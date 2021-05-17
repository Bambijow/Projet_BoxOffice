import java.io.FileNotFoundException;

public class BoxTableau extends BoxOffice {
    private Film films[];
    private final int TAILLE = 100;
    private int pointeur;
    private Film meilleurFilms[];


    public BoxTableau(String listing) throws FileNotFoundException {
        super(listing);
        System.out.println("Fichier : " + listing);
        System.out.println("Nombre de lignes : " + getNbLine()+ "\n"+
                "Nombre de films différents : " + pointeur+ "\n"+
                "--------------------" + "\n"+
                "Films compatabilisant le plus grand nombre d'entrées :");

        meilleurFilms = new Film[3];

        meilleurFilms[0] = new Film("film1", "real", 0, 0);
        meilleurFilms[1] = new Film("film2", "real2", 0, 0);
        meilleurFilms[2] = new Film("film3", "real3", 0, 0);
        boolean r;
        for(int i=0; i<pointeur; i++){
            if (films[i].getNbEntrees()>meilleurFilms[0].getNbEntrees()) {
                meilleurFilms[2] = meilleurFilms[1];
                meilleurFilms[1] = meilleurFilms[0];
                meilleurFilms[0] = films[i];
            }
            else if (films[i].getNbEntrees()>meilleurFilms[1].getNbEntrees()) {
                meilleurFilms[2] = meilleurFilms[1];
                meilleurFilms[1] = films[i];
            }
            else if (films[i].getNbEntrees()>meilleurFilms[2].getNbEntrees()) {
                meilleurFilms[2] = films[i];
            }
        }
        for( Film f : meilleurFilms){
            System.out.printf("%s \n", f.toString());
        }
    }

    @Override
    public void addFilm(Film f) {
        if(films == null) films = new Film[TAILLE];
        if(pointeur >= films.length) films = agrandirTab(films);
        for(int i = 0; i < pointeur; i++){
            if(films[i].getNomFilm().equals(f.getNomFilm()) && films[i].getRealisateur().equals(f.getRealisateur())) {
                films[i].addNbEntrees(f.getNbEntrees());
                return;
            }
        }
        films[pointeur++] = f;
    }
}
