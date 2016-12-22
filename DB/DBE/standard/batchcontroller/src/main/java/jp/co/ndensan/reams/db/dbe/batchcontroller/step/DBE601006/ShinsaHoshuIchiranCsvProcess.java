/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601006;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.IShinsaHoshuIchiranEntityCsvEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranEntity;
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
 * 審査会委員報酬一覧表のCSV作成プロセスクラスです。
 * 
 * @author n8417（鄒　春雨）
 */
public class ShinsaHoshuIchiranCsvProcess extends ShinsaHoshuIchiranProcess {

    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;
    
    @BatchWriter
    private CsvWriter<IShinsaHoshuIchiranEntityCsvEucEntity> csvWriter;

    @Override
    protected void createWriter() {
        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSV_FILE_NAME);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void output(ShinsaHoshuIchiranEntity 審査報酬一覧Entity) {
        csvWriter.writeLine(審査報酬一覧Entity);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        fileSpoolManager.spool(eucFilePath);
        
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体 = AssociationFinderFactory.createInstance().getAssociation();
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 審査会開催年月 = new RStringBuilder("【対象年月】");
        審査会開催年月.append(getFormatted年月(paramter.get審査会開催年月()));
        出力条件.add(審査会開催年月.toRString());
        
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("介護認定審査会委員報酬一覧表CSV"),
                導入団体.getLasdecCode_().value(), 
                導入団体.get市町村名(), 
                new RString(JobContextHolder.getJobId()),
                CSV_FILE_NAME, 
                EUC_ENTITY_ID.toRString(), 
                new RString(csvWriter.getCount()), 
                出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }
}

