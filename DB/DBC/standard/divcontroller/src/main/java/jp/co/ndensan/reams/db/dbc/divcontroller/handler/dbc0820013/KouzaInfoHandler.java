/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820013;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013.KouzaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払い費支給申請決定_口座情報画面
 */
public class KouzaInfoHandler {

    private final KouzaInfoPanelDiv div;
    private static final RString 受託なし = new RString("1");
    private static final RString 受託あり = new RString("2");
    private static final long 口座ID = 11111;

    /**
     * KouzaInfoHandler
     *
     * @param div KouzaInfoPanelDiv
     */
    public KouzaInfoHandler(KouzaInfoPanelDiv div) {
        this.div = div;
    }

    /**
     * ヘッダエリアの設定
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     */
    public void loadヘッダエリア(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        div.getPanelOne().getCcdKaigoAtenaInfo().onLoad(識別コード);
        div.getPanelOne().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
    }

    /**
     * 申請共通エリアの設定
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 処理モード RString
     */
    public void load申請共通エリア(FlexibleYearMonth サービス年月, RString 整理番号, RString 処理モード) {
        if (サービス年月 == null) {
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(null);
        } else {
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        }
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
        div.getPanelTwo().getTxtShoriMode().setValue(処理モード);
    }

    /**
     * 登録モードの初期化。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 国保連送付フラグ Boolean
     */
    public void load登録(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            Boolean 国保連送付フラグ) {
        RString config = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
        if (受託なし.equals(config)) {
            div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(false);
        } else if (受託あり.equals(config) && 国保連送付フラグ) {
            ShokanHanteiKekka shokanHanteiKekka = SyokanbaraihiShikyuShinseiKetteManager
                    .createInstance().getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
            償還払決定情報visible(shokanHanteiKekka);
        }
    }

    /**
     * 「申請情報」ボタン Handler処理
     */
    public void onClick_btnShinseiInfo() {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        setViewState(処理モード);
        // TODO QA252　画面モード：当画面モード =登録モードの場合、修正　画面へ遷移。
//        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
//        if (登録.equals(状態)) {
//            setViewState(処理モード, 修正);
//        } else {
//            setViewState(処理モード, 状態);
//        }
    }

    /**
     * 「申請情報」ボタン Handler処理
     */
    public void onClick_btnKouzaInfo() {
        // TODO QA252
    }

    /**
     * 「サービス提供証明書」ボタン Handler処理
     */
    public void onClick_btnServiceTeikyoShomeisyo() {
        // TODO　QA252 画面モードの用处　
//        RString 画面モード = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        setViewState(処理モード);
    }

    /**
     * 「償還払決定情報」ボタン Handler処理
     */
    public void onClick_btnShokanbaraiKeiteInfo() {
        // TODO　QA252 画面モードの用处
//        RString 画面モード = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        setViewState(処理モード);
    }

    /**
     * 申請既存チェック
     */
    public void 申請既存チェック() {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        List<ShokanShinsei> entity = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("償還払支給申請"));
        }
    }

    /**
     * 画面内容の変更有無チェック
     *
     * @return 画面内容の変更
     */
    public Boolean 変更有無チェック() {
        // TODO QA #76941 再提出
        return true;
    }

    /**
     * 「申請を保存する」ボタン 登録、修正の場合
     */
    public void 保存_修正() {
        ShokanShinsei entityView = ViewStateHolder.get(ViewStateKeys.償還払い費支給申請決定_口座情報, ShokanShinsei.class);
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        RString 支払場所 = new RString("償還払費");
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        RString 支払方法区分コード = new RString("1");
        FlexibleDate 支払期間開始年月日 = new FlexibleDate("20150101");
        FlexibleDate 支払期間終了年月日 = new FlexibleDate("20150102");
        RString 支払窓口開始時間 = new RString("02");
        RString 支払窓口終了時間 = new RString("01");
        long 口座Id = 口座ID;
//        ShokanShinsei entity = new ShokanShinsei(被保険者番号, サービス年月, new RString("0011"));
        entityView = entityView.createBuilderForEdit()
                .set支払場所(支払場所)
                .set被保険者番号(被保険者番号)
                .setサービス提供年月(サービス年月)
                .set整理番号(整理番号)
                .set支払方法区分コード(支払方法区分コード)
                .set支払期間開始年月日(支払期間開始年月日)
                .set支払期間終了年月日(支払期間終了年月日)
                .set支払窓口開始時間(支払窓口開始時間)
                .set支払窓口終了時間(支払窓口終了時間)
                .set口座ID(口座Id)
                .set受領委任契約番号(整理番号).build();
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updDbT3034ShokanShinsei(entityView);
    }

    /**
     * 「申請を保存する」ボタン 削除モードの場合
     */
    public void 保存_削除() {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().delDbT3034ShokanShinsei(被保険者番号, サービス年月, 整理番号, 識別コード);
    }

    /**
     * 償還払支給申請詳細データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @return 償還払支給申請
     */
    public ShokanShinsei get償還払支給申請(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {
        List<ShokanShinsei> 支給申請一覧情報リスト = InstanceProvider.create(ShokanbaraiJyokyoShokai.class)
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (支給申請一覧情報リスト.isEmpty()) {
            return new ShokanShinsei(被保険者番号, サービス年月, 整理番号);
        }
        ViewStateHolder.put(ViewStateKeys.償還払支給申請詳細データ, 支給申請一覧情報リスト.get(0));
        return 支給申請一覧情報リスト.get(0);
    }

    private void 償還払決定情報visible(ShokanHanteiKekka shokanHanteiKekka) {
        if (shokanHanteiKekka != null) {
            div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(false);
        } else {
            div.getPanelTwo().getBtnShokanbaraiKeiteInfo().setDisabled(true);
        }
    }

    private void setViewState(RString 処理モード) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = null;
        if (div.getPanelTwo().getTxtServiceTeikyoYM().getValue() != null) {
            サービス年月 = new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getValue().toString());
        }
        RString 整理番号 = div.getPanelTwo().getTxtSeiriBango().getValue();
        SyokanbaraihishikyushinseiketteParameter parameter = new SyokanbaraihishikyushinseiketteParameter(
                被保険者番号, サービス年月, 整理番号, null, null, null, null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, parameter);
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード);
    }
}
