
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/users.routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

package user;

import users.RoutesPrefix;

public class routes {
  
  public static final user.ReverseUserController UserController = new user.ReverseUserController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final user.javascript.ReverseUserController UserController = new user.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
  }

}
