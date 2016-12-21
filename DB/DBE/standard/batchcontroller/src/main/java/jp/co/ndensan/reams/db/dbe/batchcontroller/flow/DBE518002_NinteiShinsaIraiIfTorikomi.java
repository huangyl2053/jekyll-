/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE518002.DataTorikomiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE518002.ShinsakaiWariateProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE518002.DBE518002_NinteiShinsaIraiIfTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.DbTableType;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.externalcharacter.batch.BatchTextFileConvert;
import jp.co.ndensan.reams.uz.uza.externalcharacter.batch.BatchTextFileConvertBatchParameter;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）flowクラスです。
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
public class DBE518002_NinteiShinsaIraiIfTorikomi extends BatchFlowBase<DBE518002_NinteiShinsaIraiIfTorikomiParameter> {

    private static final String DATATORIKOMI_PROCESS = "DataTorikomiProcess";
    private static final String SHINSAKAIWARIATE_PROCESS = "ShinsakaiWariateProcess";
    private static final String CONVERT_PROCESS_SHINSAKEKKA = "BatchTextFileConvert";
    private static final String CONVERT_PROCESS_SHINSAIIN = "BatchTextFileConvert";
    private static final String CONVERT_PROCESS_NINTEI = "BatchTextFileConvert";
    private static final String CREATE認定審査会割当委員情報一時TBL = "CreateShinsakaiWariateIinJohoProcess";
    private static final String INSERT認定審査会割当委員情報一時TBL = "InsertShinsakaiWariateIinJohoProcess";
    private static final String CREATE二次判定結果登録用データ一時TBL = "CreateNintiHanteikekkaProcess";
    private static final String INSERT二次判定結果登録用データ一時TBL = "InsertNintiHanteikekkaProcess";
    private static final RString RSRING_1 = new RString("1");
    private static final RString RSRING_2 = new RString("2");
    private RString 審査委員ファイル;
    //private RString 審査会ファイル;
    private RString 審査結果ファイル;
    private RString 認定ソフトファイル = new RString("NCI242.CSV");
    private static final RString TEMP = new RString("_temp.csv");
    private static final int DOTCSV = 4;
    private RString shinsaIinPath;
    private RString shinsaIinTempPath;
    private RString shinsaKekkaPath;
    private RString shinsaKekkaTempPath;
    private RString ninteiSoftPath;
    private RString ninteiSoftTempPath;

