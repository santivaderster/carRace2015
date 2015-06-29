package View;

import Model.HeartModel;
import Controller.HeartController;
import Class.Car;
import Class.BeatBar;
import View.DJView;
import Observer.BeatObserver;
import Adapters.HeartAdapter;
import Observer.BPMObserver;
import Adapters.CarRaceAdapter;
import Controller.CarRaceController;
import Model.CarRaceModel;
import Controller.ControllerInterface;
import Controller.BeatController;
import Model.BeatModelInterface;
import Model.BeatModel;
import java.awt.*;

import java.awt.event.ItemEvent;

import java.awt.event.ItemListener;

import javax.swing.*;



import java.util.ArrayList;

public class CmbView extends DJView {

    private final JComboBox cmbEleccion = new JComboBox();

    private final CmbView thisView = this;

    /**
     *
     * @param controller
     * @param model
     */
    public CmbView(ControllerInterface controller, BeatModelInterface model) {

        super(controller, model);

    }

    public CmbView() {

        super();

    }

    public void createView() 
    {
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(3, 1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
        cmbEleccion.setModel(new DefaultComboBoxModel(new String[]{"Seleccionar", "ModelHeart", "ModelBeat", "ModelCarRace"}));
        cmbEleccion.setSelectedIndex(0);
        cmbEleccion.setToolTipText("");
        cmbEleccion.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e) 
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    if (controller != null) 
                            controller.stop();
                    switch (e.getItem().toString())
                    {
                        case "ModelHeart":
                            HeartController heartController = new HeartController(thisView);
                            setController(heartController);
                            setModel(new HeartAdapter(HeartModel.getInstance()));
                            break;
                        case "ModelBeat":
                            BeatModel beat = new BeatModel();
                            BeatController beatController = new BeatController(beat, thisView);
                            setController(beatController);
                            setModel(beat);
                            break;
                        case "ModelCarRace":
                            CarRaceModel car = new CarRaceModel(new Car(80,0,"Azul",false) ,new ArrayList<Car>());
                            CarRaceController carController = new CarRaceController(car, thisView);
                            setController(carController);
                            setModel((new CarRaceAdapter(car)));
                            break;
                    }
                }
            }
        });
        bpmPanel.add(cmbEleccion);
    }

    public void setModel(BeatModelInterface model) 
    {
        this.model = model;
        model.registerObserver((BeatObserver) this);
        model.registerObserver((BPMObserver) this);
    }

    public void setController(ControllerInterface controller) 
    {
        this.controller = controller;
    }
}
