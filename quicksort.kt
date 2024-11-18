fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high) // Find the pivot
        quickSort(arr, low, pivotIndex - 1)       // Recursively sort the left part
        quickSort(arr, pivotIndex + 1, high)     // Recursively sort the right part
    }
}

// Partition function to place the pivot in the correct position
fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]  // Choose the last element as the pivot
    var i = low - 1        // Pointer for the smaller element

    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            // Swap arr[i] and arr[j]
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    // Swap the pivot element with the element at i + 1
    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp

    return i + 1 // Return the index of the pivot
}

fun main() {
    val arr = intArrayOf(10, 7, 8, 9, 1, 5)
    println("Original Array: ${arr.joinToString(", ")}")

    quickSort(arr, 0, arr.size - 1)

    println("Sorted Array: ${arr.joinToString(", ")}")
}
