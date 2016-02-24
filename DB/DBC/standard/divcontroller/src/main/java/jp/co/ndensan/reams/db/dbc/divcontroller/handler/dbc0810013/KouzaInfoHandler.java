/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810013;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810013.KouzaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 償還払い状況照会_口座情報コンストラクタです。
 */
public class KouzaInfoHandler {

    private final KouzaInfoDiv div;

    /**
     * KouzaInfoHandler
     *
     * @param div KouzaInfoDiv
     */
    public KouzaInfoHandler(KouzaInfoDiv div) {
        this.div = div;
    }

    /**
     * ヘッダ_エリア
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 
     */
    public void setヘッダ_エリア(FlexibleYearMonth サービス年月, RString 整理番号) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
    }
}
