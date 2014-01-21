package com.drillinginfo.diglobal.play

import play.api.mvc.{SimpleResult, RequestHeader, Filter}
import play.api.{Logger, Routes}
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits.defaultContext

object DiLoggingFilter extends Filter {
  def apply(nextFilter: (RequestHeader) => Future[SimpleResult]
             )(requestHeader: RequestHeader): Future[SimpleResult] = {
    val startTime = System.currentTimeMillis
    nextFilter(requestHeader).map { result =>
      val action = requestHeader.method
      val path = requestHeader.path
      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime
      Logger.info(s"${action} ${path} took ${requestTime}ms" +
        s" and returned ${result.header.status}")
      result.withHeaders("Request-Time" -> requestTime.toString)
    }
  }
}