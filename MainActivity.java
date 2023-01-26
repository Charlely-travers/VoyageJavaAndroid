package net.travers.charlely.appvoyages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {

private Button btnListerV;
private ListView listevoyages;
private ArrayList<Voyage> voyages;
private ArrayList<String> voyagesNoms;
private  int layoutID;
private ArrayAdapter<String> arrayAdaptN;
private Button buttonAjouter;
private ArrayVoyageAdapter arrayAdapterU;
public static final String key="nom";
public static final int CODE_RETOUR_RECOGNIZER = 333;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            //instanciation et initialisation de voyages et voyagesNoms
            voyages = new ArrayList<Voyage>();
            voyagesNoms = new ArrayList<String>();
            Voyage nerja = new Voyage("NERJA EL CAPISTRANO", "Espagne", "EL CAPISTRANO est un complexe touristique formé de plusieurs petits villages typiquement andalous situé à 2 km au sud de Nerja", 5, 148, "http://flags.fmcdn.net/data/flags/w580/es.png");
            voyages.add(nerja);
            voyagesNoms.add(nerja.getNomVoyage());
            Voyage thailande = new Voyage("CIRCUIT ORCHIDÉES", "Thailande", "Visites de sites historiques classés au patrimoine mondial de l'UNESCO. Immersion dans une Thaïlande authentique grâce à la rencontre avec des tribus mythiques. Découverte des traditions lors des dîners spectacles à Bangkok et Chiang Mai", 10, 2138, "http://flags.fmcdn.net/data/flags/w580/th.png");
            voyages.add(thailande);
            voyagesNoms.add(thailande.getNomVoyage());
            Voyage teide = new Voyage("CIRCUIT SUR LA ROUTE DU TEIDE", "Espagne", "Un programme qui vous mènera du nord au sud de Tenerife ! Découvrez les charmes, la nature et l’histoire de cette île. Une première approche idéale de l’éternel printemps.", 8, 1209, "http://flags.fmcdn.net/data/flags/w580/th.png");
            voyages.add(teide);
            voyagesNoms.add(teide.getNomVoyage());
            Voyage islande = new Voyage("ESSENTIEL D'ISLANDE", "Islande", "Le tour de l'Islande en une semaine.", 9, 2580, "http://flags.fmcdn.net/data/flags/w580/is.png");
            voyages.add(islande);
            voyagesNoms.add(islande.getNomVoyage());
            Voyage sicile = new Voyage("CIRCUIT PARFUMS DE SICILE", "Italie", "Le tour de la Sicile en une semaine", 7, 1099, "http://flags.fmcdn.net/data/flags/w580/it.png");
            voyages.add(sicile);
            voyagesNoms.add(sicile.getNomVoyage());
            Voyage malte = new Voyage("CIRCUIT ECHAPPÉE MALTAISE", "Malte", "Le tour de Malte en une semaine", 7, 895, "http://flags.fmcdn.net/data/flags/w580/mt.png");
            voyages.add(malte);
            voyagesNoms.add(malte.getNomVoyage());
            Voyage norvege = new Voyage("DU SPITZBERG AUX FJORDS DE NORVÈGE", "Norvege", "Découverte des îles jusqu'au cap Nord.", 12, 3265, "http://flagpedia.net/data/flags/w580/no.png");
            voyages.add(norvege);
            voyagesNoms.add(norvege.getNomVoyage());
            Voyage senegal = new Voyage("ROYAM", "Senegal", "Vous serez charmé par cet hôtel avec ses bungalows de style africain et son aspect intimiste, son jardin composé de fleurs tropicales et de bouganvilliers, sa plage bordée de majestueux cocotiers sur la Petite Côte à Saly.", 8, 1296, "http://flagpedia.net/data/flags/w580/sn.png");
            voyages.add(senegal);
            voyagesNoms.add(senegal.getNomVoyage());
            Voyage inde = new Voyage("DU TAJ MAHAL À AMRITSAR", "Inde", "Une promenade en Rickshaw à Jaipur. Balade à dos d'éléphants ou en jeep à Jaipur. Suroth, village fortifié hors des sentiers battus. Voyage dans le temps à Fatehpur Sikri. Une balade en calèche à Agra. Le spectacle à Agra. Découverte de la merveilleuse cité du Sikhisme", 12, 1479, "http://flagpedia.net/data/flags/w580/in.png");
            voyages.add(inde);
            voyagesNoms.add(inde.getNomVoyage());
            Voyage croatie = new Voyage("CLUB MARMARA BONACA", "Croatie", "Envie de vues mer panoramiques, de la douceur des îles et de vacances mi-calmes mi-sportives ? Pas de doute, ce club niché sur l’île de Brac au large de Split est fait pour vous ! Profitez de sa situation exceptionnelle sur la côte Adriatique et de ses multiples activités… Club Marmara, l’expérience club en toute convivialité !", 8, 929, "http://flags.fmcdn.net/data/flags/w580/hr.png");
            voyages.add(croatie);
            voyagesNoms.add(croatie.getNomVoyage());

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            btnListerV = (Button) findViewById(R.id.buttonLister);
            buttonAjouter=(Button) findViewById(R.id.buttonAjouter) ;
            listevoyages = (ListView) findViewById(R.id.listeVoyage);
            layoutID = R.layout.itempersovoyages;
            btnListerV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    arrayAdapterU = new ArrayVoyageAdapter(MainActivity.this, layoutID, voyages);
                    listevoyages.setAdapter(arrayAdapterU);

                }

            });

            //simple click pour ajouter un voyage
            buttonAjouter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //arrayAdaptN= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,voyagesNoms);
                    //listevoyages.setAdapter(arrayAdaptN);
                    Intent i=new Intent(MainActivity.this, AjoutVoyage.class);
                    i.putExtra(key,voyages);
                    startActivityForResult(i,CODE_RETOUR_RECOGNIZER);

                }

            });

            //simple click pour voir les infos d'un voyage
            listevoyages.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> arg0, View view,
                                                int position, long id) {

                             Intent intent = new Intent(MainActivity.this, InformationsActivity.class);
                            intent.putExtra(key, voyages.get(position));
                            startActivity(intent);

                        }
                    }
            );


            //long click pour supprimer un voyage
            listevoyages.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                               int position, long id) {

                    String taillevoyageavant=String.valueOf(voyages.size());
                    final int positionToRemove = position;
                    arrayAdapterU.remove(arrayAdapterU.getItem(positionToRemove));
                    arrayAdapterU.notifyDataSetChanged();
                    String taillevoyageapres=String.valueOf(voyages.size());
                    Toast.makeText(getApplicationContext(), "Taille list avant :" +taillevoyageavant+" Taille list apres :" +taillevoyageapres, Toast.LENGTH_LONG).show();

                    return true;
                }
            });
        } catch (Exception e) {
            Log.e("Error Message", e.getMessage());
            e.printStackTrace();
        }

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_RETOUR_RECOGNIZER && resultCode == RESULT_OK && data != null) {
            voyages =(ArrayList<Voyage>) data.getSerializableExtra(key);
            arrayAdapterU = new ArrayVoyageAdapter(MainActivity.this, layoutID, voyages);
            listevoyages.setAdapter(arrayAdapterU);
            arrayAdapterU.notifyDataSetChanged();
        }

    }
}