/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt22001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoTmpEntity;

/**
 * 処理ロジッククラスです。
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
public class HanyoListFukaDaichoProcessCore {

    private HanyoListFukaDaichoEntity 賦課台帳;

    /**
     * 値の設定です。
     *
     * @param before 前レコード
     * @param current currentレコード
     * @return HanyoListFukaDaichoEntity
     */
    public HanyoListFukaDaichoEntity keyBreakProcess(HanyoListFukaDaichoTmpEntity before,
            HanyoListFukaDaichoTmpEntity current) {
        if (賦課台帳 == null) {
            賦課台帳 = new HanyoListFukaDaichoEntity();
            賦課台帳.set介護賦課(before.get介護賦課());
            賦課台帳.get調定共通リスト().add(before.get調定共通());
            賦課台帳.get介護期別リスト().add(before.get介護期別());
            賦課台帳.set介護徴収方法(before.get介護徴収方法());
            賦課台帳.set受給者台帳Newest(before.get受給者台帳Newest());
            賦課台帳.set被保険者台帳管理Newest(before.get被保険者台帳管理Newest());
            賦課台帳.set宛名(before.get宛名());
            賦課台帳.set宛先(before.get宛先());
            賦課台帳.set特別徴収義務者コード(before.get特別徴収義務者コード());
            賦課台帳.set本算定後(before.is本算定後());
        }
        if (before.get介護賦課().getChoteiNendo().compareTo(current.get介護賦課().getChoteiNendo()) == 0
                && before.get介護賦課().getFukaNendo().compareTo(current.get介護賦課().getFukaNendo()) == 0
                && before.get介護賦課().getRirekiNo() == current.get介護賦課().getRirekiNo()
                && before.get介護賦課().getTsuchishoNo().equals(current.get介護賦課().getTsuchishoNo())) {
            賦課台帳.get調定共通リスト().add(current.get調定共通());
            賦課台帳.get介護期別リスト().add(current.get介護期別());
        } else {
            HanyoListFukaDaichoEntity tmpEntity = 賦課台帳;
            賦課台帳 = new HanyoListFukaDaichoEntity();
            賦課台帳.set介護賦課(current.get介護賦課());
            賦課台帳.get調定共通リスト().add(current.get調定共通());
            賦課台帳.get介護期別リスト().add(current.get介護期別());
            賦課台帳.set介護徴収方法(current.get介護徴収方法());
            賦課台帳.set受給者台帳Newest(current.get受給者台帳Newest());
            賦課台帳.set被保険者台帳管理Newest(current.get被保険者台帳管理Newest());
            賦課台帳.set宛名(current.get宛名());
            賦課台帳.set宛先(current.get宛先());
            賦課台帳.set特別徴収義務者コード(current.get特別徴収義務者コード());
            賦課台帳.set本算定後(current.is本算定後());
            return tmpEntity;
        }
        return null;
    }

    /**
     * データを取得します。
     *
     * @return HanyoListFukaDaichoEntity
     */
    public HanyoListFukaDaichoEntity getFinal賦課台帳() {
        return this.賦課台帳;
    }
}
