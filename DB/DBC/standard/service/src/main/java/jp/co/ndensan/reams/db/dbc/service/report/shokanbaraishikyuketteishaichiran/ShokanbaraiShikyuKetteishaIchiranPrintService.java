/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shokanbaraishikyuketteishaichiran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyukettei.ShokanbaraiShikyuKetteishaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyukettei.ShokanbaraiShikyuKetteishaIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuKetteiChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyuketteishaichiran.ShokanbaraiShikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor.ChohyoJushoEditor;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 償還払支給決定者一覧表帳票のPrintServiceです。
 *
 * @reamsid_L DBC-0980-480 sunhui
 */
public class ShokanbaraiShikyuKetteishaIchiranPrintService {

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

    private static final RString 帳票分類ID = new RString("DBC200021_ShokanbaraiShikyuKetteishaIchiran");

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 帳票出力対象データリスト List<ShokanShikyuKetteiChohyoEntity>
     * @param 出力順情報 IOutputOrder
     * @param 作成日時 RDateTime
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaitsu(List<ShokanShikyuKetteiChohyoEntity> 帳票出力対象データリスト,
            IOutputOrder 出力順情報, RDateTime 作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(帳票出力対象データリスト, 出力順情報, 作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 本算定異動（過年度）結果一覧表 printメソッド(複数帳票出力用)
     *
     * @param 帳票出力対象データリスト List<ShokanShikyuKetteiChohyoEntity>
     * @param 出力順情報 IOutputOrder
     * @param 作成日時 RDateTime
     * @param reportManager ReportManager
     */
    public void printFukusu(List<ShokanShikyuKetteiChohyoEntity> 帳票出力対象データリスト,
            IOutputOrder 出力順情報, RDateTime 作成日時, ReportManager reportManager) {
        ChohyoJushoEditor 住所Editor = new ChohyoJushoEditor(SubGyomuCode.DBC介護給付, 帳票分類ID, GyomuBunrui.介護事務);
        ShokanbaraiShikyuKetteishaIchiranProperty property
                = new ShokanbaraiShikyuKetteishaIchiranProperty(出力順情報);
        try (ReportAssembler<ShokanbaraiShikyuKetteishaIchiranSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<ShokanbaraiShikyuKetteishaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
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
            List<RString> 住所List = new ArrayList<>();
            for (ShokanShikyuKetteiChohyoEntity 帳票出力対象データ : 帳票出力対象データリスト) {
                RString 管内管外区分 = 帳票出力対象データ.get被保険者().get管内管外区分();
                RString 住所 = 帳票出力対象データ.get被保険者().get住所();
                RString 番地 = 帳票出力対象データ.get被保険者().get番地();
                RString 方書 = 帳票出力対象データ.get被保険者().get方書();
                RString 行政区名 = 帳票出力対象データ.get被保険者().get行政区名();
                LasdecCode 市町村コード = 帳票出力対象データ.get被保険者().get市町村コード();
                RString 編集住所 = 住所Editor.editJusho(管内管外区分, 住所, 番地, 方書, 行政区名, 市町村コード);
                住所List.add(編集住所);
            }
            new ShokanbaraiShikyuKetteishaIchiranReport(帳票出力対象データリスト, 住所List,
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
