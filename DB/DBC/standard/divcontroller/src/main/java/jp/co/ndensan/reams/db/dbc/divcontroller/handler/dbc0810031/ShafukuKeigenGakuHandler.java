/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810031;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.ShafukuKeigenGakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.dgdShafukukeigenngaku_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuEntity;
import static jp.co.ndensan.reams.ur.urz.definition.core.reportyamawake.YamawakeType.設定不可;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * {@link ShafukuKeigenGakuDiv}のHandlerクラスです。
 */
public class ShafukuKeigenGakuHandler {

    private final ShafukuKeigenGakuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 証交付回収記録管理Div
     */
    public ShafukuKeigenGakuHandler(ShafukuKeigenGakuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     * @param shafukuKeigenGakuList
     */
    public void initialize(List<ShokanShakaiFukushiHojinKeigengakuEntity> ShokanShakaiFukushiHojinKeigengakuuList   ) {
//        div.getCcdKaigoAtenaInfo().load(ShikibetsuCode.EMPTY);// TODO 引数：宛名検索キークラス→　該当者検索画面ViewState．識別コードから提供されたら対応可能。2015/11/26
//        div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, ShikibetsuCode.EMPTY);// 引数：被保険者番号 //  TODO QA:67から回答されたら対応可能。2015/11/26
//        div.getPanelHead().getTxtServiceTeikyoYM().setValue(RDate.MAX);// TODO サービス提供証明書画面ViewState．サービス提供年月から提供されたら対応可能。2015/11/26
//        div.getPanelHead().getTxtShinseiYMD().setValue(RDate.MAX);// TODO 申請検索画面ViewState. 申請日から提供されたら対応可能。2015/11/26
//        div.getPanelHead().getTxtJigyoshaBango().setValue(new RString("001")); // TODO サービス提供証明書画面ViewState．事業者番号から提供されたら対応可能。2015/11/26
//        div.getPanelHead().getTxtMeisaiBango().setValue(new RString("002")); // TODO サービス提供証明書画面ViewState．明細番号から提供されたら対応可能。2015/11/26
//        div.getPanelHead().getTxtShomeisho().setValue(new RString("証明書証明書証明書証明書証明書")); //  TODO サービス提供証明書画面ViewState．証明書から提供されたら対応可能。2015/11/26

//        List<dgdShafukukeigenngaku_Row> rowList = new ArrayList<>();
//        for (ShokanShakaiFukushiHojinKeigengakuEntity ShokanShakaiFukushiHojinKeigengaku : ShokanShakaiFukushiHojinKeigengakuuList) {
//            dgdShafukukeigenngaku_Row row = new dgdShafukukeigenngaku_Row();
//            row.setDefaultDataName1(ShokanShakaiFukushiHojinKeigengaku.getサービス種類コード().value());
//            row.setDefaultDataName2(new RString(shafukuKeigenGaku.get軽減率().toString()));
//            row.getDefaultDataName3().setValue(new Decimal(shafukuKeigenGaku.get受領すべき利用者負担の総額()));
//            row.getDefaultDataName4().setValue(new Decimal(shafukuKeigenGaku.get軽減額()));
//            row.getDefaultDataName5().setValue(new Decimal(shafukuKeigenGaku.get軽減後利用者負担額()));
//            row.setDefaultDataName6(shafukuKeigenGaku.get備考());
//            rowList.add(row);
//        }
//        div.getDgdShafukukeigenngaku().setDataSource(rowList);

    }

     /**
     * ボタン表示制御を処理します。
     *
     */
//    public void setボタン表示制御処理(
//            DbT3118ShikibetsuNoKanriEntity entity) {
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
        // 特定入所者費用ボタン
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        // 「給付費明細(住所地特例)」ボタン
        if (設定不可.equals(//dbt3118Entity.getMeisaiJushochitokureiSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
         // TODO 平成２４年４月
//        if (new RString("2").equals(shikibetsuNoKanriEntity.get特定疾患施設療養設定区分())
//                && new FlexibleYearMonth("201204").isBeforeOrEquals(サービス年月)) {
//            // 緊急時施設療養費
//            div.getPanelHead().getBtnKinkyujiShisetsu().setVisible(false);
//        } else {
//            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
//            if (設定不可.equals(shikibetsuNoKanriEntity.get緊急時施設療養設定区分())) {
//                div.getPanelTwo().getBtnKinkyujiShisetsu().setDisabled(true);
//            }
//        }
        // 「食事費用」ボタン
        if (設定不可.equals(//dbt3118Entity.getShokujiHiyosetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        // 「請求額集計」ボタン
        if (設定不可.equals(//dbt3118Entity.getShukeiSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        // 「社福軽減額」ボタン
        if (設定不可.equals(//dbt3118Entity.getShakaifukushiKeigenSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
    }
//    /**
//     * 基本情報ボタンを押下した際に実行します。
//     */
//    public void btnKihonInfo() {
// TODO DBC0810021_基本情報画面機能から提供されたら対応可能。2015/11/26
//    }
//
//    /**
//     * 特定診療費ボタンを押下した際に実行します。
//     */
//    public void btnTokuteiShinryohi() {
// TODO DBC0810023_特定診療費画面機能から提供されたら対応可能。2015/11/26
//    }
//
//    /**
//     * サービス計画費ボタンを押下した際に実行します。
//     */
//    public void btnServiceKeikakuhi() {
// TOD 
//    }
//
//    /**
//     * 特定入所者費用ボタンを押下した際に実行します。
//     */
//    public void btnTokuteiNyushosya() {
// TODO DBC0810025_特定入所者費用画面機能から提供されたら対応可能。2015/11/26
//    }
//
//    /**
//     * 合計情報ボタンを押下した際に実行します。
//     */
//    public void btnGoukeiInfo() {
// TODO DBC0810026_合計情報画面機能から提供されたら対応可能。2015/11/26
//    }
//
//    /**
//     * 緊急時施設療養費ボタンを押下した際に実行します。
//     */
//    public void btnKinkyujiShisetsuRyoyo() {
// TODO DBC0810027_緊急時施設療養費画面機能から提供されたら対応可能。2015/11/26
//    }
//
//    /**
//     * 請求額集計ボタンを押下した際に実行します。
//     */
//    public void btnSeikyugakuShukei() {
// TODO DBC0810029_食事費用画面機能から提供されたら対応可能。2015/11/26
//    }
//
//    /**
//     * 食事費用ボタンを押下した際に実行します。
//     */
//    public void btnShokujiHiyo() {
// TODO DBC0810030_請求額集計画面機能から提供されたら対応可能。2015/11/26
//    }
//
//    /**
//     * 給付費明細(住所地特例)ボタンを押下した際に実行します。
//     */
//    public void btnKyufuhiMeisaiJyuchi() {
// TODO DBC0810032_給付費明細(住所地特例)画面機能から提供されたら対応可能。2015/11/26
//    }
    /**
     * 選択ボタンを押下した際に実行します。
     */
    public void selectButton() { 
        dgdShafukukeigenngaku_Row row = div.getPanelShafukukenngengaku().getDgdShafukukeigenngaku().getClickedItem();
        div.getTxtServiceShurui().setValue(row.getDefaultDataName1());
        div.getTxtKengenritsu().setValue(new Decimal(row.getDefaultDataName2().toString()));
        div.getTxtRiyoshaFutangakuTotal().setValue(new Decimal(row.getDefaultDataName3().toString()));
        div.getTxtKengengaku().setValue(new Decimal(row.getDefaultDataName4().toString()));
        div.getTxtKeigengoRiyoshaFutangaku().setValue(new Decimal(row.getDefaultDataName5().toString()));
        div.getTxtBikou().setValue(row.getDefaultDataName6());
//        ShafukuKeigenGakuFinder finder = ShafukuKeigenGakuFinder.createInstance();
//        ShafukuKeigenGaku shafukuKeigenGaku = finder.getSeikyuShakaifukushiHoujinKeigengaku();// ShafukuKeigenGakuParameter
//        //div.getPanelShakaiFukushiShokai().getTxtServiceShurui().setValue(shafukuKeigenGaku.getサービス種類コード().getColumnValue());  // TODO QA:76から回答されたら対応可能。2015/11/26
//        ///div.getPanelShakaiFukushiShokai().getTxtKengenritsu().setValue(new Decimal(shafukuKeigenGaku.get軽減率().toString())); // TODO QA:76から回答されたら対応可能。2015/11/26
//        div.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal().setValue(new Decimal(shafukuKeigenGaku.get受領すべき利用者負担の総額()));
//        div.getPanelShakaiFukushiShokai().getTxtKengengaku().setValue(new Decimal(shafukuKeigenGaku.get軽減額()));
//        div.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku().setValue(new Decimal(shafukuKeigenGaku.get軽減後利用者負担額()));
//        div.getPanelShakaiFukushiShokai().getTxtBikou().setValue(shafukuKeigenGaku.get備考());
    }
}
