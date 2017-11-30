package role;

import global.exceptions.CustomException;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class RoleService {

    private final RoleRepository repository;

    @Inject
    public RoleService(final RoleRepository repository) {
        this.repository = repository;
    }

    List<RoleModel> getAllRoles() {
        return repository.getAllRoles();
    }


    boolean deleteRole(ObjectId roleId) {
        final RoleModel role = repository.getRole(roleId);
        if (role == null) {
            throw new CustomException("No Role exists for given Role ID");
        }

        return repository.deleteRole(roleId);
    }

    public RoleModel getRole(ObjectId RoleId) {
        return repository.getRole(RoleId);
    }

    public RoleModel createRole(RoleRequestForm roleForm) {
        final RoleModel newRole = new RoleModel();
        newRole.setRoleId(roleForm.getRoleId());
        newRole.setRoleName(roleForm.getRoleName());
        return repository.createRole(newRole);
    }

    public RoleModel updateRole(ObjectId roleId, RoleRequestForm roleForm) {
        final RoleModel role = repository.getRole(roleId);
        if (role == null) {
            throw new CustomException("No Role exists for given Role ID");
        }

        role.setRoleId(roleForm.getRoleId());
        role.setRoleName(roleForm.getRoleName());

        repository.updateRole(role);

        return role;
    }

}
