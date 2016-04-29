package jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 受給資格証明書のReportSource
 *
 * @reamsid_L DBU-0490-090 suguangjun
 */
public class JukyuShikakuShomeishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaNo1", length = 1, order = 1)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 2)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 3)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 4)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 5)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 6)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 7)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 8)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 9)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 10)
    public RString hihokenshaNo10;
    @ReportItem(name = "hihokenshaNameKana", order = 11)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaName", order = 12)
    public RString hihokenshaName;
    @ReportItem(name = "birthGengoMeiji", length = 1, order = 13)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 1, order = 14)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 1, order = 15)
    public RString birthGengoShowa;
    @ReportItem(name = "birthYMD", length = 11, order = 16)
    public RString birthYMD;
    @ReportItem(name = "seibetsuMan", length = 1, order = 17)
    public RString seibetsuMan;
    @ReportItem(name = "seibetsuWoman", length = 1, order = 18)
    public RString seibetsuWoman;
    @ReportItem(name = "hihokenshaJusho", order = 19)
    public RString hihokenshaJusho;
    @ReportItem(name = "tenshutsusakiYoteiJusho", order = 20)
    public RString tenshutsusakiYoteiJusho;
    @ReportItem(name = "idoYoteiYMD", length = 11, order = 21)
    public RString idoYoteiYMD;
    @ReportItem(name = "hokenshaNo1", length = 1, order = 22)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 1, order = 23)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 1, order = 24)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 1, order = 25)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 1, order = 26)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 1, order = 27)
    public RString hokenshaNo6;
    @ReportItem(name = "ninteizumi", length = 3, order = 28)
    public RString ninteizumi;
    @ReportItem(name = "shinseichu", length = 3, order = 29)
    public RString shinseichu;
    @ReportItem(name = "shinseiYMD", length = 11, order = 30)
    public RString shinseiYMD;
    @ReportItem(name = "ninteiYMD", length = 11, order = 31)
    public RString ninteiYMD;
    @ReportItem(name = "yokaigoKubun", length = 7, order = 32)
    public RString yokaigoKubun;
    @ReportItem(name = "yukoKaishiYMD", length = 11, order = 33)
    public RString yukoKaishiYMD;
    @ReportItem(name = "yukoShuryoYMD", length = 11, order = 34)
    public RString yukoShuryoYMD;
    @ReportItem(name = "shinsakaiIken", order = 35)
    public RString shinsakaiIken;
    @ReportItem(name = "biko", order = 36)
    public RString biko;
    @ReportItem(name = "remban", length = 4, order = 37)
    public RString remban;
    @ReportItem(name = "denshiKoin", order = 38)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 39)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 40)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 41)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 42)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 43)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 44)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 45)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 46)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
