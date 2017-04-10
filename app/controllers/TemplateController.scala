package controllers

import javax.inject._

import play.api.mvc._

/**
  * Created by kiaora on 2017/04/10.
  */
class TemplateController @Inject() extends Controller{
  def show = Action{
    val list = List[String]("Lemon","Mikan","Nanao")
    Ok(views.html.show("Hello Scala Templates!", list))
  }
}
