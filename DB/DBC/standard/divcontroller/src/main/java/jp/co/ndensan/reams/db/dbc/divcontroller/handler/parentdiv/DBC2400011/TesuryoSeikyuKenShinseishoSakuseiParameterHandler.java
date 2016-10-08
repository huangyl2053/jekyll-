/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2400011;

import jp.co.ndensan.reams.db.dbc.business.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterDiv;

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

    public void onLoad(TesuryoSeikyuKenShinseishoSakuseiBusiness business) {

    }
}
