#include <stdio.h>

// Function to perform binary search
int binarySearch(int arr[], int low, int high, int key) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == key)
            return mid; // Key found
        else if (arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1; // Key not found
}

// Function to perform bubble sort (or any sorting algorithm)
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int arr[] = {34, 23, 76, 45, 68, 37};
    int n = sizeof(arr) / sizeof(arr[0]);
    int key;

    // Sort the array
    bubbleSort(arr, n);

    printf("Sorted array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    // Prompt user for the key to search
    printf("Enter the number to search: ");
    scanf("%d", &key);

    // Perform binary search
    int result = binarySearch(arr, 0, n - 1, key);

    if (result != -1)
        printf("Number found at index %d.\n", result);
    else
        printf("Number not found.\n");

    return 0;
}