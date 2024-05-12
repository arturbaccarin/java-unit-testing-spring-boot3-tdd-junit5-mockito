package br.com.erudio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.model.Person;
import br.com.erudio.service.IPersonService;
import br.com.erudio.service.PersonService;;

public class PersonServiceTeste {

    @DisplayName("when create a person with success should return a person object")
    @Test
    void testCreatePerson_WhenSuccess_ShoudlReturnPersonObject() {

        // Given / Arrange
        IPersonService service = new PersonService();

        Person person = new Person(
                "Bruce",
                "Dickinson",
                "bd@i.com",
                "London - UK",
                "Male");

        // When / Act
        service.createPerson();

        // Then / Assert
    }
}
