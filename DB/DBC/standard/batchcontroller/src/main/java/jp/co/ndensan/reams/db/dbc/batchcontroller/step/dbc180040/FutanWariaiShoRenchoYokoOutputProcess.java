/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami.FutanWariaiShoKattokamiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami.FutanWariaiShoOutputJokenhyo;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaishorenchoyoko.FutanWariaiShoRenchoYokoReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaishohakko.FutanwariaishoHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko.RiyoshaFutanwariaishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishorenchoyoko.FutanWariaiShoRenchoYokoSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko.IFutanwariaishoHakkoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariaishoikkatsu.FutanWariaishoIkkatsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100067_負担割合証（連帳・横）のProcessクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public class FutanWariaiShoRenchoYokoOutputProcess extends BatchProcessBase<RiyoshaFutanwariaishoTempEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko."
                    + "IFutanwariaishoHakkoMapper.select利用者負担割合証Temp");
    private FutanwariaishoHakkoProcessParameter parameter;
    private FutanWariaishoIkkatsu service;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private IFutanwariaishoHakkoMapper mapper;
    private int 連番;
    private IOutputOrder 出力順;
    private RString csv出力Flag;
    private RString csvファイル名;
    List<RString> 出力順BODY;
    @BatchWriter
    private BatchReportWriter<FutanWariaiShoRenchoYokoSource> batchReportWriter;
    private ReportSourceWriter<FutanWariaiShoRenchoYokoSource> reportSourceWriter;

    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_なし = new RString("なし");
    private static final RString 定数_あり = new RString("あり");
    private static final RString CONNECTOR = new RString("-");
    private static final RString 定数_負担割合証発行一覧 = new RString("負担割合証発行一覧");
    private static final RString 定数_負担割合証発行一括 = new RString("負担割合証発行（一括）");
    private static final RString 代行プリント送付票 = new RString("URU000A10_DaikoPrintCheck");
    private static final RString 定数_利用者負担割合証 = new RString("利用者負担割合証");
    private static final RString 定数_交付年月日 = new RString("【交付年月日】　　");

    @Override
    protected void initialize() {
        連番 = 1;
        csv出力Flag = 定数_なし;
        csvファイル名 = CONNECTOR;
        service = new FutanWariaishoIkkatsu();
        mapper = getMapper(IFutanwariaishoHakkoMapper.class);
        FutanwariaishoHakkoMybatisParameter param = parameter.toMybatisParameter();
        param.setサブ業務コード(SubGyomuCode.DBC介護給付.getColumnValue());
        param.set帳票分類ID(ReportIdDBC.DBC100065.getReportId().getColumnValue());
        帳票制御共通 = new ChohyoSeigyoKyotsu(mapper.select帳票制御共通(param));
        出力順BODY = new ArrayList<>();
        if (!RString.isNullOrEmpty(parameter.get出力順()) && !定数_0.equals(parameter.get出力順())) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100065.getReportId(), Long.valueOf(parameter.get出力順().toString()));
            if (出力順 != null) {
                parameter.set出力順(MyBatisOrderByClauseCreator.create(
                        FutanWariaiShoKattokamiProperty.DBB100065ShutsuryokujunEnum.class, 出力順));
                List<ISetSortItem> items = 出力順.get設定項目リスト();
                for (int i = 0; i < items.size(); i++) {
                    出力順BODY.add(items.get(i).get項目名());
                }
            } else {
                parameter.set出力順(null);
            }

        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100067.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(RiyoshaFutanwariaishoTempEntity entity) {
        csv出力Flag = 定数_あり;
        csvファイル名 = 定数_負担割合証発行一覧;
        FutanWariaiShoKattokamiEntity futanWariaiShoEntity = service.getFutanWariaiSourceData(帳票制御共通, batchReportWriter.getImageFolderPath(),
                entity, parameter.get交付年月日(), new RString(連番));
        FutanWariaiShoRenchoYokoReport report = new FutanWariaiShoRenchoYokoReport(futanWariaiShoEntity);
        report.writeBy(reportSourceWriter);
        連番++;
    }

    @Override
    protected void afterExecute() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        FutanWariaiShoOutputJokenhyo output = new FutanWariaiShoOutputJokenhyo(parameter, 出力順);
        List<RString> outputJokenhyoList = output.getOutputJokenhyoParam();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC100067.getReportId().getColumnValue(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC100067.getReportName(),
                new RString(reportSourceWriter.getPageGroupCount()),
                csv出力Flag,
                csvファイル名,
                outputJokenhyoList
        );
        OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem)
                .print();
        if (帳票制御共通.is代行プリント有無() && 定数_0.equals(parameter.get出力対象()) && 定数_あり.equals(csv出力Flag)) {
            List<RString> 帳票名 = new ArrayList<>();
            帳票名.add(定数_利用者負担割合証);
            List<Decimal> ページ数 = new ArrayList<>();
            ページ数.add(new Decimal(reportSourceWriter.getPageGroupCount()));
            List<RString> 改頁条件 = new ArrayList<>();
            List<RString> 詳細設定 = new ArrayList<>();
            詳細設定.add(定数_交付年月日.concat(parameter.get交付年月日().wareki().toDateString()));
            List<RString> 抽出条件 = output.getDaikoParam();
            DaikoPrintItem daikoPrintItem = new DaikoPrintItem(
                    SubGyomuCode.DBB介護賦課,
                    導入団体クラス.getLasdecCode_(),
                    導入団体クラス.get市町村名(),
                    new RString(String.valueOf(JobContextHolder.getJobId())),
                    定数_負担割合証発行一括,
                    代行プリント送付票,
                    帳票名,
                    ページ数,
                    抽出条件,
                    出力順BODY,
                    改頁条件,
                    詳細設定);
            DaikoPrintFactory.createInstance(daikoPrintItem).print();
        }
    }

}
