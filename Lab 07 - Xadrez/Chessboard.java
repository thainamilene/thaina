public class Chessboard{
    Pieces[][] board = new Pieces[8][8];
    int[] KingBranco = {0,4}; //guarda a posicao do rei no tabuleiro
    int[] KingPreto = {7,3};
    
    Chessboard() {
		for (int i=0; i<8; i++) { //inicializa o tabuleiro vazio
			for (int j=0; j<8; j++) {
				board[i][j] = new Pieces(i,j);							
			}			
        }
    }
    
    void moviment(int line, int column, int fline, int fcolumn, char type) {
        if (type == 'p' || type == 'P') {
            board[fline][fcolumn] = new Paw(board[line][column].color, board[line][column].state, fline, fcolumn, type, board[line][column].count);
        }
        else if (type == 'b' || type == 'B') {
            board[fline][fcolumn] = new Bishop(board[line][column].color, board[line][column].state, fline, fcolumn, type, board[line][column].count);
        }
        else if (type == 't' || type == 'T') {
            board[fline][fcolumn] = new Tower(board[line][column].color, board[line][column].state, fline, fcolumn, type, board[line][column].count);
        }
        else if (type == 'h' || type == 'H') {
            board[fline][fcolumn] = new Horse(board[line][column].color, board[line][column].state, fline, fcolumn, type, board[line][column].count);
        }
        else if (type == 'q' || type == 'Q') {
            board[fline][fcolumn] = new Queen(board[line][column].color, board[line][column].state, fline, fcolumn, type, board[line][column].count);
        }
        else if (type == 'k' || type == 'K') {
            board[fline][fcolumn] = new King(board[line][column].color, board[line][column].state, fline, fcolumn, type, board[line][column].count);
            if(board[line][column].color == 'B') {//atualiza a posicao do rei no tabuleiro
                KingBranco[0] = fline;
                KingBranco[1] = fcolumn;
            }
            else{
                KingPreto[0] = fline;
                KingPreto[1] = fcolumn;
            }
        }
        board[line][column].color = '-';
        board[line][column].state = false;
        board[line][column].type = '-';
        printOut();
    }

    void printOut() {//imprime o tabuleiro
		for(int i=8; i>0; i--) {
				System.out.print (i); 				
				System.out.print (' '); 				
				for (int j=0; j<8; j++) {
					if (board[i-1][j].state == true) {
						System.out.print (board[i-1][j].type);
					} else{
						System.out.print ('-');
					}
						System.out.print (' '); 				 						
				}
				System.out.println();
			}
			System.out.println("  a b c d e f g h\n");
	return;
	}
}