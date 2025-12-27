package com.bor96dev.hwflow.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EuropeDataSource: DataSource {
    override fun getData(): Flow<List<String>> = flow {
        delay(1500)
        emit(listOf("Paris", "London", "Berlin"))
    }
}