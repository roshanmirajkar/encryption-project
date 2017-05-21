//custom exception used to deal with errors that occur when using Alphabet objects. 
//Extends RuntimeException
public class NotInAlphabetException extends RuntimeException{
  public final String msg;
  public final char offender;
  public final Alphabet a;
  
  //Constructor initializes the data members.
  
  public NotInAlphabetException(String msg, char offender, Alphabet a) {
    this.msg = msg;
    this.offender = offender;
    this.a = a;
  }
  
  //Constructor initializes data members. 
  //Creates the message using String.format() 
  
  public NotInAlphabetException(char offender, Alphabet a) {
    this.offender = offender;
    this.a = a;
    msg = String.format("Not in alphabet: '%s' not found in %s.", offender, a);
  }
  
  //Returns msg.
  
  public String toString(){
    return msg;
  }
}
