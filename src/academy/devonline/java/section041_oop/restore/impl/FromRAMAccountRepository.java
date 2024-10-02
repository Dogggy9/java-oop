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

package academy.devonline.java.section041_oop.restore.impl;

import academy.devonline.java.section041_oop.restore.Account;
import academy.devonline.java.section041_oop.restore.AccountRepository;

public class FromRAMAccountRepository implements AccountRepository {

    private final DefaultAccount[] accounts = {
            new DefaultAccount( "test1@gmail.com", true),
            new DefaultAccount( "test2@gmail.com", false)
    };


    @Override
    public Account findByEmail(String email) {
        for (DefaultAccount account : accounts) {
            if (email.equals(account.getEmail())){
                return account;
            }
        }
        return null;
    }

    @Override
    public void update(Account account) {
        // do not
    }
}
