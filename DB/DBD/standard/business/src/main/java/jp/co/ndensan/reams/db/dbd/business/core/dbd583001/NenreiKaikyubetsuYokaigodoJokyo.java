/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd583001;

import java.util.List;
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

    /**
     * add統計人数Entity
     *
     * @param index int
     * @param toukeiNinzuEntity1 ToukeiNinzuEntity
     * @param toukeiNinzuEntity2 ToukeiNinzuEntity
     * @param 統計人数Entityリスト List<ToukeiNinzuEntity>
     */
    public void setToukeiNinzuEntity(int index, ToukeiNinzuEntity toukeiNinzuEntity1,
            ToukeiNinzuEntity toukeiNinzuEntity2, List<ToukeiNinzuEntity> 統計人数Entityリスト) {

        toukeiNinzuEntity1.set自立人数(統計人数Entityリスト.get(index).get自立人数().add(toukeiNinzuEntity1.get自立人数()));
        toukeiNinzuEntity2.set自立人数(統計人数Entityリスト.get(index + 1).get自立人数().add(toukeiNinzuEntity2.get自立人数()));
        toukeiNinzuEntity1.set経過介護人数(統計人数Entityリスト.get(index).get経過介護人数().add(toukeiNinzuEntity1.get経過介護人数()));
        toukeiNinzuEntity2.set経過介護人数(統計人数Entityリスト.get(index + 1).get経過介護人数().add(toukeiNinzuEntity2.get経過介護人数()));
        toukeiNinzuEntity1.set要支援1人数(統計人数Entityリスト.get(index).get要支援1人数().add(toukeiNinzuEntity1.get要支援1人数()));
        toukeiNinzuEntity2.set要支援1人数(統計人数Entityリスト.get(index + 1).get要支援1人数().add(toukeiNinzuEntity2.get要支援1人数()));
        toukeiNinzuEntity1.set要支援2人数(統計人数Entityリスト.get(index).get要支援2人数().add(toukeiNinzuEntity1.get要支援2人数()));
        toukeiNinzuEntity2.set要支援2人数(統計人数Entityリスト.get(index + 1).get要支援2人数().add(toukeiNinzuEntity2.get要支援2人数()));
        toukeiNinzuEntity1.set要介護1人数(統計人数Entityリスト.get(index).get要介護1人数().add(toukeiNinzuEntity1.get要介護1人数()));
        toukeiNinzuEntity2.set要介護1人数(統計人数Entityリスト.get(index + 1).get要介護1人数().add(toukeiNinzuEntity2.get要介護1人数()));
        toukeiNinzuEntity1.set要介護2人数(統計人数Entityリスト.get(index).get要介護2人数().add(toukeiNinzuEntity1.get要介護2人数()));
        toukeiNinzuEntity2.set要介護2人数(統計人数Entityリスト.get(index + 1).get要介護2人数().add(toukeiNinzuEntity2.get要介護2人数()));
        toukeiNinzuEntity1.set要介護3人数(統計人数Entityリスト.get(index).get要介護3人数().add(toukeiNinzuEntity1.get要介護3人数()));
        toukeiNinzuEntity2.set要介護3人数(統計人数Entityリスト.get(index + 1).get要介護3人数().add(toukeiNinzuEntity2.get要介護3人数()));
        toukeiNinzuEntity1.set要介護4人数(統計人数Entityリスト.get(index).get要介護4人数().add(toukeiNinzuEntity1.get要介護4人数()));
        toukeiNinzuEntity2.set要介護4人数(統計人数Entityリスト.get(index + 1).get要介護4人数().add(toukeiNinzuEntity2.get要介護4人数()));
        toukeiNinzuEntity1.set要介護5人数(統計人数Entityリスト.get(index).get要介護5人数().add(toukeiNinzuEntity1.get要介護5人数()));
        toukeiNinzuEntity2.set要介護5人数(統計人数Entityリスト.get(index + 1).get要介護5人数().add(toukeiNinzuEntity2.get要介護5人数()));
        toukeiNinzuEntity1.set合計(統計人数Entityリスト.get(index).get合計().add(toukeiNinzuEntity1.get合計()));
        toukeiNinzuEntity2.set合計(統計人数Entityリスト.get(index + 1).get合計().add(toukeiNinzuEntity2.get合計()));
    }

}
