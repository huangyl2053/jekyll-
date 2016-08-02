/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810024;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024.ServiceKeikakuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024.dgdYichiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 償還払い状況照会_サービス計画費のハンドラクラスです。
 *
 * @reamsid_L DBC-1010-010 gongliang
 */
public class ServiceKeikakuHiHandler {

    private final ServiceKeikakuHiDiv div;
    private static final int 桁目から = 3;
    private static final RString 設定可_任意 = new RString("2");
    private static final RString 設定不可 = new RString("0");
    private static final RString コード種別 = new RString("0002");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    /**
     * ServiceKeikakuHiHandler
     *
     * @param div ServiceKeikakuHiDiv
     */
    public ServiceKeikakuHiHandler(ServiceKeikakuHiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化onLoad 平成２１年4月以降の場合 Handler
     *
     * @param entity200904List List<ShokanServicePlan200904Result>
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void onLoad(
            List<ShokanServicePlan200904Result> entity200904List,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        ShokanServicePlan200904Result entity200904 = entity200904List.get(0);
        for (int i = 1; i < entity200904List.size(); i++) {
            if (new Decimal(entity200904.getEntity().get連番().toString()).compareTo(
                    new Decimal(entity200904List.get(i).getEntity().get連番().toString())) < 0) {
                entity200904 = entity200904List.get(i);
            }
        }
        setヘッダ_エリア(サービス年月, 申請日, 事業者番号, 明細番号, 証明書);
        setサービス計画費_パネル_共通エリア(entity200904);
        setサービス計画費パネル_データグリッドエリア(entity200904List);
        div.getPanelServiceKeikakuhiUp1().getTxtSeikyugaku().setValue(new Decimal(entity200904.getEntity().get請求金額()));
        div.getPanelServiceKeikakuhiUp1().getTxtGokeiTanyi().setValue(new Decimal(entity200904.getEntity().getサービス単位数合計()));
    }

    /**
     * 画面初期化onLoad サービス年月が200604～200903の場合
     *
     * @param entity200604 ShokanServicePlan200604Result
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void onLoad(
            ShokanServicePlan200604Result entity200604,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        setヘッダ_エリア(サービス年月, 申請日, 事業者番号, 明細番号, 証明書);
        setサービス計画費パネル_詳細エリア200604(entity200604);
    }

    /**
     * 画面初期化onLoad サービス年月が200603以前の場合
     *
     * @param entity200004 ShokanServicePlan200004Result
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void onLoad20004(
            ShokanServicePlan200004Result entity200004,
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        setヘッダ_エリア(サービス年月, 申請日, 事業者番号, 明細番号, 証明書);
        setサービス計画費パネル_詳細エリア200004(entity200004);
    }

    /**
     * 「選択」ボタン サービス計画費パネル_詳細エリア Handler
     *
     * @param entity200904 ShokanServicePlan200904Result
     */
    public void onClick_SelectButton(
            ShokanServicePlan200904Result entity200904) {
        setサービス計画費_パネル_共通エリア(entity200904);
        setサービス計画費パネル_詳細エリア200904(entity200904);
    }

    /**
     * ボタン表示制御処理
     *
     * @param shikibetsuNoKanriEntity ShikibetsuNoKanri
     * @param サービス年月 FlexibleYearMonth
     */
    public void setボタン表示制御処理(ShikibetsuNoKanri shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosha().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigenGaku().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.get所定疾患施設療養設定区分())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setDisplayNone(false);
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShisetsu().setVisible(false);
            div.getPanelHead().getBtnKinkyujiShisetsu().setDisplayNone(true);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.get緊急時施設療養設定区分())) {
                div.getPanelHead().getBtnKinkyujiShisetsu().setDisabled(true);
            }
        }
    }

    private void setヘッダ_エリア(
            FlexibleYearMonth サービス年月,
            RString 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisayiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    private void setサービス計画費_パネル_共通エリア(ShokanServicePlan200904Result entity200904) {
        RString 指定_基準該当事業者区分 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, new CodeShubetsu(コード種別),
                new Code(entity200904.getEntity().get指定_基準該当事業者区分コード()), FlexibleDate.getNowDate());
        div.getPanelServiceKeikakuhiUp1().getTxtJigyoshaKubun().setValue(指定_基準該当事業者区分);
        div.getPanelServiceKeikakuhiUp1().getRdoShinsahouhou().setSelectedValue(
                ShinsaHohoKubun.toValue(entity200904.getEntity().get審査方法区分コード()).get名称());
        FlexibleDate 届出日 = entity200904.getEntity().get居宅サービス計画作成依頼届出年月日();
        if (届出日 != null) {
            div.getPanelServiceKeikakuhiUp1().getTxtTodokedeYMD().setValue(new RDate(届出日.toString()));
        }
        div.getPanelServiceKeikakuhiUp1().getTxtTantoKaigoshien().setValue(entity200904.getEntity().get担当介護支援専門員番号());
        div.getPanelServiceKeikakuhiUp1().getTxtTanyiTanka().setValue(entity200904.getEntity().get単位数単価());
        div.getPanelServiceKeikakuhiUp1().getTxtGokeiTanyi().setValue(new Decimal(entity200904.getEntity().getサービス単位数合計()));
        div.getPanelServiceKeikakuhiUp1().getTxtSeikyugaku().setValue(new Decimal(entity200904.getEntity().get請求金額()));
    }

    private void setサービス計画費パネル_データグリッドエリア(List<ShokanServicePlan200904Result> entity200904List) {
        List<dgdYichiran_Row> dataSource = new ArrayList<>();
        for (ShokanServicePlan200904Result entity200904 : entity200904List) {
            dgdYichiran_Row dgdYichiran_Row = new dgdYichiran_Row();
            dgdYichiran_Row.setDefaultDataName1(
                    new RString(entity200904.getEntity().getサービスコード().getColumnValue().toString()));
            dgdYichiran_Row.setDefaultDataName6(entity200904.getServiceName());
            dgdYichiran_Row.getDefaultDataName2().setValue(new Decimal(entity200904.getEntity().get単位数()));
            dgdYichiran_Row.getDefaultDataName3().setValue(new Decimal(entity200904.getEntity().get回数()));
            dgdYichiran_Row.getDefaultDataName4().setValue(new Decimal(entity200904.getEntity().getサービス単位数()));
            dgdYichiran_Row.setDefaultDataName5(entity200904.getEntity().get摘要());
            dgdYichiran_Row.setDefaultDataName7(entity200904.getEntity().get連番());
            dataSource.add(dgdYichiran_Row);
        }
        div.getPanelServiceKeikakuhiUp1().getDgdYichiran().setDataSource(dataSource);
    }

    private void setサービス計画費パネル_詳細エリア200904(ShokanServicePlan200904Result entity200904) {
        div.getPanelServiceKeikakuhiUp1().getTxtServiceCode1().setValue(
                entity200904.getEntity().getサービスコード().getColumnValue().substring(0, 2));
        div.getPanelServiceKeikakuhiUp1().getTxtServiceCode2().setValue(
                entity200904.getEntity().getサービスコード().getColumnValue().substring(桁目から));
        div.getPanelServiceKeikakuhiUp1().getTxtServiceName().setValue(entity200904.getServiceName());
        div.getPanelServiceKeikakuhiUp1().getTxtTanyiUp().setValue(new Decimal(entity200904.getEntity().get単位数()));
        div.getPanelServiceKeikakuhiUp1().getTxtKaisu().setValue(new Decimal(entity200904.getEntity().get回数()));
        div.getPanelServiceKeikakuhiUp1().getTxtServiceTanyiSu().setValue(new Decimal(entity200904.getEntity().getサービス単位数()));
        div.getPanelServiceKeikakuhiUp1().getTxtTekiyoUp().setValue(entity200904.getEntity().get摘要());
        FlexibleYearMonth 審査年月 = entity200904.getEntity().get審査年月();
        if (審査年月 != null) {
            div.getPanelServiceKeikakuhiUp1().getTxtShinsaYM().setValue(new RDate(審査年月.toString()));
        }
        RString 支給区分コード = entity200904.getEntity().get支給区分コード();
        if (支給区分コード != null) {
            div.getPanelServiceKeikakuhiUp1().getTxtShikyuKubun().setValue(ShikyuFushikyuKubun.toValue(支給区分コード).get名称());
        }
        div.getPanelServiceKeikakuhiUp1().getTxtServiceTanyi().setValue(new Decimal(entity200904.getEntity().get点数_金額()));
        div.getPanelServiceKeikakuhiUp1().getTxtShihanayiKingaku().setValue(new Decimal(entity200904.getEntity().get支給金額()));
        div.getPanelServiceKeikakuhiUp1().getTxtZougenten().setValue(new Decimal(entity200904.getEntity().get増減点()));
        div.getPanelServiceKeikakuhiUp1().getTxtNote1().setValue(entity200904.getEntity().get増減理由等());
        div.getPanelServiceKeikakuhiUp1().getTxtNote2().setValue(entity200904.getEntity().get不支給理由等());
        div.getPanelServiceKeikakuhiUp1().getTxtNote3().setValue(entity200904.getEntity().get購入_改修履歴等());
    }

    private void setサービス計画費パネル_詳細エリア200604(ShokanServicePlan200604Result entity200604) {
        RString 指定_基準該当事業者区分 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, new CodeShubetsu(コード種別),
                new Code(entity200604.getEntity().get指定_基準該当事業者区分コード()), FlexibleDate.getNowDate());
        div.getPanelServiceKeikakuhiDown().getTxtShiteiJigyoshaKubunCode().setValue(指定_基準該当事業者区分);
        FlexibleDate 届出日 = entity200604.getEntity().get居宅サービス計画作成依頼届出年月日();
        if (届出日 != null) {
            div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(new RDate(届出日.toString()));
        }
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedValue(
                ShinsaHohoKubun.toValue(entity200604.getEntity().get審査方法区分コード()).get名称());
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown1().setValue(
                entity200604.getEntity().getサービスコード().getColumnValue().substring(0, 2));
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown2().setValue(
                entity200604.getEntity().getサービスコード().getColumnValue().substring(桁目から));
        div.getPanelServiceKeikakuhiDown().getTxtServiceNamedown().setValue(entity200604.getServiceName());
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200604.getEntity().get単位数()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200604.getEntity().get単位数単価());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200604.getEntity().get請求金額()));
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setValue(entity200604.getEntity().get担当介護支援専門員番号());
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setValue(entity200604.getEntity().get摘要());
        FlexibleYearMonth 審査年月 = entity200604.getEntity().get審査年月();
        if (審査年月 != null) {
            div.getPanelServiceKeikakuhiDown().getTxtShinsaYmdown().setValue(new RDate(審査年月.toString()));
        }
        RString 支給区分コード = entity200604.getEntity().get支給区分コード();
        if (支給区分コード != null) {
            div.getPanelServiceKeikakuhiDown().getTxtShikyuKubundown().setValue(ShikyuFushikyuKubun.toValue(支給区分コード).get名称());
        }
        div.getPanelServiceKeikakuhiDown().getTxtServiceTanyidown().setValue(new Decimal(entity200604.getEntity().get点数_金額()));
        div.getPanelServiceKeikakuhiDown().getTxtShiharaiKingaku().setValue(new Decimal(entity200604.getEntity().get支給金額()));
        div.getPanelServiceKeikakuhiDown().getTxtZougentendown().setValue(new Decimal(entity200604.getEntity().get増減点()));
        div.getPanelServiceKeikakuhiDown().getTxtNote1down().setValue(entity200604.getEntity().get増減理由等());
        div.getPanelServiceKeikakuhiDown().getTxtNote2down().setValue(entity200604.getEntity().get不支給理由等());
        div.getPanelServiceKeikakuhiDown().getTxtNote3down().setValue(entity200604.getEntity().get購入_改修履歴等());
    }

    private void setサービス計画費パネル_詳細エリア200004(ShokanServicePlan200004Result entity200004) {
        RString 指定_基準該当事業者区分 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, new CodeShubetsu(コード種別),
                new Code(entity200004.getEntity().get指定_基準該当事業者区分コード()), FlexibleDate.getNowDate());
        div.getPanelServiceKeikakuhiDown().getTxtShiteiJigyoshaKubunCode().setValue(指定_基準該当事業者区分);
        FlexibleDate 届出日 = entity200004.getEntity().get居宅サービス計画作成依頼届出年月日();
        if (届出日 != null) {
            div.getPanelServiceKeikakuhiDown().getTxtTodokedeDate().setValue(new RDate(届出日.toString()));
        }
        div.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou().setSelectedValue(
                ShinsaHohoKubun.toValue(entity200004.getEntity().get審査方法区分コード()).get名称());
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown1().setValue(
                entity200004.getEntity().getサービスコード().getColumnValue().substring(0, 2));
        div.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown2().setValue(
                entity200004.getEntity().getサービスコード().getColumnValue().substring(桁目から));
        div.getPanelServiceKeikakuhiDown().getTxtServiceNamedown().setValue(entity200004.getServiceName());
        div.getPanelServiceKeikakuhiDown().getTxtTanyiDown().setValue(new Decimal(entity200004.getEntity().get単位数()));
        div.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka().setValue(entity200004.getEntity().get単位数単価());
        div.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown().setValue(new Decimal(entity200004.getEntity().get請求金額()));
        div.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien().setVisible(false);
        div.getPanelServiceKeikakuhiDown().getTxtTekiyo().setVisible(false);
        FlexibleYearMonth 審査年月 = entity200004.getEntity().get審査年月();
        if (審査年月 != null) {
            div.getPanelServiceKeikakuhiDown().getTxtShinsaYmdown().setValue(new RDate(審査年月.toString()));
        }
        RString 支給区分コード = entity200004.getEntity().get支給区分コード();
        if (支給区分コード != null) {
            div.getPanelServiceKeikakuhiDown().getTxtShikyuKubundown().setValue(ShikyuFushikyuKubun.toValue(支給区分コード).get名称());
        }
        div.getPanelServiceKeikakuhiDown().getTxtServiceTanyidown().setValue(new Decimal(entity200004.getEntity().get点数_金額()));
        div.getPanelServiceKeikakuhiDown().getTxtShiharaiKingaku().setValue(new Decimal(entity200004.getEntity().get支給金額()));
        div.getPanelServiceKeikakuhiDown().getTxtZougentendown().setValue(new Decimal(entity200004.getEntity().get増減点()));
        div.getPanelServiceKeikakuhiDown().getTxtNote1down().setValue(entity200004.getEntity().get増減理由等());
        div.getPanelServiceKeikakuhiDown().getTxtNote2down().setValue(entity200004.getEntity().get不支給理由等());
        div.getPanelServiceKeikakuhiDown().getTxtNote3down().setValue(entity200004.getEntity().get購入_改修履歴等());
    }
}
