package privilege;

import global.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import java.util.List;

@Entity(value = "privilege", noClassnameStored = true)
@Getter
@Setter
public class PrivilegeModel extends BaseModel {
    private String email;
    private String password;
    private int roleId;
    private List<UserPrivilegeCategory> categories ;
    private List<UserPrivilegeTypes> types ;

    public enum Fields {email, password, roleId}

}

@Embedded
class UserPrivilegeCategory {
    public int cateoryId;
}

@Embedded
class UserPrivilegeTypes{
     public int privilegeTypeId;
}



//role name  + role id -> roleModel
//requested role - >   embedded documents (nested model) req role id & type
//email, password - > usermodel