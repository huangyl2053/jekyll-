/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.shiharaihohohenkotsuchishohakko;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 発行日リストクラスです。
 *
 * @reamsid_L DBD-3640-010 panxiaobo
 */
public class BunsyubanngaouList {

    private RString 予告文書番号;
    private RString 償還払化文書番号;
    private RString 差止文書番号;
    private RString 控除文書番号;
    private RString 減額文書番号;

    /**
     * @return the 予告文書番号
     */
    public RString get予告文書番号() {
        return 予告文書番号;
    }

    /**
     * @param 予告文書番号 the 予告文書番号 to set
     */
    public void set予告文書番号(RString 予告文書番号) {
        this.予告文書番号 = 予告文書番号;
    }

    /**
     * @return the 償還払化文書番号
     */
    public RString get償還払化文書番号() {
        return 償還払化文書番号;
    }

    /**
     * @param 償還払化文書番号 the 償還払化文書番号 to set
     */
    public void set償還払化文書番号(RString 償還払化文書番号) {
        this.償還払化文書番号 = 償還払化文書番号;
    }

    /**
     * @return the 差止文書番号
     */
    public RString get差止文書番号() {
        return 差止文書番号;
    }

    /**
     * @param 差止文書番号 the 差止文書番号 to set
     */
    public void set差止文書番号(RString 差止文書番号) {
        this.差止文書番号 = 差止文書番号;
    }

    /**
     * @return the 控除文書番号
     */
    public RString get控除文書番号() {
        return 控除文書番号;
    }

    /**
     * @param 控除文書番号 the 控除文書番号 to set
     */
    public void set控除文書番号(RString 控除文書番号) {
        this.控除文書番号 = 控除文書番号;
    }

    /**
     * @return the 減額文書番号
     */
    public RString get減額文書番号() {
        return 減額文書番号;
    }

    /**
     * @param 減額文書番号 the 減額文書番号 to set
     */
    public void set減額文書番号(RString 減額文書番号) {
        this.減額文書番号 = 減額文書番号;
    }
}
