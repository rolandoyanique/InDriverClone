package com.roli.indriveclone.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")
    fun onEmailInput(email: String){
        state=state.copy(email=email)
    }
    fun onPasswordInput(password: String){
        state=state.copy(password=password)
    }
    fun login(){
        if(isValidForm()){
            Log.d("LoginViewModel","Email ${state.email}");
            Log.d("LoginViewModel","Password ${state.password}");
        }
    }
    fun isValidForm(): Boolean{
        errorMessage="";
        if (state.email.isEmpty()){
            errorMessage="Ingresa el Email"
            return false;
        }else if (state.password.isEmpty()){
            errorMessage="Ingresa el Password"
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage="El Email no es Valido"
            return false;
        }else if (state.password.length<6){
            errorMessage="El password debe tener al menos 6 caracteres"
            return false;
        }
        return true;
    }
}