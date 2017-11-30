package role;

import org.bson.types.ObjectId;
import role.RoleModel;

import java.util.List;

public interface RoleRepository {

    List<RoleModel> getAllRoles();

    boolean deleteRole(final ObjectId RoleId);

    void updateRole(final RoleModel Role);

    RoleModel getRole(ObjectId RoleId);

    RoleModel createRole(RoleModel newRole);
}
