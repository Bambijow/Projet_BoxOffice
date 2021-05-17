import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class BoxOffice {
    private int nbLine;
    public abstract void addFilm(Film f);

    public BoxOffice(String listing) throws FileNotFoundException {
        Scanner in = new Scanner(new File(listing));
        nbLine = 0;
        String[] entry;
        while(in.hasNextLine()){
            String l = in.nextLine();
            nbLine++;
            entry = l.split(".FILM : |\tREALISATEUR : |\tANNEE : |\tVILLE : |\tENTREES :");
            //Main.afficherFilm(new Film(entry[0], entry[1], Integer.parseInt(entry[2]), Integer.parseInt(entry[4])));
            addFilm(new Film(entry[0], entry[1], Integer.parseInt(entry[2]), Integer.parseInt(entry[4])));
        }
        in.close();
    }
    public Film[] agrandirTab(Film[] tab){
        Film[] nouveauTab= new Film[tab.length * 2];
        for(int i = 0; i<tab.length;i++){
            if(tab[i] != null)
                nouveauTab[i]=tab[i];
        }
        return nouveauTab;
    }
    public FilmChaine[] agrandirTab(FilmChaine[] tab){
        FilmChaine[] nouveauTab= new FilmChaine[tab.length * 2];
        for(int i = 0; i<tab.length;i++){
            if(tab[i] != null)
                nouveauTab[i]=tab[i];
        }
        return nouveauTab;
    }

    public int getNbLine() {
        return nbLine;
    }
}
