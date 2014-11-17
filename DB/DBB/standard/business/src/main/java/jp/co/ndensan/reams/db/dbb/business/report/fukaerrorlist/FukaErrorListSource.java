package jp.co.ndensan.reams.db.dbb.business.report.fukaerrorlist;

import jp.co.ndensan.reams.ur.urz.model.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class FukaErrorListSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "listMeisho", length = 40, order = 1)
    public RString listMeisho;
    @ReportItem(name = "batchShoriMeisho", length = 40, order = 2)
    public RString batchShoriMeisho;
    @ReportItem(name = "listSakuseiNichiji", length = 20, order = 3)
    public RString listSakuseiNichiji;
    @ReportItem(name = "batchKidoNichiji", length = 20, order = 4)
    public RString batchKidoNichiji;
    @ReportItem(name = "page", length = 5, order = 5)
    public RString page;
    @ReportItem(name = "listFukaNendo_1", length = 10, order = 6)
    public RString listFukaNendo_1;
    @ReportItem(name = "listTsuchishoNo_1", length = 15, order = 7)
    public RString listTsuchishoNo_1;
    @ReportItem(name = "listErrorNaiyo_1", length = 70, order = 8)
    public RString listErrorNaiyo_1;
    @ReportItem(name = "listHihoNo_1", length = 10, order = 9)
    public RString listHihoNo_1;
    @ReportItem(name = "listShikibetsuCode_1", length = 15, order = 10)
    public RString listShikibetsuCode_1;
    @ReportItem(name = "listNo_1", length = 3, order = 11)
    public RString listNo_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
