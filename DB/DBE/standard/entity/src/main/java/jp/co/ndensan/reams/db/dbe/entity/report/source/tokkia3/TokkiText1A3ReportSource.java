package jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia3;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 事務局用特記事項のReportSourceです。
 *
 * @reamsid_L DBE-0150-060 wangrenze
 */
public class TokkiText1A3ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaName", length = 30, order = 1)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 3)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 4)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 5)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 6)
    public RString sakuseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 7)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 8)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 9)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 10)
    public RString chosaDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 11)
    public RString hihokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 12)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 13)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 14)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 15)
    public RString shinseiDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 16)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 17)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 18)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 19)
    public RString shinsaDD;
    @ReportItem(name = "tokkiImg1", order = 20)
    public RString tokkiImg1;
    @ReportItem(name = "listChosa_1", length = 4, order = 21)
    public RString listChosa_1;
    @ReportItem(name = "tokkiImg2", order = 22)
    public RString tokkiImg2;
    @ReportItem(name = "tokkiImg3", order = 23)
    public RString tokkiImg3;
    @ReportItem(name = "tokkiImg4", order = 24)
    public RString tokkiImg4;
    @ReportItem(name = "tokkiImg5", order = 25)
    public RString tokkiImg5;
    @ReportItem(name = "tokkiImg6", order = 26)
    public RString tokkiImg6;
    @ReportItem(name = "tokkiImg7", order = 27)
    public RString tokkiImg7;
    @ReportItem(name = "tokkiImg8", order = 28)
    public RString tokkiImg8;
    @ReportItem(name = "tokkiImg9", order = 29)
    public RString tokkiImg9;
    @ReportItem(name = "tokkiImg10", order = 30)
    public RString tokkiImg10;
    @ReportItem(name = "tokkiImg11", order = 31)
    public RString tokkiImg11;
    @ReportItem(name = "tokkiImg12", order = 32)
    public RString tokkiImg12;
    @ReportItem(name = "tokkiImg13", order = 33)
    public RString tokkiImg13;
    @ReportItem(name = "tokkiImg14", order = 34)
    public RString tokkiImg14;
    @ReportItem(name = "tokkiImg15", order = 35)
    public RString tokkiImg15;
    @ReportItem(name = "tokkiText1", order = 36)
    public RString tokkiText1;
    @ReportItem(name = "listChosa1_1", length = 4, order = 37)
    public RString listChosa1_1;
    @ReportItem(name = "tokkiText2", order = 38)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 39)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 40)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 41)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 42)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 43)
    public RString tokkiText7;
    @ReportItem(name = "tokkiText8", order = 44)
    public RString tokkiText8;
    @ReportItem(name = "tokkiText9", order = 45)
    public RString tokkiText9;
    @ReportItem(name = "tokkiText10", order = 46)
    public RString tokkiText10;
    @ReportItem(name = "tokkiText11", order = 47)
    public RString tokkiText11;
    @ReportItem(name = "tokkiText12", order = 48)
    public RString tokkiText12;
    @ReportItem(name = "tokkiText13", order = 49)
    public RString tokkiText13;
    @ReportItem(name = "tokkiText14", order = 50)
    public RString tokkiText14;
    @ReportItem(name = "tokkiText15", order = 51)
    public RString tokkiText15;
    @ReportItem(name = "tokkiImg", order = 52)
    public RString tokkiImg;
    @ReportItem(name = "tokkiText", order = 53)
    public RString tokkiText;
    @ReportItem(name = "tokkiImg", order = 54)
    public RString two1_tokkiImg;
    @ReportItem(name = "listChosa_1", length = 4, order = 55)
    public RString two_listChosa_1;
    @ReportItem(name = "tokkiImg3", order = 56)
    public RString two_tokkiImg3;
    @ReportItem(name = "listChosa1_1", length = 4, order = 57)
    public RString two_listChosa1_1;
    @ReportItem(name = "tokkiImg20", order = 58)
    public RString two_tokkiImg20;
    @ReportItem(name = "tokkiImg4", order = 59)
    public RString two_tokkiImg4;
    @ReportItem(name = "tokkiImg21", order = 60)
    public RString two_tokkiImg21;
    @ReportItem(name = "tokkiImg5", order = 61)
    public RString two_tokkiImg5;
    @ReportItem(name = "tokkiImg22", order = 62)
    public RString two_tokkiImg22;
    @ReportItem(name = "tokkiImg6", order = 63)
    public RString two_tokkiImg6;
    @ReportItem(name = "tokkiImg23", order = 64)
    public RString two_tokkiImg23;
    @ReportItem(name = "tokkiImg7", order = 65)
    public RString two_tokkiImg7;
    @ReportItem(name = "tokkiImg24", order = 66)
    public RString two_tokkiImg24;
    @ReportItem(name = "tokkiImg8", order = 67)
    public RString two_tokkiImg8;
    @ReportItem(name = "tokkiImg25", order = 68)
    public RString two_tokkiImg25;
    @ReportItem(name = "tokkiImg9", order = 69)
    public RString two_tokkiImg9;
    @ReportItem(name = "tokkiImg26", order = 70)
    public RString two_tokkiImg26;
    @ReportItem(name = "tokkiImg10", order = 71)
    public RString two_tokkiImg10;
    @ReportItem(name = "tokkiImg27", order = 72)
    public RString two_tokkiImg27;
    @ReportItem(name = "tokkiImg11", order = 73)
    public RString two_tokkiImg11;
    @ReportItem(name = "tokkiImg28", order = 74)
    public RString two_tokkiImg28;
    @ReportItem(name = "tokkiImg12", order = 75)
    public RString two_tokkiImg12;
    @ReportItem(name = "tokkiImg29", order = 76)
    public RString two_tokkiImg29;
    @ReportItem(name = "tokkiImg13", order = 77)
    public RString two_tokkiImg13;
    @ReportItem(name = "tokkiImg30", order = 78)
    public RString two_tokkiImg30;
    @ReportItem(name = "tokkiImg14", order = 79)
    public RString two_tokkiImg14;
    @ReportItem(name = "tokkiImg31", order = 80)
    public RString two_tokkiImg31;
    @ReportItem(name = "tokkiImg15", order = 81)
    public RString two_tokkiImg15;
    @ReportItem(name = "tokkiImg32", order = 82)
    public RString two_tokkiImg32;
    @ReportItem(name = "tokkiImg16", order = 83)
    public RString two_tokkiImg16;
    @ReportItem(name = "tokkiImg33", order = 84)
    public RString two_tokkiImg33;
    @ReportItem(name = "tokkiImg17", order = 85)
    public RString two_tokkiImg17;
    @ReportItem(name = "tokkiImg34", order = 86)
    public RString two_tokkiImg34;
    @ReportItem(name = "tokkiImg18", order = 87)
    public RString two_tokkiImg18;
    @ReportItem(name = "tokkiImg35", order = 88)
    public RString two_tokkiImg35;
    @ReportItem(name = "tokkiImg19", order = 89)
    public RString two_tokkiImg19;
    @ReportItem(name = "tokkiImg36", order = 90)
    public RString two_tokkiImg36;
    @ReportItem(name = "tokkiText3", order = 91)
    public RString two_tokkiText3;
    @ReportItem(name = "listChosa2_1", length = 4, order = 92)
    public RString two_listChosa2_1;
    @ReportItem(name = "listChosa3_1", length = 4, order = 93)
    public RString two_listChosa3_1;
    @ReportItem(name = "tokkiText20", order = 94)
    public RString two_tokkiText20;
    @ReportItem(name = "tokkiText4", order = 95)
    public RString two_tokkiText4;
    @ReportItem(name = "tokkiText21", order = 96)
    public RString two_tokkiText21;
    @ReportItem(name = "tokkiText5", order = 97)
    public RString two_tokkiText5;
    @ReportItem(name = "tokkiText22", order = 98)
    public RString two_tokkiText22;
    @ReportItem(name = "tokkiText6", order = 99)
    public RString two_tokkiText6;
    @ReportItem(name = "tokkiText23", order = 100)
    public RString two_tokkiText23;
    @ReportItem(name = "tokkiText7", order = 101)
    public RString two_tokkiText7;
    @ReportItem(name = "tokkiText24", order = 102)
    public RString two_tokkiText24;
    @ReportItem(name = "tokkiText8", order = 103)
    public RString two_tokkiText8;
    @ReportItem(name = "tokkiText25", order = 104)
    public RString two_tokkiText25;
    @ReportItem(name = "tokkiText9", order = 105)
    public RString two_tokkiText9;
    @ReportItem(name = "tokkiText26", order = 106)
    public RString two_tokkiText26;
    @ReportItem(name = "tokkiText10", order = 107)
    public RString two_tokkiText10;
    @ReportItem(name = "tokkiText27", order = 108)
    public RString two_tokkiText27;
    @ReportItem(name = "tokkiText11", order = 109)
    public RString two_tokkiText11;
    @ReportItem(name = "tokkiText28", order = 110)
    public RString two_tokkiText28;
    @ReportItem(name = "tokkiText12", order = 111)
    public RString two_tokkiText12;
    @ReportItem(name = "tokkiText29", order = 112)
    public RString two_tokkiText29;
    @ReportItem(name = "tokkiText13", order = 113)
    public RString two_tokkiText13;
    @ReportItem(name = "tokkiText30", order = 114)
    public RString two_tokkiText30;
    @ReportItem(name = "tokkiText14", order = 115)
    public RString two_tokkiText14;
    @ReportItem(name = "tokkiText31", order = 116)
    public RString two_tokkiText31;
    @ReportItem(name = "tokkiText15", order = 117)
    public RString two_tokkiText15;
    @ReportItem(name = "tokkiText32", order = 118)
    public RString two_tokkiText32;
    @ReportItem(name = "tokkiText16", order = 119)
    public RString two_tokkiText16;
    @ReportItem(name = "tokkiText33", order = 120)
    public RString two_tokkiText33;
    @ReportItem(name = "tokkiText17", order = 121)
    public RString two_tokkiText17;
    @ReportItem(name = "tokkiText34", order = 122)
    public RString two_tokkiText34;
    @ReportItem(name = "tokkiText18", order = 123)
    public RString two_tokkiText18;
    @ReportItem(name = "tokkiText35", order = 124)
    public RString two_tokkiText35;
    @ReportItem(name = "tokkiText19", order = 125)
    public RString two_tokkiText19;
    @ReportItem(name = "tokkiText36", order = 126)
    public RString two_tokkiText36;
    @ReportItem(name = "tokkiImg1", order = 127)
    public RString two_tokkiImg1;
    @ReportItem(name = "tokkiImg2", order = 128)
    public RString two_tokkiImg2;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 129)
    public RString two_sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 130)
    public RString two_sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 131)
    public RString two_sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 132)
    public RString two_sakuseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 133)
    public RString two_chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 134)
    public RString two_chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 135)
    public RString two_chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 136)
    public RString two_chosaDD;
    @ReportItem(name = "hokenshaNo", length = 6, order = 137)
    public RString two_hokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 138)
    public RString two_hihokenshaNo;
    @ReportItem(name = "hihokenshaName", length = 30, order = 139)
    public RString two_hihokenshaName;
    @ReportItem(name = "shinseiGengo", length = 2, order = 140)
    public RString two_shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 141)
    public RString two_shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 142)
    public RString two_shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 143)
    public RString two_shinseiDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 144)
    public RString two_shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 145)
    public RString two_shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 146)
    public RString two_shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 147)
    public RString two_shinsaDD;
    @ReportItem(name = "tokkiText1", order = 148)
    public RString two_tokkiText1;
    @ReportItem(name = "tokkiText2", order = 149)
    public RString two_tokkiText2;
    @ReportItem(name = "tokkiImg1", order = 150)
    public RString two2_tokkiImg1;
    @ReportItem(name = "tokkiImg1", order = 151)
    public RString three_tokkiImg1;
    @ReportItem(name = "listChosa_1", length = 4, order = 152)
    public RString three_listChosa_1;
    @ReportItem(name = "tokkiImg2", order = 153)
    public RString three_tokkiImg2;
    @ReportItem(name = "tokkiImg3", order = 154)
    public RString three_tokkiImg3;
    @ReportItem(name = "tokkiImg4", order = 155)
    public RString three_tokkiImg4;
    @ReportItem(name = "tokkiImg5", order = 156)
    public RString three_tokkiImg5;
    @ReportItem(name = "tokkiImg6", order = 157)
    public RString three_tokkiImg6;
    @ReportItem(name = "tokkiImg7", order = 158)
    public RString three_tokkiImg7;
    @ReportItem(name = "tokkiImg8", order = 159)
    public RString three_tokkiImg8;
    @ReportItem(name = "tokkiImg9", order = 160)
    public RString three_tokkiImg9;
    @ReportItem(name = "tokkiImg10", order = 161)
    public RString three_tokkiImg10;
    @ReportItem(name = "tokkiImg11", order = 162)
    public RString three_tokkiImg11;
    @ReportItem(name = "tokkiImg12", order = 163)
    public RString three_tokkiImg12;
    @ReportItem(name = "tokkiImg13", order = 164)
    public RString three_tokkiImg13;
    @ReportItem(name = "tokkiImg14", order = 165)
    public RString three_tokkiImg14;
    @ReportItem(name = "tokkiImg15", order = 166)
    public RString three_tokkiImg15;
    @ReportItem(name = "tokkiImg2", order = 167)
    public RString two2_tokkiImg2;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 168)
    public RString four_sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 169)
    public RString four_sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 170)
    public RString four_sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 171)
    public RString four_sakuseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 172)
    public RString four_chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 173)
    public RString four_chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 174)
    public RString four_chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 175)
    public RString four_chosaDD;
    @ReportItem(name = "hokenshaNo", length = 6, order = 176)
    public RString four_hokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 177)
    public RString four_hihokenshaNo;
    @ReportItem(name = "hihokenshaName", length = 30, order = 178)
    public RString four_hihokenshaName;
    @ReportItem(name = "shinseiGengo", length = 2, order = 179)
    public RString four_shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 180)
    public RString four_shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 181)
    public RString four_shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 182)
    public RString four_shinseiDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 183)
    public RString four_shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 184)
    public RString four_shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 185)
    public RString four_shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 186)
    public RString four_shinsaDD;
    @ReportItem(name = "listChosa_1", length = 4, order = 187)
    public RString four_listChosa_1;
    @ReportItem(name = "tokkiImg1", order = 188)
    public RString four_tokkiImg1;
    @ReportItem(name = "listChosa1_1", length = 4, order = 189)
    public RString four_listChosa1_1;
    @ReportItem(name = "tokkiImg18", order = 190)
    public RString four_tokkiImg18;
    @ReportItem(name = "tokkiImg2", order = 191)
    public RString four_tokkiImg2;
    @ReportItem(name = "tokkiImg19", order = 192)
    public RString four_tokkiImg19;
    @ReportItem(name = "tokkiImg3", order = 193)
    public RString four_tokkiImg3;
    @ReportItem(name = "tokkiImg20", order = 194)
    public RString four_tokkiImg20;
    @ReportItem(name = "tokkiImg4", order = 195)
    public RString four_tokkiImg4;
    @ReportItem(name = "tokkiImg21", order = 196)
    public RString four_tokkiImg21;
    @ReportItem(name = "tokkiImg5", order = 197)
    public RString four_tokkiImg5;
    @ReportItem(name = "tokkiImg22", order = 198)
    public RString four_tokkiImg22;
    @ReportItem(name = "tokkiImg6", order = 199)
    public RString four_tokkiImg6;
    @ReportItem(name = "tokkiImg23", order = 200)
    public RString four_tokkiImg23;
    @ReportItem(name = "tokkiImg7", order = 201)
    public RString four_tokkiImg7;
    @ReportItem(name = "tokkiImg24", order = 202)
    public RString four_tokkiImg24;
    @ReportItem(name = "tokkiImg8", order = 203)
    public RString four_tokkiImg8;
    @ReportItem(name = "tokkiImg25", order = 204)
    public RString four_tokkiImg25;
    @ReportItem(name = "tokkiImg9", order = 205)
    public RString four_tokkiImg9;
    @ReportItem(name = "tokkiImg26", order = 206)
    public RString four_tokkiImg26;
    @ReportItem(name = "tokkiImg10", order = 207)
    public RString four_tokkiImg10;
    @ReportItem(name = "tokkiImg27", order = 208)
    public RString four_tokkiImg27;
    @ReportItem(name = "tokkiImg11", order = 209)
    public RString four_tokkiImg11;
    @ReportItem(name = "tokkiImg28", order = 210)
    public RString four_tokkiImg28;
    @ReportItem(name = "tokkiImg12", order = 211)
    public RString four_tokkiImg12;
    @ReportItem(name = "tokkiImg29", order = 212)
    public RString four_tokkiImg29;
    @ReportItem(name = "tokkiImg13", order = 213)
    public RString four_tokkiImg13;
    @ReportItem(name = "tokkiImg30", order = 214)
    public RString four_tokkiImg30;
    @ReportItem(name = "tokkiImg14", order = 215)
    public RString four_tokkiImg14;
    @ReportItem(name = "tokkiImg31", order = 216)
    public RString four_tokkiImg31;
    @ReportItem(name = "tokkiImg15", order = 217)
    public RString four_tokkiImg15;
    @ReportItem(name = "tokkiImg32", order = 218)
    public RString four_tokkiImg32;
    @ReportItem(name = "tokkiImg16", order = 219)
    public RString four_tokkiImg16;
    @ReportItem(name = "tokkiImg33", order = 220)
    public RString four_tokkiImg33;
    @ReportItem(name = "tokkiImg17", order = 221)
    public RString four_tokkiImg17;
    @ReportItem(name = "tokkiImg34", order = 222)
    public RString four_tokkiImg34;

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
