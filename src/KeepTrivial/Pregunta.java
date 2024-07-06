package KeepTrivial;

public class Pregunta {
	
		//atributos
		private String pregunta;
		private String respuestaUno;
		private String respuestDos;
		private String respuestaTres;
		private String respuestaCuatro;
		private int solucion;
		
		//constructor
		public Pregunta(String pregunta, String respuestaUno, String respuestaDos, String respuestaTres, String respuestaCuatro, int solucion ) {
			
			this.pregunta = pregunta;
			this.respuestaUno= respuestaUno;
			this.respuestDos = respuestaDos;
			this.respuestaTres =respuestaTres;
			this.respuestaCuatro =respuestaCuatro;
			this.solucion =solucion;
		
		//getters y setters

	}

		public String getPregunta() {
			return pregunta;
		}

		public void setPregunta(String pregunta) {
			this.pregunta = pregunta;
		}

		public String getRespuestaUno() {
			return respuestaUno;
		}

		public void setRespuestaUno(String respuestaUno) {
			this.respuestaUno = respuestaUno;
		}

		public String getRespuestDos() {
			return respuestDos;
		}

		public void setRespuestDos(String respuestDos) {
			this.respuestDos = respuestDos;
		}

		public String getRespuestaTres() {
			return respuestaTres;
		}

		public void setRespuestaTres(String respuestaTres) {
			this.respuestaTres = respuestaTres;
		}

		public String getRespuestaCuatro() {
			return respuestaCuatro;
		}

		public void setRespuestaCuatro(String respuestaCuatro) {
			this.respuestaCuatro = respuestaCuatro;
		}

		public int getSolucion() {
			return solucion;
		}

		public void setSolucion(int solucion) {
			this.solucion = solucion;
		}
		@Override
	    public String toString() {
	        return "Pregunta: " + pregunta + "\n" +
	               "1: " + respuestaUno + "\n" +
	               "2: " + respuestDos + "\n" +
	               "3: " + respuestaTres + "\n" +
	               "4: " + respuestaCuatro + "\n" +
	               "Respuesta correcta: " + solucion + "\n";
	    }
}
