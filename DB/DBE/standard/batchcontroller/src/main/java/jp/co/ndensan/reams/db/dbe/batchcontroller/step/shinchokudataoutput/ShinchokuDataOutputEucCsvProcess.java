/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinchokudataoutput;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputResult;
import jp.co.ndensan.reams.db.dbe.business.core.shinchokudataoutput.shickdateoutput.ShinchokuDataOutputBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinchokudataoutput.ShinchokuDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.ShinchokuDataOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.ShinchokuDataOutputRelateEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
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
 * バッチ設計_DBE491001_日次進捗データCSVを作成Processクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
public class ShinchokuDataOutputEucCsvProcess extends BatchProcessBase<ShinchokuDataOutputRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinchokudataoutput."
            + "IShinchokuDataOutputMapper.get日次進捗データ作成CSV出力");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE491001"));
    private ShinchokuDataOutputProcessParamter paramter;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private ShinchokuDataOutputBusiness business;
    private FileSpoolManager manager;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        if (new RString("0").equals(paramter.getFayirukuben())) {
            RString 日次進捗データ送信ファイル名 = DbBusinessConfig.get(ConfigNameDBE.日次進捗データ送信ファイル名新, RDate.getNowDate());
            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), 日次進捗データ送信ファイル名);
        } else if (new RString("1").equals(paramter.getFayirukuben())) {
            RString 連携データ送信ファイル名 = DbBusinessConfig.get(ConfigNameDBE.要介護認定結果連携データ送信ファイル名新, RDate.getNowDate());
            eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), 連携データ送信ファイル名);
        }
    }

    @Override
    protected void beforeExecute() {
        business = new ShinchokuDataOutputBusiness();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toShinchokuDataOutputMybitisParamter());
    }
    @BatchWriter
    private EucCsvWriter<ShinchokuDataOutputEucCsvEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void createWriter() {
        RString 連携文字コード = DbBusinessConfig.get(ConfigNameDBE.連携文字コード, RDate.getNowDate());
        if (new RString("1").equals(連携文字コード)) {
            eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.SJIS).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        } else if (new RString("2").equals(連携文字コード)) {
            eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        }
    }

    @Override
    protected void process(ShinchokuDataOutputRelateEntity entity) {
        eucCsvWriterJunitoJugo.writeLine(business.setEucCsvEntity(entity));
        new NinteiChosaDataOutputResult().getアクセスログ(entity.getShinseishoKanriNo());
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterJunitoJugo.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void getアクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号));
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        if (new RString("0").equals(paramter.getFayirukuben())) {
            RString 日次進捗データ送信ファイル名 = DbBusinessConfig.get(ConfigNameDBE.日次進捗データ送信ファイル名新, RDate.getNowDate());
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    EUC_ENTITY_ID.toRString(),
                    association.getLasdecCode_().value(),
                    association.get市町村名(),
                    new RString(String.valueOf(JobContextHolder.getJobId())),
                    new RString("日次進捗データ送信ファイル.csv"),
                    日次進捗データ送信ファイル名,
                    business.get出力件数(new Decimal(eucCsvWriterJunitoJugo.getCount())),
                    business.get出力条件(paramter));
            OutputJokenhyoFactory.createInstance(item).print();
        } else if (new RString("1").equals(paramter.getFayirukuben())) {
            RString 連携データ送信ファイル名 = DbBusinessConfig.get(ConfigNameDBE.要介護認定結果連携データ送信ファイル名新, RDate.getNowDate());
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    EUC_ENTITY_ID.toRString(),
                    association.getLasdecCode_().value(),
                    association.get市町村名(),
                    new RString(String.valueOf(JobContextHolder.getJobId())),
                    new RString("要介護認定結果連携データ送信ファイル.csv"),
                    連携データ送信ファイル名,
                    business.get出力件数(new Decimal(eucCsvWriterJunitoJugo.getCount())),
                    business.get出力条件(paramter));
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }
}
