/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5101DensanErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5101DensanErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5101DensanInsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5101DensanTempInsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5101DensanTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5101KoroshoErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5101KoroshoTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5910DensanErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5910DensanErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5910DensanInsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5910KoroshoErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5910KoroshoErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5911DensanErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5911DensanErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5911DensanInsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5911KoroshoErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5911KoroshoErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5912DensanErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5912DensanErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5912DensanInsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5912KoroshoErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5912KoroshoErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5913DensanErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5913DensanErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5913DensanInsertProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5913KoroshoErrorCheckProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.renkeidatatorikomi.DbT5913KoroshoErrorTempOutputProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi.RenkeiDataTorikomiBatchParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5101TempKoroshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5910TempKoroshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911KoroshoTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5911TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912KoroshoTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5912TempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913KoroshoTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi.DbT5913TempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.DbTableType;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請連携データ取込のバッチフロークラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
public class RenkeiDataTorikomiFlow extends BatchFlowBase<RenkeiDataTorikomiBatchParamter> {

    private static final RString 認定申請一時テーブルNAME = new RString("DbT5101Temp");
    private static final RString 認定申請中間一時テーブルNAME = new RString("DbT5101TyukanTemp");
    private static final RString 主治医情報一時テーブルNAME = new RString("DbT5912Temp");
    private static final RString 医療機関一時テーブルNAME = new RString("DbT5911Temp");
    private static final RString 認定調査員一時テーブルNAME = new RString("DbT5913Temp");
    private static final RString 調査委託先一時テーブルNAME = new RString("DbT5910Temp");
    private static final RString IF種類_電算 = new RString("3");
    private static final RString IF種類_厚労省 = new RString("4");
    private static final RString IF種類_東芝版 = new RString("5");
    private RString 認定申請ファイル;
    private RString 主治医情報ファイル;
    private RString 医療機関ファイル;
    private RString 認定調査員ファイル;
    private RString 調査委託先ファイル;

