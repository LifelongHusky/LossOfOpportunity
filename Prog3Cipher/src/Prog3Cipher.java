/**
 * This program is designed to set up and use a cipher table  to
 * encode and decode messages.
 *
 * @author Laura Albrant
 */
public class Prog3Cipher {
    // INSTANCE VARIABLES
    char[] keyList; // The array of the characters in the key
    char[][] cipherTable; // The 2d array that holds the cipher table

    private char code;
    private String key;

    // METHODS

    /**
     * @param startLetter The letter the cipher table with start with
     * @return the cipher table
     */
    void setCipherTable(char startLetter) {
        int current = startLetter;
        int end = 'Z';

        for (int i = 0; i < cipherTable.length; i++) {
            for (int j = 0; j < cipherTable[i].length; j++) {
                cipherTable[i][j] = (char) current;
                if (current == end) {
                    current = 'A';
                } else {
                    current++;
                }
//             System.out.print( cipherTable[i][j] + " " );
            }
            if (current == end) {
                current = 'A';
            } else {
                current++;
            }
//          System.out.print( "\n" );
        }
    }


    /**
     * Removes spaces from a string by not inputting them into the new character
     * array. Will be used to set the keyList array.
     *
     * @param list the string that you want to removes spaces from
     * @return a new array of characters without spaces
     */
    char[] removeSpaces(String list) {
        //1st - count spaces
        int spaceCounter = 0;
        for (int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == ' ') {
                spaceCounter++;
            }
        }

        //Make an array of the length without spaces
        char[] newList = new char[list.length() - spaceCounter];

        //fill in array
        for (int j = 0; j < newList.length; j++) {
            if (list.charAt(j) != ' ') {
                newList[j] = list.charAt(j);
            }
        }
        return newList;
    }

    /**
     * Fills the keyList array with characters
     * (no spaces) with the removeSpaces method.
     *
     * @param k the key
     */
    void setKeyList(String k) {
        keyList = removeSpaces(k);
    }

    /**
     * Takes a character and returns its corresponding row/column number.
     *
     * @param letter the intended row/column of cipherTable
     * @return corresponding index integer
     */
    int letterToNumber(char letter) {
        int num = 0; //has to here so 'A' = 0
        for (int n = 'A'; n < letter; n++) {
            num++;
        }
        return num;
    }

    /**
     * Takes a number and returns its corresponding row/column character.
     *
     * @param num the column number you want to change to corresponding letter
     * @return the character of the column
     */
    char numberToLetter(int num) {
        char letter = 'A';
        for (int n = 0; n < num; n++) {
            letter++;
        }
        return letter;
    }

    /**
     * A method to encode a given given letter.
     *
     * @param letter of message to be encoded
     * @param keyPos position of the key for given letter
     * @return the encoded letter
     */
    char encodeLetter(char letter, int keyPos) {
        char newLetter;
        int row,
                col;

        //Determine row
        while (keyPos > keyList.length - 1) {
            keyPos = keyPos - (keyList.length - 1);
        }
        row = letterToNumber(keyList[keyPos]);

        //Determine column
        col = letterToNumber(letter);


        newLetter = cipherTable[row][col];
        return newLetter;
    }

    /**
     * Encodes the given message using the cipherTable
     *
     * @param message
     * @return
     */
    String encode(String message) {
        String result = "";
        message = message.toUpperCase();
        int spotInKey = 0;

        for (int m = 0; m < message.length(); m++) {


            char currentLetter = message.charAt(m), newLetter;

            if (currentLetter == ' ') {
                result = result + " ";
            } else {
                newLetter = encodeLetter(currentLetter, spotInKey);
                result = result + Character.toString(newLetter);
            }

            if (spotInKey == keyList.length - 1) {
                spotInKey = 0;
            } else {
                spotInKey++;
            }
        }
        return result;
    }

    /**
     * A method to decode a given given letter.
     *
     * @param letter of message to be decoded
     * @param keyPos position of the key for given letter
     * @return the decoded letter
     */
    char decodeLetter(char letter, int keyPos) {
        char newLetter;
        int row, col = 0;

        //Determine row
        while (keyPos > keyList.length - 1) {
            keyPos = keyPos - (keyList.length - 1);
        }
        row = letterToNumber(keyList[keyPos]);

        //Determine Column
        SEARCH_LOOP:
        for (int c = 0; c < cipherTable[row].length; c++) {
            if (cipherTable[row][c] == letter) {
                col = c;
                break SEARCH_LOOP;
            }
        }

        newLetter = numberToLetter(col);
        return newLetter;
    }

    /**
     * Decodes a given message
     *
     * @param message the encoded message
     * @return the decoded message
     */
    String decode(String message) {
        String result = "";

        int spotInKey = 0;

        for (int m = 0; m < message.length(); m++) {

            char currentLetter = message.charAt(m), newLetter;

            if (currentLetter == ' ') {
                result = result + " ";
            } else {
                newLetter = decodeLetter(currentLetter, spotInKey);
                result = result + Character.toString(newLetter);
            }

            if (spotInKey == keyList.length - 1) {
                spotInKey = 0;
            } else {
                spotInKey++;
            }
        }
        return result;
    }

        // CONSTRUCTORS
        /**
         * CONSTRUCTOR - initializes code, key,
         *               keyList, and cipherTable
         * @param code user-given code for which the cipherTable starts
         * @param key user-given key which is used to encode and decode the message.
         */
   public Prog3Cipher( char code, String key ){
            this.code = code;
            this.key = key;

            setKeyList(key);

            cipherTable = new char[26][26];
            setCipherTable(code);
        }

        // MAIN (TEST) Method
        /**
         * Tests and enacts the program/ other methods.
         * @param args
         */
   public static void main (String[ ]args ){
       // Testing only works if using VM argument -ea
       Prog3Cipher self = new Prog3Cipher('H', "BABBAGE");
       assert "PHXXF MQYBPKNJ".equals(self.encode("Happy Birthday"));
       assert "HAPPY BIRTHDAY".equals(self.decode("PHXXF MQYBPKNJ"));
   }
}
// END OF CLASS --------------------------------------------------------