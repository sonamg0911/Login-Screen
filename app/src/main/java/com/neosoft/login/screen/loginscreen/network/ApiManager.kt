package com.neosoft.login.screen.loginscreen.network

class ApiManager private constructor(){

    private val apiClient = ApiService.create()

    companion object {

        private val apiManager:ApiManager = ApiManager()

        fun getInstance():ApiManager{
            return apiManager
        }
    }


}