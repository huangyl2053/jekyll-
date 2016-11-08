/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.atenaseal;

import jp.co.ndensan.reams.db.dbz.business.core.atenaseal.AtenaSealReportBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.atenaseal.AtenaSealCreateReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;

/**
 * 宛名シールのEditorです。
 *
 * @reamsid_L DBA-1210-050 zhengsongling
 */
public class AtenaSealEditorImpl implements IAtenaSealEditor {

    private static final Code CODE = Code.EMPTY;
    private static final RString RSTRING = RString.EMPTY;
    private final AtenaSealReportBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business business
     */
    protected AtenaSealEditorImpl(AtenaSealReportBusiness business) {
        this.business = business;
    }

    /**
     * 要介護認定調査票（概況特記）を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public AtenaSealCreateReportSource edit(AtenaSealCreateReportSource source) {
        return editSource(source);
    }

    private AtenaSealCreateReportSource editSource(AtenaSealCreateReportSource source) {
        partOne(source);
        partTwo(source);
        get識別コード(source);
        source.kakkoRight13 = business.getKakkoRight13();
        source.samabunShimeiSmall13 = business.getSamabunShimeiSmall13();
        source.samaBun15 = business.getSamaBun15();
        source.samabunShimei15 = business.getSamabunShimei15();
        source.samaBun13 = business.getSamaBun13();
        source.samabunShimei13 = business.getSamabunShimei13();
        source.yubinNo9 = business.getYubinNo9();
        source.gyoseiku9 = business.getGyoseiku9();
        source.yubinNo8 = business.getYubinNo8();
        source.gyoseiku8 = business.getGyoseiku8();
        source.jushoText9 = business.getJushoText9();
        source.jushoText8 = business.getJushoText8();
        source.jusho30 = business.getJusho30();
        source.jusho27 = business.getJusho27();
        source.jusho28 = business.getJusho28();
        source.jusho25 = business.getJusho25();
        source.jusho29 = business.getJusho29();
        source.jusho26 = business.getJusho26();
        source.katagakiText9 = business.getKatagakiText9();
        source.katagakiText8 = business.getKatagakiText8();
        source.katagaki20 = business.getKatagaki20();
        source.katagakiSmall20 = business.getKatagakiSmall20();
        source.katagaki18 = business.getKatagaki18();
        source.katagakiSmall18 = business.getKatagakiSmall18();
        source.katagakiSmall19 = business.getKatagakiSmall19();
        source.katagakiSmall17 = business.getKatagakiSmall17();
        source.katagaki19 = business.getKatagaki19();
        source.katagaki17 = business.getKatagaki17();
        source.dainoKubunMei9 = business.getDainoKubunMei9();
        source.dainoKubunMei8 = business.getDainoKubunMei8();
        source.shimeiSmall18 = business.getShimeiSmall18();
        source.shimei20 = business.getShimei20();
        source.meishoFuyo20 = business.getMeishoFuyo20();
        source.shimei18 = business.getShimei18();
        source.meishoFuyo18 = business.getMeishoFuyo18();
        source.shimeiText9 = business.getShimeiText9();
        source.shimeiText8 = business.getShimeiText8();
        source.shimeiSmall20 = business.getShimeiSmall20();
        source.shimei19 = business.getShimei19();
        source.meishoFuyo19 = business.getMeishoFuyo19();
        source.shimeiSmall19 = business.getShimeiSmall19();
        source.shimei17 = business.getShimei17();
        source.meishoFuyo17 = business.getMeishoFuyo17();
        source.shimeiSmall17 = business.getShimeiSmall17();
        source.samabunShimeiText9 = business.getSamabunShimeiText9();
        source.samabunShimeiSmall20 = business.getSamabunShimeiSmall20();
        source.samabunShimei20 = business.getSamabunShimei20();
        source.kakkoLeft20 = business.getKakkoLeft20();
        source.samaBun20 = business.getSamaBun20();
        source.kakkoRight20 = business.getKakkoRight20();
        source.samabunShimeiText8 = business.getSamabunShimeiText8();
        source.samabunShimeiSmall18 = business.getSamabunShimeiSmall18();
        source.kakkoLeft18 = business.getKakkoLeft18();
        source.samabunShimei18 = business.getSamabunShimei18();
        source.samaBun18 = business.getSamaBun18();
        source.kakkoRight18 = business.getKakkoRight18();
        source.kakkoLeft19 = business.getKakkoLeft19();
        source.kakkoRight19 = business.getKakkoRight19();
        source.samabunShimeiSmall19 = business.getSamabunShimeiSmall19();
        source.kakkoLeft17 = business.getKakkoLeft17();
        source.kakkoRight17 = business.getKakkoRight17();
        source.samabunShimeiSmall17 = business.getSamabunShimeiSmall17();
        source.samaBun19 = business.getSamaBun19();
        source.samaBun17 = business.getSamaBun17();
        source.samabunShimei19 = business.getSamabunShimei19();
        source.samabunShimei17 = business.getSamabunShimei17();
        source.yubinNo11 = business.getYubinNo11();
        source.gyoseiku11 = business.getGyoseiku11();
        source.yubinNo10 = business.getYubinNo10();
        source.gyoseiku10 = business.getGyoseiku10();
        source.jushoText11 = business.getJushoText11();
        source.jushoText10 = business.getJushoText10();
        source.jusho36 = business.getJusho36();
        source.jusho33 = business.getJusho33();
        source.jusho34 = business.getJusho34();
        source.jusho31 = business.getJusho31();
        source.jusho35 = business.getJusho35();
        source.jusho32 = business.getJusho32();
        source.katagakiText11 = business.getKatagakiText11();
        source.katagakiText10 = business.getKatagakiText10();
        source.katagaki24 = business.getKatagaki24();
        source.katagakiSmall24 = business.getKatagakiSmall24();
        source.katagaki22 = business.getKatagaki22();
        source.katagakiSmall22 = business.getKatagakiSmall22();
        source.katagakiSmall23 = business.getKatagakiSmall23();
        source.katagakiSmall21 = business.getKatagakiSmall21();
        source.katagaki23 = business.getKatagaki23();
        source.katagaki21 = business.getKatagaki21();
        source.dainoKubunMei11 = business.getDainoKubunMei11();
        source.dainoKubunMei10 = business.getDainoKubunMei10();
        source.shimeiSmall22 = business.getShimeiSmall22();
        source.shimei24 = business.getShimei24();
        source.meishoFuyo24 = business.getMeishoFuyo24();
        source.shimei22 = business.getShimei22();
        source.meishoFuyo22 = business.getMeishoFuyo22();
        source.shimeiText11 = business.getShimeiText11();
        source.shimeiText10 = business.getShimeiText10();
        source.shimeiSmall24 = business.getShimeiSmall24();
        source.shimei23 = business.getShimei23();
        source.meishoFuyo23 = business.getMeishoFuyo23();
        source.shimeiSmall23 = business.getShimeiSmall23();
        source.shimei21 = business.getShimei21();
        source.meishoFuyo21 = business.getMeishoFuyo21();
        source.shimeiSmall21 = business.getShimeiSmall21();
        source.samabunShimeiText11 = business.getSamabunShimeiText11();
        source.samabunShimeiSmall24 = business.getSamabunShimeiSmall24();
        source.samabunShimei24 = business.getSamabunShimei24();
        source.kakkoLeft24 = business.getKakkoLeft24();
        source.samaBun24 = business.getSamaBun24();
        source.kakkoRight24 = business.getKakkoRight24();
        source.samabunShimeiText10 = business.getSamabunShimeiText10();
        source.samabunShimeiSmall22 = business.getSamabunShimeiSmall22();
        source.kakkoLeft22 = business.getKakkoLeft22();
        source.samabunShimei22 = business.getSamabunShimei22();
        source.samaBun22 = business.getSamaBun22();
        source.kakkoRight22 = business.getKakkoRight22();
        source.kakkoLeft23 = business.getKakkoLeft23();
        source.kakkoRight23 = business.getKakkoRight23();
        source.samabunShimeiSmall23 = business.getSamabunShimeiSmall23();
        source.kakkoLeft21 = business.getKakkoLeft21();
        source.kakkoRight21 = business.getKakkoRight21();
        source.samabunShimeiSmall21 = business.getSamabunShimeiSmall21();
        source.samaBun23 = business.getSamaBun23();
        source.samaBun21 = business.getSamaBun21();
        source.samabunShimei23 = business.getSamabunShimei23();
        source.samabunShimei21 = business.getSamabunShimei21();
        return source;
    }

    private void partOne(AtenaSealCreateReportSource source) {
        source.shichosonCode = business.getShichosonCode();
        source.shichosonName = business.getShichosonName();
        source.title = business.getTitle();
        source.printTimeStamp = business.getPrintTimeStamp();
        source.yubinNo1 = business.getYubinNo1();
        source.gyoseiku1 = business.getGyoseiku1();
        source.yubinNo = business.getYubinNo();
        source.gyoseiku = business.getGyoseiku();
        source.jushoText1 = business.getJushoText1();
        source.jushoText = business.getJushoText();
        source.jusho6 = business.getJusho6();
        source.jusho3 = business.getJusho3();
        source.jusho4 = business.getJusho4();
        source.jusho1 = business.getJusho1();
        source.jusho5 = business.getJusho5();
        source.jusho2 = business.getJusho2();
        source.katagakiText1 = business.getKatagakiText1();
        source.katagakiText = business.getKatagakiText();
        source.katagaki4 = business.getKatagaki4();
        source.katagakiSmall4 = business.getKatagakiSmall4();
        source.katagaki2 = business.getKatagaki2();
        source.katagakiSmall2 = business.getKatagakiSmall2();
        source.katagakiSmall3 = business.getKatagakiSmall3();
        source.katagakiSmall1 = business.getKatagakiSmall1();
        source.katagaki3 = business.getKatagaki3();
        source.katagaki1 = business.getKatagaki1();
        source.dainoKubunMei1 = business.getDainoKubunMei1();
        source.dainoKubunMei = business.getDainoKubunMei();
        source.shimeiSmall2 = business.getShimeiSmall2();
        source.shimei4 = business.getShimei4();
        source.meishoFuyo4 = business.getMeishoFuyo4();
        source.shimei2 = business.getShimei2();
        source.meishoFuyo2 = business.getMeishoFuyo2();
        source.shimeiText1 = business.getShimeiText1();
        source.shimeiText = business.getShimeiText();
        source.shimeiSmall4 = business.getShimeiSmall4();
        source.shimei3 = business.getShimei3();
        source.meishoFuyo3 = business.getMeishoFuyo3();
        source.shimeiSmall3 = business.getShimeiSmall3();
        source.shimei1 = business.getShimei1();
        source.meishoFuyo1 = business.getMeishoFuyo1();
        source.shimeiSmall1 = business.getShimeiSmall1();
        source.samabunShimeiText1 = business.getSamabunShimeiText1();
        source.samabunShimeiSmall4 = business.getSamabunShimeiSmall4();
        source.kakkoLeft4 = business.getKakkoLeft4();
        source.samabunShimei4 = business.getSamabunShimei4();
        source.samaBun4 = business.getSamaBun4();
        source.kakkoRight4 = business.getKakkoRight4();
        source.samabunShimeiText = business.getSamabunShimeiText();
        source.samabunShimeiSmall2 = business.getSamabunShimeiSmall2();
        source.kakkoLeft2 = business.getKakkoLeft2();
        source.samabunShimei2 = business.getSamabunShimei2();
        source.samaBun2 = business.getSamaBun2();
        source.kakkoRight2 = business.getKakkoRight2();
        source.kakkoLeft3 = business.getKakkoLeft3();
        source.kakkoRight3 = business.getKakkoRight3();
        source.samabunShimeiSmall3 = business.getSamabunShimeiSmall3();
        source.kakkoLeft1 = business.getKakkoLeft1();
        source.kakkoRight1 = business.getKakkoRight1();
        source.samabunShimeiSmall1 = business.getSamabunShimeiSmall1();
        source.samaBun3 = business.getSamaBun3();
        source.samabunShimei3 = business.getSamabunShimei3();
        source.samaBun1 = business.getSamaBun1();
        source.samabunShimei1 = business.getSamabunShimei1();
        source.拡張情報 = new ExpandedInformation(CODE, RSTRING, RSTRING);
        CustomerBarCode barcode = new CustomerBarCode();
        source.customerBarCode = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo()),
                nullToEmpty(business.get住所())).getCustomerBarCode();
        source.customerBarCode1 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo1()),
                nullToEmpty(business.get住所1())).getCustomerBarCode();
        source.customerBarCode2 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo2()),
                nullToEmpty(business.get住所2())).getCustomerBarCode();
        source.customerBarCode3 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo3()),
                nullToEmpty(business.get住所3())).getCustomerBarCode();
        source.customerBarCode4 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo4()),
                nullToEmpty(business.get住所4())).getCustomerBarCode();
        source.customerBarCode5 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo5()),
                nullToEmpty(business.get住所5())).getCustomerBarCode();
        source.customerBarCode6 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo6()),
                nullToEmpty(business.get住所6())).getCustomerBarCode();
        source.customerBarCode7 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo7()),
                nullToEmpty(business.get住所7())).getCustomerBarCode();
        source.customerBarCode8 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo8()),
                nullToEmpty(business.get住所8())).getCustomerBarCode();
        source.customerBarCode9 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo9()),
                nullToEmpty(business.get住所9())).getCustomerBarCode();
        source.customerBarCode10 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo10()),
                nullToEmpty(business.get住所10())).getCustomerBarCode();
        source.customerBarCode11 = barcode.convertCustomerBarCode(nullToEmpty(business.getYubinNo11()),
                nullToEmpty(business.get住所11())).getCustomerBarCode();
        source.jusho20 = business.getJusho20();
        source.katagakiText7 = business.getKatagakiText7();
        source.katagakiText6 = business.getKatagakiText6();
        source.katagaki16 = business.getKatagaki16();
        source.katagakiSmall16 = business.getKatagakiSmall16();
        source.katagaki14 = business.getKatagaki14();
        source.katagakiSmall14 = business.getKatagakiSmall14();
        source.katagakiSmall15 = business.getKatagakiSmall15();
        source.katagakiSmall13 = business.getKatagakiSmall13();
        source.katagaki15 = business.getKatagaki15();
        source.katagaki13 = business.getKatagaki13();
        source.dainoKubunMei7 = business.getDainoKubunMei7();
        source.dainoKubunMei6 = business.getDainoKubunMei6();
        source.shimeiSmall14 = business.getShimeiSmall14();
        source.shimei16 = business.getShimei16();
        source.meishoFuyo16 = business.getMeishoFuyo16();
        source.shimei14 = business.getShimei14();
        source.meishoFuyo14 = business.getMeishoFuyo14();
        source.shimeiText7 = business.getShimeiText7();
        source.shimeiText6 = business.getShimeiText6();
        source.shimeiSmall16 = business.getShimeiSmall16();
        source.shimei15 = business.getShimei15();
        source.meishoFuyo15 = business.getMeishoFuyo15();
        source.shimeiSmall15 = business.getShimeiSmall15();
        source.shimei13 = business.getShimei13();
        source.meishoFuyo13 = business.getMeishoFuyo13();
        source.shimeiSmall13 = business.getShimeiSmall13();
        source.samabunShimeiText7 = business.getSamabunShimeiText7();
        source.samabunShimeiSmall16 = business.getSamabunShimeiSmall16();
        source.samabunShimei16 = business.getSamabunShimei16();
        source.samaBun16 = business.getSamaBun16();
        source.kakkoRight16 = business.getKakkoRight16();
        source.samabunShimeiText6 = business.getSamabunShimeiText6();
        source.kakkoLeft16 = business.getKakkoLeft16();
        source.samabunShimeiSmall14 = business.getSamabunShimeiSmall14();
        source.samabunShimei14 = business.getSamabunShimei14();
        source.kakkoLeft14 = business.getKakkoLeft14();
        source.samaBun14 = business.getSamaBun14();
        source.kakkoRight14 = business.getKakkoRight14();
        source.kakkoLeft15 = business.getKakkoLeft15();
        source.kakkoRight15 = business.getKakkoRight15();
        source.samabunShimeiSmall15 = business.getSamabunShimeiSmall15();
        source.kakkoLeft13 = business.getKakkoLeft13();
    }

    private void partTwo(AtenaSealCreateReportSource source) {
        source.yubinNo3 = business.getYubinNo3();
        source.gyoseiku3 = business.getGyoseiku3();
        source.yubinNo2 = business.getYubinNo2();
        source.gyoseiku2 = business.getGyoseiku2();
        source.jushoText3 = business.getJushoText3();
        source.jushoText2 = business.getJushoText2();
        source.jusho12 = business.getJusho12();
        source.jusho9 = business.getJusho9();
        source.jusho10 = business.getJusho10();
        source.jusho7 = business.getJusho7();
        source.jusho11 = business.getJusho11();
        source.jusho8 = business.getJusho8();
        source.katagakiText3 = business.getKatagakiText3();
        source.katagakiText2 = business.getKatagakiText2();
        source.katagaki8 = business.getKatagaki8();
        source.katagakiSmall8 = business.getKatagakiSmall8();
        source.katagaki6 = business.getKatagaki6();
        source.katagakiSmall6 = business.getKatagakiSmall6();
        source.katagakiSmall7 = business.getKatagakiSmall7();
        source.katagakiSmall5 = business.getKatagakiSmall5();
        source.katagaki7 = business.getKatagaki7();
        source.katagaki5 = business.getKatagaki5();
        source.dainoKubunMei3 = business.getDainoKubunMei3();
        source.dainoKubunMei2 = business.getDainoKubunMei2();
        source.shimeiSmall6 = business.getShimeiSmall6();
        source.shimei8 = business.getShimei8();
        source.meishoFuyo8 = business.getMeishoFuyo8();
        source.shimei6 = business.getShimei6();
        source.meishoFuyo6 = business.getMeishoFuyo6();
        source.shimeiText3 = business.getShimeiText3();
        source.shimeiText2 = business.getShimeiText2();
        source.shimeiSmall8 = business.getShimeiSmall8();
        source.shimei7 = business.getShimei7();
        source.meishoFuyo7 = business.getMeishoFuyo7();
        source.shimeiSmall7 = business.getShimeiSmall7();
        source.shimei5 = business.getShimei5();
        source.meishoFuyo5 = business.getMeishoFuyo5();
        source.shimeiSmall5 = business.getShimeiSmall5();
        source.samabunShimeiText3 = business.getSamabunShimeiText3();
        source.samabunShimeiSmall8 = business.getSamabunShimeiSmall8();
        source.kakkoLeft8 = business.getKakkoLeft8();
        source.samabunShimei8 = business.getSamabunShimei8();
        source.samaBun8 = business.getSamaBun8();
        source.kakkoRight8 = business.getKakkoRight8();
        source.samabunShimeiText2 = business.getSamabunShimeiText2();
        source.samabunShimeiSmall6 = business.getSamabunShimeiSmall6();
        source.kakkoLeft6 = business.getKakkoLeft6();
        source.samabunShimei6 = business.getSamabunShimei6();
        source.samaBun6 = business.getSamaBun6();
        source.kakkoRight6 = business.getKakkoRight6();
        source.kakkoLeft7 = business.getKakkoLeft7();
        source.kakkoRight7 = business.getKakkoRight7();
        source.samabunShimeiSmall7 = business.getSamabunShimeiSmall7();
        source.kakkoLeft5 = business.getKakkoLeft5();
        source.kakkoRight5 = business.getKakkoRight5();
        source.samabunShimeiSmall5 = business.getSamabunShimeiSmall5();
        source.samaBun7 = business.getSamaBun7();
        source.samaBun5 = business.getSamaBun5();
        source.samabunShimei7 = business.getSamabunShimei7();
        source.samabunShimei5 = business.getSamabunShimei5();
        source.yubinNo5 = business.getYubinNo5();
        source.gyoseiku5 = business.getGyoseiku5();
        source.yubinNo4 = business.getYubinNo4();
        source.gyoseiku4 = business.getGyoseiku4();
        source.jushoText5 = business.getJushoText5();
        source.jushoText4 = business.getJushoText4();
        source.jusho18 = business.getJusho18();
        source.jusho15 = business.getJusho15();
        source.jusho16 = business.getJusho16();
        source.jusho13 = business.getJusho13();
        source.jusho17 = business.getJusho17();
        source.jusho14 = business.getJusho14();
        source.katagakiText5 = business.getKatagakiText5();
        source.katagakiText4 = business.getKatagakiText4();
        source.katagaki12 = business.getKatagaki12();
        source.katagakiSmall12 = business.getKatagakiSmall12();
        source.katagaki10 = business.getKatagaki10();
        source.katagakiSmall10 = business.getKatagakiSmall10();
        source.katagakiSmall11 = business.getKatagakiSmall11();
        source.katagakiSmall9 = business.getKatagakiSmall9();
        source.katagaki11 = business.getKatagaki11();
        source.katagaki9 = business.getKatagaki9();
        source.dainoKubunMei5 = business.getDainoKubunMei5();
        source.dainoKubunMei4 = business.getDainoKubunMei4();
        source.shimeiSmall10 = business.getShimeiSmall10();
        source.shimei12 = business.getShimei12();
        source.meishoFuyo12 = business.getMeishoFuyo12();
        source.shimei10 = business.getShimei10();
        source.meishoFuyo10 = business.getMeishoFuyo10();
        source.shimeiText5 = business.getShimeiText5();
        source.shimeiText4 = business.getShimeiText4();
        source.shimeiSmall12 = business.getShimeiSmall12();
        source.shimei11 = business.getShimei11();
        source.meishoFuyo11 = business.getMeishoFuyo11();
        source.shimeiSmall11 = business.getShimeiSmall11();
        source.shimei9 = business.getShimei9();
        source.meishoFuyo9 = business.getMeishoFuyo9();
        source.shimeiSmall9 = business.getShimeiSmall9();
        source.kakkoLeft12 = business.getKakkoLeft12();
        source.samabunShimeiText5 = business.getSamabunShimeiText5();
        source.kakkoLeft10 = business.getKakkoLeft10();
        source.samabunShimeiSmall12 = business.getSamabunShimeiSmall12();
        source.samabunShimei12 = business.getSamabunShimei12();
        source.samaBun12 = business.getSamaBun12();
        source.kakkoRight12 = business.getKakkoRight12();
        source.samabunShimeiText4 = business.getSamabunShimeiText4();
        source.samabunShimeiSmall10 = business.getSamabunShimeiSmall10();
        source.samabunShimei10 = business.getSamabunShimei10();
        source.samaBun10 = business.getSamaBun10();
        source.kakkoRight10 = business.getKakkoRight10();
        source.kakkoLeft9 = business.getKakkoLeft9();
        source.kakkoLeft11 = business.getKakkoLeft11();
        source.kakkoRight11 = business.getKakkoRight11();
        source.samabunShimeiSmall11 = business.getSamabunShimeiSmall11();
        source.samabunShimeiSmall9 = business.getSamabunShimeiSmall9();
        source.kakkoRight9 = business.getKakkoRight9();
        source.samaBun11 = business.getSamaBun11();
        source.samabunShimei11 = business.getSamabunShimei11();
        source.samaBun9 = business.getSamaBun9();
        source.samabunShimei9 = business.getSamabunShimei9();
        source.yubinNo7 = business.getYubinNo7();
        source.gyoseiku7 = business.getGyoseiku7();
        source.yubinNo6 = business.getYubinNo6();
        source.gyoseiku6 = business.getGyoseiku6();
        source.jushoText7 = business.getJushoText7();
        source.jushoText6 = business.getJushoText6();
        source.jusho24 = business.getJusho24();
        source.jusho21 = business.getJusho21();
        source.jusho22 = business.getJusho22();
        source.jusho19 = business.getJusho19();
        source.jusho23 = business.getJusho23();
    }

    private void get識別コード(AtenaSealCreateReportSource source) {
        if (!RString.isNullOrEmpty(business.get識別コード1())) {
            source.識別コード1 = new ShikibetsuCode(business.get識別コード1());
        }
        if (!RString.isNullOrEmpty(business.get識別コード2())) {
            source.識別コード2 = new ShikibetsuCode(business.get識別コード2());
        }
        if (!RString.isNullOrEmpty(business.get識別コード3())) {
            source.識別コード3 = new ShikibetsuCode(business.get識別コード3());
        }
        if (!RString.isNullOrEmpty(business.get識別コード4())) {
            source.識別コード4 = new ShikibetsuCode(business.get識別コード4());
        }
        if (!RString.isNullOrEmpty(business.get識別コード5())) {
            source.識別コード5 = new ShikibetsuCode(business.get識別コード5());
        }
        if (!RString.isNullOrEmpty(business.get識別コード6())) {
            source.識別コード6 = new ShikibetsuCode(business.get識別コード6());
        }
        if (!RString.isNullOrEmpty(business.get識別コード7())) {
            source.識別コード7 = new ShikibetsuCode(business.get識別コード7());
        }
        if (!RString.isNullOrEmpty(business.get識別コード8())) {
            source.識別コード8 = new ShikibetsuCode(business.get識別コード8());
        }
        if (!RString.isNullOrEmpty(business.get識別コード9())) {
            source.識別コード9 = new ShikibetsuCode(business.get識別コード9());
        }
        if (!RString.isNullOrEmpty(business.get識別コード10())) {
            source.識別コード10 = new ShikibetsuCode(business.get識別コード10());
        }
        if (!RString.isNullOrEmpty(business.get識別コード11())) {
            source.識別コード11 = new ShikibetsuCode(business.get識別コード11());
        }
        if (!RString.isNullOrEmpty(business.get識別コード12())) {
            source.識別コード12 = new ShikibetsuCode(business.get識別コード12());
        }
    }

    private RString nullToEmpty(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        }
        return value;
    }
}
