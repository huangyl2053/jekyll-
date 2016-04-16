/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820014;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.DBC0820014TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014.ServiceTeikyoShomeishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820014.ServiceTeikyoShomeishoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書クラスです。
 *
 * @reamsid_L DBC-1030-130 gongliang
 */
public class ServiceTeikyoShomeishoPanel {

    private static final RString 登録モード = new RString("登録");
    private static final RString 処理モード_修正 = new RString("修正");
    private static final RString 処理モード_登録 = new RString("登録");
    private static final RString 処理モード_削除 = new RString("削除");

    /**
     * 画面初期化onLoad
     *
     * @param div ServiceKeikakuHiDiv
     * @return 償還払い状況照会_サービス計画費画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onLoad(ServiceTeikyoShomeishoPanelDiv div) {

        // TODO うそのデータ
        ShoukanharaihishinseikensakuParameter par = new ShoukanharaihishinseikensakuParameter(
                new HihokenshaNo("000000003"),
                new FlexibleYearMonth(new RString("200501")),
                new RString("0000000003"),
                new JigyoshaNo("0000000003"),
                new RString("2165"),
                new RString("0003"),
                Decimal.ZERO);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        ViewStateHolder.put(ViewStateKeys.画面モード, 処理モード_修正);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo("000000003"));
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, new FlexibleYearMonth("201601"));
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        RString 様式番号 = paramter.getYoshikiNo();
        RString 明細番号 = paramter.getMeisaiNo();
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.様式番号, 様式番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        ViewStateHolder.put(ViewStateKeys.明細番号, 明細番号);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        ServiceTeikyoShomeishoPanelHandler handler = getHandler(div);

        List<ShikibetsuNoKanri> 証明書リスト = SyokanbaraihiShikyuShinseiKetteManager
                .createInstance().getShikibetsuNoKanri(サービス提供年月);
        // TODO QA528 償還払支給申請の取得。
        ShokanShinsei 償還払支給申請 = handler.get償還払支給申請(被保険者番号, サービス年月, 整理番号);
        // TODO QA529 様式番号がありません。
        List<ServiceTeikyoShomeishoResult> 証明書一覧情報 = ShokanbaraiJyokyoShokai
                .createInstance().getServiceTeikyoShomeishoList(被保険者番号, サービス年月, 整理番号, 様式番号);
        handler.load宛名と基本情報(識別コード, 被保険者番号);
        handler.loadボタンエリア(画面モード, 償還払支給申請.is国保連再送付フラグ());
        handler.load申請共通エリア(画面モード, 償還払支給申請);
        handler.load申請明細エリア(画面モード, 償還払支給申請, 証明書リスト, 証明書一覧情報);
        return createResponse(div);
    }

    /**
     * 「申請情報」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払支給申請_支給申請画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_btnShinseiInfo(ServiceTeikyoShomeishoPanelDiv div) {
        // TODO QA528。処理モードの設定。
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (登録モード.equals(画面モード)) {
            ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード_修正);
        } else {
            ViewStateHolder.put(ViewStateKeys.処理モード, 画面モード);
        }
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.申請情報).respond();
    }

    /**
     * 「口座情報」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払支給申請_口座登録画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_btnKouzaInfo(ServiceTeikyoShomeishoPanelDiv div) {
        ServiceTeikyoShomeishoPanelHandler handler = getHandler(div);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ViewStateHolder.put(ViewStateKeys.処理モード, 画面モード);
        handler.申請既存チェック();
        handler.putViewState();
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.口座情報).respond();
    }

    /**
     * 「償還払決定情報」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払支給申請一覧画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_btnShokanKeteiInfo(ServiceTeikyoShomeishoPanelDiv div) {
        ServiceTeikyoShomeishoPanelHandler handler = getHandler(div);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ViewStateHolder.put(ViewStateKeys.処理モード, 画面モード);
        handler.申請既存チェック();
        handler.putViewState();
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
        handler.証明書選択チェック();
        handler.サービス提供証明書の存在チェック();
        handler.putViewStateDown(処理モード_登録);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.償還払い費支給申請).respond();
    }

    /**
     * 「グリッドの修正」ボタンをクリックの処理内容です。
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払費支給申請決定_サービス提供証明書(基本情報)画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_Modify(ServiceTeikyoShomeishoPanelDiv div) {
        getHandler(div).putViewStateDown(処理モード_修正);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.償還払い費支給申請).respond();
    }

    /**
     *
     *
     * @param div ServiceTeikyoShomeishoPanelDiv
     * @return 償還払費支給申請決定_サービス提供証明書(基本情報)画面
     */
    public ResponseData<ServiceTeikyoShomeishoPanelDiv> onClick_Delete(ServiceTeikyoShomeishoPanelDiv div) {
        getHandler(div).putViewStateDown(処理モード_削除);
        return ResponseData.of(div).forwardWithEventName(DBC0820014TransitionEventName.償還払い費支給申請).respond();
    }

    private ServiceTeikyoShomeishoPanelHandler getHandler(ServiceTeikyoShomeishoPanelDiv div) {
        return new ServiceTeikyoShomeishoPanelHandler(div);
    }

    private ResponseData<ServiceTeikyoShomeishoPanelDiv> createResponse(ServiceTeikyoShomeishoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
