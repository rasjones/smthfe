import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

/**
 * Application settings. Configure the build for your application here.
 * You normally don't have to touch the actual build definition after this.
 */
object Settings {
  /** The name of your application */
  val name = "scalajs-spa"

  /** The version of your application */
  val version = "1.1.0"

  /** Options for the scala compiler */
  val scalacOptions = Seq(
    "-Xlint",
    "-unchecked",
    "-deprecation",
    "-feature"
  )

  /** Declare global dependency versions here to avoid mismatches in multi part dependencies */
  object versions {
    val scala = "2.11.8"
    val scalaDom = "0.9.1"
    val scalajsReact = "0.11.3"
    val scalaCSS = "0.5.1"
    val log4js = "1.4.13"
    val autowire = "0.2.6"
    val booPickle = "1.2.5"
    val diode = "1.1.0"
    val uTest = "0.4.4"

    val react = "0.14.3"
    val jQuery = "2.1.4"
    val bootstrap = "3.3.2"
    val chartjs = "1.0.1"
    val jqueryFacade = "0.11"

    val playScripts = "0.3.0"
    val silhouette = "3.0.4"
  }

  /**
   * These dependencies are shared between JS and JVM projects
   * the special %%% function selects the correct version for each project
   */
  val sharedDependencies = Def.setting(Seq(
    "com.lihaoyi" %%% "autowire" % versions.autowire,
    "me.chrons" %%% "boopickle" % versions.booPickle,
    "com.lihaoyi" %%% "utest" % versions.uTest
  ))

  /** Dependencies only used by the JVM project */
  val jvmDependencies = Def.setting(Seq(
    "com.vmunier" %% "play-scalajs-scripts" % versions.playScripts,
    "org.webjars" % "font-awesome" % "4.3.0-1" % Provided,
    "org.webjars" % "bootstrap" % versions.bootstrap % Provided,
    "com.mohiva" %% "play-silhouette" % versions.silhouette,
    "com.mohiva" %% "play-silhouette-testkit" % versions.silhouette % "test"
  ))

  /** Dependencies only used by the JS project (note the use of %%% instead of %%) */
  val scalajsDependencies = Def.setting(Seq(
    "com.github.japgolly.scalajs-react" %%% "core" % versions.scalajsReact,
    "com.github.japgolly.scalajs-react" %%% "extra" % versions.scalajsReact,
    "com.github.japgolly.scalacss" %%% "ext-react" % versions.scalaCSS,
    "com.github.japgolly.scalajs-react" %%% "ext-scalaz72" % versions.scalajsReact,
    "com.github.japgolly.scalajs-react" %%% "ext-monocle" % versions.scalajsReact,
    "com.github.japgolly.fork.monocle" %%% "monocle-core" % "1.1.1",
    "com.github.japgolly.fork.monocle" %%% "monocle-macro" % "1.1.1",
    "me.chrons" %%% "diode" % versions.diode,
    "me.chrons" %%% "diode-react" % versions.diode,
    "org.scala-js" %%% "scalajs-dom" % versions.scalaDom,
    "org.querki" %%% "jquery-facade" % versions.jqueryFacade
  ))

