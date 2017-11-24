package privilege;


import com.google.common.collect.ImmutableMap;
import global.common.BaseController;
import global.exceptions.CustomException;
import play.data.Form;
import play.mvc.BodyParser;
import play.mvc.Result;
import session.SessionService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public final class PrivilegeController extends BaseController {

    private final PrivilegeService userService;
    private final SessionService sessionService;

    @Inject
    public PrivilegeController(PrivilegeService userService, SessionService sessionService) {
        this.userService = userService;
        this.sessionService = sessionService;
    }

    public Result loginUser() {
        try {
            final Form<PrivilegeRequestForm> userModelForm = formFactory.form(PrivilegeRequestForm.class).bindFromRequest();
            final PrivilegeRequestForm inputForm = userModelForm.get();

            Optional<PrivilegeModel> user = this.userService.loginUser(inputForm);
            if (user.isPresent()) {
                PrivilegeModel privModel = user.get();
                String session = sessionService.generateSession();
                boolean status = sessionService.assignSessionToUser(privModel.getId(), session,inputForm);

                return status ? success("successfully login", ImmutableMap.of("session", session)) : failure("failed to login");
            } else {
                return failure("Invalid Login credentials");
            }

        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }

    public Result logoutUser(String sessionToken) {
        boolean status = this.sessionService.deleteSession(sessionToken);
        return status ? success("You've been successfully logged out") : failure("not logout");
    }

    public Result deleteUser(String userId) {
        try {
            PrivilegeModel priv = userService.getPrivilege(userId);
            final boolean status = userService.deleteUser(priv.getId());
            return status ? success("successfully deleted user") : failure("failed to delete user");
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result registerUser() {
        try {
            final Form<PrivilegeRequestForm> userModelForm = formFactory.form(PrivilegeRequestForm.class).bindFromRequest();
            if (userModelForm.hasErrors()) {
                return failure(buildValidationErrorMessage(userModelForm.allErrors()));
            }
            final PrivilegeRequestForm userForm = userModelForm.get();

            final PrivilegeModel user = this.userService.registerUser(userForm);
            return user != null ? success("User successfully registered with ID: " + user.getId()) : failure("failed to create user");
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }

    public Result getAllUsers() {
        if (isSessionValid()) {
            try {
                return success(ImmutableMap.of("privilege", userService.getAllUsers()));
            } catch (CustomException e) {
                return failure(e.getMessage());
            }
        }
        else {
            return failure("Invalid Session");
        }
    }



    public Result createSuperAdmin() {
        if (isSessionValid()) {
            try {
                final Form<PrivilegeRequestForm> userModelForm = formFactory.form(PrivilegeRequestForm.class).bindFromRequest();
                if (userModelForm.hasErrors()) {
                    return failure(buildValidationErrorMessage(userModelForm.allErrors()));
                }
                final PrivilegeRequestForm userForm = userModelForm.get();
                boolean user = this.userService.createSuperAdmin(userForm);
                return user == true ? success("successfully created super admin") : failure("failed to create superadmin");
            } catch (CustomException e) {
                return failure(e.getMessage());
            }
        }
            else {
                return failure("Invalid Session");
            }
    }

    public Result createAdmin() {
        if (isSessionValid()) {
            try {

                final Form<PrivilegeRequestForm> userModelForm = formFactory.form(PrivilegeRequestForm.class).bindFromRequest();
                if (userModelForm.hasErrors()) {
                    return failure(buildValidationErrorMessage(userModelForm.allErrors()));
                }
                final PrivilegeRequestForm userForm = userModelForm.get();
                boolean status = this.userService.createAdmin(userForm);
                return status == true ? success("successfully created Admin") : failure("failed to create admin");
            } catch (CustomException e) {
                return failure(e.getMessage());
            }
        }
        else {
            return failure("Invalid Session");
        }
    }

    public Result getPrivilege(String email) {
        if (isSessionValid()) {
            try {
                PrivilegeModel user = userService.getPrivilege(email);
                return user != null ? success("User has privilege to : " + user.getPrivilegeName()) : failure("failed to get privileges");

            } catch (CustomException e) {
                return failure(e.getMessage());
            }
        }
        else {
            return failure("Invalid Session");
        }
    }

    public Result updatePrivileges() {
        if (isSessionValid()) {

        try {
            final Form<PrivilegeRequestForm> userModelForm = formFactory.form(PrivilegeRequestForm.class).bindFromRequest();
            if (userModelForm.hasErrors()) {
                return failure(buildValidationErrorMessage(userModelForm.allErrors()));
            }

            final PrivilegeRequestForm userForm = userModelForm.get();
            final PrivilegeModel user = this.userService.updatePrivileges(userForm);
            return user != null ? success("successfully updated privileges") : failure("failed to update privilege");
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }
    else {
        return failure("Invalid Session");
    }
    }

    public Result revokePrivileges(String email) {
        if (isSessionValid()) {
            try {

                final PrivilegeModel status = userService.revokePrivileges(email);
                return status != null ? success("successfully revoked privileges") : failure("failed to revoke privileges");
            } catch (CustomException e) {
                return failure(e.getMessage());
            }
        }
        else {
            return failure("Invalid Session");
        }
    }

    public Result requestedRole() {
        if (isSessionValid()) {

            try {
                final Form<PrivilegeRequestForm> userModelForm = formFactory.form(PrivilegeRequestForm.class).bindFromRequest();
                if (userModelForm.hasErrors()) {
                    return failure(buildValidationErrorMessage(userModelForm.allErrors()));
                }
                final PrivilegeRequestForm userForm = userModelForm.get();
                boolean user = this.userService.createRoleRequest(userForm);
                return user == true ? success("successfully raised role request to admin") : failure("role request failed");
            } catch (CustomException e) {
                return failure(e.getMessage());
            }
        }
        else {
            return failure("Invalid Session");
        }

    }

    public Result createRoles() {
        if (isSessionValid()) {
        try {
            boolean user = userService.createRoles();
            return user == true ? success("successfully assigned role to user") : failure("role assignment failed");
        } catch (CustomException e) {
            return failure(e.getMessage());
        }
    }
    else {
        return failure("Invalid Session");
    }

    }
}
