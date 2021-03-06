package com.example

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pl.treksoft.kvision.remote.KVServiceManager

interface INumberService {
    suspend fun numberToWords(number: Int, language: Language): String
}

expect class NumberService : INumberService

object NumberServiceManager : KVServiceManager<NumberService>(NumberService::class) {
    init {
        GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
            bind(NumberService::numberToWords)
        }
    }
}
