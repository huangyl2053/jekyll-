/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.ShafukuKeigenGakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.dgdShafukukeigenngaku_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 償還払い状況照会_社福軽減額ハンドラクラスです。
 * {@link ShafukuKeigenGakuDiv}のHandlerクラスです。
 * @author 徐ひ
 */
public class ShafukuKeigenGakuHandler {

    private final ShafukuKeigenGakuDiv div;
    private static final RString 設定不可 = new RString("0");

    public ShafukuKeigenGakuHandler(ShafukuKeigenGakuDiv div) {
        this.div = div;
    }

    public void initialize(List<ShokanShakaiFukushiHojinKeigengakuResult> shokanShakaiFukushiHojinKeigengakuuList) {
        List<dgdShafukukeigenngaku_Row> rowList = new ArrayList<>();
        for (ShokanShakaiFukushiHojinKeigengakuResult entity : shokanShakaiFukushiHojinKeigengakuuList) {
            dgdShafukukeigenngaku_Row row = new dgdShafukukeigenngaku_Row();
            row.setDefaultDataName1(new RString(entity.getShokanShakaiFukushiHojinKeigengaku().getサービス種類コード().toString()));
            row.setDefaultDataName2(new RString(entity.getShokanShakaiFukushiHojinKeigengaku().get軽減率().toString()));
            row.getDefaultDataName3().setValue(new Decimal(entity.getShokanShakaiFukushiHojinKeigengaku().get受領すべき利用者負担の総額()));
            row.getDefaultDataName4().setValue(new Decimal(entity.getShokanShakaiFukushiHojinKeigengaku().get軽減額()));
            row.getDefaultDataName5().setValue(new Decimal(entity.getShokanShakaiFukushiHojinKeigengaku().get軽減後利用者負担額()));
            row.setDefaultDataName6(entity.getShokanShakaiFukushiHojinKeigengaku().get備考());
            rowList.add(row);
        }
        div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().setDataSource(rowList);

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
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setDisplayNone(false);
//            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
        } else {
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }
    
    public void selectButton() { 
        dgdShafukukeigenngaku_Row row = div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getClickedItem();
        List<KeyValueDataSource> サービス種類 = new ArrayList<>();
        サービス種類.add(new KeyValueDataSource(row.getDefaultDataName1(), row.getDefaultDataName1()));
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui().setDataSource(サービス種類);
        List<KeyValueDataSource> 軽減率 = new ArrayList<>();
        軽減率.add(new KeyValueDataSource(row.getDefaultDataName2(), row.getDefaultDataName2()));
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu().setDataSource(軽減率);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal();
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().setValue(row.getDefaultDataName3().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku().setValue(row.getDefaultDataName4().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().setValue(row.getDefaultDataName5().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtBikou().setValue(row.getDefaultDataName6());
    }
}
