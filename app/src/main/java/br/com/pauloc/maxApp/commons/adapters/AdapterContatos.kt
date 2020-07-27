package br.com.pauloc.maxApp.commons.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.pauloc.maxApp.modelos.Contato
import br.com.pauloc.maxApp.R



class AdapterContatos(val dataSet: List<Contato>) : RecyclerView.Adapter<AdapterContatos.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_contatos_item, parent, false)
        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contatoAtual = dataSet[position]

        holder.textoNome.text = contatoAtual.nome
        holder.textoTelefone.text = contatoAtual.telefone
        holder.textoCelular.text = contatoAtual.celular
        holder.textoConjugue.text = contatoAtual.conjuge
        holder.textoTipo.text = contatoAtual.tipo
        holder.textoEmail.text = contatoAtual.e_mail
        holder.textoNascimento.text = contatoAtual.data_nascimento
        holder.textoNascConjugue.text = contatoAtual.dataNascimentoConjuge
        holder.textoTime.text = contatoAtual.time
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textoNome = itemView.findViewById<TextView>(R.id.txtNomeContato)
        val textoTelefone = itemView.findViewById<TextView>(R.id.txtTelefone)
        val textoCelular = itemView.findViewById<TextView>(R.id.txtCelular)
        val textoConjugue = itemView.findViewById<TextView>(R.id.txtNomeConjugue)
        val textoTipo = itemView.findViewById<TextView>(R.id.txtTipo)
        val textoHobbie = itemView.findViewById<TextView>(R.id.txtHobbie)
        val textoEmail = itemView.findViewById<TextView>(R.id.txtEmail)
        val textoNascimento = itemView.findViewById<TextView>(R.id.txtDataNascimento)
        val textoNascConjugue = itemView.findViewById<TextView>(R.id.txtDataNascConjugue)
        val textoTime = itemView.findViewById<TextView>(R.id.txtTime)
    }

}