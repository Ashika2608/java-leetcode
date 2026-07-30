public class freqofelement {
    public static void main(String[] args) {
        int[] arr = {10, 25, 10, 7, 25, 10};
        int[] freq = new int[100];
       for(int num :arr){
        freq[num]++;
       }
       for(int i = 0;i<freq.length;i++){
        if(freq[i]>=1){
         System.out.println(i +" occurs "+freq[i]);
        }
       }
    }
}
