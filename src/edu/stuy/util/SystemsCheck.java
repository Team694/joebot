/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy.util;

import edu.stuy.commands.*;
import edu.stuy.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author 694
 */
public class SystemsCheck extends CommandGroup {

    public SystemsCheck() {
        checkAcquirer();
        addSequential(new WaitCommand(1));
        checkConveyor();
        addSequential(new WaitCommand(1));
        checkShooter();
        addSequential(new WaitCommand(1));
        checkTusks();
    }

    private void checkAcquirer(){
        addSequential(new AcquirerAcquire());
        addSequential(new WaitCommand(1));
        addSequential(new AcquirerReverse());
        addSequential(new WaitCommand(1));
        addSequential(new AcquirerStop());
    }

    private void checkConveyor() {
        addSequential(new ConveyAutomatic());
        addSequential(new WaitCommand(1));
        addSequential(new ConveyReverseManual());
        addSequential(new WaitCommand(1));
        addSequential(new ConveyStop());
    }

    private void checkShooter() {
        double distanceInches = Shooter.distances[Shooter.FENDER_INDEX];
        addSequential(new ShooterMoveFlyWheel(distanceInches));
        addSequential(new WaitCommand(1));
        addSequential(new ShooterStop());
    }

    private void checkTusks() {
        addSequential(new TusksExtend());
        addSequential(new WaitCommand(1));
        addSequential(new TusksRetract());
    }
}
