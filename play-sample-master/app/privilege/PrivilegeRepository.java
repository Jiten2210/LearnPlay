package privilege;

import org.bson.types.ObjectId;
import user.UserModel;

import java.util.ArrayList;
import java.util.List;

public interface PrivilegeRepository {

    List<PrivilegeModel> getAllUsers();

    PrivilegeModel registerUser(PrivilegeModel newUser);

    PrivilegeModel loginUser(String email, String password);

    void updateUser(final PrivilegeModel user);

    PrivilegeModel getUser(String email);

    PrivilegeModel makeSuperAdmin(String email);

    void updatePrivileges(final PrivilegeModel user);

    List<PrivilegeModel> assignRole();

    PrivilegeModel getUser(ObjectId userId);

    boolean deleteUser(final ObjectId userId);

}

