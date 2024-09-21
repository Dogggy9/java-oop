package academy.devonline.java.structures;

import java.util.Arrays;

public class DynaArray2 {

    private int[] result;

    private int count;

    public DynaArray2() {
//        result = new int[5]
        this(5);
    }

//    public DynaArray() {
//        if(Runtime.getRuntime().availableProcessors()>2) {
//            //result = new int[20];
//            this(20);
//        }
//        else {
////            result = new int[5];
//            this(5);
//        }
//    }

    public DynaArray2(int size){
        result = new int[size];
    }

    public void add(int value) {
        if (count == result.length) {
            grow(result.length * 2);
        }
        result[count++] = value;
    }

    public void add(int[] array) {
        add(array, array.length);
    }

    public void add(DynaArray2 dynaArray2) {
        add(dynaArray2.result, dynaArray2.count);
    }

    private void add(int[] array, int length) {
        if (result.length - count < length) {
            grow(count + length);
        }

        System.arraycopy(array, 0, result, count, length);
//        for (int i = 0; i < length; i++) {
//            result[i+count] = array[i];
//        }
        count += length;
    }

    private void grow(int newLength) {
        int[] newArray = new int[newLength];
        for (int i = 0; i < count; i++) {
            newArray[i] = result[i];
        }
//        System.arraycopy(result, 0, newArray, 0, count);
        result = newArray;
    }

    public int[] toArray() {

        return Arrays.copyOf(result, count);
    }

    public String asString() {
        final StringBuilder stringBuilder = new StringBuilder().append("[");
        for (int i = 0; i < count; i++) {
            stringBuilder.append(result[i]);
            if (i < count - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
