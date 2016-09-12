/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820013;

import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.DBC0820013StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.DBC0820013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.KouzaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820013.KouzaInfoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_口座情報のクラスです。
 *
 * @reamsid_L DBC-1030-150 gongliang
 */
public class KouzaInfoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 新規 = new RString("新規");
    private static final RString 参照 = new RString("参照");
    private static final RString 更新 = new RString("更新");
    private static final RString 照会モード = new RString("照会");
    private static final RString 申請を保存ボタン = new RString("btnUpdate");
    private static final RString 申請を削除する = new RString("btnDelete");

    /**
     * 画面初期化onLoadメソッドです。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払い費支給申請決定_口座情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onLoad(KouzaInfoPanelDiv div) {

        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);

        KouzaInfoHandler handler = getHandler(div);
        ShokanShinsei 支給申請情報 = handler.get償還払支給申請(被保険者番号, サービス年月, 整理番号);
        ViewStateHolder.put(ViewStateKeys.詳細データ, 支給申請情報);
        ViewStateHolder.put(ViewStateKeys.口座情報, 支給申請情報);
        handler.loadヘッダエリア(識別コード, 被保険者番号);
        if (登録.equals(画面モード)) {
            handler.load登録(被保険者番号, サービス年月, 整理番号, 支給申請情報.is国保連再送付フラグ());
            handler.load申請共通エリア(null, null, 新規);
        } else if (修正.equals(画面モード)) {
            handler.load申請共通エリア(サービス年月, 整理番号, 修正);
        } else if (削除.equals(画面モード)) {
            handler.load申請共通エリア(サービス年月, 整理番号, 参照);
        }
        SikyuSinseiJyohoParameter param = new SikyuSinseiJyohoParameter();
        param.setShikibetsuCode(識別コード);
        param.setHihokenshaNo(支給申請情報.get被保険者番号());
        param.setShikyushinseiServiceYM(支給申請情報.getサービス提供年月());
        param.setShikyushinseiSeiriNo(支給申請情報.get整理番号());
        param.setKeiyakuNo(支給申請情報.get受領委任契約番号());
        RString 支払方法区分コード = 支給申請情報.get支払方法区分コード();
        if (支払方法区分コード != null && !支払方法区分コード.isEmpty()) {
            param.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(支給申請情報.get支払方法区分コード()));
        }
        if (支給申請情報.get支払期間開始年月日() != null) {
            param.setStartYMD(new RDate(支給申請情報.get支払期間開始年月日().toString()));
        }
        if (支給申請情報.get支払期間終了年月日() != null) {
            param.setEndYMD(new RDate(支給申請情報.get支払期間終了年月日().toString()));
        }
        RString 支払窓口開始時間 = 支給申請情報.get支払窓口開始時間();
        if (支払窓口開始時間 != null && !支払窓口開始時間.isEmpty()) {
            param.setStartHHMM(new RTime(支給申請情報.get支払窓口開始時間()));
        }
        RString 支払窓口終了時間 = 支給申請情報.get支払窓口終了時間();
        if (支払窓口終了時間 != null && !支払窓口終了時間.isEmpty()) {
            param.setEndHHMM(new RTime(支給申請情報.get支払窓口終了時間()));
        }
        param.setKozaId(支給申請情報.get口座ID());
        param.setShiharaiBasho(支給申請情報.get支払場所());
        if (削除.equals(画面モード)) {
            div.getPnlCommon().getCcdShinseiNaiyo().initialize(param, 照会モード);
            return ResponseData.of(div).setState(DBC0820013StateName.削除モード);
        } else {
            div.getPnlCommon().getCcdShinseiNaiyo().initialize(param, 画面モード);
            return ResponseData.of(div).setState(DBC0820013StateName.登録修正モード);
        }
    }

    /**
     * 「申請情報」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払支給申請_支給申請画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnShinseiInfo(KouzaInfoPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (登録.equals(画面モード)) {
            setViewState(修正);
        } else {
            setViewState(画面モード);
        }
        return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.申請情報).respond();
    }

    /**
     * 「サービス提供証明書」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払支給申請_サービス提供証明書画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnServiceTeikyoShomeisyo(KouzaInfoPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).申請既存チェック(整理番号, サービス年月, 被保険者番号);
        setViewState(画面モード);
        return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.サービス提供証明書).respond();
    }

    /**
     * 「償還払決定情報」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払支給申請_償還払決定情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnShokanbaraiKeiteInfo(KouzaInfoPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).申請既存チェック(整理番号, サービス年月, 被保険者番号);
        setViewState(画面モード);
        return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.償還払決定情報).respond();
    }

    /**
     * 「一覧へ戻る」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払支給申請一覧画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_commonButtonFree(KouzaInfoPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (削除.equals(画面モード)) {
            // TODO パラメータ：viewStateの保険者番号  viewStateの申請一覧検索キー
            return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.一覧に戻る).respond();
        }
        ShokanShinsei entityView = ViewStateHolder.get(ViewStateKeys.口座情報, ShokanShinsei.class);
        Boolean 変更有無チェック = getHandler(div).変更有無チェック(entityView);
        if (!変更有無チェック) {
            return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.一覧に戻る).respond();
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.一覧に戻る).respond();
            }
        }
        return createResponse(div);
    }

    /**
     * 「申請を保存する」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払い費支給申請決定_口座情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnSave(KouzaInfoPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (修正.equals(画面モード)) {
            画面モード = 更新;
        }
        ShokanShinsei entityView = ViewStateHolder.get(ViewStateKeys.口座情報, ShokanShinsei.class);
        Boolean 変更有無チェック = getHandler(div).変更有無チェック(entityView);
        if (!変更有無チェック) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return createResponse(div);
            }
            return createResponse(div);
        }
        try {
            if (!ResponseHolder.isReRequest()) {
                RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
                FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                        ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                        toString())).getYearMonth().toDateString());
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
                getHandler(div).保存_修正(entityView, 整理番号, サービス年月, 被保険者番号);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存ボタン, true);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(画面モード.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return createResponse(div);
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return createResponse(div);
    }

    /**
     * 「申請を削除する」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払い費支給申請決定_口座情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnDelete(KouzaInfoPanelDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
                ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
                FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                        ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                        toString())).getYearMonth().toDateString());
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
                getHandler(div).保存_削除(整理番号, 識別コード, サービス年月, 被保険者番号);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除する, true);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return createResponse(div);
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return createResponse(div);
    }

    private void setViewState(RString 画面モード) {
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShoukanharaihishinseikensakuParameter parameter = new ShoukanharaihishinseikensakuParameter(
                被保険者番号, サービス年月, 整理番号, null, null, null, null);
        ViewStateHolder.put(ViewStateKeys.申請検索キー, parameter);
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
    }

    private KouzaInfoHandler getHandler(KouzaInfoPanelDiv div) {
        return new KouzaInfoHandler(div);
    }

    private ResponseData<KouzaInfoPanelDiv> createResponse(KouzaInfoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
