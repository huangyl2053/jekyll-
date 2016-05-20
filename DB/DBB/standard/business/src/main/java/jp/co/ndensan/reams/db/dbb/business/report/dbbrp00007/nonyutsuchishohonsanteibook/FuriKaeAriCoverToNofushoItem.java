/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishohonsanteibook;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ】の情報です。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuriKaeAriCoverToNofushoItem {
// 55
//    private  RString ari_listList1_1;

    private int layoutBreakItem;
    private RString ari_keisanMeisaishoNendo;
    private RString ari_keisanMeisaishoNendoBun;
    private RString ari_titleNendo;
    private RString ari_titleNendoBun;
    private RString ari_HyojicodeName1;
    private RString ari_HyojicodeName2;
    private RString ari_HyojicodeName3;
    private RString ari_Hyojicode1;
    private RString ari_Hyojicode2;
    private RString ari_Hyojicode3;
    private RString ari_keisanMeisaishoKi1;
    private RString ari_keisanMeisaishoNokigenKaishi1;
    private RString ari_kaisanMeisaishoHihokenshaName;
    private RString ari_kaisanMeisaishoSetaiNushiName;
    private RString ari_keisanMeisaishoTsuchishoNo;
    private RString ari_keisanMeisaishoSetaiCode;
    private RString ari_keisanMeisaishoTsuki1;
    private RString ari_keisanMeisaishoNokigenShuryo1;
    private RString ari_keisanMeisaishoKi2;
    private RString ari_keisanMeisaishoNokigenKaishi2;
    private RString ari_keisanMeisaishoTsuki2;
    private RString ari_keisanMeisaishoNokigenShuryo2;
    private RString ari_tsuchishoNo;
    private RString ari_setaiCode;
    private RString ari_keisanMeisaishoKi3;
    private RString ari_keisanMeisaishoNokigenKaishi3;
    private RString ari_keisanMeisaishoKaishiKi;
    private RString ari_keisanMeisaishoTsuki3;
    private RString ari_keisanMeisaishoNokigenShuryo3;
    private RString ari_keisanMeisaishoTsukiSu;
    private RString ari_kaisanMeisaishoShuryoKi;
    private RString ari_keisanMeisaishoKi4;
    private RString ari_keisanMeisaishoNokigenKaishi4;
    private RString ari_bankCode;
    private RString ari_kozaShurui;
    private RString ari_kozaNo;
    private RString ari_keisanMeisaishoTsuki4;
    private RString ari_keisanMeisaishoNokigenShuryo4;
    private RString ari_keisanMeisaishoShotokuDankai;
    private RString ari_kaisanHokenryoRitsu;
    private RString ari_keisanMeisaishoKi5;
    private RString ari_keisanMeisaishoNokigenKaishi5;
    private RString ari_keisanMeisaishoTsuki5;
    private RString ari_keisanMeisaishoNokigenShuryo5;
    private RString ari_keisanMeisaishoCalHokenryoGaku;
    private RString ari_keisanMeisaishoGenmenGaku;
    private RString ari_bankName;
    private RString ari_keisanMeisaishoKi6;
    private RString ari_keisanMeisaishoNokigenKaishi6;
    private RString ari_keisanMeisaishoTsuki6;
    private RString ari_keisanMeisaishoNokigenShuryo6;
    private RString ari_keisanMeisaishoTokuchoGokeiGaku;
    private RString ari_kaisanMeisaishoFuchoGokeiGaku;
    private RString ari_keisanMeisaishoKi7;
    private RString ari_keisanMeisaishoNokigenKaishi7;
    private RString ari_kozaMeiginin;
    private RString ari_keisanMeisaishoTsuki7;
    private RString ari_keisanMeisaishoNokigenShuryo7;
    private RString ari_kaisanMeisaishoNofuZumiGaku;
    private RString ari_keisanMeisaishoKongoNofuGaku;
    private RString ari_keisanMeisaishoKi8;
    private RString ari_keisanMeisaishoNokigenKaishi8;
    private RString ari_yen1;
    private RString ari_yen2;
    private RString ari_keisanMeisaishoTsuki8;
    private RString ari_keisanMeisaishoNokigenShuryo8;
    private RString ari_keisanMeisaishoKiTitle1;
    private RString ari_keisanMeisaishoKibetsuNofuGaku1;
    private RString ari_keisanMeisaishoKiTitle3;
    private RString ari_keisanMeisaishoKibetsuNofuGaku3;
    private RString ari_keisanMeisaishoKi9;
    private RString ari_keisanMeisaishoNokigenKaishi9;
    private RString ari_yen3;
    private RString ari_yen4;
    private RString ari_keisanMeisaishoTsuki9;
    private RString ari_keisanMeisaishoNokigenShuryo9;
    private RString ari_keisanMeisaishoKiTitle2;
    private RString ari_gekihenTitle;
    private RString ari_keisanMeisaishoKibetsuNofuGaku2;
    private RString ari_keisanMeisaishoKiTitle4;
    private RString ari_gekihenMongon;
    private RString ari_keisanMeisaishoKibetsuNofuGaku4;
    private RString ari_keisanMeisaishoKi10;
    private RString ari_keisanMeisaishoNokigenKaishi10;
    private RString ari_keisanmeisaishoNendo2;
    private RString ari_keisanMeisaishoTsuki10;
    private RString ari_keisanMeisaishoNokigenShuryo10;
    private RString ari_keisanMeisaishoHokenryoGokeiGaku;
    private RString ari_pagerenban1;
    private RString ari_pagerenban2;
    private RString ari_nokibetsuMeisaishoNendo;
    private RString ari_nokibetsuMeisaishoNendoBun;
    private RString ari_kozaIraishoLeftJusho;
    private RString ari_kozaIraishoRightJusho;
    private RString ari_nokibetsuMeisaishoTokuchoNofuGaku1;
    private RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1;
    private RString ari_nokibetsuMeisaishoTsuchishoNo;
    private RString ari_nokibetsuMeisaishoSetaiCode;
    private RString ari_nokibetsuMeisaishoTokuchoSaGaku1;
    private RString ari_nokibetsuMeisaishoTokuchoNofuGaku2;
    private RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2;
    private RString ari_nokibetsuMeisaishoTokuchoSaGaku2;
    private RString ari_kozaIraishoLeftHihokenshaName;
    private RString ari_kozaIraishoRightHihokenshaName;
    private RString ari_nokibetsuMeisaishoHohokenshaName;
    private RString ari_nokibetsuMeisaishoTokuchoNofuGaku3;
    private RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3;
    private RString ari_nokibetsuMeisaishoTokuchoSaGaku3;
    private RString ari_nokibetsuMeisaishoTokuchoNofuGaku4;
    private RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4;
    private RString ari_nokibetsuMeisaishoTokuchoSaGaku4;
    private RString ari_kozaIraishoLeftShikibetsuCode;
    private RString ari_kozaIraishoRightShikibetsuCode;
    private RString ari_nokibetsuMeisaishoKi1;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku1;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku1;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku1;
    private RString ari_nokibetsuMeisaishoNokigen1;
    private RString ari_nokibetsuMeisaishoKi2;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku2;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku2;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku2;
    private RString ari_nokibetsuMeisaishoNokigen2;
    private RString ari_nokibetsuMeisaishoKi3;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku3;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku3;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku3;
    private RString ari_nokibetsuMeisaishoNokigen3;
    private RString ari_nokibetsuMeisaishoKi4;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku4;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku4;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku4;
    private RString ari_nokibetsuMeisaishoNokigen4;
    private RString ari_nokibetsuMeisaishoKi5;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku5;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku5;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku5;
    private RString ari_nokibetsuMeisaishoNokigen5;
    private RString ari_nokibetsuMeisaishoKi6;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku6;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku6;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku6;
    private RString ari_nokibetsuMeisaishoNokigen6;
    private RString ari_nokibetsuMeisaishoKi7;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku7;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku7;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku7;
    private RString ari_nokibetsuMeisaishoNokigen7;
    private RString ari_nokibetsuMeisaishoKi8;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku8;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku8;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku8;
    private RString ari_nokibetsuMeisaishoNokigen8;
    private RString ari_nokibetsuMeisaishoKi9;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku9;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku9;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku9;
    private RString ari_nokibetsuMeisaishoNokigen9;
    private RString ari_nokibetsuMeisaishoKi10;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku10;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku10;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku10;
    private RString ari_nokibetsuMeisaishoNokigen10;
    private RString ari_nokibetsuMeisaishoFuchoNofuGaku11;
    private RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku11;
    private RString ari_nokibetsuMeisaishoFuchoSaGaku11;
    private RString ari_renban;
    private RString ari_hokenshaName;
    private RString ari_pagerenban3;
    private RString ari_pagerenban4;
    private RString ari_yubinNo;
    private RString ari_gyoseiku;
    private RString ari_jushoText;
    private RString ari_jusho3;
    private RString ari_jusho1;
    private RString ari_jusho2;
    private RString ari_katagakiText;
    private RString ari_katagaki2;
    private RString ari_katagakiSmall2;
    private RString ari_katagaki1;
    private RString ari_katagakiSmall1;
    private RString ari_shimei2;
    private RString ari_shimeiSmall2;
    private RString ari_shimeiText;
    private RString ari_meishoFuyo2;
    private RString ari_shimeiSmall1;
    private RString ari_dainoKubunMei;
    private RString ari_shimei1;
    private RString ari_meishoFuyo1;
    private RString ari_samabunShimeiText;
    private RString ari_samaBun2;
    private RString ari_samabunShimeiSmall2;
    private RString ari_kakkoLeft2;
    private RString ari_samabunShimei2;
    private RString ari_kakkoRight2;
    private RString ari_kakkoLeft1;
    private RString ari_samabunShimei1;
    private RString ari_samaBun1;
    private RString ari_kakkoRight1;
    private RString ari_samabunShimeiSmall1;
    private RString ari_customerBarCode;
    private RString ari_denshiKoin;
    private RString ari_hakkoYMD;
    private RString ari_ninshoshaYakushokuMei;
    private RString ari_ninshoshaYakushokuMei1;
    private RString ari_koinMojiretsu;
    private RString ari_ninshoshaYakushokuMei2;
    private RString ari_ninshoshaShimeiKakenai;
    private RString ari_ninshoshaShimeiKakeru;
    private RString ari_koinShoryaku;

    // 20
    private RString nofuzumishoTitleNendoBun1;
    private RString nofuzumishoTitleKi1;
    private RString nofuzumishoTitleTsuki1;
    private RString nofozumishoTitleNendo1;
    private RString nofozumishoTitleNendo2;
    private RString nofuzumishoTitleNendoBun2;
    private RString nofuzumishoTitleKi2;
    private RString nofuzumishoTitleTsuki2;
    private RString ryoshushoTitleNendo2;
    private RString ryoshushoTitleKi2;
    private RString ryoshushoTitleTsuki2;
    private RString nofushoTitleNendo2;
    private RString nofushoTitleKi2;
    private RString nofushoTitleTsuki2;
    private RString ryoshushoTitleNendo1;
    private RString ryoshushoTitleKi1;
    private RString ryoshushoTitleTsuki1;
    private RString nofushoTitleNendo1;
    private RString nofushoTitleKi1;
    private RString nofushoTitleTsuki1;
    private RString ryoshushoJusho1;
    private RString ryoshushoJusho2;
    private RString nofuzumishoTsuchishoNo1;
    private RString nofuzumishoTsuchishoNo2;
    private RString nofuzumishoOCR11;
    private RString nofuzumishoOCR12;
    private RString ryoshushoKatagaki1;
    private RString ryoshushoKatagaki2;
    private RString nofuzumishoSetaiCode1;
    private RString nofuzumishoSetaiCode2;
    private RString nofuzumishoOCR22;
    private RString nofuzumishoOCR21;
    private RString ryoshushoHihokenshaName1;
    private RString nofushoHihokenshaName1;
    private RString ryoshushoHihokenshaName2;
    private RString nofushoHihokenshaName2;
    private RString nofuzumishoOCR31;
    private RString nofuzumishoNokigen1;
    private RString nofuzumishoNokigen2;
    private RString nofuzumishoOCR32;
    private RString ryoshushoTsuchishoNo1;
    private RString nofushoTsuchishoNo1;
    private RString ryoshushoTsuchishoNo2;
    private RString nofushoTsuchishoNo2;
    private RString ryoshushoHokenryoGaku1;
    private RString nofushoHokenryoGaku1;
    private RString ryoshushoHokenryoGaku2;
    private RString nofushoHokenryoGaku2;
    private RString nofuzumishoNofuGaku1;
    private RString nofuzumishoNofuGaku2;
    private RString ryoshushoNokigen1;
    private RString nofushoNokigen1;
    private RString ryoshushoNokigen2;
    private RString nofushoNokigen2;
    private RString nofuzumishoJusho1;
    private RString nofuzumishoJusho2;
    private RString nofuzumishoKatagaki1;
    private RString nofuzumishoKatagaki2;
    private RString ryoshushoNofuIn1;
    private RString nofushoNofuIn1;
    private RString nofuzumishoNofuIn1;
    private RString ryoshushoNofuIn2;
    private RString nofushoNofuIn2;
    private RString nofuzumishoNofuIn2;
    private RString ryoshushoKozaCom1;
    private RString nofushoKozaCom1;
    private RString nofuzumishoHihokenshaName1;
    private RString nofuzumishoKozaCom1;
    private RString ryoshushoKozaCom2;
    private RString nofushoKozaCom2;
    private RString nofuzumishoHihokenshaName2;
    private RString nofuzumishoKozaCom2;
    private RString ryoshushoZuiji1;
    private RString nofushoZuiji1;
    private RString nofuzumishoZuiji1;
    private RString ryoshushoZuiji2;
    private RString nofushoZuiji2;
    private RString nofuzumishoZuiji2;
    private RString nofuzumishoshichosonName1;
    private RString pagerenban1;
    private RString nofuzumishoshichosonName2;
    private RString pagerenban2;
    private RString nofozumishoTitleNendo3;
    private RString nofuzumishoTitleNendoBun3;
    private RString nofuzumishoTitleKi3;
    private RString nofuzumishoTitleTsuki3;
    private RString nofozumishoTitleNendo4;
    private RString nofuzumishoTitleNendoBun4;
    private RString nofuzumishoTitleKi4;
    private RString nofuzumishoTitleTsuki4;
    private RString ryoshushoTitleNendo3;
    private RString ryoshushoTitleKi3;
    private RString ryoshushoTitleTsuki3;
    private RString nofushoTitleNendo3;
    private RString nofushoTitleKi3;
    private RString nofushoTitleTsuki3;
    private RString ryoshushoTitleNendo4;
    private RString ryoshushoTitleKi4;
    private RString ryoshushoTitleTsuki4;
    private RString nofushoTitleNendo4;
    private RString nofushoTitleKi4;
    private RString nofushoTitleTsuki4;
    private RString ryoshushoJusho3;
    private RString ryoshushoJusho4;
    private RString nofuzumishoTsuchishoNo3;
    private RString nofuzumishoTsuchishoNo4;
    private RString nofuzumishoOCR13;
    private RString nofuzumishoOCR14;
    private RString ryoshushoKatagaki3;
    private RString ryoshushoKatagaki4;
    private RString nofuzumishoSetaiCode3;
    private RString nofuzumishoSetaiCode4;
    private RString nofuzumishoOCR23;
    private RString nofuzumishoOCR24;
    private RString ryoshushoHihokenshaName3;
    private RString nofushoHihokenshaName3;
    private RString ryoshushoHihokenshaName4;
    private RString nofushoHihokenshaName4;
    private RString nofuzumishoNokigen3;
    private RString nofuzumishoNokigen4;
    private RString nofuzumishoOCR33;
    private RString nofuzumishoOCR34;
    private RString ryoshushoTsuchishoNo3;
    private RString nofushoTsuchishoNo3;
    private RString ryoshushoTsuchishoNo4;
    private RString nofushoTsuchishoNo4;
    private RString ryoshushoHokenryoGaku3;
    private RString nofushoHokenryoGaku3;
    private RString ryoshushoHokenryoGaku4;
    private RString nofushoHokenryoGaku4;
    private RString nofuzumishoNofuGaku3;
    private RString nofuzumishoNofuGaku4;
    private RString ryoshushoNokigen3;
    private RString nofushoNokigen3;
    private RString ryoshushoNokigen4;
    private RString nofushoNokigen4;
    private RString nofuzumishoJusho3;
    private RString nofuzumishoJusho4;
    private RString nofuzumishoKatagaki3;
    private RString nofuzumishoKatagaki4;
    private RString ryoshushoNofuIn3;
    private RString nofushoNofuIn3;
    private RString nofuzumishoNofuIn3;
    private RString ryoshushoNofuIn4;
    private RString nofushoNofuIn4;
    private RString nofuzumishoNofuIn4;
    private RString ryoshushoKozaCom3;
    private RString nofushoKozaCom3;
    private RString nofuzumishoHihokenshaName3;
    private RString nofuzumishoKozaCom3;
    private RString ryoshushoKozaCom4;
    private RString nofushoKozaCom4;
    private RString nofuzumishoHihokenshaName4;
    private RString nofuzumishoKozaCom4;
    private RString ryoshushoZuiji3;
    private RString nofushoZuiji3;
    private RString nofuzumishoZuiji3;
    private RString ryoshushoZuiji4;
    private RString nofushoZuiji4;
    private RString nofuzumishoZuiji4;
    private RString eRenban;
    private RString ePage;
    private RString nofuzumishoshichosonName3;
    private RString pagerenban3;
    private RString nofuzumishoshichosonName4;
    private RString pagerenban4;
    private RString eHokensyaName;

//    public NonyuTsuchishoHonsanteiBookItem(//RString ari_listList1_1,
//            RString ari_keisanMeisaishoNendo,
//            RString ari_keisanMeisaishoNendoBun,
//            RString ari_titleNendo,
//            RString ari_titleNendoBun,
//            RString ari_HyojicodeName1,
//            RString ari_HyojicodeName2,
//            RString ari_HyojicodeName3,
//            RString ari_Hyojicode1,
//            RString ari_Hyojicode2,
//            RString ari_Hyojicode3,
//            RString ari_keisanMeisaishoKi1,
//            RString ari_keisanMeisaishoNokigenKaishi1,
//            RString ari_kaisanMeisaishoHihokenshaName,
//            RString ari_kaisanMeisaishoSetaiNushiName,
//            RString ari_keisanMeisaishoTsuchishoNo,
//            RString ari_keisanMeisaishoSetaiCode,
//            RString ari_keisanMeisaishoTsuki1,
//            RString ari_keisanMeisaishoNokigenShuryo1,
//            RString ari_keisanMeisaishoKi2,
//            RString ari_keisanMeisaishoNokigenKaishi2,
//            RString ari_keisanMeisaishoTsuki2,
//            RString ari_keisanMeisaishoNokigenShuryo2,
//            RString ari_tsuchishoNo,
//            RString ari_setaiCode,
//            RString ari_keisanMeisaishoKi3,
//            RString ari_keisanMeisaishoNokigenKaishi3,
//            RString ari_keisanMeisaishoKaishiKi,
//            RString ari_keisanMeisaishoTsuki3,
//            RString ari_keisanMeisaishoNokigenShuryo3,
//            RString ari_keisanMeisaishoTsukiSu,
//            RString ari_kaisanMeisaishoShuryoKi,
//            RString ari_keisanMeisaishoKi4,
//            RString ari_keisanMeisaishoNokigenKaishi4,
//            RString ari_bankCode,
//            RString ari_kozaShurui,
//            RString ari_kozaNo,
//            RString ari_keisanMeisaishoTsuki4,
//            RString ari_keisanMeisaishoNokigenShuryo4,
//            RString ari_keisanMeisaishoShotokuDankai,
//            RString ari_kaisanHokenryoRitsu,
//            RString ari_keisanMeisaishoKi5,
//            RString ari_keisanMeisaishoNokigenKaishi5,
//            RString ari_keisanMeisaishoTsuki5,
//            RString ari_keisanMeisaishoNokigenShuryo5,
//            RString ari_keisanMeisaishoCalHokenryoGaku,
//            RString ari_keisanMeisaishoGenmenGaku,
//            RString ari_bankName,
//            RString ari_keisanMeisaishoKi6,
//            RString ari_keisanMeisaishoNokigenKaishi6,
//            RString ari_keisanMeisaishoTsuki6,
//            RString ari_keisanMeisaishoNokigenShuryo6,
//            RString ari_keisanMeisaishoTokuchoGokeiGaku,
//            RString ari_kaisanMeisaishoFuchoGokeiGaku,
//            RString ari_keisanMeisaishoKi7,
//            RString ari_keisanMeisaishoNokigenKaishi7,
//            RString ari_kozaMeiginin,
//            RString ari_keisanMeisaishoTsuki7,
//            RString ari_keisanMeisaishoNokigenShuryo7,
//            RString ari_kaisanMeisaishoNofuZumiGaku,
//            RString ari_keisanMeisaishoKongoNofuGaku,
//            RString ari_keisanMeisaishoKi8,
//            RString ari_keisanMeisaishoNokigenKaishi8,
//            RString ari_yen1,
//            RString ari_yen2,
//            RString ari_keisanMeisaishoTsuki8,
//            RString ari_keisanMeisaishoNokigenShuryo8,
//            RString ari_keisanMeisaishoKiTitle1,
//            RString ari_keisanMeisaishoKibetsuNofuGaku1,
//            RString ari_keisanMeisaishoKiTitle3,
//            RString ari_keisanMeisaishoKibetsuNofuGaku3,
//            RString ari_keisanMeisaishoKi9,
//            RString ari_keisanMeisaishoNokigenKaishi9,
//            RString ari_yen3,
//            RString ari_yen4,
//            RString ari_keisanMeisaishoTsuki9,
//            RString ari_keisanMeisaishoNokigenShuryo9,
//            RString ari_keisanMeisaishoKiTitle2,
//            RString ari_gekihenTitle,
//            RString ari_keisanMeisaishoKibetsuNofuGaku2,
//            RString ari_keisanMeisaishoKiTitle4,
//            RString ari_gekihenMongon,
//            RString ari_keisanMeisaishoKibetsuNofuGaku4,
//            RString ari_keisanMeisaishoKi10,
//            RString ari_keisanMeisaishoNokigenKaishi10,
//            RString ari_keisanmeisaishoNendo2,
//            RString ari_keisanMeisaishoTsuki10,
//            RString ari_keisanMeisaishoNokigenShuryo10,
//            RString ari_keisanMeisaishoHokenryoGokeiGaku,
//            RString ari_pagerenban1,
//            RString ari_pagerenban2,
//            RString ari_nokibetsuMeisaishoNendo,
//            RString ari_nokibetsuMeisaishoNendoBun,
//            RString ari_kozaIraishoLeftJusho,
//            RString ari_kozaIraishoRightJusho,
//            RString ari_nokibetsuMeisaishoTokuchoNofuGaku1,
//            RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1,
//            RString ari_nokibetsuMeisaishoTsuchishoNo,
//            RString ari_nokibetsuMeisaishoSetaiCode,
//            RString ari_nokibetsuMeisaishoTokuchoSaGaku1,
//            RString ari_nokibetsuMeisaishoTokuchoNofuGaku2,
//            RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2,
//            RString ari_nokibetsuMeisaishoTokuchoSaGaku2,
//            RString ari_kozaIraishoLeftHihokenshaName,
//            RString ari_kozaIraishoRightHihokenshaName,
//            RString ari_nokibetsuMeisaishoHohokenshaName,
//            RString ari_nokibetsuMeisaishoTokuchoNofuGaku3,
//            RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3,
//            RString ari_nokibetsuMeisaishoTokuchoSaGaku3,
//            RString ari_nokibetsuMeisaishoTokuchoNofuGaku4,
//            RString ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4,
//            RString ari_nokibetsuMeisaishoTokuchoSaGaku4,
//            RString ari_kozaIraishoLeftShikibetsuCode,
//            RString ari_kozaIraishoRightShikibetsuCode,
//            RString ari_nokibetsuMeisaishoKi1,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku1,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku1,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku1,
//            RString ari_nokibetsuMeisaishoNokigen1,
//            RString ari_nokibetsuMeisaishoKi2,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku2,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku2,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku2,
//            RString ari_nokibetsuMeisaishoNokigen2,
//            RString ari_nokibetsuMeisaishoKi3,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku3,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku3,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku3,
//            RString ari_nokibetsuMeisaishoNokigen3,
//            RString ari_nokibetsuMeisaishoKi4,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku4,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku4,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku4,
//            RString ari_nokibetsuMeisaishoNokigen4,
//            RString ari_nokibetsuMeisaishoKi5,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku5,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku5,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku5,
//            RString ari_nokibetsuMeisaishoNokigen5,
//            RString ari_nokibetsuMeisaishoKi6,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku6,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku6,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku6,
//            RString ari_nokibetsuMeisaishoNokigen6,
//            RString ari_nokibetsuMeisaishoKi7,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku7,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku7,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku7,
//            RString ari_nokibetsuMeisaishoNokigen7,
//            RString ari_nokibetsuMeisaishoKi8,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku8,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku8,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku8,
//            RString ari_nokibetsuMeisaishoNokigen8,
//            RString ari_nokibetsuMeisaishoKi9,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku9,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku9,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku9,
//            RString ari_nokibetsuMeisaishoNokigen9,
//            RString ari_nokibetsuMeisaishoKi10,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku10,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku10,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku10,
//            RString ari_nokibetsuMeisaishoNokigen10,
//            RString ari_nokibetsuMeisaishoFuchoNofuGaku11,
//            RString ari_nokibetsuMeisaishoFuchoNofuZumiGaku11,
//            RString ari_nokibetsuMeisaishoFuchoSaGaku11,
//            RString ari_renban,
//            RString ari_hokenshaName,
//            RString ari_pagerenban3,
//            RString ari_pagerenban4,
//            RString ari_yubinNo,
//            RString ari_gyoseiku,
//            RString ari_jushoText,
//            RString ari_jusho3,
//            RString ari_jusho1,
//            RString ari_jusho2,
//            RString ari_katagakiText,
//            RString ari_katagaki2,
//            RString ari_katagakiSmall2,
//            RString ari_katagaki1,
//            RString ari_katagakiSmall1,
//            RString ari_shimei2,
//            RString ari_shimeiSmall2,
//            RString ari_shimeiText,
//            RString ari_meishoFuyo2,
//            RString ari_shimeiSmall1,
//            RString ari_dainoKubunMei,
//            RString ari_shimei1,
//            RString ari_meishoFuyo1,
//            RString ari_samabunShimeiText,
//            RString ari_samaBun2,
//            RString ari_samabunShimeiSmall2,
//            RString ari_kakkoLeft2,
//            RString ari_samabunShimei2,
//            RString ari_kakkoRight2,
//            RString ari_kakkoLeft1,
//            RString ari_samabunShimei1,
//            RString ari_samaBun1,
//            RString ari_kakkoRight1,
//            RString ari_samabunShimeiSmall1,
//            RString ari_customerBarCode,
//            RString ari_denshiKoin,
//            RString ari_hakkoYMD,
//            RString ari_ninshoshaYakushokuMei,
//            RString ari_ninshoshaYakushokuMei1,
//            RString ari_koinMojiretsu,
//            RString ari_ninshoshaYakushokuMei2,
//            RString ari_ninshoshaShimeiKakenai,
//            RString ari_ninshoshaShimeiKakeru,
//            RString ari_koinShoryaku,
//            // 20
//            RString nofuzumishoTitleNendoBun1,
//            RString nofuzumishoTitleKi1,
//            RString nofuzumishoTitleTsuki1,
//            RString nofozumishoTitleNendo1,
//            RString nofozumishoTitleNendo2,
//            RString nofuzumishoTitleNendoBun2,
//            RString nofuzumishoTitleKi2,
//            RString nofuzumishoTitleTsuki2,
//            RString ryoshushoTitleNendo2,
//            RString ryoshushoTitleKi2,
//            RString ryoshushoTitleTsuki2,
//            RString nofushoTitleNendo2,
//            RString nofushoTitleKi2,
//            RString nofushoTitleTsuki2,
//            RString ryoshushoTitleNendo1,
//            RString ryoshushoTitleKi1,
//            RString ryoshushoTitleTsuki1,
//            RString nofushoTitleNendo1,
//            RString nofushoTitleKi1,
//            RString nofushoTitleTsuki1,
//            RString ryoshushoJusho1,
//            RString ryoshushoJusho2,
//            RString nofuzumishoTsuchishoNo1,
//            RString nofuzumishoTsuchishoNo2,
//            RString nofuzumishoOCR11,
//            RString nofuzumishoOCR12,
//            RString ryoshushoKatagaki1,
//            RString ryoshushoKatagaki2,
//            RString nofuzumishoSetaiCode1,
//            RString nofuzumishoSetaiCode2,
//            RString nofuzumishoOCR22,
//            RString nofuzumishoOCR21,
//            RString ryoshushoHihokenshaName1,
//            RString nofushoHihokenshaName1,
//            RString ryoshushoHihokenshaName2,
//            RString nofushoHihokenshaName2,
//            RString nofuzumishoOCR31,
//            RString nofuzumishoNokigen1,
//            RString nofuzumishoNokigen2,
//            RString nofuzumishoOCR32,
//            RString ryoshushoTsuchishoNo1,
//            RString nofushoTsuchishoNo1,
//            RString ryoshushoTsuchishoNo2,
//            RString nofushoTsuchishoNo2,
//            RString ryoshushoHokenryoGaku1,
//            RString nofushoHokenryoGaku1,
//            RString ryoshushoHokenryoGaku2,
//            RString nofushoHokenryoGaku2,
//            RString nofuzumishoNofuGaku1,
//            RString nofuzumishoNofuGaku2,
//            RString ryoshushoNokigen1,
//            RString nofushoNokigen1,
//            RString ryoshushoNokigen2,
//            RString nofushoNokigen2,
//            RString nofuzumishoJusho1,
//            RString nofuzumishoJusho2,
//            RString nofuzumishoKatagaki1,
//            RString nofuzumishoKatagaki2,
//            RString ryoshushoNofuIn1,
//            RString nofushoNofuIn1,
//            RString nofuzumishoNofuIn1,
//            RString ryoshushoNofuIn2,
//            RString nofushoNofuIn2,
//            RString nofuzumishoNofuIn2,
//            RString ryoshushoKozaCom1,
//            RString nofushoKozaCom1,
//            RString nofuzumishoHihokenshaName1,
//            RString nofuzumishoKozaCom1,
//            RString ryoshushoKozaCom2,
//            RString nofushoKozaCom2,
//            RString nofuzumishoHihokenshaName2,
//            RString nofuzumishoKozaCom2,
//            RString ryoshushoZuiji1,
//            RString nofushoZuiji1,
//            RString nofuzumishoZuiji1,
//            RString ryoshushoZuiji2,
//            RString nofushoZuiji2,
//            RString nofuzumishoZuiji2,
//            RString nofuzumishoshichosonName1,
//            RString pagerenban1,
//            RString nofuzumishoshichosonName2,
//            RString pagerenban2,
//            RString nofozumishoTitleNendo3,
//            RString nofuzumishoTitleNendoBun3,
//            RString nofuzumishoTitleKi3,
//            RString nofuzumishoTitleTsuki3,
//            RString nofozumishoTitleNendo4,
//            RString nofuzumishoTitleNendoBun4,
//            RString nofuzumishoTitleKi4,
//            RString nofuzumishoTitleTsuki4,
//            RString ryoshushoTitleNendo3,
//            RString ryoshushoTitleKi3,
//            RString ryoshushoTitleTsuki3,
//            RString nofushoTitleNendo3,
//            RString nofushoTitleKi3,
//            RString nofushoTitleTsuki3,
//            RString ryoshushoTitleNendo4,
//            RString ryoshushoTitleKi4,
//            RString ryoshushoTitleTsuki4,
//            RString nofushoTitleNendo4,
//            RString nofushoTitleKi4,
//            RString nofushoTitleTsuki4,
//            RString ryoshushoJusho3,
//            RString ryoshushoJusho4,
//            RString nofuzumishoTsuchishoNo3,
//            RString nofuzumishoTsuchishoNo4,
//            RString nofuzumishoOCR13,
//            RString nofuzumishoOCR14,
//            RString ryoshushoKatagaki3,
//            RString ryoshushoKatagaki4,
//            RString nofuzumishoSetaiCode3,
//            RString nofuzumishoSetaiCode4,
//            RString nofuzumishoOCR23,
//            RString nofuzumishoOCR24,
//            RString ryoshushoHihokenshaName3,
//            RString nofushoHihokenshaName3,
//            RString ryoshushoHihokenshaName4,
//            RString nofushoHihokenshaName4,
//            RString nofuzumishoNokigen3,
//            RString nofuzumishoNokigen4,
//            RString nofuzumishoOCR33,
//            RString nofuzumishoOCR34,
//            RString ryoshushoTsuchishoNo3,
//            RString nofushoTsuchishoNo3,
//            RString ryoshushoTsuchishoNo4,
//            RString nofushoTsuchishoNo4,
//            RString ryoshushoHokenryoGaku3,
//            RString nofushoHokenryoGaku3,
//            RString ryoshushoHokenryoGaku4,
//            RString nofushoHokenryoGaku4,
//            RString nofuzumishoNofuGaku3,
//            RString nofuzumishoNofuGaku4,
//            RString ryoshushoNokigen3,
//            RString nofushoNokigen3,
//            RString ryoshushoNokigen4,
//            RString nofushoNokigen4,
//            RString nofuzumishoJusho3,
//            RString nofuzumishoJusho4,
//            RString nofuzumishoKatagaki3,
//            RString nofuzumishoKatagaki4,
//            RString ryoshushoNofuIn3,
//            RString nofushoNofuIn3,
//            RString nofuzumishoNofuIn3,
//            RString ryoshushoNofuIn4,
//            RString nofushoNofuIn4,
//            RString nofuzumishoNofuIn4,
//            RString ryoshushoKozaCom3,
//            RString nofushoKozaCom3,
//            RString nofuzumishoHihokenshaName3,
//            RString nofuzumishoKozaCom3,
//            RString ryoshushoKozaCom4,
//            RString nofushoKozaCom4,
//            RString nofuzumishoHihokenshaName4,
//            RString nofuzumishoKozaCom4,
//            RString ryoshushoZuiji3,
//            RString nofushoZuiji3,
//            RString nofuzumishoZuiji3,
//            RString ryoshushoZuiji4,
//            RString nofushoZuiji4,
//            RString nofuzumishoZuiji4,
//            RString eRenban,
//            RString ePage,
//            RString nofuzumishoshichosonName3,
//            RString pagerenban3,
//            RString nofuzumishoshichosonName4,
//            RString pagerenban4,
//            RString eHokensyaName) {
//
////        this.ari_listList1_1 = ari_listList1_1;
//        this.ari_keisanMeisaishoNendo = ari_keisanMeisaishoNendo;
//        this.ari_keisanMeisaishoNendoBun = ari_keisanMeisaishoNendoBun;
//        this.ari_titleNendo = ari_titleNendo;
//        this.ari_titleNendoBun = ari_titleNendoBun;
//        this.ari_HyojicodeName1 = ari_HyojicodeName1;
//        this.ari_HyojicodeName2 = ari_HyojicodeName2;
//        this.ari_HyojicodeName3 = ari_HyojicodeName3;
//        this.ari_Hyojicode1 = ari_Hyojicode1;
//        this.ari_Hyojicode2 = ari_Hyojicode2;
//        this.ari_Hyojicode3 = ari_Hyojicode3;
//        this.ari_keisanMeisaishoKi1 = ari_keisanMeisaishoKi1;
//        this.ari_keisanMeisaishoNokigenKaishi1 = ari_keisanMeisaishoNokigenKaishi1;
//        this.ari_kaisanMeisaishoHihokenshaName = ari_kaisanMeisaishoHihokenshaName;
//        this.ari_kaisanMeisaishoSetaiNushiName = ari_kaisanMeisaishoSetaiNushiName;
//        this.ari_keisanMeisaishoTsuchishoNo = ari_keisanMeisaishoTsuchishoNo;
//        this.ari_keisanMeisaishoSetaiCode = ari_keisanMeisaishoSetaiCode;
//        this.ari_keisanMeisaishoTsuki1 = ari_keisanMeisaishoTsuki1;
//        this.ari_keisanMeisaishoNokigenShuryo1 = ari_keisanMeisaishoNokigenShuryo1;
//        this.ari_keisanMeisaishoKi2 = ari_keisanMeisaishoKi2;
//        this.ari_keisanMeisaishoNokigenKaishi2 = ari_keisanMeisaishoNokigenKaishi2;
//        this.ari_keisanMeisaishoTsuki2 = ari_keisanMeisaishoTsuki2;
//        this.ari_keisanMeisaishoNokigenShuryo2 = ari_keisanMeisaishoNokigenShuryo2;
//        this.ari_tsuchishoNo = ari_tsuchishoNo;
//        this.ari_setaiCode = ari_setaiCode;
//        this.ari_keisanMeisaishoKi3 = ari_keisanMeisaishoKi3;
//        this.ari_keisanMeisaishoNokigenKaishi3 = ari_keisanMeisaishoNokigenKaishi3;
//        this.ari_keisanMeisaishoKaishiKi = ari_keisanMeisaishoKaishiKi;
//        this.ari_keisanMeisaishoTsuki3 = ari_keisanMeisaishoTsuki3;
//        this.ari_keisanMeisaishoNokigenShuryo3 = ari_keisanMeisaishoNokigenShuryo3;
//        this.ari_keisanMeisaishoTsukiSu = ari_keisanMeisaishoTsukiSu;
//        this.ari_kaisanMeisaishoShuryoKi = ari_kaisanMeisaishoShuryoKi;
//        this.ari_keisanMeisaishoKi4 = ari_keisanMeisaishoKi4;
//        this.ari_keisanMeisaishoNokigenKaishi4 = ari_keisanMeisaishoNokigenKaishi4;
//        this.ari_bankCode = ari_bankCode;
//        this.ari_kozaShurui = ari_kozaShurui;
//        this.ari_kozaNo = ari_kozaNo;
//        this.ari_keisanMeisaishoTsuki4 = ari_keisanMeisaishoTsuki4;
//        this.ari_keisanMeisaishoNokigenShuryo4 = ari_keisanMeisaishoNokigenShuryo4;
//        this.ari_keisanMeisaishoShotokuDankai = ari_keisanMeisaishoShotokuDankai;
//        this.ari_kaisanHokenryoRitsu = ari_kaisanHokenryoRitsu;
//        this.ari_keisanMeisaishoKi5 = ari_keisanMeisaishoKi5;
//        this.ari_keisanMeisaishoNokigenKaishi5 = ari_keisanMeisaishoNokigenKaishi5;
//        this.ari_keisanMeisaishoTsuki5 = ari_keisanMeisaishoTsuki5;
//        this.ari_keisanMeisaishoNokigenShuryo5 = ari_keisanMeisaishoNokigenShuryo5;
//        this.ari_keisanMeisaishoCalHokenryoGaku = ari_keisanMeisaishoCalHokenryoGaku;
//        this.ari_keisanMeisaishoGenmenGaku = ari_keisanMeisaishoGenmenGaku;
//        this.ari_bankName = ari_bankName;
//        this.ari_keisanMeisaishoKi6 = ari_keisanMeisaishoKi6;
//        this.ari_keisanMeisaishoNokigenKaishi6 = ari_keisanMeisaishoNokigenKaishi6;
//        this.ari_keisanMeisaishoTsuki6 = ari_keisanMeisaishoTsuki6;
//        this.ari_keisanMeisaishoNokigenShuryo6 = ari_keisanMeisaishoNokigenShuryo6;
//        this.ari_keisanMeisaishoTokuchoGokeiGaku = ari_keisanMeisaishoTokuchoGokeiGaku;
//        this.ari_kaisanMeisaishoFuchoGokeiGaku = ari_kaisanMeisaishoFuchoGokeiGaku;
//        this.ari_keisanMeisaishoKi7 = ari_keisanMeisaishoKi7;
//        this.ari_keisanMeisaishoNokigenKaishi7 = ari_keisanMeisaishoNokigenKaishi7;
//        this.ari_kozaMeiginin = ari_kozaMeiginin;
//        this.ari_keisanMeisaishoTsuki7 = ari_keisanMeisaishoTsuki7;
//        this.ari_keisanMeisaishoNokigenShuryo7 = ari_keisanMeisaishoNokigenShuryo7;
//        this.ari_kaisanMeisaishoNofuZumiGaku = ari_kaisanMeisaishoNofuZumiGaku;
//        this.ari_keisanMeisaishoKongoNofuGaku = ari_keisanMeisaishoKongoNofuGaku;
//        this.ari_keisanMeisaishoKi8 = ari_keisanMeisaishoKi8;
//        this.ari_keisanMeisaishoNokigenKaishi8 = ari_keisanMeisaishoNokigenKaishi8;
//        this.ari_yen1 = ari_yen1;
//        this.ari_yen2 = ari_yen2;
//        this.ari_keisanMeisaishoTsuki8 = ari_keisanMeisaishoTsuki8;
//        this.ari_keisanMeisaishoNokigenShuryo8 = ari_keisanMeisaishoNokigenShuryo8;
//        this.ari_keisanMeisaishoKiTitle1 = ari_keisanMeisaishoKiTitle1;
//        this.ari_keisanMeisaishoKibetsuNofuGaku1 = ari_keisanMeisaishoKibetsuNofuGaku1;
//        this.ari_keisanMeisaishoKiTitle3 = ari_keisanMeisaishoKiTitle3;
//        this.ari_keisanMeisaishoKibetsuNofuGaku3 = ari_keisanMeisaishoKibetsuNofuGaku3;
//        this.ari_keisanMeisaishoKi9 = ari_keisanMeisaishoKi9;
//        this.ari_keisanMeisaishoNokigenKaishi9 = ari_keisanMeisaishoNokigenKaishi9;
//        this.ari_yen3 = ari_yen3;
//        this.ari_yen4 = ari_yen4;
//        this.ari_keisanMeisaishoTsuki9 = ari_keisanMeisaishoTsuki9;
//        this.ari_keisanMeisaishoNokigenShuryo9 = ari_keisanMeisaishoNokigenShuryo9;
//        this.ari_keisanMeisaishoKiTitle2 = ari_keisanMeisaishoKiTitle2;
//        this.ari_gekihenTitle = ari_gekihenTitle;
//        this.ari_keisanMeisaishoKibetsuNofuGaku2 = ari_keisanMeisaishoKibetsuNofuGaku2;
//        this.ari_keisanMeisaishoKiTitle4 = ari_keisanMeisaishoKiTitle4;
//        this.ari_gekihenMongon = ari_gekihenMongon;
//        this.ari_keisanMeisaishoKibetsuNofuGaku4 = ari_keisanMeisaishoKibetsuNofuGaku4;
//        this.ari_keisanMeisaishoKi10 = ari_keisanMeisaishoKi10;
//        this.ari_keisanMeisaishoNokigenKaishi10 = ari_keisanMeisaishoNokigenKaishi10;
//        this.ari_keisanmeisaishoNendo2 = ari_keisanmeisaishoNendo2;
//        this.ari_keisanMeisaishoTsuki10 = ari_keisanMeisaishoTsuki10;
//        this.ari_keisanMeisaishoNokigenShuryo10 = ari_keisanMeisaishoNokigenShuryo10;
//        this.ari_keisanMeisaishoHokenryoGokeiGaku = ari_keisanMeisaishoHokenryoGokeiGaku;
//        this.ari_pagerenban1 = ari_pagerenban1;
//        this.ari_pagerenban2 = ari_pagerenban2;
//        this.ari_nokibetsuMeisaishoNendo = ari_nokibetsuMeisaishoNendo;
//        this.ari_nokibetsuMeisaishoNendoBun = ari_nokibetsuMeisaishoNendoBun;
//        this.ari_kozaIraishoLeftJusho = ari_kozaIraishoLeftJusho;
//        this.ari_kozaIraishoRightJusho = ari_kozaIraishoRightJusho;
//        this.ari_nokibetsuMeisaishoTokuchoNofuGaku1 = ari_nokibetsuMeisaishoTokuchoNofuGaku1;
//        this.ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1 = ari_nokibetsuMeisaishoTokuchoNofuZumiGaku1;
//        this.ari_nokibetsuMeisaishoTsuchishoNo = ari_nokibetsuMeisaishoTsuchishoNo;
//        this.ari_nokibetsuMeisaishoSetaiCode = ari_nokibetsuMeisaishoSetaiCode;
//        this.ari_nokibetsuMeisaishoTokuchoSaGaku1 = ari_nokibetsuMeisaishoTokuchoSaGaku1;
//        this.ari_nokibetsuMeisaishoTokuchoNofuGaku2 = ari_nokibetsuMeisaishoTokuchoNofuGaku2;
//        this.ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2 = ari_nokibetsuMeisaishoTokuchoNofuZumiGaku2;
//        this.ari_nokibetsuMeisaishoTokuchoSaGaku2 = ari_nokibetsuMeisaishoTokuchoSaGaku2;
//        this.ari_kozaIraishoLeftHihokenshaName = ari_kozaIraishoLeftHihokenshaName;
//        this.ari_kozaIraishoRightHihokenshaName = ari_kozaIraishoRightHihokenshaName;
//        this.ari_nokibetsuMeisaishoHohokenshaName = ari_nokibetsuMeisaishoHohokenshaName;
//        this.ari_nokibetsuMeisaishoTokuchoNofuGaku3 = ari_nokibetsuMeisaishoTokuchoNofuGaku3;
//        this.ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3 = ari_nokibetsuMeisaishoTokuchoNofuZumiGaku3;
//        this.ari_nokibetsuMeisaishoTokuchoSaGaku3 = ari_nokibetsuMeisaishoTokuchoSaGaku3;
//        this.ari_nokibetsuMeisaishoTokuchoNofuGaku4 = ari_nokibetsuMeisaishoTokuchoNofuGaku4;
//        this.ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4 = ari_nokibetsuMeisaishoTokuchoNofuZumiGaku4;
//        this.ari_nokibetsuMeisaishoTokuchoSaGaku4 = ari_nokibetsuMeisaishoTokuchoSaGaku4;
//        this.ari_kozaIraishoLeftShikibetsuCode = ari_kozaIraishoLeftShikibetsuCode;
//        this.ari_kozaIraishoRightShikibetsuCode = ari_kozaIraishoRightShikibetsuCode;
//        this.ari_nokibetsuMeisaishoKi1 = ari_nokibetsuMeisaishoKi1;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku1 = ari_nokibetsuMeisaishoFuchoNofuGaku1;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku1 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku1;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku1 = ari_nokibetsuMeisaishoFuchoSaGaku1;
//        this.ari_nokibetsuMeisaishoNokigen1 = ari_nokibetsuMeisaishoNokigen1;
//        this.ari_nokibetsuMeisaishoKi2 = ari_nokibetsuMeisaishoKi2;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku2 = ari_nokibetsuMeisaishoFuchoNofuGaku2;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku2 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku2;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku2 = ari_nokibetsuMeisaishoFuchoSaGaku2;
//        this.ari_nokibetsuMeisaishoNokigen2 = ari_nokibetsuMeisaishoNokigen2;
//        this.ari_nokibetsuMeisaishoKi3 = ari_nokibetsuMeisaishoKi3;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku3 = ari_nokibetsuMeisaishoFuchoNofuGaku3;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku3 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku3;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku3 = ari_nokibetsuMeisaishoFuchoSaGaku3;
//        this.ari_nokibetsuMeisaishoNokigen3 = ari_nokibetsuMeisaishoNokigen3;
//        this.ari_nokibetsuMeisaishoKi4 = ari_nokibetsuMeisaishoKi4;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku4 = ari_nokibetsuMeisaishoFuchoNofuGaku4;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku4 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku4;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku4 = ari_nokibetsuMeisaishoFuchoSaGaku4;
//        this.ari_nokibetsuMeisaishoNokigen4 = ari_nokibetsuMeisaishoNokigen4;
//        this.ari_nokibetsuMeisaishoKi5 = ari_nokibetsuMeisaishoKi5;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku5 = ari_nokibetsuMeisaishoFuchoNofuGaku5;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku5 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku5;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku5 = ari_nokibetsuMeisaishoFuchoSaGaku5;
//        this.ari_nokibetsuMeisaishoNokigen5 = ari_nokibetsuMeisaishoNokigen5;
//        this.ari_nokibetsuMeisaishoKi6 = ari_nokibetsuMeisaishoKi6;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku6 = ari_nokibetsuMeisaishoFuchoNofuGaku6;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku6 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku6;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku6 = ari_nokibetsuMeisaishoFuchoSaGaku6;
//        this.ari_nokibetsuMeisaishoNokigen6 = ari_nokibetsuMeisaishoNokigen6;
//        this.ari_nokibetsuMeisaishoKi7 = ari_nokibetsuMeisaishoKi7;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku7 = ari_nokibetsuMeisaishoFuchoNofuGaku7;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku7 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku7;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku7 = ari_nokibetsuMeisaishoFuchoSaGaku7;
//        this.ari_nokibetsuMeisaishoNokigen7 = ari_nokibetsuMeisaishoNokigen7;
//        this.ari_nokibetsuMeisaishoKi8 = ari_nokibetsuMeisaishoKi8;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku8 = ari_nokibetsuMeisaishoFuchoNofuGaku8;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku8 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku8;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku8 = ari_nokibetsuMeisaishoFuchoSaGaku8;
//        this.ari_nokibetsuMeisaishoNokigen8 = ari_nokibetsuMeisaishoNokigen8;
//        this.ari_nokibetsuMeisaishoKi9 = ari_nokibetsuMeisaishoKi9;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku9 = ari_nokibetsuMeisaishoFuchoNofuGaku9;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku9 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku9;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku9 = ari_nokibetsuMeisaishoFuchoSaGaku9;
//        this.ari_nokibetsuMeisaishoNokigen9 = ari_nokibetsuMeisaishoNokigen9;
//        this.ari_nokibetsuMeisaishoKi10 = ari_nokibetsuMeisaishoKi10;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku10 = ari_nokibetsuMeisaishoFuchoNofuGaku10;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku10 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku10;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku10 = ari_nokibetsuMeisaishoFuchoSaGaku10;
//        this.ari_nokibetsuMeisaishoNokigen10 = ari_nokibetsuMeisaishoNokigen10;
//        this.ari_nokibetsuMeisaishoFuchoNofuGaku11 = ari_nokibetsuMeisaishoFuchoNofuGaku11;
//        this.ari_nokibetsuMeisaishoFuchoNofuZumiGaku11 = ari_nokibetsuMeisaishoFuchoNofuZumiGaku11;
//        this.ari_nokibetsuMeisaishoFuchoSaGaku11 = ari_nokibetsuMeisaishoFuchoSaGaku11;
//        this.ari_renban = ari_renban;
//        this.ari_hokenshaName = ari_hokenshaName;
//        this.ari_pagerenban3 = ari_pagerenban3;
//        this.ari_pagerenban4 = ari_pagerenban4;
//        this.ari_yubinNo = ari_yubinNo;
//        this.ari_gyoseiku = ari_gyoseiku;
//        this.ari_jushoText = ari_jushoText;
//        this.ari_jusho3 = ari_jusho3;
//        this.ari_jusho1 = ari_jusho1;
//        this.ari_jusho2 = ari_jusho2;
//        this.ari_katagakiText = ari_katagakiText;
//        this.ari_katagaki2 = ari_katagaki2;
//        this.ari_katagakiSmall2 = ari_katagakiSmall2;
//        this.ari_katagaki1 = ari_katagaki1;
//        this.ari_katagakiSmall1 = ari_katagakiSmall1;
//        this.ari_shimei2 = ari_shimei2;
//        this.ari_shimeiSmall2 = ari_shimeiSmall2;
//        this.ari_shimeiText = ari_shimeiText;
//        this.ari_meishoFuyo2 = ari_meishoFuyo2;
//        this.ari_shimeiSmall1 = ari_shimeiSmall1;
//        this.ari_dainoKubunMei = ari_dainoKubunMei;
//        this.ari_shimei1 = ari_shimei1;
//        this.ari_meishoFuyo1 = ari_meishoFuyo1;
//        this.ari_samabunShimeiText = ari_samabunShimeiText;
//        this.ari_samaBun2 = ari_samaBun2;
//        this.ari_samabunShimeiSmall2 = ari_samabunShimeiSmall2;
//        this.ari_kakkoLeft2 = ari_kakkoLeft2;
//        this.ari_samabunShimei2 = ari_samabunShimei2;
//        this.ari_kakkoRight2 = ari_kakkoRight2;
//        this.ari_kakkoLeft1 = ari_kakkoLeft1;
//        this.ari_samabunShimei1 = ari_samabunShimei1;
//        this.ari_samaBun1 = ari_samaBun1;
//        this.ari_kakkoRight1 = ari_kakkoRight1;
//        this.ari_samabunShimeiSmall1 = ari_samabunShimeiSmall1;
//        this.ari_customerBarCode = ari_customerBarCode;
//        this.ari_denshiKoin = ari_denshiKoin;
//        this.ari_hakkoYMD = ari_hakkoYMD;
//        this.ari_ninshoshaYakushokuMei = ari_ninshoshaYakushokuMei;
//        this.ari_ninshoshaYakushokuMei1 = ari_ninshoshaYakushokuMei1;
//        this.ari_koinMojiretsu = ari_koinMojiretsu;
//        this.ari_ninshoshaYakushokuMei2 = ari_ninshoshaYakushokuMei2;
//        this.ari_ninshoshaShimeiKakenai = ari_ninshoshaShimeiKakenai;
//        this.ari_ninshoshaShimeiKakeru = ari_ninshoshaShimeiKakeru;
//        this.ari_koinShoryaku = ari_koinShoryaku;
//
//        // 20
//        this.nofuzumishoTitleNendoBun1 = nofuzumishoTitleNendoBun1;
//        this.nofuzumishoTitleKi1 = nofuzumishoTitleKi1;
//        this.nofuzumishoTitleTsuki1 = nofuzumishoTitleTsuki1;
//        this.nofozumishoTitleNendo1 = nofozumishoTitleNendo1;
//        this.nofozumishoTitleNendo2 = nofozumishoTitleNendo2;
//        this.nofuzumishoTitleNendoBun2 = nofuzumishoTitleNendoBun2;
//        this.nofuzumishoTitleKi2 = nofuzumishoTitleKi2;
//        this.nofuzumishoTitleTsuki2 = nofuzumishoTitleTsuki2;
//        this.ryoshushoTitleNendo2 = ryoshushoTitleNendo2;
//        this.ryoshushoTitleKi2 = ryoshushoTitleKi2;
//        this.ryoshushoTitleTsuki2 = ryoshushoTitleTsuki2;
//        this.nofushoTitleNendo2 = nofushoTitleNendo2;
//        this.nofushoTitleKi2 = nofushoTitleKi2;
//        this.nofushoTitleTsuki2 = nofushoTitleTsuki2;
//        this.ryoshushoTitleNendo1 = ryoshushoTitleNendo1;
//        this.ryoshushoTitleKi1 = ryoshushoTitleKi1;
//        this.ryoshushoTitleTsuki1 = ryoshushoTitleTsuki1;
//        this.nofushoTitleNendo1 = nofushoTitleNendo1;
//        this.nofushoTitleKi1 = nofushoTitleKi1;
//        this.nofushoTitleTsuki1 = nofushoTitleTsuki1;
//        this.ryoshushoJusho1 = ryoshushoJusho1;
//        this.ryoshushoJusho2 = ryoshushoJusho2;
//        this.nofuzumishoTsuchishoNo1 = nofuzumishoTsuchishoNo1;
//        this.nofuzumishoTsuchishoNo2 = nofuzumishoTsuchishoNo2;
//        this.nofuzumishoOCR11 = nofuzumishoOCR11;
//        this.nofuzumishoOCR12 = nofuzumishoOCR12;
//        this.ryoshushoKatagaki1 = ryoshushoKatagaki1;
//        this.ryoshushoKatagaki2 = ryoshushoKatagaki2;
//        this.nofuzumishoSetaiCode1 = nofuzumishoSetaiCode1;
//        this.nofuzumishoSetaiCode2 = nofuzumishoSetaiCode2;
//        this.nofuzumishoOCR22 = nofuzumishoOCR22;
//        this.nofuzumishoOCR21 = nofuzumishoOCR21;
//        this.ryoshushoHihokenshaName1 = ryoshushoHihokenshaName1;
//        this.nofushoHihokenshaName1 = nofushoHihokenshaName1;
//        this.ryoshushoHihokenshaName2 = ryoshushoHihokenshaName2;
//        this.nofushoHihokenshaName2 = nofushoHihokenshaName2;
//        this.nofuzumishoOCR31 = nofuzumishoOCR31;
//        this.nofuzumishoNokigen1 = nofuzumishoNokigen1;
//        this.nofuzumishoNokigen2 = nofuzumishoNokigen2;
//        this.nofuzumishoOCR32 = nofuzumishoOCR32;
//        this.ryoshushoTsuchishoNo1 = ryoshushoTsuchishoNo1;
//        this.nofushoTsuchishoNo1 = nofushoTsuchishoNo1;
//        this.ryoshushoTsuchishoNo2 = ryoshushoTsuchishoNo2;
//        this.nofushoTsuchishoNo2 = nofushoTsuchishoNo2;
//        this.ryoshushoHokenryoGaku1 = ryoshushoHokenryoGaku1;
//        this.nofushoHokenryoGaku1 = nofushoHokenryoGaku1;
//        this.ryoshushoHokenryoGaku2 = ryoshushoHokenryoGaku2;
//        this.nofushoHokenryoGaku2 = nofushoHokenryoGaku2;
//        this.nofuzumishoNofuGaku1 = nofuzumishoNofuGaku1;
//        this.nofuzumishoNofuGaku2 = nofuzumishoNofuGaku2;
//        this.ryoshushoNokigen1 = ryoshushoNokigen1;
//        this.nofushoNokigen1 = nofushoNokigen1;
//        this.ryoshushoNokigen2 = ryoshushoNokigen2;
//        this.nofushoNokigen2 = nofushoNokigen2;
//        this.nofuzumishoJusho1 = nofuzumishoJusho1;
//        this.nofuzumishoJusho2 = nofuzumishoJusho2;
//        this.nofuzumishoKatagaki1 = nofuzumishoKatagaki1;
//        this.nofuzumishoKatagaki2 = nofuzumishoKatagaki2;
//        this.ryoshushoNofuIn1 = ryoshushoNofuIn1;
//        this.nofushoNofuIn1 = nofushoNofuIn1;
//        this.nofuzumishoNofuIn1 = nofuzumishoNofuIn1;
//        this.ryoshushoNofuIn2 = ryoshushoNofuIn2;
//        this.nofushoNofuIn2 = nofushoNofuIn2;
//        this.nofuzumishoNofuIn2 = nofuzumishoNofuIn2;
//        this.ryoshushoKozaCom1 = ryoshushoKozaCom1;
//        this.nofushoKozaCom1 = nofushoKozaCom1;
//        this.nofuzumishoHihokenshaName1 = nofuzumishoHihokenshaName1;
//        this.nofuzumishoKozaCom1 = nofuzumishoKozaCom1;
//        this.ryoshushoKozaCom2 = ryoshushoKozaCom2;
//        this.nofushoKozaCom2 = nofushoKozaCom2;
//        this.nofuzumishoHihokenshaName2 = nofuzumishoHihokenshaName2;
//        this.nofuzumishoKozaCom2 = nofuzumishoKozaCom2;
//        this.ryoshushoZuiji1 = ryoshushoZuiji1;
//        this.nofushoZuiji1 = nofushoZuiji1;
//        this.nofuzumishoZuiji1 = nofuzumishoZuiji1;
//        this.ryoshushoZuiji2 = ryoshushoZuiji2;
//        this.nofushoZuiji2 = nofushoZuiji2;
//        this.nofuzumishoZuiji2 = nofuzumishoZuiji2;
//        this.nofuzumishoshichosonName1 = nofuzumishoshichosonName1;
//        this.pagerenban1 = pagerenban1;
//        this.nofuzumishoshichosonName2 = nofuzumishoshichosonName2;
//        this.pagerenban2 = pagerenban2;
//        this.nofozumishoTitleNendo3 = nofozumishoTitleNendo3;
//        this.nofuzumishoTitleNendoBun3 = nofuzumishoTitleNendoBun3;
//        this.nofuzumishoTitleKi3 = nofuzumishoTitleKi3;
//        this.nofuzumishoTitleTsuki3 = nofuzumishoTitleTsuki3;
//        this.nofozumishoTitleNendo4 = nofozumishoTitleNendo4;
//        this.nofuzumishoTitleNendoBun4 = nofuzumishoTitleNendoBun4;
//        this.nofuzumishoTitleKi4 = nofuzumishoTitleKi4;
//        this.nofuzumishoTitleTsuki4 = nofuzumishoTitleTsuki4;
//        this.ryoshushoTitleNendo3 = ryoshushoTitleNendo3;
//        this.ryoshushoTitleKi3 = ryoshushoTitleKi3;
//        this.ryoshushoTitleTsuki3 = ryoshushoTitleTsuki3;
//        this.nofushoTitleNendo3 = nofushoTitleNendo3;
//        this.nofushoTitleKi3 = nofushoTitleKi3;
//        this.nofushoTitleTsuki3 = nofushoTitleTsuki3;
//        this.ryoshushoTitleNendo4 = ryoshushoTitleNendo4;
//        this.ryoshushoTitleKi4 = ryoshushoTitleKi4;
//        this.ryoshushoTitleTsuki4 = ryoshushoTitleTsuki4;
//        this.nofushoTitleNendo4 = nofushoTitleNendo4;
//        this.nofushoTitleKi4 = nofushoTitleKi4;
//        this.nofushoTitleTsuki4 = nofushoTitleTsuki4;
//        this.ryoshushoJusho3 = ryoshushoJusho3;
//        this.ryoshushoJusho4 = ryoshushoJusho4;
//        this.nofuzumishoTsuchishoNo3 = nofuzumishoTsuchishoNo3;
//        this.nofuzumishoTsuchishoNo4 = nofuzumishoTsuchishoNo4;
//        this.nofuzumishoOCR13 = nofuzumishoOCR13;
//        this.nofuzumishoOCR14 = nofuzumishoOCR14;
//        this.ryoshushoKatagaki3 = ryoshushoKatagaki3;
//        this.ryoshushoKatagaki4 = ryoshushoKatagaki4;
//        this.nofuzumishoSetaiCode3 = nofuzumishoSetaiCode3;
//        this.nofuzumishoSetaiCode4 = nofuzumishoSetaiCode4;
//        this.nofuzumishoOCR23 = nofuzumishoOCR23;
//        this.nofuzumishoOCR24 = nofuzumishoOCR24;
//        this.ryoshushoHihokenshaName3 = ryoshushoHihokenshaName3;
//        this.nofushoHihokenshaName3 = nofushoHihokenshaName3;
//        this.ryoshushoHihokenshaName4 = ryoshushoHihokenshaName4;
//        this.nofushoHihokenshaName4 = nofushoHihokenshaName4;
//        this.nofuzumishoNokigen3 = nofuzumishoNokigen3;
//        this.nofuzumishoNokigen4 = nofuzumishoNokigen4;
//        this.nofuzumishoOCR33 = nofuzumishoOCR33;
//        this.nofuzumishoOCR34 = nofuzumishoOCR34;
//        this.ryoshushoTsuchishoNo3 = ryoshushoTsuchishoNo3;
//        this.nofushoTsuchishoNo3 = nofushoTsuchishoNo3;
//        this.ryoshushoTsuchishoNo4 = ryoshushoTsuchishoNo4;
//        this.nofushoTsuchishoNo4 = nofushoTsuchishoNo4;
//        this.ryoshushoHokenryoGaku3 = ryoshushoHokenryoGaku3;
//        this.nofushoHokenryoGaku3 = nofushoHokenryoGaku3;
//        this.ryoshushoHokenryoGaku4 = ryoshushoHokenryoGaku4;
//        this.nofushoHokenryoGaku4 = nofushoHokenryoGaku4;
//        this.nofuzumishoNofuGaku3 = nofuzumishoNofuGaku3;
//        this.nofuzumishoNofuGaku4 = nofuzumishoNofuGaku4;
//        this.ryoshushoNokigen3 = ryoshushoNokigen3;
//        this.nofushoNokigen3 = nofushoNokigen3;
//        this.ryoshushoNokigen4 = ryoshushoNokigen4;
//        this.nofushoNokigen4 = nofushoNokigen4;
//        this.nofuzumishoJusho3 = nofuzumishoJusho3;
//        this.nofuzumishoJusho4 = nofuzumishoJusho4;
//        this.nofuzumishoKatagaki3 = nofuzumishoKatagaki3;
//        this.nofuzumishoKatagaki4 = nofuzumishoKatagaki4;
//        this.ryoshushoNofuIn3 = ryoshushoNofuIn3;
//        this.nofushoNofuIn3 = nofushoNofuIn3;
//        this.nofuzumishoNofuIn3 = nofuzumishoNofuIn3;
//        this.ryoshushoNofuIn4 = ryoshushoNofuIn4;
//        this.nofushoNofuIn4 = nofushoNofuIn4;
//        this.nofuzumishoNofuIn4 = nofuzumishoNofuIn4;
//        this.ryoshushoKozaCom3 = ryoshushoKozaCom3;
//        this.nofushoKozaCom3 = nofushoKozaCom3;
//        this.nofuzumishoHihokenshaName3 = nofuzumishoHihokenshaName3;
//        this.nofuzumishoKozaCom3 = nofuzumishoKozaCom3;
//        this.ryoshushoKozaCom4 = ryoshushoKozaCom4;
//        this.nofushoKozaCom4 = nofushoKozaCom4;
//        this.nofuzumishoHihokenshaName4 = nofuzumishoHihokenshaName4;
//        this.nofuzumishoKozaCom4 = nofuzumishoKozaCom4;
//        this.ryoshushoZuiji3 = ryoshushoZuiji3;
//        this.nofushoZuiji3 = nofushoZuiji3;
//        this.nofuzumishoZuiji3 = nofuzumishoZuiji3;
//        this.ryoshushoZuiji4 = ryoshushoZuiji4;
//        this.nofushoZuiji4 = nofushoZuiji4;
//        this.nofuzumishoZuiji4 = nofuzumishoZuiji4;
//        this.eRenban = eRenban;
//        this.ePage = ePage;
//        this.nofuzumishoshichosonName3 = nofuzumishoshichosonName3;
//        this.pagerenban3 = pagerenban3;
//        this.nofuzumishoshichosonName4 = nofuzumishoshichosonName4;
//        this.pagerenban4 = pagerenban4;
//        this.eHokensyaName = eHokensyaName;
//    }
}
