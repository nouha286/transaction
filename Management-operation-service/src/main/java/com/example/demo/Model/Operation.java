package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Document
public class Operation implements Serializable {
    @Transient
    private String message;
    @Id
    private String id;
    private String portefeuil;
    private Type type;
    private Double montant;
    private LocalDate date;

}
