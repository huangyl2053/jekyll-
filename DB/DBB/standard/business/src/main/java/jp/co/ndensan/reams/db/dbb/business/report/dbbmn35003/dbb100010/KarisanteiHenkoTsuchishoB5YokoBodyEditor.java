/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;

/**
 * 仮算定額変更【B5横タイプ】ボディEditorです。
 */
class KarisanteiHenkoTsuchishoB5YokoBodyEditor implements IKarisanteiHenkoTsuchishoB5YokoEditor {

    private final KarisanteiHenkoTsuchishoB5YokoItem item;

    public KarisanteiHenkoTsuchishoB5YokoBodyEditor(KarisanteiHenkoTsuchishoB5YokoItem item) {
        this.item = item;
    }

    @Override
    public KarisanteiHenkoTsuchishoB5YokoReportSource edit(KarisanteiHenkoTsuchishoB5YokoReportSource source) {
        return editBody(source);
    }

    private KarisanteiHenkoTsuchishoB5YokoReportSource editBody(KarisanteiHenkoTsuchishoB5YokoReportSource source) {
//        INinshoshaSourceBuilderCreator creater = ReportSourceBuilders.ninshoshaSourceBuilder();
//        NinshoshaSource builderSource1 = creater.create(gyomuCD, RString.EMPTY, RDate.MAX, RString.EMPTY).buildSource();
//        ISofubutsuAtesakiForShisetsuSourceBuilderCreator sourceCreater = ReportSourceBuilders.sofubutsuAtesakiForShisetsuSourceBuilder();
//        SofubutsuAtesakiSource builderSource2 = sourceCreater.create(null).buildSource();

        // CompNinshoshaの設定
//        ReportId reportId = new ReportId(new RString("DBB100010_KarisanteiHenkoTsuchishoB5Yoko"));
//        ReportManager manager = new ReportManager();
//        ReportAssemblerBuilder build = manager.reportAssembler(reportId.value(), SubGyomuCode.DBB介護賦課);
//        ReportAssembler<KarisanteiHenkoTsuchishoB5YokoReportSource> assemble = build.create();
//        RString filePath = assemble.getImageFolderPath();
//        _NinshoshaManager  _n = new _NinshoshaManager();
//        Ninshosha ninshosha = _n.get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
//        Association association = AssociationFinderFactory.createInstance().getAssociation();
//        INinshoshaSourceBuilder iNinshoshaSourceBuilder =
//                _NinshoshaSourceBuilderFactory.createInstance(ninshosha, association, filePath, new RDate(paramter.getTemp_基準日().toString()), 0);
//        NinshoshaSource source_1 = iNinshoshaSourceBuilder.buildSource();
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
        source.mitoraikiNofuzumiGaku = item.getMitoraikiNofuzumiGaku();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.shikibetsuCode = item.getShikibetsuCode();
        source.shutokuYMDMae = item.getShutokuYmdMae();
        source.shutokuYMDAto = item.getShutokuYmdAto();
        source.soshitsuYMDMae = item.getSoshitsuYmdMae();
        source.soshitsuYMDMae = item.getSoshitsuYmdAto();
        source.choteiNendo = item.getChoteiNendo();
        source.bankCode = item.getBankCode();
        source.bankName = item.getBankName();
        source.kozaMeigi = item.getKozaMeigi();
        source.kozaNo = item.getKozaNo();
        source.kozaShurui = item.getKozaShurui();
        source.title1 = item.getTitle1();
        source.title2 = item.getTitle2();
        source.title3 = item.getTitle3();
        source.hokenryoGakuMae = item.getHokenryoGakuMae();
        source.hokenryoGakuAto = item.getHokenryoGakuAto();
        source.zogenGaku = item.getZogenGaku();
        source.nokuzumiGaku = item.getNofuzumiGaku();
        source.koremadeChoshuho = item.getKoremadeChoshuho();
        source.koremadeTokuchoGimusha = item.getKoremadeTokuchoGimusha();
        source.koremadeTokuchoTaishoNenkin = item.getKoremadeTokuchoTaishoNenkin();
        source.korekaraChoshuho = item.getKorekaraChoshuho();
        source.korekaraTokuchoGimusha = item.getKorekaraTokuchoGimusha();
        source.korekaraTokuchoTaishoNenkin = item.getKorekaraTokuchoTaishoNenkin();
        source.zanteiHokenryoGaku = item.getZanteiHokenryoGaku();
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
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
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
//        source.denshiKoin = builderSource1.denshiKoin;
//        source.hakkoYMD = builderSource1.hakkoYMD;
//        source.koinMojiretsu = builderSource1.koinMojiretsu;
//        source.koinShoryaku = builderSource1.koinShoryaku;
//        source.ninshoshaShimeiKakenai = builderSource1.ninshoshaShimeiKakenai;
//        source.ninshoshaShimeiKakeru = builderSource1.ninshoshaShimeiKakeru;
//        source.ninshoshaYakushokuMei = builderSource1.ninshoshaYakushokuMei;
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
