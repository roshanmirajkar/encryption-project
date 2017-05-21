//class that represents the set of characters that will be allowed in some message.
//Used to provide translation fo character from symbols to integers and vice versa

public class Alphabet {
  private String symbols; //stroes current set of characters
  public static final Alphabet DEFAULT = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890!@#$%^&*()_+-=[]{}\\|;:'\",./?<>");
  public Alphabet a; //stores current Alphabet object
  
  //Constructor to initialize symbols.
  
  public Alphabet(String symbols){
    this.symbols = symbols;
  }
  
  //Returns the index of char parameter c in string symbols. 
  //Throws NotInAlphabetException if char parameter c is not in symbols.
  
  public int indexOf(char c) throws NotInAlphabetException{
    if (symbols.indexOf(c) > -1) { //if char in String return index of char
      return symbols.indexOf(c);
    }
    else {
      throw new NotInAlphabetException(c, a); //otherwise throw exception
    }
  }
  
  //Returns the char at position i of symbols. 
  //Throws NotInAlphabetException if int parameter i is not a position in symbols.
  
  public char get(int i) throws NotInAlphabetException{
     if (i > length()) {
      throw new NotInAlphabetException("Character doesn't exist in Alphabet", '!', a);
    }
    else {
        return symbols.charAt(i);
    }
  }
  
  //Returns the length of string symbols.
  public int length() {
    return symbols.length();
  }
  
  //Returns symbols.
  public String getSymbols(){
    return symbols;
  }
  
  //String representation. Example: if symbols is "ABC", returns "Alphabet(ABC)"
  public String toString() {
    return String.format("Alphabet(%s)", symbols);
  }
  
  //Overrides the equals method in Java. Returns true if other is another Alphabet and has the same characters 
  //and ordering as this alphabet. 
  @Override
  public boolean equals(Object other){
    if (other instanceof Alphabet) { //checks type
      Alphabet z = (Alphabet) other; //cast Object to Alphabet
      return (this.getSymbols() == z.getSymbols()); //check for equality
    }
    return false;
  } 
}
