/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810028;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028.KinkyujiShoteiShikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028.dgdKinkyujiShoteiList_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author XuPeng
 */
public class KinkyujiShoteiShikanHandler {

    private final KinkyujiShoteiShikanDiv div;
    private static final RString 設定不可 = new RString("0");

    private KinkyujiShoteiShikanHandler(KinkyujiShoteiShikanDiv div) {
        this.div = div;
    }

    public static KinkyujiShoteiShikanHandler of(KinkyujiShoteiShikanDiv div) {
        return new KinkyujiShoteiShikanHandler(div);
    }

    public void initPanelHead(FlexibleYearMonth サービス年月,
            RDate 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書,
            RString 様式番号) {
        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    public void initDgdKinkyujiShoteiList(List<ShokanShoteiShikkanShisetsuRyoyo> businessList) {
        List<dgdKinkyujiShoteiList_Row> lists = new ArrayList<>();
        for (ShokanShoteiShikkanShisetsuRyoyo result : businessList) {
            dgdKinkyujiShoteiList_Row row = new dgdKinkyujiShoteiList_Row();
            row.setDefaultDataName1(result.get所定疾患施設療養費傷病名１());
            row.getDefaultDataName2().setValue(new RDate(
                    result.get所定疾患施設療養費開始年月日１().wareki().toDateString().toString()));
            row.getDefaultDataName3().setValue(new Decimal(result.get所定疾患施設療養費単位数()));
            row.setDefaultDataName5(result.get緊急時傷病名１());
            row.getDefaultDataName6().setValue(new RDate(
                    result.get緊急時治療開始年月日１().wareki().toDateString().toString()));
            row.getDefaultDataName7().setValue(new Decimal(result.get緊急時治療管理単位数()));
            row.getDefaultDataName4().setValue((new Decimal(result.get緊急時施設療養費合計単位数())));
            row.setDefaultDataName8(result.get連番());
            lists.add(row);
        }
        div.getDgdKinkyujiShoteiList().setDataSource(lists);
    }

    //test
    public void initList() {
        List<dgdKinkyujiShoteiList_Row> lists = new ArrayList<>();
        dgdKinkyujiShoteiList_Row row = new dgdKinkyujiShoteiList_Row();
        row.setDefaultDataName1(new RString(("cold")));
        row.getDefaultDataName2().setValue(new RDate(
                new RDate(2016, 01, 18).wareki().toDateString().toString()));
        row.getDefaultDataName3().setValue(new Decimal(123));
        row.setDefaultDataName5(new RString("hot"));
        row.getDefaultDataName6().setValue(new RDate(
                new RDate(2016, 01, 18).wareki().toDateString().toString()));
        row.getDefaultDataName7().setValue(new Decimal(132));
        row.getDefaultDataName4().setValue((new Decimal(123456)));
        lists.add(row);
        div.getDgdKinkyujiShoteiList().setDataSource(lists);
    }

    public void setUp傷病名(ShokanShoteiShikkanShisetsuRyoyo result) {
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName1().setValue(result.get所定疾患施設療養費傷病名１());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName2().setValue(result.get所定疾患施設療養費傷病名２());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName3().setValue(result.get所定疾患施設療養費傷病名３());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD1().setValue(new RDate(
                result.get所定疾患施設療養費開始年月日１().wareki().toDateString().toString()));
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD2().setValue(new RDate(
                result.get所定疾患施設療養費開始年月日２().wareki().toDateString().toString()));
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoKaishiYMD3().setValue(new RDate(
                result.get所定疾患施設療養費開始年月日３().wareki().toDateString().toString()));
        div.getPanelShobyoName().getTxtKinkyuShobyoName1().setValue(result.get緊急時傷病名１());
        div.getPanelShobyoName().getTxtKinkyuShobyoName2().setValue(result.get緊急時傷病名２());
        div.getPanelShobyoName().getTxtKinkyuShobyoName3().setValue(result.get緊急時傷病名３());
        div.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD1().setValue(new RDate(
                result.get緊急時治療開始年月日１().wareki().toDateString().toString()));
        div.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD2().setValue(new RDate(
                result.get緊急時治療開始年月日２().wareki().toDateString().toString()));
        div.getPanelShobyoName().getTxtKinkyuChiryoKaishiYMD3().setValue(new RDate(
                result.get緊急時治療開始年月日３().wareki().toDateString().toString()));
    }

    public void setUp往診通院(ShokanShoteiShikkanShisetsuRyoyo result) {
        div.getPanelOshinTuyin().getTxtOshinNissu().setValue(result.get往診日数());
        div.getPanelOshinTuyin().getTxtOshinIryoKikanName().setValue(result.get往診医療機関名());
        div.getPanelOshinTuyin().getTxtTsuyinNissu().setValue(result.get通院日数());
        div.getPanelOshinTuyin().getTxtTsuinKikanName().setValue(result.get通院医療機関名());
        div.getPanelOshinTuyin().getTxtTekiyou().setValue(get摘要(result));
    }

    private RString get摘要(ShokanShoteiShikkanShisetsuRyoyo result) {
        RStringBuilder tekiyou = new RStringBuilder(result.get摘要１());
        tekiyou.append(result.get摘要２());
        tekiyou.append(result.get摘要３());
        tekiyou.append(result.get摘要４());
        tekiyou.append(result.get摘要５());
        tekiyou.append(result.get摘要６());
        tekiyou.append(result.get摘要７());
        tekiyou.append(result.get摘要８());
        tekiyou.append(result.get摘要９());
        tekiyou.append(result.get摘要１０());
        tekiyou.append(result.get摘要１１());
        tekiyou.append(result.get摘要１２());
        tekiyou.append(result.get摘要１３());
        tekiyou.append(result.get摘要１４());
        tekiyou.append(result.get摘要１５());
        tekiyou.append(result.get摘要１６());
        tekiyou.append(result.get摘要１７());
        tekiyou.append(result.get摘要１８());
        tekiyou.append(result.get摘要１９());
        tekiyou.append(result.get摘要２０());
        return tekiyou.toRString();
    }

    public void setUp治療点数(ShokanShoteiShikkanShisetsuRyoyo result) {
        div.getPanelJiryoutensu().getTxtShoteiShikkanTanisu().setValue(
                new Decimal(result.get所定疾患施設療養費単位数()));
        div.getPanelJiryoutensu().getTxtShoteiShikkanNissu().setValue(result.get所定疾患施設療養費日数());
        div.getPanelJiryoutensu().getTxtShoteiShikkanSubTotal().setValue(
                new Decimal(result.get所定疾患施設療養費小計()));
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriTanisu().setValue(
                new Decimal(result.get緊急時治療管理単位数()));
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriNissu().setValue(result.get緊急時治療管理日数());
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriSubTotal().setValue(
                new Decimal(result.get緊急時治療管理小計()));
        div.getPanelJiryoutensu().getTxtRehabilitationTanisu().setValue(
                new Decimal(result.getリハビリテーション単位数()));
        div.getPanelJiryoutensu().getTxtShujutsuTanisu().setValue(new Decimal(result.get手術単位数()));
        div.getPanelJiryoutensu().getTxtHoshasenChiryoTanisu().setValue(new Decimal(result.get放射線治療単位数()));
        div.getPanelJiryoutensu().getTxtShochiTanisu().setValue(new Decimal(result.get処置単位数()));
        div.getPanelJiryoutensu().getTxtMasuiTanisu().setValue(new Decimal(result.get麻酔単位数()));
        div.getPanelJiryoutensu().getTxtTokuteiJiryoGoukei().setValue(new Decimal(result.get緊急時施設療養費合計単位数()));
    }

    public void setボタン表示制御処理(ShikibetsuNoKanriEntity 識別番号, FlexibleYearMonth サービス年月) {

        //基本情報
        if (設定不可.equals(識別番号.getEntity().getKihonSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        //給付費明細
        if (設定不可.equals(識別番号.getEntity().getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        //特定診療費
        if (設定不可.equals(識別番号.getEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        //サービス計画費
        if (設定不可.equals(識別番号.getEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        // 特定入所者費用ボタン
        if (設定不可.equals(識別番号.getEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        // 「食事費用」ボタン
        if (設定不可.equals(識別番号.getEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        // 「請求額集計」ボタン
        if (設定不可.equals(識別番号.getEntity().getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        // 「社福軽減額」ボタン
        if (設定不可.equals(識別番号.getEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        //給付費明細（住特）
        if (設定不可.equals(識別番号.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }

    }

}
