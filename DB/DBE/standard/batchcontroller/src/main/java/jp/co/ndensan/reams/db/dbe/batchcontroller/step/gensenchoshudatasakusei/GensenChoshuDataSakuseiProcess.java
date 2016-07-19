/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.gensenchoshudatasakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gensenchoshudatasakusei.GensenChoshuDataSakuseiChange;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei.GensenChoshuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gensenchoshudatasakusei.GensenChoshuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gensenchoshudatasakusei.IGensenChoshuCsvEucEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 源泉徴収データ作成csvの作成クラスです。
 *
 * @reamsid_L DBE-2000-020 jinjue
 *
 */
public class GensenChoshuDataSakuseiProcess extends BatchProcessBase<GensenChoshuRelateEntity> {
// TODO 「ファイルを操作する時に、下記の異常がFWで自動チェックする」　QA：1413

    private GensenChoshuProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gensenchoshudatasakusei.IGensenChoshuDataSakuseiRelateMapper"
            + ".getデータ情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE631001"));
    private static final RString CSV_NAME = new RString("GensenChoshu.CSV");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString NAME = new RString("源泉徴収データ");
    private static final RString ONE = new RString("1");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 導入団体コード;
    private RString 市町村名;

    @BatchWriter
    private EucCsvWriter<IGensenChoshuCsvEucEntity> eucCsvWriter;

    @Override
    protected void initialize() {
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybitisParamter());
    }

    @Override
    protected void process(GensenChoshuRelateEntity relateEntity) {
        eucCsvWriter.writeLine(GensenChoshuDataSakuseiChange.createData(relateEntity, parameter));
    }

    private void csv出力条件リストの出力() {

        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 出力件数 = new RString(eucCsvWriter.getCount());
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 指定年 = new RStringBuilder("【年】");
        指定年.append(parameter.get指定年());
        出力条件.add(指定年.toRString());
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                NAME, 導入団体コード, 市町村名, ジョブ番号,
                CSV_NAME, EUC_ENTITY_ID.toRString(), 出力件数, 出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    @Override
    protected void createWriter() {

        RString 文字コード = DbBusinessConfig.get(ConfigNameDBE.一次判定IF文字コード, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_NAME);
        if (ONE.equals(文字コード)) {
            eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setEncode(Encode.SJIS)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(true).
                    build();
        } else {
            eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setEncode(Encode.UTF_8withBOM)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(true).
                    build();
        }
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        csv出力条件リストの出力();
    }
}
