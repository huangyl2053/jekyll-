/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6060001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshushokai.NinteichosahoshushokaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai.NinteiChosaHoshuShokaiFlowParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai.NinteiChosaHoshuShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001.NinteiChosaHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6060001.NinteiChosaHoshuShokaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6060001.NinteiChosaHoshuShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahoshushokai.NinteiChosaHoshuShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査報酬照会の処理詳細です。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
public class NinteiChosaHoshuShokai {

    private static final RString BTNPULISH = new RString("btnPulish");
    private static final RString BTNSHUTSUTYOKU = new RString("btnShutsutyoku");
    private static final RString BTNMODORU = new RString("btnModoru");

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiDiv>
     */
    public ResponseData<NinteiChosaHoshuShokaiDiv> onLoad(NinteiChosaHoshuShokaiDiv div) {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTNPULISH, false);
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTNSHUTSUTYOKU, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTNMODORU, false);
        div.getChosaIraibi().setDisplayNone(false);
        div.getNinteiChosaHoshu().setDisplayNone(true);
        div.getChosaIraibi().setVisible(true);
        div.getNinteiChosaHoshu().setVisible(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査報酬照会の検索処理です。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiDiv>
     */
    public ResponseData<NinteiChosaHoshuShokaiDiv> onClick_btnKensaku(NinteiChosaHoshuShokaiDiv div) {
        FlexibleDate 依頼日開始 = new FlexibleDate(div.getTxtChosaIraibi().getFromValue().toDateString());
        FlexibleDate 依頼日終了 = new FlexibleDate(div.getTxtChosaIraibi().getToValue().toDateString());
        NinteiChosaHoshuShokaiMapperParameter chosaParamter = NinteiChosaHoshuShokaiMapperParameter.createSelectBy情報(
                DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援),
                依頼日開始, 依頼日終了, Integer.parseInt(div.getChosaIraibi().getTxtMaxKensu().getValue().toString()), false, null);
        List<NinteichosahoshushokaiBusiness> 調査情報 = NinteiChosaHoshuShokaiFinder.createInstance().get認定調査報酬情報(chosaParamter).records();
        if (調査情報.isEmpty()) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnPulish"), false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnShutsutyoku"), false);
        } else {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnPulish"), true);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnShutsutyoku"), true);
        }
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnModoru"), true);
        getHandler(div).onClick_btnKensaku(調査情報);
        div.getChosaIraibi().setDisplayNone(true);
        div.getNinteiChosaHoshu().setDisplayNone(false);
        div.getChosaIraibi().setVisible(false);
        div.getNinteiChosaHoshu().setVisible(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件に戻る」ボタンのイベント処理です。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiDiv>
     */
    public ResponseData<NinteiChosaHoshuShokaiDiv> onClick_btnModoru(NinteiChosaHoshuShokaiDiv div) {
        return onLoad(div);
    }

    /**
     * 「CSVを出力する」ボタン押下場合、"1"を設定します。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiDiv>
     */
    public ResponseData<NinteiChosaHoshuShokaiDiv> onClick_btnShutsutyoku(NinteiChosaHoshuShokaiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧表を発行する」ボタン押下場合、"1"を設定します。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiDiv>
     */
    public ResponseData<NinteiChosaHoshuShokaiDiv> onClick_btnPulish(NinteiChosaHoshuShokaiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータの設定します。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiFlowParameter>
     */
    public ResponseData<NinteiChosaHoshuShokaiFlowParameter> getParameterToCSV(NinteiChosaHoshuShokaiDiv div) {
        NinteiChosaHoshuShokaiFlowParameter tempData = getHandler(div).getTempData(new RString("1"));
        return ResponseData.of(tempData).respond();
    }

    /**
     * バッチパラメータの設定します。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiFlowParameter>
     */
    public ResponseData<NinteiChosaHoshuShokaiFlowParameter> getParameter(NinteiChosaHoshuShokaiDiv div) {
        NinteiChosaHoshuShokaiFlowParameter tempData = getHandler(div).getTempData(new RString("2"));
        return ResponseData.of(tempData).respond();
    }

    /**
     * 「条件をクリアする」ボタン押下場合、検索条件をクリアします。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     * @return ResponseData<NinteiChosaHoshuShokaiDiv>
     */
    public ResponseData<NinteiChosaHoshuShokaiDiv> onClick_btnKensakuClear(NinteiChosaHoshuShokaiDiv div) {
        div.getChosaIraibi().getTxtChosaIraibi().setFromValue(null);
        div.getChosaIraibi().getTxtChosaIraibi().setToValue(null);
        return onLoad(div);
    }

    private NinteiChosaHoshuShokaiValidationHandler getValidationHandler(NinteiChosaHoshuShokaiDiv div) {
        return new NinteiChosaHoshuShokaiValidationHandler(div);
    }

    private NinteiChosaHoshuShokaiHandler getHandler(NinteiChosaHoshuShokaiDiv div) {
        return new NinteiChosaHoshuShokaiHandler(div);
    }
}
