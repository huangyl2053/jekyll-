/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe233001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001.ShujiiIkenTokusokujoHakkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書督促対象者一覧表の作成クラスです。
 */
public class ShujiiIkenTokusokujoHakkoReportProcess extends BatchProcessBase<ShujiiIkenTokusokujoHakkoRelateEntity> {

    public static final RString OUT_DATA_LIST;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe233001."
            + "IDbe233001RelateMapper.select主治医意見書督促対象者一覧表ByKey");

    private static final ReportId REPORT_DBE223002 = new ReportId("DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo");
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter;
    NinteiChosaTokusokuTaishoshaIchiranhyoItem item;
    private List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList;
    private ShujiiIkenTokusokujoHakkoProcessParamter processPrm;

    static {
        OUT_DATA_LIST = new RString("outDataList");
    }
    private OutputParameter<List<NinteiChosaTokusokuTaishoshaIchiranhyoItem>> outDataList;

    @Override
    protected void initialize() {
        itemList = new ArrayList();
        outDataList = new OutputParameter<>();
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toShujiiIkenTokusokujoHakkoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE223002.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(ShujiiIkenTokusokujoHakkoRelateEntity entity) {

        item = new NinteiChosaTokusokuTaishoshaIchiranhyoItem(entity.getTemp_市町村コード() == null ? RString.EMPTY : entity.getTemp_市町村コード()
                .getColumnValue(),
                entity.getTemp_市町村名称(),
                entity.getTemp_保険者番号(),
                entity.getTemp_被保険者番号(),
                entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue(),
                entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue(),
                entity.getTemp_申請日() == null ? RDate.MIN : new RDate(entity.getTemp_申請日().toString()),
                entity.getTemp_督促状発行日() == null ? RDate.MIN : new RDate(entity.getTemp_督促状発行日().toString()),
                // TODO QA639(主治医医療機関情報の取得項目)
                entity.getTemp_事業者コード() == null ? RString.EMPTY : entity.getTemp_事業者コード().getColumnValue(),
                entity.getTemp_事業者名称(),
                entity.getTemp_事業者住所(),
                entity.getTemp_事業者電話番号() == null ? RString.EMPTY : entity.getTemp_事業者電話番号().getColumnValue());
        itemList.add(item);
    }

    @Override
    protected void afterExecute() {
        NinteiChosaTokusokuTaishoshaIchiranhyoReport report = NinteiChosaTokusokuTaishoshaIchiranhyoReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
        outDataList.setValue(itemList);
    }
}
