/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2400011;

import jp.co.ndensan.reams.db.dbc.business.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 ハンドラクラスです。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
public class TesuryoSeikyuKenShinseishoSakuseiParameterHandler {

    private final TesuryoSeikyuKenShinseishoSakuseiParameterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TesuryoSeikyuKenShinseishoSakuseiParameterDiv
     */
    public TesuryoSeikyuKenShinseishoSakuseiParameterHandler(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param business 住宅改修理由書作成手数料請求書兼申請書
     */
    public void onLoad(TesuryoSeikyuKenShinseishoSakuseiBusiness business) {
        div.getChushutsuJokenPanel().getTxtZenkaiRiyushoSakuseiShinseiYMD().setFromValue(business.get対象開始日時().getDate());
        div.getChushutsuJokenPanel().getTxtZenkaiRiyushoSakuseiShinseiYMD().setToValue(business.get対象終了日時().getDate());
        if (business.get対象終了日時() != null && !business.get対象終了日時().isEmpty()) {
            div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().setFromValue(business.get対象終了日時().plusDay(1).getDate());
        } else {
            div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().setFromValue(new RDate(""));
        }
        div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().setToValue(RDate.getNowDate());
    }
}
