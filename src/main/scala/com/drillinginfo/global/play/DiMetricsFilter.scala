package com.drillinginfo.diglobal.play

import com.kenshoo.play.metrics.MetricsFilter
import com.kenshoo.play.metrics.MetricsRegistry

import play.api.http.Status

abstract class DiMetricsFilter extends MetricsFilter {
  override val knownStatuses = {
    Seq(Status.OK, Status.BAD_REQUEST, Status.FORBIDDEN, Status.NOT_FOUND,
      Status.CREATED, Status.TEMPORARY_REDIRECT, Status.INTERNAL_SERVER_ERROR, 
      Status.BAD_GATEWAY)
  }
}

object DiMetricsFilter extends DiMetricsFilter {
    lazy val registry = MetricsRegistry.default
}