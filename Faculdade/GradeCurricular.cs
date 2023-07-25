using System.Collections.Generic;

namespace Faculdade
{
    public class GradeCurricular
    {
        public Curso Curso { get; set; }
        public Termo Termo { get; set; }
        public IList<Disciplina> Disciplinas { get; set; }
    }
}
