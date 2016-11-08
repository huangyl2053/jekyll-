/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0210011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyo.ChushutsuKikanJohoData;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU070010.DBU070010_KobetsujikoRenkei_TashaParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011.KobetsuJikoRenkeiInfoSakuseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0210011.KobetsuJikoRenkeiInfoSakuseiHandler;
import jp.co.ndensan.reams.db.dbu.service.core.kaigojuminhyo.KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 介護住民票個別事項連携情報作成【他社住基】情報Divを制御します。
 *
 * @reamsid_L DBU-0350-010 zhangguopeng
 */
public class KobetsuJikoRenkeiInfoSakusei {

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を画面初期化処理しました。
     *
     * @param div {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiDiv> onLoad(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        ChushutsuKikanJohoData chushutsuKikanJohoData
                = KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder.createInstance().getChushutsukikanJoho();
        getHandler(div).initialize(chushutsuKikanJohoData);
        
        if (chushutsuKikanJohoData == null) {
            Map 処理日付Map = new HashMap();
            処理日付Map.put("TxtZenkaiChushutsuToYMD", div.getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD().getValue());
            処理日付Map.put("TxtZenkaiChushutsuToTime", div.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime().getValue());
            処理日付Map.put("TxtKonkaiChushutsuFromYMD", div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().getValue());
            処理日付Map.put("TxtKonkaiChushutsuFromTime", div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().getValue());
            ViewStateHolder.put(ViewStateKeys.発行日時Map, (Serializable) 処理日付Map);
        }
        
        ViewStateHolder.put(ViewStateKeys.退避用データ, chushutsuKikanJohoData);
        return ResponseData.of(div).respond();
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を「全件作成する」を押下する。<br/>
     *
     * @param div {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiDiv> onClick_chkZenken(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        List<RString> key = new ArrayList<>();
        if (div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkZenken().isAllSelected()) {
            div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkKikanHenko().setDisabled(true);
            div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkKikanHenko().setSelectedItemsByKey(key);
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().clearValue();
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().clearValue();
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setReadOnly(true);
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setReadOnly(true);
        } else {
            ChushutsuKikanJohoData chushutsuKikanJohoData = ViewStateHolder.get(ViewStateKeys.退避用データ, ChushutsuKikanJohoData.class);
            if (chushutsuKikanJohoData != null && chushutsuKikanJohoData.get対象終了日時() != null && !chushutsuKikanJohoData.get対象終了日時().isEmpty()) {
                div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setValue(
                        chushutsuKikanJohoData.get対象終了日時().getDate());
                div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setValue(
                        chushutsuKikanJohoData.get対象終了日時().getRDateTime().getTime());
            } else {
                Map 処理日付Map = ViewStateHolder.get(ViewStateKeys.発行日時Map, HashMap.class);
                div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD().clearValue();
                div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime().clearValue();
                div.getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD().setValue(new RDate(処理日付Map.get("TxtZenkaiChushutsuToYMD").toString()));
                div.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime().setValue(new RTime(new RString(処理日付Map.get("TxtZenkaiChushutsuToTime").toString())));
                div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setValue(new RDate(処理日付Map.get("TxtKonkaiChushutsuFromYMD").toString()));
                div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setValue(new RTime(new RString(処理日付Map.get("TxtKonkaiChushutsuFromTime").toString())));
            }
            div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkKikanHenko().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を「今回開始日時を修正する]」を押下する。<br/>
     *
     * @param div {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiDiv> onClick_chkKikanHenko(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        if (div.getKobetsuJikoRenkeiInfoSakuseiBP().getChkKikanHenko().isAllSelected()) {
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setReadOnly(false);
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setReadOnly(false);
        } else {
            Map 処理日付Map = ViewStateHolder.get(ViewStateKeys.発行日時Map, HashMap.class);
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setValue(new RDate(処理日付Map.get("TxtKonkaiChushutsuFromYMD").toString()));
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setValue(new RTime(new RString(処理日付Map.get("TxtKonkaiChushutsuFromTime").toString())));
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setReadOnly(true);
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setReadOnly(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を「実行する」を押下チェックする。<br/>
     *
     * @param div {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiDiv> onClick_btnJikkoBefore(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        RDate konkaiFromYMD = div.getChushutsuKikan().getTxtKonkaiChushutsuFromYMD().getValue();
        RTime konkaiFromTime = div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().getValue();
        RDate zenkaiToYMD = div.getChushutsuKikan().getTxtZenkaiChushutsuToYMD().getValue();
        RTime zenkaiToTime = div.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime().getValue();
        if ((konkaiFromYMD != null && konkaiFromTime != null && zenkaiToYMD != null && zenkaiToTime != null)
            && (zenkaiToYMD.isBefore(konkaiFromYMD)
                || (konkaiFromYMD.equals(zenkaiToYMD) && zenkaiToTime.isBefore(konkaiFromTime)))) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getHandler(div).開始日と終了日の比較チェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】を「実行する」を押下する。<br/>
     *
     * @param div {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData onClick_btnJikko(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        ResponseData<DBU070010_KobetsujikoRenkei_TashaParameter> response = new ResponseData<>();
        RDate konkaiFromYMD = div.getChushutsuKikan().getTxtKonkaiChushutsuFromYMD().getValue();
        RTime konkaiFromTime = div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().getValue();

        response.data = KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder.createInstance()
                .getKaigoJuminhyoKobetsuJikouBatchParameter(konkaiFromYMD, konkaiFromTime);
        return response;
    }

    private KobetsuJikoRenkeiInfoSakuseiHandler getHandler(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        return new KobetsuJikoRenkeiInfoSakuseiHandler(div);
    }
}
