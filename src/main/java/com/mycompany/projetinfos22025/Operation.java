/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetinfos22025;

/**
 *
 * @author juper
 */
public class Operation {
    private String refOperation;
    private String dOperation;
    private String refEquipement;
    private float dureeOperation;
    
   // Constructeur
    public Operation(String refOperation, String dOperation, String refEquipement, float dureeOperation) {
        this.refOperation = refOperation;
        this.dOperation = dOperation;
        this.refEquipement = refEquipement;
        this.dureeOperation = dureeOperation;
    } 
    
     public float getDureeOperation() {
        return dureeOperation;
    }
      public void afficheOperation() {
        System.out.println("Référence: " + refOperation + ", Désignation: " + dOperation + ", Équipement: " + refEquipement + ", Durée: " + dureeOperation + " heure(s)");
    }
}
