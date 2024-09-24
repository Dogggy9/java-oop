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

public class LinkedList extends BaseDataStructure {

    private Item first;

    private Item last;

    @Override
    public void add(int value) {
        Item item = new Item(value);
        count++;
        if (first == null) {
            first = last = item;
        } else {
            last.next = item;
            last = item;
        }
    }

    @Override
    public void add(LinkedList list) {
        if (list.count > 0) {
            if (last != null) {
                last.next = list.first;
            } else {
                first = list.first;
            }
            last = list.last;
            count += list.count;
        }
    }


    @Override
    public int[] toArray() {
        int[] array = new int[count];
        int index = 0;
        Item current = first;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append('[');
        Item current = first;
        while (current != null) {
            builder.append(current.value);
            if (current.next != null) {
                builder.append(", ");
            }
            current = current.next;
        }
        return builder.append(']').toString();
    }

    @Override
    public void clear() {
        super.clear();
        first = null;
        last = null;
    }

    @Override
    public boolean remove(int value) {
        Pair pair = findPair(value);
        if (pair != null) {
            if (pair.current == first && pair.current == last) {
                first = null;
                last = null;
            } else if (pair.current == first) {
                first = pair.current.next;
            } else {
                pair.previous.next = pair.current.next;
                if (pair.current == last) {
                    last = pair.previous;
                }
            }
            count--;
            return true;
        }
        return false;
    }

    private Pair findPair(int value) {
        Item previous = first;
        Item current = first;
        while (current != null) {
            if (current.value == value) {
                return new Pair(previous, current);
            } else {
                previous = current;
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public boolean contains(int value) {
        Item current = first;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private static class Pair {

        private Item previous;

        private Item current;

        public Pair(Item previous, Item current) {
            this.previous = previous;
            this.current = current;
        }
    }


    /**
     * @author doggy
     * @link
     */
    private static class Item {

        private int value;

        private Item next;

        private Item(int value) {
            this.value = value;
        }
    }
}