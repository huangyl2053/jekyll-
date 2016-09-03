/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyufuhitsuchishodetail;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailReport;
import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険給付費通知書(２ページ目以降)クラスです。
 *
 * @reamsid_L DBC-2280-050 lizhuoxuan
 */
public class KyufuhiTsuchishoDetailService {

    /**
     * 介護保険給付費通知書(２ページ目以降)Printします。
     *
     * @param detailEntity KyufuhiTsuchishoDetailEntity
     * @return 介護保険給付費通知書(２ページ目以降)_帳票
     */
    public SourceDataCollection print(List<KyufuhiTsuchishoDetailEntity> detailEntity) {
        KyufuhiTsuchishoDetailProperty property = new KyufuhiTsuchishoDetailProperty();
        return new Printer<KyufuhiTsuchishoDetailReportSource>().spool(property, toReports(detailEntity));
    }

    private static List<KyufuhiTsuchishoDetailReport> toReports(List<KyufuhiTsuchishoDetailEntity> entityList) {
        List<KyufuhiTsuchishoDetailReport> list = new ArrayList<>();
        list.add(new KyufuhiTsuchishoDetailReport(entityList));
        return list;

    }
}
