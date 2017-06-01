/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.NinteiChosaShukeiKijunbiKubun;
import jp.co.ndensan.reams.db.dbe.definition.processprm.chosahyojissekiichiran.ChosahyoJissekiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.IChosahyoJissekiIchiranCsvEucEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjigjing
 */
public class ChosahyoJissekiIchiranProcessCSV extends BatchProcessBase<ChosahyoJissekiIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosahyojissekiichiran."
            + "IChosahyoJissekiIchiranMapper.get帳票出力用認定調査実績集計表");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE603001"));
    private static final RString CSV_NAME = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, new RString("DBE603001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private ChosahyoJissekiIchiranProcessParameter paramter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 導入団体コード;
    private RString 市町村名;
    private List<PersonalData> personalDataList = new ArrayList<>();

    @BatchWriter
    private CsvWriter<IChosahyoJissekiIchiranCsvEucEntity> csvWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_NAME);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(ChosahyoJissekiIchiranRelateEntity relateEntity) {
        PersonalData personalData = getPersonalData(relateEntity);
        personalDataList.add(personalData);
        IChosahyoJissekiIchiranCsvEucEntity entity = new ChosahyoJissekiIchiranEntity(relateEntity);
        csvWriter.writeLine(entity);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, accessLogUUID);
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 出力件数 = new RString(csvWriter.getCount());
        List<RString> 出力条件 = get出力条件();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("認定調査実績集計CSV"), 導入団体コード, 市町村名, ジョブ番号,
                CSV_NAME, EUC_ENTITY_ID.toRString(), 出力件数, 出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RString 基準日区分 = get基準日区分();
        RStringBuilder 保険者_SB = new RStringBuilder("【保険者】");
        保険者_SB.append(paramter.get証記載保険者());
        出力条件.add(get出力条件_基準日From(基準日区分));
        出力条件.add(get出力条件_基準日TO(基準日区分));
        出力条件.add(保険者_SB.toRString());
        return 出力条件;
    }

    private RString get基準日区分() {
        if (paramter.get基準日区分() == null || paramter.get基準日区分().isEmpty()) {
            return new RString("基準日");
        }
        return NinteiChosaShukeiKijunbiKubun.toValue(paramter.get基準日区分()).getTitle();
    }

    private RString get出力条件_基準日From(RString 基準日区分) {
        RStringBuilder br = new RStringBuilder();
        return br.append("【")
                .append(基準日区分)
                .append("（From）】")
                .append(dateFormat(paramter.get基準日FROM()))
                .toRString();
    }

    private RString get出力条件_基準日TO(RString 基準日区分) {
        RStringBuilder br = new RStringBuilder();
        return br.append("【")
                .append(基準日区分)
                .append("（To）】")
                .append(dateFormat(paramter.get基準日TO()))
                .toRString();
    }

    private static RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.wareki().toDateString();
    }
    
    private PersonalData getPersonalData(ChosahyoJissekiIchiranRelateEntity relateEntity) {
        RStringBuilder 識別コードStr = new RStringBuilder();
        識別コードStr.append(relateEntity.get証記載保険者番号().substring(0, 5));
        識別コードStr.append(relateEntity.get被保険者番号());
        ShikibetsuCode 識別コード = new ShikibetsuCode(識別コードStr.toRString());
        ExpandedInformation 拡張情報 = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), relateEntity.get申請書管理番号());
        return PersonalData.of(識別コード, 拡張情報);
    }
}
