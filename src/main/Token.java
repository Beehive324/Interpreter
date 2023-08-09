package main



class Token {
    final TokenType type;
    final String lexeme;
    final Object liereal;
    final int line;

    //Token Constructor
    Token(TokenType type, String lexeme, Object literal, int line ){
        this.type = type;
        this.lexeme = lexeme;
        this.liereal = liereal;
        this.line = line;
    }

    public String toString() {
        return type + " " + lexeme + " " + literal;
      }
}