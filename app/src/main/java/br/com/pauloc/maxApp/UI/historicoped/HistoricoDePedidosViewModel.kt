package br.com.pauloc.maxApp.UI.fragments.historicoped

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.pauloc.maxapp.repositorios.AppRepo

class HistoricoDePedidosViewModel(application: Application): AndroidViewModel(application){

    private val appRepository = AppRepo(application)

    init {
        appRepository.getRequestsFromServer()
    }

    fun getAllResquests() = appRepository.getAllRequests()
}