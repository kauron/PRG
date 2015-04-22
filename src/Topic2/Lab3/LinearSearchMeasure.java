package Topic2.Lab3;

import java.util.Locale;

/** Class LinearSearchMeasure: program class for an empirical analysis of the
  * linear search algorithm
  *
  * @author PRG ETSInf
  * @version Year 2014-2015
  */

class LinearSearchMeasure
{
    // Constants that define the measure parameters
    static final int MAXSIZE     = 1000000,
                     INCRSIZE    =  100000,
                     INITSIZE    =  100000,
                     REPETITIONS =    1000;

    static final double NMS = 1.0e6;

    // To fill the array
    static void fillArray( int [] a )
    {
        for( int i=0; i < a.length; i++ ) a[i]=i;
    }

    public static void linearSearchMeasure()
    {
        int [] a;             // Array for the problem
        int s, r, aux;        // Sizes counter, repetitions counter, auxiliar random number
        long tb1=0, tb2=0, tbt=0, tw1=0, tw2=0, twt=0, ta1=0, ta2=0, tat=0;   // Times

        // Print header for the results
        System.out.printf( "# Size             Best          Worst        Average   (us) \n" );
        System.out.printf( "#------------------------------------------------------------\n" );

        // This loop repeats the process for several sizes
        for( s=INITSIZE; s <= MAXSIZE; s+=INCRSIZE ) {

            // Create the array and fill it
            a = new int[s];
            fillArray(a);

            // Best case: search for a[0]
            // Since it is too fast, the repetitions are included in the time measure

            MeasurableAlgorithms.linearSearch(a,a[0]);  // This initial call avoids overload for first measure
            tb1=System.nanoTime();        // Initial time
            for( r=0; r < REPETITIONS; r++ )
                MeasurableAlgorithms.linearSearch(a,a[0]);
            tb2=System.nanoTime();        // Final time
            tbt=(tb2-tb1)/REPETITIONS;    // Average time for best case

            // Worst case: search for -1

            twt=0;                        // Initial cumulative time to 0
            for( r=0; r < REPETITIONS; r++ ) {
                tw1=System.nanoTime();      // Initial time
                MeasurableAlgorithms.linearSearch(a,-1);
                tw2=System.nanoTime();      // Final time
                twt+=(tw2-tw1);             // Update cumulative time
            }
            twt=twt/REPETITIONS;          // Average time for worst case

            // Average case: search for a random number between 0 and s-1

            tat=0;                        // Initial cumulative time to 0
            for( r=0; r < REPETITIONS; r++ ) {
                aux=(int) Math.floor(Math.random()*s);    // Random number to be searched
                ta1=System.nanoTime();      // Initial time
                MeasurableAlgorithms.linearSearch(a,aux);
                ta2=System.nanoTime();      // Final time
                tat+=(ta2-ta1);             // Update cumulative time
            }
            tat=tat/REPETITIONS;          // Average time for average case

            // Print results
            System.out.printf(Locale.US, "%8d   %12.2f   %12.2f   %12.2f\n", s, tbt/NMS, twt/NMS, tat/NMS );
        }
    }

    public static void main( String [] args )
    {
        linearSearchMeasure();
    }
}
