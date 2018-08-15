package studentCoursesBackup.myTree;

public interface ObserverI {
	public String toString();

	public int getKey();

	public Node getLeft();
	public Node getRight();

	public void setKey(int kIn);

	public void setLeft(Node nIn);
	public void setRight(Node nIn);

	public void addCourse(String courseName);
	public int findCourse(String courseName);
	public void removeCourse(String courseName);

	public void update(String courseName, String alertType);
}
