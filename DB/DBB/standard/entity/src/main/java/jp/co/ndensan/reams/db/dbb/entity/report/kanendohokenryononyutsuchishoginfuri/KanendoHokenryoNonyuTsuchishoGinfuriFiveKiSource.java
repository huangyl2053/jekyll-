package jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_5期 HokenryoNonyuTsuchishoGinfuriFiveKiSource
 *
 * @reamsid_L DBB-9110-150 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "titleNendo", length = 4, order = 1)
    public RString titleNendo;
    @ReportItem(name = "HyojicodeName1", order = 2)
    public RString hyojicodeName1;
    @ReportItem(name = "HyojicodeName2", order = 3)
    public RString hyojicodeName2;
    @ReportItem(name = "HyojicodeName3", order = 4)
    public RString hyojicodeName3;
    @ReportItem(name = "santeiKisoKikanKaishi", length = 12, order = 5)
    public RString santeiKisoKikanKaishi;
    @ReportItem(name = "Hyojicode1", length = 12, order = 6)
    public RString hyojicode1;
    @ReportItem(name = "Hyojicode2", length = 12, order = 7)
    public RString hyojicode2;
    @ReportItem(name = "Hyojicode3", length = 12, order = 8)
    public RString hyojicode3;
    @ReportItem(name = "santeiKisoKikanshoryo", length = 12, order = 9)
    public RString santeiKisoKikanshoryo;
    @ReportItem(name = "tsuchishoNo", order = 10)
    public RString tsuchishoNo;
    @ReportItem(name = "santeiKisoNokisu", length = 5, order = 11)
    public RString santeiKisoNokisu;
    @ReportItem(name = "setaiCode", length = 15, order = 12)
    public RString setaiCode;
    @ReportItem(name = "santeiKisoShotokuDankai", length = 5, order = 13)
    public RString santeiKisoShotokuDankai;
    @ReportItem(name = "hihokenshaName", order = 14)
    public RString hihokenshaName;
    @ReportItem(name = "santeiKisoHokenryoRitsu", length = 8, order = 15)
    public RString santeiKisoHokenryoRitsu;
    @ReportItem(name = "santeiKisoCalHokenryoGaku", length = 8, order = 16)
    public RString santeiKisoCalHokenryoGaku;
    @ReportItem(name = "setaiNushiName", order = 17)
    public RString setaiNushiName;
    @ReportItem(name = "santeiKisoGenmenGaku", length = 8, order = 18)
    public RString santeiKisoGenmenGaku;
    @ReportItem(name = "nendo1", length = 4, order = 19)
    public RString nendo1;
    @ReportItem(name = "hokenryoGaku", length = 10, order = 20)
    public RString hokenryoGaku;
    @ReportItem(name = "santeiKisoTokuchoNofuSubekiGaku", length = 8, order = 21)
    public RString santeiKisoTokuchoNofuSubekiGaku;
    @ReportItem(name = "santeiKisoFuchoNofuSubekiGaku", length = 8, order = 22)
    public RString santeiKisoFuchoNofuSubekiGaku;
    @ReportItem(name = "santeiKisoNofuzumiGaku", length = 8, order = 23)
    public RString santeiKisoNofuzumiGaku;
    @ReportItem(name = "santeiKisoKongoNofuSubekiGaku", length = 8, order = 24)
    public RString santeiKisoKongoNofuSubekiGaku;
    @ReportItem(name = "santeiKisoKomokuTitle1", length = 4, order = 25)
    public RString santeiKisoKomokuTitle1;
    @ReportItem(name = "santeiKisoKomokuTitle3", length = 4, order = 26)
    public RString santeiKisoKomokuTitle3;
    @ReportItem(name = "santeiKisoTokiHokenryoGaku1", length = 8, order = 27)
    public RString santeiKisoTokiHokenryoGaku1;
    @ReportItem(name = "santeiKisoJikiHokenryoGaku1", length = 8, order = 28)
    public RString santeiKisoJikiHokenryoGaku1;
    @ReportItem(name = "santeiKisoYen1", length = 1, order = 29)
    public RString santeiKisoYen1;
    @ReportItem(name = "santeiKisoYen2", length = 1, order = 30)
    public RString santeiKisoYen2;
    @ReportItem(name = "santeiKisoKomokuTitle2", length = 4, order = 31)
    public RString santeiKisoKomokuTitle2;
    @ReportItem(name = "santeiKisoKomokuTitle4", length = 4, order = 32)
    public RString santeiKisoKomokuTitle4;
    @ReportItem(name = "santeiKisoTokiHokenryoGaku2", length = 8, order = 33)
    public RString santeiKisoTokiHokenryoGaku2;
    @ReportItem(name = "santeiKisoJikiHokenryoGaku2", length = 8, order = 34)
    public RString santeiKisoJikiHokenryoGaku2;
    @ReportItem(name = "gekihenTitle", length = 20, order = 35)
    public RString gekihenTitle;
    @ReportItem(name = "gekihenMongon", length = 20, order = 36)
    public RString gekihenMongon;
    @ReportItem(name = "ryoshushoNendo", length = 4, order = 37)
    public RString ryoshushoNendo;
    @ReportItem(name = "ryoshushoNofuGaku1", length = 10, order = 38)
    public RString ryoshushoNofuGaku1;
    @ReportItem(name = "ki1", length = 2, order = 39)
    public RString ki1;
    @ReportItem(name = "nokiKaishi1", length = 11, order = 40)
    public RString nokiKaishi1;
    @ReportItem(name = "ryoshushoNofuin1", length = 2, order = 41)
    public RString ryoshushoNofuin1;
    @ReportItem(name = "ryoshushoRyoshuHizukein1", length = 4, order = 42)
    public RString ryoshushoRyoshuHizukein1;
    @ReportItem(name = "tsuki1", length = 2, order = 43)
    public RString tsuki1;
    @ReportItem(name = "nokiShuryo1", length = 11, order = 44)
    public RString nokiShuryo1;
    @ReportItem(name = "ryoshushoKi1", length = 2, order = 45)
    public RString ryoshushoKi1;
    @ReportItem(name = "ki2", length = 2, order = 46)
    public RString ki2;
    @ReportItem(name = "nokiKaishi2", length = 11, order = 47)
    public RString nokiKaishi2;
    @ReportItem(name = "ryoshushoZuiji1", length = 2, order = 48)
    public RString ryoshushoZuiji1;
    @ReportItem(name = "tsuki2", length = 2, order = 49)
    public RString tsuki2;
    @ReportItem(name = "nokiShuryo2", length = 11, order = 50)
    public RString nokiShuryo2;
    @ReportItem(name = "ki3", length = 2, order = 51)
    public RString ki3;
    @ReportItem(name = "nokiKaishi3", length = 11, order = 52)
    public RString nokiKaishi3;
    @ReportItem(name = "tsuki3", length = 2, order = 53)
    public RString tsuki3;
    @ReportItem(name = "nokiShuryo3", length = 11, order = 54)
    public RString nokiShuryo3;
    @ReportItem(name = "ryoshushoNofuGaku2", length = 10, order = 55)
    public RString ryoshushoNofuGaku2;
    @ReportItem(name = "ki4", length = 2, order = 56)
    public RString ki4;
    @ReportItem(name = "nokiKaishi4", length = 11, order = 57)
    public RString nokiKaishi4;
    @ReportItem(name = "ryoshushoNofuin2", length = 2, order = 58)
    public RString ryoshushoNofuin2;
    @ReportItem(name = "ryoshushoRyoshuHizukein2", length = 4, order = 59)
    public RString ryoshushoRyoshuHizukein2;
    @ReportItem(name = "tsuki4", length = 2, order = 60)
    public RString tsuki4;
    @ReportItem(name = "nokiShuryo4", length = 11, order = 61)
    public RString nokiShuryo4;
    @ReportItem(name = "ryoshushoKi2", length = 2, order = 62)
    public RString ryoshushoKi2;
    @ReportItem(name = "ki5", length = 2, order = 63)
    public RString ki5;
    @ReportItem(name = "nokiKaishi5", length = 11, order = 64)
    public RString nokiKaishi5;
    @ReportItem(name = "ryoshushoZuiji2", length = 2, order = 65)
    public RString ryoshushoZuiji2;
    @ReportItem(name = "tsuki5", length = 2, order = 66)
    public RString tsuki5;
    @ReportItem(name = "nokiShuryo5", length = 11, order = 67)
    public RString nokiShuryo5;
    @ReportItem(name = "bankCode", length = 7, order = 68)
    public RString bankCode;
    @ReportItem(name = "ryoshushoNofuGaku3", length = 10, order = 69)
    public RString ryoshushoNofuGaku3;
    @ReportItem(name = "kozaMeigi", order = 70)
    public RString kozaMeigi;
    @ReportItem(name = "ryoshushoNofuin3", length = 2, order = 71)
    public RString ryoshushoNofuin3;
    @ReportItem(name = "ryoshushoRyoshuHizukein3", length = 4, order = 72)
    public RString ryoshushoRyoshuHizukein3;
    @ReportItem(name = "ryoshushoKi3", length = 2, order = 73)
    public RString ryoshushoKi3;
    @ReportItem(name = "ryoshushoZuiji3", length = 2, order = 74)
    public RString ryoshushoZuiji3;
    @ReportItem(name = "kozaShurui", length = 3, order = 75)
    public RString kozaShurui;
    @ReportItem(name = "ryoshushoNofuGaku4", length = 10, order = 76)
    public RString ryoshushoNofuGaku4;
    @ReportItem(name = "kozaNo", length = 14, order = 77)
    public RString kozaNo;
    @ReportItem(name = "ryoshushoNofuin4", length = 2, order = 78)
    public RString ryoshushoNofuin4;
    @ReportItem(name = "ryoshushoRyoshuHizukein4", length = 4, order = 79)
    public RString ryoshushoRyoshuHizukein4;
    @ReportItem(name = "ryoshushoKi4", length = 2, order = 80)
    public RString ryoshushoKi4;
    @ReportItem(name = "bankName", order = 81)
    public RString bankName;
    @ReportItem(name = "renban", length = 10, order = 82)
    public RString renban;
    @ReportItem(name = "ryoshushoZuiji4", length = 2, order = 83)
    public RString ryoshushoZuiji4;
    @ReportItem(name = "hokenshaName", length = 10, order = 84)
    public RString hokenshaName;
    @ReportItem(name = "tsuchiKaishiKi", length = 2, order = 85)
    public RString tsuchiKaishiKi;
    @ReportItem(name = "tsuchiShuryoKi", length = 2, order = 86)
    public RString tsuchiShuryoKi;
    @ReportItem(name = "ryoshushoNofuGaku5", length = 10, order = 87)
    public RString ryoshushoNofuGaku5;
    @ReportItem(name = "ryoshushoNofuin5", length = 2, order = 88)
    public RString ryoshushoNofuin5;
    @ReportItem(name = "ryoshushoRyoshuHizukein5", length = 4, order = 89)
    public RString ryoshushoRyoshuHizukein5;
    @ReportItem(name = "ryoshushoKi5", length = 2, order = 90)
    public RString ryoshushoKi5;
    @ReportItem(name = "ryoshushoZuiji5", length = 2, order = 91)
    public RString ryoshushoZuiji5;
    @ReportItem(name = "hakkoYMD", length = 12, order = 92)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 93)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 94)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "denshiKoin", order = 95)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 96)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 97)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 98)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 99)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 100)
    public RString koinShoryaku;
    @ReportItem(name = "nofushoKanendo5", length = 6, order = 101)
    public RString nofushoKanendo5;
    @ReportItem(name = "nofushoNendo5", length = 6, order = 102)
    public RString nofushoNendo5;
    @ReportItem(name = "nofushoKanendo4", length = 6, order = 103)
    public RString nofushoKanendo4;
    @ReportItem(name = "nofushoNendo4", length = 6, order = 104)
    public RString nofushoNendo4;
    @ReportItem(name = "nofushoKanendo3", length = 6, order = 105)
    public RString nofushoKanendo3;
    @ReportItem(name = "nofushoKanendo2", length = 6, order = 106)
    public RString nofushoKanendo2;
    @ReportItem(name = "nofushoKanendo1", length = 6, order = 107)
    public RString nofushoKanendo1;
    @ReportItem(name = "nofushoNendo3", length = 6, order = 108)
    public RString nofushoNendo3;
    @ReportItem(name = "nofushoNendo2", length = 6, order = 109)
    public RString nofushoNendo2;
    @ReportItem(name = "nofushoNendo1", length = 6, order = 110)
    public RString nofushoNendo1;
    @ReportItem(name = "nofushoKanendobun5", length = 9, order = 111)
    public RString nofushoKanendobun5;
    @ReportItem(name = "nofushoKanendobun4", length = 9, order = 112)
    public RString nofushoKanendobun4;
    @ReportItem(name = "nofushoKanendobun3", length = 9, order = 113)
    public RString nofushoKanendobun3;
    @ReportItem(name = "nofushoKanendobun2", length = 9, order = 114)
    public RString nofushoKanendobun2;
    @ReportItem(name = "nofushoKanendobun1", length = 9, order = 115)
    public RString nofushoKanendobun1;
    @ReportItem(name = "nofushoKi5", length = 2, order = 116)
    public RString nofushoKi5;
    @ReportItem(name = "nofushoTsuki5", length = 2, order = 117)
    public RString nofushoTsuki5;
    @ReportItem(name = "nofushoKi4", length = 2, order = 118)
    public RString nofushoKi4;
    @ReportItem(name = "nofushoTsuki4", length = 2, order = 119)
    public RString nofushoTsuki4;
    @ReportItem(name = "nofushoKi3", length = 2, order = 120)
    public RString nofushoKi3;
    @ReportItem(name = "nofushoTsuki3", length = 2, order = 121)
    public RString nofushoTsuki3;
    @ReportItem(name = "nofushoKi2", length = 2, order = 122)
    public RString nofushoKi2;
    @ReportItem(name = "nofushoTsuki2", length = 2, order = 123)
    public RString nofushoTsuki2;
    @ReportItem(name = "nofushoKi1", length = 2, order = 124)
    public RString nofushoKi1;
    @ReportItem(name = "nofushoTsuki1", length = 2, order = 125)
    public RString nofushoTsuki1;
    @ReportItem(name = "nofushoOcr15", length = 6, order = 126)
    public RString nofushoOcr15;
    @ReportItem(name = "nofushoOcr14", length = 6, order = 127)
    public RString nofushoOcr14;
    @ReportItem(name = "nofushoOcr13", length = 6, order = 128)
    public RString nofushoOcr13;
    @ReportItem(name = "nofushoOcr12", length = 6, order = 129)
    public RString nofushoOcr12;
    @ReportItem(name = "nofushoOcr11", length = 6, order = 130)
    public RString nofushoOcr11;
    @ReportItem(name = "nofushoOcr25", length = 16, order = 131)
    public RString nofushoOcr25;
    @ReportItem(name = "nofushoOcr24", length = 16, order = 132)
    public RString nofushoOcr24;
    @ReportItem(name = "nofushoOcr23", length = 16, order = 133)
    public RString nofushoOcr23;
    @ReportItem(name = "nofushoOcr22", length = 16, order = 134)
    public RString nofushoOcr22;
    @ReportItem(name = "nofushoOcr21", length = 16, order = 135)
    public RString nofushoOcr21;
    @ReportItem(name = "nofushoOcr35", length = 17, order = 136)
    public RString nofushoOcr35;
    @ReportItem(name = "nofushoOcr34", length = 17, order = 137)
    public RString nofushoOcr34;
    @ReportItem(name = "nofushoOcr33", length = 17, order = 138)
    public RString nofushoOcr33;
    @ReportItem(name = "nofushoOcr32", length = 17, order = 139)
    public RString nofushoOcr32;
    @ReportItem(name = "nofushoOcr31", length = 17, order = 140)
    public RString nofushoOcr31;
    @ReportItem(name = "nofushoOcr45", length = 12, order = 141)
    public RString nofushoOcr45;
    @ReportItem(name = "nofushoOcr44", length = 12, order = 142)
    public RString nofushoOcr44;
    @ReportItem(name = "nofushoOcr43", length = 12, order = 143)
    public RString nofushoOcr43;
    @ReportItem(name = "nofushoOcr42", length = 12, order = 144)
    public RString nofushoOcr42;
    @ReportItem(name = "nofushoOcr41", length = 12, order = 145)
    public RString nofushoOcr41;
    @ReportItem(name = "nofushoNofugaku5", length = 10, order = 146)
    public RString nofushoNofugaku5;
    @ReportItem(name = "nofushoNofugaku4", length = 10, order = 147)
    public RString nofushoNofugaku4;
    @ReportItem(name = "nofushoNofugaku3", length = 10, order = 148)
    public RString nofushoNofugaku3;
    @ReportItem(name = "nofushoNofugaku2", length = 10, order = 149)
    public RString nofushoNofugaku2;
    @ReportItem(name = "nofushoNofugaku1", length = 10, order = 150)
    public RString nofushoNofugaku1;
    @ReportItem(name = "nofushoSofusakiName5", order = 151)
    public RString nofushoSofusakiName5;
    @ReportItem(name = "nofushoSofusakiName4", order = 152)
    public RString nofushoSofusakiName4;
    @ReportItem(name = "nofushoSofusakiName3", order = 153)
    public RString nofushoSofusakiName3;
    @ReportItem(name = "nofushoSofusakiName2", order = 154)
    public RString nofushoSofusakiName2;
    @ReportItem(name = "nofushoSofusakiName1", order = 155)
    public RString nofushoSofusakiName1;
    @ReportItem(name = "nofushoHonninName5", order = 156)
    public RString nofushoHonninName5;
    @ReportItem(name = "nofushoHonninName4", order = 157)
    public RString nofushoHonninName4;
    @ReportItem(name = "nofushoHonninName3", order = 158)
    public RString nofushoHonninName3;
    @ReportItem(name = "nofushoHonninName2", order = 159)
    public RString nofushoHonninName2;
    @ReportItem(name = "nofushoHonninName1", order = 160)
    public RString nofushoHonninName1;
    @ReportItem(name = "nofushoKakko14", length = 1, order = 161)
    public RString nofushoKakko14;
    @ReportItem(name = "nofushoKakko13", length = 1, order = 162)
    public RString nofushoKakko13;
    @ReportItem(name = "nofushoKakko12", length = 1, order = 163)
    public RString nofushoKakko12;
    @ReportItem(name = "nofushoKakko11", length = 1, order = 164)
    public RString nofushoKakko11;
    @ReportItem(name = "nofushoKakko15", length = 1, order = 165)
    public RString nofushoKakko15;
    @ReportItem(name = "nofushoKakko25", length = 1, order = 166)
    public RString nofushoKakko25;
    @ReportItem(name = "nofushoKakko35", length = 3, order = 167)
    public RString nofushoKakko35;
    @ReportItem(name = "nofushoKakko24", length = 1, order = 168)
    public RString nofushoKakko24;
    @ReportItem(name = "nofushoKakko34", length = 3, order = 169)
    public RString nofushoKakko34;
    @ReportItem(name = "nofushoKakko23", length = 1, order = 170)
    public RString nofushoKakko23;
    @ReportItem(name = "nofushoKakko33", length = 3, order = 171)
    public RString nofushoKakko33;
    @ReportItem(name = "nofushoKakko22", length = 1, order = 172)
    public RString nofushoKakko22;
    @ReportItem(name = "nofushoKakko32", length = 3, order = 173)
    public RString nofushoKakko32;
    @ReportItem(name = "nofushoKakko21", length = 1, order = 174)
    public RString nofushoKakko21;
    @ReportItem(name = "nofushoKakko31", length = 3, order = 175)
    public RString nofushoKakko31;
    @ReportItem(name = "nofushoTsuchishoNo5", order = 176)
    public RString nofushoTsuchishoNo5;
    @ReportItem(name = "nofushoTsuchishoNo4", order = 177)
    public RString nofushoTsuchishoNo4;
    @ReportItem(name = "nofushoTsuchishoNo3", order = 178)
    public RString nofushoTsuchishoNo3;
    @ReportItem(name = "nofushoTsuchishoNo2", order = 179)
    public RString nofushoTsuchishoNo2;
    @ReportItem(name = "nofushoTsuchishoNo1", order = 180)
    public RString nofushoTsuchishoNo1;
    @ReportItem(name = "nofushoSetaiCode5", length = 15, order = 181)
    public RString nofushoSetaiCode5;
    @ReportItem(name = "nofushoSetaiCode4", length = 15, order = 182)
    public RString nofushoSetaiCode4;
    @ReportItem(name = "nofushoSetaiCode3", length = 15, order = 183)
    public RString nofushoSetaiCode3;
    @ReportItem(name = "nofushoSetaiCode2", length = 15, order = 184)
    public RString nofushoSetaiCode2;
    @ReportItem(name = "nofushoSetaiCode1", length = 15, order = 185)
    public RString nofushoSetaiCode1;
    @ReportItem(name = "nofushohyojicodeName15", order = 186)
    public RString nofushohyojicodeName15;
    @ReportItem(name = "nofushohyojicode15", length = 20, order = 187)
    public RString nofushohyojicode15;
    @ReportItem(name = "nofushohyojicodeName14", order = 188)
    public RString nofushohyojicodeName14;
    @ReportItem(name = "nofushohyojicode14", length = 20, order = 189)
    public RString nofushohyojicode14;
    @ReportItem(name = "nofushohyojicodeName13", order = 190)
    public RString nofushohyojicodeName13;
    @ReportItem(name = "nofushohyojicode13", length = 20, order = 191)
    public RString nofushohyojicode13;
    @ReportItem(name = "nofushohyojicodeName12", order = 192)
    public RString nofushohyojicodeName12;
    @ReportItem(name = "nofushohyojicode12", length = 20, order = 193)
    public RString nofushohyojicode12;
    @ReportItem(name = "nofushohyojicodeName11", order = 194)
    public RString nofushohyojicodeName11;
    @ReportItem(name = "nofushohyojicode11", length = 20, order = 195)
    public RString nofushohyojicode11;
    @ReportItem(name = "nofushohyojicodeName25", order = 196)
    public RString nofushohyojicodeName25;
    @ReportItem(name = "nofushohyojicode25", length = 20, order = 197)
    public RString nofushohyojicode25;
    @ReportItem(name = "nofushohyojicodeName24", order = 198)
    public RString nofushohyojicodeName24;
    @ReportItem(name = "nofushohyojicode24", length = 20, order = 199)
    public RString nofushohyojicode24;
    @ReportItem(name = "nofushohyojicodeName23", order = 200)
    public RString nofushohyojicodeName23;
    @ReportItem(name = "nofushohyojicode23", length = 20, order = 201)
    public RString nofushohyojicode23;
    @ReportItem(name = "nofushohyojicodeName22", order = 202)
    public RString nofushohyojicodeName22;
    @ReportItem(name = "nofushohyojicode22", length = 20, order = 203)
    public RString nofushohyojicode22;
    @ReportItem(name = "nofushohyojicodeName21", order = 204)
    public RString nofushohyojicodeName21;
    @ReportItem(name = "nofushohyojicode21", length = 20, order = 205)
    public RString nofushohyojicode21;
    @ReportItem(name = "nofushohyojicodeName35", order = 206)
    public RString nofushohyojicodeName35;
    @ReportItem(name = "nofushohyojicode35", length = 20, order = 207)
    public RString nofushohyojicode35;
    @ReportItem(name = "nofushohyojicodeName34", order = 208)
    public RString nofushohyojicodeName34;
    @ReportItem(name = "nofushohyojicode34", length = 20, order = 209)
    public RString nofushohyojicode34;
    @ReportItem(name = "nofushohyojicodeName33", order = 210)
    public RString nofushohyojicodeName33;
    @ReportItem(name = "nofushohyojicode33", length = 20, order = 211)
    public RString nofushohyojicode33;
    @ReportItem(name = "nofushohyojicodeName32", order = 212)
    public RString nofushohyojicodeName32;
    @ReportItem(name = "nofushohyojicode32", length = 20, order = 213)
    public RString nofushohyojicode32;
    @ReportItem(name = "nofushohyojicodeName31", order = 214)
    public RString nofushohyojicodeName31;
    @ReportItem(name = "nofushohyojicode31", length = 20, order = 215)
    public RString nofushohyojicode31;
    @ReportItem(name = "nofushoNokigen5", length = 11, order = 216)
    public RString nofushoNokigen5;
    @ReportItem(name = "nofushoNokigen4", length = 11, order = 217)
    public RString nofushoNokigen4;
    @ReportItem(name = "nofushoNokigen3", length = 11, order = 218)
    public RString nofushoNokigen3;
    @ReportItem(name = "nofushoNokigen2", length = 11, order = 219)
    public RString nofushoNokigen2;
    @ReportItem(name = "nofushoNokigen1", length = 11, order = 220)
    public RString nofushoNokigen1;
    @ReportItem(name = "nofushoNofuin5", length = 2, order = 221)
    public RString nofushoNofuin5;
    @ReportItem(name = "nofushoNofuin4", length = 2, order = 222)
    public RString nofushoNofuin4;
    @ReportItem(name = "nofushoNofuin3", length = 2, order = 223)
    public RString nofushoNofuin3;
    @ReportItem(name = "nofushoNofuin2", length = 2, order = 224)
    public RString nofushoNofuin2;
    @ReportItem(name = "nofushoNofuin1", length = 2, order = 225)
    public RString nofushoNofuin1;
    @ReportItem(name = "nofushoRyoshuHizukein5", length = 4, order = 226)
    public RString nofushoRyoshuHizukein5;
    @ReportItem(name = "nofushoRyoshuHizukein4", length = 4, order = 227)
    public RString nofushoRyoshuHizukein4;
    @ReportItem(name = "nofushoRyoshuHizukein3", length = 4, order = 228)
    public RString nofushoRyoshuHizukein3;
    @ReportItem(name = "nofushoRyoshuHizukein2", length = 4, order = 229)
    public RString nofushoRyoshuHizukein2;
    @ReportItem(name = "nofushoRyoshuHizukein1", length = 4, order = 230)
    public RString nofushoRyoshuHizukein1;
    @ReportItem(name = "nofushoZuiji5", length = 2, order = 231)
    public RString nofushoZuiji5;
    @ReportItem(name = "nofushoZuiji4", length = 2, order = 232)
    public RString nofushoZuiji4;
    @ReportItem(name = "nofushoZuiji3", length = 2, order = 233)
    public RString nofushoZuiji3;
    @ReportItem(name = "nofushoZuiji2", length = 2, order = 234)
    public RString nofushoZuiji2;
    @ReportItem(name = "nofushoZuiji1", length = 2, order = 235)
    public RString nofushoZuiji1;
    @ReportItem(name = "mRenban1", length = 10, order = 236)
    public RString mRenban1;
    @ReportItem(name = "mRenban", length = 10, order = 237)
    public RString mRenban;
    @ReportItem(name = "nofushoShichosonMei15", order = 238)
    public RString nofushoShichosonMei15;
    @ReportItem(name = "nofushoShichosonMei14", order = 239)
    public RString nofushoShichosonMei14;
    @ReportItem(name = "nofushoShichosonMei13", order = 240)
    public RString nofushoShichosonMei13;
    @ReportItem(name = "nofushoShichosonMei12", order = 241)
    public RString nofushoShichosonMei12;
    @ReportItem(name = "nofushoShichosonMei11", order = 242)
    public RString nofushoShichosonMei11;
    @ReportItem(name = "yubinNo", length = 8, order = 243)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 244)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 245)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 246)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 247)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 248)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 249)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 250)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 251)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 252)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 253)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 254)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 255)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 256)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 257)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 258)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 259)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 260)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 261)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 262)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 263)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 264)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 265)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 266)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 267)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 268)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 269)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 270)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 271)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 272)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 273)
    public RString customerBarCode;
    @ReportItem(name = "yubinNo1", length = 8, order = 274)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 275)
    public RString gyoseiku1;
    @ReportItem(name = "jusho4", length = 20, order = 276)
    public RString jusho4;
    @ReportItem(name = "jushoText1", order = 277)
    public RString jushoText1;
    @ReportItem(name = "jusho5", length = 20, order = 278)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 279)
    public RString jusho6;
    @ReportItem(name = "katagakiText1", order = 280)
    public RString katagakiText1;
    @ReportItem(name = "katagaki3", length = 20, order = 281)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall3", length = 30, order = 282)
    public RString katagakiSmall3;
    @ReportItem(name = "katagaki4", length = 20, order = 283)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall4", length = 30, order = 284)
    public RString katagakiSmall4;
    @ReportItem(name = "shimei3", length = 20, order = 285)
    public RString shimei3;
    @ReportItem(name = "shimeiSmall3", length = 40, order = 286)
    public RString shimeiSmall3;
    @ReportItem(name = "shimeiText1", order = 287)
    public RString shimeiText1;
    @ReportItem(name = "meishoFuyo4", length = 3, order = 288)
    public RString meishoFuyo4;
    @ReportItem(name = "shimeiSmall4", length = 40, order = 289)
    public RString shimeiSmall4;
    @ReportItem(name = "dainoKubunMei1", length = 8, order = 290)
    public RString dainoKubunMei1;
    @ReportItem(name = "shimei4", length = 20, order = 291)
    public RString shimei4;
    @ReportItem(name = "meishoFuyo3", length = 3, order = 292)
    public RString meishoFuyo3;
    @ReportItem(name = "samabunShimeiText1", order = 293)
    public RString samabunShimeiText1;
    @ReportItem(name = "samaBun4", length = 3, order = 294)
    public RString samaBun4;
    @ReportItem(name = "samabunShimeiSmall3", length = 40, order = 295)
    public RString samabunShimeiSmall3;
    @ReportItem(name = "kakkoLeft3", length = 1, order = 296)
    public RString kakkoLeft3;
    @ReportItem(name = "samabunShimei3", length = 20, order = 297)
    public RString samabunShimei3;
    @ReportItem(name = "kakkoRight4", length = 1, order = 298)
    public RString kakkoRight4;
    @ReportItem(name = "kakkoLeft4", length = 1, order = 299)
    public RString kakkoLeft4;
    @ReportItem(name = "samabunShimei4", length = 20, order = 300)
    public RString samabunShimei4;
    @ReportItem(name = "samaBun3", length = 3, order = 301)
    public RString samaBun3;
    @ReportItem(name = "kakkoRight3", length = 1, order = 302)
    public RString kakkoRight3;
    @ReportItem(name = "samabunShimeiSmall4", length = 40, order = 303)
    public RString samabunShimeiSmall4;
    @ReportItem(name = "customerBarCode1", order = 304)
    public RString customerBarCode1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
