package pillihuaman.com.pe.examen.repository.orden.dao.implement;


import org.springframework.stereotype.Repository;
import pillihuaman.com.pe.examen.repository.OrdenDAO;
import pillihuaman.com.pe.examen.repository.orden.dao.Orden;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Optional;

@Repository
public class OrdenDaoImplement implements OrdenDAO {

    private final DynamoDbTable<Orden> ordenTable;

    public OrdenDaoImplement(DynamoDbEnhancedClient enhancedClient) {
        String tableName = System.getenv("ORDENES_TABLE_NAME");
        this.ordenTable = enhancedClient.table(tableName, TableSchema.fromBean(Orden.class));
    }

    @Override
    public Orden save(Orden orden) {
        ordenTable.putItem(orden);
        return orden;
    }

    @Override
    public Optional<Orden> findById(String id) {
        Key key = Key.builder().partitionValue(id).build();
        return Optional.ofNullable(ordenTable.getItem(key));
    }

    @Override
    public Orden update(Orden orden) {
        return ordenTable.updateItem(orden);
    }
}