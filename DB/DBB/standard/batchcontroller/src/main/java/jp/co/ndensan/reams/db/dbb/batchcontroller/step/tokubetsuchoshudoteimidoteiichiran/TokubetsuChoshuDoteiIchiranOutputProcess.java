/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokubetsuchoshudoteimidoteiichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran.TokushoTaishioIchiranEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokubetsuChoshuDoteiIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.tokubetsuchoshudoteimidoteiichiransakusei.TokubetsuChoshuDoteiMiDoteiIchiranSakusei;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 特別徴収同定一覧表バッチフロークラスです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
public class TokubetsuChoshuDoteiIchiranOutputProcess extends SimpleBatchProcessBase {

    private TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter parameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("TokubetsuChoshuDoteiIchiran"));
    private final ReportId reportId = new ReportId("DBB200031_TokubetsuChoshuDoteiIchiran");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private FileSpoolManager manager;
    private final RString reportName = new RString("特別徴収同定一覧表");
    private final RString csvファイル名 = new RString("TokubetsuChoshuDoteiIchiran.csv");
    private final RString csvOutFlag = new RString("有り");
    private final RString 処理年度 = new RString("【処理年度】");
    private final RString 捕捉月 = new RString("【捕捉月】");
    private final RString 特別徴収開始月 = new RString("【特別徴収開始月】");
    private final RString 出力対象 = new RString("【出力対象】");
    private static final RString STOP = new RString("、");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString すべて選択 = new RString("すべて選択");
    private static final RString 同定済一覧 = new RString("同定済一覧");
    private static final RString 未同定一覧 = new RString("未同定一覧");
    private Association 導入団体クラス;
    @BatchWriter
    private EucCsvWriter<TokubetsuChoshuDoteiIchiranCSVEntity> eucCsvWriter;
    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuDoteiIchiranSource> batchReportWriter;
    private ReportSourceWriter<TokubetsuChoshuDoteiIchiranSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId.getColumnValue()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), csvファイル名);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process() {
        導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        TokubetsuChoshuDoteiMiDoteiIchiranSakusei service = new TokubetsuChoshuDoteiMiDoteiIchiranSakusei();
        List<TokubetsuChoshuDoteiIchiranEntity> list
                = service.getTokuchoTaishoListJoho(parameter.get処理年度().toDateString(), parameter.get特別徴収開始月(), parameter.get捕捉月());
        outputCsv(list);
        outputTyouhyou(list);
    }

    @Override
    protected void afterExecute() {
        batchReportWriter.close();
        eucCsvWriter.close();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                reportId.value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                reportName,
                new RString(reportSourceWriter.getPageGroupCount()),
                csvOutFlag,
                csvファイル名,
                getOutputJokenhyoParam()
        );
        OutputJokenhyoFactory.createInstance(item)
                .print();
    }

    private List<RString> getOutputJokenhyoParam() {
        List<RString> outputJokenhyo = new ArrayList<>();
        outputJokenhyo.add(処理年度.concat(parameter.get処理年度().wareki().toDateString()));
        RString temp = RString.EMPTY;
        if (!parameter.get捕捉月().isEmpty()) {
            for (RString tar : parameter.get捕捉月()) {
                if (RString.isNullOrEmpty(temp)) {
                    temp = temp.concat(捕捉月);
                } else {
                    temp = temp.concat(STOP);
                }
                temp = temp.concat(tar);
            }
        }
        if (RString.isNullOrEmpty(temp)) {
            outputJokenhyo.add(temp);
        }
        if (RString.isNullOrEmpty(parameter.get特別徴収開始月())) {
            outputJokenhyo.add(特別徴収開始月.concat(parameter.get特別徴収開始月()));
        }
        if (ZERO.equals(parameter.get出力対象())) {
            outputJokenhyo.add(出力対象.concat(すべて選択));
        } else if (ONE.equals(parameter.get出力対象())) {
            outputJokenhyo.add(出力対象.concat(同定済一覧));
        } else if (TWO.equals(parameter.get出力対象())) {
            outputJokenhyo.add(出力対象.concat(未同定一覧));
        }
        return outputJokenhyo;
    }

    private void outputTyouhyou(List<TokubetsuChoshuDoteiIchiranEntity> list) {
        List<TokushoTaishioIchiranEntity> targets = new ArrayList<>();
        for (TokubetsuChoshuDoteiIchiranEntity entity : list) {
            TokushoTaishioIchiranEntity target = new TokushoTaishioIchiranEntity(
                    entity.getHihokenshaNo(),
                    entity.getKisoNenkinNo(),
                    entity.getNenkinCode(),
                    entity.getShikibetsuCode(),
                    entity.getSetaiCode().getColumnValue(),
                    entity.getGyoseikuCode().getColumnValue(),
                    new RDate(entity.getBirthDay().toString()),
                    RString.EMPTY,
                    entity.getSeibetsu().value().get性別名称(),
                    entity.getKanaShimei(),
                    RString.EMPTY,
                    entity.getKanjiShimei(),
                    entity.getYubinNo(),
                    entity.getKanjiJusho()
            );
            targets.add(target);
        }
        TokubetsuChoshuDoteiIchiranReport report = new TokubetsuChoshuDoteiIchiranReport(導入団体クラス,
                targets);
        report.writeBy(reportSourceWriter);
    }

    private void outputCsv(List<TokubetsuChoshuDoteiIchiranEntity> list) {
        for (TokubetsuChoshuDoteiIchiranEntity entity : list) {
            eucCsvWriter.writeLine(new TokubetsuChoshuDoteiIchiranCSVEntity(
                    entity.getHihokenshaNo(),
                    entity.getKisoNenkinNo(),
                    entity.getNenkinCode(),
                    entity.getShikibetsuCode().getColumnValue(),
                    entity.getSetaiCode().getColumnValue(),
                    entity.getGyoseikuCode().getColumnValue(),
                    entity.getBirthDay(),
                    entity.getSeibetsu().value().get性別名称(),
                    entity.getKanaShimei(),
                    RString.EMPTY,
                    entity.getKanjiShimei(),
                    entity.getYubinNo(),
                    entity.getKanjiJusho()
            ));
        }
    }

}
