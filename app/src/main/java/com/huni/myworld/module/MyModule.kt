package com.huni.myworld.module

import com.huni.myworld.model.DataModel
import com.huni.myworld.model.DataModelImpl
import com.huni.myworld.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

var modelPart = module {
    factory<DataModel> {
        DataModelImpl()
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var myDiModule = listOf(modelPart, viewModelPart)