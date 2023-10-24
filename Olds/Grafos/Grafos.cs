using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grafos
{
    public class Grafos
    {
        int[,] Grafo;
        int TamanhoUm { get; set; }
        int TamanhoDois { get; set; }
        public int Grau {get; set;}
        public bool GrafoRegular { get; set; }

        public Grafos(int pTamanho1, int pTamanho2)
        {
            Init(pTamanho1, pTamanho2);
        }

        public void ExibeGrafo()
        {
            for (int i = 0; i < TamanhoUm; i++)
            {
                Console.Write(" ");
                Console.Write("|");
                for (int j = 0; j < TamanhoDois; j++)
                {
                    Console.Write("" + Grafo[i,j].ToString());
                }
                Console.Write("|");
                Console.WriteLine("");
            }
        }

        public bool CriaAresta(int pPosicaoUm, int pPosicaoDois)
        {
            if (VerificaPosicao(pPosicaoUm, pPosicaoDois))
            {
                Grafo[pPosicaoUm, pPosicaoDois] = 1;
                Grafo[pPosicaoDois, pPosicaoUm] = 1;
                return true;
            }
            return false;
        }

        public bool ExcluirAresta(int pPosicaoUm, int pPosicaoDois)
        {
            if (VerificaPosicao(pPosicaoUm, pPosicaoDois))
            {
                Grafo[pPosicaoUm, pPosicaoDois] = 0;
                Grafo[pPosicaoDois, pPosicaoUm] = 0;
                return true;
            }
            return false;
        }

        public int GrauVertice(int pVertice)
        {
            int aux = 0;
            if (VerificaPosicao(pVertice))
            {
                for (int i = 0; i < TamanhoDois; i++)
                {
                    if (Grafo[pVertice, i] == 1)
                        aux++;
                }
                return aux;
            }
            else
                return -1;
        }

        public void VerifcaGrafoRegular()
        {
            int aux = 0;
            for (int j = 0; j < TamanhoUm; j++)
            {
                aux = GrauVertice(j);
                    
                if (this.Grau == 0)
                    this.Grau = aux;
                else if (this.Grau != aux)
                    return;
            }
            this.Grau = aux;
            this.GrafoRegular = true;
        }

        public bool VerificaGrafoCompleto()
        {
            for (int i = 0; i < TamanhoUm; i++)
            {
                for (int j = 0; j < TamanhoDois; j++)
                {
                    if (Grafo[i,j] == 0)
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        void Init(int pTamanho1, int pTamanho2)
        {
            this.Grafo = new int[pTamanho1, pTamanho2];
            this.TamanhoUm = pTamanho1;
            this.TamanhoDois = pTamanho2;
            this.Grau = 0;
            this.GrafoRegular = false;

            DesconectarTodoGrafo();
        }

        public void ConectaTodoGrafo()
        {
            for (int i = 0; i < TamanhoUm; i++)
            {
                for (int j = 0; j < TamanhoDois; j++)
                {
                    if (i != j)
                        this.Grafo[i, j] = 1;
                }
            }
            VerifcaGrafoRegular();
        }

        public void DesconectarTodoGrafo()
        {
            for (int i = 0; i < TamanhoUm; i++)
            {
                for (int j = 0; j < TamanhoDois; j++)
                {
                    this.Grafo[i, j] = 0;
                }
            }
        }
        bool VerificaPosicao(int pPosicao)
        {
            if (pPosicao > TamanhoUm - 1 || pPosicao > TamanhoDois - 1 || pPosicao < 0)
            {
                return false;
            }
            return true;
        }

        bool VerificaPosicao(int pPosicaoUm, int pPosicaoDois)
        {
            if (pPosicaoUm < 0 || pPosicaoDois < 0)
            {
                return false;
            }
            else if (pPosicaoUm > (TamanhoUm - 1) || pPosicaoUm > (TamanhoDois - 1))
            {
                return false;
            }
            else if (pPosicaoDois > (TamanhoUm - 1) || pPosicaoDois > (TamanhoDois - 1))
            {
                return false;
            }
            return true;
        }



    }
}
