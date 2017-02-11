package org.usfirst.frc.team5493.robot.controllers;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

public class LWTalon extends Talon implements LiveWindowSendable {

	private static final String SMART_DASHBOARD_TYPE = "TalonLiveWindow";

	public LWTalon(int channel) {
		super(channel);
	}

	/*
	 * Live Window code, only does anything if live window is activated.
	 */

	private ITable m_table = null;
	private ITableListener m_table_listener = null;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initTable(ITable subtable) {
		m_table = subtable;
		updateTable();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateTable() {
		ITable table = getTable();
		if (table != null) {
			table.putString("~TYPE~", SMART_DASHBOARD_TYPE);
			table.putString("Type", getClass().getSimpleName()); // "CANTalon",
																	// "CANJaguar"
			// table.putNumber("Mode", getControlMode().getValue());
			// if (getControlMode().isPID()) {
			// // CANJaguar throws an exception if you try to get its PID
			// constants
			// // when it's not in a PID-compatible mode
			// table.putNumber("p", getP());
			// table.putNumber("i", getI());
			// table.putNumber("d", getD());
			// table.putNumber("f", getF());
			// }
			// table.putBoolean("Enabled", isEnabled());
			table.putNumber("Value", get());
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITable getTable() {
		return m_table;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startLiveWindowMode() {
		set(0); // Stop for safety
		m_table_listener = createTableListener();
		m_table.addTableListener(m_table_listener, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopLiveWindowMode() {
		set(0); // Stop for safety
		// TODO: See if this is still broken
		m_table.removeTableListener(m_table_listener);
	}

	@Override
	public String getSmartDashboardType() {
		return SMART_DASHBOARD_TYPE;
	}

	/**
	 * Creates an ITableListener for the LiveWindow table for this CAN speed
	 * controller.
	 */
	public ITableListener createTableListener() {
		return (table, key, value, isNew) -> {
			switch (key) {
			case "Value":
				set((Double) value);
				break;
			}
		};
	}
}
