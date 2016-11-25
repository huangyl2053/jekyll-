package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.SinsakaiHanteiJyokyoShinsakaishukeihyoEditor;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo.Shinsakaishukeihyo;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo.ShinsakaishukeihyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo.ShinsakaishukeihyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（判定別）の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsakaishukeihyoHanteiBetsuProcess extends BatchProcessBase<SinsakaiHanteiJyokyoHeaderEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getShinsakaishukeihyoHanteiBetsuHeader");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinsakaishukeihyoReportSource.ReportSourceFields.shichosonNo.name())));
    private ShinsakaishukeihyoHanteiBetsuProcessParameter parameter;
    private IHokokuShiryoSakuSeiMapper mapper;
    private Shinsakaishukeihyo shinsakaishukeihyo;

    @BatchWriter
    private BatchReportWriter<ShinsakaishukeihyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaishukeihyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        shinsakaishukeihyo = new Shinsakaishukeihyo();
        mapper = getMapper(IHokokuShiryoSakuSeiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HEADER, parameter.toShinsakaishukeihyoHanteiBetsuMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701007.getReportId().value())
                .addBreak(new BreakerCatalog<ShinsakaishukeihyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(SinsakaiHanteiJyokyoHeaderEntity current) {
        new SinsakaiHanteiJyokyoShinsakaishukeihyoEditor(parameter, current, shinsakaishukeihyo)
                .set介護認定審査会集計表判定別(get集計表(current));
        ShinsakaishukeihyoReport report = new ShinsakaishukeihyoReport(shinsakaishukeihyo);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
    }

    private List<ShinsakaishukeihyoHanteiBetsuEntity> get集計表(SinsakaiHanteiJyokyoHeaderEntity current) {
        ShinsakaishukeihyoHanteiBetsuMyBatisParameter batisParameter = parameter.toShinsakaishukeihyoHanteiBetsuMyBatisParameter();
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        return mapper.getShinsakaishukeihyoHanteiBetsu(batisParameter);
    }

}
