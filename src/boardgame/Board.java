package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][]  pieces;

    public Board(int rows, int columns) throws BoardException {
        if(rows < 1 || columns < 1){
            throw new BoardException("number of rows/columns must be grater tan 0");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

     public Piece piece(int row, int column){
        if (!positionExists(row,column)){
             throw new BoardException("Invalid position ");
         }else return pieces[row][column];
     }
     public Piece piece(Position position){
         if (!positionExists(position.getRow(),position.getColumn())){
             throw new BoardException("Invalid position ");
         }else return pieces[position.getRow()][position.getColumn()];
     }

     public void placePiece(Piece piece, Position position){
         if (thereIsAPiece(position)){
             throw new BoardException("There is already a piece on posistion " + position);
         }else{
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
         }

     }
     private boolean positionExists(int row, int column){
           return row >=0 && row < rows &&column >=0 && column < columns;
     }

     public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
     }

     public boolean thereIsAPiece(Position position){
         if (!positionExists(position.getRow(),position.getColumn())){
             throw new BoardException("Invalid position ");
         }else return piece(position) != null;
     }

}



