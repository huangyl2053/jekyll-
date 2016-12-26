/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601004;

import java.util.ArrayList;
import java.util.List;
import static jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601004.IkenshosakuseiHoshuProcess.EUC_ENTITY_ID;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshushokai.IkenHoshuIchiranChange;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IIkenHoshuIchiranCsvEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenshoHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 意見書作成報酬一覧表のCSVファイル作成プロセスクラスです。
 * 
 * @author n8417（鄒　春雨）
 */
public class IkenshosakuseiHoshuCsvProcess extends IkenshosakuseiHoshuProcess {

    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;

    @BatchWriter
    private CsvWriter<IIkenHoshuIchiranCsvEucEntity> csvWriter;
    
    @Override
    protected void createWriter() {
        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_NAME_EN);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void output(IkenshoHoshuShokaiRelateEntity relateEntity) {
        csvWriter.writeLine(IkenHoshuIchiranChange.createIkenHoshuIchiranData(relateEntity, paramter));
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        fileSpoolManager.spool(eucFilePath);

        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 出力件数 = new RString(csvWriter.getCount());
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 作成依頼日From = new RStringBuilder("【作成依頼日（From）】");
        作成依頼日From.append(dateFormat(paramter.get作成依頼日期間開始()));
        RStringBuilder 作成依頼日To = new RStringBuilder("【作成依頼日（To）】");
        作成依頼日To.append(dateFormat(paramter.get作成依頼日期間終了()));
        出力条件.add(作成依頼日From.toRString());
        出力条件.add(作成依頼日To.toRString());
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                CSV_NAME_JP,
                導入団体コード,
                市町村名,
                ジョブ番号,
                CSV_NAME_EN,
                EUC_ENTITY_ID.toRString(),
                出力件数,
                出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }
    
}
