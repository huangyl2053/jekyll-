package jp.co.ndensan.reams.db.dbd.entity.report.dbd800001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険負担限度額認定申請書のReportSource
 *
 * @reamsid_L DBA-0540-690 suguangjun
 */
public class FutangendogakuNinteiShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "List1_1", length = 1, order = 1)
    public RString List1_1;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 25, order = 2)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "shiseibun", length = 100, order = 3)
    public RString shiseibun;
    @ReportItem(name = "city_cd", length = 6, order = 4)
    public RString city_cd;
    @ReportItem(name = "hihokenshaNameKana", order = 5)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 6)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 7)
    public RString hihokenshaName;
    @ReportItem(name = "seibetsu", length = 2, order = 8)
    public RString seibetsu;
    @ReportItem(name = "birthYMD", length = 32, order = 9)
    public RString birthYMD;
    @ReportItem(name = "hihokenshaYubinNo", length = 8, order = 10)
    public RString hihokenshaYubinNo;
    @ReportItem(name = "hihokenshaTelNo", length = 15, order = 11)
    public RString hihokenshaTelNo;
    @ReportItem(name = "hihokenshaJusho", order = 12)
    public RString hihokenshaJusho;
    @ReportItem(name = "sisetuYubinNo", length = 8, order = 13)
    public RString sisetuYubinNo;
    @ReportItem(name = "sisetuTelNo", length = 15, order = 14)
    public RString sisetuTelNo;
    @ReportItem(name = "sisetuJusho", order = 15)
    public RString sisetuJusho;
    @ReportItem(name = "sisetuName", order = 16)
    public RString sisetuName;
    @ReportItem(name = "chuibun", order = 17)
    public RString chuibun;
    @ReportItem(name = "PageCnt", length = 4, order = 18)
    public RString PageCnt;
    @ReportItem(name = "bun_1", length = 80, order = 19)
    public RString bun_1;
    @ReportItem(name = "bun_2", length = 80, order = 20)
    public RString bun_2;
    @ReportItem(name = "bun_3", length = 80, order = 21)
    public RString bun_3;
    @ReportItem(name = "bun_4", length = 80, order = 22)
    public RString bun_4;
    @ReportItem(name = "bun_5", length = 80, order = 23)
    public RString bun_5;
    @ReportItem(name = "bun_6", length = 80, order = 24)
    public RString bun_6;
    @ReportItem(name = "bun_7", length = 80, order = 25)
    public RString bun_7;
    @ReportItem(name = "bun_8", length = 80, order = 26)
    public RString bun_8;
    @ReportItem(name = "bun_9", length = 80, order = 27)
    public RString bun_9;
    @ReportItem(name = "bun_10", length = 80, order = 28)
    public RString bun_10;
    @ReportItem(name = "bun_11", length = 80, order = 29)
    public RString bun_11;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
