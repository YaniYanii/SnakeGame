import java.util.Random;

public class Board {

    private final Cell[][] cells;
    private final int totalRows;
    private final int totalColumns;

    public Board(int rows, int columns){
        int WALLS_SIDE = 2;

        totalRows = rows +WALLS_SIDE;
        totalColumns = columns + WALLS_SIDE;

        cells = new Cell[totalRows][totalColumns];
        initBoard();

    }

    public void showBoard(){

        for(int i = 0; i < totalRows; ++i){
            for(int j = 0; j < totalColumns; ++j){
                System.out.print(cells[i][j].getSign());
            }
            System.out.println();
        }
    }

    public Cell getCentralCell(){
        return cells[totalRows/2][totalColumns/2];
    }

    public Cell getCell(int row, int column){
        return cells[row][column];
    }

    public void setFoodInRandomCell(){
        Random random = new Random();

        int MIN = 1; //included
        int MAX_COL =  totalColumns - 1; //excluded
        int MAX_ROW =  totalRows - 1; //excluded

        int randomRow = random.nextInt(MAX_ROW - MIN) + MIN;
        int randomCol = random.nextInt(MAX_COL - MIN) + MIN;

        cells[randomRow][randomCol].setCellType(CellType.FOOD).setSign('@');
    }

    private void initBoard(){
        for(int i = 0; i < totalRows; ++i){
            for(int j = 0; j < totalColumns; ++j){
                cells[i][j] = new Cell(i,j);
            }
        }
        initWalls();
    }

    private void initWalls(){

        for(int i = 0; i < totalColumns; ++i){
            cells[0][i].setSign('#').setCellType(CellType.WALL);
            cells[totalRows-1][i].setSign('#').setCellType(CellType.WALL);
        }

        for(int i = 0; i < totalRows; ++i){
            cells[i][0].setSign('#').setCellType(CellType.WALL);
            cells[i][totalColumns -1].setSign('#').setCellType(CellType.WALL);
        }
    }



}
