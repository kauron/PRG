package Topic2.Lab3;

import java.util.Locale;

/** Class SortingMeasure: program class to implement the emprical
  * time measure of sorting algorithms
  *
  * @author PRG ETSInf
  * @version Year 2014-2015
  */

class SortingMeasure
{
    // Define the static final variables that are needed for the experiment
    private final static java.util.Random r = new java.util.Random();
    static final double NMS = 1.0e3;

    /* Apart from the measuring methods, you can implement the auxiliar *
     * static methods that you consider necessary for the empirical     *
     * measure (e.g., methods to generate arrays of data)               */

    public static void fillSortedArray( int [] a )
    {
        for( int i=0; i < a.length; i++ ) a[i] = i+1;
    }
    public static void fillSortedArrayInReverseOrder( int [] a )
    {
        for( int i=0; i < a.length; i++ ) a[i] = a.length-i;
    }
    public static void fillRandomArray( int [] a )
    {
        for( int i=0; i < a.length; i++ ) a[i] = r.nextInt( a.length );
    }

    public static void measureInsertion(){
        final int MAXSIZE     = 15000,
                  INCRSIZE    =  1000,
                  INITSIZE    =  1000,
                  REPETITIONS =    50;
        int [] a;             // Array for the problem
        int s, r;             // Sizes counter, repetitions counter
        long tb1, tb2, tbt, tw1, tw2, twt, ta1, ta2, tat;   // Times

        // Print header for the results
        System.out.printf( "# Size             Best          Worst        Average   (us) \n" );
        System.out.printf( "#------------------------------------------------------------\n" );

        // This loop repeats the process for several sizes
        for( s=INITSIZE; s <= MAXSIZE; s+=INCRSIZE ) {

            // Create the array and fill it
            a = new int[s];

            // Best case: ordered array

            tbt = 0;
            for( r=0; r < REPETITIONS; r++ ){
                fillSortedArray(a);
                tb1=System.nanoTime();        // Initial time
                MeasurableAlgorithms.insertionSort(a);
                tb2=System.nanoTime();        // Final time
                tbt+=(tb2-tb1);    // Average time for best case
            }
            tbt = tbt/REPETITIONS;


            // Worst case: reversed ordered array

            twt=0;                        // Initial cumulative time to 0
            for( r=0; r < REPETITIONS; r++ ) {
                fillSortedArrayInReverseOrder(a);
                tw1=System.nanoTime();      // Initial time
                MeasurableAlgorithms.insertionSort(a);
                tw2=System.nanoTime();      // Final time
                twt+=(tw2-tw1);             // Update cumulative time
            }
            twt=twt/REPETITIONS;          // Average time for worst case

            // Average case: order a random array

            tat=0;                        // Initial cumulative time to 0
            for( r=0; r < REPETITIONS; r++ ) {
                fillRandomArray(a);
                ta1=System.nanoTime();      // Initial time
                MeasurableAlgorithms.insertionSort(a);
                ta2=System.nanoTime();      // Final time
                tat+=(ta2-ta1);             // Update cumulative time
            }
            tat=tat/REPETITIONS;          // Average time for average case

            // Print results
            System.out.printf(Locale.US, "%8d   %12.2f   %12.2f   %12.2f\n", s, tbt/NMS, twt/NMS, tat/NMS );
        }
    }

    public static void measureSelection()
    {
        final int MAXSIZE = 10000,
                  INCRSIZE = 500,
                  INITSIZE = 1000,
                  REPETITIONS = 30;

        int [] a;             // Array for the problem
        int s, r;             // Sizes counter, repetitions counter
        long ta1, ta2, tat;   // Times

        // Print header for the results
        System.out.printf( "# Size        Average   (us) \n" );
        System.out.printf( "#----------------------------\n" );

        // This loop repeats the process for several sizes
        for( s=INITSIZE; s <= MAXSIZE; s+=INCRSIZE ) {

            // Create the array and fill it
            a = new int[s];
            // Average case: order a random array

            tat=0;                        // Initial cumulative time to 0
            for( r=0; r < REPETITIONS; r++ ) {
                fillRandomArray(a);
                ta1=System.nanoTime();      // Initial time
                MeasurableAlgorithms.selectionSort(a);
                ta2=System.nanoTime();      // Final time
                tat+=(ta2-ta1);             // Update cumulative time
            }
            tat=tat/REPETITIONS;          // Average time for average case

            // Print results
            System.out.printf(Locale.US, "%8d   %12.2f\n", s, tat/NMS );
        }
    }

    public static void measureMergeSort()
    {
        final int MAXSIZE     = 100000,
                INCRSIZE    =  1000,
                INITSIZE    =  1000,
                REPETITIONS =    50;
        int [] a;             // Array for the problem
        int s, r;             // Sizes counter, repetitions counter
        long ta1, ta2, tat;   // Times

        // Print header for the results
        System.out.printf( "# Size        Average   (us) \n" );
        System.out.printf( "#----------------------------\n" );

        // This loop repeats the process for several sizes
        for( s=INITSIZE; s <= MAXSIZE; s+=INCRSIZE ) {

            // Create the array and fill it
            a = new int[s];

            // Average case: order a random array

            tat=0;                        // Initial cumulative time to 0
            for( r=0; r < REPETITIONS; r++ ) {
                fillRandomArray(a);
                ta1=System.nanoTime();      // Initial time
                MeasurableAlgorithms.mergeSort(a, 0, a.length - 1);
                ta2=System.nanoTime();      // Final time
                tat+=(ta2-ta1);             // Update cumulative time
            }
            tat=tat/REPETITIONS;          // Average time for average case

            // Print results
            System.out.printf(Locale.US, "%8d   %12.2f\n", s, tat/NMS );
        }
    }

    public static void usage()
    {
        System.out.println( "Usage: java SortingMeasure algorithm_number" );
        System.out.println( "   Where algorithm_number is:" );
        System.out.println( "   1 -> Insertion sort" );
        System.out.println( "   2 -> Selection sort" );
        System.out.println( "   3 -> MergeSort" );
    }

    public static void main( String [] args )
    {
        int a;

        if ( args.length != 1 ) {
            usage();
            return;
        }

        try {
            a=Integer.parseInt(args[0]);
        } catch ( Exception e ) {
            usage(); return;
        }

        switch (a) {
            case 1: measureInsertion();
                    break;
            case 2: measureSelection();
                    break;
            case 3: measureMergeSort();
                    break;
            default: usage();
        }
    }
}
