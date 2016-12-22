/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1a4.Shujiiikensho1A4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.Shujiiikensho1A4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 事務局用主治医意見書情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuIkenshoDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiSiryoKyotsuEntity> {

    private static final RString SELECT_JIMUWARIATEJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper.get共通情報");
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(Shujiiikensho1A4ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinShinsakaiIinJohoProcessParameter paramter;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    @BatchWriter
    private BatchReportWriter<Shujiiikensho1A4ReportSource> batchWriteA4;
    private ReportSourceWriter<Shujiiikensho1A4ReportSource> reportSourceWriterA4;
    private JimuShinsakaiWariateJohoBusiness business;
    private static final RString ファイルID_E0001 = new RString("E0001.png");
    private static final RString ファイルID_E0002 = new RString("E0002.png");
    private static final RString ファイルID_E0001BAK = new RString("E0001_BAK.png");
    private static final RString ファイルID_E0002BAK = new RString("E0002_BAK.png");
    private static final RString SEPARATOR = new RString("/");

    @Override
    protected void initialize() {
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUWARIATEJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(ShinsakaiSiryoKyotsuEntity entity) {
        entity.setJimukyoku(true);
        business = new JimuShinsakaiWariateJohoBusiness(entity);
        RString 共有ファイル名 = entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo());
        RString path = getFilePath(entity.getImageSharedFileId(), 共有ファイル名);
        if (entity.isJimukyoku()) {
            business.setイメージファイル(共有ファイルを引き出す(path, ファイルID_E0001BAK));
            business.setイメージファイル_BAK(共有ファイルを引き出す(path, ファイルID_E0002BAK));
        } else {
            business.setイメージファイル(共有ファイルを引き出す(path, ファイルID_E0001));
            business.setイメージファイル_BAK(共有ファイルを引き出す(path, ファイルID_E0002));
        }
        Shujiiikensho1A4Report reportA4 = new Shujiiikensho1A4Report(business);
        reportA4.writeBy(reportSourceWriterA4);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517151.getReportId().value())
                .addBreak(new BreakerCatalog<Shujiiikensho1A4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .addBreak(new BreakerCatalog<Shujiiikensho1A4ReportSource>().new SimpleLayoutBreaker(
                    Shujiiikensho1A4ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<Shujiiikensho1A4ReportSource> occuredBreak(
                            ReportLineRecord<Shujiiikensho1A4ReportSource> currentRecord,
                            ReportLineRecord<Shujiiikensho1A4ReportSource> nextRecord,
                            ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layout.index();
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layout.index();
                                    nextRecord.setFormGroupIndex(layout);
                                }
                                return currentRecord;
                            }
                }).create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiSiryoKyotsuEntity current) {
        hasBrek(getBefore(), current);
    }

    private boolean hasBrek(ShinsakaiSiryoKyotsuEntity before, ShinsakaiSiryoKyotsuEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
    }

    private RString 共有ファイルを引き出す(RString path, RString fileName) {
        if (!RString.isNullOrEmpty(getFilePath(path, fileName))) {
            return getFilePath(path, fileName);
        }
        return RString.EMPTY;
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        if (sharedFileId == null || RString.isNullOrEmpty(sharedFileName)) {
            return RString.EMPTY;
        }
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName), sharedFileId);
        try {
            return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(batchWriteA4.getImageFolderPath())).getCanonicalPath());
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }
}
