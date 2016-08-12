/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ninteishinsakaikekkadatatorikomi;

import java.io.File;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteishinsakaikekkadatatorikomi.DataTorikomiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteishinsakaikekkadatatorikomi.ShinsakaiWariateProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteishinsakaikekkadatatorikomi.ShinsakaiKekkaDataTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi.TmpNijiHanteikekkaTourokuyoDataItijiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi.TmpNinteiShinsakaiWariateIinJohoItijiEntity;
import jp.co.ndensan.reams.uz.uza.batch.DbTableType;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）flowクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
public class ShinsakaiKekkaDataTorikomiFlow extends BatchFlowBase<ShinsakaiKekkaDataTorikomiBatchParameter> {

    private static final String DATATORIKOMI_PROCESS = "DataTorikomiProcess";
    private static final String SHINSAKAIWARIATE_PROCESS = "ShinsakaiWariateProcess";
    private static final RString 認定審査会割当委員情報NAME = new RString("DbT5503Temp");
    private static final RString 二次判定結果登録用データNAME = new RString("DbT5510Temp");
    private static final String CREATE認定審査会割当委員情報一時TBL = "CreateShinsakaiWariateIinJohoProcess";
    private static final String INSERT認定審査会割当委員情報一時TBL = "InsertShinsakaiWariateIinJohoProcess";
    private static final String CREATE二次判定結果登録用データ一時TBL = "CreateNintiHanteikekkaProcess";
    private static final String INSERT二次判定結果登録用データ一時TBL = "InsertNintiHanteikekkaProcess";
    private static final RString RSRING_1 = new RString("1");
    private static final RString RSRING_2 = new RString("2");
    private static final RString 審査委員ファイル = new RString("NijihanteiKekkaTorokuMobileShinsaiin.csv");
    private static final RString 審査結果ファイル = new RString("NijihanteiKekkaTorokuMobile.csv");
    private static final RString 認定ソフトファイル = new RString("NCI242.CSV");
    private RString shinsaIinPath;
    private RString shinsaKekkaPath;
    private RString ninteiSoftPath;

    @Override
    protected void defineFlow() {
        List<RString> fileList = getParameter().getFilename();
        if (null != fileList && !fileList.isEmpty()) {
            for (RString file : fileList) {
                if (審査委員ファイル.equals(file)) {
                    shinsaIinPath = new RString(Path.combinePath(Path.getRootPath(RString.EMPTY), getParameter().getMediapath()).toString()
                            + File.separator + 審査委員ファイル.toString());
                } else if (審査結果ファイル.equals(file)) {
                    shinsaKekkaPath = new RString(Path.combinePath(Path.getRootPath(RString.EMPTY), getParameter().getMediapath()).toString()
                            + File.separator + 審査結果ファイル.toString());
                } else if (認定ソフトファイル.equals(file)) {
                    ninteiSoftPath = new RString(Path.combinePath(Path.getRootPath(RString.EMPTY), getParameter().getMediapath()).toString()
                            + File.separator + 認定ソフトファイル.toString());
                }
            }
            if (RSRING_1.equals(getParameter().getTorikomidatakubun()) && RSRING_1.equals(getParameter().getShinsakaiiintorikomikubun())) {
                executeStep(CREATE認定審査会割当委員情報一時TBL);
                executeStep(INSERT認定審査会割当委員情報一時TBL);
                executeStep(CREATE二次判定結果登録用データ一時TBL);
                executeStep(INSERT二次判定結果登録用データ一時TBL);
                executeStep(DATATORIKOMI_PROCESS);
                executeStep(SHINSAKAIWARIATE_PROCESS);
            }
            if (RSRING_2.equals(getParameter().getShinsakaiiintorikomikubun())) {
                executeStep(CREATE二次判定結果登録用データ一時TBL);
                executeStep(INSERT二次判定結果登録用データ一時TBL);
                executeStep(DATATORIKOMI_PROCESS);
            }
        }
    }

    /**
     * 認定調査報酬請求書のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(DATATORIKOMI_PROCESS)
    protected IBatchFlowCommand createShinseiJouhouInsatuData() {
        return loopBatch(DataTorikomiProcess.class).arguments(
                getParameter().toShinsakaiKekkaDataTorikomiProcessParameter()).define();
    }

    /**
     * 介護認定審査会割当委員情報のデータを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SHINSAKAIWARIATE_PROCESS)
    protected IBatchFlowCommand createShinsakaiWariateData() {
        return loopBatch(ShinsakaiWariateProcess.class).arguments(
                getParameter().toShinsakaiKekkaDataTorikomiProcessParameter()).define();
    }

    /**
     * 認定審査会割当委員情報一時デーブルをCREATEするProcessです。
     *
     * @return 認定審査会割当委員情報一時デーブル
     */
    @Step(CREATE認定審査会割当委員情報一時TBL)
    protected IBatchFlowCommand create認定審査会割当委員情報TempTable() {
        return createTempTable(認定審査会割当委員情報NAME,
                TmpNinteiShinsakaiWariateIinJohoItijiEntity.class).define();
    }

    /**
     * Csvファイルを認定審査会割当委員情報一時デーブルに登録のProcessです。
     *
     * @return 認定審査会割当委員情報一時デーブル
     */
    @Step(INSERT認定審査会割当委員情報一時TBL)
    protected IBatchFlowCommand insert認定審査会割当委員情報() {
        return importCsv(shinsaIinPath,
                認定審査会割当委員情報NAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 二次判定結果登録用データ一時デーブルをCREATEするProcessです。
     *
     * @return 二次判定結果登録用データ一時デーブル
     */
    @Step(CREATE二次判定結果登録用データ一時TBL)
    protected IBatchFlowCommand create二次判定結果登録情報TempTable() {
        return createTempTable(二次判定結果登録用データNAME,
                TmpNijiHanteikekkaTourokuyoDataItijiEntity.class).define();
    }

    /**
     * Csvファイルを二次判定結果登録用データ一時デーブルに登録のProcessです。
     *
     * @return 二次判定結果登録用データ一時デーブル
     */
    @Step(INSERT二次判定結果登録用データ一時TBL)
    protected IBatchFlowCommand insert二次判定結果登録情報() {
        if (RSRING_1.equals(getParameter().getTorikomidatakubun())) {
            return importCsv(shinsaKekkaPath,
                    二次判定結果登録用データNAME, DbTableType.TEMPORARY).define();
        } else {
            return importCsv(ninteiSoftPath,
                    二次判定結果登録用データNAME, DbTableType.TEMPORARY).define();
        }
    }

}
