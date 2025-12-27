package com.bor96dev.hwflow.data

import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getData(): Flow<List<String>>
}