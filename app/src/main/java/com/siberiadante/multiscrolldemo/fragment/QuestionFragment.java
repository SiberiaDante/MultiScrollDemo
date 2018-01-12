package com.siberiadante.multiscrolldemo.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.siberiadante.multiscrolldemo.R;
import com.siberiadante.multiscrolldemo.adapter.MineQuestionAdapter;
import com.siberiadante.multiscrolldemo.bean.MineQuestionBean;
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

public class QuestionFragment extends LazyFragment {
    public static final String TAG = QuestionFragment.class.getSimpleName();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    //    @BindView(R.id.refreshLayout)
//    SmartRefreshLayout refreshLayout;
    private MineQuestionAdapter adapter;

    public static QuestionFragment getInstance() {
        return new QuestionFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_question;
    }

    @Override
    public void lazyInitView(View view, Bundle savedInstanceState) {


        final List<MineQuestionBean> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final MineQuestionBean questionBean = new MineQuestionBean();
            questionBean.setContent("使用NestedScrollView+ViewPager+RecyclerView+SmartRefreshLayout打造酷炫下拉视差效果并解决各种滑动冲突" + i);
            data.add(questionBean);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.addItemDecoration(new NormalDecoration(ContextCompat.getColor(mActivity, R.color.mainGrayF8), (int) mActivity.getResources().getDimension(R.dimen.eight)));

        adapter = new MineQuestionAdapter(mActivity);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mActivity, "---position---" + position, Toast.LENGTH_SHORT).show();
            }
        });
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
    @Override
    protected void initData() {

    }
}
