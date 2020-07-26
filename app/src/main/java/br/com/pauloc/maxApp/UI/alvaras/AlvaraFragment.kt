package br.com.pauloc.maxApp.UI.fragments.alvaras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.pauloc.maxApp.R

class AlvaraFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity!!.setTitle(R.string.screen_alvaras)
        return inflater.inflate(R.layout.fragment_alvaras, container, false)
    }
}