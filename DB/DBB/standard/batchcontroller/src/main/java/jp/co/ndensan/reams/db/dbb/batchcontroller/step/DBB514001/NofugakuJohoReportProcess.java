/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB514001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.nofugakudatasakuseitandokushichoson.NofugakuDataOutput;
import jp.co.ndensan.reams.db.dbb.business.core.nofugakudatasakuseitandokushichoson.NofugakuDataPageBreak;
import jp.co.ndensan.reams.db.dbb.business.core.nofugakudatasakuseitandokushichoson.NofugakuJohoCreate;
import jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirancodefumei.NofugakuIchiranCodeFumeiReport;
import jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirandaihyo.NofugakuIchiranSource;
import jp.co.ndensan.reams.db.dbb.business.report.nofugakuichiranshinkokuyo.NofugakuIchiranShinkokuyoReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nofugakudatasakuseitandokushichoson.NofugakuDataMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.nofugakudatasakuseitandokushichoson.NofugakuDataProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.BbKakuteiShinkokuDataCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.DE940110DatEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.DE940200DatEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.DbT2016NofugakuJohoTemp;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.NofugakuJohoReportEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.fld.FldWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 納付額一覧表作成
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
public class NofugakuJohoReportProcess extends BatchProcessBase<NofugakuJohoReportEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".nofugakudatasakuseitandokushichoson.INofugakuDataSakuseiMapper.get納付額一覧表情報");
    private static final ReportId 帳票分類ID = new ReportId("DBB300005_NofugakuIchiranDaihyo");
    private static final RString DE940110_DATファイル名 = new RString("DE940110.DAT");
    private static final RString DE940200_DATファイル名 = new RString("DE940200.DAT");
    private static final RString EUCファイル名 = new RString("BBKAKUTEISHINKOKUDATA.csv");
    private static final RString カンマ = new RString(",");
    private static final RString レコード = new RString("E");
    private static final int INT_1 = 1;
    private static final int INT_5 = 5;

    private RString 出力順;
    private Association 地方公共団体;
    private NofugakuDataProcessParameter parameter;
    private NofugakuJohoCreate create;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private List<RString> breakKeyList;
    private KitsukiList 期月リスト_特徴;
    private KitsukiList 期月リスト_普徴;
    private int 連番;
    private RString filePath;
    private RString filePath_拡張;
    private RString eucFilePath;

    @BatchWriter
    private BatchReportWriter<NofugakuIchiranSource> batchReportWriter_申告用;
    private ReportSourceWriter<NofugakuIchiranSource> reportSourceWriter_申告用;

    @BatchWriter
    private BatchReportWriter<NofugakuIchiranSource> batchReportWriter_不明分;
    private ReportSourceWriter<NofugakuIchiranSource> reportSourceWriter_不明分;

    private FldWriter csvWriter;
    private FldWriter de940110Writer;
    private FldWriter de940200Writer;

    @Override
    protected void initialize() {
        super.initialize();
        create = new NofugakuJohoCreate();
        連番 = 1;
        出力項目リスト = new ArrayList<>();
        改頁項目リスト = new ArrayList<>();
        breakKeyList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        if (!RString.isNullOrEmpty(parameter.get出力順ID())) {
            get出力順(parameter.get出力順ID());
        }

        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();

    }

    @Override
    protected IBatchReader createReader() {
        NofugakuDataMybatisParameter mybaitisParameter = new NofugakuDataMybatisParameter();
        mybaitisParameter.set出力順(出力順);
        return new BatchDbReader(READ_DATA_ID, mybaitisParameter);

    }

    @Override
    protected void createWriter() {
        PageBreaker<NofugakuIchiranSource> breaker = new NofugakuDataPageBreak(breakKeyList);
        batchReportWriter_申告用 = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB300005.getReportId().value())
                .addBreak(breaker).create();
        reportSourceWriter_申告用 = new ReportSourceWriter<>(batchReportWriter_申告用);

        batchReportWriter_不明分 = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB300006.getReportId().value())
                .addBreak(breaker).create();
        reportSourceWriter_不明分 = new ReportSourceWriter<>(batchReportWriter_不明分);
        filePath = Path.combinePath(Path.getTmpDirectoryPath(), DE940110_DATファイル名);
        filePath_拡張 = Path.combinePath(Path.getTmpDirectoryPath(), DE940200_DATファイル名);
        eucFilePath = Path.combinePath(Path.getTmpDirectoryPath(), EUCファイル名);
        csvWriter = new FldWriter.InstanceBuilder(eucFilePath)
                .setEncodeJIS()
                .setNewLine(NewLine.LF)
                .setDelimiter(カンマ)
                .build();
        de940110Writer = new FldWriter.InstanceBuilder(filePath)
                .setEncodeJIS()
                .setNewLine(NewLine.LF)
                .setDelimiter(カンマ)
                .build();
        de940200Writer = new FldWriter.InstanceBuilder(filePath_拡張)
                .setEncodeJIS()
                .setNewLine(NewLine.LF)
                .setDelimiter(カンマ)
                .build();
    }

    @Override
    protected void process(NofugakuJohoReportEntity entity) {
        DbT2016NofugakuJohoTemp 納付額情報 = entity.get納付額情報();
        BbKakuteiShinkokuDataCsvEntity csvEntity = create.setCSV情報(納付額情報,
                parameter,
                連番, 期月リスト_特徴, 期月リスト_普徴);
        csvWriter.writeLine(csvEntity);

        DE940110DatEntity de940110DatEntity = create.setDE940110Dat情報(納付額情報,
                parameter,
                連番, 期月リスト_特徴, 期月リスト_普徴);
        de940110Writer.writeLine(de940110DatEntity);

        DE940200DatEntity de940200DatEntity = create.set940200Dat情報(納付額情報,
                parameter,
                連番, 期月リスト_特徴, 期月リスト_普徴);
        de940200Writer.writeLine(de940200DatEntity);
        NofugakuIchiranShinkokuyoReport report_申告用 = new NofugakuIchiranShinkokuyoReport(地方公共団体.get市町村名(),
                出力項目リスト, 改頁項目リスト, parameter.get対象年(), 納付額情報, entity.get宛名());
        report_申告用.writeBy(reportSourceWriter_申告用);
        NofugakuIchiranCodeFumeiReport report_不明分 = new NofugakuIchiranCodeFumeiReport(地方公共団体.get市町村名(),
                改頁項目リスト, parameter.get対象年(), 納付額情報, entity.get宛名());
        report_不明分.writeBy(reportSourceWriter_不明分);
        連番 = 連番 + 1;
    }

    @Override
    protected void afterExecute() {
        BbKakuteiShinkokuDataCsvEntity csvEntity = new BbKakuteiShinkokuDataCsvEntity();
        csvEntity.set最終レコード区分(レコード);
        csvWriter.writeLine(csvEntity);
        csvWriter.close();

        DE940110DatEntity de940110DatEntity = new DE940110DatEntity();
        de940110DatEntity.set最終レコード区分(レコード);
        de940110Writer.writeLine(de940110DatEntity);
        de940110Writer.close();

        DE940200DatEntity de940200DatEntity = new DE940200DatEntity();
        de940200DatEntity.set最終レコード区分(レコード);
        de940200Writer.writeLine(de940200DatEntity);
        de940200Writer.close();
    }

    private void get出力順(RString 出力順ID) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順ID.toString()));
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        出力順 = MyBatisOrderByClauseCreator.create(NofugakuDataOutput.BreakerFieldsEnum.class,
                outputOrder);
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力項目リスト.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改頁項目リスト.add(setSortItem.get項目名());
                    breakKeyList.add(setSortItem.get項目ID());
                }
            }
            i = i + INT_1;
        }
    }

}
