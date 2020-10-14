/* DO NOT EDIT THIS FILE.
 * This file is automatically generated by ./generate.sh from cbusdefs.csv
 */ 

package uk.org.merg.cbus;

// 
// Copyright (C) Pete Brownlow 2011-2020   software@upsys.co.uk
// Originally derived from opcodes.h (c) Andrew Crosland.
// CSV version by Ian Hogg inspired by David W Radcliffe
// 
// Ver 8u (WIP: not yet released)
// 
//   This work is licensed under the:
//       Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
//   To view a copy of this license, visit:
//       http://creativecommons.org/licenses/by-nc-sa/4.0/
//   or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
// 
//   License summary:
//     You are free to:
//       Share, copy and redistribute the material in any medium or format
//       Adapt, remix, transform, and build upon the material
// 
//     The licensor cannot revoke these freedoms as long as you follow the license terms.
// 
//     Attribution : You must give appropriate credit, provide a link to the license,
//                    and indicate if changes were made. You may do so in any reasonable manner,
//                    but not in any way that suggests the licensor endorses you or your use.
// 
//     NonCommercial : You may not use the material for commercial purposes. **(see note below)
// 
//     ShareAlike : If you remix, transform, or build upon the material, you must distribute
//                   your contributions under the same license as the original.
// 
//     No additional restrictions : You may not apply legal terms or technological measures that
//                                   legally restrict others from doing anything the license permits.
// 
//    ** For commercial use, please contact the original copyright holder(s) to agree licensing terms
// 
//     This software is distributed in the hope that it will be useful, but WITHOUT ANY
//     WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE
// 
// Version history:
// Pete Brownlow,6/4/11,Original from spec version 7e
// Roger Healey,6/4/11,Add OPC_CMDERR response codes
// Pete Brownlow,7/6/11,Updated to spec ver 7f and add new module ids
// Pete Brownlow,4/7/11,Updated to spec ver 7g
// Pete Brownlow,14/8/11,Updated to spec ver 7h
// Pete Brownlow,18/2/12,Updated to spec ver 8a, Rocrail and animated modeller module types added
// Pete Brownlow,10/4/12,Updated to spec ver 8b, extended parameter bytes
// Pete Brownlow,17/4/12,Updated parameter block definitions, added processor type definitions.
// Roger Healey,13/7/12,Add CANTOTI
// Pete Brownlow,15/9/12,Updated to spec ver 8c, added 0x5D ENUM and 0x75 CANID
// Pete Brownlow,4/1/13,Ver 8d New module types, added 0x5E  NNRST
// Roger Healey,15/2/13,Now at version d. Added new Module Ids (as per ModuleIds Issue 9) and
//          Align Processor Ids with constants.inc
//          Added .(fullstop) before each processor Id > 9
//          Added OPC_NNRST
// Roger Healey,27/4/13,Added CANSIG8 and CANSIG64
// Roger Healey,6/8/13,Added CANCOND8C
// Roger Healey,22/1/14,Added CANPAN, CANACE3C, CANPanel and CANMIO
// Pete Brownlow,22/1/14,Ver 8g New module types, OPC_NNRST & OPC_NNRSM, catch up with .inc file
//          Added parameter definitions for manufacturer's CPU id
//          Added extern C so can be included by c++ code
//          Fixed CANGC1e type definition
// Phil Wheeler,1/2/14,Corrected some typos. Added PRM_BETA, dotted some more decimal numbers
// Phil Wheeler,9/3/14,Corrected CANSIG MTYP definitions
// Pete Brownlow,19/4/14,Ver 8h Added module type defs for CANTOTIMIO, CANACE8MIO, CANBIP, CANSOL
// Pete Brownlow,06/7/15,Ver 8j Add new module types as per modules definitions v17 : CANCDU, CANACC4CDU, CANWiBase, WiCAB, CANWiFi, CANFTT
//          Add new opcode ALOC, added CPU manufacturer code CPUM_ATMEL
// Mike Bolton,2/3/16,Ver 8k    Add module type CANRFID8
// Pete Brownlow,2/7/16,Ver 8m Add new module types CANHNDST, CANTCHNDST, CANmchRFID and CANPiWi
//          Add processor codes for ARM chips used in Raspberry Pi's
// Pete Brownlow,16/2/17,Ver 8n Add module ids to bring it up to module ids document ver 25
// Pete Brownlow,29/7/17,Ver 8p Add new module ids and new cab signalling opcode
// Pete Brownlow,09/1/18,Ver 8q Add new parameter flag for module can consume its own events
// Ian Hogg,11/9/18,Ver 8r Added CANACE16CMIO, CANPiNODE, CANDISP, CANCOMPUTE
// Richard Crawshaw,29/02/2020,Fixed order of columns in CbusCabSigAspect2.
// Pete Brownlow,01/09/20,Ver 8s for additional module ids defined in the ModuleIds file ver 33.
//                        Updated descriptive comments for some module types
//                        Updated CABDAT opcode to match RFC0004
// Pete Brownlow,06/09/20,Ver 8t Added module type for CANRCOM. Fixed: Opcode for CABDAT, names for CANRC522 and CANMAG
// Pete Brownlow,13/10/20,Ver 8u Added module types 67 to 74 including some Arduino projects
//                               Added SPROG manufactuer code 44 and new SPROG CBUS module types
//                               Additional error code for overload
//                               New bus type USB for modules with only USB and no CAN
// 

