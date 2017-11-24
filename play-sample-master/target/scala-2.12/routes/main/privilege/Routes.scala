
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/privilege.routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

package privilege

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  PrivilegeController_0: privilege.PrivilegeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    PrivilegeController_0: privilege.PrivilegeController
  ) = this(errorHandler, PrivilegeController_0, "/")

  def withPrefix(prefix: String): Routes = {
    privilege.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PrivilegeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """privilege.PrivilegeController.getAllUsers()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """privilege.PrivilegeController.registerUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """privilege.PrivilegeController.loginUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """superadmin""", """privilege.PrivilegeController.createSuperAdmin()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createadmin""", """privilege.PrivilegeController.createAdmin()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """update""", """privilege.PrivilegeController.updatePrivileges()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """email<[^/]+>""", """privilege.PrivilegeController.getPrivilege(email:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rolerequest""", """privilege.PrivilegeController.requestedRole()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create/role""", """privilege.PrivilegeController.createRoles()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """email<[^/]+>""", """privilege.PrivilegeController.revokePrivileges(email:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout/""" + "$" + """token<[^/]+>""", """privilege.PrivilegeController.logoutUser(token:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete/""" + "$" + """email<[^/]+>""", """privilege.PrivilegeController.deleteUser(email:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val privilege_PrivilegeController_getAllUsers0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val privilege_PrivilegeController_getAllUsers0_invoker = createInvoker(
    PrivilegeController_0.getAllUsers(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "getAllUsers",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val privilege_PrivilegeController_registerUser1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val privilege_PrivilegeController_registerUser1_invoker = createInvoker(
    PrivilegeController_0.registerUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "registerUser",
      Nil,
      "POST",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val privilege_PrivilegeController_loginUser2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val privilege_PrivilegeController_loginUser2_invoker = createInvoker(
    PrivilegeController_0.loginUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "loginUser",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val privilege_PrivilegeController_createSuperAdmin3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("superadmin")))
  )
  private[this] lazy val privilege_PrivilegeController_createSuperAdmin3_invoker = createInvoker(
    PrivilegeController_0.createSuperAdmin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "createSuperAdmin",
      Nil,
      "POST",
      this.prefix + """superadmin""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val privilege_PrivilegeController_createAdmin4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createadmin")))
  )
  private[this] lazy val privilege_PrivilegeController_createAdmin4_invoker = createInvoker(
    PrivilegeController_0.createAdmin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "createAdmin",
      Nil,
      "PUT",
      this.prefix + """createadmin""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val privilege_PrivilegeController_updatePrivileges5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("update")))
  )
  private[this] lazy val privilege_PrivilegeController_updatePrivileges5_invoker = createInvoker(
    PrivilegeController_0.updatePrivileges(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "updatePrivileges",
      Nil,
      "PUT",
      this.prefix + """update""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val privilege_PrivilegeController_getPrivilege6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val privilege_PrivilegeController_getPrivilege6_invoker = createInvoker(
    PrivilegeController_0.getPrivilege(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "getPrivilege",
      Seq(classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """email<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val privilege_PrivilegeController_requestedRole7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rolerequest")))
  )
  private[this] lazy val privilege_PrivilegeController_requestedRole7_invoker = createInvoker(
    PrivilegeController_0.requestedRole(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "requestedRole",
      Nil,
      "POST",
      this.prefix + """rolerequest""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val privilege_PrivilegeController_createRoles8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create/role")))
  )
  private[this] lazy val privilege_PrivilegeController_createRoles8_invoker = createInvoker(
    PrivilegeController_0.createRoles(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "createRoles",
      Nil,
      "GET",
      this.prefix + """create/role""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val privilege_PrivilegeController_revokePrivileges9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val privilege_PrivilegeController_revokePrivileges9_invoker = createInvoker(
    PrivilegeController_0.revokePrivileges(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "revokePrivileges",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """""" + "$" + """email<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val privilege_PrivilegeController_logoutUser10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val privilege_PrivilegeController_logoutUser10_invoker = createInvoker(
    PrivilegeController_0.logoutUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "logoutUser",
      Seq(classOf[String]),
      "GET",
      this.prefix + """logout/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val privilege_PrivilegeController_deleteUser11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val privilege_PrivilegeController_deleteUser11_invoker = createInvoker(
    PrivilegeController_0.deleteUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "privilege",
      "privilege.PrivilegeController",
      "deleteUser",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """delete/""" + "$" + """email<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case privilege_PrivilegeController_getAllUsers0_route(params@_) =>
      call { 
        privilege_PrivilegeController_getAllUsers0_invoker.call(PrivilegeController_0.getAllUsers())
      }
  
    // @LINE:3
    case privilege_PrivilegeController_registerUser1_route(params@_) =>
      call { 
        privilege_PrivilegeController_registerUser1_invoker.call(PrivilegeController_0.registerUser())
      }
  
    // @LINE:4
    case privilege_PrivilegeController_loginUser2_route(params@_) =>
      call { 
        privilege_PrivilegeController_loginUser2_invoker.call(PrivilegeController_0.loginUser())
      }
  
    // @LINE:5
    case privilege_PrivilegeController_createSuperAdmin3_route(params@_) =>
      call { 
        privilege_PrivilegeController_createSuperAdmin3_invoker.call(PrivilegeController_0.createSuperAdmin())
      }
  
    // @LINE:6
    case privilege_PrivilegeController_createAdmin4_route(params@_) =>
      call { 
        privilege_PrivilegeController_createAdmin4_invoker.call(PrivilegeController_0.createAdmin())
      }
  
    // @LINE:7
    case privilege_PrivilegeController_updatePrivileges5_route(params@_) =>
      call { 
        privilege_PrivilegeController_updatePrivileges5_invoker.call(PrivilegeController_0.updatePrivileges())
      }
  
    // @LINE:8
    case privilege_PrivilegeController_getPrivilege6_route(params@_) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        privilege_PrivilegeController_getPrivilege6_invoker.call(PrivilegeController_0.getPrivilege(email))
      }
  
    // @LINE:9
    case privilege_PrivilegeController_requestedRole7_route(params@_) =>
      call { 
        privilege_PrivilegeController_requestedRole7_invoker.call(PrivilegeController_0.requestedRole())
      }
  
    // @LINE:10
    case privilege_PrivilegeController_createRoles8_route(params@_) =>
      call { 
        privilege_PrivilegeController_createRoles8_invoker.call(PrivilegeController_0.createRoles())
      }
  
    // @LINE:11
    case privilege_PrivilegeController_revokePrivileges9_route(params@_) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        privilege_PrivilegeController_revokePrivileges9_invoker.call(PrivilegeController_0.revokePrivileges(email))
      }
  
    // @LINE:12
    case privilege_PrivilegeController_logoutUser10_route(params@_) =>
      call(params.fromPath[String]("token", None)) { (token) =>
        privilege_PrivilegeController_logoutUser10_invoker.call(PrivilegeController_0.logoutUser(token))
      }
  
    // @LINE:13
    case privilege_PrivilegeController_deleteUser11_route(params@_) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        privilege_PrivilegeController_deleteUser11_invoker.call(PrivilegeController_0.deleteUser(email))
      }
  }
}
