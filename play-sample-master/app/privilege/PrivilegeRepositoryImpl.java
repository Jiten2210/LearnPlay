package privilege;

import global.common.BaseModel;
import global.common.BaseRepository;
import global.configuration.db.mongodb.MongoDBConnection;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class PrivilegeRepositoryImpl extends BaseRepository<PrivilegeModel> implements PrivilegeRepository {

    @Inject
    public PrivilegeRepositoryImpl(MongoDBConnection databaseConnection) {
        super(PrivilegeModel.class, databaseConnection);
    }

    @Override
    public boolean deleteUser(ObjectId userId) {
        return delete(userId);
    }

    @Override
    public List<PrivilegeModel> getAllUsers() {
        return query().asList();
    }

    @Override
    public PrivilegeModel registerUser(PrivilegeModel newUser) {
        PrivilegeModel user = query()
                .field(PrivilegeModel.Fields.email.name())
                .equal(newUser.getEmail()).get();
        if (user != null)
            return null;

        create(newUser);
        return newUser;
    }

    @Override
    public PrivilegeModel loginUser(String email, String password) {
        return query()
                .field(PrivilegeModel.Fields.email.name())
                .equal(email)
                .field(PrivilegeModel.Fields.password.name())
                .equal(password)
                .get();
    }


    @Override
    public void updateUser(PrivilegeModel user) {
        update(user);
    }

    @Override
    public PrivilegeModel getUser(String email) {

        return query()
                .field(PrivilegeModel.Fields.email.name())
                .equal(email)
                .get();
    }

    @Override
    public PrivilegeModel makeSuperAdmin(String email) {
       return query()
                .field(PrivilegeModel.Fields.email.name())
                .equal(email).get();
      // PrivilegeModel q2 =   query().field(PrivilegeModel.Fields.role.name()).notEqual("superadmin").get();
    }

    @Override
    public void updatePrivileges(PrivilegeModel user) {
        update(user);
    }

    @Override
    public List<PrivilegeModel> assignRole() {
        return query()
                .field(PrivilegeModel.Fields.requestedRole.name())
                .notEqual("")
                .field(PrivilegeModel.Fields.role.name()).notEqual("superadmin").asList();
    }

    @Override
    public PrivilegeModel getUser(ObjectId userId) {
        return query()
                .field(BaseModel.Fields.id.name())
                .equal(userId)
                .get();
    }

}