/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author damie
 */
public class Commande {
    private int Numero;
    private String Client;
    private String Saisie_le;
    private String Envoyee_le;
    private Float Port;
    private String Destinataire;
    private String Adresse_livraison;
    private String Ville_livraison;
    private String Region_livraison;
    private String Code_Postal_livrais;
    private String Pays_Livraison;
    private Float Remise;

    public Commande(int Numero, String Client, String Saisie_le, String Envoyee_le, Float Port, String Destinataire, String Adresse_livraison, String Ville_livraison, String Region_livraison, String Code_Postal_livrais, String Pays_Livraison, Float Remise) {
        this.Numero = Numero;
        this.Client = Client;
        this.Saisie_le = Saisie_le;
        this.Envoyee_le = Envoyee_le;
        this.Port = Port;
        this.Destinataire = Destinataire;
        this.Adresse_livraison = Adresse_livraison;
        this.Ville_livraison = Ville_livraison;
        this.Region_livraison = Region_livraison;
        this.Code_Postal_livrais = Code_Postal_livrais;
        this.Pays_Livraison = Pays_Livraison;
        this.Remise = Remise;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String Client) {
        this.Client = Client;
    }

    public String getSaisie_le() {
        return Saisie_le;
    }

    public void setSaisie_le(String Saisie_le) {
        this.Saisie_le = Saisie_le;
    }

    public String getEnvoyee_le() {
        return Envoyee_le;
    }

    public void setEnvoyee_le(String Envoyee_le) {
        this.Envoyee_le = Envoyee_le;
    }

    public Float getPort() {
        return Port;
    }

    public void setPort(Float Port) {
        this.Port = Port;
    }

    public String getDestinataire() {
        return Destinataire;
    }

    public void setDestinataire(String Destinataire) {
        this.Destinataire = Destinataire;
    }

    public String getAdresse_livraison() {
        return Adresse_livraison;
    }

    public void setAdresse_livraison(String Adresse_livraison) {
        this.Adresse_livraison = Adresse_livraison;
    }

    public String getVille_livraison() {
        return Ville_livraison;
    }

    public void setVille_livraison(String Ville_livraison) {
        this.Ville_livraison = Ville_livraison;
    }

    public String getRegion_livraison() {
        return Region_livraison;
    }

    public void setRegion_livraison(String Region_livraison) {
        this.Region_livraison = Region_livraison;
    }

    public String getCode_Postal_livrais() {
        return Code_Postal_livrais;
    }

    public void setCode_Postal_livrais(String Code_Postal_livrais) {
        this.Code_Postal_livrais = Code_Postal_livrais;
    }

    public String getPays_Livraison() {
        return Pays_Livraison;
    }

    public void setPays_Livraison(String Pays_Livraison) {
        this.Pays_Livraison = Pays_Livraison;
    }

    public Float getRemise() {
        return Remise;
    }

    public void setRemise(Float Remise) {
        this.Remise = Remise;
    }
    
    
    
}
