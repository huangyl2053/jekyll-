/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 前回処理対象高額データの削除のプロセスのクラスです。
 *
 * @reamsid_L DBC-2010-040 zhouchuanlin
 */
public class DelSaishoriKogakuTmpProcess extends SimpleBatchProcessBase {

    private KyufuJissekiKihonKogakuMybatisParameter myBatisParameter;
    private IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper;
    private KyufuJissekiKihonKogakuProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
    }

    @Override
    protected void process() {
        myBatisParameter = processParameter.toMybatisParameter();
        mapper.insert高額介護削除キー一時(myBatisParameter);
        mapper.delete前回処理高額介護サービス費支給申請();
        mapper.delete前回処理高額介護サービス費支給判定結果();
        mapper.delete前回処理高額介護サービス費支給審査決定();
        mapper.delete前回処理高額介護サービス費給付対象者合計();
        mapper.delete前回処理高額介護サービス費給付対象者明細();
    }

}
