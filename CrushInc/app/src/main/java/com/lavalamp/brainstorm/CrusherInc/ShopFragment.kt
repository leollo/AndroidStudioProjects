package com.lavalamp.brainstorm.CrusherInc

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ShopFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View? {
        var myView: View= inflater.inflate(R.layout.shop, container, false)
        return myView
    }
}
