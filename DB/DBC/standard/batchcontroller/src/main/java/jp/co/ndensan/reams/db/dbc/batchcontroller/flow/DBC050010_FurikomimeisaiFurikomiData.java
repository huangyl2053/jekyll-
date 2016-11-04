/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.EraTourokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.FurikomiDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.FurikomiDataTourokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.FurikomiErrorListCreateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.FurikomiMeisaiListStatusProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.HihokenshaAtenaJohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.KanendoUpdateFutanwariaiHanteiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.KogakuFurikomiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.KogakuShikyuHanteiKekkaCancelProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.KogakuShikyuHanteiKekkaUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.KougakuKozaJohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.KozaJohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.ShikyugakuJohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.ShinseiDataKakuninProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.ShokanHanteiKekkaCancelProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.ShokanHanteiKekkaUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.ShokanJuryoininProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.ShoriKekkaKakuninListDataNasiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.ShoukanFurikomiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010.SyoriResultKakuninListCreateProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC050010.DBC050010_FurikomimeisaiFurikomiDataParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiGyomunaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriTaisho;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.KozaFurikomiTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ux.uxx.definition.batchprm.kozafurikomi.UXX000A10_KozaFurikomiRegisterParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込明細・振込みデータ作成バッチフロークラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
public class DBC050010_FurikomimeisaiFurikomiData extends BatchFlowBase<DBC050010_FurikomimeisaiFurikomiDataParameter> {

    private static final RString 口座振込一時名称 = new RString("DbWT0511KozaFurikomi");
    private static final RString 口座振込データの登録処理BATCH_ID = new RString("UXX000A10_KozaFurikomiRegister");
    private static final RString 振込単位_償還高額同時 = new RString("1");
    private static final RString 振込単位_償還高額個別 = new RString("2");
    private static final RString 処理対象_償還高額_1 = new RString("1");
    private static final RString 処理対象_償還_2 = new RString("2");
    private static final RString 処理対象_高額_3 = new RString("3");
    private static final RString 登録区分_通常 = new RString("1");
    private static final RString 登録区分_差分 = new RString("2");

    private FurikomiGyomunaiKubun 振込業務内区分;
    private static RString 振込単位;
    private static ShoriName 処理名;
    private int レコード件数 = 0;
    private int 振込明細レコード件数 = 0;
    private int 被保険者台帳_宛名情報レコード件数 = 0;
    private RString 帳票ページCount = new RString("0");

    private static final String 口座振込データの登録処理 = "kouzaFurikomiDataInsert";
    private static final String 一時テーブル作成_振込明細 = "tempTableCreateMaisai";
    private static final String 一時テーブル作成_口座振込 = "tempTableCreateKozai";
    private static final String 一時テーブル作成_処理結果確認リスト = "tempTableCreateKakunin";
    private static final String 償還データ取得 = "ShoukanFurikomi";
    private static final String 高額データ取得 = "KogakuFurikomi";
    private static final String 処理結果確認リスト_振込データなし = "ShoriKekkaKakuninListDataNasi";
    private static final String 被保険者台帳_宛名情報 = "HihokenshaAtenaJoho";
    private static final String 被保険者台帳_宛名情報_エラー登録 = "EraTouroku";
    private static final String 還口座払の口座情報 = "KozaJoho";
    private static final String 高額の口座情報 = "KougakuKozaJoho";
    private static final String 償還受領委任払の口座情報 = "ShokanJuryoinin";
    private static final String 振込データ作成 = "FurikomiData";
    private static final String 振込データ登録_口座振込一時処理 = "FurikomiDataTouroku";
    private static final String 依頼済登録_償還 = "ShokanHanteiKekkaUpdate";
    private static final String 依頼済登録_高額介護 = "KogakuShikyuHanteiKekkaUpdate";
    private static final String 依頼済取消_償還 = "ShokanHanteiKekkaCancelProcess";
    private static final String 依頼済取消_高額介護 = "KogakuShikyuHanteiKekkaCancel";
    private static final String 振込明細一覧表作成_受給取得状況 = "FurikomiMeisaiListStatus";
    private static final String 振込明細一覧表作成_申請データ有無確認 = "ShinseiDataKakunin";
    private static final String 振込明細一覧表作成 = "ShikyugakuJoho";
    private static final String 振込エラーリスト作成 = "FurikomiErrorListCreate";
    private static final String 処理結果確認リスト作成 = "SyoriResultKakuninListCreate";
    private static final String 処理日付管理マスタの更新と出力条件表作成 = "KanendoUpdateFutanwariaiHantei";

    @Override
    protected void prepareConfigData() {

    }

