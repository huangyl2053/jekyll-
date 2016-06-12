package jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 事務局用予備判定記入表Sourceクラスです。
 *
 * @reamsid_L DBE-0150-100 wangrenze
 */
public class JimukyokuyoYobihanteiKinyuhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sinsa1", length = 40, order = 1)
    public RString sinsa1;
    @ReportItem(name = "sinsa5", length = 40, order = 2)
    public RString sinsa5;
    @ReportItem(name = "sinsa2", length = 40, order = 3)
    public RString sinsa2;
    @ReportItem(name = "sinsa6", length = 40, order = 4)
    public RString sinsa6;
    @ReportItem(name = "sinsa3", length = 40, order = 5)
    public RString sinsa3;
    @ReportItem(name = "sinsa7", length = 40, order = 6)
    public RString sinsa7;
    @ReportItem(name = "sinsa4", length = 40, order = 7)
    public RString sinsa4;
    @ReportItem(name = "sinsa8", length = 40, order = 8)
    public RString sinsa8;
    @ReportItem(name = "dtashinsaNo", length = 15, order = 9)
    public RString dtashinsaNo;
    @ReportItem(name = "dtagogitaiNo", length = 4, order = 10)
    public RString dtagogitaiNo;
    @ReportItem(name = "dtahokenname", length = 50, order = 11)
    public RString dtahokenname;
    @ReportItem(name = "dtajStDate", length = 11, order = 12)
    public RString dtajStDate;
    @ReportItem(name = "shinsakaiKaisaiNo", length = 4, order = 13)
    public RString shinsakaiKaisaiNo;
    @ReportItem(name = "kaisaiYMD", length = 10, order = 14)
    public RString kaisaiYMD;
    @ReportItem(name = "kaisaiHH", length = 2, order = 15)
    public RString kaisaiHH;
    @ReportItem(name = "kaisaiMM", length = 2, order = 16)
    public RString kaisaiMM;
    @ReportItem(name = "gogitaiName", length = 20, order = 17)
    public RString gogitaiName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 18)
    public RString printTimeStamp;
    @ReportItem(name = "dtasDate1", length = 10, order = 19)
    public RString dtasDate1;
    @ReportItem(name = "dtaktime1", length = 5, order = 20)
    public RString dtaktime1;
    @ReportItem(name = "dtaninteikikanymd1", length = 23, order = 21)
    public RString dtaninteikikanymd1;
    @ReportItem(name = "dtazenn1Hantei1", length = 6, order = 22)
    public RString dtazenn1Hantei1;
    @ReportItem(name = "dtazenninteikikanymd1", length = 23, order = 23)
    public RString dtazenninteikikanymd1;
    @ReportItem(name = "dtasKanrino1", length = 20, order = 24)
    public RString dtasKanrino1;
    @ReportItem(name = "listTokuteiShippeiCode_1", length = 2, order = 25)
    public RString listTokuteiShippeiCode_1;
    @ReportItem(name = "listHokenshaName_1", length = 10, order = 26)
    public RString listHokenshaName_1;
    @ReportItem(name = "dtashinsaIken1", length = 200, order = 27)
    public RString dtashinsaIken1;
    @ReportItem(name = "listNo_1", length = 3, order = 28)
    public RString listNo_1;
    @ReportItem(name = "listTaishoshaIchiran_1", length = 10, order = 29)
    public RString listTaishoshaIchiran_1;
    @ReportItem(name = "listTaishoshaIchiran_2", length = 200, order = 30)
    public RString listTaishoshaIchiran_2;
    @ReportItem(name = "listTaishoshaIchiran_3", length = 1, order = 31)
    public RString listTaishoshaIchiran_3;
    @ReportItem(name = "listTaishoshaIchiran_4", length = 3, order = 32)
    public RString listTaishoshaIchiran_4;
    @ReportItem(name = "listTaishoshaIchiran_5", length = 6, order = 33)
    public RString listTaishoshaIchiran_5;
    @ReportItem(name = "listTaishoshaIchiran_6", length = 5, order = 34)
    public RString listTaishoshaIchiran_6;
    @ReportItem(name = "listTaishoshaIchiran_7", length = 6, order = 35)
    public RString listTaishoshaIchiran_7;
    @ReportItem(name = "listTaishoshaIchiran_8", length = 6, order = 36)
    public RString listTaishoshaIchiran_8;
    @ReportItem(name = "listTaishoshaIchiran_9", length = 2, order = 37)
    public RString listTaishoshaIchiran_9;
    @ReportItem(name = "listTaishoshaIchiran_10", length = 5, order = 38)
    public RString listTaishoshaIchiran_10;
    @ReportItem(name = "listIchijihanteiKeikokuCode_1", length = 2, order = 39)
    public RString listIchijihanteiKeikokuCode_1;
    @ReportItem(name = "dtasDate2", length = 10, order = 40)
    public RString dtasDate2;
    @ReportItem(name = "listTokuteiShippeiName_1", length = 35, order = 41)
    public RString listTokuteiShippeiName_1;
    @ReportItem(name = "listShinseiKubun_1", length = 6, order = 42)
    public RString listShinseiKubun_1;
    @ReportItem(name = "dtaktime2", length = 5, order = 43)
    public RString dtaktime2;
    @ReportItem(name = "dtazenn1Hantei2", length = 6, order = 44)
    public RString dtazenn1Hantei2;
    @ReportItem(name = "dtaninteikikanymd2", length = 23, order = 45)
    public RString dtaninteikikanymd2;
    @ReportItem(name = "dtazenninteikikanymd2", length = 23, order = 46)
    public RString dtazenninteikikanymd2;
    @ReportItem(name = "dtasKanrino2", length = 20, order = 47)
    public RString dtasKanrino2;
    @ReportItem(name = "dtashinsaIken2", length = 200, order = 48)
    public RString dtashinsaIken2;
    @ReportItem(name = "dtasDate3", length = 10, order = 49)
    public RString dtasDate3;
    @ReportItem(name = "dtah2Rcode1", length = 2, order = 50)
    public RString dtah2Rcode1;
    @ReportItem(name = "dtaktime3", length = 5, order = 51)
    public RString dtaktime3;
    @ReportItem(name = "dtaninteikikanymd3", length = 23, order = 52)
    public RString dtaninteikikanymd3;
    @ReportItem(name = "dtazenn1Hantei3", length = 6, order = 53)
    public RString dtazenn1Hantei3;
    @ReportItem(name = "dtazenninteikikanymd3", length = 23, order = 54)
    public RString dtazenninteikikanymd3;
    @ReportItem(name = "dtasKanrino3", length = 20, order = 55)
    public RString dtasKanrino3;
    @ReportItem(name = "dtashinsaIken3", length = 200, order = 56)
    public RString dtashinsaIken3;
    @ReportItem(name = "dtasDate4", length = 10, order = 57)
    public RString dtasDate4;
    @ReportItem(name = "dtah2Rcode2", length = 2, order = 58)
    public RString dtah2Rcode2;
    @ReportItem(name = "dtaktime4", length = 5, order = 59)
    public RString dtaktime4;
    @ReportItem(name = "dtaninteikikanymd4", length = 23, order = 60)
    public RString dtaninteikikanymd4;
    @ReportItem(name = "dtazenn1Hantei4", length = 6, order = 61)
    public RString dtazenn1Hantei4;
    @ReportItem(name = "dtazenninteikikanymd4", length = 23, order = 62)
    public RString dtazenninteikikanymd4;
    @ReportItem(name = "dtasKanrino4", length = 20, order = 63)
    public RString dtasKanrino4;
    @ReportItem(name = "dtah2Rcode3", length = 2, order = 64)
    public RString dtah2Rcode3;
    @ReportItem(name = "dtashinsaIken4", length = 200, order = 65)
    public RString dtashinsaIken4;
    @ReportItem(name = "dtasDate5", length = 10, order = 66)
    public RString dtasDate5;
    @ReportItem(name = "dtaktime5", length = 5, order = 67)
    public RString dtaktime5;
    @ReportItem(name = "dtazenn1Hantei5", length = 6, order = 68)
    public RString dtazenn1Hantei5;
    @ReportItem(name = "dtaninteikikanymd5", length = 23, order = 69)
    public RString dtaninteikikanymd5;
    @ReportItem(name = "dtazenninteikikanymd5", length = 23, order = 70)
    public RString dtazenninteikikanymd5;
    @ReportItem(name = "dtasKanrino5", length = 20, order = 71)
    public RString dtasKanrino5;
    @ReportItem(name = "dtah2Rcode4", length = 2, order = 72)
    public RString dtah2Rcode4;
    @ReportItem(name = "dtashinsaIken5", length = 200, order = 73)
    public RString dtashinsaIken5;
    @ReportItem(name = "dtasDate6", length = 10, order = 74)
    public RString dtasDate6;
    @ReportItem(name = "dtaktime6", length = 5, order = 75)
    public RString dtaktime6;
    @ReportItem(name = "dtaninteikikanymd6", length = 23, order = 76)
    public RString dtaninteikikanymd6;
    @ReportItem(name = "dtazenn1Hantei6", length = 6, order = 77)
    public RString dtazenn1Hantei6;
    @ReportItem(name = "dtazenninteikikanymd6", length = 23, order = 78)
    public RString dtazenninteikikanymd6;
    @ReportItem(name = "dtasKanrino6", length = 20, order = 79)
    public RString dtasKanrino6;
    @ReportItem(name = "dtah2Rcode5", length = 2, order = 80)
    public RString dtah2Rcode5;
    @ReportItem(name = "dtashinsaIken6", length = 200, order = 81)
    public RString dtashinsaIken6;
    @ReportItem(name = "dtasDate7", length = 10, order = 82)
    public RString dtasDate7;
    @ReportItem(name = "dtaktime7", length = 5, order = 83)
    public RString dtaktime7;
    @ReportItem(name = "dtazenn1Hantei7", length = 6, order = 84)
    public RString dtazenn1Hantei7;
    @ReportItem(name = "dtaninteikikanymd7", length = 23, order = 85)
    public RString dtaninteikikanymd7;
    @ReportItem(name = "dtazenninteikikanymd7", length = 23, order = 86)
    public RString dtazenninteikikanymd7;
    @ReportItem(name = "dtah2Rcode6", length = 2, order = 87)
    public RString dtah2Rcode6;
    @ReportItem(name = "dtasKanrino7", length = 20, order = 88)
    public RString dtasKanrino7;
    @ReportItem(name = "dtashinsaIken7", length = 200, order = 89)
    public RString dtashinsaIken7;
    @ReportItem(name = "dtasDate8", length = 10, order = 90)
    public RString dtasDate8;
    @ReportItem(name = "dtaktime8", length = 5, order = 91)
    public RString dtaktime8;
    @ReportItem(name = "dtaninteikikanymd8", length = 23, order = 92)
    public RString dtaninteikikanymd8;
    @ReportItem(name = "dtazenn1Hantei8", length = 6, order = 93)
    public RString dtazenn1Hantei8;
    @ReportItem(name = "dtazenninteikikanymd8", length = 23, order = 94)
    public RString dtazenninteikikanymd8;
    @ReportItem(name = "dtah2Rcode7", length = 2, order = 95)
    public RString dtah2Rcode7;
    @ReportItem(name = "dtasKanrino8", length = 20, order = 96)
    public RString dtasKanrino8;
    @ReportItem(name = "dtashinsaIken8", length = 200, order = 97)
    public RString dtashinsaIken8;
    @ReportItem(name = "dtasDate9", length = 10, order = 98)
    public RString dtasDate9;
    @ReportItem(name = "dtaktime9", length = 5, order = 99)
    public RString dtaktime9;
    @ReportItem(name = "dtah2Rcode8", length = 2, order = 100)
    public RString dtah2Rcode8;
    @ReportItem(name = "dtazenn1Hantei9", length = 6, order = 101)
    public RString dtazenn1Hantei9;
    @ReportItem(name = "dtaninteikikanymd9", length = 23, order = 102)
    public RString dtaninteikikanymd9;
    @ReportItem(name = "dtazenninteikikanymd9", length = 23, order = 103)
    public RString dtazenninteikikanymd9;
    @ReportItem(name = "dtasKanrino9", length = 20, order = 104)
    public RString dtasKanrino9;
    @ReportItem(name = "dtashinsaIken9", length = 200, order = 105)
    public RString dtashinsaIken9;
    @ReportItem(name = "dtah2Rcode9", length = 2, order = 106)
    public RString dtah2Rcode9;
    @ReportItem(name = "dtah2Rcode10", length = 2, order = 107)
    public RString dtah2Rcode10;
    @ReportItem(name = "dtashinsain", length = 40, order = 108)
    public RString dtashinsain;
    @ReportItem(name = "dtasDate10", length = 10, order = 109)
    public RString dtasDate10;
    @ReportItem(name = "dtaktime10", length = 5, order = 110)
    public RString dtaktime10;
    @ReportItem(name = "dtazenn1Hantei10", length = 6, order = 111)
    public RString dtazenn1Hantei10;
    @ReportItem(name = "dtaninteikikanymd10", length = 23, order = 112)
    public RString dtaninteikikanymd10;
    @ReportItem(name = "dtazenninteikikanymd10", length = 23, order = 113)
    public RString dtazenninteikikanymd10;
    @ReportItem(name = "dtasKanrino10", length = 20, order = 114)
    public RString dtasKanrino10;
    @ReportItem(name = "dtashinsaIken10", length = 200, order = 115)
    public RString dtashinsaIken10;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
