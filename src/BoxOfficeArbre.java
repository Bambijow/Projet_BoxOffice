import java.io.FileNotFoundException;

public class BoxOfficeArbre extends BoxOffice{
    private FilmArbre elements;
    public static Film[] meilleurFilms = new Film[3];

    public BoxOfficeArbre (String listing) throws FileNotFoundException {
        super(listing);
        System.out.println("Fichier : " + listing);
        System.out.println(
                "Nombre de lignes : " + getNbLine()+ "\n"+
                        "Nombre de films différents : " + elements.size() + "\n"+
                        "--------------------" + "\n"+
                        "Films compatabilisant le plus grand nombre d'entrées :"
        );
        meilleurFilms[0] = new Film("film1", "real", 0, 0);
        meilleurFilms[1] = new Film("film2", "real2", 0, 0);
        meilleurFilms[2] = new Film("film3", "real3", 0, 0);
        FilmArbre.troisPlusGrand(elements);
        for( Film f : meilleurFilms){
            System.out.printf("%s \n", f.toString());
        }

    }

    public void addFilm(Film m) {
        if(elements == null){
            elements = new FilmArbre(m);
            return;
        }
        elements.addFilm(new FilmArbre(m));
    }
}
