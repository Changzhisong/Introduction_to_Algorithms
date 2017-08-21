package song.matrix;

public class Matix {
	private int rows;
	private int cols;
	private int[][] mat ;
	public Matix(int row,int col ) {
		super();
		this.rows = row;
		this.cols = col;
		this.mat = new int[row][col];
	}
	public Matix(int[][] mat) {
		super();
		this.rows = mat.length;
		this.cols = mat[0].length;
		this.mat = mat;
	}
	
	public Matix add(Matix A , Matix B){
		//还应该有A，B不可加的情况判断
		if(A.rows!=B.rows|(A.cols!=B.cols)){
			System.out.println("A,B不可加");
			return null;
		}
		Matix m =new Matix(A.rows,A.cols);
		for(int i =0 ;i<m.rows;i++){
			for(int j = 0;j<m.cols;j++){
				m.setValue(i, j, A.getValue(i, j)+B.getValue(i, j));
			}
		}
		return m;
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public int[][] getMat() {
		return mat;
	}
	
	public int getValue(int i,int j){
		return mat[i][j];
	}
	public void setValue(int i,int j,int val){
		mat[i][j] = val;
	}
	
}
