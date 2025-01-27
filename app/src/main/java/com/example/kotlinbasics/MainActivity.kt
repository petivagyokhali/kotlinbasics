package com.example.kotlinbasics

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import okhttp3.Address

class MainActivity : AppCompatActivity() {

    private lateinit var openGreetingButton: Button
    private lateinit var openCalculatorButton: Button
    private lateinit var openWeatherButton: Button
    private lateinit var openUserListButton:Button
    private lateinit var openRandomUserButton:Button

    data class Root(
        var universityName: String,
        var departments:List<Department>
    )
    data class Department(
        var name: String,
        var professors: List<Professor>,
        var students: List<Student>
    )
    data class Professor(
        var name: String,
        var subject: String
    )
    data class Student(
        var name: String,
        var studentId: String,
        var courses: List<Course>
    )
    data class Course(
        var courseName:String,
        var credits: Int
    )
//--------------------------------------------------------------------
    data class Root2(
        var airportName:String,
        var terminals: List<Terminal>
    )
    data class Terminal(
        var terminalName:String,
        var flights: List<Flight>
    )
    data class Flight(
        var flightNumber:String,
        var destination:String,
        var airline:Airline
    )
    data class Airline(
        var name: String,
        var country:String
    )
    //---------------------------------------------------------------
    data class Root3(
        var publisherName:String,
        var authors:List<Author>
    )
    data class Author(
        var authorName:String,
        var books:List<Book>
    )
    data class Book(
        var title:String,
        var year: Int,
        var ratings:List<Rating>
    )
    data class Rating(
        var rating:Int,
        var comment:String
    )
    //----------------------------------------------------------------
    data class Root4(
        var agencyName:String,
        var customers:List<Customer>
    )
    data class Customer(
        var customerId:String,
        var name: String,
        var email: String,
        var bookings: List<Booking>
    )
    data class Booking(
        var bookingId:String,
        var packagee: Package,
        var rating:Rating2
    )
    data class Package(
        var packageId:String,
        var destination: String,
        var durationDays:Int,
        var price: Int,
        var activities: List<Activity>
    )
    data class Activity(
        var activityName:String,
        var type: String
    )
    data class Rating2(
        var score:Int,
        var comment:String
    )
    //-------------------
    data class weatherResponse(
        val main:Main
    )
    data class Main(
        val temp: Float
    )

    //---------------------------------
    data class Order(
        val orderId:String,
        val customer:Customer2,
        val orderItems:List<Item>,
        val shipping:Shipping,
        val payment:Payment,
        val status:String
    )
    data class Customer2(
        val customerId:String,
        val name:String,
        val email:String,
        val phone:String
    )
    data class Item(
        val itemId:String,
        val productName:String,
        val quantity:Int,
        val pricePerUnit:Double,
        val discount:Double?
    )
    data class Shipping(
        val address: Address,
        val shippingMethod:String,
        val estimatedDeliveryDays:Int

    )
    data class Address(
        val street:String,
        val city:String,
        val postalCode:String,
        val country: String
    )
    data class Payment(
        val paymentMethod:String,
        val totalAmount:Double,
        val paid:Boolean
    )
//--------------------------------------
    data class Project(
        val projectName:String,
        val subject:String,
        val durationWeeks:Int,
        val teamMembers:List<Member>,
        val assignments:List<Assignment>,
        val completed:Boolean
    )
    data class Member(
        val studentId: String,
        val name: String,
        val grade:Int,
        val hasCompleted:Boolean
    )
    data class Assignment(
        val assignmentName:String,
        val maxPoints:Int,
        val studentScores:StudentScore
    )
    data class StudentScore(
        val STU123:Int,
        val STU124:Int,
        val STU125:Int
    )
//------------------------------------------------------
    data class City(
        val cityName:String,
        val transitSystem: TransitSystem,
        val controlCenter:ControlCenter
    )
    data class TransitSystem(
        val buses:List<Bus>,
        val trams:List<Tram>
    )
    data class Tram(
        val routeNumber:Int,
        val routeName:String,
        val vehicles:List<Vehicle>,
        val schedule:Schedule
    )
    data class Bus(
        val routeNumber:Int,
        val routeName:String,
        val vehicles:List<Vehicle>,
        val schedule:Schedule
    )
    data class Vehicle(
        val vehicleId:String,
        val capacity:Int,
        val currentLocation:Location,
        val status: String
    )
    data class Location(
        val latitude:Float,
        val longitude:Float
    )
    data class Schedule(
        val weekday:List<Weekday>,
        val weekend:List<Weekend>
    )
    data class Weekday(
        val departureTime:String,
        val arrivalTime:String
    )
    data class Weekend(
        val departureTime:String,
        val arrivalTime:String
    )
    data class ControlCenter(
        val contactNumber:String,
        val emergencyContacts:List<EmergencyContact>
    )
    data class EmergencyContact(
        val name:String,
        val phone: String,
        val shift:String
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        //UI elemelek inicializálása
        openGreetingButton = findViewById(R.id.openGreetingButton)
        openCalculatorButton = findViewById(R.id.openCalculatorButton)
        openWeatherButton=findViewById(R.id.openWeatherButton)
        openUserListButton=findViewById(R.id.openUserListButton)
        openRandomUserButton=findViewById(R.id.openRandomUserButton)

        openCalculatorButton.setOnClickListener(){
            //intent létrehozása és activity indítása
            val intent =Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
        openGreetingButton.setOnClickListener(){
            //intent létrehozása és activity indítása
            val intent =Intent(this, GreetingActivity::class.java)
            startActivity(intent)
        }
        //openweather
        openWeatherButton.setOnClickListener(){
            //intent létrehozása és activity indítása
            val intent =Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
        openUserListButton.setOnClickListener(){
            //intent létrehozása és activity indítása
            val intent =Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
        openRandomUserButton.setOnClickListener(){
            //intent létrehozása és activity indítása
            val intent =Intent(this, RandomUserListActivity::class.java)
            startActivity(intent)
        }
    }//ONCREATE nemiga
}//CLASS
