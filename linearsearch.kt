fun linearSearch(arr: IntArray, target: Int): Int {
    for (i in arr.indices) {
        if (arr[i] == target) {
            return i // Return the index if found
        }
    }
    return -1 // Return -1 if not found
}

fun main() {
    val arr = intArrayOf(10, 20, 30, 40, 50)
    val target = 30
    val result = linearSearch(arr, target)
    
    if (result != -1) {
        println("Element found at index $result")
    } else {
        println("Element not found")
    }
}