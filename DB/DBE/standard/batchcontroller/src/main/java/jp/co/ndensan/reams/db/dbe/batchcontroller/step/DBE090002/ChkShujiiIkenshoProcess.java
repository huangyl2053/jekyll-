/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1.ShujiiikenshoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujikensho.ShujiiikenshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoninteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1.ShujiiikenshoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimpleLayoutBreaker;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 主治医意見書の作成クラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class ChkShujiiIkenshoProcess extends BatchProcessBase<YokaigoninteiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    IYokaigoNinteiJohoTeikyoMapper mapper;
    @BatchWriter
    private BatchReportWriter<ShujiiikenshoReportSource> batchWrite;
    private ReportSourceWriter<ShujiiikenshoReportSource> reportSourceWriter;
    private static final RString FILENAME_BAK = new RString("E0001_BAK.png");
    private static final RString FILENAME = new RString("E0001.png");
    private static final RString FILENAME_BAK02 = new RString("E0002_BAK.png");
    private static final RString FILENAME02 = new RString("E0002.png");
    private static final RString フラグ = new RString("1");
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString 認定調査票チェックフラグ = new RString("【認定調査票】");
    private static final RString 特記事項チェックフラグ = new RString("【特記事項】");
    private static final RString 主治医意見書チェックフラグ = new RString("【主治医意見書】");
    private static final RString その他資料チェックフラグ = new RString("【その他資料】");
    private static final RString 一次判定結果チェックフラグ = new RString("【一次判定結果】");
    private static final RString 帳票発行有り = new RString("1");
    private static final RString 帳票発行無し = new RString("0");
    private static final RString 出力する = new RString("出力する");
    private static final RString 出力しない = new RString("出力しない");
    private static final RString 総合事業開始区分 = new RString("【総合事業開始区分】");
    private static final RString 総合事業開始区分_未実施 = new RString("1");
    private static final RString 総合事業開始区分_実施済 = new RString("2");
    private static final RString 総合事業未実施 = new RString("総合事業未実施");
    private static final RString 総合事業実施済 = new RString("総合事業実施済");
    private static final RString SEPARATOR = new RString("/");

    @Override
    protected void initialize() {
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IYokaigoNinteiJohoTeikyoMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517151.getReportId().value())
                .addBreak(new BreakerCatalog<ShujiiikenshoReportSource>().new SimpleLayoutBreaker(



                    ShujiiikenshoReportSource.LAYOUTBREAKITEM) {
                    @Override
                    public ReportLineRecord<ShujiiikenshoReportSource> occuredBreak(
                            ReportLineRecord<ShujiiikenshoReportSource> currentRecord,
                            ReportLineRecord<ShujiiikenshoReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layout;
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layout;
                                    nextRecord.setFormGroupIndex(layout);
                                }
                                return currentRecord;
                            }
                }).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(YokaigoninteiEntity entity) {
        ShujiiikenshoReport report = new ShujiiikenshoReport(setBodyItem(entity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
    }

    private ShujiiikenshoEntity setBodyItem(YokaigoninteiEntity entity) {
        ShujiiikenshoEntity shujiEntity = new ShujiiikenshoEntity();
        shujiEntity.set保険者番号(entity.get保険者番号());
        shujiEntity.set被保険者番号(entity.get被保険者番号());
        shujiEntity.set被保険者氏名(entity.get被保険者氏名());
        shujiEntity.set申請日_元号(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        shujiEntity.set申請日_年(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        shujiEntity.set申請日_月(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        shujiEntity.set申請日_日(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        shujiEntity.set作成日_元号(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        shujiEntity.set作成日_年(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        shujiEntity.set作成日_月(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        shujiEntity.set作成日_日(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        shujiEntity.set調査日_元号(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        shujiEntity.set調査日_年(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        shujiEntity.set調査日_月(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        shujiEntity.set調査日_日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        shujiEntity.set審査日_元号(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        shujiEntity.set審査日_年(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        shujiEntity.set審査日_月(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        shujiEntity.set審査日_日(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        RString 共有フォルダ名 = entity.get保険者番号().concat(entity.get被保険者番号());
        RDateTime イメージ共有ファイルID = mapper.getイメージ(processPrm.toYokaigoBatchMybitisParamter());
        ReadOnlySharedFileEntryDescriptor descriptor = get共有ファイルエントリ情報(共有フォルダ名, イメージ共有ファイルID);
        RString path = getFilePath(descriptor);
        shujiEntity.setイメージファイル1(get表面イメージファイルパス(descriptor, path));
        shujiEntity.setイメージファイル2(get裏面イメージファイルパス(descriptor, path));
        return shujiEntity;
    }

    private RString get表面イメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path) {
        if (フラグ.equals(processPrm.getRadShujii())) {
            RString fineFullPath = getFilePath(path, FILENAME);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_BAK)) ? FILENAME_BAK : FILENAME;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private RString get裏面イメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor, RString path) {
        if (フラグ.equals(processPrm.getRadShujii())) {
            RString fineFullPath = getFilePath(path, FILENAME02);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_BAK02)) ? FILENAME_BAK02 : FILENAME02;
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

    private RString getFilePath(ReadOnlySharedFileEntryDescriptor descriptor) {
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(batchWrite.getImageFolderPath())).getCanonicalPath());
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
    }

    private void set出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(認定調査票チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkNinteiChosahyo()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(特記事項チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkTokkiJiko()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医意見書チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkShujiiIkensho()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(その他資料チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkSonotaShiryo()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(一次判定結果チェックフラグ);
        builder.append(get帳票発行有無(processPrm.getChkIchijiHanteiKekka()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(総合事業開始区分);
        builder.append(get総合事業開始区分名称(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援)));
        出力条件.add(builder.toRString());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdDBE.DBE517151.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517151.getReportId().value()),
                        new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

    private RString get帳票発行有無(RString 帳票発行フラグ) {
        if (帳票発行フラグ.equals(帳票発行有り)) {
            return 出力する;
        } else if (帳票発行フラグ.equals(帳票発行無し)) {
            return 出力しない;
        }
        return RString.EMPTY;
    }

    private RString get総合事業開始区分名称(RString 総合事業開始区分) {
        if (総合事業開始区分.equals(総合事業開始区分_未実施)) {
            return 総合事業未実施;
        } else if (総合事業開始区分.equals(総合事業開始区分_実施済)) {
            return 総合事業実施済;
        }
        return RString.EMPTY;
    }
}
