package com.huni.myworld.ui

import com.huni.myworld.R
import com.huni.myworld.base.BaseKotlinActivity
import com.huni.myworld.databinding.ActivityMainBinding
import com.huni.myworld.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseKotlinActivity<ActivityMainBinding, MainViewModel>() {
    private val TAG: String = MainActivity::class.java.simpleName

    override val layoutResourceId: Int
        get() = R.layout.activity_main
//    override val viewModel: MainViewModel()
    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }
}