/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 償還払支給（不支給）決定通知一覧表覧表Printerです。
 */
public class ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranService {

    /**
     * 償還払支給（不支給）決定通知一覧表覧表を印刷します。
     *
     * @param item 償還払支給（不支給）決定通知一覧表覧表_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> item) {
        ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranProperty property = new ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranProperty();
        return new Printer<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReportSource>().spool(property, toReports(item));
    }

    private static List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport> toReports(List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> item) {
        List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport> list = new ArrayList<>();
        list.add(ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport.createFrom(item));
        return list;
    }
}
