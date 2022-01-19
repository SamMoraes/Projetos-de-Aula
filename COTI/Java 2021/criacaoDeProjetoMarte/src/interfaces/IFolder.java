package interfaces;

import entities.Project;

public interface IFolder {

	void createFolder(Project project) throws Exception;
	
	void copyStructure(Project project) throws Exception;
}
