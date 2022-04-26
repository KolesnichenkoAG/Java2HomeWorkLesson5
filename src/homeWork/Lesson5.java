package homeWork;

public class Lesson5 {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        float[] arr1 = new float[SIZE];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                    / 5) * Math.cos(0.4f + i / 2));
            //System.out.println("arr1 [" + i + "] =" + arr1[i]);
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() {
        float[] arr2 = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr2[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];
        System.arraycopy(arr2, 0, leftHalf, 0, HALF);
        System.arraycopy(arr2, HALF, rightHalf, 0, HALF);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < leftHalf.length; i++) {
                    leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                            / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < rightHalf.length; i++) {
                    rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                            / 5) * Math.cos(0.4f + i / 2));
                    //System.out.println("rigtHalf [" + i + "] =" + rightHalf[i]);
                }
            }
        });
        thread1.start();
        thread2.start();
        float[] mergedArray = new float[SIZE];
        System.arraycopy(leftHalf, 0, mergedArray, 0, HALF);
        System.arraycopy(rightHalf, 0, mergedArray, HALF, HALF);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
