package academy.devonline.java.structures;

import java.util.Arrays;

public final class DynaArray extends BaseDataStructure {

    private int[] result;

    public DynaArray() {

        this(5);
    }

    public DynaArray(int size) {

        result = new int[size];
    }

    @Override
    public void add(int value) {
        if (count == result.length) {
            grow(result.length == 0 ? 5 : result.length * 2);
        }
        result[count++] = value;
    }

    @Override
    public void add(int[] array) {
        add(array, array.length);
    }

    @Override
    public void add(DynaArray dynaArray) {

        add(dynaArray.result, dynaArray.count);
    }

    private void add(int[] array, int length) {
        if (result.length - count < length) {
            grow(count + length);
        }
        System.arraycopy(array, 0, result, count, length);
        count += length;
    }

    private void grow(int newLength) {
        int[] newArray = new int[newLength];
        if (count >= 0) System.arraycopy(result, 0, newArray, 0, count);
        result = newArray;
    }

    @Override
    public int[] toArray() {

        return Arrays.copyOf(result, count);
    }

    @Override
    public String toString() {
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

    @Override
    public boolean remove(int value) {
        int index = indexOf(value);
        if (index != -1) {
            removeByIndex(index);
            return true;
        }
        return false;
    }

    private void removeByIndex(int index) {
        if (index < count - 1) {
            for (int i = index; i < count - 1; i++) {
                result[i] = result[i + 1];
            }
        }
        count--;
    }

    private int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (result[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) >= 0;

    }
}
