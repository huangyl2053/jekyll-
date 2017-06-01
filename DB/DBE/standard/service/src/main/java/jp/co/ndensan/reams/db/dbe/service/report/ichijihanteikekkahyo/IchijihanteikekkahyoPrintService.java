/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ichijihanteikekkahyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * 一次判定結果のPrinterクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class IchijihanteikekkahyoPrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public IchijihanteikekkahyoPrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 一次判定結果を印刷します。
     *
     * @param business YokaigoNinteiJohoTeikyoBusiness
     * @param 認定調査特記事項番号List 認定調査特記事項番号List
     * @param 認定調査票サービス状況List 認定調査票サービス状況List
     * @param 認定調査票サービス状況フラグList 認定調査票サービス状況フラグList
     * @param 認定調査票調査項目List 認定調査票調査項目List
     * @param 前回認定調査票調査項目List 前回認定調査票調査項目List
     * @param 主治医意見書意見項目List 主治医意見書意見項目List
     * @param 前回主治医意見書意見項目List 前回主治医意見書意見項目List
     * @param 一次判定結果マスキング区分 一次判定結果マスキング区分
     */
    public void print(YokaigoNinteiJohoTeikyoBusiness business,
            List<RString> 認定調査特記事項番号List,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoChosaItem> 前回認定調査票調査項目List,
            List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List,
            List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List,
            RString 一次判定結果マスキング区分) {
        RString 特記事項符号印刷有無
                = DbBusinessConfig.get(ConfigNameDBE.特記事項符号印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 正常選択肢印刷有無
                = DbBusinessConfig.get(ConfigNameDBE.今回基本調査項目結果の正常選択肢印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 前回との結果比較印刷有無
                = DbBusinessConfig.get(ConfigNameDBE.前回との結果比較印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 前回正常選択肢印刷有無
                = DbBusinessConfig.get(ConfigNameDBE.今回前回比較で変化有で前回正常選択肢表示印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        try (ReportAssembler<IchijihanteikekkahyoReportSource> assembler = createAssembler(new IchijihanteikekkahyoProperty(), reportManager)) {
            ReportSourceWriter<IchijihanteikekkahyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            IchijihanteikekkahyoReport report = new IchijihanteikekkahyoReport(IchijihanteikekkahyoEntityEditor.edit(business.toEntity(),
                    認定調査特記事項番号List, 認定調査票サービス状況List, 認定調査票サービス状況フラグList, 認定調査票調査項目List,
                    前回認定調査票調査項目List, 主治医意見書意見項目List, 前回主治医意見書意見項目List, 特記事項符号印刷有無, 正常選択肢印刷有無,
                    前回との結果比較印刷有無, 前回正常選択肢印刷有無, 一次判定結果マスキング区分));
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
