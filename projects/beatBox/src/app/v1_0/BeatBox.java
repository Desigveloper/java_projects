package app.v1_0;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.sound.midi.*;;

public class BeatBox {
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame mainFrame;

    String [] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crush Cymabl", 
                                    "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", 
                                    "Cowbell", "Vibraslap", "Low-mind Tom", "High Agogo", "Open Hi Conga"};
    
    // Drum keys
    int [] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
     
    public static void main(String[] args) {
        new BeatBox().buildGui();
    }

    public void buildGui() {
        mainFrame = new JFrame("Cyber BeatBox");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel backgroundPanel = new JPanel(layout);
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);


        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoLister());
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);

        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        backgroundPanel.add(BorderLayout.EAST, buttonBox);
        backgroundPanel.add(BorderLayout.WEST, nameBox);

        mainFrame.getContentPane().add(backgroundPanel);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);

        mainPanel = new JPanel(grid);
        backgroundPanel.add(BorderLayout.CENTER, mainPanel);


        for (int i = 0; i < 256; i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(false);
            checkboxList.add(checkBox);
            mainPanel.add(checkBox);
        } // end of loop

        setUpMidi();
        mainFrame.setBounds(50, 50, 300, 300);
        mainFrame.pack();
        mainFrame.setVisible(true);
    } // close buildGui method

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();

            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // close setupMidi method

    /* Turns checkbox states into Midi events and add them to Track*/
    public void buildTrackAndStart() {
        int [] trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            int key = instruments[i];

            for (int j = 0; j < 16; j++) {
                JCheckBox jCheckBox = (JCheckBox) checkboxList.get(j + (16 * i));

                if (jCheckBox.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            } // end of inner loop

            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        } // end of outer loop

        track.add(makeEvent(192, 9, 1, 0 , 15));

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } // end of buildTrackAndStart method

    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            buildTrackAndStart();
        }
    } //  end MyStartListener inner class

    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            sequencer.stop();
        }
    } // end of MyStop Listener inner class

    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    } // end of MyUpTempoListener inner class

    public class MyDownTempoLister implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 0.97));
        }
    } // close MyDownTempoLister inner class

    public void makeTracks( int [] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent(int command, int channel, int noteOne, int noteTwo, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(command, channel, noteOne, noteTwo);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}
