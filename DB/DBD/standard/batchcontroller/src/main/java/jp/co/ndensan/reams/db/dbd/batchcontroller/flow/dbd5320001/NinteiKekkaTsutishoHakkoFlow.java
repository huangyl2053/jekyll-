/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd5320001;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5320001.NinteiKekkaTsutishoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5320001.ServiceHenkoTsutishoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5320001.YokaigoHenkoTsutishoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5320001.ShutsuryokuTaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5320001.TsutishoHakkoParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;

/**
 * 認定結果通知書発行のバッチフロークラスです。
 *
 * @reamsid_L DBD-1430-020 lit
 */
public class NinteiKekkaTsutishoHakkoFlow extends BatchFlowBase<TsutishoHakkoParameter> {

    private static final String 認定結果通知書発行 = "認定結果通知書発行";
    private static final String サービス変更通知書発行 = "サービス変更通知書発行";
    private static final String 要介護度変更通知書発行 = "要介護度変更通知書発行";
    private IShikibetsuTaishoPSMSearchKey searchKey;

    @Override
    protected void initialize() {
        searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義).build();
    }

    @Override
    protected void defineFlow() {
        if (getParameter().get出力対象().contains(ShutsuryokuTaishoKubun.認定結果通知書)) {
            executeStep(認定結果通知書発行);
        }
        if (getParameter().get出力対象().contains(ShutsuryokuTaishoKubun.サービス変更通知書)) {
            executeStep(サービス変更通知書発行);
        }
        if (getParameter().get出力対象().contains(ShutsuryokuTaishoKubun.要介護度変更通知書)) {
            executeStep(要介護度変更通知書発行);
        }
    }

    /**
     * 認定結果通知書発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定結果通知書発行)
    protected IBatchFlowCommand hakkoNinteiKekkaTsutisho() {
        return loopBatch(NinteiKekkaTsutishoProcess.class)
                .arguments(getParameter().toNinteiKekkaTsutishoProcessParameter(searchKey))
                .define();
    }

    /**
     * サービス変更通知書発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(サービス変更通知書発行)
    protected IBatchFlowCommand hakkoServiceHenkoTsutisho() {
        return loopBatch(ServiceHenkoTsutishoProcess.class)
                .arguments(getParameter().toServiceHenkoTsutishoProcessParameter(searchKey))
                .define();
    }

    /**
     * 要介護度変更通知書発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(要介護度変更通知書発行)
    protected IBatchFlowCommand hakkoYokaigoHenkoTsutisho() {
        return loopBatch(YokaigoHenkoTsutishoProcess.class)
                .arguments(getParameter().toYokaigoHenkoTsutishoProcessParameter(searchKey))
                .define();
    }
}
