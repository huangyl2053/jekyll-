/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc040040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanData;
import jp.co.ndensan.reams.db.dbc.business.euc.gassanjikofutangakushomeishohakkoichiran.GassanJikofutangakushomeishoHakkoIchiranCsvEntityEditor;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakuhakkoichiran.GassanJikofutangakuHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho.JikoFutangakushomeishoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho.JikoFutangakushomeishoShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040040.JikofutanShomeishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc040040.GassanJikofutangakushomeishoHakkoIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040.JikoFutangakushomeishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjikofutangakuhakkoichiran.GassanJikofutangakuHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 高額合算自己負担額証明書発行一覧表のprocessクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
public class JikoFutangakushomeishoCsvOutputProcess extends BatchKeyBreakBase<JikoFutangakushomeishoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040040."
                    + "IJikofutanShomeishoMapper.select自己負担額証明書");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701009");
    private final RString csvFileName = new RString("GassanJikofutangakushomeishoHakkoIchiran.csv");
    private static final RString 定数_ORDERBY = new RString("order by");

    private int 連番;
    private IOutputOrder 出力順;
    private List<RString> pageBreakKeys;
    private JikofutanShomeishoProcessParameter parameter;
    private RString eucFilePath;
    FileSpoolManager spoolManager;
    @BatchWriter
    private CsvWriter<GassanJikofutangakushomeishoHakkoIchiranCsvEntity> csvWriter;
    @BatchWriter
    private BatchReportWriter<GassanJikofutangakuHakkoIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanJikofutangakuHakkoIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        連番 = 0;
        pageBreakKeys = new ArrayList<>();
        if (parameter.get出力順ID() != 0L) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC200035.getReportId(), parameter.get出力順ID());
            if (出力順 != null) {
                parameter.set出力順(MyBatisOrderByClauseCreator.create(
                        JikoFutangakushomeishoShutsuryokujunEnum.class, 出力順).replace(定数_ORDERBY, RString.EMPTY));
                setPageBreakKeys();
            }
        } else {
            parameter.set出力順(null);
        }

    }

    private void setPageBreakKeys() {
        for (ISetSortItem item : 出力順.get設定項目リスト()) {
            if (item.is改頁項目()) {
                pageBreakKeys.add(item.get項目ID());
            }
        }
    }

    @Override
    protected void createWriter() {
        PageBreaker<GassanJikofutangakuHakkoIchiranSource> breaker = new JikoFutangakushomeishoPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200035.getReportId().value()).
                addBreak(breaker).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(),
                csvFileName);
        csvWriter = BatchWriters.csvWriter(GassanJikofutangakushomeishoHakkoIchiranCsvEntity.class).
                filePath(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void keyBreakProcess(JikoFutangakushomeishoEntity entity) {
        if (isBreak(entity)) {
            連番++;
            GassanJikofutangakushomeishoHakkoIchiranCsvEntityEditor editor = new GassanJikofutangakushomeishoHakkoIchiranCsvEntityEditor(
                    getBefore(), RDate.getNowDateTime(), 連番);
            csvWriter.writeLine(editor.edit());
            KogakuGassanData 高額合算データ = getKogakuGassanData(getBefore());
            GassanJikofutangakuHakkoIchiranReport report = new GassanJikofutangakuHakkoIchiranReport(高額合算データ, 出力順, 連番);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void usualProcess(JikoFutangakushomeishoEntity entity) {

    }

    private KogakuGassanData getKogakuGassanData(JikoFutangakushomeishoEntity entity) {
        KogakuGassanData 高額合算データ = new KogakuGassanData();
        高額合算データ.set被保険者番号(entity.get高額合算一時().getHihokenshaNo());
        高額合算データ.set対象年度(entity.get高額合算一時().getTaishoNendo());
        高額合算データ.set保険者番号(new LasdecCode(entity.get高額合算一時().getHokenshaNo().getColumnValue()));
        高額合算データ.set保険者名(entity.get高額合算一時().getJikoFutanGaku_HokenshaMei());
        高額合算データ.set支給申請書整理番号(entity.get高額合算一時().getShikyuShinseishoSeiriNo());
        高額合算データ.set対象計算期間開始年月日(entity.get高額合算一時().getTaishoKeisanKaishiYMD());
        高額合算データ.set対象計算期間終了年月日(entity.get高額合算一時().getTaishoKeisanShuryoYMD());
        高額合算データ.set被保険者氏名カナ(entity.get高額合算一時().getAtena_HihokenshaKanaShimei());
        高額合算データ.set被保険者氏名(entity.get高額合算一時().getAtena_HihokenshaShimei());
        高額合算データ.set生年月日(entity.get高額合算一時().getAtena_SeinengappiYMD());
        高額合算データ.set性別(Gender.toValue(entity.get高額合算一時().getAtena_Seibetsu()));
        高額合算データ.set自己負担額証明書整理番号(entity.get高額合算一時().getJikoFutanGaku_JikoFutanSeiriNo());
        高額合算データ.set被保険者期間開始年月日(entity.get高額合算一時().getJikoFutanGaku_HihokenshaKaishiYMD());
        高額合算データ.set被保険者期間終了年月日(entity.get高額合算一時().getJikoFutanGaku_HihokenshaShuryoYMD());
        高額合算データ.set合計_自己負担額(entity.get高額合算一時().getJikoFutanGaku_Gokei_JikoFutanGaku());
        高額合算データ.set合計_70_74自己負担額_内訳(entity.get高額合算一時().getJikoFutanGaku_Gokei_70_74JikoFutanGaku());
        高額合算データ.set補正済_合計_自己負担額(entity.get高額合算一時().getJikoFutanGaku_Sumi_Gokei_JikoFutanGaku());
        高額合算データ.set補正済_合計_70_74自己負担額_内訳(entity.get高額合算一時().getJikoFutanGaku_Sumi_Gokei_70_74JikoFutanGaku());
        高額合算データ.set識別コード(entity.get高額合算一時().getShikibetsuCode());
        return 高額合算データ;
    }

    private boolean isBreak(JikoFutangakushomeishoEntity currentEntity) {
        JikoFutangakushomeishoEntity beforeEntity = getBefore();
        return !beforeEntity.get高額合算自己負担額明細().getHihokenshaNo().equals(currentEntity.get高額合算自己負担額明細().getHihokenshaNo())
                || !beforeEntity.get高額合算自己負担額明細().getTaishoNendo().equals(currentEntity.get高額合算自己負担額明細().getTaishoNendo())
                || !beforeEntity.get高額合算自己負担額明細().getHokenshaNo().equals(currentEntity.get高額合算自己負担額明細().getHokenshaNo())
                || !beforeEntity.get高額合算自己負担額明細().getShikyuShinseishoSeiriNo().
                equals(currentEntity.get高額合算自己負担額明細().getShikyuShinseishoSeiriNo());
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            連番++;
            GassanJikofutangakushomeishoHakkoIchiranCsvEntityEditor editor = new GassanJikofutangakushomeishoHakkoIchiranCsvEntityEditor(
                    getBefore(), RDate.getNowDateTime(), 連番);
            csvWriter.writeLine(editor.edit());
            KogakuGassanData 高額合算データ = getKogakuGassanData(getBefore());
            GassanJikofutangakuHakkoIchiranReport report = new GassanJikofutangakuHakkoIchiranReport(高額合算データ, 出力順, 連番);
            report.writeBy(reportSourceWriter);
        }
        csvWriter.close();
        spoolManager.spool(eucFilePath);
    }

}
