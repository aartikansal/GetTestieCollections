package rocks.zipcode;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class AppTest{

    @Test
    public void testApp(){
        assertTrue(true);
    }

    @Test
    public void hashSetAddTest(){
        HashSet<Integer> mySet = new HashSet<>();
        Integer[] arr = {1,2,3,4,5,6,6};
        mySet.addAll(Arrays.asList(arr));

        Integer before = mySet.size();

        mySet.add(19);

        Integer after = mySet.size();

        Assert.assertTrue(after > before);

    }

    @Test
    public void arrayListIsEmpty(){
        ArrayList<String> newArr = new ArrayList<>();

        boolean actual = newArr.isEmpty();

        Assert.assertTrue(actual);


    }

    @Test
    public void hashMapClear(){
        HashMap<String, Integer> myHashMap= new HashMap<>();
        myHashMap.put("Will", 27);
        myHashMap.put("bob", 29);

        myHashMap.clear();
        Integer check = myHashMap.size();

        Assert.assertTrue(check == 0);

    }

    @Test
    public void linkedListRetainAllTest(){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(4);

        LinkedList newList = new LinkedList(nums);
        newList.add(7);

        newList.retainAll(nums);

        boolean actual = newList.contains(7);

        Assert.assertFalse(actual);


    }

    @Test
    public void arrayDequeRemoveFirst(){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(4);

        ArrayDeque newDeque = new ArrayDeque(nums);

        newDeque.removeFirst();

        boolean actual = newDeque.contains(2);

        Assert.assertFalse(actual);


    }

    @Test
    public void vectorClone(){
        Vector<Integer> myVector = new Vector<>(20);

        myVector.add(2);

        Vector myVector2 = (Vector) myVector.clone();

        Assert.assertEquals(myVector, myVector2);

    }

    @Test
    public void treeMapRemove(){
        TreeMap<String, Integer> myTreeMap= new TreeMap<>();
        myTreeMap.put("Will", 27);
        myTreeMap.put("bob", 29);

        myTreeMap.remove("Will");
        boolean expected = myTreeMap.containsKey("Will");

        Assert.assertFalse(expected);

    }

    @Test
    public void stackPush(){
        Stack<Integer> myStack = new Stack<>();

        myStack.add(30);
        myStack.add(33);
        myStack.add(34);

        Integer expected =  (Integer) myStack.pop();

        assertEquals(34, (int) expected);

    }

    @Test
    public void treeSetRemoveIf(){
        TreeSet<String> myTreeSet = new TreeSet<>();
        myTreeSet.add("William");
        myTreeSet.add("Bob");
        myTreeSet.add("Life");



        boolean expected = myTreeSet.remove("Bob");

        assertFalse(myTreeSet.contains("Bob"));

    }

    @Test
    public void iteratorNext(){
        TreeSet<String> myTreeSet = new TreeSet<>();
        myTreeSet.add("William");
        myTreeSet.add("Billy");
        myTreeSet.add("Life");
        myTreeSet.add("Love");
        myTreeSet.add("Liberty");

        Iterator<String> iterator = myTreeSet.iterator();

        String expected = myTreeSet.iterator().next();


        assertTrue(expected == "Billy");

    }

    @Test
    public void priorityQueuePeek(){

        PriorityQueue<String> myPriorityQueue = new PriorityQueue<>();
        myPriorityQueue.add("Christ");
        myPriorityQueue.add("Is");
        myPriorityQueue.add("Lord");
        myPriorityQueue.add("Christ ");
        myPriorityQueue.add("Is");
        myPriorityQueue.add("Love");


        String expected = myPriorityQueue.peek();

        assertSame(expected, "Christ");
    }

    @Test
    public void compareToInt() {


        String myString1 =  "Christ";
        String myString2 = "is";
        String myString3 = "Lord";
        String myString4 = "Christ";
        String myString5 = "is";
        String myString6 = "";

        int expected = (myString1.compareTo(myString6));

        //myPriorityQueue.comparator();
        assertTrue(expected == 6);


    }



}

