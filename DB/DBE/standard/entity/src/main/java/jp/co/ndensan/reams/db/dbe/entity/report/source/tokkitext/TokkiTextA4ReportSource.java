/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 特記事項A4版のReportSourceです。
 *
 * @reamsid_L DBE-0150-340 lishengli
 */
public class TokkiTextA4ReportSource implements IReportSource {
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
    @ReportItem(name = "tokkiImg1", order = 22)
    public RString tokkiImg1;
    @ReportItem(name = "listChosa_1", length = 4, order = 23)
    public RString listChosa_1;
    @ReportItem(name = "tokkiImg2", order = 24)
    public RString tokkiImg2;
    @ReportItem(name = "tokkiImg3", order = 25)
    public RString tokkiImg3;
    @ReportItem(name = "tokkiImg4", order = 26)
    public RString tokkiImg4;
    @ReportItem(name = "tokkiImg5", order = 27)
    public RString tokkiImg5;
    @ReportItem(name = "tokkiImg6", order = 28)
    public RString tokkiImg6;
    @ReportItem(name = "tokkiImg7", order = 29)
    public RString tokkiImg7;
    @ReportItem(name = "tokkiImg8", order = 30)
    public RString tokkiImg8;
    @ReportItem(name = "tokkiImg9", order = 31)
    public RString tokkiImg9;
    @ReportItem(name = "tokkiImg10", order = 32)
    public RString tokkiImg10;
    @ReportItem(name = "tokkiImg11", order = 33)
    public RString tokkiImg11;
    @ReportItem(name = "tokkiImg12", order = 34)
    public RString tokkiImg12;
    @ReportItem(name = "tokkiImg13", order = 35)
    public RString tokkiImg13;
    @ReportItem(name = "tokkiImg14", order = 36)
    public RString tokkiImg14;
    @ReportItem(name = "tokkiImg15", order = 37)
    public RString tokkiImg15;
    @ReportItem(name = "tokkiText1", order = 38)
    public RString tokkiText1;
    @ReportItem(name = "listChosa1_1", length = 4, order = 39)
    public RString listChosa1_1;
    @ReportItem(name = "tokkiText2", order = 40)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 41)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 42)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 43)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 44)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 45)
    public RString tokkiText7;
    @ReportItem(name = "tokkiText8", order = 46)
    public RString tokkiText8;
    @ReportItem(name = "tokkiText9", order = 47)
    public RString tokkiText9;
    @ReportItem(name = "tokkiText10", order = 48)
    public RString tokkiText10;
    @ReportItem(name = "tokkiText11", order = 49)
    public RString tokkiText11;
    @ReportItem(name = "tokkiText12", order = 50)
    public RString tokkiText12;
    @ReportItem(name = "tokkiText13", order = 51)
    public RString tokkiText13;
    @ReportItem(name = "tokkiText14", order = 52)
    public RString tokkiText14;
    @ReportItem(name = "tokkiText15", order = 53)
    public RString tokkiText15;
    @ReportItem(name = "tokkiImg", order = 54)
    public RString tokkiImg;
    @ReportItem(name = "tokkiText", order = 55)
    public RString tokkiText;

    @ReportItem(name = "two_tokkiImg1", order = 156)
    public RString two_tokkiImg1;
    @ReportItem(name = "two_listChosa_1", length = 4, order = 157)
    public RString two_listChosa1;
    @ReportItem(name = "two_tokkiImg2", order = 158)
    public RString two_tokkiImg2;
    @ReportItem(name = "two_tokkiImg3", order = 159)
    public RString two_tokkiImg3;
    @ReportItem(name = "two_tokkiImg4", order = 160)
    public RString two_tokkiImg4;
    @ReportItem(name = "two_tokkiImg5", order = 161)
    public RString two_tokkiImg5;
    @ReportItem(name = "two_tokkiImg6", order = 162)
    public RString two_tokkiImg6;
    @ReportItem(name = "two_tokkiImg7", order = 163)
    public RString two_tokkiImg7;
    @ReportItem(name = "two_tokkiImg8", order = 164)
    public RString two_tokkiImg8;
    @ReportItem(name = "two_tokkiImg9", order = 165)
    public RString two_tokkiImg9;
    @ReportItem(name = "two_tokkiImg10", order = 166)
    public RString two_tokkiImg10;
    @ReportItem(name = "two_tokkiImg11", order = 167)
    public RString two_tokkiImg11;
    @ReportItem(name = "two_tokkiImg12", order = 168)
    public RString two_tokkiImg12;
    @ReportItem(name = "two_tokkiImg13", order = 169)
    public RString two_tokkiImg13;
    @ReportItem(name = "two_tokkiImg14", order = 170)
    public RString two_tokkiImg14;
    @ReportItem(name = "two_tokkiImg15", order = 171)
    public RString two_tokkiImg15;
    @ReportItem(name = "two_tokkiText1", order = 172)
    public RString two_tokkiText1;
    @ReportItem(name = "two_listChosa1_1", length = 4, order = 173)
    public RString two_listChosa1_1;
    @ReportItem(name = "two_tokkiText2", order = 174)
    public RString two_tokkiText2;
    @ReportItem(name = "two_tokkiText3", order = 175)
    public RString two_tokkiText3;
    @ReportItem(name = "two_tokkiText4", order = 176)
    public RString two_tokkiText4;
    @ReportItem(name = "two_tokkiText5", order = 177)
    public RString two_tokkiText5;
    @ReportItem(name = "two_tokkiText6", order = 178)
    public RString two_tokkiText6;
    @ReportItem(name = "two_tokkiText7", order = 179)
    public RString two_tokkiText7;
    @ReportItem(name = "two_tokkiText8", order = 180)
    public RString two_tokkiText8;
    @ReportItem(name = "two_tokkiText9", order = 181)
    public RString two_tokkiText9;
    @ReportItem(name = "two_tokkiText10", order = 182)
    public RString two_tokkiText10;
    @ReportItem(name = "two_tokkiText11", order = 183)
    public RString two_tokkiText11;
    @ReportItem(name = "two_tokkiText12", order = 184)
    public RString two_tokkiText12;
    @ReportItem(name = "two_tokkiText13", order = 185)
    public RString two_tokkiText13;
    @ReportItem(name = "two_tokkiText14", order = 186)
    public RString two_tokkiText14;
    @ReportItem(name = "two_tokkiText15", order = 187)
    public RString two_tokkiText15;
    @ReportItem(name = "two_tokkiImg", order = 188)
    public RString two_tokkiImg;
    @ReportItem(name = "two_hihokenshaName", length = 30, order = 189)
    public RString two_hihokenshaName;
    @ReportItem(name = "two_hokenshaNo", length = 6, order = 190)
    public RString two_hokenshaNo;
    @ReportItem(name = "two_sakuseiGengo", length = 2, order = 191)
    public RString two_sakuseiGengo;
    @ReportItem(name = "two_sakuseiYY", length = 2, order = 192)
    public RString two_sakuseiYY;
    @ReportItem(name = "two_sakuseiMM", length = 2, order = 193)
    public RString two_sakuseiMM;
    @ReportItem(name = "two_sakuseiDD", length = 2, order = 194)
    public RString two_sakuseiDD;
    @ReportItem(name = "two_chosaGengo", length = 2, order = 195)
    public RString two_chosaGengo;
    @ReportItem(name = "two_chosaYY", length = 2, order = 196)
    public RString two_chosaYY;
    @ReportItem(name = "two_chosaMM", length = 2, order = 197)
    public RString two_chosaMM;
    @ReportItem(name = "two_chosaDD", length = 2, order = 198)
    public RString two_chosaDD;
    @ReportItem(name = "two_hihokenshaNo", length = 10, order = 199)
    public RString two_hihokenshaNo;
    @ReportItem(name = "two_shinseiGengo", length = 2, order = 200)
    public RString two_shinseiGengo;
    @ReportItem(name = "two_shinseiYY", length = 2, order = 201)
    public RString two_shinseiYY;
    @ReportItem(name = "two_shinseiMM", length = 2, order = 202)
    public RString two_shinseiMM;
    @ReportItem(name = "two_shinseiDD", length = 2, order = 203)
    public RString two_shinseiDD;
    @ReportItem(name = "two_shinsaGengo", length = 2, order = 204)
    public RString two_shinsaGengo;
    @ReportItem(name = "two_shinsaYY", length = 2, order = 205)
    public RString two_shinsaYY;
    @ReportItem(name = "two_shinsaMM", length = 2, order = 206)
    public RString two_shinsaMM;
    @ReportItem(name = "two_shinsaDD", length = 2, order = 207)
    public RString two_shinsaDD;
    @ReportItem(name = "two_tokkiText", order = 208)
    public RString two_tokkiText;

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "layout", order = 999)
    public Layouts layout;

    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }

// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        tokkiText,
        tokkiImg,
        two_tokkiText,
        two_tokkiImg,
    }
}
