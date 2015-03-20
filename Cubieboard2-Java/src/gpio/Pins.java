/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpio;

/**
 *
 * @author Tiagop
 * 
 * Classe Usada para Armazenar as funcoes dos pinos da CB2
 * 
 * A Cubieboard 2 Tem 2 grandes conjuntos de Gpio's:
 * <ul>
 * <li>Um do mesmo lado da USB, que nessa classe armazenaremos os dados no Array 'pinsUSB'</li>
 * <li>e outro que fica do lado oposto da placa,mesmo lado da SATA, ainda irei definir Array para ele</li>
 * </ul>
 * 
 */
public class Pins {
    /**
     * Array guarda as informações ref aos pinos gpio do lado da USB
     * obs.:pino 1 (físico) fica prox a entrada LAN lado interno da gpio
     * pino 2(físico)tambémprox a LAN,mas na borda da placa 
     */     
    public final String pinsUSB[][]= {
        {null,null},
        {null,"VCC-5V"},//1
        {"11","ph15"},
        {null,"CSI1"},
        {"10","ph15"},
        {"9" ,"pg0"},
        {"3" ,"pb18"},
        {"2" ,"pb19"},
        {"1" ,"pg3"},
        {"8" ,"pg2"},
        {"7" ,"pg1"},
        {"6" ,"pg4"},//11
        {"5" ,"pg5"},
        {"4" ,"pg6"},
        {"19" ,"pg7"},
        {"18" ,"pg8"},
        {"17" ,"pg9"},
        {"16" ,"pg10"},
        {"15" ,"pg11"},
        {null ,"GND"},
        {null ,"GND"},
        {null ,"FMINL"},//21
        {"14" ,"pi4"},
        {null ,"FMINR"},
        {"13" ,"pi5"},
        {null ,"GND"},
        {"12" ,"pi6"},
        {null ,"VGA-R"},
        {"27" ,"pi7"},
        {null ,"VGA-G"},
        {"26" ,"pi8"},
        {null ,"VGA-B"},
        {"25" ,"pi9"},
        {null ,"LCD1-VSYNC"},
        {"24" ,"pe4"},
        {null ,"LCD1-HSYNC"},
        {"23" ,"pe5"},
        {null ,"GND"},
        {"22" ,"pe6"},
        {null ,"AVCC"},
        {"21" ,"pe7"},
        {null ,"LRADCO"},
        {"20" ,"pe8"},
        {null ,"CVBS"},
        {"35" ,"pe9"},
        {null ,"HPL"},
        {"34" ,"pe10"},
        {null ,"HPR"},
        {"33" ,"pe11"}
    };
    
    /**
     * Array guarda as informações ref aos pinos gpio do lado da SATA
     * obs.: pino 1 (físico)fica prox a entrada SATA lado interno
     * e pino 2 na borda 
     */ 
    public final String pinsSATA[][]={
       {null,null},
       {"32","pd0"},
       {null,"GND"},
       {"30","pd2"},
       {"31","pd1"},
       {"28","pd4"},
       {"29","pd3"},
       {"42","pd6"},
       {"43","pd5"},
       {null,"GND"},
       {"41","pd7"},
       {"39","pd9"},
       {"40","pd8"},
       {"37","pd11"},
       {"38","pd10"},
       {"51","pd13"},
       {"36","pd12"},
       {"49","pd15"},
       {"50","pd14"},
       {"48","pd16"},
       {null,"GND"},
       {"46","pd18"},
       {"47","pd17"},
       {"44","pd20"},
       {"45","pd19"},
       {"58","pd22"},
       {"59","pd21"},
       {"56","pd27"},
       {"57","pd23"},
       {"54","pd24"},
       {"55","pd26"},
       {"52","pb2"},
       {"53","pd25"},
       {null,"YP-TP"},
       {null,"XP-TP"},
       {null,"YN-TP"},
       {null,"XN-TP"},
       {"67","ph"}
       
    };
    
}
