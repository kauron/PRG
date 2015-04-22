package Topic3.Exercises.Life;

/**
 * Class for defining objects representing animals.
 * 
 * @author 1E group
 * @version 1.0 (04/04/2012)
 */
public class LivingBeing
{
    /** <code>char</code> indicating the genre.
     *  Possible values:
     *      <ul>
     *          <li> <code>'F'</code>=female </li>
     *          <li> <code>'M'</code>=male </li>
     *          <li> <code>'H'</code>=hermaphrodite </li>
     *      </ul>
     */
    private char genre;
    /** Length of the living being in meters. */
    private float length;

    public LivingBeing( char genre, float length )
        throws Exception
    {
        genre = Character.toUpperCase( genre );

        switch( genre ) {
            case 'F' :
            case 'M' :
            case 'H' : break;

            default : throw new Exception( "Incorrect assigned genre: " + genre );
        }
        this.genre = genre;

        if ( length <= 0.0 ) throw new Exception( "Incorrect assigned length." );
        this.length = length;
    }

    public char getGenre() { return genre; }
    public float getLength() { return length; }

    public String toString()
    {
        return String.format( "%20s: %f\n", "Length", length )
             + String.format( "%20s: %c\n", "Genre", genre );
    }
}
