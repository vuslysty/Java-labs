import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;

class BounceFrame extends JFrame
{

	private BallCanvas canvas;
	public static final int WIDTH = 1450;
	public static final int HEIGHT = 750;

	public BounceFrame() {
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Bounce programm");

		this.canvas = new BallCanvas();
		System.out.println("In Frame Thread name = "
				+ Thread.currentThread().getName());
		Container content = this.getContentPane();
		content.add(this.canvas, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.orange);

		JButton buttonStart = new JButton("Start");
		JButton buttonStop = new JButton("Stop");
		JButton buttonRed = new JButton("Red");
		JButton buttonBlue = new JButton("Blue");

		buttonStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Ball b = new Ball(canvas, Color.darkGray);
				canvas.add(b);

				BallThread thread = new BallThread(b);
				thread.start();
				System.out.println("Thread name = " + thread.getName());
			}
		});

		buttonStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}

		});

		buttonRed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Ball b = new Ball(canvas, Color.red);
				canvas.add(b);

				BallThread thread = new BallThread(b);
				thread.setPriority(MAX_PRIORITY);
				thread.start();
				System.out.println("Thread name = " + thread.getName());
			}
		});

		buttonBlue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Ball b = new Ball(canvas, Color.blue);

				canvas.add(b);
				BallThread thread = new BallThread(b);
				thread.setPriority(MIN_PRIORITY);
				thread.start();
				System.out.println("Thread name = " + thread.getName());
			}
		});


		buttonPanel.add(buttonStart);
		buttonPanel.add(buttonStop);
		buttonPanel.add(buttonRed);
		buttonPanel.add(buttonBlue);

		content.add(buttonPanel, BorderLayout.SOUTH);
	}
}