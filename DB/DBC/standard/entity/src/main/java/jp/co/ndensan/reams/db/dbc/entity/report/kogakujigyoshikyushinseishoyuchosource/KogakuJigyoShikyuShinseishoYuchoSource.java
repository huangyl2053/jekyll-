package jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshikyushinseishoyuchosource;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC100071_介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）のReportSourceクラスです。
 *
 * @reamsid_L DBC-4770-090 jianglaisheng
 */
public class KogakuJigyoShikyuShinseishoYuchoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "taishoYM", length = 8, order = 1)
    public RString taishoYM;
    @ReportItem(name = "hakkoubi", length = 11, order = 2)
    public RString hakkoubi;
    @ReportItem(name = "hihokenshaNameKana", order = 3)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 5)
    @ReportExpandedInfo(id = "X")
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 6)
    public RString hihokenshaNo;
    @ReportItem(name = "birthYMD", length = 11, order = 7)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 2, order = 8)
    public RString seibetsu;
    @ReportItem(name = "kojinNo", length = 12, order = 9)
    public RString kojinNo;
    @ReportItem(name = "hihokenJusho", order = 10)
    public RString hihokenJusho;
    @ReportItem(name = "telNo", length = 15, order = 11)
    public RString telNo;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 12)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "chuibun", order = 13)
    public RString chuibun;
    @ReportItem(name = "chuiTitle", length = 2, order = 14)
    public RString chuiTitle;
    @ReportItem(name = "tuchoKigo2", length = 1, order = 15)
    public RString tuchoKigo2;
    @ReportItem(name = "tuchoKigo3", length = 1, order = 16)
    public RString tuchoKigo3;
    @ReportItem(name = "tuchoKigo4", length = 1, order = 17)
    public RString tuchoKigo4;
    @ReportItem(name = "tuchoKigo5", length = 1, order = 18)
    public RString tuchoKigo5;
    @ReportItem(name = "tuchoNo1", length = 1, order = 19)
    public RString tuchoNo1;
    @ReportItem(name = "tuchoNo2", length = 1, order = 20)
    public RString tuchoNo2;
    @ReportItem(name = "tuchoNo3", length = 1, order = 21)
    public RString tuchoNo3;
    @ReportItem(name = "tuchoNo4", length = 1, order = 22)
    public RString tuchoNo4;
    @ReportItem(name = "tuchoNo5", length = 1, order = 23)
    public RString tuchoNo5;
    @ReportItem(name = "tuchoNo6", length = 1, order = 24)
    public RString tuchoNo6;
    @ReportItem(name = "tuchoNo7", length = 1, order = 25)
    public RString tuchoNo7;
    @ReportItem(name = "tuchoNo8", length = 1, order = 26)
    public RString tuchoNo8;
    @ReportItem(name = "tuchoKigo1", length = 1, order = 27)
    public RString tuchoKigo1;
    @ReportItem(name = "remban", length = 4, order = 28)
    public RString remban;
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
