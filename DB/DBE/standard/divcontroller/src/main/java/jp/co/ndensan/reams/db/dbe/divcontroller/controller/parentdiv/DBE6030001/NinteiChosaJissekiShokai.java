/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6030001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601002.DBE601002_NinteichosaJissekiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyojissekiichiran.ChosahyoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001.DBE6030001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001.NinteiChosaJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6030001.NinteiChosaJissekiShokaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6030001.NinteiChosaJissekiShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosajissekishokai.NinteiChosaJissekiShokaiFindler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査実績照会の画面処理クラスです。
 *
 * @reamsid_L DBE-1691-010 dangjingjing
 */
public class NinteiChosaJissekiShokai {

    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");
    private static final RString 一覧表 = new RString("1");
    private static final RString CSVファイル = new RString("2");
    private static final RString なし = new RString("0");
    private static RString STATE;

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onLoad(NinteiChosaJissekiShokaiDiv div) {
        div.getChosaJisshibi().getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        div.getChosaJisshibi().getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getChosaJisshibi().getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        STATE = DBE6030001StateName.初期表示.getName();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onClick_btnKensakuClear(NinteiChosaJissekiShokaiDiv div) {
        getHandler(div).onClick_BtnKensakuClear();
        STATE = DBE6030001StateName.初期表示.getName();
        return ResponseData.of(div).setState(DBE6030001StateName.初期表示);
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onClick_btnkensaku(NinteiChosaJissekiShokaiDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        RString 意見書記入日FROM = RString.EMPTY;
        RString 意見書記入日TO = RString.EMPTY;
        if (div.getChosaJisshibi().getTxtChosaJisshibi().getFromValue() != null) {
            意見書記入日FROM = div.getChosaJisshibi().getTxtChosaJisshibi().getFromValue().toDateString();
        }
        if (div.getChosaJisshibi().getTxtChosaJisshibi().getToValue() != null) {
            意見書記入日TO = div.getChosaJisshibi().getTxtChosaJisshibi().getToValue().toDateString();
        }
        ChosahyoJissekiIchiranMybitisParamter paramter = ChosahyoJissekiIchiranMybitisParamter.createGamenParamter(false,
                意見書記入日FROM,
                意見書記入日TO,
                div.getRadKijunbi().getSelectedKey(),
                div.getChosaJisshibi().getCcdHokensya().getSelectedItem().get市町村コード().value(),
                new RString(div.getChosaJisshibi().getTxtMaxKensu().getValue().toString()),
                div.getDdlKaipage().getSelectedValue());
        Message message = getHandler(div).onClick_btnKensaku(NinteiChosaJissekiShokaiFindler.creatInstance().get帳票出力用認定調査実績集計表(paramter));
        if (message == null) {
            STATE = DBE6030001StateName.一覧.getName();
            return ResponseData.of(div).setState(DBE6030001StateName.一覧);
        }
        return ResponseData.of(div).addMessage(message).respond();
    }

    /**
     * 「条件に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onClick_BtnReSearch(NinteiChosaJissekiShokaiDiv div) {
        STATE = DBE6030001StateName.初期表示.getName();
        return ResponseData.of(div).setState(DBE6030001StateName.初期表示);
    }

    /**
     * 状態遷移された時のイベントです。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onChange_State(NinteiChosaJissekiShokaiDiv div) {
        return ResponseData.of(div).respond();
    }
    
    /**
     * 出力方法を変更した時のイベントです。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onChange_RadShutsuryokuHoho(NinteiChosaJissekiShokaiDiv div) {
        if (div.getRadShutsuryokuHoho().getSelectedKey().equals(CSVファイル)) {
            div.getDdlKaipage().setSelectedKey(なし);
            div.getDdlKaipage().setDisabled(true);
        } else {
            div.getDdlKaipage().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * データの必須選択チェックを実施します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onClick_BatchButton(NinteiChosaJissekiShokaiDiv div) {
        if (STATE.equals(DBE6030001StateName.初期表示.getName())) {
            if (ResponseHolder.isReRequest()) {
                return ResponseData.of(div).setState(DBE6030001StateName.初期表示);
            }
            RString 意見書記入日FROM = RString.EMPTY;
            RString 意見書記入日TO = RString.EMPTY;
            if (div.getChosaJisshibi().getTxtChosaJisshibi().getFromValue() != null) {
                意見書記入日FROM = div.getChosaJisshibi().getTxtChosaJisshibi().getFromValue().toDateString();
            }
            if (div.getChosaJisshibi().getTxtChosaJisshibi().getToValue() != null) {
                意見書記入日TO = div.getChosaJisshibi().getTxtChosaJisshibi().getToValue().toDateString();
            }
            ChosahyoJissekiIchiranMybitisParamter paramter = ChosahyoJissekiIchiranMybitisParamter.createGamenParamter(false,
                    意見書記入日FROM,
                    意見書記入日TO,
                    div.getRadKijunbi().getSelectedKey(),
                    div.getChosaJisshibi().getCcdHokensya().getSelectedItem().get市町村コード().value(),
                    new RString(div.getChosaJisshibi().getTxtMaxKensu().getValue().toString()),
                    div.getDdlKaipage().getSelectedValue());
            Message message = getHandler(div).onClick_btnKensaku(NinteiChosaJissekiShokaiFindler.creatInstance().get帳票出力用認定調査実績集計表(paramter));
            if (message != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
            return ResponseData.of(div).respond();
        }
        if (STATE.equals(DBE6030001StateName.一覧.getName())) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForCheckedDataCount();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「作表処理を実行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiBatchParameter>
     */
    public ResponseData<DBE601002_NinteichosaJissekiParameter> onClick_BtnHakko(NinteiChosaJissekiShokaiDiv div) {
        DBE601002_NinteichosaJissekiParameter param = new DBE601002_NinteichosaJissekiParameter();
        if (div.getRadShutsuryokuHoho().getSelectedKey().equals(一覧表)) {
            param = getHandler(div).createBatchParam(集計表を発行する, STATE);
        }
        if (div.getRadShutsuryokuHoho().getSelectedKey().equals(CSVファイル)) {
            param = getHandler(div).createBatchParam(CSVを出力する, STATE);
        }
        return ResponseData.of(param).respond();
    }

    /**
     * 「CSV作成を実行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiBatchParameter>
     */
    public ResponseData<DBE601002_NinteichosaJissekiParameter> onClick_BtnShutsutyoku(NinteiChosaJissekiShokaiDiv div) {
        DBE601002_NinteichosaJissekiParameter param = getHandler(div).createBatchParam(CSVを出力する, STATE);
        return ResponseData.of(param).respond();
    }

    /**
     * 「一覧表作成を実行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiBatchParameter>
     */
    public ResponseData<DBE601002_NinteichosaJissekiParameter> onClick_BtnPulish(NinteiChosaJissekiShokaiDiv div) {
        DBE601002_NinteichosaJissekiParameter param = getHandler(div).createBatchParam(集計表を発行する, STATE);
        return ResponseData.of(param).respond();
    }

    private NinteiChosaJissekiShokaiHandler getHandler(NinteiChosaJissekiShokaiDiv div) {
        return new NinteiChosaJissekiShokaiHandler(div);
    }

    private NinteiChosaJissekiShokaiValidationHandler getValidationHandler(NinteiChosaJissekiShokaiDiv div) {
        return new NinteiChosaJissekiShokaiValidationHandler(div);
    }
}
