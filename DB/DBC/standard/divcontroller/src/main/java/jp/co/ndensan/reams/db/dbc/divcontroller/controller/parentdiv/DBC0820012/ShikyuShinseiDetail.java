/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820012;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.DBC0820012StateName.削除モード;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.DBC0820012StateName.登録修正モード;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.DBC0820012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.ShikyuShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820012.ShikyuShinseiDetailHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820012.ShikyuShinseiDetailValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820012.ShikyuShinseiDetailParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払支給申請の支給申請を登録する画面Controllerです。
 *
 * @reamsid_L DBC-1030-160 xupeng
 */
public class ShikyuShinseiDetail {

    private static final RString MODEL_ADD = new RString("新規");
    private static final RString MODEL_UPD = new RString("修正");
    private static final RString MODEL_DEL = new RString("削除");
    private static final RString メッセージ_登録 = new RString("登録");
    private static final RString メッセージ_更新 = new RString("更新");
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final RString 申請を削除する = new RString("btnDelete");
    private static final RString 確認 = new RString("確認");

    /**
     * 画面初期化処理です。
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div。
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onLoad(ShikyuShinseiDetailDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (メッセージ_登録.equals(画面モード) || MODEL_ADD.equals(画面モード)) {
            画面モード = MODEL_ADD;
        }
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);

        ShikyuShinseiDetailHandler handler = getHandler(div);
        handler.load介護宛名情報(識別コード);
        handler.load介護資格系基本情報(識別コード);
        RString config = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        ShokanShinsei 償還払支給申請 = handler.load支給申請一覧情報(被保険者番号, サービス年月, 整理番号, 画面モード, config);
        ViewStateHolder.put(ViewStateKeys.詳細データ, 償還払支給申請);
        if (!MODEL_ADD.equals(画面モード)) {
            handler.set支給申請一覧情報(被保険者番号, サービス年月, 整理番号, 画面モード, 償還払支給申請, config);
        }

        if (!MODEL_DEL.equals(画面モード)) {
            return ResponseData.of(div).setState(登録修正モード);
        } else {
            return ResponseData.of(div).setState(削除モード);
        }
    }

    /**
     * 保存処理です。
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnUpdate(ShikyuShinseiDetailDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (メッセージ_登録.equals(画面モード) || MODEL_ADD.equals(画面モード)) {
            画面モード = MODEL_ADD;
        }
        try {
            if (MODEL_ADD.equals(画面モード)) {
                boolean flag = getHandler(div).is変更あり_ADD();
                if (!flag) {
                    return isChange(div);
                } else {
                    return setAdd(div, 画面モード);
                }
            } else if (MODEL_UPD.equals(画面モード)) {
                ShokanShinsei 償還払支給申請 = ViewStateHolder.get(ViewStateKeys.詳細データ, ShokanShinsei.class);
                boolean flag = getHandler(div).is変更あり(償還払支給申請);
                if (!flag) {
                    return isChange(div);
                } else {
                    return setUpd(div, 画面モード);
                }
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 削除処理です。
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnDelete(ShikyuShinseiDetailDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
                boolean flag = getHandler(div).delete(識別コード);
                if (flag) {
                    return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                            replace(MODEL_DEL.toString())).respond();
                }
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除する, true);
                return ResponseData.of(div).respond();
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ShikyuShinseiDetailDiv> setAdd(ShikyuShinseiDetailDiv div, RString 画面モード) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor支払金額合計未入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        ValidationMessageControlPairs valid = getValidationHandler(div).validateFor支払金額合計整合性チェック();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        ShokanShinsei 償還払支給申請 = ViewStateHolder.get(ViewStateKeys.詳細データ, ShokanShinsei.class);
        if (!ResponseHolder.isReRequest()) {
            RString 新整理番号 = getHandler(div).insert(画面モード, 償還払支給申請);
            if (null != 新整理番号 && !新整理番号.isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                        replace(メッセージ_登録.toString())).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ShikyuShinseiDetailDiv> setUpd(ShikyuShinseiDetailDiv div, RString 画面モード) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor支払金額合計未入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        ValidationMessageControlPairs valid = new ValidationMessageControlPairs();
        if (!ResponseHolder.isWarningIgnoredRequest() && !div.getCheckFlag().equals(確認)) {
            valid = getValidationHandler(div).validateFor支払金額合計整合性チェック();
        }
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }

        ShokanShinsei 償還払支給申請 = ViewStateHolder.get(ViewStateKeys.詳細データ, ShokanShinsei.class);
        if (!new RString(UrInformationMessages.正常終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            div.setCheckFlag(確認);
            boolean flag = getHandler(div).update(画面モード, 償還払支給申請);
            if (flag) {
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                        replace(メッセージ_更新.toString())).respond();
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
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikyuShinseiDetailParameter parameter = getHandler(div).btnCancel_SetParameter();
        RString 処理モード = parameter.get処理モード();
        if (MODEL_DEL.equals(処理モード)) {
            ViewStateHolder.put(ViewStateKeys.被保険者番号, 引継ぎデータ.get被保険者番号());
            ViewStateHolder.put(ViewStateKeys.サービス年月, parameter.getサービス提供年月().toDateString());
            ViewStateHolder.put(ViewStateKeys.整理番号, parameter.get整理番号());
            return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.一覧に戻る).respond();
        }
        boolean flag;
        if (MODEL_ADD.equals(処理モード)) {
            flag = getHandler(div).is変更あり_ADD();
        } else {
            ShokanShinsei 償還払支給申請 = ViewStateHolder.get(ViewStateKeys.詳細データ, ShokanShinsei.class);
            flag = getHandler(div).is変更あり(償還払支給申請);
        }
        if (flag) {
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
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 引継ぎデータ.get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.サービス年月, parameter.getサービス提供年月().toDateString());
        ViewStateHolder.put(ViewStateKeys.整理番号, parameter.get整理番号());
        return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「口座情報」ボタン処理
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnKouzaInfo(ShikyuShinseiDetailDiv div) {
        ValidationMessageControlPairs validPairs = 申請既存チェック(div);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.口座情報).respond();
    }

    /**
     * 「サービス提供証明書」ボタン処理
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnServerteikyoShomeisyo(ShikyuShinseiDetailDiv div) {
        ValidationMessageControlPairs validPairs = 申請既存チェック(div);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.サービス提供証明書).respond();
    }

    /**
     * 「償還払決定情報」ボタン処理
     *
     * @param div 償還払支給申請の支給申請を登録する画面Div
     * @return ResponseData<ShikyuShinseiDetailDiv>
     */
    public ResponseData<ShikyuShinseiDetailDiv> onClick_btnShokanBaraiKeteiInfo(ShikyuShinseiDetailDiv div) {
        ValidationMessageControlPairs validPairs = 申請既存チェック(div);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820012TransitionEventName.償還払決定情報).respond();
    }

    private void putViewState(ShikyuShinseiDetailDiv div) {
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikyuShinseiDetailParameter parameter = getHandler(div).setParameter();
        ViewStateHolder.put(ViewStateKeys.画面モード, parameter.get処理モード());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 引継ぎデータ.get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.サービス年月, parameter.getサービス提供年月().toDateString());
        ViewStateHolder.put(ViewStateKeys.整理番号, parameter.get整理番号());
        ViewStateHolder.put(ViewStateKeys.申請日, parameter.get申請日());
        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = new ShoukanharaihishinseikensakuParameter(
                引継ぎデータ.get被保険者番号(),
                new FlexibleYearMonth(parameter.getサービス提供年月().toString()),
                parameter.get整理番号(), null,
                null, null, null);
        ViewStateHolder.put(ViewStateKeys.検索キー, 償還払費申請検索);
    }

    private ValidationMessageControlPairs 申請既存チェック(ShikyuShinseiDetailDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ShikyuShinseiDetailValidationHandler validationHandler = getValidationHandler(div);
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (!メッセージ_登録.equals(画面モード) && !MODEL_ADD.equals(画面モード)) {
            TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
            FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                    ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                    toString())).getYearMonth().toDateString());
            RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
            List<ShokanShinsei> 支給申請一覧情報リスト = InstanceProvider.create(ShokanbaraiJyokyoShokai.class)
                    .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
            if (支給申請一覧情報リスト.isEmpty()) {
                validPairs = validationHandler.validateFor申請既存チェック(null);
            }
        } else {
            validPairs = validationHandler.validateFor申請既存チェック(null);
        }
        return validPairs;
    }

    private ShikyuShinseiDetailHandler getHandler(ShikyuShinseiDetailDiv div) {
        return ShikyuShinseiDetailHandler.of(div);
    }

    private ShikyuShinseiDetailValidationHandler getValidationHandler(ShikyuShinseiDetailDiv div) {
        return new ShikyuShinseiDetailValidationHandler(div);
    }
}
