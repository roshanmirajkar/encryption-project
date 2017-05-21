//SymmetricCipher is an abstract class that is a child of Cipher and inherits from Cipher.
//contains methods to encrypt and decrypt strings as well as helper methods on a given Alphabet object.

public abstract class SymmetricCipher extends Cipher{
  
  //The alphabet that this cipher works on. 
  protected Alphabet alphabet;
  
  //The constructor initializes the data member.
  public SymmetricCipher(Alphabet alphabet){
    this.alphabet = alphabet;
  }
  
  //Given an index value that may be outside the range of valid indexes into the alphabet, 
  //wrap it back around to a valid index.
  public int wrapInt(int i){
    if (i < alphabet.length() && i >= 0) { //if index is valid return it
      return i; //return index
    }
    else if (i >= alphabet.length()) { //if index is larger than length
      do {
        i -= alphabet.length(); //minues index value and alphabet length until you get last num that is >0
      }
      while ( i - alphabet.length()> 0); {
      }
     return i; //return index
    }
    else if ( i < 0) { //if index if negative
      do {
        i += alphabet.length(); //ad index value to alphabet length until you get las num <0
      }
      while( i < 0); {
      }
      return i; //return index
    }
    return 1; //will never reach here
  }
  
  //Given an index into the alphabet, 
  //rotate it around shift times to the resulting valid index into alphabet.
  public int rotate(int index, int shift) {
    if (shift == 0) { //no shift
      return index;
    }
    else if ((index + shift) > alphabet.length()) { //if shift exceedes length of alphabet, wrap around
      return ((index + shift) - alphabet.length());
    }
    else if ((index + shift) < 0) { //if shift is negative 
      return ((index + shift) + alphabet.length());
    }
    else if ((index + shift) > 0) { //if shift is positive
      return (index + shift );
    }
    return 0; //will never reach here, compliler filler
  }
  
  //Returns alphabet.
  public Alphabet getAlphabet() {
    return alphabet;
  }
  
  //Implement this method based upon the encrypt1 definition, which encrypts a single character 
  //Throws NotInAlphabetException if any character is found that isn't in the alphabet.
  public String encrypt(String s) throws NotInAlphabetException{
    String encryptResult = "";
    for(int i = 0; i < s.length(); i++) {
      encryptResult += encrypt1(s.charAt(i)); //decrypts each char and adds it to string
    }
   return encryptResult; //return encrypted string
  }
  
  //Implement this method based upon the decrypt1 definition, which decrypts a single character 
  //(think of the Caesar Cipher for an understanding). '
  //Throws NotInAlphabetException if any character is found that isn't in the alphabet.
  public String decrypt(String s) throws NotInAlphabetException{
    String decryptResult = "";
    for(int i = 0; i < s.length(); i++) {
      decryptResult += decrypt1(s.charAt(i)); //decrypts each char and adds it to string
    }
   return decryptResult; //return decrypted string
  }
  
  //abstract method for encrypting a single char.Child classes must provide an implementation of this.
  //Child class implementations will throw NotInAlphabetException.
  protected abstract char encrypt1(char c);
  
  //abstract method for decrypting a single char.Child classes must provide an implementation of this. 
  //Child class implementations will throw NotInAlphabetException.
  protected abstract char decrypt1(char c);
}