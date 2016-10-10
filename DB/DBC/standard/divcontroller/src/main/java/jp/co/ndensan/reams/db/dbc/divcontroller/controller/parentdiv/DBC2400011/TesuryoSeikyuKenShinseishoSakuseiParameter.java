/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2400011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiManager;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

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
        TesuryoSeikyuKenShinseishoSakuseiMybatisParameter mybitisParamter = new TesuryoSeikyuKenShinseishoSakuseiMybatisParameter(市町村コード_Temp);
        List<TesuryoSeikyuKenShinseishoSakuseiBusiness> businessList = TesuryoSeikyuKenShinseishoSakuseiManager
                .creatInstance().getTemp_市町村コード(mybitisParamter).records();
        if (!businessList.isEmpty()) {
            gethHandler(div).onLoad(businessList.get(0));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<TesuryoSeikyuKenShinseishoSakuseiParameterDiv>
     */
    public ResponseData<TesuryoSeikyuKenShinseishoSakuseiParameterDiv> onClick_Check(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).作成申請年月日空白チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).作成申請年月日比較チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).前回作成期間重複チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private TesuryoSeikyuKenShinseishoSakuseiParameterHandler gethHandler(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        return new TesuryoSeikyuKenShinseishoSakuseiParameterHandler(div);
    }

    private TesuryoSeikyuKenShinseishoSakuseiParameterValidationHandler getValidationHandler(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        return new TesuryoSeikyuKenShinseishoSakuseiParameterValidationHandler(div);
    }
}
