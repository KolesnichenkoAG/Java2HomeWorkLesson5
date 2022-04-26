package homeWork;

public class Lesson5 {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE/2;
    public static void main(String[] args) {
        firstMethod();
      // metod2();
    }

    public static void firstMethod(){
        float[] arr1 = new float[SIZE];
        for(float i = 0; i < arr1.length; i ++){
            arr1[(int) i] = 1.0f;
            //System.out.println("arr1 [" + i + "] =" + arr1[(int) i]);
        }
        long startTime = System.currentTimeMillis();
        //System.out.println();
        for(float i = 0; i < arr1.length; i ++){
            arr1[(int) i] = (float) (arr1[(int) i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                    / 5) * Math.cos(0.4f + i / 2));
            //System.out.println("arr1 [" + i + "] =" + arr1[(int) i]);
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

    }
    public static void metod2 () {
        int[] arr1 = new int[HALF];
        for (int i = 0; i < HALF; i++) {
            arr1[i] = 1;
            System.out.println("arr1 [" + i + "] =" + arr1[i]);
        }
    }
}
