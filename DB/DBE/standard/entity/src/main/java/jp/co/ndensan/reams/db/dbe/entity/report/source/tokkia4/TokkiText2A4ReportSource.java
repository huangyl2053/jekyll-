package jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia4;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 特記事項2枚目以降（A4版）のReportSourceです。
 *
 * @reamsid_L DBE-0150-350 wangrenze
 */
public class TokkiText2A4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tokkiImg1", order = 1)
    public RString tokkiImg1;
    @ReportItem(name = "listChosa_1", length = 4, order = 2)
    public RString listChosa_1;
    @ReportItem(name = "tokkiImg2", order = 3)
    public RString tokkiImg2;
    @ReportItem(name = "tokkiImg3", order = 4)
    public RString tokkiImg3;
    @ReportItem(name = "tokkiImg4", order = 5)
    public RString tokkiImg4;
    @ReportItem(name = "tokkiImg5", order = 6)
    public RString tokkiImg5;
    @ReportItem(name = "tokkiImg6", order = 7)
    public RString tokkiImg6;
    @ReportItem(name = "tokkiImg7", order = 8)
    public RString tokkiImg7;
    @ReportItem(name = "tokkiImg8", order = 9)
    public RString tokkiImg8;
    @ReportItem(name = "tokkiImg9", order = 10)
    public RString tokkiImg9;
    @ReportItem(name = "tokkiImg10", order = 11)
    public RString tokkiImg10;
    @ReportItem(name = "tokkiImg11", order = 12)
    public RString tokkiImg11;
    @ReportItem(name = "tokkiImg12", order = 13)
    public RString tokkiImg12;
    @ReportItem(name = "tokkiImg13", order = 14)
    public RString tokkiImg13;
    @ReportItem(name = "tokkiImg14", order = 15)
    public RString tokkiImg14;
    @ReportItem(name = "tokkiImg15", order = 16)
    public RString tokkiImg15;
    @ReportItem(name = "tokkiText1", order = 17)
    public RString tokkiText1;
    @ReportItem(name = "listChosa1_1", length = 4, order = 18)
    public RString listChosa1_1;
    @ReportItem(name = "tokkiText2", order = 19)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 20)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 21)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 22)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 23)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 24)
    public RString tokkiText7;
    @ReportItem(name = "tokkiText8", order = 25)
    public RString tokkiText8;
    @ReportItem(name = "tokkiText9", order = 26)
    public RString tokkiText9;
    @ReportItem(name = "tokkiText10", order = 27)
    public RString tokkiText10;
    @ReportItem(name = "tokkiText11", order = 28)
    public RString tokkiText11;
    @ReportItem(name = "tokkiText12", order = 29)
    public RString tokkiText12;
    @ReportItem(name = "tokkiText13", order = 30)
    public RString tokkiText13;
    @ReportItem(name = "tokkiText14", order = 31)
    public RString tokkiText14;
    @ReportItem(name = "tokkiText15", order = 32)
    public RString tokkiText15;
    @ReportItem(name = "tokkiImg", order = 33)
    public RString tokkiImg;
    @ReportItem(name = "hihokenshaName", length = 30, order = 34)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 35)
    public RString hokenshaNo;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 36)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 37)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 38)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 39)
    public RString sakuseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 40)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 41)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 42)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 43)
    public RString chosaDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 44)
    public RString hihokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 45)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 46)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 47)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 48)
    public RString shinseiDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 49)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 50)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 51)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 52)
    public RString shinsaDD;
    @ReportItem(name = "tokkiText", order = 53)
    public RString tokkiText;
    @ReportItem(name = "gaikyotokkiImg", order = 54)
    public RString gaikyotokkiImg;
    @ReportItem(name = "hihokenshaName", length = 30, order = 55)
    public RString two_hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 56)
    public RString two_hokenshaNo;
    @ReportItem(name = "shinseiYY", length = 2, order = 57)
    public RString two_shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 58)
    public RString two_shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 59)
    public RString two_shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 60)
    public RString two_sakuseiGengo;
    @ReportItem(name = "chosaGengo", length = 2, order = 61)
    public RString two_chosaGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 62)
    public RString two_sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 63)
    public RString two_sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 64)
    public RString two_sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 65)
    public RString two_hihokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 66)
    public RString two_shinseiGengo;
    @ReportItem(name = "shinsaGengo", length = 2, order = 67)
    public RString two_shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 68)
    public RString two_shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 69)
    public RString two_shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 70)
    public RString two_shinsaDD;
    @ReportItem(name = "chosaYY", length = 2, order = 71)
    public RString two_chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 72)
    public RString two_chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 73)
    public RString two_chosaDD;
    @ReportItem(name = "gaikyotokkiText", order = 74)
    public RString gaikyotokkiText;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        hokenshaNo,
    }
}
