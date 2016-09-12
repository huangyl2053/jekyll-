package jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyoikenshochecklist;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 認定調査結果と主治医意見書のチェックリストのReportSourceクラスです。
 *
 * @reamsid_L DBE-1390-190 dongyabin
 */
public class ChosahyoIkenshoCheckListReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 2)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", length = 20, order = 3)
    public RString hihokenshaName;
    @ReportItem(name = "zenkaiIchijiHanteiKekka", length = 10, order = 4)
    public RString zenkaiIchijiHanteiKekka;
    @ReportItem(name = "konkaiIchijiHanteiKekka", length = 10, order = 5)
    public RString konkaiIchijiHanteiKekka;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 11, order = 6)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "gogitaiNo", length = 5, order = 7)
    public RString gogitaiNo;
    @ReportItem(name = "zenkaiNijiHanteiKekka", length = 10, order = 8)
    public RString zenkaiNijiHanteiKekka;
    @ReportItem(name = "konkaiChosahyo1", length = 64, order = 9)
    public RString konkaiChosahyo1;
    @ReportItem(name = "konkaiIkensho1", length = 64, order = 10)
    public RString konkaiIkensho1;
    @ReportItem(name = "flag1", length = 1, order = 11)
    public RString flag1;
    @ReportItem(name = "konkaiChosahyo42", length = 64, order = 12)
    public RString konkaiChosahyo42;
    @ReportItem(name = "konkaiChosahyo2", length = 64, order = 13)
    public RString konkaiChosahyo2;
    @ReportItem(name = "konkaiIkensho2", length = 64, order = 14)
    public RString konkaiIkensho2;
    @ReportItem(name = "flag2", length = 1, order = 15)
    public RString flag2;
    @ReportItem(name = "konkaiChosahyo43", length = 64, order = 16)
    public RString konkaiChosahyo43;
    @ReportItem(name = "konkaiIkensho10", length = 64, order = 17)
    public RString konkaiIkensho10;
    @ReportItem(name = "flag10", length = 1, order = 18)
    public RString flag10;
    @ReportItem(name = "konkaiChosahyo3", length = 64, order = 19)
    public RString konkaiChosahyo3;
    @ReportItem(name = "konkaiIkensho3", length = 64, order = 20)
    public RString konkaiIkensho3;
    @ReportItem(name = "flag3", length = 1, order = 21)
    public RString flag3;
    @ReportItem(name = "konkaiChosahyo44", length = 64, order = 22)
    public RString konkaiChosahyo44;
    @ReportItem(name = "konkaiIkensho11", length = 64, order = 23)
    public RString konkaiIkensho11;
    @ReportItem(name = "konkaiChosahyo4", length = 64, order = 24)
    public RString konkaiChosahyo4;
    @ReportItem(name = "konkaiIkensho4", length = 64, order = 25)
    public RString konkaiIkensho4;
    @ReportItem(name = "flag4", length = 1, order = 26)
    public RString flag4;
    @ReportItem(name = "konkaiChosahyo45", length = 64, order = 27)
    public RString konkaiChosahyo45;
    @ReportItem(name = "flag11", length = 1, order = 28)
    public RString flag11;
    @ReportItem(name = "konkaiChosahyo5", length = 64, order = 29)
    public RString konkaiChosahyo5;
    @ReportItem(name = "konkaiIkensho5", length = 64, order = 30)
    public RString konkaiIkensho5;
    @ReportItem(name = "flag5", length = 1, order = 31)
    public RString flag5;
    @ReportItem(name = "konkaiChosahyo46", length = 64, order = 32)
    public RString konkaiChosahyo46;
    @ReportItem(name = "konkaiChosahyo6", length = 64, order = 33)
    public RString konkaiChosahyo6;
    @ReportItem(name = "konkaiChosahyo47", length = 64, order = 34)
    public RString konkaiChosahyo47;
    @ReportItem(name = "konkaiChosahyo7", length = 64, order = 35)
    public RString konkaiChosahyo7;
    @ReportItem(name = "konkaiChosahyo48", length = 64, order = 36)
    public RString konkaiChosahyo48;
    @ReportItem(name = "konkaiIkensho12", length = 64, order = 37)
    public RString konkaiIkensho12;
    @ReportItem(name = "flag12", length = 1, order = 38)
    public RString flag12;
    @ReportItem(name = "konkaiChosahyo8", length = 64, order = 39)
    public RString konkaiChosahyo8;
    @ReportItem(name = "konkaiChosahyo49", length = 64, order = 40)
    public RString konkaiChosahyo49;
    @ReportItem(name = "konkaiChosahyo9", length = 64, order = 41)
    public RString konkaiChosahyo9;
    @ReportItem(name = "konkaiChosahyo50", length = 64, order = 42)
    public RString konkaiChosahyo50;
    @ReportItem(name = "konkaiChosahyo10", length = 64, order = 43)
    public RString konkaiChosahyo10;
    @ReportItem(name = "konkaiChosahyo51", length = 64, order = 44)
    public RString konkaiChosahyo51;
    @ReportItem(name = "konkaiChosahyo11", length = 64, order = 45)
    public RString konkaiChosahyo11;
    @ReportItem(name = "konkaiChosahyo52", length = 64, order = 46)
    public RString konkaiChosahyo52;
    @ReportItem(name = "konkaiChosahyo12", length = 64, order = 47)
    public RString konkaiChosahyo12;
    @ReportItem(name = "konkaiChosahyo53", length = 64, order = 48)
    public RString konkaiChosahyo53;
    @ReportItem(name = "konkaiChosahyo13", length = 64, order = 49)
    public RString konkaiChosahyo13;
    @ReportItem(name = "konkaiChosahyo54", length = 64, order = 50)
    public RString konkaiChosahyo54;
    @ReportItem(name = "konkaiChosahyo14", length = 64, order = 51)
    public RString konkaiChosahyo14;
    @ReportItem(name = "konkaiChosahyo55", length = 64, order = 52)
    public RString konkaiChosahyo55;
    @ReportItem(name = "konkaiChosahyo15", length = 64, order = 53)
    public RString konkaiChosahyo15;
    @ReportItem(name = "konkaiChosahyo56", length = 64, order = 54)
    public RString konkaiChosahyo56;
    @ReportItem(name = "konkaiChosahyo16", length = 64, order = 55)
    public RString konkaiChosahyo16;
    @ReportItem(name = "konkaiChosahyo17", length = 64, order = 56)
    public RString konkaiChosahyo17;
    @ReportItem(name = "konkaiChosahyo18", length = 64, order = 57)
    public RString konkaiChosahyo18;
    @ReportItem(name = "konkaiChosahyo57", length = 64, order = 58)
    public RString konkaiChosahyo57;
    @ReportItem(name = "konkaiChosahyo19", length = 64, order = 59)
    public RString konkaiChosahyo19;
    @ReportItem(name = "konkaiChosahyo58", length = 64, order = 60)
    public RString konkaiChosahyo58;
    @ReportItem(name = "konkaiChosahyo20", length = 64, order = 61)
    public RString konkaiChosahyo20;
    @ReportItem(name = "konkaiChosahyo59", length = 64, order = 62)
    public RString konkaiChosahyo59;
    @ReportItem(name = "konkaiChosahyo60", length = 64, order = 63)
    public RString konkaiChosahyo60;
    @ReportItem(name = "konkaiChosahyo61", length = 64, order = 64)
    public RString konkaiChosahyo61;
    @ReportItem(name = "konkaiChosahyo21", length = 64, order = 65)
    public RString konkaiChosahyo21;
    @ReportItem(name = "konkaiChosahyo62", length = 64, order = 66)
    public RString konkaiChosahyo62;
    @ReportItem(name = "konkaiChosahyo22", length = 64, order = 67)
    public RString konkaiChosahyo22;
    @ReportItem(name = "konkaiChosahyo23", length = 64, order = 68)
    public RString konkaiChosahyo23;
    @ReportItem(name = "konkaiIkensho6", length = 64, order = 69)
    public RString konkaiIkensho6;
    @ReportItem(name = "flag6", length = 1, order = 70)
    public RString flag6;
    @ReportItem(name = "konkaiChosahyo24", length = 64, order = 71)
    public RString konkaiChosahyo24;
    @ReportItem(name = "konkaiChosahyo63", length = 64, order = 72)
    public RString konkaiChosahyo63;
    @ReportItem(name = "konkaiIkensho13", length = 64, order = 73)
    public RString konkaiIkensho13;
    @ReportItem(name = "flag13", length = 1, order = 74)
    public RString flag13;
    @ReportItem(name = "konkaiChosahyo25", length = 64, order = 75)
    public RString konkaiChosahyo25;
    @ReportItem(name = "konkaiChosahyo64", length = 64, order = 76)
    public RString konkaiChosahyo64;
    @ReportItem(name = "konkaiIkensho14", length = 64, order = 77)
    public RString konkaiIkensho14;
    @ReportItem(name = "flag14", length = 1, order = 78)
    public RString flag14;
    @ReportItem(name = "konkaiChosahyo26", length = 64, order = 79)
    public RString konkaiChosahyo26;
    @ReportItem(name = "konkaiChosahyo65", length = 64, order = 80)
    public RString konkaiChosahyo65;
    @ReportItem(name = "konkaiIkensho15", length = 64, order = 81)
    public RString konkaiIkensho15;
    @ReportItem(name = "flag15", length = 1, order = 82)
    public RString flag15;
    @ReportItem(name = "konkaiChosahyo27", length = 64, order = 83)
    public RString konkaiChosahyo27;
    @ReportItem(name = "konkaiChosahyo66", length = 64, order = 84)
    public RString konkaiChosahyo66;
    @ReportItem(name = "konkaiIkensho16", length = 64, order = 85)
    public RString konkaiIkensho16;
    @ReportItem(name = "flag16", length = 1, order = 86)
    public RString flag16;
    @ReportItem(name = "konkaiChosahyo28", length = 64, order = 87)
    public RString konkaiChosahyo28;
    @ReportItem(name = "konkaiChosahyo67", length = 64, order = 88)
    public RString konkaiChosahyo67;
    @ReportItem(name = "konkaiIkensho17", length = 64, order = 89)
    public RString konkaiIkensho17;
    @ReportItem(name = "flag17", length = 1, order = 90)
    public RString flag17;
    @ReportItem(name = "konkaiChosahyo29", length = 64, order = 91)
    public RString konkaiChosahyo29;
    @ReportItem(name = "konkaiChosahyo68", length = 64, order = 92)
    public RString konkaiChosahyo68;
    @ReportItem(name = "konkaiIkensho18", length = 64, order = 93)
    public RString konkaiIkensho18;
    @ReportItem(name = "flag18", length = 1, order = 94)
    public RString flag18;
    @ReportItem(name = "konkaiChosahyo30", length = 64, order = 95)
    public RString konkaiChosahyo30;
    @ReportItem(name = "konkaiChosahyo69", length = 64, order = 96)
    public RString konkaiChosahyo69;
    @ReportItem(name = "konkaiIkensho19", length = 64, order = 97)
    public RString konkaiIkensho19;
    @ReportItem(name = "flag19", length = 1, order = 98)
    public RString flag19;
    @ReportItem(name = "konkaiChosahyo31", length = 64, order = 99)
    public RString konkaiChosahyo31;
    @ReportItem(name = "konkaiChosahyo70", length = 64, order = 100)
    public RString konkaiChosahyo70;
    @ReportItem(name = "konkaiIkensho20", length = 64, order = 101)
    public RString konkaiIkensho20;
    @ReportItem(name = "flag20", length = 1, order = 102)
    public RString flag20;
    @ReportItem(name = "konkaiChosahyo32", length = 64, order = 103)
    public RString konkaiChosahyo32;
    @ReportItem(name = "konkaiChosahyo71", length = 64, order = 104)
    public RString konkaiChosahyo71;
    @ReportItem(name = "konkaiIkensho21", length = 64, order = 105)
    public RString konkaiIkensho21;
    @ReportItem(name = "flag21", length = 1, order = 106)
    public RString flag21;
    @ReportItem(name = "konkaiChosahyo72", length = 64, order = 107)
    public RString konkaiChosahyo72;
    @ReportItem(name = "konkaiIkensho22", length = 64, order = 108)
    public RString konkaiIkensho22;
    @ReportItem(name = "flag22", length = 1, order = 109)
    public RString flag22;
    @ReportItem(name = "konkaiChosahyo73", length = 64, order = 110)
    public RString konkaiChosahyo73;
    @ReportItem(name = "konkaiIkensho23", length = 64, order = 111)
    public RString konkaiIkensho23;
    @ReportItem(name = "flag23", length = 1, order = 112)
    public RString flag23;
    @ReportItem(name = "konkaiChosahyo33", length = 64, order = 113)
    public RString konkaiChosahyo33;
    @ReportItem(name = "konkaiIkensho7", length = 64, order = 114)
    public RString konkaiIkensho7;
    @ReportItem(name = "flag7", length = 1, order = 115)
    public RString flag7;
    @ReportItem(name = "konkaiChosahyo74", length = 64, order = 116)
    public RString konkaiChosahyo74;
    @ReportItem(name = "konkaiIkensho24", length = 64, order = 117)
    public RString konkaiIkensho24;
    @ReportItem(name = "flag24", length = 1, order = 118)
    public RString flag24;
    @ReportItem(name = "konkaiChosahyo34", length = 64, order = 119)
    public RString konkaiChosahyo34;
    @ReportItem(name = "konkaiChosahyo35", length = 64, order = 120)
    public RString konkaiChosahyo35;
    @ReportItem(name = "konkaiChosahyo36", length = 64, order = 121)
    public RString konkaiChosahyo36;
    @ReportItem(name = "konkaiIkensho8", length = 64, order = 122)
    public RString konkaiIkensho8;
    @ReportItem(name = "flag8", length = 1, order = 123)
    public RString flag8;
    @ReportItem(name = "konkaiChosahyo75", length = 64, order = 124)
    public RString konkaiChosahyo75;
    @ReportItem(name = "konkaiIkensho25", length = 64, order = 125)
    public RString konkaiIkensho25;
    @ReportItem(name = "flag25", length = 1, order = 126)
    public RString flag25;
    @ReportItem(name = "konkaiChosahyo37", length = 64, order = 127)
    public RString konkaiChosahyo37;
    @ReportItem(name = "konkaiChosahyo76", length = 64, order = 128)
    public RString konkaiChosahyo76;
    @ReportItem(name = "konkaiIkensho26", length = 64, order = 129)
    public RString konkaiIkensho26;
    @ReportItem(name = "flag26", length = 1, order = 130)
    public RString flag26;
    @ReportItem(name = "konkaiChosahyo38", length = 64, order = 131)
    public RString konkaiChosahyo38;
    @ReportItem(name = "konkaiChosahyo39", length = 64, order = 132)
    public RString konkaiChosahyo39;
    @ReportItem(name = "konkaiChosahyo40", length = 64, order = 133)
    public RString konkaiChosahyo40;
    @ReportItem(name = "konkaiIkensho9", length = 64, order = 134)
    public RString konkaiIkensho9;
    @ReportItem(name = "flag9", length = 1, order = 135)
    public RString flag9;
    @ReportItem(name = "konkaiChosahyo41", length = 64, order = 136)
    public RString konkaiChosahyo41;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokenshaNoAcc;
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        hihokenshaNo
    }
}
