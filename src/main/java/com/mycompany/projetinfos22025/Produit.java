/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetinfos22025;

/**
 *
 * @author juper
 */

public class Produit {
    private String codeProduit;
    private String dproduit;

    // Constructeur
    public Produit(String codeProduit, String dproduit) {
        this.codeProduit = codeProduit;
        this.dproduit = dproduit;
    }

    // Méthode pour afficher les attributs du produit
    public void afficheProduit() {
        System.out.println("Code Produit: " + codeProduit);
        System.out.println("Désignation: " + dproduit);
    }

    // Méthode pour modifier les attributs du produit
    public void modifierProduit(String newCodeProduit, String newDproduit) {
        this.codeProduit = newCodeProduit;
        this.dproduit = newDproduit;
    }

    // Méthode pour supprimer le produit
    public void supprimerProduit() {
        this.codeProduit = null;
        this.dproduit = null;
    }
    // Getters et Setters
    public String getCodeProduit() { return codeProduit; }
    public String getDProduit() { return dproduit; }
}
