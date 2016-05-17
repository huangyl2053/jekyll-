/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.honsanteiidou;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogenendofuka.HonSanteiIdoGenendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 本算定異動（現年度）結果一覧表帳票の入力Entityです。
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GenendoIdouKekkaIchiranInputEntity {

    private final KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private final KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;
    private final HonSanteiIdoGenendoFukaBatchParameter バッチパラメータ;
    private final YMDHMS 調定日時;
    private final FlexibleYear 賦課年度;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座_更正前Entity KeisanjohoAtenaKozaEntity
     * @param 計算後情報_宛名_口座_更正後Entity KeisanjohoAtenaKozaEntity
     * @param バッチパラメータ HonSanteiIdoKanendoFukaBatchParameter
     * @param 賦課年度 FUKANENDO
     * @param 調定日時 YMDHMS
     * @param association Association
     */
    public GenendoIdouKekkaIchiranInputEntity(KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity,
            KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity,
            HonSanteiIdoGenendoFukaBatchParameter バッチパラメータ, YMDHMS 調定日時, FlexibleYear 賦課年度, Association association) {
        this.計算後情報_宛名_口座_更正前Entity = 計算後情報_宛名_口座_更正前Entity;
        this.計算後情報_宛名_口座_更正後Entity = 計算後情報_宛名_口座_更正後Entity;
        this.バッチパラメータ = バッチパラメータ;
        this.調定日時 = 調定日時;
        this.賦課年度 = 賦課年度;
        this.association = association;
    }
}
