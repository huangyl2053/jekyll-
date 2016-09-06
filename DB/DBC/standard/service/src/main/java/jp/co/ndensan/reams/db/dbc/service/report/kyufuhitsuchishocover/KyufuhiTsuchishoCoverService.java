/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyufuhitsuchishocover;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishocover.KyufuhiTsuchishoCoverProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishocover.KyufuhiTsuchishoCoverReport;
import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishocover.KyufuhiTsuchishoCoverEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishocover.KyufuhiTsuchishoCoverReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票設計_DBC100041_介護保険給付費通知書クラスです。
 *
 * @reamsid_L DBC-2280-040 lizhuoxuan
 */
public class KyufuhiTsuchishoCoverService {

    /**
     * 介護保険給付費通知書Printします。
     *
     * @param detailEntity KyufuhiTsuchishoCoverEntity
     * @return 介護保険給付費通知書_帳票
     */
    public SourceDataCollection print(List<KyufuhiTsuchishoCoverEntity> detailEntity) {
        KyufuhiTsuchishoCoverProperty property = new KyufuhiTsuchishoCoverProperty();
        return new Printer<KyufuhiTsuchishoCoverReportSource>().spool(property, toReports(detailEntity));
    }

    private static List<KyufuhiTsuchishoCoverReport> toReports(List<KyufuhiTsuchishoCoverEntity> entityList) {
        List<KyufuhiTsuchishoCoverReport> list = new ArrayList<>();
        list.add(new KyufuhiTsuchishoCoverReport(entityList));
        return list;

    }
}
