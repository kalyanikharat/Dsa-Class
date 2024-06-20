import java.util.*;

public class L001 {
    
     //print increasing
    public static void printincreasing(int num1, int num2) {
        if (num1 == num2 + 1) { 
            return;
        }
        System.out.println(num1); 
        printincreasing(num1 + 1, num2); 
    }

    //printdecreasing
    public static void printdecreasing(int num1,int num2){
        if(num1== num2+1){
            return;
        }
        printdecreasing(num1+1, num2);
        System.out.println(num1);
    }

    //printincdec
    public static void printincdec(int num1,int num2){
        if(num1==num2+1){
            return;
        }
        System.out.println(num1);
        printincdec(num1+1, num2);
        System.out.println(num1);
    }
    // print evenodd
    public static void printevenodd(int num1,int num2){
        if(num1==num2+1){
            return;
        }
        if(num1%2==0){
            System.out.println(num1);
        }
        printevenodd(num1+1, num2);
        if(num1%2!=0){
            System.out.println(num1);
        }

    }

    //factorial
    public static int printfact(int num){
        if(num==0){
            return 1;
        }
        return num * printfact(num-1);
    

    }
    //power a^b
    public static int power(int num1,int num2){
        if(num1==0){
            return 0;
        }
        if(num2==0){
            return 1 ;
        }
        return num1 * power(num1,num2-1);

    }
    //powerbtr
    public static int powerbtr(int num1,int num2){
        if(num2==0){
            return 1;
        }
        int ans= powerbtr(num1,num2/2);
        if(num2% 2==0){
            return ans*ans;
        }else {
            return num1 * ans * ans;
        }
    }
    //recursion on array
    //display array
    public static void display(int idx,int arr[]){
        if(arr.length==idx){
            return;
        }
        System.out.println(arr[idx]);
        display(idx+1, arr);
    }
     //displayreverse
     public static void displayrev(int idx,int arr[]){
        
            if(arr.length==idx){
                return;
            }
            displayrev(idx+1, arr);
            System.out.println(arr[idx]);
        }
     //displayonevenlocation
     public static void displayevenloc(int idx,int arr[]){
        if(arr.length==idx){
            return;
        }
        if(idx%2==0){
            System.out.println(arr[idx]);
        }
        displayevenloc(idx+1,arr);
     }

     //displayprimelocation
     public static boolean isPrime(int num){
        boolean isPrime= true;
        if(num <2){
            return false;
        }
        for(int i=2;i<num;i++){
            if(num%i==0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
     }
     public static void displayprimelocation(int idx,int arr[]){
        if(arr.length==idx){
            return;
        }
        if(isPrime(idx)){
            System.out.println(arr[idx]);
        }
        displayprimelocation(idx+1, arr);
     }
     //find the position of given data 
     public static int find(int arr[], int idx, int data) {
        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == data) {
            return idx;
        }
        return find(arr, idx + 1, data);


    }
    //find all the position of the repeated data i.e. element
   
    public static int[] findALL(int arr[], int index, int data, int count) {

        if (arr.length == index) {
            int arr1[] = new int[count];
            return arr1;

        }

        if (arr[index] == data) {
            count = count + 1;

        }

        int ans[] = findALL(arr, index + 1, data, count);
        if (arr[index] == data) {
            ans[count - 1] = index;

        }
        return ans;

    }
    //subsequence i/p-[abc] o/p-[,a,b,ab,bc,c,ac,abc]top down 
    public static ArrayList<String> subsequence(String str,int idx){
        if(str.length()==idx){
            ArrayList<String>base= new ArrayList<>();
            base.add(" ");
            return base;
        }
        char ch=str.charAt(idx);
        ArrayList<String>ans=subsequence(str,idx+1);
        ArrayList<String>myans=new ArrayList<>();
        for(String a:ans){
            myans.add(a);
            myans.add(ch+a);
            
        }
        return myans;
    }
    //subsesequnce using bottom up
    public static void subsequence1(String str, int idx, String ans) {
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }
        subsequence1(str, idx + 1, ans);
        subsequence1(str, idx + 1, ans + str.charAt(idx));
    }
    //maze
    public static ArrayList<String> Maze(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
    
        ArrayList<String> myans = new ArrayList<>();
        if (sr + 1 <= er) {
            ArrayList<String> Horizontal = Maze(sr + 1, sc, er, ec);
            for (String s : Horizontal) {
                myans.add("H" + s);
            }
        }
        
        if (sc + 1 <= ec) {
            ArrayList<String> Vertical = Maze(sr, sc + 1, er, ec);
            for (String s : Vertical) {
                myans.add("V" + s);
            }
        }
        
        if (sc + 1 <= ec && sr + 1 <= er) {
            ArrayList<String> Diagonal = Maze(sr + 1, sc + 1, er, ec);
            for (String s : Diagonal) {
                myans.add("D" + s);
            }
        }
        return myans;
    }
    //flood fill //dfs
    
