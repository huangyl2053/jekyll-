/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2400011;

import jp.co.ndensan.reams.db.dbc.business.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterHandler;
import jp.co.ndensan.reams.db.dbc.service.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiManager;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のDivControllerクラスです。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
public class TesuryoSeikyuKenShinseishoSakuseiParameter {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TesuryoSeikyuKenShinseishoSakuseiParameterDiv
     * @return ResponseData<TesuryoSeikyuKenShinseishoSakuseiParameterDiv>
     */
    public ResponseData<TesuryoSeikyuKenShinseishoSakuseiParameterDiv> onLond(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        RString 市町村コード_Temp = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        TesuryoSeikyuKenShinseishoSakuseiBusiness business = TesuryoSeikyuKenShinseishoSakuseiManager
                .creatInstance().getTemp_市町村コード(市町村コード_Temp);
        gethHandler(div).onLoad(business);
        return ResponseData.of(div).respond();
    }

    private TesuryoSeikyuKenShinseishoSakuseiParameterHandler gethHandler(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        return new TesuryoSeikyuKenShinseishoSakuseiParameterHandler(div);
    }
}
