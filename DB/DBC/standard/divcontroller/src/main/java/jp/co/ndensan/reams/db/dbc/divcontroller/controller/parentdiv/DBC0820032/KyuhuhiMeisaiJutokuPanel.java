/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820032;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.DBC0820032StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.DBC0820032TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.KyuhuhiMeisaiJutokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032.dgJushochiTokutei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820032.KyuhuhiMeisaiJutokuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820032.KyuhuhiMeisaiJutokuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細(住特））
 *
 * @reamsid_L DBC-1030-030 quxiaodong
 */
public class KyuhuhiMeisaiJutokuPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final RString 申請を削除する = new RString("btnDelete");

    /**
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onLoad(KyuhuhiMeisaiJutokuPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(償還払費申請検索.getYoshikiNo(),
                償還払費申請検索.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPnlAtenaCommon().getCcdAtena().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPnlAtenaCommon().getCcdKaigoKihon().initialize(被保険者番号);
        } else {
            div.getPnlAtenaCommon().getCcdKaigoKihon().setVisible(false);
        }
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(false);
        if (明細番号 == null || 明細番号.isEmpty()) {
            List<ShokanMeisaiJushochiTokureiResult> emptyList = new ArrayList();
            getHandler(div).initialize(emptyList);
        } else {
            ArrayList<ShokanMeisaiJushochiTokureiResult> entityList
                    = (ArrayList<ShokanMeisaiJushochiTokureiResult>) ShokanbaraiJyokyoShokai.createInstance().
                    getShokanbarayiSeikyuMeisayiJyutokuList(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            ViewStateHolder.put(ViewStateKeys.給付費明細住特, entityList);
            if (entityList == null || entityList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).initialize(entityList);
        }
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(shikibetsuNoKanri, meisaiPar);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPnlBtnDetail().getPnlKyufuhiMeisai().getBtnAdd().setDisabled(true);
            div.getPnlBtnDetail().getPnlKyufuhiMeisai().getDgJushochiTokutei().setReadOnly(true);
            return ResponseData.of(div).setState(DBC0820032StateName.削除モード);
        }
        return ResponseData.of(div).setState(DBC0820032StateName.新規修正モード);
    }

    /**
     * onClick_btnAdd事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnAdd(KyuhuhiMeisaiJutokuPanelDiv div) {
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(true);
        getHandler(div).readOnly給付費明細登録(false);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).clear給付費明細登録();
        return createResponse(div);
    }

    /**
     * onClick_Modify事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_Modify(KyuhuhiMeisaiJutokuPanelDiv div) {
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(true);
        getHandler(div).readOnly給付費明細登録(false);
        getHandler(div).set給付費明細();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * onClick_Delete事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_Delete(KyuhuhiMeisaiJutokuPanelDiv div) {
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(true);
        getHandler(div).readOnly給付費明細登録(true);
        getHandler(div).set給付費明細();
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * onClick_btnKeisan事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKeisan(KyuhuhiMeisaiJutokuPanelDiv div) {
        getHandler(div).click計算する();
        return createResponse(div);
    }

    /**
     * onClick_btnClear事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnClear(KyuhuhiMeisaiJutokuPanelDiv div) {
        getHandler(div).clear給付費明細登録();
        return createResponse(div);
    }

    /**
     * onClick_btnCancel事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnCancel(KyuhuhiMeisaiJutokuPanelDiv div) {
        getHandler(div).clear給付費明細登録();
        div.getPnlBtnDetail().getPnlKyufuhiMeisai().getPnlKyufuhiMeisaiTouroku().setVisible(false);
        return createResponse(div);
    }

    /**
     * onClick_btnFree事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnFree(KyuhuhiMeisaiJutokuPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.一覧に戻る).respond();
        }
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.一覧に戻る).respond();
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.一覧に戻る).respond();
        }
        return createResponse(div);
    }

    /**
     * onClick_btnConfirm事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnConfirm(KyuhuhiMeisaiJutokuPanelDiv div) {
        dgJushochiTokutei_Row row;
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (登録.equals(state)) {
            row = new dgJushochiTokutei_Row();
        } else {
            row = getHandler(div).selectRow();
        }
        ValidationMessageControlPairs validPairs = getCheckHandler(div).入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).modifyRow(row, state);
        return createResponse(div);
    }

    /**
     * onClick_btnSave事件
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnSave(KyuhuhiMeisaiJutokuPanelDiv div) {
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            return 保存処理(div);
        } else {
            return notChanges(div);
        }
    }

    /**
     * 「申請を削除する」ボタンのメソッドます。
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnDelete(KyuhuhiMeisaiJutokuPanelDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                ShoukanharaihishinseimeisaikensakuParameter meisaiPar
                        = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                                ShoukanharaihishinseimeisaikensakuParameter.class);
                RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
                List<ShokanMeisaiJushochiTokureiResult> shkonlist
                        = ViewStateHolder.get(ViewStateKeys.給付費明細住特, List.class);
                getHandler(div).保存処理(meisaiPar, 処理モード, shkonlist);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace(削除.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を削除する, true);
                return createResponse(div);
            }
            return ResponseData.of(div).respond();
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    private ResponseData<KyuhuhiMeisaiJutokuPanelDiv> 保存処理(KyuhuhiMeisaiJutokuPanelDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                ShoukanharaihishinseimeisaikensakuParameter meisaiPar
                        = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                                ShoukanharaihishinseimeisaikensakuParameter.class);
                RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
                List<ShokanMeisaiJushochiTokureiResult> shkonlist
                        = ViewStateHolder.get(ViewStateKeys.給付費明細住特, List.class);
                getHandler(div).保存処理(meisaiPar, 処理モード, shkonlist);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                        replace(登録.toString())).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
                return createResponse(div);
            }
        } catch (Exception e) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return createResponse(div);
    }

    private ResponseData<KyuhuhiMeisaiJutokuPanelDiv> notChanges(KyuhuhiMeisaiJutokuPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    /**
     * 基本情報ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKihonJoho(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKyufuhiMeisai(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.給付費明細).respond();
    }

    /**
     * 特定診療費」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnTokuteiShiryohi(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnServicePlanhi(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnTokuteiNyushoshaHi(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnGokeiJoho(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.合計情報).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKinkyujiShoteiShikan(
            KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 緊急時施設療養費」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnKinkyuShisetsuRyoyouhi(
            KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnShokujiHi(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnShiseigakuShukei(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div KyuhuhiMeisaiJutokuPanelDiv
     * @return ResponseData
     */
    public ResponseData<KyuhuhiMeisaiJutokuPanelDiv> onClick_btnShafukuGahenGaku(KyuhuhiMeisaiJutokuPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820032TransitionEventName.社福軽減額).respond();
    }

    private KyuhuhiMeisaiJutokuPanelHandler getHandler(KyuhuhiMeisaiJutokuPanelDiv div) {
        return new KyuhuhiMeisaiJutokuPanelHandler(div);
    }

    private KyuhuhiMeisaiJutokuPanelValidationHandler getCheckHandler(KyuhuhiMeisaiJutokuPanelDiv div) {
        return new KyuhuhiMeisaiJutokuPanelValidationHandler(div);
    }

    private ResponseData<KyuhuhiMeisaiJutokuPanelDiv> createResponse(KyuhuhiMeisaiJutokuPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private void setViewState(KyuhuhiMeisaiJutokuPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPnlBtnDetail().getTxtShinseibi().getValue());
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPnlBtnDetail().getTxtJigyoshaNo().getValue()),
                div.getPnlBtnDetail().getTxtShomeisho().getValue(),
                div.getPnlBtnDetail().getTxtMeisaiNo().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }

}
