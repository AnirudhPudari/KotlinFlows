import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    // Map Operator Example
    numbers().map {
        delay(1000)
        it + 2
    }.collect {
        println("Mapped values are $it")
    }


    // Filter Operator Example
    //------------------------------------------------------------------
    numbers().filter {
        delay(1000)
        it % 2 == 0
    }.collect {
        println("Filtered values are $it")
    }


    // Take Operator Example
    //------------------------------------------------------------------
    numbers().take(1).collect {
        println("values are $it")
    }


    //Zip operator
    //------------------------------------------------------------------
    flowOFNumbers().zip(flowOf(3, 2, 1)) { firstFlowValue, secondFlowValue ->
        firstFlowValue + secondFlowValue
    }.collect {
        println("Sum value is $it")
    }
}


fun numbers(): Flow<Int> = flow {
    emit(1)
    emit(2)
    emit(3)
}


fun flowOFNumbers() = flowOf(6,5,4)
