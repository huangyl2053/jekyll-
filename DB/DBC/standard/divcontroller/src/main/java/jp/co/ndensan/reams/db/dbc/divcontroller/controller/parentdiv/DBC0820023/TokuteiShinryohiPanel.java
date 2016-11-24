/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.DBC0820023StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.DBC0820023TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.TokuteiShinryohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.ddgToteishinryoTokubetushinryo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023.dgdTokuteiShinryohi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820023.TokuteiShinryohiPanelHandler;
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
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(特定診療費）のクラスです。
 *
 * @reamsid_L DBC-1030-110 wangkanglei
 */
public class TokuteiShinryohiPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString NUM1 = new RString("1");
    private static final RString NUM0 = new RString("0");
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成１５年４月 = new FlexibleYearMonth("200304");
    private static final RString 登録_削除 = new RString("登録_削除");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onLoad(TokuteiShinryohiPanelDiv div) {

        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ViewStateHolder.put(ViewStateKeys.申請年月日, 申請日);

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        getHandler(div).set申請共通エリア(サービス年月, 事業者番号, 申請日, 明細番号, 様式番号, 被保険者番号, 識別コード);

        DbJohoViewState viewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (viewStateDB == null) {
            viewStateDB = new DbJohoViewState();
        }

        ArrayList<ShokanTokuteiShinryohi> 特定DBList = ViewStateHolder.get(ViewStateKeys.償還払請求特定診療費データ, ArrayList.class);
        if (特定DBList == null) {
            特定DBList = new ArrayList<>();
        }
        ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> 特別DBList = ViewStateHolder.get(ViewStateKeys.特別療養費一覧, ArrayList.class);
        if (特別DBList == null) {
            特別DBList = new ArrayList<>();
        }

        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            平成15年月制御(div, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, viewStateDB, 特定DBList, meisaiPar);
        }

        if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            平成15年月後制御(div, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, viewStateDB, 特別DBList, meisaiPar);
        }

        ShikibetsuNoKanri shikibetsuNoKanri = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(meisaiPar.getサービス年月(), meisaiPar.get様式番号());
        if (shikibetsuNoKanri == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        getHandler(div).getボタンを制御(shikibetsuNoKanri, meisaiPar);
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            getHandler(div).set削除状態();
            return ResponseData.of(div).setState(DBC0820023StateName.削除モード);
        }
        return ResponseData.of(div).setState(DBC0820023StateName.新規修正モード);
    }

    /**
     * 追加ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnAdd(TokuteiShinryohiPanelDiv div) {
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            getHandler(div).set特定診療費登録(true);
            getHandler(div).readOnly特定診療費登録(false);
            getHandler(div).clear特定診療費登録();
        }
        if (平成１５年４月.isBeforeOrEquals(サービス年月)) {
            getHandler(div).set特定診療費(true);
            getHandler(div).readOnly特定診療費_特別診療費登録(false);
            getHandler(div).clear特定診療費_特別診療費登録();
        }
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        return createResponse(div);
    }

    /**
     * グリッド(平成１５年３月以前)エリアの修正ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_ddgModify(TokuteiShinryohiPanelDiv div) {
        getHandler(div).readOnly特定診療費登録(false);
        getHandler(div).clear特定診療費登録();
        getHandler(div).set特定診療費登録();
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * グリッド(平成１５年３月以前)エリアの削除ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_ddgDelete(TokuteiShinryohiPanelDiv div) {
        getHandler(div).readOnly特定診療費登録(true);
        getHandler(div).clear特定診療費登録();
        getHandler(div).set特定診療費登録();
        ddgToteishinryoTokubetushinryo_Row row = div.getDdgToteishinryoTokubetushinryo().getClickedItem();
        if (RowState.Added.equals(row.getRowState())) {
            ViewStateHolder.put(ViewStateKeys.状態, 登録_削除);
        } else {
            ViewStateHolder.put(ViewStateKeys.状態, 削除);
        }
        return createResponse(div);
    }

    /**
     * グリッド(平成１５年４月以降)の修正ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_dgdModify(TokuteiShinryohiPanelDiv div) {
        getHandler(div).readOnly特定診療費_特別診療費登録(false);
        getHandler(div).clear特定診療費_特別診療費登録();
        getHandler(div).set特定診療費_特別診療費登録(
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.様式番号, RString.class));
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        return createResponse(div);
    }

    /**
     * グリッド(平成１５年４月以降)の削除ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_dgdDelete(TokuteiShinryohiPanelDiv div) {
        getHandler(div).readOnly特定診療費_特別診療費登録(true);
        getHandler(div).clear特定診療費_特別診療費登録();
        getHandler(div).set特定診療費_特別診療費登録(
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.様式番号, RString.class));
        dgdTokuteiShinryohi_Row row = div.getDgdTokuteiShinryohi().getClickedItem();

        if (RowState.Added.equals(row.getRowState())) {
            ViewStateHolder.put(ViewStateKeys.状態, 登録_削除);
        } else {
            ViewStateHolder.put(ViewStateKeys.状態, 削除);
        }
        return createResponse(div);
    }

    /**
     * 特定診療費登録エリアの「計算する」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKeisan(TokuteiShinryohiPanelDiv div) {
        getHandler(div).click計算結果();
        return createResponse(div);
    }

    /**
     * 特定診療費登録エリアの「クリアする」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnClear(TokuteiShinryohiPanelDiv div) {
        getHandler(div).clear特定診療費登録();
        return createResponse(div);
    }

    /**
     * 特定診療費登録エリアの「取消する」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnCancel(TokuteiShinryohiPanelDiv div) {
        getHandler(div).clear特定診療費登録();
        getHandler(div).set特定診療費登録(false);
        return createResponse(div);
    }

    /**
     * 特定診療費登録エリアの「確定する」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnConfirm(TokuteiShinryohiPanelDiv div) {
        List<ShokanTokuteiShinryohi> 初期の特定診療費登録List = ViewStateHolder.get(ViewStateKeys.償還払請求特定診療費データ, List.class);
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.
                get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);

        ddgToteishinryoTokubetushinryo_Row ddgRow;
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (登録.equals(状態)) {
            ddgRow = new ddgToteishinryoTokubetushinryo_Row();
        } else {
            ddgRow = getHandler(div).getSelectedRow();
        }
        getHandler(div).modifyRow(初期の特定診療費登録List, ddgRow, 状態, 明細検索キー);
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「計算する」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnCal(TokuteiShinryohiPanelDiv div) {
        getHandler(div).click計算結果2();
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「クリアする」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnClear2(TokuteiShinryohiPanelDiv div) {
        getHandler(div).clear特定診療費_特別診療費登録();
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「取消する」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnCancel2(TokuteiShinryohiPanelDiv div) {
        getHandler(div).clear特定診療費_特別診療費登録();
        getHandler(div).set特定診療費(false);
        return createResponse(div);
    }

    /**
     * 特定診療費・特別診療費登録エリアの「確定する」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnConfirm2(TokuteiShinryohiPanelDiv div) {
        List<ShokanTokuteiShinryoTokubetsuRyoyo> 初期の特別診療費List = ViewStateHolder.get(ViewStateKeys.特別療養費一覧, List.class);
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.
                get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);

        dgdTokuteiShinryohi_Row row;
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (登録.equals(状態)) {
            row = new dgdTokuteiShinryohi_Row();
        } else {
            row = getHandler(div).getSelectedRow2();
        }
        getHandler(div).modifyRow2(初期の特別診療費List, row, 状態, 明細検索キー);
        return createResponse(div);
    }

    /**
     * 共通エリア「証明書一覧へ戻る」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnFree(TokuteiShinryohiPanelDiv div) {

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.一覧に戻る).respond();
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
            return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.一覧に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 共通エリア「確認する」ボタンの押下処理です。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnSave(TokuteiShinryohiPanelDiv div) {

        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);

        DbJohoViewState viewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (viewStateDB == null) {
            viewStateDB = new DbJohoViewState();
        }

        boolean flag = getHandler(div).get内容変更状態(明細検索キー.getサービス年月());
        if (flag) {
            viewStateDB = 証明書フラグ設定(div, 明細検索キー, 処理モード, viewStateDB);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, viewStateDB);
            ViewStateHolder.put(ViewStateKeys.証明書戻り, NUM1);
        }
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.一覧に戻る).respond();
    }

    private DbJohoViewState 証明書フラグ設定(TokuteiShinryohiPanelDiv div, ShoukanharaihishinseimeisaikensakuParameter 明細検索キー,
            RString 処理モード, DbJohoViewState viewStateDB) {
        getHandler(div).viewStateDBの編集(明細検索キー.getサービス年月(), viewStateDB, 明細検索キー);
        if (登録.equals(処理モード)) {
            ShomeishoNyuryokuKanryoKubunType 出力_証明書入力済区分 = SyokanbaraihiShikyuShinseiManager.createInstance().証明書InputCheck(
                    ViewStateHolder.get(ViewStateKeys.証明書入力済フラグ, ShomeishoNyuryokuFlag.class),
                    明細検索キー.get様式番号(), 明細検索キー.getサービス年月());

            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoNyuryokuKanryoKubunType> 証明書入力完了フラグMap
                    = viewStateDB.get証明書入力完了フラグMap();
            if (ShomeishoNyuryokuKanryoKubunType.入力未完了.equals(出力_証明書入力済区分)) {
                証明書入力完了フラグMap.put(明細検索キー, ShomeishoNyuryokuKanryoKubunType.入力未完了);
                throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.getMessage().evaluate());
            }
            証明書入力完了フラグMap.put(明細検索キー, ShomeishoNyuryokuKanryoKubunType.入力完了);

        } else if (修正.equals(処理モード)) {
            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap
                    = viewStateDB.get証明書変更済フラグMap();
            if (証明書変更済フラグMap == null) {
                証明書変更済フラグMap = new HashMap<>();
            }
            ShomeishoHenkoFlag 証明書変更済フラグ = 証明書変更済フラグMap.get(明細検索キー);
            if (証明書変更済フラグ == null) {
                証明書変更済フラグ = new ShomeishoHenkoFlag();
            }
            証明書変更済フラグ.set特定診療費_証明書変更済フラグ(ShomeishoHenkoKubunType.変更あり);
            証明書変更済フラグMap.put(明細検索キー, 証明書変更済フラグ);
            viewStateDB.set証明書変更済フラグMap(証明書変更済フラグMap);
        }
        return viewStateDB;
    }

    private TokuteiShinryohiPanelHandler getHandler(TokuteiShinryohiPanelDiv div) {
        return new TokuteiShinryohiPanelHandler(div);
    }

    private ResponseData<TokuteiShinryohiPanelDiv> createResponse(TokuteiShinryohiPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「基本情報」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKihoninfo(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKyufuMeisai(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.給付費明細).respond();
    }

    /**
     * 「サービス計画費」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnServiceKeikakuhi(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnTokuteinyushosha(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「合計情報」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnGokeiinfo(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.合計情報).respond();
    }

    /**
     * 「給付費明細（住特）」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKyufuhiMeisaiJutoku(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKinkyujiShoteiShikan(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 「緊急時施設療養費」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnKinkyujiShisetsu(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnShokujihiyo(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnSeikyugaku(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onClick_btnShafuku(TokuteiShinryohiPanelDiv div) {
        viewStateDBの編集(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820023TransitionEventName.社福軽減額).respond();
    }

    private void viewStateDBの編集(TokuteiShinryohiPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        DbJohoViewState viewStateDB = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        getHandler(div).viewStateDBの編集(明細検索キー.getサービス年月(), viewStateDB, 明細検索キー);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, viewStateDB);
    }

    /**
     * 「識別コード入力補助ボタン」ボタンのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onBeforeOpenDialog_btnJigyosha(TokuteiShinryohiPanelDiv div) {
        getHandler(div).set識別コード(
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.様式番号, RString.class));
        return createResponse(div);
    }

    /**
     * onOkClose_btnJigyoshaのメソッドます。
     *
     * @param div TokuteiShinryohiPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiPanelDiv> onOkClose_btnJigyosha(TokuteiShinryohiPanelDiv div) {
        getHandler(div).set識別名称(
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.様式番号, RString.class));
        return createResponse(div);
    }

    private void 平成15年月制御(TokuteiShinryohiPanelDiv div, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, DbJohoViewState viewStateDB,
            ArrayList<ShokanTokuteiShinryohi> 特定DBList, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        getHandler(div).setエリア制御(サービス年月);
        ArrayList<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList
                = getHandler(div).get当特定診療費ViewStateList(meisaiPar, viewStateDB.get償還払請求特定診療費データList());

        if (shokanTokuteiShinryohiList == null || shokanTokuteiShinryohiList.isEmpty()) {
            shokanTokuteiShinryohiList = (ArrayList<ShokanTokuteiShinryohi>) ShokanbaraiJyokyoShokai.createInstance()
                    .getTokuteiShinryohiData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);

            ArrayList<ShokanTokuteiShinryohi> 償還払請求特定診療費データList = viewStateDB.get償還払請求特定診療費データList();
            if (償還払請求特定診療費データList == null) {
                償還払請求特定診療費データList = new ArrayList<>();
            }
            償還払請求特定診療費データList.addAll(shokanTokuteiShinryohiList);
            viewStateDB.set償還払請求特定診療費データList(償還払請求特定診療費データList);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, viewStateDB);

            特定DBList.addAll(shokanTokuteiShinryohiList);
            ViewStateHolder.put(ViewStateKeys.償還払請求特定診療費データ, 特定DBList);
        }
        getHandler(div).set特定診療費一覧グリッド(shokanTokuteiShinryohiList);
    }

    private void 平成15年月後制御(TokuteiShinryohiPanelDiv div, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, RString 整理番号,
            JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, DbJohoViewState viewStateDB,
            ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> 特別DBList, ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        getHandler(div).setエリア制御(サービス年月);
        ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList
                = getHandler(div).get当特別診療費ViewStateList(meisaiPar, viewStateDB.get特別療養費データList());

        if (shokanTokuteiShinryoTokubetsuRyoyoList == null || shokanTokuteiShinryoTokubetsuRyoyoList.isEmpty()) {
            shokanTokuteiShinryoTokubetsuRyoyoList = (ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo>) ShokanbaraiJyokyoShokai.createInstance()
                    .getTokuteyiShinnryouhiTokubeturyoyohi(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);

            ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> 特別療養費データList = viewStateDB.get特別療養費データList();
            if (特別療養費データList == null) {
                特別療養費データList = new ArrayList<>();
            }
            特別療養費データList.addAll(shokanTokuteiShinryoTokubetsuRyoyoList);
            viewStateDB.set特別療養費データList(特別療養費データList);
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, viewStateDB);

            特別DBList.addAll(shokanTokuteiShinryoTokubetsuRyoyoList);
            ViewStateHolder.put(ViewStateKeys.特別療養費一覧, 特別DBList);
        }
        getHandler(div).set特定診療費_特別診療費一覧グリッド(shokanTokuteiShinryoTokubetsuRyoyoList);
    }
}
