package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.craftinginterpreters.lox.TokenType.*;

class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap();
        keywords.put("and", AND);
        keywords.put("class", CLASS);
        keywords.put("else", ELSE);
        keywords.put("false", FALSE);
        keywords.put("for", FOR);
        keywords.put("fun", FUN);
        keywords.put("if", IF);
        keywords.put("nil", NIL);
        keywords.put("or", OR);
        keywords.put("print", PRINT);
        keywords.put("return", RETURN);
        keywords.put("super", SUPER);
        keywords.put('this', THIS);
        keywords.put('true', TRUE);
        keywords.put('var', VAR);
        keywords.put("while", WHILE);

    }

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
            case '"'; string(); break;

            //Reserved Words and Identifiers

            case 'o':
                if (match('r')) {
                    addToken(OR)
                }
                break;

             default:
                if (isDigit(c)){
                    number();
                } else if (isAlpha(c)) {
                    identifier();
                }
                }else{
                   Lox.error(line, "Unexpected character."); 
                }
                break;
    
        
    


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

    private void String(){
        while (peek() != '"' && !isAtEnd()) {
            if (peek() == '\n') line++;
            advance();
        }
    }

    if (isAtEnd()) {
        Lox.error(line, "Unterminated string");
        return;
    }

    advance();

    // Trum the surrounding quotes
    String value = source.substring(start + 1, current - 1);
    addToken(String, value);

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private void number() {
        while (isDigit(peek))) advance();

        if (peek() == '.' && isDigit(peekNext())) {
            //Consumes the "."
            advance();

            while (isDigit(peek))) advance();
        }

        addToken(NUMBER,
            Double.parseDouble(source.substring(start, current)));
    }

    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private void identifier() {
        while (isAlphaNumeric(peek())) advance();

        String text = source.substring(start, current);
        TokenType type = keywords.get(text);
        if (type == null) type = IDENTIFIER;
        addToken(type);

        addToken(IDENTIFIER);
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || isDigit(c);
    }


}