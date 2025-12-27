package com.bor96dev.hwflow.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface DataSource {
    fun getData(): Flow<List<String>>
}

class AsiaDataSource : DataSource {
    override fun getData(): Flow<List<String>> = flow {
        delay(2000)
        emit(listOf("Tokyo", "Beijing", "Seoul"))
    }
}

class EuropeDataSource : DataSource {
    override fun getData(): Flow<List<String>> = flow {
        delay(1500)
        emit(listOf("Paris", "London", "Berlin"))
    }
}

class NorthAmericaDataSource : DataSource {
    override fun getData(): Flow<List<String>> = flow {
        delay(1000)
        emit(listOf("New York", "Toronto", "Los Angeles"))
    }
}