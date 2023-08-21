package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import models.Reading;
import play.Logger;
import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String name;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  /*public String weatherCode;*/

  public Station(String name) {
    this.name = name;
    Logger.info("Test 01 to see if station name called ");
  }

  public Station() {

  }

  /**
   * Setter
   */

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    Logger.info("Test 02 to see if name called", this.name);
    return name;
  }
}





