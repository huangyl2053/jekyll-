/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110020.JukyushaIdoRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110020.JukyushaIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushaidorenrakuhyoout.IJukyushaIdoRenrakuhyoOutMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 *
 * 処理対象年月受給者異動送付データの削除のプロセスのクラスです。
 *
 * @reamsid_L DBC-2720-070 chenhui
 *
 */
public class DelJukyushaIdoRenrakuhyoProcess extends SimpleBatchProcessBase {

    private JukyushaIdoRenrakuhyoOutMybatisParameter myBatisParameter;
    private IJukyushaIdoRenrakuhyoOutMapper mapper;
    private JukyushaIdoRenrakuhyoOutProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(IJukyushaIdoRenrakuhyoOutMapper.class);
    }

    @Override
    protected void process() {
        myBatisParameter = processParameter.toMybatisParameter();
        mapper.delete受給者異動送付(myBatisParameter);
    }
}
