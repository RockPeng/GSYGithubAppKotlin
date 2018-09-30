package com.shuyu.github.kotlin.module.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation

/**
 * Created by guoshuyu
 * Date: 2018-09-30
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainView = inflater.inflate(getLayoutId(), container, false)
        onCreateView(mainView)
        return mainView
    }

    abstract fun onCreateView(mainView: View)

    abstract fun getLayoutId(): Int


    fun navigationPopUpTo(view: View, args: Bundle?, actionId: Int, finishStack: Boolean) {
        val controller = Navigation.findNavController(view)
        controller.navigate(actionId,
                args, NavOptions.Builder().setPopUpTo(controller.graph.id, true).build())
        if (finishStack) {
            activity?.finish()
        }
    }

}