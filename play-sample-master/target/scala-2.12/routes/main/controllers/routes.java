
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
