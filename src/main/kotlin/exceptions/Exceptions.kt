package exceptions

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        exceptionInIntermediateOperator()

        exceptionInTerminalOperator()

        //Best way to handle exception by moving the collect code to onEach where you can catch exceptions from all blocks
        println("------------------------Exception handling using a catch operator----------------------------------------------")
        (1..3).asFlow().map { it * 2 }.onEach {
            if (it > 2) throw Exception("$it")
            println("Emitted values are $it")
        }.catch { e -> println("Caught $e") }.collect()
    }
}

suspend fun exceptionInIntermediateOperator() {
    try {
        println("------------------------Exception example in Intermediate Operator----------------------------------------------")
        simple().map {
            if (it == 2) throw Exception("$it") else it
        }.collect {
            println("Collected Values are $it")
        }
    } catch (e: Throwable) {
        println("Exception Caught on value ${e.message}")
    }
}

suspend fun exceptionInTerminalOperator() {
    try {
        println("-----------------------------Exception example in Terminal Operator----------------------------------------------")
        simple().map { it * it }.collect {
                if (it > 2) {
                    throw Exception("$it")
                }
            }
    } catch (e: Throwable) {
        println("Exception Caught at value ${e.message}")
    }
}

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}
