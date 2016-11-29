/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.DBC0820030StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.DBC0820030TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.SeikyuGakuShukeiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820030.SeikyuGakuShukeiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820030.SeikyuGakuShukeiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
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
    private static final RString NUM1 = new RString("1");
    private static final RString NUM0 = new RString("0");
    private static final RString 入力完了 = new RString("1");
    private static final RString 登録_削除 = new RString("登録_削除");

    /**
     * onLoad事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onLoad(SeikyuGakuShukeiPanelDiv div) {
        初期化ViewStateDb請求額集計();
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
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
        ViewStateHolder.put(ViewStateKeys.明細番号, 明細番号);
        ViewStateHolder.put(ViewStateKeys.事業者番号, 事業者番号);
        SikibetuNokennsakuki sikibetuKey = new SikibetuNokennsakuki(様式番号, サービス年月);
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, sikibetuKey);

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
            div.setSeiriNo(整理番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号);
        DbJohoViewState 一覧情報リスト = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ArrayList<ShokanShukeiResult> entityList;
        if (!一覧情報リスト.get償還払請求集計データList().isEmpty()) {
            entityList = 一覧情報リスト.get償還払請求集計データList();
        } else {
            entityList = (ArrayList<ShokanShukeiResult>) ShokanbaraiJyokyoShokai.createInstance().getSeikyuShukeiData(
                    被保険者番号,
                    サービス年月,
                    整理番号,
                    事業者番号,
                    様式番号,
                    明細番号, null);
            if (entityList != null) {
                一覧情報リスト.set償還払請求集計データList(entityList);
            } else {
                entityList = new ArrayList<>();
            }
            ViewStateHolder.put(ViewStateKeys.請求額集計一覧情報, entityList);
        }
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setVisible(false);
        if (entityList != null && !entityList.isEmpty()) {
            getHandler(div).initialize(entityList);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 一覧情報リスト);
        } else {
            List<dgdSeikyugakushukei_Row> rowList = new ArrayList<>();
            div.getPanelSeikyugakuShukei()
                    .getDgdSeikyugakushukei().setDataSource(rowList);
        }
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        getHandler(div).get制御(shikibetsuNoKanri, meisaiPar);

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            div.getPanelSeikyugakuShukei().getBtnAdd().setDisabled(true);
            div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().setReadOnly(true);
            return ResponseData.of(div).setState(DBC0820030StateName.削除モード);
        }
        return ResponseData.of(div).setState(DBC0820030StateName.新規修正モード);
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
        getHandler(div).set請求額集計登録(ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class));
        dgdSeikyugakushukei_Row row = div.getPanelSeikyugakuShukei()
                .getDgdSeikyugakushukei().getClickedItem();
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getBtnClear().setDisabled(true);
        div.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getBtnCal().setDisabled(true);
        if (RowState.Added.equals(row.getRowState())) {
            ViewStateHolder.put(ViewStateKeys.状態, 登録_削除);
        } else {
            ViewStateHolder.put(ViewStateKeys.状態, 削除);
        }
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
        getHandler(div).set請求額集計登録(ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class));
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
     * 「証明書一覧へ戻る」ボタンをclickする。
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnFree(SeikyuGakuShukeiPanelDiv div) {
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.一覧に戻る).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().getCode(),
                    DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbcQuestionMessages.償還払い費支給申請決定_入力内容破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, ViewStateHolder.get(ViewStateKeys.償還払ViewStateDBBAK, DbJohoViewState.class));
            ViewStateHolder.put(ViewStateKeys.証明書戻り, NUM0);
            return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.一覧に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * onClick_btnConfirm事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnConfirm(SeikyuGakuShukeiPanelDiv div) {
        dgdSeikyugakushukei_Row row;
        RString state = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(
                ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        if (登録.equals(state)) {
            row = new dgdSeikyugakushukei_Row();
        } else {
            row = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getActiveRow();
        }
        ValidationMessageControlPairs validPairs = getCheckHandler(div).入力チェック(meisaiPar);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        ArrayList<ShokanShukeiResult> 請求額集計情報リスト = ViewStateHolder.get(ViewStateKeys.請求額集計一覧情報, ArrayList.class);
        getHandler(div).modifyRow(row, state, 請求額集計情報リスト);
        return createResponse(div);
    }

    /**
     * onClick_btnSave事件
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnSave(SeikyuGakuShukeiPanelDiv div) {
        画面入力内容の保存(div, true);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.一覧に戻る).respond();
    }

    private void 画面入力内容の保存(SeikyuGakuShukeiPanelDiv div, boolean state) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        DbJohoViewState 一覧情報リスト = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        boolean flag = getHandler(div).is内容変更状態();
        if (flag) {
            ViewStateHolder.put(ViewStateKeys.証明書戻り, NUM1);
            一覧情報リスト = 証明書フラグ設定(明細検索キー, 処理モード, 一覧情報リスト);
        }
        最終情報を設定する(div, 一覧情報リスト, 処理モード, 明細検索キー, state);
    }

    private DbJohoViewState 証明書フラグ設定(ShoukanharaihishinseimeisaikensakuParameter 明細検索キー,
            RString 処理モード, DbJohoViewState 一覧情報リスト) {
        if (登録.equals(処理モード)) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap
                    = 一覧情報リスト.get証明書入力済フラグMap();
            if (一覧情報リスト.get証明書入力済フラグMap() == null) {
                証明書入力済フラグMap = new HashMap<>();
                一覧情報リスト.set証明書入力済フラグMap(証明書入力済フラグMap);
            }
            ShomeishoNyuryokuFlag 証明書入力済フラグ = 一覧情報リスト.get証明書入力済フラグMap().get(明細検索キー);
            if (証明書入力済フラグ == null) {
                証明書入力済フラグ = new ShomeishoNyuryokuFlag();
            }
            証明書入力済フラグ.set請求額集計_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
            証明書入力済フラグMap.put(明細検索キー, 証明書入力済フラグ);
            一覧情報リスト.set証明書入力済フラグMap(証明書入力済フラグMap);
        } else if (修正.equals(処理モード)) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap
                    = 一覧情報リスト.get証明書変更済フラグMap();
            if (一覧情報リスト.get証明書変更済フラグMap() == null) {
                証明書変更済フラグMap = new HashMap<>();
                一覧情報リスト.set証明書変更済フラグMap(証明書変更済フラグMap);
            }
            ShomeishoHenkoFlag 証明書変更済フラグ = 一覧情報リスト.get証明書変更済フラグMap().get(明細検索キー);
            if (証明書変更済フラグ == null) {
                証明書変更済フラグ = new ShomeishoHenkoFlag();
            }
            証明書変更済フラグ.set請求額集計_証明書変更済フラグ(ShomeishoHenkoKubunType.変更あり);
            証明書変更済フラグMap.put(明細検索キー, 証明書変更済フラグ);
            一覧情報リスト.set証明書変更済フラグMap(証明書変更済フラグMap);
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap
                    = 一覧情報リスト.get証明書入力済フラグMap();
            if (一覧情報リスト.get証明書入力済フラグMap() == null) {
                証明書入力済フラグMap = new HashMap<>();
                一覧情報リスト.set証明書入力済フラグMap(証明書入力済フラグMap);
            }
            ShomeishoNyuryokuFlag 証明書入力済フラグ = 一覧情報リスト.get証明書入力済フラグMap().get(明細検索キー);
            if (証明書入力済フラグ == null) {
                証明書入力済フラグ = new ShomeishoNyuryokuFlag();
            }
            証明書入力済フラグ.set請求額集計_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力あり);
            証明書入力済フラグMap.put(明細検索キー, 証明書入力済フラグ);
            一覧情報リスト.set証明書入力済フラグMap(証明書入力済フラグMap);
        }
        return 一覧情報リスト;
    }

    private void 最終情報を設定する(SeikyuGakuShukeiPanelDiv div,
            DbJohoViewState 一覧情報リスト, RString 処理モード, ShoukanharaihishinseimeisaikensakuParameter 明細検索キー,
            boolean state) {

        一覧情報リスト.set償還払請求集計データList(getHandler(div).償還払請求集計_保存処理(一覧情報リスト.get償還払請求集計データList()));
        一覧情報リスト.set償還払請求基本データList(getHandler(div).償還払請求基本_保存処理(一覧情報リスト.get償還払請求基本データList()));
        一覧情報リスト.set償還払支給申請(getHandler(div).償還払申請_保存処理(一覧情報リスト.get償還払請求基本データList(), 一覧情報リスト.get償還払支給申請()));
        if (登録.equals(処理モード) && state) {
            ShomeishoNyuryokuKanryoKubunType 証明書入力完了区分 = SyokanbaraihiShikyuShinseiManager
                    .createInstance().証明書InputCheck(一覧情報リスト.get証明書入力済フラグMap().get(明細検索キー),
                            明細検索キー.get様式番号(), 明細検索キー.getサービス年月());
            if (入力完了.equals(証明書入力完了区分.getCode())) {
                Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap
                        = 一覧情報リスト.get証明書入力完了フラグMap();
                証明書入力完了フラグMap.put(明細検索キー, ShomeishoNyuryokuKanryoKubunType.入力完了);
                一覧情報リスト.set証明書入力完了フラグMap(証明書入力完了フラグMap);
            } else {
                Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap
                        = 一覧情報リスト.get証明書入力完了フラグMap();
                証明書入力完了フラグMap.put(明細検索キー, ShomeishoNyuryokuKanryoKubunType.入力未完了);
                一覧情報リスト.set証明書入力完了フラグMap(証明書入力完了フラグMap);
                throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.getMessage().evaluate());
            }
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 一覧情報リスト);
    }

    /**
     * 基本情報ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKihonInfo(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKyufuMeisai(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.給付費明細).respond();
    }

    /**
     * 特定診療費」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnTokuteiShinryouhii(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnServiceKeikakuhi(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnTokuteiNyushosya(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnGoukeiInfo(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKyufuhiMeisaiJutoku(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKinkyujiShoteiShikan(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 緊急時施設療養費」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnKinkyushisetuRyoyouhi(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnShokujihiyo(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
        return ResponseData.of(div).forwardWithEventName(DBC0820030TransitionEventName.食事費用).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div SeikyuGakuShukeiPanelDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiPanelDiv> onClick_btnShafukukeigenGaku(SeikyuGakuShukeiPanelDiv div) {
        setViewState(div);
        画面入力内容の保存(div, false);
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

    private void setViewState(SeikyuGakuShukeiPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelHead().getTxtShinseiYMD().getValue());
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelHead().getTxtJigyoshaBango().getValue()),
                div.getPanelHead().getTxtShomeisho().getValue(),
                div.getPanelHead().getTxtMeisaiBango().getValue(),
                null);
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }

    private void 初期化ViewStateDb請求額集計() {
        DbJohoViewState 一覧情報リスト = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (一覧情報リスト == null) {
            一覧情報リスト = new DbJohoViewState();
        }
        if (一覧情報リスト.get償還払請求集計データList() == null) {
            ArrayList<ShokanShukeiResult> 償還払請求集計データList = new ArrayList<>();
            一覧情報リスト.set償還払請求集計データList(償還払請求集計データList);
        }
        if (一覧情報リスト.get証明書入力済フラグMap() == null) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuFlag> 証明書入力済フラグMap
                    = new HashMap<>();
            一覧情報リスト.set証明書入力済フラグMap(証明書入力済フラグMap);
        }
        if (一覧情報リスト.get証明書変更済フラグMap() == null) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap
                    = new HashMap<>();
            一覧情報リスト.set証明書変更済フラグMap(証明書変更済フラグMap);
        }
        if (一覧情報リスト.get証明書入力完了フラグMap() == null) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap
                    = new HashMap<>();
            一覧情報リスト.set証明書入力完了フラグMap(証明書入力完了フラグMap);
        }
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 一覧情報リスト);
    }
}
