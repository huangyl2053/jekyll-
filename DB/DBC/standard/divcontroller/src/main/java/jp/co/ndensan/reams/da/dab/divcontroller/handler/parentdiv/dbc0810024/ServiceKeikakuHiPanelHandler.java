/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.da.dab.divcontroller.handler.parentdiv.dbc0810024;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024.ServiceKeikakuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い状況照会_サービス計画費のハンドラクラスです。
 */
public class ServiceKeikakuHiPanelHandler {

    private final ServiceKeikakuHiDiv div;
    private static final RString 設定不可 = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div 償還払い状況照会_サービス計画費
     */
    public ServiceKeikakuHiPanelHandler(ServiceKeikakuHiDiv div) {
        this.div = div;
    }

    /**
     * onLoad処理です。
     *
     * @param entity200904List List<ServiceKeikakuHiRealtEntity>
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void onLoad(
            List<ServiceKeikakuHiRealtEntity> entity200904List,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {

        setヘッダ_エリア(サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号);
        setサービス計画費_パネル_共通エリア(entity200904List);
        setサービス計画費パネル_データグリッドエリア(entity200904List);
        // TODO 凌護行 仕様書の設定が不明、QA回答まち
        setサービス計画費パネル_詳細エリア200904(entity200904List.get(0));

    }

    /**
     * onLoad処理です。
     *
     * @param entity200604 ServiceKeikakuHiRealtEntity
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void onLoad(
            ServiceKeikakuHiRealtEntity entity200604,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        setヘッダ_エリア(サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号);
        setサービス計画費パネル_詳細エリア200604(entity200604);
    }

    /**
     * onLoad処理です。
     *
     * @param entity200004 ServiceKeikakuHiRealtEntity
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void onLoad20004(
            ServiceKeikakuHiRealtEntity entity200004,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        setヘッダ_エリア(サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号);
        setサービス計画費パネル_詳細エリア200004(entity200004);
    }

    /**
     * 選択ボタンを押下した際に実行します。
     *
     * @param entity200904 ServiceKeikakuHiRealtEntity
     */
    public void onClick_SelectButton(
            ServiceKeikakuHiRealtEntity entity200904) {
        setサービス計画費パネル_詳細エリア200904(entity200904);
    }

