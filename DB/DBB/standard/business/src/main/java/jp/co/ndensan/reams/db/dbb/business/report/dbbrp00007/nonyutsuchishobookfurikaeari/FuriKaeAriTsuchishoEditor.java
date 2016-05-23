/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishobookfurikaeari;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;

/**
 * 保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ】の通知書のボディEditorです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class FuriKaeAriTsuchishoEditor implements INonyuTsuchishoBookFuriKaeAriEditor {

    private final NonyuTsuchishoBookFuriKaeAriItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokusokujoBodyEditor}
     */
    protected FuriKaeAriTsuchishoEditor(NonyuTsuchishoBookFuriKaeAriItem item) {
        this.item = item;
    }

    @Override
    public FuriKaeAriCoverToNofushoReportSource edit(FuriKaeAriCoverToNofushoReportSource source) {
        return editBody(source);
    }

    private FuriKaeAriCoverToNofushoReportSource editBody(FuriKaeAriCoverToNofushoReportSource source) {
        edit計算明細書期１To１０(source);
        source.layoutBreakItem = item.getLayoutBreakItem();
        source.ari_keisanMeisaishoNendo = item.getKmsNendo();
        source.ari_keisanMeisaishoNendoBun = item.getKmsNendoBun();
        source.ari_titleNendo = item.getTitleNendo();
        source.ari_titleNendoBun = item.getTitleNendoBun();
        source.ari_HyojicodeName1 = item.getHyojicodeName1();
        source.ari_HyojicodeName2 = item.getHyojicodeName2();
        source.ari_HyojicodeName3 = item.getHyojicodeName3();
        source.ari_Hyojicode1 = item.getHyojicode1();
        source.ari_Hyojicode2 = item.getHyojicode2();
        source.ari_Hyojicode3 = item.getHyojicode3();
        source.ari_kaisanMeisaishoHihokenshaName = item.getKaisanMeisaishoHihokenshaName();
        source.ari_kaisanMeisaishoSetaiNushiName = item.getKaisanMeisaishoSetaiNushiName();
        source.ari_keisanMeisaishoTsuchishoNo = item.getKmsTsuchishoNo();
        source.ari_keisanMeisaishoSetaiCode = item.getKmsSetaiCode();
        source.ari_tsuchishoNo = item.getTsuchishoNo();
        source.ari_setaiCode = item.getSetaiCode();
        source.ari_keisanMeisaishoKaishiKi = item.getKmsKaishiKi();
        source.ari_keisanMeisaishoTsukiSu = item.getKmsTsukiSu();
        source.ari_kaisanMeisaishoShuryoKi = item.getKaisanMeisaishoShuryoKi();
        source.ari_bankCode = item.getBankCode();
        source.ari_kozaShurui = item.getKozaShurui();
        source.ari_kozaNo = item.getKozaNo();
        source.ari_keisanMeisaishoShotokuDankai = item.getKmsShotokuDankai();
        source.ari_kaisanHokenryoRitsu = item.getKaisanHokenryoRitsu();
        source.ari_keisanMeisaishoCalHokenryoGaku = item.getKmsCalHokenryoGaku();
        source.ari_keisanMeisaishoGenmenGaku = item.getKmsGenmenGaku();
        source.ari_bankName = item.getBankName();
        source.ari_keisanMeisaishoTokuchoGokeiGaku = item.getKmsTokuchoGokeiGaku();
        source.ari_kaisanMeisaishoFuchoGokeiGaku = item.getKaisanMeisaishoFuchoGokeiGaku();
        source.ari_kozaMeiginin = item.getKozaMeiginin();
        source.ari_kaisanMeisaishoNofuZumiGaku = item.getKaisanMeisaishoNofuZumiGaku();
        source.ari_keisanMeisaishoKongoNofuGaku = item.getKmsKongoNofuGaku();
        source.ari_yen1 = item.getYen1();
        source.ari_yen2 = item.getYen2();
        source.ari_keisanMeisaishoKiTitle1 = item.getKmsKiTitle1();
        source.ari_keisanMeisaishoKibetsuNofuGaku1 = item.getKmsKibetsuNofuGaku1();
        source.ari_keisanMeisaishoKiTitle3 = item.getKmsKiTitle3();
        source.ari_keisanMeisaishoKibetsuNofuGaku3 = item.getKmsKibetsuNofuGaku3();
        source.ari_yen3 = item.getYen3();
        source.ari_yen4 = item.getYen4();
        source.ari_keisanMeisaishoKiTitle2 = item.getKmsKiTitle2();
        source.ari_gekihenTitle = item.getGekihenTitle();
        source.ari_keisanMeisaishoKibetsuNofuGaku2 = item.getKmsKibetsuNofuGaku2();
        source.ari_keisanMeisaishoKiTitle4 = item.getKmsKiTitle4();
        source.ari_gekihenMongon = item.getGekihenMongon();
        source.ari_keisanMeisaishoKibetsuNofuGaku4 = item.getKmsKibetsuNofuGaku4();
        source.ari_keisanmeisaishoNendo2 = item.getKeisanmeisaishoNendo2();
        source.ari_keisanMeisaishoHokenryoGokeiGaku = item.getKmsHokenryoGokeiGaku();
        source.ari_pagerenban1 = item.getTsuchisho_pagerenban1();
        source.ari_pagerenban2 = item.getTsuchisho_pagerenban2();
        source.ari_nokibetsuMeisaishoNendo = item.getNbmsNendo();
        source.ari_nokibetsuMeisaishoNendoBun = item.getNbmsNendoBun();
        source.ari_kozaIraishoLeftJusho = item.getKozaIraishoLeftJusho();
        source.ari_kozaIraishoRightJusho = item.getKozaIraishoRightJusho();
        source.ari_nokibetsuMeisaishoTokuchoNofuGaku1 = item.getNbmsTokuchoNofuGaku1();
        source.ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1 = item.getNbmsTokuchoNofuZumiGaku1();
        source.ari_nokibetsuMeisaishoTsuchishoNo = item.getNbmsTsuchishoNo();
        source.ari_nokibetsuMeisaishoSetaiCode = item.getNbmsSetaiCode();
        source.ari_nokibetsuMeisaishoTokuchoSaGaku1 = item.getNbmsTokuchoSaGaku1();
        source.ari_nokibetsuMeisaishoTokuchoNofuGaku2 = item.getNbmsTokuchoNofuGaku2();
        source.ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2 = item.getNbmsTokuchoNofuZumiGaku2();
        source.ari_nokibetsuMeisaishoTokuchoSaGaku2 = item.getNbmsTokuchoSaGaku2();
        source.ari_kozaIraishoLeftHihokenshaName = item.getKozaIraishoLeftHihokenshaName();
        source.ari_kozaIraishoRightHihokenshaName = item.getKozaIraishoRightHihokenshaName();
        source.ari_nokibetsuMeisaishoHohokenshaName = item.getNbmsHohokenshaName();
        source.ari_nokibetsuMeisaishoTokuchoNofuGaku3 = item.getNbmsTokuchoNofuGaku3();
        source.ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3 = item.getNbmsTokuchoNofuZumiGaku3();
        source.ari_nokibetsuMeisaishoTokuchoSaGaku3 = item.getNbmsTokuchoSaGaku3();
        source.ari_nokibetsuMeisaishoTokuchoNofuGaku4 = item.getNbmsTokuchoNofuGaku4();
        source.ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4 = item.getNbmsTokuchoNofuZumiGaku4();
        source.ari_nokibetsuMeisaishoTokuchoSaGaku4 = item.getNbmsTokuchoSaGaku4();
        source.ari_kozaIraishoLeftShikibetsuCode = item.getKozaIraishoLeftShikibetsuCode();
        source.ari_kozaIraishoRightShikibetsuCode = item.getKozaIraishoRightShikibetsuCode();
        source.ari_nokibetsuMeisaishoKi1 = item.getNbmsKi1();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku1 = item.getNbmsFuchoNofuGaku1();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku1 = item.getNbmsFuchoNofuZumiGaku1();
        source.ari_nokibetsuMeisaishoFuchoSaGaku1 = item.getNbmsFuchoSaGaku1();
        source.ari_nokibetsuMeisaishoNokigen1 = item.getNbmsNokigen1();
        source.ari_nokibetsuMeisaishoKi2 = item.getNbmsKi2();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku2 = item.getNbmsFuchoNofuGaku2();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku2 = item.getNbmsFuchoNofuZumiGaku2();
        source.ari_nokibetsuMeisaishoFuchoSaGaku2 = item.getNbmsFuchoSaGaku2();
        source.ari_nokibetsuMeisaishoNokigen2 = item.getNbmsNokigen2();
        source.ari_nokibetsuMeisaishoKi3 = item.getNbmsKi3();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku3 = item.getNbmsFuchoNofuGaku3();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku3 = item.getNbmsFuchoNofuZumiGaku3();
        source.ari_nokibetsuMeisaishoFuchoSaGaku3 = item.getNbmsFuchoSaGaku3();
        source.ari_nokibetsuMeisaishoNokigen3 = item.getNbmsNokigen3();
        source.ari_nokibetsuMeisaishoKi4 = item.getNbmsKi4();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku4 = item.getNbmsFuchoNofuGaku4();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku4 = item.getNbmsFuchoNofuZumiGaku4();
        source.ari_nokibetsuMeisaishoFuchoSaGaku4 = item.getNbmsFuchoSaGaku4();
        source.ari_nokibetsuMeisaishoNokigen4 = item.getNbmsNokigen4();
        source.ari_nokibetsuMeisaishoKi5 = item.getNbmsKi5();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku5 = item.getNbmsFuchoNofuGaku5();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku5 = item.getNbmsFuchoNofuZumiGaku5();
        source.ari_nokibetsuMeisaishoFuchoSaGaku5 = item.getNbmsFuchoSaGaku5();
        source.ari_nokibetsuMeisaishoNokigen5 = item.getNbmsNokigen5();
        source.ari_nokibetsuMeisaishoKi6 = item.getNbmsKi6();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku6 = item.getNbmsFuchoNofuGaku6();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku6 = item.getNbmsFuchoNofuZumiGaku6();
        source.ari_nokibetsuMeisaishoFuchoSaGaku6 = item.getNbmsFuchoSaGaku6();
        source.ari_nokibetsuMeisaishoNokigen6 = item.getNbmsNokigen6();
        source.ari_nokibetsuMeisaishoKi7 = item.getNbmsKi7();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku7 = item.getNbmsFuchoNofuGaku7();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku7 = item.getNbmsFuchoNofuZumiGaku7();
        source.ari_nokibetsuMeisaishoFuchoSaGaku7 = item.getNbmsFuchoSaGaku7();
        source.ari_nokibetsuMeisaishoNokigen7 = item.getNbmsNokigen7();
        source.ari_nokibetsuMeisaishoKi8 = item.getNbmsKi8();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku8 = item.getNbmsFuchoNofuGaku8();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku8 = item.getNbmsFuchoNofuZumiGaku8();
        source.ari_nokibetsuMeisaishoFuchoSaGaku8 = item.getNbmsFuchoSaGaku8();
        source.ari_nokibetsuMeisaishoNokigen8 = item.getNbmsNokigen8();
        source.ari_nokibetsuMeisaishoKi9 = item.getNbmsKi9();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku9 = item.getNbmsFuchoNofuGaku9();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku9 = item.getNbmsFuchoNofuZumiGaku9();
        source.ari_nokibetsuMeisaishoFuchoSaGaku9 = item.getNbmsFuchoSaGaku9();
        source.ari_nokibetsuMeisaishoNokigen9 = item.getNbmsNokigen9();
        source.ari_nokibetsuMeisaishoKi10 = item.getNbmsKi10();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku10 = item.getNbmsFuchoNofuGaku10();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku10 = item.getNbmsFuchoNofuZumiGaku10();
        source.ari_nokibetsuMeisaishoFuchoSaGaku10 = item.getNbmsFuchoSaGaku10();
        source.ari_nokibetsuMeisaishoNokigen10 = item.getNbmsNokigen10();
        source.ari_nokibetsuMeisaishoFuchoNofuGaku11 = item.getNbmsFuchoNofuGaku11();
        source.ari_nokibetsuMeisaishoFuchoNofuZumiGaku11 = item.getNbmsFuchoNofuZumiGaku11();
        source.ari_nokibetsuMeisaishoFuchoSaGaku11 = item.getNbmsFuchoSaGaku11();
        source.ari_renban = item.getRenban();
        source.ari_hokenshaName = item.getHokenshaName();
        source.ari_pagerenban3 = item.getTsuchisho_pagerenban3();
        source.ari_pagerenban4 = item.getTsuchisho_pagerenban4();

        editCompNinshoshaLayer(source);
        editCompSofubutsuAtesakiLayer(source);
        return source;
    }

    private void edit計算明細書期１To１０(FuriKaeAriCoverToNofushoReportSource source) {
        source.ari_keisanMeisaishoKi1 = item.getKmsKi1();
        source.ari_keisanMeisaishoTsuki1 = item.getKmsTsuki1();
        source.ari_keisanMeisaishoNokigenKaishi1 = item.getKmsNokigenKaishi1();
        source.ari_keisanMeisaishoNokigenShuryo1 = item.getKmsNokigenShuryo1();
        source.ari_keisanMeisaishoKi2 = item.getKmsKi2();
        source.ari_keisanMeisaishoTsuki2 = item.getKmsTsuki2();
        source.ari_keisanMeisaishoNokigenKaishi2 = item.getKmsNokigenKaishi2();
        source.ari_keisanMeisaishoNokigenShuryo2 = item.getKmsNokigenShuryo2();
        source.ari_keisanMeisaishoKi3 = item.getKmsKi3();
        source.ari_keisanMeisaishoNokigenKaishi3 = item.getKmsNokigenKaishi3();
        source.ari_keisanMeisaishoTsuki3 = item.getKmsTsuki3();
        source.ari_keisanMeisaishoNokigenShuryo3 = item.getKmsNokigenShuryo3();
        source.ari_keisanMeisaishoKi4 = item.getKmsKi4();
        source.ari_keisanMeisaishoNokigenKaishi4 = item.getKmsNokigenKaishi4();
        source.ari_keisanMeisaishoTsuki4 = item.getKmsTsuki4();
        source.ari_keisanMeisaishoNokigenShuryo4 = item.getKmsNokigenShuryo4();
        source.ari_keisanMeisaishoKi5 = item.getKmsKi5();
        source.ari_keisanMeisaishoNokigenKaishi5 = item.getKmsNokigenKaishi5();
        source.ari_keisanMeisaishoTsuki5 = item.getKmsTsuki5();
        source.ari_keisanMeisaishoNokigenShuryo5 = item.getKmsNokigenShuryo5();
        source.ari_keisanMeisaishoKi6 = item.getKmsKi6();
        source.ari_keisanMeisaishoNokigenKaishi6 = item.getKmsNokigenKaishi6();
        source.ari_keisanMeisaishoTsuki6 = item.getKmsTsuki6();
        source.ari_keisanMeisaishoNokigenShuryo6 = item.getKmsNokigenShuryo6();
        source.ari_keisanMeisaishoKi7 = item.getKmsKi7();
        source.ari_keisanMeisaishoNokigenKaishi7 = item.getKmsNokigenKaishi7();
        source.ari_keisanMeisaishoTsuki7 = item.getKmsTsuki7();
        source.ari_keisanMeisaishoNokigenShuryo7 = item.getKmsNokigenShuryo7();
        source.ari_keisanMeisaishoKi8 = item.getKmsKi8();
        source.ari_keisanMeisaishoNokigenKaishi8 = item.getKmsNokigenKaishi8();
        source.ari_keisanMeisaishoTsuki8 = item.getKmsTsuki8();
        source.ari_keisanMeisaishoNokigenShuryo8 = item.getKmsNokigenShuryo8();
        source.ari_keisanMeisaishoKi9 = item.getKmsKi9();
        source.ari_keisanMeisaishoNokigenKaishi9 = item.getKmsNokigenKaishi9();
        source.ari_keisanMeisaishoTsuki9 = item.getKmsTsuki9();
        source.ari_keisanMeisaishoNokigenShuryo9 = item.getKmsNokigenShuryo9();
        source.ari_keisanMeisaishoKi10 = item.getKmsKi10();
        source.ari_keisanMeisaishoNokigenKaishi10 = item.getKmsNokigenKaishi10();
        source.ari_keisanMeisaishoTsuki10 = item.getKmsTsuki10();
        source.ari_keisanMeisaishoNokigenShuryo10 = item.getKmsNokigenShuryo10();
    }

    private void editCompNinshoshaLayer(FuriKaeAriCoverToNofushoReportSource source) {
        source.ari_denshiKoin = item.getDenshiKoin();
        source.ari_hakkoYMD = item.getHakkoYMD();
        source.ari_ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ari_ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ari_koinMojiretsu = item.getKoinMojiretsu();
        source.ari_ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ari_ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ari_ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ari_koinShoryaku = item.getKoinShoryaku();
    }

    private void editCompSofubutsuAtesakiLayer(FuriKaeAriCoverToNofushoReportSource source) {
        source.ari_customerBarCode = item.getCustomerBarCode();
        source.ari_dainoKubunMei = item.getDainoKubunMei();
        source.ari_gyoseiku = item.getGyoseiku();
        source.ari_jusho1 = item.getJusho1();
        source.ari_jusho2 = item.getJusho2();
        source.ari_jusho3 = item.getJusho3();
        source.ari_jushoText = item.getJushoText();
        source.ari_kakkoLeft1 = item.getKakkoLeft1();
        source.ari_kakkoLeft2 = item.getKakkoLeft2();
        source.ari_kakkoRight1 = item.getKakkoRight1();
        source.ari_kakkoRight2 = item.getKakkoRight2();
        source.ari_katagaki1 = item.getKatagaki1();
        source.ari_katagaki2 = item.getKatagaki2();
        source.ari_katagakiSmall1 = item.getKatagakiSmall1();
        source.ari_katagakiSmall2 = item.getKatagakiSmall2();
        source.ari_katagakiText = item.getKatagakiText();
        source.ari_meishoFuyo1 = item.getMeishoFuyo1();
        source.ari_meishoFuyo2 = item.getMeishoFuyo2();
        source.ari_samaBun1 = item.getSamaBun1();
        source.ari_samaBun2 = item.getSamaBun2();
        source.ari_samabunShimei1 = item.getSamabunShimei1();
        source.ari_samabunShimei2 = item.getSamabunShimei2();
        source.ari_samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.ari_samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.ari_samabunShimeiText = item.getSamabunShimeiText();
        source.ari_shimei1 = item.getShimei1();
        source.ari_shimei2 = item.getShimei2();
        source.ari_shimeiSmall1 = item.getShimeiSmall1();
        source.ari_shimeiSmall2 = item.getShimeiSmall2();
        source.ari_shimeiText = item.getShimeiText();
        source.ari_yubinNo = item.getYubinNo();
    }

}
