/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810032;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032.KyufuShiharayiMeisaiJyuTokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032.dgdKyufuhiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiEntity;
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
public class KyufuShiharayiMeisaiJyuTokuHandler {

    private final KyufuShiharayiMeisaiJyuTokuDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    public KyufuShiharayiMeisaiJyuTokuHandler(KyufuShiharayiMeisaiJyuTokuDiv div) {
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
        div.getPanelFour().getTxtServiceShuruiCode().setValue(row.getServiceCode());
        div.getPanelFour().getTxtTanyi().setValue(new Decimal(row.getTanyi().toString()));
        div.getPanelFour().getTxtKaisu().setValue(new Decimal(row.getKaisuuNissu().toString()));
        div.getPanelFour().getTxtServiceTanyi().setValue(new Decimal(row.getServiceTanyi().toString()));
        div.getPanelFour().getTxtShisetsuHokenshaCode().setValue(row.getShisetuShozaiHokenshaBango());
        div.getPanelFour().getTxtTeikiyo().setValue(row.getTekiyo());
    }

    public void initialize(List<ShokanMeisaiJushochiTokureiEntity> ShokanMeisaiList) {
        List<dgdKyufuhiMeisai_Row> rowList = new ArrayList<>();
        for (ShokanMeisaiJushochiTokureiEntity ShokanMeisai : ShokanMeisaiList) {
            dgdKyufuhiMeisai_Row row = new dgdKyufuhiMeisai_Row();
            row.setServiceCode(new RString(ShokanMeisai.getEntity().getServiceKomokuCode().toString()));
            row.setTanyi(new RString(String.valueOf(ShokanMeisai.getEntity().getTanisu())));
            row.setKaisuuNissu(new RString(String.valueOf(ShokanMeisai.getEntity().getNissuKaisu())));
            row.setServiceTanyi(new RString(Integer.toString(ShokanMeisai.getEntity().getServiceTanisu())));
            row.setShisetuShozaiHokenshaBango(new RString(ShokanMeisai.getEntity().getShisetsuShozaiHokenshaNo().toString()));
            row.setTekiyo(new RString(ShokanMeisai.getEntity().getTekiyo().toString()));
            rowList.add(row);

        }
        div.getDgdKyufuhiMeisai().setDataSource(rowList);

    }

//    public void initialize2() {
//        List<dgdKyufuhiMeisai_Row> rowList = new ArrayList<>();
//
//        dgdKyufuhiMeisai_Row row = new dgdKyufuhiMeisai_Row();
//        row.setServiceCode(new RString("55555"));
//        row.setTanyi(new RString("22222"));
//        row.setKaisuuNissu(new RString("2060223"));
//        row.setServiceTanyi(new RString(Integer.toString(555)));
//        row.setShisetuShozaiHokenshaBango(new RString("vvvv"));
//        row.setTekiyo(new RString("kli"));
//        rowList.add(row);
//
//        div.getDgdKyufuhiMeisai().setDataSource(rowList);
//
//    }
    public void setボタン表示制御処理(ShikibetsuNoKanriEntity shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiSetteiKubun())) {
            div.getPanelTwo().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelTwo().getBtnKyufuMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShukeiSetteiKubun())) {
            div.getPanelTwo().getBtnShokujihiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelTwo().getBtnShafukukeigenGaku().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShikkanSetteiKubun())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setVisible(false);
        } else {
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setDisabled(true);
            }
        }
    }

}
