package jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 前回認定調査結果との比較表のReportSourceです。
 */
public class ChosahyoSaiCheckhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 15, order = 1)
    public RString title;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 2)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", length = 20, order = 3)
    public RString hihokenshaName;
    @ReportItem(name = "PageCount", length = 10, order = 4)
    public RString PageCount;
    @ReportItem(name = "printTimeStamp", length = 34, order = 5)
    public RString printTimeStamp;
    @ReportItem(name = "zenkaiIchijihanteikekka", length = 10, order = 6)
    public RString zenkaiIchijihanteikekka;
    @ReportItem(name = "konkaiIchijihanteikekka", length = 10, order = 7)
    public RString konkaiIchijihanteikekka;
    @ReportItem(name = "shinsakaiYMD", length = 11, order = 8)
    public RString shinsakaiYMD;
    @ReportItem(name = "gogitaiNo", length = 5, order = 9)
    public RString gogitaiNo;
    @ReportItem(name = "zenkaiNijihanteikekka", length = 10, order = 10)
    public RString zenkaiNijihanteikekka;
    @ReportItem(name = "zenkaiChosakekkaNo1", length = 64, order = 11)
    public RString zenkaiChosakekkaNo1;
    @ReportItem(name = "konkaiChosakekkaNo1", length = 64, order = 12)
    public RString konkaiChosakekkaNo1;
    @ReportItem(name = "tokkiFuraguNo1", length = 1, order = 13)
    public RString tokkiFuraguNo1;
    @ReportItem(name = "zenkaiChosakekkaNo42", length = 64, order = 14)
    public RString zenkaiChosakekkaNo42;
    @ReportItem(name = "konkaiChosakekkaNo42", length = 64, order = 15)
    public RString konkaiChosakekkaNo42;
    @ReportItem(name = "tokkiFuraguNo42", length = 1, order = 16)
    public RString tokkiFuraguNo42;
    @ReportItem(name = "zenkaiChosakekkaNo2", length = 64, order = 17)
    public RString zenkaiChosakekkaNo2;
    @ReportItem(name = "konkaiChosakekkaNo2", length = 64, order = 18)
    public RString konkaiChosakekkaNo2;
    @ReportItem(name = "tokkiFuraguNo2", length = 1, order = 19)
    public RString tokkiFuraguNo2;
    @ReportItem(name = "zenkaiChosakekkaNo43", length = 64, order = 20)
    public RString zenkaiChosakekkaNo43;
    @ReportItem(name = "konkaiChosakekkaNo43", length = 64, order = 21)
    public RString konkaiChosakekkaNo43;
    @ReportItem(name = "tokkiFuraguNo43", length = 1, order = 22)
    public RString tokkiFuraguNo43;
    @ReportItem(name = "zenkaiChosakekkaNo3", length = 64, order = 23)
    public RString zenkaiChosakekkaNo3;
    @ReportItem(name = "konkaiChosakekkaNo3", length = 64, order = 24)
    public RString konkaiChosakekkaNo3;
    @ReportItem(name = "tokkiFuraguNo3", length = 1, order = 25)
    public RString tokkiFuraguNo3;
    @ReportItem(name = "zenkaiChosakekkaNo44", length = 64, order = 26)
    public RString zenkaiChosakekkaNo44;
    @ReportItem(name = "konkaiChosakekkaNo44", length = 64, order = 27)
    public RString konkaiChosakekkaNo44;
    @ReportItem(name = "tokkiFuraguNo44", length = 1, order = 28)
    public RString tokkiFuraguNo44;
    @ReportItem(name = "zenkaiChosakekkaNo4", length = 64, order = 29)
    public RString zenkaiChosakekkaNo4;
    @ReportItem(name = "konkaiChosakekkaNo4", length = 64, order = 30)
    public RString konkaiChosakekkaNo4;
    @ReportItem(name = "tokkiFuraguNo4", length = 1, order = 31)
    public RString tokkiFuraguNo4;
    @ReportItem(name = "zenkaiChosakekkaNo45", length = 64, order = 32)
    public RString zenkaiChosakekkaNo45;
    @ReportItem(name = "konkaiChosakekkaNo45", length = 64, order = 33)
    public RString konkaiChosakekkaNo45;
    @ReportItem(name = "tokkiFuraguNo45", length = 1, order = 34)
    public RString tokkiFuraguNo45;
    @ReportItem(name = "zenkaiChosakekkaNo5", length = 64, order = 35)
    public RString zenkaiChosakekkaNo5;
    @ReportItem(name = "konkaiChosakekkaNo5", length = 64, order = 36)
    public RString konkaiChosakekkaNo5;
    @ReportItem(name = "tokkiFuraguNo5", length = 1, order = 37)
    public RString tokkiFuraguNo5;
    @ReportItem(name = "zenkaiChosakekkaNo46", length = 64, order = 38)
    public RString zenkaiChosakekkaNo46;
    @ReportItem(name = "konkaiChosakekkaNo46", length = 64, order = 39)
    public RString konkaiChosakekkaNo46;
    @ReportItem(name = "tokkiFuraguNo46", length = 1, order = 40)
    public RString tokkiFuraguNo46;
    @ReportItem(name = "zenkaiChosakekkaNo6", length = 64, order = 41)
    public RString zenkaiChosakekkaNo6;
    @ReportItem(name = "konkaiChosakekkaNo6", length = 64, order = 42)
    public RString konkaiChosakekkaNo6;
    @ReportItem(name = "tokkiFuraguNo6", length = 1, order = 43)
    public RString tokkiFuraguNo6;
    @ReportItem(name = "zenkaiChosakekkaNo47", length = 64, order = 44)
    public RString zenkaiChosakekkaNo47;
    @ReportItem(name = "konkaiChosakekkaNo47", length = 64, order = 45)
    public RString konkaiChosakekkaNo47;
    @ReportItem(name = "tokkiFuraguNo47", length = 1, order = 46)
    public RString tokkiFuraguNo47;
    @ReportItem(name = "zenkaiChosakekkaNo7", length = 64, order = 47)
    public RString zenkaiChosakekkaNo7;
    @ReportItem(name = "konkaiChosakekkaNo7", length = 64, order = 48)
    public RString konkaiChosakekkaNo7;
    @ReportItem(name = "tokkiFuraguNo7", length = 1, order = 49)
    public RString tokkiFuraguNo7;
    @ReportItem(name = "zenkaiChosakekkaNo48", length = 64, order = 50)
    public RString zenkaiChosakekkaNo48;
    @ReportItem(name = "konkaiChosakekkaNo48", length = 64, order = 51)
    public RString konkaiChosakekkaNo48;
    @ReportItem(name = "tokkiFuraguNo48", length = 1, order = 52)
    public RString tokkiFuraguNo48;
    @ReportItem(name = "zenkaiChosakekkaNo8", length = 64, order = 53)
    public RString zenkaiChosakekkaNo8;
    @ReportItem(name = "konkaiChosakekkaNo8", length = 64, order = 54)
    public RString konkaiChosakekkaNo8;
    @ReportItem(name = "tokkiFuraguNo8", length = 1, order = 55)
    public RString tokkiFuraguNo8;
    @ReportItem(name = "zenkaiChosakekkaNo49", length = 64, order = 56)
    public RString zenkaiChosakekkaNo49;
    @ReportItem(name = "konkaiChosakekkaNo49", length = 64, order = 57)
    public RString konkaiChosakekkaNo49;
    @ReportItem(name = "tokkiFuraguNo49", length = 1, order = 58)
    public RString tokkiFuraguNo49;
    @ReportItem(name = "zenkaiChosakekkaNo9", length = 64, order = 59)
    public RString zenkaiChosakekkaNo9;
    @ReportItem(name = "konkaiChosakekkaNo9", length = 64, order = 60)
    public RString konkaiChosakekkaNo9;
    @ReportItem(name = "tokkiFuraguNo9", length = 1, order = 61)
    public RString tokkiFuraguNo9;
    @ReportItem(name = "zenkaiChosakekkaNo50", length = 64, order = 62)
    public RString zenkaiChosakekkaNo50;
    @ReportItem(name = "konkaiChosakekkaNo50", length = 64, order = 63)
    public RString konkaiChosakekkaNo50;
    @ReportItem(name = "tokkiFuraguNo50", length = 1, order = 64)
    public RString tokkiFuraguNo50;
    @ReportItem(name = "zenkaiChosakekkaNo10", length = 64, order = 65)
    public RString zenkaiChosakekkaNo10;
    @ReportItem(name = "konkaiChosakekkaNo10", length = 64, order = 66)
    public RString konkaiChosakekkaNo10;
    @ReportItem(name = "tokkiFuraguNo10", length = 1, order = 67)
    public RString tokkiFuraguNo10;
    @ReportItem(name = "zenkaiChosakekkaNo51", length = 64, order = 68)
    public RString zenkaiChosakekkaNo51;
    @ReportItem(name = "konkaiChosakekkaNo51", length = 64, order = 69)
    public RString konkaiChosakekkaNo51;
    @ReportItem(name = "tokkiFuraguNo51", length = 1, order = 70)
    public RString tokkiFuraguNo51;
    @ReportItem(name = "zenkaiChosakekkaNo11", length = 64, order = 71)
    public RString zenkaiChosakekkaNo11;
    @ReportItem(name = "konkaiChosakekkaNo11", length = 64, order = 72)
    public RString konkaiChosakekkaNo11;
    @ReportItem(name = "tokkiFuraguNo11", length = 1, order = 73)
    public RString tokkiFuraguNo11;
    @ReportItem(name = "zenkaiChosakekkaNo52", length = 64, order = 74)
    public RString zenkaiChosakekkaNo52;
    @ReportItem(name = "konkaiChosakekkaNo52", length = 64, order = 75)
    public RString konkaiChosakekkaNo52;
    @ReportItem(name = "tokkiFuraguNo52", length = 1, order = 76)
    public RString tokkiFuraguNo52;
    @ReportItem(name = "zenkaiChosakekkaNo12", length = 64, order = 77)
    public RString zenkaiChosakekkaNo12;
    @ReportItem(name = "konkaiChosakekkaNo12", length = 64, order = 78)
    public RString konkaiChosakekkaNo12;
    @ReportItem(name = "tokkiFuraguNo12", length = 1, order = 79)
    public RString tokkiFuraguNo12;
    @ReportItem(name = "zenkaiChosakekkaNo53", length = 64, order = 80)
    public RString zenkaiChosakekkaNo53;
    @ReportItem(name = "konkaiChosakekkaNo53", length = 64, order = 81)
    public RString konkaiChosakekkaNo53;
    @ReportItem(name = "tokkiFuraguNo53", length = 1, order = 82)
    public RString tokkiFuraguNo53;
    @ReportItem(name = "zenkaiChosakekkaNo13", length = 64, order = 83)
    public RString zenkaiChosakekkaNo13;
    @ReportItem(name = "konkaiChosakekkaNo13", length = 64, order = 84)
    public RString konkaiChosakekkaNo13;
    @ReportItem(name = "tokkiFuraguNo13", length = 1, order = 85)
    public RString tokkiFuraguNo13;
    @ReportItem(name = "zenkaiChosakekkaNo54", length = 64, order = 86)
    public RString zenkaiChosakekkaNo54;
    @ReportItem(name = "konkaiChosakekkaNo54", length = 64, order = 87)
    public RString konkaiChosakekkaNo54;
    @ReportItem(name = "tokkiFuraguNo54", length = 1, order = 88)
    public RString tokkiFuraguNo54;
    @ReportItem(name = "zenkaiChosakekkaNo14", length = 64, order = 89)
    public RString zenkaiChosakekkaNo14;
    @ReportItem(name = "konkaiChosakekkaNo14", length = 64, order = 90)
    public RString konkaiChosakekkaNo14;
    @ReportItem(name = "tokkiFuraguNo14", length = 1, order = 91)
    public RString tokkiFuraguNo14;
    @ReportItem(name = "zenkaiChosakekkaNo55", length = 64, order = 92)
    public RString zenkaiChosakekkaNo55;
    @ReportItem(name = "konkaiChosakekkaNo55", length = 64, order = 93)
    public RString konkaiChosakekkaNo55;
    @ReportItem(name = "tokkiFuraguNo55", length = 1, order = 94)
    public RString tokkiFuraguNo55;
    @ReportItem(name = "zenkaiChosakekkaNo15", length = 64, order = 95)
    public RString zenkaiChosakekkaNo15;
    @ReportItem(name = "konkaiChosakekkaNo15", length = 64, order = 96)
    public RString konkaiChosakekkaNo15;
    @ReportItem(name = "tokkiFuraguNo15", length = 1, order = 97)
    public RString tokkiFuraguNo15;
    @ReportItem(name = "zenkaiChosakekkaNo56", length = 64, order = 98)
    public RString zenkaiChosakekkaNo56;
    @ReportItem(name = "konkaiChosakekkaNo56", length = 64, order = 99)
    public RString konkaiChosakekkaNo56;
    @ReportItem(name = "tokkiFuraguNo56", length = 1, order = 100)
    public RString tokkiFuraguNo56;
    @ReportItem(name = "zenkaiChosakekkaNo16", length = 64, order = 101)
    public RString zenkaiChosakekkaNo16;
    @ReportItem(name = "konkaiChosakekkaNo16", length = 64, order = 102)
    public RString konkaiChosakekkaNo16;
    @ReportItem(name = "tokkiFuraguNo16", length = 1, order = 103)
    public RString tokkiFuraguNo16;
    @ReportItem(name = "zenkaiChosakekkaNo17", length = 64, order = 104)
    public RString zenkaiChosakekkaNo17;
    @ReportItem(name = "konkaiChosakekkaNo17", length = 64, order = 105)
    public RString konkaiChosakekkaNo17;
    @ReportItem(name = "tokkiFuraguNo17", length = 1, order = 106)
    public RString tokkiFuraguNo17;
    @ReportItem(name = "zenkaiChosakekkaNo18", length = 64, order = 107)
    public RString zenkaiChosakekkaNo18;
    @ReportItem(name = "konkaiChosakekkaNo18", length = 64, order = 108)
    public RString konkaiChosakekkaNo18;
    @ReportItem(name = "tokkiFuraguNo18", length = 1, order = 109)
    public RString tokkiFuraguNo18;
    @ReportItem(name = "zenkaiChosakekkaNo57", length = 64, order = 110)
    public RString zenkaiChosakekkaNo57;
    @ReportItem(name = "konkaiChosakekkaNo57", length = 64, order = 111)
    public RString konkaiChosakekkaNo57;
    @ReportItem(name = "tokkiFuraguNo57", length = 1, order = 112)
    public RString tokkiFuraguNo57;
    @ReportItem(name = "zenkaiChosakekkaNo19", length = 64, order = 113)
    public RString zenkaiChosakekkaNo19;
    @ReportItem(name = "konkaiChosakekkaNo19", length = 64, order = 114)
    public RString konkaiChosakekkaNo19;
    @ReportItem(name = "tokkiFuraguNo19", length = 1, order = 115)
    public RString tokkiFuraguNo19;
    @ReportItem(name = "tokkiFuraguNo58", length = 1, order = 116)
    public RString tokkiFuraguNo58;
    @ReportItem(name = "zenkaiChosakekkaNo58", length = 64, order = 117)
    public RString zenkaiChosakekkaNo58;
    @ReportItem(name = "konkaiChosakekkaNo58", length = 64, order = 118)
    public RString konkaiChosakekkaNo58;
    @ReportItem(name = "zenkaiChosakekkaNo20", length = 64, order = 119)
    public RString zenkaiChosakekkaNo20;
    @ReportItem(name = "konkaiChosakekkaNo20", length = 64, order = 120)
    public RString konkaiChosakekkaNo20;
    @ReportItem(name = "tokkiFuraguNo20", length = 1, order = 121)
    public RString tokkiFuraguNo20;
    @ReportItem(name = "tokkiFuraguNo59", length = 1, order = 122)
    public RString tokkiFuraguNo59;
    @ReportItem(name = "zenkaiChosakekkaNo59", length = 64, order = 123)
    public RString zenkaiChosakekkaNo59;
    @ReportItem(name = "konkaiChosakekkaNo59", length = 64, order = 124)
    public RString konkaiChosakekkaNo59;
    @ReportItem(name = "tokkiFuraguNo60", length = 1, order = 125)
    public RString tokkiFuraguNo60;
    @ReportItem(name = "zenkaiChosakekkaNo60", length = 64, order = 126)
    public RString zenkaiChosakekkaNo60;
    @ReportItem(name = "konkaiChosakekkaNo60", length = 64, order = 127)
    public RString konkaiChosakekkaNo60;
    @ReportItem(name = "tokkiFuraguNo61", length = 1, order = 128)
    public RString tokkiFuraguNo61;
    @ReportItem(name = "zenkaiChosakekkaNo61", length = 64, order = 129)
    public RString zenkaiChosakekkaNo61;
    @ReportItem(name = "konkaiChosakekkaNo61", length = 64, order = 130)
    public RString konkaiChosakekkaNo61;
    @ReportItem(name = "zenkaiChosakekkaNo21", length = 64, order = 131)
    public RString zenkaiChosakekkaNo21;
    @ReportItem(name = "konkaiChosakekkaNo21", length = 64, order = 132)
    public RString konkaiChosakekkaNo21;
    @ReportItem(name = "tokkiFuraguNo21", length = 1, order = 133)
    public RString tokkiFuraguNo21;
    @ReportItem(name = "zenkaiChosakekkaNo62", length = 64, order = 134)
    public RString zenkaiChosakekkaNo62;
    @ReportItem(name = "konkaiChosakekkaNo62", length = 64, order = 135)
    public RString konkaiChosakekkaNo62;
    @ReportItem(name = "tokkiFuraguNo62", length = 1, order = 136)
    public RString tokkiFuraguNo62;
    @ReportItem(name = "zenkaiChosakekkaNo22", length = 64, order = 137)
    public RString zenkaiChosakekkaNo22;
    @ReportItem(name = "konkaiChosakekkaNo22", length = 64, order = 138)
    public RString konkaiChosakekkaNo22;
    @ReportItem(name = "tokkiFuraguNo22", length = 1, order = 139)
    public RString tokkiFuraguNo22;
    @ReportItem(name = "zenkaiChosakekkaNo23", length = 64, order = 140)
    public RString zenkaiChosakekkaNo23;
    @ReportItem(name = "konkaiChosakekkaNo23", length = 64, order = 141)
    public RString konkaiChosakekkaNo23;
    @ReportItem(name = "tokkiFuraguNo23", length = 1, order = 142)
    public RString tokkiFuraguNo23;
    @ReportItem(name = "zenkaiChosakekkaNo24", length = 64, order = 143)
    public RString zenkaiChosakekkaNo24;
    @ReportItem(name = "konkaiChosakekkaNo24", length = 64, order = 144)
    public RString konkaiChosakekkaNo24;
    @ReportItem(name = "tokkiFuraguNo24", length = 1, order = 145)
    public RString tokkiFuraguNo24;
    @ReportItem(name = "zenkaiChosakekkaNo63", length = 64, order = 146)
    public RString zenkaiChosakekkaNo63;
    @ReportItem(name = "konkaiChosakekkaNo63", length = 64, order = 147)
    public RString konkaiChosakekkaNo63;
    @ReportItem(name = "tokkiFuraguNo63", length = 1, order = 148)
    public RString tokkiFuraguNo63;
    @ReportItem(name = "zenkaiChosakekkaNo25", length = 64, order = 149)
    public RString zenkaiChosakekkaNo25;
    @ReportItem(name = "konkaiChosakekkaNo25", length = 64, order = 150)
    public RString konkaiChosakekkaNo25;
    @ReportItem(name = "tokkiFuraguNo25", length = 1, order = 151)
    public RString tokkiFuraguNo25;
    @ReportItem(name = "zenkaiChosakekkaNo64", length = 64, order = 152)
    public RString zenkaiChosakekkaNo64;
    @ReportItem(name = "konkaiChosakekkaNo64", length = 64, order = 153)
    public RString konkaiChosakekkaNo64;
    @ReportItem(name = "tokkiFuraguNo64", length = 1, order = 154)
    public RString tokkiFuraguNo64;
    @ReportItem(name = "zenkaiChosakekkaNo26", length = 64, order = 155)
    public RString zenkaiChosakekkaNo26;
    @ReportItem(name = "konkaiChosakekkaNo26", length = 64, order = 156)
    public RString konkaiChosakekkaNo26;
    @ReportItem(name = "tokkiFuraguNo26", length = 1, order = 157)
    public RString tokkiFuraguNo26;
    @ReportItem(name = "zenkaiChosakekkaNo65", length = 64, order = 158)
    public RString zenkaiChosakekkaNo65;
    @ReportItem(name = "konkaiChosakekkaNo65", length = 64, order = 159)
    public RString konkaiChosakekkaNo65;
    @ReportItem(name = "tokkiFuraguNo65", length = 1, order = 160)
    public RString tokkiFuraguNo65;
    @ReportItem(name = "zenkaiChosakekkaNo27", length = 64, order = 161)
    public RString zenkaiChosakekkaNo27;
    @ReportItem(name = "konkaiChosakekkaNo27", length = 64, order = 162)
    public RString konkaiChosakekkaNo27;
    @ReportItem(name = "tokkiFuraguNo27", length = 1, order = 163)
    public RString tokkiFuraguNo27;
    @ReportItem(name = "zenkaiChosakekkaNo66", length = 64, order = 164)
    public RString zenkaiChosakekkaNo66;
    @ReportItem(name = "konkaiChosakekkaNo66", length = 64, order = 165)
    public RString konkaiChosakekkaNo66;
    @ReportItem(name = "tokkiFuraguNo66", length = 1, order = 166)
    public RString tokkiFuraguNo66;
    @ReportItem(name = "zenkaiChosakekkaNo28", length = 64, order = 167)
    public RString zenkaiChosakekkaNo28;
    @ReportItem(name = "konkaiChosakekkaNo28", length = 64, order = 168)
    public RString konkaiChosakekkaNo28;
    @ReportItem(name = "tokkiFuraguNo28", length = 1, order = 169)
    public RString tokkiFuraguNo28;
    @ReportItem(name = "zenkaiChosakekkaNo67", length = 64, order = 170)
    public RString zenkaiChosakekkaNo67;
    @ReportItem(name = "konkaiChosakekkaNo67", length = 64, order = 171)
    public RString konkaiChosakekkaNo67;
    @ReportItem(name = "tokkiFuraguNo67", length = 1, order = 172)
    public RString tokkiFuraguNo67;
    @ReportItem(name = "zenkaiChosakekkaNo29", length = 64, order = 173)
    public RString zenkaiChosakekkaNo29;
    @ReportItem(name = "konkaiChosakekkaNo29", length = 64, order = 174)
    public RString konkaiChosakekkaNo29;
    @ReportItem(name = "tokkiFuraguNo29", length = 1, order = 175)
    public RString tokkiFuraguNo29;
    @ReportItem(name = "zenkaiChosakekkaNo68", length = 64, order = 176)
    public RString zenkaiChosakekkaNo68;
    @ReportItem(name = "konkaiChosakekkaNo68", length = 64, order = 177)
    public RString konkaiChosakekkaNo68;
    @ReportItem(name = "tokkiFuraguNo68", length = 1, order = 178)
    public RString tokkiFuraguNo68;
    @ReportItem(name = "zenkaiChosakekkaNo30", length = 64, order = 179)
    public RString zenkaiChosakekkaNo30;
    @ReportItem(name = "konkaiChosakekkaNo30", length = 64, order = 180)
    public RString konkaiChosakekkaNo30;
    @ReportItem(name = "tokkiFuraguNo30", length = 1, order = 181)
    public RString tokkiFuraguNo30;
    @ReportItem(name = "zenkaiChosakekkaNo69", length = 64, order = 182)
    public RString zenkaiChosakekkaNo69;
    @ReportItem(name = "konkaiChosakekkaNo69", length = 64, order = 183)
    public RString konkaiChosakekkaNo69;
    @ReportItem(name = "tokkiFuraguNo69", length = 1, order = 184)
    public RString tokkiFuraguNo69;
    @ReportItem(name = "zenkaiChosakekkaNo31", length = 64, order = 185)
    public RString zenkaiChosakekkaNo31;
    @ReportItem(name = "konkaiChosakekkaNo31", length = 64, order = 186)
    public RString konkaiChosakekkaNo31;
    @ReportItem(name = "tokkiFuraguNo31", length = 1, order = 187)
    public RString tokkiFuraguNo31;
    @ReportItem(name = "zenkaiChosakekkaNo70", length = 64, order = 188)
    public RString zenkaiChosakekkaNo70;
    @ReportItem(name = "konkaiChosakekkaNo70", length = 64, order = 189)
    public RString konkaiChosakekkaNo70;
    @ReportItem(name = "tokkiFuraguNo70", length = 1, order = 190)
    public RString tokkiFuraguNo70;
    @ReportItem(name = "zenkaiChosakekkaNo32", length = 64, order = 191)
    public RString zenkaiChosakekkaNo32;
    @ReportItem(name = "konkaiChosakekkaNo32", length = 64, order = 192)
    public RString konkaiChosakekkaNo32;
    @ReportItem(name = "tokkiFuraguNo32", length = 1, order = 193)
    public RString tokkiFuraguNo32;
    @ReportItem(name = "zenkaiChosakekkaNo71", length = 64, order = 194)
    public RString zenkaiChosakekkaNo71;
    @ReportItem(name = "konkaiChosakekkaNo71", length = 64, order = 195)
    public RString konkaiChosakekkaNo71;
    @ReportItem(name = "tokkiFuraguNo71", length = 1, order = 196)
    public RString tokkiFuraguNo71;
    @ReportItem(name = "zenkaiChosakekkaNo72", length = 64, order = 197)
    public RString zenkaiChosakekkaNo72;
    @ReportItem(name = "konkaiChosakekkaNo72", length = 64, order = 198)
    public RString konkaiChosakekkaNo72;
    @ReportItem(name = "tokkiFuraguNo72", length = 1, order = 199)
    public RString tokkiFuraguNo72;
    @ReportItem(name = "zenkaiChosakekkaNo73", length = 64, order = 200)
    public RString zenkaiChosakekkaNo73;
    @ReportItem(name = "konkaiChosakekkaNo73", length = 64, order = 201)
    public RString konkaiChosakekkaNo73;
    @ReportItem(name = "tokkiFuraguNo73", length = 1, order = 202)
    public RString tokkiFuraguNo73;
    @ReportItem(name = "zenkaiChosakekkaNo33", length = 64, order = 203)
    public RString zenkaiChosakekkaNo33;
    @ReportItem(name = "konkaiChosakekkaNo33", length = 64, order = 204)
    public RString konkaiChosakekkaNo33;
    @ReportItem(name = "tokkiFuraguNo33", length = 1, order = 205)
    public RString tokkiFuraguNo33;
    @ReportItem(name = "zenkaiChosakekkaNo74", length = 64, order = 206)
    public RString zenkaiChosakekkaNo74;
    @ReportItem(name = "konkaiChosakekkaNo74", length = 64, order = 207)
    public RString konkaiChosakekkaNo74;
    @ReportItem(name = "tokkiFuraguNo74", length = 1, order = 208)
    public RString tokkiFuraguNo74;
    @ReportItem(name = "zenkaiChosakekkaNo34", length = 64, order = 209)
    public RString zenkaiChosakekkaNo34;
    @ReportItem(name = "konkaiChosakekkaNo34", length = 64, order = 210)
    public RString konkaiChosakekkaNo34;
    @ReportItem(name = "tokkiFuraguNo34", length = 1, order = 211)
    public RString tokkiFuraguNo34;
    @ReportItem(name = "zenkaiChosakekkaNo35", length = 64, order = 212)
    public RString zenkaiChosakekkaNo35;
    @ReportItem(name = "konkaiChosakekkaNo35", length = 64, order = 213)
    public RString konkaiChosakekkaNo35;
    @ReportItem(name = "tokkiFuraguNo35", length = 1, order = 214)
    public RString tokkiFuraguNo35;
    @ReportItem(name = "zenkaiChosakekkaNo36", length = 64, order = 215)
    public RString zenkaiChosakekkaNo36;
    @ReportItem(name = "konkaiChosakekkaNo36", length = 64, order = 216)
    public RString konkaiChosakekkaNo36;
    @ReportItem(name = "tokkiFuraguNo36", length = 1, order = 217)
    public RString tokkiFuraguNo36;
    @ReportItem(name = "zenkaiChosakekkaNo75", length = 64, order = 218)
    public RString zenkaiChosakekkaNo75;
    @ReportItem(name = "konkaiChosakekkaNo75", length = 64, order = 219)
    public RString konkaiChosakekkaNo75;
    @ReportItem(name = "tokkiFuraguNo75", length = 1, order = 220)
    public RString tokkiFuraguNo75;
    @ReportItem(name = "zenkaiChosakekkaNo37", length = 64, order = 221)
    public RString zenkaiChosakekkaNo37;
    @ReportItem(name = "konkaiChosakekkaNo37", length = 64, order = 222)
    public RString konkaiChosakekkaNo37;
    @ReportItem(name = "tokkiFuraguNo37", length = 1, order = 223)
    public RString tokkiFuraguNo37;
    @ReportItem(name = "zenkaiChosakekkaNo76", length = 64, order = 224)
    public RString zenkaiChosakekkaNo76;
    @ReportItem(name = "konkaiChosakekkaNo76", length = 64, order = 225)
    public RString konkaiChosakekkaNo76;
    @ReportItem(name = "tokkiFuraguNo76", length = 1, order = 226)
    public RString tokkiFuraguNo76;
    @ReportItem(name = "zenkaiChosakekkaNo38", length = 64, order = 227)
    public RString zenkaiChosakekkaNo38;
    @ReportItem(name = "konkaiChosakekkaNo38", length = 64, order = 228)
    public RString konkaiChosakekkaNo38;
    @ReportItem(name = "tokkiFuraguNo38", length = 1, order = 229)
    public RString tokkiFuraguNo38;
    @ReportItem(name = "zenkaiChosakekkaNo39", length = 64, order = 230)
    public RString zenkaiChosakekkaNo39;
    @ReportItem(name = "konkaiChosakekkaNo39", length = 64, order = 231)
    public RString konkaiChosakekkaNo39;
    @ReportItem(name = "tokkiFuraguNo39", length = 1, order = 232)
    public RString tokkiFuraguNo39;
    @ReportItem(name = "zenkaiChosakekkaNo40", length = 64, order = 233)
    public RString zenkaiChosakekkaNo40;
    @ReportItem(name = "konkaiChosakekkaNo40", length = 64, order = 234)
    public RString konkaiChosakekkaNo40;
    @ReportItem(name = "tokkiFuraguNo40", length = 1, order = 235)
    public RString tokkiFuraguNo40;
    @ReportItem(name = "zenkaiChosakekkaNo41", length = 64, order = 236)
    public RString zenkaiChosakekkaNo41;
    @ReportItem(name = "konkaiChosakekkaNo41", length = 64, order = 237)
    public RString konkaiChosakekkaNo41;
    @ReportItem(name = "tokkiFuraguNo41", length = 1, order = 238)
    public RString tokkiFuraguNo41;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
