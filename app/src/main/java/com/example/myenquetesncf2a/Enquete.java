package com.example.myenquetesncf2a;

import java.util.HashMap;

public class Enquete {
    private HashMap<String, Candidat> lesCandidats;
    // String : cle --> Email du candidat
    //Candidat : Value --> un candidat

    public Enquete(){
        this.lesCandidats = new HashMap<>();
    }
    public boolean ajouterCandidat (Candidat unCandidat){

        if(lesCandidats.containsKey(unCandidat.getEmail())){
            return false;  //echec de l'inssertion
        }
        else{
            this.lesCandidats.put(unCandidat.getEmail(), unCandidat);
            return true; //inssertion reussie
        }

    }
    public Candidat getCandidat (String email){
        return  this.lesCandidats.get(email);
    }

    public HashMap<String, Candidat> getLesCandidats() {
        return lesCandidats;
    }

    public void setLesCandidats(HashMap<String, Candidat> lesCandidats) {
        this.lesCandidats = lesCandidats;
    }
}
