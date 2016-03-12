/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.ShikyuShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.pnlShinseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820012.ShikyuShinseiDetailParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払支給申請の支給申請を登録する画面のHandler
 */
public final class ShikyuShinseiDetailHandler {

    private final ShikyuShinseiDetailDiv div;
    private static final RString MODEL_ADD = new RString("新規");
    private static final RString MODEL_UPD = new RString("修正");
    private static final RString MODEL_DEL = new RString("削除");
    private static final RString JUTAKUARI = new RString("2");
    private static final RString JUTAKUNASHI = new RString("1");
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final int SIX = 6;

    /**
     * コンストラクタです。
     *
     * @param div 償還払支給申請の支給申請Div
     */
    private ShikyuShinseiDetailHandler(ShikyuShinseiDetailDiv div) {
        this.div = div;
    }

    /**
     * 生成されたインタフェースを返します
     *
     * @param div 償還払支給申請の支給申請Div
     * @return ShikyuShinseiDetailHandler
     */
    public static ShikyuShinseiDetailHandler of(ShikyuShinseiDetailDiv div) {
        return new ShikyuShinseiDetailHandler(div);
    }

    /**
     * 介護宛名情報のデータをロードする。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void load介護宛名情報(ShikibetsuCode 識別コード) {
        div.getPanelUp().getCcdKaigoAtenaInfo().onLoad(識別コード);
    }

    /**
     * 介護資格系基本情報のデータをロードする。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void load介護資格系基本情報(ShikibetsuCode 識別コード) {
        div.getPanelUp().getCcdKaigoShikakuKihon().onLoad(識別コード);
    }

    /**
     * 支給申請一覧情報をロードする。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @param 処理モード 処理モード
     */
    public void load支給申請一覧情報(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            RString 処理モード) {
        RString config = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
        if (MODEL_ADD.equals(処理モード)) {
            if (JUTAKUNASHI.equals(config)) {
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(false);
            } else if (JUTAKUARI.equals(config)) {
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(true);
            }
            div.getPnlShinsei().getChkKokuhorenSaiso().setVisible(true);
            return;
        }

        div.getPanelHead().getTxtShoriMode().setValue(処理モード);
        ShokanShinsei 償還払支給申請 = get償還払支給申請(被保険者番号, サービス年月, 整理番号);
        if (!MODEL_DEL.equals(処理モード)) {
            set申請共通エリア(償還払支給申請);
        } else {
            div.getPnlShinsei().getChkKokuhorenSaiso().setVisible(true);
            div.getPnlShinsei().setDisabled(true);
        }
        set申請明細エリア(償還払支給申請, 処理モード);

        if (!JUTAKUARI.equals(config)) {
            return;
        }
        if (償還払支給申請.is国保連再送付フラグ() && null != 償還払支給申請.get送付年月()) {
            div.getPnlShinsei().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(申請を保存する, true);
            ShokanHanteiKekka 償還払支給判定結果 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                    getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
            if (null != 償還払支給判定結果) {
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(false);
            } else {
                div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(true);
            }
        }
    }

    private ShokanShinsei get償還払支給申請(
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

    /**
     * 支給申請を登録する。
     *
     * @param 画面モード RString
     * @return boolean 整理番号
     */
    public RString insert(RString 画面モード) {
        RString 整理番号 = InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteManager.class).
                insDbT3034ShokanShinsei(get画面データ(画面モード));
        return 整理番号;
    }

