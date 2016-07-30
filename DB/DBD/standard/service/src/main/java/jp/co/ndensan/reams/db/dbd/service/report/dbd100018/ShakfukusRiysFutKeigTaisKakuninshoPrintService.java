/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd100018;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport;
import jp.co.ndensan.reams.db.dbd.business.report.hanyo.HokenshaNameOutput;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoReportSource;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100019.ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
     * @param 社会福祉法人等利用者負担軽減 社会福祉法人等利用者負担軽減
     * @param iKojin iKojin
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 交付日 交付日
     * @param 発行日 発行日
     * @param 帳票分類ID 帳票分類ID
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減, IKojin iKojin, ChohyoSeigyoKyotsu 帳票制御共通,
            List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RDate 交付日,
            RDate 発行日, ReportId 帳票分類ID, ReportManager reportManager) {
        for (DbT7067ChohyoSeigyoHanyoEntity entity : 帳票制御汎用List) {
            if (HokenshaNameOutput.印字する.getコード().equals(entity.getKomokuValue())) {
                printDBD100019(社会福祉法人等利用者負担軽減,
                        iKojin, 帳票制御共通, 帳票制御汎用List, 地方公共団体, 交付日, 発行日, 帳票分類ID, reportManager);
                break;
            } else {
                printDBD100018(社会福祉法人等利用者負担軽減,
                        iKojin, 帳票制御共通, 帳票制御汎用List, 地方公共団体, 交付日, 発行日, 帳票分類ID, reportManager);
                break;
            }
        }
    }

    private void printDBD100018(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減, IKojin iKojin,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RDate 交付日,
            RDate 発行日, ReportId 帳票分類ID, ReportManager reportManager) {
        ShakfukusRiysFutKeigTaisKakuninshoProerty property = new ShakfukusRiysFutKeigTaisKakuninshoProerty();
        try (ReportAssembler<ShakfukusRiysFutKeigTaisKakuninshoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ShakfukusRiysFutKeigTaisKakuninshoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID,
                    new FlexibleDate(発行日.toDateString()), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            ShakfukusRiysFutKeigTaisKakuninshoReport report = ShakfukusRiysFutKeigTaisKakuninshoReport.createReport(社会福祉法人等利用者負担軽減,
                    iKojin, 帳票制御共通, 帳票制御汎用List, 地方公共団体, 交付日, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private void printDBD100019(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減, IKojin iKojin,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RDate 交付日,
            RDate 発行日, ReportId 帳票分類ID, ReportManager reportManager) {
        ShafukuRiysFutKeigTaisKakuninshoShoNoAriProerty property = new ShafukuRiysFutKeigTaisKakuninshoShoNoAriProerty();
        try (ReportAssembler<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<ShafukuRiysFutKeigTaisKakuninshoShoNoAriReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID,
                    new FlexibleDate(発行日.toDateString()), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport report = ShafukuRiysFutKeigTaisKakuninshoShoNoAriReport.createReport(
                    社会福祉法人等利用者負担軽減, iKojin, 帳票制御共通, 帳票制御汎用List, 地方公共団体, 交付日,
                    ninshoshaSource);
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
