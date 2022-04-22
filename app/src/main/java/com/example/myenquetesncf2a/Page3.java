package com.example.myenquetesncf2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class Page3 extends AppCompatActivity implements View.OnClickListener {

    private Button btSuivant2;
    private RatingBar ratingBar, ratingBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        this.btSuivant2 = (Button) findViewById(R.id.idSuivant2);
        this.ratingBar =(RatingBar) findViewById(R.id.idratingBar);
        this.ratingBar2 =(RatingBar) findViewById(R.id.idratingBar2);
        this.btSuivant2.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.idSuivant2) {

            //on recuprere l'email et le rer
            String email = this.getIntent().getStringExtra("email").toString();
            String rer = this.getIntent().getStringExtra("rer").toString();

            int score2 =0;
            switch (this.ratingBar.getNumStars()) {
                case 1:score2 =2; break;
                case 2:score2 =4; break;
                case 3:score2 =6; break;
                case 4:score2 =8; break;
                case 5:score2 =10; break;
                case 6:score2 =12; break;
                case 7:score2 =14; break;
                case 8:score2 =16; break;
                case 9:score2 =18; break;
                case 10:score2 =20; break;
                }
            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse2("livraison", score2);



           switch (this.ratingBar2.getNumStars()) {

               case 1:score2 =2; break;
               case 2:score2 =4; break;
               case 3:score2 =6; break;
               case 4:score2 =8; break;
               case 5:score2 =10; break;
               case 6:score2 =12; break;
               case 7:score2 =14; break;
               case 8:score2 =16; break;
               case 9:score2 =18; break;
               case 10:score2 =20; break;
            }
            SNCF.getEnquete(rer).getCandidat(email).ajouterReponse2("service", score2);



                    //on passe a la page2
                    Intent unIntent = new Intent(this, Fin.class);
                    unIntent.putExtra("rer", rer);
                    unIntent.putExtra("email", email);
                    this.startActivity(unIntent);

            }
        }
    }
