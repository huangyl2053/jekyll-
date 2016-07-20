/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd532001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd532001.YokaigoNinteiKekkaTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定結果通知書ボディEditorです。
 *
 * @reamsid_L DBD-1430-030 b_zhengs
 */
public class YokaigoNinteiKekkaTshuchishoBodyEditor implements IYokaigoNinteiKekkaTshuchishoEditor {

    private final YokaigoNinteiKekkaTshuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定結果通知書
     */
    public YokaigoNinteiKekkaTshuchishoBodyEditor(YokaigoNinteiKekkaTshuchishoItem item) {
        this.item = item;
    }

    /**
     * 要介護認定結果通知書ボディEditorです。
     *
     * @param source 要介護認定結果通知書Source
     * @return 要介護認定結果通知書Source
     */
    @Override
    public YokaigoNinteiKekkaTshuchishoReportSource edit(YokaigoNinteiKekkaTshuchishoReportSource source) {
        return bodyEdit(source);
    }

    private YokaigoNinteiKekkaTshuchishoReportSource bodyEdit(YokaigoNinteiKekkaTshuchishoReportSource source) {
        source.bunshoNo = item.getBunshoNo();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNo1 = item.getHihokenshaNo1();
        source.hihokenshaNo2 = item.getHihokenshaNo2();
        source.hihokenshaNo3 = item.getHihokenshaNo3();
        source.hihokenshaNo4 = item.getHihokenshaNo4();
        source.hihokenshaNo5 = item.getHihokenshaNo5();
        source.hihokenshaNo6 = item.getHihokenshaNo6();
        source.hihokenshaNo7 = item.getHihokenshaNo7();
        source.hihokenshaNo8 = item.getHihokenshaNo8();
        source.hihokenshaNo9 = item.getHihokenshaNo9();
        source.hihokenshaNo10 = item.getHihokenshaNo10();
        source.kekkaKosho = item.getKekkaKosho();
        source.kekkaName = item.getKekkaName();
        source.kekkaYMDKosho = item.getKekkaYMDKosho();
        source.kekkaYMD = item.getKekkaYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.riyu = item.getRiyu();
        source.serviceShurui1 = item.getServiceShurui1();
        source.yukoKaishiYMD = item.getYukoKaishiYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.yukoShuryoYMD = item.getYukoShuryoYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.tsuchibun2 = item.getTsuchibun2();
        source.tsuchibun3 = item.getTsuchibun3();
        source.tsuchibun4 = item.getTsuchibun4();
        source.tsuchibun5 = item.getTsuchibun5();
        source.tsuchibun6 = item.getTsuchibun6();
        source.tsuchibun7 = item.getTsuchibun7();
        source.denshiKoin = item.getDenshiKoin();
        source.hakkoYMD = item.getHakkoYMD();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinShoryaku = item.getKoinShoryaku();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.yubinNo = item.getYubinNo();
        source.gyoseiku = item.getGyoseiku();
        source.jushoText = item.getJushoText();
        source.jusho1 = item.getJusho1();
        source.jusho2 = item.getJusho2();
        source.jusho3 = item.getJusho3();
        source.katagakiText = item.getKatagakiText();
        source.katagaki1 = item.getKatagaki1();
        source.katagaki2 = item.getKatagaki2();
        source.katagakiSmall1 = item.getKatagakiSmall1();
        source.katagakiSmall2 = item.getKatagakiSmall2();
        source.dainoKubunMei = item.getDainoKubunMei();
        source.shimeiText = item.getShimeiText();
        source.shimei1 = item.getShimei1();
        source.shimei2 = item.getShimei2();
        source.shimeiSmall1 = item.getShimeiSmall1();
        source.shimeiSmall2 = item.getShimeiSmall2();
        source.samabunShimeiText = item.getSamabunShimeiText();
        source.samabunShimei1 = item.getSamabunShimei1();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.meishoFuyo1 = item.getMeishoFuyo1();
        source.meishoFuyo2 = item.getMeishoFuyo2();
        source.samaBun1 = item.getSamaBun1();
        source.samaBun2 = item.getSamaBun2();
        source.kakkoLeft1 = item.getKakkoLeft1();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.kakkoRight1 = item.getKakkoRight1();
        source.kakkoRight2 = item.getKakkoRight2();
        source.customerBarCode = item.getCustomerBarCode();

        return source;
    }

}
