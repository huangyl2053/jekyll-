/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijihanteisumidataif.IchijihanteiSumidataIftProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 一次判定データ出力Processです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
public class IchijihanteiSumidataIfProcess extends BatchProcessBase<IchijihanteiSumidataIDataShutsuryokuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteisumidataif."
            + "IchijihanteiSumidataIDataShutsuryokuMapper.get一次判定結果票");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE309003"));

    private IchijihanteiSumidataIftProcessParamter paramter;
    private FileSpoolManager manager;
    private CsvWritersByFileName csvWritersByFileName;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RDate operationDate = RDate.getNowDate();
        csvWritersByFileName = new CsvWritersByFileName(manager, operationDate);
        paramter.set仮一次判定区分(false);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toIchijihanteiSumidataIftMybitisParamter());
    }

    @Override
    protected void process(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        csvWritersByFileName.writeLine(entity);
    }

    @Override
    protected void afterExecute() {
        csvWritersByFileName.spool();
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        for (CsvWritersByFileName.OutputingInfo info : csvWritersByFileName.outputingInfos()) {
            EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                    new RString("一次判定済データ"),
                    association.getLasdecCode_().value(),
                    association.get市町村名(),
                    new RString(String.valueOf(JobContextHolder.getJobId())),
                    info.getFileName(),
                    EUC_ENTITY_ID.toRString(),
                    get出力件数(info.getCount()),
                    get出力条件(paramter));
            OutputJokenhyoFactory.createInstance(item).print();
        }
    }

    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    private final RString 項目 = new RString("0");
    private final RString 予防給付サービス = new RString("1");

    public List<RString> get出力条件(IchijihanteiSumidataIftProcessParamter paramter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        if (項目.equals(paramter.get日付指定())) {
            jokenBuilder.append(new RString("【日付指定】　申請日"));
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("【申請日From】"));
            jokenBuilder.append(new FlexibleDate(paramter.get申請日From()).wareki().toDateString());
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("申請日To"));
            jokenBuilder.append(new FlexibleDate(paramter.get申請日To()).wareki().toDateString());
            出力条件List.add(jokenBuilder.toRString());
        }
        if (予防給付サービス.equals(paramter.get日付指定())) {
            jokenBuilder.append(new RString("【日付指定】　一次判定日"));
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("【一次判定日From】"));
            jokenBuilder.append(new FlexibleDate(paramter.get一次判定日From()).wareki().toDateString());
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("【一次判定日To】"));
            jokenBuilder.append(new FlexibleDate(paramter.get一次判定日To()).wareki().toDateString());
            出力条件List.add(jokenBuilder.toRString());
        }
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }
}
