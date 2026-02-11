package com.bor96dev.hwflow

import com.bor96dev.hwflow.data.AsiaDataSource
import com.bor96dev.hwflow.data.EuropeDataSource
import com.bor96dev.hwflow.data.NorthAmericaDataSource
import com.bor96dev.hwflow.data.RepositoryImpl
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe


class MainViewModelTest: BehaviorSpec( {
    Given("MainViewModel c datasources") {
        val repository = RepositoryImpl(
            asia = AsiaDataSource(),
            europe = EuropeDataSource(),
            america = NorthAmericaDataSource()
        )
        When ("ViewModel создается"){
            val viewModel = MainViewModel(repository)

            Then("список стран должен быть заполнен"){
                viewModel.countries.size shouldBe 21
            }
        }
    }
})