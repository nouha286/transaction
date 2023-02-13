package com.example.demo.Service;

import com.example.demo.Dto.Portefeuil;
import com.example.demo.Liaison.PortefeuilRequiredRest;
import com.example.demo.Model.Operation;
import com.example.demo.Model.Type;
import com.example.demo.Repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    PortefeuilRequiredRest portefeuilRequiredRest;



    @Override
    public Operation passerOperation(Operation operation) {
        if(operation.getPortefeuil()==null)
        {
            operation.setMessage("Il faut citer un portefeuil valide");
            return operation;
        }
        Optional<Portefeuil> portefeuil =portefeuilRequiredRest.findByReference(operation.getPortefeuil());
       if (operation.getMontant()!=null &&
               portefeuil.isPresent() &&
               portefeuil.get().getSolde()>0
               )
       {
           operation.setDate(LocalDate.now());
           if (operation.getMontant()>0) operation.setType(Type.Depot);
           if (operation.getMontant()<0)
               {
                   if( portefeuil.get().getSolde()>-operation.getMontant())
                   {
                       operation.setType(Type.Retrait);
                   }
                   else
                   {
                       operation.setMessage("le montant que vous voulez retirer est supérieur à votre solde");
                       return operation;
                   }
           }
           operation.setPortefeuil(portefeuil.get().getReference());
           operation.setMessage("L'opération est passée avec succés");
           portefeuil.get().setSolde(portefeuil.get().getSolde()+operation.getMontant());
           System.out.println(portefeuil.get());
           portefeuilRequiredRest.update(portefeuil.get());
           return operationRepository.save(operation);
       }
       operation.setMessage("Une erreur s'est produite");
       return operation;
    }

    @Override
    public Optional<Operation> findOperationByPortefeuil(String portefeuil) {
        return operationRepository.findOperationByPortefeuil(portefeuil);
    }
}
