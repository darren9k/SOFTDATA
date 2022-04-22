package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fin extends AppCompatActivity implements View.OnClickListener {

    private Button btFin;
    private ImageView imgSmyle;
    private TextView tvResultat;
    private ListView lvListe;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        this.btFin =(Button) findViewById(R.id.idFin);
        this.tvResultat = (TextView) findViewById(R.id.idResultat);
        this.imgSmyle = (ImageView) findViewById(R.id.idSmyle);
        this.lvListe = (ListView) findViewById(R.id.idListe);
        this.btFin.setOnClickListener(this);

        String rer = this.getIntent().getStringExtra("rer").toString();
        String email = this.getIntent().getStringExtra("email").toString();

        float moyenne = SNCF.getEnquete(rer).getCandidat(email).moyenneScore();
        String nom = SNCF.getEnquete(rer).getCandidat(email).getNom();
        String prenom = SNCF.getEnquete(rer).getCandidat(email).getPrenom();

        this.tvResultat.setText("Resultat Enquete de M/Mm"+" "+nom+" "+prenom);

        // chox du smiley
        if(moyenne<10){
            this.imgSmyle.setImageResource(R.drawable.smiley_3);
        }
        else if(moyenne<14){
            this.imgSmyle.setImageResource(R.drawable.smiley_2);
        }
        else{
            this.imgSmyle.setImageResource(R.drawable.smiley_1);
        }

        //construction de la liste listView
        ArrayList<String> lesResulats = new ArrayList<>();
        for (Candidat unCandidat : SNCF.getEnquete(rer).getLesCandidats().values())
        {
            lesResulats.add(unCandidat.getNom()+" "+unCandidat.getPrenom()+" "+unCandidat.moyenneScore());
        }

        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lesResulats);
        this.lvListe.setAdapter((unAdapter));


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.idFin) {
            Intent unIntent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "Merci d'avoir participé à l'enquete", Toast.LENGTH_SHORT).show();
            this.startActivity(unIntent);
        }
    }
}