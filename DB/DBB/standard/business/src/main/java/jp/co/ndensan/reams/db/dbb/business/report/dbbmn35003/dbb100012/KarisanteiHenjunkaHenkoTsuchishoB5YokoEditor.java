/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100012;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource;

/**
 * 特別徴収平準化【B5横タイプ】ボディEditorです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
class KarisanteiHenjunkaHenkoTsuchishoB5YokoEditor implements IKarisanteiHenjunkaHenkoTsuchishoB5YokoEditor {

    private final KarisanteiHenjunkaHenkoTsuchishoB5YokoItem item;

    public KarisanteiHenjunkaHenkoTsuchishoB5YokoEditor(KarisanteiHenjunkaHenkoTsuchishoB5YokoItem item) {
        this.item = item;

    }

    @Override
    public KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource edit(KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource source) {
        return editBody(source);
    }

    private KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource editBody(KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource source) {

        source.bunshoNo = item.getBunshoNo();
        source.listKibetsu_1 = item.getListKibetsu_1();
        source.listKibetsu_2 = item.getListKibetsu_2();
        source.listKibetsu_3 = item.getListKibetsu_3();
        source.listKibetsu_4 = item.getListKibetsu_4();
        source.listKibetsu_5 = item.getListKibetsu_5();
        source.listKibetsu_6 = item.getListKibetsu_6();
        source.listKibetsu_7 = item.getListKibetsu_7();
        source.listKibetsu_8 = item.getListKibetsu_8();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.hyojicode1 = item.getHyojicode1();
        source.hyojicode2 = item.getHyojicode2();
        source.hyojicode3 = item.getHyojicode3();
        source.hyojicodeName1 = item.getHyojicodeName1();
        source.hyojicodeName2 = item.getHyojicodeName2();
        source.hyojicodeName3 = item.getHyojicodeName3();
        source.tsuchishoNo = item.getTsuchishoNo();
        source.setaiCode = item.getSetaiCode();
        source.kongoNofuSubekiGaku = item.getKongoNofuSubekiGaku();
        source.kongoNofuSubekigakuChotei = item.getKongoNofuSubekigakuChotei();
        source.nofuSubekiGaku = item.getNofuSubekiGaku();
        source.mitoraikiNofuzumiGaku = item.getMitoraikiNofuzumiGaku();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.shikibetsuCode = item.getShikibetsuCode();
        source.shutokuYMDMae = item.getShutokuYmdMae();
        source.shutokuYMDAto = item.getShutokuYmdAto();
        source.soshitsuYMDMae = item.getSoshitsuYmdMae();
        source.soshitsuYMDAto = item.getSoshitsuYmdAto();
        source.choteiNendo = item.getChoteiNendo();
        source.bankCode = item.getBankCode();
        source.bankName = item.getBankName();
        source.kozaMeigi = item.getKozaMeigi();
        source.kozaNo = item.getKozaNo();
        source.kozaShurui = item.getKozaShurui();
        source.title1 = item.getTitle1();
        source.title2 = item.getTitle2();
        source.title3 = item.getTitle3();
        source.zanteiHokenryoGaku = item.getZanteiHokenryoGaku();
        source.hokenryoGakuMae = item.getHokenryoGakuMae();
        source.hokenryoGakuAto = item.getHokenryoGakuAto();
        source.zogenGaku = item.getZogenGaku();
        source.nokuzumiGaku = item.getNofuzumiGaku();
        source.korekaraChoshuho = item.getKorekaraChoshuho();
        source.korekaraTokuchoGimusha = item.getKorekaraTokuchoGimusha();
        source.korekaraTokuchoTaishoNenkin = item.getKorekaraTokuchoTaishoNenkin();
        source.koremadeChoshuho = item.getKoremadeChoshuho();
        source.koremadeTokuchoGimusha = item.getKoremadeTokuchoGimusha();
        source.koremadeTokuchoTaishoNenkin = item.getKoremadeTokuchoTaishoNenkin();
        source.choteiJiyu1 = item.getChoteiJiyu1();
        source.choteiJiyu2 = item.getChoteiJiyu2();
        source.choteiJiyu3 = item.getChoteiJiyu3();
        source.choteiJiyu4 = item.getChoteiJiyu4();

        source.customerBarCode = item.getCustomerBarCode();
        source.yubinNo1 = item.getYubinNo1();
        source.gyoseiku1 = item.getGyoseiku1();
        source.jusho1 = item.getJusho1();
        source.jusho2 = item.getJusho2();
        source.jusho3 = item.getJusho3();
        source.jushoText = item.getJushoText();
        source.katagaki1 = item.getKatagaki1();
        source.katagaki2 = item.getKatagaki2();
        source.katagakiSmall1 = item.getKatagakiSmall1();
        source.katagakiSmall2 = item.getKatagakiSmall2();
        source.katagakiText = item.getKatagakiText();
        source.shimei1 = item.getShimei1();
        source.shimei2 = item.getShimei2();
        source.shimeiSmall1 = item.getShimeiSmall1();
        source.shimeiSmall2 = item.getShimeiSmall2();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo1 = item.getMeishoFuyo1();
        source.meishoFuyo2 = item.getMeishoFuyo2();
        source.dainoKubunMei = item.getDainoKubunMei();
        source.samaBun1 = item.getSamaBun1();
        source.samaBun2 = item.getSamaBun2();
        source.samabunShimei1 = item.getSamabunShimei1();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.samabunShimeiText = item.getSamabunShimeiText();
        source.kakkoLeft1 = item.getKakkoLeft1();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.kakkoRight1 = item.getKakkoRight1();
        source.kakkoRight2 = item.getKakkoRight2();

        source.denshiKoin = item.getDenshiKoin();
        source.hakkoYMD = item.getHakkoYMD();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();

        source.choshaBushoName = item.getChoshaBushoName();
        source.naisenLabel = item.getNaisenLabel();
        source.naisenNo = item.getNaisenNo();
        source.shozaichi = item.getShozaichi();
        source.tantoName = item.getTantoName();
        source.telNo = item.getTelNo();
        source.yubinBango = item.getYubinBango();

        return source;
    }

}
