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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShukeiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author quxiaodong
 */
public class SeikyuGakuShukeiHandler {

    private final SeikyuGakuShukeiDiv div;
    private static final RString 設定不可 = new RString("0");

    public SeikyuGakuShukeiHandler(SeikyuGakuShukeiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param shkanList
     */
    public void initialize(List<ShokanShukeiEntity> shkanList) {
        div.getPanelHead().getTxtJigyoshaBango().setValue(new RString("001"));
        div.getPanelHead().getTxtMeisaiBango().setValue(new RString("002"));
        div.getPanelHead().getTxtShomeisho().setValue(new RString("証明書証明書証明書証明書証明書"));
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
            rowList.add(row);
        }
        div.getDgdSeikyugakushukei().setDataSource(rowList);

    }

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

    public void setボタン表示制御処理() {
        if (設定不可.equals(//dbt3118Entity.getKihonSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getMeisaiSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteiShinryoSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteiShinryoSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }

        if (new RString("2").equals(//dbt3118Entity.getKihonSetteiKubun()
                new RString("0"))) {
            // 「緊急時・所定疾患」ボタンを活性に表示、「緊急時施設療養費」ボタンを非表示
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            //  「緊急時・所定疾患」ボタンを非表示
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
// 「緊急時施設療養費」ボタン
            if (設定不可.equals( // dbt3118Entity.getKinkyuShisetsuRyoyoSetteiKubun()
                    new RString("0"))) {
                div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
            }
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }

        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }

    }

}
