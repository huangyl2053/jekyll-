/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.business.core.renkeidatatorikomi.RenkeiDataTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.renkeidatatorikomi.RenkeiDataTorikomiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101ErrorTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi.DbT5101ErrorTempEUCEntity;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 要介護認定申請情報エラー一時テーブルより、CSVファイルを出力_バッチフ処理クラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class DbT5101DensanErrorTempOutputProcess extends BatchProcessBase<DbT5101ErrorTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.renkeidatatorikomi.IDbT5101TempMapper.get申請エラー一時テーブル");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE192002");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RenkeiDataTorikomiProcessParamter processParamter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private EucCsvWriter<DbT5101ErrorTempEUCEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("NinteiShinseiJohoErrList.CSV"));
    }

    @Override
    protected void createWriter() {
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(getEncode()).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(DbT5101ErrorTempEntity entity) {
        eucCsvWriter.writeLine(new RenkeiDataTorikomiBusiness().setDbT5101ErrorTempEUCEntity(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("認定申請情報エラーリスト.CSV"),
                new RString("NinteiShinseiJohoErrList.CSV"),
                new RenkeiDataTorikomiBusiness().get出力件数(new Decimal(eucCsvWriter.getCount())),
                new RenkeiDataTorikomiBusiness().get出力条件(processParamter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private Encode getEncode() {
        RString 文字コード = DbBusinessConfig.get(ConfigNameDBE.連携文字コード, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        Encode encode = Encode.UTF_8withBOM;
        if (new RString("1").equals(文字コード)) {
            encode = Encode.UTF_8withBOM;
        } else if (new RString("2").equals(文字コード)) {
            encode = Encode.SJIS;
        }
        return encode;
    }
}
