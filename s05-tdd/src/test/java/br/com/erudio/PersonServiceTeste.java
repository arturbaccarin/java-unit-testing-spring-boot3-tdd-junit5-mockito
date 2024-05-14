package br.com.erudio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.erudio.model.Person;
import br.com.erudio.service.IPersonService;
import br.com.erudio.service.PersonService;;

public class PersonServiceTeste {

    private Person person;
    IPersonService service;

    @BeforeEach
    void setup() {
        service = new PersonService();

        person = new Person(
                "Bruce",
                "Dickinson",
                "bd@i.com",
                "London - UK",
                "Male");
    }

    @DisplayName("when create a person with success should return a person object")
    @Test
    void testCreatePerson_WhenSuccess_ShoudlReturnPersonObject() {

        // Given / Arrange

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "the createPerson() should not have returned null");
    }

    @DisplayName("when create a person with success should contains FirstName in returned a person object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {

        // Given / Arrange

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "the createPerson() should not have returned null");

        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "the FirstName is different!");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "the LastName is different!");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "the Address is different!");
        assertEquals(person.getGender(), actual.getGender(), () -> "the Gender is different!");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "the Email is different!");
    }

    @DisplayName("when create a person with null e-mail shoudl throw an exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {

        person.setEmail(null);

        var expectedMessage = "person email is null or empty";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "empty email should have causa an IllegalArgumentException");

        assertEquals(
                expectedMessage,
                exception.getMessage(),
                () -> "exception error message is incorrect");
    }
}