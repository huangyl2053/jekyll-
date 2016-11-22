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
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010.IdoRenrakuhyoDBUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010.IdoRenrakuhyoSofuFileSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010.IdoRenrakuhyoSofuTaishoDataShutokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170010.DBC170010_ServicecodeIdoRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc170010.ServicecodeIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業分サービスコード異動連絡票作成のバッチフロークラスです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
public class DBC170010_ServicecodeIdoRenrakuhyoOut extends BatchFlowBase<DBC170010_ServicecodeIdoRenrakuhyoOutParameter> {

    private static final RString データがある = new RString("1");
    private static final RString 本番処理 = new RString("2");
    private static final String 国保連インタフェース管理更新 = "kokuhorenkyoutsuDoInterfaceKanriKousinProcess";
    private static final String 処理結果リスト作成 = "hokenshaKyufujissekiOutListSakuseiProcess";
    private static final String 送付対象データ取得 = "SofuTaishoDataShutoku";
    private static final String 送付ファイル作成 = "sofuFileKakutei";
    private static final String DB更新 = "dbUpdate";
    private static final String 文字コード変換 = "batchTextFileConvert";
    private static final int INT_1 = 1;
    private static final RString SJIS類似 = new RString("SjisRuiji");
    private static final RString 国保連送付外字_変換区分_1 = new RString("1");
    private static final RString エラーログファイル名 = new RString("errorLogFile_");
    private static final RString ファイル_TYRPE = new RString(".csv");

    private int レコード件数 = 0;
    private List<SharedFileDescriptor> エントリ情報List;
    private RString 入力ファイルパス;
    private RString 出力ファイルパス;
    private Encode 文字コード;

    @Override
    protected void initialize() {
        エントリ情報List = new ArrayList<>();
        RString 国保連送付外字_変換区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (国保連送付外字_変換区分_1.equals(国保連送付外字_変換区分)) {
            文字コード = Encode.UTF_8;
        } else {
            文字コード = Encode.SJIS;
        }
    }

    @Override
    protected void defineFlow() {
        executeStep(送付対象データ取得);
        if (データがある.equals((getResult(RString.class, new RString(送付対象データ取得),
                IdoRenrakuhyoSofuTaishoDataShutokuProcess.PARAMETER_OUT_FLOWFLAG)))) {
            executeStep(送付ファイル作成);
            レコード件数 = getResult(
                    Integer.class, new RString(送付ファイル作成), IdoRenrakuhyoSofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTCOUNT);
            do文字コード変換();
            if (本番処理.equals(getParameter().get処理選択区分())) {
                executeStep(DB更新);
            }
        }
        executeStep(国保連インタフェース管理更新);
        executeStep(処理結果リスト作成);
    }

    /**
     * 総合事業分サービスコード異動連絡票作成情報を取得するクラスです。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand callIdoRenrakuhyoSofuTaishoDataShutokuProcess() {
        return loopBatch(IdoRenrakuhyoSofuTaishoDataShutokuProcess.class).
                arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 送付ファイル作成を行う。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand callIdoRenrakuhyoSofuFileSakuseiProcess() {
        ServicecodeIdoRenrakuhyoOutProcessParameter parameter = getParameter().toProcessParameter();
        parameter.set文字コード(文字コード);
        return loopBatch(IdoRenrakuhyoSofuFileSakuseiProcess.class).arguments(parameter).define();
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
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_ERROR_LOG_FILE_PATH),
                出力ファイルパス.substring(0, 出力ファイルパス.lastIndexOf(File.separator) + 1)
                .concat(エラーログファイル名.concat(YMDHMS.now().toString()).concat(ファイル_TYRPE)));
        return simpleBatch(BatchTextFileConvert.class)
                .arguments(parameter)
                .define();
    }

    /**
     * DB更新を行う。
     *
     * @return IBatchFlowCommand
     */
    @Step(DB更新)
    protected IBatchFlowCommand callIdoRenrakuhyoDBUpdateProcess() {
        return loopBatch(IdoRenrakuhyoDBUpdateProcess.class).arguments(getParameter().toProcessParameter()).define();
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
    protected IBatchFlowCommand callHokenshaKyufujissekiOutListSakuseiProcess() {
        HokenshaKyufujissekiOutListSakuseiProcessParameter parameter
                = new HokenshaKyufujissekiOutListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ0);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getParam() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter param = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        param.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toString()));
        param.set交換情報識別番号(ConfigKeysKokuhorenSofu.総合事業分サービスコード異動連絡票情報.getコード());
        param.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toString()));
        param.setレコード件数合計(レコード件数);
        List<RString> list = new ArrayList<>();
        if (エントリ情報List.isEmpty()) {
            param.setFileNameList(Collections.EMPTY_LIST);
        } else {
            for (SharedFileDescriptor entry : エントリ情報List) {
                list.add(entry.getSharedFileName().toRString());
            }
            param.setFileNameList(list);
        }
        return param;
    }

    private void do文字コード変換() {
        出力ファイルパス = getResult(
                RString.class, new RString(送付ファイル作成), IdoRenrakuhyoSofuFileSakuseiProcess.OUTPUT_PATH);
        if (Encode.UTF_8.equals(文字コード)) {
            入力ファイルパス = getResult(
                    RString.class, new RString(送付ファイル作成), IdoRenrakuhyoSofuFileSakuseiProcess.INPUT_PATH);
            File file = new File(出力ファイルパス.toString());
            if ((file.exists() && file.delete()) || !file.exists()) {
                executeStep(文字コード変換);
            }
            deleteEmptyFile(入力ファイルパス);
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険,
                FilesystemName.fromString(出力ファイルパス.substring(出力ファイルパス.lastIndexOf(File.separator) + INT_1)));
        sfd = SharedFile.defineSharedFile(sfd, 1, SharedFile.GROUP_ALL, null, true, null);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
        SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(出力ファイルパス), opts);
        エントリ情報List.add(sfd);
    }

    private void deleteEmptyFile(RString filePath) {
        if (RString.isNullOrEmpty(filePath)) {
            return;
        }
        File file = new File(filePath.toString());
        if (file.exists()) {
            file.getAbsoluteFile().deleteOnExit();
        }
    }
}
