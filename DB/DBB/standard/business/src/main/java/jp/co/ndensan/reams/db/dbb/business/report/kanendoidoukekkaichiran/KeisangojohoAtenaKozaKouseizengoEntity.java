/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 計算後情報_宛名_口座_更正前後Entityです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeisangojohoAtenaKozaKouseizengoEntity {

    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座_更正前Entity KeisangojohoAtenaKozaEntity
     * @param 計算後情報_宛名_口座_更正後Entity KeisangojohoAtenaKozaEntity
     */
    public KeisangojohoAtenaKozaKouseizengoEntity(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity,
            KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity) {
        this.計算後情報_宛名_口座_更正前Entity = 計算後情報_宛名_口座_更正前Entity;
        this.計算後情報_宛名_口座_更正後Entity = 計算後情報_宛名_口座_更正後Entity;
    }

}
