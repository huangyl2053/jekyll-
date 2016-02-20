/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810029;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810029.ShokujiHiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810029.dgdShokuji_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払い状況照会_食事費用画面のハンドラクラスです。
 *
 * @author wangkanglei
 */
public class ShokujiHiyoHandler {

    private final ShokujiHiyoDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    public ShokujiHiyoHandler(ShokujiHiyoDiv div) {
        this.div = div;
    }

    public void setヘッダーエリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    public void setボタン表示制御処理(ShikibetsuNoKanriEntity shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKihonSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShikkanSetteiKubun())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setDisplayNone(false);
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }

    public void set食事費用一覧グリッド(List<ShokanMeisai> list, ShokanShokujiHiyo shokanShokujiHiyo) {
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
        set食事費用合計設定パネル(shokanShokujiHiyo);
    }

    public void set食事費用合計設定パネル(ShokanShokujiHiyo entity) {
        div.getPanelShokuji().getPanelShokujiGokei().getTxtShokujiTeikyoNobeNissu().setValue(new Decimal(entity.get食事提供延べ日数()));
        div.getPanelShokuji().getPanelShokujiGokei().getTxtHyojunFutanfakuNichigaku().setValue(new Decimal(entity.get標準負担額_日額()));
        div.getPanelShokuji().getPanelShokujiGokei().getTxtHyojunFutanfakuGetsugaku().setValue(new Decimal(entity.get標準負担額_月額()));
        div.getPanelShokuji().getPanelShokujiGokei().getTxtShokujiTeikyohiGokei().setValue(new Decimal(entity.get食事提供費合計()));
        div.getPanelShokuji().getPanelShokujiGokei().getTxtShokujiTeikyoSeikyugaku()
                .setValue(new Decimal(entity.get食事提供費請求額()));
    }

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
        if (ShikyuFushikyuKubun.toValue(entity.get支給区分コード()) != null) {
            div.getPanelShokuji().getPanelDetail1().getTxtShikyukubun().setValue(ShikyuFushikyuKubun.toValue(entity.get支給区分コード())
                    .get名称());
        }
        div.getPanelShokuji().getPanelDetail1().getTxtShiharaiKingaku().setValue(new Decimal(entity.get支給金額()));
        div.getPanelShokuji().getPanelDetail1().getTxtZougenten().setValue(new Decimal(entity.get増減点()));
    }

    public void set食事費用パネル２() {
        dgdShokuji_Row row = div.getPanelShokuji().getPanelShoikujiList().getDgdShokuji().getClickedItem();
        div.getPanelShokuji().getPanelDetail2().getTxtServiceCodeShurui().setValue(row.getDefaultDataName2().substring(0, 2));
        div.getPanelShokuji().getPanelDetail2().getTxtServiceItemCode().setValue(row.getDefaultDataName2().substring(2, 6));
        // TODO 選択行．サービス名称 ?
        div.getPanelShokuji().getPanelDetail2().getTxtServiceName().setValue(new RString("サービス名称"));
        div.getPanelShokuji().getPanelDetail2().getTxtTanyi().setValue(row.getDefaultDataName3().getValue());
        div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().setValue(new Decimal(row.getDefaultDataName4().toString()));
        div.getPanelShokuji().getPanelDetail2().getBtnKinngaku().setValue(row.getDefaultDataName5().getValue());
        div.getPanelShokuji().getPanelDetail2().setVisible(true);
    }
}