public enum CbusMergModuleTypes {
// 
// MODULE TYPES
// 
// Please note that the existence of a module type id does not necessarily mean that firmware has been implemented
// 
// MERG Module types
// 
	MTYP_SLIM(0),	//default for SLiM nodes
	MTYP_CANACC4(1),	//Solenoid point driver
	MTYP_CANACC5(2),	//Motorised point driver
	MTYP_CANACC8(3),	//8 digital outputs
	MTYP_CANACE3(4),	//Control panel switch/button encoder
	MTYP_CANACE8C(5),	//8 digital inputs
	MTYP_CANLED(6),	//64 led driver
	MTYP_CANLED64(7),	//64 led driver (multi leds per event)
	MTYP_CANACC4_2(8),	//12v version of CANACC4
	MTYP_CANCAB(9),	//CANCAB hand throttle
	MTYP_CANCMD(10),	//CANCMD command station
	MTYP_CANSERVO(11),	//8 servo driver (on canacc8 or similar hardware)
	MTYP_CANBC(12),	//BC1a command station
	MTYP_CANRPI(13),	//RPI and RFID interface
	MTYP_CANTTCA(14),	//Turntable controller (turntable end)
	MTYP_CANTTCB(15),	//Turntable controller (control panel end)
	MTYP_CANHS(16),	//Handset controller for old BC1a type handsets
	MTYP_CANTOTI(17),	//Track occupancy detector
	MTYP_CAN8I8O(18),	//8 inputs 8 outputs
	MTYP_CANSERVO8C(19),	//Canservo with servo position feedback
	MTYP_CANRFID(20),	//RFID input
	MTYP_CANTC4(21),	//
	MTYP_CANACE16C(22),	//16 inputs
	MTYP_CANIO8(23),	//8 way I/O
	MTYP_CANSNDX(24),	//??
	MTYP_CANEther(25),	//Ethernet interface
	MTYP_CANSIG64(26),	//Multiple aspect signalling for CANLED module
	MTYP_CANSIG8(27),	//Multiple aspect signalling for CANACC8 module
	MTYP_CANCOND8C(28),	//Conditional event generation
	MTYP_CANPAN(29),	//Control panel 32/32
	MTYP_CANACE3C(30),	//Newer version of CANACE3 firmware
	MTYP_CANPanel(31),	//Control panel 64/64
	MTYP_CANMIO(32),	//Multiple I/O – Universal CANMIO firmware
	MTYP_CANACE8MIO(33),	//Multiple IO module 16 inputs emulating CANACE8C on CANMIO hardware
	MTYP_CANSOL(34),	//Solenoid driver module
	MTYP_CANBIP(35),	//Universal CANBIP firmware - Bipolar IO module with additional 8 I/O pins (CANMIO family)
	MTYP_CANCDU(36),	//Solenoid driver module with additional 6 I/O pins (CANMIO family)
	MTYP_CANACC4CDU(37),	//CANACC4 firmware ported to CANCDU
	MTYP_CANWiBase(38),	//CAN to MiWi base station
	MTYP_WiCAB(39),	//Wireless cab using MiWi protocol
	MTYP_CANWiFi(40),	//CAN to WiFi connection with Withrottle to CBUS protocol conversion
	MTYP_CANFTT(41),	//Turntable controller configured using FLiM
	MTYP_CANHNDST(42),	//Handset (alternative to CANCAB)
	MTYP_CANTCHNDST(43),	//Touchscreen handset
	MTYP_CANRFID8(44),	//multi-channel RFID reader
	MTYP_CANmchRFID(45),	//either a 2ch or 8ch RFID reader
	MTYP_CANPiWi(46),	//a Raspberry Pi based module for WiFi
	MTYP_CAN4DC(47),	//DC train controller
	MTYP_CANELEV(48),	//Nelevator controller
	MTYP_CANSCAN(49),	//128 switch inputs
	MTYP_CANMIO_SVO(50),	//16MHz 25k80 version of CANSERVO8c on CANMIO hardware
	MTYP_CANMIO_INP(51),	//16MHz 25k80 version of CANACE8MIO on CANMIO hardware
	MTYP_CANMIO_OUT(52),	//16MHz 25k80 version of CANACC8 on CANMIO hardware
	MTYP_CANBIP_OUT(53),	//16MHz 25k80 version of CANACC5 on CANBIP hardware
	MTYP_CANASTOP(54),	//DCC stop generator
	MTYP_CANCSB(55),	//CANCMD with on board 3A booster
	MTYP_CANMAG(56),	//Magnet on Track detector
	MTYP_CANACE16CMIO(57),	//16 input equivaent to CANACE8C
	MTYP_CANPiNODE(58),	//CBUS module based on Raspberry Pi
	MTYP_CANDISP(59),	//25K80 version of CANLED64 (IHart and MB)
	MTYP_CANCOMPUTE(60),	//Compute Event processing engine
	MTYP_CANRC522(61),	//Read/Write from/to RC522 RFID tags
	MTYP_CANINP(62),	//8 inputs module (2g version of CANACE8c)
	MTYP_CANOUT(63),	//8 outputs module (2g version of CANACC8)
	MTYP_CANEMIO(64),	//Extended CANMIO (24 I/O ports)
	MTYP_CANCABDC(65),	//DC cab
	MTYP_CANRCOM(66),	//DC Railcom detector/reader
	MTYP_CANMP3(67),	//MP3 sound player in response to events (eg: station announcements)
	MTYP_CANXMAS(68),	//Addressed RGB LED driver
	MTYP_CANSVOSET(69),	//Servo setting box
	MTYP_CANCMDDC(70),	//DC Command station
	MTYP_CANTEXT(71),	//Text message display
	MTYP_CANASIGNAL(72),	//Signal controller
	MTYP_CANSLIDER(73),	//DCC cab with slider control
	MTYP_CANDCATC(74),	//DC ATC module
// 
// At the time of writing the list of defined MERG module types is maintained by Pete Brownlow software@upsys.co.uk
// Please liaise with Pete before adding new module types, 
// and/or create your own GitHub branch, add your proposed new module type(s) and then create a Pull Request
// 
	MTYP_CAN_SW(0xFF),	//Software nodes
	MTYP_EMPTY(0xFE),	//Empty module, bootloader only
	MTYP_CANUSB(0xFD);	//USB interface

	private final int v;

	private CbusMergModuleTypes(int v) {
		this.v = v;
	}

	public int value() {
		return v;
	}
}
