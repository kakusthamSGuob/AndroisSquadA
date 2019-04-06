/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.mindorks.framework.mvvm.ui.search;

import androidx.databinding.ObservableField;

/**
 * Created by amitshekhar on 10/07/17.
 */

public class TransactionHistoryItemViewModel {

    public final ObservableField<String> transactionDate = new ObservableField<>();

    public final ObservableField<String> accountType = new ObservableField<>();

    public final ObservableField<String> accountNumber = new ObservableField<>();

    public final ObservableField<String> transactionAmount = new ObservableField<>();

    public TransactionHistoryItemViewModel(String trxDate, String accType, String accNumber, String trxAmount) {
        this.transactionDate.set(trxDate);
        this.accountType.set(accType);
        this.accountNumber.set(accNumber);
        this.transactionAmount.set(trxAmount);
    }
}
