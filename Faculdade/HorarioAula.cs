using System;

namespace Faculdade
{
    public class HorarioAula
    {
        public Professor Professor { get; set; }
        public Oferta Oferta { get; set; }

        public String Local { get; set; }
        public TimeSpan Horario { get; set; }
        public DayOfWeek DiaSemana { get; set; }
    }
}
