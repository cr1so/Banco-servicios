package com.fpmislata.banco.presentacion;

import com.fpmislata.banco.negocio.dominio.EntidadBancaria;
import com.fpmislata.banco.negocio.servicios.EntidadBancariaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NewMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        EntidadBancariaService entidadBancariaService = context.getBean(EntidadBancariaService.class);
        

        EntidadBancaria entidadBancaria = entidadBancariaService.get(1);

        System.out.println(entidadBancaria.getNombre());

    }

}
