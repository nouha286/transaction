package com.example.demo.Controller;

import com.example.demo.Model.Operation;
import com.example.demo.Service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OperationController {

    @GetMapping("/{portefeuil}")
    public Optional<Operation> findOperationByPortefeuil(@PathVariable("portefeuil") String portefeuil) {
        return operationService.findOperationByPortefeuil(portefeuil);
    }

    @Autowired
    OperationService operationService;
    @PostMapping("/add")
    public Operation passerOperation(@RequestBody Operation operation) {
        return operationService.passerOperation(operation);
    }




}
