/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.dbd5910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranProperty;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranReport;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医医療機関・主治医一覧表Printerです。
 */
public class IkenshoShujiiIchiranPrintService {

    /**
     * 治医医療機関・主治医一覧表を印刷します。
     *
     * @param ichiranReportJoho 療機関・主治医一覧表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
   public SourceDataCollection print(IkenshoShujiiIchiranReportJoho ichiranReportJoho) {
        IkenshoShujiiIchiranProperty property = new IkenshoShujiiIchiranProperty();
        return new Printer<ShujiiIryokikanShujiiIchiranhyoReportSource>().spool(property, toReports(ichiranReportJoho));
    }

    /**
     * 主治医医療機関・主治医一覧表のReportを作成します。
     * @param targets 治医医療機関・主治医一覧表のITEM
     * @return 主治医医療機関・主治医一覧表のReport
     */
    private static List<IkenshoShujiiIchiranReport> toReports(IkenshoShujiiIchiranReportJoho targets) {
        List<IkenshoShujiiIchiranReport> list = new ArrayList<>();
        list.add(IkenshoShujiiIchiranReport.
                createFrom(targets.getHeadItem(),
                        targets.getBodyItemList()));
        return list;
    }
}
