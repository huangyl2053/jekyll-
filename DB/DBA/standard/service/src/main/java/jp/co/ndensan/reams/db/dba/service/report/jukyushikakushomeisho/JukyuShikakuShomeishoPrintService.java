/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.jukyushikakushomeisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoJoho;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeisho.JukyuShikakuShomeishoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 受給資格証明書Printerです。
 *
 * @reamsid_L DBU-0490-090 suguangjun
 */
public class JukyuShikakuShomeishoPrintService {

    /**
     * 受給資格証明書を印刷します。
     *
     * @param bodyItemList 受給資格証明書ヘッダのITEMリストです
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<JukyuShikakuShomeishoBodyItem> bodyItemList) {
        JukyuShikakuShomeishoProerty property = new JukyuShikakuShomeishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<JukyuShikakuShomeishoReportSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<JukyuShikakuShomeishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                        property.reportId(),
                        FlexibleDate.getNowDate(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし,
                        reportSourceWriter);
                for (JukyuShikakuShomeishoBodyItem bodyItem : bodyItemList) {
                    bodyItem = new JukyuShikakuShomeishoBodyItem(
                            bodyItem.getHihokenshaNo(),
                            bodyItem.getHihokenshaNameKana(),
                            bodyItem.getHihokenshaName(),
                            bodyItem.getBirthGengoMeiji(),
                            bodyItem.getBirthGengoTaisho(),
                            bodyItem.getBirthGengoShowa(),
                            bodyItem.getBirthYMD(),
                            bodyItem.getSeibetsu(),
                            bodyItem.getSusakiYoteiJusho(),
                            bodyItem.getTenshutsusakiYoteiJusho(),
                            bodyItem.getIdoYoteiYMD(),
                            bodyItem.getHokenshaNo(),
                            ninshoshaSource.hakkoYMD,
                            ninshoshaSource.ninshoshaYakushokuMei,
                            bodyItem.getRecognizedName(),
                            ninshoshaSource.denshiKoin,
                            ninshoshaSource.koinShoryaku,
                            bodyItem.getShichosonMei(),
                            bodyItem.getShinseichu(),
                            bodyItem.getShinseiYMD(),
                            bodyItem.getYokaigoKubun(),
                            bodyItem.getNinteiYMD(),
                            bodyItem.getYukoKaishiYMD(),
                            bodyItem.getYukoShuryoYMD(),
                            bodyItem.getShinsakaiIken(),
                            bodyItem.getBiko(),
                            bodyItem.getRemban(),
                            ninshoshaSource.koinMojiretsu,
                            ninshoshaSource.ninshoshaShimeiKakenai,
                            ninshoshaSource.ninshoshaShimeiKakeru,
                            ninshoshaSource.ninshoshaYakushokuMei1,
                            ninshoshaSource.ninshoshaYakushokuMei2);
                    for (JukyuShikakuShomeishoReport report : toReports(new JukyuShikakuShomeishoJoho(bodyItem))) {
                        ReportSourceWriter<JukyuShikakuShomeishoReportSource> reportSourceWrite = new ReportSourceWriter(assembler);
                        report.writeBy(reportSourceWrite);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static List<JukyuShikakuShomeishoReport> toReports(JukyuShikakuShomeishoJoho reportJoho) {
        List<JukyuShikakuShomeishoReport> list = new ArrayList<>();
        list.add(JukyuShikakuShomeishoReport.createReport(reportJoho.getBodyItem()));
        return list;
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
