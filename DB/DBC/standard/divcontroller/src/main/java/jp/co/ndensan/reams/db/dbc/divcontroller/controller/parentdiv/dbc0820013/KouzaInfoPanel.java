/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820013;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.DBC0820013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.KouzaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820013.KouzaInfoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_口座情報のクラスです。
 */
public class KouzaInfoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 新規 = new RString("新規");
    private static final RString 参照 = new RString("参照");
    private static final RString 申請を保存ボタン = new RString("Element3");

    /**
     * 画面初期化onLoad
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払い費支給申請決定_口座情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onLoad(KouzaInfoPanelDiv div) {

        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000003"), new FlexibleYearMonth(new RString("201601")),
                new RString("123123"), new JigyoshaNo("0000000003"), new RString("事業者名"),
                new RString("0003"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);

        List<ShokanShinsei> entityList = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_口座情報, (Serializable) entityList);
        KouzaInfoHandler handler = getHandler(div);
        handler.loadヘッダエリア(識別コード, 被保険者番号);
        if (登録.equals(状態)) {
            // TODO コンフィグ判断
//          RString config = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
            ShokanHanteiKekka shokanHanteiKekka = SyokanbaraihiShikyuShinseiKetteManager
                    .createInstance().getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
            if (shokanHanteiKekka == null) {
                div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(true);
            }
            handler.load申請共通エリア(null, null, 新規);
        }
        if (修正.equals(状態)) {
            ShokanShinsei 償還払支給申請 = entityList.get(0);
            handler.load申請共通エリア(償還払支給申請.getサービス提供年月(), 償還払支給申請.get整理番号(), new RString("修正"));
        }
        if (削除.equals(状態)) {
            handler.load申請共通エリア(null, null, 参照);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(申請を保存ボタン, false);
        }
        // TODO 支払方法情報共有DIV 初期化  空白
//            div.getCcdShinseiNaiyo().load(修正, new RString("001"));
        return createResponse(div);
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
     * 「取消する」ボタンを押下した際に実行します。
     *
     * @param div KouzaInfoPanelDiv
     * @return 償還払い費支給申請決定_口座情報画面
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_commonButtonFree(KouzaInfoPanelDiv div) {
        Boolean 変更有無チェック = getHandler(div).変更有無チェック();
        if (!変更有無チェック) {
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
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (削除.equals(状態)) {
            getHandler(div).保存_削除();
        } else {
            // TODO #76941 再提出
            Boolean 変更有無チェック = getHandler(div).変更有無チェック();
            if (!変更有無チェック) {
                return saveOut(div);
            } else {
                return 保存処理(div, 状態);
            }
        }
        return createResponse(div);
    }

    private ResponseData<KouzaInfoPanelDiv> 保存処理(KouzaInfoPanelDiv div, RString 状態) {
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).保存_削除();
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(状態.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存ボタン, true);
            return createResponse(div);
        }
        return ResponseData.of(div).addMessage(UrErrorMessages.異常終了.getMessage()).respond();
    }

    private ResponseData<KouzaInfoPanelDiv> saveOut(KouzaInfoPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    private KouzaInfoHandler getHandler(KouzaInfoPanelDiv div) {
        return new KouzaInfoHandler(div);
    }

    private ResponseData<KouzaInfoPanelDiv> createResponse(KouzaInfoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
