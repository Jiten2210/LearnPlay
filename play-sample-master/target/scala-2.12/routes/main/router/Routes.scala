
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jitu/Eclipse451Mars64Workspace/play-sample-master/conf/routes
// @DATE:Fri Nov 24 16:43:04 IST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Assets_0: controllers.Assets,
  // @LINE:8
  BaseController_1: global.common.BaseController,
  // @LINE:9
  users_Routes_1: users.Routes,
  // @LINE:10
  privilege_Routes_0: privilege.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Assets_0: controllers.Assets,
    // @LINE:8
    BaseController_1: global.common.BaseController,
    // @LINE:9
    users_Routes_1: users.Routes,
    // @LINE:10
    privilege_Routes_0: privilege.Routes
  ) = this(errorHandler, Assets_0, BaseController_1, users_Routes_1, privilege_Routes_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_0, BaseController_1, users_Routes_1, privilege_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix, """global.common.BaseController.index()"""),
    prefixed_users_Routes_1_2.router.documentation,
    prefixed_privilege_Routes_0_3.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val global_common_BaseController_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val global_common_BaseController_index1_invoker = createInvoker(
    BaseController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "global.common.BaseController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] val prefixed_users_Routes_1_2 = Include(users_Routes_1.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "users"))

  // @LINE:10
  private[this] val prefixed_privilege_Routes_0_3 = Include(privilege_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "privilege"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Assets_versioned0_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:8
    case global_common_BaseController_index1_route(params@_) =>
      call { 
        global_common_BaseController_index1_invoker.call(BaseController_1.index())
      }
  
    // @LINE:9
    case prefixed_users_Routes_1_2(handler) => handler
  
    // @LINE:10
    case prefixed_privilege_Routes_0_3(handler) => handler
  }
}
