/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120150;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInLoginMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassankyufujissekiin.IKogakuGassanKyufuJissekiInMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 高額合算給付実績取込のマスタ登録(マスタ更新)。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
public class KogakuGassanKyufuJissekiInDoMasterTorokuUpdateProcess extends SimpleBatchProcessBase {

    private KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter parameter;

    @Override
    protected void process() {
        KogakuGassanKyufuJissekiInLoginMybatisParameter dbParameter = new KogakuGassanKyufuJissekiInLoginMybatisParameter();
        dbParameter.set処理年月(parameter.get処理年月());
        getMapper(IKogakuGassanKyufuJissekiInMapper.class).update高額合算給付実績と一時データ(dbParameter);
    }

}
