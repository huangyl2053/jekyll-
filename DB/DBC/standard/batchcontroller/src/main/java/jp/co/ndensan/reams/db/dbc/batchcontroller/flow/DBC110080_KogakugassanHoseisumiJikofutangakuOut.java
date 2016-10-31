/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080.KogakugassanGassanMiSofuReprotProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080.KogakugassanGassanSofuReprotProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080.KogakugassanMeisaiKakuninProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080.KogakugassanReadDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080.KogakugassanSoufuFairuSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080.KogakugassanSoufuSetteiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080.UpdateKogakuGassanMiSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110080.UpdateKogakuGassanSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110080.DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassan.KogakugassanProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.externalcharacter.batch.BatchTextFileConvert;
import jp.co.ndensan.reams.uz.uza.externalcharacter.batch.BatchTextFileConvertBatchParameter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のバッチflowです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class DBC110080_KogakugassanHoseisumiJikofutangakuOut extends BatchFlowBase<DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter> {

    private static final String 送付対象データ取得 = "getFile";
    private static final String 高額合算自己負担額明細データの存在確認 = "meisaiKakunin";
    private static final String 被保険者_宛名情報取得 = "getHihokenshaAtena";
    private static final String エラー登録 = "doError";
    private static final String 送付除外区分設定 = "soufuSettei";
    private static final String 送付ファイル作成 = "soufuFairuSakusei";
    private static final String 帳票出力_送付一覧表 = "gassanSofuReprot";
    private static final String 帳票出力_未送付一覧表 = "gassanMiSofuReprot";
    private static final String DB更新_送付済 = "updateKogakuGassanSofu";
    private static final String DB更新_未送付 = "updateKogakuGassanMiSofu";
    private static final String 国保連インタフェース管理更新 = "kokuhorenkyoutsuDoInterfaceKanriKousinProcess";
    private static final String 処理結果リスト作成 = "kokuhorenkyoutsuDoShoriKekkaListSakuseiProcess";
    private static final String 文字コード変換 = "batchTextFileConvert";

    private static final RString データがある = new RString("1");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString 国保連送付外字_変換区分_1 = new RString("1");
    private static final RString SJIS類似 = new RString("SjisRuiji");

    private KogakugassanProcessParameter processParameter;
    private int レコード件数合計 = 0;
    private List<SharedFileDescriptor> エントリ情報List = new ArrayList<>();
    private RString 入力ファイルパス;
    private RString 出力ファイルパス;

    @Override
    protected void initialize() {
        processParameter = getParameter().toKogakugassanProcessParameter(YMDHMS.now());
        RDate date = processParameter.getNow().getDate();
        RString 保険者情報_保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, date, SubGyomuCode.DBU介護統計報告);
        RString 保険者情報_保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, date, SubGyomuCode.DBU介護統計報告);
        processParameter.set保険者情報_保険者番号(保険者情報_保険者番号);
        processParameter.set保険者情報_保険者名称(保険者情報_保険者名称);
        RString 国保連送付外字_変換区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (国保連送付外字_変換区分_1.equals(国保連送付外字_変換区分)) {
            processParameter.set文字コード(Encode.UTF_8);
        } else {
            processParameter.set文字コード(Encode.SJIS);
        }
        processParameter.setShoriKunbun(getParameter().getShoriKunbun().trim());
    }

    @Override
    protected void defineFlow() {
        executeStep(送付対象データ取得);
        if (データがある.equals((getResult(RString.class, new RString(送付対象データ取得), KogakugassanReadDataProcess.PARAMETER_OUT_FLOWFLAG)))) {
            executeStep(高額合算自己負担額明細データの存在確認);
            executeStep(被保険者_宛名情報取得);
            executeStep(エラー登録);
            executeStep(送付除外区分設定);
            executeStep(送付ファイル作成);
            レコード件数合計 = getResult(
                    Integer.class, new RString(送付ファイル作成), KogakugassanSoufuFairuSakuseiProcess.PARAMETER_OUT_OUTPUTCOUNT);
            do文字コード変換();
            executeStep(帳票出力_送付一覧表);
            executeStep(帳票出力_未送付一覧表);
            executeStep(DB更新_送付済);
            executeStep(DB更新_未送付);
        }
        executeStep(国保連インタフェース管理更新);
        executeStep(処理結果リスト作成);
    }

    /**
     * 送付対象データ取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand callGetFileProcess() {
        return loopBatch(KogakugassanReadDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 高額合算自己負担額明細データの存在確認操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(高額合算自己負担額明細データの存在確認)
    protected IBatchFlowCommand callKogakugassanMeisaiKakuninProcess() {
        return loopBatch(KogakugassanMeisaiKakuninProcess.class).define();
    }

    /**
     * 被保険者_宛名情報取得です。
     *
     * @return HokenshaKyufujissekiOutGetHihokenshaAtenaProcess
     */
    @Step(被保険者_宛名情報取得)
    protected IBatchFlowCommand callGetHihokenshaAtenaProcess() {
        return loopBatch(HokenshaKyufujissekiOutGetHihokenshaAtenaProcess.class).define();

    }

    /**
     * エラー登録です。
     *
     * @return HokenshaKyufujissekiOutDoErrorProcess
     */
    @Step(エラー登録)
    protected IBatchFlowCommand callDoErrorrProcess() {
        return loopBatch(HokenshaKyufujissekiOutDoErrorProcess.class).define();

    }

    /**
     * 送付除外区分設定操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付除外区分設定)
    protected IBatchFlowCommand callSoufuSetteiProcess() {
        return loopBatch(KogakugassanSoufuSetteiProcess.class).define();
    }

    /**
     * 送付ファイル作成操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand callSoufuFairuSakuseiProcess() {
        return loopBatch(KogakugassanSoufuFairuSakuseiProcess.class).arguments(processParameter).define();
    }

    /**
     * 文字コード変換操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(文字コード変換)
    protected IBatchFlowCommand callBatchTextFileConvertProcess() {
        HashMap<RString, Object> parameter = new HashMap();
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_FILE_PATH), 入力ファイルパス);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_FILE_PATH), 出力ファイルパス);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TABLE_NAME), SJIS類似);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TYPE), BatchTextFileConvert.CONVERTTYPE_TO);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_LF);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_CRLF);
        return simpleBatch(BatchTextFileConvert.class)
                .arguments(parameter)
                .define();
    }

    /**
     * 帳票出力_送付操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票出力_送付一覧表)
    protected IBatchFlowCommand callGassanSofuReprotProcess() {
        return loopBatch(KogakugassanGassanSofuReprotProcess.class).arguments(processParameter).define();
    }

    /**
     * 帳票出力_未送付操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票出力_未送付一覧表)
    protected IBatchFlowCommand callGassanMiSofuReprotProcess() {
        return loopBatch(KogakugassanGassanMiSofuReprotProcess.class).arguments(processParameter).define();
    }

    /**
     * DB更新_送付済操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(DB更新_送付済)
    protected IBatchFlowCommand callUpdateKogakuGassanSofuProcess() {
        return loopBatch(UpdateKogakuGassanSofuProcess.class).arguments(processParameter).define();
    }

    /**
     * DB更新_未送付操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(DB更新_未送付)
    protected IBatchFlowCommand callUpdateKogakuGassanMiSofuProcess() {
        return loopBatch(UpdateKogakuGassanMiSofuProcess.class).define();
    }

    /**
     * 国保連インタフェース管理更新操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callKokuhorenkyoutsuDoInterfaceKanriKousinProcess() {
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(getParam()).define();
    }

    /**
     * 処理結果リスト作成操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callKokuhorenkyoutsuDoShoriKekkaListSakuseiProcess() {
        HokenshaKyufujissekiOutListSakuseiProcessParameter parameter = new HokenshaKyufujissekiOutListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ2);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getParam() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter param = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        param.set処理年月(getParameter().getShoriYM());
        RString 処理区分 = getParameter().getShoriKunbun().trim();
        param.set交換情報識別番号(ConfigKeysKokuhorenSofu.高額合算補正済自己負担額情報.getコード().concat(処理区分));
        param.set処理対象年月(getParameter().getShoriYM());
        param.setレコード件数合計(レコード件数合計);
        List<RString> list = new ArrayList<>();
        if (エントリ情報List.isEmpty()) {
            param.setFileNameList(Collections.EMPTY_LIST);
        } else {
            for (SharedFileDescriptor entry : エントリ情報List) {
                list.add(entry.getSharedFileName().toRString());
                param.setFileNameList(list);
            }
        }
        return param;
    }

    private void do文字コード変換() {
        出力ファイルパス = getResult(
                RString.class, new RString(送付ファイル作成), KogakugassanSoufuFairuSakuseiProcess.OUTPUT_PATH);
        if (Encode.UTF_8.equals(processParameter.get文字コード()) && レコード件数合計 != INT_0) {
            入力ファイルパス = getResult(
                    RString.class, new RString(送付ファイル作成), KogakugassanSoufuFairuSakuseiProcess.INPUT_PATH);
            File file出力 = new File(出力ファイルパス.toString());
            file出力.delete();
            executeStep(文字コード変換);
            File file入力 = new File(入力ファイルパス.toString());
            file入力.delete();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険,
                FilesystemName.fromString(出力ファイルパス.substring(出力ファイルパス.lastIndexOf(File.separator) + INT_1)));
        sfd = SharedFile.defineSharedFile(sfd, 1, SharedFile.GROUP_ALL, null, true, null);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
        SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(出力ファイルパス), opts);
        エントリ情報List.add(sfd);
    }

}
