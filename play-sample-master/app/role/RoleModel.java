package role;

import global.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.mongodb.morphia.annotations.Entity;

@Entity(value = "role", noClassnameStored = true)
@Getter
@Setter
public class RoleModel extends BaseModel {
    private int roleId;
    private String roleName;


    public enum Fields {roleId, roleName}

}