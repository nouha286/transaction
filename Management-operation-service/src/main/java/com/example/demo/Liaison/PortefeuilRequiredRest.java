package com.example.demo.Liaison;


import com.example.demo.Dto.Portefeuil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "Portefeuille-MicroService"  )
public interface PortefeuilRequiredRest {

    @GetMapping("/Management/portefeuil/{ref}")
    @ResponseBody
    public Optional<Portefeuil> findByReference(@PathVariable("ref") String ref);

    @RequestMapping( value = "/Management/portefeuil/update",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Portefeuil update(@RequestBody Portefeuil portefeuil);
}
