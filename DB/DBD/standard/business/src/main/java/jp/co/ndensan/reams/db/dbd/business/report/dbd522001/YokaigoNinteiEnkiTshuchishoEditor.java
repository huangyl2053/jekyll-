/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd522001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.YokaigoNinteiEnkiTshuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522001.YokaigoNinteiEnkiTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定延期通知書タイトルEditorです。
 *
 * @reamsid_L DBD-1410-030 chenxin
 */
class YokaigoNinteiEnkiTshuchishoEditor implements IYokaigoNinteiEnkiTshuchishoEditor {

    private final YokaigoNinteiEnkiTshuchishoEntity entity;

    protected YokaigoNinteiEnkiTshuchishoEditor(YokaigoNinteiEnkiTshuchishoEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定延期通知書タイトルEditorです。
     *
     * @param source YokaigoNinteiEnkiTshuchishoReportSource
     * @return source YokaigoNinteiEnkiTshuchishoReportSource
     */
    @Override
    public YokaigoNinteiEnkiTshuchishoReportSource edit(YokaigoNinteiEnkiTshuchishoReportSource source) {
        edit基本情報(source);
        editフォント混在2(source);
        editフォント混在(source);
        editフォント大(source);
        edit認証者情報(source);
        edit送付物宛先情報(source);
        return source;
    }

    private void edit基本情報(YokaigoNinteiEnkiTshuchishoReportSource source) {
        source.bunshoNo = entity.get文書番号();
        source.title = DbBusinessConfig.get(ConfigNameDBE.要介護認定延期通知書, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        source.tsuchibun1 = entity.get通知文1();
        source.hihokenshaNo1 = entity.getEntity().getHihokenshaNo().substring(1);
        source.hihokenshaNo2 = entity.getEntity().getHihokenshaNo().substring(2);
        source.hihokenshaNo3 = entity.getEntity().getHihokenshaNo().substring(3);
        source.hihokenshaNo4 = entity.getEntity().getHihokenshaNo().substring(4);
        source.hihokenshaNo5 = entity.getEntity().getHihokenshaNo().substring(5);
        source.hihokenshaNo6 = entity.getEntity().getHihokenshaNo().substring(6);
        source.hihokenshaNo7 = entity.getEntity().getHihokenshaNo().substring(7);
        source.hihokenshaNo8 = entity.getEntity().getHihokenshaNo().substring(8);
        source.hihokenshaNo9 = entity.getEntity().getHihokenshaNo().substring(9);
        source.hihokenshaNo10 = entity.getEntity().getHihokenshaNo().substring(10);
        source.hihokenshaName = entity.getEntity().getHihokenshaName().getColumnValue();
        source.riyu1 = new RString(entity.getEntity().getEnkiRiyu().toString());
        //TODO 共通ポリシーパターンー9 FillType ZERO
        source.shoriMikomiKaishiYMD = entity.getEntity().getEnkiMikomiKaishiYMD()
                == null ? RString.EMPTY : entity.getEntity().getEnkiMikomiKaishiYMD()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        //TODO 共通ポリシーパターンー9 FillType ZERO
        source.shoriMikomiShuryoYMD = entity.getEntity().getEnkiMikomiShuryoYMD()
                == null ? RString.EMPTY : entity.getEntity().getEnkiMikomiShuryoYMD()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.tsuchibun2 = entity.get通知文2();

    }

    private void editフォント混在2(YokaigoNinteiEnkiTshuchishoReportSource source) {
        source.tsuchibun6 = entity.getフォント混在2_1();
        source.tsuchibun7 = entity.getフォント混在2_2();
    }

    private void editフォント混在(YokaigoNinteiEnkiTshuchishoReportSource source) {
        source.tsuchibun4 = entity.getフォント混在_1();
        source.tsuchibun5 = entity.getフォント混在_2();
    }

    private void editフォント大(YokaigoNinteiEnkiTshuchishoReportSource source) {
        source.tsuchibun3 = entity.getフフォント大();
    }

    private void edit認証者情報(YokaigoNinteiEnkiTshuchishoReportSource source) {
        source.denshiKoin = entity.get電子公印();
        source.hakkoYMD = entity.get発行日();
        source.ninshoshaYakushokuMei = entity.get認証者役職名();
        source.ninshoshaYakushokuMei1 = entity.get認証者役職名1();
        source.ninshoshaYakushokuMei2 = entity.get認証者役職名2();
        source.ninshoshaShimeiKakenai = entity.get認証者氏名公印に掛けない();
        source.ninshoshaShimeiKakeru = entity.get認証者氏名公印に掛ける();
        source.koinShoryaku = entity.get公印省略();
        source.koinMojiretsu = entity.get公印文字列();
    }

    private void edit送付物宛先情報(YokaigoNinteiEnkiTshuchishoReportSource source) {
        source.yubinNo = entity.get郵便番号();
        source.gyoseiku = entity.get行政区();
        source.jushoText = entity.get住所TextField();
        source.jusho1 = entity.get住所優先順位1();
        source.jusho2 = entity.get住所優先順位2();
        source.jusho3 = entity.get住所優先順位3();
        source.katagakiText = entity.get方書TextField();
        source.katagaki1 = entity.get方書優先順位1標準();
        source.katagaki2 = entity.get方書優先順位2標準();
        source.katagakiSmall1 = entity.get方書優先順位1小();
        source.katagakiSmall2 = entity.get方書優先順位2小();
        source.dainoKubunMei = entity.get代納人区分();
        source.shimeiText = entity.get氏名1TextField();
        source.shimei1 = entity.get氏名1優先順位1標準();
        source.shimei2 = entity.get氏名1優先順位2標準();
        source.shimeiSmall1 = entity.get氏名1優先順位1小();
        source.shimeiSmall2 = entity.get氏名2優先順位2小();
        source.samabunShimeiText = entity.get氏名2TextField();
        source.samabunShimei1 = entity.get氏名2優先順位1標準();
        source.samabunShimei2 = entity.get氏名2優先順位2標準();
        source.samabunShimeiSmall1 = entity.get氏名2優先順位1小();
        source.samabunShimeiSmall2 = entity.get氏名2優先順位2小();
        source.meishoFuyo1 = entity.get氏名1敬称1();
        source.meishoFuyo2 = entity.get氏名1敬称2();
        source.samaBun1 = entity.get氏名2敬称1();
        source.samaBun2 = entity.get氏名2敬称2();
        source.kakkoLeft1 = entity.get左括弧1();
        source.kakkoLeft2 = entity.get左括弧2();
        source.kakkoRight1 = entity.get右括弧1();
        source.kakkoRight2 = entity.get右括弧2();
        source.customerBarCode = entity.getカスタマバーコード();
    }
}
