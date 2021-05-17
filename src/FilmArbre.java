public class FilmArbre extends Film {
    private FilmArbre gauche;
    private FilmArbre droite;

    public FilmArbre(Film f, FilmArbre g, FilmArbre d) {
        super(f);
        gauche = g;
        droite = d;
    }

    public FilmArbre(Film f) {
        this(f, null, null);
    }

    public int cle() {
        return this.getNbEntrees();
    }

    public int size() {
        int res = 1;
        if (gauche != null)
            res += gauche.size();
        if (droite != null)
            res += droite.size();
        return res;
    }

    public void addFilm(FilmArbre f) {
        FilmArbre s = search(f);
        if (s == null) {
            if (f.getNbEntrees() < this.getNbEntrees()) {

                if (gauche == null) {
                    gauche = f;
                } else {
                    gauche.addFilm(f);

                }
            } else {
                if (droite == null) {
                    droite = f;
                } else {
                    droite.addFilm(f);
                }
            }
        }
        else
            s.addNbEntrees(f.getNbEntrees());
    }

    static void troisPlusGrand(FilmArbre f) {
        if (f == null)
            return;

        if (f.getNbEntrees() > BoxOfficeArbre.meilleurFilms[0].getNbEntrees()) {
            BoxOfficeArbre.meilleurFilms[2] = BoxOfficeArbre.meilleurFilms[1];
            BoxOfficeArbre.meilleurFilms[1] = BoxOfficeArbre.meilleurFilms[0];
            BoxOfficeArbre.meilleurFilms[0] = f;
        } else if (f.getNbEntrees() > BoxOfficeArbre.meilleurFilms[1].getNbEntrees() &&
                !f.equals(BoxOfficeArbre.meilleurFilms[0])) {
            BoxOfficeArbre.meilleurFilms[2] = BoxOfficeArbre.meilleurFilms[1];
            BoxOfficeArbre.meilleurFilms[1] = f;
        } else if (f.getNbEntrees() > BoxOfficeArbre.meilleurFilms[2].getNbEntrees() &&
                !f.equals(BoxOfficeArbre.meilleurFilms[0]) &&
                !f.equals(BoxOfficeArbre.meilleurFilms[1]))
            BoxOfficeArbre.meilleurFilms[2] = f;

        troisPlusGrand(f.gauche);
        troisPlusGrand(f.droite);
    }

    public FilmArbre search(FilmArbre f) {
        FilmArbre r = null;
        if (this.getNomFilm().equals(f.getNomFilm()) && this.getAnnee() == f.getAnnee()) {
            r = this;
        } else if (gauche != null && gauche.getNomFilm().equals(f.getNomFilm()) && gauche.getAnnee() == f.getAnnee()) {
            r = gauche;
        } else if (droite != null && droite.getNomFilm().equals(f.getNomFilm()) && droite.getAnnee() == f.getAnnee()) {
            r = droite;
        }
        if (r == null && gauche != null) {
            r = gauche.search(f);
        }
        if (r == null && droite != null) {
            r = droite.search(f);
        }
        return r;
    }
}