  /** Dependencies for external JS libs that are bundled into a single .js file according to dependency order */
  val jsDependencies = Def.setting(Seq(
    "org.webjars.bower" % "react" % versions.react / "react-with-addons.js" minified "react-with-addons.min.js" commonJSName "React",
    "org.webjars.bower" % "react" % versions.react / "react-dom.js" minified "react-dom.min.js" dependsOn "react-with-addons.js" commonJSName "ReactDOM",
    "org.webjars" % "jquery" % versions.jQuery / "jquery.js" minified "jquery.min.js",
//    "org.webjars" % "bootstrap" % versions.bootstrap / "bootstrap.js" minified "bootstrap.min.js" dependsOn "jquery.js",
//    "org.webjars" % "chartjs" % versions.chartjs / "Chart.js" minified "Chart.min.js",
    "org.webjars" % "log4javascript" % versions.log4js / "js/log4javascript_uncompressed.js" minified "js/log4javascript.js",


//        "org.webjars" % "uuid" % "1.4.1" / "uuid.js",
//        "org.webjars" % "codemirror" % "5.8" / "lib/codemirror.js",
//        "org.webjars" % "codemirror" % "5.8" / "mode/javascript/javascript.js",
//        "org.webjars" % "jquery-ui" % "1.11.4" / "jquery-ui.js" minified "jquery-ui.min.js",
//        "org.webjars" % "momentjs" % "2.10.6" / "moment.js" minified "moment.min.js",
//        "org.webjars" % "d3js" % "3.5.6" / "d3.js" minified "d3.min.js",
//    //    "org.webjars.npm" % "modernizr" % "3.2.0" / "src/Modernizr.js",
//        "org.webjars" % "chartjs" % "1.0.2" / "Chart.js" minified "Chart.min.js",
//        "org.webjars.bower" % "blueimp-gallery" % "2.16.0" / "js/blueimp-gallery.js" minified "js/blueimp-gallery.min.js" ,
//        "org.webjars.bower" % "perfect-scrollbar" % "0.6.7" / "js/perfect-scrollbar.jquery.js" minified "js/min/perfect-scrollbar.jquery.min.js",
//        "org.webjars" % "datatables" % "1.10.9" / "js/jquery.dataTables.js" minified "js/jquery.dataTables.min.js",
//        "org.webjars" % "bootstrap-slider" % "4.8.3" / "bootstrap-slider.js" minified "bootstrap-slider.min.js",
//        "org.webjars" % "bootstrap-datetimepicker" % "2.3.1" / "js/bootstrap-datetimepicker.js" minified "js/bootstrap-datetimepicker.min.js",
//        "org.webjars" % "jquery-knob" % "1.2.11" / "jquery.knob.js" minified "jquery.knob.min.js",
//        "org.webjars.bower" % "leaflet" % "0.7.7" / "dist/leaflet.js" dependsOn "vendor/eventemitter2/lib/eventemitter2.js",
//        "org.webjars" % "jquery.sparkline" % "2.1.2" / "jquery.sparkline.js" minified "jquery.sparkline.min.js",
//        "org.webjars" % "raphaeljs" % "2.1.4" / "raphael.js" minified "raphael-min.js",
//        "org.webjars" % "select2" % "3.5.4" / "select2.js" minified "select2.min.js",
//        "org.webjars" % "typeaheadjs" % "0.11.1" / "typeahead.jquery.js" minified "typeahead.jquery.min.js",
//        "org.webjars.bower" % "jquery.steps" % "1.1.0" / "jquery.steps.js" minified "jquery.steps.min.js",
//        "org.webjars" % "jquery-validation" % "1.14.0" / "jquery.validate.js" minified "jquery.validate.min.js",
//        "org.webjars" % "fullcalendar" % "2.4.0" / "fullcalendar.js" minified "fullcalendar.min.js",
//        "org.webjars" % "dropzone" % "4.2.0" / "dropzone.js" minified "dropzone.min.js",
//        "org.webjars" % "Jcrop" % "0.9.12" / "js/jquery.Jcrop.js" minified "js/jquery.Jcrop.min.js",
//        "org.webjars" % "prismjs" % "1.0.0" / "components/prism-core.js" minified "components/prism-core.min.js",
//        "org.webjars" % "morrisjs" % "0.5.1" / "morris.js" minified "morris.min.js",
//        "org.webjars.bower" % "holderjs" % "2.8.2" / "holder.js" minified "holder.min.js",
//        "org.webjars" % "c3" % "0.4.10" / "c3.js" minified "c3.min.js",
//        "org.webjars" % "pace" % "1.0.2" / "pace.js" minified "pace.min.js",

//        ProvidedJS / "common/rubix-bootstrap/rubix-bootstrap.js" dependsOn "d3.js",
//        ProvidedJS / "common/pace/pace.js",
//        ProvidedJS / "vendor/modernizr/modernizr.js",
//        ProvidedJS / "vendor/eventemitter2/lib/eventemitter2.js",
//        ProvidedJS / "common/react-l20n/react-l20n.js" dependsOn "react-with-addons.js",
//        ProvidedJS / "common/rubix/rubix.js" dependsOn "dist/jquery.js",
//        ProvidedJS / "common/globals.js",
//        ProvidedJS / "vendor/trumbowyg/dist/trumbowyg.min.js",
//        ProvidedJS / "vendor/gmaps/gmaps.js",
//        ProvidedJS / "vendor/ion.tabs/ion.tabs.min.js",
//        ProvidedJS / "vendor/ion.rangeSlider/ion.rangeSlider.min.js",
//        ProvidedJS / "vendor/switchery/switchery.js",
//        ProvidedJS / "vendor/messenger/messenger.min.js",
//        ProvidedJS / "vendor/xeditable/xeditable.js" dependsOn "dist/jquery.js" dependsOn "bootstrap.js",
//        ProvidedJS / "vendor/tablesaw/tablesaw.js",
//        ProvidedJS / "vendor/nestable/nestable.js",
//        ProvidedJS / "vendor/timeline/timeline.js",

        ProvidedJS / "js/common/pace/pace.js",
        ProvidedJS / "js/common/uuid/uuid.js",
        ProvidedJS / "js/bower_components/modernizr/modernizr.js",
        ProvidedJS / "js/bower_components/codemirror/lib/codemirror.js",
        ProvidedJS / "js/bower_components/codemirror/mode/javascript/javascript.js",
//        ProvidedJS / "js/bower_components/jquery/dist/jquery.js",
        ProvidedJS / "js/bower_components/jquery-ui/jquery-ui.min.js",
        ProvidedJS / "js/bower_components/moment/moment.js",
        ProvidedJS / "js/bower_components/eventemitter2/lib/eventemitter2.js",
        ProvidedJS / "js/bower_components/vex/js/vex.combined.min.js",
        ProvidedJS / "js/bower_components/chartjs/Chart.js",
        ProvidedJS / "js/bower_components/trumbowyg/dist/trumbowyg.js",
        ProvidedJS / "js/bower_components/blueimp-gallery/js/blueimp-gallery.js",
        ProvidedJS / "js/vendor/p-scrollbar/src/perfect-scrollbar.js" dependsOn "js/common/rubix-bootstrap/rubix-bootstrap.js",
        //    ProvidedJS / "js/bower_components/react/react-with-addons.js",
        ProvidedJS / "js/vendor/datatables/datatables.js" dependsOn "jquery.js",
        //    ProvidedJS / "js/common/react-router/react-router.js",
        ProvidedJS / "js/common/react-l20n/react-l20n.js" dependsOn "react-with-addons.js" ,
        ProvidedJS / "js/common/rubix-bootstrap/rubix-bootstrap.js" dependsOn "jquery.js" dependsOn "js/vendor/d3/d3.js" dependsOn "js/common/rubix/rubix.js",
        //    ProvidedJS /"/maps.google.com/maps/api/js?sensor=true",
        ProvidedJS / "js/vendor/gmaps/gmaps.js",
        ProvidedJS / "js/vendor/bootstrap/bootstrap.js" dependsOn "jquery.js",
        ProvidedJS / "js/vendor/bootstrap-slider/bootstrap-slider.js",
        ProvidedJS / "js/vendor/bootstrap-datetimepicker/bootstrap-datetimepicker.js" dependsOn "jquery.js" dependsOn "js/bower_components/moment/moment.js",
//        ProvidedJS / "js/vendor/bootstrap-datetimepicker/bootstrap-datetimepicker.js" dependsOn "js/bower_components/jquery/dist/jquery.js" dependsOn "js/bower_components/moment/moment.js",

        ProvidedJS / "js/vendor/ion.tabs/ion.tabs.min.js",
        ProvidedJS / "js/vendor/ion.rangeSlider/ion.rangeSlider.min.js",
        ProvidedJS / "js/vendor/d3/d3.js",
        ProvidedJS / "js/vendor/jquery.knob/jquery.knob.js",
        ProvidedJS / "js/vendor/leaflet/leaflet.js",
        ProvidedJS / "js/vendor/sparklines/sparklines.js",
        ProvidedJS / "js/vendor/switchery/switchery.js",
        ProvidedJS / "js/vendor/raphael/raphael.js",
        ProvidedJS / "js/vendor/messenger/messenger.min.js",
        ProvidedJS / "js/vendor/select2/select2.js" dependsOn "jquery.js",
        ProvidedJS / "js/vendor/xeditable/xeditable.js" dependsOn "jquery.js" dependsOn "js/vendor/bootstrap/bootstrap.js",
        ProvidedJS / "js/vendor/typeahead/typeahead.js",
        ProvidedJS / "js/vendor/jquery-steps/jquery-steps.js",
        ProvidedJS / "js/vendor/jquery-validate/jquery-validate.js",
        ProvidedJS / "js/vendor/tablesaw/tablesaw.js",
        ProvidedJS / "js/vendor/fullcalendar/fullcalendar.js",
        ProvidedJS / "js/vendor/nestable/nestable.js",
        ProvidedJS / "js/vendor/dropzone/dropzone.js",
        ProvidedJS / "js/vendor/jcrop/color.js",
        ProvidedJS / "js/vendor/jcrop/jcrop.js",
        ProvidedJS / "js/vendor/prism/prism.js" dependsOn "js/common/react-l20n/react-l20n.js",
        ProvidedJS / "js/vendor/morris/morris.js",
        ProvidedJS / "js/vendor/timeline/timeline.js",
        ProvidedJS / "js/vendor/holder/holder.js",
        ProvidedJS / "js/bower_components/c3/c3.js",
        ProvidedJS / "js/common/rubix/rubix.js" dependsOn "jquery.js",
        ProvidedJS / "js/common/globals.js"
  ))
}
