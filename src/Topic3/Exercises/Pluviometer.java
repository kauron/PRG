package Topic3.Exercises;

import java.io.*;

public class Pluviometer implements Serializable {
	private static final int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private double[][] rained;

	public Pluviometer() {
		rained = new double[13][32];

	}

	public void save( String filename ) {
		ObjectOutputStream oos = null;
		try{
			File file = new File (filename);
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
		
			oos.writeObject(this);
		} catch (FileNotFoundException fnfe) {
			System.out.print("An error ocurred! " + fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.print("File not found " + ioe.getMessage());
		} finally {
			if (oos != null) try {oos.close();} catch (Exception e) {}
		}
	}
	//TODO: fix and complete
	public static Pluviometer load ( String filename ) {
		ObjectInputStream ois = null;
		Pluviometer p = null;
		try{
			File file = new File (filename);
			FileInputStream fis = new FileInputStream (file);
			BufferedInputStream bis = new BufferedInputStream (fis);
			ois = new ObjectInputStream (bis);

			Object o = ois.readObject();
			p = o instanceof Pluviometer ? (Pluviometer)o : null;
		} catch (FileNotFoundException fnfe) {
			System.out.print("There was an error " + fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.print("There was an error " + ioe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.print("There was an error " + cnfe.getMessage());
		} finally {
			try {
				if (ois != null) ois.close();
			} catch (IOException ioe ) {
				System.out.println("There was an error " + ioe.getMessage());
			}
		}
		return p;
	}

	public String toString() {
		return "This object has been loaded";
	}
}