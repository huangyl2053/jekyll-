/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820029;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.DBC0820029StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.DBC0820029TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.ShokujiHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.dgdShokuji_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820029.ShokujiHiyoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820029.ShokujiHiyoPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(食事費用）の画面クラスです。
 *
 * @reamsid_L DBC-1030-090 lijunjun
 */
public class ShokujiHiyoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final RString 申請を削除する = new RString("btnDelete");
    private static final RString 標準負担額日額 = new RString("標準負担額(日額)");
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成17年９月 = new FlexibleYearMonth("200509");
    private static final FlexibleYearMonth 平成17年１０月 = new FlexibleYearMonth("200510");

    /**
     * onLoad
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onLoad(ShokujiHiyoPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス提供年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ShoukanharaihishinseikensakuParameter 償還払費申請検索 = ViewStateHolder.get(ViewStateKeys.申請検索キー,
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
        getHandler(div).setヘッダーエリア(サービス提供年月, 申請日, 事業者番号, 明細番号, 様式番号);

        if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
            getHandler(div).set平成１５年３月_状態();
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null);
            if (!shokanShokujiHiyoList.isEmpty()) {
                getHandler(div).set食事費用登録エリア１(shokanShokujiHiyoList.get(0));
            }
            ViewStateHolder.put(ViewStateKeys.食事費用データ, (Serializable) shokanShokujiHiyoList);
        }
        if (平成１５年３月.isBefore(サービス提供年月)
                && サービス提供年月.isBeforeOrEquals(平成17年９月)) {

            getデータ(div, 被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        }
        if (平成17年１０月.isBeforeOrEquals(サービス提供年月)) {
            getHandler(div).set平成17年１０月_状態();
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null);
            if (!shokanShokujiHiyoList.isEmpty()) {
                getHandler(div).set食事費用合計設定(shokanShokujiHiyoList.get(0));
            }
            ViewStateHolder.put(ViewStateKeys.食事費用データ, (Serializable) shokanShokujiHiyoList);
        }
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー,
                SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            ShoukanharaihishinseimeisaikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                    ShoukanharaihishinseimeisaikensakuParameter.class);
            getHandler(div).getボタンを制御(shikibetsuNoKanri, paramter);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            getHandler(div).setボタン状態(サービス提供年月);
            return ResponseData.of(div).setState(DBC0820029StateName.削除モード);
        }
        return ResponseData.of(div).setState(DBC0820029StateName.新規修正モード);
    }

    /**
     * getデータのメソッド
     *
     * @param div ShokujiHiyoPanelDiv
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     */
    public void getデータ(ShokujiHiyoPanelDiv div,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        getHandler(div).set平成１５年３月_平成17年１０月_状態();

        List<ShokanMeisai> shokanMeisaiList = ShokanbaraiJyokyoShokai.createInstance()
                .getShokujiHiyoDataList(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (!shokanMeisaiList.isEmpty()) {
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null);
            getHandler(div).set食事費用一覧グリッド(shokanMeisaiList, shokanShokujiHiyoList);
            ViewStateHolder.put(ViewStateKeys.食事費用データ, (Serializable) shokanShokujiHiyoList);
        } else {
            Decimal 標準負担額_日額 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .getHyojyunfutangaku(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (標準負担額_日額 == null) {
                throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage()
                        .replace(標準負担額日額.toString()));
            }
            getHandler(div).set標準負担額日額(標準負担額_日額);
        }
        ViewStateHolder.put(ViewStateKeys.償還払請求食事費用, (Serializable) shokanMeisaiList);
    }

    /**
     * 「証明書一覧へ戻る」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTorikeshi(ShokujiHiyoPanelDiv div) {
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder.get(
                ViewStateKeys.食事費用データ, List.class);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.一覧に戻る).respond();
        }
        Boolean flag = getHandler(div).get内容変更状態(サービス提供年月, shokanShokujiHiyoList);
        if (flag) {
            return clear入力内容(div);
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.一覧に戻る).respond();
        }
    }

    private ResponseData<ShokujiHiyoPanelDiv> clear入力内容(ShokujiHiyoPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.一覧に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「申請を削除する」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnDelete(ShokujiHiyoPanelDiv div) {
        try {
            ShoukanharaihishinseimeisaikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                    ShoukanharaihishinseimeisaikensakuParameter.class);
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder
                    .get(ViewStateKeys.食事費用データ, List.class);
            List<ShokanMeisai> shokanMeisaiList = ViewStateHolder.get(
                    ViewStateKeys.償還払請求食事費用, List.class);
            RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
            if (!ResponseHolder.isReRequest()) {
                getHandler(div).保存処理(paramter, shokanShokujiHiyoList, shokanMeisaiList, 処理モード);
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了
                        .getMessage().replace(削除.toString())).respond();
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

    /**
     * 保存処理のメソッド
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnSave(ShokujiHiyoPanelDiv div) {
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder
                .get(ViewStateKeys.食事費用データ, List.class);
        ShoukanharaihishinseimeisaikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        List<ShokanMeisai> shokanMeisaiList = ViewStateHolder.get(
                ViewStateKeys.償還払請求食事費用, List.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        try {
            Boolean flag = getHandler(div).get内容変更状態(サービス提供年月, shokanShokujiHiyoList);
            if (flag) {
                return save(div, paramter, shokanShokujiHiyoList, shokanMeisaiList, 処理モード, サービス提供年月);
            } else {
                return noChange(div);
            }
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    private ResponseData<ShokujiHiyoPanelDiv> save(ShokujiHiyoPanelDiv div,
            ShoukanharaihishinseimeisaikensakuParameter paramter,
            List<ShokanShokujiHiyo> shokanShokujiHiyoList,
            List<ShokanMeisai> shokanMeisaiList,
            RString 処理モード,
            FlexibleYearMonth サービス提供年月) {
        if (!ResponseHolder.isReRequest()) {
            if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
                ValidationMessageControlPairs validPairs = getValidationHandler(div).check食事費用登録エリア１必須入力();
                if (validPairs.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(validPairs).respond();
                }
            }
            getHandler(div).保存処理(paramter, shokanShokujiHiyoList, shokanMeisaiList, 処理モード);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().
                    replace(登録.toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            return createResponse(div);
        }
        return createResponse(div);
    }

    private ResponseData<ShokujiHiyoPanelDiv> noChange(ShokujiHiyoPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return createResponse(div);
        }
        return createResponse(div);
    }

    /**
     * 「追加する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnAdd(ShokujiHiyoPanelDiv div) {
        div.getPanelShokuji().getPanelDetail2().setVisible(true);
        getHandler(div).readOnly食事費用登録(false);
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).clear食事費用登録エリア2();
        return createResponse(div);
    }

    /**
     * 「グリッドの削除」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_ddgDelete(ShokujiHiyoPanelDiv div) {
        div.getPanelShokuji().getPanelDetail2().setVisible(true);
        getHandler(div).clear食事費用登録エリア2();
        getHandler(div).readOnly食事費用登録(true);
        div.setRowId(new RString(String.valueOf(div.getPanelShokuji().getPanelShoikujiList()
                .getDgdShokuji().getClickedRowId())));
        dgdShokuji_Row row = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getClickedItem();
        getHandler(div).set食事費用登録(row);
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        return createResponse(div);
    }

    /**
     * 「グリッドの修正」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_ddgModify(ShokujiHiyoPanelDiv div) {
        div.getPanelShokuji().getPanelDetail2().setVisible(true);
        getHandler(div).clear食事費用登録エリア2();
        getHandler(div).readOnly食事費用登録(false);
        div.setRowId(new RString(String.valueOf(div.getPanelShokuji().getPanelShoikujiList()
                .getDgdShokuji().getClickedRowId())));
        dgdShokuji_Row row = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getClickedItem();
        getHandler(div).set食事費用登録(row);
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * 食事費用合計設定エリアの「集計する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnShukei(ShokujiHiyoPanelDiv div) {
        getHandler(div).集計する();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア１の「計算する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnCal(ShokujiHiyoPanelDiv div) {
        getHandler(div).計算する();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア２の「計算する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnCal2(ShokujiHiyoPanelDiv div) {
        getHandler(div).計算する2();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア１「クリアする」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnClear(ShokujiHiyoPanelDiv div) {
        getHandler(div).clear食事費用登録エリア１();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア２「クリアする」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnClear2(ShokujiHiyoPanelDiv div) {
        getHandler(div).clear食事費用登録エリア2();
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア２「取消する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnCacel2(ShokujiHiyoPanelDiv div) {
        getHandler(div).clear食事費用登録エリア2();
        div.getPanelShokuji().getPanelDetail2().setVisible(false);
        return createResponse(div);
    }

    /**
     * 食事費用登録エリア２「確定する」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnConfirm2(ShokujiHiyoPanelDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (状態.equals(登録)) {
            dgdShokuji_Row row = new dgdShokuji_Row();
            getHandler(div).confirm(row, 状態);
        } else {
            dgdShokuji_Row row = getHandler(div).selectRow();
            getHandler(div).confirm(row, 状態);
        }
        ValidationMessageControlPairs validPairs = getValidationHandler(div).check食事費用登録エリア２必須入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).clear食事費用登録エリア2();
        div.getPanelShokuji().getPanelDetail2().setVisible(false);
        return createResponse(div);
    }

    /**
     * 「基本情報」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKihonInfo(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKyufuMeisai(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.給付費明細).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnServiceKeikakuhi(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTokuteiNyushosya(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnGoukeiInfo(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細(住所地特例)」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(
            ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTokuteiShinryohi(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.特定診療費).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKyufuhiMeisaiJutoku(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKinkyujiShoteiShikan(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKinkyushisetuRyoyouhi(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnSeikyugakuShukei(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnShafukukeigenGaku(ShokujiHiyoPanelDiv div) {
        setViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.社福軽減額).respond();
    }

    private ShokujiHiyoPanelHandler getHandler(ShokujiHiyoPanelDiv div) {
        return new ShokujiHiyoPanelHandler(div);
    }

    private ShokujiHiyoPanelValidationHandler getValidationHandler(ShokujiHiyoPanelDiv div) {
        return new ShokujiHiyoPanelValidationHandler(div);
    }

    private ResponseData<ShokujiHiyoPanelDiv> createResponse(ShokujiHiyoPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private void setViewState(ShokujiHiyoPanelDiv div) {
        ShoukanharaihishinseikensakuParameter paramter = getHandler(div).putViewState(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }
}
