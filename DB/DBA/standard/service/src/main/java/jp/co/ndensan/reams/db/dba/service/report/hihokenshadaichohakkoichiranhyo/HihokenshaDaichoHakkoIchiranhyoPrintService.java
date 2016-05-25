package jp.co.ndensan.reams.db.dba.service.report.hihokenshadaichohakkoichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoJoho;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoProerty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 被保険者台帳一覧表Printクラスです。
 *
 * @reamsid_L DBA-0510-070 wangxiaodong
 */
public class HihokenshaDaichoHakkoIchiranhyoPrintService {

    /**
     * 被保険者台帳一覧表をPrintします。
     *
     * @param item 被保険者台帳一覧表item
     * @return 被保険者台帳一覧表_帳票
     */
    public SourceDataCollection print(HihokenshaDaichoHakkoIchiranhyoJoho item) {
        HihokenshaDaichoHakkoIchiranhyoProerty property = new HihokenshaDaichoHakkoIchiranhyoProerty();
        return new Printer<HihokenshaDaichoHakkoIchiranhyoReportSource>().spool(property, toReports(item));
    }

    private static List<HihokenshaDaichoHakkoIchiranhyoReport> toReports(HihokenshaDaichoHakkoIchiranhyoJoho item) {
        List<HihokenshaDaichoHakkoIchiranhyoReport> list = new ArrayList<>();
        list.add(HihokenshaDaichoHakkoIchiranhyoReport.createReport(item.getHeaderItem(), item.getBodyItemList()));
        return list;
    }

}
