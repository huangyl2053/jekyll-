/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810025;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810025.TokuteiNyushoshaHiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810025.dgdTokuteiYichiran_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author wangkanglei
 */
public class TokuteiNyushoshaHiyoHandler {

    private final TokuteiNyushoshaHiyoDiv div;
    private static final RString 設定不可 = new RString("0");

    public TokuteiNyushoshaHiyoHandler(TokuteiNyushoshaHiyoDiv div) {
        this.div = div;
    }

    public void setヘッダーエリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
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
            div.getPanelHead().getBtnTokuteiShinryouhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
        if (new RString("2").equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShikkanSetteiKubun())
                && new FlexibleYearMonth("201204").isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }

    public void set特定入所者費用一覧グリッド(List<ShokanTokuteiNyushoshaKaigoServiceHiyo> list) {
        List<dgdTokuteiYichiran_Row> dataSource = new ArrayList<>();
        for (ShokanTokuteiNyushoshaKaigoServiceHiyo entity : list) {
            dgdTokuteiYichiran_Row row = new dgdTokuteiYichiran_Row();
            RStringBuilder builder = new RStringBuilder();
            builder.append(entity.getサービス種類コード()).append(entity.getサービス項目コード());
            row.setDefaultDataName1(builder.toRString());
            // TODO　標準単価 缺失
            row.getDefaultDataName2().setValue(entity.get費用単価());
            row.getDefaultDataName3().setValue(entity.get負担限度額());
            row.getDefaultDataName4().setValue(entity.get日数());
            row.getDefaultDataName5().setValue(new Decimal(entity.get費用額()));
            row.getDefaultDataName6().setValue(new Decimal(entity.get保険分請求額()));
            row.getDefaultDataName7().setValue(new Decimal(entity.get利用者負担額()));
            row.getDefaultDataName8().setValue(new Decimal(entity.get点数_金額()));
            if (ShikyuFushikyuKubun.toValue(設定不可) != null) {
                row.setDefaultDataName9(ShikyuFushikyuKubun.toValue(設定不可).get名称());
            }
            row.getDefaultDataName10().setValue(new Decimal(entity.get差額金額()));
            row.getDefaultDataName11().setValue(new Decimal(entity.get増減点()));
            dataSource.add(row);
        }
        div.getPanelTokutei().getDgdTokuteiYichiran().setDataSource(dataSource);
        set特定入所者費用一覧の合計エリア(list.get(0));
    }

    public void set特定入所者費用一覧の合計エリア(ShokanTokuteiNyushoshaKaigoServiceHiyo entity) {

        div.getPanelTokutei().getTxtHiyogakuTotal().setValue(new Decimal(entity.get費用額合計()));
        div.getPanelTokutei().getTxtHokenbunTotal().setValue(new Decimal(entity.get保険分請求額合計()));
        div.getPanelTokutei().getTxtRiyoshaFutangakuTotal().setValue(new Decimal(entity.get利用者負担額合計()));
    }

    public void set特定入所者費用照会パネル(FlexibleYearMonth サービス年月) {
        dgdTokuteiYichiran_Row row = div.getDgdTokuteiYichiran().getClickedItem();
        RString serviceCodeShuruyi = new RString(row.getDefaultDataName1().subSequence(0, 2).toString());
        RString serviceCodeKoumoku = new RString(row.getDefaultDataName1().subSequence(2, 6).toString());
        // TODOサービスコード取得
//        List<ServiceCode> serviceCode = ServiceCodeInput.getServiceCodeList(serviceCodeShuruyi, serviceCodeKoumoku, サービス年月);
        div.getPanelMeisai().getTxtServiceCodeShuruyi().setValue(serviceCodeShuruyi);
        div.getPanelMeisai().getTxtServiceCodeKoumoku().setValue(serviceCodeKoumoku);
        // TODO
        div.getPanelMeisai().getTxtServiceName().setValue(new RString("サービス名称"));
        div.getPanelMeisai().getTxtHyojyuntanka().setValue(row.getDefaultDataName2().getValue());
        div.getPanelMeisai().getTxtFutangenndogaku().setValue(row.getDefaultDataName3().getValue());
        div.getPanelMeisai().getTxtNisu().setValue(row.getDefaultDataName4().getValue());
        div.getPanelMeisai().getTxtHiyogaku().setValue(row.getDefaultDataName5().getValue());
        div.getPanelMeisai().getTxtHokenbun().setValue(row.getDefaultDataName6().getValue());
        div.getPanelMeisai().getTxtRiyoshafutangaku().setValue(row.getDefaultDataName7().getValue());
        div.getPanelMeisai().getTxtTanyiGaku().setValue(row.getDefaultDataName8().getValue());
        div.getPanelMeisai().getTxtShikyukubun().setValue(row.getDefaultDataName9());
        div.getPanelMeisai().getTxtShiharaiGaku().setValue(row.getDefaultDataName10().getValue());
        div.getPanelMeisai().getTxtZogenten().setValue(row.getDefaultDataName11().getValue());
    }
}
