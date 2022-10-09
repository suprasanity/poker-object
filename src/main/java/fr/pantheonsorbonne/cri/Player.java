package fr.pantheonsorbonne.cri;

import java.util.ArrayList;

public class Player {
    public static final int TAILLEMAIN=5;
    private String nom;
    public enum COMBI {
        PAIR,
        BRELAN,
        CARRE,
    }
    private Card[] main= new Card[TAILLEMAIN];

    public Player(String nom){this.nom=nom;}

    public String mainToString(){
        String main="";
        int rang=0;
        for(Card carte : this.main){

            main+= "rang : "+rang +" "+carte.toString() +"\n";
            rang++;
        }
        return main;
    }
    public Card[] choixChangementCarte(){
        System.out.println(this.mainToString());
        System.out.println("Combien de carte voulez vous bruler ?");
        int nbCarteToBurn=ClosedPoker.sc.nextInt();
         Card[]tabloCarteABruler=new Card[nbCarteToBurn];
        for (int i = 0;i<nbCarteToBurn;i++){
            System.out.println("Quelle carte voulez vous bruler ?");
            int indiceCarte= ClosedPoker.sc.nextInt();
            tabloCarteABruler[i]=this.main[indiceCarte];
            this.main[indiceCarte]=null;

        }
      return tabloCarteABruler;
    }
    public void ajoutTirageCarte(Card[] carteAAjouter){
        for(Card c : carteAAjouter){
            for(int i =0;i<this.main.length;i++){
                if(this.main[i]==null){
                    this.main[i]=c;
                    break;
                }
            }
        }
        System.out.println(mainToString());

    }
      public void setMain(Card[]tabloMain){
        this.main=tabloMain;
      }

    public boolean beats(Player b){
        String combinaisonB= getCombinaison(b.main)[0];
        String combinaisonA= getCombinaison(this.main)[0];
        String valeurA = getCombinaison(this.main)[1];
        String valeurB = getCombinaison(b.main)[1];


        if (compareCombinaison(combinaisonA,combinaisonB).equals(combinaisonA)){
            return true;
        }

        else if (compareCombinaison(combinaisonA,combinaisonB).equals(combinaisonB)){
            return false;
        }

        else{
            if(compareValeur(valeurA,valeurB).equals(valeurA)){
                return true;
            }

            else{
                return false;
            }
        }



        //getCombinaison(une main) : donne les combinaison (paire, brelan, carre, rien), renvoie String.
        //compareCombinaison(2 combinaison(String))=donne la combinaison gagante(String)
        //compareValeur(2 valeur(String)): donne la valeur gagnante(String)
        //getValeurCombinaison(hand,combinaison) : retourne une valeur (String)
    }



    public String[] getCombinaison(Card[] main){
        int countMax=1;
        ArrayList <Card> carteMaxVal = new ArrayList<>();
        String valeur="";
        int countPaire=0;
        for(Card c : main){
            int count=0;
            for(Card c2 : main){
                if(c.getValeur().equals(c2.getValeur())){
                    count++;
                }
            }

            if(count>countMax){
                countMax=count;
                valeur = c.getValeur();
            }

            if(count==2){
                carteMaxVal.add(c);
                countPaire++;
            }

        }

        if(countPaire==2){
            valeur = compareValeur(carteMaxVal.get(0).getValeur(),carteMaxVal.get(1).getValeur());
        }

        if(countMax==2){
            String[] combi ={"pair",valeur};
            return combi;
        }

        else if(countMax==3){
            String[] combi ={"brelan",valeur};
            return combi;
        }

        else if(countMax==4){
            String[] combi ={"carre",valeur};
            return combi;
        }

        String[] combi ={"rien",valeur};
        return combi;

    }



    public int valeurCombinaison(String combi){
        if(combi.equals("carre")){
            return 4;
        }
        else if(combi.equals("brelan")){
            return 3;
        }
        else if(combi.equals("pair")){
            return 2;
        }
        else{
            return 1;
        }
    }
    public String compareCombinaison(String combiA, String combiB){
        int valA = valeurCombinaison(combiA);
        int valB = valeurCombinaison(combiB);
        if(valA>valB){
            return combiA;
        }
        else if(valA<valB){
            return combiB;
        }
        else{
            return "draw";
        }


    }

    public String compareValeur(String valeur1,String valeur2){
        int val1=valeurValeur(valeur1);
        int val2=valeurValeur(valeur2);

        if(val1>val2){
            return valeur1;
        }
        else if(val1<val2){
            return valeur2;
        }
        else{
            return "draw";
        }

    }

    public int valeurValeur(String valeur){
        if(valeur.equals("AS")){
            return 13;
        }

        else if(valeur.equals("ROI")){
            return 12;
        }

        else if(valeur.equals("DAME")){
            return 11;
        }

        else if(valeur.equals("VALET")){
            return 10;
        }

        else if(valeur.equals("DIX")){
            return 9;
        }

        else if(valeur.equals("NEUF")){
            return 8;
        }

        else if(valeur.equals("HUIT")){
            return 7;
        }

        else if(valeur.equals("SEPT")){
            return 6;
        }

        else if(valeur.equals("SIX")){
            return 5;
        }

        else if(valeur.equals("CINQ")){
            return 4;
        }

        else if(valeur.equals("QUATRE")){
            return 3;
        }

        else if(valeur.equals("TROIS")){
            return 2;
        }

        else{
            return 1;
        }
    }


}
