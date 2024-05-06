package org.udg.siiau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.udg.siiau.models.StudentModel;
import org.udg.siiau.services.StudentService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@RestController// indica la elaboracion de un API REST
@RequestMapping("/students") //Mapea peticion HTTP // Asigna URL al controlador
public class StudentController {


    @Autowired //Inyeccion de dependencias automaticas //Decide cuando crear el opbjeto o no
    StudentService studentService;

    @GetMapping()
    public ArrayList<StudentModel> getAllStudents(){
        return  studentService.getAllStudents();
    }

    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    //@GetMapping("/{id}")
    //public

    //@DeleteMapping()
    //public String deleteStudent(@RequestHeader Long id){
    //    return studentService.deletStudent(id);
    //}

    @DeleteMapping("/delete-by-id")
    public String deleteStudentById(@RequestParam("id") Long id){
        return studentService.deleteStudentById(id);
    }



    @PutMapping()
    public  StudentModel editStudent(@RequestHeader StudentModel student){
        return studentService.saveStudent(student);
    }

    //Encontrar por nombre
    @GetMapping(path = "/find-by-name") //http://tudominio.com/find-by-name?name=name_value
    public ArrayList<StudentModel> findByName(@RequestParam("name") String name){ //  El valor del parámetro "name" se asignará a la variable name
        return  studentService.findByName(name);
    }

    //Encpontrar por codigo
    @GetMapping(path = "/find-by-code")
    public ArrayList<StudentModel> findByCode(@RequestParam("code")Long code){
        return  studentService.findByCode(code);
    }

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        ArrayList<StudentModel> students = studentService.getAllStudents();
        System.out.println("Número de estudiantes: " + students.size()); // Verifica el tamaño de la lista
        model.addAttribute("students", students);
        return "students";
    }
}
