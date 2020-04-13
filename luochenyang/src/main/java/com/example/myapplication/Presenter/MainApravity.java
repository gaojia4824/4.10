package com.example.myapplication.Presenter;

import com.example.myapplication.Molder.DataModele;
import com.example.myapplication.View.MainAView;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.text.Akk;

public class MainApravity extends BasePresenter<MainAView> {

    private DataModele mModele;

    @Override
    protected void into() {
       mModele = new DataModele();
    }

    public void ll() {

   }
}
