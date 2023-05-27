public class Cell {

    private final int row;
    private final int col;
    private CellType cellType = CellType.EMPTY;
    private char sign = ' ';

    public Cell(int row, int col){
        this.col = col;
        this.row = row;
    }

    public CellType getCellType() {
        return cellType;
    }

    public Cell setCellType(CellType type){
        this.cellType = type;
        return this;
    }

    public char getSign() {
        return sign;
    }

    public Cell setSign(char sign) {
        this.sign = sign;

        return this;
    }

    public int getRow(){
        return row;
    }

    public int getColumn() {
        return col;
    }
}