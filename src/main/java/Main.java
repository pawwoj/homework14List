import java.util.*;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        Person person1 = new Person("Adam", Gender.MALE);
        Person person2 = new Person("Monika", Gender.FEMALE);
        Person person3 = new Person("Marcin", Gender.MALE);
        Person person4 = new Person("Adam", Gender.MALE);
        Person person5 = new Person("Edward", Gender.MALE);
        Person person6 = new Person("Adam", Gender.MALE);
        Person person7 = new Person("Igor", Gender.MALE);
        Person person8 = new Person("Marcin", Gender.MALE);
        Person person9 = new Person("Agata", Gender.FEMALE);
        Person person10 = new Person("Beata", Gender.FEMALE);
        Person person11 = new Person("Sylwia", Gender.FEMALE);
        Person person12 = new Person("Monika", Gender.FEMALE);

        List<Person> allPersons = List.of(person1, person2, person3, person4
                , person5, person6, person7, person8
                , person9, person10, person11, person12);

        List<String> stringList1 = new ArrayList<>(Arrays.asList("Ania", "Kasia", "Grzegorz", "Tomek", "Magda"));
        List<String> stringList2 = new ArrayList<>(Arrays.asList("Ola", "Kasia", "Sebastian", "Tomek", "Magda"));
        List<String> stringList3 = new ArrayList<>(Arrays.asList("Ania", "Krzys", "Ania", "Piotr", "Tomek", "Ania"));
        List<String> stringList4
                = new ArrayList<>(Arrays.asList("Ania", "Piotr", "Ania", "Tomek", "Krzyś", "Tomek", "Ania"));
        List<String> stringList5 = new ArrayList<>(Arrays.asList("Ania", "Pątuniusz", "Ąsębnik"));
        List<String> stringList6 = new ArrayList<>(Arrays.asList("Aleksandra", "Kasia", "Grzegorz", "Tomek", "Magda"));
        List<String> stringList7 = new ArrayList<>(Arrays.asList("Aleksandra", "    ", " ", " ", "Magda"));
        List<String> stringList8 = new ArrayList<>(Arrays.asList("Ania", "Krzys", "Tomek", "Kasia", "Jan"));
        List<String> stringList9 = new ArrayList<>(Arrays.asList("Ania", "Kasia", "Grzegorz", "Kleofacy", "Magda"));
        List<String> stringList10 = new ArrayList<>(Arrays.asList("Ola", "Kasia", "Sebastian", "Beata", "Magda"));
        List<String> stringList11
                = new ArrayList<>(Arrays.asList("Ania", "Krzys", "Monika", "Piotr", "Czarek", "Ania"));
        List<Integer> intList1 = new ArrayList<>(Arrays.asList(8, 23, 1, 42, 1));
        List<Integer> intList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> intList3 = new ArrayList<>(Arrays.asList(8, 23, 1, 42, 1, 38, 25, 368));
        List<Integer> intList4 = new ArrayList<>(Arrays.asList(4, 2, 5, 8, 3));
        String[] nameTable1 = {"Ania", "Pątuniusz", "Ąsębnik"};
        String[] nameTable2 = {"Aleksandra", "Kasia", "Grzegorz", "Tomek", "Magda"};
        String[] nameTable3 = {"Ania", "Krzys", "Tomek", "Kasia", "Jan"};
        List<String[]> stringTableLIst = new ArrayList<>(Arrays.asList(nameTable1, nameTable2, nameTable3));
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Jan");
        map1.put(2, "Ola");
        map1.put(3, "Kasia");
        map1.put(4, "Jan");
        map1.put(5, "Kasia");
        map1.put(6, "Iza");
        map1.put(7, "Kasia");
        Map<String, List<String>> schoolClassMap = new HashMap<>();
        schoolClassMap.put("1a", stringList9);
        schoolClassMap.put("2b", stringList10);
        schoolClassMap.put("3c", stringList11);

        /*1*/
        service.printAllMaleNameFromList(allPersons);
        /*2*/
        service.printCountOfGivenName(allPersons, "Adam");
        /*3*/
        System.out.println(service.getListOfStringCountingGivenChar(stringList1, 'a'));
        /*4*/
        System.out.println(service.getListOfStringsOccurringOnBothLists(stringList1, stringList2));
        /*5*/
        System.out.println(service.getDifferenceMaxMinIntFromList(intList1));
        /*6*/
        System.out.println(service.getListOfIndexesForGivenString(stringList3, "Ania"));
        /*7*/
        service.invertList(intList2);
        System.out.println(intList2);
        /*8*/
        System.out.println(service.getListOfIntegersEndedWithGivenDigit(intList3, 8));
        /*9*/
        System.out.println(service.getRepetitionsCounted(stringList4));
        /*10*/
        System.out.println(service.getAllVowelCounted(stringList5));
        /*11*/
        service.printUniqueNames(stringList4);
        /*12*/
        System.out.println(service.getListOfStringsWithEvenLengthAndLongerThen5(stringList6));
        /*13*/
        System.out.println(service.getCountOfWhitespaceWords(stringList7));
        /*14*/
        System.out.println(service.getListOfStringEqualToInt(stringList8, intList4));
        /*15*/
        System.out.println(service.getLengthOfAllStrings(stringTableLIst));
        /*16*/
        System.out.println(service.lottery());
        /*17*/
        service.printHowManyTimesElementHasBenAdded(map1);
        /*18*/
        System.out.println(service.getMapWithChangedValueWhenKeyIsEven(map1));
        /*19*/
        System.out.println(service.getListOfLongestNamesFromEachClass(schoolClassMap));
        /*20*/
        System.out.println(service.getLongestNameFromAllClasses(schoolClassMap));
    }
}
