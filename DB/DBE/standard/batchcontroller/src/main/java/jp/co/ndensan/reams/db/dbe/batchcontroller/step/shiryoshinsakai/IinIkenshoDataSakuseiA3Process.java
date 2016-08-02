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
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa3.ShujiiikenshoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoItem;
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
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用主治医意見書情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinIkenshoDataSakuseiA3Process extends BatchKeyBreakBase<ShinsakaiSiryoKyotsuEntity> {

    private static final RString SELECT_WARIATEJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiWariateJoho");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(ShujiiikenshoA3ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    @BatchWriter
    private BatchReportWriter<ShujiiikenshoA3ReportSource> batchWriteA3;
    private ReportSourceWriter<ShujiiikenshoA3ReportSource> reportSourceWriterA3;
    private ShujiiikenshoItem item;
    private static final RString ファイルID_E0001 = new RString("E0001.png");
    private static final RString ファイルID_E0001_BAK = new RString("E0001_BAK.png");
    private static final RString ファイルID_E0002 = new RString("E0002.png");
    private static final RString ファイルID_E0002_BAK = new RString("E0002_BAK.png");

    @Override
    protected void initialize() {
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_WARIATEJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(ShinsakaiSiryoKyotsuEntity entity) {
        item = new ShujiiikenshoItem();
        item.set左の主治医意見書イメージ(共有ファイルを引き出す(entity.getImageSharedFileId(), ファイルID_E0001));
        item.set右の主治医意見書イメージ(共有ファイル2を引き出す(entity.getImageSharedFileId(), ファイルID_E0002));
        JimuShinsakaiWariateJohoBusiness business = new JimuShinsakaiWariateJohoBusiness(entity);
        ShujiiikenshoA3Report reportA3 = ShujiiikenshoA3Report.createFrom(business);
        reportA3.writeBy(reportSourceWriterA3);
    }

    @Override
    protected void createWriter() {
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517005.getReportId().value())
                .addBreak(new BreakerCatalog<ShujiiikenshoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A3))
                .create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージID, ファイルID_E0001_BAK);
            }
        }
        return imagePath;
    }

    private RString 共有ファイル2を引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージID, ファイルID_E0002_BAK);
            }
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiSiryoKyotsuEntity current) {
        hasBrek(getBefore(), current);
    }

    private boolean hasBrek(ShinsakaiSiryoKyotsuEntity before, ShinsakaiSiryoKyotsuEntity current) {
//        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
        return before.equals(current);
    }

    @Override
    protected void afterExecute() {
    }
}
