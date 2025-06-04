package com.test.crud.exception.handler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import com.test.crud.dto.ErrorDto;
import com.test.crud.exception.ResourceNotFoundException;

class GlobalExceptionHandlerTest {

    @Test
    void resourceNotFoundException_returnsErrorDto() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        WebRequest request = mock(WebRequest.class);
        when(request.getDescription(false)).thenReturn("uri=/test");

        ResponseEntity<?> response = handler.resourceNotFoundException(
                new ResourceNotFoundException("not found"), request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertTrue(response.getBody() instanceof ErrorDto);
        ErrorDto body = (ErrorDto) response.getBody();
        assertEquals("not found", body.getMessage());
        assertEquals("uri=/test", body.getDetails());
        assertNotNull(body.getTimestamp());
    }
}
