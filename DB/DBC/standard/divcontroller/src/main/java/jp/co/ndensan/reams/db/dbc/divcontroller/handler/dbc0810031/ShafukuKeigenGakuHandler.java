/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.ShafukuKeigenGakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.dgdShafukukeigenngaku_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い状況照会_社福軽減額ハンドラクラスです。
 * {@link ShafukuKeigenGakuDiv}のHandlerクラスです。
 * @author GC xuhao
 */
public class ShafukuKeigenGakuHandler {

    private final ShafukuKeigenGakuDiv div;
    private static final RString 設定不可 = new RString("0");

    public ShafukuKeigenGakuHandler(ShafukuKeigenGakuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     * @param ShokanShakaiFukushiHojinKeigengakuuList
     */
    public void initialize(List<ShokanShakaiFukushiHojinKeigengakuEntity> ShokanShakaiFukushiHojinKeigengakuuList   ) {
        List<dgdShafukukeigenngaku_Row> rowList = new ArrayList<>();
        for (ShokanShakaiFukushiHojinKeigengakuEntity entity : ShokanShakaiFukushiHojinKeigengakuuList) {
            dgdShafukukeigenngaku_Row row = new dgdShafukukeigenngaku_Row();
            row.setDefaultDataName1(new RString(entity.getEntity().getServiceShuruiCode().toString()));
            row.setDefaultDataName2(new RString(entity.getEntity().getKeigenritsu().toString()));
            row.getDefaultDataName3().setValue(new Decimal(entity.getEntity().getRiyoshaFutangakuTotal()));
            row.getDefaultDataName4().setValue(new Decimal(entity.getEntity().getKeigengaku()));
            row.getDefaultDataName5().setValue(new Decimal(entity.getEntity().getKeigengoRiyoshaFutangaku()));
            row.setDefaultDataName6(entity.getEntity().getBiko());
            rowList.add(row);
        }
        div.getDgdShafukukeigenngaku().setDataSource(rowList);

    }

    /**
     * ボタン表示制御を処理します。
     * @param shikibetsuNoKanriEntity
     * @param サービス年月 
     */
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
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        }
        if (new RString("2").equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShikkanSetteiKubun())
                && new FlexibleYearMonth("201204").isBeforeOrEquals(サービス年月)) {
//            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
        } else {
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }
    
    /**
     * 選択ボタンを押下した際に実行します。
     */
    public void selectButton() { 
        dgdShafukukeigenngaku_Row row = div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getClickedItem();
        div.getDdlServiceShurui().setSelectedValue(row.getDefaultDataName1());
        div.getDdlKengenritsu().setSelectedValue(row.getDefaultDataName2());
        div.getTxtRiyoshaFutangakuTotal().setValue(new Decimal(row.getDefaultDataName3().toString()));
        div.getTxtKengengaku().setValue(new Decimal(row.getDefaultDataName4().toString()));
        div.getTxtKeigengoRiyoshaFutangaku().setValue(new Decimal(row.getDefaultDataName5().toString()));
        div.getTxtBikou().setValue(row.getDefaultDataName6());
    }
}
