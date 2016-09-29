/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010;

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
        super.beforeExecute();
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
    }

    @Override
    protected void process() {
        myBatisParameter = processParameter.toMybatisParameter();
        mapper.delete前回処理高額介護サービス費支給申請全件一時(myBatisParameter);
        mapper.delete前回処理高額介護サービス費支給判定結果全件一時(myBatisParameter);
        mapper.delete前回処理高額介護サービス費支給審査決定全件一時(myBatisParameter);
        mapper.delete前回処理高額介護サービス費給付対象者合計全件一時(myBatisParameter);
        mapper.delete前回処理高額介護サービス費給付対象者明細全件一時(myBatisParameter);
    }

}
