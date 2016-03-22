/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120070;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufutaishoshain.IKogakuKyufuTaishoshaInMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 高額介護サービス費給付対象者取込の一時テーブル編集
 */
public class KogakuKyufuTaishoshaInTempUpdateProcess extends SimpleBatchProcessBase {

    private IKogakuKyufuTaishoshaInMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKogakuKyufuTaishoshaInMapper.class);
    }

    @Override
    protected void process() {
        mapper.select一時テーブル();
    }
}
