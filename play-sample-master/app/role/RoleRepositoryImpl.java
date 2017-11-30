package role;

import global.common.BaseModel;
import global.common.BaseRepository;
import global.configuration.db.mongodb.MongoDBConnection;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class RoleRepositoryImpl extends BaseRepository<RoleModel> implements RoleRepository {

    @Inject
    public RoleRepositoryImpl(MongoDBConnection databaseConnection) {
        super(RoleModel.class, databaseConnection);
    }

    @Override
    public List<RoleModel> getAllRoles() {
        return query().asList();
    }

    @Override
    public boolean deleteRole(ObjectId roleId) {
        return delete(roleId);
    }

    @Override
    public void updateRole(RoleModel role) {
        update(role);
    }

    @Override
    public RoleModel getRole(ObjectId roleId) {
        return query()
                .field(BaseModel.Fields.id.name())
                .equal(roleId)
                .get();
    }

    @Override
    public RoleModel createRole(RoleModel newRole) {
        create(newRole);
        return newRole;
    }

}
