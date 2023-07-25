using System.Collections.Generic;

namespace Faculdade
{
    public class Oferta
    {
        public Aluno Aluno { get; set; }
        public Curso Curso { get; set; }
        public Termo Termo { get; set; }

        public IList<Nota> Notas { get; set; }
    }
}
