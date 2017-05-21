//Class VigenereCipher is a child class of SymmetricCipher and extends from SymmetricCipher. 
//Provides a way of encrypting and decrypting a message using an Alphabet 
//object & a secret password and its individual locations of characters in the alphabet
//to allocate how to encrypt and decrypt messages.

public class VigenereCipher extends SymmetricCipher {
  
  //The password, used to generate shift values.
  protected String password;
  
  //Records the current location in a String that is being crypted. 
  protected int passwordPos = 0;
  
  //The constructor initializes the data members. 
  //This includes the data member in the parent class SymmetricCipher.
  public VigenereCipher(String password,Alphabet alphabet) {
    super(alphabet); //call to parent class
    this.password = password;
  }
  
  //The constructor initializes the data members. 
  //This includes the data member in the parent class SymmetricCipher, 
  //which is initialized to the DEFAULT Alphabet.
  public VigenereCipher(String password) {
    super(Alphabet.DEFAULT); //call to parent with DEFAULT Alphabet
    this.password = password;
  }
  
  //Returns password.
  public String getPassword(){
    return password;
  }
  
  //Relies upon password and passwordPos to encrypt a single char. Must increment passwordPos. 
  //Will throw NotInAlphabetException if any character is found that isn't in the alphabet.
  protected char encrypt1(char c) throws NotInAlphabetException{
    if (passwordPos > password.length()-1) { //reset position to zero after every char is used
      passwordPos = 0; //reset to 0
    }
    //get the current index of where the character being encrypted is and then
    //get the character in the current position of the string using passwordPos and then
    //use this to look up the index in the alphabet
    int temp = ((alphabet.indexOf(c)) + (alphabet.indexOf(password.charAt(passwordPos)))); 
    passwordPos += 1; //increment password pos;
    return alphabet.get(wrapInt(temp)); //wrap the index and return
  }
  
  //Relies upon password and passwordPos to decrypt a single char. Must increment passwordPos. 
  //Will throw NotInAlphabetException if any character is found that isn't in the alphabet.
  protected char decrypt1(char c) throws NotInAlphabetException {
    if (passwordPos > password.length()-1) { //reset position to zero after every char is used
      passwordPos = 0; //reset to 0
    }
    //get the current index of where the character being decrypted is and then
    //get the character in the current position of the string using passwordPos then make
    //it negative because we want to go to left and then
    //use this to look up the index in the alphabet
    int temp = alphabet.indexOf(c) + ( alphabet.indexOf(password.charAt(passwordPos)) *-1);
    passwordPos +=1; //increment password pos;
    return alphabet.get(wrapInt(temp)); //wrap the index and return
  }
  
  //We can't wholly use the inherited version, 
  //because we need to know at what position in the string we're encrypting. Initializes passwordPos to 0, 
  //and then invokes the parent class's version of encrypt (which in turn uses this class's 
  //encrypt1 definition). 
  //When characters not in the alphabet are encountered, a NotInAlphabetException is thrown.
  @Override
  public String encrypt(String s) throws NotInAlphabetException{ 
    passwordPos = 0; //initialize to 0
    return super.encrypt(s); //invoke parent
  }
  
  //We can't wholly use the inherited version, 
  //because we need to know at what position in the string we're decrypting. 
  //Initializes passwordPos to 0, and then invokes the parent 
  //class's version of decrypt (which in turn uses this class's decrypt1 definition). 
  //When characters not in the alphabet are encountered, a NotInAlphabetException is thrown.
  @Override
  public String decrypt(String s) throws NotInAlphabetException{
    passwordPos = 0; //initialize to 0
    return super.decrypt(s); //invoke parent
  }
  
  //Return a string representation of the cipher in the following format 
  //Vigenere Cipher (password='Cats')
  public String toString(){
   return String.format("Vigenere Cipher (password='%s')", password);
  }
}