/*
 * Copyright 2024 Doggy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package academy.devonline.java.structures;

public abstract class BasedOnArrayDataStorage extends BaseDataStorage {

    protected int[] array;

    public BasedOnArrayDataStorage() {

        this(5);
    }

    public BasedOnArrayDataStorage(int size) {

        array = new int[size];
    }

    @Override
    public final void add(int value) {
        if (count == array.length) {
            grow(array.length == 0 ? 5 : array.length * 2);
        }
        array[count++] = value;
    }

    private void grow(int newLength) {
        int[] newArray = new int[newLength];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
//        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray;
    }
}
