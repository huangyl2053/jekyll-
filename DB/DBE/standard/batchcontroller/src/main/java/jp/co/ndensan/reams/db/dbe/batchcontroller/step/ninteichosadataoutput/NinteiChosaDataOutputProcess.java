/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputResult;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataCsvProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaBasicDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputEucCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 認定調査データ出力（モバイル）CSV出力処理クラスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
public class NinteiChosaDataOutputProcess extends BatchProcessBase<NinteiChosaBasicDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput.INinteiChosaDataOutputMapper."
            + "getCsvTable");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE224001");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString ZIP拡張子 = new RString(".zip");
    private static final RString underscore = new RString("_");
    private NinteiChosaDataCsvProcessParamter processParamter;
    private RString 認定調査委託先名称 = RString.EMPTY;
    private RString 認定調査員氏名 = RString.EMPTY;
    private RString 市町村名称 = RString.EMPTY;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<NinteiChosaDataOutputEucCsvEntity> eucCsvWriter;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private DbAccessLogger accessLog;

    @Override
    protected void initialize() {
        eucFilePath = Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID.toRString()));
        accessLog = new DbAccessLogger();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaDataOutputCsvMybitisParameter());
    }

    @Override
    protected void createWriter() {
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(NinteiChosaBasicDataRelateEntity entity) {
        if (認定調査委託先名称 == null || 認定調査委託先名称.isEmpty()) {
            認定調査委託先名称 = entity.get今回分Entity().get事業者名称();
        }
        if (processParamter.getNinteiChosainCode() != null && !processParamter.getNinteiChosainCode().isEmpty()
                && (認定調査員氏名 == null || 認定調査員氏名.isEmpty())) {
            認定調査員氏名 = entity.get今回分Entity().get調査員氏名();
        }
        if (市町村名称 == null || 市町村名称.isEmpty()) {
            市町村名称 = entity.get今回分Entity().get市町村名称();
        }
        eucCsvWriter.writeLine(new NinteiChosaDataOutputResult().setEucCsvEntity(entity));
        PersonalData personalData = new NinteiChosaDataOutputResult().getPersonalData(entity.get今回分Entity().get申請書管理番号());
        personalDataList.add(personalData);
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                entity.get今回分Entity().get申請書管理番号());
        accessLog.store(new ShoKisaiHokenshaNo(entity.get今回分Entity().get証記載保険者番号()),
                entity.get今回分Entity().get被保険者番号(), expandedInfo);

    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        outputJokenhyoFactory();
        accessLog.flushBy(AccessLogType.照会);
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RStringBuilder EUCファイル名称 = new RStringBuilder();
        EUCファイル名称.append(DbBusinessConfig.get(ConfigNameDBE.認定調査結果入力用ZIPファイル名称, RDate.getNowDate(), processParamter.getShichosonCode()))
                .append(underscore).append(processParamter.getAddedFileName()).append(ZIP拡張子);
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("認定調査データ出力（モバイル）"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                EUCファイル名称.toRString(),
                new RString("DBE224005"),
                new NinteiChosaDataOutputResult().get出力件数(new Decimal(eucCsvWriter.getCount())),
                new NinteiChosaDataOutputResult().get出力条件(processParamter, 認定調査委託先名称, 認定調査員氏名, 市町村名称));
        OutputJokenhyoFactory.createInstance(item).print();
    }

}
