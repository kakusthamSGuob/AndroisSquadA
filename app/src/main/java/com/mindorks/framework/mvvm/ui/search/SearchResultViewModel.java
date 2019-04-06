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

import android.text.TextUtils;

import com.mindorks.framework.mvvm.data.DataManager;
import com.mindorks.framework.mvvm.data.model.api.LoginRequest;
import com.mindorks.framework.mvvm.ui.base.BaseViewModel;
import com.mindorks.framework.mvvm.ui.feed.opensource.OpenSourceItemViewModel;
import com.mindorks.framework.mvvm.utils.CommonUtils;
import com.mindorks.framework.mvvm.utils.rx.SchedulerProvider;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by amitshekhar on 08/07/17.
 */

public class SearchResultViewModel extends BaseViewModel<SearchResultNavigator> {

    private MutableLiveData<List<TransactionHistoryItemViewModel>> transactionHistoryItemsLiveData;

    public SearchResultViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public LiveData<List<TransactionHistoryItemViewModel>> getTransactionHistoryItemsLiveData() {
        return transactionHistoryItemsLiveData;
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public void onServerLoginClick() {
        getNavigator().openMainActivity();
    }
}