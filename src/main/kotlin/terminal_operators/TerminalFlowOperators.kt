package terminal_operators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {

        // Collect Terminal operator
        println("----------------------------Collect Terminal operator----------------------")
        numbers().collect {
            println("collected values are $it")
        }


        // Single Terminal operator
        println("----------------------------Single Terminal operator----------------------")
        println(singleValueFlow().single())


        // toList() Terminal operator
        println("----------------------------toList() Terminal operator----------------------")
        val list = numbers().toList()
        println(list)


        // toSet() Terminal operator
        println("----------------------------toSet() Terminal operator----------------------")
        val set = numbers().toSet()
        println(set)

        println("----------------------------reduce Terminal operator----------------------")
        val reduceConCatenation = flowOf("A", "B", "C", "D").reduce { accumulator, value -> accumulator + value }
        println("Reduce concatenated value is $reduceConCatenation")

        println("----------------------------fold Terminal operator----------------------")
        val foldSum = numbers().fold(5) { accumulator, value -> accumulator + value }
        println("Fold calculation with initial value as 5 and computed value is $foldSum")


        numbers().count()
    }
}

fun singleValueFlow() = flowOf(123)

fun numbers(): Flow<Int> = flow {
    emit(1)
    delay(1000)
    emit(2)
    delay(1000)
    emit(3)
}
