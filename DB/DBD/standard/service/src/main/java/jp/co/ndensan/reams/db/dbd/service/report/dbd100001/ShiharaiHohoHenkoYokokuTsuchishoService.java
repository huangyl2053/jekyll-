/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100001.ShiharaiHohoHenkoYokokuTsuchishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100001.ShiharaiHohoHenkoYokokuTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100001.ShiharaiHohoHenkoYokokuTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
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
 * 支払方法変更予告通知書
 *
 * @reamsid_L DBD-3640-040 b_liuyang2
 */
public class ShiharaiHohoHenkoYokokuTsuchishoService {

    /**
     * 帳票を出力
     *
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(IKojin 個人情報, IAtesaki 宛先, List<ChohyoSeigyoHanyo> 帳票制御汎用リスト, ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体, FlexibleDate 発行日, RString 文書番号, List<RString> 通知書定型文リスト, RString 帳票分類ID,
            Ninshosha 認証者, ShiharaiHohoHenko 帳票情報, ReportManager reportManager) {
        ShiharaiHohoHenkoYokokuTsuchishoProerty property = new ShiharaiHohoHenkoYokokuTsuchishoProerty();
        try (ReportAssembler<ShiharaiHohoHenkoYokokuTsuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            for (ShiharaiHohoHenkoYokokuTsuchishoReport report : toReport(個人情報, 宛先, 帳票制御汎用リスト, 帳票制御共通,
                    地方公共団体, 発行日, 文書番号, 通知書定型文リスト, 帳票分類ID, 認証者, 帳票情報)) {
                ReportSourceWriter<ShiharaiHohoHenkoYokokuTsuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    private List<ShiharaiHohoHenkoYokokuTsuchishoReport> toReport(IKojin 個人情報, IAtesaki 宛先,
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体,
            FlexibleDate 発行日, RString 文書番号, List<RString> 通知書定型文リスト, RString 帳票分類ID, Ninshosha 認証者,
            ShiharaiHohoHenko 帳票情報) {
        List<ShiharaiHohoHenkoYokokuTsuchishoReport> list = new ArrayList();
        list.add(ShiharaiHohoHenkoYokokuTsuchishoReport.createReport(個人情報, 宛先, 帳票制御汎用リスト, 帳票制御共通,
                地方公共団体, 発行日, 文書番号, 通知書定型文リスト, 帳票分類ID, 認証者, 帳票情報));
        return list;
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
