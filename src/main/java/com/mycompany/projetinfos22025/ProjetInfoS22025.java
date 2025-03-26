/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetinfos22025;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetInfoS22025 extends JFrame {

    private JTextArea outputArea;
 

    public ProjetInfoS22025() {
        setTitle("Atelier de Fabrication - Gestion");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
     

        // Barre de menu
        JMenuBar menuBar = new JMenuBar();
        
        // Menu principal
        JMenu machineMenu = new JMenu("Machine");
        JMenu gammeMenu = new JMenu("Gamme");
        JMenu optimisationMenu = new JMenu("Optimisation");

        // Ajouter des sous-menus pour Machine
        JMenuItem ajouterMachine = new JMenuItem("Ajouter une machine");
        JMenuItem afficherMachines = new JMenuItem("Afficher les machines");
        machineMenu.add(ajouterMachine);
        machineMenu.add(afficherMachines);

        // Ajouter des sous-menus pour Gamme
        JMenuItem ajouterGamme = new JMenuItem("Ajouter une gamme");
        JMenuItem afficherGammes = new JMenuItem("Afficher les gammes");
        gammeMenu.add(ajouterGamme);
        gammeMenu.add(afficherGammes);

        // Ajouter un menu pour l'optimisation
        JMenuItem calculerFiabilite = new JMenuItem("Calculer la fiabilité");
        optimisationMenu.add(calculerFiabilite);

        // Ajouter les menus à la barre de menu
        menuBar.add(machineMenu);
        menuBar.add(gammeMenu);
        menuBar.add(optimisationMenu);
        setJMenuBar(menuBar);

        // Zone de texte pour afficher les informations
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane);
        
        // Ajout des composants à la fenêtre
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.SOUTH);
        

        // Action pour ajouter une machine
        ajouterMachine.addActionListener(e -> Machine.ouvrirFenetreMachine(outputArea));

        // Action pour afficher les machines
        afficherMachines.addActionListener(e -> Machine.afficherMachines(outputArea));

        // Action pour ajouter une gamme
        ajouterGamme.addActionListener(e -> Gamme.ouvrirFenetreGamme(outputArea));

        // Action pour afficher les gammes
        afficherGammes.addActionListener(e -> Gamme.afficherGammes(outputArea));

        // Action pour calculer la fiabilité
        calculerFiabilite.addActionListener(e -> calculerFiabilite());
    }

   

    private void calculerFiabilite() {
        outputArea.append("Calcul de la fiabilité (à implémenter)...\n");
    }

    
    public static void main(String[] args) {
         // Ajouter le shutdown hook pour vider le fichier à la fermeture de l'application
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        Machine.viderFichier(); // Vider le fichier "suiviMaintenance.txt"
    }));
        SwingUtilities.invokeLater(() -> new ProjetInfoS22025().setVisible(true));
    }
    
}
 
