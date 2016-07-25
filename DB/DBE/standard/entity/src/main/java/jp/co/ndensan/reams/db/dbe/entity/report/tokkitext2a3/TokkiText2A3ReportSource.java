package jp.co.ndensan.reams.db.dbe.entity.report.tokkitext2a3;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 特記事項（2枚目以降）（A3版）のReportSourceクラスです。
 *
 * @reamsid_L DBE-0150-290 lishengli
 */
public class TokkiText2A3ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "listChosa_1", length = 4, order = 1)
    public RString listChosa_1;
    @ReportItem(name = "tokkiImg3", order = 2)
    public RString tokkiImg3;
    @ReportItem(name = "listChosa1_1", length = 4, order = 3)
    public RString listChosa1_1;
    @ReportItem(name = "tokkiImg20", order = 4)
    public RString tokkiImg20;
    @ReportItem(name = "tokkiImg4", order = 5)
    public RString tokkiImg4;
    @ReportItem(name = "tokkiImg21", order = 6)
    public RString tokkiImg21;
    @ReportItem(name = "tokkiImg5", order = 7)
    public RString tokkiImg5;
    @ReportItem(name = "tokkiImg22", order = 8)
    public RString tokkiImg22;
    @ReportItem(name = "tokkiImg6", order = 9)
    public RString tokkiImg6;
    @ReportItem(name = "tokkiImg23", order = 10)
    public RString tokkiImg23;
    @ReportItem(name = "tokkiImg7", order = 11)
    public RString tokkiImg7;
    @ReportItem(name = "tokkiImg24", order = 12)
    public RString tokkiImg24;
    @ReportItem(name = "tokkiImg8", order = 13)
    public RString tokkiImg8;
    @ReportItem(name = "tokkiImg25", order = 14)
    public RString tokkiImg25;
    @ReportItem(name = "tokkiImg9", order = 15)
    public RString tokkiImg9;
    @ReportItem(name = "tokkiImg26", order = 16)
    public RString tokkiImg26;
    @ReportItem(name = "tokkiImg10", order = 17)
    public RString tokkiImg10;
    @ReportItem(name = "tokkiImg27", order = 18)
    public RString tokkiImg27;
    @ReportItem(name = "tokkiImg11", order = 19)
    public RString tokkiImg11;
    @ReportItem(name = "tokkiImg28", order = 20)
    public RString tokkiImg28;
    @ReportItem(name = "tokkiImg12", order = 21)
    public RString tokkiImg12;
    @ReportItem(name = "tokkiImg29", order = 22)
    public RString tokkiImg29;
    @ReportItem(name = "tokkiImg13", order = 23)
    public RString tokkiImg13;
    @ReportItem(name = "tokkiImg30", order = 24)
    public RString tokkiImg30;
    @ReportItem(name = "tokkiImg14", order = 25)
    public RString tokkiImg14;
    @ReportItem(name = "tokkiImg31", order = 26)
    public RString tokkiImg31;
    @ReportItem(name = "tokkiImg15", order = 27)
    public RString tokkiImg15;
    @ReportItem(name = "tokkiImg32", order = 28)
    public RString tokkiImg32;
    @ReportItem(name = "tokkiImg16", order = 29)
    public RString tokkiImg16;
    @ReportItem(name = "tokkiImg33", order = 30)
    public RString tokkiImg33;
    @ReportItem(name = "tokkiImg17", order = 31)
    public RString tokkiImg17;
    @ReportItem(name = "tokkiImg34", order = 32)
    public RString tokkiImg34;
    @ReportItem(name = "tokkiImg18", order = 33)
    public RString tokkiImg18;
    @ReportItem(name = "tokkiImg35", order = 34)
    public RString tokkiImg35;
    @ReportItem(name = "tokkiImg19", order = 35)
    public RString tokkiImg19;
    @ReportItem(name = "tokkiImg36", order = 36)
    public RString tokkiImg36;
    @ReportItem(name = "tokkiText3", order = 37)
    public RString tokkiText3;
    @ReportItem(name = "listChosa2_1", length = 4, order = 38)
    public RString listChosa2_1;
    @ReportItem(name = "listChosa3_1", length = 4, order = 39)
    public RString listChosa3_1;
    @ReportItem(name = "tokkiText20", order = 40)
    public RString tokkiText20;
    @ReportItem(name = "tokkiText4", order = 41)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText21", order = 42)
    public RString tokkiText21;
    @ReportItem(name = "tokkiText5", order = 43)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText22", order = 44)
    public RString tokkiText22;
    @ReportItem(name = "tokkiText6", order = 45)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText23", order = 46)
    public RString tokkiText23;
    @ReportItem(name = "tokkiText7", order = 47)
    public RString tokkiText7;
    @ReportItem(name = "tokkiText24", order = 48)
    public RString tokkiText24;
    @ReportItem(name = "tokkiText8", order = 49)
    public RString tokkiText8;
    @ReportItem(name = "tokkiText25", order = 50)
    public RString tokkiText25;
    @ReportItem(name = "tokkiText9", order = 51)
    public RString tokkiText9;
    @ReportItem(name = "tokkiText26", order = 52)
    public RString tokkiText26;
    @ReportItem(name = "tokkiText10", order = 53)
    public RString tokkiText10;
    @ReportItem(name = "tokkiText27", order = 54)
    public RString tokkiText27;
    @ReportItem(name = "tokkiText11", order = 55)
    public RString tokkiText11;
    @ReportItem(name = "tokkiText28", order = 56)
    public RString tokkiText28;
    @ReportItem(name = "tokkiText12", order = 57)
    public RString tokkiText12;
    @ReportItem(name = "tokkiText29", order = 58)
    public RString tokkiText29;
    @ReportItem(name = "tokkiText13", order = 59)
    public RString tokkiText13;
    @ReportItem(name = "tokkiText30", order = 60)
    public RString tokkiText30;
    @ReportItem(name = "tokkiText14", order = 61)
    public RString tokkiText14;
    @ReportItem(name = "tokkiText31", order = 62)
    public RString tokkiText31;
    @ReportItem(name = "tokkiText15", order = 63)
    public RString tokkiText15;
    @ReportItem(name = "tokkiText32", order = 64)
    public RString tokkiText32;
    @ReportItem(name = "tokkiText16", order = 65)
    public RString tokkiText16;
    @ReportItem(name = "tokkiText33", order = 66)
    public RString tokkiText33;
    @ReportItem(name = "tokkiText17", order = 67)
    public RString tokkiText17;
    @ReportItem(name = "tokkiText34", order = 68)
    public RString tokkiText34;
    @ReportItem(name = "tokkiText18", order = 69)
    public RString tokkiText18;
    @ReportItem(name = "tokkiText35", order = 70)
    public RString tokkiText35;
    @ReportItem(name = "tokkiText19", order = 71)
    public RString tokkiText19;
    @ReportItem(name = "tokkiText36", order = 72)
    public RString tokkiText36;
    @ReportItem(name = "tokkiImg1", order = 73)
    public RString tokkiImg1;
    @ReportItem(name = "tokkiImg2", order = 74)
    public RString tokkiImg2;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 75)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 76)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 77)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 78)
    public RString sakuseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 79)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 80)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 81)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 82)
    public RString chosaDD;
    @ReportItem(name = "hokenshaNo", length = 6, order = 83)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 84)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", length = 30, order = 85)
    public RString hihokenshaName;
    @ReportItem(name = "shinseiGengo", length = 2, order = 86)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 87)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 88)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 89)
    public RString shinseiDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 90)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 91)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 92)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 93)
    public RString shinsaDD;
    @ReportItem(name = "tokkiText1", order = 94)
    public RString tokkiText1;
    @ReportItem(name = "tokkiText2", order = 95)
    public RString tokkiText2;
    @ReportItem(name = "shinsakaiOrder", order = 96)
    public RString shinsakaiOrder;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    @ReportPerson(id = "A")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation hishokenshaNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shinsakaiOrder,
    }
}
