package controllers;

import java.util.List;
import java.util.Scanner;

import models.Reading;
import models.Station;
import play.mvc.Controller;

public class Admin extends Controller
{
    public static void index() {
        List<Reading> readings  = Reading.findAll();
        render ("admin.html", readings);
        List<Station> stations  = Station.findAll();
        render ("admin.html", stations);
    }
}