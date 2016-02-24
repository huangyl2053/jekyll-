/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810032;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032.KyufuShiharayiMeisaiJyuTokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032.dgdKyufuhiMeisai_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 *
 */
public class KyufuShiharayiMeisaiJyuTokuHandler {

    private final KyufuShiharayiMeisaiJyuTokuDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    /**
     * 初期化
     *
     * @param div KyufuShiharayiMeisaiJyuTokuDiv
     */
    public KyufuShiharayiMeisaiJyuTokuHandler(KyufuShiharayiMeisaiJyuTokuDiv div) {
        this.div = div;
    }

    /**
     * setヘッダーエリア
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
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

    /**
     * set給付費明細
     */
    public void set給付費明細() {
        dgdKyufuhiMeisai_Row row = div.getDgdKyufuhiMeisai().getClickedItem();
        div.getPanelFour().getTxtServiceShuruiCode().setValue(row.getServiceCode());
        div.getPanelFour().getTxtTanyi().setValue(new Decimal(row.getTanyi().toString()));
        div.getPanelFour().getTxtKaisu().setValue(new Decimal(row.getKaisuuNissu().toString()));
        div.getPanelFour().getTxtServiceTanyi().setValue(new Decimal(row.getServiceTanyi().toString()));
        div.getPanelFour().getTxtShisetsuHokenshaCode().setValue(row.getShisetuShozaiHokenshaBango());
        div.getPanelFour().getTxtTeikiyo().setValue(row.getTekiyo());
    }

    /**
     *
     * @param shmeList List
     */
    public void initialize(List<ShokanMeisaiJushochiTokureiResult> shmeList) {
        List<dgdKyufuhiMeisai_Row> rowList = new ArrayList<>();
        for (ShokanMeisaiJushochiTokureiResult shme : shmeList) {
            dgdKyufuhiMeisai_Row row = new dgdKyufuhiMeisai_Row();
            row.setServiceCode(shme.getEntity().getサービス種類コード().value().
                    concat(shme.getEntity().getサービス項目コード().value()));
            row.setTanyi(new RString(String.valueOf(shme.getEntity().getサービス単位数())));
            row.setKaisuuNissu(new RString(String.valueOf(shme.getEntity().get日数_回数())));
            row.setServiceTanyi(new RString(Integer.toString(shme.getEntity().getサービス単位数())));
            row.setShisetuShozaiHokenshaBango(shme.getEntity().get施設所在保険者番号().value());
            row.setTekiyo(shme.getEntity().get摘要());
            rowList.add(row);

        }
        div.getDgdKyufuhiMeisai().setDataSource(rowList);

    }

    /**
     * 制御処理
     *
     * @param shikibetsuNoKanriEntity ShikibetsuNoKanriResult
     * @param サービス年月 FlexibleYearMonth
     */
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
            div.getPanelTwo().getBtnTokuteiShinryouhi().setDisplayNone(false);
            div.getPanelTwo().getBtnTokuteiShinryouhi().setVisible(true);
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setVisible(false);
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setDisplayNone(true);
        } else {
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setDisabled(true);
            }
        }
    }

}
