/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.dbu0210011;

import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyo.ChushutsuKikanJohoData;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo.KaigoJuminhyoBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011.KobetsuJikoRenkeiInfoSakuseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0210011.KobetsuJikoRenkeiInfoSakuseiHandler;
import jp.co.ndensan.reams.db.dbu.service.core.basic.kaigojuminhyo.KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 介護住民票個別事項連携情報作成【他社住基】情報Divを制御します。
 */
public class KobetsuJikoRenkeiInfoSakusei {

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を画面初期化処理しました。
     *
     * @param div
     * {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiDiv> onLoad(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        ChushutsuKikanJohoData chushutsuKikanJohoData
                = KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder.createInstance().getChushutsukikanJoho();
        getHandler(div).initialize(chushutsuKikanJohoData);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を「全件作成する」を押下する。<br/>
     *
     * @param div
     * {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiDiv> onClick_chkZenken(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        if (div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkZenken().isAllSelected()) {
            div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkKikanHenko().setDisabled(true);
        } else {
            div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkKikanHenko().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を「今回開始日時を修正する]」を押下する。<br/>
     *
     * @param div
     * {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiDiv> onClick_chkKikanHenko(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        if (div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkKikanHenko().isAllSelected()) {
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setReadOnly(false);
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setReadOnly(false);
        } else {
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setReadOnly(true);
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setReadOnly(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を「実行する」を押下する。<br/>
     *
     * @param div
     * {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData onClick_btnJikko(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        ResponseData<KaigoJuminhyoBatchParameter> response = new ResponseData<>();
        RDate konkaiFromYMD = div.getChushutsuKikan().getTxtKonkaiChushutsuFromYMD().getValue();
        RTime konkaiFromTime = div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().getValue();
        RDate zenkaiFromYMD = div.getChushutsuKikan().getTxtZenkaiChushutsuFromYMD().getValue();
        RTime zenkaiFromTime = div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime().getValue();
        if ((konkaiFromYMD != null && konkaiFromTime != null && zenkaiFromYMD != null && zenkaiFromTime != null)
                && (konkaiFromYMD.isBefore(zenkaiFromYMD)
                || (konkaiFromYMD.isBefore(zenkaiFromYMD) && konkaiFromTime.isBefore(zenkaiFromTime)))) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getHandler(div).開始日と終了日の比較チェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        } else {
            response.data = KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder.createInstance()
                    .getKaigoJuminhyoKobetsuJikouBatchParameter(konkaiFromYMD, konkaiFromTime);
        }
        return response;
    }

    private KobetsuJikoRenkeiInfoSakuseiHandler getHandler(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        return new KobetsuJikoRenkeiInfoSakuseiHandler(div);
    }
}
