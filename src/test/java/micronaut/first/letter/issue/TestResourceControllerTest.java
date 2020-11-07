package micronaut.first.letter.issue;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.core.naming.Named;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.*;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import lombok.AllArgsConstructor;
import lombok.Value;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@MicronautTest
public class TestResourceControllerTest {

    @Test
    public void testClass1() {
        // Given, When
        BeanIntrospection<TestClass1> introspection = BeanIntrospection.getIntrospection(TestClass1.class);
        List<String> constructorArgs = Arrays.stream(introspection.getConstructorArguments())
                .map(Named::getName)
                .collect(toList());
        List<String> properties = introspection.getBeanProperties().stream()
                .map(Named::getName)
                .collect(toList());

        // Then
        assertEquals(constructorArgs, properties, "Test: properties are equal to constructor arguments");
    }

    @Test
    public void testClass2() {
        // Given, When
        BeanIntrospection<TestClass2> introspection = BeanIntrospection.getIntrospection(TestClass2.class);
        List<String> constructorArgs = Arrays.stream(introspection.getConstructorArguments())
                .map(Named::getName)
                .collect(toList());
        List<String> properties = introspection.getBeanProperties().stream()
                .map(Named::getName)
                .collect(toList());

        // Then
        assertEquals(constructorArgs, properties, "Test: properties are equal to constructor arguments");
    }

    @Test
    public void testClassLombok() {
        // Given, When
        BeanIntrospection<TestClassLombok> introspection = BeanIntrospection.getIntrospection(TestClassLombok.class);
        List<String> constructorArgs = Arrays.stream(introspection.getConstructorArguments())
                .map(Named::getName)
                .collect(toList());
        List<String> properties = introspection.getBeanProperties().stream()
                .map(Named::getName)
                .collect(toList());

        // Then
        assertEquals(constructorArgs, properties, "Test: properties are equal to constructor arguments");
    }

    @Introspected
    public static class TestClass1 {

        private final String xForwardedFor;

        public TestClass1(String xForwardedFor) {
            this.xForwardedFor = xForwardedFor;
        }

        public String getxForwardedFor() {
            return xForwardedFor;
        }

    }

    @Introspected
    public static class TestClass2 {

        private final String xForwardedFor;

        public TestClass2(String xForwardedFor) {
            this.xForwardedFor = xForwardedFor;
        }

        public String getXForwardedFor() {
            return xForwardedFor;
        }

    }

    @Value
    @AllArgsConstructor
    @Introspected
    public static class TestClassLombok {

        private final String xForwardedFor;
    }

}
