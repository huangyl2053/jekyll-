/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyufuhitsuchishofukushiyogutaiyohinmoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport;
import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）クラスです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuService {

    /**
     * 介護保険給付費通知書（福祉用具貸与品目）Printします。
     *
     * @param detailEntity KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity
     * @return 介護保険給付費通知書(２ページ目以降)_帳票
     */
    public SourceDataCollection print(List<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity> detailEntity) {
        KyufuhiTsuchishoFukushiYoguTaiyoHinmokuProperty property = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuProperty();
        return new Printer<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource>().spool(property, toReports(detailEntity));
    }

    private static List<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport> toReports(List<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity> entityList) {
        List<KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport> list = new ArrayList<>();
        list.add(new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReport(entityList));
        return list;

    }
}
