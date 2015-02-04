package jp.co.ndensan.reams.db.dbz.model.report.DBA10000X;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItemGroup;
// TODO n8178 参照できないため、福祉を参考に一時的にpomを書き換えて見えるようにした。TsuchishoSofusakiSourceがModelに移動した後に修正する。 2015年2月末
import jp.co.ndensan.reams.ur.urz.business.report.parts.tsuchishoatesaki.TsuchishoAtesakiSource;

public class HihokenshashoA4 implements IHihokenshasho {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihojusho", order = 1)
    public RString hihojusho;
    @ReportItem(name = "hihokana", order = 2)
    public RString hihokana;
    @ReportItem(name = "hihoname", order = 3)
    public RString hihoname;
    @ReportItem(name = "ryui", order = 4)
    public RString ryui;
    @ReportItem(name = "gyosha1", order = 5)
    public RString gyosha1;
    @ReportItem(name = "gyosha2", order = 6)
    public RString gyosha2;
    @ReportItem(name = "gyosha2Asa", order = 7)
    public RString gyosha2Asa;
    @ReportItem(name = "gyosha2Massho", order = 8)
    public RString gyosha2Massho;
    @ReportItem(name = "gyosha3", order = 9)
    public RString gyosha3;
    @ReportItem(name = "gyosha3Asa", order = 10)
    public RString gyosha3Asa;
    @ReportItem(name = "gyosha3Massho", order = 11)
    public RString gyosha3Massho;
    @ReportItem(name = "todokeYmd2Massho", length = 16, order = 12)
    public RString todokeYmd2Massho;
    @ReportItem(name = "todokeYmd2Asa", length = 16, order = 13)
    public RString todokeYmd2Asa;
    @ReportItem(name = "seigen6", length = 4, order = 14)
    public RString seigen6;
    @ReportItem(name = "seigenLong4", length = 6, order = 15)
    public RString seigenLong4;
    @ReportItem(name = "seigen4", length = 4, order = 16)
    public RString seigen4;
    @ReportItem(name = "seigenLong2", length = 11, order = 17)
    public RString seigenLong2;
    @ReportItem(name = "seigen2", length = 4, order = 18)
    public RString seigen2;
    @ReportItem(name = "seigen1", length = 4, order = 19)
    public RString seigen1;
    @ReportItem(name = "seigenLong6", length = 6, order = 20)
    public RString seigenLong6;
    @ReportItem(name = "hihokenshanno", length = 10, order = 21)
    public RString hihokenshanno;
    @ReportItem(name = "yukokigen", length = 25, order = 22)
    public RString yukokigen;
    @ReportItem(name = "kofuymdGengo", length = 2, order = 23)
    public RString kofuymdGengo;
    @ReportItem(name = "kofuymdYy", length = 2, order = 24)
    public RString kofuymdYy;
    @ReportItem(name = "kofuymdMm", length = 2, order = 25)
    public RString kofuymdMm;
    @ReportItem(name = "kofuymdDd", length = 2, order = 26)
    public RString kofuymdDd;
    @ReportItem(name = "seibetsu", length = 1, order = 27)
    public RString seibetsu;
    @ReportItem(name = "seigenSt1", length = 11, order = 28)
    public RString seigenSt1;
    @ReportItem(name = "seigenSt2", length = 11, order = 29)
    public RString seigenSt2;
    @ReportItem(name = "seigenEd1", length = 11, order = 30)
    public RString seigenEd1;
    @ReportItem(name = "seigenEd2", length = 11, order = 31)
    public RString seigenEd2;
    @ReportItem(name = "seigen3", length = 4, order = 32)
    public RString seigen3;
    @ReportItem(name = "nyushoymd2", length = 11, order = 33)
    public RString nyushoymd2;
    @ReportItem(name = "taiinymd1", length = 11, order = 34)
    public RString taiinymd1;
    @ReportItem(name = "taiinymd2", length = 11, order = 35)
    public RString taiinymd2;
    @ReportItem(name = "shisetsuSyu1", length = 13, order = 36)
    public RString shisetsuSyu1;
    @ReportItem(name = "shisetsuname2", length = 14, order = 37)
    public RString shisetsuname2;
    @ReportItem(name = "shisetsuname3", length = 14, order = 38)
    public RString shisetsuname3;
    @ReportItem(name = "shisetsuname1", length = 14, order = 39)
    public RString shisetsuname1;
    @ReportItem(name = "nyushoymd1", length = 2, order = 40)
    public RString nyushoymd1;
    @ReportItem(name = "shisetsuname4", length = 14, order = 41)
    public RString shisetsuname4;
    @ReportItem(name = "shisetsuname5", length = 14, order = 42)
    public RString shisetsuname5;
    @ReportItem(name = "shisetsuname6", length = 14, order = 43)
    public RString shisetsuname6;
    @ReportItem(name = "yubinno", length = 8, order = 44)
    public RString yubinno;
    @ReportItem(name = "todokeYmd1", length = 11, order = 45)
    public RString todokeYmd1;
    @ReportItem(name = "saikofu1", length = 3, order = 46)
    public RString saikofu1;
    @ReportItem(name = "saikofu2", length = 3, order = 47)
    public RString saikofu2;
    @ReportItem(name = "gyoseiku", length = 13, order = 48)
    public RString gyoseiku;
    @ReportItem(name = "seigen5", length = 4, order = 49)
    public RString seigen5;
    @ReportItem(name = "seigenSt3", length = 11, order = 50)
    public RString seigenSt3;
    @ReportItem(name = "seigenEd3", length = 11, order = 51)
    public RString seigenEd3;
    @ReportItem(name = "nyushochk1", length = 2, order = 52)
    public RString nyushochk1;
    @ReportItem(name = "nyuinchk1", length = 2, order = 53)
    public RString nyuinchk1;
    @ReportItem(name = "taishochk1", length = 2, order = 54)
    public RString taishochk1;
    @ReportItem(name = "taiinchk1", length = 2, order = 55)
    public RString taiinchk1;
    @ReportItem(name = "nyushochk2", length = 2, order = 56)
    public RString nyushochk2;
    @ReportItem(name = "nyuinchk2", length = 2, order = 57)
    public RString nyuinchk2;
    @ReportItem(name = "taishochk2", length = 2, order = 58)
    public RString taishochk2;
    @ReportItem(name = "taiinchk2", length = 2, order = 59)
    public RString taiinchk2;
    @ReportItem(name = "renban", length = 6, order = 60)
    public RString renban;
    @ReportItem(name = "yukokigen2", length = 11, order = 61)
    public RString yukokigen2;
    @ReportItem(name = "kaigokbn", length = 6, order = 62)
    public RString kaigokbn;
    @ReportItem(name = "ninteiymd", length = 11, order = 63)
    public RString ninteiymd;
    @ReportItem(name = "yukokikanst", length = 11, order = 64)
    public RString yukokikanst;
    @ReportItem(name = "yukokikaned", length = 11, order = 65)
    public RString yukokikaned;
    @ReportItem(name = "service1", length = 7, order = 66)
    public RString service1;
    @ReportItem(name = "shurui1", length = 14, order = 67)
    public RString shurui1;
    @ReportItem(name = "shuruigendo1", length = 7, order = 68)
    public RString shuruigendo1;
    @ReportItem(name = "shuruigendo2", length = 7, order = 69)
    public RString shuruigendo2;
    @ReportItem(name = "shuruigendo3", length = 7, order = 70)
    public RString shuruigendo3;
    @ReportItem(name = "shuruigendo4", length = 7, order = 71)
    public RString shuruigendo4;
    @ReportItem(name = "shurui2", length = 14, order = 72)
    public RString shurui2;
    @ReportItem(name = "shurui3", length = 14, order = 73)
    public RString shurui3;
    @ReportItem(name = "shurui4", length = 14, order = 74)
    public RString shurui4;
    @ReportItem(name = "homonkikanst", length = 11, order = 75)
    public RString homonkikanst;
    @ReportItem(name = "homonkikaned", length = 11, order = 76)
    public RString homonkikaned;
    @ReportItem(name = "ten1", length = 2, order = 77)
    public RString ten1;
    @ReportItem(name = "ten2", length = 2, order = 78)
    public RString ten2;
    @ReportItem(name = "ten3", length = 2, order = 79)
    public RString ten3;
    @ReportItem(name = "ten4", length = 2, order = 80)
    public RString ten4;
    @ReportItem(name = "ten0", length = 2, order = 81)
    public RString ten0;
    @ReportItem(name = "shurui5", length = 14, order = 82)
    public RString shurui5;
    @ReportItem(name = "shuruigendo5", length = 7, order = 83)
    public RString shuruigendo5;
    @ReportItem(name = "ten5", length = 2, order = 84)
    public RString ten5;
    @ReportItem(name = "shurui6", length = 14, order = 85)
    public RString shurui6;
    @ReportItem(name = "shuruigendo6", length = 7, order = 86)
    public RString shuruigendo6;
    @ReportItem(name = "ten6", length = 2, order = 87)
    public RString ten6;
    @ReportItem(name = "todokeYmd2", length = 11, order = 88)
    public RString todokeYmd2;
    @ReportItem(name = "todokeYmd3", length = 11, order = 89)
    public RString todokeYmd3;
    @ReportItem(name = "todokeYmd3Massho", length = 16, order = 90)
    public RString todokeYmd3Massho;
    @ReportItem(name = "todokeYmd3Asa", length = 16, order = 91)
    public RString todokeYmd3Asa;
    @ReportItem(name = "seigenLong1", length = 6, order = 92)
    public RString seigenLong1;
    @ReportItem(name = "seigenLong3", length = 6, order = 93)
    public RString seigenLong3;
    @ReportItem(name = "seigenLong5", length = 6, order = 94)
    public RString seigenLong5;
    @ReportItem(name = "gyoseikuS", length = 17, order = 95)
    public RString gyoseikuS;
    @ReportItem(name = "hokenshano1", length = 1, order = 96)
    public RString hokenshano1;
    @ReportItem(name = "hokenshano2", length = 1, order = 97)
    public RString hokenshano2;
    @ReportItem(name = "hokenshano5", length = 1, order = 98)
    public RString hokenshano5;
    @ReportItem(name = "hokenshano3", length = 1, order = 99)
    public RString hokenshano3;
    @ReportItem(name = "hokenshano4", length = 1, order = 100)
    public RString hokenshano4;
    @ReportItem(name = "hokenshano6", length = 1, order = 101)
    public RString hokenshano6;
    @ReportItem(name = "yukokikannamisen", length = 1, order = 102)
    public RString yukokikannamisen;
    @ReportItem(name = "homonkikannamisen", length = 1, order = 103)
    public RString homonkikannamisen;
    @ReportItem(name = "umareG", length = 2, order = 104)
    public RString umareG;
    @ReportItem(name = "umareYy", length = 2, order = 105)
    public RString umareYy;
    @ReportItem(name = "umareMm", length = 2, order = 106)
    public RString umareMm;
    @ReportItem(name = "umareDd", length = 2, order = 107)
    public RString umareDd;
    @ReportItem(name = "shisetsuSyu2", length = 13, order = 108)
    public RString shisetsuSyu2;
    @ReportItem(name = "umareYyyy", length = 4, order = 109)
    public RString umareYyyy;
    @ReportItem(name = "itakuGyosha1", order = 110)
    public RString itakuGyosha1;
    @ReportItem(name = "itakuGyosha2", order = 111)
    public RString itakuGyosha2;
    @ReportItem(name = "itakuGyosha2Asa", order = 112)
    public RString itakuGyosha2Asa;
    @ReportItem(name = "itakuGyosha2Massho", order = 113)
    public RString itakuGyosha2Massho;
    @ReportItem(name = "itakuGyosha3", order = 114)
    public RString itakuGyosha3;
    @ReportItem(name = "itakuGyosha3Asa", order = 115)
    public RString itakuGyosha3Asa;
    @ReportItem(name = "itakuGyosha3Massho", order = 116)
    public RString itakuGyosha3Massho;
    @ReportItem(name = "seiShogai11", length = 4, order = 117)
    public RString seiShogai11;
    @ReportItem(name = "seiShogai12", length = 4, order = 118)
    public RString seiShogai12;
    @ReportItem(name = "kosekiSeibetsu11", length = 4, order = 119)
    public RString kosekiSeibetsu11;
    @ReportItem(name = "kosekiSeibetsu12", length = 4, order = 120)
    public RString kosekiSeibetsu12;
    @ReportItemGroup(groupName = "sofusakiAtena", order = 121)
    // TODO n8178 AtesakiSourceをModelパッケージに移動した後変更する。 2014/1/9
    public TsuchishoAtesakiSource sofusakiAtena;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

}
