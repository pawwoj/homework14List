import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {

    // 1 Wyswietl wszystkie imiona męskie które znajduja sie w liscie
    public void printAllMaleNameFromList(List<Person> list) {
        list.stream().filter(person -> person.getGender().equals(Gender.MALE))
                .map(Person::getName).distinct()
                .forEach(System.out::println);
    }

    // 2 Wyswietl ile razy było podane imie podane jako parametr
    public void printCountOfGivenName(List<Person> list, String name) {
        System.out.println(list.stream().filter(person -> person.getName().equals(name)).count());
    }

    // 3 Napisz metode ktora jako parametr przyjmuje Liste Stringow oraz znak. Zwroc
    // liste zawierajaca wszystkie
    // Stringi ktore zawieraja podana znak
    // Lista: Ania Kasia Grzegorz Tomek Magda a znak to a, to lista zwracana powinna
    // zawierac Ania Kasia Magda
    public List<String> getListOfStringCountingGivenChar(List<String> list, char sign) {
        return list.stream().filter(s -> s.contains(String.valueOf(sign))).toList();
    }

    // 4 Napisz metode ktora jako parametr przyjmuje 2 Listy Stringow i zwraca liste
    // elementów ktore sa na obu listach
    public List<String> getListOfStringsOccurringOnBothLists(List<String> list1, List<String> list2) {
        return list1.stream().filter(s1 -> list2.stream().anyMatch(s2 -> s2.equals(s1))).toList();
    }

    // 5 Napisz metode ktora dla listy intów zwroci roznice pomiedzy jej najwiekszym a
    // najmniejszym elementem
    public int getDifferenceMaxMinIntFromList(List<Integer> list) {
        return list.stream().max(Comparator.comparing(integer -> integer)).get()
                - list.stream().min(Comparator.comparing(integer -> integer)).get();
    }

    // 6 Napisz metode ktora przyjmuje liste Stringow i zwraca listę (intow) indeksow
    // wszystkich elementow na liscie, ktore sa takie same jak parametr metody
    // np dla Listy Ania Krzys Ania Piotr Tomek Ania i imienia Ania
    // output: to 0,2,5
    public List<Integer> getListOfIndexesForGivenString(List<String> list, String s) {
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(s)) {
                indexList.add(i);
            }
        }
        return indexList;
    }

    // 7 Napisz metode ktora odwraca kolejnosc liczb w liscie ktora jest podana jako parametr

    // 7 Napisz metode ktora odwraca kolejnosc liczb w liscie ktora jest podana jako parametr
    // metoda ma odwrocic liste, nie ma nic zwracac, nie mozna wykorzystywac innych list/tablic
    public void invertList(List<Integer> list) {
        Collections.reverse(list);
    }

    // 8 majac liste intow zwróc liste intow tych ktore te ktore koncza sie na cyfre
    // podana jako porametr
    public List<Integer> getListOfIntegersEndedWithGivenDigit(List<Integer> list, int i) {
        return list.stream().filter(integer -> String.valueOf(integer).endsWith(String.valueOf(i))).toList();
    }

    // 9 Wyświetl ile razy ktorekolwiek imie zostało powtórzone Np dla imion ania piotr ania tomek krzys tomek ania program
    // powinien wypisac 3, bo byly 3 potworki
    public int getRepetitionsCounted(List<String> list) {
        return list.size() - list.stream().distinct().toList().size();
    }

    // 10 Wyswietl ile razy we wszystkich imionach była użyta samogłoska
    public int getAllVowelCounted(List<String> list) {
        int counter = 0;
        List<Character> vowelList = List.of('a', 'ą', 'e', 'ę', 'i', 'o', 'u', 'ó', 'y');
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.toLowerCase(Locale.ROOT).charAt(i);
                if (vowelList.contains(ch)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    //11 Napisz metodę która wyswietli unikalne imiona
    public void printUniqueNames(List<String> list) {
        final int oneUniqueOccurrence = 1;
        System.out.println(list.stream().filter(s ->
                (list.stream().filter(s1 -> s1.equals(s)).count() == oneUniqueOccurrence)).toList());
    }

    //12 Zwroc liste imion które sa dluzsze niz 5 znakow o parzystej dlugosci
    public List<String> getListOfStringsWithEvenLengthAndLongerThen5(List<String> list) {
        return list.stream().filter(s -> (s.length() > 5) && ((s.length() % 2) == 0)).toList();
    }

    //13 Zwroc liczbe słow ktore sa zlozone z samych whitespaców np spacji
    public int getCountOfWhitespaceWords(List<String> list) {
        return list.stream()
                .filter(string -> string.chars().mapToObj(value -> (char) value).toList().stream()
                        .filter(Character::isWhitespace)
                        .toList().size() == string.length()).toList().size();
    }

    //14 Napisz metode ktora przyjmuje jako parametr liste Stringow oraz liste intow (tej samej dlugosci obie listy)
    //Metoda ma zwrocic liste Stringow z pirwszej listy ktorych dlugosc odpowiada liczbom na 2 liscie
    // Ania Krzys Tomek Kasia Jan
    // 4 2 5 8 3
    //Ania Tomek Jan
    public List<String> getListOfStringEqualToInt(List<String> stringList, List<Integer> integerList) {
        AtomicInteger incrementer = new AtomicInteger();
        return stringList.stream().filter(s -> s.length() == integerList.get(incrementer.getAndIncrement())).toList();
    }

    //15 Napisz metode ktora przyjmuje jako parametr liste tablic Stringow i oblicza
    // sume dlugosci wszystkich Stringów
    public int getLengthOfAllStrings(List<String[]> list) {
        AtomicInteger count = new AtomicInteger();
        list.stream().forEach(tab -> Arrays.stream(tab).sequential().forEach(s -> count.set(count.get() + s.length())));
        return count.get();
    }

    //16 Napisz program, ktory losuje liczby w duzym lotku bez powtorzen, zakres liczb 1-45
    public Set<Integer> lottery() {
        Set<Integer> num = new LinkedHashSet<>();
        while (num.size() < 5) {
            num.add((int) (Math.random() * 45) + 1);
        }
        return num;
    }

    //17 Napisz metode ktora pozwala dodawac do mapy kolejne wyrazy. Na koncu ma
    // wyswietlic ile razy jaki element byl dodany
    public void printHowManyTimesElementHasBenAdded(Map<Integer, String> map) {
        System.out.println(map.values().stream().distinct()
                .map(s -> s + " - " + map.values().stream().filter(s1 -> s1.equals(s)).count()).toList());
    }

    //17 Albo
    public void printHowManyTimesElementHasBenAdded() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> map = new HashMap<>();
        int coun = 0;
        label:
        while (true) {
            System.out.println("[ 1 - Add Element ]  [ 2 - Finish ]");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Add Element:");
                    String newElement = scanner.nextLine();
                    map.put(coun++, newElement);
                    break;
                case "2":
                    System.out.println(map.values().stream().distinct()
                            .map(s -> s + " - " + map.values().stream().filter(s1 -> s1.equals(s)).count()).toList());
                    break label;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }

    //18 napisz metode ktora przyjmuje Mape<Integer, String>, zamien wartosci ktorych
    // klucze sa parzystych wartosci
    // na słowo "parzyste"
    public Map<Integer, String> getMapWithChangedValueWhenKeyIsEven(Map<Integer, String> map) {
        map.replaceAll((key, value) -> key % 2 == 0 ? "parzyste" : value);
        return map;
    }

    //19 W systemie przechowujemy nazwe klasy (szkolnej, np 1a, 2b) oraz listę osób
    // (same nazwiska jako Stringi) które uczeszczaja do klasy.
    // 1) Napisz metode ktora zwraca liste osob o najdluzszych nazwiskach z kazdej klasy
    public List<String> getListOfLongestNamesFromEachClass(Map<String, List<String>> map) {
        List<String> list = new ArrayList<>();
        // dodawane imiona o max długości z listy z mapy
        map.values()
                .forEach(v -> list.addAll(v.stream()
                        .filter(s -> s.length() == v.stream()
                                .max(Comparator.comparingInt(String::length)).get().length()).toList()));
        // tylko 1 imię z każdej listy
//     map.values()
//                .forEach(v -> list.add(v.stream().max(Comparator.comparingInt(String::length)).get()));

        return list;
    }

    //20 2) Napisz metode która zwraca osobe o najdluzszym nazwisku ze wzystkich klas
    public String getLongestNameFromAllClasses(Map<String, List<String>> map) {
        List<String> list = new ArrayList<>();
        map.values().forEach(list::addAll);

        return list.stream().max(Comparator.comparingInt(String::length)).get();
    }
}
