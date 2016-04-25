/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 入力Entityです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoIdouKekkaIchiranInputEntity {

    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;
    private final HonSanteiIdoKanendoFukaBatchParameter バッチパラメータ;
    private final YMDHMS 調定日時;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座_更正前Entity KeisangojohoAtenaKozaEntity
     * @param 計算後情報_宛名_口座_更正後Entity KeisangojohoAtenaKozaEntity
     * @param バッチパラメータ HonSanteiIdoKanendoFukaBatchParameter
     * @param 調定日時 YMDHMS
     * @param association Association
     */
    public KanendoIdouKekkaIchiranInputEntity(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity,
            KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity,
            HonSanteiIdoKanendoFukaBatchParameter バッチパラメータ, YMDHMS 調定日時, Association association) {
        this.計算後情報_宛名_口座_更正前Entity = 計算後情報_宛名_口座_更正前Entity;
        this.計算後情報_宛名_口座_更正後Entity = 計算後情報_宛名_口座_更正後Entity;
        this.バッチパラメータ = バッチパラメータ;
        this.調定日時 = 調定日時;
        this.association = association;
    }

}
