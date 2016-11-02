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
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110.KogakugassanKyufujissekiCreateSofuFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110.KogakugassanKyufujissekiDoSofuReportProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110.KogakugassanKyufujissekiGetSofuTaishoDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110.KogakugassanKyufujissekiSetSofuJogaiFlagProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110110.KogakugassanKyufujissekiUpdateDBProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110110.DBC110110_KogakugassanKyufujissekiOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiCreateSofuFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiDoSofuReportProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiGetSofuTaishoDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiUpdateDBProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.SofuTaishoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 高額合算給付実績情報作成のバッチflowです。
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
public class DBC110110_KogakugassanKyufujissekiOut extends BatchFlowBase<DBC110110_KogakugassanKyufujissekiOutParameter> {

    private static final String 送付対象データ取得 = "getSofuTaishoData";
    private static final String 被保険者_宛名情報取得 = "getHihokenshaAtena";
    private static final String エラー登録 = "doError";
    private static final String 送付除外区分設定 = "setSofuJogaiFlag";
    private static final String 送付ファイル作成 = "createSofuFile";
    private static final String 帳票出力 = "doSofuReport";
    private static final String DB更新 = "updateDB";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 文字コード変換 = "batchTextFileConvert";
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString 国保連送付外字_変換区分_1 = new RString("1");
    private static final RString SJIS類似 = new RString("SjisRuiji");
    private static final RString バックスラッシュ = new RString("\\");

    private RString 交換情報識別番号;
    private int 合計;
    private SofuTaishoEntity returnEntity;
    private RString 入力ファイルパス;
    private RString 出力ファイルパス;
    private Encode 文字コード;
    private SharedFileDescriptor エントリ情報;

    @Override
    protected void defineFlow() {
        RDate nowDate = RDate.getNowDate();
        交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連送付_高額合算給付実績情報_交換情報識別番号,
                nowDate, SubGyomuCode.DBC介護給付);
        RString 国保連送付外字_変換区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (国保連送付外字_変換区分_1.equals(国保連送付外字_変換区分)) {
            文字コード = Encode.UTF_8;
        } else {
            文字コード = Encode.SJIS;
        }
        executeStep(送付対象データ取得);
        SofuTaishoEntity flowEntity = getResult(SofuTaishoEntity.class, new RString(送付対象データ取得),
                KogakugassanKyufujissekiGetSofuTaishoDataProcess.PARAMETER_OUT_FLOWENTITY);
        合計 = flowEntity.get合計();
        if (INT_0 != 合計) {
            executeStep(被保険者_宛名情報取得);
            executeStep(エラー登録);
            executeStep(送付除外区分設定);
            executeStep(送付ファイル作成);
            returnEntity = getResult(SofuTaishoEntity.class, new RString(送付ファイル作成),
                    KogakugassanKyufujissekiCreateSofuFileProcess.PARAMETER_OUT_OUTRETURNENTITY);
            if (null != returnEntity) {
                do文字コード変換();
            }
            executeStep(帳票出力);
            executeStep(DB更新);
        }
        executeStep(国保連インタフェース管理更新);
        executeStep(処理結果リスト作成);
    }

    /**
     * 送付対象データ取得です。
     *
     * @return KogakugassanKyufujissekiGetSofuTaishoDataProcess
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand getSofuTaishoData() {
        KogakugassanKyufujissekiGetSofuTaishoDataProcessParameter parameter
                = new KogakugassanKyufujissekiGetSofuTaishoDataProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set再処理区分(getParameter().get再処理区分());
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        return loopBatch(KogakugassanKyufujissekiGetSofuTaishoDataProcess.class).arguments(parameter).define();
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
     * 送付除外区分設定です。
     *
     * @return KogakugassanKyufujissekiSetSofuJogaiFlagProcess
     */
    @Step(送付除外区分設定)
    protected IBatchFlowCommand setSofuJogaiFlag() {
        return loopBatch(KogakugassanKyufujissekiSetSofuJogaiFlagProcess.class).define();
    }

    /**
     * 送付ファイル作成です。
     *
     * @return KogakugassanKyufujissekiCreateSofuFileProcess
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand createSofuFile() {
        KogakugassanKyufujissekiCreateSofuFileProcessParameter parameter
                = new KogakugassanKyufujissekiCreateSofuFileProcessParameter();
        parameter.set文字コード(文字コード);
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        return loopBatch(KogakugassanKyufujissekiCreateSofuFileProcess.class).arguments(parameter).define();
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
     * 帳票出力です。
     *
     * @return KogakugassanKyufujissekiDoSofuReportProcess
     */
    @Step(帳票出力)
    protected IBatchFlowCommand doSofuReport() {
        KogakugassanKyufujissekiDoSofuReportProcessParameter parameter
                = new KogakugassanKyufujissekiDoSofuReportProcessParameter();
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        parameter.set出力順ID(getParameter().get出力順ID());
        return loopBatch(KogakugassanKyufujissekiDoSofuReportProcess.class).arguments(parameter).define();
    }

    /**
     * DB更新_送付済です。
     *
     * @return KogakugassanKyufujissekiUpdateDBProcess
     */
    @Step(DB更新)
    protected IBatchFlowCommand updateDB() {
        KogakugassanKyufujissekiUpdateDBProcessParameter parameter
                = new KogakugassanKyufujissekiUpdateDBProcessParameter();
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        return simpleBatch(KogakugassanKyufujissekiUpdateDBProcess.class).arguments(parameter).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KokuhorenkyoutsuDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand doInterfaceKanriKousin() {
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(getKanriKousinProcessParameter()).define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return HokenshaKyufujissekiOutListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand doShoriKekkaListSakusei() {
        HokenshaKyufujissekiOutListSakuseiProcessParameter parameter
                = new HokenshaKyufujissekiOutListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ0);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getKanriKousinProcessParameter() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter returnParameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        returnParameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        returnParameter.set交換情報識別番号(交換情報識別番号);
        if (INT_0 == 合計 || returnEntity == null) {
            returnParameter.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
            returnParameter.setレコード件数合計(INT_0);
            returnParameter.setFileNameList(Collections.EMPTY_LIST);
        } else {
            returnParameter.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
            returnParameter.setレコード件数合計(returnEntity.get総出力件数());
            List<RString> fileNameList = new ArrayList<>();
            fileNameList.add(エントリ情報.getSharedFileName().toRString());
            returnParameter.setFileNameList(fileNameList);
        }
        return returnParameter;
    }

    private void do文字コード変換() {
        出力ファイルパス = returnEntity.get出力ファイルパス();
        if (Encode.UTF_8.equals(文字コード) && returnEntity.get総出力件数() != INT_0) {
            入力ファイルパス = returnEntity.get入力ファイルパス();
            File file = new File(出力ファイルパス.toString());
            if ((file.exists() && file.delete()) || !file.exists()) {
                executeStep(文字コード変換);
            }
            deleteEmptyFile(入力ファイルパス);
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険,
                FilesystemName.fromString(出力ファイルパス.substring(出力ファイルパス.lastIndexOf(バックスラッシュ) + INT_1)));
        sfd = SharedFile.defineSharedFile(sfd, 1, SharedFile.GROUP_ALL, null, true, null);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
        SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(出力ファイルパス), opts);
        エントリ情報 = sfd;
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
