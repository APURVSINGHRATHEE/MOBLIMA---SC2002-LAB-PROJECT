package Helpful;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 */
public abstract class Body implements Serializable {
    /**
     * Unique ID of the entity
     */
    protected UUID uuid;

    /**
     * Create a body with a unique number generated using UUID
     */
    public Body() {
        this.uuid = UUID.randomUUID();
    }
    
     /**
     * Compare between bodies using their UUID
     * @param object The new object to compare to
     * @return True of the UUID of both objects are the same
     */
    @Override
    public boolean equals(Object object) {
        if ((null == object) || !(object instanceof Body))
            return false;
        Body body = (Body) object;
        return body.uuid == uuid;
    }

    /**
     * Get hash code value for the body, generated using the UUID
     * @return a hash code value
     */
    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
    
    /**
     * Return the body's UUID
     * @param body The body to obtain the UUID from
     * @return This body's UUID
     */
    public static UUID getUUID(Body body) {
        return body.uuid;
    }
    
    /**
     * Return the body's UUID
     * @param body The body to obtain the UUID from
     * @return This body's UUID in the string format
     */
    public static String getUUIDString(Body body) {
        return body.uuid.toString();
    }
    
    /**
     * Change the body's  UUID
     * @param body The body to set the UUID
     * @param uuid The new UUID to replace the body's UUID with
     */
    public void setId(Body body, UUID uuid) {
        body.uuid = uuid;
    }
}
