/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD206010.KeikakuJigyoshaJohoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD206010.SabisuKeikakuJigyoshaJohoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD206010.TyohyoShutuyukuProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD206010.DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist.JigyoshaSentaku;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd206010.DBD206010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd206010.DBD206010TyohyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のバッチクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
public class DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakko
        extends BatchFlowBase<DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter> {

    private static final String 計画事業者データの取得格納 = "get計画事業者データ";
    private static final String サービス事業者データの取得格納 = "getサービス事業者データ";
    private static final String 帳票出力を行う = "set帳票出力";
    private YMDHMS systemTime;

    @Override
    protected void initialize() {
        systemTime = YMDHMS.now();
    }

    @Override
    protected void defineFlow() {

        if (JigyoshaSentaku.計画事業者.getコード().equals(getParameter().get事業者選択())
                || JigyoshaSentaku.計画事業者とサービス事業者.getコード().equals(getParameter().get事業者選択())) {
            executeStep(計画事業者データの取得格納);
        }
        if (JigyoshaSentaku.サービス事業者.getコード().equals(getParameter().get事業者選択())
                || JigyoshaSentaku.計画事業者とサービス事業者.getコード().equals(getParameter().get事業者選択())) {
            executeStep(サービス事業者データの取得格納);
        }
        executeStep(帳票出力を行う);
    }

    /**
     * get計画事業者データのProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(計画事業者データの取得格納)
    protected IBatchFlowCommand get計画事業者データ() {
        return loopBatch(KeikakuJigyoshaJohoProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * getサービス事業者データのProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(サービス事業者データの取得格納)
    protected IBatchFlowCommand getサービス事業者データ() {
        return loopBatch(SabisuKeikakuJigyoshaJohoProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * set帳票出力のProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票出力を行う)
    protected IBatchFlowCommand set帳票出力() {
        return loopBatch(TyohyoShutuyukuProcess.class)
                .arguments(createTyohyoProcessParameter(systemTime))
                .define();
    }

    private DBD206010ProcessParameter createProcessParameter() {
        DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter parameter = getParameter();
        DBD206010ProcessParameter processParameter = new DBD206010ProcessParameter();
        processParameter.set基準日(parameter.get基準日());
        processParameter.set事業者名(parameter.get事業者名());
        processParameter.set事業者番号(parameter.get事業者番号());
        processParameter.set処理日時(parameter.get処理日時());
        processParameter.set出力順ID(parameter.get出力順ID());
        processParameter.set資格喪失者選択(parameter.get資格喪失者選択());
        return processParameter;
    }

    private DBD206010TyohyoProcessParameter createTyohyoProcessParameter(YMDHMS systemTime) {
        DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter parameter = getParameter();
        DBD206010TyohyoProcessParameter processParameter = new DBD206010TyohyoProcessParameter();
        processParameter.set基準日(parameter.get基準日());
        processParameter.set事業者名(parameter.get事業者名());
        processParameter.setSystemTime(systemTime);
        processParameter.set事業者選択(parameter.get事業者選択());
        processParameter.set資格喪失者選択(parameter.get資格喪失者選択());
        processParameter.set事業者番号(parameter.get事業者番号());
        processParameter.set出力順ID(parameter.get出力順ID());

        return processParameter;
    }

}
