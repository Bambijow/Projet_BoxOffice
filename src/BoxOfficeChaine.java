import java.io.FileNotFoundException;

public class BoxOfficeChaine extends BoxOffice {
    private FilmChaine elements;
    private Film meilleurFilms[];
    private int taille;

    public BoxOfficeChaine (String listing) throws FileNotFoundException {
        super(listing);
        System.out.println("Fichier : " + listing);
        System.out.println(
                "Nombre de lignes : " + getNbLine()+ "\n"+
                "Nombre de films différents : " + elements.getNbFilms() + "\n"+
                "--------------------" + "\n"+
                "Films compatabilisant le plus grand nombre d'entrées :"
        );

        meilleurFilms = new Film[3];

        meilleurFilms[0] = new Film("film1", "real", 0, 0);
        meilleurFilms[1] = new Film("film2", "real2", 0, 0);
        meilleurFilms[2] = new Film("film3", "real3", 0, 0);
        FilmChaine tmp = elements;
        while (tmp.getNext() != null){
            if (tmp.getNbEntrees() > meilleurFilms[0].getNbEntrees()) {
                meilleurFilms[2] = meilleurFilms[1];
                meilleurFilms[1] = meilleurFilms[0];
                meilleurFilms[0] = tmp;
            }
            else if (tmp.getNbEntrees()>meilleurFilms[1].getNbEntrees()) {
                meilleurFilms[2] = meilleurFilms[1];
                meilleurFilms[1] = tmp;
            }
            else if (tmp.getNbEntrees()>meilleurFilms[2].getNbEntrees()) {
                meilleurFilms[2] = tmp;
            }
            tmp = tmp.getNext();
        }
        for( Film f : meilleurFilms){
            System.out.printf("%s \n", f.toString());
        }
    }

    public void addFilm(Film m) {
        if(elements == null)
            elements = new FilmChaine(m);
        elements.addFilm(m);
    }
}
