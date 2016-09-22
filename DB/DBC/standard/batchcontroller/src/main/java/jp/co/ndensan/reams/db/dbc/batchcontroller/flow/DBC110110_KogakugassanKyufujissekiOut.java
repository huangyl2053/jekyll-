/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110110.KogakugassanKyufujissekiCreateSofuFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110110.KogakugassanKyufujissekiDoSofuReportProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110110.KogakugassanKyufujissekiGetSofuTaishoDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110110.KogakugassanKyufujissekiSetSofuJogaiFlagProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110110.KogakugassanKyufujissekiUpdateDBProcess;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
    private static final String DB更新_送付済 = "updateDBSofusumi";
    private static final String DB更新_未送付 = "updateDBMisofu";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final int INT_0 = 0;

    private RString 交換情報識別番号;
    private int 合計;
    private SofuTaishoEntity returnEntity;

    @Override
    protected void defineFlow() {
        RDate nowDate = RDate.getNowDate();
        交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連送付_高額合算給付実績情報_交換情報識別番号,
                nowDate, SubGyomuCode.DBC介護給付);
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
            executeStep(帳票出力);
            executeStep(DB更新_送付済);
            executeStep(DB更新_未送付);
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
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        return loopBatch(KogakugassanKyufujissekiCreateSofuFileProcess.class).arguments(parameter).define();
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
    @Step(DB更新_送付済)
    protected IBatchFlowCommand updateDBSofusumi() {
        // TODO QA1439
        KogakugassanKyufujissekiUpdateDBProcessParameter parameter
                = new KogakugassanKyufujissekiUpdateDBProcessParameter();
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        parameter.set送付除外フラグ(false);
        return loopBatch(KogakugassanKyufujissekiUpdateDBProcess.class).arguments(parameter).define();
    }

    /**
     * DB更新_未送付です。
     *
     * @return KogakugassanKyufujissekiUpdateDBProcess
     */
    @Step(DB更新_未送付)
    protected IBatchFlowCommand updateDBMisofu() {
        // TODO QA1439
        KogakugassanKyufujissekiUpdateDBProcessParameter parameter
                = new KogakugassanKyufujissekiUpdateDBProcessParameter();
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        parameter.set送付除外フラグ(true);
        return loopBatch(KogakugassanKyufujissekiUpdateDBProcess.class).arguments(parameter).define();
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
            fileNameList.add(returnEntity.getエントリ情報().getSharedFileName().toRString());
            returnParameter.setFileNameList(fileNameList);
        }
        return returnParameter;
    }

}
