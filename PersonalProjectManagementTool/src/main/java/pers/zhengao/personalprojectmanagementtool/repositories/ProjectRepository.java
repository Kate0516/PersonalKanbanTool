package pers.zhengao.personalprojectmanagementtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pers.zhengao.personalprojectmanagementtool.domain.Project;

import java.util.Optional;

//这个注解可不写
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    Iterable<Project> findAllById(Iterable<Long> longs);

    Project findByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();
}
