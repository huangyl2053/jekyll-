/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tekiyojogaikaijo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 適用除外情報のパラメータクラスです。
 */
public class TekiyoJogaiKaijo implements Serializable {

    private FlexibleDate nyushoTsuchiHakkoYMD;
    private FlexibleDate taishoTsuchiHakkoYMD;

    /**
     * 入所通知発行日を返します。
     *
     * @return 入所通知発行日
     */
    public FlexibleDate getNyushoTsuchiHakkoYMD() {
        return nyushoTsuchiHakkoYMD;
    }

    /**
     * 入所通知発行日を設定します。
     *
     * @param nyushoTsuchiHakkoYMD 入所通知発行日
     */
    public void setNyushoTsuchiHakkoYMD(FlexibleDate nyushoTsuchiHakkoYMD) {
        this.nyushoTsuchiHakkoYMD = nyushoTsuchiHakkoYMD;
    }

    /**
     * 退所通知発行日を返します。
     *
     * @return 退所通知発行日
     */
    public FlexibleDate getTaishoTsuchiHakkoYMD() {
        return taishoTsuchiHakkoYMD;
    }

    /**
     * 退所通知発行日を設定します。
     *
     * @param taishoTsuchiHakkoYMD 退所通知発行日
     */
    public void setTaishoTsuchiHakkoYMD(FlexibleDate taishoTsuchiHakkoYMD) {
        this.taishoTsuchiHakkoYMD = taishoTsuchiHakkoYMD;
    }

}
