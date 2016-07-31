package jp.co.ndensan.reams.db.dbd.entity.report.dbd100017;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 訪問介護等利用者負担額減額認定証のReportSource
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public class HomKaigRiysFutgGengNinteishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kofuGengo", length = 2, order = 1)
    public RString kofuGengo;
    @ReportItem(name = "kofuYYYY", length = 2, order = 2)
    public RString kofuYYYY;
    @ReportItem(name = "kofuMM", length = 2, order = 3)
    public RString kofuMM;
    @ReportItem(name = "kofuDD", length = 2, order = 4)
    public RString kofuDD;
    @ReportItem(name = "futanNo1", length = 1, order = 5)
    public RString futanNo1;
    @ReportItem(name = "futanNo2", length = 1, order = 6)
    public RString futanNo2;
    @ReportItem(name = "futanNo3", length = 1, order = 7)
    public RString futanNo3;
    @ReportItem(name = "futanNo4", length = 1, order = 8)
    public RString futanNo4;
    @ReportItem(name = "futanNo5", length = 1, order = 9)
    public RString futanNo5;
    @ReportItem(name = "futanNo6", length = 1, order = 10)
    public RString futanNo6;
    @ReportItem(name = "futanNo7", length = 1, order = 11)
    public RString futanNo7;
    @ReportItem(name = "futanNo8", length = 1, order = 12)
    public RString futanNo8;
    @ReportItem(name = "jukyuNo1", length = 1, order = 13)
    public RString jukyuNo1;
    @ReportItem(name = "jukyuNo2", length = 1, order = 14)
    public RString jukyuNo2;
    @ReportItem(name = "jukyuNo3", length = 1, order = 15)
    public RString jukyuNo3;
    @ReportItem(name = "jukyuNo4", length = 1, order = 16)
    public RString jukyuNo4;
    @ReportItem(name = "jukyuNo5", length = 1, order = 17)
    public RString jukyuNo5;
    @ReportItem(name = "jukyuNo6", length = 1, order = 18)
    public RString jukyuNo6;
    @ReportItem(name = "jukyuNo7", length = 1, order = 19)
    public RString jukyuNo7;
    @ReportItem(name = "jusho", order = 20)
    public RString jusho;
    @ReportItem(name = "hihokenshaNameKana", length = 34, order = 21)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaName", order = 22)
    public RString hihokenshaName;
    @ReportItem(name = "birthGengoMeiji", length = 1, order = 23)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 1, order = 24)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 1, order = 25)
    public RString birthGengoShowa;
    @ReportItem(name = "man", length = 1, order = 26)
    public RString man;
    @ReportItem(name = "woman", length = 1, order = 27)
    public RString woman;
    @ReportItem(name = "birthYYYY", length = 4, order = 28)
    public RString birthYYYY;
    @ReportItem(name = "birthMM", length = 2, order = 29)
    public RString birthMM;
    @ReportItem(name = "birthDD", length = 2, order = 30)
    public RString birthDD;
    @ReportItem(name = "tekiyoGengo", length = 2, order = 32)
    public RString tekiyoGengo;
    @ReportItem(name = "tekiyoYYYY", length = 2, order = 33)
    public RString tekiyoYYYY;
    @ReportItem(name = "tekiyoMM", length = 2, order = 34)
    public RString tekiyoMM;
    @ReportItem(name = "tekiyoDD", length = 2, order = 35)
    public RString tekiyoDD;
    @ReportItem(name = "yukoGengo", length = 2, order = 36)
    public RString yukoGengo;
    @ReportItem(name = "yukoYYYY", length = 2, order = 37)
    public RString yukoYYYY;
    @ReportItem(name = "yukoMM", length = 2, order = 38)
    public RString yukoMM;
    @ReportItem(name = "yukoDD", length = 2, order = 39)
    public RString yukoDD;
    @ReportItem(name = "kyufuRitsu", length = 26, order = 40)
    public RString kyufuRitsu;
    @ReportItem(name = "hokenshaJusho", order = 41)
    public RString hokenshaJusho;
    @ReportItem(name = "hokenshaName1", length = 13, order = 42)
    public RString hokenshaName1;
    @ReportItem(name = "hokenshaName2", length = 15, order = 43)
    public RString hokenshaName2;
    @ReportItem(name = "hokenshaName3", length = 16, order = 44)
    public RString hokenshaName3;
    @ReportItem(name = "hokenshaName4", length = 18, order = 45)
    public RString hokenshaName4;
    @ReportItem(name = "hokenshaName5", length = 20, order = 46)
    public RString hokenshaName5;
    @ReportItem(name = "hokenshaTelNo", length = 20, order = 47)
    public RString hokenshaTelNo;
    @ReportItem(name = "denshiKoin", order = 48)
    public RString denshiKoin;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "001")
    public RString shikibetsuCode;
    @ReportExpandedInfo(id = "001", code = "003", name = "被保険者番号")
    @ReportItem(name = "hihokenshaNo", length = 10, order = 31)
    public RString hihokenshaNo;
// </editor-fold>
}
