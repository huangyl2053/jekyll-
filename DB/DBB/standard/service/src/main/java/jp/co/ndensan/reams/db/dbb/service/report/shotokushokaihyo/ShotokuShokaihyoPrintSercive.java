/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.NushiJuminJohoResult;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo.ShotokuShokaihyoTateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo.ShotokuShokaihyoTateReport;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo.ShotokuShokaihyoYokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo.ShotokuShokaihyoYokoReport;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo.ShotokuShokaihyoTateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo.ShotokuShokaihyoYokoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 所得照会票のクラスです。
 *
 * @reamsid_L DBB-1710-030 xuhao
 */
public class ShotokuShokaihyoPrintSercive {

    private static final RString 種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();

    /**
     * printＡ４横のメソッドです。
     *
     * @param 所得照会票 NushiJuminJohoResult
     * @param 文書タイトル RString
     * @param 送付先担当課名称 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printＡ４横(NushiJuminJohoResult 所得照会票,
            RString 文書タイトル,
            RString 送付先担当課名称) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printＡ４横(所得照会票, 文書タイトル, 送付先担当課名称, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * printＡ４横のメソッドです。
     *
     * @param 所得照会票 NushiJuminJohoResult
     * @param 文書タイトル RString
     * @param 送付先担当課名称 RString
     * @param reportManager ReportManager
     */
    public void printＡ４横(NushiJuminJohoResult 所得照会票,
            RString 文書タイトル,
            RString 送付先担当課名称,
            ReportManager reportManager) {
        ShotokuShokaihyoYokoProperty property = new ShotokuShokaihyoYokoProperty();
        try (ReportAssembler<ShotokuShokaihyoYokoSource> assembler = createAssembler(property, reportManager)) {
            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (所得照会票.get発行日() != null) {
                開始年月日 = new FlexibleDate(所得照会票.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者, 地方公共団体,
                    assembler.getImageFolderPath(), 所得照会票.get発行日()).buildSource();
            ReportSourceWriter<ShotokuShokaihyoYokoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new ShotokuShokaihyoYokoReport(所得照会票, sourceBuilder, 文書タイトル, 送付先担当課名称)
                    .writeBy(reportSourceWriter);
        }

    }

    /**
     * printＡ４縦のメソッドです。
     *
     * @param 所得照会票 NushiJuminJohoResult
     * @param 文書タイトル RString
     * @param 送付先担当課名称 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printＡ４縦(NushiJuminJohoResult 所得照会票,
            RString 文書タイトル,
            RString 送付先担当課名称) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printＡ４縦(所得照会票, 文書タイトル, 送付先担当課名称, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * printＡ４縦のメソッドです。
     *
     * @param 所得照会票 NushiJuminJohoResult
     * @param 文書タイトル RString
     * @param 送付先担当課名称 RString
     * @param reportManager ReportManager
     */
    public void printＡ４縦(NushiJuminJohoResult 所得照会票,
            RString 文書タイトル,
            RString 送付先担当課名称,
            ReportManager reportManager) {
        ShotokuShokaihyoTateProperty property = new ShotokuShokaihyoTateProperty();
        try (ReportAssembler<ShotokuShokaihyoTateSource> assembler = createAssembler(property, reportManager)) {

            FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
            if (所得照会票.get発行日() != null) {
                開始年月日 = new FlexibleDate(所得照会票.get発行日().toString());
            }
            INinshoshaManager manager = new _NinshoshaManager();
            Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード, 開始年月日);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者, 地方公共団体,
                    assembler.getImageFolderPath(), 所得照会票.get発行日()).buildSource();
            ReportSourceWriter<ShotokuShokaihyoTateSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new ShotokuShokaihyoTateReport(所得照会票, sourceBuilder, 文書タイトル, 送付先担当課名称).
                    writeBy(reportSourceWriter);
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
