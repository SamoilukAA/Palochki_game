package field;

import net.SerializableCommand;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
//import net.SerializableCommand;

public class PaintField extends JPanel {
    private int id;
    private static PlayingField pfield;
    private static SerializableCommand command;
    private static final int cellSize = 50;
    private static final int gap = 20;
    private static final int pointsize = 10;
    private static final int offset = 5;
    private static final int exstraspace = 200;
    private int mouseX = 0, mouseY = 0;

    JFrame frame;


    public PaintField(int id, PlayingField pfield, SerializableCommand command) {
        super();
        this.id = id;
        this.pfield = pfield;
        this.command = command;
        frame = new JFrame("Палочки");
        setBackground(Color.WHITE);
        setLayout(null);
        frame.setSize(pfield.cols * cellSize * 2 + 2 * gap + exstraspace, pfield.rows * cellSize * 2 + 2 * gap);
        frame.add(this);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseListener(new CustomListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        this.removeAll();
        int empty = 0;
        for (int i = 0; i < pfield.rows; i++) {
            for (int j = 0; j < pfield.cols; j++) {
                if (pfield.cells[i][j].equals("EMPTY")){
                    empty++;
                }
            }
        }
        if (empty == 0) {
            if (pfield.getScore()[0] > pfield.getScore()[1]) {
                JOptionPane.showMessageDialog(this, "Победил первый игрок!");
            } else {
                JOptionPane.showMessageDialog(this, "Победил второй игрок!");
            }
        }
        super.paintComponent(g);
        int screenWidth = getWidth() - exstraspace;
        int screenHeight = getHeight();
        g.setColor(Color.BLACK);
        int width = Math.min(screenHeight - 2 * gap, screenWidth - 2 * gap);
        int step = width / Math.max(pfield.cols, pfield.rows);

        for (int i = 0; i <= pfield.rows; i++) {
            for (int j = 0; j <= pfield.cols; j++) {
                g.drawOval(i * step + gap - offset, j * step + gap - offset, pointsize, pointsize);
                g.fillOval(i * step + gap - offset, j * step + gap - offset, pointsize, pointsize);
            }
        }

        Graphics2D g2d = (Graphics2D)g;
        BasicStroke pen = new BasicStroke(2);
        g2d.setStroke(pen);
        for (int i = 0; i < pfield.rows; i++){
            for (int j = 0; j < pfield.cols + 1; j++) {
                if (pfield.getHlineState(i, j).equals("BLACK")){
                    g2d.setColor(Color.BLACK);
                    g2d.drawLine(i * step + gap, j * step + gap, i * step + step + gap, j * step + gap);
                }
                if (pfield.getHlineState(i, j).equals("RED")){
                    g2d.setColor(Color.RED);
                    g2d.drawLine(i * step + gap, j * step + gap, i * step + step + gap, j * step + gap);
                }
                if (pfield.getHlineState(i, j).equals("GREEN")){
                    g2d.setColor(Color.GREEN);
                    g2d.drawLine(i * step + gap, j * step + gap, i * step + step + gap, j * step + gap);
                }
            }
        }

        for (int i = 0; i < pfield.rows + 1; i++) {
            for (int j = 0; j < pfield.cols; j++) {
                if (pfield.getVlineState(i, j).equals("BLACK")){
                    g2d.setColor(Color.BLACK);
                    g2d.drawLine(i * step + gap, j * step + gap, i * step + gap, j * step + step + gap);
                }
                if (pfield.getVlineState(i, j).equals("RED")){
                    g2d.setColor(Color.RED);
                    g2d.drawLine(i * step + gap, j * step + gap, i * step + gap, j * step + step + gap);
                }
                if (pfield.getVlineState(i, j).equals("GREEN")){
                    g2d.setColor(Color.GREEN);
                    g2d.drawLine(i * step + gap, j * step + gap, i * step + gap, j * step + step + gap);
                }
            }
        }

        for (int i = 0; i < pfield.rows; i++) {
            for (int j = 0; j < pfield.cols; j++){
                if (pfield.getCellState(i, j).equals("A")){
                    JLabel label = new JLabel();
                    label.setText("A");
                    label.setVerticalAlignment(JLabel.CENTER);
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setForeground(Color.RED);
                    label.setBounds(i * step + gap + (step - cellSize) / 2, j * step + gap + (step - cellSize) / 2, cellSize, cellSize);
                    label.setFont(new Font("TimesNewRoman", Font.PLAIN, cellSize));
                    this.add(label);
                }
                if (pfield.getCellState(i, j).equals("B")){
                    JLabel label = new JLabel();
                    label.setText("B");
                    label.setVerticalAlignment(JLabel.CENTER);
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setForeground(Color.GREEN);
                    label.setBounds(i * step + gap + (step - cellSize) / 2, j * step + gap + (step - cellSize) / 2, cellSize, cellSize);
                    label.setFont(new Font("TimesNewRoman", Font.PLAIN, cellSize));
                    this.add(label);
                }
            }
        }
        JLabel label_name = new JLabel();
        label_name.setText("Ирок " + id);
        label_name.setVerticalAlignment(JLabel.CENTER);
        label_name.setHorizontalAlignment(JLabel.CENTER);
        label_name.setBounds(pfield.cols * step + 2 * gap + step / 4, gap + (step - cellSize) / 2, 2 * cellSize, cellSize / 2);
        label_name.setFont(new Font("TimesNewRoman", Font.ITALIC, cellSize / 2));
        this.add(label_name);

        JLabel label = new JLabel();
        label.setText("Счет");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(pfield.cols * step + 2 * gap + step / 4, gap + cellSize / 2 + pointsize + (step - cellSize) / 2, 2 * cellSize, cellSize / 2);
        label.setFont(new Font("TimesNewRoman", Font.PLAIN, cellSize / 2));
        this.add(label);

        JLabel label_score = new JLabel();
        label_score.setText(pfield.getScore()[0] + " : " + pfield.getScore()[1]);
        label_score.setVerticalAlignment(JLabel.CENTER);
        label_score.setHorizontalAlignment(JLabel.CENTER);
        label_score.setBounds(pfield.cols * step + 2 * gap + step / 4, gap + cellSize + pointsize + (step - cellSize) / 2, 2 * cellSize, cellSize / 2);
        label_score.setFont(new Font("TimesNewRoman", Font.PLAIN, cellSize / 2));
        this.add(label_score);

        JLabel label_move = new JLabel();
        label_move.setText("Ходит " + pfield.whoMove + "-й игрок");
        label_move.setVerticalAlignment(JLabel.CENTER);
        label_move.setHorizontalAlignment(JLabel.CENTER);
        label_move.setBounds(pfield.cols * step + 2 * gap + step / 4, gap + cellSize * 2 + pointsize + (step - cellSize) / 2, 3 * cellSize, cellSize / 2);
        label_move.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
        this.add(label_move);
    }


    public void repaintField(PlayingField pfield) {
        this.pfield = pfield;
        repaint();
    }

    public SerializableCommand getCommand() {
        return command;
    }

    public class CustomListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pfield.whoMove == id) {
                int screenWidth = getWidth();
                int screenHeight = getHeight();
                int width = Math.min(screenHeight - 2 * gap, screenWidth - 2 * gap);
                int step = width / Math.max(pfield.cols, pfield.rows);
                mouseX = e.getX();
                mouseY = e.getY();
                for (int i = 0; i < (pfield.rows + 1) * pfield.cols; i++) {
                    for (int j = 0; j < (pfield.cols + 1) * pfield.rows; j++) {
                        if (mouseX > i * step + gap && mouseX < i * step + step + gap &&
                                mouseY > j * step + cellSize - offset && mouseY < j * step + cellSize + offset) {
                            if (pfield.getHlineState(i, j).equals("BLACK")) {
                                command.setArgs(id, "ChooseHLine", i, j);
                            }
                        }
                        if (mouseX > i * step + gap - pointsize && mouseX < i * step + gap + pointsize &&
                                mouseY > j * step + cellSize && mouseY < j * step + step + cellSize) {
                            if (pfield.getVlineState(i, j).equals("BLACK")) {
                                command.setArgs(id, "ChooseVLine", i, j);
                            }
                        }
                    }
                }
                if (pfield.needToSetSymbol()) {
                    for (int i = 0; i < pfield.rows; i++){
                        for (int j = 0; j < pfield.cols; j++) {
                            if (mouseX > i * step + gap + (step - cellSize) / 2 && mouseX < i * step + gap + (step - cellSize) / 2 + cellSize &&
                                    mouseY > j * step + cellSize + (step - cellSize) / 2 && mouseY < j * step + (step - cellSize) / 2 + 2 * cellSize) {
                                if (pfield.getCellState(i, j).equals("EMPTY")) {
                                    command.setArgs(id, "SetSymbol", i, j);
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
}
