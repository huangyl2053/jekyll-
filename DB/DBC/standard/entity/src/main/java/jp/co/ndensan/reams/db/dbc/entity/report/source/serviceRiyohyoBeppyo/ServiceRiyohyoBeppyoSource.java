package jp.co.ndensan.reams.db.dbc.entity.report.source.serviceRiyohyoBeppyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBC0150011_1_サービス提供票別表 Source。
 *
 * @reamsid_L DBC-5100-030 tianshuai
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ServiceRiyohyoBeppyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihoNo", length = 10, order = 1)
    public RString hihoNo;
    @ReportItem(name = "hihoMei1", length = 20, order = 2)
    public RString hihoMei1;
    @ReportItem(name = "hihoMei2", length = 20, order = 3)
    public RString hihoMei2;
    @ReportItem(name = "title", length = 2, order = 4)
    public RString title;
    @ReportItem(name = "nengo", length = 8, order = 5)
    public RString nengo;
    @ReportItem(name = "pagecnt", length = 6, order = 6)
    public RString pagecnt;
    @ReportItem(name = "shoriYmdHms", length = 20, order = 7)
    public RString shoriYmdHms;
    @ReportItem(name = "headSeikyugaku", length = 9, order = 8)
    public RString headSeikyugaku;
    @ReportItem(name = "headRiyoushaFutan", length = 8, order = 9)
    public RString headRiyoushaFutan;
    @ReportItem(name = "headHiyouSougaku", length = 8, order = 10)
    public RString headHiyouSougaku;
    @ReportItem(name = "jigyomei111", length = 18, order = 11)
    public RString jigyomei111;
    @ReportItem(name = "sname111", length = 8, order = 12)
    public RString sname111;
    @ReportItem(name = "sover11", length = 8, order = 13)
    public RString sover11;
    @ReportItem(name = "sin11", length = 8, order = 14)
    public RString sin11;
    @ReportItem(name = "wariritsu11", length = 3, order = 15)
    public RString wariritsu11;
    @ReportItem(name = "wariten11", length = 6, order = 16)
    public RString wariten11;
    @ReportItem(name = "kai11", length = 3, order = 17)
    public RString kai11;
    @ReportItem(name = "tanka11", length = 5, order = 18)
    public RString tanka11;
    @ReportItem(name = "hiyou11", length = 9, order = 19)
    public RString hiyou11;
    @ReportItem(name = "ritu11", length = 3, order = 20)
    public RString ritu11;
    @ReportItem(name = "zengaku11", length = 9, order = 21)
    public RString zengaku11;
    @ReportItem(name = "jigyoshoCd11", length = 10, order = 22)
    public RString jigyoshoCd11;
    @ReportItem(name = "scode11", length = 6, order = 23)
    public RString scode11;
    @ReportItem(name = "ten11", length = 6, order = 24)
    public RString ten11;
    @ReportItem(name = "stensu11", length = 8, order = 25)
    public RString stensu11;
    @ReportItem(name = "kover11", length = 8, order = 26)
    public RString kover11;
    @ReportItem(name = "kin11", length = 8, order = 27)
    public RString kin11;
    @ReportItem(name = "kyufu11", length = 9, order = 28)
    public RString kyufu11;
    @ReportItem(name = "hoken11", length = 9, order = 29)
    public RString hoken11;
    @ReportItem(name = "jigyomei121", length = 18, order = 30)
    public RString jigyomei121;
    @ReportItem(name = "sname121", length = 8, order = 31)
    public RString sname121;
    @ReportItem(name = "sname112", length = 8, order = 32)
    public RString sname112;
    @ReportItem(name = "jigyomei112", length = 18, order = 33)
    public RString jigyomei112;
    @ReportItem(name = "sover12", length = 8, order = 34)
    public RString sover12;
    @ReportItem(name = "sin12", length = 8, order = 35)
    public RString sin12;
    @ReportItem(name = "kover12", length = 8, order = 36)
    public RString kover12;
    @ReportItem(name = "kin12", length = 8, order = 37)
    public RString kin12;
    @ReportItem(name = "jigyoshoCd12", length = 10, order = 38)
    public RString jigyoshoCd12;
    @ReportItem(name = "wariritsu12", length = 3, order = 39)
    public RString wariritsu12;
    @ReportItem(name = "wariten12", length = 6, order = 40)
    public RString wariten12;
    @ReportItem(name = "stensu12", length = 8, order = 41)
    public RString stensu12;
    @ReportItem(name = "tanka12", length = 5, order = 42)
    public RString tanka12;
    @ReportItem(name = "hiyou12", length = 9, order = 43)
    public RString hiyou12;
    @ReportItem(name = "ritu12", length = 3, order = 44)
    public RString ritu12;
    @ReportItem(name = "kyufu12", length = 9, order = 45)
    public RString kyufu12;
    @ReportItem(name = "hoken12", length = 9, order = 46)
    public RString hoken12;
    @ReportItem(name = "zengaku12", length = 9, order = 47)
    public RString zengaku12;
    @ReportItem(name = "scode12", length = 6, order = 48)
    public RString scode12;
    @ReportItem(name = "ten12", length = 6, order = 49)
    public RString ten12;
    @ReportItem(name = "kai12", length = 3, order = 50)
    public RString kai12;
    @ReportItem(name = "sname122", length = 8, order = 51)
    public RString sname122;
    @ReportItem(name = "jigyomei122", length = 18, order = 52)
    public RString jigyomei122;
    @ReportItem(name = "jigyomei113", length = 18, order = 53)
    public RString jigyomei113;
    @ReportItem(name = "sname113", length = 8, order = 54)
    public RString sname113;
    @ReportItem(name = "ten13", length = 6, order = 55)
    public RString ten13;
    @ReportItem(name = "sover13", length = 8, order = 56)
    public RString sover13;
    @ReportItem(name = "sin13", length = 8, order = 57)
    public RString sin13;
    @ReportItem(name = "kover13", length = 8, order = 58)
    public RString kover13;
    @ReportItem(name = "kin13", length = 8, order = 59)
    public RString kin13;
    @ReportItem(name = "ritu13", length = 3, order = 60)
    public RString ritu13;
    @ReportItem(name = "jigyoshoCd13", length = 10, order = 61)
    public RString jigyoshoCd13;
    @ReportItem(name = "scode13", length = 6, order = 62)
    public RString scode13;
    @ReportItem(name = "wariritsu13", length = 3, order = 63)
    public RString wariritsu13;
    @ReportItem(name = "wariten13", length = 6, order = 64)
    public RString wariten13;
    @ReportItem(name = "kai13", length = 3, order = 65)
    public RString kai13;
    @ReportItem(name = "stensu13", length = 8, order = 66)
    public RString stensu13;
    @ReportItem(name = "tanka13", length = 5, order = 67)
    public RString tanka13;
    @ReportItem(name = "hiyou13", length = 9, order = 68)
    public RString hiyou13;
    @ReportItem(name = "kyufu13", length = 9, order = 69)
    public RString kyufu13;
    @ReportItem(name = "hoken13", length = 9, order = 70)
    public RString hoken13;
    @ReportItem(name = "zengaku13", length = 9, order = 71)
    public RString zengaku13;
    @ReportItem(name = "jigyomei123", length = 18, order = 72)
    public RString jigyomei123;
    @ReportItem(name = "sname123", length = 8, order = 73)
    public RString sname123;
    @ReportItem(name = "jigyomei114", length = 18, order = 74)
    public RString jigyomei114;
    @ReportItem(name = "sname114", length = 8, order = 75)
    public RString sname114;
    @ReportItem(name = "ten14", length = 6, order = 76)
    public RString ten14;
    @ReportItem(name = "sover14", length = 8, order = 77)
    public RString sover14;
    @ReportItem(name = "sin14", length = 8, order = 78)
    public RString sin14;
    @ReportItem(name = "kover14", length = 8, order = 79)
    public RString kover14;
    @ReportItem(name = "kin14", length = 8, order = 80)
    public RString kin14;
    @ReportItem(name = "ritu14", length = 3, order = 81)
    public RString ritu14;
    @ReportItem(name = "jigyoshoCd14", length = 10, order = 82)
    public RString jigyoshoCd14;
    @ReportItem(name = "wariritsu14", length = 3, order = 83)
    public RString wariritsu14;
    @ReportItem(name = "wariten14", length = 6, order = 84)
    public RString wariten14;
    @ReportItem(name = "kai14", length = 3, order = 85)
    public RString kai14;
    @ReportItem(name = "stensu14", length = 8, order = 86)
    public RString stensu14;
    @ReportItem(name = "tanka14", length = 5, order = 87)
    public RString tanka14;
    @ReportItem(name = "hiyou14", length = 9, order = 88)
    public RString hiyou14;
    @ReportItem(name = "kyufu14", length = 9, order = 89)
    public RString kyufu14;
    @ReportItem(name = "hoken14", length = 9, order = 90)
    public RString hoken14;
    @ReportItem(name = "zengaku14", length = 9, order = 91)
    public RString zengaku14;
    @ReportItem(name = "scode14", length = 6, order = 92)
    public RString scode14;
    @ReportItem(name = "jigyomei124", length = 18, order = 93)
    public RString jigyomei124;
    @ReportItem(name = "sname124", length = 8, order = 94)
    public RString sname124;
    @ReportItem(name = "jigyomei115", length = 18, order = 95)
    public RString jigyomei115;
    @ReportItem(name = "sname115", length = 8, order = 96)
    public RString sname115;
    @ReportItem(name = "ten15", length = 6, order = 97)
    public RString ten15;
    @ReportItem(name = "sover15", length = 8, order = 98)
    public RString sover15;
    @ReportItem(name = "sin15", length = 8, order = 99)
    public RString sin15;
    @ReportItem(name = "kover15", length = 8, order = 100)
    public RString kover15;
    @ReportItem(name = "kin15", length = 8, order = 101)
    public RString kin15;
    @ReportItem(name = "ritu15", length = 3, order = 102)
    public RString ritu15;
    @ReportItem(name = "jigyoshoCd15", length = 10, order = 103)
    public RString jigyoshoCd15;
    @ReportItem(name = "wariritsu15", length = 3, order = 104)
    public RString wariritsu15;
    @ReportItem(name = "wariten15", length = 6, order = 105)
    public RString wariten15;
    @ReportItem(name = "kai15", length = 3, order = 106)
    public RString kai15;
    @ReportItem(name = "stensu15", length = 8, order = 107)
    public RString stensu15;
    @ReportItem(name = "tanka15", length = 5, order = 108)
    public RString tanka15;
    @ReportItem(name = "hiyou15", length = 9, order = 109)
    public RString hiyou15;
    @ReportItem(name = "kyufu15", length = 9, order = 110)
    public RString kyufu15;
    @ReportItem(name = "hoken15", length = 9, order = 111)
    public RString hoken15;
    @ReportItem(name = "zengaku15", length = 9, order = 112)
    public RString zengaku15;
    @ReportItem(name = "scode15", length = 6, order = 113)
    public RString scode15;
    @ReportItem(name = "jigyomei125", length = 18, order = 114)
    public RString jigyomei125;
    @ReportItem(name = "sname125", length = 8, order = 115)
    public RString sname125;
    @ReportItem(name = "jigyomei116", length = 18, order = 116)
    public RString jigyomei116;
    @ReportItem(name = "sname116", length = 8, order = 117)
    public RString sname116;
    @ReportItem(name = "ten16", length = 6, order = 118)
    public RString ten16;
    @ReportItem(name = "sover16", length = 8, order = 119)
    public RString sover16;
    @ReportItem(name = "sin16", length = 8, order = 120)
    public RString sin16;
    @ReportItem(name = "kover16", length = 8, order = 121)
    public RString kover16;
    @ReportItem(name = "kin16", length = 8, order = 122)
    public RString kin16;
    @ReportItem(name = "ritu16", length = 3, order = 123)
    public RString ritu16;
    @ReportItem(name = "jigyoshoCd16", length = 10, order = 124)
    public RString jigyoshoCd16;
    @ReportItem(name = "scode16", length = 6, order = 125)
    public RString scode16;
    @ReportItem(name = "wariritsu16", length = 3, order = 126)
    public RString wariritsu16;
    @ReportItem(name = "wariten16", length = 6, order = 127)
    public RString wariten16;
    @ReportItem(name = "kai16", length = 3, order = 128)
    public RString kai16;
    @ReportItem(name = "stensu16", length = 8, order = 129)
    public RString stensu16;
    @ReportItem(name = "tanka16", length = 5, order = 130)
    public RString tanka16;
    @ReportItem(name = "hiyou16", length = 9, order = 131)
    public RString hiyou16;
    @ReportItem(name = "kyufu16", length = 9, order = 132)
    public RString kyufu16;
    @ReportItem(name = "hoken16", length = 9, order = 133)
    public RString hoken16;
    @ReportItem(name = "zengaku16", length = 9, order = 134)
    public RString zengaku16;
    @ReportItem(name = "jigyomei126", length = 18, order = 135)
    public RString jigyomei126;
    @ReportItem(name = "sname126", length = 8, order = 136)
    public RString sname126;
    @ReportItem(name = "jigyomei117", length = 18, order = 137)
    public RString jigyomei117;
    @ReportItem(name = "sname117", length = 8, order = 138)
    public RString sname117;
    @ReportItem(name = "ten17", length = 6, order = 139)
    public RString ten17;
    @ReportItem(name = "sover17", length = 8, order = 140)
    public RString sover17;
    @ReportItem(name = "sin17", length = 8, order = 141)
    public RString sin17;
    @ReportItem(name = "kover17", length = 8, order = 142)
    public RString kover17;
    @ReportItem(name = "kin17", length = 8, order = 143)
    public RString kin17;
    @ReportItem(name = "ritu17", length = 3, order = 144)
    public RString ritu17;
    @ReportItem(name = "jigyoshoCd17", length = 10, order = 145)
    public RString jigyoshoCd17;
    @ReportItem(name = "scode17", length = 6, order = 146)
    public RString scode17;
    @ReportItem(name = "wariritsu17", length = 3, order = 147)
    public RString wariritsu17;
    @ReportItem(name = "wariten17", length = 6, order = 148)
    public RString wariten17;
    @ReportItem(name = "kai17", length = 3, order = 149)
    public RString kai17;
    @ReportItem(name = "stensu17", length = 8, order = 150)
    public RString stensu17;
    @ReportItem(name = "tanka17", length = 5, order = 151)
    public RString tanka17;
    @ReportItem(name = "hiyou17", length = 9, order = 152)
    public RString hiyou17;
    @ReportItem(name = "kyufu17", length = 9, order = 153)
    public RString kyufu17;
    @ReportItem(name = "hoken17", length = 9, order = 154)
    public RString hoken17;
    @ReportItem(name = "zengaku17", length = 9, order = 155)
    public RString zengaku17;
    @ReportItem(name = "jigyomei127", length = 18, order = 156)
    public RString jigyomei127;
    @ReportItem(name = "sname127", length = 8, order = 157)
    public RString sname127;
    @ReportItem(name = "jigyomei118", length = 18, order = 158)
    public RString jigyomei118;
    @ReportItem(name = "sname118", length = 8, order = 159)
    public RString sname118;
    @ReportItem(name = "ten18", length = 6, order = 160)
    public RString ten18;
    @ReportItem(name = "sover18", length = 8, order = 161)
    public RString sover18;
    @ReportItem(name = "sin18", length = 8, order = 162)
    public RString sin18;
    @ReportItem(name = "kover18", length = 8, order = 163)
    public RString kover18;
    @ReportItem(name = "kin18", length = 8, order = 164)
    public RString kin18;
    @ReportItem(name = "ritu18", length = 3, order = 165)
    public RString ritu18;
    @ReportItem(name = "jigyoshoCd18", length = 10, order = 166)
    public RString jigyoshoCd18;
    @ReportItem(name = "scode18", length = 6, order = 167)
    public RString scode18;
    @ReportItem(name = "wariritsu18", length = 3, order = 168)
    public RString wariritsu18;
    @ReportItem(name = "wariten18", length = 6, order = 169)
    public RString wariten18;
    @ReportItem(name = "kai18", length = 3, order = 170)
    public RString kai18;
    @ReportItem(name = "stensu18", length = 8, order = 171)
    public RString stensu18;
    @ReportItem(name = "tanka18", length = 5, order = 172)
    public RString tanka18;
    @ReportItem(name = "hiyou18", length = 9, order = 173)
    public RString hiyou18;
    @ReportItem(name = "kyufu18", length = 9, order = 174)
    public RString kyufu18;
    @ReportItem(name = "hoken18", length = 9, order = 175)
    public RString hoken18;
    @ReportItem(name = "zengaku18", length = 9, order = 176)
    public RString zengaku18;
    @ReportItem(name = "jigyomei128", length = 18, order = 177)
    public RString jigyomei128;
    @ReportItem(name = "sname128", length = 8, order = 178)
    public RString sname128;
    @ReportItem(name = "jigyomei119", length = 18, order = 179)
    public RString jigyomei119;
    @ReportItem(name = "sname119", length = 8, order = 180)
    public RString sname119;
    @ReportItem(name = "sover19", length = 8, order = 181)
    public RString sover19;
    @ReportItem(name = "sin19", length = 8, order = 182)
    public RString sin19;
    @ReportItem(name = "kover19", length = 8, order = 183)
    public RString kover19;
    @ReportItem(name = "kin19", length = 8, order = 184)
    public RString kin19;
    @ReportItem(name = "jigyoshoCd19", length = 10, order = 185)
    public RString jigyoshoCd19;
    @ReportItem(name = "scode19", length = 6, order = 186)
    public RString scode19;
    @ReportItem(name = "ten19", length = 6, order = 187)
    public RString ten19;
    @ReportItem(name = "wariritsu19", length = 3, order = 188)
    public RString wariritsu19;
    @ReportItem(name = "wariten19", length = 6, order = 189)
    public RString wariten19;
    @ReportItem(name = "kai19", length = 3, order = 190)
    public RString kai19;
    @ReportItem(name = "stensu19", length = 8, order = 191)
    public RString stensu19;
    @ReportItem(name = "tanka19", length = 5, order = 192)
    public RString tanka19;
    @ReportItem(name = "hiyou19", length = 9, order = 193)
    public RString hiyou19;
    @ReportItem(name = "ritu19", length = 3, order = 194)
    public RString ritu19;
    @ReportItem(name = "kyufu19", length = 9, order = 195)
    public RString kyufu19;
    @ReportItem(name = "hoken19", length = 9, order = 196)
    public RString hoken19;
    @ReportItem(name = "zengaku19", length = 9, order = 197)
    public RString zengaku19;
    @ReportItem(name = "jigyomei129", length = 18, order = 198)
    public RString jigyomei129;
    @ReportItem(name = "sname129", length = 8, order = 199)
    public RString sname129;
    @ReportItem(name = "jigyomei1110", length = 18, order = 200)
    public RString jigyomei1110;
    @ReportItem(name = "sname1110", length = 8, order = 201)
    public RString sname1110;
    @ReportItem(name = "sover110", length = 8, order = 202)
    public RString sover110;
    @ReportItem(name = "sin110", length = 8, order = 203)
    public RString sin110;
    @ReportItem(name = "kover110", length = 8, order = 204)
    public RString kover110;
    @ReportItem(name = "kin110", length = 8, order = 205)
    public RString kin110;
    @ReportItem(name = "jigyoshoCd110", length = 10, order = 206)
    public RString jigyoshoCd110;
    @ReportItem(name = "scode110", length = 6, order = 207)
    public RString scode110;
    @ReportItem(name = "ten110", length = 6, order = 208)
    public RString ten110;
    @ReportItem(name = "wariritsu110", length = 3, order = 209)
    public RString wariritsu110;
    @ReportItem(name = "wariten110", length = 6, order = 210)
    public RString wariten110;
    @ReportItem(name = "kai110", length = 3, order = 211)
    public RString kai110;
    @ReportItem(name = "stensu110", length = 8, order = 212)
    public RString stensu110;
    @ReportItem(name = "tanka110", length = 5, order = 213)
    public RString tanka110;
    @ReportItem(name = "hiyou110", length = 9, order = 214)
    public RString hiyou110;
    @ReportItem(name = "ritu110", length = 3, order = 215)
    public RString ritu110;
    @ReportItem(name = "kyufu110", length = 9, order = 216)
    public RString kyufu110;
    @ReportItem(name = "hoken110", length = 9, order = 217)
    public RString hoken110;
    @ReportItem(name = "zengaku110", length = 9, order = 218)
    public RString zengaku110;
    @ReportItem(name = "jigyomei1210", length = 18, order = 219)
    public RString jigyomei1210;
    @ReportItem(name = "sname1210", length = 8, order = 220)
    public RString sname1210;
    @ReportItem(name = "jigyomei1111", length = 18, order = 221)
    public RString jigyomei1111;
    @ReportItem(name = "sname1111", length = 8, order = 222)
    public RString sname1111;
    @ReportItem(name = "sover111", length = 8, order = 223)
    public RString sover111;
    @ReportItem(name = "sin111", length = 8, order = 224)
    public RString sin111;
    @ReportItem(name = "kover111", length = 8, order = 225)
    public RString kover111;
    @ReportItem(name = "kin111", length = 8, order = 226)
    public RString kin111;
    @ReportItem(name = "jigyoshoCd111", length = 10, order = 227)
    public RString jigyoshoCd111;
    @ReportItem(name = "ten111", length = 6, order = 228)
    public RString ten111;
    @ReportItem(name = "wariritsu111", length = 3, order = 229)
    public RString wariritsu111;
    @ReportItem(name = "wariten111", length = 6, order = 230)
    public RString wariten111;
    @ReportItem(name = "kai111", length = 3, order = 231)
    public RString kai111;
    @ReportItem(name = "stensu111", length = 8, order = 232)
    public RString stensu111;
    @ReportItem(name = "tanka111", length = 5, order = 233)
    public RString tanka111;
    @ReportItem(name = "hiyou111", length = 9, order = 234)
    public RString hiyou111;
    @ReportItem(name = "ritu111", length = 3, order = 235)
    public RString ritu111;
    @ReportItem(name = "kyufu111", length = 9, order = 236)
    public RString kyufu111;
    @ReportItem(name = "hoken111", length = 9, order = 237)
    public RString hoken111;
    @ReportItem(name = "zengaku111", length = 9, order = 238)
    public RString zengaku111;
    @ReportItem(name = "scode111", length = 6, order = 239)
    public RString scode111;
    @ReportItem(name = "jigyomei1211", length = 18, order = 240)
    public RString jigyomei1211;
    @ReportItem(name = "sname1211", length = 8, order = 241)
    public RString sname1211;
    @ReportItem(name = "sname1112", length = 8, order = 242)
    public RString sname1112;
    @ReportItem(name = "jigyomei1112", length = 18, order = 243)
    public RString jigyomei1112;
    @ReportItem(name = "sover112", length = 8, order = 244)
    public RString sover112;
    @ReportItem(name = "sin112", length = 8, order = 245)
    public RString sin112;
    @ReportItem(name = "kover112", length = 8, order = 246)
    public RString kover112;
    @ReportItem(name = "kin112", length = 8, order = 247)
    public RString kin112;
    @ReportItem(name = "jigyoshoCd112", length = 10, order = 248)
    public RString jigyoshoCd112;
    @ReportItem(name = "scode112", length = 6, order = 249)
    public RString scode112;
    @ReportItem(name = "ten112", length = 6, order = 250)
    public RString ten112;
    @ReportItem(name = "wariritsu112", length = 3, order = 251)
    public RString wariritsu112;
    @ReportItem(name = "wariten112", length = 6, order = 252)
    public RString wariten112;
    @ReportItem(name = "kai112", length = 3, order = 253)
    public RString kai112;
    @ReportItem(name = "stensu112", length = 8, order = 254)
    public RString stensu112;
    @ReportItem(name = "tanka112", length = 5, order = 255)
    public RString tanka112;
    @ReportItem(name = "hiyou112", length = 9, order = 256)
    public RString hiyou112;
    @ReportItem(name = "ritu112", length = 3, order = 257)
    public RString ritu112;
    @ReportItem(name = "kyufu112", length = 9, order = 258)
    public RString kyufu112;
    @ReportItem(name = "hoken112", length = 9, order = 259)
    public RString hoken112;
    @ReportItem(name = "zengaku112", length = 9, order = 260)
    public RString zengaku112;
    @ReportItem(name = "sname1212", length = 8, order = 261)
    public RString sname1212;
    @ReportItem(name = "jigyomei1212", length = 18, order = 262)
    public RString jigyomei1212;
    @ReportItem(name = "jigyomei1113", length = 18, order = 263)
    public RString jigyomei1113;
    @ReportItem(name = "sname1113", length = 8, order = 264)
    public RString sname1113;
    @ReportItem(name = "sover113", length = 8, order = 265)
    public RString sover113;
    @ReportItem(name = "sin113", length = 8, order = 266)
    public RString sin113;
    @ReportItem(name = "kover113", length = 8, order = 267)
    public RString kover113;
    @ReportItem(name = "kin113", length = 8, order = 268)
    public RString kin113;
    @ReportItem(name = "jigyoshoCd113", length = 10, order = 269)
    public RString jigyoshoCd113;
    @ReportItem(name = "scode113", length = 6, order = 270)
    public RString scode113;
    @ReportItem(name = "ten113", length = 6, order = 271)
    public RString ten113;
    @ReportItem(name = "wariritsu113", length = 3, order = 272)
    public RString wariritsu113;
    @ReportItem(name = "wariten113", length = 6, order = 273)
    public RString wariten113;
    @ReportItem(name = "kai113", length = 3, order = 274)
    public RString kai113;
    @ReportItem(name = "stensu113", length = 8, order = 275)
    public RString stensu113;
    @ReportItem(name = "tanka113", length = 5, order = 276)
    public RString tanka113;
    @ReportItem(name = "hiyou113", length = 9, order = 277)
    public RString hiyou113;
    @ReportItem(name = "ritu113", length = 3, order = 278)
    public RString ritu113;
    @ReportItem(name = "kyufu113", length = 9, order = 279)
    public RString kyufu113;
    @ReportItem(name = "hoken113", length = 9, order = 280)
    public RString hoken113;
    @ReportItem(name = "zengaku113", length = 9, order = 281)
    public RString zengaku113;
    @ReportItem(name = "jigyomei1213", length = 18, order = 282)
    public RString jigyomei1213;
    @ReportItem(name = "sname1213", length = 8, order = 283)
    public RString sname1213;
    @ReportItem(name = "jigyomei1114", length = 18, order = 284)
    public RString jigyomei1114;
    @ReportItem(name = "sname1114", length = 8, order = 285)
    public RString sname1114;
    @ReportItem(name = "sover114", length = 8, order = 286)
    public RString sover114;
    @ReportItem(name = "sin114", length = 8, order = 287)
    public RString sin114;
    @ReportItem(name = "kover114", length = 8, order = 288)
    public RString kover114;
    @ReportItem(name = "kin114", length = 8, order = 289)
    public RString kin114;
    @ReportItem(name = "jigyoshoCd114", length = 10, order = 290)
    public RString jigyoshoCd114;
    @ReportItem(name = "scode114", length = 6, order = 291)
    public RString scode114;
    @ReportItem(name = "ten114", length = 6, order = 292)
    public RString ten114;
    @ReportItem(name = "wariritsu114", length = 3, order = 293)
    public RString wariritsu114;
    @ReportItem(name = "wariten114", length = 6, order = 294)
    public RString wariten114;
    @ReportItem(name = "kai114", length = 3, order = 295)
    public RString kai114;
    @ReportItem(name = "stensu114", length = 8, order = 296)
    public RString stensu114;
    @ReportItem(name = "tanka114", length = 5, order = 297)
    public RString tanka114;
    @ReportItem(name = "hiyou114", length = 9, order = 298)
    public RString hiyou114;
    @ReportItem(name = "ritu114", length = 3, order = 299)
    public RString ritu114;
    @ReportItem(name = "kyufu114", length = 9, order = 300)
    public RString kyufu114;
    @ReportItem(name = "hoken114", length = 9, order = 301)
    public RString hoken114;
    @ReportItem(name = "zengaku114", length = 9, order = 302)
    public RString zengaku114;
    @ReportItem(name = "jigyomei1214", length = 18, order = 303)
    public RString jigyomei1214;
    @ReportItem(name = "sname1214", length = 8, order = 304)
    public RString sname1214;
    @ReportItem(name = "jigyomei1115", length = 18, order = 305)
    public RString jigyomei1115;
    @ReportItem(name = "sname1115", length = 8, order = 306)
    public RString sname1115;
    @ReportItem(name = "jigyoshoCd115", length = 10, order = 307)
    public RString jigyoshoCd115;
    @ReportItem(name = "scode115", length = 6, order = 308)
    public RString scode115;
    @ReportItem(name = "ten115", length = 6, order = 309)
    public RString ten115;
    @ReportItem(name = "wariritsu115", length = 3, order = 310)
    public RString wariritsu115;
    @ReportItem(name = "wariten115", length = 6, order = 311)
    public RString wariten115;
    @ReportItem(name = "kai115", length = 3, order = 312)
    public RString kai115;
    @ReportItem(name = "stensu115", length = 8, order = 313)
    public RString stensu115;
    @ReportItem(name = "sover115", length = 8, order = 314)
    public RString sover115;
    @ReportItem(name = "sin115", length = 8, order = 315)
    public RString sin115;
    @ReportItem(name = "kover115", length = 8, order = 316)
    public RString kover115;
    @ReportItem(name = "kin115", length = 8, order = 317)
    public RString kin115;
    @ReportItem(name = "tanka115", length = 5, order = 318)
    public RString tanka115;
    @ReportItem(name = "hiyou115", length = 9, order = 319)
    public RString hiyou115;
    @ReportItem(name = "ritu115", length = 3, order = 320)
    public RString ritu115;
    @ReportItem(name = "kyufu115", length = 9, order = 321)
    public RString kyufu115;
    @ReportItem(name = "hoken115", length = 9, order = 322)
    public RString hoken115;
    @ReportItem(name = "zengaku115", length = 9, order = 323)
    public RString zengaku115;
    @ReportItem(name = "jigyomei1215", length = 18, order = 324)
    public RString jigyomei1215;
    @ReportItem(name = "sname1215", length = 8, order = 325)
    public RString sname1215;
    @ReportItem(name = "gokeiTen", length = 7, order = 326)
    public RString gokeiTen;
    @ReportItem(name = "gokeiStensu", length = 8, order = 327)
    public RString gokeiStensu;
    @ReportItem(name = "gokeiSover", length = 8, order = 328)
    public RString gokeiSover;
    @ReportItem(name = "gokeiSin", length = 8, order = 329)
    public RString gokeiSin;
    @ReportItem(name = "gokeiKover", length = 8, order = 330)
    public RString gokeiKover;
    @ReportItem(name = "gokeiKin", length = 8, order = 331)
    public RString gokeiKin;
    @ReportItem(name = "gokeiHiyou", length = 9, order = 332)
    public RString gokeiHiyou;
    @ReportItem(name = "gokeiKyufu", length = 9, order = 333)
    public RString gokeiKyufu;
    @ReportItem(name = "gokeiHoken", length = 9, order = 334)
    public RString gokeiHoken;
    @ReportItem(name = "gokeiZengaku", length = 9, order = 335)
    public RString gokeiZengaku;
    @ReportItem(name = "sgten1", length = 8, order = 336)
    public RString sgten1;
    @ReportItem(name = "sgsin6", length = 8, order = 337)
    public RString sgsin6;
    @ReportItem(name = "sgsin11", length = 8, order = 338)
    public RString sgsin11;
    @ReportItem(name = "sgten11", length = 8, order = 339)
    public RString sgten11;
    @ReportItem(name = "sgsover11", length = 8, order = 340)
    public RString sgsover11;
    @ReportItem(name = "sgname1", length = 15, order = 341)
    public RString sgname1;
    @ReportItem(name = "sgsin1", length = 8, order = 342)
    public RString sgsin1;
    @ReportItem(name = "sgsover1", length = 8, order = 343)
    public RString sgsover1;
    @ReportItem(name = "sgname6", length = 15, order = 344)
    public RString sgname6;
    @ReportItem(name = "sgten6", length = 8, order = 345)
    public RString sgten6;
    @ReportItem(name = "sgsover6", length = 8, order = 346)
    public RString sgsover6;
    @ReportItem(name = "sgname11", length = 15, order = 347)
    public RString sgname11;
    @ReportItem(name = "sgname2", length = 15, order = 348)
    public RString sgname2;
    @ReportItem(name = "sgsin2", length = 8, order = 349)
    public RString sgsin2;
    @ReportItem(name = "sgten2", length = 8, order = 350)
    public RString sgten2;
    @ReportItem(name = "sgsover2", length = 8, order = 351)
    public RString sgsover2;
    @ReportItem(name = "sgname7", length = 15, order = 352)
    public RString sgname7;
    @ReportItem(name = "sgsin7", length = 8, order = 353)
    public RString sgsin7;
    @ReportItem(name = "sgten7", length = 8, order = 354)
    public RString sgten7;
    @ReportItem(name = "sgsover7", length = 8, order = 355)
    public RString sgsover7;
    @ReportItem(name = "sgname12", length = 15, order = 356)
    public RString sgname12;
    @ReportItem(name = "sgsin12", length = 8, order = 357)
    public RString sgsin12;
    @ReportItem(name = "sgten12", length = 8, order = 358)
    public RString sgten12;
    @ReportItem(name = "sgsover12", length = 8, order = 359)
    public RString sgsover12;
    @ReportItem(name = "sgname3", length = 15, order = 360)
    public RString sgname3;
    @ReportItem(name = "sgsin3", length = 8, order = 361)
    public RString sgsin3;
    @ReportItem(name = "sgten3", length = 8, order = 362)
    public RString sgten3;
    @ReportItem(name = "sgsover3", length = 8, order = 363)
    public RString sgsover3;
    @ReportItem(name = "sgname8", length = 15, order = 364)
    public RString sgname8;
    @ReportItem(name = "sgsin8", length = 8, order = 365)
    public RString sgsin8;
    @ReportItem(name = "sgten8", length = 8, order = 366)
    public RString sgten8;
    @ReportItem(name = "sgsover8", length = 8, order = 367)
    public RString sgsover8;
    @ReportItem(name = "sgname13", length = 15, order = 368)
    public RString sgname13;
    @ReportItem(name = "sgsin13", length = 8, order = 369)
    public RString sgsin13;
    @ReportItem(name = "sgten13", length = 8, order = 370)
    public RString sgten13;
    @ReportItem(name = "sgsover13", length = 8, order = 371)
    public RString sgsover13;
    @ReportItem(name = "sgten4", length = 8, order = 372)
    public RString sgten4;
    @ReportItem(name = "sgname4", length = 15, order = 373)
    public RString sgname4;
    @ReportItem(name = "sgsover4", length = 8, order = 374)
    public RString sgsover4;
    @ReportItem(name = "sgname9", length = 15, order = 375)
    public RString sgname9;
    @ReportItem(name = "sgsin9", length = 8, order = 376)
    public RString sgsin9;
    @ReportItem(name = "sgten9", length = 8, order = 377)
    public RString sgten9;
    @ReportItem(name = "sgsover9", length = 8, order = 378)
    public RString sgsover9;
    @ReportItem(name = "sgname14", length = 15, order = 379)
    public RString sgname14;
    @ReportItem(name = "sgsin14", length = 8, order = 380)
    public RString sgsin14;
    @ReportItem(name = "sgten14", length = 8, order = 381)
    public RString sgten14;
    @ReportItem(name = "sgsover14", length = 8, order = 382)
    public RString sgsover14;
    @ReportItem(name = "sgsin4", length = 8, order = 383)
    public RString sgsin4;
    @ReportItem(name = "sgname5", length = 15, order = 384)
    public RString sgname5;
    @ReportItem(name = "sgsin5", length = 8, order = 385)
    public RString sgsin5;
    @ReportItem(name = "sgten5", length = 8, order = 386)
    public RString sgten5;
    @ReportItem(name = "sgsover5", length = 8, order = 387)
    public RString sgsover5;
    @ReportItem(name = "sgname10", length = 15, order = 388)
    public RString sgname10;
    @ReportItem(name = "sgsin10", length = 8, order = 389)
    public RString sgsin10;
    @ReportItem(name = "sgsover10", length = 8, order = 390)
    public RString sgsover10;
    @ReportItem(name = "sgname15", length = 15, order = 391)
    public RString sgname15;
    @ReportItem(name = "sgsin15", length = 8, order = 392)
    public RString sgsin15;
    @ReportItem(name = "sgten15", length = 8, order = 393)
    public RString sgten15;
    @ReportItem(name = "sgsover15", length = 8, order = 394)
    public RString sgsover15;
    @ReportItem(name = "sgten10", length = 8, order = 395)
    public RString sgten10;
    @ReportItem(name = "gokeiSgname", length = 8, order = 396)
    public RString gokeiSgname;
    @ReportItem(name = "gokeiSgten", length = 8, order = 397)
    public RString gokeiSgten;
    @ReportItem(name = "tougetsu", length = 3, order = 398)
    public RString tougetsu;
    @ReportItem(name = "zengetsu", length = 3, order = 399)
    public RString zengetsu;
    @ReportItem(name = "ruiseki", length = 3, order = 400)
    public RString ruiseki;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
