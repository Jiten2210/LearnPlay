
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package global.common {

  // @LINE:8
  class ReverseBaseController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
