/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetinfos22025;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author juper
 */
import java.util.ArrayList;

public class Gamme {
    private ArrayList<Operation> listeOperations;
    private String refGamme;
    private ArrayList<Equipement> listeEquipements;
    
    // Constructeur
    public Gamme(String refGamme) {
        this.listeOperations = new ArrayList<>();
        this.listeEquipements = new ArrayList<>();
        this.refGamme = refGamme;
    }

  
        // Méthode statique pour afficher les gammes
    public static void afficherGammes(JTextArea outputArea) {
        // Lire les gammes depuis le fichier ou toute autre source, et les afficher
        // Exemple d'affichage (ajustez selon votre source de données)
        try (BufferedReader reader = new BufferedReader(new FileReader("suiviMaintenance.txt"))) {
            String ligne;
            outputArea.append("Gammes enregistrées :\n");
            while ((ligne = reader.readLine()) != null) {
                if (ligne.startsWith("Gamme")) { // Affiche uniquement les lignes commençant par "Gamme"
                    outputArea.append(ligne);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
       private static void enregistrerGamme(String... infos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suiviMaintenance.txt", true))) {
            writer.write("Gamme " + String.join(" ", infos) + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //Méthode pour créer gammes
    public void creerGamme(Operation operation, Equipement equipement){
        listeOperations.add(operation);
        listeEquipements.add(equipement);
    }

    // Méthode pour modifier une gamme
    public void modifierGamme(String operation) {
        System.out.println("Opération modifiée.");
    }

    // Méthode pour supprimer une gamme
    public void supprimerGamme(String operation) {
        listeOperations.remove(operation);
    }
    
    public float coutGamme(){
     float coutTotal = 0;
        for (Operation operation : listeOperations) {
            coutTotal += operation.getDureeOperation();
        }
        return coutTotal;     
    }
    public float dureeGamme(){
       float dureeTotale = 0;
        for (Operation operation : listeOperations) {
            dureeTotale += operation.getDureeOperation();
        }
        return dureeTotale;
    }
        public static void ouvrirFenetreGamme(JTextArea outputArea) {
        JFrame gammeFrame = new JFrame("Ajouter une gamme");
        gammeFrame.setSize(400, 250);
        gammeFrame.setLayout(new GridLayout(5, 2));

        JTextField refField = new JTextField();
        JTextField codeProduitField = new JTextField();
        JTextField dureeField = new JTextField();
        JTextField coutField = new JTextField();

        gammeFrame.add(new JLabel("Référence:"));
        gammeFrame.add(refField);
        gammeFrame.add(new JLabel("Code Produit:"));
        gammeFrame.add(codeProduitField);
        gammeFrame.add(new JLabel("Durée:"));
        gammeFrame.add(dureeField);
        gammeFrame.add(new JLabel("Coût:"));
        gammeFrame.add(coutField);

        JButton creerBtn = new JButton("Créer");
        creerBtn.addActionListener(e -> {
            String ref = refField.getText();
            String codeProduit = codeProduitField.getText();
            String duree = dureeField.getText();
            String cout = coutField.getText();

            enregistrerGamme(ref, codeProduit, duree, cout);
            outputArea.append("Gamme ajoutée : " + ref + "\n");
            gammeFrame.dispose();
        });

        gammeFrame.add(creerBtn);
        gammeFrame.setVisible(true);
    }
}
