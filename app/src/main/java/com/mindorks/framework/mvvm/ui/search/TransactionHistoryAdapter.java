///*
// *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
// *
// *  Licensed under the Apache License, Version 2.0 (the "License");
// *  you may not use this file except in compliance with the License.
// *  You may obtain a copy of the License at
// *
// *      https://mindorks.com/license/apache-v2
// *
// *  Unless required by applicable law or agreed to in writing, software
// *  distributed under the License is distributed on an "AS IS" BASIS,
// *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *  See the License for the specific language governing permissions and
// *  limitations under the License
// */
//
//package com.mindorks.framework.mvvm.ui.search;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.mindorks.framework.mvvm.data.model.api.BlogResponse;
//import com.mindorks.framework.mvvm.databinding.ItemBlogEmptyViewBinding;
//import com.mindorks.framework.mvvm.databinding.ItemBlogViewBinding;
//import com.mindorks.framework.mvvm.ui.base.BaseViewHolder;
//import com.mindorks.framework.mvvm.ui.feed.blogs.BlogEmptyItemViewModel;
//import com.mindorks.framework.mvvm.ui.feed.blogs.BlogItemViewModel;
//import com.mindorks.framework.mvvm.utils.AppLogger;
//
//
//import java.util.List;
//
//import androidx.recyclerview.widget.RecyclerView;
//
///**
// * Created by amitshekhar on 10/07/17.
// */
//
//public class TransactionHistoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {
//
//    public static final int VIEW_TYPE_EMPTY = 0;
//
//    public static final int VIEW_TYPE_NORMAL = 1;
//
//    private List<BlogResponse.Blog> mBlogResponseList;
//
//
//    public TransactionHistoryAdapter(List<BlogResponse.Blog> blogResponseList) {
//        this.mBlogResponseList = blogResponseList;
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mBlogResponseList != null && mBlogResponseList.size() > 0) {
//            return mBlogResponseList.size();
//        } else {
//            return 1;
//        }
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (mBlogResponseList != null && !mBlogResponseList.isEmpty()) {
//            return VIEW_TYPE_NORMAL;
//        } else {
//            return VIEW_TYPE_EMPTY;
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(BaseViewHolder holder, int position) {
//        holder.onBind(position);
//    }
//
//    @Override
//    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//
//
//        ItemBlogEmptyViewBinding emptyViewBinding = ItemBlogEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
//                parent, false);
//        return new EmptyViewHolder(emptyViewBinding);
//
//
//    }
//
//    public void addItems(List<BlogResponse.Blog> blogList) {
//        mBlogResponseList.addAll(blogList);
//        notifyDataSetChanged();
//    }
//
//    public void clearItems() {
//        mBlogResponseList.clear();
//    }
//
//
//    public interface BlogAdapterListener {
//
//        void onRetryClick();
//    }
//
//    public class EmptyViewHolder extends BaseViewHolder  {
//
//        private ItemBlogViewBinding mBinding;
//
//        private BlogItemViewModel mBlogItemViewModel;
//
//        public EmptyViewHolder(ItemBlogViewBinding binding) {
//            super(binding.getRoot());
//            this.mBinding = binding;
//        }
//
//        @Override
//        public void onBind(int position) {
//            final BlogResponse.Blog blog = mBlogResponseList.get(position);
////            mBlogItemViewModel = new BlogItemViewModel(blog, this);
////            mBinding.setViewModel(mBlogItemViewModel);
//
//            // Immediate Binding
//            // When a variable or observable changes, the binding will be scheduled to change before
//            // the next frame. There are times, however, when binding must be executed immediately.
//            // To force execution, use the executePendingBindings() method.
//            mBinding.executePendingBindings();
//        }
//
//
//    }
//
//
//}