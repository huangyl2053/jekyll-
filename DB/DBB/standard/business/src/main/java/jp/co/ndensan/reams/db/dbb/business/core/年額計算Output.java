/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
public class 年額計算Output {
    
    private RString fukaNendo;
    private Decimal hokenryoNengaku;

    /**
     * @return the fukaNendo
     */
    public RString getFukaNendo() {
        return fukaNendo;
    }

    /**
     * @param fukaNendo the fukaNendo to set
     */
    public void setFukaNendo(RString fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * @return the hokenryoNengaku
     */
    public Decimal getHokenryoNengaku() {
        return hokenryoNengaku;
    }

    /**
     * @param hokenryoNengaku the hokenryoNengaku to set
     */
    public void setHokenryoNengaku(Decimal hokenryoNengaku) {
        this.hokenryoNengaku = hokenryoNengaku;
    }
}
