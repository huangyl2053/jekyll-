/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.ijikofutangakushomeishoservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009Property;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009Report;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFromData;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009ReportSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 自己負担証明書一覧2009Printerです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
public class IJikoFutangakushomeisho2009Service {

    private final ReportManager reportManager;
    private static final RString コード = new RString("0001");

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public IJikoFutangakushomeisho2009Service(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 自己負担証明書を印刷します。
     *
     * @param joho 自己負担証明書_帳票クラスパラメータクラス
     */
    public void print(List<JikoFutangakushomeishoFromData> joho) {
        JikoFutangakushomeishoFrom2009Property property = new JikoFutangakushomeishoFrom2009Property();
        try (ReportAssembler<JikoFutangakushomeishoFrom2009ReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<JikoFutangakushomeishoFrom2009ReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100051.getReportId(),
                    FlexibleDate.getNowDate(), コード, KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            for (JikoFutangakushomeishoFromData items : joho) {
                items.set認証者情報(ninshoshaSource);
                JikoFutangakushomeishoFrom2009Report report = new JikoFutangakushomeishoFrom2009Report(items);
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
