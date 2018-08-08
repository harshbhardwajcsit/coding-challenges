# Some cool map challenge

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.7.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/` or `http://localhost:4200/world-map`. The app will automatically reload if you change any of the source files.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.


## Components

**MapHomeComponent** is responsible for loading world's map and is the parent component.

## Services

1. **GetUserCurrentLocationService** : Responsible for fetching user's current geographical location(latitude & longitude).
2. **GetTimeStampService** : Responsible for calculating current timestamp, that is used in Date and time service as a parameter for google time API.
3. **GetDateAndTimeService** :Return TimeZone "dstOffset", "rawOffset" and "TimeZoneId/Name" of specific latitude and longitude.
4. **GetWeatherInfoService** : Return weather information of specific latitude and longitude.
5. **ApplicationUrlService** : Just to Externalize urls, keys in application.


## Third party Api's Used

1. Google Time Zone Api
2. Open weather Api

# Design principles used
1. Single responsibility principle
2. open close principle
3. dependency Inversion principle

## Architectural flow
 **Presentational and Container Components pattern**
 This application follows the above pattern, mean it open for modularization and extensions controlled by its parent component(Smart component) and any other component will be dumb component or just presentational component, takes input from parent component via services.
 
 **benefits**:
 1. Will be single point of failure for application if any.
 2  Easy to maintain and scale.
 3. Easy to debug failures.
 
ref : https://medium.com/@dan_abramov/smart-and-dumb-components-7ca2f9a7c7d0
