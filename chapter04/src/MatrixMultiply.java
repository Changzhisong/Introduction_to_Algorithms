package song.matrix;

public class MatrixMultiply {
	public static void main(String[] args) {
		MatrixMultiply mm = new MatrixMultiply();
		int[][] a = { { 1, 2, 3 }, { 3, 4, 5 }, { 1, 2, 2 } };
		int[][] b = { { 2, 4, 3 }, { 2, 3, 5 }, { 1, 2, 3 } };
		Matix A = new Matix(a);
		Matix B = new Matix(b);

		// Matix C=mm.matrixMult(A, B);
		Matix C = mm.matrixMultRecur(A, B);

		if (C == null) {
			return;
		}
		for (int i = 0; i < C.getRows(); i++) {
			for (int j = 0; j < C.getCols(); j++) {
				System.out.print(C.getValue(i, j) + " ");
			}
			System.out.println();
		}
	}

	// 朴素方法O(n^3)
	public Matix matrixMult(Matix A, Matix B) {
		if (A.getCols() != B.getRows()) {
			System.out.println("矩阵A和B不能相乘");
			return null;
		}
		int n = A.getRows();
		int t = B.getCols();
		int m = A.getCols();
		Matix C = new Matix(n, t);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < t; j++) {
				int val = 0;
				for (int k = 0; k < m; k++) {
					val += (A.getValue(i, k) * B.getValue(k, j));
				}
				C.setValue(i, j, val);
			}
		}
		return C;
	}

	// 分治递归法O(n^3)
	public Matix matrixMultRecur(Matix A, Matix B) {
		if (A.getCols() != B.getRows()) {
			System.out.println("矩阵A和B不能相乘");
			return null;
		}
		int n = A.getRows();
		int t = B.getCols();
		int m = A.getCols();
		Matix C = new Matix(n, t);
		if (n == 1 | m == 1 | t == 1) {
			return matrixMult(A, B);
		} else if (n > 1 & t > 1 & m > 1) {
			// 拆分矩阵
			Matix A11 = new Matix(n / 2, m / 2);
			for (int i = 0; i < A11.getRows(); i++) {
				for (int j = 0; j < A11.getCols(); j++) {
					A11.setValue(i, j, A.getValue(i, j));
				}
			}
			Matix A12 = new Matix(n / 2, m - m / 2);
			for (int i = 0; i < A12.getRows(); i++) {
				for (int j = m / 2; j < A.getCols(); j++) {
					A12.setValue(i, j - m / 2, A.getValue(i, j));
				}
			}

			Matix A21 = new Matix(n - n / 2, m / 2);
			for (int i = n / 2; i < A.getRows(); i++) {
				for (int j = 0; j < A21.getCols(); j++) {
					A21.setValue(i - n / 2, j, A.getValue(i, j));
				}
			}
			Matix A22 = new Matix(n - n / 2, m - m / 2);
			for (int i = n / 2; i < A.getRows(); i++) {
				for (int j = m / 2; j < A.getCols(); j++) {
					A22.setValue(i - n / 2, j - m / 2, A.getValue(i, j));
				}
			}

			Matix B11 = new Matix(m / 2, t / 2);
			for (int i = 0; i < B11.getRows(); i++) {
				for (int j = 0; j < B11.getCols(); j++) {
					B11.setValue(i, j, B.getValue(i, j));
				}
			}
			Matix B12 = new Matix(m / 2, t - t / 2);
			for (int i = 0; i < B12.getRows(); i++) {
				for (int j = t / 2; j < B.getCols(); j++) {
					B12.setValue(i, j - t / 2, B.getValue(i, j));
				}
			}
			Matix B21 = new Matix(m - m / 2, t / 2);
			for (int i = m / 2; i < B.getRows(); i++) {
				for (int j = 0; j < B21.getCols(); j++) {
					B21.setValue(i - m / 2, j, B.getValue(i, j));
				}
			}
			Matix B22 = new Matix(m - m / 2, t - t / 2);
			for (int i = m / 2; i < B.getRows(); i++) {
				for (int j = t / 2; j < B.getCols(); j++) {
					B22.setValue(i - m / 2, j - t / 2, B.getValue(i, j));
				}
			}
			//递归调用
			Matix C11 = new Matix(A11.getRows(), B11.getCols());
			C11 = C11.add(matrixMultRecur(A11, B11), matrixMultRecur(A12, B21));
			Matix C12 = new Matix(A12.getRows(), B12.getCols());
			C12 = C12.add(matrixMultRecur(A11, B12), matrixMultRecur(A12, B22));
			Matix C21 = new Matix(A21.getRows(), B21.getCols());
			C21 = C21.add(matrixMultRecur(A21, B11), matrixMultRecur(A22, B21));
			Matix C22 = new Matix(A22.getRows(), B22.getCols());
			C22 = C22.add(matrixMultRecur(A21, B12), matrixMultRecur(A22, B22));
			//合并形成矩阵C
			for (int i = 0; i < C11.getRows(); i++) {
				for (int j = 0; j < C11.getCols(); j++) {
					C.setValue(i, j, C11.getValue(i, j));
				}
			}
			for (int i = 0; i < C12.getRows(); i++) {
				for (int j = 0; j < C12.getCols(); j++) {
					C.setValue(i, j + C11.getCols(), C12.getValue(i, j));
				}
			}
			for (int i = 0; i < C21.getRows(); i++) {
				for (int j = 0; j < C21.getCols(); j++) {
					C.setValue(i + C11.getRows(), j, C21.getValue(i, j));
				}
			}
			for (int i = 0; i < C22.getRows(); i++) {
				for (int j = 0; j < C22.getCols(); j++) {
					C.setValue(i + C11.getRows(), j + C11.getCols(), C22.getValue(i, j));
				}
			}

		}
		return C;
	}
	
	//Strassen 算法 
	//略
}
