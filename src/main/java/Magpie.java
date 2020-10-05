/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (statement.indexOf("cat") >= 0
                || statement.indexOf("dog") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (statement.indexOf("Mr.") >= 0)
        {
            response = "He sounds like a good teacher.";
        }
        else if (statement.indexOf("Mrs.") >= 0)
        {
            response = "She sounds like a good teacher. ";
        }
        else if (statement.trim() == "")
        {
            response = "Say something, please.";
        }
        else if (statement.indexOf("sad") >= 0)
        {
            response = "Would you like some tissues?";
        }
        else if (statement.indexOf("guitar") >= 0
                || statement.indexOf("drums") >= 0
                || statement.indexOf("piano") >= 0)
        {
            response = "I bet you are really good at making music.";
        }
        else if (statement.indexOf("thank") >= 0)
        {
            response = "You are welcome.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 1)
        {
            response = "Are you compleatly sure?";
        }
        else if (whichResponse == 2)
        {
            response = "No way!";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        String str2 = str.toLowerCase();
        int num = str2.indexOf(word);
        String space = " ";
        if (num == -1)
        {
            return num;
        }
        else if (num == 0)
        {
            if (str2.charAt(num + 2) == space.charAt(0))
            {
                return num;
            }
        }
        else if (num == str.length())
        {
            if (str2.charAt(num - 1) == space.charAt(0))
            {
                return num;
            }
        }
        else if (str2.charAt(num + 2) == space.charAt(0) && (str2.charAt(num - 1) == space.charAt(0)))
        {
            return num;
        }
        else
        {
            return -1;
        }
    }
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {   
        String response = "Would you really be happy if you had " + statement.substring(7, (statement.length())) + "?";
        return response;
     }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        String response = "Why do you " + statement.substring(2, statement.indexOf("you")) + "me?";
        return response;
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        String response = "What would it mean to " + statement.substring(10, statement.length()) + "?";
        return response;
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        String response = "What makes you think that I " + statement.substring(statement.indexOf("you") + 4, statement.indexOf("me")) + "you?";
        return response;
    }
}
