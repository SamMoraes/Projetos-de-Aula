package interfaces;

import entities.Project;

public interface IProjectRepository {

	void createFolder(Project project) throws Exception;
	
	void copyStructure(Project project) throws Exception;
	
	void testFolderExists(Project project) throws Exception;
	
	
}
