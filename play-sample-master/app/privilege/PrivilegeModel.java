package privilege;

import global.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "privilege", noClassnameStored = true)
@Getter
@Setter
public class PrivilegeModel extends BaseModel {
    private String email, password,role, privilegeName ,requestedRole, privilegeId;


    public enum Fields {email, password, role, privilegeName ,requestedRole, privilegeId}

}
