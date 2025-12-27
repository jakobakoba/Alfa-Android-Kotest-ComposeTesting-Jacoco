package com.bor96dev.hwflow.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NorthAmericaDataSource: DataSource {
    override fun getData(): Flow<List<String>> = flow {
        delay(1000)
        emit(listOf("New York", "Toronto", "Los Angeles"))
    }
}