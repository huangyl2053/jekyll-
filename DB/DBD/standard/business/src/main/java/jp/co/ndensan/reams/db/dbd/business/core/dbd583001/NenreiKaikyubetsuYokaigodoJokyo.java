/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd583001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001.ToukeiNinzuEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 統計人数Entity設定のビジネスです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyo {

    /**
     * initialize統計人数Entity
     *
     * @param toukeiNinzuEntity ToukeiNinzuEntity
     */
    public void initializeToukeiNinzuEntity(ToukeiNinzuEntity toukeiNinzuEntity) {
        if (toukeiNinzuEntity.get自立人数() == null) {
            toukeiNinzuEntity.set自立人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get経過介護人数() == null) {
            toukeiNinzuEntity.set経過介護人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要支援1人数() == null) {
            toukeiNinzuEntity.set要支援1人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要支援2人数() == null) {
            toukeiNinzuEntity.set要支援2人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護1人数() == null) {
            toukeiNinzuEntity.set要介護1人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護2人数() == null) {
            toukeiNinzuEntity.set要介護2人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護3人数() == null) {
            toukeiNinzuEntity.set要介護3人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護4人数() == null) {
            toukeiNinzuEntity.set要介護4人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護5人数() == null) {
            toukeiNinzuEntity.set要介護5人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get合計() == null) {
            toukeiNinzuEntity.set合計(Decimal.ZERO);
        }

    }

    /**
     * set統計人数Entity
     *
     * @param toukeiNinzuEntity ToukeiNinzuEntity
     */
    public void setToukeiNinzuEntityZero(ToukeiNinzuEntity toukeiNinzuEntity) {
        toukeiNinzuEntity.set自立人数(Decimal.ZERO);
        toukeiNinzuEntity.set経過介護人数(Decimal.ZERO);
        toukeiNinzuEntity.set要支援1人数(Decimal.ZERO);
        toukeiNinzuEntity.set要支援2人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護1人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護2人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護3人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護4人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護5人数(Decimal.ZERO);
        toukeiNinzuEntity.set合計(Decimal.ZERO);
    }

}
