package rocks.zipcode;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.*;

public class ArrayListTest {

    ArrayList<Person> testArray;

    @Test
    public void setTestArray()
    {
        // GIVEN

        testArray = new ArrayList<Person>();
        Person testPersonA = new Person("James", 1979);
        Person testPersonB = new Person("Gary", 1953);
        Person testPersonC = new Person("Zane", 2011);

        // WHEN

        testArray.add(testPersonA);
        testArray.add(testPersonB);
        testArray.add(testPersonC);

        Person differentPersonObject = new Person("James", 1979);
        Person actual = testArray.get(0);

        // THEN

        assertEquals(testPersonA, actual);
        assertNotEquals(testPersonA, differentPersonObject);
    }

    @Test
    public void removeToEmptyArray()
    {
        // GIVEN

        Boolean expected = true;
        testArray = new ArrayList<>();

        // WHEN

        testArray.add(new Person("Barely There", 2020));
        testArray.remove(0);

        // THEN

        assertEquals(true, testArray.isEmpty());
    }

    @Test
    public void removeSpecificObject()
    {
        Person me = new Person("James", 1979);
        Person notMe = new Person("Jake", 1983);
        testArray = new ArrayList<>();

        // WHEN

        testArray.add(me);
        testArray.add(notMe);
        testArray.remove(me);
        Person actual = testArray.get(0);

        // THEN

        assertEquals(notMe, actual);
    }

    @Test
    public void clearAndEmpty()
    {
        // GIVEN

        Boolean expected = true;
        Person madMax = new Person("Mel Gibson", 1961);
        testArray = new ArrayList<>();

        // WHEN

        testArray.clear();
        Boolean actual = testArray.isEmpty();

        // THEN

        assertEquals(expected, actual);
    }

    @Test
    public void sortingArray()
    {
        // GIVEN

        testArray = new ArrayList<>();
        Person personA = new Person("Jerry", 1991);
        Person personB = new Person("John", 1981);
        Person personC = new Person("Jason", 1986);
        Integer expectedYear = 1981;
        String expectedName = "Jason";

        // WHEN

        testArray.add(personA);
        testArray.add(personB);
        testArray.add(personC);

        Comparator<Person> byAge = Comparator.comparing(Person::getYearOfBirth);
        Collections.sort(testArray, byAge);
        Integer actualYear = testArray.get(0).getYearOfBirth();

        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Collections.sort(testArray, byName);
        String actualName = testArray.get(0).getName();

        // THEN

        assertEquals(expectedYear, actualYear);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void sortByMultipleValues()
    {
        // GIVEN

        testArray = new ArrayList<>();
        testArray.add(new Person("Andy", 1977));
        testArray.add(new Person("Andy", 1951));
        testArray.add(new Person("Tim", 1991));
        Integer expectedYear = 1951;

        // WHEN

        Comparator<Person> byAge = Comparator.comparing(Person::getYearOfBirth);
        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Collections.sort(testArray, byName.thenComparing(byAge));
        Integer actualYear = testArray.get(0).getYearOfBirth();

        // THEN

        assertEquals(actualYear, expectedYear);
    }

    @Test
    public void middleThree()
    {
        // GIVEN

        ArrayList<Integer> numberArrayList = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(4);

        // WHEN

        numberArrayList.add(1);
        numberArrayList.add(2);
        numberArrayList.add(3);
        numberArrayList.add(4);
        numberArrayList.add(5);

        // THEN

        assertEquals(expected, numberArrayList.subList(1, 4));
    }

    @Test
    public void removeOdds()
    {
        // GIVEN

        ArrayList<Integer> testNumbers = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        expected.add(32);

        testNumbers.add(23);
        testNumbers.add(32);
        testNumbers.add(45);
        testNumbers.add(63);

        // WHEN

        testNumbers.removeIf(n -> (n % 2 != 0));

        // THEN

        assertEquals(expected, testNumbers);
    }
}

