/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterTransmissionCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterTransmissionEditEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterTransmissionEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
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
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * センター送信データ作成のProcessクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class CenterTransmissionProcess extends BatchProcessBase<CenterTransmissionEntity> {

    private static final RString SELECT_SHUJIIIKENSHOIKENITEM = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getCenterTransmissionData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE561001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = RString.EMPTY;

    private CenterTransmissionProcessParameter parameter;
    private CenterTransmissionMybitisParamter mybitisParamter;
    private List<RString> 申請書管理番号リスト;
    private RString 申請書管理番号;
    private FileSpoolManager manager;
    private RString filename;
    private RString ファイル名;
    private int シーケンシャル番号;
    private int 出力データ件数;

    /**
     * データ有無の判定です。
     */
    public static final RString OUTPUTSHINSEISHOKANRINO;

    static {
        OUTPUTSHINSEISHOKANRINO = new RString("outputShinseishoKanriNo");
    }
    private OutputParameter<List<RString>> outputShinseishoKanriNo;
    private List<RString> 出力された申請書管理番号;

    @BatchWriter
    private CsvWriter<CenterTransmissionCsvEntity> csvWriterCenterTransmission;

    @Override
    protected void initialize() {
        outputShinseishoKanriNo = new OutputParameter<>();
        シーケンシャル番号 = 0;
        出力データ件数 = 0;
        申請書管理番号リスト = parameter.get申請書管理番号リスト();
        出力された申請書管理番号 = new ArrayList<>();
        申請書管理番号 = RString.EMPTY;
        mybitisParamter = parameter.toCenterTransmissionMybitisParamter();
        if (parameter.is転入死亡情報出力()) {
            List<RString> shinseijiKubunCodeList = new ArrayList<>();
            shinseijiKubunCodeList.add(NinteiShinseiShinseijiKubunCode.転入申請.getコード());
            shinseijiKubunCodeList.add(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード());
            mybitisParamter.setShinseijiKubunCodeList(shinseijiKubunCodeList);
        }
        mybitisParamter.setShinseishoKanriNoList(申請書管理番号リスト);
        mybitisParamter.setGaikyoChosaTextImageKubun(DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        ファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定支援センター送信ファイル名, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        filename = Path.combinePath(spoolWorkPath, ファイル名);
        csvWriterCenterTransmission = new CsvWriter.InstanceBuilder(filename).
                setEncode(Encode.SJIS)
                .canAppend(true)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHUJIIIKENSHOIKENITEM, mybitisParamter);
    }

    @Override
    protected void process(CenterTransmissionEntity entity) {
        シーケンシャル番号 = シーケンシャル番号 + 1;
        csvWriterCenterTransmission.writeLine(new CenterTransmissionEditEntity(entity, シーケンシャル番号).getファイル出力項目());
        出力データ件数 = 出力データ件数 + 1;
        if (!申請書管理番号.equals(entity.getShinseishoKanriNo().value())) {
            出力された申請書管理番号.add(entity.getShinseishoKanriNo().value());
            申請書管理番号 = entity.getShinseishoKanriNo().value();
            AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号));
        }
    }

    @Override
    protected void afterExecute() {
        outputShinseishoKanriNo.setValue(出力された申請書管理番号);
        outputJokenhyoFactory();
        csvWriterCenterTransmission.close();
        manager.spool(filename);
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("認定支援センター送信ファイル"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                ファイル名,
                EUC_ENTITY_ID.toRString(),
                new RString(出力データ件数),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("【転入/死亡情報出力区分】"), get情報出力区分For出力条件(parameter.is転入死亡情報出力())));
        出力条件.add(条件(new RString("【二次判定日(開始)】"), parameter.get二次判定開始日()));
        出力条件.add(条件(new RString("【二次判定日(終了)】"), parameter.get二次判定終了日()));
        return 出力条件;
    }

    private RString 条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(バッチパラメータ名);
        条件.append(値);
        return 条件.toRString();
    }

    private RString get情報出力区分For出力条件(boolean is情報出力) {
        if (is情報出力) {
            return new RString("0");
        }
        return new RString("1");
    }
}
