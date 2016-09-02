/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyufuhitsuchishosealer;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerReport;
import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishosealer.KyufuhiTsuchishoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票設計_DBC100042_介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)クラスです。
 *
 * @reamsid_L DBC-2280-070 lizhuoxuan
 */
public class KyufuhiTsuchishoSealerService {

    /**
     * 介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)Printします。
     *
     * @param detailEntity KyufuhiTsuchishoSealerEntity
     * @return 介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)_帳票
     */
    public SourceDataCollection print(List<KyufuhiTsuchishoSealerEntity> detailEntity) {
        KyufuhiTsuchishoSealerProperty property = new KyufuhiTsuchishoSealerProperty();
        return new Printer<KyufuhiTsuchishoSealerReportSource>().spool(property, toReports(detailEntity));
    }

    private static List<KyufuhiTsuchishoSealerReport> toReports(List<KyufuhiTsuchishoSealerEntity> entityList) {
        List<KyufuhiTsuchishoSealerReport> list = new ArrayList<>();
        list.add(new KyufuhiTsuchishoSealerReport(entityList));
        return list;

    }
}
