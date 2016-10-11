/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120050.KyufuJissekiInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120050.KyufuJissekiInMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekiin.IKyufuJissekiInMasterTorokuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 給付実績更新結果情報取込・再処理準備を実行する。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInDoSaiShoriJunbiProcess extends SimpleBatchProcessBase {

    private KyufuJissekiInMasterTorokuProcessParameter parameter;

    @Override
    protected void process() {
        IKyufuJissekiInMasterTorokuMapper mapper = getMapper(IKyufuJissekiInMasterTorokuMapper.class);
        KyufuJissekiInMybatisParameter mybatisParameter = new KyufuJissekiInMybatisParameter();
        mybatisParameter.set処理年月(parameter.get処理年月());
        mapper.delete給付実績基本(mybatisParameter);
        mapper.delete給付実績明細(mybatisParameter);
        mapper.delete給付実績緊急時施設療養(mybatisParameter);
        mapper.delete給付実績特定診療費(mybatisParameter);
        mapper.delete給付実績特定診療費特別療養費(mybatisParameter);
        mapper.delete給付実績食事費用(mybatisParameter);
        mapper.delete給付実績居宅サービス計画費(mybatisParameter);
        mapper.delete給付実績福祉用具販売費(mybatisParameter);
        mapper.delete給付実績住宅改修費(mybatisParameter);
        mapper.delete給付実績高額介護サービス費(mybatisParameter);
        mapper.delete給付実績特定入所者介護サービス費(mybatisParameter);
        mapper.delete給付実績社会福祉法人軽減額(mybatisParameter);
        mapper.delete給付実績ケアマネジメント費(mybatisParameter);
        mapper.delete給付実績所定疾患施設療養費等(mybatisParameter);
        mapper.delete給付実績明細住所地特例(mybatisParameter);
        mapper.delete給付実績集計(mybatisParameter);
    }

}
