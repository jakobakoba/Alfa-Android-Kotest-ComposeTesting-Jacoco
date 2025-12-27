package com.bor96dev.hwflow.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AsiaDataSource: DataSource {
    override fun getData(): Flow<List<String>> = flow {
        delay(2000)
        emit(listOf("Tokyo", "Beijing", "Seoul"))
    }
}