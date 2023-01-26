package net.travers.charlely.appvoyages;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
public class InformationsActivity extends AppCompatActivity implements Serializable
{
    private TextView txtViewNom;
    private TextView txtViewPays;
    private TextView txtViewNbJours;
    private TextView txtViewPrix;
    private TextView txtViewNDetail;
    private ImageView image_view;
    private URL url;
    private ImageView drapeau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.info_activity);
            txtViewNom=(TextView) findViewById(R.id.txtViewNom);
            txtViewPays=(TextView) findViewById(R.id.txtViewPays);
            txtViewNbJours=(TextView) findViewById(R.id.txtViewNbJours);
            txtViewPrix=(TextView) findViewById(R.id.txtViewPrix);
            txtViewNDetail=(TextView) findViewById(R.id.txtViewNDetail);
            Intent i=getIntent();
            Voyage voyage=(Voyage) i.getSerializableExtra(MainActivity.key);
            txtViewNom.setText(voyage.getNomVoyage());
            txtViewPays.setText(voyage.getPays());
            txtViewNbJours.setText(Integer.toString(voyage.getNbrJours()));
            txtViewPrix.setText(Double.toString(voyage.getPrix()));
            txtViewNDetail.setText(voyage.getDetaiVoyage());
            DownloadImageFromInternet dlInternet=new DownloadImageFromInternet((ImageView)findViewById(R.id.image_view));
            dlInternet.execute(voyage.getDrapeauVoyage());
        }
        catch (Exception e) {
            Log.e("Error Message", e.getMessage());
            e.printStackTrace();
        }

    }
}
class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap>
{
    ImageView imageView;
    public DownloadImageFromInternet(ImageView imageView) {
        this.imageView=imageView;
    }

    protected Bitmap doInBackground (String ...urls) {
        String imageURL=urls[0];
        Bitmap bimage=null;
        try {
            InputStream in=new java.net.URL(imageURL).openStream();
            bimage= BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error Message", e.getMessage());
            e.printStackTrace();
        }
        return bimage;
    }
    protected void onPostExecute(Bitmap result) {

        imageView.setImageBitmap(result);
    }
}
