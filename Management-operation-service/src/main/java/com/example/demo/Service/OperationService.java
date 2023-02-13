package com.example.demo.Service;


import com.example.demo.Model.Operation;

import java.util.Optional;

public interface OperationService
{

    public Operation passerOperation(Operation operation);

    public Optional<Operation> findOperationByPortefeuil(String portefeuil);
}
