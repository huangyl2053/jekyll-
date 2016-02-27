package jp.co.ndensan.reams.db.dba.entity.report.hihokenshashoa4;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *
 * 介護保険被保険者証 （A4版）のReportSource
 */
public class HihokenshashoA4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kaigokbn", length = 6, order = 1)
    public RString kaigokbn;
    @ReportItem(name = "seigen1", length = 4, order = 2)
    public RString seigen1;
    @ReportItem(name = "seigenSt1", length = 11, order = 3)
    public RString seigenSt1;
    @ReportItem(name = "seigenLong1", length = 6, order = 4)
    public RString seigenLong1;
    @ReportItem(name = "ninteiymd", length = 11, order = 5)
    public RString ninteiymd;
    @ReportItem(name = "seigen2", length = 4, order = 6)
    public RString seigen2;
    @ReportItem(name = "seigenEd1", length = 11, order = 7)
    public RString seigenEd1;
    @ReportItem(name = "seigenLong2", length = 11, order = 8)
    public RString seigenLong2;
    @ReportItem(name = "yukokikannamisen", length = 1, order = 9)
    public RString yukokikannamisen;
    @ReportItem(name = "yukokikaned", length = 11, order = 10)
    public RString yukokikaned;
    @ReportItem(name = "yukokikanst", length = 11, order = 11)
    public RString yukokikanst;
    @ReportItem(name = "seigen3", length = 4, order = 12)
    public RString seigen3;
    @ReportItem(name = "seigenLong3", length = 6, order = 13)
    public RString seigenLong3;
    @ReportItem(name = "seigenSt2", length = 11, order = 14)
    public RString seigenSt2;
    @ReportItem(name = "saikofu1", length = 3, order = 15)
    public RString saikofu1;
    @ReportItem(name = "saikofu2", length = 3, order = 16)
    public RString saikofu2;
    @ReportItem(name = "yukokigen2", length = 11, order = 17)
    public RString yukokigen2;
    @ReportItem(name = "yukokigen", length = 25, order = 18)
    public RString yukokigen;
    @ReportItem(name = "seigen4", length = 4, order = 19)
    public RString seigen4;
    @ReportItem(name = "seigenLong4", length = 6, order = 20)
    public RString seigenLong4;
    @ReportItem(name = "seigenEd2", length = 11, order = 21)
    public RString seigenEd2;
    @ReportItem(name = "seigen5", length = 4, order = 22)
    public RString seigen5;
    @ReportItem(name = "seigenSt3", length = 11, order = 23)
    public RString seigenSt3;
    @ReportItem(name = "seigenLong5", length = 6, order = 24)
    public RString seigenLong5;
    @ReportItem(name = "homonkikannamisen", length = 1, order = 25)
    public RString homonkikannamisen;
    @ReportItem(name = "homonkikanst", length = 11, order = 26)
    public RString homonkikanst;
    @ReportItem(name = "homonkikaned", length = 11, order = 27)
    public RString homonkikaned;
    @ReportItem(name = "hihokenshanno", length = 10, order = 28)
    public RString hihokenshanno;
    @ReportItem(name = "seigen6", length = 4, order = 29)
    public RString seigen6;
    @ReportItem(name = "seigenEd3", length = 11, order = 30)
    public RString seigenEd3;
    @ReportItem(name = "seigenLong6", length = 6, order = 31)
    public RString seigenLong6;
    @ReportItem(name = "service1", length = 7, order = 32)
    public RString service1;
    @ReportItem(name = "ten0", length = 2, order = 33)
    public RString ten0;
    @ReportItem(name = "gyosha1", order = 34)
    public RString gyosha1;
    @ReportItem(name = "yubinno", length = 8, order = 35)
    public RString yubinno;
    @ReportItem(name = "gyoseiku", length = 13, order = 36)
    public RString gyoseiku;
    @ReportItem(name = "gyoseikuS", length = 17, order = 37)
    public RString gyoseikuS;
    @ReportItem(name = "hihojusho", order = 38)
    public RString hihojusho;
    @ReportItem(name = "todokeYmd1", length = 11, order = 39)
    public RString todokeYmd1;
    @ReportItem(name = "shuruigendo1", length = 7, order = 40)
    public RString shuruigendo1;
    @ReportItem(name = "shurui1", length = 14, order = 41)
    public RString shurui1;
    @ReportItem(name = "ten1", length = 2, order = 42)
    public RString ten1;
    @ReportItem(name = "shuruigendo2", length = 7, order = 43)
    public RString shuruigendo2;
    @ReportItem(name = "ten2", length = 2, order = 44)
    public RString ten2;
    @ReportItem(name = "shurui2", length = 14, order = 45)
    public RString shurui2;
    @ReportItem(name = "gyosha2", order = 46)
    public RString gyosha2;
    @ReportItem(name = "gyosha2Asa", order = 47)
    public RString gyosha2Asa;
    @ReportItem(name = "gyosha2Massho", order = 48)
    public RString gyosha2Massho;
    @ReportItem(name = "shuruigendo3", length = 7, order = 49)
    public RString shuruigendo3;
    @ReportItem(name = "ten3", length = 2, order = 50)
    public RString ten3;
    @ReportItem(name = "shurui3", length = 14, order = 51)
    public RString shurui3;
    @ReportItem(name = "shuruigendo4", length = 7, order = 52)
    public RString shuruigendo4;
    @ReportItem(name = "ten4", length = 2, order = 53)
    public RString ten4;
    @ReportItem(name = "shurui4", length = 14, order = 54)
    public RString shurui4;
    @ReportItem(name = "todokeYmd2", length = 11, order = 55)
    public RString todokeYmd2;
    @ReportItem(name = "todokeYmd2Massho", length = 16, order = 56)
    public RString todokeYmd2Massho;
    @ReportItem(name = "todokeYmd2Asa", length = 16, order = 57)
    public RString todokeYmd2Asa;
    @ReportItem(name = "ten5", length = 2, order = 58)
    public RString ten5;
    @ReportItem(name = "shuruigendo5", length = 7, order = 59)
    public RString shuruigendo5;
    @ReportItem(name = "shurui5", length = 14, order = 60)
    public RString shurui5;
    @ReportItem(name = "gyosha3", order = 61)
    public RString gyosha3;
    @ReportItem(name = "gyosha3Asa", order = 62)
    public RString gyosha3Asa;
    @ReportItem(name = "gyosha3Massho", order = 63)
    public RString gyosha3Massho;
    @ReportItem(name = "hihokana", order = 64)
    public RString hihokana;
    @ReportItem(name = "shurui6", length = 14, order = 65)
    public RString shurui6;
    @ReportItem(name = "ten6", length = 2, order = 66)
    public RString ten6;
    @ReportItem(name = "shuruigendo6", length = 7, order = 67)
    public RString shuruigendo6;
    @ReportItem(name = "hihoname", order = 68)
    public RString hihoname;
    @ReportItem(name = "ryui", order = 69)
    public RString ryui;
    @ReportItem(name = "todokeYmd3", length = 11, order = 70)
    public RString todokeYmd3;
    @ReportItem(name = "todokeYmd3Asa", length = 16, order = 71)
    public RString todokeYmd3Asa;
    @ReportItem(name = "todokeYmd3Massho", length = 16, order = 72)
    public RString todokeYmd3Massho;
    @ReportItem(name = "shisetsuSyu1", length = 13, order = 73)
    public RString shisetsuSyu1;
    @ReportItem(name = "umareG", length = 2, order = 74)
    public RString umareG;
    @ReportItem(name = "umareYyyy", length = 4, order = 75)
    public RString umareYyyy;
    @ReportItem(name = "umareYy", length = 2, order = 76)
    public RString umareYy;
    @ReportItem(name = "umareMm", length = 2, order = 77)
    public RString umareMm;
    @ReportItem(name = "umareDd", length = 2, order = 78)
    public RString umareDd;
    @ReportItem(name = "seibetsu", length = 1, order = 79)
    public RString seibetsu;
    @ReportItem(name = "shisetsuname1", order = 80)
    public RString shisetsuname1;
    @ReportItem(name = "nyushochk1", length = 2, order = 81)
    public RString nyushochk1;
    @ReportItem(name = "nyuinchk1", length = 2, order = 82)
    public RString nyuinchk1;
    @ReportItem(name = "kofuymdMm", length = 2, order = 83)
    public RString kofuymdMm;
    @ReportItem(name = "kofuymdDd", length = 2, order = 84)
    public RString kofuymdDd;
    @ReportItem(name = "kofuymdGengo", length = 2, order = 85)
    public RString kofuymdGengo;
    @ReportItem(name = "nyushoymd1", length = 11, order = 86)
    public RString nyushoymd1;
    @ReportItem(name = "kofuymdYy", length = 2, order = 87)
    public RString kofuymdYy;
    @ReportItem(name = "taishochk1", length = 2, order = 88)
    public RString taishochk1;
    @ReportItem(name = "taiinchk1", length = 2, order = 89)
    public RString taiinchk1;
    @ReportItem(name = "taiinymd1", length = 11, order = 90)
    public RString taiinymd1;
    @ReportItem(name = "shisetsuSyu2", length = 13, order = 91)
    public RString shisetsuSyu2;
    @ReportItem(name = "hokenshano4", length = 1, order = 92)
    public RString hokenshano4;
    @ReportItem(name = "hokenshano6", length = 1, order = 93)
    public RString hokenshano6;
    @ReportItem(name = "hokenshano1", length = 1, order = 94)
    public RString hokenshano1;
    @ReportItem(name = "hokenshano2", length = 1, order = 95)
    public RString hokenshano2;
    @ReportItem(name = "hokenshano5", length = 1, order = 96)
    public RString hokenshano5;
    @ReportItem(name = "hokenshano3", length = 1, order = 97)
    public RString hokenshano3;
    @ReportItem(name = "shisetsuname2", order = 98)
    public RString shisetsuname2;
    @ReportItem(name = "nyushochk2", length = 2, order = 99)
    public RString nyushochk2;
    @ReportItem(name = "nyuinchk2", length = 2, order = 100)
    public RString nyuinchk2;
    @ReportItem(name = "nyushoymd2", length = 11, order = 101)
    public RString nyushoymd2;
    @ReportItem(name = "taiinchk2", length = 2, order = 102)
    public RString taiinchk2;
    @ReportItem(name = "taishochk2", length = 2, order = 103)
    public RString taishochk2;
    @ReportItem(name = "taiinymd2", length = 11, order = 104)
    public RString taiinymd2;
    @ReportItem(name = "renban", length = 6, order = 105)
    public RString renban;
    @ReportItem(name = "itakuGyosha1", order = 106)
    public RString itakuGyosha1;
    @ReportItem(name = "itakuGyosha2", order = 107)
    public RString itakuGyosha2;
    @ReportItem(name = "itakuGyosha2Asa", order = 108)
    public RString itakuGyosha2Asa;
    @ReportItem(name = "itakuGyosha2Massho", order = 109)
    public RString itakuGyosha2Massho;
    @ReportItem(name = "itakuGyosha3", order = 110)
    public RString itakuGyosha3;
    @ReportItem(name = "itakuGyosha3Asa", order = 111)
    public RString itakuGyosha3Asa;
    @ReportItem(name = "itakuGyosha3Massho", order = 112)
    public RString itakuGyosha3Massho;
    @ReportItem(name = "seiShogai11", length = 4, order = 113)
    public RString seiShogai11;
    @ReportItem(name = "seiShogai12", length = 4, order = 114)
    public RString seiShogai12;
    @ReportItem(name = "kosekiSeibetsu11", length = 4, order = 115)
    public RString kosekiSeibetsu11;
    @ReportItem(name = "kosekiSeibetsu12", length = 4, order = 116)
    public RString kosekiSeibetsu12;
    @ReportItem(name = "ImageField1", order = 117)
    public RString ImageField1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
