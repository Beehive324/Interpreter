package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.craftinginterpreters.lox.TokenType.*;

class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    //loop to keep track of where the scanner is pointing at in the source code
    private int start;
    private int current;
    private int end;
    

    //scanners works through the source code, adding characters until it runs out of characters
    List<Token> scanTokens() {
        while (!isAtEnd()) {

            start = current;
            scanToken();
        }

        tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }

    Scanner(String source){
        this.source = source;
    }

    //this is true when the scanner is pointing at the end
    private boolean isAtEnd() {
        return current >= source.length();

}

    private void scanToken() {
        
    }

}