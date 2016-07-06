/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei.IinSonotashiryoSakuseiA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinsonotashiryosakusei.IinSonotashiryoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.SonotaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA3ReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用その他資料情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class SonotaJohoDataSakuseiA3Process extends BatchKeyBreakBase<SonotaJohoEntity> {

    private static final RString SELECT_TSONOTAJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getSonotaJoho");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(SonotashiryoA3ReportSource.ReportSourceFields.hokenshaNo.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private IinSonotashiryoSakuseiEntity item;
    @BatchWriter
    private BatchReportWriter<SonotashiryoA3ReportSource> batchWriteA3;
    private ReportSourceWriter<SonotashiryoA3ReportSource> reportSourceWriterA3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_10 = 10;
    private static final RString ファイルID_F1401A01 = new RString("F1401A01.png");
    private static final RString ファイルID_F1401A01_BAK = new RString("F1401A01_BAK.png");
    private static final RString ファイルID_F1401A02 = new RString("F1401A02.png");
    private static final RString ファイルID_F1401A02_BAK = new RString("F1401A02_BAK.png");

    @Override
    protected void initialize() {
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_TSONOTAJOHO, myBatisParameter);
    }

    @Override
    protected void usualProcess(SonotaJohoEntity entity) {
        item = new IinSonotashiryoSakuseiEntity();
        set項目(entity);
        item.set左のその他資料イメージ(共有ファイルを引き出す(entity.getImageSharedFileId(), ファイルID_F1401A01));
        item.set右のその他資料イメージ(共有ファイル2を引き出す(entity.getImageSharedFileId(), ファイルID_F1401A02));
        IinSonotashiryoSakuseiA3Report reportA3 = new IinSonotashiryoSakuseiA3Report(item);
        reportA3.writeBy(reportSourceWriterA3);
    }

    @Override
    protected void createWriter() {
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517006.getReportId().value())
                .addBreak(new BreakerCatalog<SonotashiryoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A3))
                .create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
    }

    private void set項目(SonotaJohoEntity entity) {
        item.set保険者番号(entity.getShoKisaiHokenshaNo());
        item.set被保険者番号(entity.getHihokenshaNo());
        item.set名前(entity.getHihokenshaName().getColumnValue());
        item.set審査会資料作成年(get年(new FlexibleDate(RDate.getNowDate().toDateString())));
        item.set審査会資料作成月(get月(new FlexibleDate(RDate.getNowDate().toDateString())));
        item.set審査会資料作成日(get日(new FlexibleDate(RDate.getNowDate().toDateString())));
        item.set今回認定申請年(get年(entity.getNinteiShinseiYMD()));
        item.set今回認定申請月(get月(entity.getNinteiShinseiYMD()));
        item.set今回認定申請日(get日(entity.getNinteiShinseiYMD()));
        item.set今回認定調査実施年(get年(entity.getNinteichosaJisshiYMD()));
        item.set今回認定調査実施月(get月(entity.getNinteichosaJisshiYMD()));
        item.set今回認定調査実施日(get日(entity.getNinteichosaJisshiYMD()));
        item.set今回認定審査年(get年(entity.getShinsakaiKaisaiYMD()));
        item.set今回認定審査月(get月(entity.getShinsakaiKaisaiYMD()));
        item.set今回認定審査日(get日(entity.getShinsakaiKaisaiYMD()));
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージID, ファイルID_F1401A01_BAK);
            }
        }
        return imagePath;
    }

    private RString 共有ファイル2を引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージID, ファイルID_F1401A02_BAK);
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
    protected void keyBreakProcess(SonotaJohoEntity current) {
        hasBrek(getBefore(), current);
    }

    private boolean hasBrek(SonotaJohoEntity before, SonotaJohoEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        RString id = ReportIdDBE.DBE517006.getReportId().getColumnValue();
        RString idName = ReportIdDBE.DBE517006.getReportName();
        RString 総ページ数 = new RString(batchWriteA3.getPageCount());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                idName,
                総ページ数,
                RString.EMPTY,
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
    }

    private List<RString> 出力条件() {
        List<RString> list = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append("【開始資料番号】")
                .append(" ")
                .append(paramter.getBangoStart());
        RStringBuilder stringBuilder = new RStringBuilder();
        stringBuilder.append("【終了資料番号】")
                .append(" ")
                .append(paramter.getBangoEnd());
        list.add(builder.toRString());
        list.add(stringBuilder.toRString());
        return list;
    }

    private RString get年(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(0, INT_4);
        }
        return RString.EMPTY;
    }

    private RString get月(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(INT_5, INT_7);
        }
        return RString.EMPTY;
    }

    private RString get日(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(INT_8, INT_10);
        }
        return RString.EMPTY;
    }

    private RString パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
