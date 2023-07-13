import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Customer {
	protected String name;
	private String address;
	private String email;
	private int uniqueID;

	/*
	 * Static field id will set the value of the uniqueID increasing by one when an
	 * Customer object is created
	 */

	private static int id = 0;

	public Customer() {
		id++;
		uniqueID = id;
	}

	public Customer(String name, String address, String email) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		id++;
		uniqueID = id;
	}

	/*
	 * Getter Methods
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public int getuniqueID() {
		return this.uniqueID;
	}

	/*
	 * Mutator Methods
	 */

	// This setEmail method uses a Regex pattern to detect
	// if the @ icon and the email is properly formatted
	public boolean setEmail(String email) {
		boolean isValid = false;
		if (email == null || email.isEmpty()) {
			isValid = false;
		} else {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
					+ "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern = Pattern.compile(emailRegex);
			if (pattern.matcher(email).matches()) {
				isValid = true;
			}
		}
		return isValid;
	}

	public boolean setuniqueID(int uniqueID) {
		boolean isTrue = false;
		if (uniqueID > 0 && uniqueID < 100) {
			this.uniqueID = uniqueID;
			isTrue = true;
		}

		return isTrue;
	}

	/**
	 * Overwrite method toString() uses the variables and prints them in order for
	 * the Version3App
	 * 
	 * Used in inheritance in the Customer and Business subclasses
	 * 
	 * @return the Customer details with the instance variables above in a formatted
	 *         manner
	 *
	 */
	@Override
	public String toString() {
		return " Customer{" + " ID= " + this.uniqueID + " Name= " + this.name + " Address= " + this.address + " Email= "
				+ this.email + '}';
	}
	
	/**
	 * HashCode for Customer Name and Address
	 */
    @Override
    public int hashCode() {
        int hash = 8;
        hash = 90 * hash + Objects.hashCode(this.name);
        hash = 90 * hash + Objects.hashCode(this.address);
        return hash;
    }
    /**
	 * equals, used to compare Customer Object values as a way to make valid comparisons
	 * among the Customer name and address
	 * 
	 * @param obj, the Object used to compare Customer name and address
	 * instance variables
	 * 
	 * @return the Customer details with the instance variables above in a formatted
	 *         manner
	 *
	 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

}