    public static void mazepath(int sr,int sc,int er,int ec,String ans,String[] dirS,int [][] dirA,int [][]maze ){
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return;
        }
        maze[sr][sc]=1;
        for(int d=0;d<dirA.length;d++){
            int r= sr+ dirA[d][0];
            int c= sc+ dirA[d][1];

            if(r>=0 && r<=er && c>=0 && c<=ec && maze[r][c]!=1){
                
                mazepath(r, c, er, ec, ans + dirS[d],dirS, dirA, maze);
                
            }
        }
        maze[sr][sc]=0;

    }
    //Ratpath
    public static ArrayList<String> findPath(int[][] m, int n) {
        String dirA[]={"D", "L" ,"R","U"};
        int dirS[][]={{1,0},{0,-1},{0,1},{-1,0}};
        ArrayList<String>myans = new ArrayList<>();
        // Your code here
        if(m[0][0]==0 || m[n-1][n-1]==0){
            return myans;
        }
    
        Ratpath(0,0,n-1,n-1,"",dirA,dirS,m,myans);
        return myans;
    }
    public static void Ratpath(int sr,int sc,int er,int ec,String ans,String dirA[],int dirS[][],int maze[][],ArrayList<String>myans){
        if(sr==er && sc==ec){
            myans.add(ans);
            return;
        }
        int temp =maze[sr][sc];
        maze[sr][sc]=-1;
        for(int d=0;d< dirS.length;d++){
            int r=sr +dirS[d][0];
            int c=sc +dirS[d][1];
            
            if(r>=0 && r<=er && c>=0 && c<=ec && maze[r][c]!=-1&& maze[r][c]!=0){
                Ratpath(r,c,er,ec,ans + dirA[d],dirA,dirS,maze,myans);
            }
        }
        maze[sr][sc]=temp;
        return;
    }
    //multiple jumps 1-n
    public static void MulPath(int sr,int sc,int er,int ec,String ans,String[] dirS,int [][] dirA,int [][]maze,ArrayList<String>myans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            myans.add(ans);
            return;
        }
        maze[sr][sc]=1;
       
        for(int d=0;d<dirA.length;d++){
            for(int jump=1;jump<=2;jump++){
                int r= sr + jump * dirA[d][0];
                int c= sc + jump * dirA[d][1];
                
                if(r>=0 && r<=er && c>=0 && c<=ec ){
                    if(maze[r][c]!=1){
                        MulPath(r,c,er,ec,ans+dirS[d]+jump,dirS,dirA,maze,myans);
                    }
                    
                } else{
                    break;
                }
            }
        }
        maze[sr][sc]=0;

    }
    //take a cell count the jump 
    public static void jumppath(int sr,int sc,int er,int ec,String ans,String[]dirS,int[][]dirA,int[][]maze,int[][]arr,ArrayList<String>myans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            myans.add(ans);
            return;
        } 
        maze[sr][sc]=1;

        int res=arr[sr][sc];
        for(int d=0;d<dirA.length;d++){
            for(int jump=1;jump<=res;jump++){
                int r = sr + jump*dirA[d][0];
                int c = sc + jump*dirA[d][1];

                if(r>=0 && r<=er && c>=0 && c<=ec ){
                    if(maze[r][c]!=1){
                        jumppath(r,c,er,ec,ans+dirS[d]+jump,dirS,dirA,maze,arr,myans);
                    }
                }else {
                    break;
                }
            }
            
        }
        maze[sr][sc]=0;
    }
