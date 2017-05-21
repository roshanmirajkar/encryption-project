class MorseCipher extends Cipher{
  //stores the alphabet object in use only to be used in this class
  protected Alphabet z;
  
  //which gives the valid characters in the MorseCode. 
  //This table is a good candidate for an Alphabet object to ease looking up characters.
  public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
  
  //codes is a character table that represents each character as a series of dashes 
  //in the allowed set of characters 
  public static final String[] codes = {
    ".-",    /* A */
    "-...",  /* B */    
    "-.-.",  /* C */    
    "-..",   /* D */
    ".",     /* E */    
    "..-.",  /* F */    
    "--.",   /* G */    
    "....",  /* H */
    "..",    /* I */    
    ".---",  /* J */    
    "-.-",   /* K */    
    ".-..",  /* L */
    "--",    /* M */    
    "-.",    /* N */    
    "---",   /* O */    
    ".--.",  /* P */
    "--.-",  /* Q */    
    ".-.",   /* R */    
    "...",   /* S */    
    "-",     /* T */
    "..-",   /* U */    
    "...-",  /* V */    
    ".--",   /* W */    
    "-..-",  /* X */
    "-.--",  /* Y */    
    "--..",  /* Z */    
    ".----", /* 1 */    
    "..---", /* 2 */
    "...--", /* 3 */    
    "....-", /* 4 */    
    ".....", /* 5 */    
    "-....", /* 6 */
    "--...", /* 7 */    
    "---..", /* 8 */    
    "----.", /* 9 */    
    "-----", /* 0 */
    " ",     /* blank space*/ 
  };
  
  //The constructor uses letters to fill in its alphabet field.
  public MorseCipher(){
    z = new Alphabet(letters); //creates Alphabet object with letters
  }
  
  //Converts a string of letters, digits, and spaces to the corresponding morse code representation. 
  //All lowercase letters are implicitly converted to uppercase during encryption.
  public String encrypt(String plainText) {
    String e = "";
    for(int i = 0; i < plainText.length(); i++) {
      plainText = plainText.toUpperCase(); //make all values upercase
      //find the char of each place in the string and then get the index where it
      //occurs in the alphabet. Use this index to match the value in codes. Then add 3 white spaces.
      e += codes[ z.indexOf( plainText.charAt(i)) ] + ("   "); 
    }
   return e.trim(); //trim trailing whitspace
  }
  
  //Converts a string of morse code representation back to a string of uppercase letters, digits, and spaces. 
  //Any letters that were originally lowercase will only appear as uppercase.
  public String decrypt(String cryptText) {
    String d = "";
    String dResult = "";
    for (int i = 0; i < cryptText.length(); i++) {
      if (cryptText.charAt(i) == ' ') { //don't store white space
      }
      else {
        d += cryptText.charAt(i); //stores the current symbol being checked
      }
      if ((i + 1) < cryptText.length() ) {
        if (cryptText.charAt(i + 1) == ' ') { //if the next value is empty space
        for (int v = 0; v < codes.length; v++) { //check every single values for the symbol
         if (codes[v].equals(d)) { //checks current string with code array
           if (cryptText.charAt(i+4) == ' ') { //if the fourth index from current is white space
             dResult += letters.charAt(v) + " "; //adds the resulting letter to the String + empty space
           }
           else {
             dResult += letters.charAt(v); //adds the resulting letter to the String
           }
           d = ""; // clear the string
        } 
       }
      }
     }
      else { //used to get the first location in the String (i = 0)
        for (int v = 0; v < codes.length; v++) { //check every single values for the symbol
         if (codes[v].equals(d)) {
           dResult += letters.charAt(v);
           d = ""; // clear the string
         } 
        }
      }
  } //for loop ends
    
  return dResult.toUpperCase().trim(); //make every value upper case and trip trailing whitespace
 }
}