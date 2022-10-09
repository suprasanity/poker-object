package fr.pantheonsorbonne.cri;

import java.util.Scanner;

public class ClosedPoker {
    public static Scanner sc= new Scanner(System.in);
    public static void main(String ...args){
        Player p1=new Player("Yann");
        Player p2=new Player ("Macron");
        Player p3 =new Player("Melanchon");

        p1.setMain(Deck.getCartes(Player.TAILLEMAIN));
        p2.setMain(Deck.getCartes(Player.TAILLEMAIN));
        p3.setMain(Deck.getCartes(Player.TAILLEMAIN));

        System.out.println(" TOUR DU JOUEUR 1");
        Card[] cardsP1=p1.choixChangementCarte();
        p1.ajoutTirageCarte(Deck.getCartes(cardsP1.length));

        System.out.println(" TOUR DU JOUEUR 2");
        Card[] cardsP2=p2.choixChangementCarte();
        p2.ajoutTirageCarte(Deck.getCartes(cardsP2.length));

        System.out.println(" TOUR DU JOUEUR 3");
        Card[] cardsP3=p3.choixChangementCarte();
        p3.ajoutTirageCarte(Deck.getCartes(cardsP3.length));

        if(p1.beats(p2) && p1.beats(p3)){
            System.out.println("P1 wins with hand \n"+p1.mainToString());
        }

        else if(p2.beats(p1) && p2.beats(p3)){
            System.out.println("P2 wins with hand \n"+p2.mainToString());
        }

        else if(p3.beats(p1) && p3.beats(p3)){
            System.out.println("P3 wins with hand \n"+p3.mainToString());
        }
        else{
            System.out.println("there is a draw");
        }

        }

}