    @Override
    protected void defineFlow() {
        RDate 基準日 = RDate.getNowDate();
        審査委員ファイル = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル審査委員, 基準日, SubGyomuCode.DBE認定支援);
        審査結果ファイル = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル審査結果, 基準日, SubGyomuCode.DBE認定支援);
        //審査会ファイル = RString.EMPTY;
        認定ソフトファイル = DbBusinessConfig.get(ConfigNameDBE.認定ソフト審査会結果データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援);
        List<RString> fileList = getParameter().getFilename();
        if (null != fileList && !fileList.isEmpty()) {
            for (RString file : fileList) {
                if (審査委員ファイル.equals(file)) {
                    shinsaIinPath = new RString(Path.combinePath(Path.getRootPath(RString.EMPTY), getParameter().getMediapath()).toString()
                                                + File.separator + 審査委員ファイル.toString());
                    shinsaIinTempPath = shinsaIinPath.substring(0, shinsaIinPath.length() - DOTCSV).concat(TEMP);
                    convertMoji_Shinsain();
                    File.deleteIfExists(shinsaIinTempPath);
                } else if (審査結果ファイル.equals(file)) {
                    shinsaKekkaPath = new RString(Path.combinePath(Path.getRootPath(RString.EMPTY), getParameter().getMediapath()).toString()
                                                  + File.separator + 審査結果ファイル.toString());
                    shinsaKekkaTempPath = shinsaKekkaPath.substring(0, shinsaKekkaPath.length() - DOTCSV).concat(TEMP);
                    convertMoji_Shinsakekka();
                    File.deleteIfExists(shinsaKekkaTempPath);
                } else if (認定ソフトファイル.equals(file)) {
                    ninteiSoftPath = new RString(Path.combinePath(Path.getRootPath(RString.EMPTY), getParameter().getMediapath()).toString()
                                                 + File.separator + 認定ソフトファイル.toString());
                    ninteiSoftTempPath = ninteiSoftPath.substring(0, ninteiSoftPath.length() - DOTCSV).concat(TEMP);
                    convertMoji_Nintei();
                    File.deleteIfExists(ninteiSoftTempPath);
                }
            }
            if (RSRING_1.equals(getParameter().getTorikomidatakubun())) {
                executeStep(CREATE二次判定結果登録用データ一時TBL);
                executeStep(INSERT二次判定結果登録用データ一時TBL);
                executeStep(DATATORIKOMI_PROCESS);
                if (RSRING_1.equals(getParameter().getShinsakaiiintorikomikubun())) {
                    executeStep(CREATE認定審査会割当委員情報一時TBL);
                    executeStep(INSERT認定審査会割当委員情報一時TBL);
                    executeStep(SHINSAKAIWARIATE_PROCESS);
                }
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
        return createTempTable(TempShinsakaiIinJohoEntity.TABLE_NAME,
                               TempShinsakaiIinJohoEntity.class).define();
    }

    /**
     * Csvファイルを認定審査会割当委員情報一時デーブルに登録のProcessです。
     *
     * @return 認定審査会割当委員情報一時デーブル
     */
    @Step(INSERT認定審査会割当委員情報一時TBL)
    protected IBatchFlowCommand insert認定審査会割当委員情報() {
        return importCsv(shinsaIinPath,
                         TempShinsakaiIinJohoEntity.TABLE_NAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 二次判定結果登録用データ一時デーブルをCREATEするProcessです。
     *
     * @return 二次判定結果登録用データ一時デーブル
     */
    @Step(CREATE二次判定結果登録用データ一時TBL)
    protected IBatchFlowCommand create二次判定結果登録情報TempTable() {
        return createTempTable(TempShinsakaiKekkaEntity.TABLE_NAME,
                               TempShinsakaiKekkaEntity.class).define();
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
                             TempShinsakaiKekkaEntity.TABLE_NAME, DbTableType.TEMPORARY).define();
        } else {
            return importCsv(ninteiSoftPath,
                             TempShinsakaiKekkaEntity.TABLE_NAME, DbTableType.TEMPORARY).define();
        }
    }

    @Step(CONVERT_PROCESS_SHINSAKEKKA)
    IBatchFlowCommand convertMoji_Shinsakekka() {
        File.copy(shinsaKekkaPath, shinsaKekkaTempPath);
        File.deleteIfExists(shinsaKekkaPath);

        HashMap<RString, Object> parameter = new HashMap();
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_FILE_PATH), shinsaKekkaTempPath);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_FILE_PATH), shinsaKekkaPath);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TABLE_NAME), new RString("Sjis"));
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TYPE), BatchTextFileConvert.CONVERTTYPE_FROM);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_CRLF);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_CRLF);

        return simpleBatch(BatchTextFileConvert.class).arguments(parameter).define();
    }

    @Step(CONVERT_PROCESS_SHINSAIIN)
    IBatchFlowCommand convertMoji_Shinsain() {
        File.copy(shinsaIinPath, shinsaIinTempPath);
        File.deleteIfExists(shinsaIinPath);

        HashMap<RString, Object> parameter = new HashMap();
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_FILE_PATH), shinsaIinTempPath);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_FILE_PATH), shinsaIinPath);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TABLE_NAME), new RString("Unicode"));
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TYPE), BatchTextFileConvert.CONVERTTYPE_FROM);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_CRLF);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_CRLF);

        return simpleBatch(BatchTextFileConvert.class).arguments(parameter).define();
    }

    @Step(CONVERT_PROCESS_NINTEI)
    IBatchFlowCommand convertMoji_Nintei() {
        File.copy(ninteiSoftPath, ninteiSoftTempPath);
        File.deleteIfExists(ninteiSoftPath);

        HashMap<RString, Object> parameter = new HashMap();
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_FILE_PATH), ninteiSoftTempPath);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_FILE_PATH), ninteiSoftPath);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TABLE_NAME), new RString("Sjis"));
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TYPE), BatchTextFileConvert.CONVERTTYPE_FROM);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_CRLF);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_CRLF);

        return simpleBatch(BatchTextFileConvert.class).arguments(parameter).define();
    }
}
