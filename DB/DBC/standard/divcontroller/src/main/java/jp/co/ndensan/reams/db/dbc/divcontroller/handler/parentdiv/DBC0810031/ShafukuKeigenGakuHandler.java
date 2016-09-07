/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.ShafukuKeigenGakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.dgdShafukukeigenngaku_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 償還払い状況照会_社福軽減額ハンドラクラスです。
 *
 * @reamsid_L DBC-1010-100 xuhao
 */
public class ShafukuKeigenGakuHandler {

    private final ShafukuKeigenGakuDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    /**
     * ShafukuKeigenGakuHandler
     *
     * @param div 画面DIV
     */
    public ShafukuKeigenGakuHandler(ShafukuKeigenGakuDiv div) {
        this.div = div;
    }

    /**
     * initialize
     *
     * @param shokanShakaiFukushiHojinKeigengakuuList List
     */
    public void initialize(List<ShokanShakaiFukushiHojinKeigengakuResult> shokanShakaiFukushiHojinKeigengakuuList) {
        List<dgdShafukukeigenngaku_Row> rowList = new ArrayList<>();
        for (ShokanShakaiFukushiHojinKeigengakuResult entity : shokanShakaiFukushiHojinKeigengakuuList) {
            dgdShafukukeigenngaku_Row row = new dgdShafukukeigenngaku_Row();
            row.setDefaultDataName1(entity.getShokanShakai().getサービス種類コード()
                    .getColumnValue());
            row.setDefaultDataName2(new RString(entity.getShokanShakai().get軽減率().toString()));
            row.getDefaultDataName3().setValue(new Decimal(entity.getShokanShakai()
                    .get受領すべき利用者負担の総額()));
            row.getDefaultDataName4().setValue(new Decimal(entity.getShokanShakai().get軽減額()));
            row.getDefaultDataName5().setValue(new Decimal(entity.getShokanShakai()
                    .get軽減後利用者負担額()));
            row.setDefaultDataName6(entity.getShokanShakai().get備考());
            row.setDefaultDataName7(entity.getServiceShuruiRyakusho());
            rowList.add(row);
        }
        div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().setDataSource(rowList);

    }

    /**
     * setボタン表示制御処理
     *
     * @param shikibetsuNoKanriEntity shikibetsuNoKanriEntity
     * @param サービス年月 サービス年月
     */
    public void setボタン表示制御処理(ShikibetsuNoKanriResult shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().get所定疾患施設療養設定区分())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setDisplayNone(false);
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteishikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get緊急時施設療養設定区分())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }

    /**
     * selectButton
     */
    public void selectButton() {
        dgdShafukukeigenngaku_Row row = div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getClickedItem();
        List<KeyValueDataSource> サービス種類略称 = new ArrayList<>();
        サービス種類略称.add(new KeyValueDataSource(row.getDefaultDataName7(), row.getDefaultDataName7()));
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui()
                .setDataSource(サービス種類略称);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui()
                .setSelectedKey(row.getDefaultDataName7());
        List<KeyValueDataSource> 軽減率 = new ArrayList<>();
        軽減率.add(new KeyValueDataSource(row.getDefaultDataName2(), row.getDefaultDataName2()));
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu().setDataSource(軽減率);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu()
                .setSelectedValue(row.getDefaultDataName2());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal()
                .setValue(row.getDefaultDataName3().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku()
                .setValue(row.getDefaultDataName4().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku()
                .setValue(row.getDefaultDataName5().getValue());
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtBikou()
                .setValue(row.getDefaultDataName6());
    }
}
