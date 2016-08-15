/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jukyushakoshinkekka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 *
 * 受給者情報更新結果情報取込一覧表 帳票PrintService
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public class JukyushaKoshinKekkaInPrintService {

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 帳票出力対象データリスト List<JukyushaHihokenshaEntity>
     * @param 住所List List<RString>
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaitsu(List<JukyushaHihokenshaEntity> 帳票出力対象データリスト, List<RString> 住所List,
            IOutputOrder 出力順情報, FlexibleYearMonth 処理年月, RDateTime 作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(帳票出力対象データリスト, 住所List, 出力順情報, 処理年月, 作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 本算定異動（過年度）結果一覧表 printメソッド(複数帳票出力用)
     *
     * @param 帳票出力対象データリスト List<JukyushaHihokenshaEntity>
     * @param 住所List List<RString>
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param reportManager ReportManager
     */
    public void printFukusu(List<JukyushaHihokenshaEntity> 帳票出力対象データリスト, List<RString> 住所List,
            IOutputOrder 出力順情報, FlexibleYearMonth 処理年月, RDateTime 作成日時, ReportManager reportManager) {
        JukyushaKoshinKekkaIchiranProperty property = new JukyushaKoshinKekkaIchiranProperty(出力順情報);
        try (ReportAssembler<JukyushaKoshinKekkaIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<JukyushaKoshinKekkaIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
            int i = 0;
            Map<RString, RString> 出力順Map = new HashMap<>();
            List<RString> 改頁リスト = new ArrayList<>();
            if (出力順情報 != null) {
                for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
                    if (item.is改頁項目()) {
                        改頁リスト.add(item.get項目名());
                    }
                    if (i == INDEX_1) {
                        出力順Map.put(KEY_並び順の２件目, item.get項目名());
                    } else if (i == INDEX_2) {
                        出力順Map.put(KEY_並び順の３件目, item.get項目名());
                    } else if (i == INDEX_3) {
                        出力順Map.put(KEY_並び順の４件目, item.get項目名());
                    } else if (i == INDEX_4) {
                        出力順Map.put(KEY_並び順の５件目, item.get項目名());
                    } else if (i == INDEX_5) {
                        出力順Map.put(KEY_並び順の６件目, item.get項目名());
                    }
                    i = i + 1;
                }
            }
            new JukyushaKoshinKekkaIchiranReport(帳票出力対象データリスト, 住所List,
                    出力順Map, 改頁リスト, 作成日時).writeBy(reportSourceWriter);
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
