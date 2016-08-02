/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810029;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810029.ShokujiHiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810029.dgdShokuji_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払い状況照会_食事費用画面のハンドラクラスです。
 *
 * @reamsid_L DBC-1010-120 wangkanglei
 */
public class ShokujiHiyoHandler {

    private final ShokujiHiyoDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");
    private static final int SIX = 6;
    private static final int NUM_2 = 2;

    /**
     * コンストラクタです。
     *
     * @param div ShokujiHiyoDiv
     */
    public ShokujiHiyoHandler(ShokujiHiyoDiv div) {
        this.div = div;
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
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(申請日);
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    /**
     * ボタン表示制御処理のメソッドます。
     *
     * @param entity ShikibetsuNoKanri
     * @param サービス年月 サービス年月
     */
    public void setボタン表示制御処理(ShikibetsuNoKanri entity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(entity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(entity.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(entity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(entity.get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(entity.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(entity.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(entity.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        if (設定不可.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        }
        if (設定可_任意.equals(entity.get所定疾患施設療養設定区分())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setDisplayNone(false);
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setVisible(false);
            if (設定不可.equals(entity.get緊急時施設療養設定区分())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }

    /**
     * 食事費用一覧グリッドの設定のメソッドます。
     *
     * @param list List<ShokanMeisai>
     * @param shokanShokujiHiyoList List<ShokanShokujiHiyo>
     */
    public void set食事費用一覧グリッド(List<ShokanMeisai> list, List<ShokanShokujiHiyo> shokanShokujiHiyoList) {
        List<dgdShokuji_Row> dataSource = new ArrayList<>();
        for (ShokanMeisai entity : list) {
            dgdShokuji_Row dgdShokuji_Row = new dgdShokuji_Row();
            RStringBuilder builder = new RStringBuilder();
            builder.append(entity.getサービス種類コード().value()).append(entity.getサービス項目コード().value());
            dgdShokuji_Row.setDefaultDataName2(builder.toRString());
            dgdShokuji_Row.getDefaultDataName3().setValue(new Decimal(entity.get単位数()));
            dgdShokuji_Row.setDefaultDataName4(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get日数_回数()), 0));
            dgdShokuji_Row.getDefaultDataName5().setValue(new Decimal(entity.getサービス単位数()));
            dataSource.add(dgdShokuji_Row);
        }
        div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().setDataSource(dataSource);
        if (shokanShokujiHiyoList != null && shokanShokujiHiyoList.size() > 0) {
            set食事費用合計設定パネル(shokanShokujiHiyoList.get(0));
        }
    }

    /**
     * 食事費用合計設定パネルの設定のメソッドます。
     *
     * @param entity ShokanShokujiHiyo
     */
    public void set食事費用合計設定パネル(ShokanShokujiHiyo entity) {
        div.getPanelShokuji().getPanelShokujiGokei().getTxtShokujiTeikyoNobeNissu().setValue(new Decimal(entity.get食事提供延べ日数()));
        div.getPanelShokuji().getPanelShokujiGokei().getTxtHyojunFutanfakuNichigaku().setValue(new Decimal(entity.get標準負担額_日額()));
        div.getPanelShokuji().getPanelShokujiGokei().getTxtHyojunFutanfakuGetsugaku().setValue(new Decimal(entity.get標準負担額_月額()));
        div.getPanelShokuji().getPanelShokujiGokei().getTxtShokujiTeikyohiGokei().setValue(new Decimal(entity.get食事提供費合計()));
        div.getPanelShokuji().getPanelShokujiGokei().getTxtShokujiTeikyoSeikyugaku()
                .setValue(new Decimal(entity.get食事提供費請求額()));
    }

    /**
     * 食事費用パネル１の設定のメソッドます。
     *
     * @param entity ShokanShokujiHiyo
     */
    public void set食事費用パネル１(ShokanShokujiHiyo entity) {
        div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().setValue(new Decimal(entity.get基本提供日数()));
        div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().setValue(new Decimal(entity.get基本提供単価()));
        div.getPanelShokuji().getPanelDetail1().getTxtKihonKingaku().setValue(new Decimal(entity.get基本提供金額()));
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().setValue(new Decimal(entity.get特別提供日数()));
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka().setValue(new Decimal(entity.get特別提供単価()));
        div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuKinngaku().setValue(new Decimal(entity.get特別提供金額()));
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyoTotalNissu().setValue(new Decimal(entity.get食事提供延べ日数()));
        div.getPanelShokuji().getPanelDetail1().getTxtShokujiTeikyohiTotal().setValue(new Decimal(entity.get食事提供費合計()));
        div.getPanelShokuji().getPanelDetail1().getTxtnichigakuHyojunFutangaku().setValue(new Decimal(entity.get標準負担額_日額()));
        div.getPanelShokuji().getPanelDetail1().getTxtgetsugakuHyojunFutangaku().setValue(new Decimal(entity.get標準負担額_月額()));
        div.getPanelShokuji().getPanelDetail1().getTxtshokujiTeikyohiSeikyugaku().setValue(new Decimal(entity.get食事提供費請求額()));
        div.getPanelShokuji().getPanelDetail1().getTxtTensuKingaku().setValue(new Decimal(entity.get点数_金額()));
        if (!entity.get支給区分コード().isEmpty() && ShikyuFushikyuKubun.toValue(entity.get支給区分コード()) != null) {
            div.getPanelShokuji().getPanelDetail1().getTxtShikyukubun().setValue(ShikyuFushikyuKubun.toValue(entity.get支給区分コード())
                    .get名称());
        }
        div.getPanelShokuji().getPanelDetail1().getTxtShiharaiKingaku().setValue(new Decimal(entity.get支給金額()));
        div.getPanelShokuji().getPanelDetail1().getTxtZougenten().setValue(new Decimal(entity.get増減点()));
    }

    /**
     * 食事費用パネル２の設定のメソッドます。
     */
    public void set食事費用パネル２() {
        dgdShokuji_Row row = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getClickedItem();
        RString serviceCodeShuruyi = row.getDefaultDataName2().substring(0, NUM_2);
        div.getPanelShokuji().getPanelDetail2().getTxtServiceCodeShurui().setValue(serviceCodeShuruyi);
        RString serviceCodeKoumoku = row.getDefaultDataName2().substring(NUM_2, SIX);
        div.getPanelShokuji().getPanelDetail2().getTxtServiceItemCode().setValue(serviceCodeKoumoku);
        List<KaigoServiceNaiyou> list = ShokanbaraiJyokyoShokai.createInstance().getServiceCodeInfo(
                new KaigoServiceShuruiCode(serviceCodeShuruyi),
                serviceCodeKoumoku,
                ViewStateHolder.get(ViewStateKeys.サービス年月, FlexibleYearMonth.class));
        if (list != null) {
            Collections.sort(list, new Comparator<KaigoServiceNaiyou>() {
                @Override
                public int compare(KaigoServiceNaiyou o1, KaigoServiceNaiyou o2) {
                    return o2.get提供開始年月().compareTo(o1.get提供開始年月());
                }
            });
            if (list.get(0).getサービス名称() != null) {
                div.getPanelShokuji().getPanelDetail2().getTxtServiceName().setValue(list.get(0).getサービス名称());
            }
        }
        div.getPanelShokuji().getPanelDetail2().getTxtTanyi().setValue(row.getDefaultDataName3().getValue());
        if (!row.getDefaultDataName4().isEmpty()) {
            div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().setValue(
                    new Decimal(row.getDefaultDataName4().toString()));
        }
        div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().setValue(row.getDefaultDataName5().getValue());
        div.getPanelShokuji().getPanelDetail2().setVisible(true);
    }
}
