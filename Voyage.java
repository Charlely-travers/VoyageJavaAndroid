package net.travers.charlely.appvoyages;
import java.io.Serializable;

public class Voyage implements Serializable {
    private String nom;
    private String pays;
    private int NbreJours;
    private double prix;
    private String detail;
    private String drapeau;

    public String getNomVoyage() {
        return nom;
    }
    public void setNomVoyage(String nomV) {
        this.nom = nomV;
    }
    public String getPays() {
        return pays;
    }
    public  void setNomPays(String nomPays) {this.pays = nomPays;}
    public int getNbrJours() {
        return NbreJours;
    }
    public void setNbJours(int nbJours) {
        this.NbreJours = nbJours;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrixVoyage(double prixV) {
        this.prix = prixV;
    }
    public String getDetaiVoyage() {
        return detail;
    }
    public void setDetailVoyage(String detailV) {
        this.detail = detailV;
    }
    public String getDrapeauVoyage() {
        return drapeau;
    }
    public void setDrapeauVoyage(String drapeauV) {
        this.drapeau = drapeauV;
    }
    public Voyage(String name,String py,String det,int nb,double pr,String urlD )
    {
        setNomVoyage(name);
        setDetailVoyage(det);
        setDrapeauVoyage(urlD);
        setNomPays(py);
        setPrixVoyage(pr);
        setNbJours(nb);
    }
}
