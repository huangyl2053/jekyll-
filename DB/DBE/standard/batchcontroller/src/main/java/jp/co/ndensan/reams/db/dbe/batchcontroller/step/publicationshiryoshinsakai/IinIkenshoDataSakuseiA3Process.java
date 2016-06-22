/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoa3.ShujiiikenshoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.publicationshiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3.ShujiiikenshoItem;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用主治医意見書情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinIkenshoDataSakuseiA3Process extends BatchKeyBreakBase<ShinsakaiWariateJohoEntity> {

    private static final RString SELECT_WARIATEJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.publicationshiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiWariateJoho");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(ShujiiikenshoA3ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    @BatchWriter
    private BatchReportWriter<ShujiiikenshoA3ReportSource> batchWriteA3;
    private ReportSourceWriter<ShujiiikenshoA3ReportSource> reportSourceWriterA3;
    private ShujiiikenshoItem item;

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
        // TODO QA回答まち、ファイル名が無し、
//            item.set左の主治医意見書イメージ(共有ファイルを引き出す(entity.getImageSharedFileId(), 出力スタイル_A4));
//            item.set右の主治医意見書イメージ(共有ファイルを引き出す(entity.getImageSharedFileId(), 出力スタイル_A4));
        ShujiiikenshoA3Report reportA3 = ShujiiikenshoA3Report.createFrom(item);
        reportA3.writeBy(reportSourceWriterA3);
    }

    @Override
    protected void createWriter() {
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517005.getReportId().value())
                .addBreak(new BreakerCatalog<ShujiiikenshoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A3))
                .create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
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

//    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージID01) {
//        RString imagePath = RString.EMPTY;
//        if (イメージID != null) {
//            imagePath = getFilePath(イメージID, イメージID01);
//        }
//        return imagePath;
//    }
//
//    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
//        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
//        ReadOnlySharedFileEntryDescriptor descriptor
//                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
//                        sharedFileId);
//        SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
//        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
//    }
    @Override
    protected void keyBreakProcess(ShinsakaiWariateJohoEntity current) {
        if (hasBrek(getBefore(), current)) {
            ShujiiikenshoA3Report report = new ShujiiikenshoA3Report(item);
            report.writeBy(reportSourceWriterA3);
        }
    }

    private boolean hasBrek(ShinsakaiWariateJohoEntity before, ShinsakaiWariateJohoEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
    }
}
