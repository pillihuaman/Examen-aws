package pillihuaman.com.pe.examen.repository.orden.dao;


import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
public class Orden {
    private String ordenId;
    private String clienteId;
    private String fecha;
    private double montoTotal;
    private String estado;

    @DynamoDbPartitionKey
    public String getOrdenId() {
        return ordenId;
    }
}
