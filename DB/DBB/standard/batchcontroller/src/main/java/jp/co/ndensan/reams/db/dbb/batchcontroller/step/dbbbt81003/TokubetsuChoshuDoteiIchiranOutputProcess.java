/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt81003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran.TokushoTaishioIchiranEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokubetsuChoshuDoteiIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiIchiranEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokubetsuchoshudoteimidoteiichiransakusei.TokubetsuChoshuDoteiMiDoteiIchiranSakusei;
import jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranPrintService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 特別徴収同定一覧表バッチフロークラスです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
public class TokubetsuChoshuDoteiIchiranOutputProcess extends SimpleBatchProcessBase {

    private TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter parameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200031"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private FileSpoolManager manager;
    private final RString rseId = new RString("DBB200018_TokubetsuChoshuDoteiMiDoteiIchiran");
    private final RString reportName = new RString("特別徴収同定一覧表");
    private final RString csvファイル名 = new RString("TokubetsuChoshuDoteiIchiran.csv");
    private final RString csvOutFlag = new RString("有り");
    private final RString 処理年度 = new RString("【処理年度】");
    private final RString 捕捉月 = new RString("【捕捉月】");
    private final RString 特別徴収開始月 = new RString("【開始月】");
    private final RString 出力対象 = new RString("【出力対象】");
    private static final RString STOP = new RString("、");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString すべて選択 = new RString("すべて選択");
    private static final RString 同定済一覧 = new RString("同定済一覧");
    private static final RString 未同定一覧 = new RString("未同定一覧");
    private static final int NUM_EIGHTEEN = 18;
    private Association 導入団体クラス;
    private RString pageSize;
    @BatchWriter
    private EucCsvWriter<TokubetsuChoshuDoteiIchiranCSVEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        pageSize = ONE;
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
        if (!list.isEmpty()) {
            pageSize = new RString(String.valueOf(Math.ceil(list.size() / NUM_EIGHTEEN)));
        }
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                rseId,
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                reportName,
                pageSize,
                csvOutFlag,
                csvファイル名,
                getOutputJokenhyoParam()
        );
        OutputJokenhyoFactory.createInstance(item)
                .print();
    }

    private List<RString> getOutputJokenhyoParam() {
        List<RString> outputJokenhyo = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(処理年度.concat(parameter.get処理年度().wareki().toDateString()));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(捕捉月);
        for (RString tar : parameter.get捕捉月()) {
            if (!捕捉月.equals(builder.toRString())) {
                builder.append(STOP);
            }
            builder.append(tar);
        }
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(特別徴収開始月.concat(parameter.get特別徴収開始月()));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        if (ZERO.equals(parameter.get出力対象())) {
            builder.append(出力対象.concat(すべて選択));
        } else if (ONE.equals(parameter.get出力対象())) {
            builder.append(出力対象.concat(同定済一覧));
        } else if (TWO.equals(parameter.get出力対象())) {
            builder.append(出力対象.concat(未同定一覧));
        }
        outputJokenhyo.add(builder.toRString());
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
                    entity.getJuminShubetsuCode(),
                    entity.getSeibetsu().value().get性別名称(),
                    entity.getKanaShimei(),
                    RString.EMPTY,
                    entity.getKanjiShimei(),
                    entity.getYubinNo(),
                    entity.getKanjiJusho()
            );
            targets.add(target);
        }
        TokubetsuChoshuDoteiIchiranPrintService printService = new TokubetsuChoshuDoteiIchiranPrintService();
        printService.print(targets, null, null, new ReportManager(), null);
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
