/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.io.File;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB112001.CheckShotokuJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB112001.InsKaigoShotokuKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB112001.SelectShotokuJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB112001.SpoolShotokuJohoIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB112001.UpdShoriHidukeKanriProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112002.DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携_当初広域のバッチFlowです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class DBB112002_ToushoShotokuJohoChushutsuRenkeiKoiki extends BatchFlowBase<DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter> {

    private static final String CSVファイル読み込み = "csvFileYomikomi";
    private static final String 所得情報をチェックとEUCファイル出力 = "callCheckShotokuJohoProcess";
    private static final String 介護所得TEMPテーブルに登録 = "callInsKaigoShotokuKanriProcess";
    private static final String 帳票とEUCファイル出力 = "callSpoolShotokuJohoIchiranProcess";
    private static final String 処理日付管理マスタの更新 = "callUpdShoriHidukeKanriProcess";

    private static final RString DEC05F001 = new RString("DEC05F001");
    private static final RString DEE01F001 = new RString("DEE01F001");

    private ShutokuJohoShuchutsuRenkeiProcessParameter processParameter;

    @Override
    protected void initialize() {
        processParameter = getParameter().toProcessParamter();
        processParameter.set処理日時(YMDHMS.now());
    }

    @Override
    @SuppressWarnings("checkstyle:illegaltoken")
    protected void defineFlow() {
        List<UzT0885SharedFileEntryEntity> 国保List = SharedFile.searchSharedFile(DEC05F001);
        List<UzT0885SharedFileEntryEntity> 国保情報List = SharedFile.searchSharedFile(DEE01F001);
        for (UzT0885SharedFileEntryEntity entity : 国保List) {
            国保情報List.add(entity);
        }
        for (UzT0885SharedFileEntryEntity entity : 国保情報List) {
            ReadOnlySharedFileEntryDescriptor descriptor
                    = ReadOnlySharedFileEntryDescriptor.fromEntity(entity);
            RString path = SharedFile.getDirectAccessPath(descriptor);
            FilesystemPath filesystemPath = SharedFile.copyToLocal(descriptor, FilesystemPath.fromString(path));
            File file = new File(filesystemPath.toString());
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.getName().startsWith(DEE01F001.toString()) || file1.getName().startsWith(DEC05F001.toString())) {
                    RString csvReaderPath = Path.combinePath(filesystemPath.toRString(), new RString(file1.getName()));
                    processParameter.setCsvファイルPath(csvReaderPath);
                    executeStep(CSVファイル読み込み);
                }
            }
        }
        executeStep(所得情報をチェックとEUCファイル出力);
        executeStep(介護所得TEMPテーブルに登録);
        executeStep(帳票とEUCファイル出力);
        executeStep(処理日付管理マスタの更新);
    }

    /**
     * CSVファイル読み込みを行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(CSVファイル読み込み)
    protected IBatchFlowCommand csvFileYomikomi() {
        return loopBatch(SelectShotokuJohoProcess.class).arguments(processParameter).define();
    }

    /**
     * 所得情報をチェックとEUCファイル出力を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(所得情報をチェックとEUCファイル出力)
    protected IBatchFlowCommand callCheckShotokuJohoProcess() {
        return loopBatch(CheckShotokuJohoProcess.class).arguments(processParameter).define();
    }

    /**
     * 介護所得Tempテーブルに登録を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護所得TEMPテーブルに登録)
    protected IBatchFlowCommand callInsKaigoShotokuKanriProcess() {
        return loopBatch(InsKaigoShotokuKanriProcess.class).define();
    }

    /**
     * 帳票とEUCファイル出力を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票とEUCファイル出力)
    protected IBatchFlowCommand callSpoolShotokuJohoIchiranProcess() {
        return loopBatch(SpoolShotokuJohoIchiranProcess.class).arguments(processParameter).define();
    }

    /**
     * 帳票とEUCファイル出力を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタの更新)
    protected IBatchFlowCommand callUpdShoriHidukeKanriProcess() {
        return simpleBatch(UpdShoriHidukeKanriProcess.class).arguments(processParameter).define();
    }
}
