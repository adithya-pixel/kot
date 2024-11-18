class CircularLinkedList {

    // Node class
    data class Node(var data: Int, var next: Node? = null)

    private var tail: Node? = null // Points to the last node

    // Insert at the beginning
    fun insertAtBeginning(data: Int) {
        val newNode = Node(data)
        if (tail == null) {
            newNode.next = newNode
            tail = newNode
        } else {
            newNode.next = tail?.next
            tail?.next = newNode
        }
    }

    // Insert at the end
    fun insertAtEnd(data: Int) {
        val newNode = Node(data)
        if (tail == null) {
            newNode.next = newNode
            tail = newNode
        } else {
            newNode.next = tail?.next
            tail?.next = newNode
            tail = newNode
        }
    }
// Initialize the list with an array of values
fun initialize(values: List<Int>) {
    for (value in values) {
        insertAtEnd(value)
    }
}

    // Insert at a specific position (1-based index)
    fun insertAtPosition(data: Int, position: Int) {
        if (position < 1) {
            println("Invalid position")
            return
        }
        val newNode = Node(data)
        if (position == 1) {
            insertAtBeginning(data)
            return
        }
        var current = tail?.next
        var currentPosition = 1
        while (current != tail && currentPosition < position - 1) {
            current = current?.next
            currentPosition++
        }
        if (current == null || current == tail) {
            insertAtEnd(data)
        } else {
            newNode.next = current.next
            current.next = newNode
        }
    }

    // Delete at the beginning
    fun deleteAtBeginning() {
        if (tail == null) {
            println("List is empty")
            return
        }
        if (tail?.next == tail) { // Only one node
            tail = null
        } else {
            tail?.next = tail?.next?.next
        }
    }

    // Delete at the end
    fun deleteAtEnd() {
        if (tail == null) {
            println("List is empty")
            return
        }
        if (tail?.next == tail) { // Only one node
            tail = null
            return
        }
        var current = tail?.next
        while (current?.next != tail) {
            current = current?.next
        }
        current?.next = tail?.next
        tail = current
    }

    // Delete at a specific position (1-based index)
    fun deleteAtPosition(position: Int) {
        if (position < 1) {
            println("Invalid position")
            return
        }
        if (tail == null) {
            println("List is empty")
            return
        }
        if (position == 1) {
            deleteAtBeginning()
            return
        }
        var current = tail?.next
        var currentPosition = 1
        while (current?.next != tail?.next && currentPosition < position - 1) {
            current = current?.next
            currentPosition++
        }
        if (current?.next == tail?.next || current == null) {
            println("Position out of bounds")
        } else {
            current.next = current.next?.next
            if (current.next == tail?.next) { // If deleting the tail node
                tail = current
            }
        }
    }

    // Display the list
    fun display() {
        if (tail == null) {
            println("List is empty")
            return
        }
        var current = tail?.next
        do {
            print("${current?.data} -> ")
            current = current?.next
        } while (current != tail?.next)
        println("(circular)")
    }
}

fun main() {
    val list = CircularLinkedList()
 // Initialize the list with values
 list.initialize(listOf(5, 10, 15, 20))
 println("After initializing the list with values (5, 10, 15, 20):")
 list.display()
    // Insert at the beginning
    list.insertAtBeginning(10)
    println("After inserting  10 at the beginning:")
    list.display()

    // Insert at the end
    list.insertAtEnd(15)
    println("\nAfter inserting  20 at the end:")
    list.display()

    // Insert at a specific position
    list.insertAtPosition(12, 3)
    println("\nAfter inserting 12 at position 3:")
    list.display()

    // Delete at the beginning
    list.deleteAtBeginning()
    println("\nAfter deleting at the beginning:")
    list.display()

    // Delete at the end
    list.deleteAtEnd()
    println("\nAfter deleting at the end:")
    list.display()

    // Delete at a specific position
    list.deleteAtPosition(2)
    println("\nAfter deleting at position 2:")
    list.display()
}
