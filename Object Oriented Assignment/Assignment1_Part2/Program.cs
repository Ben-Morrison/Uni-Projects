using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

// Name: Ben Morrison
// Date: 17 April 2015
// Purpose: The testing program for the Room class and other classes

namespace Assignment1_Part2
{
    class Program
    {
        static void Main(string[] args)
        {
            Room[] rooms = 
            {
                new Room("0", 22),
                new Office("1", 18, 3, 4),
                new Office("2", 10, 1, 2),
                new Bathroom("3", 5, 1, 1),
                new Bathroom("4", 12, 2, 2),
                new Kitchen("5", 20, 4, true, true),
                new Kitchen("6", 4, 0, true, false)
            };

            // Displays the data for each room
            foreach (Room r in rooms)
                r.displayRoom();

            // Editing some of the data for each room, some of it is invalid
            Console.WriteLine("----------------------------------------");
            rooms[0].setSize(4000);
            ((Office)rooms[1]).setDesks(-10);
            ((Office)rooms[2]).setCabinets(5);
            ((Bathroom)rooms[3]).setBasins(3);
            ((Bathroom)rooms[4]).setConveniences(7);
            ((Kitchen)rooms[5]).setMicrowave(false);
            ((Kitchen)rooms[6]).setSeats(2);

            // Displays the data for each room now with the changed
            foreach (Room r in rooms)
                r.displayRoom();

            Console.ReadLine();
        }
    }
}
