/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc020060;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020060.DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;

/**
 *
 * 高額総合事業サービス費支給（不支給）決定通知書作成のバッチフロークラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public class DBC020060_KogakuJigyoServicehiShikyuKetteiTsuchishoFlow
        extends BatchFlowBase<DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter> {

    private static final String 事業高額一時テーブルの登録 = "insertKogakuKaigoKetteiTsuchishoInfoTempProcess";

    @Override
    protected void defineFlow() {
        executeStep(事業高額一時テーブルの登録);
    }

}
