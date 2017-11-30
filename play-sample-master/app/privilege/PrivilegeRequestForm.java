package privilege;

import lombok.Getter;
import lombok.Setter;
import play.data.validation.Constraints;

import java.util.ArrayList;

@Getter
@Setter
public class PrivilegeRequestForm {

    public String id;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String password;

    public String roleId;

    public int catId;

    public int typeId;


}