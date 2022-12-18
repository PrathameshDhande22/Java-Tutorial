package tutorial;

//Annotations in java
// annotations start with /** double asterisk sign you can generate the java doc
/**
 * Class Library is very Usefull to deal with Library Function
 * 
 * @author Prathamesh
 * @version 1.1
 * @since 2012
 *        <p>
 *        You can implement to get the Access to the virtual Library
 *        </p>
 *
 */
class Tut30 {
	public int id;
	public String bookname;
	public String Author;
	public String Libname;

	/**
	 * Constructor for Library
	 * 
	 * @param id
	 * @param bookname
	 * @param Author
	 */
	public Tut30(int id, String bookname, String Author) {
		this.id = id;
		this.Author = Author;
		this.bookname = bookname;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", bookname=" + bookname + ", Author=" + Author + "]";
	}

	/**
	 * Setting the Library Name
	 * 
	 * @param Libname
	 */
	public void setLibraryName(String Libname) {
		this.Libname = Libname;
	}

	/**
	 * Returns the Library Name
	 * 
	 * @return
	 */
	public String getLibname() {
		return Libname;
	}
}
