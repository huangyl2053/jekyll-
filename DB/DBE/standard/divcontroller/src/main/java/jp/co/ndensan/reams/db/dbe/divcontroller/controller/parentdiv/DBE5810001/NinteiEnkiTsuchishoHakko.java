/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5810001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE581001.DBE581001_EnkitsuchiParameter;
import static jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001.DBE5810001StateName.完了;
import static jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001.DBE5810001StateName.検索;
import static jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001.DBE5810001StateName.通知書;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001.NinteiEnkiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5810001.NinteiEnkiTsuchishoHakkoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5810001.NinteiEnkiTsuchishoHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoDbT5101Child;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定延期通知発行画面のDivControllerです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
public class NinteiEnkiTsuchishoHakko {

    private final RString グループコード = new RString("1007");
    private final RString 一覧表を発行する_FileName = new RString("btnPrint1");
    private final RString 変更フラグ_変更 = new RString("1");

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onLoad(NinteiEnkiTsuchishoHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(検索);
    }

    /**
     * 「条件をクリアする」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnClear(NinteiEnkiTsuchishoHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnSearch(NinteiEnkiTsuchishoHakkoDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(一覧表を発行する_FileName, true);
        
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        NinteiEnkiTsuchishoHakkoValidationHandler validationHandler = getValidationHandler();
        validationHandler.申請区分の未入力チェック(pairs, div);
        validationHandler.発行有無の未入力チェック(pairs, div);
        validationHandler.経過日数の未入力チェック(pairs, div);
        validationHandler.終了日が開始日以前チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        div.getDgHakkotaishosha().getGridSetting().setLimitRowCount(div.getTxtMaxDisp().getValue().intValue());
        NinteiEnkiTsuchishoHakkoHandler handler = getHandler(div);
        List<NinteiEnkiTsuchishoHakkoBusiness> 発行対象者一覧情報 = handler.発行対象者一覧情報取得();
        if (発行対象者一覧情報.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        handler.通知書モード表示(発行対象者一覧情報);
        List<NinteiShinseiJohoDbT5101Child> 要介護認定申請情報 = handler.get要介護認定申請情報(発行対象者一覧情報);
        ArrayList<NinteiShinseiJohoDbT5101Child> 要介護認定申請情報ArrayList = new ArrayList<>(要介護認定申請情報);
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報List, 要介護認定申請情報ArrayList);
        ViewStateHolder.put(ViewStateKeys.認定延期通知書, RString.EMPTY);
        return ResponseData.of(div).setState(通知書);
    }

    /**
     * 「選択した対象者に延期理由をセットする」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnSetting(NinteiEnkiTsuchishoHakkoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        NinteiEnkiTsuchishoHakkoValidationHandler validationHandler = getValidationHandler();
        validationHandler.対象行を選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).対象行延期理由のセット();
        ViewStateHolder.put(ViewStateKeys.認定延期通知書, 変更フラグ_変更);
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の「チェックボックス」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnOnSelected(NinteiEnkiTsuchishoHakkoDiv div) {
        getHandler(div).選択状態の制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 「延期内容をクリアする」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnInputClear(NinteiEnkiTsuchishoHakkoDiv div) {
        getHandler(div).延期内容クリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 「延期内容を更新する」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnUpdate(NinteiEnkiTsuchishoHakkoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        NinteiEnkiTsuchishoHakkoValidationHandler validationHandler = getValidationHandler();
        validationHandler.延期決定日の未入力チェック(pairs, div);
        validationHandler.延期内容_処理見込み日の未入力チェック(pairs, div);
        validationHandler.通知書発行日の未入力チェック(pairs, div);
        validationHandler.延期内容_終了日が開始日以前チェック(pairs, div);
        validationHandler.対象行を選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).対象行延期内容の更新();
        ViewStateHolder.put(ViewStateKeys.認定延期通知書, 変更フラグ_変更);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件に戻る」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnBack(NinteiEnkiTsuchishoHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (ViewStateHolder.get(ViewStateKeys.認定延期通知書, RString.class).equals(変更フラグ_変更)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
            }
        }
        if (!new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes))) {
//            List<KeyValueDataSource> emptyDataSource = new ArrayList<>();
//            div.getDdlEnkiRiyuInput().setDataSource(emptyDataSource);
            div.getDdlEnkiRiyuInput().setSelectedIndex(0);
            div.getTxtnkiKetteiDate().clearValue();
            div.getTxtTsuchishoHakkoDate().clearValue();
            div.getTxtMikomiDateTsuchisho().clearFromValue();
            div.getTxtMikomiDateTsuchisho().clearToValue();
//            div.getBatchParameter().getEnkiTsuchiHakkoTaishosha().setHiddenUpdate(RString.EMPTY);
//            getHandler(div).onLoad();
            return ResponseData.of(div).setState(検索);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「延期内容を保存する」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnSave(NinteiEnkiTsuchishoHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            NinteiEnkiTsuchishoHakkoValidationHandler validationHandler = getValidationHandler();
            validationHandler.更新対象のデータがないチェック(pairs, div);
            validationHandler.整合性チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ArrayList<NinteiShinseiJohoDbT5101Child> 要介護認定申請情報ArrayList
                    = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報List, ArrayList.class);
            getHandler(div).更新処理(要介護認定申請情報ArrayList);
            ViewStateHolder.put(ViewStateKeys.認定延期通知書, RString.EMPTY);
            return ResponseData.of(div).setState(完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 印刷選択rad「一覧表を発行する」ボタンの制御です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onChange_radEnkiTsuchiHakkoIchiranhyo(NinteiEnkiTsuchishoHakkoDiv div) {
        getHandler(div).一覧表を発行するボタンの制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 「通知書を発行する」また「一覧表を発行する」ボタンの前処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> beforeOnClick_btnprint(NinteiEnkiTsuchishoHakkoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        NinteiEnkiTsuchishoHakkoValidationHandler validationHandler = getValidationHandler();
        if (通知書.getName().equals(ResponseHolder.getState())) {
            validationHandler.対象行を選択チェック(pairs, div);
            validationHandler.選択行発行日チェック(pairs, div);
            validationHandler.変更内容保存チェック(pairs, div);
        } else if (検索.getName().equals(ResponseHolder.getState())) {
            validationHandler.発行一覧表_終了日が開始日以前チェック(pairs, div);
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「通知書を発行する」また「一覧表を発行する」ボタンの処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<DBE581001_EnkitsuchiParameter> onClick_btnprint(NinteiEnkiTsuchishoHakkoDiv div) {
        return ResponseData.of(getHandler(div).getバッチパラメータ()).respond();
    }

    /**
     * 「発行対象者一覧に戻る」ボタンの前処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onClick_btnBack2(NinteiEnkiTsuchishoHakkoDiv div) {
        List<NinteiShinseiJohoDbT5101Child> 要介護認定申請情報 = getHandler(div).発行対象者一覧に戻るを表示();
        ArrayList<NinteiShinseiJohoDbT5101Child> 要介護認定申請情報ArrayList = new ArrayList<>(要介護認定申請情報);
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報List, 要介護認定申請情報ArrayList);
        return ResponseData.of(div).setState(通知書);
    }

    /**
     * 一覧の「延期理由」ボタンの前処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> beforeOpen_riyuselect(NinteiEnkiTsuchishoHakkoDiv div) {
        div.getEnkiTsuchiHakkoTaishosha().setHiddenGyomuCode(GyomuCode.DB介護保険.getColumnValue());
        div.getEnkiTsuchiHakkoTaishosha().setHiddenGroupCode(グループコード);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択した理由を該当行の延期理由へセットする処理です。
     *
     * @param div NinteiEnkiTsuchishoHakkoDiv
     * @return ResponseData<NinteiEnkiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiEnkiTsuchishoHakkoDiv> onOkClose_riyuselect(NinteiEnkiTsuchishoHakkoDiv div) {
        RString サンプル文書 = div.getEnkiTsuchiHakkoTaishosha().getHiddenTeikeibun();
        getHandler(div).onOkClose_riyuselect(サンプル文書);
        return ResponseData.of(div).respond();
    }

    private NinteiEnkiTsuchishoHakkoHandler getHandler(NinteiEnkiTsuchishoHakkoDiv div) {
        return new NinteiEnkiTsuchishoHakkoHandler(div);
    }

    private NinteiEnkiTsuchishoHakkoValidationHandler getValidationHandler() {
        return new NinteiEnkiTsuchishoHakkoValidationHandler();
    }

}
