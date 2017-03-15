/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput;

import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumifoutput.ichijihanteizumi.IchijiHanteizumIfOutputBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.itizihanteishori.ItziHanteiShoriProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput.IchijiHanteizumIfOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput.IchijiHanteizumIfOutputRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBE309001_一次判定IF作成CSVを作成Processクラスです。
 *
 * @reamsid_L DBE-1470-021 wanghui
 */
public class IchijiHanteizumIfOutputEucCsvProcess extends BatchProcessBase<IchijiHanteizumIfOutputRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteizumifoutput."
            + "IchijiHanteizumIfOutputMapper.get日次進捗データ作成CSV出力");

    private static RString ファイル名;
    private static final RString 処理タイトル = new RString("一次判定インターフェース作成");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE309001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private ItziHanteiShoriProcessParamter paramter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private DbAccessLogger accessLog;

    @Override
    protected void initialize() {
        ファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定ソフト一次判定用データ送信ファイル名09B, RDate.getNowDate());

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate());
        paramter.setイメージ区分(イメージ区分);
        accessLog = new DbAccessLogger();
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void createWriter() {
        createWriterAndSetMojiCode();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toItziHanteiShoriMybitisParamter());
    }
    @BatchWriter
    private CsvWriter<IchijiHanteizumIfOutputEucCsvEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void process(IchijiHanteizumIfOutputRelateEntity entity) {
        eucCsvWriterJunitoJugo.writeLine(IchijiHanteizumIfOutputBusiness.setEucCsvEntity(entity));
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), entity.getShinseishoKanriNo());
        accessLog.store(new ShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo()), entity.getHihokenshaNo(), expandedInfo);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterJunitoJugo.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
        accessLog.flushBy(AccessLogType.照会);
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                処理タイトル,
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ファイル名,
                EUC_ENTITY_ID.toRString(),
                IchijiHanteizumIfOutputBusiness.get出力件数(new Decimal(eucCsvWriterJunitoJugo.getCount())),
                IchijiHanteizumIfOutputBusiness.get出力条件(paramter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private void createWriterAndSetMojiCode() {
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
}
