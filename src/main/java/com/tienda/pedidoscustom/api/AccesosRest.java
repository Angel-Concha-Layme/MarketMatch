package com.tienda.pedidoscustom.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.pedidoscustom.interceptor.InterceptadorDeAccesos;
import com.tienda.pedidoscustom.interceptor.InterceptadorDeAccesos.Acceso;

@RequestMapping("api/accesos")
@RestController
public class AccesosRest {    
    @GetMapping
    public List<Acceso> getAccesos(){
        return InterceptadorDeAccesos.accesos;
    }
}
