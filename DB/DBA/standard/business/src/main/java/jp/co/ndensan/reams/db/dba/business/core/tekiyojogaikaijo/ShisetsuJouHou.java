/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tekiyojogaikaijo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 適用除外情報のパラメータクラスです。
 */
public class ShisetsuJouHou implements Serializable {

    private FlexibleDate nyushoTsuchiHakkoYMD;
    private FlexibleDate taishoTsuchiHakkoYMD;
    private RString state;

    /**
     * 入所日を返します。
     *
     * @return 入所日
     */
    public FlexibleDate getNyushoTsuchiHakkoYMD() {
        return nyushoTsuchiHakkoYMD;
    }

    /**
     * 入所日を設定します。
     *
     * @param nyushoTsuchiHakkoYMD 入所日
     */
    public void setNyushoTsuchiHakkoYMD(FlexibleDate nyushoTsuchiHakkoYMD) {
        this.nyushoTsuchiHakkoYMD = nyushoTsuchiHakkoYMD;
    }

    /**
     * 退所日を返します。
     *
     * @return 退所日
     */
    public FlexibleDate getTaishoTsuchiHakkoYMD() {
        return taishoTsuchiHakkoYMD;
    }

    /**
     * 退所日を設定します。
     *
     * @param taishoTsuchiHakkoYMD 退所日
     */
    public void setTaishoTsuchiHakkoYMD(FlexibleDate taishoTsuchiHakkoYMD) {
        this.taishoTsuchiHakkoYMD = taishoTsuchiHakkoYMD;
    }

    /**
     * 状態を返します。
     *
     * @return 状態
     */
    public RString getState() {
        return state;
    }

    /**
     * 状態を設定します。
     *
     * @param state 状態
     */
    public void setState(RString state) {
        this.state = state;
    }
}
