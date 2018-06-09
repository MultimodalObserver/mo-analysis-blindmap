/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.eyetribeblindmapplayer;

import com.theeyetribe.clientsdk.data.GazeData;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;

/**
 *
 * @author gustavo
 */
public class EyeTribeBlindMapControlPanel extends javax.swing.JPanel {

    int val;
    private long currentTime;
    private long starRangeTime;
    private long endRangeTime;
    private JFXPanelBlindMap fixationPanel;
    private File outputDir;

    public EyeTribeBlindMapControlPanel(File dataFile, File mediaFile) throws FileNotFoundException {

        initComponents();
        this.currentTime = 0;
        this.starRangeTime = 0;
        this.endRangeTime = 0;
        Media media = new Media(mediaFile.toURI().toString());

        TrackingPanel videoPanel = (TrackingPanel) this.frontPanel;
        videoPanel.setupMedia(media);
        this.trackingPanel = (TrackingPanel) this.frontPanel;
        this.fixationPanel = this.trackingPanel.getFxPanel();

        /////////////////////////////////////////////////7         
        this.dataFile = dataFile;

    }

    public EyeTribeBlindMapControlPanel(File dataFile, File mediaFile, File outputDir) throws FileNotFoundException {

        initComponents();
        this.currentTime = 0;
        this.starRangeTime = 0;
        this.endRangeTime = 0;
        Media media = new Media(mediaFile.toURI().toString());
        this.outputDir = outputDir;

        TrackingPanel videoPanel = (TrackingPanel) this.frontPanel;
        videoPanel.setupMedia(media);
        this.trackingPanel = (TrackingPanel) this.frontPanel;
        this.fixationPanel = this.trackingPanel.getFxPanel();

        /////////////////////////////////////////////////7         
        this.dataFile = dataFile;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frontPanel = new TrackingPanel();
        opacityMapChooser = new javax.swing.JSlider();
        selectStartRangeButton = new javax.swing.JButton();
        selectEndRangeButton = new javax.swing.JButton();
        saveAsButton = new javax.swing.JButton();
        intervalMapButton = new javax.swing.JButton();
        cleanMapButton = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        frontPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        frontPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                frontPanelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout frontPanelLayout = new javax.swing.GroupLayout(frontPanel);
        frontPanel.setLayout(frontPanelLayout);
        frontPanelLayout.setHorizontalGroup(
            frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        frontPanelLayout.setVerticalGroup(
            frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        opacityMapChooser.setValue(100);
        opacityMapChooser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                opacityMapChooserMouseDragged(evt);
            }
        });

