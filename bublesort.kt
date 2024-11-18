fun bubbleSort(arr: IntArray) {
    for (i in 0 until arr.size - 1) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

fun main() {
    val arr = intArrayOf(5, 3, 8, 6, 2)

    println("Original Array: ${arr.joinToString(", ")}")

    bubbleSort(arr)

    println("Sorted Array: ${arr.joinToString(", ")}")
}
