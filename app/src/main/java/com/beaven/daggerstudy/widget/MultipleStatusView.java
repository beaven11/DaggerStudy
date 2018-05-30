package com.beaven.daggerstudy.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.beaven.daggerstudy.R;

public class MultipleStatusView extends FrameLayout {

    private static final String TAG = "MultipleStatusView";

    private static final LayoutParams DEFAULT_LAYOUT_PARAMS =
            new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

    private int emptyViewResId;
    private int errorViewResId;
    private int loadingViewResId;
    private int contentViewResId;

    private LayoutInflater inflater;
    private SparseArray<View> viewArray = new SparseArray<>();

    public MultipleStatusView(Context context) {
        this(context, null);
    }

    public MultipleStatusView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray a =
                context.obtainStyledAttributes(attrs, R.styleable.MultipleStatusView, defStyleAttr,
                        0);
        emptyViewResId =
                a.getResourceId(R.styleable.MultipleStatusView_emptyView, R.layout.view_load_empty);
        errorViewResId =
                a.getResourceId(R.styleable.MultipleStatusView_errorView, R.layout.view_load_error);
        loadingViewResId = a.getResourceId(R.styleable.MultipleStatusView_loadingView,
                R.layout.view_load_loading);
        a.recycle();

        inflater = LayoutInflater.from(getContext());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, "onFinishInflate: child count--" + getChildCount());
        if (getChildCount() == 0) {
            return;
        }
        if (getChildCount() > 1) {
            throw new IllegalArgumentException("There can be only one child view");
        }
        View view = getChildAt(0);
        contentViewResId = view.getId();
        viewArray.put(contentViewResId, view);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        viewArray.clear();
        inflater = null;
    }

    public void showContent() {
        showView(contentViewResId);
    }

    public void showEmpty() {
        showView(emptyViewResId);
    }

    public void showError() {
        showView(errorViewResId);
    }

    public void showLoading() {
        showView(loadingViewResId);
    }

    private void showView(int viewId) {
        View view = inflate(viewId);
        if (null == view) {
            throw new NullPointerException("inflate view is null");
        }
        if (view.getVisibility() == VISIBLE) {
            return;
        }
        for (int i = 0; i < viewArray.size(); i++) {
            View childView = viewArray.valueAt(i);
            childView.setVisibility(GONE);
        }
        view.setVisibility(VISIBLE);
    }

    private View inflate(int viewId) {
        View view = viewArray.get(viewId);
        if (view != null) {
            return view;
        }
        View layoutView = inflater.inflate(viewId, this, false);
        layoutView.setVisibility(GONE);
        addView(layoutView, DEFAULT_LAYOUT_PARAMS);
        viewArray.put(viewId, layoutView);
        return layoutView;
    }
}
