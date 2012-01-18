/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy.speed;

/**
 * abstract class for making a common API for the jaguars and the victors
 * @author admin
 */
public interface JoeSpeed {
    final int ENCODER_CODES_PER_REV = 360;
    final double ENCODER_RPM_PER_PULSE = 60.0 / ENCODER_CODES_PER_REV;
    double getRPM ();
    void setRPM (double rpm);
}