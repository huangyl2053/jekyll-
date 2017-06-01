/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.entity.report.chosahyomatome;

import jp.co.ndensan.reams.db.dbz.definition.core.chosahyomatome.ChosahyoMatomeLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 認定調査票まとめ印刷の帳票ソースです。
 * @author n8438
 */
public class ChosahyoMatomeReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    //220001
    @ReportItem(name = "hakkoYMD1", length = 12, order = 1)
    public RString hakkoYMD1;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 3)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 4)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 5)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 6)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 7)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 8)
    public RString ninshoshaShimeiKakenai;
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
    @ReportItem(name = "birthGengo", length = 2, order = 31)
    public RString birthGengo;
    @ReportItem(name = "birthYMD", length = 11, order = 32)
    public RString birthYMD;
    @ReportItem(name = "hihokenshaNameKana", order = 33)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaName", order = 34)
    public RString hihokenshaName;
    @ReportItem(name = "seibetsu", length = 1, order = 35)
    public RString seibetsu;
    @ReportItem(name = "yubinNo", length = 8, order = 36)
    public RString yubinNo;
    @ReportItem(name = "jusho", order = 37)
    public RString jusho;
    @ReportItem(name = "telNo", length = 14, order = 38)
    public RString telNo;
    @ReportItem(name = "homonChosasakiYubinNo", length = 8, order = 39)
    public RString homonChosasakiYubinNo;
    @ReportItem(name = "homonChosasakiJusho", order = 40)
    public RString homonChosasakiJusho;
    @ReportItem(name = "homonChosasakiName", order = 41)
    public RString homonChosasakiName;
    @ReportItem(name = "homonChosasakiTelNo", length = 14, order = 42)
    public RString homonChosasakiTelNo;
    @ReportItem(name = "shinseiYMD", length = 11, order = 43)
    public RString shinseiYMD;
    @ReportItem(name = "teishutsuKigen", length = 11, order = 44)
    public RString teishutsuKigen;
    @ReportItem(name = "tsuchibun2", order = 45)
    public RString tsuchibun2;
    @ReportItem(name = "atenaRemban", order = 46)
    public RString atenaRemban;
    
