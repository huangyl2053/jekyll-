package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.SinsakaiHanteiJyokyoShinsakaishukeihyoEditor;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo.Shinsakaishukeihyo;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo.ShinsakaishukeihyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo.ShinsakaishukeihyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
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
    private static final RString タイトル = new RString("介護認定審査会集計表（判定別）");
    private static final RString JIGYOJYOKYOHOKOKU = new RString("【事業状況報告出力区分】");
    private static final RString JISSIJYOKYOTOKEI = new RString("【実施状況統計出力区分】");
    private static final RString SINSAHANTEIJYOKYO = new RString("【審査判定状況出力区分】");
    private static final RString SINSAKAIKANRENTOKEI = new RString("【審査会関連統計資料作成出力区分】");
    private static final RString CSVSHUTSURYOKU = new RString("【CSV出力区分】");
    private static final RString SHUTSURYOKUFAIRU = new RString("【出力ファイル名】");
    private static final RString HOKENSYANO = new RString("【保険者番号】");
    private static final RString HIHOKENSYAKUBUN = new RString("【被保険者区分】");
    private static final RString GOGITAINO = new RString("【合議体番号】");
    private static final RString TAISHOTSUKIKUBUN = new RString("【対象月編集区分】");
    private static final RString TAISHOYM = new RString("【対象年月】");
    private static final RString KIJYUNYMD = new RString("【基準年月日】");
    private static final RString TAISHOGEPPIKUBUN = new RString("【対象月日編集区分】");
    private static final RString TAISHOGEPPIFROM = new RString("【対象月日開始】");
    private static final RString TAISHOGEPPITO = new RString("【対象月日終了】");
    private static final RString SINSEIKUBUNSINSEITOKI = new RString("【申請区分(申請時)】");
    private static final RString SINSEIKUBUNHOREI = new RString("【申請区分(法令)】");
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
        outputJokenhyo();
    }

    private List<ShinsakaishukeihyoHanteiBetsuEntity> get集計表(SinsakaiHanteiJyokyoHeaderEntity current) {
        ShinsakaishukeihyoHanteiBetsuMyBatisParameter batisParameter = parameter.toShinsakaishukeihyoHanteiBetsuMyBatisParameter();
        batisParameter.setTaishoGeppiFrom(current.getShinsakaiKaisaiYMDMin());
        batisParameter.setTaishoGeppiTo(current.getShinsakaiKaisaiYMDMax());
        return mapper.getShinsakaishukeihyoHanteiBetsu(batisParameter);
    }

    private void outputJokenhyo() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE701007.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                タイトル,
                new RString(reportSourceWriter.pageCount().value()),
                new RString("無し"),
                new RString("ー"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(JIGYOJYOKYOHOKOKU);
        条件.append(parameter.isJigyoJyokyoHokoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(JISSIJYOKYOTOKEI);
        条件.append(parameter.isJissiJyokyoTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAHANTEIJYOKYO);
        条件.append(parameter.isSinsaHanteiJyokyo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAKAIKANRENTOKEI);
        条件.append(parameter.isSinsakaiKanrenTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(CSVSHUTSURYOKU);
        条件.append(parameter.isCsvShutsuryoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SHUTSURYOKUFAIRU);
        条件.append(parameter.getShutsuryokuFairuName());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HOKENSYANO);
        条件.append(parameter.getHokensyaNo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HIHOKENSYAKUBUN);
        条件.append(parameter.isJigyoJyokyoHokoku() ? RString.EMPTY : HihokenshaKubun.toValue(
                parameter.getHihokenshaKubun()).get名称());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(GOGITAINO);
        条件.append(parameter.isJigyoJyokyoHokoku() ? RString.EMPTY : new RString(parameter.getGogitaiNo()));
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOTSUKIKUBUN);
        条件.append(parameter.isTaishoTsukiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOYM);
        条件.append(!parameter.isTaishoTsukiKubun() ? RString.EMPTY
                : new RYearMonth(parameter.getTaishoNendoYM()).wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(KIJYUNYMD);
        条件.append(parameter.getKijyunYMD() == null ? RString.EMPTY : parameter.getKijyunYMD().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIKUBUN);
        条件.append(parameter.isTaishoGeppiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIFROM);
        条件.append(parameter.isEmptyTaishoGeppiFrom() ? RString.EMPTY
                : new RDate(parameter.getTaishoGeppiFrom().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPITO);
        条件.append(parameter.isEmptyTaishoGeppiTo() ? RString.EMPTY
                : new RDate(parameter.getTaishoGeppiTo().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNSINSEITOKI);
        条件.append(parameter.isShinseiji());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNHOREI);
        条件.append(parameter.isHorei());
        出力条件.add(条件.toRString());
        return 出力条件;
    }

}
