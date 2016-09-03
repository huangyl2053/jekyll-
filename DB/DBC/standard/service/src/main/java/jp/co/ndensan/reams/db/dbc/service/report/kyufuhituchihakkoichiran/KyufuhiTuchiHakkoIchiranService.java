/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyufuhituchihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票設計_DBC200044_給付費通知発行一覧表クラスです。
 *
 * @reamsid_L DBC-2280-080 lizhuoxuan
 */
public class KyufuhiTuchiHakkoIchiranService {

    /**
     * 給付費通知発行一覧表Printします。
     *
     * @param detailEntity KyufuhiTuchiHakkoIchiranEntity
     * @return 給付費通知発行一覧表_帳票
     */
    public SourceDataCollection print(List<KyufuhiTuchiHakkoIchiranEntity> detailEntity) {
        KyufuhiTuchiHakkoIchiranProperty property = new KyufuhiTuchiHakkoIchiranProperty();
        return new Printer<KyufuhiTuchiHakkoIchiranReportSource>().spool(property, toReports(detailEntity));
    }

    private static List<KyufuhiTuchiHakkoIchiranReport> toReports(List<KyufuhiTuchiHakkoIchiranEntity> entityList) {
        List<KyufuhiTuchiHakkoIchiranReport> list = new ArrayList<>();
        list.add(new KyufuhiTuchiHakkoIchiranReport(entityList));
        return list;

    }
}
