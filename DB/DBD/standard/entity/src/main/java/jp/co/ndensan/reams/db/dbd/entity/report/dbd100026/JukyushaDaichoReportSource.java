package jp.co.ndensan.reams.db.dbd.entity.report.dbd100026;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 受給者台帳ReportSourceです。
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
public class JukyushaDaichoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hihokenshaPage", length = 10, order = 2)
    public RString hihokenshaPage;
    @ReportItem(name = "shoHokenshaName", order = 3)
    public RString shoHokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 10, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 6)
    public RString hihokenshaNo;
    @ReportItem(name = "shoHokenshaNo", length = 6, order = 7)
    public RString shoHokenshaNo;
    @ReportItem(name = "genJotai", length = 5, order = 8)
    public RString genJotai;
    @ReportItem(name = "telTitle1", length = 6, order = 9)
    public RString telTitle1;
    @ReportItem(name = "telNo1", length = 20, order = 10)
    public RString telNo1;
    @ReportItem(name = "hihokenshaNameKana", order = 11)
    public RString hihokenshaNameKana;
    @ReportItem(name = "sonotaTitle1", length = 5, order = 12)
    public RString sonotaTitle1;
    @ReportItem(name = "chikuCode1", length = 8, order = 13)
    public RString chikuCode1;
    @ReportItem(name = "seibetsu", length = 1, order = 14)
    public RString seibetsu;
    @ReportItem(name = "birthYMD", length = 10, order = 15)
    public RString birthYMD;
    @ReportItem(name = "hiHokenshaName", order = 16)
    public RString hiHokenshaName;
    @ReportItem(name = "gyoseikuCode", length = 9, order = 17)
    public RString gyoseikuCode;
    @ReportItem(name = "telTitle2", length = 6, order = 18)
    public RString telTitle2;
    @ReportItem(name = "telNo2", length = 20, order = 19)
    public RString telNo2;
    @ReportItem(name = "sonotaTitle2", length = 5, order = 20)
    public RString sonotaTitle2;
    @ReportItem(name = "chikuCode2", length = 8, order = 21)
    public RString chikuCode2;
    @ReportItem(name = "rokenCityName", order = 22)
    public RString rokenCityName;
    @ReportItem(name = "setaiCode", length = 15, order = 23)
    public RString setaiCode;
    @ReportItem(name = "rokenCityCode", length = 8, order = 24)
    public RString rokenCityCode;
    @ReportItem(name = "hihokenshaJusho", order = 25)
    public RString hihokenshaJusho;
    @ReportItem(name = "gyoseikuName", order = 26)
    public RString gyoseikuName;
    @ReportItem(name = "hihokenshaJushoCode", length = 11, order = 27)
    public RString hihokenshaJushoCode;
    @ReportItem(name = "sonotaTitle3", length = 5, order = 28)
    public RString sonotaTitle3;
    @ReportItem(name = "chikuCode3", length = 8, order = 29)
    public RString chikuCode3;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 30)
    public RString shikibetsuCode;
    @ReportItem(name = "rokenJukyuCode", length = 7, order = 31)
    public RString rokenJukyuCode;
    @ReportItem(name = "ninteiKbn", length = 1, order = 32)
    public RString ninteiKbn;
    @ReportItem(name = "listNinteiCenter_1", length = 2, order = 33)
    public RString listNinteiCenter_1;
    @ReportItem(name = "listNinteiCenter_2", length = 14, order = 34)
    public RString listNinteiCenter_2;
    @ReportItem(name = "listNinteiCenter_3", length = 8, order = 35)
    public RString listNinteiCenter_3;
    @ReportItem(name = "listNinteiCenter_4", length = 9, order = 36)
    public RString listNinteiCenter_4;
    @ReportItem(name = "listNinteiCenter_5", length = 9, order = 37)
    public RString listNinteiCenter_5;
    @ReportItem(name = "listNinteiCenter_6", length = 9, order = 38)
    public RString listNinteiCenter_6;
    @ReportItem(name = "listNinteiCenter_7", length = 9, order = 39)
    public RString listNinteiCenter_7;
    @ReportItem(name = "listNinteiCenter_8", length = 9, order = 40)
    public RString listNinteiCenter_8;
    @ReportItem(name = "listNinteiCenter_9", length = 9, order = 41)
    public RString listNinteiCenter_9;
    @ReportItem(name = "listNinteiCenter_10", length = 9, order = 42)
    public RString listNinteiCenter_10;
    @ReportItem(name = "listNinteiCenter_11", length = 9, order = 43)
    public RString listNinteiCenter_11;
    @ReportItem(name = "listNinteiCenter_12", length = 38, order = 44)
    public RString listNinteiCenter_12;
    @ReportItem(name = "listNinteiCenter_13", length = 19, order = 45)
    public RString listNinteiCenter_13;
    @ReportItem(name = "listNinteiCenter_14", length = 60, order = 46)
    public RString listNinteiCenter_14;
    @ReportItem(name = "listNinteiLower_1", length = 14, order = 47)
    public RString listNinteiLower_1;
    @ReportItem(name = "listNinteiUpper_1", length = 9, order = 48)
    public RString listNinteiUpper_1;
    @ReportItem(name = "listNinteiLower_2", length = 8, order = 49)
    public RString listNinteiLower_2;
    @ReportItem(name = "listNinteiUpper_2", length = 9, order = 50)
    public RString listNinteiUpper_2;
    @ReportItem(name = "listNinteiLower_3", length = 9, order = 51)
    public RString listNinteiLower_3;
    @ReportItem(name = "listNinteiUpper_3", length = 5, order = 52)
    public RString listNinteiUpper_3;
    @ReportItem(name = "listNinteiLower_4", length = 9, order = 53)
    public RString listNinteiLower_4;
    @ReportItem(name = "listNinteiUpper_4", length = 9, order = 54)
    public RString listNinteiUpper_4;
    @ReportItem(name = "listNinteiLower_5", length = 9, order = 55)
    public RString listNinteiLower_5;
    @ReportItem(name = "listNinteiUpper_5", length = 9, order = 56)
    public RString listNinteiUpper_5;
    @ReportItem(name = "listNinteiLower_6", length = 9, order = 57)
    public RString listNinteiLower_6;
    @ReportItem(name = "listNinteiUpper_6", length = 9, order = 58)
    public RString listNinteiUpper_6;
    @ReportItem(name = "listNinteiLower_7", length = 9, order = 59)
    public RString listNinteiLower_7;
    @ReportItem(name = "listNinteiUpper_7", length = 9, order = 60)
    public RString listNinteiUpper_7;
    @ReportItem(name = "listNinteiLower_8", length = 5, order = 61)
    public RString listNinteiLower_8;
    @ReportItem(name = "listNinteiUpper_8", length = 9, order = 62)
    public RString listNinteiUpper_8;
    @ReportItem(name = "listNinteiLower_9", length = 5, order = 63)
    public RString listNinteiLower_9;
    @ReportItem(name = "listNinteiUpper_9", length = 5, order = 64)
    public RString listNinteiUpper_9;
    @ReportItem(name = "listNinteiLower_10", length = 9, order = 65)
    public RString listNinteiLower_10;
    @ReportItem(name = "listNinteiUpper_10", length = 5, order = 66)
    public RString listNinteiUpper_10;
    @ReportItem(name = "listNinteiLower_11", length = 38, order = 67)
    public RString listNinteiLower_11;
    @ReportItem(name = "listNinteiUpper_11", length = 14, order = 68)
    public RString listNinteiUpper_11;
    @ReportItem(name = "listNinteiLower_12", length = 19, order = 69)
    public RString listNinteiLower_12;
    @ReportItem(name = "listNinteiUpper_12", length = 10, order = 70)
    public RString listNinteiUpper_12;
    @ReportItem(name = "listNinteiLower_13", length = 2, order = 71)
    public RString listNinteiLower_13;
    @ReportItem(name = "listNinteiUpper_13", length = 15, order = 72)
    public RString listNinteiUpper_13;
    @ReportItem(name = "listNinteiUpper_14", length = 10, order = 73)
    public RString listNinteiUpper_14;
    @ReportItem(name = "listNinteiUpper_15", length = 3, order = 74)
    public RString listNinteiUpper_15;
    @ReportItem(name = "listNinteiUpper_16", length = 2, order = 75)
    public RString listNinteiUpper_16;
    @ReportItem(name = "futanGendogakuNinteiKbn", length = 1, order = 76)
    public RString futanGendogakuNinteiKbn;
    @ReportItem(name = "shaFukuKeigenKbn", length = 1, order = 77)
    public RString shaFukuKeigenKbn;
    @ReportItem(name = "listFutanGendogakuNintei_1", length = 2, order = 78)
    public RString listFutanGendogakuNintei_1;
    @ReportItem(name = "listFutanGendogakuNintei_2", length = 9, order = 79)
    public RString listFutanGendogakuNintei_2;
    @ReportItem(name = "listFutanGendogakuNintei_3", length = 10, order = 80)
    public RString listFutanGendogakuNintei_3;
    @ReportItem(name = "listFutanGendogakuNintei_4", length = 9, order = 81)
    public RString listFutanGendogakuNintei_4;
    @ReportItem(name = "listFutanGendogakuNintei_5", length = 9, order = 82)
    public RString listFutanGendogakuNintei_5;
    @ReportItem(name = "listFutanGendogakuNintei_6", length = 9, order = 83)
    public RString listFutanGendogakuNintei_6;
    @ReportItem(name = "listFutanGendogakuNintei_7", length = 4, order = 84)
    public RString listFutanGendogakuNintei_7;
    @ReportItem(name = "listFutanGendogakuNintei_8", length = 4, order = 85)
    public RString listFutanGendogakuNintei_8;
    @ReportItem(name = "listFutanGendogakuNintei_9", length = 4, order = 86)
    public RString listFutanGendogakuNintei_9;
    @ReportItem(name = "listFutanGendogakuNintei_10", length = 6, order = 87)
    public RString listFutanGendogakuNintei_10;
    @ReportItem(name = "listFutanGendogakuNintei_11", length = 6, order = 88)
    public RString listFutanGendogakuNintei_11;
    @ReportItem(name = "listFutanGendogakuNintei_12", length = 6, order = 89)
    public RString listFutanGendogakuNintei_12;
    @ReportItem(name = "listFutanGendogakuNintei_13", length = 6, order = 90)
    public RString listFutanGendogakuNintei_13;
    @ReportItem(name = "listFutanGendogakuNintei_14", length = 6, order = 91)
    public RString listFutanGendogakuNintei_14;
    @ReportItem(name = "listFutanGendogakuNintei_15", length = 6, order = 92)
    public RString listFutanGendogakuNintei_15;
    @ReportItem(name = "listFutanGendogakuNintei_16", length = 2, order = 93)
    public RString listFutanGendogakuNintei_16;
    @ReportItem(name = "listFutanGendogakuNintei_17", length = 2, order = 94)
    public RString listFutanGendogakuNintei_17;
    @ReportItem(name = "listShaFukuKeigen_1", length = 2, order = 95)
    public RString listShaFukuKeigen_1;
    @ReportItem(name = "listShaFukuKeigen_2", length = 9, order = 96)
    public RString listShaFukuKeigen_2;
    @ReportItem(name = "listShaFukuKeigen_3", length = 9, order = 97)
    public RString listShaFukuKeigen_3;
    @ReportItem(name = "listShaFukuKeigen_4", length = 9, order = 98)
    public RString listShaFukuKeigen_4;
    @ReportItem(name = "listShaFukuKeigen_5", length = 9, order = 99)
    public RString listShaFukuKeigen_5;
    @ReportItem(name = "listShaFukuKeigen_6", length = 10, order = 100)
    public RString listShaFukuKeigen_6;
    @ReportItem(name = "listShaFukuKeigen_7", length = 6, order = 101)
    public RString listShaFukuKeigen_7;
    @ReportItem(name = "listShaFukuKeigen_8", length = 2, order = 102)
    public RString listShaFukuKeigen_8;
    @ReportItem(name = "listShaFukuKeigen_9", length = 2, order = 103)
    public RString listShaFukuKeigen_9;
    @ReportItem(name = "listShaFukuKeigen_10", length = 2, order = 104)
    public RString listShaFukuKeigen_10;
    @ReportItem(name = "riyoshaFutanGenmenKbn", length = 1, order = 105)
    public RString riyoshaFutanGenmenKbn;
    @ReportItem(name = "honmonKaigoRiyoshaFutanGengakuKbn", length = 1, order = 106)
    public RString honmonKaigoRiyoshaFutanGengakuKbn;
    @ReportItem(name = "hyojunFutanGengakuKbn", length = 1, order = 107)
    public RString hyojunFutanGengakuKbn;
    @ReportItem(name = "tokubetsuChiikiKasanGenmenKbn", length = 1, order = 108)
    public RString tokubetsuChiikiKasanGenmenKbn;
    @ReportItem(name = "listRiyoshaFutanGenmen_1", length = 2, order = 109)
    public RString listRiyoshaFutanGenmen_1;
    @ReportItem(name = "listRiyoshaFutanGenmen_2", length = 9, order = 110)
    public RString listRiyoshaFutanGenmen_2;
    @ReportItem(name = "listRiyoshaFutanGenmen_3", length = 9, order = 111)
    public RString listRiyoshaFutanGenmen_3;
    @ReportItem(name = "listRiyoshaFutanGenmen_4", length = 9, order = 112)
    public RString listRiyoshaFutanGenmen_4;
    @ReportItem(name = "listRiyoshaFutanGenmen_5", length = 9, order = 113)
    public RString listRiyoshaFutanGenmen_5;
    @ReportItem(name = "listRiyoshaFutanGenmen_6", length = 4, order = 114)
    public RString listRiyoshaFutanGenmen_6;
    @ReportItem(name = "listHonmonKaigoRiyoshaFutanGengaku_1", length = 2, order = 115)
    public RString listHonmonKaigoRiyoshaFutanGengaku_1;
    @ReportItem(name = "listHonmonKaigoRiyoshaFutanGengaku_2", length = 9, order = 116)
    public RString listHonmonKaigoRiyoshaFutanGengaku_2;
    @ReportItem(name = "listHonmonKaigoRiyoshaFutanGengaku_3", length = 9, order = 117)
    public RString listHonmonKaigoRiyoshaFutanGengaku_3;
    @ReportItem(name = "listHonmonKaigoRiyoshaFutanGengaku_4", length = 9, order = 118)
    public RString listHonmonKaigoRiyoshaFutanGengaku_4;
    @ReportItem(name = "listHonmonKaigoRiyoshaFutanGengaku_5", length = 9, order = 119)
    public RString listHonmonKaigoRiyoshaFutanGengaku_5;
    @ReportItem(name = "listHonmonKaigoRiyoshaFutanGengaku_6", length = 4, order = 120)
    public RString listHonmonKaigoRiyoshaFutanGengaku_6;
    @ReportItem(name = "listHonmonKaigoRiyoshaFutanGengaku_7", length = 2, order = 121)
    public RString listHonmonKaigoRiyoshaFutanGengaku_7;
    @ReportItem(name = "listHonmonKaigoRiyoshaFutanGengaku_8", length = 7, order = 122)
    public RString listHonmonKaigoRiyoshaFutanGengaku_8;
    @ReportItem(name = "listHyojunFutanGengaku_1", length = 2, order = 123)
    public RString listHyojunFutanGengaku_1;
    @ReportItem(name = "listHyojunFutanGengaku_2", length = 9, order = 124)
    public RString listHyojunFutanGengaku_2;
    @ReportItem(name = "listHyojunFutanGengaku_3", length = 9, order = 125)
    public RString listHyojunFutanGengaku_3;
    @ReportItem(name = "listHyojunFutanGengaku_4", length = 9, order = 126)
    public RString listHyojunFutanGengaku_4;
    @ReportItem(name = "listHyojunFutanGengaku_5", length = 9, order = 127)
    public RString listHyojunFutanGengaku_5;
    @ReportItem(name = "listHyojunFutanGengaku_6", length = 6, order = 128)
    public RString listHyojunFutanGengaku_6;
    @ReportItem(name = "listTokubetsuChiikiKasanGenmen_1", length = 2, order = 129)
    public RString listTokubetsuChiikiKasanGenmen_1;
    @ReportItem(name = "listTokubetsuChiikiKasanGenmen_2", length = 9, order = 130)
    public RString listTokubetsuChiikiKasanGenmen_2;
    @ReportItem(name = "listTokubetsuChiikiKasanGenmen_3", length = 9, order = 131)
    public RString listTokubetsuChiikiKasanGenmen_3;
    @ReportItem(name = "listTokubetsuChiikiKasanGenmen_4", length = 9, order = 132)
    public RString listTokubetsuChiikiKasanGenmen_4;
    @ReportItem(name = "listTokubetsuChiikiKasanGenmen_5", length = 9, order = 133)
    public RString listTokubetsuChiikiKasanGenmen_5;
    @ReportItem(name = "listTokubetsuChiikiKasanGenmen_6", length = 4, order = 134)
    public RString listTokubetsuChiikiKasanGenmen_6;
    @ReportItem(name = "listTokubetsuChiikiKasanGenmen_7", length = 10, order = 135)
    public RString listTokubetsuChiikiKasanGenmen_7;
    @ReportItem(name = "shisetsuNyutaishoKbn", length = 1, order = 136)
    public RString shisetsuNyutaishoKbn;
    @ReportItem(name = "kyotakuKeikakuKbn", length = 1, order = 137)
    public RString kyotakuKeikakuKbn;
    @ReportItem(name = "listShisetsuNyutaisho_1", length = 2, order = 138)
    public RString listShisetsuNyutaisho_1;
    @ReportItem(name = "listShisetsuNyutaisho_2", length = 9, order = 139)
    public RString listShisetsuNyutaisho_2;
    @ReportItem(name = "listShisetsuNyutaisho_3", length = 9, order = 140)
    public RString listShisetsuNyutaisho_3;
    @ReportItem(name = "listShisetsuNyutaisho_4", length = 10, order = 141)
    public RString listShisetsuNyutaisho_4;
    @ReportItem(name = "listShisetsuNyutaisho_5", length = 25, order = 142)
    public RString listShisetsuNyutaisho_5;
    @ReportItem(name = "listShisetsuNyutaisho_6", length = 20, order = 143)
    public RString listShisetsuNyutaisho_6;
    @ReportItem(name = "listKyotakuKeikaku_1", length = 2, order = 144)
    public RString listKyotakuKeikaku_1;
    @ReportItem(name = "listKyotakuKeikaku_2", length = 7, order = 145)
    public RString listKyotakuKeikaku_2;
    @ReportItem(name = "listKyotakuKeikaku_3", length = 2, order = 146)
    public RString listKyotakuKeikaku_3;
    @ReportItem(name = "listKyotakuKeikaku_4", length = 2, order = 147)
    public RString listKyotakuKeikaku_4;
    @ReportItem(name = "listKyotakuKeikaku_5", length = 9, order = 148)
    public RString listKyotakuKeikaku_5;
    @ReportItem(name = "listKyotakuKeikaku_6", length = 9, order = 149)
    public RString listKyotakuKeikaku_6;
    @ReportItem(name = "listKyotakuKeikaku_7", length = 9, order = 150)
    public RString listKyotakuKeikaku_7;
    @ReportItem(name = "listKyotakuKeikaku_8", length = 9, order = 151)
    public RString listKyotakuKeikaku_8;
    @ReportItem(name = "listKyotakuKeikaku_9", length = 10, order = 152)
    public RString listKyotakuKeikaku_9;
    @ReportItem(name = "listKyotakuKeikaku_10", length = 29, order = 153)
    public RString listKyotakuKeikaku_10;
    @ReportItem(name = "listKyotakuKeikaku_11", length = 20, order = 154)
    public RString listKyotakuKeikaku_11;
    @ReportItem(name = "tokureiShisetsuNyutaishoKbn", length = 1, order = 155)
    public RString tokureiShisetsuNyutaishoKbn;
    @ReportItem(name = "shiharaiHohoHenkoKbn", length = 1, order = 156)
    public RString shiharaiHohoHenkoKbn;
    @ReportItem(name = "kyufugakuGengakuKbn", length = 1, order = 157)
    public RString kyufugakuGengakuKbn;
    @ReportItem(name = "listTokureiShisetsuNyutaisho_1", length = 2, order = 158)
    public RString listTokureiShisetsuNyutaisho_1;
    @ReportItem(name = "listTokureiShisetsuNyutaisho_2", length = 9, order = 159)
    public RString listTokureiShisetsuNyutaisho_2;
    @ReportItem(name = "listTokureiShisetsuNyutaisho_3", length = 9, order = 160)
    public RString listTokureiShisetsuNyutaisho_3;
    @ReportItem(name = "listTokureiShisetsuNyutaisho_4", length = 10, order = 161)
    public RString listTokureiShisetsuNyutaisho_4;
    @ReportItem(name = "listTokureiShisetsuNyutaisho_5", length = 25, order = 162)
    public RString listTokureiShisetsuNyutaisho_5;
    @ReportItem(name = "listTokureiShisetsuNyutaisho_6", length = 20, order = 163)
    public RString listTokureiShisetsuNyutaisho_6;
    @ReportItem(name = "listShiharaiHohoHenko_1", length = 2, order = 164)
    public RString listShiharaiHohoHenko_1;
    @ReportItem(name = "listShiharaiHohoHenko_2", length = 4, order = 165)
    public RString listShiharaiHohoHenko_2;
    @ReportItem(name = "listShiharaiHohoHenko_3", length = 9, order = 166)
    public RString listShiharaiHohoHenko_3;
    @ReportItem(name = "listShiharaiHohoHenko_4", length = 9, order = 167)
    public RString listShiharaiHohoHenko_4;
    @ReportItem(name = "listShiharaiHohoHenko_5", length = 9, order = 168)
    public RString listShiharaiHohoHenko_5;
    @ReportItem(name = "listShiharaiHohoHenko_6", length = 2, order = 169)
    public RString listShiharaiHohoHenko_6;
    @ReportItem(name = "listShiharaiHohoHenko_7", length = 7, order = 170)
    public RString listShiharaiHohoHenko_7;
    @ReportItem(name = "listShiharaiHohoHenko_8", length = 10, order = 171)
    public RString listShiharaiHohoHenko_8;
    @ReportItem(name = "listShiharaiHohoHenko_9", length = 1, order = 172)
    public RString listShiharaiHohoHenko_9;
    @ReportItem(name = "listKyufugakuGengaku_1", length = 2, order = 173)
    public RString listKyufugakuGengaku_1;
    @ReportItem(name = "listKyufugakuGengaku_2", length = 4, order = 174)
    public RString listKyufugakuGengaku_2;
    @ReportItem(name = "listKyufugakuGengaku_3", length = 9, order = 175)
    public RString listKyufugakuGengaku_3;
    @ReportItem(name = "listKyufugakuGengaku_4", length = 9, order = 176)
    public RString listKyufugakuGengaku_4;
    @ReportItem(name = "listKyufugakuGengaku_5", length = 4, order = 177)
    public RString listKyufugakuGengaku_5;
    @ReportItem(name = "listKyufugakuGengaku_6", length = 7, order = 178)
    public RString listKyufugakuGengaku_6;
    @ReportItem(name = "listKyufugakuGengaku_7", length = 7, order = 179)
    public RString listKyufugakuGengaku_7;
    @ReportItem(name = "listKyufugakuGengaku_8", length = 4, order = 180)
    public RString listKyufugakuGengaku_8;
    @ReportItem(name = "shikakuKbn", length = 1, order = 181)
    public RString shikakuKbn;
    @ReportItem(name = "roreiFukushiNenkinKbn", length = 1, order = 182)
    public RString roreiFukushiNenkinKbn;
    @ReportItem(name = "seikatsuHogoKbn", length = 1, order = 183)
    public RString seikatsuHogoKbn;
    @ReportItem(name = "listShikaku_1", length = 2, order = 184)
    public RString listShikaku_1;
    @ReportItem(name = "listShikaku_2", length = 9, order = 185)
    public RString listShikaku_2;
    @ReportItem(name = "listShikaku_3", length = 9, order = 186)
    public RString listShikaku_3;
    @ReportItem(name = "listShikaku_4", length = 7, order = 187)
    public RString listShikaku_4;
    @ReportItem(name = "listShikaku_5", length = 9, order = 188)
    public RString listShikaku_5;
    @ReportItem(name = "listShikaku_6", length = 9, order = 189)
    public RString listShikaku_6;
    @ReportItem(name = "listShikaku_7", length = 7, order = 190)
    public RString listShikaku_7;
    @ReportItem(name = "listShikaku_8", length = 9, order = 191)
    public RString listShikaku_8;
    @ReportItem(name = "listShikaku_9", length = 9, order = 192)
    public RString listShikaku_9;
    @ReportItem(name = "listShikaku_10", length = 7, order = 193)
    public RString listShikaku_10;
    @ReportItem(name = "listShikaku_11", length = 9, order = 194)
    public RString listShikaku_11;
    @ReportItem(name = "listShikaku_12", length = 9, order = 195)
    public RString listShikaku_12;
    @ReportItem(name = "listShikaku_13", length = 7, order = 196)
    public RString listShikaku_13;
    @ReportItem(name = "listShikaku_14", length = 9, order = 197)
    public RString listShikaku_14;
    @ReportItem(name = "listShikaku_15", length = 9, order = 198)
    public RString listShikaku_15;
    @ReportItem(name = "listShikaku_16", length = 7, order = 199)
    public RString listShikaku_16;
    @ReportItem(name = "listRoreiFukushiNenkin_1", length = 2, order = 200)
    public RString listRoreiFukushiNenkin_1;
    @ReportItem(name = "listRoreiFukushiNenkin_2", length = 9, order = 201)
    public RString listRoreiFukushiNenkin_2;
    @ReportItem(name = "listRoreiFukushiNenkin_3", length = 9, order = 202)
    public RString listRoreiFukushiNenkin_3;
    @ReportItem(name = "listSeikatsuHogo_1", length = 2, order = 203)
    public RString listSeikatsuHogo_1;
    @ReportItem(name = "listSeikatsuHogo_2", length = 9, order = 204)
    public RString listSeikatsuHogo_2;
    @ReportItem(name = "listSeikatsuHogo_3", length = 9, order = 205)
    public RString listSeikatsuHogo_3;
    @ReportItem(name = "listSeikatsuHogo_4", length = 5, order = 206)
    public RString listSeikatsuHogo_4;
    @ReportItem(name = "nigoIryoShurui", length = 11, order = 207)
    public RString nigoIryoShurui;
    @ReportItem(name = "nigoHokenshaName", length = 18, order = 208)
    public RString nigoHokenshaName;
    @ReportItem(name = "chokukinKanrihyo", length = 6, order = 209)
    public RString chokukinKanrihyo;
    @ReportItem(name = "chokukinKogaku", length = 6, order = 210)
    public RString chokukinKogaku;
    @ReportItem(name = "homonChosaSakiYubinno", length = 8, order = 211)
    public RString homonChosaSakiYubinno;
    @ReportItem(name = "homonChosaSakiJusho", length = 46, order = 212)
    public RString homonChosaSakiJusho;
    @ReportItem(name = "homonChosaSakiTelNo", length = 20, order = 213)
    public RString homonChosaSakiTelNo;
    @ReportItem(name = "nigoHokenshaNo", length = 8, order = 214)
    public RString nigoHokenshaNo;
    @ReportItem(name = "nigoBango", length = 18, order = 215)
    public RString nigoBango;
    @ReportItem(name = "chokukinJiseki", length = 6, order = 216)
    public RString chokukinJiseki;
    @ReportItem(name = "chokukinShokan", length = 6, order = 217)
    public RString chokukinShokan;
    @ReportItem(name = "chokukinShotokuDankai", length = 12, order = 218)
    public RString chokukinShotokuDankai;
    @ReportItem(name = "homonChosaSakiName", length = 35, order = 219)
    public RString homonChosaSakiName;
    @ReportItem(name = "biko", length = 36, order = 220)
    public RString biko;
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

        hokenshaNo
    }

}
