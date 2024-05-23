package br.com.erudio.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("3a5297b3-c681-43a6-8a52-9b3c018b3d72");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 7, 4, 15, 50);

    @DisplayName("Should Include Random OrderId When NoOrderId Exists")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
        // Given / Arrange
        try (MockedStatic<UUID> mockedUuid = Mockito.mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            // When / Act
            Order result = service.createOrder("MacBook Pro", 2L, null);

            // Then / Assert
            assertEquals(defaultUuid.toString(), result.getId());
        }
    }

    @DisplayName("Should Include Random OrderId When NoOrderId Exists")
    @Test
    void testShouldIncludeCurrentTime_When_NoOrderIdExists() {
        // Given / Arrange
        try (MockedStatic<LocalDateTime> mockedUuid = Mockito.mockStatic(LocalDateTime.class)) {
            mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            // When / Act
            Order result = service.createOrder("MacBook Pro", 2L, null);

            // Then / Assert
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
    }
}
