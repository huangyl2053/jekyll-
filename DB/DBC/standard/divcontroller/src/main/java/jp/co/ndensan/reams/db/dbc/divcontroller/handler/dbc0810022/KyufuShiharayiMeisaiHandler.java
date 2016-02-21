/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810022;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810022.KyufuShiharayiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810022.dgdKyufuhiMeisai_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author quxiaodong
 */
public class KyufuShiharayiMeisaiHandler {

    private final KyufuShiharayiMeisaiDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    public KyufuShiharayiMeisaiHandler(KyufuShiharayiMeisaiDiv div) {
        this.div = div;
    }

    public void setヘッダーエリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelTwo().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
    }

    public void set給付費明細() {
        dgdKyufuhiMeisai_Row row = div.getDgdKyufuhiMeisai().getClickedItem();
        div.getPanelFour().getTxtServiceShuruiCode().setValue(row.getDefaultDataName1());
        div.getPanelFour().getTxtTanyi().setValue(new Decimal(row.getDefaultDataName2().toString()));
        div.getPanelFour().getTxtKaisu().setValue(new Decimal(row.getDefaultDataName3().toString()));
        div.getPanelFour().getTxtServiceTanyi().setValue(new Decimal(row.getDefaultDataName4().toString()));
        div.getPanelFour().getTxtTeikiyo().setValue(row.getDefaultDataName5());
    }

    public void initialize(List<ShokanMeisaiResult> ShokanMeisaiList) {
        div.getPanelTwo().getTxtJigyoshaBango().setValue(new RString("001"));
        div.getPanelTwo().getTxtMeisaiBango().setValue(new RString("002"));
        div.getPanelTwo().getTxtShomeisho().setValue(new RString("証明書証明書証明書証明書証明書"));
        List<dgdKyufuhiMeisai_Row> rowList = new ArrayList<>();
        for (ShokanMeisaiResult ShokanMeisai : ShokanMeisaiList) {
            dgdKyufuhiMeisai_Row row = new dgdKyufuhiMeisai_Row();
            row.setDefaultDataName1(ShokanMeisai.getEntity().toEntity().getServiceKomokuCode().value());
            row.setDefaultDataName2(new RString(String.valueOf(ShokanMeisai.getEntity().get単位数())));
            row.setDefaultDataName3(new RString(String.valueOf(ShokanMeisai.getEntity().get日数_回数())));
            row.setDefaultDataName4(new RString(String.valueOf(ShokanMeisai.getEntity().getサービス単位数())));
            row.setDefaultDataName5(ShokanMeisai.getEntity().get摘要());
            rowList.add(row);

        }
        div.getDgdKyufuhiMeisai().setDataSource(rowList);

    }

    public void setボタン表示制御処理(ShikibetsuNoKanriResult shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getMeisaiSetteiKubun())) {
            div.getPanelTwo().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelTwo().getBtnKyufuMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getShukeiSetteiKubun())) {
            div.getPanelTwo().getBtnShokujihiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelTwo().getBtnShafukukeigenGaku().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getTokuteiShikkanSetteiKubun())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setVisible(false);
        } else {
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setDisabled(true);
            }
        }
    }

}
