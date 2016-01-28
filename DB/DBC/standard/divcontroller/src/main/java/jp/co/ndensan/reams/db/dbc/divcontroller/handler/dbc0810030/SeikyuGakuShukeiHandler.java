/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.SeikyuGakuShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 償還払い状況照会_請求額集計
 *
 * @author 瞿暁東
 */
public class SeikyuGakuShukeiHandler {

    private final SeikyuGakuShukeiDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    public SeikyuGakuShukeiHandler(SeikyuGakuShukeiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param shkanList
     */
    public void initialize(List<ShokanShukeiEntity> shkanList) {
        List<dgdSeikyugakushukei_Row> rowList = new ArrayList<>();
        for (ShokanShukeiEntity shokanshukei : shkanList) {
            dgdSeikyugakushukei_Row row = new dgdSeikyugakushukei_Row();
            row.setDefaultDataName1(shokanshukei.getEntity().getServiceShuruiCode().value());
            row.getDefaultDataName2().setValue(new Decimal(shokanshukei.getEntity().getTanisuTotal()));
            row.getDefaultDataName3().setValue(shokanshukei.getEntity().getTanisuTanka());
            row.getDefaultDataName4().setValue(shokanshukei.getEntity().getSeikyugaku());
            row.getDefaultDataName6().setValue(new Decimal(shokanshukei.getEntity().getRiyoshaFutangaku()));
            if (ShinsaHohoKubun.toValue(shokanshukei.getEntity().getShinsaHohoKubunCode()) != null) {
                row.setDefaultDataName5(ShinsaHohoKubun.toValue(shokanshukei.getEntity().getShinsaHohoKubunCode()).get名称());
            }
            row.setDefaultDataName7(shokanshukei.getEntity().getRenban());
            rowList.add(row);
        }
        div.getDgdSeikyugakushukei().setDataSource(rowList);

    }

    /**
     * setヘッダーエリア
     *
     * @param サービス年月
     * @param 事業者番号
     * @param 申請日
     * @param 明細番号
     * @param 証明書
     */
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

    /**
     *
     * @param shkanList
     * @param entity
     */
    public void selectButton(List<ShokanShukeiEntity> shkanList, ShokanKihon entity) {

        ShokanShukeiEntity shokanshukei = shkanList.get(0);

        div.getPanelSeikyuShokai().getTxtServiceShurui().setValue(new RString(shokanshukei.getEntity().getServiceShuruiCode().toString()));
        div.getPanelSeikyuShokai().getTxtJitsuNissu().setValue(new Decimal(shokanshukei.getEntity().getTankiNyushoJitsunissu()));

        List<KeyValueDataSource> source = new ArrayList<>();
        source.add(new KeyValueDataSource(shokanshukei.getEntity().getShinsaHohoKubunCode(), new RString("審査方法区分")));
        div.getPanelSeikyuShokai().getRdoShinsahouhou().setDataSource(source);
        div.getPanelSeikyuShokai().getRdoShinsahouhou().setSelectedKey(shokanshukei.getEntity().getShinsaHohoKubunCode());
        div.getPanelSeikyuShokai().getTxtKeikakuTanyi().setValue(new Decimal(shokanshukei.getEntity().getPlanTanisu()));
        div.getPanelSeikyuShokai().getTxtTaishoTanyi().setValue(new Decimal(shokanshukei.getEntity().getGendogakuKanriTaishoTanisu()));
        div.getPanelSeikyuShokai().getTxtTaishoTanyi().setValue(new Decimal(shokanshukei.getEntity().getGendogakuKanriTaishogaiTanisu()));
        div.getPanelSeikyuShokai().getTxtKeikakuNissu().setValue(new Decimal(shokanshukei.getEntity().getTankiNyushoPlanNissu()));
        div.getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().setValue(new Decimal(shokanshukei.getEntity().getTankiNyushoJitsunissu()));
        div.getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().setValue(shokanshukei.getEntity().getTanisuTanka());
        div.getPanelSeikyuShokai().getTxtTanyiTanka().setValue(shokanshukei.getEntity().getTanisuTanka());
        div.getPanelSeikyuShokai().getTxtSeikyugakuHoken().setValue(shokanshukei.getEntity().getSeikyugaku());
        div.getPanelSeikyuShokai().getTxtSagakukinngakuHoken().setValue(new Decimal(shokanshukei.getEntity().getSeikyugakuSagakuKingaku()));
        div.getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().setValue(new Decimal(shokanshukei.getEntity().getDekidakaIryohiTanisuTotal()));
        div.getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(shokanshukei.getEntity().getDekidakaIryohiRiyoshaFutangaku());
        div.getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(shokanshukei.getEntity().getDekidakaIryohiSeikyugaku());
        div.getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().setValue(shokanshukei.getEntity().getDekidakaIryohiRiyoshaFutangaku());
        div.getPanelSeikyuShokai().getTxtSagakukinngakuDekikata().setValue(new Decimal(shokanshukei.getEntity().getDekidakaSeikyugakuSagaku()));
        div.getPanelSeikyuShokai().getTxtKyufuritsu().setValue(new Decimal(entity.get保険給付率().toString()));

    }

    /**
     * 制御処理
     *
     * @param shikibetsuNoKanriEntity
     * @param サービス年月
     */
    public void setボタン表示制御処理(ShikibetsuNoKanriEntity shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShikkanSetteiKubun())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnTokuteiShinryohi().setVisible(false);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }

}
