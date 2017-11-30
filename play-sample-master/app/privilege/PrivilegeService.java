package privilege;

import global.exceptions.CustomException;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

import static global.utils.Helper.compare;
import static global.utils.Helper.hash;

@Singleton
public class PrivilegeService {

    private final PrivilegeRepository repository;

    @Inject
    public PrivilegeService(final PrivilegeRepository repository) {
        this.repository = repository;
    }

    List<PrivilegeModel> getAllUsers() {
        return repository.getAllUsers();
    }

    boolean deleteUser(ObjectId userId) {
        final PrivilegeModel user = repository.getUser(userId);
        if (user == null) {
            throw new CustomException("No user exists for given user ID");
        }
        return repository.deleteUser(userId);
    }

    public Optional<PrivilegeModel> loginUser(PrivilegeRequestForm mForm) {
        final PrivilegeModel user = repository.getUser(mForm.getEmail());
        boolean flag = compare(mForm.getPassword(), user.getPassword());

        if (flag)
            return Optional.of(user);
        else
            return Optional.empty();

    }

    public PrivilegeModel registerUser(PrivilegeRequestForm userForm) {
        final PrivilegeModel newUser = new PrivilegeModel();
        newUser.setEmail(userForm.getEmail());
        newUser.setPassword(hash(userForm.getPassword()));
        newUser.setRoleId(0);
        return repository.registerUser(newUser);
    }

    public boolean createSuperAdmin(PrivilegeRequestForm userForm) {
        PrivilegeModel user = repository.makeSuperAdmin(userForm.getEmail());
        if (user != null) {
            user.setRole(userForm.getRole());
            repository.updateUser(user);
            return true;
        }

        return false;
    }

    public boolean createAdmin(PrivilegeRequestForm userForm) {
        boolean flag = false;
        for (String s : userForm.getIds()) {
            PrivilegeModel user = repository.getUser(s);
            if (user != null) {
                user.setRole(userForm.getRole());
                repository.updateUser(user);
                flag = true;
            }
        }
        if (flag)
            return true;
        else
            return false;
    }

    public PrivilegeModel getPrivilege(String email) {
        return repository.getUser(email);
    }

    public PrivilegeModel revokePrivileges(String email) {
        final PrivilegeModel user = repository.getUser(email);
        if (user == null) {
            throw new CustomException("No user exists for given email ID");
        }
        user.setPrivilegeName(" ");
        repository.updatePrivileges(user);
        return user;
    }

    public PrivilegeModel updatePrivileges(PrivilegeRequestForm userForm) {
        final PrivilegeModel user = repository.getUser(userForm.getEmail());
        if (user == null) {
            throw new CustomException("No user exists for given email ID");
        }
        user.setPrivilegeName(userForm.getPrivilegeName());
        user.setPrivilegeId(getPrivilegeId(userForm.getPrivilegeName()));
        repository.updatePrivileges(user);
        return user;
    }

    public boolean createRoleRequest(PrivilegeRequestForm userForm) {
        PrivilegeModel user = repository.getUser(userForm.getEmail());
        if (user != null) {
            user.setRequestedRole(userForm.getRole());
            repository.updateUser(user);
            return true;
        }
        return false;
    }

    public boolean createRoles() {
        List<PrivilegeModel> roleList = repository.assignRole();
        if (!roleList.isEmpty()) {
            for (PrivilegeModel user : roleList) {
                user.setRole("Member");
                repository.updateUser(user);
            }
            return true;
        } else
            return false;
    }

    public String getPrivilegeId(String name) {
        switch (name.toLowerCase()) {
            case "read":
                return "0";
            case "write":
                return "1";
            case "r&w":
                return "2";
        }
        return null;
    }
}