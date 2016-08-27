/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550003;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護度変更通知書ボディEditorです。
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
public class YokaigodoHenkoTshuchishoBodyEditor implements IYokaigodoHenkoTshuchishoEditor {

    private final YokaigodoHenkoTsuchishoJoho entity;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護度変更通知書
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param ninshoshaSource NinshoshaSource
     */
    public YokaigodoHenkoTshuchishoBodyEditor(YokaigodoHenkoTsuchishoJoho entity,
            ChohyoSeigyoKyotsu 帳票制御共通,
            NinshoshaSource ninshoshaSource) {
        this.entity = entity;
        this.帳票制御共通 = 帳票制御共通;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     * 要介護度変更通知書ボディEditorです。
     *
     * @param source 要介護度変更通知書Source
     * @return 要介護度変更通知書Source
     */
    @Override
    public YokaigodoHenkoTshuchishoReportSource edit(YokaigodoHenkoTshuchishoReportSource source) {
        return bodyEdit(source);
    }

    private YokaigodoHenkoTshuchishoReportSource bodyEdit(YokaigodoHenkoTshuchishoReportSource source) {
        source.bunshoNo = entity.getBunshoNo();
        source.title = entity.getTitle();
        source.tsuchibun1 = entity.getTsuchibun1();
        source.hihokenshaName = entity.getHihokenshaName();
        source.hihokenshaNo1 = entity.getHihokenshaNo1();
        source.hihokenshaNo2 = entity.getHihokenshaNo2();
        source.hihokenshaNo3 = entity.getHihokenshaNo3();
        source.hihokenshaNo4 = entity.getHihokenshaNo4();
        source.hihokenshaNo5 = entity.getHihokenshaNo5();
        source.hihokenshaNo6 = entity.getHihokenshaNo6();
        source.hihokenshaNo7 = entity.getHihokenshaNo7();
        source.hihokenshaNo8 = entity.getHihokenshaNo8();
        source.hihokenshaNo9 = entity.getHihokenshaNo9();
        source.hihokenshaNo10 = entity.getHihokenshaNo10();
        source.kosho1 = entity.getKosho1();
        source.kosho2 = entity.getKosho2();
        source.beforeYokaigoKubun = entity.getBeforeYokaigoKubun();
        source.afterYokaigoKubun = entity.getAfterYokaigoKubun();
        source.henkoYMD = entity.getHenkoYmd().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.yukoKaishiYMD = entity.getYukoKaishiYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.yukoShuryoYMD = entity.getYukoShuryoYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.tsuchibun2 = entity.getTsuchibun2();
        source.kigenKosho = entity.getKigenKosho();
        source.kigenYMD = entity.getKigenYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.tsuchibun3 = entity.getTsuchibun3();

        RString 定型文文字サイズ = this.帳票制御共通.get定型文文字サイズ();

        if (new RString("1").equals(定型文文字サイズ)) {
            source.tsuchibun4 = entity.getTsuchibun4();
        } else {
            source.tsuchibun4 = RString.EMPTY;
        }

        if (new RString("2").equals(定型文文字サイズ)) {
            source.tsuchibun5 = entity.getTsuchibun5();
        } else {
            source.tsuchibun5 = RString.EMPTY;
        }

        if (new RString("3").equals(定型文文字サイズ)) {
            source.tsuchibun6 = entity.getTsuchibun6();
            source.tsuchibun7 = entity.getTsuchibun7();
        } else {
            source.tsuchibun6 = RString.EMPTY;
            source.tsuchibun7 = RString.EMPTY;
        }

        if (new RString("4").equals(定型文文字サイズ)) {
            source.tsuchibun8 = entity.getTsuchibun8();
            source.tsuchibun9 = entity.getTsuchibun9();
        } else {
            source.tsuchibun8 = RString.EMPTY;
            source.tsuchibun9 = RString.EMPTY;
        }

        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD1 = ninshoshaSource.hakkoYMD;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.yubinNo = entity.getYubinNo();
        source.gyoseiku = entity.getGyoseiku();
        source.jushoText = entity.getJushoText();
        source.jusho1 = entity.getJusho1();
        source.jusho2 = entity.getJusho2();
        source.jusho3 = entity.getJusho3();
        source.katagakiText = entity.getKatagakiText();
        source.katagaki1 = entity.getKatagaki1();
        source.katagaki2 = entity.getKatagaki2();
        source.katagakiSmall1 = entity.getKatagakiSmall1();
        source.katagakiSmall2 = entity.getKatagakiSmall2();
        source.dainoKubunMei = entity.getDainoKubunMei();
        source.shimeiText = entity.getShimeiText();
        source.shimei1 = entity.getShimei1();
        source.shimei2 = entity.getShimei2();
        source.shimeiSmall1 = entity.getShimeiSmall1();
        source.shimeiSmall2 = entity.getShimeiSmall2();
        source.samabunShimeiText = entity.getSamabunShimeiText();
        source.samabunShimei1 = entity.getSamabunShimei1();
        source.samabunShimei2 = entity.getSamabunShimei2();
        source.samabunShimeiSmall1 = entity.getSamabunShimeiSmall1();
        source.samabunShimeiSmall2 = entity.getSamabunShimeiSmall2();
        source.meishoFuyo1 = entity.getMeishoFuyo1();
        source.meishoFuyo2 = entity.getMeishoFuyo2();
        source.samaBun1 = entity.getSamaBun1();
        source.samaBun2 = entity.getSamaBun2();
        source.kakkoLeft1 = entity.getKakkoLeft1();
        source.kakkoLeft2 = entity.getKakkoLeft2();
        source.kakkoRight1 = entity.getKakkoRight1();
        source.kakkoRight2 = entity.getKakkoRight2();
        source.customerBarCode = entity.getCustomerBarCode();

        return source;
    }

}
