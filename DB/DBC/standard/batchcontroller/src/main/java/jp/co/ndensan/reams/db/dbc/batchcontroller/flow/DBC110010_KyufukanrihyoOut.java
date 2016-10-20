/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.JigyoshaNameOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.KyotakuKeikakuJikosakuseiKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.KyufuKanrihyoSofuIchiranDoBillOutProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.KyufuKanrihyoSokatsuhyoDoBillOutProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.KyufukanrihyoOutDoBillOutProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.KyufukanrihyoOutGetjigyoshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.KyufukanrihyoOutGetkaigojigyoshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.KyufukanrihyoOutHokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.YoboKeikakuJikoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.UpdateKyotakuNissuprocess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010.UpdateYoboKeikakuNissuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110010.DBC110010_KyufukanrihyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110900.DBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGetParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成のクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class DBC110010_KyufukanrihyoOut extends BatchFlowBase<DBC110010_KyufukanrihyoOutParameter> {

    private static final String 送付対象データ取得 = "getSofuTaishoData";
    private static final String 支給限度額情報取得 = "getYoboKeikakuJikoSakuseiData";
    private static final String 介護事業者指定サービス事業者名称取得 = "callGetjigyoshaServiceNameProcess";
    private static final String 事業者名称取得 = "callGetjigyoshaNameProcess";
    private static final String エラー登録 = "callDoErrorrProcess";
    private static final String 給付管理票作成 = "callKyufukanrihyoOutDoBillOutProcess";
    private static final String 給付管理票送付一覧表作成 = "callKyufuKanrihyoSofuIchiranDoBillOutProcess";
    private static final String 給付管理票総括票作成 = "callKyufuKanrihyoSokatsuhyoDoBillOutProcess";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 居宅給付日数更新 = "updateKyotakuNissuprocess";
    private static final String 予防給付日数更新 = "updateYoboKeikakuNissuProcess";
    private static final String 保険者番号取込 = "callKyufukanrihyoOutHokenshaNoProcess";
    private static final String 証記載保険者番号取得 = "callDBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGet";
    private static final RString 証記載保険者番号取得BATCHID = new RString("DBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGet");
    private static final String 被保険者_宛名情報取得 = "callHokenshaKyufujissekiOutHihokenshaAtenaFlow";
    private static RString 交換情報識別番号;
    private List<SharedFileDescriptor> エントリ情報List;
    private int レコード件数合計 = 0;
    private int 連番 = 0;

    @Override
    protected void defineFlow() {
        エントリ情報List = new ArrayList<>();
        交換情報識別番号 = DbBusinessConfig.get(
                ConfigNameDBC.国保連送付_再審査申立書情報_交換情報識別番号,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        executeStep(送付対象データ取得);
        連番 = getResult(Integer.class, new RString(送付対象データ取得),
                KyotakuKeikakuJikosakuseiKanriProcess.PARAMETER_OUT_OUTCOUNT);

        executeStep(支給限度額情報取得);
        int 登録件数 = getResult(Integer.class, new RString(送付対象データ取得),
                YoboKeikakuJikoSakuseiProcess.PARAMETER_OUT_OUTCOUNT);
        if (登録件数 != 0) {
            executeStep(証記載保険者番号取得);
            executeStep(保険者番号取込);
            executeStep(被保険者_宛名情報取得);
            executeStep(介護事業者指定サービス事業者名称取得);
            executeStep(事業者名称取得);
            executeStep(エラー登録);
            executeStep(給付管理票作成);
            executeStep(給付管理票送付一覧表作成);
            executeStep(給付管理票総括票作成);
            レコード件数合計 = getResult(
                    Integer.class, new RString(給付管理票総括票作成), KyufuKanrihyoSokatsuhyoDoBillOutProcess.PARAMETER_OUT_OUTPUTCOUNT);
            List<SharedFileDescriptor> list = (ArrayList<SharedFileDescriptor>) getResult(
                    List.class, new RString(給付管理票総括票作成), KyufuKanrihyoSokatsuhyoDoBillOutProcess.PARAMETER_OUT_OUTPUTENTRY);
            this.エントリ情報List.addAll(list);
            executeStep(居宅給付日数更新);
            executeStep(予防給付日数更新);
        }
        executeStep(国保連インタフェース管理更新);
        executeStep(処理結果リスト作成);

    }

    /**
     * 送付対象データ取得です。
     *
     * @return KogakugassanShikyushinseishoOutGetSofuTaishoDataProcess
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand getSofuTaishoData() {
        return loopBatch(KyotakuKeikakuJikosakuseiKanriProcess.class).arguments(getParameter().toKyufukanrihyoOutProcessParameter()).define();
    }

    /**
     * 支給限度額情報データ取得です。
     *
     * @return YoboKeikakuJikoSakuseiProcess
     */
    @Step(支給限度額情報取得)
    protected IBatchFlowCommand getYoboKeikakuJikoSakuseiData() {
        getParameter().set連番(連番);
        return loopBatch(YoboKeikakuJikoSakuseiProcess.class).arguments(getParameter().toKyufukanrihyoOutProcessParameter()).define();
    }

    /**
     * 証記載保険者番号取得バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(証記載保険者番号取得)
    protected IBatchFlowCommand callDBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGet() {
        DBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGetParameter paramter = new DBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGetParameter();
        return otherBatchFlow(証記載保険者番号取得BATCHID, SubGyomuCode.DBC介護給付, paramter).define();
    }

    /**
     * 保険者番号取込を実行する。
     *
     * @return バッチコマンド
     */
    @Step(保険者番号取込)
    protected IBatchFlowCommand callKyufukanrihyoOutHokenshaNoProcess() {
        return loopBatch(KyufukanrihyoOutHokenshaNoProcess.class).define();
    }

    /**
     * 被保険者_宛名情報取得です。
     *
     * @return HokenshaKyufujissekiOutGetHihokenshaAtenaProcess
     */
    @Step(被保険者_宛名情報取得)
    protected IBatchFlowCommand callHokenshaKyufujissekiOutHihokenshaAtenaFlow() {
        return loopBatch(HokenshaKyufujissekiOutGetHihokenshaAtenaProcess.class).define();
    }

    /**
     * 介護事業者名称取得です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameProcess
     */
    @Step(介護事業者指定サービス事業者名称取得)
    protected IBatchFlowCommand callGetjigyoshaServiceNameProcess() {
        return loopBatch(KyufukanrihyoOutGetjigyoshaNameProcess.class).define();
    }

    /**
     * 介護事業者名称取得です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameProcess
     */
    @Step(事業者名称取得)
    protected IBatchFlowCommand callGetjigyoshaNameProcess() {
        return loopBatch(KyufukanrihyoOutGetkaigojigyoshaNameProcess.class).define();
    }

    /**
     * エラー登録です。
     *
     * @return HokenshaKyufujissekiOutDoErrorProcess
     */
    @Step(エラー登録)
    protected IBatchFlowCommand callDoErrorrProcess() {
        return loopBatch(JigyoshaNameOutDoErrorProcess.class).define();

    }

    /**
     * 給付管理票作成。
     *
     * @return HokenshaKyufujissekiOutDoErrorProcess
     */
    @Step(給付管理票作成)
    protected IBatchFlowCommand callKyufukanrihyoOutDoBillOutProcess() {
        return loopBatch(KyufukanrihyoOutDoBillOutProcess.class).arguments(getParameter().toKyufukanrihyoOutProcessParameter()).define();

    }

    /**
     * 給付管理票作成。
     *
     * @return HokenshaKyufujissekiOutDoErrorProcess
     */
    @Step(給付管理票送付一覧表作成)
    protected IBatchFlowCommand callKyufuKanrihyoSofuIchiranDoBillOutProcess() {
        return loopBatch(KyufuKanrihyoSofuIchiranDoBillOutProcess.class).arguments(getParameter().toKyufukanrihyoOutProcessParameter()).define();
    }

    /**
     * 給付管理票総括票作成。
     *
     * @return HokenshaKyufujissekiOutDoErrorProcess
     */
    @Step(給付管理票総括票作成)
    protected IBatchFlowCommand callKyufuKanrihyoSokatsuhyoDoBillOutProcess() {
        return loopBatch(KyufuKanrihyoSokatsuhyoDoBillOutProcess.class).arguments(getParameter().toKyufukanrihyoOutProcessParameter()).define();
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
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ4);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 居宅給付日数更新。
     *
     * @return IBatchFlowCommand
     */
    @Step(居宅給付日数更新)
    protected IBatchFlowCommand updateKyotakuNissuprocess() {
        return loopBatch(UpdateKyotakuNissuprocess.class).arguments(getParameter().toKyufukanrihyoOutProcessParameter()).define();
    }

    /**
     * 予防給付日数更新。
     *
     * @return IBatchFlowCommand
     */
    @Step(予防給付日数更新)
    protected IBatchFlowCommand updateYoboKeikakuNissuProcess() {
        return loopBatch(UpdateYoboKeikakuNissuProcess.class).arguments(getParameter().toKyufukanrihyoOutProcessParameter()).define();
    }

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getParam() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter param = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        param.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        param.set交換情報識別番号(交換情報識別番号);
        param.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        param.setレコード件数合計(レコード件数合計);
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
