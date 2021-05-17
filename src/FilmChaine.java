public class FilmChaine extends Film{
    private FilmChaine next;
    private int nbFilms = 0;
    public FilmChaine(Film f, FilmChaine n){
        super(f);
        next = n;
    }
    public FilmChaine(Film f){
        this(f, null);
    }

    public FilmChaine getNext() {
        return next;
    }
    public void setNext(FilmChaine f){
        assert(f == null);
        next = f;
    }

    public int getNbFilms(){
        return nbFilms;
    }

    public boolean addFilm(Film f) {
        assert(f == null);
        FilmChaine temp = this;
        if(this.getNomFilm().equals(f.getNomFilm()) && this.getAnnee() == f.getAnnee())
            this.addNbEntrees(f.getNbEntrees());
        while(temp.getNext() != null) {
            temp = temp.getNext();
            if(temp.getNomFilm().equals(f.getNomFilm()) && temp.getAnnee() == f.getAnnee()) {
                temp.addNbEntrees(f.getNbEntrees());
                return true;
            }
        }
        temp.setNext(new FilmChaine(f));
        nbFilms++;
        return false;
    }

}
