/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.IkenshoShukeiKijunbiKubun;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshojissekiichiran.IkenshoJissekiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IIkenshoJissekiIchiranCsvEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranRelateEntity;
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
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 主治医意見書作成実績集計表のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
public class IkenshoJissekiIchiranProcessCSV extends BatchProcessBase<IkenshoJissekiIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshojissekiichiran.IIkenshoJissekiIchiranMapper.get主治医意見書作成実績集計表");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE602001"));
    private static final RString CSV_NAME = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, new RString("DBE602001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private IkenshoJissekiIchiranProcessParameter paramter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 導入団体コード;
    private RString 市町村名;

    @BatchWriter
    private CsvWriter<IIkenshoJissekiIchiranCsvEucEntity> csvWriter;

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
    protected void process(IkenshoJissekiIchiranRelateEntity relateEntity) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(relateEntity));
            IIkenshoJissekiIchiranCsvEucEntity entity = new IkenshoJissekiIchiranEntity(relateEntity);
            csvWriter.writeLine(entity);
    }

    @Override
    protected void afterExecute() {
            csvWriter.close();
            manager.spool(eucFilePath);
            バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 出力件数 = new RString(csvWriter.getCount());
        List<RString> 出力条件 = get出力条件();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("主治医意見書作成実績集計CSV"), 導入団体コード, 市町村名, ジョブ番号,
                CSV_NAME, EUC_ENTITY_ID.toRString(), 出力件数, 出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RString 基準日区分 = get基準日区分();
        RStringBuilder 保険者_SB = new RStringBuilder("【保険者】");
        保険者_SB.append(paramter.get証記載保険者());
        保険者_SB.append(new RString(" "));
        保険者_SB.append(paramter.get保険者名称());
        出力条件.add(get出力条件_基準日区分From(基準日区分));
        出力条件.add(get出力条件_基準日区分To(基準日区分));
        出力条件.add(保険者_SB.toRString());
        return 出力条件;
    }

    private RString get基準日区分() {
        if (paramter.get基準日区分() == null || paramter.get基準日区分().isEmpty()) {
            return new RString("基準日");
        }
        return IkenshoShukeiKijunbiKubun.toValue(paramter.get基準日区分()).getTitle();
    }

    private RString get出力条件_基準日区分From(RString 基準日区分) {
        RStringBuilder br = new RStringBuilder();
        return br.append(new RString("【"))
                .append(基準日区分)
                .append(new RString("（From）】"))
                .append(dateFormat(paramter.get基準日FROM()))
                .toRString();
    }

    private RString get出力条件_基準日区分To(RString 基準日区分) {
        RStringBuilder br = new RStringBuilder();
        return br.append(new RString("【"))
                .append(基準日区分)
                .append(new RString("（To）】"))
                .append(dateFormat(paramter.get基準日TO()))
                .toRString();
    }

    private PersonalData toPersonalData(IkenshoJissekiIchiranRelateEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"),
                entity.get申請書管理番号());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private static RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.wareki().toDateString();
    }
}
