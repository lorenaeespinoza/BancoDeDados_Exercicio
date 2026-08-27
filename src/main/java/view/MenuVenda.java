package view;

import dao.VendaDao;
import dao.VendedorDAO;
import model.Venda;
import model.Vendedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class MenuVenda {
    public void menu (){

        String[] item = {"Inserir", "Pesquisar", "Listar", "Atualizar", "relatorio", "Excluir", "Sair"};
        String opcao;

        do {
            opcao = (String) showInputDialog(null, "Selecione uma opção", "MENU VENDA", INFORMATION_MESSAGE, null, item, item[0]);

            switch (opcao.toLowerCase()) {
                case "inserir" -> inserir();
                case "relatorio" -> relatorio();
            }
        }
        while (!opcao.toLowerCase().equals("sair"));
    }

    private void relatorio(){
        List<Venda> lista = new VendaDao().relatorio();
        String aux = "";
        for (Venda venda : lista){
            aux += venda.getVendedor().getNome() + "   |   ";
            aux += venda.getTotal()+ "    |    ";
            aux += venda.getData()+ "\n";
        }
        showMessageDialog(null,aux);
    }

    private void inserir() {
        Vendedor vendedor = new Vendedor();
        List<Vendedor> lista = new VendedorDAO().Listar();
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Double total;
        String data;

        vendedor = (Vendedor) showInputDialog(null,
                "Selecione uma opção",
                "MENU VENDA",
                INFORMATION_MESSAGE,
                null,
                lista.toArray(),
                lista.get(0));

        total = parseDouble(showInputDialog("Total das vendas"));
        data = showInputDialog("Data da venda (dd/mm/aaaa)");
        Venda venda = new Venda();
        venda.setTotal(total);
        venda.setVendedor(vendedor);
        venda.setData(LocalDate.parse(data,mascara));
        new VendaDao().inserir(venda);
    }

}