    @Override
    protected void defineFlow() {
        RDate 基準日 = RDate.getNowDate();
        List<RString> 取込み対象ファイルリスト = getParameter().get取込み対象ファイルリスト();
        if (取込み対象ファイルリスト != null && !取込み対象ファイルリスト.isEmpty()) {
            RString 認定申請IF種類 = DbBusinessConfig.get(ConfigNameDBE.認定申請IF種類, 基準日, SubGyomuCode.DBE認定支援);
            RString マスタIF種類 = DbBusinessConfig.get(ConfigNameDBE.四マスタIF種類, 基準日, SubGyomuCode.DBE認定支援);
            主治医情報ファイル = new RString(getParameter().get格納パス().toString()
                    + DbBusinessConfig.get(ConfigNameDBE.主治医データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援).toString());
            医療機関ファイル = new RString(getParameter().get格納パス().toString()
                    + DbBusinessConfig.get(ConfigNameDBE.主治医医療機関データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援).toString());
            認定調査員ファイル = new RString(getParameter().get格納パス().toString()
                    + DbBusinessConfig.get(ConfigNameDBE.認定調査員データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援).toString());
            調査委託先ファイル = new RString(getParameter().get格納パス().toString()
                    + DbBusinessConfig.get(ConfigNameDBE.認定調査委託先データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援).toString());
            認定申請ファイル = new RString(getParameter().get格納パス().toString()
                    + DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援).toString());
            if (IF種類_電算.equals(認定申請IF種類)) {
                call電算標準版_認定申請IF種類(取込み対象ファイルリスト, 基準日);
            }
            if (IF種類_電算.equals(マスタIF種類)) {
                call電算標準版_4マスタIF種類(取込み対象ファイルリスト, 基準日);
            }
            if (IF種類_厚労省.equals(認定申請IF種類)) {
                getParameter().set厚労省フラグ(true);
                call厚労省版_認定申請IF種類(取込み対象ファイルリスト, 基準日);
            }
            if (IF種類_厚労省.equals(マスタIF種類)) {
                getParameter().set厚労省フラグ(true);
                call厚労省版_4マスタIF種類(取込み対象ファイルリスト, 基準日);
            }
            if (IF種類_東芝版.equals(認定申請IF種類)) {
                getParameter().set東芝版フラグ(true);
                call東芝版(取込み対象ファイルリスト, 基準日);
            }
        }
    }

    private void call東芝版(List<RString> 取込み対象ファイルリスト, RDate 基準日) {
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call要介護認定申請情報_東芝版();
        }
    }
    private static final String CREATE申請一時TBL_東芝版 = "create申請一時テーブル_東芝版";
    private static final String INSERT申請中間一時TBL_東芝版 = "insert申請一時テーブル_東芝版";
    private static final String 申請一時TBL_東芝版出力 = "申請一時TBL_東芝出力";
    private static final String 申請エラー一時TBL_東芝版出力 = "申請エラー一時TBL_東芝出力";

    private void call要介護認定申請情報_東芝版() {
        executeStep(CREATE申請一時TBL_東芝版);
        executeStep(INSERT申請中間一時TBL_東芝版);
        executeStep(CREATE申請エラー一時TBL_電算);
        executeStep(申請一時TBL_東芝版出力);
        executeStep(申請エラー一時TBL_東芝版出力);
        executeStep(申請TBL登録_電算);
    }

    /**
     * 要介護認定申請情報中間一時テーブル（東芝版）をCREATEするProcessです。
     *
     * @return 要介護認定申請情報中間一時テーブル
     */
    @Step(CREATE申請一時TBL_東芝版)
    protected IBatchFlowCommand create要介護認定申請情報TempTable_東芝版() {
        return createTempTable(認定申請一時テーブルNAME, DbT5101TempEntity.class).define();
    }

    /**
     * Csvファイルを要介護認定申請情報中間一時テーブル（東芝版）に登録のProcessです。
     *
     * @return 要介護認定申請情報中間一時テーブル
     */
    @Step(INSERT申請中間一時TBL_東芝版)
    protected IBatchFlowCommand insert要介護認定申請一時テーブル_東芝版() {
        return importCsv(認定申請ファイル,
                認定申請一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 要介護認定申請情報エラー一時テーブルからCSV出力Processです。
     *
     * @return DbT5101KoroshoErrorTempOutputProcess
     */
    @Step(申請エラー一時TBL_東芝版出力)
    protected IBatchFlowCommand call要介護認定申請エラー一時TBL_東芝版出力() {
        return loopBatch(DbT5101KoroshoErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 要介護認定申請情報一時テーブルからCSV出力Processです。
     *
     * @return DbT5101KoroshoTempOutputProcess
     */
    @Step(申請一時TBL_東芝版出力)
    protected IBatchFlowCommand call要介護認定申請一時TBL_東芝版出力() {
        return loopBatch(DbT5101KoroshoTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private void call厚労省版_認定申請IF種類(List<RString> 取込み対象ファイルリスト, RDate 基準日) {
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call要介護認定申請情報_厚労省();
        }
    }

    private void call厚労省版_4マスタIF種類(List<RString> 取込み対象ファイルリスト, RDate 基準日) {
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.認定調査委託先データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call認定調査委託先情報_厚労省();
        }
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.認定調査員データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call認定調査員情報_厚労省();
        }
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.主治医医療機関データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call主治医医療機関情報_厚労省();
        }
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.主治医データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call主治医情報_厚労省();
        }
    }

    private static final String CREATE主治医一時TBL_厚労省 = "create主治医一時テーブル_厚労省標準版";
    private static final String INSERT主治医一時TBL_厚労省 = "insert主治医一時テーブル_厚労省標準版";
    private static final String CREATE主治医エラー一時TBL_厚労省 = "create主治医エラー一時テーブル_厚労省標準版";
    private static final String 主治医エラー一時TBL_厚労省出力 = "主治医エラー一時TBL_厚労省標準版";

    private void call主治医情報_厚労省() {
        executeStep(CREATE主治医一時TBL_厚労省);
        executeStep(INSERT主治医一時TBL_厚労省);
        executeStep(CREATE主治医エラー一時TBL_厚労省);
        executeStep(主治医エラー一時TBL_厚労省出力);
        executeStep(主治医TBL登録_電算);
    }

    /**
     * 主治医情報一時テーブル（厚労省）をCREATEするProcessです。
     *
     * @return 主治医情報一時テーブル
     */
    @Step(CREATE主治医一時TBL_厚労省)
    protected IBatchFlowCommand create主治医情報一時TBL_厚労省() {
        return createTempTable(主治医情報一時テーブルNAME,
                DbT5912KoroshoTempEntity.class).define();
    }

    /**
     * Csvファイルを主治医情報一時テーブル（厚労省）に登録のProcessです。
     *
     * @return 主治医情報一時テーブル
     */
    @Step(INSERT主治医一時TBL_厚労省)
    protected IBatchFlowCommand insert主治医情報一時TBL_厚労省() {
        return importCsv(主治医情報ファイル, 主治医情報一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 主治医情報一時テーブルのエラーチェックし、主治医情報エラー一時テーブルに登録のProcessです。
     *
     * @return 主治医情報エラー一時テーブル
     */
    @Step(CREATE主治医エラー一時TBL_厚労省)
    protected IBatchFlowCommand create主治医情報エラー一時TBL_厚労省() {
        return loopBatch(DbT5912KoroshoErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 主治医情報エラー一時テーブルからCSV出力のProcessです。
     *
     * @return 主治医情報エラー一時テーブル
     */
    @Step(主治医エラー一時TBL_厚労省出力)
    protected IBatchFlowCommand create主治医情報エラー一時TBL_厚労省出力() {
        return loopBatch(DbT5912KoroshoErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private static final String CREATE医療機関一時TBL_厚労省 = "create医療機関一時テーブル_厚労省標準版";
    private static final String INSERT医療機関一時TBL_厚労省 = "insert医療機関一時テーブル_厚労省標準版";
    private static final String CREATE医療機関エラー一時TBL_厚労省 = "create医療機関エラー一時テーブル_厚労省標準版";
    private static final String 医療機関エラー一時TBL_厚労省出力 = "医療機関エラー一時TBL_厚労省標準版";

    private void call主治医医療機関情報_厚労省() {
        executeStep(CREATE医療機関一時TBL_厚労省);
        executeStep(INSERT医療機関一時TBL_厚労省);
        executeStep(CREATE医療機関エラー一時TBL_厚労省);
        executeStep(医療機関エラー一時TBL_厚労省出力);
        executeStep(医療機関TBL登録_電算);
    }

    /**
     * 主治医医療機関情報一時テーブル（厚労省）をCREATEするProcessです。
     *
     * @return 主治医医療機関情報一時テーブル
     */
    @Step(CREATE医療機関一時TBL_厚労省)
    protected IBatchFlowCommand create主治医医療機関一時TBL_厚労省() {
        return createTempTable(医療機関一時テーブルNAME,
                DbT5911KoroshoTempEntity.class).define();
    }

    /**
     * Csvファイルを主治医医療機関情報一時テーブル（厚労省）に登録のProcessです。
     *
     * @return 主治医医療機関情報一時テーブル
     */
    @Step(INSERT医療機関一時TBL_厚労省)
    protected IBatchFlowCommand insert主治医医療機関一時TBL_厚労省() {
        return importCsv(医療機関ファイル, 医療機関一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 主治医医療機関情報一時テーブルのエラーチェックし、主治医医療機関情報エラー一時テーブルに登録のProcessです。
     *
     * @return 主治医医療機関情報エラー一時テーブル
     */
    @Step(CREATE医療機関エラー一時TBL_厚労省)
    protected IBatchFlowCommand create主治医医療機関エラー一時TBL_厚労省() {
        return loopBatch(DbT5911KoroshoErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 主治医医療機関情報エラー一時テーブルからCSV出力のProcessです。
     *
     * @return 主治医医療機関情報エラー一時テーブル
     */
    @Step(医療機関エラー一時TBL_厚労省出力)
    protected IBatchFlowCommand create主治医医療機関エラー一時TBL_厚労省出力() {
        return loopBatch(DbT5911KoroshoErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private static final String CREATE調査員一時TBL_厚労省 = "create調査員一時テーブル_厚労省版";
    private static final String INSERT調査員一時TBL_厚労省 = "insert調査員一時テーブル_厚労省";
    private static final String CREATE調査員エラー一時TBL_厚労省 = "create調査員エラー一時TBL_厚労省";
    private static final String 調査員エラー一時TBL_厚労省出力 = "調査員エラー一時TBL_厚労省出力";

    private void call認定調査員情報_厚労省() {
        executeStep(CREATE調査員一時TBL_厚労省);
        executeStep(INSERT調査員一時TBL_厚労省);
        executeStep(CREATE調査員エラー一時TBL_厚労省);
        executeStep(調査員エラー一時TBL_厚労省出力);
        executeStep(調査員TBL登録_電算);
    }

    /**
     * 認定調査員情報一時テーブル（厚労省）をCREATEするProcessです。
     *
     * @return 認定調査員情報一時テーブル
     */
    @Step(CREATE調査員一時TBL_厚労省)
    protected IBatchFlowCommand create認定調査員一時TBL_厚労省() {
        return createTempTable(認定調査員一時テーブルNAME,
                DbT5913KoroshoTempEntity.class).define();
    }

    /**
     * Csvファイルを認定調査員情報一時テーブル（厚労省）に登録のProcessです。
     *
     * @return 認定調査員情報一時テーブル
     */
    @Step(INSERT調査員一時TBL_厚労省)
    protected IBatchFlowCommand insert認定調査員一時TBL_厚労省() {
        return importCsv(認定調査員ファイル, 認定調査員一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 認定調査員情報一時テーブルのエラーチェックし、認定調査員情報エラー一時テーブルに登録のProcessです。
     *
     * @return 認定調査員情報エラー一時テーブル
     */
    @Step(CREATE調査員エラー一時TBL_厚労省)
    protected IBatchFlowCommand create認定調査員エラー一時TBL_厚労省() {
        return loopBatch(DbT5913KoroshoErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 認定調査員情報エラー一時テーブルからCSV出力のProcessです。
     *
     * @return 認定調査員情報エラー一時テーブル
     */
    @Step(調査員エラー一時TBL_厚労省出力)
    protected IBatchFlowCommand create認定調査員エラー一時TBL_厚労省出力() {
        return loopBatch(DbT5913KoroshoErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private static final String CREATE委託先一時TBL_厚労 = "create委託先一時テーブル_厚労省準版";
    private static final String INSERT委託先一時TBL_厚労 = "insert委託先一時テーブル_厚労省準版";
    private static final String CREATE委託先エラー一時TBL_厚労 = "create委託先エラー一時テーブル_厚労省";
    private static final String 委託先エラー一時TBL_厚労出力 = "委託先エラー一時TBL__厚労省";

    private void call認定調査委託先情報_厚労省() {
        executeStep(CREATE委託先一時TBL_厚労);
        executeStep(INSERT委託先一時TBL_厚労);
        executeStep(CREATE委託先エラー一時TBL_厚労);
        executeStep(委託先エラー一時TBL_厚労出力);
        executeStep(委託先TBL登録_電算);
    }

    /**
     * 認定調査委託先情報一時テーブル（厚労省）をCREATEするProcessです。
     *
     * @return 認定調査委託先情報一時テーブル
     */
    @Step(CREATE委託先一時TBL_厚労)
    protected IBatchFlowCommand create認定調査委託先一時TBL_厚労() {
        return createTempTable(調査委託先一時テーブルNAME,
                DbT5910TempKoroshoEntity.class).define();
    }

    /**
     * Csvファイルを認定調査委託先情報一時テーブル（厚労省）に登録のProcessです。
     *
     * @return 認定調査委託先情報一時テーブル
     */
    @Step(INSERT委託先一時TBL_厚労)
    protected IBatchFlowCommand insert認定調査委託先一時TBL_厚労() {
        return importCsv(調査委託先ファイル, 調査委託先一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 認定調査委託先情報一時テーブルのエラーチェックし、認定調査委託先情報エラー一時テーブルに登録のProcessです。
     *
     * @return 認定調査委託先情報エラー一時テーブル
     */
    @Step(CREATE委託先エラー一時TBL_厚労)
    protected IBatchFlowCommand create認定調査委託先エラー一時TBL_厚労() {
        return loopBatch(DbT5910KoroshoErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 認定調査委託先情報エラー一時テーブルからCSV出力のProcessです。
     *
     * @return 認定調査委託先情報エラー一時テーブル
     */
    @Step(委託先エラー一時TBL_厚労出力)
    protected IBatchFlowCommand create認定調査委託先エラー一時TBL_厚労出力() {
        return loopBatch(DbT5910KoroshoErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private static final String CREATE申請一時TBL_厚労省 = "create申請一時テーブル_厚労省標準版";
    private static final String INSERT申請一時TBL_厚労省 = "insert申請一時テーブル_厚労省標準版";

    private void call要介護認定申請情報_厚労省() {
        executeStep(CREATE申請一時TBL_厚労省);
        executeStep(INSERT申請一時TBL_厚労省);
        executeStep(CREATE申請エラー一時TBL_電算);
        executeStep(申請エラー一時TBL_電算出力);
        executeStep(申請一時TBL_電算出力);
        executeStep(申請TBL登録_電算);
    }

    /**
     * 要介護認定申請情報中間一時テーブル（厚労省）をCREATEするProcessです。
     *
     * @return 要介護認定申請情報中間一時テーブル
     */
    @Step(CREATE申請一時TBL_厚労省)
    protected IBatchFlowCommand create認定申請情報中間TempTable_厚労省() {
        return createTempTable(認定申請一時テーブルNAME,
                DbT5101TempKoroshoEntity.class).define();
    }

    /**
     * Csvファイルを要介護認定申請情報中間一時テーブル（厚労省）に登録のProcessです。
     *
     * @return 要介護認定申請情報中間一時テーブル
     */
    @Step(INSERT申請一時TBL_厚労省)
    protected IBatchFlowCommand insert認定申請一時中間テーブル_厚労省() {
        return importCsv(認定申請ファイル, 認定申請一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    private void call電算標準版_認定申請IF種類(List<RString> 取込み対象ファイルリスト, RDate 基準日) {
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call要介護認定申請情報();
        }
    }

    private void call電算標準版_4マスタIF種類(List<RString> 取込み対象ファイルリスト, RDate 基準日) {
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.認定調査委託先データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call認定調査委託先情報();
        }
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.認定調査員データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call認定調査員情報();
        }
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.主治医医療機関データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call主治医医療機関情報();
        }
        if (取込み対象ファイルリスト.contains(DbBusinessConfig.get(ConfigNameDBE.主治医データ取込みファイル名,
                基準日, SubGyomuCode.DBE認定支援))) {
            call主治医情報();
        }
    }

    private static final String CREATE主治医一時TBL_電算 = "create主治医一時テーブル_電算標準版";
    private static final String INSERT主治医一時TBL_電算 = "insert主治医一時テーブル_電算標準版";
    private static final String CREATE主治医エラー一時TBL_電算 = "create主治医エラー一時テーブル_電算標準版";
    private static final String 主治医エラー一時TBL_電算出力 = "主治医エラー一時TBL_電算標準版";
    private static final String 主治医TBL登録_電算 = "主治医TBL登録_電算標準版";

    private void call主治医情報() {
        executeStep(CREATE主治医一時TBL_電算);
        executeStep(INSERT主治医一時TBL_電算);
        executeStep(CREATE主治医エラー一時TBL_電算);
        executeStep(主治医エラー一時TBL_電算出力);
        executeStep(主治医TBL登録_電算);
    }

    /**
     * 主治医情報一時テーブル（電算標準版）をCREATEするProcessです。
     *
     * @return 主治医情報一時テーブル
     */
    @Step(CREATE主治医一時TBL_電算)
    protected IBatchFlowCommand create主治医情報一時TBL_電算() {
        return createTempTable(主治医情報一時テーブルNAME,
                DbT5912TempEntity.class).define();
    }

    /**
     * Csvファイルを主治医情報一時テーブル（電算標準版）に登録のProcessです。
     *
     * @return 主治医情報一時テーブル
     */
    @Step(INSERT主治医一時TBL_電算)
    protected IBatchFlowCommand insert主治医情報一時TBL_電算() {
        return importCsv(主治医情報ファイル, 主治医情報一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 主治医情報一時テーブルのエラーチェックし、主治医情報エラー一時テーブルに登録のProcessです。
     *
     * @return 主治医情報エラー一時テーブル
     */
    @Step(CREATE主治医エラー一時TBL_電算)
    protected IBatchFlowCommand create主治医情報エラー一時TBL_電算() {
        return loopBatch(DbT5912DensanErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 主治医情報エラー一時テーブルからCSV出力のProcessです。
     *
     * @return 主治医情報エラー一時テーブル
     */
    @Step(主治医エラー一時TBL_電算出力)
    protected IBatchFlowCommand create主治医情報エラー一時TBL_電算出力() {
        return loopBatch(DbT5912DensanErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 主治医情報テーブルに登録のProcessです。
     *
     * @return 主治医情報テーブル
     */
    @Step(主治医TBL登録_電算)
    protected IBatchFlowCommand call主治医情報TBL登録_電算() {
        return loopBatch(DbT5912DensanInsertProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private static final String CREATE医療機関一時TBL_電算 = "create医療機関一時テーブル_電算標準版";
    private static final String INSERT医療機関一時TBL_電算 = "insert医療機関一時テーブル_電算標準版";
    private static final String CREATE医療機関エラー一時TBL_電算 = "create医療機関エラー一時テーブル_電算標準版";
    private static final String 医療機関エラー一時TBL_電算出力 = "医療機関エラー一時TBL_電算標準版";
    private static final String 医療機関TBL登録_電算 = "医療機関TBL登録_電算標準版";

    private void call主治医医療機関情報() {
        executeStep(CREATE医療機関一時TBL_電算);
        executeStep(INSERT医療機関一時TBL_電算);
        executeStep(CREATE医療機関エラー一時TBL_電算);
        executeStep(医療機関エラー一時TBL_電算出力);
        executeStep(医療機関TBL登録_電算);
    }

    /**
     * 主治医医療機関情報一時テーブル（電算標準版）をCREATEするProcessです。
     *
     * @return 主治医医療機関情報一時テーブル
     */
    @Step(CREATE医療機関一時TBL_電算)
    protected IBatchFlowCommand create主治医医療機関一時TBL_電算() {
        return createTempTable(医療機関一時テーブルNAME,
                DbT5911TempEntity.class).define();
    }

    /**
     * Csvファイルを主治医医療機関情報一時テーブル（電算標準版）に登録のProcessです。
     *
     * @return 主治医医療機関情報一時テーブル
     */
    @Step(INSERT医療機関一時TBL_電算)
    protected IBatchFlowCommand insert主治医医療機関一時TBL_電算() {
        return importCsv(医療機関ファイル, 医療機関一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 主治医医療機関情報一時テーブルのエラーチェックし、主治医医療機関情報エラー一時テーブルに登録のProcessです。
     *
     * @return 主治医医療機関情報エラー一時テーブル
     */
    @Step(CREATE医療機関エラー一時TBL_電算)
    protected IBatchFlowCommand create主治医医療機関エラー一時TBL_電算() {
        return loopBatch(DbT5911DensanErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 主治医医療機関情報エラー一時テーブルからCSV出力のProcessです。
     *
     * @return 主治医医療機関情報エラー一時テーブル
     */
    @Step(医療機関エラー一時TBL_電算出力)
    protected IBatchFlowCommand create主治医医療機関エラー一時TBL_電算出力() {
        return loopBatch(DbT5911DensanErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 主治医医療機関情報テーブルに登録のProcessです。
     *
     * @return 主治医医療機関情報テーブル
     */
    @Step(医療機関TBL登録_電算)
    protected IBatchFlowCommand call主治医医療機関TBL登録_電算() {
        return loopBatch(DbT5911DensanInsertProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private static final String CREATE調査員一時TBL_電算 = "create調査員一時テーブル_電算標準版";
    private static final String INSERT調査員一時TBL_電算 = "insert調査員一時テーブル_電算標準版";
    private static final String CREATE調査員エラー一時TBL_電算 = "create調査員エラー一時テーブル_電算標準版";
    private static final String 調査員エラー一時TBL_電算出力 = "調査員エラー一時TBL_電算標準版";
    private static final String 調査員TBL登録_電算 = "調査員TBL登録_電算標準版";

    private void call認定調査員情報() {
        executeStep(CREATE調査員一時TBL_電算);
        executeStep(INSERT調査員一時TBL_電算);
        executeStep(CREATE調査員エラー一時TBL_電算);
        executeStep(調査員エラー一時TBL_電算出力);
        executeStep(調査員TBL登録_電算);
    }

    /**
     * 認定調査員情報一時テーブル（電算標準版）をCREATEするProcessです。
     *
     * @return 認定調査員情報一時テーブル
     */
    @Step(CREATE調査員一時TBL_電算)
    protected IBatchFlowCommand create認定調査員一時TBL_電算() {
        return createTempTable(認定調査員一時テーブルNAME,
                DbT5913TempEntity.class).define();
    }

    /**
     * Csvファイルを認定調査員情報一時テーブル（電算標準版）に登録のProcessです。
     *
     * @return 認定調査員情報一時テーブル
     */
    @Step(INSERT調査員一時TBL_電算)
    protected IBatchFlowCommand insert認定調査員一時TBL_電算() {
        return importCsv(認定調査員ファイル, 認定調査員一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 認定調査員情報一時テーブルのエラーチェックし、認定調査員情報エラー一時テーブルに登録のProcessです。
     *
     * @return 認定調査員情報エラー一時テーブル
     */
    @Step(CREATE調査員エラー一時TBL_電算)
    protected IBatchFlowCommand create認定調査員エラー一時TBL_電算() {
        return loopBatch(DbT5913DensanErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 認定調査員情報エラー一時テーブルからCSV出力のProcessです。
     *
     * @return 認定調査員情報エラー一時テーブル
     */
    @Step(調査員エラー一時TBL_電算出力)
    protected IBatchFlowCommand create認定調査員エラー一時TBL_電算出力() {
        return loopBatch(DbT5913DensanErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 認定調査員情報テーブルに登録のProcessです。
     *
     * @return 認定調査員情報テーブル
     */
    @Step(調査員TBL登録_電算)
    protected IBatchFlowCommand call認定調査員TBL登録_電算() {
        return loopBatch(DbT5913DensanInsertProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private static final String CREATE委託先一時TBL_電算 = "create委託先一時テーブル_電算標準版";
    private static final String INSERT委託先一時TBL_電算 = "insert委託先一時テーブル_電算標準版";
    private static final String CREATE委託先エラー一時TBL_電算 = "create委託先エラー一時テーブル_電算標準版";
    private static final String 委託先エラー一時TBL_電算出力 = "委託先エラー一時TBL_電算標準版";
    private static final String 委託先TBL登録_電算 = "委託先TBL登録_電算標準版";

    private void call認定調査委託先情報() {
        executeStep(CREATE委託先一時TBL_電算);
        executeStep(INSERT委託先一時TBL_電算);
        executeStep(CREATE委託先エラー一時TBL_電算);
        executeStep(委託先エラー一時TBL_電算出力);
        executeStep(委託先TBL登録_電算);
    }

    /**
     * 認定調査委託先情報一時テーブル（電算標準版）をCREATEするProcessです。
     *
     * @return 認定調査委託先情報一時テーブル
     */
    @Step(CREATE委託先一時TBL_電算)
    protected IBatchFlowCommand create認定調査委託先一時TBL_電算() {
        return createTempTable(調査委託先一時テーブルNAME,
                DbT5910TempEntity.class).define();
    }

    /**
     * Csvファイルを認定調査委託先情報一時テーブル（電算標準版）に登録のProcessです。
     *
     * @return 認定調査委託先情報一時テーブル
     */
    @Step(INSERT委託先一時TBL_電算)
    protected IBatchFlowCommand insert認定調査委託先一時TBL_電算() {
        return importCsv(調査委託先ファイル, 調査委託先一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 認定調査委託先情報一時テーブルのエラーチェックし、認定調査委託先情報エラー一時テーブルに登録のProcessです。
     *
     * @return 認定調査委託先情報エラー一時テーブル
     */
    @Step(CREATE委託先エラー一時TBL_電算)
    protected IBatchFlowCommand create認定調査委託先エラー一時TBL_電算() {
        return loopBatch(DbT5910DensanErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 認定調査委託先情報エラー一時テーブルからCSV出力のProcessです。
     *
     * @return 認定調査委託先情報エラー一時テーブル
     */
    @Step(委託先エラー一時TBL_電算出力)
    protected IBatchFlowCommand create認定調査委託先エラー一時TBL_電算出力() {
        return loopBatch(DbT5910DensanErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 認定調査委託先情報テーブルに登録のProcessです。
     *
     * @return 認定調査委託先情報テーブル
     */
    @Step(委託先TBL登録_電算)
    protected IBatchFlowCommand call認定調査委託先TBL登録_電算() {
        return loopBatch(DbT5910DensanInsertProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    private static final String CREATE申請中間一時TBL_電算 = "create申請中間中間一時テーブル_電算標準版";
    private static final String INSERT申請中間一時TBL_電算 = "insert申請一時中間テーブル_電算標準版";
    private static final String CREATE申請一時TBL_電算 = "insert申請一時テーブル_電算標準版";
    private static final String CREATE申請エラー一時TBL_電算 = "create申請エラー一時TBL_電算";
    private static final String 申請エラー一時TBL_電算出力 = "申請エラー一時TBL_電算出力";
    private static final String 申請一時TBL_電算出力 = "申請一時TBL_電算出力";
    private static final String 申請TBL登録_電算 = "申請TBL登録_電算";

    private void call要介護認定申請情報() {
        executeStep(CREATE申請中間一時TBL_電算);
        executeStep(INSERT申請中間一時TBL_電算);
        executeStep(CREATE申請一時TBL_電算);
        executeStep(CREATE申請エラー一時TBL_電算);
        executeStep(申請エラー一時TBL_電算出力);
        executeStep(申請一時TBL_電算出力);
        executeStep(申請TBL登録_電算);
    }

    /**
     * 要介護認定申請情報中間一時テーブル（電算標準版）をCREATEするProcessです。
     *
     * @return 要介護認定申請情報中間一時テーブル
     */
    @Step(CREATE申請中間一時TBL_電算)
    protected IBatchFlowCommand create認定申請情報中間TempTable_電算標準版() {
        return createTempTable(認定申請中間一時テーブルNAME,
                DbT5101TempEntity.class).define();
    }

    /**
     * Csvファイルを要介護認定申請情報中間一時テーブル（電算標準版）に登録のProcessです。
     *
     * @return 要介護認定申請情報中間一時テーブル
     */
    @Step(INSERT申請中間一時TBL_電算)
    protected IBatchFlowCommand insert認定申請一時中間テーブル_電算標準版() {
        return importCsv(認定申請ファイル, 認定申請中間一時テーブルNAME, DbTableType.TEMPORARY).define();
    }

    /**
     * 要介護認定申請情報中間一時テーブルを要介護認定申請情報一時テーブルに登録のProcessです。
     *
     * @return 要介護認定申請情報一時テーブル
     */
    @Step(CREATE申請一時TBL_電算)
    protected IBatchFlowCommand insert認定申請一時テーブル_電算標準版() {
        return loopBatch(DbT5101DensanTempInsertProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 要介護認定申請情報エラー一時テーブルを要介護認定申請情報一時テーブルに登録のProcessです。
     *
     * @return 要介護認定申請情報エラー一時テーブル
     */
    @Step(CREATE申請エラー一時TBL_電算)
    protected IBatchFlowCommand create認定申請エラー一時TBL_電算() {
        return loopBatch(DbT5101DensanErrorCheckProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 要介護認定申請情報エラー一時テーブルからCSV出力Processです。
     *
     * @return DbT5101DensanErrorTempOutputProcess
     */
    @Step(申請エラー一時TBL_電算出力)
    protected IBatchFlowCommand call認定申請エラー一時TBL_電算出力() {
        return loopBatch(DbT5101DensanErrorTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 要介護認定申請情報一時テーブルからCSV出力Processです。
     *
     * @return DbT5101DensanErrorTempOutputProcess
     */
    @Step(申請一時TBL_電算出力)
    protected IBatchFlowCommand call認定申請一時TBL_電算出力() {
        return loopBatch(DbT5101DensanTempOutputProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }

    /**
     * 要介護認定申請情報一時テーブルから要介護認定申請情報に登録Processです。
     *
     * @return DbT5101DensanInsertProcess
     */
    @Step(申請TBL登録_電算)
    protected IBatchFlowCommand call認定申請TBL登録_電算() {
        return loopBatch(DbT5101DensanInsertProcess.class)
                .arguments(getParameter().toRenkeiDataTorikomiProcessParamter()).define();
    }
}
