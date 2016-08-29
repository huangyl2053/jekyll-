/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710210.JigyoBunKogakuGassanShikyuKetteiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710210.DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 汎用リスト_事業分高額合算支給決定情報のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
public class DBC710210_HanyoListJigyoBunKogakuGassanShikyuKettei
        extends BatchFlowBase<DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter> {

    private static final String 事業分高額合算支給決定情報 = "JigyoBunKogakuGassanShikyuKettei";

    @Override
    protected void defineFlow() {
        executeStep(事業分高額合算支給決定情報);
    }

    @Step(事業分高額合算支給決定情報)
    IBatchFlowCommand callJigyoBunKogakuGassanShikyuKettei() {
        return loopBatch(JigyoBunKogakuGassanShikyuKetteiProcess.class).arguments(getParameter().toProcessParameter()).define();
    }
}
