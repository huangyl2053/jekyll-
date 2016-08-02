/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.KaigoJigyoshaReturnEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810021.KihonInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 償還払い状況照会_基本情報のハンドラクラスです。
 *
 * @reamsid_L DBC-1010-030 wangkanglei
 */
public class KihonInfoHandler {

    private final KihonInfoDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final RString 有 = new RString("2");
    private static final RString 自己作成 = new RString("3");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");
    private static final RString KEY = new RString("key0");
    private static final RString 計画作成区分 = new RString("0001");
    private static final RString 中止理由 = new RString("0009");
    private static final RString 入所院前の状況 = new RString("0048");
    private static final RString 退所院後の状況 = new RString("0010");
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

    /**
     * コンストラクタです。
     *
     * @param div KihonInfoDiv
     */
    public KihonInfoHandler(KihonInfoDiv div) {
        this.div = div;
    }

    /**
     * ボタン表示制御処理のメソッドます。
     *
     * @param entity ShikibetsuNoKanri
     * @param サービス年月 サービス年月
     */
    public void setボタン表示制御処理(ShikibetsuNoKanri entity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(entity.get明細設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiDown().setDisabled(true);
        }
        if (設定不可.equals(entity.get特定診療費設定区分())) {
            div.getPanelTwo().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(entity.get居宅計画費設定区分())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(entity.get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteiNyushosyaHiyo().setDisabled(true);
        }
        if (設定不可.equals(entity.get食事費用設定区分())) {
            div.getPanelTwo().getBtnSyokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(entity.get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(entity.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafukuKeigenGaku().setDisabled(true);
        }
        if (設定不可.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setDisabled(true);
        }
        if (設定可_任意.equals(entity.get所定疾患施設療養設定区分())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setDisplayNone(false);
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setVisible(true);
            div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setVisible(false);
            div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setDisplayNone(true);
        } else {
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setVisible(false);
            if (設定不可.equals(entity.get緊急時施設療養設定区分())) {
                div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setDisabled(true);
            }
        }
    }

    /**
     * ヘッダーエリアの設定のメソッドます。
     *
     * @param サービス年月 サービス年月
     * @param 事業者番号 事業者番号
     * @param 申請日 申請日
     * @param 明細番号 明細番号
     * @param 証明書 証明書
     */
    public void setヘッダーエリア(
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
     * 基本内容エリアの設定のメソッドます。
     *
     * @param shokanKihon ShokanKihon
     * @param kaigoJigyoshaEntity KaigoJigyoshaReturnEntity
     * @param サービス年月 サービス年月
     */
    public void set基本内容エリア(ShokanKihon shokanKihon, KaigoJigyoshaReturnEntity kaigoJigyoshaEntity,
            FlexibleYearMonth サービス年月) {

        FlexibleDate date = new FlexibleDate(RDate.getNowDate().toDateString());
        UzT0007CodeEntity code = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(計画作成区分), new Code(shokanKihon.get居宅サービス計画作成区分コード()), date);
        if (code != null) {
            List<KeyValueDataSource> keyValueDataSource1 = new ArrayList<>();
            keyValueDataSource1.add(new KeyValueDataSource(KEY, code.getコード名称()));
            div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun().setDataSource(keyValueDataSource1);
            div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun().setSelectedKey(KEY);
        }
        if (!shokanKihon.get旧措置入所者特例コード().isEmpty() && 有.equals(shokanKihon.get旧措置入所者特例コード())) {
            List<RString> sources = new ArrayList<>();
            sources.add(KEY);
            div.getPanelKihon().getPanelKyotaku().getChkKyusochi().setSelectedItemsByKey(sources);
        }

        if (!shokanKihon.get居宅サービス計画作成区分コード().isEmpty() && !自己作成.equals(shokanKihon.get居宅サービス計画作成区分コード())) {
            if (shokanKihon.get事業者番号() != null) {
                div.getPanelKihon().getPanelKyotaku().getTxtJigyosha().setValue(shokanKihon.get事業者番号().value());
            }
            if (kaigoJigyoshaEntity != null && kaigoJigyoshaEntity.getEntity() != null && kaigoJigyoshaEntity.getEntity()
                    .getJigyoshaName() != null) {
                div.getPanelKihon().getPanelKyotaku().getTxtJigyoshaName().setValue(kaigoJigyoshaEntity.getEntity()
                        .getJigyoshaName().value());
            }
        }
        div.getPanelKihon().getPanelKyotaku().getTxtHokenKyufuritsu().setValue(shokanKihon.get保険給付率().value());
        if (!shokanKihon.get開始年月日().isEmpty()) {
            div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().setFromValue(new RDate(shokanKihon.get開始年月日().toString()));
        }
        if (!shokanKihon.get中止年月日().isEmpty()) {
            div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan().setToValue(new RDate(shokanKihon.get中止年月日().toString()));
        }

        List<RString> list = new ArrayList<>();
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
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_様式番号, RString.class);
        if (平成２１年４月.isBeforeOrEquals(サービス年月) && list.contains(様式番号)) {
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setVisible(false);
        } else {
            UzT0007CodeEntity code4 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                    new CodeShubetsu(中止理由), new Code(shokanKihon.get中止理由_入所_院前の状況コード()), date);
            List<KeyValueDataSource> keyValueDataSource2 = new ArrayList<>();
            keyValueDataSource2.add(new KeyValueDataSource(KEY, code4.getコード名称()));
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setDataSource(keyValueDataSource2);
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setSelectedKey(KEY);
        }
        if (!shokanKihon.get入所_院年月日().isEmpty()) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().setValue(new RDate(
                    shokanKihon.get入所_院年月日().toString()));
        }
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().setValue(
                new Decimal(shokanKihon.get入所_院実日数()));
        if (!shokanKihon.get退所_院年月日().isEmpty()) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().setValue(new RDate(
                    shokanKihon.get退所_院年月日().toString()));
        }
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().setValue(new Decimal(shokanKihon.get外泊日数()));
        if (サービス年月.isBefore(平成２１年４月)
                || (平成２１年４月.isBeforeOrEquals(サービス年月)
                && !list.contains(様式番号))) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setVisible(false);
        } else {
            UzT0007CodeEntity code3 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                    new CodeShubetsu(入所院前の状況), new Code(shokanKihon.get中止理由_入所_院前の状況コード()), date);
            List<KeyValueDataSource> keyValueDataSource3 = new ArrayList<>();
            keyValueDataSource3.add(new KeyValueDataSource(KEY, code3.getコード名称()));
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setDataSource(keyValueDataSource3);
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setSelectedKey(KEY);
        }
        UzT0007CodeEntity code2 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(退所院後の状況), new Code(shokanKihon.get退所_院後の状態コード()), date);
        List<KeyValueDataSource> keyValueDataSource4 = new ArrayList<>();
        keyValueDataSource4.add(new KeyValueDataSource(KEY, code2.getコード名称()));
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState().setDataSource(keyValueDataSource4);
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState().setSelectedKey(KEY);
    }
}
