using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dia01.ConsoleApp
{
    internal static class StringExtensions
    {
        internal static string ToBacon(this string str)
        {
            return str + " bacon!!!";
        }
    }
}
