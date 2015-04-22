package Topic3.Exercises.Life;

/**
 * Class for defining objects representing animals.
 * 
 * @author 1E group
 * @version 1.0 (04/04/2012)
 */
public class Animal 
    extends LivingBeing
{
    /** Weight of the animal in Kg */
    private float weight;

    /** Range of valid values for this kind of animals *
    final static float minWeight= ... ;
    final static float maxWeight= ... ;
        
       -- These class variables must be declared in each class specific for each species.
    */

    /** String with the definition of the type of skin. */
    private String skinType;

    /** String with the name of the colour of the skin. */
    private String skinColour; 

    /** String with the name of the colour of the eyes. */
    private String eyesColour; 

    /** String with the names of different kinds of feeding. */
    private String feeding; 

    public Animal()
        throws Exception
    {
        super( 'h', 0.1F );
    }

    public Animal(  float  weight,
                    String skinType,
                    String skinColour,
                    String eyesColour,
                    String feeding,
                    char   genre,
                    float  length )
        throws Exception
    {
        super( genre, length );

        if ( weight <= 0.0 ) throw new Exception( "Incorrect value for weight: " + weight );

        this.weight     = weight;
        this.skinType   = skinType;
        this.skinColour = skinColour;
        this.eyesColour = eyesColour;
        this.feeding    = feeding;
    }

    public float  getWeight()     { return weight; }
    public String getSkinType()   { return skinType; }
    public String getSkinColour() { return skinColour; }
    public String getEyesColour() { return eyesColour; }
    public String getFeeding()    { return feeding; }

    public void setWeight( float weight )          { this.weight = weight; }
    public void setSkinType( String skinType )     { this.skinType = skinType; }
    public void setSkinColour( String skinColour ) { this.skinColour = skinColour; }
    public void setEyesColour( String eyesColour ) { this.eyesColour = eyesColour; }
    public void setFeeding( String feeding )       { this.feeding = feeding; }

    public String toString()
    {
        return super.toString()
             + String.format( "%20s: %f\n", "Weight", weight )
             + String.format( "%20s: %s\n", "Skin Type", skinType )
             + String.format( "%20s: %s\n", "Skin Colour", skinColour )
             + String.format( "%20s: %s\n", "Eyes Colour", eyesColour )
             + String.format( "%20s: %s\n", "Feeding", feeding );
    }


    public static void main( String args[] )
        throws Exception
    {
        Animal a = new Animal( 1.0F, "Fur", "Blue", "Grey", "Lentejas", 'h', 100.0F );

        System.out.println( a );
    }
}
