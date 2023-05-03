package flowbuilders

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        simpleFlow().collect {// collect is a suspend function and it needs to execute in a couroutine
            println("The Emitted values are $it")
        }


        // Collection of values from a flowOf builder
        flowOfBuilder().collect {
            delay(1000)
            println("The values are $it")
        }


        // Collection of values from a asFlow builder
        asFlowBuilder().collect {
            delay(1000)
            println("The values are $it")
        }
    }
}

// basic flow{..} builder
fun simpleFlow(): Flow<Int> = flow {
    println("printing values for a normal flow builder flow{...}----------------------------------")
    emit(1)
    delay(1000) // Code inside the flow can suspend for this flow builder
    emit(2)
}


//flowOf  Builder
fun flowOfBuilder(): Flow<Int> {
    println("printing values for flowOfBuilder flowOf(.......)-----------------------------")
    return flowOf(12, 15, 14) // The flowOf builder defines a flow that emits a fixed set of values.
}


//asFlow Builder
fun asFlowBuilder(): Flow<Int> {
    println("printing values for a asFlowBuilder() --------------------------------------------")
    return (95..100).asFlow()
}