/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820024;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.ServiceKeikakuHiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820024.ServiceKeikakuHiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
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
 * 償還払い費支給申請決定_サービス提供証明書(サービス計画費)のクラスです。
 */
public class ServiceKeikakuHiPanel {

    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth サービス年月_200903 = new FlexibleYearMonth("200903");
    private static final FlexibleYearMonth サービス年月_200604 = new FlexibleYearMonth("200604");
    private static final RString 登録モード = new RString("登録");
    private static final RString 削除モード = new RString("削除");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 申請を保存するボタン = new RString("btnUpdate");

    /**
     * 画面初期化onLoad
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onLoad(ServiceKeikakuHiPanelDiv div) {
        SyokanbaraihishikyushinseiketteParameter param = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("000000003"), new FlexibleYearMonth(new RString("201501")),
                new RString("1111"), new JigyoshaNo("3333"), new RString("2222"),
                new RString("4444"), null);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0004"),
                new FlexibleYearMonth(new RString("201601")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, param);
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 申請年月日 = new RString("20151124");
        RString 証明書 = new RString("証明書");
        ViewStateHolder.put(ViewStateKeys.画面モード, 登録モード);

        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        if (明細番号.isEmpty()) {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する  TransitationEventName not have
            return createResponse(div);
        }
        getHandler(div).set申請共通エリア(サービス年月, 申請年月日, 事業者番号, 明細番号, 証明書, 様式番号);
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(false);
        if (サービス年月_200904.isBeforeOrEquals(サービス年月)) {
            List<ShokanServicePlan200904Result> entity200904List
                    = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200904(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            checkNull(entity200904List);
            ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, (Serializable) entity200904List);
            getHandler(div).onLoad200904(entity200904List);
            div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(false);
            div.getPanelServiceKeikakuhiDown().setDisplayNone(true);
        } else {
            if (サービス年月_200604.isBeforeOrEquals(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
                List<ShokanServicePlan200604Result> entity200604
                        = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200604(
                                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
                checkNull(entity200604);
                ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, (Serializable) entity200604);
                getHandler(div).onLoad200604(entity200604.get(0));
            } else {
                List<ShokanServicePlan200004Result> entity200004
                        = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200004(
                                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
                checkNull(entity200004);
                ViewStateHolder.put(ViewStateKeys.償還払い費支給申請決定_サービス計画費, (Serializable) entity200004);
                div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setDisplayNone(true);
                div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setDisplayNone(true);
                getHandler(div).onLoad20004(entity200004.get(0));
            }
            div.getPanelServiceKeikakuhiUp().setDisplayNone(true);
        }
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(shikibetsuNoKanri);
        }
        return createResponse(div);
    }

    /**
     * 追加するボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnAdd(ServiceKeikakuHiPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).click追加();
        return createResponse(div);
    }

    /**
     * グリッドの修正ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_dgList_modify(ServiceKeikakuHiPanelDiv div) {
        dgdYichiran_Row row = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        getHandler(div).click修正(row);
        return createResponse(div);
    }

    /**
     * グリッドの削除ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_dgList_delete(ServiceKeikakuHiPanelDiv div) {
        dgdYichiran_Row row = div.getPanelServiceKeikakuhiUp().getDgdYichiran().getClickedItem();
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        getHandler(div).click削除(row);
        getHandler(div).set削除();
        return createResponse(div);
    }

    /**
     * 「計算する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnKeisan(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).click計算Keisan();
        return createResponse(div);
    }

    /**
     * 「クリアする」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnClear(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).clickクリア();
        return createResponse(div);
    }

    /**
     * 「取消する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnCancel(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).clickクリア();
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(false);
        return createResponse(div);
    }

    /**
     * 「確定する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnConfirm(ServiceKeikakuHiPanelDiv div) {
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).確定_登録();
        } else if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).確定_修正();
        } else if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            getHandler(div).確定_削除();
        }
        getHandler(div).clickクリア();
        div.getPanelServiceKeikakuhiUp().getPanelServiceKeikakuhiToroku().setIsOpen(false);
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「計算する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnkeisan(ServiceKeikakuHiPanelDiv div) {
        getHandler(div).click計算keisan();
        return createResponse(div);
    }

    /**
     * 共通エリア「取消する」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnTorikeshi(ServiceKeikakuHiPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (削除モード.equals(画面モード)) {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return createResponse(div);
        } else {
            Boolean 変更 = getHandler(div).変更チェック処理(div);
            return 登録モード変更処理(変更, div);
        }
    }

    /**
     * 保存ボタンを押下した際に実行します
     *
     * @param div ServiceKeikakuHiPanelDiv
     * @return 償還払い費支給申請決定_サービス提供証明書(サービス計画費)画面
     */
    public ResponseData<ServiceKeikakuHiPanelDiv> onClick_btnUpdate(ServiceKeikakuHiPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (削除モード.equals(画面モード)) {
            getHandler(div).保存処理(削除モード);
        } else if (登録モード.equals(画面モード)) {
            Boolean 変更 = getHandler(div).変更チェック処理(div);
            if (!変更) {
                return saveOut(div);
            } else {
                return 保存処理(div, 登録モード);
            }
        }
        if (削除モード.equals(画面モード)) {
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("削除")).respond();
        } else if (登録モード.equals(画面モード)) {
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("登録")).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> 保存処理(ServiceKeikakuHiPanelDiv div, RString 状態) {
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).保存処理(登録モード);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace(状態.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存するボタン, true);
            return createResponse(div);
        }
        return ResponseData.of(div).addMessage(UrErrorMessages.異常終了.getMessage()).respond();
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> saveOut(ServiceKeikakuHiPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> 登録モード変更処理(Boolean 変更, ServiceKeikakuHiPanelDiv div) {
        if (!変更) {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return createResponse(div);
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return createResponse(div);
                // TODO getHandler(div).内容の破棄();
                // 償還払支給申請_サービス提供証明書画面へ遷移する。
                //                return ResponseData.of(div).forwardWithEventName(DBC0820024TransitionEventName.サービス提供証明書)
                //                        .parameter(new RString("サービス提供証明書"));
            }
        }
        return createResponse(div);
    }

    private void checkNull(List list) {
        if (list == null || list.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
    }

    private ServiceKeikakuHiPanelHandler getHandler(ServiceKeikakuHiPanelDiv div) {
        return new ServiceKeikakuHiPanelHandler(div);
    }

    private ResponseData<ServiceKeikakuHiPanelDiv> createResponse(ServiceKeikakuHiPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
