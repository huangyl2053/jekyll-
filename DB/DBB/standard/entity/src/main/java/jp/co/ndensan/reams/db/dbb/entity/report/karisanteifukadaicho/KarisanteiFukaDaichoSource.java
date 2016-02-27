package jp.co.ndensan.reams.db.dbb.entity.report.karisanteifukadaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBRP00006_2_賦課台帳（仮算定）
 */
public class KarisanteiFukaDaichoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "pageNo", length = 2, order = 2)
    public RString pageNo;
    @ReportItem(name = "pageNoAll", length = 2, order = 3)
    public RString pageNoAll;
    @ReportItem(name = "title", length = 10, order = 4)
    public RString title;
    @ReportItem(name = "choteiNendo", length = 4, order = 5)
    public RString choteiNendo;
    @ReportItem(name = "fukaNendo", length = 4, order = 6)
    public RString fukaNendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 7)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 8)
    public RString hokenshaName;
    @ReportItem(name = "tsuchishoNo", order = 9)
    public RString tsuchishoNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 10)
    public RString hihokenshaNo;
    @ReportItem(name = "setaiCode", length = 15, order = 11)
    public RString setaiCode;
    @ReportItem(name = "hyojicodeName2", length = 8, order = 12)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojicodeName4", length = 8, order = 13)
    public RString hyojicodeName4;
    @ReportItem(name = "hyojicodeName1", length = 8, order = 14)
    public RString hyojicodeName1;
    @ReportItem(name = "honinNameKana", order = 15)
    public RString honinNameKana;
    @ReportItem(name = "honinyubinNo", length = 8, order = 16)
    public RString honinyubinNo;
    @ReportItem(name = "honinJusho", order = 17)
    public RString honinJusho;
    @ReportItem(name = "honinSeibetsu", length = 1, order = 18)
    public RString honinSeibetsu;
    @ReportItem(name = "honinBirthYMD", length = 10, order = 19)
    public RString honinBirthYMD;
    @ReportItem(name = "honinRenrakuSaki1", length = 14, order = 20)
    public RString honinRenrakuSaki1;
    @ReportItem(name = "hyojicode1", length = 11, order = 21)
    public RString hyojicode1;
    @ReportItem(name = "hyojicode2", length = 11, order = 22)
    public RString hyojicode2;
    @ReportItem(name = "hyojicode3", length = 11, order = 23)
    public RString hyojicode3;
    @ReportItem(name = "honinName", order = 24)
    public RString honinName;
    @ReportItem(name = "honinRenrakuSaki2", length = 14, order = 25)
    public RString honinRenrakuSaki2;
    @ReportItem(name = "honinShotokuDankaiHenko", length = 5, order = 26)
    public RString honinShotokuDankaiHenko;
    @ReportItem(name = "listHonin1_1", length = 9, order = 27)
    public RString listHonin1_1;
    @ReportItem(name = "listHonin1_2", length = 6, order = 28)
    public RString listHonin1_2;
    @ReportItem(name = "listHonin1_3", length = 9, order = 29)
    public RString listHonin1_3;
    @ReportItem(name = "listHonin1_4", length = 6, order = 30)
    public RString listHonin1_4;
    @ReportItem(name = "listHonin1_5", length = 2, order = 31)
    public RString listHonin1_5;
    @ReportItem(name = "listHonin1_6", length = 9, order = 32)
    public RString listHonin1_6;
    @ReportItem(name = "listHonin1_7", length = 9, order = 33)
    public RString listHonin1_7;
    @ReportItem(name = "listHonin1_8", length = 9, order = 34)
    public RString listHonin1_8;
    @ReportItem(name = "listHonin1_9", length = 9, order = 35)
    public RString listHonin1_9;
    @ReportItem(name = "honinTokuchoGimusha", length = 20, order = 36)
    public RString honinTokuchoGimusha;
    @ReportItem(name = "honinTokuchoTaishoNenkin", length = 20, order = 37)
    public RString honinTokuchoTaishoNenkin;
    @ReportItem(name = "dainoninNameKana", order = 38)
    public RString dainoninNameKana;
    @ReportItem(name = "dainoninyubinNo", length = 8, order = 39)
    public RString dainoninyubinNo;
    @ReportItem(name = "dainoninJusho", order = 40)
    public RString dainoninJusho;
    @ReportItem(name = "dainoninRenrakuSaki1", length = 14, order = 41)
    public RString dainoninRenrakuSaki1;
    @ReportItem(name = "dainoninName", order = 42)
    public RString dainoninName;
    @ReportItem(name = "dainoninRenrakuSaki2", length = 14, order = 43)
    public RString dainoninRenrakuSaki2;
    @ReportItem(name = "bankName", order = 44)
    public RString bankName;
    @ReportItem(name = "bankNo", length = 7, order = 45)
    public RString bankNo;
    @ReportItem(name = "honDummy", length = 1, order = 46)
    public RString honDummy;
    @ReportItem(name = "kozaShurui", length = 3, order = 47)
    public RString kozaShurui;
    @ReportItem(name = "listHonin2_1", length = 15, order = 48)
    public RString listHonin2_1;
    @ReportItem(name = "listHonin2_2", length = 35, order = 49)
    public RString listHonin2_2;
    @ReportItem(name = "listHonin2_3", length = 1, order = 50)
    public RString listHonin2_3;
    @ReportItem(name = "listHonin2_4", length = 10, order = 51)
    public RString listHonin2_4;
    @ReportItem(name = "listHonin2_5", length = 9, order = 52)
    public RString listHonin2_5;
    @ReportItem(name = "listHonin2_6", length = 17, order = 53)
    public RString listHonin2_6;
    @ReportItem(name = "listHonin2_7", length = 3, order = 54)
    public RString listHonin2_7;
    @ReportItem(name = "kozaMeiginin", order = 55)
    public RString kozaMeiginin;
    @ReportItem(name = "kozaNo", length = 14, order = 56)
    public RString kozaNo;
    @ReportItem(name = "listSetaiin_1", length = 15, order = 57)
    public RString listSetaiin_1;
    @ReportItem(name = "listSetaiin_2", length = 12, order = 58)
    public RString listSetaiin_2;
    @ReportItem(name = "listSetaiin_3", length = 1, order = 59)
    public RString listSetaiin_3;
    @ReportItem(name = "listSetaiin_4", length = 10, order = 60)
    public RString listSetaiin_4;
    @ReportItem(name = "listSetaiin_5", length = 6, order = 61)
    public RString listSetaiin_5;
    @ReportItem(name = "listSetaiin_6", length = 15, order = 62)
    public RString listSetaiin_6;
    @ReportItem(name = "listSetaiin_7", length = 3, order = 63)
    public RString listSetaiin_7;
    @ReportItem(name = "listSetaiin_8", length = 15, order = 64)
    public RString listSetaiin_8;
    @ReportItem(name = "listSetaiin_9", length = 12, order = 65)
    public RString listSetaiin_9;
    @ReportItem(name = "listSetaiin_10", length = 1, order = 66)
    public RString listSetaiin_10;
    @ReportItem(name = "listSetaiin_11", length = 10, order = 67)
    public RString listSetaiin_11;
    @ReportItem(name = "listSetaiin_12", length = 6, order = 68)
    public RString listSetaiin_12;
    @ReportItem(name = "listSetaiin_13", length = 15, order = 69)
    public RString listSetaiin_13;
    @ReportItem(name = "listSetaiin_14", length = 3, order = 70)
    public RString listSetaiin_14;
    @ReportItem(name = "choteiJiyu1", length = 15, order = 71)
    public RString choteiJiyu1;
    @ReportItem(name = "henkoJiyu1", length = 15, order = 72)
    public RString henkoJiyu1;
    @ReportItem(name = "setDummy", length = 1, order = 73)
    public RString setDummy;
    @ReportItem(name = "choteiJiyu2", length = 15, order = 74)
    public RString choteiJiyu2;
    @ReportItem(name = "henkoJiyu2", length = 15, order = 75)
    public RString henkoJiyu2;
    @ReportItem(name = "choteiJiyu3", length = 15, order = 76)
    public RString choteiJiyu3;
    @ReportItem(name = "henkoJiyu3", length = 15, order = 77)
    public RString henkoJiyu3;
    @ReportItem(name = "choteiJiyu4", length = 15, order = 78)
    public RString choteiJiyu4;
    @ReportItem(name = "henkoJiyu4", length = 15, order = 79)
    public RString henkoJiyu4;
    @ReportItem(name = "listUchiwakei_1", length = 13, order = 80)
    public RString listUchiwakei_1;
    @ReportItem(name = "listUchiwakei_2", length = 13, order = 81)
    public RString listUchiwakei_2;
    @ReportItem(name = "listUchiwakei_3", length = 13, order = 82)
    public RString listUchiwakei_3;
    @ReportItem(name = "listUchiwakei_4", length = 9, order = 83)
    public RString listUchiwakei_4;
    @ReportItem(name = "listUchiwakei_5", length = 9, order = 84)
    public RString listUchiwakei_5;
    @ReportItem(name = "zenNendoShotokuDankai", length = 2, order = 85)
    public RString zenNendoShotokuDankai;
    @ReportItem(name = "zenNendoHokenryoRitsu", length = 13, order = 86)
    public RString zenNendoHokenryoRitsu;
    @ReportItem(name = "zenNendoHokenryoNengaku", length = 13, order = 87)
    public RString zenNendoHokenryoNengaku;
    @ReportItem(name = "zenNendoTochoSaishukiHokenryo", length = 13, order = 88)
    public RString zenNendoTochoSaishukiHokenryo;
    @ReportItem(name = "zenNendoFuchoSaishukiHokenryo", length = 13, order = 89)
    public RString zenNendoFuchoSaishukiHokenryo;
    @ReportItem(name = "tkDummy", length = 1, order = 90)
    public RString tkDummy;
    @ReportItem(name = "listTokuchoKi_1", length = 2, order = 91)
    public RString listTokuchoKi_1;
    @ReportItem(name = "listTokuchoKi_2", length = 2, order = 92)
    public RString listTokuchoKi_2;
    @ReportItem(name = "listTokuchoKi_3", length = 2, order = 93)
    public RString listTokuchoKi_3;
    @ReportItem(name = "listTokuchoKi_4", length = 2, order = 94)
    public RString listTokuchoKi_4;
    @ReportItem(name = "listTokuchoKi_5", length = 2, order = 95)
    public RString listTokuchoKi_5;
    @ReportItem(name = "listTokuchoKi_6", length = 2, order = 96)
    public RString listTokuchoKi_6;
    @ReportItem(name = "listTokuchoKi_7", length = 2, order = 97)
    public RString listTokuchoKi_7;
    @ReportItem(name = "listTokuchoKi_8", length = 2, order = 98)
    public RString listTokuchoKi_8;
    @ReportItem(name = "listTokuchoKi_9", length = 2, order = 99)
    public RString listTokuchoKi_9;
    @ReportItem(name = "listTokuchoKi_10", length = 2, order = 100)
    public RString listTokuchoKi_10;
    @ReportItem(name = "listTokuchoKi_11", length = 2, order = 101)
    public RString listTokuchoKi_11;
    @ReportItem(name = "listTokuchoKi_12", length = 2, order = 102)
    public RString listTokuchoKi_12;
    @ReportItem(name = "listTokuchoKi_13", length = 2, order = 103)
    public RString listTokuchoKi_13;
    @ReportItem(name = "listTokuchoKi_14", length = 2, order = 104)
    public RString listTokuchoKi_14;
    @ReportItem(name = "listTokuchoTsuki_1", length = 2, order = 105)
    public RString listTokuchoTsuki_1;
    @ReportItem(name = "listTokuchoTsuki_2", length = 2, order = 106)
    public RString listTokuchoTsuki_2;
    @ReportItem(name = "listTokuchoTsuki_3", length = 2, order = 107)
    public RString listTokuchoTsuki_3;
    @ReportItem(name = "listTokuchoTsuki_4", length = 2, order = 108)
    public RString listTokuchoTsuki_4;
    @ReportItem(name = "listTokuchoTsuki_5", length = 2, order = 109)
    public RString listTokuchoTsuki_5;
    @ReportItem(name = "listTokuchoTsuki_6", length = 2, order = 110)
    public RString listTokuchoTsuki_6;
    @ReportItem(name = "listTokuchoTsuki_7", length = 2, order = 111)
    public RString listTokuchoTsuki_7;
    @ReportItem(name = "listTokuchoTsuki_8", length = 2, order = 112)
    public RString listTokuchoTsuki_8;
    @ReportItem(name = "listTokuchoTsuki_9", length = 2, order = 113)
    public RString listTokuchoTsuki_9;
    @ReportItem(name = "listTokuchoTsuki_10", length = 2, order = 114)
    public RString listTokuchoTsuki_10;
    @ReportItem(name = "listTokuchoTsuki_11", length = 2, order = 115)
    public RString listTokuchoTsuki_11;
    @ReportItem(name = "listTokuchoTsuki_12", length = 2, order = 116)
    public RString listTokuchoTsuki_12;
    @ReportItem(name = "listTokuchoTsuki_13", length = 2, order = 117)
    public RString listTokuchoTsuki_13;
    @ReportItem(name = "listTokuchoTsuki_14", length = 2, order = 118)
    public RString listTokuchoTsuki_14;
    @ReportItem(name = "listTokuChoshu_1", length = 3, order = 119)
    public RString listTokuChoshu_1;
    @ReportItem(name = "listTokuChoshu_2", length = 5, order = 120)
    public RString listTokuChoshu_2;
    @ReportItem(name = "listTokuChoshu_3", length = 13, order = 121)
    public RString listTokuChoshu_3;
    @ReportItem(name = "listTokuChoshu_4", length = 13, order = 122)
    public RString listTokuChoshu_4;
    @ReportItem(name = "listTokuChoshu_5", length = 13, order = 123)
    public RString listTokuChoshu_5;
    @ReportItem(name = "listTokuChoshu_6", length = 7, order = 124)
    public RString listTokuChoshu_6;
    @ReportItem(name = "listTokuChoshu_7", length = 7, order = 125)
    public RString listTokuChoshu_7;
    @ReportItem(name = "listTokuChoshu_8", length = 7, order = 126)
    public RString listTokuChoshu_8;
    @ReportItem(name = "listTokuChoshu_9", length = 7, order = 127)
    public RString listTokuChoshu_9;
    @ReportItem(name = "listTokuChoshu_10", length = 7, order = 128)
    public RString listTokuChoshu_10;
    @ReportItem(name = "listTokuChoshu_11", length = 7, order = 129)
    public RString listTokuChoshu_11;
    @ReportItem(name = "listTokuChoshu_12", length = 7, order = 130)
    public RString listTokuChoshu_12;
    @ReportItem(name = "listTokuChoshu_13", length = 7, order = 131)
    public RString listTokuChoshu_13;
    @ReportItem(name = "listTokuChoshu_14", length = 7, order = 132)
    public RString listTokuChoshu_14;
    @ReportItem(name = "listTokuChoshu_15", length = 7, order = 133)
    public RString listTokuChoshu_15;
    @ReportItem(name = "listTokuChoshu_16", length = 7, order = 134)
    public RString listTokuChoshu_16;
    @ReportItem(name = "listTokuChoshu_17", length = 7, order = 135)
    public RString listTokuChoshu_17;
    @ReportItem(name = "listTokuChoshu_18", length = 7, order = 136)
    public RString listTokuChoshu_18;
    @ReportItem(name = "listTokuChoshu_19", length = 7, order = 137)
    public RString listTokuChoshu_19;
    @ReportItem(name = "listFuchoZuiji_1", length = 2, order = 138)
    public RString listFuchoZuiji_1;
    @ReportItem(name = "listFuchoZuiji_2", length = 2, order = 139)
    public RString listFuchoZuiji_2;
    @ReportItem(name = "listFuchoZuiji_3", length = 2, order = 140)
    public RString listFuchoZuiji_3;
    @ReportItem(name = "listFuchoZuiji_4", length = 2, order = 141)
    public RString listFuchoZuiji_4;
    @ReportItem(name = "listFuchoZuiji_5", length = 2, order = 142)
    public RString listFuchoZuiji_5;
    @ReportItem(name = "listFuchoZuiji_6", length = 2, order = 143)
    public RString listFuchoZuiji_6;
    @ReportItem(name = "listFuchoZuiji_7", length = 2, order = 144)
    public RString listFuchoZuiji_7;
    @ReportItem(name = "listFuchoZuiji_8", length = 2, order = 145)
    public RString listFuchoZuiji_8;
    @ReportItem(name = "listFuchoZuiji_9", length = 2, order = 146)
    public RString listFuchoZuiji_9;
    @ReportItem(name = "listFuchoZuiji_10", length = 2, order = 147)
    public RString listFuchoZuiji_10;
    @ReportItem(name = "listFuchoZuiji_11", length = 2, order = 148)
    public RString listFuchoZuiji_11;
    @ReportItem(name = "listFuchoZuiji_12", length = 2, order = 149)
    public RString listFuchoZuiji_12;
    @ReportItem(name = "listFuchoZuiji_13", length = 2, order = 150)
    public RString listFuchoZuiji_13;
    @ReportItem(name = "listFuchoZuiji_14", length = 2, order = 151)
    public RString listFuchoZuiji_14;
    @ReportItem(name = "fuDummy", length = 1, order = 152)
    public RString fuDummy;
    @ReportItem(name = "listFuchoTsuki_1", length = 2, order = 153)
    public RString listFuchoTsuki_1;
    @ReportItem(name = "listFuchoTsuki_2", length = 2, order = 154)
    public RString listFuchoTsuki_2;
    @ReportItem(name = "listFuchoTsuki_3", length = 2, order = 155)
    public RString listFuchoTsuki_3;
    @ReportItem(name = "listFuchoTsuki_4", length = 2, order = 156)
    public RString listFuchoTsuki_4;
    @ReportItem(name = "listFuchoTsuki_5", length = 2, order = 157)
    public RString listFuchoTsuki_5;
    @ReportItem(name = "listFuchoTsuki_6", length = 2, order = 158)
    public RString listFuchoTsuki_6;
    @ReportItem(name = "listFuchoTsuki_7", length = 2, order = 159)
    public RString listFuchoTsuki_7;
    @ReportItem(name = "listFuchoTsuki_8", length = 2, order = 160)
    public RString listFuchoTsuki_8;
    @ReportItem(name = "listFuchoTsuki_9", length = 2, order = 161)
    public RString listFuchoTsuki_9;
    @ReportItem(name = "listFuchoTsuki_10", length = 2, order = 162)
    public RString listFuchoTsuki_10;
    @ReportItem(name = "listFuchoTsuki_11", length = 2, order = 163)
    public RString listFuchoTsuki_11;
    @ReportItem(name = "listFuchoTsuki_12", length = 2, order = 164)
    public RString listFuchoTsuki_12;
    @ReportItem(name = "listFuchoTsuki_13", length = 2, order = 165)
    public RString listFuchoTsuki_13;
    @ReportItem(name = "listFuchoTsuki_14", length = 2, order = 166)
    public RString listFuchoTsuki_14;
    @ReportItem(name = "listFuchoKi_1", length = 2, order = 167)
    public RString listFuchoKi_1;
    @ReportItem(name = "listFuchoKi_2", length = 2, order = 168)
    public RString listFuchoKi_2;
    @ReportItem(name = "listFuchoKi_3", length = 2, order = 169)
    public RString listFuchoKi_3;
    @ReportItem(name = "listFuchoKi_4", length = 2, order = 170)
    public RString listFuchoKi_4;
    @ReportItem(name = "listFuchoKi_5", length = 2, order = 171)
    public RString listFuchoKi_5;
    @ReportItem(name = "listFuchoKi_6", length = 2, order = 172)
    public RString listFuchoKi_6;
    @ReportItem(name = "listFuchoKi_7", length = 2, order = 173)
    public RString listFuchoKi_7;
    @ReportItem(name = "listFuchoKi_8", length = 2, order = 174)
    public RString listFuchoKi_8;
    @ReportItem(name = "listFuchoKi_9", length = 2, order = 175)
    public RString listFuchoKi_9;
    @ReportItem(name = "listFuchoKi_10", length = 2, order = 176)
    public RString listFuchoKi_10;
    @ReportItem(name = "listFuchoKi_11", length = 2, order = 177)
    public RString listFuchoKi_11;
    @ReportItem(name = "listFuchoKi_12", length = 2, order = 178)
    public RString listFuchoKi_12;
    @ReportItem(name = "listFuchoKi_13", length = 2, order = 179)
    public RString listFuchoKi_13;
    @ReportItem(name = "listFuchoKi_14", length = 2, order = 180)
    public RString listFuchoKi_14;
    @ReportItem(name = "listFutsuChoshu_1", length = 3, order = 181)
    public RString listFutsuChoshu_1;
    @ReportItem(name = "listFutsuChoshu_2", length = 5, order = 182)
    public RString listFutsuChoshu_2;
    @ReportItem(name = "listFutsuChoshu_3", length = 13, order = 183)
    public RString listFutsuChoshu_3;
    @ReportItem(name = "listFutsuChoshu_4", length = 13, order = 184)
    public RString listFutsuChoshu_4;
    @ReportItem(name = "listFutsuChoshu_5", length = 13, order = 185)
    public RString listFutsuChoshu_5;
    @ReportItem(name = "listFutsuChoshu_6", length = 7, order = 186)
    public RString listFutsuChoshu_6;
    @ReportItem(name = "listFutsuChoshu_7", length = 7, order = 187)
    public RString listFutsuChoshu_7;
    @ReportItem(name = "listFutsuChoshu_8", length = 7, order = 188)
    public RString listFutsuChoshu_8;
    @ReportItem(name = "listFutsuChoshu_9", length = 7, order = 189)
    public RString listFutsuChoshu_9;
    @ReportItem(name = "listFutsuChoshu_10", length = 7, order = 190)
    public RString listFutsuChoshu_10;
    @ReportItem(name = "listFutsuChoshu_11", length = 7, order = 191)
    public RString listFutsuChoshu_11;
    @ReportItem(name = "listFutsuChoshu_12", length = 7, order = 192)
    public RString listFutsuChoshu_12;
    @ReportItem(name = "listFutsuChoshu_13", length = 7, order = 193)
    public RString listFutsuChoshu_13;
    @ReportItem(name = "listFutsuChoshu_14", length = 7, order = 194)
    public RString listFutsuChoshu_14;
    @ReportItem(name = "listFutsuChoshu_15", length = 7, order = 195)
    public RString listFutsuChoshu_15;
    @ReportItem(name = "listFutsuChoshu_16", length = 7, order = 196)
    public RString listFutsuChoshu_16;
    @ReportItem(name = "listFutsuChoshu_17", length = 7, order = 197)
    public RString listFutsuChoshu_17;
    @ReportItem(name = "listFutsuChoshu_18", length = 7, order = 198)
    public RString listFutsuChoshu_18;
    @ReportItem(name = "listFutsuChoshu_19", length = 7, order = 199)
    public RString listFutsuChoshu_19;
    @ReportItem(name = "jukyuJoho", length = 50, order = 200)
    public RString jukyuJoho;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
