package br.com.pauloc.maxApp.repositorios

import android.content.Context
import br.com.pauloc.maxApp.API.ApiSrvc
import br.com.pauloc.maxApp.DB.AppDB
import br.com.pauloc.maxApp.modelos.TempCliente
import br.com.pauloc.maxApp.modelos.TempPedidos
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AppRepo(val context: Context) {
    val db = AppDB.getInstance(context)
    fun getAllRequests() = db.maxAppDao().getAllLiveRequests()
    fun getClientInfo() = db.maxAppDao().getLiveClient()
    fun getClientFromServer() {
        val request = ApiSrvc.getEndPoints()
        request.getClientInfo().enqueue(object : Callback<TempCliente> {
            override fun onFailure(call: Call<TempCliente>, t: Throwable) {
            }

            override fun onResponse(call: Call<TempCliente>, response: Response<TempCliente>) {
                if (response.code() == 200) {
                    val resultado = response.body()
                    resultado?.let { temp ->
                        doAsync {
                            db.maxAppDao().addClient(temp.cliente)
                        }
                    }

                }
            }
        })
    }

    fun getRequestsFromServer() {
        val request = ApiSrvc.getEndPoints()
        request.getAllRequests().enqueue(object : Callback<TempPedidos> {
            override fun onFailure(call: Call<TempPedidos>, t: Throwable) {
            }

            override fun onResponse(call: Call<TempPedidos>, response: Response<TempPedidos>) {
                if (response.code() == 200) {
                    val resultado = response.body()
                    resultado?.let { temp ->
                        val lista = temp.pedidos
                        lista?.forEach {
                            doAsync {
                                db.maxAppDao().addRequest(it)
                            }
                        }
                    }
                }
            }
        })
    }
}

private fun Any.enqueue(callback: Callback<TempCliente>) {

}

private fun <T> Call<T>.enqueue(callback: Callback<TempPedidos>) {

}


