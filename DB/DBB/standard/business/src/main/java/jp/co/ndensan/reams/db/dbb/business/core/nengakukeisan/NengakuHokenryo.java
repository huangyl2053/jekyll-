/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 年額計算の結果。賦課年度分の保険料額。
 *
 * @author N2810
 */
public class NengakuHokenryo {

    private FlexibleDate fukaNendo;
    private Decimal hokenryoNengaku;

    /**
     * @return the fukaNendo
     */
    public FlexibleDate getFukaNendo() {
        return fukaNendo;
    }

    /**
     * @param fukaNendo the fukaNendo to set
     */
    protected void setFukaNendo(FlexibleDate fukaNendo) {
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
    protected void setHokenryoNengaku(Decimal hokenryoNengaku) {
        this.hokenryoNengaku = hokenryoNengaku;
    }
}
