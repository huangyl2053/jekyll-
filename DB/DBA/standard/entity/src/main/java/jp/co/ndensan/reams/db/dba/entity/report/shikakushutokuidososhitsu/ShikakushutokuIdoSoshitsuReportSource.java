package jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 
 * 介護保険資格取得・異動・喪失届の帳票ReportSourceクラスです。
 */
public class ShikakushutokuIdoSoshitsuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaJusho", order = 1)
    public RString hihokenshaJusho;
    @ReportItem(name = "setainushiName", order = 2)
    public RString setainushiName;
    @ReportItem(name = "hihokenKatakaki", order = 3)
    public RString hihokenKatakaki;
    @ReportItem(name = "zokugara1", order = 4)
    public RString zokugara1;
    @ReportItem(name = "hihokenshaNameKana1", order = 5)
    public RString hihokenshaNameKana1;
    @ReportItem(name = "seibetsu1", length = 1, order = 6)
    public RString seibetsu1;
    @ReportItem(name = "birthYMD1", length = 11, order = 7)
    public RString birthYMD1;
    @ReportItem(name = "hihokenshaNo1", length = 10, order = 8)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaName1", order = 9)
    public RString hihokenshaName1;
    @ReportItem(name = "zokugara2", order = 10)
    public RString zokugara2;
    @ReportItem(name = "hihokenshaNameKana2", order = 11)
    public RString hihokenshaNameKana2;
    @ReportItem(name = "seibetsu2", length = 1, order = 12)
    public RString seibetsu2;
    @ReportItem(name = "hihokenshaNo2", length = 10, order = 13)
    public RString hihokenshaNo2;
    @ReportItem(name = "birthYMD2", length = 11, order = 14)
    public RString birthYMD2;
    @ReportItem(name = "hihokenshaName2", order = 15)
    public RString hihokenshaName2;
    @ReportItem(name = "zokugara3", order = 16)
    public RString zokugara3;
    @ReportItem(name = "hihokenshaNameKana3", order = 17)
    public RString hihokenshaNameKana3;
    @ReportItem(name = "seibetsu3", length = 1, order = 18)
    public RString seibetsu3;
    @ReportItem(name = "birthYMD3", length = 11, order = 19)
    public RString birthYMD3;
    @ReportItem(name = "hihokenshaNo3", length = 10, order = 20)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaName3", order = 21)
    public RString hihokenshaName3;
    @ReportItem(name = "remban", length = 4, order = 22)
    public RString remban;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 23)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
