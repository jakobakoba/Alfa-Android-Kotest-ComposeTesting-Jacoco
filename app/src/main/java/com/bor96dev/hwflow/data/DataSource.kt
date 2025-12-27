package com.bor96dev.hwflow.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

interface DataSource {
    fun getData(): Flow<String>
}

class AsiaDataSource : DataSource {
    override fun getData(): Flow<String> = flow {
        for (city in listOf("Tokyo", "Beijing", "Seoul")) {
            delay(Random.nextLong(1000, 2000))
            emit("$city - AsiaDataSource")
        }
    }
}

class EuropeDataSource : DataSource {
    override fun getData(): Flow<String> = flow {
        for (city in listOf("Paris", "London", "Berlin")) {
            delay(Random.nextLong(1000, 2000))
            emit("$city - EuropeDataSource")
        }
    }
}

class NorthAmericaDataSource : DataSource {
    override fun getData(): Flow<String> = flow {
        for (city in listOf(
            "New York", "Toronto", "Los Angeles", "Chicago", "Miami",
            "Houston", "San Francisco", "Vancouver", "Boston", "Seattle",
            "Dallas", "Montreal", "Washington D.C.", "Philadelphia", "Atlanta"
        )
        ) {
            delay(Random.nextLong(500, 1000))
            emit("$city - NorthAmericaDataSource")
        }
    }
}