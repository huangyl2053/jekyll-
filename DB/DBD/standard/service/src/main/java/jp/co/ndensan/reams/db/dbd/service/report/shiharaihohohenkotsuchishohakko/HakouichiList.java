/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.shiharaihohohenkotsuchishohakko;

import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * 文書番号リストクラスです。
 *
 * @reamsid_L DBD-3640-010 panxiaobo
 */
public class HakouichiList {

    private RDate 予告通知書発行年月日;
    private RDate 償還払化通知書発行年月日;
    private RDate 差止通知書発行年月日;
    private RDate 控除通知書発行年月日;
    private RDate 減額通知書発行年月日;

    /**
     * @return the 予告通知書発行年月日
     */
    public RDate get予告通知書発行年月日() {
        return 予告通知書発行年月日;
    }

    /**
     * @param 予告通知書発行年月日 the 予告通知書発行年月日 to set
     */
    public void set予告通知書発行年月日(RDate 予告通知書発行年月日) {
        this.予告通知書発行年月日 = 予告通知書発行年月日;
    }

    /**
     * @return the 償還払化通知書発行年月日
     */
    public RDate get償還払化通知書発行年月日() {
        return 償還払化通知書発行年月日;
    }

    /**
     * @param 償還払化通知書発行年月日 the 償還払化通知書発行年月日 to set
     */
    public void set償還払化通知書発行年月日(RDate 償還払化通知書発行年月日) {
        this.償還払化通知書発行年月日 = 償還払化通知書発行年月日;
    }

    /**
     * @return the 差止通知書発行年月日
     */
    public RDate get差止通知書発行年月日() {
        return 差止通知書発行年月日;
    }

    /**
     * @param 差止通知書発行年月日 the 差止通知書発行年月日 to set
     */
    public void set差止通知書発行年月日(RDate 差止通知書発行年月日) {
        this.差止通知書発行年月日 = 差止通知書発行年月日;
    }

    /**
     * @return the 控除通知書発行年月日
     */
    public RDate get控除通知書発行年月日() {
        return 控除通知書発行年月日;
    }

    /**
     * @param 控除通知書発行年月日 the 控除通知書発行年月日 to set
     */
    public void set控除通知書発行年月日(RDate 控除通知書発行年月日) {
        this.控除通知書発行年月日 = 控除通知書発行年月日;
    }

    /**
     * @return the 減額通知書発行年月日
     */
    public RDate get減額通知書発行年月日() {
        return 減額通知書発行年月日;
    }

    /**
     * @param 減額通知書発行年月日 the 減額通知書発行年月日 to set
     */
    public void set減額通知書発行年月日(RDate 減額通知書発行年月日) {
        this.減額通知書発行年月日 = 減額通知書発行年月日;
    }
}
