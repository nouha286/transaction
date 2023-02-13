package com.example.demo.Repository;

import com.example.demo.Model.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends MongoRepository<Operation, String>
{

   Optional<Operation> findOperationByPortefeuil(String portefeuil);
}
