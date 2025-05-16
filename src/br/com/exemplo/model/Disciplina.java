package br.com.exemplo.model;

public class Disciplina {
	// Atributos
	
		private String disciplina;
		private String semestre;
		private String notas;
		private int faltas;
		private int rgm;
		
		// construtores
		public Disciplina() {
		}

		public Disciplina(String disciplina, String semestre, String notas, int faltas, int rgm) {
			super();
			this.disciplina = disciplina;
			this.semestre = semestre;
			this.notas = notas;
			this.faltas = faltas;
			this.rgm = rgm;
		}

		public String getDisciplina() {
			return disciplina;
		}

		public void setDisciplina(String disciplina) {
			this.disciplina = disciplina;
		}

		public String getSemestre() {
			return semestre;
		}

		public void setSemestre(String semestre) {
			this.semestre = semestre;
		}

		public String getNotas() {
			return notas;
		}

		public void setNotas(String notas) {
			this.notas = notas;
		}

		public int getFaltas() {
			return faltas;
		}

		public void setFaltas(int faltas) {
			this.faltas = faltas;
		}

		public int getRgm() {
			return rgm;
		}

		public void setRgm(int rgm) {
			this.rgm = rgm;
		}
		
		

}
