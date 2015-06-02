using System;
using System.Dynamic;
using System.Linq;

namespace Dia01.ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            #region dynamic
            dynamic oi = new ExpandoObject();
            oi.Saudacao = "Ta se loco";

            Console.WriteLine(oi.Saudacao);
            Console.WriteLine("Ana, to me mijando!");
            #endregion

            #region arraiiii
            var numeros = new[] { 1, 2, 3 };
            numeros.ToList().Add(4);

            string str1 = "ana";
            #endregion

            #region Extension Methods
            Console.WriteLine("Ana".ToBacon());
            #endregion

            #region Jedi
            //var yoda = new Jedi();
            //yoda.Nome = "Yoda";

            var yoda = new Jedi
            {
                Nome = "Yoda",
                Grau = Grau.MESTRE
            };

            Console.WriteLine(yoda.Nome);
            #endregion
            Console.ReadLine();
        }
    }
}