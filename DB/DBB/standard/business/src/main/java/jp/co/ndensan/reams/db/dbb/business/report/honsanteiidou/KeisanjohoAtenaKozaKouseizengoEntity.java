/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;

/**
 * 本算定異動（現年度）結果一覧表帳票の入力Entityです。
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeisanjohoAtenaKozaKouseizengoEntity {

    private KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;

}
