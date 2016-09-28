/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.gassanhoseizumijikofutangakusofuchiran;

import jp.co.ndensan.reams.db.dbc.business.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassan.SyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * 帳票設計_DBC200032_高額合算補正済自己負担額情報送付一覧表 PrintServiceクラスです。
 *
 * @reamsid_L DBC-2660-040 lijian
 */
public class GassanHoseizumiJikofutangakuSofuchiranPrintService {

    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");

    /**
     * 帳票設計_DBC200032_高額合算補正済自己負担額情報送付一覧表 (単一帳票出力用)
     *
     * @param 送付一覧表データ SyuturyokuEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     * @param 帳票ID ReportId
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            SyuturyokuEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 連番,
            ReportId 帳票ID) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(送付一覧表データ, 出力順情報, 処理年月, 作成日時, 連番, 帳票ID, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC200032_高額合算補正済自己負担額情報送付一覧表 (複数帳票出力用)。
     *
     * @param 送付一覧表データ SyuturyokuResult
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     * @param 帳票ID ReportId
     * @param reportManager ReportManager
     */
    public void print(
            SyuturyokuEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 連番,
            ReportId 帳票ID,
            ReportManager reportManager) {
        GassanHoseizumiJikofutangakuSofuchiranProperty property = new GassanHoseizumiJikofutangakuSofuchiranProperty();

        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();

        ChohyoSeigyoHanyo hanyoResult = manager
                .get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票ID, 管理年度, ChohyoSeigyoHanyoKomokuMei.帳票タイトル.get名称());
        RString 設定値;
        if (hanyoResult != null) {
            設定値 = hanyoResult.get設定値();
        } else {
            設定値 = RString.EMPTY;
        }
        try (ReportAssembler<GassanHoseizumiJikofutangakuSofuchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<GassanHoseizumiJikofutangakuSofuchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
            new GassanHoseizumiJikofutangakuSofuchiranReport(送付一覧表データ, 出力順情報, 処理年月, 作成日時, 連番, 設定値).writeBy(reportSourceWriter);
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
