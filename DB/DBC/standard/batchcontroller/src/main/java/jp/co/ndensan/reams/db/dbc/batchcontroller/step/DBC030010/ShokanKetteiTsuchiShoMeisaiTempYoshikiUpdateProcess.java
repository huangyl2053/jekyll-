/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 償還払い支給不支給決定通知書明細一時TBLを更新します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShoMeisaiTempYoshikiUpdateProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        getMapper(IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.class).get様式名称();
    }
}
