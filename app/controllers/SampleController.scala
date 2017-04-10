package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
  * Created by kiaora on 2017/04/10.
  */
class SampleController @Inject() extends Controller{
  def sample1 = Action {
    Ok(views.html.index("Sample Controller#sample1"))
  }
  def sample2 = Action {
//    Ok(views.html.index("Sample Controller#sample2"))
    Redirect(routes.SampleController.sample1)
  }
  def sample3(id:Long) = Action {
    Ok(views.html.index("id:" + id))
  }
}
