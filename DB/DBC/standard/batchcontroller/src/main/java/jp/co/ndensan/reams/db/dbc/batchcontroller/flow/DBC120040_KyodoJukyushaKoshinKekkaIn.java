/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120040.CreateKyodoJukyushaKoshinkekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5C3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5C4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5D3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5D4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5E3Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptable5E4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.IchiTmpTableTorokuProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120040.DBC120040_KyodoJukyushaKoshinKekkaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C31KihonKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C32ShoukanKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C33KougakuKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetManager;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileReceivedDeleteManager;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuHihokansyaKanrenManager;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuInterfaceKanriKousinManager;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuSyoriKekkaListSakuseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計書_DBCMNF2002-5C3、5D3、5E3_共同処理用受給者情報更新結果情報取込クラスです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
public class DBC120040_KyodoJukyushaKoshinKekkaIn extends BatchFlowBase<DBC120040_KyodoJukyushaKoshinKekkaInParameter> {

    private static final RString TABLE_基本共同処理一時TBL = new RString("DbWT5C31KihonKyoudouShori");
    private static final RString TABLE_償還共同処理一時TBL = new RString("DbWT5C32ShoukanKyoudouShori");
    private static final RString TABLE_高額共同処理一時TBL = new RString("DbWT5C33KougakuKyoudouShori");
    private static final RString 基本情報_5C3 = new RString("5C3");
    private static final RString 償還情報_5D3 = new RString("5D3");
    private static final RString 高額情報_5E3 = new RString("5E3");
    private static final RString 基本情報_5C4 = new RString("5C4");
    private static final RString 償還情報_5D4 = new RString("5D4");
    private static final RString 高額情報_5E4 = new RString("5E4");
    private static final int ENDINDEX = 5;
    private static final String 一時TBL基本情報_5C3作成 = "一時TBL基本情報_5C3作成";
    private static final String 一時TBL償還情報_5D3作成 = "一時TBL償還情報_5D3作成";
    private static final String 一時TBL高額情報_5E3作成 = "一時TBL高額情報_5E3作成";
    private static final String 一時TBL基本情報_5C4作成 = "一時TBL基本情報_5C4作成";
    private static final String 一時TBL償還情報_5D4作成 = "一時TBL償還情報_5D4作成";
    private static final String 一時TBL高額情報_5E4作成 = "一時TBL高額情報_5E4作成";
    private static final String 一時TBLの登録 = "一時TBLの登録";
    private static final String 共同処理用受給者情報一覧表 = "共同処理用受給者情報一覧表";
    private static final String CREATE基本共同処理一時TBL = "CREATE基本共同処理一時TBL";
    private static final String CREATE償還共同処理一時TBL = "CREATE償還共同処理一時TBL";
    private static final String CREATE高額共同処理一時TBL = "CREATE高額共同処理一時TBL";
    private RString 保存先フォルダのパス;
    private List<RString> ファイル名List;
    private List<SharedFileEntryDescriptor> entityList;
    private Integer レコード総件数;
    private RString ファイル名;
    private RString 処理対象年月;

