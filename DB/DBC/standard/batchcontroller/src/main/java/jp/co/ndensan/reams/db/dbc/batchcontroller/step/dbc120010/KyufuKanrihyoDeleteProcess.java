/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufukanrihyo200004.IKyufuKanrihyo200004Mapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufukanrihyo200604.IKyufuKanrihyo200604Mapper;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public class KyufuKanrihyoDeleteProcess extends SimpleBatchProcessBase {

    //パラメータ名
    /**
     * shoriYM
     */
    public static final RString PARAMETER_SHORIYM;

    static {
        PARAMETER_SHORIYM = new RString("shoriYM");
    }

    //パラメータ受取変数
    InputParameter<RString> shoriYM;

    @Override
    protected void process() {

        IKyufuKanrihyo200004Mapper mapper200004 = getMapper(IKyufuKanrihyo200004Mapper.class);
        mapper200004.deleteKyufuKanrihyo200004(shoriYM.getValue());

        IKyufuKanrihyo200604Mapper mapper200604 = getMapper(IKyufuKanrihyo200604Mapper.class);
        mapper200604.deleteKyufuKanrihyo200604(shoriYM.getValue());

    }
}
