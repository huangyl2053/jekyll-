/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820029;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshinseijoho.ShokujiHiyoUpdateData;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import static jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.DBC0820029StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.DBC0820029TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.ShokujiHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.dgdShokuji_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820029.ShokujiHiyoPanelErrorMessage;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820029.ShokujiHiyoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820029.ShokujiHiyoPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
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
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (償還払ViewStateDB == null) {
            償還払ViewStateDB = new DbJohoViewState();
        }
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
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(様式番号, サービス提供年月);
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス提供年月, 申請日, 事業者番号, 明細番号, 様式番号);
        ArrayList<ShokanShokujiHiyo> 償還払請求食事費用データList = 償還払ViewStateDB.get償還払請求食事費用データList();
        if (!サービス提供年月.isEmpty() && サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
            getHandler(div).set平成１５年３月_状態();
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = 償還払請求食事費用データList == null
                    ? ShokanbaraiJyokyoShokai.createInstance().getSeikyuShokujiHiyoTanjyunSearch(
                            被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null)
                    : 償還払請求食事費用データList;
            if (!shokanShokujiHiyoList.isEmpty()) {
                getHandler(div).set食事費用登録エリア１(shokanShokujiHiyoList.get(0));
            }
            ViewStateHolder.put(ViewStateKeys.食事費用データ, (Serializable) shokanShokujiHiyoList);
            if (償還払ViewStateDB.get償還払請求食事費用データList() == null) {
                償還払ViewStateDB.set償還払請求食事費用データList((ArrayList) shokanShokujiHiyoList);
            }
        }
        if (!サービス提供年月.isEmpty() && 平成１５年３月.isBefore(サービス提供年月)
                && サービス提供年月.isBeforeOrEquals(平成17年９月)) {

            getデータ(div, 被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 償還払ViewStateDB);
        }
        if (!サービス提供年月.isEmpty() && 平成17年１０月.isBeforeOrEquals(サービス提供年月)) {
            getHandler(div).set平成17年１０月_状態();
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = 償還払請求食事費用データList == null
                    ? ShokanbaraiJyokyoShokai.createInstance().getSeikyuShokujiHiyoTanjyunSearch(
                            被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null)
                    : 償還払請求食事費用データList;
            if (!shokanShokujiHiyoList.isEmpty()) {
                getHandler(div).set食事費用合計設定(shokanShokujiHiyoList.get(0));
            }
            ViewStateHolder.put(ViewStateKeys.食事費用データ, (Serializable) shokanShokujiHiyoList);
            if (償還払ViewStateDB.get償還払請求食事費用データList() == null) {
                償還払ViewStateDB.set償還払請求食事費用データList((ArrayList) shokanShokujiHiyoList);
            }
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
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

    private void getデータ(ShokujiHiyoPanelDiv div,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            DbJohoViewState 償還払ViewStateDB) {
        getHandler(div).set平成１５年３月_平成17年１０月_状態();

        List<ShokanMeisai> shokanMeisaiList = 償還払ViewStateDB.get償還払請求明細データList() == null
                ? ShokanbaraiJyokyoShokai.createInstance().getShokujiHiyoDataList(
                        被保険者番号,
                        サービス提供年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号,
                        null)
                : getHandler(div).toShokanMeisaiList(償還払ViewStateDB.get償還払請求明細データList());
        if (!shokanMeisaiList.isEmpty()) {
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = 償還払ViewStateDB.get償還払請求食事費用データList() == null
                    ? ShokanbaraiJyokyoShokai.createInstance().getSeikyuShokujiHiyoTanjyunSearch(
                            被保険者番号,
                            サービス提供年月,
                            整理番号,
                            事業者番号,
                            様式番号,
                            明細番号,
                            null)
                    : 償還払ViewStateDB.get償還払請求食事費用データList();
            getHandler(div).set食事費用一覧グリッド(shokanMeisaiList, shokanShokujiHiyoList);
            ViewStateHolder.put(ViewStateKeys.食事費用データ, (Serializable) shokanShokujiHiyoList);
            if (償還払ViewStateDB.get償還払請求食事費用データList() == null) {
                償還払ViewStateDB.set償還払請求食事費用データList((ArrayList) shokanShokujiHiyoList);
            }
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
        if (償還払ViewStateDB.get償還払請求明細データList() == null) {
            償還払ViewStateDB.set償還払請求明細データList((ArrayList) getHandler(div).toShokanMeisaiResultList(shokanMeisaiList));
        }
    }

    /**
     * 「確定する」ボタンをクリックするイベントメソッドです。
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKakutei(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        ShoukanharaihishinseimeisaikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            ShomeishoNyuryokuFlag 証明書入力済フラグAll = 償還払ViewStateDB.get証明書入力済フラグMap().get(paramter);
            SyokanbaraihiShikyuShinseiManager manager = SyokanbaraihiShikyuShinseiManager.createInstance();
            ShomeishoNyuryokuKanryoKubunType チェック結果 = manager.証明書InputCheck(証明書入力済フラグAll, paramter.get様式番号(), paramter.getサービス年月());
            if (ShomeishoNyuryokuKanryoKubunType.入力完了.equals(チェック結果)) {
                償還払ViewStateDB.get証明書入力完了フラグMap().put(paramter, チェック結果);
                ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
            } else {
                ValidationMessageControlPairs controlPairs = new ValidationMessageControlPairs();
                controlPairs.add(new ValidationMessageControlPair(new ShokujiHiyoPanelErrorMessage(償還払い費支給申請決定_証明書情報未入力.getMessage())));
                return ResponseData.of(div).addValidationMessages(controlPairs).respond();
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「証明書一覧へ戻る」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTorikeshi(ShokujiHiyoPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.一覧に戻る).respond();
        }
        return clear入力内容(div);

    }

    private ResponseData<ShokujiHiyoPanelDiv> clear入力内容(ShokujiHiyoPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(
                    DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().getCode(),
                    DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
            return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.一覧に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
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
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKyufuMeisai(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.給付費明細).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnServiceKeikakuhi(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTokuteiNyushosya(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnGoukeiInfo(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
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
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnTokuteiShinryohi(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.特定診療費).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKyufuhiMeisaiJutoku(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKinkyujiShoteiShikan(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnKinkyushisetuRyoyouhi(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnSeikyugakuShukei(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820029TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div ShokujiHiyoPanelDiv
     * @return ResponseData<ShokujiHiyoPanelDiv>
     */
    public ResponseData<ShokujiHiyoPanelDiv> onClick_btnShafukukeigenGaku(ShokujiHiyoPanelDiv div) {
        setフラグ(div);
        入力内容保存(div);
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

    private void setフラグ(ShokujiHiyoPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder.get(ViewStateKeys.食事費用データ, List.class);
        Boolean flag = getHandler(div).get内容変更状態(サービス提供年月, shokanShokujiHiyoList);

        if (修正.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap = 償還払ViewStateDB.get証明書変更済フラグMap();

            if (証明書変更済フラグMap == null) {
                証明書変更済フラグMap = new HashMap<>();
            }
            ShomeishoHenkoFlag 証明書変更済フラグ = 証明書変更済フラグMap.get(明細検索キー);
            if (証明書変更済フラグ == null) {
                証明書変更済フラグ = new ShomeishoHenkoFlag();
            }
            証明書変更済フラグ.set食事費用_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
            if (flag) {
                証明書変更済フラグ.set食事費用_証明書変更済フラグ(ShomeishoHenkoKubunType.変更あり);
            }
            証明書変更済フラグMap.put(明細検索キー, 証明書変更済フラグ);
            償還払ViewStateDB.set証明書変更済フラグMap(証明書変更済フラグMap);
        }
        if (登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap = 償還払ViewStateDB.get証明書入力済フラグMap();
            if (証明書入力済フラグMap == null) {
                証明書入力済フラグMap = new HashMap<>();
            }
            ShomeishoNyuryokuFlag 証明書入力済フラグ = 証明書入力済フラグMap.get(明細検索キー);
            if (証明書入力済フラグ == null) {
                証明書入力済フラグ = new ShomeishoNyuryokuFlag();
            }
            証明書入力済フラグ.set食事費用_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
            if (flag) {
                証明書入力済フラグ.set食事費用_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
            }
            証明書入力済フラグMap.put(明細検索キー, 証明書入力済フラグ);
            償還払ViewStateDB.set証明書入力済フラグMap(証明書入力済フラグMap);
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
    }

    private void 入力内容保存(ShokujiHiyoPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        List<ShokanShokujiHiyo> shokanShokujiHiyoList = ViewStateHolder.get(ViewStateKeys.食事費用データ, List.class);
        List<ShokanMeisai> shokanMeisaiList = ViewStateHolder.get(ViewStateKeys.償還払請求食事費用, List.class);
        ShoukanharaihishinseimeisaikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);

        ShokujiHiyoUpdateData 更新用データ = getHandler(div).get更新用データ(paramter, shokanShokujiHiyoList, shokanMeisaiList, 処理モード);
        償還払ViewStateDB.set償還払請求食事費用データList((ArrayList) 更新用データ.get償還払請求食事費用データ());
        償還払ViewStateDB.set償還払請求明細データList((ArrayList) 更新用データ.get償還払請求明細データ());

        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB);
    }

}
