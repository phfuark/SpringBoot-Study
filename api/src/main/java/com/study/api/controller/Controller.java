package .com.study.api.controller;


import com.study.api.models.Person;

@RestController
public class Controller {

    @GetMapping("")
    public String HelloWord(){
        return "Hello Word";
    }

    @GetMapping("BemVinda")
    public String BemVinda(){
        return "Bem vindo(a)";
    }

    @GetMapping("BemVinda/${nome}")
    public String BemVinda(@PathVariable String nome){
        return "Bem vindo(a)" + nome;
    }

    @PostMapping("/person")
    public Person person(@RequestBody Person person){
        return person;
    }

}