package com.bor96dev.hwflow

import com.bor96dev.hwflow.data.AsiaDataSource
import com.bor96dev.hwflow.data.EuropeDataSource
import com.bor96dev.hwflow.data.NorthAmericaDataSource
import com.bor96dev.hwflow.data.RepositoryImpl
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest: BehaviorSpec( {
    val testDispatcher = UnconfinedTestDispatcher()

    beforeSpec {
        Dispatchers.setMain(testDispatcher)
    }

    afterSpec {
        Dispatchers.resetMain()
    }

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