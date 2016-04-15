/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプCompSofubutsuAtesakiEditor
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class CompSofubutsuAtesakiA4Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor {

    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item;

    /**
     * コンストラクタです
     *
     * @param item KaigoHokenryoChoshuyuyoKetteiTsuchishoItem
     */
    public CompSofubutsuAtesakiA4Editor(KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource edit(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource source) {

        source.yubinNo = item.getYubinNo();
        source.gyoseiku = item.getGyoseiku();
        source.jusho3 = item.getJusho3();
        source.jushoText = item.getJushoText();
        source.jusho1 = item.getJusho1();
        source.jusho2 = item.getJusho2();
        source.katagakiText = item.getKatagakiText();
        source.katagaki2 = item.getKatagaki2();
        source.katagakiSmall2 = item.getKatagakiSmall2();
        source.katagaki1 = item.getKatagaki1();
        source.katagakiSmall1 = item.getKatagakiSmall1();
        source.kakkoRight2 = item.getKakkoRight2();
        source.kakkoRight1 = item.getKakkoRight1();
        source.shimei2 = item.getShimei2();
        source.shimeiSmall2 = item.getShimei2();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo2 = item.getMeishoFuyo2();
        source.shimeiSmall1 = item.getShimeiSmall1();
        source.dainoKubunMei = item.getDainoKubunMei();
        source.shimei1 = item.getShimei1();
        source.meishoFuyo1 = item.getMeishoFuyo1();
        source.samabunShimeiText = item.getSamabunShimeiText();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.samaBun2 = item.getSamaBun2();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.kakkoLeft1 = item.getKakkoLeft1();
        source.samabunShimei1 = item.getSamabunShimei1();
        source.samaBun1 = item.getSamaBun1();
        source.samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.customerBarCode = item.getCustomerBarCode();
        // TODO QA:581
//        source.setainusimei = item.getSetainusimei();
//        source.samaKata = item.getSamaKata();
        return source;
    }

}
