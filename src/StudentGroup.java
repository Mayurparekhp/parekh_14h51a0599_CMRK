import java.util.Date;
import java.util.Vector;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		students[index]=student;
		
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		Vector<Student>ts=new Vector<Student>();
		ts.add(student);
		for(int i=0;i<students.length;i++)
			ts.add(students[i]);
		ts.toArray(students);
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		Vector<Student>ts=new Vector<Student>();
		for(int i=0;i<students.length;i++)
			ts.add(students[i]);
		ts.add(student);
		ts.toArray(students);
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		Vector<Student>ts=new Vector<Student>();
		for(int i=0;i<students.length;i++){
			if(i<index)
			ts.add(students[i]);
			if(i==index){
		ts.add(student);
			i--;
			}
		}
		ts.toArray(students);
	}

	@Override
	public void remove(int index) {
		int k=0;
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		Vector<Student>ts=new Vector<Student>();
		for(int j=0;j<students.length;j++)
		{
	
			if(j!=index)
			{
				k++;
				ts.add(students[j]);	
				
			}
		}
		/*for(int i=index;i<students.length-1;i++)
		{
			Student temp=students[i];
			students[i]=students[i+1];
			students[i+1]=temp;
		}*/
		ts.toArray(students);
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		int k=0,c=0;
		if(student==null)
			throw new IllegalArgumentException();
		Vector<Student>ts=new Vector<Student>();
		for(int j=0;j<students.length;j++)
		{
	
			if(students[j].compareTo(student)!=0)
			{
				k++;
				ts.add(students[j]);	
				
			}
			else
				c++;
			
		}
		if(c==0)
			throw new IllegalArgumentException("Student not exist");
		ts.toArray(students);
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		for(int i=index+1;i<students.length;i++)
			remove(i);
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int k=0;
		if(student==null)
			throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++)
		{
			if(students[i].compareTo(student)==0)
			{
				k=i;
				break;
			}
		}
		for(int i=k;i<students.length;i++)
			remove(i);
	}

	@Override
	public void removeToIndex(int index) {
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		for(int i=0;i<index;i++)
		{
			remove(i);
		}
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		 for(int i=0;i<students.length;i++)
		 {
			 if(students[i].compareTo(student)==0)
			 {
				 return;
			 }
			 remove(i);
			 
		 }
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int n=students.length;
		Student temp=students[0];
		for(int i=0;i<n;i++){
		for(int j=1;j<(n-i);j++){
		if(students[j-1].getId()>students[j].getId()){
			temp=students[j-1];
			students[j-1]=students[j];
			students[j]=temp;
		}
		}
		}
	}
		

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date==null)
		{
			throw new IllegalArgumentException();
		}
		Student[] temp;
		Vector<Student>temp1=new Vector<Student>();
		int c=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate()==date)
			{
				c++;
				temp1.add(students[i]);
			}
		}
		temp=new Student[c];
		temp1.toArray(temp);
		return temp;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate==null||lastDate==null)
		{
			throw new IllegalArgumentException();
		}
		Student[] temp;
		Vector<Student>temp1=new Vector<Student>();
		int c=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate()==firstDate){
				temp1.add(students[i]);
				c++;
			}
			if(students[i].getBirthDate()==lastDate)
				break;
		}
		temp=new Student[c];
		temp1.toArray(temp);
		return temp;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if(date==null)
		{
			throw new IllegalArgumentException();
		}
		Student[] temp;
		Vector<Student>temp1=new Vector<Student>();
		
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent==0)
			throw new IllegalArgumentException();
		int age = (int) (System.currentTimeMillis()-students[indexOfStudent].getBirthDate().getTime())/(24*60*60*1000);
		return age;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student[] temp;
		int c=0;
		Vector<Student>temp1=new Vector<Student>();
		for(int i=0;i<students.length;i++)
		{
			 if(getCurrentAgeByDate(i)==age)
			 {
				 temp1.add(students[i]);
				 c++;
			 }
		}
		temp=new Student[c];
		temp1.toArray(temp);
		return temp;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		Student[] temp;
		Vector<Student>temp1=new Vector<Student>();
		double avg=0;
		int c=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()>avg)
				avg=students[i].getAvgMark();
				
		}
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()==avg)
			{
				temp1.add(students[i]);
				c++;
			}
		}
		temp=new Student[c];
		temp1.toArray(temp);
		return temp;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0;i<students.length;i++)
		{
			if(students[i].compareTo(student)==0)
				return students[i+1];
		}
		return null;
	}
}
