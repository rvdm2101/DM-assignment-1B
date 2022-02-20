import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class main {
    private static Sentient trump = new Human("Trump");

    public static void main(String[] args) {
        List<Sentient> allDomain = prepareForAllDomain();
        List<Sentient> existDomain = prepareForExistDomain();
        Predicate<Sentient> predicate = preparePredicate();
        boolean resultForAll = forAll(allDomain, predicate);
        boolean resultForAllShouldBeFalse = forAll(existDomain, predicate);
        boolean resultThereExists = thereExists(existDomain, predicate);

        System.out.println("True: " + resultForAll);
        System.out.println("False: " + resultForAllShouldBeFalse);
        System.out.println("True: " + resultThereExists);
    }

    private static List<Sentient> prepareForAllDomain() {
        List<Sentient> list = new ArrayList<>();
        Sentient trumpSupporter1 = new Human("Henk");
        Sentient trumpSupporter2 = new Human("Jan");
        trumpSupporter1.setLikes(trump);
        trumpSupporter2.setLikes(trump);

        list.add(trumpSupporter1);
        list.add(trumpSupporter2);

        return list;
    }

    private static List<Sentient> prepareForExistDomain() {
        List<Sentient> list = new ArrayList<>();
        Sentient trumpSupporter3 = new Human("Jake");
        Sentient randomGuy = new Human("Piet");
        trumpSupporter3.setLikes(trump);

        list.add(trumpSupporter3);
        list.add(randomGuy);

        return list;
    }

    private static Predicate<Sentient> preparePredicate() {
        return s -> s.likes(trump);
    }

    private static boolean forAll(List<Sentient> sentients, Predicate<Sentient> predicate) {
        return sentients.stream().allMatch(predicate);
    }

    private static boolean thereExists(List<Sentient> sentients, Predicate<Sentient> predicate) {
        return sentients.stream().anyMatch(predicate);
    }
}