        selectStartRangeButton.setText("<");
        selectStartRangeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectStartRangeButtonMouseClicked(evt);
            }
        });

        selectEndRangeButton.setText(">");
        selectEndRangeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectEndRangeButtonMouseClicked(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("i18n/mo/analysis/BlindmapPlugin/BlindmapControlPanel"); // NOI18N
        saveAsButton.setText(bundle.getString("saveImage")); // NOI18N
        saveAsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveAsButtonMouseClicked(evt);
            }
        });

        intervalMapButton.setText(bundle.getString("intervalMap")); // NOI18N
        intervalMapButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                intervalMapButtonMouseClicked(evt);
            }
        });

        cleanMapButton.setText(bundle.getString("Clean")); // NOI18N
        cleanMapButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanMapButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectStartRangeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectEndRangeButton)
                .addGap(35, 35, 35)
                .addComponent(opacityMapChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(intervalMapButton)
                .addGap(18, 18, 18)
                .addComponent(cleanMapButton)
                .addGap(18, 18, 18)
                .addComponent(saveAsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(frontPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveAsButton)
                            .addComponent(intervalMapButton)
                            .addComponent(cleanMapButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(frontPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(selectStartRangeButton)
                                .addComponent(selectEndRangeButton))
                            .addComponent(opacityMapChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void frontPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_frontPanelComponentResized

    }//GEN-LAST:event_frontPanelComponentResized

    private void opacityMapChooserMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opacityMapChooserMouseDragged
        this.trackingPanel.getFxPanel().setBlindmapOpacity((float) this.opacityMapChooser.getValue() / 100);
        // this.trackingPanel.getFxPanel().getFijationMap().cleanMap();
        //  this.trackingPanel.getFxPanel().getFijationMap().repaint();
        this.repaint();
    }//GEN-LAST:event_opacityMapChooserMouseDragged

    private void selectStartRangeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectStartRangeButtonMouseClicked
        this.starRangeTime = this.currentTime;
        this.fixationPanel.setStartRange(starRangeTime);
        this.repaint();

    }//GEN-LAST:event_selectStartRangeButtonMouseClicked

    private void selectEndRangeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectEndRangeButtonMouseClicked
        this.endRangeTime = this.currentTime;
        this.fixationPanel.setEndRange(endRangeTime);
        this.repaint();
    }//GEN-LAST:event_selectEndRangeButtonMouseClicked

    private void cleanMapButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanMapButtonMouseClicked
        this.trackingPanel.getFxPanel().restarBlindMap();
        this.repaint();
    }//GEN-LAST:event_cleanMapButtonMouseClicked

    private void intervalMapButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_intervalMapButtonMouseClicked
        this.trackingPanel.getFxPanel().updateBlindMap();
        this.repaint();
    }//GEN-LAST:event_intervalMapButtonMouseClicked

    private void saveAsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveAsButtonMouseClicked
        String now = DateTime.now().toString();
        File outputFile = new File(outputDir.getPath(), "BlindMap_" + now.substring(0, now.indexOf("T")) + "_" + ".png");
        this.fixationPanel.mapToFile(outputFile);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("i18n/mo/analysis/BlindmapPlugin/BlindmapPluginDialogs");
        JOptionPane.showMessageDialog(frontPanel, bundle.getString("imageSaved") + outputFile.getPath());
    }//GEN-LAST:event_saveAsButtonMouseClicked

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        int realWidth = this.trackingPanel.getFxPanel().getRealWidth();
        int realHeight = this.trackingPanel.getFxPanel().getRealHeight();
        this.trackingPanel.setSize(realWidth, realHeight);
        this.trackingPanel.getFxPanel().setSize(realWidth, realHeight);
        this.trackingPanel.setPreferredSize(new Dimension(realWidth, realHeight));

    }//GEN-LAST:event_formComponentResized

    public void setOffset(long offset) {
        this.trackingPanel.getFxPanel().setOffset(offset);
    }

    public void playVideo() {
        this.trackingPanel.getFxPanel().playVideo();
    }

    public void playData(long time) {

    }

    public void addData(GazeData data) {
        this.trackingPanel.getFxPanel().addData(data);
    }

    public void addDataWithoutAois(GazeData data) {
        this.trackingPanel.getFxPanel().addDataWithoutAois(data);
    }

    public void pauseVideo() {
        this.trackingPanel.getFxPanel().pauseVideo();
    }

    public void setDataFromHeatMap(ArrayList<GazeData> data) {
        this.fixationPanel.setDataFromHeatMap(data);
    }

    public void pauseData() {

    }

    public void seekVideo(long time) {
        this.fixationPanel.seek(time);
    }

    public void seekData(long time) {

    }

    public void stop() {
        this.trackingPanel.getFxPanel().stop();
    }

    public void reset() {
        this.trackingPanel.getFxPanel().reset();
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void setTime(long start, long end) {
        this.fixationPanel.setStartTime(start);
        this.fixationPanel.setEndTime(end);
        this.endRangeTime = end;
        this.starRangeTime = start;
        this.fixationPanel.setTimeRange(start, end);
    }

    public void restartBlindMap() {
        this.fixationPanel.restarBlindMap();
    }

    public void playWhitLimit(Long limit) {
        this.trackingPanel.getFxPanel().playToLimit(limit);
    }

    public void cleanLastPlayLimit() {
        this.trackingPanel.getFxPanel().cleanLastPlayLimit();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cleanMapButton;
    private javax.swing.JPanel frontPanel;
    private javax.swing.JButton intervalMapButton;
    private javax.swing.JSlider opacityMapChooser;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JButton selectEndRangeButton;
    private javax.swing.JButton selectStartRangeButton;
    // End of variables declaration//GEN-END:variables
    private boolean playing;
    private TrackingPanel trackingPanel;
    private File dataFile;

}
