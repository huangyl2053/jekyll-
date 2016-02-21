/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810024;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024.ServiceKeikakuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い状況照会_サービス計画費のハンドラクラスです。
 */
public class ServiceKeikakuHiHandler {

    private final ServiceKeikakuHiDiv div;
    private static final RString 設定不可 = new RString("0");

    public ServiceKeikakuHiHandler(ServiceKeikakuHiDiv div) {
        this.div = div;
    }

    public void onLoad(
            List<ShokanServicePlan200904Entity> entity200904List,
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

    public void onLoad(
            ShokanServicePlan200604Entity entity200604,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        setヘッダ_エリア(サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号);
        setサービス計画費パネル_詳細エリア200604(entity200604);
    }

    public void onLoad20004(
            ShokanServicePlan200004Entity entity200004,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        setヘッダ_エリア(サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号);
        setサービス計画費パネル_詳細エリア200004(entity200004);
    }

    public void onClick_SelectButton(
            ShokanServicePlan200904Entity entity200904) {
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

    public void setボタン表示制御処理(ShikibetsuNoKanriResult shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get基本設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosha().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigenGaku().setDisabled(true);
        }
        // TODO 給付費明細（住特）
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
        if (new RString("2").equals(shikibetsuNoKanriEntity.getEntity().get特定疾患施設療養設定区分())
                && new FlexibleYearMonth("201204").isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setDisplayNone(false);
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShisetsu().setVisible(false);
            div.getPanelHead().getBtnKinkyujiShisetsu().setDisplayNone(true);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get緊急時施設療養設定区分())) {
                div.getPanelHead().getBtnKinkyujiShisetsu().setDisabled(true);
            }
        }
    }

    private void setサービス計画費_パネル_共通エリア(List<ShokanServicePlan200904Entity> entity200904List) {
        // TODO 凌護行 DbT3047ShokanServicePlan200904Entityとdbが不一致です QA回答まち
        ShokanServicePlan200904Entity entity200904 = entity200904List.get(0);
        for (int i = 1; i < entity200904List.size(); i++) {
            if (new Decimal(entity200904.get連番().toString()).compareTo(new Decimal(entity200904List.get(i).get連番().toString())) > 0) {
                entity200904 = entity200904List.get(i);
            }
        }
        div.getPanelServiceKeikakuHiUp().getTxtJigyoshaKubun().setValue(entity200904.get指定_基準該当事業者区分コード());
        div.getPanelServiceKeikakuHiUp().getRdoShinsahouhou().setSelectedKey(entity200904.get審査方法区分コード());
        div.getPanelServiceKeikakuHiUp().getTxtTodokedeYMD().setValue(new RDate(entity200904.get届出日().toString()));
        div.getPanelServiceKeikakuHiUp().getTxtTantoKaigoshien().setValue(entity200904.get担当介護支給専門員番号());
        div.getPanelServiceKeikakuHiUp().getTxtTanyiTanka().setValue(entity200904.get単位数単価());
        div.getPanelServiceKeikakuHiUp().getTxtGokeiTanyi().setValue(new Decimal(entity200904.getサービス単位数合計()));
        div.getPanelServiceKeikakuHiUp().getTxtSeikyugaku().setValue(new Decimal(entity200904.get請求金額()));
    }

    private void setサービス計画費パネル_データグリッドエリア(List<ShokanServicePlan200904Entity> entity200904List) {
        List<dgdYichiran_Row> dataSource = new ArrayList<>();
        for (ShokanServicePlan200904Entity entity200904 : entity200904List) {
            dgdYichiran_Row dgdYichiran_Row = new dgdYichiran_Row();
            dgdYichiran_Row.setDefaultDataName1(new RString(entity200904.getサービスコード().getColumnValue().toString()));
            // TODO serviceName 没有
            dgdYichiran_Row.setDefaultDataName6(new RString("名称"));
            dgdYichiran_Row.getDefaultDataName2().setValue(new Decimal(entity200904.get単位数()));
            dgdYichiran_Row.getDefaultDataName3().setValue(new Decimal(entity200904.get回数()));
            dgdYichiran_Row.getDefaultDataName4().setValue(new Decimal(entity200904.getサービス単位数()));
            dgdYichiran_Row.setDefaultDataName5(entity200904.get摘要());
            dgdYichiran_Row.setDefaultDataName7(entity200904.get連番());
            dataSource.add(dgdYichiran_Row);
        }
        div.getPanelServiceKeikakuHiUp().getDgdYichiran().setDataSource(dataSource);
    }

    private void setサービス計画費パネル_詳細エリア200904(ShokanServicePlan200904Entity entity200904) {
        // TODO 凌護行 画面表示される、前ゼロがあり、QA回答まち
        div.getPanelServiceKeikakuHiUp().getTxtServiceCode1().setValue(entity200904.getサービスコード().getColumnValue().substring(0, 2));
        div.getPanelServiceKeikakuHiUp().getTxtServiceCode2().setValue(entity200904.getサービスコード().getColumnValue().substring(2));
        // TODO serviceName不知哪里取
        div.getPanelServiceKeikakuHiUp().getTxtServiceName().setValue(entity200904.getServiceName());
        div.getPanelServiceKeikakuHiUp().getTxtTanyiUp().setValue(new Decimal(entity200904.get単位数()));
        div.getPanelServiceKeikakuHiUp().getTxtKaisu().setValue(new Decimal(entity200904.get回数()));
        div.getPanelServiceKeikakuHiUp().getTxtServiceTanyiSu().setValue(new Decimal(entity200904.getサービス単位数()));
        div.getPanelServiceKeikakuHiUp().getTxtTekiyoUp().setValue(entity200904.get摘要());
        div.getPanelServiceKeikakuHiUp().getTxtShinsaYM().setDomain(new RYearMonth(entity200904.get審査年月().wareki().toDateString()));
        // TODO 凌護行 Enumクラスを提供しない、QA回答まち
        div.getPanelServiceKeikakuHiUp().getTxtShikyuKubun().setValue( entity200904.get支給区分());
        div.getPanelServiceKeikakuHiUp().getTxtServiceTanyi().setValue(new Decimal(entity200904.getサービス単位数()));
        div.getPanelServiceKeikakuHiUp().getTxtShihanayiKingaku().setValue(new Decimal(entity200904.get支払金額()));
        div.getPanelServiceKeikakuHiUp().getTxtZougenten().setValue(new Decimal(entity200904.get増減点()));
        div.getPanelServiceKeikakuHiUp().getTxtNote1().setValue(entity200904.get備考1());
        div.getPanelServiceKeikakuHiUp().getTxtNote2().setValue(entity200904.get備考2());
        div.getPanelServiceKeikakuHiUp().getTxtNote3().setValue(entity200904.get備考3());
    }

    private void setサービス計画費パネル_詳細エリア200604(ShokanServicePlan200604Entity entity200604) {
        div.getPanelServiceKeikakuhiDown().getTxtShiteiJigyoshaKubunCode().setValue(entity200604.get指定_基準該当事業者区分コード());
        div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(new RDate(entity200604.get届出日().toString()));
        // TODO Enumクラスを提供しない、QA回答まち
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedKey(entity200604.get審査方法());
        // TODO 凌護行 画面表示される、前ゼロがあり、QA回答まち
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown1().setValue(entity200604.getサービスコード().getColumnValue().substring(0, 2));
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown2().setValue(entity200604.getサービスコード().getColumnValue().substring(3));
        // TODO 这里没有serviceName，不知道哪里找
        div.getPanelServiceKeikakuhiDown().getTxtServiceNamedown().setValue(entity200604.getServiceName());
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200604.get単位数()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200604.get単位数単価());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200604.get請求金額()));
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setValue(entity200604.get担当介護支援専門員番号());
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setValue(entity200604.get摘要());
        div.getPanelServiceKeikakuhiDown().getTxtShinsaYmdown().setDomain(new RYearMonth(entity200604.get審査年月().wareki().toDateString()));
        // TODO 凌護行 Enumクラスを提供しない、QA回答まち
        div.getPanelServiceKeikakuhiDown().getTxtShikyuKubundown().setValue(entity200604.get支給区分());
        // TODO 表里没有サービス単位
