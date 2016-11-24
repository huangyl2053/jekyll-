/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820014;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoHenkoFlag;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShomeishoGridList;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoHenkoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKanryoKubunType;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.DBC0820014TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.ServiceTeikyoShomeishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.dgdServiceTeikyoShomeisyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820014.ServiceTeikyoShomeishoPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書クラスです。
 *
 * @reamsid_L DBC-1030-130 gongliang
 */
public class ServiceTeikyoShomeishoPanel {

    private static final RString 処理モード_修正 = new RString("修正");
    private static final RString 処理モード_登録 = new RString("登録");
    private static final RString 処理モード_削除 = new RString("削除");
    private static final RString 変更あり = new RString("1");
    private static final RString 入力完了 = new RString("1");
    private static final RString 証明書戻り_0 = new RString("0");
    private static final RString 処理_空白 = RString.EMPTY;
    private static final RString 処理_追加 = new RString("追加");
    private static final RString 処理_追加修正 = new RString("追加修正");
    private static final RString 処理_修正 = new RString("修正");
    private static final RString 処理_削除 = new RString("削除");
    private static final RString 処理区分_0 = new RString("0");
    private static final RString 処理区分_1 = new RString("1");
    private static final RString 処理区分_2 = new RString("2");
    private static final RString 処理区分_3 = new RString("3");

