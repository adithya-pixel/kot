class DoublyLinkedList {

    // Node class
    data class Node(var data: Int, var prev: Node? = null, var next: Node? = null)

    private var head: Node? = null

    // Insert at the beginning
    fun insertAtBeginning(data: Int) {
        val newNode = Node(data)
        newNode.next = head
        if (head != null) {
            head?.prev = newNode
        }
        head = newNode
    }

    // Insert at the end
    fun insertAtEnd(data: Int) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
            return
        }
        var temp = head
        while (temp?.next != null) {
            temp = temp.next
        }
        temp?.next = newNode
        newNode.prev = temp
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
        var temp = head
        var currentPosition = 1
        while (temp != null && currentPosition < position - 1) {
            temp = temp.next
            currentPosition++
        }
        if (temp == null) {
            println("Position out of bounds")
            return
        }
        newNode.next = temp.next
        newNode.prev = temp
        temp.next?.prev = newNode
        temp.next = newNode
    }

    // Delete at the beginning
    fun deleteAtBeginning() {
        if (head == null) {
            println("List is empty")
            return
        }
        head = head?.next
        head?.prev = null
    }

    // Delete at the end
    fun deleteAtEnd() {
        if (head == null) {
            println("List is empty")
            return
        }
        if (head?.next == null) {
            head = null
            return
        }
        var temp = head
        while (temp?.next != null) {
            temp = temp.next
        }
        temp?.prev?.next = null
    }

    // Delete at a specific position (1-based index)
    fun deleteAtPosition(position: Int) {
        if (position < 1) {
            println("Invalid position")
            return
        }
        if (head == null) {
            println("List is empty")
            return
        }
        if (position == 1) {
            deleteAtBeginning()
            return
        }
        var temp = head
        var currentPosition = 1
        while (temp != null && currentPosition < position) {
            temp = temp.next
            currentPosition++
        }
        if (temp == null) {
            println("Position out of bounds")
            return
        }
        temp.prev?.next = temp.next
        temp.next?.prev = temp.prev
    }

    // Display the list
    fun display() {
        if (head == null) {
            println("List is empty")
            return
        }
        var temp = head
        while (temp != null) {
            print("${temp.data} <-> ")
            temp = temp.next
        }
        println("NULL")
    }
}

fun main() {
    val list = DoublyLinkedList()

    // Initialize the list with values
    list.initialize(listOf(5, 10, 15, 20))
    println("After initializing the list with values (5, 10, 15, 20):")
    list.display()

    // Insert at the beginning
    list.insertAtBeginning(1)
    println("\nAfter inserting at the beginning (1):")
    list.display()

    // Insert at the end
    list.insertAtEnd(25)
    println("\nAfter inserting at the end (25):")
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