//    221011
    @ReportItem(name = "shinseiYY1", length = 2, order = 201)
    public RString shinseiYY1;
    @ReportItem(name = "shinseiYY2", length = 2, order = 202)
    public RString shinseiYY2;
    @ReportItem(name = "shinseiMM1", length = 2, order = 203)
    public RString shinseiMM1;
    @ReportItem(name = "shinseiMM2", length = 2, order = 204)
    public RString shinseiMM2;
    @ReportItem(name = "shinseiDD1", length = 2, order = 205)
    public RString shinseiDD1;
    @ReportItem(name = "shinseiDD2", length = 2, order = 206)
    public RString shinseiDD2;
    @ReportItem(name = "hokenshaNo1", length = 2, order = 207)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 2, order = 208)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 2, order = 209)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 2, order = 210)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 2, order = 211)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 2, order = 212)
    public RString hokenshaNo6;
    @ReportItem(name = "hishokenshaNo7", length = 2, order = 213)
    public RString hishokenshaNo7;
    @ReportItem(name = "hishokenshaNo8", length = 2, order = 214)
    public RString hishokenshaNo8;
    @ReportItem(name = "hishokenshaNo9", length = 2, order = 215)
    public RString hishokenshaNo9;
    @ReportItem(name = "hishokenshaNo10", length = 2, order = 216)
    public RString hishokenshaNo10;
    @ReportItem(name = "hishokenshaNo1", length = 2, order = 217)
    public RString hishokenshaNo1;
    @ReportItem(name = "hishokenshaNo2", length = 2, order = 218)
    public RString hishokenshaNo2;
    @ReportItem(name = "hishokenshaNo3", length = 2, order = 219)
    public RString hishokenshaNo3;
    @ReportItem(name = "hishokenshaNo4", length = 2, order = 220)
    public RString hishokenshaNo4;
    @ReportItem(name = "hishokenshaNo5", length = 2, order = 221)
    public RString hishokenshaNo5;
    @ReportItem(name = "hishokenshaNo6", length = 2, order = 222)
    public RString hishokenshaNo6;
    @ReportItem(name = "再調査", length = 2, order = 223)
    public RString 再調査;
    @ReportItem(name = "新規", length = 2, order = 224)
    public RString 新規;
    @ReportItem(name = "homonChosainName", length = 40, order = 225)
    public RString homonChosainName;
    @ReportItem(name = "homonChosainNo1", length = 2, order = 226)
    public RString homonChosainNo1;
    @ReportItem(name = "homonChosainNo2", length = 2, order = 227)
    public RString homonChosainNo2;
    @ReportItem(name = "homonChosainNo3", length = 2, order = 228)
    public RString homonChosainNo3;
    @ReportItem(name = "homonChosainNo4", length = 2, order = 229)
    public RString homonChosainNo4;
    @ReportItem(name = "homonChosainNo5", length = 2, order = 230)
    public RString homonChosainNo5;
    @ReportItem(name = "homonChosainNo6", length = 2, order = 231)
    public RString homonChosainNo6;
    @ReportItem(name = "homonChosainNo7", length = 2, order = 232)
    public RString homonChosainNo7;
    @ReportItem(name = "homonChosainNo8", length = 2, order = 233)
    public RString homonChosainNo8;
    @ReportItem(name = "homonChosasakiNo1", length = 2, order = 235)
    public RString homonChosasakiNo1;
    @ReportItem(name = "homonChosasakiNo2", length = 2, order = 236)
    public RString homonChosasakiNo2;
    @ReportItem(name = "homonChosasakiNo3", length = 2, order = 237)
    public RString homonChosasakiNo3;
    @ReportItem(name = "homonChosasakiNo4", length = 2, order = 238)
    public RString homonChosasakiNo4;
    @ReportItem(name = "homonChosasakiNo5", length = 2, order = 239)
    public RString homonChosasakiNo5;
    @ReportItem(name = "homonChosasakiNo6", length = 2, order = 240)
    public RString homonChosasakiNo6;
    @ReportItem(name = "homonChosasakiNo7", length = 2, order = 241)
    public RString homonChosasakiNo7;
    @ReportItem(name = "homonChosasakiNo8", length = 2, order = 242)
    public RString homonChosasakiNo8;
    @ReportItem(name = "homonChosasakiNo9", length = 2, order = 243)
    public RString homonChosasakiNo9;
    @ReportItem(name = "homonChosasakiNo10", length = 2, order = 244)
    public RString homonChosasakiNo10;
    @ReportItem(name = "homonChosasakiNo11", length = 2, order = 245)
    public RString homonChosasakiNo11;
    @ReportItem(name = "homonChosasakiNo12", length = 2, order = 246)
    public RString homonChosasakiNo12;
    @ReportItem(name = "shinseishaNameKana", length = 20, order = 247)
    public RString shinseishaNameKana;
    @ReportItem(name = "seibetsuMan", length = 2, order = 248)
    public RString seibetsuMan;
    @ReportItem(name = "shinseishaYubinNo", length = 8, order = 249)
    public RString shinseishaYubinNo;
    @ReportItem(name = "shinseishTelNo", length = 13, order = 250)
    public RString shinseishTelNo;
    @ReportItem(name = "shinseishaName", length = 20, order = 251)
    public RString shinseishaName;
    @ReportItem(name = "seibetsuWoman", length = 2, order = 252)
    public RString seibetsuWoman;
    @ReportItem(name = "shinseishaJusho", length = 60, order = 253)
    public RString shinseishaJusho;
    @ReportItem(name = "kazokuRenrakusakiTel1", length = 13, order = 254)
    public RString kazokuRenrakusakiTel1;
    @ReportItem(name = "meiji", length = 2, order = 255)
    public RString meiji;
    @ReportItem(name = "taisho", length = 2, order = 256)
    public RString taisho;
    @ReportItem(name = "showa", length = 2, order = 257)
    public RString showa;
    @ReportItem(name = "kazokuRenrakusakiYubinNo", length = 8, order = 258)
    public RString kazokuRenrakusakiYubinNo;
    @ReportItem(name = "kazokuRenrakusakiTel2", length = 13, order = 259)
    public RString kazokuRenrakusakiTel2;
    @ReportItem(name = "kazokuRenrakusakiJusho", length = 60, order = 260)
    public RString kazokuRenrakusakiJusho;
    @ReportItem(name = "birthMM", length = 2, order = 261)
    public RString birthMM;
    @ReportItem(name = "birthYY", length = 2, order = 262)
    public RString birthYY;
    @ReportItem(name = "birthDD", length = 2, order = 263)
    public RString birthDD;
    @ReportItem(name = "age", length = 3, order = 264)
    public RString age;
    @ReportItem(name = "shinseishatonoKankei", length = 10, order = 265)
    public RString shinseishatonoKankei;
    @ReportItem(name = "kazokuRenrakusakiName", length = 15, order = 266)
    public RString kazokuRenrakusakiName;
    @ReportItem(name = "nikaime", length = 2, order = 267)
    public RString nikaime;
    @ReportItem(name = "shokai", length = 2, order = 268)
    public RString shokai;
    @ReportItem(name = "higaito", length = 2, order = 269)
    public RString higaito;
    @ReportItem(name = "yoshien", length = 2, order = 270)
    public RString yoshien;
    @ReportItem(name = "yoshiendo", length = 2, order = 271)
    public RString yoshiendo;
    @ReportItem(name = "yokaigo", length = 2, order = 272)
    public RString yokaigo;
    @ReportItem(name = "yokaigodo", length = 3, order = 273)
    public RString yokaigodo;
    @ReportItem(name = "zenkaiNinteiYYYY", length = 4, order = 274)
    public RString zenkaiNinteiYYYY;
    @ReportItem(name = "zenkaiNinteiMM", length = 2, order = 275)
    public RString zenkaiNinteiMM;
    @ReportItem(name = "zenkaiNinteiDD", length = 2, order = 276)
    public RString zenkaiNinteiDD;
    
    
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    private static final RString LAYOUT = new RString("layout");
    @ReportItem(name = "layout", order = 998)
    public ChosahyoMatomeLayout layout;
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
     * @return ChosahyoMatomeLayout
     */
    public ChosahyoMatomeLayout getLayout() {
        return layout;
    }
// </editor-fold>
}
