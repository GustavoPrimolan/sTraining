package br.com.straining.tx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding //DIZ QUE A ANOTA��O � UTILIZADO PARA ACIONAR O GERENCIADOR DE TRANSA��O
@Target({ElementType.METHOD, ElementType.TYPE})//ARRAY QUE PERMITE A UTILIZA��O DA ANOTA��O EM M�TODOS E EM CLASSES (TYPE)
@Retention(RetentionPolicy.RUNTIME)//V�LIDA NA HORA DE RODAR
public @interface Transacional {

}
