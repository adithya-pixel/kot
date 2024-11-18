fun selectionSort(array: IntArray) {
    for (i in array.indices) {
        // Find the smallest element in the remaining array
        var minIndex = i
        for (j in i + 1 until array.size) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        // Swap the smallest element with the current element
        val temp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = temp
    }
}

fun main() {
    val array = intArrayOf(5, 3, 8, 6, 2)

    println("Before sorting: ${array.joinToString(", ")}")
    selectionSort(array)
    println("After sorting: ${array.joinToString(", ")}")
}
