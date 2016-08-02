/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810032;

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
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い状況照会_給付費明細（住特）
 *
 * @reamsid_L DBC-1010-040 quxiaodong
 */
public class KyufuShiharayiMeisaiJyuTokuHandler {

    private final KyufuShiharayiMeisaiJyuTokuDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");
    private static final int NUM = 6;

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
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
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
        if (!row.getServiceCode().isEmpty()) {
            RString serviceCodeShuruyi = new RString(row.getServiceCode().subSequence(0, 2).toString());
            RString serviceCodeKoumoku = new RString(row.getServiceCode().subSequence(2, NUM).toString());
            div.getPanelThree().getPanelFour().getTxtServiceShuruiCode().setValue(serviceCodeShuruyi);
            div.getPanelThree().getPanelFour().getTxtServiceKoumokuCode().setValue(serviceCodeKoumoku);
        }
        div.getPanelFour().getTxtServicename().setValue(row.getServicename());
        div.getPanelFour().getTxtTanyi().setValue(new Decimal(row.getTanyi().toString()));
        div.getPanelFour().getTxtKaisu().setValue(new Decimal(row.getKaisuuNissu().toString()));
        div.getPanelFour().getTxtServiceTanyi().setValue(new Decimal(row.getServiceTanyi().toString()));
        div.getPanelFour().getTxtShisetsuHokenshaCode().setValue(row.getShisetuShozaiHokenshaBango());
        div.getPanelFour().getTxtShisetsuHokenshaName().setValue(row.getHokenshaName());
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
            row.setTanyi(new RString(String.valueOf(shme.getEntity().get単位数())));
            row.setKaisuuNissu(new RString(String.valueOf(shme.getEntity().get日数_回数())));
            row.setServiceTanyi(new RString(Integer.toString(shme.getEntity().getサービス単位数())));
            row.setShisetuShozaiHokenshaBango(shme.getEntity().get施設所在保険者番号().value());
            row.setHokenshaName(shme.getHokenshaName());
            row.setTekiyo(shme.getEntity().get摘要());
            row.setServicename(shme.getServiceName());
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

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get基本設定区分())) {
            div.getPanelTwo().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get明細設定区分())) {
            div.getPanelTwo().getBtnKyufuMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get特定診療費設定区分())) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get居宅計画費設定区分())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get食事費用設定区分())) {
            div.getPanelTwo().getBtnShokujihiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafukukeigenGaku().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().get所定疾患施設療養設定区分())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setDisplayNone(false);
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setVisible(true);
            div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setVisible(false);
            div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setDisplayNone(true);
        } else {
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get所定疾患施設療養設定区分())) {
                div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setDisabled(true);
            }
        }
    }

}
