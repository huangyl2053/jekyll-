/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820030;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.DBC0820030TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.SeikyuGakuShukeiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820030.SeikyuGakuShukeiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820030.SeikyuGakuShukeiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 償還払い費支給申請決定_サービス提供証明書(請求額集計）
 *
 * @reamsid_L DBC-1030-100 quxiaodong
 *
 */
public class SeikyuGakuShukeiPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final RString 申請を削除する = new RString("btnDelete");
    private static final RString NUM1 = new RString("1");

    /**
     * onLoad事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onLoad(SeikyuGakuShukeiPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        Decimal 給付率 = ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class);
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.給付率, 給付率);
        ViewStateHolder.put(ViewStateKeys.申請年月日, 申請日);
        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(償還払費申請検索.getYoshikiNo(),
                償還払費申請検索.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);
        List<ShokanShukeiResult> entityList = ShokanbaraiJyokyoShokai.createInstance().getSeikyuShukeiData(
                被保険者番号,
                サービス年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号, null);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(false);
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).initialize(entityList);
        }
        ViewStateHolder.put(ViewStateKeys.請求額集計一覧情報, (Serializable) entityList);
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).get制御(shikibetsuNoKanri);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPanelSeikyugakuShukei().getBtnAdd().setDisabled(true);
            div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().setReadOnly(true);
        }
        return createResponse(div);
    }

    /**
     * onClick_btnAdd事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnAdd(SeikyuGakuShukeiPanelDiv div) {
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(true);
        getHandler(div).readOnly請求額集計登録(false);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).clear請求額集計登録();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu().setValue(
                ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class));
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou().setSelectedKey(NUM1);
        return createResponse(div);
    }

    /**
     * onClick_Delete事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_ddgDelete(SeikyuGakuShukeiPanelDiv div) {
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(true);
        getHandler(div).readOnly請求額集計登録(true);
        getHandler(div).set請求額集計登録();
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * onClick_Modify事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_ddgModify(SeikyuGakuShukeiPanelDiv div) {
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(true);
        getHandler(div).readOnly請求額集計登録(false);
        getHandler(div).set請求額集計登録();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * onClick_btnKeisan事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKeisan(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).計算する();
        return createResponse(div);
    }

    /**
     * onClick_btnClear事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnClear(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).clear請求額集計登録();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou().setSelectedKey(NUM1);
        return createResponse(div);
    }

    /**
     * onClick_btnCancel事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnCancel(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).clear請求額集計登録();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(false);
        return createResponse(div);
    }

    /**
     * onClick_btnFree事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnFree(SeikyuGakuShukeiPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.一覧に戻る).respond();
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
                return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.一覧に戻る).respond();
            } else {
                ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.一覧に戻る).respond();
        }
        return createResponse(div);
    }

    /**
     * onClick_btnConfirm事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnConfirm(SeikyuGakuShukeiPanelDiv div) {
        dgdSeikyugakushukei_Row row;
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            row = new dgdSeikyugakushukei_Row();
        } else {
            row = getHandler(div).selectRow();
        }
        ValidationMessageControlPairs validPairs = getCheckHandler(div).入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).modifyRow(row);
        return createResponse(div);
    }

    /**
     * onClick_btnSave事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnSave(SeikyuGakuShukeiPanelDiv div) {
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
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnDelete(SeikyuGakuShukeiPanelDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理();
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

    private ResponseData<SeikyuGakuShukeiPanelDiv> 保存処理(SeikyuGakuShukeiPanelDiv div) {
        try {
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理();
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

    private ResponseData<SeikyuGakuShukeiPanelDiv> notChanges(SeikyuGakuShukeiPanelDiv div) {
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
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKihonInfo(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKyufuMeisai(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.給付費明細).respond();
    }

    /**
     * 特定診療費」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnTokuteiShinryouhii(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnServiceKeikakuhi(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnTokuteiNyushosya(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnGoukeiInfo(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKyufuhiMeisaiJutoku(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKinkyujiShoteiShikan(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 緊急時施設療養費」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKinkyushisetuRyoyouhi(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnShokujihiyo(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.食事費用).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnShafukukeigenGaku(SeikyuGakuShukeiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.社福軽減額).respond();
    }

    private SeikyuGakuShukeiPanelHandler getHandler(SeikyuGakuShukeiPanelDiv div) {
        return new SeikyuGakuShukeiPanelHandler(div);
    }

    private SeikyuGakuShukeiPanelValidationHandler getCheckHandler(SeikyuGakuShukeiPanelDiv div) {
        return new SeikyuGakuShukeiPanelValidationHandler(div);
    }

    private ResponseData<SeikyuGakuShukeiPanelDiv> createResponse(SeikyuGakuShukeiPanelDiv div) {
        return ResponseData.of(div).respond();
    }

}
