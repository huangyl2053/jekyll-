/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.sonotashiryo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo.SonoTashiryoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo.SonoTashiryoReport;
import jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo.SonotashiryoProperty;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryo.SonoTashiryoReportSource;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * 事務局用その他資料のPrinterクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class SonotashiryoPrintService {

    private static final RString FILENAME_A_BAK = new RString("F1401A01_BAK.png");
    private static final RString FILENAME_A = new RString("F1401A01.png");
    private static final RString FILENAME_B_BAK = new RString("F1401B02_BAK.png");
    private static final RString FILENAME_B = new RString("F1401B02.png");
    private static final RString FILENAME_C_BAK = new RString("F1401C03_BAK.png");
    private static final RString FILENAME_C = new RString("F1401C03.png");
    private static final RString FILENAME_D_BAK = new RString("F1401D04_BAK.png");
    private static final RString FILENAME_D = new RString("F1401D04.png");
    private static final RString FILENAME_E_BAK = new RString("F1401E05_BAK.png");
    private static final RString FILENAME_E = new RString("F1401E05.png");
    private static final RString FILENAME_F_BAK = new RString("F1401F06_BAK.png");
    private static final RString FILENAME_F = new RString("F1401F06.png");
    private static final RString マスキングあり = new RString("1");
    private static final RString SEPARATOR = new RString("/");

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public SonotashiryoPrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 事務局用その他資料を印刷します。
     *
     * @param business YokaigoNinteiJohoTeikyoBusiness
     * @param イメージ共有ファイルID RDateTime
     * @param その他資料マスキング区分 その他資料マスキング区分
     */
    public void print(YokaigoNinteiJohoTeikyoBusiness business, RDateTime イメージ共有ファイルID, RString その他資料マスキング区分) {
        RString 共有フォルダ名 = business.get保険者番号().concat(business.get被保険者番号());
        if (イメージ共有ファイルID != null) {
            ReadOnlySharedFileEntryDescriptor descriptor = get共有ファイルエントリ情報(共有フォルダ名, イメージ共有ファイルID);
            RString path = Directory.createTmpDirectory();

            RString イメージファイルパスA = getAイメージファイルパス(descriptor, path, その他資料マスキング区分);
            if (!イメージファイルパスA.isEmpty()) {
                try (ReportAssembler<SonoTashiryoReportSource> assembler = createAssembler(new SonotashiryoProperty(), reportManager)) {
                    ReportSourceWriter<SonoTashiryoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    SonoTashiryoReport report = new SonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスA));
                    report.writeBy(reportSourceWriter);
                }
            }

            RString イメージファイルパスB = getBイメージファイルパス(descriptor, path, その他資料マスキング区分);
            if (!イメージファイルパスB.isEmpty()) {
                try (ReportAssembler<SonoTashiryoReportSource> assembler = createAssembler(new SonotashiryoProperty(), reportManager)) {
                    ReportSourceWriter<SonoTashiryoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    SonoTashiryoReport report = new SonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスB));
                    report.writeBy(reportSourceWriter);
                }
            }

            RString イメージファイルパスC = getCイメージファイルパス(descriptor, path, その他資料マスキング区分);
            if (!イメージファイルパスC.isEmpty()) {
                try (ReportAssembler<SonoTashiryoReportSource> assembler = createAssembler(new SonotashiryoProperty(), reportManager)) {
                    ReportSourceWriter<SonoTashiryoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    SonoTashiryoReport report = new SonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスC));
                    report.writeBy(reportSourceWriter);
                }
            }

            RString イメージファイルパスD = getDイメージファイルパス(descriptor, path, その他資料マスキング区分);
            if (!イメージファイルパスD.isEmpty()) {
                try (ReportAssembler<SonoTashiryoReportSource> assembler = createAssembler(new SonotashiryoProperty(), reportManager)) {
                    ReportSourceWriter<SonoTashiryoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    SonoTashiryoReport report = new SonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスD));
                    report.writeBy(reportSourceWriter);
                }
            }

            RString イメージファイルパスE = getEイメージファイルパス(descriptor, path, その他資料マスキング区分);
            if (!イメージファイルパスE.isEmpty()) {
                try (ReportAssembler<SonoTashiryoReportSource> assembler = createAssembler(new SonotashiryoProperty(), reportManager)) {
                    ReportSourceWriter<SonoTashiryoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    SonoTashiryoReport report = new SonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスE));
                    report.writeBy(reportSourceWriter);
                }
            }

            RString イメージファイルパスF = getFイメージファイルパス(descriptor, path, その他資料マスキング区分);
            if (!イメージファイルパスF.isEmpty()) {
                try (ReportAssembler<SonoTashiryoReportSource> assembler = createAssembler(new SonotashiryoProperty(), reportManager)) {
                    ReportSourceWriter<SonoTashiryoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    SonoTashiryoReport report = new SonoTashiryoReport(SonoTashiryoEntityEditor.edit(business.toEntity(), イメージファイルパスF));
                    report.writeBy(reportSourceWriter);
                }
            }
        }
    }

    private RString getAイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_A);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_A_BAK)) ? FILENAME_A_BAK : FILENAME_A;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getBイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_B);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_B_BAK)) ? FILENAME_B_BAK : FILENAME_B;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getCイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_C);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_C_BAK)) ? FILENAME_C_BAK : FILENAME_C;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getDイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_D);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_D_BAK)) ? FILENAME_D_BAK : FILENAME_D;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getEイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_E);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_E_BAK)) ? FILENAME_E_BAK : FILENAME_E;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString getFイメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path, RString その他資料マスキング区分) {
        if (マスキングあり.equals(その他資料マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME_F);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_F_BAK)) ? FILENAME_F_BAK : FILENAME_F;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private boolean existマスキングファイル(List<SharedFileEntryInfoEntity> entryInfoList, RString ファイル名) {
        for (SharedFileEntryInfoEntity entryInfo : entryInfoList) {
            if (entryInfo.getFilesEntity().getPathname().endsWith(ファイル名)) {
                return true;
            }
        }
        return false;
    }

    private ReadOnlySharedFileEntryDescriptor get共有ファイルエントリ情報(RString 共有フォルダ名, RDateTime イメージ共有ファイルID) {
        return new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有フォルダ名), イメージ共有ファイルID);
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
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
