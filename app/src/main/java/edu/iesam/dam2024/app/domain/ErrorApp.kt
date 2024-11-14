package edu.iesam.dam2024.app.domain

sealed class ErrorApp : Throwable(){
    object InternetErrorApp : ErrorApp()
    object ServerErrorApp: ErrorApp()
    object DataErrorApp: ErrorApp()
    object UnknowErrorApp: ErrorApp()
}