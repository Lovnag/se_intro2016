import java.util.*;

/**
 * Created by thy humble Lovnag on 10.12.2016.
 */
public class Main {

    public static void getItInto(Map<String, ArrayList<Integer>> m, String key, Integer value) {
        ArrayList<Integer> theValue = m.get(key);
        if (theValue.contains(0)) {
            theValue.clear();
        }
        theValue.add(value);
        m.put(key, theValue);
    }


    public static void main(String[] args) {
        List<String> studentList = new ArrayList<>();
        studentList.add("First student");
        studentList.add("Second student");
        studentList.add("Third student");
        studentList.add("Fourth student");

        Map<String, ArrayList<Integer>> students = new HashMap<>();
        for (String student : studentList) {
            ArrayList<Integer> startingScore = new ArrayList<>();
            startingScore.add(0);
            students.put(student, startingScore);
        }
        getItInto(students, "First student", 1);
        getItInto(students, "First student", 3);
        getItInto(students, "First student", 2);
        getItInto(students, "Second student", 1);

        int sum;
        String running;
        Iterator<String> studentNames = students.keySet().iterator();
        while (studentNames.hasNext()) {
            sum = 0;
            running = "";
            String key = studentNames.next();
            ArrayList<Integer> value = students.get(key);
            for (int i = 0; i < value.size() - 1; i++) {
                sum = sum + value.get(i);
                running = running + value.get(i).toString() + " + ";
            }
            sum = sum + value.get(value.size() - 1);
            running = running + value.get(value.size() - 1).toString();
            System.out.println(key + " final score is " + sum + " = {" + running + "}");
        }
    }
}
