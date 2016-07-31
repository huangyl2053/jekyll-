/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6040001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsahoshuichiran.ShinsaHoshuIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsahoshuichiran.ShinsaHoshuIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001.ShinsakauIinHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6040001.ShinsakauIinHoshuShokaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6040001.ShinsakauIinHoshuShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsahoshushokai.ShinsakauIinHoshuShokaiFindler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査会委員報酬照会の画面処理クラスです。
 *
 * @reamsid_L DBE-1920-010 zhaoyao
 */
public class ShinsakauIinHoshuShokai {

    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakauIinHoshuShokaiDiv>
     */
    public ResponseData<ShinsakauIinHoshuShokaiDiv> onLoad(ShinsakauIinHoshuShokaiDiv div) {
        div.getTxtShinsakaiKaisaiYM().clearValue();
        getHandler(div).set初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakauIinHoshuShokaiDiv>
     */
    public ResponseData<ShinsakauIinHoshuShokaiDiv> onClick_btnBackToKensaku(ShinsakauIinHoshuShokaiDiv div) {
        this.getHandler(div).set初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakauIinHoshuShokaiDiv>
     */
    public ResponseData<ShinsakauIinHoshuShokaiDiv> onClick_BtnKensaku(ShinsakauIinHoshuShokaiDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor必須引数();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        ShinsaHoshuIchiranMybitisParamter paramter = ShinsaHoshuIchiranMybitisParamter.createParamter(
                new RString(div.getTxtShinsakaiKaisaiYM().getValue().getYearMonth().toString()));

        getHandler(div).onClick_BtnKensaku(ShinsakauIinHoshuShokaiFindler.createInstance().get審査会委員報酬照会(paramter).records());
        getHandler(div).set一覧状態();

        if (div.getDgShinsakaiIinHoshu().getDataSource().isEmpty()) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnPulish"), false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnShutsutyoku"), false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSVを出力する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsaHoshuIchiranBatchParameter>
     */
    public ResponseData<ShinsaHoshuIchiranBatchParameter> onClick_BtnShutsutyoku(ShinsakauIinHoshuShokaiDiv div) {
        ShinsaHoshuIchiranBatchParameter paramter = getHandler(div).createBatchParam(CSVを出力する);
        return ResponseData.of(paramter).respond();
    }

    /**
     * 「集計表を発行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsaHoshuIchiranBatchParameter>
     */
    public ResponseData<ShinsaHoshuIchiranBatchParameter> onClick_BtnPulish(ShinsakauIinHoshuShokaiDiv div) {
        ShinsaHoshuIchiranBatchParameter paramter = getHandler(div).createBatchParam(一覧表を発行する);
        return ResponseData.of(paramter).respond();
    }

    /**
     * ShinsakauIinHoshuShokaiHandlerの取得する。
     *
     * @param div
     * @return ShinsakauIinHoshuShokaiHandler
     */
    private ShinsakauIinHoshuShokaiHandler getHandler(ShinsakauIinHoshuShokaiDiv div) {
        return new ShinsakauIinHoshuShokaiHandler(div);
    }

    /**
     * ShinsakauIinHoshuShokaiValidationHandlerrの取得する。
     *
     * @param div
     * @return ShinsakauIinHoshuShokaiValidationHandler
     */
    private ShinsakauIinHoshuShokaiValidationHandler getValidationHandler(ShinsakauIinHoshuShokaiDiv div) {
        return new ShinsakauIinHoshuShokaiValidationHandler(div);
    }
}
