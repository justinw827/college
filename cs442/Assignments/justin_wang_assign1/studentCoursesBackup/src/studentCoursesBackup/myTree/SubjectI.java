package studentCoursesBackup.myTree;

public interface SubjectI {
	public String toString();

	public int getKey();

	public Node getLeft();
	public Node getRight();

	public int getObserverSize();
	public Node getObserver(int index);

	public void setKey(int kIn);

	public void setLeft(Node nIn);
	public void setRight(Node nIn);

	public void addCourse(String courseName);
	public int findCourse(String courseName);
	public void removeCourse(String courseName);
	public void addObserver(Node observer);

	public void notify(String courseName, String alertType);

}
