/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;

/**
 * 仮算定額変更【A4縦タイプ】ボディEditorです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
class KarisanteiHenkoTsuchishoA4TateEditor implements IKarisanteiHenkoTsuchishoA4TateEditor {

    private final KarisanteiHenkoTsuchishoA4TateItem item;

    public KarisanteiHenkoTsuchishoA4TateEditor(KarisanteiHenkoTsuchishoA4TateItem item) {
        this.item = item;

    }

    @Override
    public KarisanteiHenkoTsuchishoA4TateReportSource edit(KarisanteiHenkoTsuchishoA4TateReportSource source) {
        return editbody(source);
    }

    private KarisanteiHenkoTsuchishoA4TateReportSource editbody(KarisanteiHenkoTsuchishoA4TateReportSource source) {

        source.bunshoNo = item.getBunshoNo();
        source.title1 = item.getTitle1();
        source.title2 = item.getTitle2();
        source.title3 = item.getTitle3();
        source.choteiNendo = item.getChoteiNendo();
        source.hyojicode1 = item.getHyojicode1();
        source.hyojicode2 = item.getHyojicode2();
        source.hyojicode3 = item.getHyojicode3();
        source.hyojicodeName1 = item.getHyojicodeName1();
        source.hyojicodeName2 = item.getHyojicodeName2();
        source.hyojicodeName3 = item.getHyojicodeName3();
        source.setaiCode = item.getSetaiCode();
        source.tsuchishoNo = item.getTsuchishoNo();
        source.zanteiHokenryoGaku = item.getZanteiHokenryoGaku();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.shikibetsuCode = item.getShikibetsuCode();
        source.shutokuYMDMae = item.getShutokuYmdMae();
        source.shutokuYMDAto = item.getShutokuYmdAto();
        source.soshitsuYMDMae = item.getSoshitsuYmdMae();
        source.soshitsuYMDAto = item.getSoshitsuYmdAto();
        source.hokenryoGakuMae = item.getHokenryoGakuMae();
        source.hokenryoGakuAto = item.getHokenryoGakuAto();
        source.zogenGaku = item.getZogenGaku();
        source.koseigoHokenryoGaku = item.getKoseigoHokenryoGaku();
        source.nofuzumiGaku = item.getNofuzumiGaku();
        source.kongoNofusubekiGaku = item.getKongoNofuSubekiGaku();
        source.korekaraChoshuho = item.getKorekaraChoshuho();
        source.listKibetsu_1 = item.getListKibetsu_1();
        source.listKibetsu_2 = item.getListKibetsu_2();
        source.listKibetsu_3 = item.getListKibetsu_3();
        source.listKibetsu_4 = item.getListKibetsu_4();
        source.listKibetsu_5 = item.getListKibetsu_5();
        source.listKibetsu_6 = item.getListKibetsu_6();
        source.listKibetsu_7 = item.getListKibetsu_7();
        source.listKibetsu_8 = item.getListKibetsu_8();
        source.listKibetsu_9 = item.getListKibetsu_9();
        source.bankCode = item.getBankCode();
        source.bankName = item.getBankName();
        source.korekaraTokuchoGimusha = item.getKorekaraTokuchoGimusha();
        source.korekaraTokuchoTaishoNenkin = item.getKorekaraTokuchoTaishoNenkin();
        source.kozaShurui = item.getKozaShurui();
        source.kozaNo = item.getKozaNo();
        source.kozaMeigi = item.getKozaMeigi();
        source.choteiJiyu1 = item.getChoteiJiyu1();
        source.choteiJiyu2 = item.getChoteiJiyu2();
        source.choteiJiyu3 = item.getChoteiJiyu3();
        source.choteiJiyu4 = item.getChoteiJiyu4();

        source.customerBarCode = item.getCustomerBarCode();
        source.dainoKubunMei = item.getDainoKubunMei();
        source.gyoseiku1 = item.getGyoseiku1();
        source.jusho1 = item.getJusho1();
        source.jusho2 = item.getJusho2();
        source.jusho3 = item.getJusho3();
        source.jushoText = item.getJushoText();
        source.kakkoLeft1 = item.getKakkoLeft1();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.kakkoRight1 = item.getKakkoRight1();
        source.kakkoRight2 = item.getKakkoRight2();
        source.katagaki1 = item.getKatagaki1();
        source.katagaki2 = item.getKatagaki2();
        source.katagakiSmall1 = item.getKatagakiSmall1();
        source.katagakiSmall2 = item.getKatagakiSmall2();
        source.katagakiText = item.getKatagakiText();
        source.meishoFuyo1 = item.getMeishoFuyo1();
        source.meishoFuyo2 = item.getMeishoFuyo2();
        source.samaBun1 = item.getSamaBun1();
        source.samaBun2 = item.getSamaBun2();
        source.samabunShimei1 = item.getSamabunShimei1();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.samabunShimeiText = item.getSamabunShimeiText();
        source.shimei1 = item.getShimei1();
        source.shimei2 = item.getShimei2();
        source.shimeiSmall1 = item.getShimeiSmall1();
        source.shimeiSmall2 = item.getShimeiSmall2();
        source.shimeiText = item.getShimeiText();
        source.yubinNo1 = item.getYubinNo1();

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
