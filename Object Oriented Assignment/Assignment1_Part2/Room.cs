using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

// Name: Ben Morrison
// Date: 17 April 2015
// Purpose: The base class for Office, Bathroom and Kitchen

namespace Assignment1_Part2
{
    class Room
    {
        // Readonly identifier that cant be changed after the constructor
        private readonly string identifier;
        private double size;

        public Room(string identifier, double size)
        {
            this.identifier = identifier;
            this.setSize(size);
        }

        public string getIdentifier()
        {
            return identifier;
        }

        public double getSize()
        {
            return size;
        }

        // Sets the room size, some error handling
        public void setSize(double size)
        {
            if (size < 0)
            {
                Console.WriteLine("Error: Size cannot be lower than 5");
                this.size = 5;
            }
            else if (size > 200)
            {
                Console.WriteLine("Error: Size cannot be higher than 200");
                this.size = 200;
            }
            else
                this.size = size;
        }

        // Default method to display the room, other classes can override
        public virtual void displayRoom()
        {
            Console.WriteLine("-----------------");
            Console.WriteLine("Idenfitier: " + identifier);
            Console.WriteLine("Square Meters: " + size);
        }
    }
}
