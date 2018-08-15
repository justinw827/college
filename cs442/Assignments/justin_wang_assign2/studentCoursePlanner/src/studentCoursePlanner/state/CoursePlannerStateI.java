package studentCoursePlanner.state;

public interface CoursePlannerStateI {
	public boolean processCourse(char courseIn);
	public void addCourse(char courseIn);
	public boolean checkCourse(char courseIn);
	public int getReqs();
	public void setReqsMet(boolean val);
	public boolean getReqsMet();

	public String toString();
}