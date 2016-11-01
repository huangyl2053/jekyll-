/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb014001.FuchoKarisanteiFukaMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka.IFuchoKarisanteiFukaMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 処理日付管理のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class UpdShoriDateKanriProcess extends SimpleBatchProcessBase {

    private FuchoKarisanteiFukaProcessParameter parameter;
    private IFuchoKarisanteiFukaMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IFuchoKarisanteiFukaMapper.class);
    }

    @Override
    protected void process() {
        FuchoKarisanteiFukaMybatisParameter mybatisParameter = new FuchoKarisanteiFukaMybatisParameter();
        mybatisParameter.set調定年度(parameter.get調定年度());
        mybatisParameter.set処理日付(new YMDHMS(parameter.getバッチ起動日時()));
        mapper.update処理日付管理(mybatisParameter);
    }

}
