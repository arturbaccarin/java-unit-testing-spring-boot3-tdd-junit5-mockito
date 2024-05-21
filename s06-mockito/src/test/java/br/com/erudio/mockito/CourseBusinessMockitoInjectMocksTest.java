package br.com.erudio.mockito;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.business.CourseBusiness;
import br.com.erudio.service.CourseService;

@ExtendWith(MockitoExtension.class)
public class CourseBusinessMockitoInjectMocksTest {

    @Mock
    CourseService mockService;

    @InjectMocks
    CourseBusiness business;
    // business = new CourseBusiness(mockService);

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    List<String> courses;

    @BeforeEach
    void setup() {

        // Given / Arrange
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        // When / Act
        var filteredCourses = business.retrieveCourseRelatedToSpring("Leandro");

        // Then / Assert
        assertThat(filteredCourses.size(), is(4));
    }

    // test[System Under Test]_[Condition os State Change]_[Expected Result]
    @DisplayName("delete courses not related to spring using mockito should call method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourse() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService, times(1)).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
        verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker");

        // can use atLeast or atLeastOnce
    }

    @DisplayName("delete courses not related to spring using mockito should call method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourseV2() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
        String architectureCourse = "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#";
        String restSpringCourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker";

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        then(mockService).should().deleteCourse(agileCourse);
        then(mockService).should().deleteCourse(architectureCourse);
        then(mockService).should(never())
                .deleteCourse(restSpringCourse);

    }

    @DisplayName("delete courses not related to spring capturing arguments should call method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethod_deleteCourseV2() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        // ArgumentCaptor<String> argumentCaptor =
        // ArgumentCaptor.forClass(String.class);

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}