package A_Array;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Example 3:
Input: matrix = [[1]]
Output: [[1]]

Example 4:
Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]
*/

// 迴圈的限制, 可以利用 len/2 以及 (len+1)/2 控制區域, 
// 對於空間上的旋轉, 可以先從起點附近的x,y關係嘗試 , 基本上嘗試過單數及雙數 4x4, 3,3 即可解決
// 對於紙本考試, 可能需要硬背
public class K_RotateImage {
    public void rotate(int[][] matrix) {
        int temp;
        int n = matrix.length;
        for (int y = 0; y < n / 2; y++) {
            for (int x = 0; x < (n + 1) / 2; x++) {
                // int lt = matrix[x][y]; // lt
                // int rt = matrix[n-y-1][x]; // rt
                // int rd = matrix[n-1-x][n-1-y]; // rd
                // int ld = matrix[y][n-1-x]; // ld
                // System.out.println(String.format("%s,%s = %s,%s = %s,%s = %s,%s",
                // x,y,
                // n-y-1,x,
                // n-1-x,n-1-y,
                // y,n-1-x));

                temp = matrix[x][y];
                matrix[x][y] = matrix[n - y - 1][x];
                matrix[n - y - 1][x] = matrix[n - 1 - x][n - 1 - y];
                matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
                matrix[y][n - 1 - x] = temp;
            }
        }
    }
}
