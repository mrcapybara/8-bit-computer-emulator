package Screen;

import Screen.Panel.PanelALU;
import Screen.Panel.PanelCounter;
import Screen.Panel.PanelBus;
import Screen.Panel.PanelRegister;
import Screen.Panel.PanelClock;
import Screen.Panel.PanelControl;
import Screen.Panel.PanelMAR;
import Screen.Panel.PanelRAM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author MrCapybara
 */
public class ViewScreen extends JFrame {

    private final Dimension SIZE = new Dimension(800, 600);
    private final String TITLE = "8-bit Computer Emulator";

    private JPanel panelComputer;
    private JSplitPane splitPane;

    protected final PanelALU pALU = new PanelALU();
    protected final PanelRAM pRAM = new PanelRAM();
    protected final PanelMAR pMAR = new PanelMAR();
    protected final PanelBus pBus = new PanelBus();
    protected final PanelClock pClock = new PanelClock();
    protected final PanelControl pControl = new PanelControl();
    protected final PanelCounter pCounter = new PanelCounter();
    protected final PanelRegister pBRegister = new PanelRegister("B Register");
    protected final PanelRegister pAccumulator = new PanelRegister("Accumulator Register");
    protected final PanelRegister pInstruction = new PanelRegister("Instruction Register");
    protected final PanelRegister pOutRegister = new PanelRegister("Output Register");

    protected TerminalIO txtTerminal;

    public ViewScreen() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        setSize(SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(TITLE);
        setExtendedState(MAXIMIZED_BOTH);
    }

    private void initComponents() {
        txtTerminal = new TerminalIO();
        txtTerminal.setBackground(Color.BLACK);
        txtTerminal.setForeground(Color.LIGHT_GRAY);
        txtTerminal.setFont(new Font("Monospaced", Font.PLAIN, 12));

        panelComputer = new JPanel(new MigLayout("fill"));

        panelComputer.setBackground(new Color(245, 245, 245));

        panelComputer.add(pInstruction, "center");
        panelComputer.add(pCounter, "center");
        panelComputer.add(pAccumulator, "center, wrap");
        panelComputer.add(pMAR, "center");
        panelComputer.add(pClock, "center");
        panelComputer.add(pALU, "center, wrap");
        panelComputer.add(pRAM, "center, spany");
        panelComputer.add(pControl, "center");
        panelComputer.add(pBRegister, "center, wrap");
        panelComputer.add(pBus, "skip, center");
        panelComputer.add(pOutRegister, "center");

        splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(panelComputer),
                new JScrollPane(txtTerminal)
        );

        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.86);

        add(splitPane);
    }

}
