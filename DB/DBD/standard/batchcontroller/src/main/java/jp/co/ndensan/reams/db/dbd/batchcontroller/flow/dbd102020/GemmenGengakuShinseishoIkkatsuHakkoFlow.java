/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd102020;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko.FutanGendogakuNinteiShinseishoHakko;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko.FutanGendogakuOshiraseTsuchiHakko;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko.FutanGengaokuNinteiShinseishoHakkoIchiranSakusei;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko.HomonRiyoshaFutanGengakuShinseishoHakko;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko.RiyoshaFutangakuGemmenShinseishoHakko;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko.ShafukuRiyoshaKeigenShinseishoHakko;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd102020.DBD102020_GemmenGengakuShinseishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 減免減額申請書一括発行のバッチフロークラスです。
 *
 * @reamsid_L DBD-3530-070 mawy
 */
public class GemmenGengakuShinseishoIkkatsuHakkoFlow extends BatchFlowBase<DBD102020_GemmenGengakuShinseishoIkkatsuHakkoParameter> {

    private static final String 介護保険負担限度額認定申請書 = "futanGendogakuNinteiShinseishoHakko";
    private static final String 利用者負担額免除申請書 = "riyoshaFutangakuGemmenShinseishoHakko";
    private static final String 訪問介護利用者負担額減額申請書 = "homonRiyoshaFutanGengakuShinseishoHakko";
    private static final String 社会福祉法人等利用者負担軽減対象確認申請書 = "shafukuRiyoshaKeigenShinseishoHakko";
    private static final String 負担限度額認定お知らせ通知書発行 = "futanGendogakuOshiraseTsuchiHakko";
    private static final String 負担限度額認定申請書発行一覧表発行 = "futanGengaokuNinteiShinseishoHakkoIchiranSakusei";
    private static final String FUTANGENDOGAKUNINTEI = "DBD800001_FutangendogakuNinteiShinseisho";
    private static final String RIYOSHAFUTANGAKUGENGAKUMENJYO = "DBD800002_RiyoshaFutangakuGengakuMenjyoShinseisho";
    private static final String FUTANGENGAKUSHINSEISHOHAKKO = "DBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseisho";
    private static final String RIYOSHAFUTANGAKUKEIGENTAISHO
            = "DBD800006_ShafukuRiyoshaFutangakuKeigentaishoShinseisho";

    @Override
    protected void defineFlow() {
        DBD102020_GemmenGengakuShinseishoIkkatsuHakkoParameter parameter = getParameter();
        switch (parameter.get帳票ID().toString()) {
            case FUTANGENDOGAKUNINTEI:
                executeStep(介護保険負担限度額認定申請書);
                executeStep(負担限度額認定お知らせ通知書発行);
                executeStep(負担限度額認定申請書発行一覧表発行);
                break;
            case RIYOSHAFUTANGAKUGENGAKUMENJYO:
                executeStep(利用者負担額免除申請書);
                break;
            case FUTANGENGAKUSHINSEISHOHAKKO:
                executeStep(訪問介護利用者負担額減額申請書);
                break;
            case RIYOSHAFUTANGAKUKEIGENTAISHO:
                executeStep(社会福祉法人等利用者負担軽減対象確認申請書);
                break;
            default:
        }
    }

    /**
     * 介護保険負担限度額認定申請書、介護保険特定負担限度額認定申請書を発行するのbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護保険負担限度額認定申請書)
    protected IBatchFlowCommand futanGendogakuNinteiShinseishoHakkoProcess() {
        return loopBatch(FutanGendogakuNinteiShinseishoHakko.class)
                .arguments(getParameter().toShinseishoHakkoProcessParameter())
                .define();
    }

    /**
     * 利用者負担額免除申請書を発行するのbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担額免除申請書)
    protected IBatchFlowCommand riyoshaFutangakuGemmenShinseishoHakkoProcess() {
        return loopBatch(RiyoshaFutangakuGemmenShinseishoHakko.class)
                .arguments(getParameter().toShinseishoHakkoProcessParameter())
                .define();
    }

    /**
     * 訪問介護利用者負担額減額申請書を発行するのbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(訪問介護利用者負担額減額申請書)
    protected IBatchFlowCommand homonRiyoshaFutanGengakuShinseishoHakkoProcess() {
        return loopBatch(HomonRiyoshaFutanGengakuShinseishoHakko.class)
                .arguments(getParameter().toShinseishoHakkoProcessParameter())
                .define();
    }

    /**
     * 社会福祉法人等利用者負担軽減対象確認申請書を発行するのbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(社会福祉法人等利用者負担軽減対象確認申請書)
    protected IBatchFlowCommand shafukuRiyoshaKeigenShinseishoHakkoProcess() {
        return loopBatch(ShafukuRiyoshaKeigenShinseishoHakko.class)
                .arguments(getParameter().toShinseishoHakkoProcessParameter())
                .define();
    }

    /**
     * 負担限度額認定お知らせ通知書発行を一括発行するのbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(負担限度額認定お知らせ通知書発行)
    protected IBatchFlowCommand futanGendogakuOshiraseTsuchiHakkoProcess() {
        return loopBatch(FutanGendogakuOshiraseTsuchiHakko.class)
                .arguments(getParameter().toShinseishoHakkoProcessParameter())
                .define();
    }

    /**
     * 負担限度額認定申請書発行一覧表を発行するのbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(負担限度額認定申請書発行一覧表発行)
    protected IBatchFlowCommand futanGengaokuNinteiShinseishoHakkoIchiranSakuseiProcess() {
        return loopBatch(FutanGengaokuNinteiShinseishoHakkoIchiranSakusei.class)
                .arguments(getParameter().toShinseishoHakkoProcessParameter())
                .define();
    }

}
