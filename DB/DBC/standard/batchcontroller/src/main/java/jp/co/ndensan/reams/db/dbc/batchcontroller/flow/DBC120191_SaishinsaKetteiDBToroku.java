/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.saishinsaketteidbtoroku.SaishinsaKetteiMeisaiSakujoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.saishinsaketteidbtoroku.SaishinsaKetteiMeisaiTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.saishinsaketteidbtoroku.SaishinsaKetteiShukeiSakujoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.saishinsaketteidbtoroku.SaishinsaKetteiShukeiTorokuProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120190.DBC120191_SaishinsaKetteiDBTorokuParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteidbtoroku.SaishinsaKetteiDBProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込共通処理（マスタ登録）
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class DBC120191_SaishinsaKetteiDBToroku extends BatchFlowBase<DBC120191_SaishinsaKetteiDBTorokuParameter> {

    private static final String 再審査決定集計削除 = "deleteSaishinsaKetteiShukei";
    private static final String 再審査決定明細削除 = "deleteSaishinsaKetteiMeisai";
    private static final String 再審査決定集計登録 = "insertSaishinsaKetteiShukei";
    private static final String 再審査決定明細登録 = "insertSaishinsaKetteiMeisai";

    private static final RString 交換情報識別番号_172 = new RString("172");
    private static final RString 交換情報識別番号_652 = new RString("652");
    private static final RString 交換情報識別番号_178 = new RString("178");
    private static final RString 交換情報識別番号_662 = new RString("662");


    @Override
    protected void defineFlow() {
        if (SaiShoriKubun.再処理.equals(getParameter().get再処理区分())) {
            executeStep(再審査決定集計削除);
            executeStep(再審査決定明細削除);
        }
        executeStep(再審査決定集計登録);
        executeStep(再審査決定明細登録);
    }

    /**
     * 再審査決定集計削除
     *
     * @return SaishinsaKetteiShukeiSakujoProcess
     */
    @Step(再審査決定集計削除)
    protected IBatchFlowCommand deleteSaishinsaKetteiShukei() {
        SaishinsaKetteiDBProcessParameter parameter = new SaishinsaKetteiDBProcessParameter();
        parameter.set保険者区分(get保険者区分(getParameter().get交換情報識別番号()));
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(SaishinsaKetteiShukeiSakujoProcess.class).arguments(parameter).define();
    }

    /**
     * 再審査決定明細削除
     *
     * @return SaishinsaKetteiMeisaiSakujoProcess
     */
    @Step(再審査決定明細削除)
    protected IBatchFlowCommand deleteSaishinsaKetteiMeisai() {
        SaishinsaKetteiDBProcessParameter parameter = new SaishinsaKetteiDBProcessParameter();
        parameter.set保険者区分(get保険者区分(getParameter().get交換情報識別番号()));
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(SaishinsaKetteiMeisaiSakujoProcess.class).arguments(parameter).define();
    }

    /**
     * 再審査決定集計登録
     *
     * @return SaishinsaKetteiShukeiTorokuProcess
     */
    @Step(再審査決定集計登録)
    protected IBatchFlowCommand insertSaishinsaKetteiShukei() {
        SaishinsaKetteiDBProcessParameter parameter = new SaishinsaKetteiDBProcessParameter();
        parameter.set保険者区分(get保険者区分(getParameter().get交換情報識別番号()));
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(SaishinsaKetteiShukeiTorokuProcess.class).arguments(parameter).define();
    }

    /**
     * 再審査決定明細登録
     *
     * @return SaishinsaKetteiMeisaiTorokuProcess
     */
    @Step(再審査決定明細登録)
    protected IBatchFlowCommand insertSaishinsaKetteiMeisai() {
        SaishinsaKetteiDBProcessParameter parameter = new SaishinsaKetteiDBProcessParameter();
        parameter.set保険者区分(get保険者区分(getParameter().get交換情報識別番号()));
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(SaishinsaKetteiMeisaiTorokuProcess.class).arguments(parameter).define();
    }

    private RString get保険者区分(RString 交換情報識別番号) {
        RString 保険者区分 = RString.EMPTY;
        if (交換情報識別番号_172.equals(交換情報識別番号)) {
            保険者区分 = new RString("1");
        } else if (交換情報識別番号_652.equals(交換情報識別番号)) {
            保険者区分 = new RString("2");

        } else if (交換情報識別番号_178.equals(交換情報識別番号)) {
            保険者区分 = new RString("3");

        } else if (交換情報識別番号_662.equals(交換情報識別番号)) {
            保険者区分 = new RString("4");
        }
        return 保険者区分;
    }
}
