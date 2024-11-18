fun insertionSort(array: IntArray) {
    for (i in 1 until array.size) {
        val key = array[i] // Current element to insert
        var j = i - 1

        // Shift elements of the sorted part of the array
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }

        // Place the key in the correct position
        array[j + 1] = key
    }
}

fun main() {
    val array = intArrayOf(5, 3, 8, 6, 2)

    println("Before sorting: ${array.joinToString(", ")}")
    insertionSort(array)
    println("After sorting: ${array.joinToString(", ")}")
}
