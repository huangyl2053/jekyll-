/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.gassanjikofutangakukeisankekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * 帳票設計_DBCMN62006_高額合算自己負担額計算結果一覧表PrintServiceクラスです。
 *
 * @reamsid_L DBC-2060-040 surun
 */
public class GassanJikofutangakuKeisanKekkaIchiranPrintService {

    /**
     * 高額合算自己負担額計算結果一覧表(単一帳票出力用)
     *
     * @param 高額合算自己負担額計算結果一覧表list List<GassanJikofutangakuKeisanKekkaIchiranEntity>
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 作成日時 YMDHMS
     * @param 出力順1 RString
     * @param 出力順2 RString
     * @param 出力順3 RString
     * @param 出力順4 RString
     * @param 出力順5 RString
     * @param 改頁1 RString
     * @param 改頁2 RString
     * @param 改頁3 RString
     * @param 改頁4 RString
     * @param 改頁5 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printSinger(List<GassanJikofutangakuKeisanKekkaIchiranEntity> 高額合算自己負担額計算結果一覧表list,
            LasdecCode 市町村コード, RString 市町村名称, YMDHMS 作成日時,
            RString 出力順1, RString 出力順2, RString 出力順3, RString 出力順4, RString 出力順5,
            RString 改頁1, RString 改頁2, RString 改頁3, RString 改頁4, RString 改頁5) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(高額合算自己負担額計算結果一覧表list, 市町村コード, 市町村名称, 作成日時, 出力順1, 出力順2, 出力順3, 出力順4, 出力順5,
                    改頁1, 改頁2, 改頁3, 改頁4, 改頁5, reportManager);
            collection = reportManager.publish();
        }
        return collection;

    }

    /**
     * 高額合算自己負担額計算結果一覧表の printメソッド(複数帳票出力用)。
     *
     * @param 高額合算自己負担額計算結果一覧表list List<GassanJikofutangakuKeisanKekkaIchiranEntity>
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 作成日時 YMDHMS
     * @param 出力順1 RString
     * @param 出力順2 RString
     * @param 出力順3 RString
     * @param 出力順4 RString
     * @param 出力順5 RString
     * @param 改頁1 RString
     * @param 改頁2 RString
     * @param 改頁3 RString
     * @param 改頁4 RString
     * @param 改頁5 RString
     * @param reportManager ReportManager
     */
    public void print(List<GassanJikofutangakuKeisanKekkaIchiranEntity> 高額合算自己負担額計算結果一覧表list,
            LasdecCode 市町村コード, RString 市町村名称, YMDHMS 作成日時,
            RString 出力順1, RString 出力順2, RString 出力順3, RString 出力順4, RString 出力順5,
            RString 改頁1, RString 改頁2, RString 改頁3, RString 改頁4, RString 改頁5, ReportManager reportManager) {
        GassanJikofutangakuKeisanKekkaIchiranProperty property = new GassanJikofutangakuKeisanKekkaIchiranProperty(改頁1, 改頁2, 改頁3, 改頁4, 改頁5);
        try (ReportAssembler<GassanJikofutangakuKeisanKekkaIchiranSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<GassanJikofutangakuKeisanKekkaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            for (GassanJikofutangakuKeisanKekkaIchiranEntity 高額合算自己負担額計算結果一覧表 : 高額合算自己負担額計算結果一覧表list) {
                GassanJikofutangakuKeisanKekkaIchiranReport report = new GassanJikofutangakuKeisanKekkaIchiranReport(
                        高額合算自己負担額計算結果一覧表, 市町村コード, 市町村名称, 作成日時, 出力順1, 出力順2, 出力順3, 出力順4, 出力順5,
                        改頁1, 改頁2, 改頁3, 改頁4, 改頁5);
                report.writeBy(reportSourceWriter);
            }
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
