package com.roli.indriveclone.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel(){
    var state by mutableStateOf(RegisterState())
        private set
    var errorMessage by mutableStateOf("")
    fun register(){
        if(isValidForm()){
            Log.d("RegisterViewModel","Name: ${state.name}");
            Log.d("RegisterViewModel","LastName: ${state.lastname}");
            Log.d("RegisterViewModel","Email: ${state.email}");
            Log.d("RegisterViewModel","Phone: ${state.phone}");
            Log.d("RegisterViewModel","Password: ${state.password}");
            Log.d("RegisterViewModel","ConfirmPassword: ${state.confirmPassword}");
        }
    }
    fun onNameInput(name: String){
        state=state.copy(name=name)
    }
    fun onLastNameInput(lastName: String){
        state=state.copy(lastname = lastName)
    }
    fun onEmailInput(email: String){
        state=state.copy(email=email)
    }
    fun onPhoneInput(phone: String){
        state=state.copy(phone=phone)
    }
    fun onPasswordInput(password: String){
        state=state.copy(password=password)
    }
    fun onConfirmPasswordInput(confirmPassword: String){
        state=state.copy(confirmPassword=confirmPassword)
    }
    fun isValidForm(): Boolean{
        errorMessage="";
        if(state.name.isEmpty()){
            errorMessage="Introduzca el Nombre";
            return false
        }
        else if(state.lastname.isEmpty()){
            errorMessage="Introduzca el Apellido";
            return false
        }
        else if(state.email.isEmpty()){
            errorMessage="Introduzca el Email";
            return false
        }
        else if(state.phone.isEmpty()){
            errorMessage="Introduzca el Telefono";
            return false
        }
        else if(state.password.isEmpty()){
            errorMessage="Introduzca el Password";
            return false
        }
        else if(state.name.isEmpty()){
            errorMessage="Introduzca la Confirmación del Password";
            return false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage="El email no es valido";
            return false
        }
        else if(state.password.length<6){
            errorMessage="El password debe tener al menos 6 caracteres";
            return false
        }
        else if(!state.password.equals(state.confirmPassword)){
            errorMessage="Las contraseñas no coinciden";
            return false
        }
        return true;
    }
}