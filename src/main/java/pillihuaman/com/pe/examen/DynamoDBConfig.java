package pillihuaman.com.pe.examen;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pillihuaman.com.pe.examen.repository.orden.dao.Orden;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;

import java.net.URI;
@Configuration
public class DynamoDBConfig {

    @Value("${aws.region}")
    private String region;
    @Value("${AWS_DYNAMODB_TABLE_ORDEN}")
    private String ordenTable;

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.of(region))
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }

    @Bean
    public DynamoDbTable<Orden> ordenTable(DynamoDbEnhancedClient enhancedClient) {
        return enhancedClient.table(ordenTable, TableSchema.fromBean(Orden.class));
    }

    @PostConstruct
    public void testEnv() {
        System.out.println("🔑 AWS REGION: " + region);
        System.out.println("🔑 Orden Table: " + ordenTable);
    }
}
