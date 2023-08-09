package main;


public class Lox {
    public static void main(String[] args) throws Exception {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]"); 
            System.exit(64); //exit code
        } else if (args.length == 1) {
            runFile(args[0]);
        }else{
            runPrompt(); // call the method runPrompt
        }
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
            }
        }
        
        
    }

