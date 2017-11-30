package role;

import lombok.Getter;
import lombok.Setter;
import play.data.validation.Constraints;

@Getter
@Setter
public class RoleRequestForm {

    @Constraints.Required
    public int roleId;

    @Constraints.Required
    public String roleName;

}
