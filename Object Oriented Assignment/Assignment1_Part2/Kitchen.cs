using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

// Name: Ben Morrison
// Date: 17 April 2015
// Purpose: Inherits the Room class, adds data specific for a Kitchen

namespace Assignment1_Part2
{
    class Kitchen : Room
    {
        private int numSeats;
        private bool fridge;
        private bool microwave;

        public Kitchen(string identifier, double size, int numSeats, bool fridge, bool microwave)
            : base(identifier, size)
        {
            this.numSeats = numSeats;
            this.fridge = fridge;
            this.microwave = microwave;
        }

        public int getSeats()
        {
            return numSeats;
        }

        public bool getFridge()
        {
            return fridge;
        }

        public bool getMicrowave()
        {
            return microwave;
        }

        // Sets the number of the seats, some error handling
        public void setSeats(int numSeats)
        {
            if (numSeats < 0)
            {
                Console.WriteLine("Error: There cannot be less than 0 seats");
                this.numSeats = 0;
            }
            else if (numSeats > 10)
            {
                Console.WriteLine("Error: There cannot be more than 10 seats");
                this.numSeats = 10;
            }
            else
                this.numSeats = numSeats;
        }

        // Boolean for if a fridge is available or not
        public void setFridge(bool fridge)
        {
            this.fridge = fridge;
        }

        // Boolean for if a microwave is available or not
        public void setMicrowave(bool microwave)
        {
            this.microwave = microwave;
        }

        // Overrides Room.DisplayRoom()
        public override void displayRoom()
        {
            base.displayRoom();

            Console.WriteLine("Number of seats: " + numSeats);
            Console.WriteLine("Fridge available: " + fridge);
            Console.WriteLine("Microwave available: " + microwave);
        } 
    }
}
