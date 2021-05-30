
public class MyVector {
	private double[] elements;
	static int count;

	public MyVector() {
		elements=new double[2];
		elements[0]=0.0;
		elements[1]=0.0;
		count=0;
	}
	public MyVector(double x,double y) {
		elements=new double[2];
		elements[0]=x;
		elements[1]=y;
		count++;
	}
	MyVector constMult(double k) {
		this.elements[0]*=k;
		this.elements[1]*=k;
		return this;
	}
	double getLength() {
		return Math.sqrt(this.elements[0]*this.elements[0]+this.elements[1]*this.elements[1]);
	}
	boolean isEqual(MyVector v) {
		if(this.elements==v.elements)
			return true;
		else
			return false;

	}
	static int getNumVec() {
		return count;
	}
	void print() {
		System.out.println("("+this.elements[0]+","+this.elements[1]+")");
	}

}
