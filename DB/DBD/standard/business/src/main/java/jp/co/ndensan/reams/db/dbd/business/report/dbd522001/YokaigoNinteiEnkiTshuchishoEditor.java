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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定延期通知書タイトルEditorです。
 *
 * @reamsid_L DBD-1410-030 chenxin
 */
class YokaigoNinteiEnkiTshuchishoEditor implements IYokaigoNinteiEnkiTshuchishoEditor {

    private final YokaigoNinteiEnkiTshuchishoEntity entity;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;

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
        source.tsuchibun2 = entity.get通知文2();
        DbT4101NinteiShinseiJohoEntity dbT4101entity = entity.getEntity();
        if (dbT4101entity != null) {
            if (dbT4101entity.getHihokenshaName() != null) {
                source.hihokenshaNo1 = dbT4101entity.getHihokenshaNo().substring(0, INT_1);
                source.hihokenshaNo2 = dbT4101entity.getHihokenshaNo().substring(INT_1, INT_2);
                source.hihokenshaNo3 = dbT4101entity.getHihokenshaNo().substring(INT_2, INT_3);
                source.hihokenshaNo4 = dbT4101entity.getHihokenshaNo().substring(INT_3, INT_4);
                source.hihokenshaNo5 = dbT4101entity.getHihokenshaNo().substring(INT_4, INT_5);
                source.hihokenshaNo6 = dbT4101entity.getHihokenshaNo().substring(INT_5, INT_6);
                source.hihokenshaNo7 = dbT4101entity.getHihokenshaNo().substring(INT_6, INT_7);
                source.hihokenshaNo8 = dbT4101entity.getHihokenshaNo().substring(INT_7, INT_8);
                source.hihokenshaNo9 = dbT4101entity.getHihokenshaNo().substring(INT_8, INT_9);
                source.hihokenshaNo10 = dbT4101entity.getHihokenshaNo().substring(INT_9, INT_10);
            }
            if (dbT4101entity.getHihokenshaName() != null) {
                source.hihokenshaName = dbT4101entity.getHihokenshaName().getColumnValue();
            }
            source.riyu1 = dbT4101entity.getEnkiRiyu();
            if (dbT4101entity.getEnkiMikomiKaishiYMD() != null && dbT4101entity.getEnkiMikomiKaishiYMD().isWareki()) {
                source.shoriMikomiKaishiYMD = dbT4101entity.getEnkiMikomiKaishiYMD()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            }
            if (dbT4101entity.getEnkiMikomiShuryoYMD() != null && dbT4101entity.getEnkiMikomiShuryoYMD().isWareki()) {
                source.shoriMikomiShuryoYMD = dbT4101entity.getEnkiMikomiShuryoYMD()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            }
        }

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
