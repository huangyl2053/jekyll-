/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.KihonInfoMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 償還払支給申請_サービス提供証明書_基本情報画面のハンドラクラスです。
 *
 * @reamsid_L DBC-1030-020 wangkanglei
 */
public class KihonInfoMainPanelHandler {

    private final KihonInfoMainPanelDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可必須 = new RString("1");
    private static final RString 設定可任意 = new RString("2");
    private static final RString 削除 = new RString("削除");
    private static final RString 固定明細番号 = new RString("0001");
    private static final RString 入所年月日 = new RString("入所年月日");
    private static final RString 退所年月日 = new RString("退所年月日");
    private static final RString KEY = new RString("key0");
    private static final RString 有 = new RString("2");
    private static final RString 無し = new RString("1");
    private static final int 日数 = 30;
    private static final int NUM_1 = 1;
    private static final FlexibleYearMonth 平成２１年３月 = new FlexibleYearMonth("200903");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成14年１月 = new FlexibleYearMonth("200201");
    private static final RString コード_0001 = new RString("0001");
    private static final RString コード_0009 = new RString("0009");
    private static final RString コード_0048 = new RString("0048");
    private static final RString コード_0010 = new RString("0010");
    private static final RString STR_2171 = new RString("2171");
    private static final RString STR_2172 = new RString("2172");
    private static final RString STR_2173 = new RString("2173");
    private static final RString STR_2174 = new RString("2174");
    private static final RString STR_2181 = new RString("2181");
    private static final RString STR_2182 = new RString("2182");
    private static final RString STR_2183 = new RString("2183");
    private static final RString STR_2191 = new RString("2191");
    private static final RString STR_2192 = new RString("2192");
    private static final RString STR_2193 = new RString("2193");
    private static final RString STR_2194 = new RString("2194");
    private static final RString STR_2195 = new RString("2195");
    private static final RString STR_21A1 = new RString("21A1");
    private static final RString STR_21A2 = new RString("21A2");
    private static final RString STR_21A3 = new RString("21A3");
    private static final RString STR_2144 = new RString("2144");
    private static final RString STR_2154 = new RString("2154");
    private static final RString STR_2156 = new RString("2156");
    private static final RString STR_2165 = new RString("2165");
    private static final RString STR_2142 = new RString("2142");
    private static final RString STR_2143 = new RString("2143");
    private static final RString STR_2152 = new RString("2152");
    private static final RString STR_2153 = new RString("2153");
    private static final RString STR_2155 = new RString("2155");
    private static final RString STR_2162 = new RString("2162");
    private static final RString STR_2163 = new RString("2163");
    private static final RString STR_2164 = new RString("2164");

    /**
     * コンストラクタです。
     *
     * @param div KihonInfoMainPanelDiv
     */
    public KihonInfoMainPanelHandler(KihonInfoMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 申請共通エリアの設定のメソッドます。
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 申請日 RDate
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void set申請共通エリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RDate 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelTwo().getTxtShinseiDate().setValue(申請日);
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
    }

    /**
     * 画面の個別設定を行うのメソッドます。
     */
    public void set初期基本情報() {
        FlexibleDate date = new FlexibleDate(RDate.getNowDate().toDateString());
        List<UzT0007CodeEntity> codeList1 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(コード_0001), date);
        List<KeyValueDataSource> keyValueDataSource1 = new ArrayList<>();
        keyValueDataSource1.add(new KeyValueDataSource(KEY, RString.EMPTY));
        for (UzT0007CodeEntity code : codeList1) {
            keyValueDataSource1.add(new KeyValueDataSource(code.getコード().value(), code.getコード名称()));
        }
        div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun().setDataSource(keyValueDataSource1);

