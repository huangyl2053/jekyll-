/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd100014;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100011.HomKaigRiysFutgGengKettTsuchishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100011.HomKaigRiysFutgGengKettTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100011.HomKaigRiysFutgGengKettTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 訪問介護等利用者負担額減額決定通知書のReportSource
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public class HomKaigRiysFutgGengKettTsuchishoPrintService {

    /**
     * 帳票を出力
     *
     * @param 訪問介護利用者負担額減額 訪問介護利用者負担額減額
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 地方公共団体 地方公共団体
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 通知書定型文List 通知書定型文List
     * @param 帳票分類ID 帳票分類ID
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額, IKojin iKojin, IAtesaki iAtesaki,
            ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体, RDate 発行日, RString 文書番号, List<RString> 通知書定型文List,
            ReportId 帳票分類ID, ReportManager reportManager) {
        HomKaigRiysFutgGengKettTsuchishoProerty property = new HomKaigRiysFutgGengKettTsuchishoProerty();
        try (ReportAssembler<HomKaigRiysFutgGengKettTsuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HomKaigRiysFutgGengKettTsuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID,
                    new FlexibleDate(発行日.toDateString()), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            HomKaigRiysFutgGengKettTsuchishoReport report = HomKaigRiysFutgGengKettTsuchishoReport.createReport(訪問介護利用者負担額減額, iKojin,
                    iAtesaki, 帳票制御共通, 地方公共団体, 文書番号, 通知書定型文List, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
