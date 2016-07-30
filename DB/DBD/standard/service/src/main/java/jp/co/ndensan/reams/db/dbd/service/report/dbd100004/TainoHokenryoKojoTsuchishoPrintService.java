/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd100004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100004.TainoHokenryoKojoTsuchishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100004.TainoHokenryoKojoTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shokankihonjiho.ShokanKihonJihoEntiy;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100004.TainoHokenryoKojoTsuchishoReportSource;
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
 * 滞納保険料控除通知書
 *
 * @reamsid_L DBD-3640-050 b_liuyang2
 */
public class TainoHokenryoKojoTsuchishoPrintService {

    /**
     * 帳票を出力
     *
     * @param 個人情報 IKojin
     * @param 宛先 IAtesaki
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 通知書定型文リスト List<RString>
     * @param 帳票分類ID ReportId
     * @param 帳票情報 ShiharaiHohoHenko
     * @param 償還払集計情報リスト List<ShokanKihonJihoEntiy>
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(IKojin 個人情報, IAtesaki 宛先, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体,
            FlexibleDate 発行日, RString 文書番号, List<RString> 通知書定型文リスト, ReportId 帳票分類ID,
            ShiharaiHohoHenko 帳票情報, List<ShokanKihonJihoEntiy> 償還払集計情報リスト, ReportManager reportManager) {
        TainoHokenryoKojoTsuchishoProerty property = new TainoHokenryoKojoTsuchishoProerty();
        try (ReportAssembler<TainoHokenryoKojoTsuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TainoHokenryoKojoTsuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource 認証者ソースビルダー = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID, 発行日,
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            TainoHokenryoKojoTsuchishoReport report = TainoHokenryoKojoTsuchishoReport.createReport(個人情報, 宛先,
                    帳票制御共通, 地方公共団体, 文書番号, 通知書定型文リスト, 認証者ソースビルダー, 帳票情報, 償還払集計情報リスト);
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
