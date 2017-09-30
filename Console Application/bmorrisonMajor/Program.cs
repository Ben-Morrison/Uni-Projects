// Author: Ben Morrison
// Date: 1 Sep 2014
// Load university application data for a database

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace bmorrisonMajor
{
    class Program
    {
        public struct application
        {
            public string state; // The name of the state
            public string university; // The name of the university
            public int apps2009; // The number of applications from 2009
            public int apps2010; // The number of applications from 2010
            public int apps2011; // The number of applications from 2011
            public int apps2012; // The number of applications from 2012
            public int apps2013; // The number of applications from 2013
        }

        public static application[] applications = new application[100];

        static void Main(string[] args)
        {
            ShowMenu();
        }

        // Displays and loops the main menu
        public static void ShowMenu()
        {
            string input;

            do
            {
                Console.WriteLine("------------------------------");
                Console.WriteLine("1. Load File");
                Console.WriteLine("2. Display Data");
                Console.WriteLine("3. Display in database format");
                Console.WriteLine("4. Save data in database format");
                Console.WriteLine("5. Highest Applicants in a year");
                Console.WriteLine("6. Exit");

                input = Console.ReadLine();

                switch (input)
                {
                    case "1":
                        LoadFile();
                        break;
                    case "2":
                        Console.WriteLine(DisplayData(1));
                        break;
                    case "3":
                        Console.WriteLine(DisplayData(2));
                        break;
                    case "4":
                        SaveFile();
                        break;
                    case "5":
                        FindHighest();
                        break;
                    default:
                        Console.WriteLine("Invalid input");
                        break;
                }
            } while (input != "6");
        }

        // Loads the data from a text file
        public static void LoadFile()
        {
            string line;
            string[] data = new string[7];

            if (File.Exists("data.txt"))
            {
                StreamReader reader = new StreamReader("data.txt");
                line = reader.ReadLine();
                int count = 0;

                while (line != null)
                {
                    data = line.Split('\t');
                    application app;
                    app = new application();
                    app.state = data[0];
                    app.university = data[1];
                    app.apps2009 = Convert.ToInt32(data[2]);
                    app.apps2010 = Convert.ToInt32(data[3]);
                    app.apps2011 = Convert.ToInt32(data[4]);
                    app.apps2012 = Convert.ToInt32(data[5]);
                    app.apps2013 = Convert.ToInt32(data[6]);

                    applications[count] = app;
                    count++;

                    line = reader.ReadLine();
                }

                Console.WriteLine("File loaded successfully");
                reader.Close();
            }
            else
                Console.WriteLine("File \"data.txt\" does not exist");
        }

        // Saves the data to a text file in database format
        public static void SaveFile()
        {
            string line = "";
            string[] data = new string[7];

            StreamWriter writer = new StreamWriter("database.txt");

            foreach (application app in applications)
            {
                if (app.state != null)
                {
                    line = app.state + ", " +
                                app.university + ", \"" +
                                app.apps2009.ToString("#,###") + "\", \"" +
                                app.apps2010.ToString("#,###") + "\", \"" +
                                app.apps2011.ToString("#,###") + "\", \"" +
                                app.apps2012.ToString("#,###") + "\", \"" +
                                app.apps2013.ToString("#,###") + "\"" + "\n";
                }
                writer.Write(line);
            }

            writer.Close();
        }

        // Returns the data in normal or database format as a string
        public static string DisplayData(int type)
        {
            string data = "";

            if (type == 1)
            {
                // Displays the data as it was in the file
                foreach (application app in applications)
                {
                    if (app.state != null)
                    {
                        data += app.state + "\t" +
                                        app.university + "\t" +
                                        app.apps2009 + "\t" +
                                        app.apps2010 + "\t" +
                                        app.apps2011 + "\t" +
                                        app.apps2012 + "\t" +
                                        app.apps2013 + "\t" + "\n";
                    }
                }
            }
            else if (type == 2)
            {
                // Displays the data in database format
                foreach (application app in applications)
                {
                    if (app.state != null)
                    {
                        data += app.state + ", " +
                            app.university + ", \"" +
                            app.apps2009.ToString("#,###") + "\", \"" +
                            app.apps2010.ToString("#,###") + "\", \"" +
                            app.apps2011.ToString("#,###") + "\", \"" +
                            app.apps2012.ToString("#,###") + "\", \"" +
                            app.apps2013.ToString("#,###") + "\"" + "\n";
                    }
                }
            }

            return data;
        }

        // Finds the highest number of applications in a year and displays the university name
        public static void FindHighest()
        {
            Console.WriteLine("Enter the year (2009, 2010, 2011, 2012, 2013)");

            string year = Console.ReadLine();
            application highest = new application();

            foreach (application app in applications)
            {
                if (app.state != null)
                {
                    if (year == "2009")
                        if (app.apps2009 > highest.apps2009)
                            highest = app;
                    if (year == "2010")
                        if (app.apps2010 > highest.apps2010)
                            highest = app;
                    if (year == "2011")
                        if (app.apps2011 > highest.apps2011)
                            highest = app;
                    if (year == "2012")
                        if (app.apps2012 > highest.apps2012)
                            highest = app;
                    if (year == "2013")
                        if (app.apps2013 > highest.apps2013)
                            highest = app;
                }
            }

            if (year == "2009")
                Console.WriteLine("The university with the most applications in year " + 
                    year + " was " + highest.university + " with " + highest.apps2009 + " applications");
            if (year == "2010")
                Console.WriteLine("The university with the most applications in year " + 
                    year + " was " + highest.university + " with " + highest.apps2010 + " applications");
            if (year == "2011")
                Console.WriteLine("The university with the most applications in year " +
                    year + " was " + highest.university + " with " + highest.apps2011 + " applications");
            if (year == "2012")
                Console.WriteLine("The university with the most applications in year " + 
                    year + " was " + highest.university + " with " + highest.apps2012 + " applications");
            if (year == "2013")
                Console.WriteLine("The university with the most applications in year " + 
                    year + " was " + highest.university + " with " + highest.apps2013 + " applications");
        }
    }
}