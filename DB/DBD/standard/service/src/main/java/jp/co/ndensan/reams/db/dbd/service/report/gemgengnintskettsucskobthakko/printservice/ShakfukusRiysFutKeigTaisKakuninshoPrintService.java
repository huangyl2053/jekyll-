/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice;

import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoReport;
import jp.co.ndensan.reams.db.dbd.business.report.hanyo.HokenshaNameOutput;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 社会福祉法人等利用者負担軽減対象確認証のReportSource
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShakfukusRiysFutKeigTaisKakuninshoPrintService {

    /**
     * 帳票を出力
     *
     * @param target パラメータ
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(ShakfukusRiysFutKeigTaisKakuninshoItem target, ReportManager reportManager) {
        ReportId reportId = null;
        for (DbT7067ChohyoSeigyoHanyoEntity entity : target.get帳票制御汎用List()) {
            if (HokenshaNameOutput.印字する.getコード().equals(entity.getKomokuValue())) {
                reportId = ReportIdDBD.DBD100019.getReportId();
            } else {
                reportId = ReportIdDBD.DBD100018.getReportId()
            }
        }
        ShakfukusRiysFutKeigTaisKakuninshoProerty property = new ShakfukusRiysFutKeigTaisKakuninshoProerty(reportId);
        try (ReportAssembler<ShakfukusRiysFutKeigTaisKakuninshoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ShakfukusRiysFutKeigTaisKakuninshoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, target.get帳票分類ID(),
                    new FlexibleDate(target.get発行日().toDateString()), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            target.setNinshoshaSource(ninshoshaSource);
            ShakfukusRiysFutKeigTaisKakuninshoReport report = ShakfukusRiysFutKeigTaisKakuninshoReport.createReport(target);
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
