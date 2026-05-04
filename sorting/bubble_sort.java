class Solution {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i<n; i++){  // or (int i = n - 1; i >= 0; i--)
            
                boolean swapped = false; //if no swap occurs in iteration i = 0 then all are sorted no need to checck the rest i = 1 to n

            for(int j = 0; j<n-i-1; j++){  // or (int j = 0; j <= i - 1; j++) 
                
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                   
                    swapped = true;
                }
            }
            
            if(!swapped){
                break;
            }
            
        }
        
    }
}