        List<UzT0007CodeEntity> codeList2 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(コード_0009), date);
        List<KeyValueDataSource> keyValueDataSource2 = new ArrayList<>();
        keyValueDataSource2.add(new KeyValueDataSource(KEY, RString.EMPTY));
        for (UzT0007CodeEntity code : codeList2) {
            keyValueDataSource2.add(new KeyValueDataSource(code.getコード().value(), code.getコード名称()));
        }
        div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setDataSource(keyValueDataSource2);

        List<UzT0007CodeEntity> codeList3 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(コード_0048), date);
        List<KeyValueDataSource> keyValueDataSource3 = new ArrayList<>();
        keyValueDataSource3.add(new KeyValueDataSource(KEY, RString.EMPTY));
        for (UzT0007CodeEntity code : codeList3) {
            keyValueDataSource3.add(new KeyValueDataSource(code.getコード().value(), code.getコード名称()));
        }
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setDataSource(keyValueDataSource3);

        List<UzT0007CodeEntity> codeList4 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(コード_0010), date);
        List<KeyValueDataSource> keyValueDataSource4 = new ArrayList<>();
        keyValueDataSource4.add(new KeyValueDataSource(KEY, RString.EMPTY));
        for (UzT0007CodeEntity code : codeList4) {
            keyValueDataSource4.add(new KeyValueDataSource(code.getコード().value(), code.getコード名称()));
        }
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState().setDataSource(keyValueDataSource4);

    }

    /**
     * 取得だれたデータを画面へ設定のメソッドます。
     *
     * @param shokanKihon ShokanKihon
     * @param サービス年月 FlexibleYearMonth
     */
    public void set基本情報(ShokanKihon shokanKihon, FlexibleYearMonth サービス年月) {
        set初期基本情報();
        if (shokanKihon.get居宅サービス計画作成区分コード() != null
                && !shokanKihon.get居宅サービス計画作成区分コード().isEmpty()) {
            div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun().setSelectedKey(
                    shokanKihon.get居宅サービス計画作成区分コード());
        }
        if (有.equals(shokanKihon.get旧措置入所者特例コード())) {
            List<RString> sources = new ArrayList<>();
            sources.add(KEY);
            div.getPanelKihon().getPanelKyotaku().getChkKyusochi().setSelectedItemsByKey(sources);
        }
        if (shokanKihon.get居宅サービス計画事業者番号() != null) {
            div.getPanelKihon().getPanelKyotaku()
                    .getCcdShisetsuJoho().setNyuryokuShisetsuKodo(shokanKihon.get居宅サービス計画事業者番号().value());
        }
        if (shokanKihon.get保険給付率() != null) {
            div.getPanelKihon().getPanelKyotaku().getTxtHokenKyufuritsu().setValue(shokanKihon.get保険給付率().value());
        }
        if (shokanKihon.get開始年月日() != null) {
            div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().setFromValue(
                    new RDate(shokanKihon.get開始年月日().toString()));
        }
        if (shokanKihon.get中止年月日() != null) {
            div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().setToValue(
                    new RDate(shokanKihon.get中止年月日().toString()));
        }
        set登録項目(shokanKihon, サービス年月);
        if (shokanKihon.get入所_院年月日() != null) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().setValue(new RDate(
                    shokanKihon.get入所_院年月日().toString()));
        }
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().setValue(
                new Decimal(shokanKihon.get入所_院実日数()));
        if (shokanKihon.get退所_院年月日() != null) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().setValue(new RDate(
                    shokanKihon.get退所_院年月日().toString()));
        }
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().setValue(
                new Decimal(shokanKihon.get外泊日数()));
        if (shokanKihon.get退所_院後の状態コード() != null
                && !shokanKihon.get退所_院後の状態コード().isEmpty()) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState().setSelectedKey(
                    shokanKihon.get退所_院後の状態コード());
        }
    }

    private void set登録項目(ShokanKihon shokanKihon, FlexibleYearMonth サービス年月) {

        List<RString> list = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        if (サービス年月.isBeforeOrEquals(平成２１年３月)) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setDisplayNone(true);
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setDisplayNone(false);
            if (shokanKihon.get中止理由_入所_院前の状況コード() != null
                    && !shokanKihon.get中止理由_入所_院前の状況コード().isEmpty()) {
                div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setSelectedKey(
                        shokanKihon.get中止理由_入所_院前の状況コード());
            }
        } else if (平成２１年４月.isBeforeOrEquals(サービス年月) && !list.contains(様式番号)) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setDisplayNone(true);
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setDisplayNone(false);
            if (shokanKihon.get中止理由_入所_院前の状況コード() != null
                    && !shokanKihon.get中止理由_入所_院前の状況コード().isEmpty()) {
                div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setSelectedKey(
                        shokanKihon.get中止理由_入所_院前の状況コード());
            }
        } else {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setDisplayNone(false);
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setDisplayNone(true);
            if (shokanKihon.get中止理由_入所_院前の状況コード() != null
                    && !shokanKihon.get中止理由_入所_院前の状況コード().isEmpty()) {
                div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setSelectedKey(
                        shokanKihon.get中止理由_入所_院前の状況コード());
            }
        }
    }

    /**
     * データ保存処理を行うのメソッドます。
     *
     * @return 明細番号 RString
     */
    public RString 保存処理() {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanSyomeisyo(
                    被保険者番号,
                    サービス年月,
                    整理番号,
                    事業者番号,
                    様式番号,
                    明細番号);
        } else {
            明細番号 = RString.EMPTY;
            ShokanKihon shokanKihon = ViewStateHolder.get(ViewStateKeys.償還払請求基本データ, ShokanKihon.class);
            if (shokanKihon == null) {
                shokanKihon = new ShokanKihon(
                        被保険者番号,
                        サービス年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        固定明細番号).createBuilderForEdit().build();
                shokanKihon = save基本情報(shokanKihon, サービス年月, 様式番号);
            } else {
                shokanKihon = save基本情報(shokanKihon, サービス年月, 様式番号);
            }
            明細番号 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKihon(明細番号, shokanKihon);
        }
        return 明細番号;
    }

    private ShokanKihon save基本情報(ShokanKihon shokanKihon, FlexibleYearMonth サービス年月, RString 様式番号) {
        List<RString> keyList = div.getPanelKihon().getPanelKyotaku().getChkKyusochi().getSelectedKeys();
        if (!keyList.isEmpty()) {
            shokanKihon = shokanKihon.createBuilderForEdit().set旧措置入所者特例コード(有).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set旧措置入所者特例コード(無し).build();
        }
        RString 居宅サービス計画作成区分Key = div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun()
                .getSelectedKey();
        if (!居宅サービス計画作成区分Key.equals(KEY)) {
            shokanKihon = shokanKihon.createBuilderForEdit()
                    .set居宅サービス計画作成区分コード(居宅サービス計画作成区分Key).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set居宅サービス計画作成区分コード(null).build();
        }
        RString 居宅サービス計画事業者番号 = div.getPanelKihon().getPanelKyotaku()
                .getCcdShisetsuJoho().getNyuryokuShisetsuKodo();
        if (!居宅サービス計画事業者番号.isEmpty()) {
            shokanKihon = shokanKihon.createBuilderForEdit()
                    .set居宅サービス計画事業者番号(new JigyoshaNo(居宅サービス計画事業者番号)).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set居宅サービス計画事業者番号(null).build();
        }
        RDate 開始年月日 = div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().getFromValue();
        if (開始年月日 != null) {
            shokanKihon = shokanKihon.createBuilderForEdit()
                    .set開始年月日(new FlexibleDate(開始年月日.toString())).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set開始年月日(null).build();
        }
        RDate 中止年月日 = div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().getToValue();
        if (中止年月日 != null) {
            shokanKihon = shokanKihon.createBuilderForEdit()
                    .set中止年月日(new FlexibleDate(中止年月日.toString())).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set中止年月日(null).build();
        }
        shokanKihon = save登録項目(shokanKihon, サービス年月, 様式番号);
        RDate 入所_院年月日 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue();
        if (入所_院年月日 != null) {
            shokanKihon = shokanKihon.createBuilderForEdit()
                    .set入所_院年月日(new FlexibleDate(入所_院年月日.toString())).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set入所_院年月日(null).build();
        }
        RDate 退所_院年月日 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().getValue();
        if (退所_院年月日 != null) {
            shokanKihon = shokanKihon.createBuilderForEdit()
                    .set退所_院年月日(new FlexibleDate(退所_院年月日.toString())).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set退所_院年月日(null).build();
        }
        Decimal 入所_院実日数 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().getValue();
        if (入所_院実日数 != null) {
            shokanKihon = shokanKihon.createBuilderForEdit().set入所_院実日数(入所_院実日数.intValue()).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set入所_院実日数(0).build();
        }
        Decimal 外泊日数 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().getValue();
        if (外泊日数 != null) {
            shokanKihon = shokanKihon.createBuilderForEdit().set外泊日数(外泊日数.intValue()).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set外泊日数(0).build();
        }
        RString 退所_院後の状態Key = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState()
                .getSelectedKey();
        if (!退所_院後の状態Key.equals(KEY)) {
            shokanKihon = shokanKihon.createBuilderForEdit().set退所_院後の状態コード(退所_院後の状態Key).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set退所_院後の状態コード(null).build();
        }
        Decimal 保険給付率 = div.getPanelKihon().getPanelKyotaku().getTxtHokenKyufuritsu().getValue();
        if (保険給付率 != null) {
            shokanKihon = shokanKihon.createBuilderForEdit().set保険給付率(new HokenKyufuRitsu(保険給付率)).build();
        } else {
            shokanKihon = shokanKihon.createBuilderForEdit().set保険給付率(null).build();
        }
        return shokanKihon;
    }

    private ShokanKihon save登録項目(ShokanKihon shokanKihon, FlexibleYearMonth サービス年月, RString 様式番号) {
        List<RString> list = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        RString 中止理由Key;
        RString 入所_院前の状況Key;
        if (サービス年月.isBeforeOrEquals(平成２１年３月)) {
            中止理由Key = div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().getSelectedKey();
            if (!中止理由Key.equals(KEY)) {
                shokanKihon = shokanKihon.createBuilderForEdit().set中止理由_入所_院前の状況コード(中止理由Key).build();
            } else {
                shokanKihon = shokanKihon.createBuilderForEdit().set中止理由_入所_院前の状況コード(無し).build();
            }
        } else if (平成２１年４月.isBeforeOrEquals(サービス年月) && !list.contains(様式番号)) {
            中止理由Key = div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu()
                    .getSelectedKey();
            if (!中止理由Key.equals(KEY)) {
                shokanKihon = shokanKihon.createBuilderForEdit().set中止理由_入所_院前の状況コード(中止理由Key).build();
            } else {
                shokanKihon = shokanKihon.createBuilderForEdit().set中止理由_入所_院前の状況コード(無し).build();
            }
        } else {
            入所_院前の状況Key = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState()
                    .getSelectedKey();
            if (!入所_院前の状況Key.equals(KEY)) {
                shokanKihon = shokanKihon.createBuilderForEdit()
                        .set中止理由_入所_院前の状況コード(入所_院前の状況Key).build();
            } else {
                shokanKihon = shokanKihon.createBuilderForEdit().set中止理由_入所_院前の状況コード(無し).build();
            }
        }
        return shokanKihon;
    }

    /**
     * 画面内容の変更有無チェックを行うのメソッドます。
     *
     * @return boolean
     */
    public boolean get内容変更状態() {
        ShokanKihon shokanKihon = ViewStateHolder.get(ViewStateKeys.償還払請求基本データ, ShokanKihon.class);
        RString 明細番号 = div.getPanelTwo().getTxtMeisaiBango().getValue();
        if (shokanKihon != null && 明細番号 != null && !明細番号.isEmpty()) {
            if (checkPanelKyotaku(shokanKihon)) {
                return true;
            }
            if (checkPanelServiceKikan(shokanKihon)) {
                return true;
            }
            return checkPanelShisetuNyutaisyoInfo(shokanKihon);
        } else {
            return check登録場合();
        }
    }

    private boolean check登録場合() {
        RString 事業者 = div.getPanelKihon().getPanelKyotaku().getCcdShisetsuJoho().getNyuryokuShisetsuKodo();
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        List<RString> list = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        if (is登録場合(事業者)) {
            if ((サービス年月.isBeforeOrEquals(平成２１年３月) || (平成２１年４月.isBeforeOrEquals(サービス年月)
                    && !list.contains(様式番号)))
                    && div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu()
                    .getSelectedKey().equals(KEY)) {
                return false;
            }
            if ((!サービス年月.isBeforeOrEquals(平成２１年３月)
                    && !(平成２１年４月.isBeforeOrEquals(サービス年月) && !list.contains(様式番号)))
                    && div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState()
                    .getSelectedKey().equals(KEY)) {
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean is登録場合(RString 事業者) {
        return div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun().getSelectedKey().equals(KEY)
                && div.getPanelKihon().getPanelKyotaku().getChkKyusochi().getSelectedKeys().isEmpty()
                && (事業者 == null || 事業者.isEmpty())
                && div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().getFromValue() == null
                && div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().getToValue() == null
                && div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue() == null
                && div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().getValue() == null
                && div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().getValue() == null
                && div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().getValue() == null
                && div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState().getSelectedKey().equals(KEY);
    }

    private boolean checkPanelKyotaku(ShokanKihon shokanKihon) {
        RString 居宅サービス計画作成区分コード = shokanKihon.get居宅サービス計画作成区分コード();
        RString 居宅サービス計画作成区分Key = div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun()
                .getSelectedKey();
        if (居宅サービス計画作成区分コード == null || 居宅サービス計画作成区分コード.isEmpty()) {
            if (!居宅サービス計画作成区分Key.equals(KEY)) {
                return true;
            }
        } else if (!居宅サービス計画作成区分コード.equals(居宅サービス計画作成区分Key)) {
            return true;
        }

        RString 旧措置入所者特例コード = shokanKihon.get旧措置入所者特例コード();
        List<RString> keyList = div.getPanelKihon().getPanelKyotaku().getChkKyusochi().getSelectedKeys();
        if (旧措置入所者特例コード == null && !keyList.isEmpty()) {
            return true;
        }
        if (旧措置入所者特例コード != null) {
            if (!keyList.isEmpty() && !有.equals(旧措置入所者特例コード)) {
                return true;
            } else if (keyList.isEmpty() && !無し.equals(旧措置入所者特例コード)) {
                return true;
            }
        }
        JigyoshaNo 居宅サービス計画事業者番号 = shokanKihon.get居宅サービス計画事業者番号();
        RString 事業者 = div.getPanelKihon().getPanelKyotaku().getCcdShisetsuJoho().getNyuryokuShisetsuKodo();
        if (居宅サービス計画事業者番号 == null) {
            if (事業者 != null && !事業者.isEmpty()) {
                return true;
            }
        } else {
            if (事業者 == null || 事業者.isEmpty()) {
                return true;
            } else if (!事業者.equals(居宅サービス計画事業者番号.value())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPanelServiceKikan(ShokanKihon shokanKihon) {
        RDate row開始年月日 = div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().getFromValue();
        if (shokanKihon.get開始年月日() == null) {
            if (row開始年月日 != null) {
                return true;
            }
        } else {
            if (row開始年月日 == null) {
                return true;
            } else if (!row開始年月日.equals(new RDate(shokanKihon.get開始年月日().toString()))) {
                return true;
            }
        }

        RDate row中止年月日 = div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().getToValue();
        if (shokanKihon.get中止年月日() == null) {
            if (row中止年月日 != null) {
                return true;
            }
        } else {
            if (row中止年月日 == null) {
                return true;
            } else if (!row中止年月日.equals(new RDate(shokanKihon.get中止年月日().toString()))) {
                return true;
            }
        }

        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        List<RString> list = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        if (サービス年月.isBeforeOrEquals(平成２１年３月)
                || (平成２１年４月.isBeforeOrEquals(サービス年月) && !list.contains(様式番号))) {
            RString 中止理由コード = shokanKihon.get中止理由_入所_院前の状況コード();
            RString 中止理由Key = div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu()
                    .getSelectedKey();
            if (中止理由コード == null || 中止理由コード.isEmpty()) {
                return !中止理由Key.equals(KEY);
            } else if (!中止理由コード.equals(中止理由Key)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPanelShisetuNyutaisyoInfo(ShokanKihon shokanKihon) {
        RDate row入所_院年月日 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue();
        if (shokanKihon.get入所_院年月日() == null) {
            if (row入所_院年月日 != null) {
                return true;
            }
        } else {
            if (row入所_院年月日 == null) {
                return true;
            } else if (!row入所_院年月日.equals(new RDate(shokanKihon.get入所_院年月日().toString()))) {
                return true;
            }
        }

        Decimal row入所_院実日数 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().getValue();
        if (!new Decimal(shokanKihon.get入所_院実日数()).equals(row入所_院実日数)) {
            return true;
        }

        RDate row退所_院年月日 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().getValue();
        if (shokanKihon.get退所_院年月日() == null) {
            if (row退所_院年月日 != null) {
                return true;
            }
        } else {
            if (row退所_院年月日 == null) {
                return true;
            } else if (!row退所_院年月日.equals(new RDate(shokanKihon.get退所_院年月日().toString()))) {
                return true;
            }
        }

        Decimal row外泊日数 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().getValue();
        if (!new Decimal(shokanKihon.get外泊日数()).equals(row外泊日数)) {
            return true;
        }
        return checkDdl(shokanKihon);
    }

    private boolean checkDdl(ShokanKihon shokanKihon) {
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        List<RString> list = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        if (!サービス年月.isBeforeOrEquals(平成２１年３月)
                && !(平成２１年４月.isBeforeOrEquals(サービス年月) && !list.contains(様式番号))) {
            RString 入所_院前の状況コード = shokanKihon.get中止理由_入所_院前の状況コード();
            RString 入所_院前の状況Key = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState()
                    .getSelectedKey();
            if (入所_院前の状況コード == null || 入所_院前の状況コード.isEmpty()) {
                return !入所_院前の状況Key.equals(KEY);
            } else if (!入所_院前の状況コード.equals(入所_院前の状況Key)) {
                return true;
            }
        }

        RString 退所_院後の状態コード = shokanKihon.get退所_院後の状態コード();
        RString 退所_院後の状態Key = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState()
                .getSelectedKey();
        if (退所_院後の状態コード == null || 退所_院後の状態コード.isEmpty()) {
            if (!退所_院後の状態Key.equals(KEY)) {
                return true;
            }
        } else if (!退所_院後の状態コード.equals(退所_院後の状態Key)) {
            return true;
        }
        return false;
    }

    /**
     * パラメータ設定のメソッドます。
     */
    public void putViewState() {
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ViewStateHolder.put(ViewStateKeys.申請日, div.getPanelTwo().getTxtShinseiDate().getValue());
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class),
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                new JigyoshaNo(div.getPanelTwo().getTxtJigyoshaBango().getValue()),
                div.getPanelTwo().getTxtShomeisho().getValue(),
                div.getPanelTwo().getTxtMeisaiBango().getValue(),
                div.getPanelKihon().getPanelKyotaku().getTxtHokenKyufuritsu().getValue());
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

    /**
     * ボタンを制御のメソッドます。
     *
     * @param shikibetsuNoKanri ShikibetsuNoKanri
     */
    public void getボタンを制御(ShikibetsuNoKanri shikibetsuNoKanri) {

        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.償還払費申請明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        div.getPanelTwo().getBtnKihon().setDisabled(true);
        set給付費明細ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定診療費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        setサービス計画費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set特定入所者費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        div.getPanelTwo().getBtnGokeiInfo().setDisabled(false);
        set給付費明細_住特ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時_所定疾患ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set緊急時施設療養費ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set食事費用ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set請求額集計ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        set社福軽減額ボタン制御(shikibetsuNoKanri, 被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    private void set給付費明細ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiDown().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細設定区分())) {
            int count2 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().delShokanMeisaiCount(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count2 != 0) {
                div.getPanelTwo().getBtnKyufuhiMeisaiDown().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKyufuhiMeisaiDown().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiDown().setIconNameEnum(IconName.NONE);
        }
    }

    private void setサービス計画費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            int count4 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanServicePlan(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count4 != 0) {
                div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get居宅計画費設定区分())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定診療費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelTwo().getBtnTokuteiShinryohi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            int count3 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanTokuteiShinryohi(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count3 != 0) {
                div.getPanelTwo().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnTokuteiShinryohi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定診療費設定区分())) {
            div.getPanelTwo().getBtnTokuteiShinryohi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set特定入所者費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteiNyushosyaHiyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            int count5 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                    .updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (count5 != 0) {
                div.getPanelTwo().getBtnTokuteiNyushosyaHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnTokuteiNyushosyaHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteiNyushosyaHiyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set給付費明細_住特ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            int count6 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShokanMeisaiJushochiTokureiCount(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count6 != 0) {
                div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get明細住所地特例設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時_所定疾患ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            int count7 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShoteiShikkanShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count7 != 0) {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get所定疾患施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikan().setIconNameEnum(IconName.NONE);
        }
    }

    private void set緊急時施設療養費ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            int count8 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanKinkyuShisetsuRyoyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count8 != 0) {
                div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get緊急時施設療養設定区分())) {
            div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setIconNameEnum(IconName.NONE);
        }
    }

    private void set食事費用ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelTwo().getBtnSyokujiHiyo().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            int count9 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShokujiHiyo(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count9 != 0) {
                div.getPanelTwo().getBtnSyokujiHiyo().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnSyokujiHiyo().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get食事費用設定区分())) {
            div.getPanelTwo().getBtnSyokujiHiyo().setIconNameEnum(IconName.NONE);
        }
    }

    private void set請求額集計ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get集計設定区分())) {
            int count10 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShukei(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count10 != 0) {
                div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setIconNameEnum(IconName.NONE);
        }
    }

    private void set社福軽減額ボタン制御(ShikibetsuNoKanri shikibetsuNoKanri, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (設定不可.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafukuKeigenGaku().setDisabled(true);
        } else if (設定可必須.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            int count11 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().updShokanShakaiFukushiHojinKeigengaku(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (count11 != 0) {
                div.getPanelTwo().getBtnShafukuKeigenGaku().setIconNameEnum(IconName.Incomplete);
            } else {
                div.getPanelTwo().getBtnShafukuKeigenGaku().setIconNameEnum(IconName.Complete);
            }
        } else if (設定可任意.equals(shikibetsuNoKanri.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafukuKeigenGaku().setIconNameEnum(IconName.NONE);
        }
    }

    /**
     * 様式番号に対応する番号のメソッドます。
     */
    public void put様式番号ViewState() {
        ArrayList<RString> list = new ArrayList<>();
        list.add(STR_2171);
        list.add(STR_2172);
        list.add(STR_2173);
        list.add(STR_2174);
        list.add(STR_2181);
        list.add(STR_2182);
        list.add(STR_2183);
        list.add(STR_2191);
        list.add(STR_2192);
        list.add(STR_2193);
        list.add(STR_2194);
        list.add(STR_2195);
        list.add(STR_21A1);
        list.add(STR_21A2);
        list.add(STR_21A3);
        ViewStateHolder.put(ViewStateKeys.様式番号List, list);
    }

    /**
     * 入力チェックのメソッドます。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェックメッセージ() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        ArrayList<RString> list = new ArrayList<>();
        list.add(STR_2144);
        list.add(STR_2154);
        list.add(STR_2156);
        list.add(STR_2165);
        list.add(STR_2142);
        list.add(STR_2143);
        list.add(STR_2152);
        list.add(STR_2153);
        list.add(STR_2155);
        list.add(STR_2162);
        list.add(STR_2163);
        list.add(STR_2164);
        FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        if (!サービス年月.isBefore(平成14年１月) && list.contains(様式番号)
                && div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue() == null) {
            pairs.add(new ValidationMessageControlPair(new KihonInfoMainPanelHandler.IdocheckMessages(
                    UrErrorMessages.必須項目_追加メッセージあり, 入所年月日.toString()),
                    div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD()));
        }
        RDate 入所_院年月日 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue();
        RDate 退所_院年月日 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().getValue();
        if (入所_院年月日 != null && 退所_院年月日 != null) {
            int 期間_日数 = 退所_院年月日.plusDay(NUM_1).getBetweenDays(入所_院年月日);
            if (期間_日数 > 日数) {
                pairs.add(new ValidationMessageControlPair(new KihonInfoMainPanelHandler.IdocheckMessages(
                        DbcWarningMessages.日数３０日超過, 入所年月日.toString(), 退所年月日.toString()),
                        div.getPanelKihon().getPanelShisetuNyutaisyoInfo()));
            }
        }
        return pairs;
    }

    /**
     * 画面の個別設定のメソッドます。
     *
     * @param サービス年月 FlexibleYearMonth
     */
    public void set画面の個別設定(FlexibleYearMonth サービス年月) {
        List<RString> list = ViewStateHolder.get(ViewStateKeys.様式番号List, List.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        if (サービス年月.isBeforeOrEquals(平成２１年３月)
                || (平成２１年４月.isBeforeOrEquals(サービス年月) && !list.contains(様式番号))) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setDisplayNone(true);
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setDisplayNone(false);
        } else {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setDisplayNone(false);
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setDisplayNone(true);
        }
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
