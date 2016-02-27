/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;

/**
 * 仮算定額変更【A4縦タイプ】ボディEditorです。
 */
class KarisanteiHenkoTsuchishoA4TateBodyEditor implements IKarisanteiHenkoTsuchishoA4TateEditor {

    private final KarisanteiHenkoTsuchishoA4TateItem item;

    public KarisanteiHenkoTsuchishoA4TateBodyEditor(KarisanteiHenkoTsuchishoA4TateItem item) {
        this.item = item;

    }

    @Override
    public KarisanteiHenkoTsuchishoA4TateReportSource edit(KarisanteiHenkoTsuchishoA4TateReportSource source) {
        return editbody(source);
    }

    private KarisanteiHenkoTsuchishoA4TateReportSource editbody(KarisanteiHenkoTsuchishoA4TateReportSource source) {
        // xy commentout
//        INinshoshaSourceBuilderCreator creater = ReportSourceBuilders.ninshoshaSourceBuilder();
//        NinshoshaSource builderSource1=creater.create(gyomuCD, RString.EMPTY, RDate.MAX, RString.EMPTY).buildSource();
//        ISofubutsuAtesakiForShisetsuSourceBuilderCreator  sourceCreater = ReportSourceBuilders.sofubutsuAtesakiForShisetsuSourceBuilder();
//        SofubutsuAtesakiSource builderSource2 = sourceCreater.create(null).buildSource();
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
//        source.customerBarCode = builderSource2.customerBarCode;
//        source.dainoKubunMei = builderSource2.dainoKubunMei;
//        source.gyoseiku1 = builderSource2.gyoseiku;
//        source.jusho1 = builderSource2.jusho1;
//        source.jusho2 = builderSource2.jusho2;
//        source.jusho3 = builderSource2.jusho3;
//        source.jushoText = builderSource2.jushoText;
//        source.kakkoLeft1 = builderSource2.kakkoLeft1;
//        source.kakkoLeft2 = builderSource2.kakkoLeft2;
//        source.kakkoRight1 = builderSource2.kakkoRight1;
//        source.kakkoRight2 = builderSource2.kakkoRight2;
//        source.katagaki1 = builderSource2.katagaki1;
//        source.katagaki2 = builderSource2.katagaki2;
//        source.katagakiSmall1 = builderSource2.katagakiSmall1;
//        source.katagakiSmall2 = builderSource2.katagakiSmall2;
//        source.katagakiText = builderSource2.katagakiText;
//        source.meishoFuyo1 = builderSource2.meishoFuyo1;
//        source.meishoFuyo2 = builderSource2.meishoFuyo2;
//        source.samaBun1 = builderSource2.samaBun1;
//        source.samaBun2 = builderSource2.samaBun2;
//        source.samabunShimei1 = builderSource2.samabunShimei1;
//        source.samabunShimei2 = builderSource2.samabunShimei2;
//        source.samabunShimeiSmall1 = builderSource2.samabunShimeiSmall1;
//        source.samabunShimeiSmall2 = builderSource2.samabunShimeiSmall2;
//        source.samabunShimeiText = builderSource2.samabunShimeiText;
//        source.shimei1 = builderSource2.shimei1;
//        source.shimei2 = builderSource2.shimei2;
//        source.shimeiSmall1 = builderSource2.shimeiSmall1;
//        source.shimeiSmall2 = builderSource2.shimeiSmall2;
//        source.shimeiText = builderSource2.shimeiText;
//        source.yubinNo1 = builderSource2.yubinNo;
//       source.denshiKoin =builderSource1.denshiKoin;
//        source.hakkoYMD = builderSource1.hakkoYMD;
//        source.koinMojiretsu = builderSource1.koinMojiretsu;
//        source.koinShoryaku = builderSource1.koinShoryaku;
//        source.ninshoshaShimeiKakenai = builderSource1.ninshoshaShimeiKakenai;
//        source.ninshoshaShimeiKakeru = builderSource1.ninshoshaShimeiKakeru;
//        source.ninshoshaYakushokuMei = builderSource1.ninshoshaYakushokuMei;

        //to  do 「ビジネス設計_CompKaigoToiawasesaki_問合せ先」を利用する。
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
