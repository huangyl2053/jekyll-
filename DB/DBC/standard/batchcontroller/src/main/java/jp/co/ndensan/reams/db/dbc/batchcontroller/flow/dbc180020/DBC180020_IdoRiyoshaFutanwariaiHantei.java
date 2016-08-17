/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc180020;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;

/**
 * バッチ設計_DBCMNK1002_利用者負担割合判定（共通）のクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class DBC180020_IdoRiyoshaFutanwariaiHantei extends BatchFlowBase<DBC180020_IdoRiyoshaFutanwariaiHanteiParameter> {

    @Override
    protected void defineFlow() {
//        RiyoshaFutanWariaiHantei service = RiyoshaFutanWariaiHantei.createInstance();
//        getParameter().setHanteiKijunbi(service.getHanteiKijunbi(
//                new RiyoshaFutanWariaiHanteiUtil().getFlexibleDateString(getParameter().getKijunbi())));
//        getParameter().setTaishoGetsu(service.initializeTaishoGetsu());
    }
}
