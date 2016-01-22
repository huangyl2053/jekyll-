/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0060031;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060031.NenpoYoushiki2No8Div;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author soft863
 */
public class NenpoYoushiki2No8Handler {

    private final NenpoYoushiki2No8Div div;
    private static final RString フラグ_削除 = new RString("削除");

    public NenpoYoushiki2No8Handler(NenpoYoushiki2No8Div div) {
        this.div = div;
    }

    public void 初期状態(RString viewState) {
//        div.getKanryoMessage()
        div.getHihokenshabango().getTxthokokuYM().setValue(FlexibleDate.MAX);
        div.getHihokenshabango().getTxthokokuYM().setDisabled(true);
        div.getHihokenshabango().getTxtshukeiY().setValue(FlexibleDate.MAX);
        div.getHihokenshabango().getTxtshukeiY().setDisabled(true);
        div.getHihokenshabango().getTxtHihokenshabango().setValue(フラグ_削除);
        div.getHihokenshabango().getTxtHihokenshabango().setDisabled(true);
        div.getHihokenshabango().getTxthihokenshamei().setValue(フラグ_削除);
        div.getHihokenshabango().getTxthihokenshamei().setDisabled(true);
        if (viewState.equals(フラグ_削除)) {
            div.getShisetsugaigosabisujukyuMeisai().getDgItakuyobosabisujukyusu().setDisabled(true);
            div.getShisetsugaigosabisujukyuMeisai().getDgHisetsugaigosabisujukyu().setDisabled(true);
            div.getShisetsugaigosabisujukyuMeisai().getDgChiikimitchakuyobosabisujukyu().setDisabled(true);
        }
    }
}
