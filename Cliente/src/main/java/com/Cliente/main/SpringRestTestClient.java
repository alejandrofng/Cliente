package com.Cliente.main;

import java.util.LinkedHashMap;
import java.util.List;
 
import org.springframework.web.client.RestTemplate;
 
public class SpringRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8090/IJMpiloto";
     
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllSuppliers(){
        System.out.println("Testing listAllSuppliers API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> SuppliersMap = restTemplate.getForObject(REST_SERVICE_URI+"/supplier", List.class);
         
        if(SuppliersMap!=null){
            for(LinkedHashMap<String, Object> map : SuppliersMap){
                System.out.println("Supplier : id="+map.get("id")+", Name="+map.get("name")+", Code="+map.get("code"));
            }
        }else{
            System.out.println("No Supplier exist----------");
        }
    }

    public static void main(String args[]){
        listAllSuppliers();
 
    }
}