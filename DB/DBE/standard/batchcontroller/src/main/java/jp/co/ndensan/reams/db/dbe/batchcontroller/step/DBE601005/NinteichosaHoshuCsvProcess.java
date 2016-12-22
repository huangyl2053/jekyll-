/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601005;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshushokai.NinteiChosaHoshuShokaiChange;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005.NinteiChosaHoshuShokaiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.IChosaHoshuShokaiCsvEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 認定調査報酬照会csvの作成クラスです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 *
 */
public class NinteichosaHoshuCsvProcess extends BatchProcessBase<NinteiChosaHoshuShokaiRelateEntity> {

    private NinteiChosaHoshuShokaiProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahoshushokai."
            + "INinteiChosaHoshuShokaiRelateMapper.get報酬実績データ情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE606001"));
    private static final RString CSV_NAME = new RString("認定調査報酬一覧表.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 導入団体コード;
    private RString 市町村名;
    @BatchWriter
    private CsvWriter<IChosaHoshuShokaiCsvEucEntity> csvWriter;

    @Override
    protected void initialize() {
    }

    @Override
    protected void process(NinteiChosaHoshuShokaiRelateEntity relateEntity) {
        csvWriter.writeLine(NinteiChosaHoshuShokaiChange.createData(relateEntity));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_NAME);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();
    }

    private void CSVバッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 出力件数 = new RString(csvWriter.getCount());
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 調査依頼日FROM = new RStringBuilder("【調査依頼日（From）】");
        調査依頼日FROM.append(toWareki(parameter.get調査依頼日開始()));
        RStringBuilder 調査依頼日To = new RStringBuilder("【調査依頼日（To）】");
        調査依頼日To.append(toWareki(parameter.get調査依頼日終了()));
        RStringBuilder 保険者_SB = new RStringBuilder(new RString("【保険者】"));
        保険者_SB.append(parameter.get保険者());
        出力条件.add(調査依頼日FROM.toRString());
        出力条件.add(調査依頼日To.toRString());
        出力条件.add(保険者_SB.toRString());
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("認定調査報酬一覧表CSV"), 導入団体コード, 市町村名, ジョブ番号,
                CSV_NAME, EUC_ENTITY_ID.toRString(), 出力件数, 出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        manager.spool(eucFilePath);
        CSVバッチ出力条件リストの出力();
    }

    private RString toWareki(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        return new FlexibleDate(date).wareki().toDateString();
    }
}
