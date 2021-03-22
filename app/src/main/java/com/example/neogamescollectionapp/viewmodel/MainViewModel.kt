package com.example.neogamescollectionapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neogamescollectionapp.services.repository.UserRepository

class MainViewModel : ViewModel(){
    var mutableResultString = MutableLiveData<String>()
    val resultString : LiveData<String> = mutableResultString

    fun loginAction(user: String, password: String) {
        if(user.isEmpty()){
            if(password.isEmpty()){
                mutableResultString.value = "Todos os campos estão vazios"
            } else {
                mutableResultString.value = "O campo do usuário está vazio"
            }
        } else {
            if(password.isEmpty()){
                mutableResultString.value = "O campo da senha está vazio"
            } else {
                if(UserRepository.instance.userExists(user)){
                    if(UserRepository.instance.passwordCorrect(user, password)){
                        mutableResultString.value = "Sucesso"
                    } else {
                        mutableResultString.value = "Senha incorreta"
                    }
                } else {
                    mutableResultString.value = "Usuário inexistente"
                }
            }
        }
    }

    fun clearResultString(){
        mutableResultString.value = ""
    }

}