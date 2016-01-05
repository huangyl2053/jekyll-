/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.DBU0210011;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo.KaigoJuminhyoBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011.KobetsuJikoRenkeiInfoSakuseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.DBU0210011.KobetsuJikoRenkeiInfoSakuseiHandler;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

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
//        ChushutsuKikanJohoData chushutsuKikanJohoData = KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder.createInstance().getChushutsukikanJoho();
//        getHandler(div).initialize(chushutsuKikanJohoData);
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
        if (div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkKikanHenko().isAllSelected() == true) {
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
    public ResponseData<KaigoJuminhyoBatchParameter> onClick_btnJikko(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        KaigoJuminhyoBatchParameter parameter = new KaigoJuminhyoBatchParameter();
        ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        if (true) {
            RDate konkaiFromYMD = div.getChushutsuKikan().getTxtKonkaiChushutsuFromYMD().getValue();
            RTime konkaiFromTime = div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().getValue();
            RDate zenkaiFromYMD = div.getChushutsuKikan().getTxtZenkaiChushutsuFromYMD().getValue();
            RTime zenkaiFromTime = div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime().getValue();
            if (konkaiFromYMD.isBefore(zenkaiFromYMD) || (konkaiFromYMD.isBefore(zenkaiFromYMD) && konkaiFromTime.isBefore(zenkaiFromTime))) {
                throw new ApplicationException(DbzErrorMessages.期間が不正_未来日付不可.getMessage());
            } else {
//                parameter = KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder.createInstance()
//                        .getKaigoJuminhyoKobetsuJikouBatchParameter(konkaiFromYMD.toDateString(), new RString(konkaiFromTime.toString()));
            }
        }

        return ResponseData.of(parameter).respond();
    }

    private KobetsuJikoRenkeiInfoSakuseiHandler getHandler(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        return new KobetsuJikoRenkeiInfoSakuseiHandler(div);
    }
}
