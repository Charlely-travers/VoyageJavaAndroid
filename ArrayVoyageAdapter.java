package net.travers.charlely.appvoyages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class ArrayVoyageAdapter extends ArrayAdapter<Voyage> {
    // Déclaration d'une liste d'items
    private ArrayList<Voyage> objetsV;
    private int item_id;

    //Surcharge du constructeur ArrayAdapteur
    public ArrayVoyageAdapter(Context context,
                              int textViewResourceId,
                              ArrayList<Voyage> objects) {
        super(context, textViewResourceId, objects);
        this.objetsV = objects;
        this.item_id = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
// Vue à mettre à jour
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(this.item_id, null);
        }

        Voyage Vcourant = objetsV.get(position);

        if (Vcourant != null) {
            TextView tv_nV = (TextView) v.findViewById(R.id.nomV);
            if (tv_nV != null) tv_nV.setText(Vcourant.getNomVoyage());
            ImageView icone = (ImageView) v.findViewById(R.id.imgVoyage);
            if (icone != null) icone.setImageResource(R.drawable.voyages);
        }
        return v;
    }
}
