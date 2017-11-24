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

    public String role;

    public String privilegeName;

    public String requestedRole;

    public ArrayList<String> ids;

    public Integer privilegeId;
}