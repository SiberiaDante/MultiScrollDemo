package com.siberiadante.multiscrolldemo.adapter;


import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.siberiadante.multiscrolldemo.R;
import com.siberiadante.multiscrolldemo.bean.MineQuestionBean;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/12/15
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class MineQuestionAdapter extends RecyclerArrayAdapter<MineQuestionBean> {
    public MineQuestionAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new QuestionViewHolder(parent);
    }

    public class QuestionViewHolder extends BaseViewHolder<MineQuestionBean> {

        TextView textView;

        public QuestionViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_mine_question);
            textView = $(R.id.tv_title);
        }

        @Override
        public void setData(MineQuestionBean data) {
            super.setData(data);
            textView.setText(data.getContent());
        }
    }
}