//take static class and the find longest and shortest path from the given matrix
    static class Path{
        String longestpath;
        String shortestpath;
        int longestpathlength;
        int shoretestpathlength;
        int [][]lplengthco;
        int [][]splengthco;

    }
    static String dirS[]={"R","L","D","U"};
    static int dirA[][]={{0,1,},{0,-1},{1,0},{-1,0}};

    public static int[][] copyArray(int vis[][]){
        int rows= vis.length;
        int cols= vis[0].length;
        int ans[][]= new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                ans[i][j]=vis[i][j];
            }
        }
        return ans;
    }

    public static Path Mazepath(int sr,int sc,int er,int ec,String ans,int[][]arr,int vis[][]){
        if(sr==er && sc==ec){
            System.out.println(ans);
            Path p = new Path();
            p.longestpath=ans;
            p.shortestpath=ans;
            p.longestpathlength= ans.length();
            p.shoretestpathlength = ans.length();
            p.lplengthco= copyArray(vis);
            p.splengthco= copyArray(vis);
            
            return p;

        }
        int temp=arr[sr][sc];
        arr[sr][sc]=-1;
        vis[sr][sc]=1;

        Path mypath= new Path();
        mypath.lplengthco=new int[er+1][ec+1];
        mypath.splengthco=new int[er+1][ec+1];
        mypath.shoretestpathlength= (int)1e9;
        mypath.longestpath = "";
        mypath.longestpathlength = -(int)1e9;
        mypath.shortestpath= "";
        for(int i=0;i<dirS.length;i++){
            for(int jump=1;jump<=temp;jump++){
                int r= sr + jump*dirA[i][0];
                int c= sc + jump*dirA[i][1];
                if(r >=0 && c>=0 && r<=er && c<=ec){
                    if(arr[r][c]>0){
                        Path tempans=Mazepath(r, c, er, ec, ans+""+dirS[i]+""+jump, arr, vis);

                        if(tempans.longestpathlength >mypath.longestpathlength){
                            mypath.longestpath= tempans.longestpath;
                            mypath.longestpathlength= tempans.longestpathlength;
                            mypath.lplengthco=tempans.lplengthco;
                        }

                        if(tempans.shoretestpathlength <mypath.shoretestpathlength){
                            mypath.shortestpath= tempans.shortestpath;
                            mypath.shoretestpathlength=tempans.shoretestpathlength;
                            mypath.splengthco=tempans.splengthco;
                        }
                      
                    }

                }
                else
                {
                 break;
                }
            }

        }
        arr[sr][sc]=temp;
        vis[sr][sc]=0;
        return mypath;
    }
    //////////////particular length path print with the same length in lexicography
    static class Paths01 {
        ArrayList<String> longestPath;
        ArrayList<String> shortePath;
        int longestPathLen;
        int shortePathLen;
        int[][] longestPathco;
        int[][] shortePathco;
    }

    public static int[][] copyarr(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    public static Paths01 mazePathjumpbtr03(int sr, int sc, int er, int ec, String ans, int[][] arr, int[][] vis)
    {
        Paths01 myans= new Paths01();
        if (sr == er && sc == ec) {
            Paths01 temp1 = new Paths01();
            temp1.longestPath.add(ans); // 0 hdvd
            temp1.shortePath.add(ans);  // 0 rd
            temp1.longestPathLen = ans.length();
            temp1.shortePathLen = ans.length();
            temp1.longestPathco = copyarr(vis);
            temp1.shortePathco = copyarr(vis);
            return temp1;
        }
        // Paths p= new Paths();
        myans.longestPath.add("");
        myans.shortePath.add("");
        myans.longestPathLen = (int) -1e9;
        myans.shortePathLen = (int) 1e9;
        myans.longestPathco = new int[sr + 1][sc + 1];
        myans.shortePathco = new int[sr + 1][sc + 1];

        String[] arrD = { "D", "R", "L", "U" };
        int[][] arrC = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        int temp = arr[sr][sc];
        arr[sr][sc]=-1;
        vis[sr][sc]=1;
        for (int i = 0; i < arrD.length; i++) {
            for (int j = 1; j <= temp; j++) {
                int r = sr + j * arrC[i][0];
                int c = sc + j * arrC[i][1];
                Paths01 p = new Paths01();
                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (arr[r][c] > 0) {
                        p = mazePathjumpbtr03(r, c, er, ec, ans+ arrD[i] +""+ j, arr, vis);

                        if (p.longestPathLen > myans.longestPathLen) {
                            myans.longestPath.clear();
                            String st= p.longestPath.get(0);
                            myans.longestPath.add(st);
                            myans.longestPathco = p.longestPathco;
                            myans.longestPathLen = p.longestPathLen;
                        }
                        if(p.longestPath== myans.longestPath)                  // myans.shortpath= 0 hd  1 vd  2 rd
                        {
                            String st= p.longestPath.get(0);
                            myans.longestPath.add(st);
                        }

                        if (p.shortePathLen < myans.shortePathLen) {
                            //myans.shortePath.clear();
                            myans.shortePath = p.shortePath;
                            myans.shortePathco = p.shortePathco;
                            myans.shortePathLen = p.shortePathLen;

                        }
                        if(p.shortePath== myans.shortePath)
                        {
                            String st= p.shortePath.get(0);
                            myans.shortePath.add(st);                  
                        }
                    }
                }
                else
                {
                    break;
                }
            }
        }
        arr[sr][sc]=temp;
        vis[sr][sc]=0;

        return myans;
    }
   
    

    //take cell count and print matrix
    public static void display(int arr[][]){
        /*for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){

            }
        }*/
        for(int ar[]:arr){
            for(int num:ar){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    /*static String dirS[]={"E","W","N","S"};
    static int dirA[][]={{0,1,},{0,-1},{1,0},{-1,0}};*/
    public static int[][] mazpathjump2(int sr,int sc,int er,int ec,String ans,int arr[][],int vis[][]){
        if(sr==er && sc==ec){
          System.out.println(ans);
          vis[sr][sc]=1;
          int myans[][]= new int[er+1][ec+1];
          for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
               myans[i][j]=vis[i][j];
               System.out.println(vis[i][j]);
            }
        }
        display(myans);
          
          
          vis[sr][sc]=0;
          return myans;
        }
        int maxjump=arr[sr][sc];
        int temp[][]=new int[er+1][ec+1];
        vis[sr][sc]=1;
        for(int i=0;i<dirS.length;i++){
            for(int jump=1;jump<=maxjump;jump++){
                int r = sr +dirA[i][0] *jump;
                int c = sc +dirA[i][1] *jump;
                if(r <=er && c <=ec && r>=0 && c>=0){
                   if(vis[r][c] !=1){
                    temp=mazpathjump2(r, c, er, ec, ans+dirS[i]+""+jump, arr, vis);

                   }else{
                    break;
                   }
                }
            }
        
        }
        vis[sr][sc]=0;
        return temp;
        
    }


    
    
     
        public static void solve() {
        //printincreasing(1, 5); 
        //printdecreasing(1, 5);
        //printincdec(1, 5);
        //printevenodd(1,5);
        //int ans= printfact(5);
        //System.out.println(ans);
        //int myans= power(5,4);
        //System.out.println(myans);
        //int myans= powerbtr(2,4);
        //System.out.println(myans);
        //int []arr={1,2,3,4,2,5,2};
        //displayrev(0, arr);
        //displayevenloc(0, arr);
        //displayprimelocation(0, arr);
        //int ans= find(arr, 0, 5);
        //System.out.println(ans);
        //int ans[] = findALL(arr, 0, 2, 0);
        //for(int i=0 ;i<ans.length;i++)
        //{
        //System.out.println(ans[i]);
        //}
        //ArrayList<String> myans = subsequence("abc", 0);
        // for (String str : myans) {
        // System.out.println(str);
        // }
         //subsequence1("abc", 0, "");
         //ArrayList<String> ans = Maze(0, 0, 2, 2);
         //for(String s : ans);
        // {
        //System.out.println(ans);

        // }
          /*String dirS[]= {"E","W","N","S","NE","NW","SE","SW"};
          int dirA[][]= {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
          int[][] maze={{0,0,0},{0,0,0},{0,0,0}};
          mazepath(0,0,2,2,"",dirS,dirA,maze);*/

          /*String dirS[]={"E","W","N","S","R","L","D","U"};
          int dirA[][]={{0,1,},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
          int[][]maze={{0,0,0},{0,0,0},{0,0,0}};
          ArrayList<String>myans=new ArrayList<>();
          MulPath(0, 0, 2, 2, "", dirS, dirA, maze,myans);*/

          /*String dirS[]={"E","W","N","S"};
          int dirA[][]={{0,1,},{0,-1},{1,0},{-1,0}};*/
          //int[][]vis={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
         // int[][]arr={{2,1,1,1},{3,1,0,1},{1,1,1,1},{0,1,1,1}};
          //ArrayList<String>myans=new ArrayList<>();
          //jumppath(0, 0, 3, 3, "", dirS, dirA, maze, arr, myans);
          /*int temp[][]=mazpathjump2(0, 0, 3, 3, "", arr, vis);
          display(temp);*/
          
          //Path Result=Mazepath(0, 0, 3, 3, "", arr, vis);
          //System.out.println("LongestPath:"+Result.longestpath);
          //System.out.println("ShortestPath:"+Result.shortestpath);
              
          int[][] vis = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
          int[][] arr = {{2, 1, 1, 1}, {3, 1, 0, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
          Paths01 result = mazePathjumpbtr03(0, 0, 3, 3, "", arr, vis);
          System.out.println("Longest Path: " + result.longestPath);
          System.out.println("Shortest Path: " + result.shortePath);
          System.out.println("Longest Path Length: " + result.longestPathLen);
          System.out.println("Shortest Path Length: " + result.shortePathLen);
}
        public static void main(String args[]) {
        solve(); 
    }
}




    

