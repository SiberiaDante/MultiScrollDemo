package com.siberiadante.multiscrolldemo.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.siberiadante.multiscrolldemo.R;
import com.siberiadante.multiscrolldemo.adapter.MineArticleAdapter;
import com.siberiadante.multiscrolldemo.bean.MineArticleBean;
import com.siberiadante.multiscrolldemo.fragment.base.LazyFragment;
import com.siberiadante.multiscrolldemo.view.NormalDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/12/14
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class ArticleFragment extends LazyFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private MineArticleAdapter adapter;

    public static ArticleFragment getInstance() {
        return new ArticleFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void lazyInitView(View view, Bundle savedInstanceState) {
        final List<MineArticleBean> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final MineArticleBean articleBean = new MineArticleBean();
            articleBean.setContent("使用NestedScrollView+ViewPager+RecyclerView+SmartRefreshLayout打造酷炫下拉视差效果并解决各种滑动冲突" + i);
            data.add(articleBean);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
//        linearLayoutManager.setSmoothScrollbarEnabled(true);
//        linearLayoutManager.setAutoMeasureEnabled(true);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new NormalDecoration(ContextCompat.getColor(mActivity, R.color.mainGrayF8), (int) mActivity.getResources().getDimension(R.dimen.one)));

        adapter = new MineArticleAdapter(mActivity);
        recyclerView.setAdapter(adapter);
        adapter.addAll(data);
        adapter.setNoMore(R.layout.view_no_more);
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                Log.d(TAG, "----onMoreShow");
                adapter.addAll(data);
            }

            @Override
            public void onMoreClick() {

            }
        });

    }

}
