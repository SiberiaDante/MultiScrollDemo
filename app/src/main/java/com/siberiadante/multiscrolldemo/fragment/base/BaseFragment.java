package com.siberiadante.multiscrolldemo.fragment.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/12/5
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public abstract class BaseFragment extends Fragment {
    public static final String TAG = BaseFragment.class.getSimpleName();

    public Activity mActivity;
    public Unbinder unbinder;
    private View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, view);
            initViews(view, savedInstanceState);
            initData();
        }
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initViews(View view, @Nullable Bundle savedInstanceState);

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.view = null;
    }
}
