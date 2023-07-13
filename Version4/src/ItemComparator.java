

import java.util.Comparator;
/**
 * 
 * @author Conor Garvey
 *
 */
public class ItemComparator implements Comparator <Item> {
	
	/** 
	 * It is a constructor, that uses a Comparator interface to sort
	 * the Item Objects by ascending uniqueID 
	 *
	 * @param i1, an Item Object used
	 * @param i2  an Item Object used
	 * 
	 * @return an int, as a result of the object comparison sorting 
	 * 		   the Item Objects in ascending order
	 */
	@Override
	public int compare(Item i1,Item i2) {
		if (i1.getuniqueID() > i2.getuniqueID()) {
			return 1;
		}
		if (i1.getuniqueID() < i2.getuniqueID()) {
			return -1;
		} else {
			return 0;
		}
	}
}
