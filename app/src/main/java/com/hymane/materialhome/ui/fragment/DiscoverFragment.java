package com.hymane.materialhome.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.hymanme.tagflowlayout.OnTagClickListener;
import com.github.hymanme.tagflowlayout.TagAdapter;
import com.github.hymanme.tagflowlayout.TagFlowLayout;
import com.github.hymanme.tagflowlayout.tags.ColorfulTagView;
import com.github.hymanme.tagflowlayout.tags.DefaultTagView;
import com.hymane.materialhome.R;
import com.hymane.materialhome.api.presenter.IEBookPresenter;
import com.hymane.materialhome.api.presenter.impl.EBookPresenterImpl;
import com.hymane.materialhome.api.presenter.impl.HotSearchPresenterImpl;
import com.hymane.materialhome.api.view.IEBookListView;
import com.hymane.materialhome.api.view.IHotSearchView;
import com.hymane.materialhome.bean.http.douban.HotSearchResponse;
import com.hymane.materialhome.bean.http.ebook.HotWords;
import com.hymane.materialhome.ui.activity.CaptureActivity;
import com.hymane.materialhome.ui.activity.ESearchResultActivity;
import com.hymane.materialhome.ui.activity.MainActivity;
import com.hymane.materialhome.ui.activity.SearchResultActivity;
import com.hymane.materialhome.utils.common.PermissionUtils;
import com.hymane.materialhome.utils.common.UIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author   :hymanme
 * Email    :hymanme@163.com
 * Create at 2016/9/14
 * Description:
 */
public class DiscoverFragment extends BaseFragment implements IEBookListView {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_widget)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private LinearLayoutManager mLayoutManager;
    private DiscoverAdapter mDiscoverAdapter;
    private IEBookPresenter mHotSearchPresenter;
    private List<String> mTags;
    private int type;//0:douban,1:ebook

    public static DiscoverFragment newInstance(int type) {

        Bundle args = new Bundle();
        args.putInt("type", type);

        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.recycler_content, null, false);
        type = getArguments().getInt("type");
        mHotSearchPresenter = new EBookPresenterImpl(this);
    }

    @Override
    protected void initEvents() {
        mSwipeRefreshLayout.setEnabled(false);
        //?????????????????????
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //??????adapter
        mDiscoverAdapter = new DiscoverAdapter(type);
        mRecyclerView.setAdapter(mDiscoverAdapter);

        //??????Item?????????????????????
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void initData(boolean isSavedNull) {
        mTags = new ArrayList<>();
        if (type == 0) {
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("?????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("?????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("?????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("?????????");
            mTags.add("????????????");
            mTags.add("????????????");
            mTags.add("?????????");
            mTags.add("?????????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("????????????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("?????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("?????????");
            mTags.add("?????????????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????????????????");
            mTags.add("????????????");
            mTags.add("?????????");
            mTags.add("?????????");
            mTags.add("?????????");
            mTags.add("?????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("?????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("???????????????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("BL");
            mTags.add("??????");
            mTags.add("????????????");
            mTags.add("??????");
            mTags.add("??????");
        } else {
            mHotSearchPresenter.getHotWord();
        }
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void refreshData(Object result) {
        if (result instanceof HotWords) {
            final String[] hotWords = ((HotWords) result).getHotWords();
            mTags.clear();
            mTags.addAll(Arrays.asList(hotWords));
            mDiscoverAdapter.notifyItemChanged(1);
        }
    }

    class DiscoverAdapter extends RecyclerView.Adapter {
        private static final int TYPE_SEARCH_HEADER = 0;
        private static final int TYPE_HOT_SEARCH = 1;
        private int type;//0:douban,1:ebook

        public DiscoverAdapter(int type) {
            this.type = type;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType == TYPE_SEARCH_HEADER) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_search, parent, false);
                return new SearchHeaderHolder(view);
            } else {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot_search, parent, false);
                return new HotSearchHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof HotSearchHolder) {
                //????????????(?????????????????????)
                ((HotSearchHolder) holder).tagFlowLayout.setTagListener(new OnTagClickListener() {
                    @Override
                    public void onClick(TagFlowLayout parent, View view, int position) {
                        Intent intent;
                        if (type == 0) {
                            intent = new Intent(UIUtils.getContext(), SearchResultActivity.class);
                        } else {
                            intent = new Intent(UIUtils.getContext(), ESearchResultActivity.class);
                            intent.putExtra("type", 0);
                        }
                        intent.putExtra("q", mTags.get(position));
                        UIUtils.startActivity(intent);
                    }

                    @Override
                    public void onLongClick(TagFlowLayout parent, View view, int position) {
                    }
                });
                TagAdapter<String> tagAdapter = new TagAdapter<String>() {

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        //??????tag????????????????????????????????????????????????????????????????????????
                        DefaultTagView textView = new ColorfulTagView(UIUtils.getContext());
                        textView.setText((String) getItem(position));
                        return textView;
                    }
                };
                //??????adapter
                ((HotSearchHolder) holder).tagFlowLayout.setTagAdapter(tagAdapter);

                //???adapter????????????
                tagAdapter.addAllTags(mTags);
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return TYPE_SEARCH_HEADER;
            } else {
                return TYPE_HOT_SEARCH;
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    class SearchHeaderHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_search)
        TextView tv_search;
        @BindView(R.id.iv_scan)
        ImageView iv_scan;

        public SearchHeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            tv_search.setOnClickListener(this);
            iv_scan.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tv_search) {
                ((MainActivity) getActivity()).showSearchView();
            } else if (v.getId() == R.id.iv_scan) {
                if (PermissionUtils.requestCameraPermission(getActivity())) {
                    UIUtils.startActivity(new Intent(UIUtils.getContext(), CaptureActivity.class));
                }
            }
        }
    }

    class HotSearchHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tag_flow_layout)
        TagFlowLayout tagFlowLayout;

        public HotSearchHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
