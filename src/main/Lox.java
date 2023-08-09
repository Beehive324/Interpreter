package main;

//executes from souce
public class Lox {

    static boolean hadError = False;

    public static void main(String[] args) throws Exception {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]"); 
            System.exit(64); //exit code
        } else if (args.length == 1) {
            runFile(args[0]);
        }else{
            runPrompt(); // call the method runPrompt
        }
        if hadError System.exit(65);
        }
    
        // Read a line of input, evaluate it, print the result and then loop and then repear the process again
        private static void runPrompt() throws IOException {
            InputStreamReader input = new InputStreamReader(System.in); //new StreamReader object
            BufferedReader reader = new BufferedReader(input) // new Bffered reader takes input as an parameter

            for(;;) { 
                System.out.print("> ");
                String line = reader.readLine(); // readline function, reads a line of input from the user on the command line and returns the result
                if (line == null) break;
                run(line);
                hadError = False;
            }
        }
        
        
        //Run method
        private static void run(String source) {
            Scanner scanner = new Scanner(source); //reading the input from the string
            List<Token> tokens = scanner.scanTokens() // reading from the token class

            for (Token token : tokens) { //Prints out the tokens
                System.out.println(token);
            }
        }
        
        //Error handling
        static void error(int line, message) {
            report(line, "", message;)
        }

        private static void(int line, String where, String message) {
            System.err.println(
        "[line " + line + "] Error" + where + ": " + message);
    hadError = true;
  }      
        

        }
    

