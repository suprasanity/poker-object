package fr.pantheonsorbonne.cri;

public class Card {
    private String couleur;
    private String valeur;
    private enum Level {
        AS,
        ROI,
        VALET,
        DAME,
        DIX,
        NEUF,
        HUIT,
        SEPT,
        SIX,
        CINQ,
        QUATRE,
        TROIS,
        DEUX,
    }
    public Card(String valeur,String couleur){
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public String getValeur(){
        return this.valeur;
    }

    public String getCouleur(){
        return this.couleur;
    }

    @Override
    public String toString() {
        return "Card{" +
                "couleur='" + couleur + '\'' +
                ", valeur='" + valeur + '\'' +
                '}';
    }
}
