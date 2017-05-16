/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.entity.report.ikenshoassortment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshoassortment.IkenshoAssortmentLayout;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 意見書個人別まとめて印刷のソースです。
 * @author n8438
 */
public class IkenshoAssortmentReportSource implements IReportSource {
    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    //意見書依頼書・兼用
    @ReportItem(name = "hakkoYMD1", length = 12, order = 1)
    public RString hakkoYMD1;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 3)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 4)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 5)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 6)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 7)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 8)
    public RString koinMojiretsu;
    @ReportItem(name = "koinShoryaku", length = 15, order = 9)
    public RString koinShoryaku;
    @ReportItem(name = "bunshoNo", length = 35, order = 10)
    public RString bunshoNo;
    @ReportItem(name = "yubinNo1", length = 8, order = 11)
    public RString yubinNo1;
    @ReportItem(name = "jushoText", order = 12)
    public RString jushoText;
    @ReportItem(name = "kikanNameText", order = 13)
    public RString kikanNameText;
    @ReportItem(name = "shimeiText", order = 14)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo", length = 3, order = 15)
    public RString meishoFuyo;
    @ReportItem(name = "customerBarCode", order = 16)
    public RString customerBarCode;
    @ReportItem(name = "sonota", length = 14, order = 17)
    public RString sonota;
    @ReportItem(name = "pageCount", length = 8, order = 18)
    public RString pageCount;
    @ReportItem(name = "title", length = 50, order = 19)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 20)
    public RString tsuchibun1;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 21)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 22)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 23)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 24)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 25)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 26)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 27)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 28)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 29)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 30)
    public RString hihokenshaNo10;
    @ReportItem(name = "hokenshaNo1", length = 1, order = 31)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 1, order = 32)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 1, order = 33)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 1, order = 34)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 1, order = 35)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 1, order = 36)
    public RString hokenshaNo6;
    @ReportItem(name = "shinseiKubun", length = 2, order = 37)
    public RString shinseiKubun;
    @ReportItem(name = "hihokenshaNameKana", order = 38)
    public RString hihokenshaNameKana;
    @ReportItem(name = "seibetsu", length = 1, order = 39)
    public RString seibetsu;
    @ReportItem(name = "hihokenshaName", order = 40)
    public RString hihokenshaName;
    @ReportItem(name = "birthGengo", length = 2, order = 41)
    public RString birthGengo;
    @ReportItem(name = "birthYMD", length = 11, order = 42)
    public RString birthYMD;
    @ReportItem(name = "yubinNo", length = 8, order = 43)
    public RString yubinNo;
    @ReportItem(name = "jusho", order = 44)
    public RString jusho;
    @ReportItem(name = "shinseiYMD", length = 11, order = 45)
    public RString shinseiYMD;
    @ReportItem(name = "teishutsuKigen", length = 11, order = 46)
    public RString teishutsuKigen;
    @ReportItem(name = "tsuchibun2", order = 47)
    public RString tsuchibun2;
    @ReportItem(name = "shoriName", length = 4, order = 48)
    public RString shoriName;
    @ReportItem(name = "atenaRemban", length = 8, order = 49)
    public RString atenaRemban;
    
    //記入用紙
    @ReportItem(name = "hihokenshaKana", length = 30, order = 101)
    public RString hihokenshaKana;
    @ReportItem(name = "seibetsuMan", length = 2, order = 103)
    public RString seibetsuMan;
    @ReportItem(name = "seibetsuWoman", length = 2, order = 106)
    public RString seibetsuWoman;
    @ReportItem(name = "hihokenshaTel", length = 13, order = 107)
    public RString hihokenshaTel;
    @ReportItem(name = "birthGengoMeiji", length = 2, order = 108)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 2, order = 109)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 2, order = 110)
    public RString birthGengoShowa;
    @ReportItem(name = "age", length = 3, order = 111)
    public RString age;
    @ReportItem(name = "birthYY", length = 2, order = 112)
    public RString birthYY;
    @ReportItem(name = "birthMM", length = 2, order = 113)
    public RString birthMM;
    @ReportItem(name = "birthDD", length = 2, order = 114)
    public RString birthDD;
    @ReportItem(name = "shujiiName", length = 30, order = 115)
    public RString shujiiName;
    @ReportItem(name = "iryokikanName", length = 40, order = 116)
    public RString iryokikanName;
    @ReportItem(name = "iryokikanNameTel", length = 13, order = 117)
    public RString iryokikanNameTel;
    @ReportItem(name = "iryokikanFax", length = 13, order = 118)
    public RString iryokikanFax;
    @ReportItem(name = "iryokikanAdress", length = 50, order = 119)
    public RString iryokikanAdress;
    @ReportItem(name = "shinseiYMDNo1", length = 2, order = 127)
    public RString shinseiYMDNo1;
    @ReportItem(name = "shinseiYMDNo2", length = 2, order = 128)
    public RString shinseiYMDNo2;
    @ReportItem(name = "shinseiYMDNo3", length = 2, order = 129)
    public RString shinseiYMDNo3;
    @ReportItem(name = "shinseiYMDNo4", length = 2, order = 130)
    public RString shinseiYMDNo4;
    @ReportItem(name = "shinseiYMDNo5", length = 2, order = 131)
    public RString shinseiYMDNo5;
    @ReportItem(name = "shinseiYMDNo6", length = 2, order = 132)
    public RString shinseiYMDNo6;
    @ReportItem(name = "shinseiYY1", length = 2, order = 151)
    public RString shinseiYY1;
    @ReportItem(name = "shinseiYY2", length = 2, order = 152)
    public RString shinseiYY2;
    @ReportItem(name = "shinseiMM1", length = 2, order = 153)
    public RString shinseiMM1;
    @ReportItem(name = "shinseiMM2", length = 2, order = 154)
    public RString shinseiMM2;
    @ReportItem(name = "shinseiD1", length = 2, order = 155)
    public RString shinseiD1;
    @ReportItem(name = "shinseiDD2", length = 2, order = 156)
    public RString shinseiDD2;
    @ReportItem(name = "shinseishaNameKana", length = 30, order = 173)
    public RString shinseishaNameKana;
    @ReportItem(name = "shinseishaYubinNo", length = 8, order = 174)
    public RString shinseishaYubinNo;
    @ReportItem(name = "shinseishaTelNo", length = 13, order = 175)
    public RString shinseishaTelNo;
    @ReportItem(name = "shinseishaName", length = 35, order = 177)
    public RString shinseishaName;
    @ReportItem(name = "shinseishaJusho", length = 60, order = 178)
    public RString shinseishaJusho;
    @ReportItem(name = "meiji", length = 2, order = 180)
    public RString meiji;
    @ReportItem(name = "taisho", length = 2, order = 181)
    public RString taisho;
    @ReportItem(name = "showa", length = 2, order = 182)
    public RString showa;
    @ReportItem(name = "iryokikanTelNo", length = 13, order = 189)
    public RString iryokikanTelNo;
    @ReportItem(name = "iryokikanJusho", length = 55, order = 190)
    public RString iryokikanJusho;
    @ReportItem(name = "iryokikanFaxNo", length = 13, order = 191)
    public RString iryokikanFaxNo;
    
    //請求書
    @ReportItem(name = "inkanMark", length = 1, order = 213)
    public RString inkanMark;
    @ReportItem(name = "iryokikanDaihyosha", order = 215)
    public RString iryokikanDaihyosha;
    @ReportItem(name = "iryokikanTel", length = 20, order = 220)
    public RString iryokikanTel;
    @ReportItem(name = "ikenshoSakuseiRyo2", length = 1, order = 221)
    public RString ikenshoSakuseiRyo2;
    @ReportItem(name = "ikenshoSakuseiRyo4", length = 1, order = 222)
    public RString ikenshoSakuseiRyo4;
    @ReportItem(name = "ikenshoSakuseiRyo1", length = 1, order = 223)
    public RString ikenshoSakuseiRyo1;
    @ReportItem(name = "ikenshoSakuseiRyo3", length = 1, order = 224)
    public RString ikenshoSakuseiRyo3;
    @ReportItem(name = "shubetsuZaitaku", length = 1, order = 225)
    public RString shubetsuZaitaku;
    @ReportItem(name = "shubetsuKeizoku", length = 1, order = 226)
    public RString shubetsuKeizoku;
    @ReportItem(name = "shubetsuShisetsu", length = 1, order = 227)
    public RString shubetsuShisetsu;
    @ReportItem(name = "shubetsuShinki", length = 1, order = 228)
    public RString shubetsuShinki;
    @ReportItem(name = "seikyugakuIkenshoSakuseiRyo1", length = 1, order = 229)
    public RString seikyugakuIkenshoSakuseiRyo1;
    @ReportItem(name = "seikyugakuIkenshoSakuseiRyo2", length = 1, order = 230)
    public RString seikyugakuIkenshoSakuseiRyo2;
    @ReportItem(name = "seikyugakuIkenshoSakuseiRyo3", length = 1, order = 231)
    public RString seikyugakuIkenshoSakuseiRyo3;
    @ReportItem(name = "seikyugakuIkenshoSakuseiRyo4", length = 1, order = 232)
    public RString seikyugakuIkenshoSakuseiRyo4;
    @ReportItem(name = "gengo", length = 11, order = 233)
    public RString gengo;
    @ReportItem(name = "atesakiHokenshaName", length = 50, order = 234)
    public RString atesakiHokenshaName;
    @ReportItem(name = "shinkiShisetsuKingaku", length = 6, order = 235)
    public Decimal shinkiShisetsuKingaku;
    @ReportItem(name = "shinkiZaitakuKingaku", length = 6, order = 236)
    public Decimal shinkiZaitakuKingaku;
    @ReportItem(name = "keizokuZaitakuKingaku", length = 6, order = 237)
    public Decimal keizokuZaitakuKingaku;
    @ReportItem(name = "keizokuShisetsuKingaku", length = 6, order = 238)
    public Decimal keizokuShisetsuKingaku;
    
    //命令書
    @ReportItem(name = "hakkoYMD", length = 12, order = 301)
    public RString hakkoYMD;
    @ReportItem(name = "hihokenshaName1", order = 313)
    public RString hihokenshaName1;
    @ReportItem(name = "hihokenshaName2", order = 330)
    public RString hihokenshaName2;
    @ReportItem(name = "tantoIshiName", order = 332)
    public RString tantoIshiName;
    @ReportItem(name = "iryokikanYubinNo", length = 8, order = 333)
    public RString iryokikanYubinNo;
    @ReportItem(name = "telNo", length = 14, order = 335)
    public RString telNo;
    @ReportItem(name = "jushinKikan", length = 25, order = 336)
    public RString jushinKikan;
    @ReportItem(name = "jushinArea", order = 337)
    public RString jushinArea;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportItem(name = "remban", length = 4, order = 998)
    public RString remban;
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    private static final RString LAYOUT = new RString("layout");
    @ReportItem(name = "layout", order = 999)
    public IkenshoAssortmentLayout layout;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation 拡張情報;
    
    /**
     * レイアウトブレイクキーの一覧です。
     */
    public static List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(LAYOUT));
    }
    
    /**
     * レイアウトを取得します。
     * @return IkenshoAssortmentLayout
     */
    public IkenshoAssortmentLayout getLayout() {
        return layout;
    }
// </editor-fold>

}
