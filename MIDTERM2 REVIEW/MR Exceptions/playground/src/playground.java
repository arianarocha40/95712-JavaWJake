//import java.io.NotActiveException;

public class playground {
    public static void main(String[] args) {
        
        int fav = 2;
        Exception exc = new NotFavNumba();

        System.out.println("Hello, World!");

        // if (fav > 10) {
        //     throw exc;
        // }

        try {
            if(fav >10) {
                throw new NotFavNumba();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
