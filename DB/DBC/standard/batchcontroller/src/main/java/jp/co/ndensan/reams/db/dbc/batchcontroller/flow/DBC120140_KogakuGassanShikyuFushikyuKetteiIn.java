/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuIchiranDataNomiTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuKozaJohoTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuKozaKakuninTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuMasterTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuReadCsvFile38BProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuReadCsvFile38GProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuRirekiNoTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140.ShikyuFushikyuSaishoriJunbiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoin.KyufukanrihyoInCsvReadReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120140.DBC120140_KogakuGassanShikyuFushikyuKetteiInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120140.ShikyuFushikyuSaishoriJunbiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoin.KyufukanrihyoDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給（不支給）決定通知書情報取込のバッチ処理フローです。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class DBC120140_KogakuGassanShikyuFushikyuKetteiIn
        extends BatchFlowBase<DBC120140_KogakuGassanShikyuFushikyuKetteiInParameter> {

    private static final String ファイル取得38B = "getFile38B";
    private static final String ファイル取得38G = "getFile38G";
    private static final String CSVファイル取込38B = "readCsvFile38B";
    private static final String CSVファイル取込38G = "readCsvFile38G";
    private static final String 口座情報登録 = "shikyuFushikyuKouzaJohoTorokuProcess";
    private static final String 一覧データのみ登録 = "shikyuFushikyuIchiranDataNomiTorokuProcess";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String 再処理準備 = "shikyuFushikyuSaishoriJunbiProcess";
    private static final String 口座確認登録 = "shikyuFushikyuKozaKakuninTorokuProcess";
    private static final String 最大履歴番号取得 = "shikyuFushikyuRirekiNoTorokuProcess";
    private static final String マスタ登録 = "shikyuFushikyuMasterTorokuProcess";
    private static final String 国保連インタフェース管理更新38B = "doInterfaceKanriKousin38B";
    private static final String 国保連インタフェース管理更新38G = "doInterfaceKanriKousin38G";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除38B = "deleteReveicedFile38B";
    private static final String 取込済ファイル削除38G = "deleteReveicedFile38G";

    private static final RString ファイル格納フォルダ名 = new RString("DBC120140");

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity38B;
    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity38G;
    private KyufukanrihyoInCsvReadReturnEntity flowEntity38B;
    private KyufukanrihyoInCsvReadReturnEntity flowEntity38G;
    private RString csvFullPath;
    private boolean isFirst;
    private boolean isLast;
    private int レコード件数合算;
    private int 明細件数合算;
    private int 集計件数合算;
    private static RString 交換情報識別番号38B;
    private static RString 交換情報識別番号38G;

    @Override
    protected void defineFlow() {
        try {
            RString 処理区分trim = RString.EMPTY;
            if (!RString.isNullOrEmpty(getParameter().get処理区分())) {
                処理区分trim = getParameter().get処理区分().trim();
            }
            RDate now = RDate.getNowDate();
            交換情報識別番号38B = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込媒体_合算支給通知Ｆ_交換情報識別番号, now, SubGyomuCode.DBC介護給付)
                    .concat(処理区分trim);
            交換情報識別番号38G = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込媒体_合算支給一覧Ｆ_交換情報識別番号, now, SubGyomuCode.DBC介護給付)
                    .concat(処理区分trim);
            executeStep(ファイル取得38B);
            returnEntity38B
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得38B),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            executeStep(ファイル取得38G);
            returnEntity38G
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得38G),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);

            for (int i = 0; i < returnEntity38B.getFileNameList().size(); i++) {
                String filePath = returnEntity38B.get保存先フォルダのパス() + File.separator
                        + returnEntity38B.getFileNameList().get(i);
                File path = new File(filePath);
                csvFullPath = new RString(path.getPath());
                isFirst = (0 == i);
                isLast = ((returnEntity38B.getFileNameList().size() - 1) == i);
                executeStep(CSVファイル取込38B);
                flowEntity38B = getResult(KyufukanrihyoInCsvReadReturnEntity.class, new RString(CSVファイル取込38B),
                        ShikyuFushikyuReadCsvFile38BProcess.PARAMETER_OUT_FLOWENTITY);
                明細件数合算 = flowEntity38B.get明細件数合算();
                集計件数合算 = flowEntity38B.get集計件数合算();
                レコード件数合算 = flowEntity38B.getレコード件数合算();
            }

            明細件数合算 = 0;
            集計件数合算 = 0;
            レコード件数合算 = 0;
            for (int i = 0; i < returnEntity38G.getFileNameList().size(); i++) {
                String filePath = returnEntity38G.get保存先フォルダのパス() + File.separator
                        + returnEntity38G.getFileNameList().get(i);
                File path = new File(filePath);
                csvFullPath = new RString(path.getPath());
                isFirst = (0 == i);
                isLast = ((returnEntity38G.getFileNameList().size() - 1) == i);
                executeStep(CSVファイル取込38G);
                flowEntity38G = getResult(KyufukanrihyoInCsvReadReturnEntity.class, new RString(CSVファイル取込38G),
                        ShikyuFushikyuReadCsvFile38GProcess.PARAMETER_OUT_FLOWENTITY);
                明細件数合算 = flowEntity38G.get明細件数合算();
                集計件数合算 = flowEntity38G.get集計件数合算();
                レコード件数合算 = flowEntity38G.getレコード件数合算();
            }

            if (0 == flowEntity38B.get明細件数合算()) {
                executeStep(国保連インタフェース管理更新38B);
                executeStep(国保連インタフェース管理更新38G);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(口座情報登録);
                executeStep(一覧データのみ登録);
                executeStep(被保険者関連処理);
                if (SaiShoriKubun.再処理.equals(getParameter().get再処理区分())) {
                    executeStep(再処理準備);
                }
                executeStep(口座確認登録);
                executeStep(最大履歴番号取得);
                executeStep(マスタ登録);
                executeStep(国保連インタフェース管理更新38B);
                executeStep(国保連インタフェース管理更新38G);
                executeStep(一覧表作成);
                executeStep(処理結果リスト作成);
            }
        } finally {
            if (null != returnEntity38B) {
                executeStep(取込済ファイル削除38B);
            }
            if (null != returnEntity38G) {
                executeStep(取込済ファイル削除38G);
            }
        }

    }

    /**
     * ファイル取得です。
     *
     * @return KokuhorenkyoutsuGetFileProcess
     */
    @Step(ファイル取得38B)
    protected IBatchFlowCommand callGetFile38BProcess() {
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号38B);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        parameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * ファイル取得です。
     *
     * @return KokuhorenkyoutsuGetFileProcess
     */
    @Step(ファイル取得38G)
    protected IBatchFlowCommand callGetFile38GProcess() {
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号38G);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        parameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KyufukanrihyoReadCsvFileProcess
     */
    @Step(CSVファイル取込38B)
    protected IBatchFlowCommand callReadCsvFile38BProcess() {
        KokuhorenkyotsuCsvFileReadProcessParameter parameter = new KokuhorenkyotsuCsvFileReadProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先パース(csvFullPath);
        parameter.setFirst(isFirst);
        parameter.setLast(isLast);
        parameter.set明細件数合算(明細件数合算);
        parameter.set集計件数合算(集計件数合算);
        parameter.setレコード件数合算(レコード件数合算);
        return loopBatch(ShikyuFushikyuReadCsvFile38BProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KyufukanrihyoReadCsvFileProcess
     */
    @Step(CSVファイル取込38G)
    protected IBatchFlowCommand callReadCsvFile38GProcess() {
        KokuhorenkyotsuCsvFileReadProcessParameter parameter = new KokuhorenkyotsuCsvFileReadProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先パース(csvFullPath);
        parameter.setFirst(isFirst);
        parameter.setLast(isLast);
        parameter.set明細件数合算(明細件数合算);
        parameter.set集計件数合算(集計件数合算);
        parameter.setレコード件数合算(レコード件数合算);
        return loopBatch(ShikyuFushikyuReadCsvFile38GProcess.class).arguments(parameter).define();
    }

    /**
     * 口座情報を登録する。
     *
     * @return ShikyuFushikyuKozaJohoTorokuProcess
     */
    @Step(口座情報登録)
    protected IBatchFlowCommand callShikyuFushikyuKouzaJohoTorokuProcess() {
        return loopBatch(ShikyuFushikyuKozaJohoTorokuProcess.class).define();
    }

    /**
     * 一覧データのみ登録する。
     *
     * @return ShikyuFushikyuIchiranDataNomiTorokuProcess
     */
    @Step(一覧データのみ登録)
    protected IBatchFlowCommand callShikyuFushikyuIchiranDataNomiTorokuProcess() {
        return loopBatch(ShikyuFushikyuIchiranDataNomiTorokuProcess.class).define();
    }

    /**
     * 被保険者関連処理です。
     *
     * @return KokuhorenkyoutsuDoHihokenshaKanrenProcess
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand callDoHihokenshaKanrenProcess() {
        return simpleBatch(KokuhorenkyoutsuDoHihokenshaKanrenProcess.class).define();
    }

    /**
     * 再処理準備です。<br>
     *
     * @return ShikyuFushikyuSaishoriJunbiProcess
     */
    @Step(再処理準備)
    protected IBatchFlowCommand callShikyuFushikyuSaishoriJunbiProcess() {
        ShikyuFushikyuSaishoriJunbiProcessParameter 再処理parameter = new ShikyuFushikyuSaishoriJunbiProcessParameter();
        再処理parameter.set処理区分(getParameter().get処理区分());
        再処理parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(ShikyuFushikyuSaishoriJunbiProcess.class).arguments(再処理parameter).define();
    }

    /**
     * 口座確認登録です。
     *
     * @return ShikyuFushikyuKozaKakuninTorokuProcess
     */
    @Step(口座確認登録)
    protected IBatchFlowCommand callShikyuFushikyuKozaKakuninTorokuProcess() {
        return loopBatch(ShikyuFushikyuKozaKakuninTorokuProcess.class).define();
    }

    /**
     * 最大履歴番号取得です。
     *
     * @return ShikyuFushikyuRirekiNoTorokuProcess
     */
    @Step(最大履歴番号取得)
    protected IBatchFlowCommand callShikyuFushikyuRirekiNoTorokuProcess() {
        return loopBatch(ShikyuFushikyuRirekiNoTorokuProcess.class).define();
    }

    /**
     * マスタ登録です。
     *
     * @return ShikyuFushikyuMasterTorokuProcess
     */
    @Step(マスタ登録)
    protected IBatchFlowCommand callShikyuFushikyuMasterTorokuProcess() {
        ShikyuFushikyuSaishoriJunbiProcessParameter parameter = new ShikyuFushikyuSaishoriJunbiProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(ShikyuFushikyuMasterTorokuProcess.class).arguments(parameter).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KokuhorenkyoutsuDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新38B)
    protected IBatchFlowCommand callDoInterfaceKanriKousin38BProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set交換情報識別番号(交換情報識別番号38B);
        parameter.set処理対象年月(flowEntity38B.get処理対象年月());
        parameter.setレコード件数合計(flowEntity38B.getレコード件数合算());
        parameter.setFileNameList(returnEntity38B.getFileNameList());
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KokuhorenkyoutsuDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新38G)
    protected IBatchFlowCommand callDoInterfaceKanriKousin38GProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set交換情報識別番号(交換情報識別番号38G);
        parameter.set処理対象年月(flowEntity38B.get処理対象年月());
        parameter.setレコード件数合計(flowEntity38B.getレコード件数合算());
        parameter.setFileNameList(returnEntity38G.getFileNameList());
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return DoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KyufukanrihyoDoIchiranhyoSakuseiProcessParameter parameter
                = new KyufukanrihyoDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.setシステム日付(RDateTime.now());
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set出力順ID(getParameter().get出力順ID());
        parameter.set帳票ID(ReportIdDBC.DBC200039.getReportId());
        return loopBatch(ShikyuFushikyuDoIchiranhyoSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter
                = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ4);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除です。
     *
     * @return KohifutanshaDeleteReveicedFileProcess
     */
    @Step(取込済ファイル削除38B)
    protected IBatchFlowCommand callDeleteReveicedFile38BProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameter
                = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先フォルダ(returnEntity38B.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity38B.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除です。
     *
     * @return KohifutanshaDeleteReveicedFileProcess
     */
    @Step(取込済ファイル削除38G)
    protected IBatchFlowCommand callDeleteReveicedFile38GProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameter
                = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先フォルダ(returnEntity38G.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity38G.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();
    }

}