    @Override
    protected void initialize() {
        振込単位 = DbBusinessConfig.get(ConfigNameDBC.振込単位, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        DBC050010_FurikomimeisaiFurikomiDataParameter parameter = getParameter();

        if (Furikomi_ShoriTaisho.償還高額.equals(parameter.get処理対象())) {
            振込業務内区分 = FurikomiGyomunaiKubun.償還高額;
            処理名 = ShoriName.給付振込データ作成_償還高額;
        }

        if (Furikomi_ShoriTaisho.償還.equals(parameter.get処理対象())) {
            if (振込単位_償還高額同時.equals(振込単位)) {
                振込業務内区分 = FurikomiGyomunaiKubun.償還高額;
                処理名 = ShoriName.給付振込データ作成_償還高額;
            }
            if (振込単位_償還高額個別.equals(振込単位)) {
                振込業務内区分 = FurikomiGyomunaiKubun.償還;
                処理名 = ShoriName.給付振込データ作成_償還;
            }
        }
        if (Furikomi_ShoriTaisho.高額.equals(parameter.get処理対象())) {
            if (振込単位_償還高額同時.equals(振込単位)) {
                振込業務内区分 = FurikomiGyomunaiKubun.償還高額;
                処理名 = ShoriName.給付振込データ作成_償還高額;
            }
            if (振込単位_償還高額個別.equals(振込単位)) {
                振込業務内区分 = FurikomiGyomunaiKubun.高額;
                処理名 = ShoriName.給付振込データ作成_高額;
            }
        }
    }

    @Override
    protected void defineFlow() {
        executeStep(一時テーブル作成_振込明細);
        executeStep(一時テーブル作成_口座振込);
        executeStep(一時テーブル作成_処理結果確認リスト);
        if (処理対象_償還高額_1.equals(getParameter().get処理対象().getコード())
                || 処理対象_償還_2.equals(getParameter().get処理対象().getコード())) {
            executeStep(償還データ取得);
        }
        if (処理対象_償還高額_1.equals(getParameter().get処理対象().getコード())
                || 処理対象_高額_3.equals(getParameter().get処理対象().getコード())) {
            executeStep(高額データ取得);
        }
        executeStep(処理結果確認リスト_振込データなし);
        振込明細レコード件数 = getResult(
                Integer.class, new RString(処理結果確認リスト_振込データなし),
                ShoriKekkaKakuninListDataNasiProcess.PARAMETER_OUT_COUNT);

        if (0 != 振込明細レコード件数) {
            executeStep(被保険者台帳_宛名情報);
            被保険者台帳_宛名情報レコード件数 = getResult(
                    Integer.class, new RString(被保険者台帳_宛名情報),
                    HihokenshaAtenaJohoProcess.PARAMETER_OUT_COUNT);

            if (0 == 被保険者台帳_宛名情報レコード件数) {
                executeStep(被保険者台帳_宛名情報_エラー登録);
            }
            executeStep(還口座払の口座情報);
            executeStep(高額の口座情報);
            executeStep(償還受領委任払の口座情報);
            振込データ登録処理();
            if (0 != レコード件数 || Furikomi_ShoriKubun.明細一覧表作成.equals(getParameter().get処理区分())) {
                振込データ登録_口座振込一時0件以外処理();
            }
        }

        executeStep(処理結果確認リスト作成);
        executeStep(処理日付管理マスタの更新と出力条件表作成);
    }

    /**
     * 一時テーブル作成_振込明細
     *
     * @return IBatchFlowCommand
     */
    @Step(一時テーブル作成_振込明細)
    protected IBatchFlowCommand tempTableCreate() {
        return createTempTable(FurikomiDetailTempTableEntity.TABLE_NAME, FurikomiDetailTempTableEntity.class).define();
    }

    /**
     * 一時テーブル作成_口座振込
     *
     * @return IBatchFlowCommand
     */
    @Step(一時テーブル作成_口座振込)
    protected IBatchFlowCommand tempTableCreateKozai() {
        return createTempTable(KozaFurikomiTempTableEntity.TABLE_NAME, KozaFurikomiTempTableEntity.class).define();
    }

    /**
     * 一時テーブル作成_処理結果確認リスト
     *
     * @return IBatchFlowCommand
     */
    @Step(一時テーブル作成_処理結果確認リスト)
    protected IBatchFlowCommand tempTableCreateKakunin() {
        return createTempTable(ShoriKekkaKakuninListTempTableEntity.TABLE_NAME, ShoriKekkaKakuninListTempTableEntity.class).define();
    }

    /**
     * 償還データ取得
     *
     * @return IBatchFlowCommand
     */
    @Step(償還データ取得)
    protected IBatchFlowCommand shoukanFurikomi() {
        return loopBatch(ShoukanFurikomiProcess.class).arguments(getParameter().toFurikomimeisaiFurikomiProcessParameter()).define();
    }

    /**
     * 高額データ取得
     *
     * @return IBatchFlowCommand
     */
    @Step(高額データ取得)
    protected IBatchFlowCommand kogakuFurikomi() {
        return loopBatch(KogakuFurikomiProcess.class).arguments(getParameter().toGdaekomimeisaiFurikomiProcessParameter()).define();
    }

    /**
     * 被保険者台帳_宛名情報
     *
     * @return IBatchFlowCommand
     */
    @Step(被保険者台帳_宛名情報)
    protected IBatchFlowCommand hihokenshaAtenaJoho() {
        return loopBatch(HihokenshaAtenaJohoProcess.class).arguments(getParameter().toHihokenshaAtenaProcessParameter()).define();
    }

    /**
     * 被保険者台帳_宛名情報_エラー登録
     *
     * @return IBatchFlowCommand
     */
    @Step(被保険者台帳_宛名情報_エラー登録)
    protected IBatchFlowCommand eraTouroku() {
        return loopBatch(EraTourokuProcess.class).define();
    }

    /**
     * 還口座払の口座情報
     *
     * @return IBatchFlowCommand
     */
    @Step(還口座払の口座情報)
    protected IBatchFlowCommand kozaJoho() {
        return loopBatch(KozaJohoProcess.class)
                .arguments(getParameter().toKozaJohoProcessParameter()).define();
    }

    /**
     * 高額の口座情報
     *
     * @return IBatchFlowCommand
     */
    @Step(高額の口座情報)
    protected IBatchFlowCommand kougakuKozaJoho() {
        return loopBatch(KougakuKozaJohoProcess.class).define();
    }

    /**
     * 償還受領委任払の口座情報
     *
     * @return IBatchFlowCommand
     */
    @Step(償還受領委任払の口座情報)
    protected IBatchFlowCommand shokanJuryoinin() {
        return loopBatch(ShokanJuryoininProcess.class).arguments(getParameter().toKozaJohoProcessParameter()).define();
    }

    /**
     * 振込データ作成
     *
     * @return IBatchFlowCommand
     */
    @Step(振込データ作成)
    protected IBatchFlowCommand furikomiData() {
        return loopBatch(FurikomiDataProcess.class)
                .arguments(getParameter().toFurikomiDataProcessParameter(振込業務内区分))
                .define();
    }

    /**
     * 処理結果確認リスト_振込データなし
     *
     * @return IBatchFlowCommand
     */
    @Step(処理結果確認リスト_振込データなし)
    protected IBatchFlowCommand shoriKekkaKakuninListDataNasi() {
        return loopBatch(ShoriKekkaKakuninListDataNasiProcess.class).define();
    }

    /**
     * 振込データ登録_口座振込一時処理
     *
     * @return IBatchFlowCommand
     */
    @Step(振込データ登録_口座振込一時処理)
    protected IBatchFlowCommand furikomiDataTouroku() {
        return loopBatch(FurikomiDataTourokuProcess.class)
                .arguments(getParameter().toFurikomiDataTourokuProcessParameter()).define();
    }

    /**
     * 口座振込データの登録処理
     *
     * @return IBatchFlowCommand
     */
    @Step(口座振込データの登録処理)
    protected IBatchFlowCommand callGetKouzaFurikomiProcess() {
        return otherBatchFlow(口座振込データの登録処理BATCH_ID, SubGyomuCode.UXX公開共通, createKozaFurikomiRegisterParameter()).define();
    }

    /**
     * 依頼済登録_償還
     *
     * @return IBatchFlowCommand
     */
    @Step(依頼済登録_償還)
    protected IBatchFlowCommand shokanHanteiKekkaUpdate() {
        return loopBatch(ShokanHanteiKekkaUpdateProcess.class).define();
    }

    /**
     * 依頼済登録_高額介護
     *
     * @return IBatchFlowCommand
     */
    @Step(依頼済登録_高額介護)
    protected IBatchFlowCommand kogakuShikyuHanteiKekkaUpdate() {
        return loopBatch(KogakuShikyuHanteiKekkaUpdateProcess.class).define();
    }

    /**
     * 依頼済取消_償還
     *
     * @return IBatchFlowCommand
     */
    @Step(依頼済取消_償還)
    protected IBatchFlowCommand shokanHanteiKekkaCancel() {
        return loopBatch(ShokanHanteiKekkaCancelProcess.class).define();
    }

    /**
     * 依頼済取消_高額介護
     *
     * @return IBatchFlowCommand
     */
    @Step(依頼済取消_高額介護)
    protected IBatchFlowCommand kogakuShikyuHanteiKekkaCancel() {
        return loopBatch(KogakuShikyuHanteiKekkaCancelProcess.class).define();
    }

    /**
     * 振込明細一覧表作成_受給取得状況
     *
     * @return IBatchFlowCommand
     */
    @Step(振込明細一覧表作成_受給取得状況)
    protected IBatchFlowCommand furikomiMeisaiListStatus() {
        return loopBatch(FurikomiMeisaiListStatusProcess.class).define();
    }

    /**
     * 振込明細一覧表作成_申請データ有無確認
     *
     * @return IBatchFlowCommand
     */
    @Step(振込明細一覧表作成_申請データ有無確認)
    protected IBatchFlowCommand shinseiDataKakunin() {
        return loopBatch(ShinseiDataKakuninProcess.class).define();
    }

    /**
     * 振込明細一覧表作成
     *
     * @return IBatchFlowCommand
     */
    @Step(振込明細一覧表作成)
    protected IBatchFlowCommand shikyugakuJoho() {
        return loopBatch(ShikyugakuJohoProcess.class).arguments(getParameter().toShikyugakuJohoProcessParameter()).define();
    }

    /**
     * 振込エラーリスト作成
     *
     * @return IBatchFlowCommand
     */
    @Step(振込エラーリスト作成)
    protected IBatchFlowCommand furikomiErrorListCreate() {
        return loopBatch(FurikomiErrorListCreateProcess.class).define();
    }

    /**
     * 処理結果確認リスト作成
     *
     * @return IBatchFlowCommand
     */
    @Step(処理結果確認リスト作成)
    protected IBatchFlowCommand syoriResultKakuninListCreate() {
        return loopBatch(SyoriResultKakuninListCreateProcess.class).define();
    }

    /**
     * 処理日付管理マスタの更新と出力条件表作成
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタの更新と出力条件表作成)
    protected IBatchFlowCommand kanendoUpdateFutanwariaiHantei() {
        return loopBatch(KanendoUpdateFutanwariaiHanteiProcess.class)
                .arguments(getParameter().toKanendoUpdateFutanwariaiHanteProcessParameter(処理名, 帳票ページCount)).define();
    }

    private UXX000A10_KozaFurikomiRegisterParameter createKozaFurikomiRegisterParameter() {
        UXX000A10_KozaFurikomiRegisterParameter parameter = new UXX000A10_KozaFurikomiRegisterParameter();
        parameter.setTempTableName(口座振込一時名称);
        parameter.setDaihyoKinyuKikanCode(getParameter().get代表金融機関コード());
        parameter.setFurikomiGroupCode(getParameter().get振込グループコード());
        parameter.setFurikomiYMD(getParameter().get振込指定年月日());
        if (getParameter().is再処理フラグ()) {
            parameter.setTourokuKubun(登録区分_通常);
        } else {
            parameter.setTourokuKubun(登録区分_差分);
        }
        return parameter;
    }

    private void 振込データ登録_口座振込一時0件以外処理() {

        executeStep(振込明細一覧表作成_受給取得状況);
        executeStep(振込明細一覧表作成_申請データ有無確認);
        executeStep(振込明細一覧表作成);
        帳票ページCount = getResult(
                RString.class, new RString(振込明細一覧表作成),
                ShikyugakuJohoProcess.PARAMETER_OUT_PAGE_COUNT);

        if (!(Furikomi_ShoriKubun.明細一覧表作成.equals(getParameter().get処理区分())
                && Furikomi_ShihraiHohoShitei.窓口.equals(getParameter().get支払方法()))) {
            executeStep(振込エラーリスト作成);
        }
    }

    private void 振込データ登録処理() {
        if (!(Furikomi_ShoriKubun.明細一覧表作成.equals(getParameter().get処理区分()))) {
            executeStep(振込データ作成);
            executeStep(振込データ登録_口座振込一時処理);

            レコード件数 = getResult(
                    Integer.class, new RString(振込データ登録_口座振込一時処理),
                    FurikomiDataTourokuProcess.PARAMETER_OUT_COUNT);
            if (0 != レコード件数) {
                executeStep(口座振込データの登録処理);
            }

            if (処理対象_償還高額_1.equals(getParameter().get処理対象().getコード())
                    || 処理対象_償還_2.equals(getParameter().get処理対象().getコード())) {

                executeStep(依頼済登録_償還);
                executeStep(依頼済取消_償還);
            }
            if (処理対象_償還高額_1.equals(getParameter().get処理対象().getコード())
                    || 処理対象_高額_3.equals(getParameter().get処理対象().getコード())) {
                executeStep(依頼済登録_高額介護);
                executeStep(依頼済取消_高額介護);
            }
        }
    }
}
