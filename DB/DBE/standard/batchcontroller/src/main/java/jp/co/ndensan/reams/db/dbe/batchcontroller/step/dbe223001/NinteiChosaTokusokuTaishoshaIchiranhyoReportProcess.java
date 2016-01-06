/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.DbeMapperInterfaces;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 処理詳細_認定調査督促対象者一覧表の作成クラスです。
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess extends BatchProcessBase<NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity> {
    
   /**
     * OutputParameter用キー outDataList
     */
    public static final RString OUT_DATA_LIST;
    private NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter parameter;
    
    private static final ReportId REPORT_DBE223001 = new ReportId("DBE223002_NinteiChosaTokusokuTaishoshaIchiranhyo");
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource> reportSourceWriter;
    private int 帳票データの行番号 = 1;
    
    
    NinteiChosaTokusokuTaishoshaIchiranhyoItem item;
    private List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList;
    
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
        return new BatchDbReader(DbeMapperInterfaces.認定調査督促対象者一覧表データの抽出.getFullPath(), 
                parameter.toNinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter());
    }
    
    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE223001.value()).
                 addBreak(new BreakerCatalog<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource>().simplePageBreaker(parameter.getTemp_改頁()))
                 .create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity entity) {
        
        item =  new NinteiChosaTokusokuTaishoshaIchiranhyoItem(
                entity.getTemp_市町村コード() == null ? RString.EMPTY : entity.getTemp_市町村コード().getColumnValue(),  //cityCode
                entity.getTemp_市町村名称(),  //cityName
                new RString("調査機関名称"),  //kikanNameTitle
                new RString("調査機関住所"),  //kikanJushoTitle
                new RString("調査員氏名"),  // nameTitle
                new RString("調査機関TEL"),  //kikanTelTitle
                new RString(String.valueOf(帳票データの行番号++)),  //listNo_1
                parameter.getTemp_保険者名称(),  //listUpper1_1 TODO QA N0.22
                entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY
                        : entity.getTemp_被保険者氏名カナ().getColumnValue(),  //listUpper1_2
                entity.getTemp_申請日() == null ? RString.EMPTY :  entity.getTemp_申請日().
                        wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString(),  // listShinseiYMD_1
                entity.getTemp_督促状発行日() == null ? RString.EMPTY : entity.getTemp_督促状発行日().
                        wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString(),  // listTokusokujoHakkoYMD_1
                entity.getTemp_事業者コード() == null ? RString.EMPTY 
                        : entity.getTemp_事業者コード().getColumnValue(),  //listUpper2_1 TODO  QA  帳票レイアウトに当該項目が存在しない
                entity.getTemp_事業者住所(),  // listUpper2_2
                entity.getTemp_被保険者番号(),  //listLower1_1
                entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue(),  //listLower1_2
                entity.getTemp_事業者名称(),  //listLower2_1 
                entity.getTemp_事業者電話番号() == null ? RString.EMPTY : entity.getTemp_事業者電話番号().getColumnValue()  //listLower2_2
        );
        itemList.add(item);
    }
    
    @Override
    protected void afterExecute() {
        NinteiChosaTokusokuTaishoshaIchiranhyoReport report = NinteiChosaTokusokuTaishoshaIchiranhyoReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
        outDataList.setValue(itemList);
    }
}
