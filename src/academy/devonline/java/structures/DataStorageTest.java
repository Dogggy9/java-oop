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

public class DataStorageTest {
    public static void main(String[] args) {

        DataStorage dataStorage = new StackBasedOnLinkedList(); // new Stack() or new Queue()

        for (int i = 0; i < 5; i++) {
            dataStorage.add(i);
        }

        //43210 - for stack
        //01234 - for queue
//        dataStorage.add(6);
//        System.out.print(dataStorage.get() + " ");
//        System.out.println();
//        dataStorage.add(5);

        while (dataStorage.size() > 0) {
            System.out.print(dataStorage.get() + " ");
        }
        System.out.println();
    }
}
