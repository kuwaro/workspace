
public class book {
	private String subject;
	private String isbnNum;
	private String author;
	private String publisher;
	private String year;

	public book(String subject,String isbnNum,
			String author,String publisher,String year) {
		this.subject=subject;
		this.isbnNum=isbnNum;
		this.author=author;
		this.publisher=publisher;
		this.year=year;
	}
public String getsubject(){
	return this.subject;
}
public String getisbnNum() {
	return this.isbnNum;
}
public String getauthor(){
	return this.author;
}
public String getpublisher() {
	return this.publisher;
}
public String getyear() {
	return this.year;
}
}
