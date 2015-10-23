/**
 * These exceptions were made for my own use.
 * Author: Marcus Eliason (Choooooooooooooooooooooooooooooooooooooooooooooooood)
 * Created 10/21/15
 */


package com.astronuts.library.chudsCode;

//Main class
class Exceptions extends Exception{

    //Empty call
    public Exceptions(){

        super("Unknown Exception");

    }

    //Details included
    public Exceptions(String details){

        super(details);

    }

    //Details and Case id included
    public Exceptions(String details, Short Case){

        super(details + Case);

    }

    //Details and unit included
    public Exceptions(String details, char unit){

        super(details + unit);

    }

}
