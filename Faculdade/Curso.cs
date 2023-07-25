using System;
using System.Collections.Generic;

namespace Faculdade
{
    public class Curso
    {
        public String Nome { get; set; }
        public Decimal Valor { get; set; }
        public TipoCurso Tipo { get; set; }
        public TimeSpan CargaHoraria { get; set; }

        public IList<GradeCurricular> GradeCurricular { get; set; }
    }
}
