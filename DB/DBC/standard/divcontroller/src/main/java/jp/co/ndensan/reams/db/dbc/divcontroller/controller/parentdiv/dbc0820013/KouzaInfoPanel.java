/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820013;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014.DBC0810014TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.KouzaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820013.KouzaInfoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_口座情報のクラスです。
 *
 * @author きょう亮
 */
public class KouzaInfoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 新規 = new RString("新規");
    private static final RString 参照 = new RString("参照");
    private static final RString 申請を保存ボタン = new RString("Element3");

    public ResponseData<KouzaInfoPanelDiv> onLoad(KouzaInfoPanelDiv div) {

        // TODO 引き継ぎデータの取得
        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000003"),
                new FlexibleYearMonth(new RString("201601")),
                new RString("0000000003"),
                new JigyoshaNo("0000000003"),
                new RString("事業者名"),
                new RString("0003"),
                new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("123456"));

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);

        List<ShokanShinsei> entity = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        KouzaInfoHandler handler = getHandler(div);
        handler.loadヘッダエリア(識別コード, 被保険者番号);

        if (登録.equals(状態)) {
            // TODO コンフィグ判断
//          RString config = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
            // TODO コンフィグ判断
            DbT3036ShokanHanteiKekkaEntity shokanHanteiKekkaEntity = SyokanbaraihiShikyuShinseiKetteManager
                    .createInstance().getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
            if (shokanHanteiKekkaEntity == null) {
                div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(true);
            }
            div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(false);
            handler.load申請共通エリア(null, null, 新規);
        }
        if (修正.equals(状態)) {
            ShokanShinsei 償還払支給申請 = entity.get(0);
            handler.load申請共通エリア(償還払支給申請.getサービス提供年月(), 償還払支給申請.get整理番号(), new RString("修正"));
        }
        if (削除.equals(状態)) {
            div.getPanelTwo().getBtnShinseiInfo().setDisabled(true);
            handler.load申請共通エリア(null, null, 参照);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存ボタン, true);
        }
        // TODO 支払方法情報共有DIV 初期化  空白
//            div.getCcdShinseiNaiyo().load(修正, new RString("001"));
        return createResponse(div);
    }

    /**
     * 申請情報
     *
     * @param div
     * @return
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnShinseiInfo(KouzaInfoPanelDiv div) {
        getHandler(div).onClick_btnShinseiInfo();
        return ResponseData.of(div).forwardWithEventName(DBC0810014TransitionEventName.償還払い費支給申請).respond();
    }

    /**
     * サービス提供証明書
     *
     * @param div
     * @return
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnServiceTeikyoShomeisyo(KouzaInfoPanelDiv div) {
        getHandler(div).申請既存チェック();
        getHandler(div).onClick_btnServiceTeikyoShomeisyo();
        return ResponseData.of(div).forwardWithEventName(DBC0810014TransitionEventName.サービス提供証明書).respond();
    }

    /**
     * 償還払決定情報
     *
     * @param div
     * @return
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnShokanbaraiKeiteInfo(KouzaInfoPanelDiv div) {
        getHandler(div).申請既存チェック();
        getHandler(div).onClick_btnShokanbaraiKeiteInfo();
        return ResponseData.of(div).forwardWithEventName(DBC0810014TransitionEventName.償還払決定情報).respond();
    }

    /**
     * 取消する
     *
     * @param div
     * @return
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_commonButtonFree(KouzaInfoPanelDiv div) {
        Boolean 変更有無チェック = getHandler(div).変更有無チェック();
        if (!変更有無チェック) {
            return ResponseData.of(div).forwardWithEventName(DBC0810014TransitionEventName.一覧に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0810014TransitionEventName.償還払い費支給申請).respond();
        } else {
            return createResponse(div);
        }
    }

    /**
     * 申請を保存する
     *
     * @param div
     * @return
     */
    public ResponseData<KouzaInfoPanelDiv> onClick_btnSave(KouzaInfoPanelDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        try {
            if (削除.equals(状態)) {
                getHandler(div).保存_削除();
            } else {
                Boolean 変更有無チェック = getHandler(div).変更有無チェック();
                if (!変更有無チェック) {
                    return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
                }
                getHandler(div).保存_修正();
                if (修正.equals(状態)) {
                    return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("修正")).respond();
                } else if (登録.equals(状態)) {
                    return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("登録")).respond();
                }
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("償還払支給申請"));
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存ボタン, true);
        return createResponse(div);
    }

    private KouzaInfoHandler getHandler(KouzaInfoPanelDiv div) {
        return new KouzaInfoHandler(div);
    }

    private ResponseData<KouzaInfoPanelDiv> createResponse(KouzaInfoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
