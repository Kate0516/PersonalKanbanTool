package pers.zhengao.personalprojectmanagementtool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.zhengao.personalprojectmanagementtool.domain.Project;
import pers.zhengao.personalprojectmanagementtool.services.MapValidationErrorServices;
import pers.zhengao.personalprojectmanagementtool.services.ProjectServices;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectServices projectServices;

    @Autowired
    private MapValidationErrorServices mapValidationErrorServices;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorServices.MapValidationService(result);
        if(errorMap != null)
            return errorMap;

        Project project1 = projectServices.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){

        Project project = projectServices.findProjectByIdentifier(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects(){
        return projectServices.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
        projectServices.deleteProjectByIdentifier(projectId);

        return new ResponseEntity<String>("Project with ID '" + projectId + "' was deleted.", HttpStatus.OK);
    }
}
