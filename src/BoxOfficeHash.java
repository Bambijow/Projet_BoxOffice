import java.io.FileNotFoundException;

public class BoxOfficeHash extends BoxOffice {
    public final int TAILLE_INITIALE = 100000;
    private FilmChaine[] elements;
    private int nbFilmsDiff;
    private Film[] meilleurFilms;

    public BoxOfficeHash(String listing) throws FileNotFoundException {
        super(listing);
        System.out.println("Fichier : " + listing);
        System.out.println(
                "Nombre de lignes : " + getNbLine() + "\n" +
                        "Nombre de films différents : " + nbFilmsDiff + "\n" +
                        "--------------------" + "\n" +
                        "Films compatabilisant le plus grand nombre d'entrées :"
        );
        meilleurFilms = new Film[3];

        meilleurFilms[0] = new Film("film1", "real", 0, 0);
        meilleurFilms[1] = new Film("film2", "real2", 0, 0);
        meilleurFilms[2] = new Film("film3", "real3", 0, 0);
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                if (elements[i].getNbEntrees() > meilleurFilms[0].getNbEntrees()) {
                    meilleurFilms[2] = meilleurFilms[1];
                    meilleurFilms[1] = meilleurFilms[0];
                    meilleurFilms[0] = elements[i];
                } else if (elements[i].getNbEntrees() > meilleurFilms[1].getNbEntrees()) {
                    meilleurFilms[2] = meilleurFilms[1];
                    meilleurFilms[1] = elements[i];
                } else if (elements[i].getNbEntrees() > meilleurFilms[2].getNbEntrees()) {
                    meilleurFilms[2] = elements[i];
                }
            }
        }
        for (Film f : meilleurFilms) {
            System.out.printf("%s \n", f.toString());
        }
    }

    public void addFilm(Film f) {
        if (elements == null) elements = new FilmChaine[TAILLE_INITIALE];
        int hash = (Math.abs(f.getNomFilm().hashCode() + f.getAnnee()) % elements.length);
        while (hash > elements.length) {
            elements = super.agrandirTab(elements);
        }
        if (elements[hash] == null) {
            elements[hash] = new FilmChaine(f);
            nbFilmsDiff++;
        } else {
            if(elements[hash].getNomFilm().equalsIgnoreCase(f.getNomFilm()) && elements[hash].getAnnee() == f.getAnnee())
                elements[hash].addNbEntrees(f.getNbEntrees());
            else {
                FilmChaine tmp = elements[hash];
                while(tmp.getNext() != null){
                    if(tmp.getNomFilm().equals(f.getNomFilm()) && tmp.getAnnee() == f.getAnnee()) {
                        tmp.addNbEntrees(f.getNbEntrees());
                        return;
                    }
                    tmp = tmp.getNext();
                }
                if(tmp.getNomFilm().equals(f.getNomFilm()) && tmp.getAnnee() == f.getAnnee())
                    tmp.addNbEntrees(f.getNbEntrees());
                else {
                    tmp.setNext(new FilmChaine(f));
                    nbFilmsDiff++;
                }
            }
        }
    }
}
