package com.example.myenquetesncf2a;

import java.util.HashMap;

public class SNCF {

    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();
    //String : cle -->rer
    //Enquete : value --> une Enquete

    public static void initialiser()
    {
        if ( ! lesEnquetes.containsKey("rera")){
            lesEnquetes.put("rera", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerb")){
        lesEnquetes.put("rerb", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerc")){
            lesEnquetes.put("rerc", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerd")){
            lesEnquetes.put("rerd", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rere")){
            lesEnquetes.put("rere", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerh")){
            lesEnquetes.put("rerh", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerj")){
            lesEnquetes.put("rerj", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerk")){
            lesEnquetes.put("rerk", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerl")){
            lesEnquetes.put("rerl", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rern")){
            lesEnquetes.put("rern", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerp")){
            lesEnquetes.put("rerp", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("rerr")){
            lesEnquetes.put("rerr", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("reru")){
            lesEnquetes.put("reru", new Enquete());
        }
    }

    public static Enquete getEnquete (String rer){
        return lesEnquetes.get(rer);
    }


}
