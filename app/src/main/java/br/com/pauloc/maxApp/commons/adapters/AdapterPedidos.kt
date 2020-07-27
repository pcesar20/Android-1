package br.com.pauloc.maxApp.commons.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.pauloc.maxApp.R
import br.com.pauloc.maxApp.modelos.Pedido
import org.jetbrains.anko.backgroundResource

class AdapterPedidos(val dataSet: List<Pedido>) :
    RecyclerView.Adapter<AdapterPedidos.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numeroPedido = itemView.findViewById<TextView>(R.id.txtNumeroPedido)
        val infoCliente = itemView.findViewById<TextView>(R.id.txtNumeroCliente)
        val data = itemView.findViewById<TextView>(R.id.txtDataHora)
        val status = itemView.findViewById<TextView>(R.id.txtStatusPedido)
        val imagemCritica = itemView.findViewById<ImageView>(R.id.imgTipoCritica)
        val labelCritica = itemView.findViewById<TextView>(R.id.labelCritica)
        val imagemLegenda = itemView.findViewById<ImageView>(R.id.imgLegenda)
        val imagemTipoPedido = itemView.findViewById<ImageView>(R.id.imgTipoPedido)
        val textoTipoPedido = itemView.findViewById<TextView>(R.id.txtTipoPedido)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_pedido_item, parent, false)
        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedidoAtual = dataSet[position]
        holder.numeroPedido.text = "${pedidoAtual.numero_ped_Rca}/${pedidoAtual.numero_ped_Rca}"
        holder.infoCliente.text = "${pedidoAtual.codigoCliente} - ${pedidoAtual.NOMECLIENTE}"
        holder.status.text = pedidoAtual.status
        holder.data.text = pedidoAtual.data
        holder.data.text = pedidoAtual.data
        pedidoAtual.critica?.let {

            holder.imagemCritica.setImageResource(
                when (pedidoAtual.critica) {
                    "AGUARDANDO" -> R.drawable.ic_maxima_aguardando_critica
                    "FALHA_PARCIAL" -> R.drawable.ic_maxima_critica_alerta
                    "SUCESSO" -> R.drawable.ic_maxima_critica_sucesso
                    else -> R.drawable.ic_maxima_critica_sucesso
                }
            )
            holder.labelCritica.visibility = View.VISIBLE
            holder.imagemCritica.visibility = View.VISIBLE
        }

        /* Legendas */
        pedidoAtual.legendas?.let {
            it.forEach { legenda ->
                holder.imagemLegenda.setImageResource(
                    when (legenda) {
                        "PEDIDO_CANCELADO_ERP" -> R.drawable.ic_maxima_legenda_cancelamento
                        "PEDIDO_DEVOLVIDO" -> R.drawable.ic_maxima_legenda_devolucao
                        "PEDIDO_EM_FALTA" -> R.drawable.ic_maxima_legenda_falta
                        "PEDIDO_FEITO_TELEMARKETING" -> R.drawable.ic_maxima_legenda_telemarketing
                        "PEDIDO_SOFREU_CORTE" -> R.drawable.ic_maxima_legenda_corte
                        else -> R.drawable.ic_maxima_legenda_corte
                    }
                )
            }
            holder.imagemLegenda.visibility = View.VISIBLE
        }

        /* Status dos Pedidos*/
        if (pedidoAtual.status.toLowerCase().equals("em processamento")) {
            holder.imagemTipoPedido.setImageResource(R.drawable.ic_maxima_em_processamento)
            holder.imagemTipoPedido.backgroundResource = R.color.cor_status_em_processamento
            holder.imagemTipoPedido.visibility = View.VISIBLE
        } else {
            holder.textoTipoPedido.text = pedidoAtual.tipo[0].toString()
            holder.textoTipoPedido.visibility = View.VISIBLE
            when (pedidoAtual.status.toLowerCase()) {
                "BLOQUEADO" -> holder.textoTipoPedido.backgroundResource =
                    R.color.cor_status_bloqueado
                "CANCELADO" -> holder.textoTipoPedido.backgroundResource =
                    R.color.cor_status_cancelado
                "EM ORÇAMENTO" -> holder.textoTipoPedido.backgroundResource =
                    R.color.cor_status_em_orcamento
                "FATURADO" -> holder.textoTipoPedido.backgroundResource =
                    R.color.cor_status_faturado
                "LIBERADO" -> holder.textoTipoPedido.backgroundResource =
                    R.color.cor_status_liberado
                "MONTADO" -> holder.textoTipoPedido.backgroundResource = R.color.cor_status_montado
                "PENDENTE" -> holder.textoTipoPedido.backgroundResource =
                    R.color.cor_status_pendente
                "RECUSADO" -> {
                    holder.textoTipoPedido.backgroundResource = R.color.cor_status_recusado
                    holder.textoTipoPedido.text = "!"
                }
                else -> holder.textoTipoPedido.backgroundResource = R.color.colorPrimaryDark
            }
        }

    }

}