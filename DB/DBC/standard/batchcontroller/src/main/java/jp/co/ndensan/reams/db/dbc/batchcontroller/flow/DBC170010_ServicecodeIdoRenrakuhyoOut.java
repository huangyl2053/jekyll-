/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010.IdoRenrakuhyoDBUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010.IdoRenrakuhyoSofuFileSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010.IdoRenrakuhyoSofuTaishoDataShutokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170010.DBC170010_ServicecodeIdoRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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

    private int レコード件数 = 0;
    private List<SharedFileDescriptor> エントリ情報List = new ArrayList<>();

    @Override
    protected void defineFlow() {
        executeStep(送付対象データ取得);
        if (データがある.equals((getResult(RString.class, new RString(送付対象データ取得),
                IdoRenrakuhyoSofuTaishoDataShutokuProcess.PARAMETER_OUT_FLOWFLAG)))) {
            executeStep(送付ファイル作成);
            レコード件数 = getResult(
                    Integer.class, new RString(送付ファイル作成), IdoRenrakuhyoSofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTCOUNT);
            エントリ情報List = (ArrayList<SharedFileDescriptor>) getResult(
                    List.class, new RString(送付ファイル作成), IdoRenrakuhyoSofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTENTRY);
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
        return loopBatch(IdoRenrakuhyoSofuFileSakuseiProcess.class).arguments(getParameter().toProcessParameter()).define();
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
}
