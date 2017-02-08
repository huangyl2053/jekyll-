/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosajohohyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52.NinteiChosaJohohyo99AProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52.NinteiChosaJohohyo52EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52.NinteiChosaJohohyo52Report;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo52ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 認定調査票情報_99AのPrinterクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteiChosaJohohyo99APrintService implements INinteiChosaJohohyoPrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager
     */
    public NinteiChosaJohohyo99APrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @Override
    public void print(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            RString 特記事項マスキング区分,
            RString 主治医意見書マスキング区分) {
        try (ReportAssembler<NinteiChosaJohohyo52ReportSource> assembler = createAssembler(new NinteiChosaJohohyo99AProperty(), reportManager)) {
            ReportSourceWriter<NinteiChosaJohohyo52ReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinteiChosaJohohyo52Report report = new NinteiChosaJohohyo52Report(NinteiChosaJohohyo52EntityEditor.edit(business.toEntity(),
                    認定調査票サービス状況List, 認定調査票サービス状況フラグList, 認定調査票調査項目List, 認定調査票記入項目List,
                    イメージ共有ファイルID, 認定調査票マスキング区分, 主治医意見書マスキング区分));
            report.writeBy(reportSourceWriter);
        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
