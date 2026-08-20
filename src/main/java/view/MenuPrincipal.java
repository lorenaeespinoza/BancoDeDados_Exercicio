package view;

import static javax.swing.JOptionPane.*;

public class MenuPrincipal {
    public void menu(){
        String [] item = {"vendendor", "venda", "finalizar" };
        String opcao;

        do {
            opcao = (String) showInputDialog(null, "Selecione uma opção", "Menu principal", INFORMATION_MESSAGE, null, item, item[0]);

            switch (opcao.toLowerCase()){
                case "vendedor" -> new MenuVendedor().menu();
                case "venda" -> new MenuVenda().menu();
            }
        }
        while (!opcao.toLowerCase().equals("finalizar"));
    }
}
