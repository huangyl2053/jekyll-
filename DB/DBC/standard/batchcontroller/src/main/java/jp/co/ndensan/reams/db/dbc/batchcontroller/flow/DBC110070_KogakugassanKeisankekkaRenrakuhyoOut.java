/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070.GassanShikyugakuKeisankekkaRanrakuhyoSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070.SofuFileSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070.SofuJogaiKubunSeteiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070.SofuTaishoDataShutokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070.SofuTaishoDataShutokuUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070.UpdateKogakuGassanShikyuGakuKeisanKekkaMiSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110070.UpdateKogakuGassanShikyuGakuKeisanKekkaSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110070.DBC110070_KogakugassanKeisankekkaRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算計算結果連絡票情報作成のバッチフロークラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class DBC110070_KogakugassanKeisankekkaRenrakuhyoOut extends BatchFlowBase<DBC110070_KogakugassanKeisankekkaRenrakuhyoOutParameter> {

    private static final RString データがある = new RString("1");
    private static final RString 宛名情報取得BATCHID = new RString("HokenshaKyufujissekiOutHihokenshaAtenaFlow");
    private static final String 国保連インタフェース管理更新 = "kokuhorenkyoutsuDoInterfaceKanriKousinProcess";
    private static final String 処理結果リスト作成 = "hokenshaKyufujissekiOutListSakuseiProcess";

    private static final String 送付対象データ取得 = "SofuTaishoDataShutoku";
    private static final String 明細データ存在確認 = "SofuTaishoDataShutokuUpdate";
    private static final String 宛名情報取得 = "getAtenaJoho";
    private static final String 送付除外区分設定 = "sofuJogaiKubunSetei";
    private static final String 送付ファイル作成 = "sofuFileKakutei";
    private static final String 送付一覧表作成 = "sofuItiranhyoSakusei";
    private static final String DB更新_送付済 = "updateKogakuGassanSofu";
    private static final String DB更新_未送付 = "updateKogakuGassanMiSofu";

    private int レコード件数 = 0;
    private List<SharedFileDescriptor> エントリ情報List = new ArrayList<>();

    @Override
    protected void defineFlow() {
        executeStep(送付対象データ取得);
        if (データがある.equals((getResult(RString.class, new RString(送付対象データ取得), SofuTaishoDataShutokuProcess.PARAMETER_OUT_FLOWFLAG)))) {
            executeStep(明細データ存在確認);
            executeStep(宛名情報取得);
            executeStep(送付除外区分設定);
            executeStep(送付ファイル作成);
            レコード件数 = getResult(
                    Integer.class, new RString(送付ファイル作成), SofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTCOUNT);
            エントリ情報List = (ArrayList<SharedFileDescriptor>) getResult(
                    List.class, new RString(送付ファイル作成), SofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTENTRY);

            executeStep(送付一覧表作成);
            executeStep(DB更新_送付済);
            executeStep(DB更新_未送付);
        }
        executeStep(国保連インタフェース管理更新);
        executeStep(処理結果リスト作成);
    }

    /**
     * 高額合算計算結果連絡票情報を取得するクラスです。
     *
     * @return DoBatchTokuchoDoteiProcess
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand callSofuTaishoDataShutokuProcess() {
        return loopBatch(SofuTaishoDataShutokuProcess.class).
                arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 明細データ存在確認を行う。
     *
     * @return IBatchFlowCommand
     */
    @Step(明細データ存在確認)
    protected IBatchFlowCommand callSofuTaishoDataShutokuUpdate() {
        return loopBatch(SofuTaishoDataShutokuUpdateProcess.class).define();
    }

    /**
     * 宛名情報を取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(宛名情報取得)
    protected IBatchFlowCommand callGetAtenaProcess() {
        return otherBatchFlow(宛名情報取得BATCHID, SubGyomuCode.DBC介護給付, null).define();
    }

    /**
     * 送付除外区分設定を行う。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付除外区分設定)
    protected IBatchFlowCommand callSoufuSetteiProcess() {
        return loopBatch(SofuJogaiKubunSeteiProcess.class).define();
    }

    /**
     * 送付ファイル作成を行う。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand callSoufuFairuSakuseiProcess() {
        return loopBatch(SofuFileSakuseiProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 送付一覧表作成を行う。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付一覧表作成)
    protected IBatchFlowCommand callGassanShikyugakuKeisankekkaRanrakuhyoSofuProcess() {
        return loopBatch(GassanShikyugakuKeisankekkaRanrakuhyoSofuProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 「未送付」の登録処理を行う。
     *
     * @return IBatchFlowCommand
     */
    @Step(DB更新_送付済)
    protected IBatchFlowCommand callUpdateKogakuGassanSofuProcess() {
        return loopBatch(UpdateKogakuGassanShikyuGakuKeisanKekkaSofuProcess.class)
                .arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 「未送付」の登録処理を行う。
     *
     * @return IBatchFlowCommand
     */
    @Step(DB更新_未送付)
    protected IBatchFlowCommand callUpdateKogakuGassanMiSofuProcess() {
        return loopBatch(UpdateKogakuGassanShikyuGakuKeisanKekkaMiSofuProcess.class).define();
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
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ2);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getParam() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter param = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        param.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toString()));
        param.set交換情報識別番号(ConfigKeysKokuhorenSofu.高額合算計算結果連絡票情報.getコード());

        param.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toString()));
        param.setレコード件数合計(レコード件数);
        List<RString> list = new ArrayList<>();
        if (0 == レコード件数) {
            param.setFileNameList(Collections.EMPTY_LIST);
        } else {
            for (SharedFileDescriptor entry : エントリ情報List) {
                list.add(entry.getSharedFileName().toRString());
            }
            param.setFileNameList(list);
        }
        return param;
    }
}
