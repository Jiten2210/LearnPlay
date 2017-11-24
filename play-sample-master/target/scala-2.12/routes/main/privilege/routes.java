
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/privilege.routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

package privilege;

import privilege.RoutesPrefix;

public class routes {
  
  public static final privilege.ReversePrivilegeController PrivilegeController = new privilege.ReversePrivilegeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final privilege.javascript.ReversePrivilegeController PrivilegeController = new privilege.javascript.ReversePrivilegeController(RoutesPrefix.byNamePrefix());
  }

}
