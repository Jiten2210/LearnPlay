
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/users.routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package user.javascript {

  // @LINE:2
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def updateUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "user.UserController.updateUser",
      """
        function(userId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:3
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "user.UserController.createUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:4
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "user.UserController.getUser",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:6
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "user.UserController.deleteUser",
      """
        function(userId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:2
    def getAllUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "user.UserController.getAllUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
