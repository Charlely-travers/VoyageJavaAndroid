package net.travers.charlely.appvoyages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
public class AjoutVoyage extends AppCompatActivity implements Serializable {
    private EditText Nom;
    private EditText Url;
    private EditText Pays;
    private EditText Prix;
    private EditText Detail;
    private EditText NbJours;
    private Button buttonValider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutvoyage);
        Intent i = getIntent();
        ArrayList<Voyage> voyages =(ArrayList<Voyage>) i.getSerializableExtra(MainActivity.key);


        buttonValider=(Button) findViewById(R.id.buttonValider);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try {


                Nom = (EditText) findViewById(R.id.Nom);
                Url = (EditText) findViewById(R.id.url);
                Pays = (EditText) findViewById(R.id.Pays);
                Prix = (EditText) findViewById(R.id.Prix);
                Detail = (EditText) findViewById(R.id.Detail);
                NbJours = (EditText) findViewById(R.id.NbJours);
                String nom = Nom.getText().toString();
                String url = Url.getText().toString();
                String pays = Pays.getText().toString();
                String prix = Prix.getText().toString();
                String detail = Detail.getText().toString();
                String nbJours = NbJours.getText().toString();
                double prix2 = Double.parseDouble(prix);
                int nbjour2 = Integer.parseInt(nbJours);

                Voyage voyageajouter = new Voyage(nom, pays, detail, nbjour2, prix2, url);
                voyages.add(voyageajouter);
                Intent retour = new Intent();
                retour.putExtra(MainActivity.key, voyages);
                setResult(MainActivity.RESULT_OK, retour);
                finish();
            }
            catch (Exception e)
            {
                Log.e("Erreur format de text", e.getMessage());
                e.printStackTrace();
            }
            }
        });
    }


}
