import java.util.*;
public class MatrixMult {
	static Scanner in = new Scanner(System.in);
	
	static int[][] readMat(int r, int c){
		
		int mat[][] = new int[r][c] ;
		for(int i=0; i<r;i++) {
			for(int j = 0; j<c; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		return mat;
	}
	static void displayMat(int mat[][],int r, int c){
		
		for(int i=0; i<r;i++) {
			for(int j = 0; j<c; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		
		int mat1[][], mat2[][], r1, r2, c1, c2, mult[][];
		System.out.println("Enter row and colums of 1st");
		

		r1 = in.nextInt();
		c1 = in.nextInt();

		System.out.println("Enter mat values");
		mat1 = readMat(r1, c1);
		displayMat(mat1,r1,c1);
		
		System.out.println("Enter row and colums of 2ns");
		

		r2 = in.nextInt();
		c2 = in.nextInt();

		System.out.println("Enter mat values");
		mat2 = readMat(r2, c2);
		displayMat(mat2,r2,c2);
		
		if(c2 == r1) {
			mult = productMat(mat1, mat2, r1, c1, r2, c2);
			displayMat(mult,r1,c2);
		}else {
			System.out.println("Not possible");
		}
		MatrixMult m = new MatrixMult();
		m.toString();
		
	}
	static int[][] productMat(int[][] mat1, int[][] mat2, int r1, int c1, int r2, int c2) {
		// TODO Auto-generated method stub
		int mult[][] = new int[r1][c2];
		
		for(int i=0; i<r1;i++) {
			for(int j = 0; j<c2; j++) {
				mult[i][j] = 0;
				for(int k=0; k<c1; k++) {
					mult[i][j] += mat1[i][k]*mat2[k][j];
				}
			}
		}
		
		
		return mult;
		
		
	}
}
