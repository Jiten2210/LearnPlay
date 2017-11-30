package role;


import com.google.common.collect.ImmutableMap;
import global.common.BaseController;
import global.exceptions.CustomException;
import org.bson.types.ObjectId;
import play.data.Form;
import play.mvc.BodyParser;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class RoleController extends BaseController {

    private final RoleService roleService;


    @Inject
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    public Result getRole(String roleIdStr) {
        try {
            if (!ObjectId.isValid(roleIdStr)) {
                return failure("Invalid role ID type");
            }
            RoleModel role = roleService.getRole(new ObjectId(roleIdStr));
            return role != null ? success(ImmutableMap.of("role", role)) : failure("Invalid role ID");
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result createrole() {
        try {

            final Form<RoleRequestForm> roleModelForm = formFactory.form(RoleRequestForm.class).bindFromRequest();
            if (roleModelForm.hasErrors()) {
                return failure(buildValidationErrorMessage(roleModelForm.allErrors()));
            }
            final RoleRequestForm roleForm = roleModelForm.get();
            final RoleModel role = this.roleService.createRole(roleForm);
            return role != null ? success("successfully created Role with ID: " + role.getId()) : failure("failed to create Role");
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }

    public Result updateRole(String roleIdStr) {
        try {
            final Form<RoleRequestForm> roleModelForm = formFactory.form(RoleRequestForm.class).bindFromRequest();
            if (roleModelForm.hasErrors()) {
                return failure(buildValidationErrorMessage(roleModelForm.allErrors()));
            }

            if (!ObjectId.isValid(roleIdStr)) {
                return failure("Invalid Role ID type");
            }

            final RoleRequestForm roleForm = roleModelForm.get();
            final RoleModel role = this.roleService.updateRole(new ObjectId(roleIdStr), roleForm);
            return role != null ? success("successfully updated Role") : failure("failed to update Role");
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }

    public Result deleteRole(String roleIdStr) {
        try {
            if (!ObjectId.isValid(roleIdStr)) {
                return failure("Invalid Role ID type");
            }
            final boolean status = roleService.deleteRole(new ObjectId(roleIdStr));
            return status ? success("successfully deleted Role") : failure("failed to delete Role");
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }

    public Result getAllRoles() {
        try {
            return success(ImmutableMap.of("Roles", roleService.getAllRoles()));
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }

}
