package TicTacToe;

import TicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){

        //creating 2 players
        players=new LinkedList<>();
        PieceX crossPiece=new PieceX();
        Player player1=new Player("Player1",crossPiece);

        PieceO noughtPiece=new PieceO();
        Player player2=new Player("Player2",noughtPiece);

        players.add(player1);
        players.add(player2);

        //initializeBoard
        gameBoard=new Board(3);
    }

    public String startGame(){
        boolean noWinner=true;

        while(noWinner){
            //take out the player whose turn is and also put the player in the list back
            Player playerTurn=players.removeFirst();

            //get the free space from the board
            gameBoard.printBoard();
            List<Pair<Integer,Integer>>freeSpaces=gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }

            //read the user input
            System.out.print("Player:" + playerTurn.name + "Enter row,column: ");
            Scanner inputScanner=new Scanner(System.in);
            String s=inputScanner.nextLine();
            String[] values=s.split(",");
            int inputRow=Integer.parseInt(values[0]);
            int inputColumn=Integer.parseInt(values[1]);

            //place the piece
            boolean pieceAddedSuccessfully=gameBoard.addPiece(inputRow,inputColumn, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully){
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen,try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner=isThereWinner(inputRow,inputColumn,playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.name;
            }



        }
        return "tie";

    }

    public boolean isThereWinner(int row,int column,PieceType pieceType){
        boolean rowMatch=true;
        boolean columnMatch=true;
        boolean diagonalMatch=true;
        boolean antiDiagonalMatch=true;

        //need tp check in row
        for(int i=0;i< gameBoard.size;i++){
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType!=pieceType){
                rowMatch= false;
                break;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][column]==null || gameBoard.board[i][column].pieceType!=pieceType){
                columnMatch= false;
                break;
            }
        }

        //need to check diagonals
        for(int i=0,j=0;i<gameBoard.size;i++,j++){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType){
                diagonalMatch= false;
                break;
            }
        }

        //need to check in antidiagonal
        for(int i=0,j=gameBoard.size-1;i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType){
                antiDiagonalMatch= false;
                break;
            }
        }

        return rowMatch||columnMatch||diagonalMatch||antiDiagonalMatch;
    }

}
