/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550003;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;

/**
 * 要介護度変更通知書ボディEditorです。
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
public class YokaigodoHenkoTshuchishoBodyEditor implements IYokaigodoHenkoTshuchishoEditor {

    private final YokaigodoHenkoTshuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護度変更通知書
     */
    public YokaigodoHenkoTshuchishoBodyEditor(YokaigodoHenkoTshuchishoItem item) {
        this.item = item;
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
        source.kosho1 = item.getKosho1();
        source.kosho2 = item.getKosho2();
        source.beforeYokaigoKubun = item.getBeforeYokaigoKubun();
        source.afterYokaigoKubun = item.getAfterYokaigoKubun();
        source.henkoYMD = item.getHenkoYmd();
        source.yukoKaishiYMD = item.getYukoKaishiYMD();
        source.yukoShuryoYMD = item.getYukoShuryoYMD();
        source.tsuchibun2 = item.getTsuchibun2();
        source.kigenKosho = item.getKigenKosho();
        source.kigenYMD = item.getKigenYMD();
        source.tsuchibun3 = item.getTsuchibun3();
        source.tsuchibun4 = item.getTsuchibun4();
        source.tsuchibun5 = item.getTsuchibun5();
        source.tsuchibun6 = item.getTsuchibun6();
        source.tsuchibun7 = item.getTsuchibun7();
        source.tsuchibun8 = item.getTsuchibun8();
        source.tsuchibun9 = item.getTsuchibun9();
        source.denshiKoin = item.getDenshiKoin();
        source.hakkoYMD1 = item.getHakkoYMD();
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
