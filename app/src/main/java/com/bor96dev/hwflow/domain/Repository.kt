package com.bor96dev.hwflow.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllCountries(): Flow<String>
}