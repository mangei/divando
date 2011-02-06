package mangei.cashmanagement.gui;

import java.awt.GridLayout;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mangei.cashmanagement.ComponentFactory;


public class EditBuchungView extends JPanel {

    private EditBuchungPresentationModel model;

    private JTextField tfName;
    private JTextField tfBetrag;
    private JComboBox cbKategorie;
    private JComboBox cbKonto;
    private JButton bOk;
    private JButton bCancel;

    public EditBuchungView(EditBuchungPresentationModel model) {
        this.model = model;
        initComponents();
        initLayout();
    }

    private void initComponents() {
        tfName = ComponentFactory.createTextField(model.getNameValueModel());
        tfBetrag = ComponentFactory.createTextField(model.getBetragValueModel());
        cbKategorie = ComponentFactory.createComboBox(model.getKategorieComboBoxModel());
        cbKonto = ComponentFactory.createComboBox(model.getKontoComboBoxModel());
        bOk = ComponentFactory.createButton(model.getOkAction());
        bCancel = ComponentFactory.createButton(model.getCancelAction());
    }

    private void initLayout() {
        setLayout(new GridLayout(5, 2));
        add(new JLabel("Name: "));
        add(tfName);
        add(new JLabel("Betrag: "));
        add(tfBetrag);
        add(new JLabel("Kategorie: "));
        add(cbKategorie);
        add(new JLabel("Konto: "));
        add(cbKonto);
        add(bOk);
        add(bCancel);
    }

    public JButton getButtonOk() {
        return bOk;
    }

    public JButton getButtonCancel() {
        return bCancel;
    }
}