    /**
     * 支給申請を更新する。
     *
     * @param 画面モード RString
     * @return boolean 更新結果
     */
    public boolean update(RString 画面モード) {
        int i = InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteManager.class).
                updDbT3034ShokanShinsei(get画面データ(画面モード));
        return i != 0;
    }

    /**
     * 支給申請を削除する。
     *
     * @param 画面モード RString
     * @return boolean 削除結果
     */
    public boolean delete(RString 画面モード) {
        ShikyuShinseiDetailParameter 償還払費申請検索キー = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShikyuShinseiDetailParameter.class);
        HihokenshaNo 被保険者番号 = 償還払費申請検索キー.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(div.getPanelHead().
                getTxtServiceTeikyoYM().getValue().toDateString().substring(0, SIX));
        RString 整理番号 = div.getPanelHead().getTxtSeiribango().getValue();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        int i = InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteManager.class).
                delDbT3034ShokanShinsei(被保険者番号, サービス年月, 整理番号, 識別コード);
        return i != 0;
    }

    /**
     * 変更チェック処理()
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @return boolean
     */
    public boolean is変更あり(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {
        ShokanShinsei 償還払支給申請 = get償還払支給申請(被保険者番号, サービス年月, 整理番号);
        償還払支給申請 = 償還払支給申請.createBuilderForEdit().
                set受付年月日(
                        new FlexibleDate(div.getPnlShinsei().getTxtUketsukeYMD().getValue().toString())).
                set申請年月日(
                        new FlexibleDate(div.getPnlShinsei().getTxtShinseiYMD().getValue().toString())).
                set申請理由(div.getPnlShinsei().getTxtMulShinseiRiyu().getValue()).
                set申請者氏名(div.getPnlShinsei().getTxtShimeiKanji().getDomain().value()).
                set申請者氏名カナ(div.getPnlShinsei().getTxtShimeikana().getDomain().value()).
                set申請者電話番号(div.getPnlShinsei().getTxtTelNo().getDomain()).
                set支払金額合計(div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue()).build();

        if (new RString("本人").equals(div.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue())) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請者区分(new RString("1")).build();
        } else if (new RString("代理人").equals(div.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue())) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請者区分(new RString("2")).build();
        }

        return 償還払支給申請.hasChanged();
    }

    /**
     * 変更チェック処理2()
     *
     * @return boolean
     */
    public boolean is変更あり2() {
        pnlShinseiDiv pnlDiv = div.getPnlShinsei();
        if (pnlDiv.getTxtUketsukeYMD() != null) {
            return true;
        }
        if (pnlDiv.getTxtShinseiYMD() != null) {
            return true;
        }
        if (pnlDiv.getTxtKisaiHokensyaBango() != null) {
            return true;
        }
        if (pnlDiv.getTxtShimeikana() != null) {
            return true;
        }
        if (pnlDiv.getTxtShimeiKanji() != null) {
            return true;
        }
        if (pnlDiv.getTxtTelNo() != null) {
            return true;
        }
        if (pnlDiv.getTxtMulShinseiRiyu() != null) {
            return true;
        }
        if (pnlDiv.getTxtNumShiharaKingakuGk() != null) {
            return true;
        }

        return false;
    }

    private void set申請共通エリア(ShokanShinsei 償還払支給申請) {
        div.getPanelHead().getTxtSeiribango().setValue(償還払支給申請.get整理番号());
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(償還払支給申請.getサービス提供年月().toString()));
    }

    private void set申請明細エリア(ShokanShinsei 償還払支給申請, RString 処理モード) {
        if (償還払支給申請.get申請年月日() != null) {
            div.getPnlShinsei().getTxtShinseiYMD().setValue(new RDate(償還払支給申請.get申請年月日().toString()));
        }
        div.getPnlShinsei().getTxtUketsukeYMD().setValue(new RDate(償還払支給申請.get受付年月日().toString()));

        if (JUTAKUNASHI.equals(償還払支給申請.get申請者区分())) {
            div.getPnlShinsei().getRdoShinseisyaKubun().setSelectedValue(new RString("本人"));
        } else if (JUTAKUARI.equals(償還払支給申請.get申請者区分())) {
            div.getPnlShinsei().getRdoShinseisyaKubun().setSelectedValue(new RString("代理人"));
        }
        div.getPnlShinsei().getTxtKisaiHokensyaBango().setValue(償還払支給申請.get証記載保険者番号().value());
        div.getPnlShinsei().getTxtShimeikana().setDomain(new AtenaKanaMeisho(償還払支給申請.get申請者氏名カナ()));
        div.getPnlShinsei().getTxtShimeiKanji().setDomain(new AtenaMeisho(償還払支給申請.get申請者氏名()));
        div.getPnlShinsei().getTxtTelNo().setDomain(償還払支給申請.get申請者電話番号());
        div.getPnlShinsei().getTxtMulShinseiRiyu().setValue(償還払支給申請.get申請理由());
        div.getPnlShinsei().getTxtNumShiharaKingakuGk().setValue(償還払支給申請.get支払金額合計());
        div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().setValue(new Decimal(償還払支給申請.get保険給付額()));
        div.getPnlShinsei().getTxtNumHokenKyufuGaku().setValue(new Decimal(償還払支給申請.get利用者負担額()));

        if (MODEL_UPD.equals(処理モード) && 償還払支給申請.is国保連再送付フラグ()
                && null != 償還払支給申請.get送付年月() && !償還払支給申請.get送付年月().isEmpty()) {
            div.getPnlShinsei().getChkKokuhorenSaiso().setDisabled(false);
            List<KeyValueDataSource> items = div.getPnlShinsei().getChkKokuhorenSaiso().getDataSource();
            div.getPnlShinsei().getChkKokuhorenSaiso().setSelectedItems(items);
        }
    }

    private ShokanShinsei get画面データ(RString 画面モード) {
        RString config = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
        RString 審査方法区分 = null;
        if (JUTAKUNASHI.equals(config)) {
            審査方法区分 = ShinsaHohoKubun.審査済み.getコード();
        } else if (JUTAKUARI.equals(config)) {
            審査方法区分 = ShinsaHohoKubun.審査依頼.getコード();
        }
        ShikyuShinseiDetailParameter 償還払費申請検索キー = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShikyuShinseiDetailParameter.class);
        HihokenshaNo 被保険者番号 = 償還払費申請検索キー.getHiHokenshaNo();
        FlexibleYearMonth サービス提供年月 = 償還払費申請検索キー.getServiceTeikyoYM();
        RString 整理番号 = div.getPanelHead().getTxtSeiribango().getValue();
        ShokanShinsei 償還払支給申請 = ViewStateHolder.get(ViewStateKeys.償還払支給申請詳細データ, ShokanShinsei.class);
        if (MODEL_ADD.equals(画面モード)) {
            償還払支給申請 = new ShokanShinsei(被保険者番号, サービス提供年月, 整理番号);
        }

        償還払支給申請 = 償還払支給申請.createBuilderForEdit().
                setサービス提供年月(サービス提供年月).
                set被保険者番号(被保険者番号).
                set受付年月日(new FlexibleDate(div.getPnlShinsei().getTxtUketsukeYMD().
                                getValue().toString())).
                set証記載保険者番号(new ShoKisaiHokenshaNo(div.getPnlShinsei().getTxtKisaiHokensyaBango().getValue())).
                set申請理由(div.getPnlShinsei().getTxtMulShinseiRiyu().getValue()).
                set申請者氏名(div.getPnlShinsei().getTxtShimeiKanji().getDomain().value()).
                set申請者氏名カナ(div.getPnlShinsei().getTxtShimeikana().getDomain().value()).
                set支払金額合計(div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue()).
                set保険対象費用額(div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue()).build();

        if (div.getPnlShinsei().getTxtShinseiYMD().getValue() != null) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請年月日(new FlexibleDate(
                    div.getPnlShinsei().getTxtShinseiYMD().getValue().toString())).build();
        }

        if (new RString("本人").equals(div.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue())) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請者区分(new RString("1")).build();
        } else if (new RString("代理人").equals(div.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue())) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set申請者区分(new RString("2")).build();
        }

        if (div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().getValue() != null) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set保険給付額(Integer.valueOf(
                    div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().getValue().toString())).build();
        }

        if (div.getPnlShinsei().getTxtNumHokenKyufuGaku().getValue() != null) {
            償還払支給申請 = 償還払支給申請.createBuilderForEdit().set利用者負担額(Integer.valueOf(
                    div.getPnlShinsei().getTxtNumHokenKyufuGaku().getValue().toString())).build();
        }

        if (MODEL_ADD.equals(画面モード)) {
            return 償還払支給申請.createBuilderForEdit().
                    set支給申請審査区分(ShikyushinseiShinsaKubun.未審査.getコード()).
                    set審査方法区分(審査方法区分).
                    build();
        } else if (MODEL_UPD.equals(画面モード)) {
            return 償還払支給申請.createBuilderForEdit().
                    set整理番号(整理番号).
                    build();
        }
        return 償還払支給申請;
    }

    /**
     * ViewStateに以下の情報を設定する
     */
    public void putViewState() {
        RString 処理モード = div.getPanelHead().getTxtShoriMode().getValue();
        ViewStateHolder.put(ViewStateKeys.処理モード, 処理モード);

        ShikyuShinseiDetailParameter 償還払費申請検索キー = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShikyuShinseiDetailParameter.class);
        HihokenshaNo 被保険者番号 = 償還払費申請検索キー.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(
                div.getPanelHead().getTxtServiceTeikyoYM().getValue().toDateString().substring(0, SIX));
        RString 整理番号 = div.getPanelHead().getTxtSeiribango().getValue();
        ShikyuShinseiDetailParameter parameter = new ShikyuShinseiDetailParameter(被保険者番号, サービス年月, 整理番号);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, parameter);
    }
}
