package org.udg.siiau.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.udg.siiau.models.StudentModel;

import java.util.ArrayList;
import java.util.Optional;
//Crud repository es de el framework de spring boot
//Esta es una interfaz que se especifica aque es un repositorio
@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> { //al extender de Crud repository realiza en automatico el codigo de crud

    //public Optional<>
    //void deleteAllBy(Iterable<? extends  ID> ids);
    //void  deleteAll(Iterable<? extends  T> entities);
    //void deletAll();

    public abstract ArrayList<StudentModel> findByCode(Long Code); //Consultas especificas
    public abstract ArrayList<StudentModel> findByName(String name); //Consultas especificas


}