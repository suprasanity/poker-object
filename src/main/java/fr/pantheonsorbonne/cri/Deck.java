package fr.pantheonsorbonne.cri;

import java.util.*;

public class Deck {

    public static String[] couleur = {"COEUR","CARREAU","PIQUE","TREFLE"};
    public final static String[] val = {"AS","ROI","DAME","VALET","DIX","NEUF","HUIT","SEPT","SIX","CINQ","QUATRE","TROIS","DEUX"};
    public static Map<Integer,Integer>listCarteTire=new HashMap<Integer,Integer>();

    public static Card[] getCartes(int n){
        Random random = new Random();
        Card[] main = new Card[n];
        for(int i =0; i<n; i++){
            int indexCouleur = random.nextInt(4);
            int indexValeur = random.nextInt(13);
            while(listCarteTire.containsKey(indexCouleur)&&listCarteTire.containsValue(indexValeur)){
                indexCouleur = random.nextInt(4);
                indexValeur = random.nextInt(13);
            }
            Card carte = new Card(val[indexValeur],couleur[indexCouleur]);
            main[i] = carte;
            listCarteTire.put(indexValeur,indexCouleur);
        }
        return main;
    }
}
