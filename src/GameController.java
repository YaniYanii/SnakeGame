import java.util.HashMap;
import java.util.function.Function;


public class GameController {

    private final Board board = new Board(10,30);
    private final Snake snake;

    private final HashMap<String, Function<Void,Cell>> mapFuncByDir = new HashMap<>();
    private String curDir;

    private final long CONTROL_GAME_SPEED = 500;
    private boolean gameOver = false;

    public GameController(String  left, String  up, String  right, String down){
        Cell startCellSnake = board.getCentralCell().setCellType(CellType.SNAKE_BODY).setSign('o');
        snake = new Snake(startCellSnake);

        mapFuncByDirInit(left, up, right, down);
    }


    public void play(){

        Cell nextMove = null;
        board.setFoodInRandomCell();

        while(true){
            board.showBoard();
            controlSpeed();
            String key = readKeyInput();

            if(isValidDir(key)){
                curDir = key;
            }
            nextMove = mapFuncByDir.get(curDir).apply(null);

            if(checkCrushed(nextMove)){
                System.out.println("Game Over!");
                break;
            } else if (isFood((nextMove))) {
                snake.moveAndFeed(nextMove);
                board.setFoodInRandomCell();
                continue;
            }else {
                snake.move(nextMove);
            }
            cleanConsole();
        }
    }

    private  boolean isFood(Cell nextMove){
        return  nextMove.getCellType() == CellType.FOOD;
    }

    private boolean checkCrushed(Cell nextMove){
        return nextMove.getCellType() == CellType.WALL || nextMove.getCellType() == CellType.SNAKE_BODY;
    }

    private boolean isValidDir(String key){
        return mapFuncByDir.containsKey(key);
    }
    
    private void controlSpeed(){
        try {
            Thread.sleep(CONTROL_GAME_SPEED);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public String  readKeyInput() {
        try {
            if (System.in.available() > 0) {
                byte[] bytes = new byte[System.in.available()];
                System.out.println(System.in.read(bytes));
                return new String(bytes).trim().toLowerCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NON";
    }

    private void mapFuncByDirInit(String  left, String  up, String  right, String down){
        curDir = up;
        mapFuncByDir.put(left, (Void)-> {
            return board.getCell(snake.getHead().getRow(), snake.getHead().getColumn()-1);
        });
        mapFuncByDir.put(right,  (Void)-> {
            return board.getCell(snake.getHead().getRow(), snake.getHead().getColumn()+1);
        });
        mapFuncByDir.put(up,  (Void)-> {
            return board.getCell(snake.getHead().getRow()-1, snake.getHead().getColumn());
        });
        mapFuncByDir.put(down,  (Void)-> {
            return board.getCell(snake.getHead().getRow()+1, snake.getHead().getColumn());
        });
    }

    private void cleanConsole(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
