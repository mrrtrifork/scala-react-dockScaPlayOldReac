package controllers

import play.api.libs.json.{JsValue, Json}

import javax.inject._
import play.api.mvc._

import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents)(implicit ec: ExecutionContext) extends BaseController {

  val gameOfThrones : JsValue = Json.parse( """
                        { "characters":
                          [
                            {
                            "name": "Jamie",
                            "lastname":"Lannister",
                            "pet": "lion"
                            },
                            {
                            "name": "John",
                            "lastname":"Snow",
                            "pet": "wolf"
                            },
                            {
                            "name": "Daeneris",
                            "lastname":"Targarien",
                            "pet": "dragon"
                            }
                          ]
                        }
                      """)
  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def indexScala(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>

    Ok(views.html.index())
  }

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>

    //Ok(assets.index)
    Redirect("/index.html")
  }

  def users(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(gameOfThrones)
  }
}
