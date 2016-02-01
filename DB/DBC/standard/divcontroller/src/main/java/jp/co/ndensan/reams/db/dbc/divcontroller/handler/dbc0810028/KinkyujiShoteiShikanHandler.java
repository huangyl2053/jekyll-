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
 * 償還払い状況照会_緊急時・所定疾患画面のハンドラクラスです
 *
 * @author XuPeng
 */
public class KinkyujiShoteiShikanHandler {

    private final KinkyujiShoteiShikanDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 改行 = new RString("\n");

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
        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(
                サービス年月.wareki().toDateString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(
                申請日.wareki().toDateString().toString()));
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
            row.getDefaultDataName3().setValue(new Decimal(result.get所定疾患施設療養費小計()));
            row.setDefaultDataName5(result.get緊急時傷病名１());
            row.getDefaultDataName6().setValue(new RDate(
                    result.get緊急時治療開始年月日１().wareki().toDateString().toString()));
            row.getDefaultDataName7().setValue(new Decimal(result.get緊急時治療管理小計()));
            row.getDefaultDataName4().setValue((new Decimal(result.get緊急時施設療養費合計単位数())));
            row.setDefaultDataName8(result.get連番());
            lists.add(row);
        }
        div.getDgdKinkyujiShoteiList().setDataSource(lists);
    }

    public void setUp傷病名(ShokanShoteiShikkanShisetsuRyoyo result) {
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName1().setValue(
                result.get所定疾患施設療養費傷病名１());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName2().setValue(
                result.get所定疾患施設療養費傷病名２());
        div.getPanelShobyoName().getTxtShoteiShikkanShobyoName3().setValue(
                result.get所定疾患施設療養費傷病名３());
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
        RStringBuilder tekiyou = new RStringBuilder("");
        if (result.get摘要１() != null && !result.get摘要１().isEmpty()) {
            tekiyou.append(result.get摘要１());
        }
        if (result.get摘要２() != null && !result.get摘要２().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要２());
        }
        if (result.get摘要３() != null && !result.get摘要３().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要３());
        }
        if (result.get摘要４() != null && !result.get摘要４().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要４());
        }
        if (result.get摘要５() != null && !result.get摘要５().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要５());
        }
        if (result.get摘要６() != null && !result.get摘要６().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要６());
        }
        if (result.get摘要７() != null && !result.get摘要７().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要７());
        }
        if (result.get摘要８() != null && !result.get摘要８().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要８());
        }
        if (result.get摘要９() != null && !result.get摘要９().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要９());
        }
        if (result.get摘要１０() != null && !result.get摘要１０().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１０());
        }
        if (result.get摘要１１() != null && !result.get摘要１１().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１１());
        }
        if (result.get摘要１２() != null && !result.get摘要１２().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１２());
        }
        if (result.get摘要１３() != null && !result.get摘要１３().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１３());
        }
        if (result.get摘要１４() != null && !result.get摘要１４().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１４());
        }
        if (result.get摘要１５() != null && !result.get摘要１５().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１５());
        }
        if (result.get摘要１６() != null && !result.get摘要１６().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１６());
        }
        if (result.get摘要１７() != null && !result.get摘要１７().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１７());
        }
        if (result.get摘要１８() != null && !result.get摘要１８().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１８());
        }
        if (result.get摘要１９() != null && !result.get摘要１９().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要１９());
        }
        if (result.get摘要２０() != null && !result.get摘要２０().isEmpty()) {
            tekiyou.append(改行);
            tekiyou.append(result.get摘要２０());
        }
        return tekiyou.toRString();
    }

    public void setUp治療点数(ShokanShoteiShikkanShisetsuRyoyo result) {
        div.getPanelJiryoutensu().getTxtShoteiShikkanTanisu().setValue(
                new Decimal(result.get所定疾患施設療養費単位数()));
        div.getPanelJiryoutensu().getTxtShoteiShikkanNissu().setValue(
                result.get所定疾患施設療養費日数());
        div.getPanelJiryoutensu().getTxtShoteiShikkanSubTotal().setValue(
                new Decimal(result.get所定疾患施設療養費小計()));
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriTanisu().setValue(
                new Decimal(result.get緊急時治療管理単位数()));
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriNissu().setValue(
                result.get緊急時治療管理日数());
        div.getPanelJiryoutensu().getTxtKinkyuChiryoKanriSubTotal().setValue(
                new Decimal(result.get緊急時治療管理小計()));
        div.getPanelJiryoutensu().getTxtRehabilitationTanisu().setValue(
                new Decimal(result.getリハビリテーション単位数()));
        div.getPanelJiryoutensu().getTxtShujutsuTanisu().setValue(
                new Decimal(result.get手術単位数()));
        div.getPanelJiryoutensu().getTxtHoshasenChiryoTanisu().setValue(
                new Decimal(result.get放射線治療単位数()));
        div.getPanelJiryoutensu().getTxtShochiTanisu().setValue(new Decimal(
                result.get処置単位数()));
        div.getPanelJiryoutensu().getTxtMasuiTanisu().setValue(new Decimal(
                result.get麻酔単位数()));
        div.getPanelJiryoutensu().getTxtTokuteiJiryoGoukei().setValue(
                new Decimal(result.get緊急時施設療養費合計単位数()));
    }

    public void setボタン表示制御処理(ShikibetsuNoKanriEntity 識別番号) {
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