    private void setヘッダ_エリア(
            FlexibleYearMonth サービス年月,
            RString 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書,
            RString 様式番号) {
        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisayiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);

    }

    /**
     * ボタン表示制御を処理します。
     *
     * @param entity DbT3118ShikibetsuNoKanriEntity
     */
    public void setボタン表示制御処理(
            DbT3118ShikibetsuNoKanriEntity entity) {

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
            div.getPanelHead().getBtnTokuteiShinryo().setDisabled(true);
        }
        // 特定入所者費用ボタン
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnTokuteiNyushosha().setDisabled(true);
        }

        //  TODO 凌護行 reamlに「緊急時・所定疾患」ボタンがありません。 QA回答まち
        if (new RString("2").equals(//dbt3118Entity.getKihonSetteiKubun()
                new RString("0"))) {
            // 「緊急時・所定疾患」ボタンを活性に表示、「緊急時施設療養費」ボタンを非表示
            div.getPanelHead().getBtnKinkyujiShisetsu().setVisible(false);
//            div.getPanelHead().getBtnKinkyujiShisetsu().setDisabled(true);
        } else {
            //  「緊急時・所定疾患」ボタンを非表示
//            div.getPanelHead().getBtnKinkyujiShisetsu().setVisible(true);
// 「緊急時施設療養費」ボタン
            if (設定不可.equals( // dbt3118Entity.getKinkyuShisetsuRyoyoSetteiKubun()
                    new RString("0"))) {
                div.getPanelHead().getBtnKinkyujiShisetsu().setDisabled(true);
            }
        }

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
            div.getPanelHead().getBtnShafukukeigenGaku().setDisabled(true);
        }
        // 「給付費明細(住所地特例)」ボタン
        if (設定不可.equals(//dbt3118Entity.getMeisaiJushochitokureiSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        }
    }

    private void setサービス計画費_パネル_共通エリア(List<ServiceKeikakuHiRealtEntity> entity200904List) {
        // TODO 凌護行 DbT3047ShokanServicePlan200904Entityとdbが不一致です QA回答まち
        ServiceKeikakuHiRealtEntity entity200904 = entity200904List.get(0);
        for (int i = 1; i < entity200904List.size(); i++) {
            if (new Decimal(entity200904.get連番().toString()).compareTo(new Decimal(entity200904List.get(i).get連番().toString())) > 0) {
                entity200904 = entity200904List.get(i);
            }
        }

        // TODO 凌護行 DB(DbT3047ShokanServicePlan200904)に項目「事業者区分コード」がありません。 QA回答まち
//        div.getPanelServiceKeikakuHiUp().getDdlJigyoshaKubun().getSelectedValue(new RString("1"));
//        // TODO 凌護行 DB(DbT3047ShokanServicePlan200904)に項目「審査方法」がありません。 QA回答まち
//        div.getPanelServiceKeikakuHiUp().getRdoShinsahouhou().setSelectedKey(new RString("1"));
        // TODO  凌護行 DB(DbT3047ShokanServicePlan200904)に項目「届出日」がありません。 QA回答まち
        div.getPanelServiceKeikakuHiUp().getTxtTodokedeYMD().setValue(new RDate(new RString("20151123").toString()));
//        div.getPanelServiceKeikakuHiUp().getTxtTantoKaigoshien().setValue(entity200904.get担当介護支給専門員番号());
        div.getPanelServiceKeikakuHiUp().getTxtTanyiTanka().setValue(entity200904.get単位数単価());
    }

    private void setサービス計画費パネル_データグリッドエリア(List<ServiceKeikakuHiRealtEntity> entity200904List) {
        List<dgdYichiran_Row> dataSource = new ArrayList<>();
        for (ServiceKeikakuHiRealtEntity entity200904 : entity200904List) {
            dgdYichiran_Row dgdYichiran_Row = new dgdYichiran_Row();
            dgdYichiran_Row.setDefaultDataName1(new RString(entity200904.getサービスコード().getColumnValue().toString()));
            dgdYichiran_Row.setDefaultDataName6(entity200904.get摘要());
            dgdYichiran_Row.getDefaultDataName2().setValue(new Decimal(entity200904.get単位数()));
            dgdYichiran_Row.getDefaultDataName3().setValue(new Decimal(entity200904.get回数()));
            dgdYichiran_Row.getDefaultDataName4().setValue(new Decimal(entity200904.getサービス単位数()));
            dgdYichiran_Row.setDefaultDataName5(new RString("名称"));
            dgdYichiran_Row.setDefaultDataName7(entity200904.get連番());
            dataSource.add(dgdYichiran_Row);
        }
        div.getPanelServiceKeikakuHiUp().getDgdYichiran().setDataSource(dataSource);
    }

    private void setサービス計画費パネル_詳細エリア200904(ServiceKeikakuHiRealtEntity entity200904) {
        // TODO 凌護行 画面表示される、前ゼロがあり、QA回答まち
        div.getPanelServiceKeikakuHiUp().getTxtServiceCode1().setValue(entity200904.getサービスコード().getColumnValue().substring(0, 2));
        div.getPanelServiceKeikakuHiUp().getTxtServiceCode2().setValue(entity200904.getサービスコード().getColumnValue().substring(2));
        div.getPanelServiceKeikakuHiUp().getTxtServiceName().setValue(new RString("名称"));
        div.getPanelServiceKeikakuHiUp().getTxtTanyiUp().setValue(new Decimal(entity200904.get単位数()));
        div.getPanelServiceKeikakuHiUp().getTxtKaisu().setValue(new Decimal(entity200904.get回数()));
        div.getPanelServiceKeikakuHiUp().getTxtServiceTanyiSu().setValue(new Decimal(entity200904.getサービス単位数()));
        div.getPanelServiceKeikakuHiUp().getTxtTekiyoUp().setValue(entity200904.get摘要());
        div.getPanelServiceKeikakuHiUp().getTxtShinsaYM().setDomain(new RYearMonth(entity200904.get審査年月().wareki().toDateString()));
        // TODO 凌護行 Enumクラスを提供しない、QA回答まち
//        div.getPanelServiceKeikakuHiUp().getTxtShikyuKubun().setValue(ShikyuFushikyuKubun.支給区分, entity200904.getShikyuKubunCode());
        div.getPanelServiceKeikakuHiUp().getTxtServiceTanyi().setValue(new Decimal(entity200904.getサービス単位数()));
        div.getPanelServiceKeikakuHiUp().getTxtShihanayiKingaku().setValue(new Decimal(entity200904.get支払金額()));
        div.getPanelServiceKeikakuHiUp().getTxtZougenten().setValue(new Decimal(entity200904.get増減点()));
        div.getPanelServiceKeikakuHiUp().getTxtNote1().setValue(entity200904.get備考1());
        div.getPanelServiceKeikakuHiUp().getTxtNote2().setValue(entity200904.get備考2());
        div.getPanelServiceKeikakuHiUp().getTxtNote3().setValue(entity200904.get備考3());
    }

    private void setサービス計画費パネル_詳細エリア200604(ServiceKeikakuHiRealtEntity entity200604) {
        // TODO 凌護行 DropDownListの設定、QA回答まち
//        div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setSelectedValue(entity200604.getShiteiKijunGaitoJigyoshaKubunCode());
        // TODO 凌護行 デープルに項目「届出日」がない、QA回答まち
        div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(new RDate(new RString("20151123").toString()));
        // TODO 凌護行 デープルに項目「審査方法」がない、QA回答まち
//        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedKey(new RString("0"));
        // TODO 凌護行 画面表示される、前ゼロがあり、QA回答まち
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown1().setValue(entity200604.getサービスコード200604().getColumnValue().substring(0, 2));
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown2().setValue(entity200604.getサービスコード200604().getColumnValue().substring(3));
        div.getPanelServiceKeikakuhiDown().getTxtServiceNamedown().setValue(new RString("サービス名称200604"));
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200604.get単位数200604()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200604.get単位数単価200604());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200604.get請求金額200604()));
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setValue(entity200604.get担当介護支援専門員番号200604());
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setValue(entity200604.get摘要200604());
        div.getPanelServiceKeikakuhiDown().getTxtShinsaYmdown().setDomain(new RYearMonth(entity200604.get審査年月200604().wareki().toDateString()));
        // TODO 凌護行 Enumクラスを提供しない、QA回答まち
