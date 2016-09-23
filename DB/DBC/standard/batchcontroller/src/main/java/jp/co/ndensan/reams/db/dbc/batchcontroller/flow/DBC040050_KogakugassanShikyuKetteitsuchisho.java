/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040050.GetTaishoshaChushutsuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040050.SetKougakuGassanKetteiTsuuchishoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040050.UpdateDbT3074Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040050.UpdateDbT7022Process;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040050.DBC040050_KogakugassanShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額合算支給決定通知書（一括）のバッチフロークラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
public class DBC040050_KogakugassanShikyuKetteitsuchisho extends BatchFlowBase<DBC040050_KogakugassanShikyuKetteitsuchishoParameter> {

    private static final int INT_0 = 0;
    private static final RString 文字列_1 = new RString("1");
    private static final String BACKUP_TO_TEMPORARY_TABLE = "backupShikyuuKetteiTsuuchisho";
    private static final String 対象者抽出 = "getTaishoshaChushutsu";
    private static final String 高額合算支給決定通知書発行 = "setKougakuGassanKetteiTsuuchisho";
    private static final String 高額合算支給不支給決定の決定通知書作成年月日を更新 = "updateDbT3074KogakuGassanShikyuFushikyuKettei";
    private static final String 処理日付管理マスタを更新 = "updateDbT7022ShoriDateKanri";
    private static final RString IMPORTTABLENAMEPERMANENT = new RString("DbT3074KogakuGassanShikyuFushikyuKettei");
    private static final RString TABLENAMEFORTAIHITEMP = new RString("DbT3074KogakuGassanShikyuFushikyuKetteiTemp");

    @Override
    protected void defineFlow() {
        executeStep(BACKUP_TO_TEMPORARY_TABLE);
        executeStep(対象者抽出);
        int 件数 = getResult(Integer.class, new RString(対象者抽出), GetTaishoshaChushutsuProcess.件数);
        if (INT_0 < 件数) {
            executeStep(高額合算支給決定通知書発行);
        }
        if (文字列_1.equals(getParameter().get決定日一括更新区分())) {
            executeStep(高額合算支給不支給決定の決定通知書作成年月日を更新);
        }
        executeStep(処理日付管理マスタを更新);
    }

    /**
     * データのバックアップのメソッドです。
     *
     * @return データのバックアップ
     */
    @Step(BACKUP_TO_TEMPORARY_TABLE)
    protected IBatchFlowCommand backupShikyuuKetteiTsuuchisho() {
        return backupToTemporaryTable(IMPORTTABLENAMEPERMANENT, TABLENAMEFORTAIHITEMP).
                define();
    }

    /**
     * 対象者抽出のメソッドです。
     *
     * @return 対象者抽出Process
     */
    @Step(対象者抽出)
    protected IBatchFlowCommand getTaishoshaChushutsu() {
        return loopBatch(GetTaishoshaChushutsuProcess.class).arguments(setParameter()).define();
    }

    /**
     * 高額合算支給決定通知書発行のメソッドです。
     *
     * @return 対象者抽出Process
     */
    @Step(高額合算支給決定通知書発行)
    protected IBatchFlowCommand setKougakuGassanKetteiTsuuchisho() {
        return loopBatch(SetKougakuGassanKetteiTsuuchishoProcess.class).arguments(setParameter()).define();
    }

    /**
     * 高額合算支給不支給決定の決定通知書作成年月日を更新のメソッドです。
     *
     * @return 対象者抽出Process
     */
    @Step(高額合算支給不支給決定の決定通知書作成年月日を更新)
    protected IBatchFlowCommand updateDbT3074KogakuGassanShikyuFushikyuKettei() {
        return loopBatch(UpdateDbT3074Process.class).arguments(setParameter()).define();
    }

    /**
     * 処理日付管理マスタを更新のメソッドです。
     *
     * @return 対象者抽出Process
     */
    @Step(処理日付管理マスタを更新)
    protected IBatchFlowCommand updateDbT7022ShoriDateKanri() {
        return loopBatch(UpdateDbT7022Process.class).arguments(setParameter()).define();
    }

    private KogakugassanShikyuKetteitsuchishoProcessParameter setParameter() {
        KogakugassanShikyuKetteitsuchishoProcessParameter parameter = new KogakugassanShikyuKetteitsuchishoProcessParameter();
        DBC040050_KogakugassanShikyuKetteitsuchishoParameter batchParameter = getParameter();
        parameter.set日付選択区分(batchParameter.get日付選択区分());
        parameter.set受取年月(batchParameter.get受取年月());
        parameter.set申請開始年月日(batchParameter.get申請開始年月日());
        parameter.set申請終了年月日(batchParameter.get申請終了年月日());
        parameter.set決定開始年月日(batchParameter.get決定開始年月日());
        parameter.set決定終了年月日(batchParameter.get決定終了年月日());
        parameter.set印書区分(batchParameter.get印書区分());
        parameter.set改頁出力順ID(batchParameter.get改頁出力順ID());
        parameter.set発行日(batchParameter.get発行日());
        parameter.set支払予定日印字有無(batchParameter.get支払予定日印字有無());
        parameter.set支払予定日(batchParameter.get支払予定日());
        parameter.set決定日一括更新区分(batchParameter.get決定日一括更新区分());
        parameter.set決定日(batchParameter.get決定日());
        parameter.set文書番号(batchParameter.get文書番号());
        parameter.set処理日時(batchParameter.get処理日時());
        return parameter;
    }
}