    @Override
    protected void defineFlow() {
        executeStep(CREATE基本共同処理一時TBL);
        executeStep(CREATE償還共同処理一時TBL);
        executeStep(CREATE高額共同処理一時TBL);
        RString 交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_共同処理用受給者情報更新結果_交換情報識別番号,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        getファイル(交換情報識別番号);
        レコード総件数 = 0;
        for (RString csvファイル名 : ファイル名List) {
            ファイル名 = csvファイル名;
            try {
                if (基本情報_5C3.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL基本情報_5C3作成);
                    レコード総件数 = レコード総件数 + getResult(Integer.class, new RString(一時TBL基本情報_5C3作成),
                            CreateTmptable5C3Process.レコード件数);
                } else if (償還情報_5D3.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL償還情報_5D3作成);
                    レコード総件数 = レコード総件数 + getResult(Integer.class, new RString(一時TBL基本情報_5C3作成),
                            CreateTmptable5C3Process.レコード件数);
                } else if (高額情報_5E3.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL高額情報_5E3作成);
                    レコード総件数 = レコード総件数 + getResult(Integer.class, new RString(一時TBL基本情報_5C3作成),
                            CreateTmptable5C3Process.レコード件数);
                } else if (基本情報_5C4.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL基本情報_5C4作成);
                    レコード総件数 = レコード総件数 + getResult(Integer.class, new RString(一時TBL基本情報_5C3作成),
                            CreateTmptable5C3Process.レコード件数);
                } else if (償還情報_5D4.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL償還情報_5D4作成);
                    レコード総件数 = レコード総件数 + getResult(Integer.class, new RString(一時TBL基本情報_5C3作成),
                            CreateTmptable5C3Process.レコード件数);
                } else if (高額情報_5E4.equals(ファイル名.substring(2, ENDINDEX))) {
                    executeStep(一時TBL高額情報_5E4作成);
                    レコード総件数 = レコード総件数 + getResult(Integer.class, new RString(一時TBL基本情報_5C3作成),
                            CreateTmptable5C3Process.レコード件数);
                }
            } catch (Exception e) {
                throw new BatchInterruptedException(e.getMessage());
            }
            処理対象年月 = getResult(RString.class, new RString(一時TBL基本情報_5C3作成), CreateTmptable5C3Process.処理対象年月);
        }
        executeStep(一時TBLの登録);
        int 登録件数 = getResult(Integer.class, new RString(一時TBLの登録), IchiTmpTableTorokuProcess.登録件数);
        if (登録件数 == 0) {
            国保連インタフェース管理更新(getParameter().get処理年月(), 交換情報識別番号, new FlexibleYearMonth(処理対象年月), レコード総件数, ファイル名List);
            処理結果リスト作成();
            取込済ファイル削除(new FlexibleYearMonth(処理対象年月), 保存先フォルダのパス, entityList);
        } else {
            被保険者関連処理();
            国保連インタフェース管理更新(getParameter().get処理年月(), 交換情報識別番号, new FlexibleYearMonth(処理対象年月), レコード総件数, ファイル名List);
            executeStep(共同処理用受給者情報一覧表);
            処理結果リスト作成();
            取込済ファイル削除(new FlexibleYearMonth(処理対象年月), 保存先フォルダのパス, entityList);
        }
    }

    /**
     * 基本共同処理一時TBLをCREATEするProcessです。
     *
     * @return 基本共同処理一時TBL
     */
    @Step(CREATE基本共同処理一時TBL)
    protected IBatchFlowCommand create基本共同処理一時TempTable() {
        return createTempTable(TABLE_基本共同処理一時TBL, DbWT5C31KihonKyoudouShoriEntity.class).define();
    }

    /**
     * 償還共同処理一時TBLをCREATEするProcessです。
     *
     * @return 償還共同処理一時TBL
     */
    @Step(CREATE償還共同処理一時TBL)
    protected IBatchFlowCommand create償還共同処理一時TempTable() {
        return createTempTable(TABLE_償還共同処理一時TBL, DbWT5C32ShoukanKyoudouShoriEntity.class).define();
    }

    /**
     * 高額共同処理一時TBLをCREATEするProcessです。
     *
     * @return 要介護認定申請情報中間一時テーブル
     */
    @Step(CREATE高額共同処理一時TBL)
    protected IBatchFlowCommand create高額共同処理一時TempTable() {
        return createTempTable(TABLE_高額共同処理一時TBL, DbWT5C33KougakuKyoudouShoriEntity.class).define();
    }

    /**
     * 一時TBL基本情報_5C3作成処理Processです。
     *
     * @return CreateTmptable5C3Process
     */
    @Step(一時TBL基本情報_5C3作成)
    protected IBatchFlowCommand createTmptable5C3Process() {
        return loopBatch(CreateTmptable5C3Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(保存先フォルダのパス, ファイル名)).define();
    }

    /**
     * 一時TBL償還情報_5D3作成処理Processです。
     *
     * @return CreateTmptable5D3Process
     */
    @Step(一時TBL償還情報_5D3作成)
    protected IBatchFlowCommand createTmptable5D3Process() {
        return loopBatch(CreateTmptable5D3Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(保存先フォルダのパス, ファイル名)).define();
    }

    /**
     * 一時TBL高額情報_5E3作成処理Processです。
     *
     * @return CreateTmptable5E3Process
     */
    @Step(一時TBL高額情報_5E3作成)
    protected IBatchFlowCommand createTmptable5E3Process() {
        return loopBatch(CreateTmptable5E3Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(保存先フォルダのパス, ファイル名)).define();
    }

    /**
     * 一時TBL基本情報_5C4作成処理Processです。
     *
     * @return CreateTmptable5C4Process
     */
    @Step(一時TBL基本情報_5C4作成)
    protected IBatchFlowCommand createTmptable5C4Process() {
        return loopBatch(CreateTmptable5C4Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(保存先フォルダのパス, ファイル名)).define();
    }

    /**
     * 一時TBL償還情報_5D4作成処理Processです。
     *
     * @return CreateTmptable5D4Process
     */
    @Step(一時TBL償還情報_5D4作成)
    protected IBatchFlowCommand createTmptable5D4Process() {
        return loopBatch(CreateTmptable5D4Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(保存先フォルダのパス, ファイル名)).define();
    }

    /**
     * 一時TBL高額情報_5E4作成処理Processです。
     *
     * @return CreateTmptable5E4Process
     */
    @Step(一時TBL高額情報_5E4作成)
    protected IBatchFlowCommand createTmptable5E4Process() {
        return loopBatch(CreateTmptable5E4Process.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(保存先フォルダのパス, ファイル名)).define();
    }

    /**
     * 一時TBLの登録Processです。
     *
     * @return IchiTmpTableTorokuProcess
     */
    @Step(一時TBLの登録)
    protected IBatchFlowCommand ichiTmpTableTorokuProcess() {
        return loopBatch(IchiTmpTableTorokuProcess.class).define();
    }

    /**
     * 共同処理用受給者情報一覧表Processです。
     *
     * @return CreateTmptableProcess
     */
    @Step(共同処理用受給者情報一覧表)
    protected IBatchFlowCommand create共同処理用受給者情報一覧表() {
        return loopBatch(CreateKyodoJukyushaKoshinkekkaIchiranProcess.class).define();
    }

    private void getファイル(RString 交換情報識別番号) {
        KokuhorenKyoutsuuFileGetReturnEntity entity = KokuhorenKyoutsuuFileGetManager.createInstance()
                .getFile(交換情報識別番号, new RString("DBC120040"));
        保存先フォルダのパス = entity.get保存先フォルダのパス().toRString();
        ファイル名List = entity.getFileNameList();
        entityList = entity.getEntityList();
    }

    private void 被保険者関連処理() {
        KokuhorenKyoutsuuHihokansyaKanrenManager.createInstance().do被保険者関連処理();
    }

    private void 国保連インタフェース管理更新(FlexibleYearMonth 処理年月, RString 交換情報識別番号, FlexibleYearMonth 処理対象年月,
            int レコード件数合計, List<RString> fileNameList) {
        KokuhorenKyoutsuuInterfaceKanriKousinManager.createInstance().
                updateInterfaceKanriTbl(処理年月, 交換情報識別番号, 処理対象年月, レコード件数合計, fileNameList);
    }

    private void 処理結果リスト作成() {
        KokuhorenKyoutsuuSyoriKekkaListSakuseiManager.createInstance().
                create国保連情報データ取込処理結果リスト(KokuhorenJoho_TorikomiErrorListType.リストタイプ0);
    }

    private void 取込済ファイル削除(FlexibleYearMonth 処理年月, RString 保存先フォルダ, List<SharedFileEntryDescriptor> エントリ情報List) {
        KokuhorenKyoutsuuFileReceivedDeleteManager.createInstance().deleteReceivedFile(処理年月, 保存先フォルダ, エントリ情報List);
    }
}
