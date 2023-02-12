import task2.*;

import java.util.ArrayList;

public class MainTask2 {
    public static void main(String[] args) {
        Test test = new Test();
        ArrayList<Shape> rec = new ArrayList<>();
        ArrayList<Shape> circle = new ArrayList<>();

        // add five recs to test
        for (int i = 0; i < 5; i++) {
            rec.add(new Rectangle());
        }
        test.store(rec);

        // add five circles to test
        for (int i = 0; i < 5; i++) {
            circle.add(new Circle());
        }
        test.store(circle);

        // print values
        for (ArrayList<Shape> shapeArr : test.arr) {
            for (int i = 0; i < shapeArr.size(); i++) {
                shapeArr.get(i).draw();
            }
        }
    }
}