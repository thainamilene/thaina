public class Bishop extends Pieces{ 
    
    public Bishop (char color, boolean state, int line, int column, char type){
        super(color, state, line, column, type);
    }
    
    boolean checkMoviment(int fline, int fcolumn, Chessboard chess, boolean transforms, char newtype){
        if (chess.board[fline][fcolumn].state ==true && chess.board[fline][fcolumn].color == color) {//verifica se o destino nao ha uma peca da mesma cor
            return false;
        }
        if (((fline-line) * (fline-line)) == ((fcolumn-column) * (fcolumn-column))) {//verifica se esta indo na diagonal
            if (line - fline < 0) { //indo para frente
                if (column - fcolumn < 0){ //direita
                    int k = 1;
                    for (int i = 1; i < (fline-line); i++) {
                        if(chess.board[line+i][column+k].state) {
                            return false;
                        }
                        k++;                   
                    }
                } 
                else if (fcolumn-column>0){ //esquerda
                    int k = 1;
                    for (int i = 1; i < (fline-line); i++) {
                        if(chess.board[line+i][column-k].state) {
                            return false;
                        }
                        k++;                   
                    }
                }
                else{
                    return false;
                }
            }
            else if (fline - line < 0) { //indo para tras
                if (column - fcolumn < 0){ //direita
                    int k = 1;
                    for (int i = 1; i < (line-fline); i++) {
                        if(chess.board[line-i][column+k].state) {
                            return false;
                        }
                        k++;                   
                    }
                } 
                else if (fcolumn - column<0){ //esquerda
                    int k = 1;
                    for (int i = 1; i < (line-fline); i++) {
                        System.out.println("here i am");
                        if(chess.board[line-i][column-k].state) {
                            return false;
                        }
                        k++;                   
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        
	chess.moviment(line, column, fline, fcolumn, type);
	return true;
	}	
}