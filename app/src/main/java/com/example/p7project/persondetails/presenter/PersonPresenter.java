package com.example.p7project.persondetails.presenter;

import com.example.p7project.bean.ShouBean;
import com.example.p7project.persondetails.contract.PersonContract;
import com.example.p7project.persondetails.model.PersonModel;
import com.example.p7project.utils.CallBack;

public class PersonPerson implements PersonContract.IPersonDetails {
    private final PersonModel personModel;
    private PersonContract.IView view;

    public PersonPerson(PersonContract.IView view) {
        this.view = view;
        personModel = new PersonModel();
    }

    @Override
    public void getPerson() {
        personModel.getPersonModel("index", new CallBack<ShouBean>() {
            @Override
            public void OnSuccess(ShouBean shouBean) {
                view.onPerSuccess(shouBean);
            }

            @Override
            public void OnFail(String error) {
                view.onPerFail("错误"+error);
            }
        });
    }
}
