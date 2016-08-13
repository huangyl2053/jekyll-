/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1000065;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.kijunshunyugakutekiyoshinseishohakkoichiran.DBC190030_KijunsyunygetsujiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.ShinseishoHakkoChushutsuJoken.ShinseishoHakkoChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065.DBC1000065TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065.ShinseishoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000065.ShinseishoTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000065.ShinseishoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 基準収入額適用申請書_異動分作成
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
public class ShinseishoToroku {

    private static final int INDEX_4 = 4;

    /**
     * 画面の初期化
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onLoad(ShinseishoTorokuDiv div) {
        getHandler(div).initialize(div);
        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタンを切り替えた時に、画面項目の表示を制御する
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onChange_RadChushutsuJoken(ShinseishoTorokuDiv div) {
        getHandler(div).set抽出条件表示制御処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタン押下時のイベントメソッドです。
     *
     * @param div DBZ0200001
     * @return ResponseData<DBZ0200001Div>
     */
    public ResponseData<ShinseishoTorokuDiv> onClick_Search(ShinseishoTorokuDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC1000065TransitionEventName.対象者検索).respond();
    }

    /**
     * 画面項目の被保険者番号に設定する
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onActive(ShinseishoTorokuDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        div.getTxtHihokenshaNo().setValue(資格対象者.get被保険者番号().getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 文書番号ccdを初期化する
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onChange_SakuseiYMD(ShinseishoTorokuDiv div) {
        getHandler(div).set文書番号();
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialog
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onBeforeOpenDialog(ShinseishoTorokuDiv div) {
        FlexibleYear 処理年度 = new FlexibleYear(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4));
        getHandler(div).set出力順の入力チェック();
        if (ShinseishoHakkoChushutsuJoken.異動分.getコード().equals(div.getRadChushutsuJoken().getSelectedKey()) && getHandler(div).処理年度判定()) {
            ValidationMessageControlPairs valid = getValidationHandler(div).処理年度チェックValidate();
            if (valid.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid).respond();
            }
        }
        if (ShinseishoHakkoChushutsuJoken.異動分.getコード().equals(div.getRadChushutsuJoken().getSelectedKey()) && getHandler(div).世帯員把握基準日判定()) {
            ValidationMessageControlPairs valid1 = getValidationHandler(div).世帯員把握基準日チェックValidate(処理年度);
            if (valid1.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid1).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).年次処理が実行済みか確認();
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「實行」ボタン押下時の処理
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<DBC190030_KijunsyunygetsujiParameter> onClick_btnExcute(ShinseishoTorokuDiv div) {
        getHandler(div).set前排他();
        DBC190030_KijunsyunygetsujiParameter parameter = getHandler(div).setバッチ(div);
        getHandler(div).release前排他();
        return ResponseData.of(parameter).respond();
    }

    private ShinseishoTorokuHandler getHandler(ShinseishoTorokuDiv div) {
        return new ShinseishoTorokuHandler(div);
    }

    private ShinseishoTorokuValidationHandler getValidationHandler(ShinseishoTorokuDiv div) {
        return new ShinseishoTorokuValidationHandler(div);
    }
}
