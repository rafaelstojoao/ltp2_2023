using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grafos
{
    public class Menu
    {
        Grafos Grafo;
        void CabecalhoMenuGrafo()
        {
            Console.WriteLine("1 - Criar Grafo");
            Console.WriteLine("2 - Criar Aresta");
            Console.WriteLine("3 - Verifica grau do vertice");
            Console.WriteLine("4 - Verifica se grafo é regular");
            Console.WriteLine("5 - Verifica se grafo está completo");
            Console.WriteLine("6 - Conectar todos os vertices");
            Console.WriteLine("7 - Exclui Aresta");
            Console.WriteLine("8 - Exibir Grafo");
            Console.WriteLine("0 - Sair");
        }
        public void MenuGrafo()
        {
            int vTamanhoGrafo;
            int vPosicaoUm, vPosicaoDois;
            int vVertice;
            int vOpcao;

            do
            {
                Console.Clear();

                CabecalhoMenuGrafo();
                Console.Write("Qual opção deseja escolher: ");
                vOpcao = Int32.Parse(Console.ReadLine());
                switch (vOpcao)
                {
                    case 0:
                    {
                            Console.Clear();

                            Console.WriteLine("Adeus");

                            break;
                    }
                    case 1:
                    {
                            Console.Clear();

                            Console.Write("Qual o tamanho do grafo: ");
                            vTamanhoGrafo = Int32.Parse(Console.ReadLine());

                            this.Grafo = new Grafos(vTamanhoGrafo, vTamanhoGrafo);

                            break;
                    }
                    case 2:
                    {
                            Console.Clear();

                            Console.Write("Digite a primeira posição para ligar: ");
                            vPosicaoUm = Int32.Parse(Console.ReadLine());

                            Console.Write("Digite a segunda posição: ");
                            vPosicaoDois = Int32.Parse(Console.ReadLine());

                            if (!this.Grafo.CriaAresta(vPosicaoUm - 1, vPosicaoDois - 1))
                                Console.WriteLine("Posição não encontrada!");
                            else
                                Console.WriteLine("Aresta criado");
                            Console.ReadLine();
                            break;
                    }
                    case 3:
                    {
                            int Grau;
                            Console.Clear();

                            Console.Write("Digite o vertice que deseja saber o Grau: ");
                            vVertice = Int32.Parse(Console.ReadLine());

                            Grau = this.Grafo.GrauVertice(vVertice - 1);
                            if (Grau != -1)
                                Console.WriteLine("Grau do vertice: " + vVertice + " é: " + Grau);
                            else
                                Console.WriteLine("Posição " + vVertice + " não encontrada");

                            Console.ReadLine();
                            break;
                    }
                    case 4:
                    {
                            Console.Clear();

                            if (this.Grafo.GrafoRegular)
                                Console.WriteLine("Grafo é regular de grau: " + this.Grafo.Grau);
                            else
                                Console.WriteLine("Grafo não é regular");

                            Console.ReadLine();
                            break;
                    }
                    case 5:
                    {
                            Console.Clear();

                            if (this.Grafo.VerificaGrafoCompleto())
                                Console.WriteLine("Grafo completo");
                            else
                                Console.WriteLine("Grafo não completo");

                            Console.ReadLine();
                            break;
                    }
                    case 6:
                    {
                            Console.Clear();

                            this.Grafo.ConectaTodoGrafo();
                            Console.WriteLine("Todos os vertices estão ligados");

                            Console.ReadLine();
                            break;
                    }
                    case 7:
                    {
                            Console.Clear();

                            Console.Write("Digite a primeira posição para excluir: ");
                            vPosicaoUm = Int32.Parse(Console.ReadLine());

                            Console.Write("Digite a segunda posição: ");
                            vPosicaoDois = Int32.Parse(Console.ReadLine());

                            if (!this.Grafo.ExcluirAresta(vPosicaoUm - 1, vPosicaoDois - 1))
                                Console.WriteLine("Posição não encontrada!");
                            else
                                Console.WriteLine("Aresta Excluida");
                            Console.ReadLine();
                            break;
                    }
                    case 8:
                    {
                            Console.Clear();

                            this.Grafo.ExibeGrafo();

                            Console.ReadLine();
                            break;
                    }
                    default:
                    {
                            Console.Clear();

                            Console.WriteLine("Opção não encontrada");

                            Console.ReadLine();
                            break;
                    }
                }
            } while (vOpcao != 0);
        }
    }
}
