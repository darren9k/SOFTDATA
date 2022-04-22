package com.example.myenquetesncf2a;

import android.content.Intent;

import java.util.HashMap;

public class Candidat {
    private String email, nom, prenom, trancheAge, frequence;
    private HashMap<String, Integer> lesReponses;
    private HashMap<String, Integer> lesReponses2;

    public Candidat(String email, String nom, String prenom, String trancheAge, String frequence) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.trancheAge = trancheAge;
        this.frequence = frequence;
        this.lesReponses = new HashMap<>(); //instanciation de hashMap
        this.lesReponses2 = new HashMap<>(); //instanciation de hashMap2
    }

    public void ajouterReponse (String question, int score){
        this.lesReponses.put(question, score);
    }
    public void ajouterReponse2 (String question2, int score2){
        this.lesReponses2.put(question2, score2);
    }

    public float moyenneScore(){
        float moy = 0;
        for (Integer score : this.lesReponses.values())
        {
            moy += score;
        }
        moy/= this.lesReponses.size();
        return moy;
    }
    public float moyenneScore2(){
        float moy2 = 0;
        for (Integer score2 : this.lesReponses2.values())
        {
            moy2 += score2;
        }
        moy2/= this.lesReponses2.size();
        return moy2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTrancheAge() {
        return trancheAge;
    }

    public void setTrancheAge(String trancheAge) {
        this.trancheAge = trancheAge;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public HashMap<String, Integer> getLesReponses2() {
        return lesReponses2;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;

    }
    public void setLesReponses2(HashMap<String, Integer> lesReponses2) {
        this.lesReponses2 = lesReponses2;
    }
}
