class Livro {
    private String titulo;
    private boolean reservado;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.reservado = false;
        this.emprestado = false;
    }

    public void reservar() {
        if (!reservado) {
            reservado = true;
            System.out.println("O livro '" + titulo + "' foi reservado com sucesso.");
        } else {
            System.out.println("O livro '" + titulo + "' já está reservado.");
        }
    }

    public void cancelarReserva() {
        if (reservado) {
            reservado = false;
            System.out.println("A reserva do livro '" + titulo + "' foi cancelada.");
        } else {
            System.out.println("O livro '" + titulo + "' não está reservado para cancelar.");
        }
    }

    public void emprestar() {
        if (reservado && !emprestado) {
            emprestado = true;
            System.out.println("O livro '" + titulo + "' foi emprestado com sucesso.");
        } else if (!reservado) {
            System.out.println("O livro '" + titulo + "' precisa ser reservado primeiro.");
        } else {
            System.out.println("O livro '" + titulo + "' já está emprestado.");
        }
    }

    public void devolver() {
        if (emprestado) {
            emprestado = false;
            System.out.println("O livro '" + titulo + "' foi devolvido com sucesso.");
        } else {
            System.out.println("O livro '" + titulo + "' não está emprestado para devolver.");
        }
    }
}


class LivroFisico extends Livro {
    public LivroFisico(String titulo, String autor) {
        super(titulo, autor);
    }
}


class Ebook extends Livro {
    private String formato;

    public Ebook(String titulo, String autor, String formato) {
        super(titulo, autor);
        this.formato = formato;
    }

    @Override
    public void emprestar() {
        boolean reservado;
        boolean emprestado;
        if (reservado && !emprestado) {
            if (!formato.equals("PDF")) {
                System.out.println("Este e-book só pode ser lido online e não pode ser emprestado.");
            } else {
                super.emprestar();
            }
        } else if (!reservado) {
            System.out.println("O e-book '" + getTitulo() + "' precisa ser reservado primeiro.");
        } else {
            System.out.println("O e-book '" + getTitulo() + "' já está emprestado.");
        }
    }

    private String getTitulo() {
        return null;
    }
}

public class App {
    public static void main(String[] args) {
        LivroFisico livro1 = new LivroFisico("Aventuras em Java", "João Autor");
        Ebook ebook1 = new Ebook("Programação Java Avançada", "João Autor", "PDF");

        livro1.emprestar(); 
        livro1.reservar();
        ebook1.reservar();

        ebook1.cancelarReserva(); 

        livro1.emprestar();
        livro1.emprestar(); 
        livro1.devolver(); 
    }
}
