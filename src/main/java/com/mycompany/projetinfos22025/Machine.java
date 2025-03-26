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
public class Machine {
    private String refMachine;
    private String dmachine;
    private String type;
    private float coutHoraire;
    private int x; //abscisse
    private int y;//ordonnée

    // Constructeur
    public Machine(String refMachine, String dmachine, String type, float coutHoraire, int x, int y) {
        this.refMachine = refMachine;
        this.dmachine = dmachine;
        this.type = type;
        this.coutHoraire = coutHoraire;
        this.x = x;
        this.y = y;
    }

    public String getRefMachine() {
            return refMachine;
        }

        public int getAbscisse() {
            return x;
        }

        public int getOrdonnee() {
            return y;
        }
        
    public void modifierMachine(String dMachine, float cout, int x, int y) {
        this.dmachine = dMachine;
        this.coutHoraire = cout;
        this.x = x;
        this.y = y;
    }

    public void supprimerMachine() {
        this.refMachine = null;
        this.dmachine = null;
        
    }
     // Getters et Setters
    
    public String getDMachine() { return dmachine; }
    public float getCout() { return coutHoraire; }
    
       // Méthode pour calculer le coût d'utilisation
    public float coutUtil (float duree) {
        return coutHoraire * duree;
    }
public static void afficherMachines(JTextArea outputArea) {
        try (BufferedReader reader = new BufferedReader(new FileReader("suiviMaintenance.txt"))) {
            String ligne;
            outputArea.append("Machines enregistrées :\n");
            while ((ligne = reader.readLine()) != null) {
                if (!ligne.startsWith("Gamme")) { // ignorer les gammes
                    outputArea.append(ligne + "\n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
public static void viderFichier() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("suiviMaintenance.txt"))) {
        // Cela efface tout le contenu du fichier.
        writer.write(""); 
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

 private static void enregistrerMachine(String... infos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suiviMaintenance.txt", true))) {
            writer.write(String.join(" ", infos) + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
   public static void ouvrirFenetreMachine(JTextArea outputArea) {
        JFrame machineFrame = new JFrame("Ajouter une machine");
        machineFrame.setSize(400, 300);
        machineFrame.setLayout(new GridLayout(7, 2));

        JTextField refField = new JTextField();
        JTextField designationField = new JTextField();
        JTextField abscisseField = new JTextField();
        JTextField ordonneeField = new JTextField();
        JTextField coutHoraireField = new JTextField();
        JTextField dureeField = new JTextField();

        machineFrame.add(new JLabel("Référence:"));
        machineFrame.add(refField);
        machineFrame.add(new JLabel("Désignation:"));
        machineFrame.add(designationField);
        machineFrame.add(new JLabel("Abscisse:"));
        machineFrame.add(abscisseField);
        machineFrame.add(new JLabel("Ordonnée:"));
        machineFrame.add(ordonneeField);
        machineFrame.add(new JLabel("Coût Horaire:"));
        machineFrame.add(coutHoraireField);
        machineFrame.add(new JLabel("Durée:"));
        machineFrame.add(dureeField);

        JButton creerBtn = new JButton("Créer");
        creerBtn.addActionListener(e -> {
            String ref = refField.getText();
            String designation = designationField.getText();
            String abscisse = abscisseField.getText();
            String ordonnee = ordonneeField.getText();
            String coutHoraire = coutHoraireField.getText();
            String duree = dureeField.getText();

            enregistrerMachine(ref, designation, abscisse, ordonnee, coutHoraire, duree);
            
            machineFrame.dispose();
        });

        machineFrame.add(creerBtn);
        machineFrame.setVisible(true);
    }

}

 