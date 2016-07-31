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
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.Shujiiikensho1A4ReportSource;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用主治医意見書情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinIkenshoDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiWariateJohoEntity> {

    private static final RString SELECT_WARIATEJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiWariateJoho");
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(Shujiiikensho1A4ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    @BatchWriter
    private BatchReportWriter<Shujiiikensho1A4ReportSource> batchWriteA4;
    private ReportSourceWriter<Shujiiikensho1A4ReportSource> reportSourceWriterA4;
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
    protected void usualProcess(ShinsakaiWariateJohoEntity entity) {
        item = new ShujiiikenshoItem();
        set項目(entity);
        item.set主治医意見書イメージ一頁目(共有ファイルを引き出す(entity.getImageSharedFileId(), ファイルID_E0001));
        item.set主治医意見書イメージ二頁目(共有ファイル2を引き出す(entity.getImageSharedFileId(), ファイルID_E0002));
        JimuShinsakaiWariateJohoBusiness business = new JimuShinsakaiWariateJohoBusiness(entity);
        Shujiiikensho1A4Report reportA4 = Shujiiikensho1A4Report.createFrom(business);
        reportA4.writeBy(reportSourceWriterA4);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517152.getReportId().value())
                .addBreak(new BreakerCatalog<Shujiiikensho1A4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    private void set項目(ShinsakaiWariateJohoEntity 主治医意見書情報) {
        item.set保険者番号(主治医意見書情報.getShoKisaiHokenshaNo());
        item.set被保険者番号(主治医意見書情報.getHihokenshaNo());
        item.set名前(主治医意見書情報.getHihokenshaName().getColumnValue());
        item.set審査会資料作成年月日(new FlexibleDate(RDate.getNowDate().toDateString()));
        item.set今回認定申請年月日(主治医意見書情報.getNinteiShinseiYMD());
        item.set今回認定調査実施年月日(主治医意見書情報.getNinteichosaJisshiYMD());
        item.set今回認定審査年月日(主治医意見書情報.getShinsakaiKaisaiYMD());
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
    protected void keyBreakProcess(ShinsakaiWariateJohoEntity current) {
        hasBrek(getBefore(), current);
    }

    private boolean hasBrek(ShinsakaiWariateJohoEntity before, ShinsakaiWariateJohoEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
    }
}
