/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120040.CreateKyodoJukyushaKoshinkekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptableProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.IchiTmpTableTorokuProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120040.DBC120040_KyodoJukyushaKoshinKekkaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
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

    private static final String 一時TBL基本情報作成 = "一時TBL基本情報作成";
    private static final String 一時TBLの登録 = "一時TBLの登録";
    private static final String 共同処理用受給者情報一覧表 = "共同処理用受給者情報一覧表";
    private RString 保存先フォルダのパス;
    private List<RString> ファイル名List;
    private List<SharedFileEntryDescriptor> entityList;
    private Integer レコード総件数;
    private RString ファイル名;
    private RString 処理対象年月;

    @Override
    protected void defineFlow() {
        RString 交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_共同処理用受給者情報更新結果_交換情報識別番号,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        getファイル(交換情報識別番号);
        レコード総件数 = 0;
        for (RString csvファイル名 : ファイル名List) {
            ファイル名 = csvファイル名;
            try {
                executeStep(一時TBL基本情報作成);
                レコード総件数 = レコード総件数 + checkNull(getResult(Integer.class, new RString(一時TBL基本情報作成),
                        CreateTmptableProcess.レコード件数));
                処理対象年月 = getResult(RString.class, new RString(一時TBL基本情報作成), CreateTmptableProcess.処理対象年月);
            } catch (Exception e) {
                throw new BatchInterruptedException(e.getMessage());
            }
        }
        executeStep(一時TBLの登録);
        int 登録件数 = getResult(Integer.class, new RString(一時TBLの登録), IchiTmpTableTorokuProcess.登録件数);
        if (登録件数 == 0) {
            国保連インタフェース管理更新(getParameter().get処理年月(), 交換情報識別番号, 処理対象年月CheckNull(処理対象年月), レコード総件数, ファイル名List);
            処理結果リスト作成();
            取込済ファイル削除(処理対象年月CheckNull(処理対象年月), 保存先フォルダのパス, entityList);
        } else {
            被保険者関連処理();
            国保連インタフェース管理更新(getParameter().get処理年月(), 交換情報識別番号, 処理対象年月CheckNull(処理対象年月), レコード総件数, ファイル名List);
            executeStep(共同処理用受給者情報一覧表);
            処理結果リスト作成();
            取込済ファイル削除(処理対象年月CheckNull(処理対象年月), 保存先フォルダのパス, entityList);
        }
    }

    /**
     * 一時TBL基本情報作成処理Processです。
     *
     * @return CreateTmptableProcess
     */
    @Step(一時TBL基本情報作成)
    protected IBatchFlowCommand createTmptableProcess() {
        return loopBatch(CreateTmptableProcess.class)
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
        return loopBatch(CreateKyodoJukyushaKoshinkekkaIchiranProcess.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(保存先フォルダのパス, ファイル名)).define();
    }

    private void getファイル(RString 交換情報識別番号) {
        KokuhorenKyoutsuuFileGetReturnEntity entity = KokuhorenKyoutsuuFileGetManager.createInstance()
                .getFile(交換情報識別番号, new RString("DBC120040"), getParameter().getLoginUserId());
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

    private Integer checkNull(Integer レコード件数) {
        if (レコード件数 != null) {
            return レコード件数;
        }
        return 0;
    }

    private FlexibleYearMonth 処理対象年月CheckNull(RString 処理対象年月) {
        if (!RString.isNullOrEmpty(処理対象年月)) {
            return new FlexibleYearMonth(処理対象年月);
        }
        return FlexibleYearMonth.EMPTY;
    }
}
