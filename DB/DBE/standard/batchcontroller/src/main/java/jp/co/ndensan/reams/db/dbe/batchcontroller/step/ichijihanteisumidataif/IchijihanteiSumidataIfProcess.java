/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif;

import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteisumidataif.IchijihanteiSumidataIfBunisess;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteisumidataif.IchijihanteiSumidataIferaBunisess;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijihanteisumidataif.IchijihanteiSumidataIftProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIferaEucEntity;
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
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 一次判定データ出力Processです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
public class IchijihanteiSumidataIfProcess extends BatchProcessBase<IchijihanteiSumidataIDataShutsuryokuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteisumidataif."
            + "IchijihanteiSumidataIDataShutsuryokuMapper.get一次判定結果票");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE309003"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private IchijihanteiSumidataIftProcessParamter paramter;
    private IchijihanteiSumidataIfBunisess bunisess;
    private IchijihanteiSumidataIferaBunisess eraBunisess;
    private RString koroshoIfShikibetsuCode = RString.EMPTY;
    private RString ファイル名;
    private final RString ファイル09B = new RString("09B");
    private final RString ファイル09AB = new RString("09A");
    private final RString ファイル09Bエラ = new RString("IchijiHanteiErr_09B.CSV");
    private final RString ファイル09Aエラ = new RString("IchijiHanteiErr_09A.CSV");

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        bunisess = new IchijihanteiSumidataIfBunisess();
        eraBunisess = new IchijihanteiSumidataIferaBunisess();
        ファイル名 = new RString("111.csv");
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        paramter.set仮一次判定区分(false);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toIchijihanteiSumidataIftMybitisParamter());
    }
    @BatchWriter
    private CsvWriter<IchijihanteiSumidataEucEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void createWriter() {
        eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(getEncode()).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();

    }

    @Override
    protected void process(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        if (ファイル09B.equals(entity.get厚労省IF識別コード())) {
//            RString エラーデータ09B = eraBunisess.setエラーデータ09B(entity);
//            if (!RString.isNullOrEmpty(エラーデータ09B)) {
//                getファイル名エラ(entity);
//                IchijihanteiSumidataIferaEucEntity eraEucEntity = new IchijihanteiSumidataIferaEucEntity();
//                eraEucEntity.set保険者番号(entity.get保険者番号());
//                eraEucEntity.set被保険者番号(entity.get被保険者番号());
//                eraEucEntity.setエラー項目(エラーデータ09B);
//                eucCsvWriterJunitoJugo.writeLine(eraEucEntity);
//                return;
//            }
            getファイル名(entity);
            eucCsvWriterJunitoJugo.writeLine(bunisess.set一次判定済データ09B(entity));
        }
        if (ファイル09AB.equals(entity.get厚労省IF識別コード())) {
            RString エラーデータ09A = eraBunisess.setエラーデータ09A(entity);
            if (!RString.isNullOrEmpty(エラーデータ09A)) {
                getファイル名エラ(entity);
                IchijihanteiSumidataIferaEucEntity eraEucEntity = new IchijihanteiSumidataIferaEucEntity();
                eraEucEntity.set保険者番号(entity.get保険者番号());
                eraEucEntity.set被保険者番号(entity.get被保険者番号());
                eraEucEntity.setエラー項目(エラーデータ09A);
                eucCsvWriterJunitoJugo.writeLine(eraEucEntity);
                return;
            }
            getファイル名(entity);
            eucCsvWriterJunitoJugo.writeLine(bunisess.set一次判定済データ09A(entity));
        }
        bunisess.getアクセスログ(entity.get被保険者番号());
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterJunitoJugo.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
    }

    private void getファイル名(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        if (RString.isNullOrEmpty(koroshoIfShikibetsuCode)) {
            koroshoIfShikibetsuCode = entity.get厚労省IF識別コード();
            ファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会資料作成用データ送信ファイル名09B, RDate.getNowDate());
            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        }
        if (!koroshoIfShikibetsuCode.equals(entity.get厚労省IF識別コード())) {
            eucCsvWriterJunitoJugo.close();
            koroshoIfShikibetsuCode = entity.get厚労省IF識別コード();
            ファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会資料作成用データ送信ファイル名09A, RDate.getNowDate());
            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        }
        RString 一次判定IF文字コード = DbBusinessConfig.get(ConfigNameDBE.一次判定IF文字コード, RDate.getNowDate());
        if (new RString("1").equals(一次判定IF文字コード)) {
            eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.SJIS).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        } else if (new RString("2").equals(一次判定IF文字コード)) {
            eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        }
    }

    private void getファイル名エラ(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        if (RString.isNullOrEmpty(koroshoIfShikibetsuCode)) {
            koroshoIfShikibetsuCode = entity.get厚労省IF識別コード();
            ファイル名 = ファイル09Aエラ;

            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        }
        if (!koroshoIfShikibetsuCode.equals(entity.get厚労省IF識別コード())) {
            eucCsvWriterJunitoJugo.close();
            koroshoIfShikibetsuCode = entity.get厚労省IF識別コード();
            ファイル名 = ファイル09Bエラ;
            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        }
        RString 一次判定IF文字コード = DbBusinessConfig.get(ConfigNameDBE.一次判定IF文字コード, RDate.getNowDate());
        if (new RString("1").equals(一次判定IF文字コード)) {
            eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.SJIS).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        } else if (new RString("2").equals(一次判定IF文字コード)) {
            eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        }
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("一次判定済データ"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ファイル名,
                EUC_ENTITY_ID.toRString(),
                bunisess.get出力件数(new Decimal(eucCsvWriterJunitoJugo.getCount())),
                bunisess.get出力条件(paramter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private Encode getEncode() {
        RString 一次判定IF文字コード = DbBusinessConfig.get(ConfigNameDBE.一次判定IF文字コード, RDate.getNowDate());
        Encode encode = Encode.SJIS;
        if (new RString("1").equals(一次判定IF文字コード)) {
            encode = Encode.SJIS;

        } else if (new RString("2").equals(一次判定IF文字コード)) {
            encode = Encode.UTF_8withBOM;
        }
        return encode;
    }
}
