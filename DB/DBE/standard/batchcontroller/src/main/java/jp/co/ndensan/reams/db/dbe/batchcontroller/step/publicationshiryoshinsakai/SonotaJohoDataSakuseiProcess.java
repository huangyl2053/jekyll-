/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei.IinSonotashiryoSakuseiA3Report;
import jp.co.ndensan.reams.db.dbe.business.report.iinsonotashiryosakusei.IinSonotashiryoSakuseiA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.publicationshiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iinsonotashiryosakusei.IinSonotashiryoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.SonotaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinsonotashiryosakusei.SonotashiryoA4ReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用その他資料情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class SonotaJohoDataSakuseiProcess extends BatchKeyBreakBase<SonotaJohoEntity> {

    private static final RString SELECT_TSONOTAJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.publicationshiryoshinsakai.IShiryoShinsakaiIinMapper.getSonotaJoho");
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    @BatchWriter
    private BatchReportWriter<SonotashiryoA4ReportSource> batchWriteA4;
    private ReportSourceWriter<SonotashiryoA4ReportSource> reportSourceWriterA4;
    @BatchWriter
    private BatchReportWriter<SonotashiryoA3ReportSource> batchWriteA3;
    private ReportSourceWriter<SonotashiryoA3ReportSource> reportSourceWriterA3;
    private final RString 出力スタイル_A4 = new RString("1");
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_10 = 10;
    private int 総ページ数 = 0;

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
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                entity.getShinseishoKanriNo().getColumnValue()));
        AccessLogger.log(AccessLogType.照会, personalData);
        IinSonotashiryoSakuseiEntity item = new IinSonotashiryoSakuseiEntity();
        set項目(item, entity);
        if (出力スタイル_A4.equals(paramter.getShuturyokuSutairu())) {
            // TODO QA回答まち、ファイル名が無し。
//            item.setその他資料(共有ファイルを引き出す(entity.getImageSharedFileId(), 出力スタイル_A4));
            IinSonotashiryoSakuseiA4Report reportA4 = new IinSonotashiryoSakuseiA4Report(item);
            reportA4.writeBy(reportSourceWriterA4);
        } else {
            // TODO QA回答まち、ファイル名が無し。
//            item.set左のその他資料イメージ(共有ファイルを引き出す(entity.getImageSharedFileId(), RString.EMPTY));
//            item.set右のその他資料イメージ(共有ファイルを引き出す(entity.getImageSharedFileId(), RString.EMPTY));
            IinSonotashiryoSakuseiA3Report reportA3 = new IinSonotashiryoSakuseiA3Report(item);
            reportA3.writeBy(reportSourceWriterA3);
        }
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517016.getReportId().value()).create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517006.getReportId().value()).create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
    }

    private void set項目(IinSonotashiryoSakuseiEntity item, SonotaJohoEntity entity) {
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
    protected void keyBreakProcess(SonotaJohoEntity current) {
        if (hasBrek(getBefore(), current)) {
            総ページ数 = 総ページ数 + 1;
        }
    }

    private boolean hasBrek(SonotaJohoEntity before, SonotaJohoEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        RString id;
        RString idName;
        if (出力スタイル_A4.equals(paramter.getShuturyokuSutairu())) {
            id = ReportIdDBE.DBE517016.getReportId().getColumnValue();
            idName = ReportIdDBE.DBE517016.getReportName();
        } else {
            id = ReportIdDBE.DBE517006.getReportId().getColumnValue();
            idName = ReportIdDBE.DBE517006.getReportName();
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                idName,
                new RString(総ページ数),
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(item).print();
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
            return パターン12(年月日).substring(2, INT_4);
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
