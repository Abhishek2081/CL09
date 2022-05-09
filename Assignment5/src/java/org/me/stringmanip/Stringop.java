/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/EjbWebService.java to edit this template
 */
package org.me.stringmanip;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author tanay
 */
@WebService(serviceName = "Stringop")
@Stateless()
public class Stringop {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "concat")
    public String concat(@WebParam(name = "a") String a, @WebParam(name = "b") String b) {
        //TODO write your implementation code here:
        String res = a.concat(b);
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "length")
    public int length(@WebParam(name = "a") String a) {
        //TODO write your implementation code here:
        return a.length();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "upper")
    public String upper(@WebParam(name = "a") String a) {
        //TODO write your implementation code here:
        return a.toUpperCase();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "lower")
    public String lower(@WebParam(name = "a") String a) {
        //TODO write your implementation code here:
        return a.toLowerCase();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "compare")
    public String compare(@WebParam(name = "a") String a, @WebParam(name = "b") String b) {
        //TODO write your implementation code here:
        int comp = a.compareTo(b);
        String msg = "";
        if(comp==0)
        {
            msg = "Both are equal";
        }
        else if(comp<0)
        {
            msg = "Second string is lexicographically greater";
        }
        else
        {
            msg = "First string is lexicographically greater";
        }
        return msg;
    }
}
