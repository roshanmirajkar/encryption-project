]//CaesarCipher is a child of SymmetricCipher and inherits from SymmetricCipher. 
//Provides a form of encrypting and decrypting an message using an Alphabet object.
//primarly through the use of a shift key.

public class CaesarCipher extends SymmetricCipher {
  
  //The shift that this cipher uses to adjust characters during encryption/decryption.
  protected int shift;
  
  //The constructor stores the shift and alphabet.
  //Note: even if shift is out of range of the alphabet, 
  //store it exactly as given.
  public CaesarCipher(int shift, Alphabet alphabet) {
    super(alphabet); //call to parent constructor
    this.shift = shift;
  }
  
  //This constructor stores the shift and uses the default Alphabet found in Alphabet.DEFAULT.
  // Note: even if shift is out of range of the alphabet, 
  //store it exactly as given 
  public CaesarCipher(int shift) {
    super(Alphabet.DEFAULT); //call to parent constructor
    this.shift = shift;
  }
  
  //Shifts each character by the shift amount and returns the newly encoded string. 
  //Inherited implementation.
  public String encrypt(String s) {
    return super.encrypt(s); //call to parent method
  }
  
  //Shifts each character in the opposite direction by the shift amount, which will recover the original secret message. 
  //Inherited implementation.
  public String decrypt(String s){ 
    return super.decrypt(s); //call to parent method
  }
  
  //Encrypts and returns a single character based on the shift and the alphabet in use. 
  //Will throw NotInAlphabetException if any character is found that isn't in the alphabet.
  @Override
  public char encrypt1(char c) throws NotInAlphabetException{
    
    //get index of c in the Alphabet & shift key. Then rotate. 
    //Wrap the resulting value incase it is not a valid index. The resulting value
    //is the index of the char after the process of encryption, return this char.
    return alphabet.get(wrapInt(rotate(alphabet.indexOf(c), shift)));
    
  }
  
  //Decrypts and returns a single character based on the shift and the alphabet in use. 
  //Will throw NotInAlphabetException if any character is found that isn't in the alphabet
  @Override
  public char decrypt1(char c) throws NotInAlphabetException {
    
    //get index of c in the Alphabet & shift key.Note: make shift negative because 
    //we should shift to left for decryption. Then rotate. 
    //Wrap the resulting value incase it is not a valid index. The resulting value
    //is the index of the char after the process of decryption, return this char.
    return alphabet.get(wrapInt(rotate(alphabet.indexOf(c), shift*-1)));
  }
  
  //Return a string representation of the cipher in the following format "Caesar Cipher (shift=2)"
  public String toString() {
    return String.format("Caesar Cipher (shift=%1$d)", shift);
  }
}