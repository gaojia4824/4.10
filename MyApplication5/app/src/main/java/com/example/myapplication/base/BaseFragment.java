package com.example.myapplication.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends BaseView, P extends BasePresent<T>, T> extends Fragment implements BaseView<T> {
    private Unbinder unbinder;
    private P mPresenter;
    private V mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        View view = null;
        if (layoutId != 0)
            view = inflater.inflate(layoutId, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        if (mPresenter == null)
            mPresenter = createPresenter();

        if (mView == null)
            mView = createView();
        initInject();
    }

    protected abstract void initInject();

    protected abstract V createView();

    protected abstract P createPresenter();

    protected abstract int getLayoutId();


    public V getmView() {
        if (mView != null)
            return mView;
        return null;
    }

    public P getmPresenter() {
        if (mPresenter != null)
            return mPresenter;
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
