package jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkitexta3;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 事務局用概況特記のReportSourceです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
public class GaikyotokkiTextA4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "gaikyotokkiImg", order = 1)
    public RString gaikyotokkiImg;
    @ReportItem(name = "hihokenshaName", length = 30, order = 2)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "shinseiYY", length = 2, order = 4)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 5)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 6)
    public RString shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 7)
    public RString sakuseiGengo;
    @ReportItem(name = "chosaGengo", length = 2, order = 8)
    public RString chosaGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 9)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 10)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 11)
    public RString sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 12)
    public RString hihokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 13)
    public RString shinseiGengo;
    @ReportItem(name = "shinsaGengo", length = 2, order = 14)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 15)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 16)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 17)
    public RString shinsaDD;
    @ReportItem(name = "chosaYY", length = 2, order = 18)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 19)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 20)
    public RString chosaDD;
    @ReportItem(name = "gaikyotokkiText", order = 21)
    public RString gaikyotokkiText;
    @ReportItem(name = "tokkiText2", order = 22)
    public RString two_tokkiText2;
    @ReportItem(name = "tokkiText3", order = 23)
    public RString two_tokkiText3;
    @ReportItem(name = "tokkiText4", order = 24)
    public RString two_tokkiText4;
    @ReportItem(name = "tokkiText5", order = 25)
    public RString two_tokkiText5;
    @ReportItem(name = "tokkiText6", order = 26)
    public RString two_tokkiText6;
    @ReportItem(name = "tokkiText7", order = 27)
    public RString two_tokkiText7;
    @ReportItem(name = "hihokenshaName", length = 30, order = 28)
    public RString two_hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 29)
    public RString two_hokenshaNo;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 30)
    public RString two_sakuseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 31)
    public RString two_shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 32)
    public RString two_shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 33)
    public RString two_shinseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 34)
    public RString two_chosaGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 35)
    public RString two_sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 36)
    public RString two_sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 37)
    public RString two_sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 30, order = 38)
    public RString two_hihokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 39)
    public RString two_shinseiGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 40)
    public RString two_chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 41)
    public RString two_chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 42)
    public RString two_chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 43)
    public RString two_shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 44)
    public RString two_shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 45)
    public RString two_shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 46)
    public RString two_shinsaDD;
    @ReportItem(name = "gaikyotokkiImg1", order = 47)
    public RString gaikyotokkiImg1;
    @ReportItem(name = "gaikyotokkiImg2", order = 48)
    public RString gaikyotokkiImg2;
    @ReportItem(name = "gaikyotokkiImg3", order = 49)
    public RString gaikyotokkiImg3;
    @ReportItem(name = "gaikyotokkiImg4", order = 50)
    public RString gaikyotokkiImg4;
    @ReportItem(name = "gaikyotokkiImg5", order = 51)
    public RString gaikyotokkiImg5;
    @ReportItem(name = "gaikyotokkiImg6", order = 52)
    public RString gaikyotokkiImg6;
    @ReportItem(name = "gaikyotokkiImg7", order = 53)
    public RString gaikyotokkiImg7;
    @ReportItem(name = "tokkiText1", order = 54)
    public RString two_tokkiText1;
    @ReportItem(name = "tokkiText1", order = 55)
    public RString tokkiText1;
    @ReportItem(name = "tokkiText2", order = 56)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 57)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 58)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 59)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 60)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 61)
    public RString tokkiText7;
    @ReportItem(name = "gaikyotokkiImg", order = 62)
    public RString two_gaikyotokkiImg;
    @ReportItem(name = "shinseiGengo", length = 2, order = 63)
    public RString three_shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 64)
    public RString three_shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 65)
    public RString three_shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 66)
    public RString three_shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 67)
    public RString three_sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 68)
    public RString three_sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 69)
    public RString three_sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 70)
    public RString three_sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 71)
    public RString three_hihokenshaNo;
    @ReportItem(name = "chosaGengo", length = 2, order = 72)
    public RString three_chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 73)
    public RString three_chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 74)
    public RString three_chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 75)
    public RString three_chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 76)
    public RString three_shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 77)
    public RString three_shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 78)
    public RString three_shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 79)
    public RString three_shinsaDD;
    @ReportItem(name = "imgIkensho1", order = 80)
    public RString three_imgIkensho1;
    @ReportItem(name = "hihokenshaName", length = 30, order = 81)
    public RString four_hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 82)
    public RString four_hokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 83)
    public RString four_shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 84)
    public RString four_shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 85)
    public RString four_shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 86)
    public RString four_shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 87)
    public RString four_sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 88)
    public RString four_sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 89)
    public RString four_sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 90)
    public RString four_sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 91)
    public RString four_hihokenshaNo;
    @ReportItem(name = "chosaGengo", length = 2, order = 92)
    public RString four_chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 93)
    public RString four_chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 94)
    public RString four_chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 95)
    public RString four_chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 96)
    public RString four_shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 97)
    public RString four_shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 98)
    public RString four_shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 99)
    public RString four_shinsaDD;
    @ReportItem(name = "imgIkensho2", order = 100)
    public RString four_imgIkensho2;
    @ReportItem(name = "hihokenshaName", length = 30, order = 101)
    public RString three_hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 102)
    public RString three_hokenshaNo;
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

        hokenshaNo,
    }
}
