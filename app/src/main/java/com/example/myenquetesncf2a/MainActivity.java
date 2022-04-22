package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton rerA, rerB, rerC, rerD, rerE,rerH, rerJ, rerK, rerL, rerN, rerP, rerR, rerU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.rerA =(ImageButton) findViewById(R.id.idRerA);
        this.rerB =(ImageButton) findViewById(R.id.idRerB);
        /*this.rerC =(ImageButton) findViewById(R.id.idRerC);
        this.rerD =(ImageButton) findViewById(R.id.idRerD);
        this.rerE =(ImageButton) findViewById(R.id.idRerE);

        this.rerH =(ImageButton) findViewById(R.id.idRerH);
        this.rerJ =(ImageButton) findViewById(R.id.idRerJ);
        this.rerK =(ImageButton) findViewById(R.id.idRerK);
        this.rerL =(ImageButton) findViewById(R.id.idRerL);
        this.rerN =(ImageButton) findViewById(R.id.idRerN);
        this.rerP =(ImageButton) findViewById(R.id.idRerP);
        this.rerR =(ImageButton) findViewById(R.id.idRerR);
        this.rerU =(ImageButton) findViewById(R.id.idRerU);*/







        this.rerA.setOnClickListener(this);
        this.rerB.setOnClickListener(this);
        /*this.rerC.setOnClickListener(this);
        this.rerD.setOnClickListener(this);
        this.rerE.setOnClickListener(this);

        this.rerH.setOnClickListener(this);
        this.rerJ.setOnClickListener(this);
        this.rerK.setOnClickListener(this);
        this.rerL.setOnClickListener(this);
        this.rerN.setOnClickListener(this);
        this.rerP.setOnClickListener(this);
        this.rerR.setOnClickListener(this);
        this.rerU.setOnClickListener(this);*/

        //initialiser les enquetes de la SNCF
        SNCF.initialiser();


    }

    @Override
    public void onClick(View view) {
        String rer ="";
        switch (view.getId())
        {
            case R.id.idRerA: rer= "rera"; break;
            case R.id.idRerB: rer= "rerb"; break;
           /* case R.id.idRerC: rer= "rerc"; break;
            case R.id.idRerD: rer= "rerd"; break;
            case R.id.idRerE: rer= "rere"; break;

            case R.id.idRerH: rer= "rerh"; break;
            case R.id.idRerJ: rer= "rerj"; break;
            case R.id.idRerK: rer= "rerk"; break;
            case R.id.idRerL: rer= "rerl"; break;
            case R.id.idRerN: rer= "rern"; break;
            case R.id.idRerP: rer= "rerp"; break;
            case R.id.idRerR: rer= "rerr"; break;
            case R.id.idRerU: rer= "reru"; break;*/
        }
        //on passe a la page suivante en envoyant le rer
        Intent unIntent = new Intent(this, Inscription.class);
        unIntent.putExtra("rer", rer);
        this.startActivity(unIntent);

    }
}