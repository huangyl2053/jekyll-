package jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyokyotakuyobosogojigyo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 給付管理票のReportSourceクラスです。
 *
 * @reamsid_L DBC-2840-040 sunhaidi
 */
public class KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "koshinKbn", length = 4, order = 1)
    public RString koshinKbn;
    @ReportItem(name = "teishutsuYM", length = 8, order = 2)
    public RString teishutsuYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", order = 4)
    public RString hokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 5)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaKanaShimei", length = 40, order = 6)
    public RString hihokenshaKanaShimei;
    @ReportItem(name = "hihokenshaShimei", order = 7)
    public RString hihokenshaShimei;
    @ReportItem(name = "seinengappiGengoMeiji", length = 2, order = 8)
    public RString seinengappiGengoMeiji;
    @ReportItem(name = "seinengappiGengoTaisho", length = 2, order = 9)
    public RString seinengappiGengoTaisho;
    @ReportItem(name = "seinengappiGengoShowa", length = 2, order = 10)
    public RString seinengappiGengoShowa;
    @ReportItem(name = "seibetsu", length = 1, order = 11)
    public RString seibetsu;
    @ReportItem(name = "yokaigoJotaiKubun", length = 4, order = 12)
    public RString yokaigoJotaiKubun;
    @ReportItem(name = "seinengappiYY", length = 2, order = 13)
    public RString seinengappiYY;
    @ReportItem(name = "seinengappiMM", length = 2, order = 14)
    public RString seinengappiMM;
    @ReportItem(name = "seinengappiDD", length = 2, order = 15)
    public RString seinengappiDD;
    @ReportItem(name = "gendogakuTekiyoKikanStGengo", length = 2, order = 16)
    public RString gendogakuTekiyoKikanStGengo;
    @ReportItem(name = "gendogakuTekiyoKikanEdGengo", length = 2, order = 17)
    public RString gendogakuTekiyoKikanEdGengo;
    @ReportItem(name = "shikyuGendoKijunGaku", length = 7, order = 18)
    public RString shikyuGendoKijunGaku;
    @ReportItem(name = "gendogakuTekiyoKikanStMM", length = 2, order = 19)
    public RString gendogakuTekiyoKikanStMM;
    @ReportItem(name = "gendogakuTekiyoKikanEdYY", length = 2, order = 20)
    public RString gendogakuTekiyoKikanEdYY;
    @ReportItem(name = "gendogakuTekiyoKikanEdMM", length = 2, order = 21)
    public RString gendogakuTekiyoKikanEdMM;
    @ReportItem(name = "gendogakuTekiyoKikanStYY", length = 2, order = 22)
    public RString gendogakuTekiyoKikanStYY;
    @ReportItem(name = "listLower_1", length = 20, order = 23)
    public RString listLower_1;
    @ReportItem(name = "listUpper_1", length = 20, order = 24)
    public RString listUpper_1;
    @ReportItem(name = "listLower_2", length = 7, order = 25)
    public RString listLower_2;
    @ReportItem(name = "listUpper_2", length = 10, order = 26)
    public RString listUpper_2;
    @ReportItem(name = "listLower_3", length = 5, order = 27)
    public RString listLower_3;
    @ReportItem(name = "listUpper_3", length = 4, order = 28)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 7, order = 29)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 2, order = 30)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 3, order = 31)
    public RString listUpper_6;
    @ReportItem(name = "gokeiTanisuMainusKigo", length = 3, order = 32)
    public RString gokeiTanisuMainusKigo;
    @ReportItem(name = "gokeiTanisu", length = 5, order = 33)
    public RString gokeiTanisu;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;
// </editor-fold>
}
