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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.mindorks.framework.mvvm.BR;
import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.ViewModelProviderFactory;
import com.mindorks.framework.mvvm.databinding.ActivitySearchResultBinding;
import com.mindorks.framework.mvvm.ui.base.BaseActivity;
import com.mindorks.framework.mvvm.ui.main.MainActivity;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

/**
 * Created by amitshekhar on 08/07/17.
 */

public class SearchResultActivity extends BaseActivity<ActivitySearchResultBinding, SearchResultViewModel> implements SearchResultNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private SearchResultViewModel mLoginViewModel;
    private ActivitySearchResultBinding mActivitySearchResultBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, SearchResultActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search_result;
    }

    @Override
    public SearchResultViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this,factory).get(SearchResultViewModel.class);
        return mLoginViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(SearchResultActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySearchResultBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
    }
}