    /**
     * 画面初期化onLoad
     *
     * @param div ServiceKeikakuHiDiv
     * @return 償還払い状況照会_サービス提供証明書画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onLoad(ServiceTeikyoShomeishoPanelDiv div) {

        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        FlexibleYearMonth サービス年月;
        try {
            サービス年月 = new FlexibleYearMonth((new RDate(
                    ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                    toString())).getYearMonth().toDateString());
        } catch (ClassCastException e) {
            サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
            ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月.toDateString());
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ServiceTeikyoShomeishoPanelHandler handler = getHandler(div);

        List<ShikibetsuNoKanri> 証明書リスト = SyokanbaraihiShikyuShinseiKetteManager
                .createInstance().getShikibetsuNoKanri(サービス年月);
        RDate 申請日;
        try {
            申請日 = new RDate(ViewStateHolder.get(ViewStateKeys.申請日, RString.class).toString());
        } catch (ClassCastException e) {
            申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RDate.class);
            ViewStateHolder.put(ViewStateKeys.申請日, 申請日.toDateString());
        }
        証明書グリッド変更();
        DbJohoViewState 償還払ViewStateDB情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        List<ServiceTeikyoShomeishoResult> 証明書一覧情報 = ShokanbaraiJyokyoShokai
                .createInstance().getServiceTeikyoShomeishoList(被保険者番号, サービス年月, 整理番号);
        handler.load宛名と基本情報(識別コード, 被保険者番号);
        handler.loadボタンエリア(画面モード);
        handler.load申請共通エリア(画面モード, サービス年月, 整理番号);
        handler.load申請明細エリア(画面モード, 申請日, 証明書リスト, 証明書一覧情報, 償還払ViewStateDB情報, サービス年月);
        return createResponse(div);
    }

    /**
     * 「申請情報」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払支給申請_支給申請画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_btnShinseiInfo(ServiceTeikyoShomeishoPanelDiv div) {
        入力有無フラグ設定();
        証明書グリッドList設定(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.申請情報).respond();
    }

    /**
     * 「口座情報」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払支給申請_口座登録画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_btnKouzaInfo(ServiceTeikyoShomeishoPanelDiv div) {
        入力有無フラグ設定();
        証明書グリッドList設定(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.口座情報).respond();
    }

    /**
     * 「償還払決定情報」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払支給申請一覧画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_btnShokanKeteiInfo(ServiceTeikyoShomeishoPanelDiv div) {
        入力有無フラグ設定();
        証明書グリッドList設定(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.償還払決定情報).respond();
    }

    /**
     * 「追加する」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払費支給申請決定_サービス提供証明書(基本情報)画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_btnAdd(ServiceTeikyoShomeishoPanelDiv div) {
        ServiceTeikyoShomeishoPanelHandler handler = getHandler(div);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        handler.証明書選択チェック();
        DbJohoViewState 償還払ViewStateDB情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        handler.サービス提供証明書の存在チェック(整理番号, サービス年月, 被保険者番号, 償還払ViewStateDB情報);
        putViewStateDown(処理モード_登録, div);
        証明書入力済フラグ初期化();
        証明書グリッドList設定(div);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDBBAK, 償還払ViewStateDB情報);
        ViewStateHolder.put(ViewStateKeys.証明書戻り, 証明書戻り_0);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.償還払い費支給申請).respond();
    }

    /**
     * 「グリッドの修正」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払費支給申請決定_サービス提供証明書(基本情報)画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_Modify(ServiceTeikyoShomeishoPanelDiv div) {
        if (getHandler(div).削除済チェック()) {
            throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_削除済修正.getMessage().evaluate());
        }
        if (処理_追加.equals(div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getActiveRow().getShori())) {
            putViewStateDown(処理_追加修正, div);
        }
        putViewStateDown(処理モード_修正, div);

        証明書変更済フラグ初期化();
        証明書グリッドList設定(div);
        DbJohoViewState 償還払ViewStateDB情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDBBAK, 償還払ViewStateDB情報);
        ViewStateHolder.put(ViewStateKeys.証明書戻り, 証明書戻り_0);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.償還払い費支給申請).respond();
    }

    /**
     * 削除ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払費支給申請決定_サービス提供証明書(基本情報)画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_Delete(ServiceTeikyoShomeishoPanelDiv div) {
        if (処理_追加.equals(div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getActiveRow().getShori())) {
            DbJohoViewState 償還払ViewStateDB情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                    ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                    toString())).getYearMonth().toDateString());
            RDate 申請日 = div.getPanelShinseiNaiyo().getTxtShinseibi().getValue();
            RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
            ShoukanharaihishinseimeisaikensakuParameter removeKey = new ShoukanharaihishinseimeisaikensakuParameter(被保険者番号, サービス年月, 申請日, 整理番号,
                    new JigyoshaNo(div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getActiveRow().getData1()),
                    div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getActiveRow().getData4(),
                    div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getActiveRow().getData3());
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, getHandler(div).明細削除_償還払情報クリア(償還払ViewStateDB情報, removeKey));
            onLoad(div);
            return ResponseData.of(div).respond();
        }
        putViewStateDown(処理モード_削除, div);
        ViewStateHolder.put(ViewStateKeys.証明書戻り, 証明書戻り_0);
        証明書グリッドList設定(div);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.償還払い費支給申請).respond();
    }

    private void 証明書グリッド変更() {
        DbJohoViewState 償還払ViewStateDB情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter 明細検索キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        RString 証明書戻り = ViewStateHolder.get(ViewStateKeys.証明書戻り, RString.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ArrayList<ShomeishoGridList> 証明書グリッドList = 償還払ViewStateDB情報.get証明書グリッドリスト();
        if (null != 明細検索キー && null != 証明書戻り && null != 処理モード && null != 証明書グリッドList) {
            for (ShomeishoGridList 証明書グリッド : 証明書グリッドList) {
                if (証明書グリッド.get事業者番号().equals(明細検索キー.get事業者番号().value())
                        && 証明書グリッド.get明細().equals(明細検索キー.get明細番号())
                        && 証明書グリッド.getサービス提供証明書().equals(明細検索キー.get様式番号())) {
                    証明書グリッド項目変更(証明書グリッド, 処理モード, 証明書戻り);
                }
            }
        }
        償還払ViewStateDB情報.set証明書グリッドリスト(証明書グリッドList);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB情報);
    }

    private void 証明書グリッド項目変更(ShomeishoGridList 証明書グリッド, RString 処理モード, RString 証明書戻り) {
        if (処理_空白.equals(証明書グリッド.get処理()) && 処理モード_登録.equals(処理モード)) {
            if (証明書戻り_0.equals(証明書戻り)) {
                証明書グリッド.set処理(処理_空白);
                証明書グリッド.set処理区分(処理区分_0);
            } else {
                証明書グリッド.set処理(処理_追加);
                証明書グリッド.set処理区分(処理区分_1);
            }
        } else if (処理_空白.equals(証明書グリッド.get処理()) && 処理モード_修正.equals(処理モード)) {
            if (証明書戻り_0.equals(証明書戻り)) {
                証明書グリッド.set処理(処理_空白);
                証明書グリッド.set処理区分(処理区分_0);
            } else {
                証明書グリッド.set処理(処理_修正);
                証明書グリッド.set処理区分(処理区分_2);
            }
        } else if (処理モード_削除.equals(処理モード)) {
            証明書グリッド.set処理(処理_削除);
            証明書グリッド.set処理区分(処理区分_3);
        }
    }

    private void putViewStateDown(RString 処理モード, ServiceTeikyoShomeishoPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        RDate 申請日 = div.getPanelShinseiNaiyo().getTxtShinseibi().getValue();
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        dgdServiceTeikyoShomeisyo_Row row = div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getActiveRow();
        JigyoshaNo 事業者番号 = JigyoshaNo.EMPTY;
        RString 事業者番号_入力 = div.getPanelShinseiNaiyo().getCcdShisetsuJoho().getNyuryokuShisetsuKodo();
        if (処理モード_登録.equals(処理モード) && 事業者番号_入力 != null) {
            事業者番号 = new JigyoshaNo(事業者番号_入力);
        } else if (row.getData1() != null) {
            事業者番号 = new JigyoshaNo(row.getData1());
        }
        RString 様式番号;
        if (処理モード_登録.equals(処理モード)) {
            様式番号 = div.getPanelShinseiNaiyo().getDdlShomeisho().getSelectedKey();
        } else {
            様式番号 = row.getData4();
        }
        RString 明細番号 = null;
        if (!処理モード_登録.equals(処理モード) || 処理_追加修正.equals(処理モード)) {
            処理モード = 処理モード_修正;
            明細番号 = row.getData3();
        }
        ShoukanharaihishinseimeisaikensakuParameter parameter = new ShoukanharaihishinseimeisaikensakuParameter(
                被保険者番号, サービス年月, 申請日, 整理番号, 事業者番号, 様式番号, 明細番号);
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード);
        ViewStateHolder.put(ViewStateKeys.明細検索キー, parameter);
    }

    private void 証明書入力済フラグ初期化() {
        ShomeishoNyuryokuFlag 証明書入力済フラグ = new ShomeishoNyuryokuFlag();
        証明書入力済フラグ.setサービス計画費_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set基本情報_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set特定入所者費用_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set特定診療費_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set社福軽減額_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set給付費明細_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set給付費明細住特_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set緊急時所定疾患_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set緊急時施設療養費_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set請求額集計_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set食事費用_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        ViewStateHolder.put(ViewStateKeys.証明書入力済フラグ, 証明書入力済フラグ);
    }

    private void 証明書グリッドList設定(ServiceTeikyoShomeishoPanelDiv div) {
        DbJohoViewState 償還払ViewStateDB情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ArrayList<ShomeishoGridList> 証明書グリッドList = new ArrayList<>();
        if (null != div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getDataSource()
                && !div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getDataSource().isEmpty()) {
            for (dgdServiceTeikyoShomeisyo_Row row : div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getDataSource()) {
                ShomeishoGridList 証明書グリッド = new ShomeishoGridList();
                証明書グリッド.set処理(row.getShori());
                証明書グリッド.set事業者番号(row.getData1());
                証明書グリッド.set事業者名(row.getData2() == null ? RString.EMPTY : row.getData2());
                証明書グリッド.set明細(row.getData3());
                証明書グリッド.setサービス提供証明書(row.getData4());
                証明書グリッド.set処理区分(row.getShoriKubun());
                証明書グリッドList.add(証明書グリッド);
            }
        }
        償還払ViewStateDB情報.set証明書グリッドリスト(証明書グリッドList);
        ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, 償還払ViewStateDB情報);
    }

    private void 証明書変更済フラグ初期化() {
        ShomeishoHenkoFlag 証明書変更済フラグ = new ShomeishoHenkoFlag();
        証明書変更済フラグ.setサービス計画費_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set基本情報_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set特定入所者費用_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set特定診療費_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set社福軽減額_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set給付費明細_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set給付費明細住特_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set緊急時所定疾患_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set緊急時施設療養費_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set請求額集計_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        証明書変更済フラグ.set食事費用_証明書変更済フラグ(ShomeishoHenkoKubunType.変更なし);
        ViewStateHolder.put(ViewStateKeys.証明書変更済フラグ, 証明書変更済フラグ);
    }

    private void 入力有無フラグ設定() {
        DbJohoViewState 償還払ViewStateDB情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        if (null != 償還払ViewStateDB情報 && null != 償還払ViewStateDB情報.get証明書入力完了フラグMap()) {
            for (Map.Entry entry : 償還払ViewStateDB情報.get証明書入力完了フラグMap().entrySet()) {
                ShomeishoNyuryokuKanryoKubunType 証明書入力完了フラグ = (ShomeishoNyuryokuKanryoKubunType) entry.getValue();
                if (入力完了.equals(証明書入力完了フラグ.getCode())) {
                    ViewStateHolder.put(ViewStateKeys.申請書入力済フラグ_サービス提供証明書, 変更あり);
                }
            }
        }
//        if (null != 償還払ViewStateDB情報 && null != 償還払ViewStateDB情報.get証明書変更済フラグMap()) {
//            Map<ShoukanharaihishinseimeisaikensakuParameter, ShomeishoHenkoFlag> 証明書変更済フラグMap = 償還払ViewStateDB情報.get証明書変更済フラグMap();
//            for (Map.Entry entry : 証明書変更済フラグMap.entrySet()) {
//                ShomeishoHenkoFlag 証明書変更済フラグ = (ShomeishoHenkoFlag) entry.getValue();
//                if (ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.getサービス計画費_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get基本情報_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get特定入所者費用_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get特定診療費_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get社福軽減額_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get給付費明細_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get給付費明細住特_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get緊急時所定疾患_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get緊急時施設療養費_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get請求額集計_証明書変更済フラグ().getCode())
//                        || ShomeishoHenkoKubunType.変更あり.getCode().equals(証明書変更済フラグ.get食事費用_証明書変更済フラグ().getCode())) {
//                    ViewStateHolder.put(ViewStateKeys.申請書入力済フラグ_サービス提供証明書, 変更あり);
//                }
//            }
//        }
    }

    private ServiceTeikyoShomeishoPanelHandler getHandler(ServiceTeikyoShomeishoPanelDiv div) {
        return new ServiceTeikyoShomeishoPanelHandler(div);
    }

    private ResponseData<ServiceTeikyoShomeishoPanelDiv> createResponse(ServiceTeikyoShomeishoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
