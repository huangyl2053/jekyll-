/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author n3336
 */
public class 端数調整_四捨五入 implements I端数調整{
    private final String tanni;

    public 端数調整_四捨五入(String tanni) {
        this.tanni = tanni;
    }
    
    @Override
    public Decimal Calc端数(Decimal 年額保険料) {
        Integer half = Integer.parseInt(this.tanni);
        half = half/2;
        if( (年額保険料.remainder(new Decimal(this.tanni))).compareTo(new Decimal(half.toString())) >= 0  ){
           return 年額保険料.subtract(年額保険料.remainder(new Decimal(this.tanni))).add(new Decimal(this.tanni));            
        }
        return 年額保険料.subtract(年額保険料.remainder(new Decimal(this.tanni))); 
    }        
    
    
}
