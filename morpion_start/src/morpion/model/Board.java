package morpion.model;

/**
 * 棋盘类
 *
 */
public class Board {
	/** 棋盘二维数组 */
	private int[][] blocks;
	/** 棋盘大小，3x3或更多 */
	private int size;
	
	public Board(int s){
		this.size = s;
		this.blocks = new int[s][];
		for(int i=0; i<s; i++){
			this.blocks[i] = new int[s];
		}
		
		for(int i=0; i<s; i++){
			for(int j=0; j<s; j++){
				// 0 代表空格
				this.blocks[i][j] = 0;
			}
		}
	}
	
	/**
	 * 检查每行或每列或者对角线中是否有相同的标记
	 * @return 如果没找到有相同标记的行返回-1，如果有则返回标记
	 */
	public int checkConnectedMark(){
		int mark;
		boolean not_found = true;
		
		// 检查每一行
		for(int i=0; i<this.size; i++){
			not_found = false;
			mark = this.blocks[i][0];
			for(int j=1; j<this.size; j++){
				if(mark != this.blocks[i][j] || this.blocks[i][j] == 0){
					not_found = true;
					break;
				}
			}
			if(!not_found){
				return mark;
			}
		}
		
		// 检查每一列
		for(int j=0; j<this.size; j++){
			not_found = false;
			mark = this.blocks[0][j];
			for(int i=1; i<this.size; i++){
				if(mark != this.blocks[i][j]  || this.blocks[i][j] == 0){
					not_found = true;
					break;
				}
			}
			if(!not_found){
				return mark;
			}
		}
		
		// 检查对角线
		not_found = false;
		mark = this.blocks[0][0];
		for(int i=1; i<this.size; i++){
			if(mark != this.blocks[i][i] || this.blocks[i][i] == 0){
				not_found = true;
				break;
			}
		}
		if(!not_found){
			return mark;
		}
		
		// 检查另一条对角线
		not_found = false;
		mark = this.blocks[0][this.size-1];
		for(int i=1; i<this.size; i++){
			if(mark != this.blocks[i][this.size-1-i] || this.blocks[i][i] == 0){
				not_found = true;
				break;
			}
		}
		if(!not_found){
			return mark;
		}
		
		return -1;
	}
	
	/**
	 * 返回当前棋盘是否已填满
	 * @return 已填满则返回真
	 */
	public boolean isFull(){
		for(int i=0; i<this.size; i++){
			for(int j=0; j<this.size; j++){
				if(this.blocks[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	public String toString(){
		String s = "---\n|";
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++){
				s += this.blocks[i][j]+"|";
			}
			s += "\n";
		}
		s += "---";
		return s;
	}

	public void setBlock(int x, int y, int mark) {
		this.blocks[x][y] = mark;
	}
	
	public int getBlock(int x, int y){
		return this.blocks[x][y];
	}

	public int[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(int[][] blocks) {
		this.blocks = blocks;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
