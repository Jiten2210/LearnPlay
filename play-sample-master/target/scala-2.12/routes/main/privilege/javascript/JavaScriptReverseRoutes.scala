
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/privilege.routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package privilege.javascript {

  // @LINE:2
  class ReversePrivilegeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def loginUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.loginUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:7
    def updatePrivileges: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.updatePrivileges",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "update"})
        }
      """
    )
  
    // @LINE:9
    def requestedRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.requestedRole",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rolerequest"})
        }
      """
    )
  
    // @LINE:12
    def logoutUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.logoutUser",
      """
        function(token0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("token", token0))})
        }
      """
    )
  
    // @LINE:3
    def registerUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.registerUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:6
    def createAdmin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.createAdmin",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "createadmin"})
        }
      """
    )
  
    // @LINE:10
    def createRoles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.createRoles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "create/role"})
        }
      """
    )
  
    // @LINE:11
    def revokePrivileges: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.revokePrivileges",
      """
        function(email0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email0))})
        }
      """
    )
  
    // @LINE:8
    def getPrivilege: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.getPrivilege",
      """
        function(email0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email0))})
        }
      """
    )
  
    // @LINE:13
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.deleteUser",
      """
        function(email0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "delete/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("email", email0))})
        }
      """
    )
  
    // @LINE:2
    def getAllUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.getAllUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:5
    def createSuperAdmin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "privilege.PrivilegeController.createSuperAdmin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "superadmin"})
        }
      """
    )
  
  }


}
