

package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id =  " + id);
    render("station.html", station);
  }

//    public static void deletereading(Long id, Long readingid) {
//        Station station = Station.findById(id);
//        Reading reading = Reading.findByID(readingid);
//        Logger.info("Removing" + reading.code);
//        station.readings.remove(reading);
//        station.save();
//        reading.delete();
//        render("dashboard.html", dashbord);
//    }

  public static void addreading(Long id, int code, float temperature, float windSpeed, double windDirection, String windCompass, float pressure) {
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, windCompass, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/stations/" + id);
  }

}




