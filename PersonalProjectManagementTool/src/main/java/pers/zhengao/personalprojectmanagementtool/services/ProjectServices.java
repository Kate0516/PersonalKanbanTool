package pers.zhengao.personalprojectmanagementtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zhengao.personalprojectmanagementtool.domain.Project;
import pers.zhengao.personalprojectmanagementtool.exceptions.ProjectidException;
import pers.zhengao.personalprojectmanagementtool.repositories.ProjectRepository;

import java.awt.print.PrinterException;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectidException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectidException("Project ID '"+projectId.toUpperCase()+"' doesn't exists");
        }
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectid){
        Project project = projectRepository.findByProjectIdentifier(projectid.toUpperCase());

        if(project == null){
            throw new ProjectidException("Can not delete, Project ID '"+projectid.toUpperCase()+"' doesn't exists");
        }

        projectRepository.delete(project);
    }
}
