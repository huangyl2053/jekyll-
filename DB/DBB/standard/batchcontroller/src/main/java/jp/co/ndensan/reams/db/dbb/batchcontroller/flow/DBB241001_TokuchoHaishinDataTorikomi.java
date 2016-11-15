/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB241001.NenkinTokuchoCsvOutputProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB241001.DBB241001_TokuchoHaishinDataTorikomiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb241001.TokuchoHaishinDataTorikomiProcessParameter;
import jp.co.ndensan.reams.ue.uex.batchcontroller.step.uext00010.NenkinTokuchoJohoTorikomiProcess;
import jp.co.ndensan.reams.ue.uex.definition.batchprm.uext00011.KaikeiHikiTsugiFlowParameter;
import jp.co.ndensan.reams.ue.uex.definition.processprm.nenkintokucho.UEXT00010NenkinTokuchoJohoTorikomiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴配信データ取り込みのバッチ処理フローです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
public class DBB241001_TokuchoHaishinDataTorikomi extends BatchFlowBase<DBB241001_TokuchoHaishinDataTorikomiParameter> {

    private static final String 取り込みファイルデータを一時テーブルに登録 = "nenkinTokuchoJohoTorikomi";
    private static final String 一覧表の出力および年金特徴回付情報の登録及び件数表の出力 = "nenkinTokuchoCsvOutputProcess";
    private static final String バッチ特徴分配集約を呼び出し = "doNenkinTokuchoKaikeiHikitsugi";
    private static final RString BATCH_ID = new RString("UEXT00030_NenkinTokuchoKaikeiHikitsugi");
    private RString filePath;
    private RString fileName;
    private FlexibleYearMonth 対象年月 = FlexibleYearMonth.EMPTY;

    @Override
    protected void defineFlow() {
        getParameter().setShoriYMDHM(RDateTime.now());
        if (!getParameter().getSharedFileEntryDescriptorList().isEmpty() && getParameter().getSharedFileEntryDescriptorList().size() > 0) {
            for (int i = 0; i < getParameter().getSharedFileEntryDescriptorList().size(); i++) {
                getFilePath(getParameter().getSharedFileEntryDescriptorList().get(i));
                executeStep(取り込みファイルデータを一時テーブルに登録);
                executeStep(一覧表の出力および年金特徴回付情報の登録及び件数表の出力);
                対象年月 = getResult(FlexibleYearMonth.class, new RString(一覧表の出力および年金特徴回付情報の登録及び件数表の出力),
                        NenkinTokuchoCsvOutputProcess.PARAMETER_OUT_OUTPUTSAKUSEIYMD);
                executeStep(バッチ特徴分配集約を呼び出し);
                対象年月 = FlexibleYearMonth.EMPTY;
            }
        }

    }

    /**
     * 取り込みファイルデータを一時テーブルに登録処理クラスです。
     *
     * @return バッチコマンド
     */
    @Step(取り込みファイルデータを一時テーブルに登録)
    protected IBatchFlowCommand callNenkinTokuchoJohoTorikomiProcess() {
        return loopBatch(NenkinTokuchoJohoTorikomiProcess.class).
                arguments(toUEXT00010NenkinTokuchoJohoTorikomiProcessParameter()).define();
    }

    /**
     * 一覧表の出力および年金特徴回付情報の登録及び件数表の出力処理クラスです。
     *
     * @return バッチコマンド
     */
    @Step(一覧表の出力および年金特徴回付情報の登録及び件数表の出力)
    protected IBatchFlowCommand callNenkinTokuchoCsvOutputProcess() {
        return loopBatch(NenkinTokuchoCsvOutputProcess.class).
                arguments(getProcessParameter()).define();
    }

    /**
     * バッチ_特徴分配集約(UEXT00030_NenkinTokuchoKaikeiHikitsugi)を呼び出しクラスです。
     *
     * @return DoBatchTokuchoDoteiProcess
     */
    @Step(バッチ特徴分配集約を呼び出し)
    protected IBatchFlowCommand callDoBatchTokuchoDoteiProcess() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.UEX分配集約公開,
                getBatchParamter()).define();
    }

    private KaikeiHikiTsugiFlowParameter getBatchParamter() {
        KaikeiHikiTsugiFlowParameter parameter = new KaikeiHikiTsugiFlowParameter();
        parameter.set業務コード(GyomuCode.DB介護保険.getColumnValue());
        parameter.setバッチ処理日時(RDateTime.now());
        parameter.set処理対象年月(対象年月);
        return parameter;
    }

    private void getFilePath(SharedFileEntryDescriptor descriptor) {
        RString tmpPath = Directory.createTmpDirectory();
        FilesystemPath filesystemPath = new FilesystemPath(tmpPath);
        ReadOnlySharedFileEntryDescriptor entitydesc = new ReadOnlySharedFileEntryDescriptor(descriptor.getSharedFileName(),
                descriptor.getSharedFileId());
        FilesystemPath 保存先フォルダのパス = SharedFile.copyToLocal(entitydesc, filesystemPath);
        fileName = (Directory.getFiles(保存先フォルダのパス.toRString(), descriptor.getSharedFileName().toRString(),
                false).length > 0 ? Directory.getFiles(保存先フォルダのパス.toRString(), descriptor.getSharedFileName().toRString(),
                        false)[0] : RString.EMPTY);
        filePath = Path.combinePath(保存先フォルダのパス.toRString(), fileName);

    }

    private TokuchoHaishinDataTorikomiProcessParameter getProcessParameter() {
        return getParameter().toProcessParameter(fileName);
    }

    private UEXT00010NenkinTokuchoJohoTorikomiProcessParameter
            toUEXT00010NenkinTokuchoJohoTorikomiProcessParameter() {
        return new UEXT00010NenkinTokuchoJohoTorikomiProcessParameter(null, null, null, null, null, null, null,
                filePath);
    }
}
