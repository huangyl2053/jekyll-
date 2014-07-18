/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.entity.mapper.YokaigoNinteiShinseiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.YokaigoNinteiShinseiDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author N3327 三浦 凌
 */
public class YokaigoNinteiShinseiManager {

    private final YokaigoNinteiShinseiDac dac;

    public YokaigoNinteiShinseiManager() {
        dac = InstanceProvider.create(YokaigoNinteiShinseiDac.class);
    }

    public boolean save(YokaigoNinteiShinsei 要介護認定申請) {
        dac.insertOrUpdate(YokaigoNinteiShinseiMapper.toDbT5001NinteiShinseiJohoEntity(要介護認定申請));
        return true;
    }
}
