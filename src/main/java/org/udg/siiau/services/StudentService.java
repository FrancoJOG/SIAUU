package org.udg.siiau.services;

import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.udg.siiau.models.StudentModel;
import org.udg.siiau.repositories.StudentRepository;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired //Inyeccion de dependencias automaticas
    StudentRepository studentRepository;




    //obtener estudiantes registrados (SELECT*)
    public ArrayList<StudentModel> getAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }


    //SELECT*WHERE ID = ""
    public Optional<StudentModel> findStudent(Long id){
        return studentRepository.findById(id);
    }


    //DELETE
    public String deletStudent(Long id){
        Optional<StudentModel> respuesta = studentRepository.findById(id);
        if(respuesta.isPresent()){
            studentRepository.deleteById(id);
            return  "Estudiante eliminado";
        }else{
            return "Estudiante no encontrado";
        }
    }

    public String deleteStudentById(Long id) {
        if(studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
            return "Estudiante eliminado";
        }else {
            return "Estudiante ="+ id+ " no encontrado";
        }
    }

    public StudentModel saveStudent(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }


    //Elimiar
    public  String deleteStudent(Long id){
        //primero buscar si existe un estudiante con ese id
        //Si existe lo eliminamos,si no mandamos mensaje de error
        if(studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        }else {
            return  ("Student not found whith id = "+id);
        }
    }


    //Buscar por id


    //Buscar por code
    public ArrayList<StudentModel> findByCode(Long code){
       return studentRepository.findByCode(code);
    }

    public ArrayList<StudentModel> findByName(String name){
        return studentRepository.findByName(name);
    }
}
