/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetinfos22025;

/**
 *
 * @author juper
 */
import java.util.ArrayList;
import javax.swing.JTextArea;

public class Poste {
    private String refPoste;
    private String dposte;
    private ArrayList<Machine> listeMachines;

    // Constructeur
    public Poste(String refPoste, String dposte) {
        this.refPoste = refPoste;
        this.dposte = dposte;
        this.listeMachines = new ArrayList<>();
    }

    // Méthode pour afficher les attributs du poste
    public void affichePoste() {
        System.out.println("Référence Poste: " + refPoste);
        System.out.println("Désignation: " + dposte);
        System.out.println("Machines:");
       
    }

    // Méthode pour ajouter une machine au poste
    public void ajouterMachine(Machine machine) {
        listeMachines.add(machine);
        System.out.println("Machine ajoutée au poste.");
    }

    // Méthode pour supprimer une machine du poste
    public void supprimerMachine(Machine machine) {
        listeMachines.remove(machine);
        System.out.println("Machine supprimée du poste.");
    }

    // Méthode pour supprimer le poste
    public void supprimerPoste() {
        this.listeMachines.clear();
        System.out.println("Poste supprimé.");
    }
}
