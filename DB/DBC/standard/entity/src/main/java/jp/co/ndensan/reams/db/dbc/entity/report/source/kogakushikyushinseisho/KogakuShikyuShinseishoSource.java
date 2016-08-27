package jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 高額介護（予防）サービス費支給申請書のソースクラスです。
 *
 * @reamsid_L DBC-4770-060 jiangxiaolong
 */
public class KogakuShikyuShinseishoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "teikyoYM", length = 8, order = 1)
    public RString teikyoYM;
    @ReportItem(name = "hakkoubi", length = 11, order = 2)
    public RString hakkoubi;
    @ReportItem(name = "hihokenshaNameKana", order = 3)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 6)
    @ReportExpandedInfo(id = "X")
    public RString hihokenshaNo;
    @ReportItem(name = "seibetsu", length = 2, order = 7)
    public RString seibetsu;
    @ReportItem(name = "birthYMD", length = 11, order = 8)
    public RString birthYMD;
    @ReportItem(name = "kojinNo", length = 12, order = 9)
    public RString kojinNo;
    @ReportItem(name = "hihokenJusho", order = 10)
    public RString hihokenJusho;
    @ReportItem(name = "telNo", length = 15, order = 11)
    public RString telNo;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 12)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "chuiTitle", length = 2, order = 13)
    public RString chuiTitle;
    @ReportItem(name = "chuibun", order = 14)
    public RString chuibun;
    @ReportItem(name = "ginko", length = 4, order = 15)
    public RString ginko;
    @ReportItem(name = "honten", length = 3, order = 16)
    public RString honten;
    @ReportItem(name = "shinkin", length = 4, order = 17)
    public RString shinkin;
    @ReportItem(name = "shiten", length = 3, order = 18)
    public RString shiten;
    @ReportItem(name = "shinkumi", length = 4, order = 19)
    public RString shinkumi;
    @ReportItem(name = "shuccho", length = 3, order = 20)
    public RString shuccho;
    @ReportItem(name = "nokyo", length = 4, order = 21)
    public RString nokyo;
    @ReportItem(name = "shisho", length = 3, order = 22)
    public RString shisho;
    @ReportItem(name = "remban", length = 4, order = 23)
    public RString remban;
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * KogakuShikyuShinseishoSourceのENUM
     */
    public enum DBC100068SourceFields {

        teikyoYM,
        hakkoubi,
        hihokenshaNameKana,
        hokenshaNo,
        hihokenshaName,
        hihokenshaNo,
        seibetsu,
        birthYMD,
        kojinNo,
        hihokenJusho,
        telNo,
        ninshoshaYakushokuMei,
        chuiTitle,
        chuibun,
        ginko,
        honten,
        shinkin,
        shiten,
        shinkumi,
        shuccho,
        nokyo,
        shisho,
        remban
    }
}
