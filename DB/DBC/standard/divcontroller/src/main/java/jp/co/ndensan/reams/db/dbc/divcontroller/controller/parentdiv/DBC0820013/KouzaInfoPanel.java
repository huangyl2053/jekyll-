/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820013;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.DBC0820013StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.DBC0820013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.KouzaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820013.KouzaInfoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820012.ShikyuShinseiDetailParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
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
    private static final RString 申請を保存ボタン = new RString("btnUpdate");
    private static final RString 申請を削除する = new RString("btnDelete");

    /**
     * 画面初期化onLoadメソッドです。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払い費支給申請決定_口座情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onLoad(KouzaInfoPanelDiv div) {

        // TODO うそのデータ
        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000003"), new FlexibleYearMonth(new RString("201601")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("事業者名"),
                new RString("0003"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.処理モード, 登録);
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);

        KouzaInfoHandler handler = getHandler(div);
        ShokanShinsei 支給申請情報 = handler.get償還払支給申請(被保険者番号, サービス年月, 整理番号);
        ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_口座情報, 支給申請情報);
        handler.loadヘッダエリア(識別コード, 被保険者番号);
        if (登録.equals(状態)) {
            handler.load登録(被保険者番号, サービス年月, 整理番号, 支給申請情報.is国保連再送付フラグ());
            handler.load申請共通エリア(null, null, 新規);
        } else if (修正.equals(状態)) {
            handler.load申請共通エリア(支給申請情報.getサービス提供年月(), 支給申請情報.get整理番号(), 修正);
        } else if (削除.equals(状態)) {
            handler.load申請共通エリア(null, null, 参照);
        }
        SikyuSinseiJyohoParameter param = new SikyuSinseiJyohoParameter();
        param.setShikibetsuCode(識別コード);
        param.setHihokenshaNo(支給申請情報.get被保険者番号());
        param.setShikyushinseiServiceYM(支給申請情報.getサービス提供年月());
        param.setShikyushinseiSeiriNo(支給申請情報.get整理番号());
        param.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(支給申請情報.get支払方法区分コード()));
        param.setKeiyakuNo(支給申請情報.get受領委任契約番号());
        if (支給申請情報.get支払期間開始年月日() != null) {
            param.setStartYMD(new RDate(支給申請情報.get支払期間開始年月日().toString()));
        }
        if (支給申請情報.get支払期間終了年月日() != null) {
            param.setEndYMD(new RDate(支給申請情報.get支払期間終了年月日().toString()));
        }
        param.setStartHHMM(new RTime(支給申請情報.get支払窓口開始時間()));
        param.setEndHHMM(new RTime(支給申請情報.get支払窓口終了時間()));
        param.setKozaId(支給申請情報.get口座ID());
        param.setShiharaiBasho(支給申請情報.get支払場所());
        if (削除.equals(状態)) {
            div.getPnlCommon().getCcdShinseiNaiyo().initialize(param, 参照);
            return ResponseData.of(div).setState(DBC0820013StateName.削除モード);
        } else {
            div.getPnlCommon().getCcdShinseiNaiyo().initialize(param, 修正);
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
        getHandler(div).onClick_btnShinseiInfo();
        return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.申請情報).respond();
    }

    /**
     * 「サービス提供証明書」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払支給申請_サービス提供証明書画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnServiceTeikyoShomeisyo(KouzaInfoPanelDiv div) {
        getHandler(div).申請既存チェック();
        getHandler(div).onClick_btnServiceTeikyoShomeisyo();
        return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.サービス提供証明書).respond();
    }

    /**
     * 「償還払決定情報」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払支給申請_償還払決定情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnShokanbaraiKeiteInfo(KouzaInfoPanelDiv div) {
        getHandler(div).申請既存チェック();
        getHandler(div).onClick_btnShokanbaraiKeiteInfo();
        return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.償還払決定情報).respond();
    }

    /**
     * 「一覧へ戻る」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払支給申請一覧画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_commonButtonFree(KouzaInfoPanelDiv div) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (削除.equals(処理モード)) {
            // TODO パラメータ：viewStateの保険者番号  viewStateの申請一覧検索キー
            return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.一覧に戻る).respond();
        }
        Boolean 変更有無チェック = getHandler(div).変更有無チェック();
        ShikyuShinseiDetailParameter 償還払費申請検索キー = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShikyuShinseiDetailParameter.class);
        HihokenshaNo 被保険者番号 = 償還払費申請検索キー.getHiHokenshaNo();
        if (!変更有無チェック) {
            ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
            // TODO パラメータ：viewStateの保険者番号  viewStateの申請一覧検索キー
            return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.一覧に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            // TODO パラメータ：viewStateの保険者番号  viewStateの申請一覧検索キー
            return ResponseData.of(div).forwardWithEventName(DBC0820013TransitionEventName.申請情報).respond();
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
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        Boolean 変更有無チェック = getHandler(div).変更有無チェック();
        if (!変更有無チェック) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return createResponse(div);
            }
            return createResponse(div);
        }
        getHandler(div).保存_修正();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存ボタン, true);
        return 保存処理(div, 処理モード);
    }

    /**
     * 「申請を削除する」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払い費支給申請決定_口座情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnDelete(KouzaInfoPanelDiv div) {
        getHandler(div).保存_削除();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除する, true);
        return 保存処理(div, 削除);
    }

    private ResponseData<KouzaInfoPanelDiv> 保存処理(KouzaInfoPanelDiv div, RString 状態) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(状態.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return ResponseData.of(div).addMessage(UrErrorMessages.異常終了.getMessage().replace(状態.toString())).respond();
    }

    private KouzaInfoHandler getHandler(KouzaInfoPanelDiv div) {
        return new KouzaInfoHandler(div);
    }

    private ResponseData<KouzaInfoPanelDiv> createResponse(KouzaInfoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
