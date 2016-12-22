/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6020001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601001.DBE601001_IkenshoSakuseiJIssekiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojissekiichiran.IkenshoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6020001.DBE6020001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6020001.IkenshoSakuseiJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6020001.IkenshoSakuseiJissekiShokaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6020001.IkenshoSakuseiJissekiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshosakuseijissekishokai.IkenshoSakuseiJissekiShokaiFindler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 意見書作成実績照会の画面処理クラスです。
 *
 * @reamsid_L DBE-1690-010 dongyabin
 */
public class IkenshoSakuseiJissekiShokai {

    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiJissekiShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiJissekiShokaiDiv> onLoad(IkenshoSakuseiJissekiShokaiDiv div) {
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiJissekiShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiJissekiShokaiDiv> onClick_BtnKensakuClear(IkenshoSakuseiJissekiShokaiDiv div) {
        getHandler(div).onClick_BtnKensakuClear();
        return ResponseData.of(div).setState(DBE6020001StateName.検索);
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiJissekiShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiJissekiShokaiDiv> onClick_BtnKensaku(IkenshoSakuseiJissekiShokaiDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        RString 意見書記入日FROM = RString.EMPTY;
        RString 意見書記入日TO = RString.EMPTY;
        if (div.getTxtIkenshoKinyubi().getFromValue() != null) {
            意見書記入日FROM = div.getTxtIkenshoKinyubi().getFromValue().toDateString();
        }
        if (div.getTxtIkenshoKinyubi().getToValue() != null) {
            意見書記入日TO = div.getTxtIkenshoKinyubi().getToValue().toDateString();
        }
        IkenshoJissekiIchiranMybitisParamter paramter = IkenshoJissekiIchiranMybitisParamter.createGamenParamter(false,
                意見書記入日FROM,
                意見書記入日TO,
                div.getRadKensakuKijunbi().getSelectedKey(),
                div.getCcdHokensya().getSelectedItem().get市町村コード().value(),
                new RString(div.getTxtMaxKensu().getValue().toString()));
        Message message = getHandler(div).onClick_BtnKensaku(IkenshoSakuseiJissekiShokaiFindler.createInstance().get主治医意見書作成実績集計表(paramter));
        if (message == null) {
            return ResponseData.of(div).setState(DBE6020001StateName.一覧);
        }
        return ResponseData.of(div).addMessage(message).respond();
    }

    /**
     * 状態遷移された時のイベントです。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiJissekiShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiJissekiShokaiDiv> onChange_State(IkenshoSakuseiJissekiShokaiDiv div) {
        if (ResponseHolder.getState().equals(DBE6020001StateName.一覧.getName())) {
            if (div.getDgIkenshoSakuseiJisseki().getDataSource().isEmpty()) {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnPulish"), true);
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnShutsutyoku"), true);
            } else {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnPulish"), false);
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnShutsutyoku"), false);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiJissekiShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiJissekiShokaiDiv> onClick_btnBackToKensaku(IkenshoSakuseiJissekiShokaiDiv div) {
        return ResponseData.of(div).setState(DBE6020001StateName.検索);
    }

    /**
     * データの必須選択チェックを実施します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiJissekiShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiJissekiShokaiDiv> onClick_BatchButton(IkenshoSakuseiJissekiShokaiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForCheckedDataCount();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSVを出力する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoJissekiIchiranBatchParameter>
     */
    public ResponseData<DBE601001_IkenshoSakuseiJIssekiParameter> onClick_BtnShutsutyoku(IkenshoSakuseiJissekiShokaiDiv div) {
        DBE601001_IkenshoSakuseiJIssekiParameter paramter = getHandler(div).createBatchParam(CSVを出力する);
        return ResponseData.of(paramter).respond();
    }

    /**
     * 「集計表を発行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoJissekiIchiranBatchParameter>
     */
    public ResponseData<DBE601001_IkenshoSakuseiJIssekiParameter> onClick_BtnPulish(IkenshoSakuseiJissekiShokaiDiv div) {
        DBE601001_IkenshoSakuseiJIssekiParameter paramter = getHandler(div).createBatchParam(集計表を発行する);
        return ResponseData.of(paramter).respond();
    }

    private IkenshoSakuseiJissekiShokaiHandler getHandler(IkenshoSakuseiJissekiShokaiDiv div) {
        return new IkenshoSakuseiJissekiShokaiHandler(div);
    }

    private IkenshoSakuseiJissekiValidationHandler getValidationHandler(IkenshoSakuseiJissekiShokaiDiv div) {
        return new IkenshoSakuseiJissekiValidationHandler(div);
    }
}
