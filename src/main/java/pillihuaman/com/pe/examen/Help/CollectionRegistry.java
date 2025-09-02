package pillihuaman.com.pe.examen.Help;


import lombok.Getter;

import java.util.Optional;

/**
 * An Enum that serves as the single source of truth for all collection names in the database.
 * This is used to normalize and validate collection names suggested by the AI.
 */
@Getter
public enum CollectionRegistry {
    // This list is built from the collection names you provided
    COMMON_DATA("common_data", "Configuration Data"),
    CONTROL("control", "Control Information"),
    MENU("menu", "System Menus"),
    NOTIFICATION_TEMPLATES("notification_templates", "Notification Templates"),
    PAGE("page", "System Pages"),
    PRODUCT("product", "Products Catalog"), // Assuming your product collection is 'product'
    PURCHASE_ORDER("purchaseOrder", "Purchase Orders"),
    PURCHASE_ORDER_ITEMS("purchase_order_items", "Purchase Order Items"),
    QUOTATIONS("quotations", "Quotations"),
    ROLE("role", "User Roles"),
    SUPPLIER("supplier", "Suppliers"),
    SYSTEM("system", "System Configuration"),
    TENANT("tenant", "Tenants"),
    TOKEN("token", "User Tokens"),
    WAREHOUSE("warehouse", "Warehouses"),
    FILE_METADATA("file_metadata", "File Metadata"),
    USER("user", "Users"); // Assuming your security user collection is 'user'

    private final String collectionName;
    private final String description;

    CollectionRegistry(String collectionName, String description) {
        this.collectionName = collectionName;
        this.description = description;
    }

    /**
     * Attempts to find the correct collection from a potentially incorrect name
     * provided by the AI. Handles plurals and common variations.
     * @param aiSuggestedName The name from the AI.
     * @return An Optional containing the canonical collection name.
     */
    public static Optional<String> findCanonicalName(String aiSuggestedName) {
        if (aiSuggestedName == null || aiSuggestedName.isBlank()) {
            return Optional.empty();
        }
        String normalized = aiSuggestedName.toLowerCase().trim().replace("_", "");

        for (CollectionRegistry entry : values()) {
            String canonicalNormalized = entry.getCollectionName().toLowerCase().replace("_", "");
            // Check for direct match or plural match
            if (canonicalNormalized.equals(normalized) || (canonicalNormalized + "s").equals(normalized)) {
                return Optional.of(entry.getCollectionName());
            }
        }
        return Optional.empty();
    }
}