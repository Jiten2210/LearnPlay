
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/privilege.routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package privilege {

  // @LINE:2
  class ReversePrivilegeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def loginUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:7
    def updatePrivileges(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "update")
    }
  
    // @LINE:9
    def requestedRole(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "rolerequest")
    }
  
    // @LINE:12
    def logoutUser(token:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("token", token)))
    }
  
    // @LINE:3
    def registerUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:6
    def createAdmin(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "createadmin")
    }
  
    // @LINE:10
    def createRoles(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "create/role")
    }
  
    // @LINE:11
    def revokePrivileges(email:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)))
    }
  
    // @LINE:8
    def getPrivilege(email:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)))
    }
  
    // @LINE:13
    def deleteUser(email:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)))
    }
  
    // @LINE:2
    def getAllUsers(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:5
    def createSuperAdmin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "superadmin")
    }
  
  }


}
