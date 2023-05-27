import java.util.LinkedList;


public class Snake {
    private LinkedList<Cell> body = new LinkedList<>();


    public Snake(Cell startCell){
        body.addFirst(startCell);
    }

    public Cell getHead(){
        return body.getFirst();
    }

    public void moveAndFeed(Cell nextHead){
        nextHead.setCellType(CellType.SNAKE_BODY).setSign('o');
        body.addFirst(nextHead);
    }

    public void move(Cell nextHead){
        moveAndFeed(nextHead);
        removeLastTail(); // remove
    }

    private void removeLastTail(){
        Cell tail = body.removeLast();
        tail.setCellType(CellType.EMPTY).setSign(' ');
    }

}

/*char arrowUp =
char arrowDown = '\u2193';
char arrowLeft = '\u2190';
char arrowRight = '\u2192';*/
