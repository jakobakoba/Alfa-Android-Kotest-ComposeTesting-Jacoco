package com.bor96dev.hwflow.data

import com.bor96dev.hwflow.domain.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val asia: AsiaDataSource,
    private val europe: EuropeDataSource,
    private val america: NorthAmericaDataSource
) : Repository {
    override fun getAllCities(): Flow<String> {
        return merge(
            asia.getData(),
            europe.getData(),
            america.getData()
        )
    }
}