//        div.getPanelServiceKeikakuhiDown().getTxtServiceTanyidown().setValue(new Decimal(entity200604.getサービス単位()));
        div.getPanelServiceKeikakuhiDown().getTxtShiharaiKingaku().setValue(new Decimal(entity200604.get支払金額()));
        div.getPanelServiceKeikakuhiDown().getTxtZougentendown().setValue(new Decimal(entity200604.get増減点()));
        div.getPanelServiceKeikakuhiDown().getTxtNote1down().setValue(entity200604.get備考1());
        div.getPanelServiceKeikakuhiDown().getTxtNote2down().setValue(entity200604.get備考2());
        div.getPanelServiceKeikakuhiDown().getTxtNote3down().setValue(entity200604.get備考3());
    }

    private void setサービス計画費パネル_詳細エリア200004(ShokanServicePlan200004Entity entity200004) {
        div.getPanelServiceKeikakuhiDown().getTxtShiteiJigyoshaKubunCode().setValue(entity200004.get指定_基準該当事業者区分コード());
        div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(new RDate(entity200004.get届出日().toString()));
        // TODO Enumクラスを提供しない、QA回答まち
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedKey(entity200004.get審査方法());
        // TODO 凌護行 画面表示される、前ゼロがあり、QA回答まち
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown1().setValue(entity200004.getサービスコード().getColumnValue().substring(0, 2));
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown2().setValue(entity200004.getサービスコード().getColumnValue().substring(3));
        // TODO 这里没有serviceName，不知道哪里找
        div.getPanelServiceKeikakuhiDown().getTxtServiceNamedown().setValue(entity200004.getServiceName());
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200004.get単位数()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200004.get単位数単価());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200004.get請求金額()));
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setVisible(false);
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setVisible(false);
        div.getPanelServiceKeikakuhiDown().getTxtShinsaYmdown().setDomain(new RYearMonth(entity200004.get審査年月().wareki().toDateString()));
        // TODO 凌護行 Enumクラスを提供しない、QA回答まち
        div.getPanelServiceKeikakuhiDown().getTxtShikyuKubundown().setValue(entity200004.get支給区分());
        div.getPanelServiceKeikakuhiDown().getTxtServiceTanyidown().setVisible(false);
        div.getPanelServiceKeikakuhiDown().getTxtShiharaiKingaku().setValue(new Decimal(entity200004.get支払金額()));
        div.getPanelServiceKeikakuhiDown().getTxtZougentendown().setValue(new Decimal(entity200004.get増減点()));
        div.getPanelServiceKeikakuhiDown().getTxtNote1down().setValue(entity200004.get備考1());
        div.getPanelServiceKeikakuhiDown().getTxtNote2down().setValue(entity200004.get備考2());
        div.getPanelServiceKeikakuhiDown().getTxtNote3down().setValue(entity200004.get備考3());
    }
}
