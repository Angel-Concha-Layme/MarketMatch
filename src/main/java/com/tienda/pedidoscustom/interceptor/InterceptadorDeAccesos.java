package com.tienda.pedidoscustom.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;

public class InterceptadorDeAccesos implements HandlerInterceptor{
    public static List<Acceso> accesos = new ArrayList<Acceso>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Acceso acceso = new Acceso();
        acceso.setRuta(request.getRequestURI());
        acceso.setFecha(LocalDateTime.now());
        request.setAttribute("inicio", acceso);
        return true;
   }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        Acceso acceso = (Acceso) request.getAttribute("inicio");
        acceso.setDuracion(Duration.between(acceso.getFecha(), LocalDateTime.now())); 
        accesos.add(acceso);
   }
    
    @Setter
    @Getter
    public static class Acceso{
        private String ruta;
        private LocalDateTime fecha;
        private Duration duracion;
    }
}
