import java.io.FileNotFoundException;

public class Main{

    public static void main(String[] args) {
        if(args.length == 0)
            System.exit(0);
        else
            try {
                new BoxTableau(args[0]);
                System.out.println("       ");
                new BoxOfficeHash(args[0]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.exit(0);
            }
    }

    public static void afficherFilm(Film f){
        System.out.println(f);
    }
}
