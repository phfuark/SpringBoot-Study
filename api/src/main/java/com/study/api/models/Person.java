package com.study.api.models;

// Importação das anotações da biblioteca Jakarta Persistence (JPA)
import jakarta.persistence.Entity; // Marca a classe como uma entidade gerenciada pela JPA.
import jakarta.persistence.GeneratedValue; // Define como o valor do identificador será gerado.
import jakarta.persistence.GenerationType; // Estratégias para geração de identificadores.
import jakarta.persistence.Id; // Marca um campo como a chave primária da entidade.
import jakarta.persistence.Table; // Permite configurar o nome da tabela no banco de dados.

// Marca a classe como uma entidade JPA (será mapeada para uma tabela no banco de dados)
@Entity
// Especifica que a tabela correspondente no banco de dados terá o nome "Persons"
@Table(name = "Persons")
public class Person {

    @Id
    // Configura a geração automática dos valores para o campo 'code'
    // GenerationType.IDENTITY indica que o banco de dados será responsável pela geração (ex.: auto incremento)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String name;
    private int age;



    // Métodos getters e setters para permitir acesso e modificação dos atributos
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
