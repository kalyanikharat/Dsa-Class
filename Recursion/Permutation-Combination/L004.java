
public class L004 {
    public static int permutationinfcoins(int arr[], int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int ele : arr) {
            if (tar - ele >= 0) {
                count += permutationinfcoins(arr, tar - ele, ans + "" + ele);
            }
        }
        return count;
    }

    // combination infinite
    public static int combinationinf(int arr[], int idx, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += combinationinf(arr, i, tar - arr[i], ans + "" + arr[i]);
            }
        }
        return count;
    }

    // coin should be used one time used only in combination
    public static int combinationcoin(int arr[], int idx, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += combinationinf(arr, i + 1, tar - arr[i], ans + "" + arr[i]);
            }
        }
        return count;
    }

    // coin should be used one time used only in permutation
    public static int permutationOneCoin(int[] arr, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && tar - arr[i] >= 0) {
                int ele = arr[i];
                arr[i] = -ele;
                count += permutationOneCoin(arr, tar - ele, ans + "" + ele);
                arr[i] = ele;

            }
        }
        return count;
    }

    /// subsequence
    public static int combinationinfcoinsub(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += combinationinfcoinsub(arr, tar - arr[idx], idx, ans + arr[idx]);

        }
        count += combinationinfcoinsub(arr, tar, idx + 1, ans);
        return count;

    }

    /// using now only one time coin
    public static int combinationonecoinsub(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += combinationonecoinsub(arr, tar - arr[idx], idx + 1, ans + arr[idx] + "");

        }
        count += combinationonecoinsub(arr, tar, idx + 1, ans);
        return count;

    }

    // permutations for infinite coin using subsequence
    public static int permutationinfcoinsub(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += permutationinfcoinsub(arr, tar - arr[idx], 0, ans + arr[idx] + "");

        }
        count += permutationinfcoinsub(arr, tar, idx + 1, ans);
        return count;

    }

    /// permutation only one time coin used
    public static int permutationonecoinsub(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (arr[idx] > 0 && tar - arr[idx] >= 0) {
            int ele = arr[idx];
            arr[idx] = -ele;
            count += permutationonecoinsub(arr, tar - ele, 0, ans + ele);
            arr[idx] = ele;
        }
        count += permutationonecoinsub(arr, tar, idx + 1, ans);
        return count;
    }

    /// find equalsubset
    public static int findsubset(int[] arr, int idx, int sum1, int sum2, String ans1, String ans2) {
        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println("Subset1:" + ans1 + " " + "Subset2:" + ans2);

                return 1;
            }
            return 0;
        }
        int count = 0;

        count += findsubset(arr, idx + 1, sum1 + arr[idx], sum2, ans1 + arr[idx] + " ", ans2);
        count += findsubset(arr, idx + 1, sum1, sum2 + arr[idx], ans1, ans2 + arr[idx] + " ");
        return count;

    }

    // now find unique pairs
    public static int findsubsetunique(int[] arr, int idx, int sum1, int sum2, String ans1, String ans2) {
        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println("Subset1:" + ans1 + " " + "Subset2:" + ans2);

                return 1;
            }
            return 0;
        }
        int count = 0;

        count += findsubsetunique(arr, idx + 1, sum1 + arr[0], sum2, ans1 + arr[0] + " ", ans2);
        count += findsubsetunique(arr, idx + 1, sum1, sum2 + arr[0], ans1, ans2 + arr[0] + " ");
        return count;

    }

    /// permutation on string for "abcd"
    public static void permutationstr(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String myans = str.substring(0, i) + str.substring(i + 1);
            permutationstr(myans, ans + ch);

        }
    }

    /// Find the permutation of unique string abcda / aaaa
    public static void permutationstrunique(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        boolean visited[] = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!visited[ch - 'a']) {
                visited[ch - 'a'] = true;
                String myans = str.substring(0, i) + str.substring(i + 1);
                permutationstrunique(myans, ans + ch);

            }

        }
    }

    // By different way need to take prev=$ and current =ch
    public static void permutationstrunique1(String str, String ans, char prev) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != prev) {
                String myans = str.substring(0, i) + str.substring(i + 1);
                permutationstrunique1(myans, ans + ch, ch);
            }
        }
    }

    // find all possible ways to reach at the top of stair
    public static int StairPr(int n, String path, int num) {
        if (n == 0) {
            System.out.println(path);
            return 1;
        }
        int count = 0;
        if (n > 0) {
            for (int jump = 1; jump <= 3; jump++) {
                count += StairPr(n - jump, path + "S" + num + "J" + jump + " ", num + jump);
            }

        }
        return count;

    }

    // there are 5 boxes (array size 5) and three queens q1,q2,q3 solvw it by
    // combi,permi
    // parameters=(int totalnoboxes,int boxno,int totalnoofqueens,int
    // queenplacesofar,string ans)
    public static int queenCombination1D(int totalnoboxes, int boxno, int totalnoofqueens, int queenplacesofar,
            String ans) {
        if (queenplacesofar == totalnoofqueens) {
            System.out.println(ans);
            return 1;
        }
        if (boxno == totalnoboxes) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < totalnoboxes; i++) {
            count += queenCombination1D(totalnoboxes, boxno + 1, totalnoofqueens, queenplacesofar + 1,
                    ans + "(" + "q" + (queenplacesofar + 1) + "b" + boxno + ")");
        }

        return count;

    }

    /// queen permutation
    public static int Permutation1D(int totalnoboxes, int totalnoofqueens, int queenplacesofar, String ans,
            boolean[] vis) {
        if (queenplacesofar == totalnoofqueens) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < totalnoboxes; i++) {
            if (!vis[i]) {
                vis[i] = true;
                count += Permutation1D(totalnoboxes, totalnoofqueens, queenplacesofar + 1,
                        ans + "(" + "q" + (queenplacesofar + 1) + "b" + i + ")", vis);
                vis[i] = false;
            }

        }
        return count;
    }

    /// combination placing 4 queens in box
    public static int Queencombi1d(int tnb, int tnq, int bno, int qno, String ans) {
        if (qno == tnq) {
            System.out.println(ans);
            return 1;
        }
        if (bno == tnb) {
            return 0;
        }
        int count = 0;
        for (int i = bno; i < tnb; i++) {
            count += Queencombi1d(tnb, tnq, i + 1, qno + 1, ans + "q" + qno + "b" + i + " ");
        }

        return count;
    }

    // now same for permutation place 4 queens in 5 boxes
    public static int Queenper1d(int tnb, int tnq, int bno, int qno, String ans, boolean[] vis) {
        if (qno == tnq) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < tnb; i++) {
            if (!vis[i]) {
                vis[i] = true;
                count += Queenper1d(tnb, tnq, i + 1, qno + 1, ans + "q" + qno + "b" + i + " ", vis);
                vis[i] = false;
            }
        }
        return count;

    }

    // now combination for 2d array using boolean
    public static int Queencombi2d(boolean[][] tnb, int idx, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;

        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            count += Queencombi2d(tnb, i + 1, tnq + 1, ans + " ( " + r + "," + c + " ) ");

        }
        return count;

    }

    // now i want for permutation 2d
    public static int Queenper2d(boolean[][] tnb, int idx, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;

        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (tnb[r][c] != true) {
                tnb[r][c] = true;
                count += Queenper2d(tnb, idx, tnq - 1, ans + " ( " + r + "," + c + " ) ");
                tnb[r][c] = false;
            }

        }
        return count;

    }

    // N queens using combination
    public static int Nqueenscombi(boolean[][] boxes, int idx, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        int n = boxes.length;
        int m = boxes[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (isSafeToPlaceQueen(boxes, r, c) && !boxes[r][c]) {
                boxes[r][c] = true;
                count += Nqueenscombi(boxes, i + 1, tnq - 1, ans + "(" + r + "," + c + ")");
                boxes[r][c] = false;

            }
        }
        return count;
    }

    public static boolean isSafeToPlaceQueen(boolean boxes[][], int r, int c) {
        int dirA[][] = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

        for (int d = 0; d < dirA.length; d++) {
            for (int rad = 1; rad < boxes.length; rad++) {
                int x = r + rad * dirA[d][0];
                int y = c + rad * dirA[d][1];

                if (x >= 0 && y >= 0 && x < boxes.length && y < boxes[0].length) {
                    if (boxes[x][y]) {
                        return false;
                    }
                } else {
                    break;
                }
            }
        }
        return true;
    }

    // nqueen for permutation
    public static int NqueensPermut(boolean[][] boxes, int idx, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        int n = boxes.length;
        int m = boxes[0].length;
        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (isSafeToPlaceQueenper(boxes, r, c) && !boxes[r][c]) {
                boxes[r][c] = true;
                count += NqueensPermut(boxes, idx, tnq - 1, ans + "(" + r + "," + c + ")");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    public static boolean isSafeToPlaceQueenper(boolean[][] boxes, int r, int c) {
        int[][] dirA = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

        for (int d = 0; d < dirA.length; d++) {
            for (int rad = 1; rad < boxes.length; rad++) {
                int x = r + rad * dirA[d][0];
                int y = c + rad * dirA[d][1];

                if (x >= 0 && y >= 0 && x < boxes.length && y < boxes[0].length) {
                    if (boxes[x][y]) {
                        return false;
                    }
                } else {
                    break;
                }
            }
        }
        return true;
    }

    // combinatin2d using subsequence
    public static int queenCombiSub2D(boolean[][] tnb, int idx, int tnq, String ans) {
        int n = tnb.length;
        int m = tnb[0].length;
        if (tnq == 0 || idx == n * m) {
            if (tnq == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        int r = idx / m;
        int c = idx % m;

        count += queenCombiSub2D(tnb, idx + 1, tnq - 1, ans + "(" + r + "," + c + ")");

        count += queenCombiSub2D(tnb, idx + 1, tnq, ans);

        return count;
    }

    // create 4 array for the queen replacement using combination using 4 array
    public static int queenncombiarr(int[][] tnb, int[] row, int[] col, int[] diag1, int[] diag2, int idx, int tnq,
            String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;

        }
        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (row[r] == 0 && col[c] == 0 && diag1[r + c] == 0 && diag2[r - c + m - 1] == 0) {
                
                tnb[r][c] = 1;
                row[r] = 1;
                col[c] = 1;
                diag1[r + c] = 1;
                diag2[r - c + m - 1] = 1;

                
                count += queenncombiarr(tnb, row, col, diag1, diag2, i + 1, tnq - 1, ans + " ( " + r + "," + c + " ) ");

                
                tnb[r][c] = 0;
                row[r] = 0;
                col[c] = 0;
                diag1[r + c] = 0;
                diag2[r - c + m - 1] = 0;
            }
        }
        return count;
    }
    //now permutation using  4 array to place the queen to reduced time
    static boolean[] row;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    static int n,m;

    public static int queenpermutationarr(int n,int m,int idx,int tnq,String ans){
        if(tnq==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0;i<n*m;i++){
            int r= i/m;
            int c= i%m;
            if (!row[r] && !col[c] && !diag1[r + c] && !diag2[r - c + m - 1]) {
                row[r] = true;
                col[c] = true;
                diag1[r + c] = true;
                diag2[r - c + m - 1] = true;

                count += queenpermutationarr(n, m, idx + 1, tnq - 1, ans + "(" + r + "," + c + ") ");

                row[r] = false;
                col[c] = false;
                diag1[r + c] = false;
                diag2[r - c + m - 1] = false;
        }
    }
    return count;
}



    public static void main(String args[]) {
        // int[] arr={2,3,5,7};
        // int tar= 10;
        // permutations
        // int totalcount = permutationinfcoins(arr, tar, "");
        // System.out.println("total permutations" +totalcount);

        // combinations
        // int result = combinationinf(arr, 0, tar, "");
        // System.out.println("total combinations:"+result);

        // coin once only should print in combination
        // int myans= combinationcoin(arr, 0, tar, "");
        // System.out.println("One coin:"+myans);

        // coin once only should print in permutation
        // int res= permutationOneCoin(arr, tar, "");
        // System.out.println("One permutation:"+res);

        // combination for infinite coins using subsequence
        // int myans = combinationinfcoinsub(arr,tar,0,"");
        // System.out.println("Total combinations using subsequnce :" +myans);

        // combination for only one time coin used using subsequence
        // int res= combinationonecoinsub(arr,tar,0,"");
        // System.out.println("total combination using one coin:"+res);

        // permutation subsequence for ifinite coin
        // int res= permutationinfcoinsub(arr, tar, 0, "");
        // System.out.println("total permutation:"+res);

        // permutation subsequnece for one time coin use
        // int myans = permutationonecoinsub(arr, tar, 0, "");
        // System.out.println("total permutation:"+myans);

        // equalset
        // int[]arr={10,20,30,40,50,60,70};
        // int result= findsubset(arr,0, 0, 0, "", "");
        // System.out.println("Total Pairs:"+result);
        // unique way non repeated values
        // int res= findsubsetunique(arr,1, arr[0] , 0, arr[0] + "","");
        // System.out.println("Total Pairs:"+res);

        // String str = "abca";
        // permutationstr(str, "");
        // permutationstrunique(str, "");
        // permutationstrunique1("abcd", "", '$');
        // int totalstairs = 5;
        // StairPr(totalstairs, "",0);

        // queen placing
        // int totalboxes= 5;
        // int totalqueens = 4;
        // int result = queenCombination1D(totalboxes, 0, totalqueens,0, "");
        // System.out.println(result);
        // int result = Permutation1D(totalboxes, totalqueens, 0,new
        // boolean[totalboxes], "");
        // 4 queen placing in 5 box using combination
        // int totalboxes = 5;
        int totalqueens = 3;
        // boolean [] vis = new boolean[totalboxes];
        // int result = Queencombi1d(totalboxes, totalqueens, 0, 0, " ");
        // System.out.println("total combination:"+result);
        // int result = Queenper1d(totalboxes, totalqueens, 0, 0, "",vis);
        // System.out.println("total permutation:"+result);

        // boolean tnb[][]= new boolean[3][3];
        // int result = Queencombi2d(tnb, 0, totalqueens, "");
        // System.out.println("total combination2d:"+result);

        // int result = Queenper2d(tnb, 0, totalqueens, "");
        // System.out.println("total permutation:"+result);
        // boolean[][] boxes= new boolean[n][m];
        // int result = Nqueenscombi(boxes, 0, totalqueens, "");
        // System.out.println("total combi:"+result);

        // int result = NqueensPermut(boxes,0, totalqueens, "");
        // System.out.println("Total permutations: " + result);

       // int result = queenCombiSub2D(tnb, 0, totalqueens, "");
        //System.out.println("total combinationsub:" + result);

       /*  int n = 4;
        int m = 4;
        int[][] tnb = new int[n][m]; 
        int[] row = new int[n];
        int[] col = new int[m];
        int[] diag1 = new int[n + m - 1];
        int[] diag2 = new int[n + m - 1];
        int result= queenncombiarr(tnb, row, col, diag1, diag2, 0, 4, "");
        System.out.println("total path:"+result);*/
        
        n = 4;
        m = 4;
        row = new boolean[n];
        col = new boolean[m];
        diag1 = new boolean[n + m - 1]; 
        diag2 = new boolean[n + m - 1];
        int result = queenpermutationarr(n, m, 0, n, "");
        System.out.println("Total paths: " + result);

    }
}
