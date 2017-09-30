using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

// Name: Ben Morrison
// Date: 17 April 2015
// Purpose: Inherits the Room class, adds data specificially for a Bathroom

namespace Assignment1_Part2
{
    class Bathroom : Room
    {
        private int numBasins;
        private int numConveniences;

        public Bathroom(string identifier, double size, int numBasins, int numConveniences)
            : base(identifier, size)
        {
            this.setBasins(numBasins);
            this.setConveniences(numConveniences);
        }

        public int getBasins()
        {
            return numBasins;
        }

        public int getConveniences()
        {
            return numConveniences;
        }

        // sets the number of basins, some error handling
        public void setBasins(int numBasins)
        {
            if (numBasins < 0)
            {
                Console.WriteLine("Error: There cannot be less than 0 basins");
                this.numBasins = 0;
            }
            else if (numBasins > 4)
            {
                Console.WriteLine("Error: There cannot be more than 4 basins");
                this.numBasins = 4;
            }
            else
                this.numBasins = numBasins;
        }

        // Sets the number of conviniences, some error handling
        public void setConveniences(int numConveniences)
        {
            if (numConveniences < 0)
            {
                Console.WriteLine("Error: There cannot be less than 0 conveniences");
                this.numConveniences = 0;
            }
            else if (numConveniences > 2)
            {
                Console.WriteLine("Error: There cannot be more than 2 conveniences");
                this.numConveniences = 2;
            }
            else
                this.numConveniences = numConveniences;
        }

        // Overrides Room.DisplayRoom()
        public override void displayRoom()
        {
            base.displayRoom();

            Console.WriteLine("Number of Basins: " + numBasins);
            Console.WriteLine("Number of Conveniences: " + numConveniences);
        } 
    }
}
