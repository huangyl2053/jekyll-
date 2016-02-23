/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.SeikyuGakuShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    public void initialize(List<ShokanShukeiResult> shkanList) {
        List<dgdSeikyugakushukei_Row> rowList = new ArrayList<>();
        for (ShokanShukeiResult shokanshukei : shkanList) {
            dgdSeikyugakushukei_Row row = new dgdSeikyugakushukei_Row();
            row.setDefaultDataName1(shokanshukei.getShukei().toEntity().getServiceShuruiCode().value());
            row.getDefaultDataName2().setValue(new Decimal(shokanshukei.getShukei().toEntity().getTanisuTotal()));
            row.getDefaultDataName3().setValue(shokanshukei.getShukei().toEntity().getTanisuTanka());
            row.getDefaultDataName4().setValue(shokanshukei.getShukei().toEntity().getSeikyugaku());
            row.getDefaultDataName6().setValue(new Decimal(shokanshukei.getShukei().toEntity().getRiyoshaFutangaku()));
            if (ShinsaHohoKubun.toValue(shokanshukei.getShukei().toEntity().getShinsaHohoKubunCode()) != null) {
                row.setDefaultDataName5(ShinsaHohoKubun.toValue(shokanshukei.getShukei().toEntity().getShinsaHohoKubunCode()).get名称());
            }
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
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki().toString()));
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
    public void selectButton(List<ShokanShukeiResult> shkanList, ShokanKihon entity) {

        ShokanShukeiResult shokanshukei = shkanList.get(0);

        div.getPanelSeikyuShokai().getTxtServiceShurui().setValue(new RString(shokanshukei.getShukei().toEntity().getServiceShuruiCode().toString()));
        div.getPanelSeikyuShokai().getTxtJitsuNissu().setValue(new Decimal(shokanshukei.getShukei().toEntity().getTankiNyushoJitsunissu()));

        List<KeyValueDataSource> source = new ArrayList<>();
        source.add(new KeyValueDataSource(shokanshukei.getShukei().toEntity().getShinsaHohoKubunCode(), new RString("審査方法区分")));
        div.getPanelSeikyuShokai().getRdoShinsahouhou().setDataSource(source);
        div.getPanelSeikyuShokai().getRdoShinsahouhou().setSelectedKey(shokanshukei.getShukei().toEntity().getShinsaHohoKubunCode());
        div.getPanelSeikyuShokai().getTxtKeikakuTanyi().setValue(new Decimal(shokanshukei.getShukei().toEntity().getPlanTanisu()));
        div.getPanelSeikyuShokai().getTxtTaishoTanyi().setValue(new Decimal(shokanshukei.getShukei().toEntity().getGendogakuKanriTaishoTanisu()));
        div.getPanelSeikyuShokai().getTxtTaishoTanyi().setValue(new Decimal(shokanshukei.getShukei().toEntity().getGendogakuKanriTaishogaiTanisu()));
        div.getPanelSeikyuShokai().getTxtKeikakuNissu().setValue(new Decimal(shokanshukei.getShukei().toEntity().getTankiNyushoPlanNissu()));
        div.getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().setValue(new Decimal(shokanshukei.getShukei().toEntity().getTankiNyushoJitsunissu()));
        div.getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().setValue(shokanshukei.getShukei().toEntity().getTanisuTanka());
        div.getPanelSeikyuShokai().getTxtTanyiTanka().setValue(shokanshukei.getShukei().toEntity().getTanisuTanka());
        div.getPanelSeikyuShokai().getTxtSeikyugakuHoken().setValue(shokanshukei.getShukei().toEntity().getSeikyugaku());
        div.getPanelSeikyuShokai().getTxtSagakukinngakuHoken().setValue(new Decimal(shokanshukei.getShukei().toEntity().getSeikyugakuSagakuKingaku()));
        div.getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().setValue(new Decimal(shokanshukei.getShukei().toEntity().getDekidakaIryohiTanisuTotal()));
        div.getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(shokanshukei.getShukei().toEntity().getDekidakaIryohiRiyoshaFutangaku());
        div.getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(shokanshukei.getShukei().toEntity().getDekidakaIryohiSeikyugaku());
        div.getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().setValue(shokanshukei.getShukei().toEntity().getDekidakaIryohiRiyoshaFutangaku());
        div.getPanelSeikyuShokai().getTxtSagakukinngakuDekikata().setValue(new Decimal(shokanshukei.getShukei().toEntity().getDekidakaSeikyugakuSagaku()));
        div.getPanelSeikyuShokai().getTxtKyufuritsu().setValue(new Decimal(entity.get保険給付率().toString()));

    }

    /**
     * 制御処理
     *
     * @param shikibetsuNoKanriEntity
     * @param サービス年月
     */
    public void setボタン表示制御処理(ShikibetsuNoKanriResult shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getTokuteiShikkanSetteiKubun())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setDisplayNone(false);
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().toEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }

}
