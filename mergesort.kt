fun mergeSort(arr: IntArray): IntArray {
    if (arr.size <= 1) return arr // No need to sort if only one element

    val mid = arr.size / 2
    val left = mergeSort(arr.sliceArray(0 until mid)) // Sort left half
    val right = mergeSort(arr.sliceArray(mid until arr.size)) // Sort right half

    return merge(left, right) // Merge sorted halves
}

fun merge(left: IntArray, right: IntArray): IntArray {
    val merged = mutableListOf<Int>()
    var i = 0
    var j = 0

    // Compare and merge
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            merged.add(left[i])
            i++
        } else {
            merged.add(right[j])
            j++
        }
    }

    // Add leftovers
    while (i < left.size) merged.add(left[i++])
    while (j < right.size) merged.add(right[j++])

    return merged.toIntArray()
}

fun main() {
    val arr = intArrayOf(4, 2, 7, 1,8,12)
    println("Original: ${arr.joinToString(", ")}")
    val sorted = mergeSort(arr)
    println("Sorted: ${sorted.joinToString(", ")}")
}
