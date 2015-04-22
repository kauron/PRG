package Topic3.Exercises.Life.Test;

import Topic3.Exercises.Life.*;

/**
 * Class for testing the use of the class <b>ClassesForAnObject</b>.
 *
 * @author Jon Ander Gómez (jon@dsic.upv.es)
 * @version 1.0 (March 2012) 
 */

public class TestLife
{
    /**
     * <code>main()</code> method for testing the use of objects of other classes.
     * 
     * @param args Array of objects of class <b>String</b> with the list of command line arguments.
     */
    public static void main( String args[] )
        throws Exception
    {
        System.out.println();
        ClassesForAnObject.listOfClasses( new LivingBeing('H', 0.1F) );
        ClassesForAnObject.listOfClasses( new Animal() );
        ClassesForAnObject.listOfClasses( new Mammal() );
        ClassesForAnObject.listOfClasses( new Hominidae() );
        ClassesForAnObject.listOfClasses( new HomoSapiens() );
        ClassesForAnObject.listOfClasses( new Person() );
    }
}
