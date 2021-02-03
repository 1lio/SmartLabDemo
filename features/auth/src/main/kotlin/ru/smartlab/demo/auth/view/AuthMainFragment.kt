package ru.smartlab.demo.auth.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.smartlab.demo.auth.R

class AuthMainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        super.onCreateView(inflater, group, state)

        val v = inflater.inflate(R.layout.auth_main, group, false)

        return v
    }

}