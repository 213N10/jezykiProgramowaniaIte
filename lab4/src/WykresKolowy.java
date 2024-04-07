import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;

public class WykresKolowy extends JPanel {
        WykresKolowy(){
                setPreferredSize(new Dimension(100, 100));
        }
        private Map<Color, Integer> dictionary = new LinkedHashMap<>();
        public void dodajKol(Color color, int value) {
                dictionary.put(color, value);
                repaint();
        }
        public void usunKol(Color color){
                dictionary.remove(color);
        }
        @Override
        public void paintComponent(Graphics g) {
                // szukam najdłuższego
                int max = Integer.MIN_VALUE;
                for (Integer value : dictionary.values()) {
                max = Math.max(max, value);
                }
        // malowanie
                int width = (getWidth() / dictionary.size()) - 2;
                int x = 1;
                for (Color color : dictionary.keySet()) {
                int value = dictionary.get(color);
                int height = (int)
                ((getHeight()-5) * ((double)value / max));
                g.setColor(color);
                g.fillRect(x, getHeight() - height, width, height);
                g.setColor(Color.black);
                g.drawRect(x, getHeight() - height, width, height);
                x += (width + 2);
                }
 }



}