package com.example.mvvmdemo.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mvvmdemo.model.Users;

public class UserViewModel extends BaseObservable {
    private Users users;


    private String successMessage = "Login Successfull";
    private String errorMessage = "Error in login";

    @Bindable
    private String toastMessage = null;

    public String getToastMessage(){
        return toastMessage;
    }

    public void setToastMessage(String toastMessage){
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getViewModelEmailId(){
        return users.getEmailId();
    }

    public void setViewModelEmailId(String emailId){
        users.setEmailId(emailId);
        notifyPropertyChanged(BR.viewModelEmailId);
    }

    @Bindable
    public String getViewModelPassword(){
        return users.getPassword();
    }

    public void setViewModelPassword(String password){
        users.setPassword(password);
        notifyPropertyChanged(BR.viewModelPassword);
    }

    public UserViewModel() {
        users = new Users("","");
    }

    public void onLoginClicked(){

        if(isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);

    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getViewModelEmailId()) && Patterns.EMAIL_ADDRESS.matcher(getViewModelEmailId()).matches() && getViewModelPassword().length() > 5;
    }
}
