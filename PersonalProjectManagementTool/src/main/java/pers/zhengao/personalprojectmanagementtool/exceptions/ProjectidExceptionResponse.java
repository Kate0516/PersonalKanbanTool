package pers.zhengao.personalprojectmanagementtool.exceptions;

public class ProjectidExceptionResponse {

    private String projectIdentifier;

    public ProjectidExceptionResponse(String projectIdentifier){
        this.projectIdentifier = projectIdentifier;

    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
