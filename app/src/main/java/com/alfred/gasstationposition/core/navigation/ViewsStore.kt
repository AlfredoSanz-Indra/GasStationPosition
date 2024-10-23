package com.alfred.gasstationposition.core.navigation

import com.alfred.gasstationposition.core.log.Klog
import com.alfred.gasstationposition.ui.view.MainView

/**
 * @author Alfredo Sanz
 * @time 2023
 */
object ViewsStore {

    private var mainView: MainView? = null

    fun getMainView(): MainView {
        if(mainView == null) {
            Klog.line("ViewsStore", "getMainView", "creating MainView!")
            mainView = MainView()
        }
        return mainView!!
    }


    fun cleanLoggedViews() {
        mainView = null
    }
}