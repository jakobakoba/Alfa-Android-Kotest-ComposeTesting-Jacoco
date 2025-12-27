package com.bor96dev.hwflow.data

import com.bor96dev.hwflow.domain.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.merge

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryImpl(
    private val asia: AsiaDataSource,
    private val europe: EuropeDataSource,
    private val america: NorthAmericaDataSource
) : Repository {
    override fun getAllCountries(): Flow<String> {
        return merge(
            asia.getData().flatMapMerge { it.asFlow() },
            europe.getData().flatMapMerge { it.asFlow() },
            america.getData().flatMapMerge { it.asFlow() }
        )
    }
}