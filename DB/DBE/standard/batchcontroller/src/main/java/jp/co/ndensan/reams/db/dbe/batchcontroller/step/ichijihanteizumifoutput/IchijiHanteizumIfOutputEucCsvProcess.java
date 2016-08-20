/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteizumifoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumifoutput.ichijihanteizumi.IchijiHanteizumIfOutputBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputResult;
import jp.co.ndensan.reams.db.dbe.definition.processprm.itizihanteishori.ItziHanteiShoriProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput.IchijiHanteizumIfOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput.IchijiHanteizumIfOutputRelateEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE309001"));
    private ItziHanteiShoriProcessParamter paramter;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    List<IchijiHanteizumIfOutputRelateEntity> kaigoJuminhyoEntityList = new ArrayList<>();
    private RString eucFilePath;
    private IchijiHanteizumIfOutputBusiness business;
    private FileSpoolManager manager;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString 一次判定IF文字コードファイル名 = DbBusinessConfig.get(ConfigNameDBE.一次判定IF文字コード, RDate.getNowDate());
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), 一次判定IF文字コードファイル名);
        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate());
        paramter.setイメージ区分(イメージ区分);
    }

    @Override
    protected void beforeExecute() {
        business = new IchijiHanteizumIfOutputBusiness();
    }

    @Override
    protected void createWriter() {
        eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toItziHanteiShoriMybitisParamter());
    }
    @BatchWriter
    private EucCsvWriter<IchijiHanteizumIfOutputEucCsvEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void process(IchijiHanteizumIfOutputRelateEntity entity) {
        getファイル名(entity);
        eucCsvWriterJunitoJugo.writeLine(business.setEucCsvEntity(entity));
        new NinteiChosaDataOutputResult().getアクセスログ(entity.getShinseishoKanriNo());
        kaigoJuminhyoEntityList.add(entity);
    }

    @Override
    protected void afterExecute() {
        RString koroshoIfShikibetsuCode = RString.EMPTY;
        for (int i = 0; i < kaigoJuminhyoEntityList.size(); i++) {
            if (!kaigoJuminhyoEntityList.get(i).getKoroshoIfShikibetsuCode().equals(koroshoIfShikibetsuCode)) {
                manager.spool(eucFilePath);
                koroshoIfShikibetsuCode = kaigoJuminhyoEntityList.get(i).getKoroshoIfShikibetsuCode();
                outputJokenhyoFactory();
            }
        }
        eucCsvWriterJunitoJugo.close();
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
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("NCI221.CSV"),
                new RString("CSVFile00001.csv"),
                business.get出力件数(new Decimal(eucCsvWriterJunitoJugo.getCount())),
                business.get出力条件(paramter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private void getファイル名(IchijiHanteizumIfOutputRelateEntity entity) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RStringBuilder jokenBuilder = new RStringBuilder();
        RString ファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定ソフト一次判定用データ送信ファイル名09B, RDate.getNowDate());
        jokenBuilder.append(ファイル名.replace(".csv", "_"));
        jokenBuilder.append(entity.getKoroshoIfShikibetsuCode().concat(new RString(".csv")));
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), jokenBuilder.toRString());
        RString 一次判定IF文字コード = DbBusinessConfig.get(ConfigNameDBE.一次判定IF文字コード, RDate.getNowDate());
        if (new RString("1").equals(一次判定IF文字コード)) {
            eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.SJIS).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        } else if (new RString(
                "2").equals(一次判定IF文字コード)) {
            eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        }
    }
}
