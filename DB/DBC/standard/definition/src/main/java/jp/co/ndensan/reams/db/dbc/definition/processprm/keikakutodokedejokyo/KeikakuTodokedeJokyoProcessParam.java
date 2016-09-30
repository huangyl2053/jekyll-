/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.keikakutodokedejokyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計画届出状況リストのプロセス用パラメータクラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeikakuTodokedeJokyoProcessParam implements IBatchProcessParameter {

    private FlexibleDate jyukyuushinseibiFrom;
    private FlexibleDate jyukyuushinseibiTo;
    private RString taisyoushatyuusyutu;
    private RString todokeidejyoukyou;
    private FlexibleDate kijyunbi;
    private Long shutsuryokujunId;

    /**
     * コンストラクタです。
     *
     * @param jyukyuushinseibiFrom FlexibleDate
     * @param jyukyuushinseibiTo FlexibleDate
     * @param taisyoushatyuusyutu RString
     * @param todokeidejyoukyou RString
     * @param kijyunbi FlexibleDate
     * @param shutsuryokujunId Long
     */
    public KeikakuTodokedeJokyoProcessParam(FlexibleDate jyukyuushinseibiFrom,
            FlexibleDate jyukyuushinseibiTo,
            RString taisyoushatyuusyutu,
            RString todokeidejyoukyou,
            FlexibleDate kijyunbi,
            Long shutsuryokujunId) {
        this.jyukyuushinseibiFrom = jyukyuushinseibiFrom;
        this.jyukyuushinseibiTo = jyukyuushinseibiTo;
        this.taisyoushatyuusyutu = taisyoushatyuusyutu;
        this.todokeidejyoukyou = todokeidejyoukyou;
        this.kijyunbi = kijyunbi;
        this.shutsuryokujunId = shutsuryokujunId;
    }
}
