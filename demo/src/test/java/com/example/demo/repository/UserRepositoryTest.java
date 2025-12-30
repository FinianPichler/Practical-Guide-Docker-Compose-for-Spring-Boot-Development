package com.example.demo.repository;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest extends BaseIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveAndFindUser() {
        // Given
        User user = User.builder()
                .username("testuser")
                .email("test@example.com")
                .build();

        // When
        User saved = userRepository.save(user);
        User found = userRepository.findById(saved.getId()).orElse(null);

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("testuser");
        assertThat(found.getEmail()).isEqualTo("test@example.com");
        assertThat(found.getCreatedAt()).isNotNull();
    }

    @Test
    void shouldFindUserByUsername() {
        // Given
        User user = User.builder()
                .username("john")
                .email("john@example.com")
                .build();
        userRepository.save(user);

        // When
        User found = userRepository.findByUsername("john").orElse(null);

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo("john@example.com");
    }

    @Test
    void shouldReturnEmptyWhenUserNotFound() {
        // When
        var result = userRepository.findByUsername("nonexistent");

        // Then
        assertThat(result).isEmpty();
    }
}
