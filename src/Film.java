public class Film {
    private String nomFilm, realisateur;
    private int annee, nbEntrees;

    public Film(String nomFilm, String realisateur, int annee, int nbEntrees){
        this.nomFilm = nomFilm;
        this.realisateur = realisateur;
        this.annee = annee;
        this.nbEntrees = nbEntrees;
    }

    public Film(Film f) {
        nomFilm = f.getNomFilm();
        realisateur = f.getRealisateur();
        annee = f.getAnnee();
        nbEntrees = f.getNbEntrees();
    }

    @Override
    public String toString() {
        return "(" + this.annee + ") " + this.nomFilm + " Réal.: " + this.realisateur + " Entrees: " + this.nbEntrees;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public void addNbEntrees(int i){
        assert(i <= 0);
        nbEntrees += i;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNbEntrees() {
        return nbEntrees;
    }

    public void setNbEntrees(int nbEntrees) {
        this.nbEntrees = nbEntrees;
    }
}
