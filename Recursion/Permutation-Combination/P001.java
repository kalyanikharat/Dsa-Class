public class P001 {
    public class L004 {
        public static int permutationinfcoins(int arr[],int tar,String ans){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            int count=0;
            for(int ele: arr){
                if(tar - ele >=0){
                    count += permutationinfcoins(arr, tar - ele, ans + ""+ele);
                }
            }
            return count;
        }
        //combination infinite
        public static int combinationinf(int arr[],int idx,int tar,String ans){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            int count=0;
            for(int i=idx;i<arr.length;i++){
                if(tar -arr[i] >=0){
                    count += combinationinf(arr, i, tar -arr[i], ans +""+arr[i]);
                }
            }
            return count;
        }
        //coin should be used one time used only in combination
        public static int combinationcoin(int arr[],int idx,int tar,String ans){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            int count=0;
            for(int i=idx;i<arr.length;i++){
                if(tar -arr[i] >=0){
                    count += combinationinf(arr, i+1, tar -arr[i], ans +""+arr[i]);
                }
            }
            return count;
        }
        //coin should be used one time used only in permutation
        public static int permutationOneCoin(int[] arr, int tar, String ans) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            int count = 0;
            for(int i=0; i<arr.length;i++){
                if(arr[i]>0 && tar-arr[i] >=0){
                  int ele = arr[i];
                  arr[i] =-ele;
                  count += permutationOneCoin(arr, tar-ele, ans+""+ele);
                  arr[i] = ele;
    
                }
            }
            return count;
        }
        ///subsequence
        public static int combinationinfcoinsub(int[]arr,int tar,int idx,String ans){
            if(tar==0 || idx==arr.length){
               if(tar==0){
                System.out.println(ans);
                return 1;
               }
               return 0;
            }
            int count=0;
            if(tar - arr[idx]>=0){
                count += combinationinfcoinsub(arr,tar-arr[idx],idx,ans + arr[idx]);
                            
            }
            count += combinationinfcoinsub(arr,tar,idx+1,ans);
            return count;
    
            
        }
        ///using now only one time coin
        public static int combinationonecoinsub(int[]arr,int tar,int idx,String ans){
            if(tar==0 || idx==arr.length){
               if(tar==0){
                System.out.println(ans);
                return 1;
               }
               return 0;
            }
            int count=0;
            if(tar - arr[idx]>=0){
                count += combinationonecoinsub(arr,tar-arr[idx],idx+1,ans + arr[idx]+"");
                            
            }
            count += combinationonecoinsub(arr,tar,idx+1,ans);
            return count;
    
            
        }
        //permutations for infinite coin using subsequence
        public static int permutationinfcoinsub(int[]arr,int tar,int idx,String ans){
            if(tar==0 || idx==arr.length){
               if(tar==0){
                System.out.println(ans);
                return 1;
               }
               return 0;
            }
            int count=0;
            if(tar - arr[idx]>=0){
                count += permutationinfcoinsub(arr,tar-arr[idx],0,ans + arr[idx]+"");
                            
            }
            count += permutationinfcoinsub(arr,tar,idx+1,ans);
            return count;
    
            
        }
        ///permutation only one time coin used
        public static int permutationonecoinsub(int []arr,int tar,int idx,String ans){
            if(tar==0 || idx==arr.length){
                if(tar==0){
                 System.out.println(ans);
                 return 1;
                }
                return 0;
             }
             int count=0;
             if(arr[idx]>0 && tar-arr[idx]>=0){
                int ele= arr[idx];
                arr[idx]= -ele;
                count += permutationonecoinsub(arr,tar-ele,0,ans+ele);
                arr[idx]=ele;
             }
             count += permutationonecoinsub(arr,tar,idx+1,ans);
             return count;
        }
        ///find equalsubset 
        public static int findsubset(int[]arr,int idx,int sum1,int sum2,String ans1,String ans2){
           if(idx==arr.length){
            if(sum1==sum2){
                System.out.println("Subset1:"+ans1 +" "+"Subset2:"+ans2);
                
                return 1;
            }
            return 0;
           }
           int count=0;
    
           count += findsubset(arr, idx+1, sum1+arr[idx], sum2, ans1+arr[idx]+" ", ans2);
           count += findsubset(arr, idx+1, sum1, sum2+arr[idx], ans1, ans2+arr[idx]+" ");
           return count;
    
        }
        //now find unique pairs
        public static int findsubsetunique(int[]arr,int idx,int sum1,int sum2,String ans1,String ans2){
            if(idx==arr.length){
             if(sum1==sum2){
                 System.out.println("Subset1:"+ans1 +" "+"Subset2:"+ans2);
                 
                 return 1;
             }
             return 0;
            }
            int count=0;
     
            count += findsubsetunique(arr, idx+1, sum1+arr[0], sum2, ans1+arr[0]+" ", ans2);
            count += findsubsetunique(arr, idx+1, sum1, sum2+arr[0], ans1, ans2+arr[0]+" ");
            return count;
     
         }
    
        
        public static void main(String args[]){
           // int[] arr={2,3,5,7};
           // int tar= 10;
            //permutations
            //int totalcount = permutationinfcoins(arr, tar, "");
            //System.out.println("total permutations" +totalcount);
    
            //combinations
            //int result = combinationinf(arr, 0, tar, "");
            //System.out.println("total combinations:"+result);
    
            //coin once only should print in combination
            //int myans= combinationcoin(arr, 0, tar, "");
            //System.out.println("One coin:"+myans);
    
            //coin once only should print in permutation
            //int res= permutationOneCoin(arr, tar, "");
            //System.out.println("One permutation:"+res);
    
            //combination for infinite coins using subsequence
            //int myans = combinationinfcoinsub(arr,tar,0,"");
            //System.out.println("Total combinations using subsequnce :" +myans);
    
            //combination for only one time coin used using subsequence
           // int res= combinationonecoinsub(arr,tar,0,"");
            //System.out.println("total combination using one coin:"+res);
    
            //permutation subsequence for ifinite coin
            //int res= permutationinfcoinsub(arr, tar, 0, "");
            //System.out.println("total permutation:"+res);
    
            //permutation subsequnece for one time coin use
            //int myans = permutationonecoinsub(arr, tar, 0, "");
            //System.out.println("total permutation:"+myans);
    
            //equalset 
            int[]arr={10,20,30,40,50,60,70};
            //int result= findsubset(arr,0, 0, 0, "", "");
            //System.out.println("Total Pairs:"+result);
             //unique way non repeated values
             int res= findsubsetunique(arr,1, arr[0] , 0, arr[0] + "","");
             System.out.println("Total Pairs:"+res);
           
    
        }
    }
    
    
}
