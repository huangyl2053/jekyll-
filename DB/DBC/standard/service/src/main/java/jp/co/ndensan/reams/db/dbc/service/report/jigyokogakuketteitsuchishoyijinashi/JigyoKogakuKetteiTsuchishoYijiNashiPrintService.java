/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jigyokogakuketteitsuchishoyijinashi;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijinashi.JigyoKogakuKetteiTsuchishoYijiNashiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jigyokogakuketteitsuchishoyijinashi.JigyoKogakuKetteiTsuchishoYijiNashiReport;
import jp.co.ndensan.reams.db.dbc.entity.jigyokogakuketteitsuchishoyijinashi.JigyoKogakuKetteiTsuchishoYijiNashiSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 帳票設計_DBCMN43002_事業高額決定通知書 PrintServiceするクラスです。
 *
 * @reamsid_L DBC-2000-100 lijian
 */
public class JigyoKogakuKetteiTsuchishoYijiNashiPrintService {

    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final ReportId 帳票分類ID = new ReportId("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString 項目名 = new RString("取り消し線");

    /**
     * 帳票設計_DBCMN43002_事業高額決定通知書 (単一帳票出力用)
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoEntity
     * @param 発行日 RDate
     * @param 文書番号 RString
     * @param 帳票ID RString
     * @param 認証者 Ninshosha
     * @param 通知書定型文List List<RString>
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KogakuKetteiTsuchiShoEntity 帳票情報,
            RDate 発行日,
            RString 文書番号,
            RString 帳票ID,
            Ninshosha 認証者,
            List<RString> 通知書定型文List) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(帳票情報, 発行日, 文書番号, 帳票ID, 認証者, 通知書定型文List, reportManager);
            collection = reportManager.publish();
        }

        return collection;

    }

    /**
     * 帳票設計_DBCMN43002_事業高額決定通知書 (複数帳票出力用)。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoEntity
     * @param 発行日 RDate
     * @param 文書番号 RString
     * @param 帳票ID RString
     * @param 認証者 Ninshosha
     * @param 通知書定型文List List<RString>
     * @param reportManager ReportManager
     */
    public void print(
            KogakuKetteiTsuchiShoEntity 帳票情報,
            RDate 発行日,
            RString 文書番号,
            RString 帳票ID,
            Ninshosha 認証者,
            List<RString> 通知書定型文List,
            ReportManager reportManager) {

        JigyoKogakuKetteiTsuchishoYijiNashiProperty property = new JigyoKogakuKetteiTsuchishoYijiNashiProperty();

        try (ReportAssembler<JigyoKogakuKetteiTsuchishoYijiNashiSource> assembler = createAssembler(property, reportManager)) {
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

//            RString 帳票イメージフォルダパス = assembler.getImageFolderPath();
//            NinshoshaSource 認証者ソースデータ = NinshoshaSourceBuilderFactory.createInstance(
//                    認証者,
//                    地方公共団体,
//                    帳票イメージフォルダパス,
//                    発行日).buildSource();
            NinshoshaSource 認証者ソースデータ = null;

            ReportSourceWriter<JigyoKogakuKetteiTsuchishoYijiNashiSource> reportSourceWriter;
            reportSourceWriter = new ReportSourceWriter(assembler);

//            RString 設定値 = fetch設定値();
            RString 設定値 = null;

            new JigyoKogakuKetteiTsuchishoYijiNashiReport(
                    設定値,
                    帳票情報,
                    認証者ソースデータ,
                    文書番号,
                    通知書定型文List).writeBy(reportSourceWriter);
        }
    }

    private RString fetch設定値() {
        DbT7067ChohyoSeigyoHanyoDac dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity = dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID, 管理年度, 項目名);
        RString 設定値 = entity.getKomokuValue();
        return 設定値;
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
