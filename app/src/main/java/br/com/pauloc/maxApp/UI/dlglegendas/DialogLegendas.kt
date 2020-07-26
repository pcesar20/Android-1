package br.com.pauloc.maxApp.UI.fragments.dlglegendas

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import br.com.pauloc.maxApp.R
import org.jetbrains.anko.layoutInflater

class DialogLegendas : AppCompatDialogFragment() {

    lateinit var customView: View;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return customView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        customView = context!!.layoutInflater.inflate(R.layout.fragment_legendas, null)
        return AlertDialog.Builder(context!!).setView(customView).setNegativeButton("Fechar", null).create()
    }
}