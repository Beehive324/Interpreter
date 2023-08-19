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
        char c = advance();
        switch (c) {
            case '(': addToken(LEFT_PAREN); break;
            case ')': addToken(RIGHT_PAREN); break;
            case '{': addToken(LEFT_BRACE); break;
            case '}': addToken(RIGHT_BRACE); break;
            case ',': addToken(COMMA); break;
            case '.': addToken(DOT); break;
            case '-': addToken(MINUS); break;
            case '+': addToken(PLUS); break;
            case ';': addToken(SEMICOLON); break;
            case '*': addToken(STAR); break; 
            //Operators
            case '!':
                addToken(match('=') ? BANG_EQUAL : BANG);
                break;
            case '=':
                addToken(match('=') ? EQUAL_EQUAL : EQUAL);
                break;
            case '<':
                addToken(match('=') ? LESS_EQUAL : LESS);
                break;
            case '>':
                addToken(match('=') ? GREATER_EQUAL : GREATER);
                break;
            case '/':
                if (match('/')){
                    while (peek() != '\n' && !isAtEnd()) advance();
                }else{
                    addToken(SLASH)''
                }
                }
             default:
        Lox.error(line, "Unexpected character.");
        break;
    }
        
    }


    // advance method consumes the next character in the source file and returns it
    //Advance is for input
    private char advance() {

        return source.charAt(current++);

    }
    //Grabs the text of the current lexeme and creates a new token for it 
    private void addToken(TokenType TokenType){
        addToken(type, null);
    }

    private void addToken(TokenType type, Obejct literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }

    private boolean match(char expected) {
        if(isAtEnd()) return false;
        if(souce.charAt(current) != expected) return false;

        current++;
        return true;


    }

    //Looks at the currenct unconsumed character
    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

