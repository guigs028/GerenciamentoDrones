import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    private List<DronePessoal> drones;

    public App() {
        drones = new ArrayList<>();
    }

    public String cadastrarDronePessoal(int codigo, double custofixo, double autonomia, int capacidadePessoas) {
        for (DronePessoal drone : drones) {
            if (drone.getCodigo() == codigo) {
                return "Erro: Drone com o código " + codigo + " já existe!";
            }
        }
    
        DronePessoal novoDrone = new DronePessoal(codigo, custofixo, autonomia, capacidadePessoas);
        drones.add(novoDrone);
        Collections.sort(drones, Comparator.comparingInt(DronePessoal::getCodigo));
        return "Drone cadastrado com sucesso!";
    }

    public String listarDrones() {
        if (drones.isEmpty()) {
            return "Nenhum drone cadastrado.";
        }
        StringBuilder sb = new StringBuilder();
        for (DronePessoal drone : drones) {
            sb.append("Código: ").append(drone.getCodigo())
            .append(", Custo Fixo: ").append(drone.getCustoFixo())
            .append(", Autonomia: ").append(drone.getAutonomia())
            .append(", Capacidade: ").append(drone.getQtdMaxPessoas()).append("\n");
              
        }
        return sb.toString();
    }
}

