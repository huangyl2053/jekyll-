/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.DBC0820012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.ShikyuShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820012.ShikyuShinseiDetailHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820012.ShikyuShinseiDetailValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820012.ShikyuShinseiDetailParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払支給申請の支給申請を登録する画面Controllerです。
 */
public class ShikyuShinseiDetail {

    private static final RString MODEL_ADD = new RString("新規");
    private static final RString MODEL_UPD = new RString("修正");
    private static final RString MODEL_DEL = new RString("削除");
    private static final RString 申請を保存する = new RString("btnUpdate");

    /**
     * 画面初期化処理です。
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div。
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onLoad(ShikyuShinseiDetailDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理モード, MODEL_UPD);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);

        ShikyuShinseiDetailParameter parameter = new ShikyuShinseiDetailParameter(new HihokenshaNo("000000003"),
                new FlexibleYearMonth(new RString("201601")), new RString("0000000004"));
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, parameter);

        ShikyuShinseiDetailParameter 償還払費申請検索キー = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShikyuShinseiDetailParameter.class);
        HihokenshaNo 被保険者番号 = 償還払費申請検索キー.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = 償還払費申請検索キー.getServiceTeikyoYM();
        RString 整理番号 = 償還払費申請検索キー.getSeiriNo();

        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);

        ShikyuShinseiDetailHandler handler = getHandler(div);
        handler.load介護宛名情報(識別コード);
        handler.load介護資格系基本情報(識別コード);
        handler.load支給申請一覧情報(被保険者番号, サービス年月, 整理番号, 処理モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 保存処理です。
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_Save(ShikyuShinseiDetailDiv div) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);

        ValidationMessageControlPairs valid = getValidationHandler(div).validateFor支払金額合計整合性チェック();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }

        if (MODEL_DEL.equals(処理モード)) {
            return setDel(div, 処理モード);
        } else if (MODEL_ADD.equals(処理モード)) {
            boolean flag = getHandler(div).is変更あり2();
            if (!flag) {
                return isChange(div);
            } else {
                return setAdd(div, 処理モード);
            }
        } else if (MODEL_UPD.equals(処理モード)) {
            //TODO hasChange調査の中
//            boolean flag = getHandler(div).is変更あり(被保険者番号, サービス年月, 整理番号);
            boolean flag = true;
            if (!flag) {
                return isChange(div);
            } else {
                return setUpd(div, 処理モード);
            }
        }
        return ResponseData.of(div).addMessage(UrErrorMessages.異常終了.getMessage()).respond();
    }

    private ResponseData<ShikyuShinseiDetailDiv> setAdd(ShikyuShinseiDetailDiv div, RString 処理モード) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor支払金額合計未入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            RString 新整理番号 = getHandler(div).insert(処理モード);
            if (null != 新整理番号 && !新整理番号.isEmpty()) {
                div.getPanelHead().getTxtSeiribango().setValue(新整理番号);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                        replace(new RString("登録").toString())).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ShikyuShinseiDetailDiv> setUpd(ShikyuShinseiDetailDiv div, RString 処理モード) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor支払金額合計未入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            boolean flag = getHandler(div).update(処理モード);
            if (flag) {
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                        replace(new RString("更新").toString())).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ShikyuShinseiDetailDiv> setDel(ShikyuShinseiDetailDiv div, RString 処理モード) {
        if (!ResponseHolder.isReRequest()) {
            boolean flag = getHandler(div).delete(処理モード);
            if (flag) {
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                        replace(new RString("削除").toString())).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ShikyuShinseiDetailDiv> isChange(ShikyuShinseiDetailDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消する」ボタンの処理です。
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnCancel(ShikyuShinseiDetailDiv div) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ShikyuShinseiDetailParameter 償還払費申請検索キー = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShikyuShinseiDetailParameter.class);
        HihokenshaNo 被保険者番号 = 償還払費申請検索キー.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(
                ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        if (MODEL_DEL.equals(処理モード)) {
            ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
            //TODO 申請一覧検索キー QA内部番号314
            return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.一覧に戻る).respond();
        }
        ShikyuShinseiDetailHandler handler = getHandler(div);
        if (handler.is変更あり(被保険者番号, サービス年月, 整理番号)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.一覧に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        //TODO 申請一覧検索キー QA内部番号314
        return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「口座情報」ボタン処理
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnKouzaInfo(ShikyuShinseiDetailDiv div) {
        ShikyuShinseiDetailValidationHandler validationHandler = getValidationHandler(div);
        ValidationMessageControlPairs validPairs = validationHandler.validateFor申請既存チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.口座情報へ).respond();
    }

    /**
     * 「サービス提供証明書」ボタン処理
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnServerteikyoShomeisyo(ShikyuShinseiDetailDiv div) {
        ShikyuShinseiDetailValidationHandler validationHandler = getValidationHandler(div);
        ValidationMessageControlPairs validPairs = validationHandler.validateFor申請既存チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.サービスへ).respond();
    }

    /**
     * 「償還払決定情報」ボタン処理
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnShokanBaraiKeteiInfo(ShikyuShinseiDetailDiv div) {
        ShikyuShinseiDetailValidationHandler validationHandler = getValidationHandler(div);
        ValidationMessageControlPairs validPairs = validationHandler.validateFor申請既存チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.決定情報へ).respond();
    }

    private ShikyuShinseiDetailHandler getHandler(ShikyuShinseiDetailDiv div) {
        return ShikyuShinseiDetailHandler.of(div);
    }

    private ShikyuShinseiDetailValidationHandler getValidationHandler(ShikyuShinseiDetailDiv div) {
        return new ShikyuShinseiDetailValidationHandler(div);
    }
}
