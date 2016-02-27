/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820022;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.DBC0820022StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.DBC0820022TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.dgdKyufuhiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820022.KyufuShiharayiMeisaiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細）
 *
 *
 */
public class KyufuShiharayiMeisaiPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");

    /**
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onLoad(KyufuShiharayiMeisaiPanelDiv div) {
        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("0000030"), new FlexibleYearMonth(new RString("201406")),
                new RString("1111"), new JigyoshaNo("3333"), new RString("2222"),
                new RString("4444"), null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        SyokanbaraihishikyushinseiketteParameter parameter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 様式番号 = parameter.getYoshikiNo();
        RString 明細番号 = parameter.getMeisaiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0000030"),
                new FlexibleYearMonth(new RString("201406")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        RString 申請日 = new RString("201406");
//        ServiceShuruiCode サービス種類コード = new ServiceShuruiCode("50");
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);
        List<ShokanMeisaiResult> entityList = ShokanbaraiJyokyoShokai.createInstance().
                getShokanbarayiSeikyuMeisayiList(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null, null);
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        div.getPanelThree().getPanelFour().setVisible(false);
        getHandler(div).initialize(entityList);
//        ArrayList<ShokanMeisai> viewstateList = new ArrayList<>();
//        for (ShokanMeisaiResult tmp : entityList) {
//            viewstateList.add(tmp.getEntity().createBuilderForEdit().build());
//        }
        ViewStateHolder.put(ViewStateKeys.給付費明細登録, (Serializable) entityList);

//        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
//        DbT3118ShikibetsuNoKanriEntity entity = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
//                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
//        if (entity == null) {
//            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
//        } else {
//            getHandler(div).getボタンを制御(entity);
//        }
//        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
//            div.getPanelThree().setDisabled(true);
//        }
        return createResponse(div);
    }

    /**
     * onClick_btnAdd事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnAdd(KyufuShiharayiMeisaiPanelDiv div) {
        div.getPanelThree().getPanelFour().setVisible(true);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        return createResponse(div);
    }

    /**
     * onClick_Modify事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_Modify(KyufuShiharayiMeisaiPanelDiv div) {
//        dgdKyufuhiMeisai_Row row = div.getPanelThree().getDgdKyufuhiMeisai().getClickedItem();
        div.getPanelThree().getPanelFour().setVisible(true);
        getHandler(div).set給付費明細登録();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * onClick_Delete事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_Delete(KyufuShiharayiMeisaiPanelDiv div) {
        div.getPanelThree().getPanelFour().setVisible(true);
//        dgdKyufuhiMeisai_Row row = div.getPanelThree().getDgdKyufuhiMeisai().getClickedItem();
        getHandler(div).set給付費明細登録();
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * onClick_btnKeisan事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKeisan(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).click計算する();
        return createResponse(div);
    }

    /**
     * onClick_btnClear事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnClear(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).clear給付費明細登録();
        return createResponse(div);
    }

    /**
     * onClick_btnCancel事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnCancel(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).clear給付費明細登録();
        div.getPanelThree().getPanelFour().setVisible(false);
        return createResponse(div);
    }

    /**
     * onClick_btnFree事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnFree(KyufuShiharayiMeisaiPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.サービス計画費)
                    .parameter(new RString("サービス計画費"));
        }
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
        boolean flag = getHandler(div).get内容変更状態(サービス年月);
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//                getHandler(div).内容の破棄();
                return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.サービス計画費)
                        .parameter(new RString("サービス計画費"));
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            // TODO 償還払支給申請_サービス提供証明書画面へ遷移する。
            return ResponseData.of(div).forwardWithEventName(DBC0820022TransitionEventName.サービス計画費)
                    .parameter(new RString("サービス計画費"));
        }
        return createResponse(div);
    }

    /**
     * onClick_btnConfirm事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnConfirm(KyufuShiharayiMeisaiPanelDiv div) {
        dgdKyufuhiMeisai_Row row;
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            row = new dgdKyufuhiMeisai_Row();
        } else {
            row = getHandler(div).selectRow();
        }
        getHandler(div).modifyRow(row);
        return createResponse(div);
    }

    /**
     * onClick_btnSave事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnSave(KyufuShiharayiMeisaiPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return createResponse(div);
            }

        } else {
            FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
//            boolean flag = getHandler(div).get内容変更状態(サービス年月);
            if (getHandler(div).get内容変更状態(サービス年月) && !ResponseHolder.isReRequest()) {
                getHandler(div).保存処理();
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()).respond();
            } else if (getHandler(div).get内容変更状態(サービス年月)
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return createResponse(div);
            } else if (!getHandler(div).get内容変更状態(サービス年月) && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(
                        DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            } else {
                return createResponse(div);
            }

//            if (flag) {
//                if (!ResponseHolder.isReRequest()) {
//                    getHandler(div).保存処理();
//                    return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()).respond();
//                }
//                if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//                    return createResponse(div);
//                }
//
//            } else {
//                if (!ResponseHolder.isReRequest()) {
//                    return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
//                }
//                if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//                    return createResponse(div);
//                }
//            }
        }
        // TODO 「申請を保存する」ボタンを非活性にする。
        return ResponseData.of(div).setState(DBC0820022StateName.Default);

    }

    /**
     * 基本情報ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKihonInfo(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKyufuhiMeisai(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 特定診療費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnTokuteiShinryohi(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnServiceKeikakuhi(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnTokuteiNyushosya(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnGoukeiInfo(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKinkyujiShoteiShikan(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 緊急時施設療養費」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnKinkyujiShisetsuRyoyo(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnShokujiHiyo(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnSeikyugakuShukei(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiPanelDiv> onClick_btnShafukukeigengaku(KyufuShiharayiMeisaiPanelDiv div) {
        getHandler(div).putViewState();
        return createResponse(div);
    }

    private KyufuShiharayiMeisaiPanelHandler getHandler(KyufuShiharayiMeisaiPanelDiv div) {

        return new KyufuShiharayiMeisaiPanelHandler(div);
    }

    private ResponseData<KyufuShiharayiMeisaiPanelDiv> createResponse(KyufuShiharayiMeisaiPanelDiv div) {
        return ResponseData.of(div).respond();
    }

}
