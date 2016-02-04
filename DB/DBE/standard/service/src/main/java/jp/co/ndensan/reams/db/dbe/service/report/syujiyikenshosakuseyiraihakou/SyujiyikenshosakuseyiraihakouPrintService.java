/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.syujiyikenshosakuseyiraihakou;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouProperty;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouReport;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.syujiyikensho.IkenshoSakuseiIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医意見書作成依頼発行一覧表Printerです。
 */
public class SyujiyikenshosakuseyiraihakouPrintService {

    /**
     * 主治医意見書作成依頼発行一覧表を印刷します。
     *
     * @param ichiranReportJoho 主治医意見書作成依頼発行一覧表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(SyujiyikenshosakuseyiraihakouReportJoho ichiranReportJoho) {
        SyujiyikenshosakuseyiraihakouProperty property = new SyujiyikenshosakuseyiraihakouProperty();
        return new Printer<IkenshoSakuseiIraiHakkoIchiranhyoReportSource>().spool(property, toReports(ichiranReportJoho));
    }

    private static List<SyujiyikenshosakuseyiraihakouReport> toReports(SyujiyikenshosakuseyiraihakouReportJoho reportJoho) {
        List<SyujiyikenshosakuseyiraihakouReport> list = new ArrayList<>();
        list.add(SyujiyikenshosakuseyiraihakouReport.createFrom(
                reportJoho.getHeadItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
