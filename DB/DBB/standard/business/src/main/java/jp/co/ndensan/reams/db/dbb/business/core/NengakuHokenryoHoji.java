/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public class NengakuHokenryoHoji {
    private RString rank;
    private RString dankai;
    private int kosuu;

    /**
     * @return the rank
     */
    public RString getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(RString rank) {
        this.rank = rank;
    }

    /**
     * @return the dankai
     */
    public RString getDankai() {
        return dankai;
    }

    /**
     * @param dankai the dankai to set
     */
    public void setDankai(RString dankai) {
        this.dankai = dankai;
    }

    /**
     * @return the kosuu
     */
    public int getKosuu() {
        return kosuu;
    }

    /**
     * @param kosuu the kosuu to set
     */
    public void setKosuu(int kosuu) {
        this.kosuu = kosuu;
    }
}
