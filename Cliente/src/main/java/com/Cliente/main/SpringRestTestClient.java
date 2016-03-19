package com.Cliente.main;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;

import com.Cliente.model.Supplier;

import org.springframework.http.ResponseEntity;
 
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

    /* GET */
    private static void getSupplier(){
        System.out.println("Testing getSupplier API----------");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Supplier> supplier = restTemplate.getForEntity(REST_SERVICE_URI+"/supplier/1", Supplier.class);
        System.out.println(supplier);
    }
     
    /* POST */
    private static void createSupplier() {
        System.out.println("Testing create Supplier API----------");
        RestTemplate restTemplate = new RestTemplate();
        Supplier supplier = new Supplier("J123123123","prueba POST CLIENTE");

        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/supplier", supplier, Supplier.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    /* PUT */
    private static void updateSupplier() {
        System.out.println("Testing update Supplier API----------");
        RestTemplate restTemplate = new RestTemplate();
        Supplier user  = new Supplier("J123323323","prueba PUT CLIENTE");
        restTemplate.put(REST_SERVICE_URI+"/supplier/1", user);
        System.out.println(user);
    }
 
    /* DELETE */
    private static void deleteSupplier() {
        System.out.println("Testing delete Supplier API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/supplier/3");
    }
 
 
    /* DELETE */
    private static void deleteAllSuppliers() {
        System.out.println("Testing all delete Suppliers API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/supplier/");
    }
 
    public static void main(String args[]){
        listAllSuppliers();
        getSupplier();
        createSupplier();
       listAllSuppliers();
        updateSupplier();
        listAllSuppliers();
        deleteSupplier();
        listAllSuppliers();
    }
}