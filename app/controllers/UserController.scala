package controllers

import javax.inject._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._
import models._

/**
  * Created by kiaora on 2017/04/10.
  */
class UserController @Inject() extends Controller {
  val userForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "email" -> text)(User.apply)(User.unapply)
  )

  def entryInit = Action{
    val filledForm = userForm.fill(User("user name","email address"))
    Ok(views.html.entry(filledForm))
  }
  def entrySubmit = Action{ implicit request =>
    userForm.bindFromRequest.fold(
      errors =>{
        println("Error!")
        BadRequest(views.html.entry(errors))
      },
      success =>{
        println("entry success!")
        val user = userForm.bindFromRequest.get
        println(user)
        Ok(views.html.entrySubmit(user.name + ":" + user.email))
      }
    )
  }
}
