/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.DelTaisyogaiJuminJohoTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsHakouRirekiAndKanriMstProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsJuminJohoTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsJyukyushaTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsNendoNaiYuSikakushaTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsReHakouShotokushokaihyoTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsReHakouTaisyoshaTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsSetaiinHaakuTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsSetaiinShotokuJohoTmp1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsSetaiinShotokuJohoTmp2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsSetaiinShotokuJohoTmp3Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.InsShotokushokaihyoTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.PrtShotokushokaihyoListProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001.PrtShotokushokaihyoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB114001.DBB114001_ShotokuShokaihyoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT51001_所得照会票一括発行のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class DBB114001_ShotokuShokaihyoHakko extends BatchFlowBase<DBB114001_ShotokuShokaihyoHakkoParameter> {

    private static final RString 出力対象_0 = new RString("0");
    private static final RString 出力対象_1 = new RString("1");
    private static final RString 出力対象_2 = new RString("2");
    private static final RString 出力対象_3 = new RString("3");
    private static final RString OUTPUTCOUNT_1 = new RString("1");
    private static final RString 世帯員把握BATCH_ID = new RString("DBB002001_SetaiinHaaku");
    private static final String 所得照会候補者TEMPテーブルに登録 = "insJuminJohoTmpProcess";
    private static final String 対象外の住民情報を更新 = "delTaisyogaiJuminJohoTmpProcess";
    private static final String 年度内有資格者TEMPテーブルに登録 = "insNendoNaiYuSikakushaTmpProcess";
    private static final String 世帯員所得情報TEMPテーブル1に登録 = "insSetaiinShotokuJohoTmp1Process";
    private static final String 世帯員所得情報TEMPテーブル2に登録 = "insSetaiinShotokuJohoTmp2Process";
    private static final String 世帯員把握TEMPテーブル1へ出力 = "setaiShotokuKazeiHanteiFuka1";
    private static final String 世帯員把握入力TEMPに出力 = "insSetaiinHaakuTempProcess";
    private static final String 世帯員把握TEMPテーブル2へ出力 = "setaiShotokuKazeiHanteiFuka2";
    private static final String 受給者TEMPテーブルに登録 = "insJyukyushaTmpProcess";
    private static final String 世帯員所得情報TEMPテーブル3に登録 = "insSetaiinShotokuJohoTmp3Process";
    private static final String 所得照会票データTEMPテーブルに登録 = "insShotokushokaihyoTmpProcess";
    private static final String 所得照会票の出力 = "prtShotokushokaihyoProcess";
    private static final String 所得照会票発行履歴介護所得管理マスタに登録 = "insHakouRirekiAndKanriMstProcess";
    private static final String 所得照会票一覧の出力 = "prtShotokushokaihyoListProcess";
    private static final String 再発行対象者TEMPテーブルに登録 = "insReHakouTaisyoshaTmpProcess";
    private static final String 再発行所得照会票データTEMPテーブルに登録 = "insReHakouShotokushokaihyoTmpProcess";

    private DBB114001_ShotokuShokaihyoHakkoParameter batchParameter;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private RString 出力対象;

    @Override
    public void initialize() {
        processParameter = creatProcessParameter();
        出力対象 = processParameter.get出力対象();
    }

    @Override
    protected void defineFlow() {
        if (出力対象_1.equals(出力対象) || 出力対象_2.equals(出力対象) || 出力対象_3.equals(出力対象)) {
            if (出力対象_1.equals(出力対象)) {
                executeStep(所得照会候補者TEMPテーブルに登録);
                executeStep(対象外の住民情報を更新);
                executeStep(年度内有資格者TEMPテーブルに登録);
                executeStep(世帯員把握入力TEMPに出力);
                executeStep(世帯員把握TEMPテーブル1へ出力);
                executeStep(世帯員所得情報TEMPテーブル1に登録);
                executeStep(受給者TEMPテーブルに登録);
                executeStep(世帯員把握TEMPテーブル2へ出力);
                executeStep(世帯員所得情報TEMPテーブル2に登録);
                executeStep(世帯員所得情報TEMPテーブル3に登録);
            } else if (出力対象_2.equals(出力対象)) {
                executeStep(所得照会候補者TEMPテーブルに登録);
                executeStep(対象外の住民情報を更新);
                executeStep(年度内有資格者TEMPテーブルに登録);
                executeStep(世帯員把握入力TEMPに出力);
                executeStep(世帯員把握TEMPテーブル1へ出力);
                executeStep(世帯員所得情報TEMPテーブル1に登録);
            } else if (出力対象_3.equals(出力対象)) {
                executeStep(所得照会候補者TEMPテーブルに登録);
                executeStep(対象外の住民情報を更新);
                executeStep(受給者TEMPテーブルに登録);
                executeStep(世帯員把握TEMPテーブル2へ出力);
                executeStep(世帯員所得情報TEMPテーブル2に登録);
            }
            executeStep(所得照会票データTEMPテーブルに登録);
            executeStep(所得照会票の出力);
            if (OUTPUTCOUNT_1.equals(getResult(RString.class, new RString(所得照会票の出力), PrtShotokushokaihyoProcess.PARAMETER_OUT_OUTPUTCOUNT))
                    && !processParameter.isテストプリント()) {
                executeStep(所得照会票発行履歴介護所得管理マスタに登録);
            }
            executeStep(所得照会票一覧の出力);
        } else if (出力対象_0.equals(出力対象)) {
            executeStep(所得照会候補者TEMPテーブルに登録);
            executeStep(対象外の住民情報を更新);
            executeStep(再発行対象者TEMPテーブルに登録);
            executeStep(再発行所得照会票データTEMPテーブルに登録);
            executeStep(所得照会票の出力);
        }
    }

    /**
     * 所得照会候補者TEMPテーブルに登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(所得照会候補者TEMPテーブルに登録)
    protected IBatchFlowCommand insJuminJohoTmpProcess() {
        if (processParameter.get処理年度() == null || processParameter.get処理年度().isEmpty()
                || RString.isNullOrEmpty(processParameter.get出力対象())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(InsJuminJohoTmpProcess.class).arguments(processParameter).define();
    }

    /**
     * 対象外の住民情報を更新のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(対象外の住民情報を更新)
    protected IBatchFlowCommand delTaisyogaiJuminJohoTmpProcess() {
        if (processParameter.get処理年度() == null || processParameter.get処理年度().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return simpleBatch(DelTaisyogaiJuminJohoTmpProcess.class).arguments(processParameter).define();
    }

    /**
     * 年度内有資格者TEMPテーブルに登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(年度内有資格者TEMPテーブルに登録)
    protected IBatchFlowCommand insNendoNaiYuSikakushaTmpProcess() {
        if (processParameter.get処理年度() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(InsNendoNaiYuSikakushaTmpProcess.class).arguments(processParameter).define();
    }

    /**
     * 年度内有資格者TEMPテーブルに登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(世帯員把握入力TEMPに出力)
    protected IBatchFlowCommand insSetaiinHaakuTempProcess() {
        return loopBatch(InsSetaiinHaakuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 世帯員把握TEMPテーブル1へ出力のメソッドです。
     *
     * @return 世帯員所得情報一時
     */
    @Step(世帯員把握TEMPテーブル1へ出力)
    protected IBatchFlowCommand setaiShotokuKazeiHanteiFuka1() {
        RString 管理識別区分 = SetaiinHaakuKanriShikibetsuKubun.賦課.getコード();
        DBB002001_SetaiinHaakuParameter param = new DBB002001_SetaiinHaakuParameter(管理識別区分);
        return otherBatchFlow(世帯員把握BATCH_ID, SubGyomuCode.DBB介護賦課, param).define();
    }

    /**
     * 世帯員所得情報TEMPテーブル1に登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(世帯員所得情報TEMPテーブル1に登録)
    protected IBatchFlowCommand insSetaiinShotokuJohoTmp1Process() {
        return loopBatch(InsSetaiinShotokuJohoTmp1Process.class).arguments(processParameter).define();
    }

    /**
     * 受給者TEMPテーブルに登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(受給者TEMPテーブルに登録)
    protected IBatchFlowCommand insJyukyushaTmpProcess() {
        if (processParameter.get処理年度() == null || processParameter.get処理年度().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(InsJyukyushaTmpProcess.class).arguments(processParameter).define();
    }

    /**
     * 世帯員把握TEMPテーブル2へ出力のメソッドです。
     *
     * @return 世帯員所得情報一時
     */
    @Step(世帯員把握TEMPテーブル2へ出力)
    protected IBatchFlowCommand setaiShotokuKazeiHanteiFuka2() {
        RString 管理識別区分 = SetaiinHaakuKanriShikibetsuKubun.高額介護.getコード();
        DBB002001_SetaiinHaakuParameter param = new DBB002001_SetaiinHaakuParameter(管理識別区分);
        return otherBatchFlow(世帯員把握BATCH_ID, SubGyomuCode.DBB介護賦課, param).define();
    }

    /**
     * 世帯員所得情報TEMPテーブル2に登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(世帯員所得情報TEMPテーブル2に登録)
    protected IBatchFlowCommand insSetaiinShotokuJohoTmp2Process() {
        return loopBatch(InsSetaiinShotokuJohoTmp2Process.class).arguments(processParameter).define();
    }

    /**
     * 世帯員所得情報TEMPテーブル3に登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(世帯員所得情報TEMPテーブル3に登録)
    protected IBatchFlowCommand insSetaiinShotokuJohoTmp3Process() {
        return loopBatch(InsSetaiinShotokuJohoTmp3Process.class).arguments(processParameter).define();
    }

    /**
     * 所得照会票データTEMPテーブルに登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(所得照会票データTEMPテーブルに登録)
    protected IBatchFlowCommand insShotokushokaihyoTmpProcess() {
        if ((processParameter.get処理年度() == null || processParameter.get処理年度().isEmpty())
                || RString.isNullOrEmpty(processParameter.get出力対象())
                || RString.isNullOrEmpty(processParameter.get導入形態コード())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(InsShotokushokaihyoTmpProcess.class).arguments(processParameter).define();
    }

    /**
     * 所得照会票の出力のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(所得照会票の出力)
    protected IBatchFlowCommand prtShotokushokaihyoProcess() {
        return loopBatch(PrtShotokushokaihyoProcess.class).arguments(processParameter).define();
    }

    /**
     * 所得照会票発行履歴介護所得管理マスタに登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(所得照会票発行履歴介護所得管理マスタに登録)
    protected IBatchFlowCommand insHakouRirekiAndKanriMstProcess() {
        if ((processParameter.get処理年度() == null || processParameter.get処理年度().isEmpty())
                || (processParameter.get照会年月日() == null || processParameter.get照会年月日().isEmpty())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(InsHakouRirekiAndKanriMstProcess.class).arguments(processParameter).define();
    }

    /**
     * 所得照会票一覧の出力のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(所得照会票一覧の出力)
    protected IBatchFlowCommand prtShotokushokaihyoListProcess() {
        return loopBatch(PrtShotokushokaihyoListProcess.class).arguments(processParameter).define();
    }

    /**
     * 再発行対象者TEMPテーブルに登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(再発行対象者TEMPテーブルに登録)
    protected IBatchFlowCommand insReHakouTaisyoshaTmpProcess() {
        if (processParameter.get処理年度() == null || processParameter.get出力対象() == null
                || processParameter.get再発行対象リスト() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(InsReHakouTaisyoshaTmpProcess.class).arguments(processParameter).define();
    }

    /**
     * 再発行所得照会票データTEMPテーブルに登録のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(再発行所得照会票データTEMPテーブルに登録)
    protected IBatchFlowCommand insReHakouShotokushokaihyoTmpProcess() {
        if (processParameter.get処理年度() == null || processParameter.get出力対象() == null
                || processParameter.get再発行対象リスト() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(InsReHakouShotokushokaihyoTmpProcess.class).arguments(processParameter).define();
    }

    private ShotokuShokaihyoHakkoProcessParameter creatProcessParameter() {
        ShotokuShokaihyoHakkoProcessParameter parameter = new ShotokuShokaihyoHakkoProcessParameter();
        batchParameter = getParameter();
        parameter.set処理年度(batchParameter.get処理年度());
        parameter.set照会年月日(batchParameter.get照会年月日());
        parameter.set出力対象(batchParameter.get出力対象());
        parameter.set再発行対象リスト(batchParameter.get再発行対象リスト());
        parameter.setテストプリント(batchParameter.isテストプリント());
        parameter.set出力順ID(batchParameter.get出力順ID());
        parameter.set導入形態コード(batchParameter.get導入形態コード());
        parameter.set構成市町村情報リスト(batchParameter.get構成市町村情報リスト());
        parameter.set出力順(batchParameter.get出力順());
        parameter.set改頁項目ID(batchParameter.get改頁項目ID());
        return parameter;
    }
}