//        div.getPanelServiceKeikakuhiDown().getTxtShikyuKubundown().setValue(entity200604.getShikyuKubunCode());
        div.getPanelServiceKeikakuhiDown().getTxtServiceTanyidown().setValue(new Decimal(entity200604.getサービス単位200604()));
        div.getPanelServiceKeikakuhiDown().getTxtShiharaiKingaku().setValue(new Decimal(entity200604.get支払金額200604()));
        div.getPanelServiceKeikakuhiDown().getTxtZougentendown().setValue(new Decimal(entity200604.get増減点200604()));
        div.getPanelServiceKeikakuhiDown().getTxtNote1down().setValue(entity200604.get備考1200604());
        div.getPanelServiceKeikakuhiDown().getTxtNote2down().setValue(entity200604.get備考2200604());
        div.getPanelServiceKeikakuhiDown().getTxtNote3down().setValue(entity200604.get備考3200604());
    }

    private void setサービス計画費パネル_詳細エリア200004(ServiceKeikakuHiRealtEntity entity200004) {
        // TODO 凌護行 DropDownListの設定、QA回答まち
//        div.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode().setSelectedValue(entity200004.getShiteiKijunGaitoJigyoshaKubunCode());
        // TODO 凌護行 デープルに項目「届出日」がない、QA回答まち
        div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(new RDate(new RString("20151123").toString()));
        // TODO 凌護行 デープルに項目「審査方法」がない、QA回答まち
//        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedKey(new RString("0"));
        // TODO 凌護行 画面表示される、前ゼロがあり、QA回答まち
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown1().setValue(new RString(entity200004.getサービスコード200004().toString().substring(0, 2)));
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown2().setValue(new RString(entity200004.getサービスコード200004().toString().substring(3)));
        div.getPanelServiceKeikakuhiDown().getTxtServiceNamedown().setValue(new RString("サービス名称200604"));
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200004.get単位数200004()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200004.get単位数単価200004());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200004.get請求金額200004()));
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setVisible(false);
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setVisible(false);
        // 審査年月
        div.getPanelServiceKeikakuhiDown().getTxtShinsaYmdown().setDomain(new RYearMonth(entity200004.get審査年月200004().wareki().toDateString()));
        // TODO 凌護行 Enumクラスを提供しない、QA回答まち
//        div.getPanelServiceKeikakuhiDown().getTxtShikyuKubundown().setValue(entity200004.getShikyuKubunCode());
        div.getPanelServiceKeikakuhiDown().getTxtServiceTanyidown().setVisible(false);
        div.getPanelServiceKeikakuhiDown().getTxtShiharaiKingaku().setValue(new Decimal(entity200004.get支払金額200004()));
        div.getPanelServiceKeikakuhiDown().getTxtZougentendown().setValue(new Decimal(entity200004.get増減点200004()));
        div.getPanelServiceKeikakuhiDown().getTxtNote1down().setValue(entity200004.get備考1200004());
        div.getPanelServiceKeikakuhiDown().getTxtNote2down().setValue(entity200004.get備考2200004());
        div.getPanelServiceKeikakuhiDown().getTxtNote3down().setValue(entity200004.get備考3200004());
    }
}
