/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.mapper.YokaigoNinteiShinseiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.YokaigoNinteiShinseiDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定の登録・修正・削除を行うためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class YokaigoNinteiShinseiManager {

    private final YokaigoNinteiShinseiDac dac;

    /**
     * 新しいYokaigoNinteiShinseiManagerのインスタンスを生成します。
     */
    public YokaigoNinteiShinseiManager() {
        dac = InstanceProvider.create(YokaigoNinteiShinseiDac.class);
    }

    /**
     * Constructor for Test
     *
     * @param dac YokaigoNinteiShinseiDac
     */
    YokaigoNinteiShinseiManager(YokaigoNinteiShinseiDac dac) {
        this.dac = dac;
    }

    /**
     * YokaigoNinteiShinseiの内容でDBへ保存します。
     *
     * @param 要介護認定申請 要介護認定申請
     * @return 成功したときはtrue, 失敗したときはfalse
     */
    public boolean save(YokaigoNinteiShinsei 要介護認定申請) {
        int result = dac.insertOrUpdate(YokaigoNinteiShinseiMapper.toDbT5001NinteiShinseiJohoEntity(要介護認定申請));
        return isSuccess(result);
    }

    private boolean isSuccess(int result) {
        return result != 0;
    }
}
