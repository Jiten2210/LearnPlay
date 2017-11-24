
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/users.routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

package users

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  UserController_0: user.UserController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    UserController_0: user.UserController
  ) = this(errorHandler, UserController_0, "/")

  def withPrefix(prefix: String): Routes = {
    users.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """user.UserController.getAllUsers()"""),
    ("""POST""", this.prefix, """user.UserController.createUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """userId<[^/]+>""", """user.UserController.getUser(userId:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """userId<[^/]+>""", """user.UserController.updateUser(userId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """userId<[^/]+>""", """user.UserController.deleteUser(userId:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val user_UserController_getAllUsers0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val user_UserController_getAllUsers0_invoker = createInvoker(
    UserController_0.getAllUsers(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "users",
      "user.UserController",
      "getAllUsers",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val user_UserController_createUser1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val user_UserController_createUser1_invoker = createInvoker(
    UserController_0.createUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "users",
      "user.UserController",
      "createUser",
      Nil,
      "POST",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val user_UserController_getUser2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val user_UserController_getUser2_invoker = createInvoker(
    UserController_0.getUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "users",
      "user.UserController",
      "getUser",
      Seq(classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val user_UserController_updateUser3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val user_UserController_updateUser3_invoker = createInvoker(
    UserController_0.updateUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "users",
      "user.UserController",
      "updateUser",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val user_UserController_deleteUser4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val user_UserController_deleteUser4_invoker = createInvoker(
    UserController_0.deleteUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "users",
      "user.UserController",
      "deleteUser",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case user_UserController_getAllUsers0_route(params@_) =>
      call { 
        user_UserController_getAllUsers0_invoker.call(UserController_0.getAllUsers())
      }
  
    // @LINE:3
    case user_UserController_createUser1_route(params@_) =>
      call { 
        user_UserController_createUser1_invoker.call(UserController_0.createUser())
      }
  
    // @LINE:4
    case user_UserController_getUser2_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        user_UserController_getUser2_invoker.call(UserController_0.getUser(userId))
      }
  
    // @LINE:5
    case user_UserController_updateUser3_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        user_UserController_updateUser3_invoker.call(UserController_0.updateUser(userId))
      }
  
    // @LINE:6
    case user_UserController_deleteUser4_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        user_UserController_deleteUser4_invoker.call(UserController_0.deleteUser(userId))
      }
  }
}
