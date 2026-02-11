package com.bor96dev.hwflow

import com.bor96dev.hwflow.data.AsiaDataSource
import com.bor96dev.hwflow.data.EuropeDataSource
import com.bor96dev.hwflow.data.NorthAmericaDataSource
import com.bor96dev.hwflow.data.RepositoryImpl
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import kotlinx.coroutines.flow.toList

class RepositoryImplTest : BehaviorSpec({
    Given("Repository с datasources") {
        val repository = RepositoryImpl(
            asia = AsiaDataSource(),
            europe = EuropeDataSource(),
            america = NorthAmericaDataSource()
        )
        When("вызывается функция getAllCities") {
            Then("она должна собрать все 21 городов") {
                val cities = repository.getAllCities().toList()
                cities shouldHaveSize (21)
            }
        }
    }
})