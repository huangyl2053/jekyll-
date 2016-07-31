package jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 主治医意見書（オルカ）のReportSourceクラスです。
 *
 * @reamsid_L DBE-1600-021 lishengli
 */
public class Ikenshokinyuyoshi02ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kikiudeRight", length = 1, order = 1)
    public RString kikiudeRight;
    @ReportItem(name = "kikiudeLeft", length = 1, order = 2)
    public RString kikiudeLeft;
    @ReportItem(name = "shincho", length = 5, order = 3)
    public RString shincho;
    @ReportItem(name = "taiju", length = 5, order = 4)
    public RString taiju;
    @ReportItem(name = "taijuZoka", length = 1, order = 5)
    public RString taijuZoka;
    @ReportItem(name = "taijuIji", length = 1, order = 6)
    public RString taijuIji;
    @ReportItem(name = "taijuGensho", length = 1, order = 7)
    public RString taijuGensho;
    @ReportItem(name = "shishikessonUmu", length = 1, order = 8)
    public RString shishikessonUmu;
    @ReportItem(name = "shishikesson", length = 10, order = 9)
    public RString shishikesson;
    @ReportItem(name = "mahiUmu", length = 1, order = 10)
    public RString mahiUmu;
    @ReportItem(name = "mahiMigiueUmu", length = 1, order = 11)
    public RString mahiMigiueUmu;
    @ReportItem(name = "mahiMigiueKei", length = 1, order = 12)
    public RString mahiMigiueKei;
    @ReportItem(name = "mahiMigiueChu", length = 1, order = 13)
    public RString mahiMigiueChu;
    @ReportItem(name = "mahiMigiueJu", length = 1, order = 14)
    public RString mahiMigiueJu;
    @ReportItem(name = "mahiHidariueUmu", length = 1, order = 15)
    public RString mahiHidariueUmu;
    @ReportItem(name = "mahiHidariueKei", length = 1, order = 16)
    public RString mahiHidariueKei;
    @ReportItem(name = "mahiHidariueChu", length = 1, order = 17)
    public RString mahiHidariueChu;
    @ReportItem(name = "mahiHidariueJu", length = 1, order = 18)
    public RString mahiHidariueJu;
    @ReportItem(name = "mahiMigishitaUmu", length = 1, order = 19)
    public RString mahiMigishitaUmu;
    @ReportItem(name = "mahiMigishitaKei", length = 1, order = 20)
    public RString mahiMigishitaKei;
    @ReportItem(name = "mahiMigishitaChu", length = 1, order = 21)
    public RString mahiMigishitaChu;
    @ReportItem(name = "mahiHidarishitaUmu", length = 1, order = 22)
    public RString mahiHidarishitaUmu;
    @ReportItem(name = "mahiHidarishitaKei", length = 1, order = 23)
    public RString mahiHidarishitaKei;
    @ReportItem(name = "mahiHidarishitaChu", length = 1, order = 24)
    public RString mahiHidarishitaChu;
    @ReportItem(name = "mahiHidarishitaJu", length = 1, order = 25)
    public RString mahiHidarishitaJu;
    @ReportItem(name = "mahiMigishitaJu", length = 1, order = 26)
    public RString mahiMigishitaJu;
    @ReportItem(name = "mahiSonotaUmu", length = 1, order = 27)
    public RString mahiSonotaUmu;
    @ReportItem(name = "mahiSonotaBui", length = 10, order = 28)
    public RString mahiSonotaBui;
    @ReportItem(name = "mahiSonotaKei", length = 1, order = 29)
    public RString mahiSonotaKei;
    @ReportItem(name = "mahiSonotaChu", length = 1, order = 30)
    public RString mahiSonotaChu;
    @ReportItem(name = "mahiSonotaJu", length = 1, order = 31)
    public RString mahiSonotaJu;
    @ReportItem(name = "kinryokuteikaUmu", length = 1, order = 32)
    public RString kinryokuteikaUmu;
    @ReportItem(name = "kinryokuteikaBui", length = 10, order = 33)
    public RString kinryokuteikaBui;
    @ReportItem(name = "kinryokuteikaKei", length = 1, order = 34)
    public RString kinryokuteikaKei;
    @ReportItem(name = "kinryokuteikaChu", length = 1, order = 35)
    public RString kinryokuteikaChu;
    @ReportItem(name = "kinryokuteikaJu", length = 1, order = 36)
    public RString kinryokuteikaJu;
    @ReportItem(name = "kansetsukoshukUmu", length = 1, order = 37)
    public RString kansetsukoshukUmu;
    @ReportItem(name = "kansetsukoshukuBui", length = 10, order = 38)
    public RString kansetsukoshukuBui;
    @ReportItem(name = "kansetsukoshukuKei", length = 1, order = 39)
    public RString kansetsukoshukuKei;
    @ReportItem(name = "kansetsukoshukuChu", length = 1, order = 40)
    public RString kansetsukoshukuChu;
    @ReportItem(name = "kansetsukoshukuJu", length = 1, order = 41)
    public RString kansetsukoshukuJu;
    @ReportItem(name = "kansetsuitamiUmu", length = 1, order = 42)
    public RString kansetsuitamiUmu;
    @ReportItem(name = "kansetsuitamiBui", length = 10, order = 43)
    public RString kansetsuitamiBui;
    @ReportItem(name = "kansetsuitamiKei", length = 1, order = 44)
    public RString kansetsuitamiKei;
    @ReportItem(name = "kansetsuitamiChu", length = 1, order = 45)
    public RString kansetsuitamiChu;
    @ReportItem(name = "kansetsuitamiJu", length = 1, order = 46)
    public RString kansetsuitamiJu;
    @ReportItem(name = "shitchoUmu", length = 1, order = 47)
    public RString shitchoUmu;
    @ReportItem(name = "shitchoJoshiRight", length = 1, order = 48)
    public RString shitchoJoshiRight;
    @ReportItem(name = "shitchoJoshiLeft", length = 1, order = 49)
    public RString shitchoJoshiLeft;
    @ReportItem(name = "shitchoKashiRight", length = 1, order = 50)
    public RString shitchoKashiRight;
    @ReportItem(name = "shitchoKashiLeft", length = 1, order = 51)
    public RString shitchoKashiLeft;
    @ReportItem(name = "shitchoTaikanRight", length = 1, order = 52)
    public RString shitchoTaikanRight;
    @ReportItem(name = "shitchoTaikanLeft", length = 1, order = 53)
    public RString shitchoTaikanLeft;
    @ReportItem(name = "jokusoUmu", length = 1, order = 54)
    public RString jokusoUmu;
    @ReportItem(name = "jokusoBui", length = 10, order = 55)
    public RString jokusoBui;
    @ReportItem(name = "jokusoKei", length = 1, order = 56)
    public RString jokusoKei;
    @ReportItem(name = "jokusoChu", length = 1, order = 57)
    public RString jokusoChu;
    @ReportItem(name = "jokusoJu", length = 1, order = 58)
    public RString jokusoJu;
    @ReportItem(name = "sonotaHifuUmu", length = 1, order = 59)
    public RString sonotaHifuUmu;
    @ReportItem(name = "sonotaHifuBui", length = 10, order = 60)
    public RString sonotaHifuBui;
    @ReportItem(name = "sonotaHifuKei", length = 1, order = 61)
    public RString sonotaHifuKei;
    @ReportItem(name = "sonotaHifuChu", length = 1, order = 62)
    public RString sonotaHifuChu;
    @ReportItem(name = "sonotaHifuJu", length = 1, order = 63)
    public RString sonotaHifuJu;
    @ReportItem(name = "okugaihokoJiritsu", length = 1, order = 64)
    public RString okugaihokoJiritsu;
    @ReportItem(name = "okugaihokoKaijo", length = 1, order = 65)
    public RString okugaihokoKaijo;
    @ReportItem(name = "okugaihokoNashi", length = 1, order = 66)
    public RString okugaihokoNashi;
    @ReportItem(name = "kurumaisuFushiyo", length = 1, order = 67)
    public RString kurumaisuFushiyo;
    @ReportItem(name = "kurumaisuJiso", length = 1, order = 68)
    public RString kurumaisuJiso;
    @ReportItem(name = "kurumaisuTaso", length = 1, order = 69)
    public RString kurumaisuTaso;
    @ReportItem(name = "hokohojoFushiyo", length = 1, order = 70)
    public RString hokohojoFushiyo;
    @ReportItem(name = "hokohojoOkugai", length = 1, order = 71)
    public RString hokohojoOkugai;
    @ReportItem(name = "hokohojoOkunai", length = 1, order = 72)
    public RString hokohojoOkunai;
    @ReportItem(name = "shokujikoiJiritsu", length = 1, order = 73)
    public RString shokujikoiJiritsu;
    @ReportItem(name = "shokujikoiKaijo", length = 1, order = 74)
    public RString shokujikoiKaijo;
    @ReportItem(name = "eiyojotaiRyo", length = 1, order = 75)
    public RString eiyojotaiRyo;
    @ReportItem(name = "eiyojotaiFuryo", length = 1, order = 76)
    public RString eiyojotaiFuryo;
    @ReportItem(name = "eiyoryuiten", length = 30, order = 77)
    public RString eiyoryuiten;
    @ReportItem(name = "genjoNyoshikkin", length = 1, order = 78)
    public RString genjoNyoshikkin;
    @ReportItem(name = "genjoTento", length = 1, order = 79)
    public RString genjoTento;
    @ReportItem(name = "genjoIdoteika", length = 1, order = 80)
    public RString genjoIdoteika;
    @ReportItem(name = "genjoJokuso", length = 1, order = 81)
    public RString genjoJokuso;
    @ReportItem(name = "genjoShimpaiteika", length = 1, order = 82)
    public RString genjoShimpaiteika;
    @ReportItem(name = "genjoTojikomori", length = 1, order = 83)
    public RString genjoTojikomori;
    @ReportItem(name = "genjoIyokuteika", length = 1, order = 84)
    public RString genjoIyokuteika;
    @ReportItem(name = "genjoHaikai", length = 1, order = 85)
    public RString genjoHaikai;
    @ReportItem(name = "genjoTeieiyo", length = 1, order = 86)
    public RString genjoTeieiyo;
    @ReportItem(name = "genjoSesshokuteika", length = 1, order = 87)
    public RString genjoSesshokuteika;
    @ReportItem(name = "genjoDassui", length = 1, order = 88)
    public RString genjoDassui;
    @ReportItem(name = "genjoIkansen", length = 1, order = 89)
    public RString genjoIkansen;
    @ReportItem(name = "genjoTontsu", length = 1, order = 90)
    public RString genjoTontsu;
    @ReportItem(name = "genjoSonota", length = 1, order = 91)
    public RString genjoSonota;
    @ReportItem(name = "genjoSonotaName", length = 15, order = 92)
    public RString genjoSonotaName;
    @ReportItem(name = "genjoTaisho", length = 58, order = 93)
    public RString genjoTaisho;
    @ReportItem(name = "seikatsuijiDekiru", length = 1, order = 94)
    public RString seikatsuijiDekiru;
    @ReportItem(name = "seikatsuijiDekinai", length = 1, order = 95)
    public RString seikatsuijiDekinai;
    @ReportItem(name = "seikatsuijiFumei", length = 1, order = 96)
    public RString seikatsuijiFumei;
    @ReportItem(name = "igakukanriShinryo", length = 1, order = 97)
    public RString igakukanriShinryo;
    @ReportItem(name = "igakukanriKango", length = 1, order = 98)
    public RString igakukanriKango;
    @ReportItem(name = "igakukanriShien", length = 1, order = 99)
    public RString igakukanriShien;
    @ReportItem(name = "igakukanriShika", length = 1, order = 100)
    public RString igakukanriShika;
    @ReportItem(name = "igakulineShinryo", length = 10, order = 101)
    public RString igakulineShinryo;
    @ReportItem(name = "igakulineKango", length = 10, order = 102)
    public RString igakulineKango;
    @ReportItem(name = "igakulineShien", length = 40, order = 103)
    public RString igakulineShien;
    @ReportItem(name = "igakulineShika", length = 12, order = 104)
    public RString igakulineShika;
    @ReportItem(name = "igakukanriYakuzai", length = 1, order = 105)
    public RString igakukanriYakuzai;
    @ReportItem(name = "igakukanriHomonriha", length = 1, order = 106)
    public RString igakukanriHomonriha;
    @ReportItem(name = "igakukanriNyusho", length = 1, order = 107)
    public RString igakukanriNyusho;
    @ReportItem(name = "igakukanriShikaeisei", length = 1, order = 108)
    public RString igakukanriShikaeisei;
    @ReportItem(name = "igakulineYakuzai", length = 30, order = 109)
    public RString igakulineYakuzai;
    @ReportItem(name = "igakulineHomonriha", length = 30, order = 110)
    public RString igakulineHomonriha;
    @ReportItem(name = "igakulineNyusho", length = 15, order = 111)
    public RString igakulineNyusho;
    @ReportItem(name = "igakulineShikaeisei", length = 30, order = 112)
    public RString igakulineShikaeisei;
    @ReportItem(name = "igakukanriEiyo", length = 1, order = 113)
    public RString igakukanriEiyo;
    @ReportItem(name = "igakukanriTsushoriha", length = 1, order = 114)
    public RString igakukanriTsushoriha;
    @ReportItem(name = "igakukanriSonota", length = 1, order = 115)
    public RString igakukanriSonota;
    @ReportItem(name = "igakukanriSonotaName", length = 15, order = 116)
    public RString igakukanriSonotaName;
    @ReportItem(name = "igakulineEiyo", length = 30, order = 117)
    public RString igakulineEiyo;
    @ReportItem(name = "igakulineTsushoriha", length = 30, order = 118)
    public RString igakulineTsushoriha;
    @ReportItem(name = "igakulineSonota", length = 40, order = 119)
    public RString igakulineSonota;
    @ReportItem(name = "ryuiKetsuatsuNashi", length = 1, order = 120)
    public RString ryuiKetsuatsuNashi;
    @ReportItem(name = "ryuiKetsuatsuAri", length = 1, order = 121)
    public RString ryuiKetsuatsuAri;
    @ReportItem(name = "ryuijikoKetsuatsu", length = 30, order = 122)
    public RString ryuijikoKetsuatsu;
    @ReportItem(name = "ryuiIdoNashi", length = 1, order = 123)
    public RString ryuiIdoNashi;
    @ReportItem(name = "ryuiIdoAri", length = 1, order = 124)
    public RString ryuiIdoAri;
    @ReportItem(name = "ryuijikoIdo", length = 30, order = 125)
    public RString ryuijikoIdo;
    @ReportItem(name = "ryuiSesshokuNashi", length = 1, order = 126)
    public RString ryuiSesshokuNashi;
    @ReportItem(name = "ryuiSesshokuAri", length = 1, order = 127)
    public RString ryuiSesshokuAri;
    @ReportItem(name = "ryuijikoSesshoku", length = 30, order = 128)
    public RString ryuijikoSesshoku;
    @ReportItem(name = "ryuiUndoNashi", length = 1, order = 129)
    public RString ryuiUndoNashi;
    @ReportItem(name = "ryuiUndoAri", length = 1, order = 130)
    public RString ryuiUndoAri;
    @ReportItem(name = "ryuijikoUndo", length = 30, order = 131)
    public RString ryuijikoUndo;
    @ReportItem(name = "ryuiEngeNashi", length = 1, order = 132)
    public RString ryuiEngeNashi;
    @ReportItem(name = "ryuiEngeAri", length = 1, order = 133)
    public RString ryuiEngeAri;
    @ReportItem(name = "ryuijikoEnge", length = 30, order = 134)
    public RString ryuijikoEnge;
    @ReportItem(name = "ryuijikoSonota", length = 50, order = 135)
    public RString ryuijikoSonota;
    @ReportItem(name = "kansenshoNashi", length = 1, order = 136)
    public RString kansenshoNashi;
    @ReportItem(name = "kansenshoAri", length = 1, order = 137)
    public RString kansenshoAri;
    @ReportItem(name = "kansenshoFumei", length = 1, order = 138)
    public RString kansenshoFumei;
    @ReportItem(name = "kansenshoName", length = 30, order = 139)
    public RString kansenshoName;
    @ReportItem(name = "sonoTatokki", length = 700, order = 140)
    public RString sonoTatokki;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
