using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

// Name: Ben Morrison
// Date: 17 April 2015
// Purpose: Inherits the Room class, adds data specific for an office

namespace Assignment1_Part2
{
    class Office : Room
    {
        private int numDesks;
        private int numCabinets;

        public Office(string identifier, double size, int numDesks, int numCabinets) 
            : base (identifier, size)
        {
            this.setDesks(numDesks);
            this.setCabinets(numCabinets);
        }

        public int getDesks()
        {
            return numDesks;
        }

        public int getCabinets()
        {
            return numCabinets;
        }

        // Sets the number of desks, some error handling
        public void setDesks(int numDesks)
        {
            if (numDesks < 0)
            {
                Console.WriteLine("Error: There cannot be less than 0 desks");
                this.numDesks = 0;
            }
            else if (numDesks > 10)
            {
                Console.WriteLine("Error: There cannot be more than 10 desks");
                this.numDesks = 10;
            }
            else
                this.numDesks = numDesks;
        }

        // Sets the number of cabinets, some error handling
        public void setCabinets(int numCabinets)
        {
            if (numCabinets < 0)
            {
                Console.WriteLine("Error: There cannot be less than 0 cabinets");
                this.numCabinets = 0;
            }
            else if (numCabinets > 8)
            {
                Console.WriteLine("Error: There cannot be more than 8 cabinets");
                this.numCabinets = 8;
            }
            else
                this.numCabinets = numCabinets;
        }

        // Overrides Room.DisplayRoom()
        public override void displayRoom()
        {
            base.displayRoom();

            Console.WriteLine("Number of Desks: " + numDesks);
            Console.WriteLine("Number of Cabinets: " + numCabinets);
        } 
    }
}
