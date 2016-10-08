/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD104010.JukyushaNinteishasuJokyohyoOutputProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD104010.JukyushaShinseiNinteiJokyohyoOutputProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD104010.JukyushagenmeninteiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD104010.JukyushagenmenshinseiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD104010.DBD104010_JukyushaGemmenJisshiJokyoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.JukyushaGenmenJissijokyo.NinteijokyohyoSyutsuryokuChohyo;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd104010.DBD104010ProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 受給者減免実施状況のバッチフロークラスです。
 *
 * @reamsid_L DBD-3770-030 liuwei2
 */
public class DBD104010_JukyushaGemmenJisshiJokyo extends BatchFlowBase<DBD104010_JukyushaGemmenJisshiJokyoParameter> {

    private static final String 集計受給者減免月別申請認定状況表 = "count集計受給者減免月別申請";
    private static final String 集計受給者減免月別認定者数状況表 = "count受給者減免月別認定";
    private static final String 申請帳票出力を行う = "set受給者減免月別申請認定状況帳票出力";
    private static final String 認定者数帳票出力を行う = "set受給者減免月別認定者数帳票出力";
    private YMDHMS systemTime;

    @Override
    protected void initialize() {
        systemTime = YMDHMS.now();
    }

    @Override
    protected void defineFlow() {
        if (NinteijokyohyoSyutsuryokuChohyo.受給者減免月別申請認定状況表.getコード().equals(getParameter().get出力帳票())) {
            executeStep(集計受給者減免月別申請認定状況表);
            executeStep(申請帳票出力を行う);
        } else {
            executeStep(集計受給者減免月別認定者数状況表);
            executeStep(認定者数帳票出力を行う);
        }

    }

    /**
     * 受給者減免月別申請・認定状況表を集計するのProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(集計受給者減免月別申請認定状況表)
    protected IBatchFlowCommand count集計受給者減免月別申請() {
        return loopBatch(JukyushagenmenshinseiProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * 受給者減免月別認定者数状況表を集計するのProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(集計受給者減免月別認定者数状況表)
    protected IBatchFlowCommand count受給者減免月別認定() {
        return loopBatch(JukyushagenmeninteiProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * set申請認定帳票出力のProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(申請帳票出力を行う)
    protected IBatchFlowCommand set受給者減免月別申請認定状況帳票出力() {
        return loopBatch(JukyushaShinseiNinteiJokyohyoOutputProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * set認定者数帳票出力のProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定者数帳票出力を行う)
    protected IBatchFlowCommand set受給者減免月別認定者数帳票出力() {
        return loopBatch(JukyushaNinteishasuJokyohyoOutputProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    private DBD104010ProcessParameter createProcessParameter() {
        DBD104010ProcessParameter processParameter = new DBD104010ProcessParameter();
        DBD104010_JukyushaGemmenJisshiJokyoParameter parameter = getParameter();
        processParameter.set基準日(parameter.get基準日());
        processParameter.set対象年度(parameter.get対象年度());
        processParameter.set宛名抽出条件(parameter.get宛名抽出条件());
        processParameter.set基準日区分(parameter.get基準日区分());
        processParameter.set出力帳票(parameter.get出力帳票());
        processParameter.set帳票ID(parameter.get帳票ID());
        processParameter.setSystemTime(systemTime);

        return processParameter;
    }

}
