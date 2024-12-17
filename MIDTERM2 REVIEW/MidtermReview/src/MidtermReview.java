import java.util.ArrayList;
import java.util.Collection;

public class MidtermReview {

    public static void main(String[] args) throws Exception {

        Collection<Animal> animal = new ArrayList();


        Animal elephant = new Elephant();
        Animal rhino = new Rhino();
        Animal belephant = new BElephant();

        animal.add(elephant);
        animal.add(rhino);
        animal.add(belephant);

        for (Animal a : animal) {
            a.eat();
        }
    }
}
