public class Main{
    public static void main(String[] args) {
        System.out.println(nextBigger(831));
    }
    public static int nextBigger(int inputNumber){
        int[] inNumArray = convertToArray(inputNumber);
        if (isSorted(inNumArray)){
            return -1;
        }
        else{
            int arrayLength = inNumArray.length;
            for(int i=arrayLength-1; i > 0; i--){
                if(inNumArray[i] > inNumArray[i-1]){
                    int temp = inNumArray[i];
                    inNumArray[i] = inNumArray[i-1];
                    inNumArray[i-1] = temp;
                    break;
                }
            }
            return convertToInt(inNumArray);
        }
    }
    public static int convertToInt(int[] inputArray){
        int output = 0;
        for (int i =0; i < inputArray.length; i++){
            output *= 10;
            output += inputArray[i];
        }
        return output;
    }
    public static boolean isSorted(int[] inputArray){
        for(int i = 0; i < inputArray.length - 1; i++){
            if(inputArray[i] >= inputArray[i+1]){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static int[] convertToArray(int inputNumber){
        int length = lengthOfNumber(inputNumber);
        int[] output = new int[length];
        for (int i=length-1; i>=0; i--){
            output[i] = inputNumber % 10;
            inputNumber /= 10;
        }
        return output;
    }

    public static int lengthOfNumber(int inputNumber){
        int i = 0;
        while (inputNumber != 0){
            i++;
            inputNumber /= 10;
        }
        return i;
    }
}