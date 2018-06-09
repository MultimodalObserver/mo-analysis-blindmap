package mo.eyetribeblindmapplayer;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BlindMap {

    private BufferedImage map;
    private int pointRadio;
    private float opaque;
    //private BufferedImage gradient;

    public BlindMap(int width, int height) {

        this.map = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.pointRadio = 55;
        this.opaque = 0.0f;
        Graphics2D g = this.map.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.dispose();
    }

    public void addPoint(Double x, Double y) {

        Graphics2D g = this.map.createGraphics();
//        g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR,0.1f)); 
        g.setComposite(AlphaComposite.Clear);
        g.fillOval(x.intValue(), y.intValue(), this.pointRadio, this.pointRadio);

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opaque));
        g.setColor(Color.WHITE);
        g.setPaint(new GradientPaint(0.0f, 0.0f, Color.BLACK.darker(), (float) pointRadio, (float) pointRadio, Color.BLACK.darker()));
        g.fillOval(x.intValue(), y.intValue(), this.pointRadio, this.pointRadio);
        //addImage(map, gradient, opaque);

    }

    public void addPoint(int x, int y) {

        Graphics2D g = this.map.createGraphics();
        g.setComposite(AlphaComposite.Clear);
        g.fillOval(x, y, this.pointRadio, this.pointRadio);

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opaque));
        g.setColor(Color.WHITE);
        g.fillOval(x, y, this.pointRadio, this.pointRadio);

    }

    private void saveImage(final BufferedImage buff, final String dest) {
        try {
            final File outputfile = new File(dest);
            ImageIO.write(buff, "png", outputfile);
        } catch (final IOException e) {
        }
    }

    private void saveImage(final BufferedImage buff, File outputfile) {
        try {
            ImageIO.write(buff, "png", outputfile);
        } catch (final IOException e) {
        }
    }

    public void toFile(File file) {
        saveImage(map, file);
    }

    public void toFile(BufferedImage bf, File file) {

//        BufferedImage output = new BufferedImage(this.map.getWidth(), this.map.getHeight(), BufferedImage.TYPE_INT_ARGB);        
        BufferedImage output = bf;
        //addImage(output, bf);
        //addImage(output, this.map, 0.3f);
        addImage(output, this.map, 1.0f);
        saveImage(output, file);

    }

    /*    
     private void addImage(final BufferedImage buff1, final BufferedImage buff2) {
        addImage(buff1, buff2, 1.0f , 0, 0);
    }   */
    private void addImage(final BufferedImage buff1, final BufferedImage buff2,
            final float opaque) {
        addImage(buff1, buff2, opaque, 0, 0);
    }

    private void addImage(final BufferedImage buff1, final BufferedImage buff2,
            final float opaque, final int x, final int y) {
        final Graphics2D g2d = buff1.createGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                opaque));
        g2d.drawImage(buff2, x, y, null);
        g2d.dispose();
    }

    private BufferedImage loadImage(final String ref) {
        BufferedImage b1 = null;
        try {
            b1 = ImageIO.read(new File(ref));
        } catch (final IOException e) {
            System.out.println("error loading the image: " + ref + " : " + e);
        }
        return b1;
    }

    public void setRadio(int r) {
        this.pointRadio = r;
    }

    public BufferedImage getMap() {
        return this.map;
    }

    public void restart() {

        this.map = new BufferedImage(map.getWidth(), map.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.pointRadio = 60;
        this.opaque = 0.0f;
        Graphics2D g = this.map.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, map.getWidth(), map.getHeight());
        g.dispose();
    }

    public void resize(int width, int height) {
        this.map = this.resizeImage(this.map, width, height);

    }

    private BufferedImage resizeImage(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        //g2d.dispose();
        return dimg;
    }

}
