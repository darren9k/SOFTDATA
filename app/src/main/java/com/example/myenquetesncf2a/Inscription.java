package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener {
    private Button btParticiper;
    private EditText txtNom, txtPrenom, txtEmail;
    private Spinner spAge, spFrequence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);


        this.txtNom =(EditText) findViewById(R.id.idNom);
        this.txtPrenom =(EditText) findViewById(R.id.idPrenom);
        this.txtEmail =(EditText) findViewById(R.id.idEmail);
        this.btParticiper =(Button) findViewById(R.id.idParticiper);
        this.spAge =(Spinner) findViewById(R.id.idAge);
        this.spFrequence =(Spinner) findViewById(R.id.idFrequence);

        this.btParticiper.setOnClickListener(this);

        //remplir les spinner
        ArrayList<String> lesAges = new ArrayList<>();//liste des champs
        //remplire les champs
        lesAges.add("Homme");
        lesAges.add("Femme");

        //je cree un adaptateur d'affichage du spinner
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item ,lesAges);
        this.spAge.setAdapter(unAdapter);


        //remplir les spinner
        ArrayList<String> lesFrequences = new ArrayList<>();//liste des champs
        //remplire les champs
        lesFrequences.add("18-25");
        lesFrequences.add("26-35");
        lesFrequences.add("36-45");
        lesFrequences.add("46-55");
        lesFrequences.add("56 et plus");
        //je cree un adaptateur d'affichage du spinner
        unAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item ,lesFrequences);
        this.spFrequence.setAdapter(unAdapter);




    }

    @Override
    public void onClick(View view) {
    if(view.getId()==R.id.idParticiper){
        String email = this.txtEmail.getText().toString();
        String nom = this.txtNom.getText().toString();
        String prenom = this.txtPrenom.getText().toString();
        String age = this.spAge.getSelectedItem().toString();
        String frequence = this.spFrequence.getSelectedItem().toString();

        if(nom.equals("")){
            Toast.makeText(this,"veuillez saisir le nom du candidat", Toast.LENGTH_LONG).show();
        }
        if(prenom.equals("")){
            Toast.makeText(this,"veuillez saisir le prenom du candidat", Toast.LENGTH_LONG).show();
        }
        if(email.equals("")){
            Toast.makeText(this,"veuillez saisir le email du candidat", Toast.LENGTH_LONG).show();
        }
        if( ! nom.equals("") && ! prenom.equals("") && ! email.equals("") ) {

        }

        //instanciation de la classe candidat a l'enquete
        Candidat unCandidat = new Candidat(email, nom, prenom, age, frequence);



        //passage a la premiere page de l'enquete
        Intent unIntent = new Intent(this, Page1.class);
        String rer = this.getIntent().getStringExtra("rer").toString();

        //ajouter le candidat dans la hashmap de l'enquete identifier pas le rer
        if ( ! SNCF.getEnquete(rer).ajouterCandidat(unCandidat)){
            Toast.makeText(this, "ce Condidat a deja participe", Toast.LENGTH_LONG).show();
        } else{
            unIntent.putExtra("rer", rer);
            unIntent.putExtra("email",email);
            Toast.makeText(this, "Bienvenue "+nom+" "+prenom,Toast.LENGTH_LONG).show();
            this.startActivity(unIntent);
        }



    }
    }
}