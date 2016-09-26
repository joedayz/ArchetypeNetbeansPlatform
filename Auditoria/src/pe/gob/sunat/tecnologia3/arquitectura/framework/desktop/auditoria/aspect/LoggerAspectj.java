package pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.aspect;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.LoggerAnnotation;
import pe.gob.sunat.tecnologia3.arquitectura.framework.desktop.auditoria.logger.LogHelper;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.Signature;
/**
 *
 * @author Edwin Farfan
 */
@Aspect
public class LoggerAspectj {

    @Around("(execution(* pe.gob.sunat.tecnologia3.arquitectura.framework.desktop..*(..)) && @annotation(logAnnotation))")
    public Object auditarMetodo(final ProceedingJoinPoint joinPoint, LoggerAnnotation logAnnotation)  throws Throwable{
       
        long start = System.nanoTime();
        
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        //Class object = joinPoint.getClass();
        
        String arguments = StringUtils.join(joinPoint.getArgs());

        Object result = joinPoint.proceed();
        long last = System.nanoTime() - start;
      
        String modulo = logAnnotation.modulo();
        LogHelper.log(last,methodName, arguments,modulo);
        
        return result;
    }

    
}
