package pers.zhengao.personalprojectmanagementtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zhengao.personalprojectmanagementtool.domain.Project;
import pers.zhengao.personalprojectmanagementtool.repositories.ProjectRepository;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        return projectRepository.save(project);
    }
}
