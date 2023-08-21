package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import java.lang.Math;

//to do the power function in the table


@Entity
public class Reading extends Model {
    public int code;
    public float temperature;
    public float windSpeed;

    public float pressure;

    public String weatherCode;

    public int beaufort;

    public String beaufortLabel;

    public double windDirection;

    public String windCompass;

    public double windChill;

    public double farhenheit;

    public Reading(int code, float temperature, float windSpeed, double windDirection, String windCompass, float pressure) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.windCompass = windCompass;
        this.pressure = pressure;
        //Logger.info("Reading establishing int, float etc");

    }

//    public Reading() {}


    /**
     * Setter
     */

    public void setCode(int code) {
        this.code = code;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setFarhenheit(double farhenheit) {this.farhenheit = farhenheit;}

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public void setBeaufort(int beaufort) {
        this.beaufort = beaufort;
    }

    public void setWindCompass(String windCompass) {
        this.windCompass = windCompass;
    }

    public void setWindChill(double windChill1) {
        this.windChill = windChill;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * Getter
     */

    public String getWeatherCode() {
        switch (code) {
            case 100:
                weatherCode = "Thunder";
                break;
            case 200:
                weatherCode = "Partial Clouds";
                break;
            case 300:
                weatherCode = "Cloudy";
                break;
            case 400:
                weatherCode = "Light Showers";
                break;
            case 500:
                weatherCode = "Heavy Showers";
                break;
            case 600:
                weatherCode = "Rain";
                break;
            case 700:
                weatherCode = "Snow";
                break;
            case 800:
                weatherCode = "Thunder";
                break;

        }
        return weatherCode;
    }

    public int getCode() {
        return code;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getPressure() {
        return pressure;
    }

    public double getFahrenheit() {
        return this.farhenheit = ((temperature * 9 / 5) + 32);
    }

    public int getBeaufort() {
        if (windSpeed <= 1) {
            return 0;
        } else if (windSpeed <= 5) {
            return 1;
        } else if (windSpeed <= 11) {
            return 2;
        } else if (windSpeed <= 19) {
            return 3;
        } else if (windSpeed <= 28) {
            return 4;
        } else if (windSpeed <= 38) {
            return 5;
        } else if (windSpeed <= 49) {
            return 6;
        } else if (windSpeed <= 61) {
            return 7;
        } else if (windSpeed <= 74) {
            return 8;
        } else if (windSpeed <= 88) {
            return 9;
        } else if (windSpeed <= 102) {
            return 10;
        } else if (windSpeed <= 117) {
            return 11;
        }
        return beaufort; //out of bounds - not a correct reading, add exception here
    }

    public String getWindCompass()
    {

            if ((this.windDirection <= 11.25) || (this.windDirection > 348.75)) {
                return "North (N)";
            } else if ((this.windDirection > 11.25) && (this.windDirection < 33.75)) {
                return "North North East (NNE)";
            } else if ((this.windDirection > 33.75) && (this.windDirection < 56.25)) {
                return "North East (NE)";
            } else if ((this.windDirection > 56.25) && (this.windDirection < 78.75)) {
                return "East North East (ENE)";
            } else if ((this.windDirection > 78.75) && (this.windDirection < 101.25)) {
                return "East (E)";
            } else if ((this.windDirection > 101.25) && (this.windDirection < 123.75)) {
                return "East South East (ESE)";
            } else if ((this.windDirection > 123.75) && (this.windDirection < 146.25)) {
                return "South East (SE)";
            } else if ((this.windDirection > 146.25) && (this.windDirection < 168.75)) {
                return "South South East (SE)";
            } else if ((this.windDirection > 168.75) && (this.windDirection < 191.25)) {
                return "South (S)";
            } else if ((this.windDirection > 191.25) && (this.windDirection < 213.75)) {
                return "South South West (SSW)";
            } else if ((this.windDirection > 213.75) && (this.windDirection < 236.25)) {
                return "South West (SW)";
            } else if ((this.windDirection > 236.25) && (this.windDirection < 258.75)) {
                return "West South West (WSW)";
            } else if ((this.windDirection > 258.75) && (this.windDirection < 281.25)) {
                return "West (W)";
            } else if ((this.windDirection > 281.25) && (this.windDirection < 303.75)) {
                return "West North West (WNW)";
            } else if ((this.windDirection > 303.75) && (this.windDirection < 326.25)) {
                return "North West (NW)";
            } else  {
                return "North North West (NNW)";
            }
                   }


    public double getWindChill(float temperature, float windSpeed) {
        double windchill = 13.12 + (0.6215 * temperature ) - 11.37 * (Math.pow(windSpeed, 0.16)) + ((0.3965 * temperature)*((Math.pow(windSpeed,0.16))));
        return windChill;
    }

}