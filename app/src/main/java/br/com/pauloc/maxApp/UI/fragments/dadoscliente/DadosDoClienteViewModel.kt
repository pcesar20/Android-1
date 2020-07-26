package br.com.pauloc.maxApp.UI.fragments.dadoscliente

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.pauloc.maxApp.repositorios.AppRepo

class DadosDoClienteViewModel(application: Application): AndroidViewModel(application){

    private val appRepository = AppRepo(application)

    init {
        /* Sempre que o fragment de Dados do cliente for inicializado,
        * uma consulta será feita no servidor pegando os dados e adicionando
        * ao banco de dados local
        * */
        appRepository.getClientFromServer()
    }

    /* Busca a lista de pedidos armazenados no banco de dados local*/
    fun getClientInfo() = appRepository.getClientInfo()
}