/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.genendoidoukekkaichiran.KeisanjohoAtenaKozaEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final YMDHMS 調定日時;
    private final FlexibleYear 賦課年度;
    private final Association association;
    private final RString 住所編集;

    /**
     *
     * @param 計算後情報_宛名_口座_更正前Entity KeisanjohoAtenaKozaEntity
     * @param 計算後情報_宛名_口座_更正後Entity KeisanjohoAtenaKozaEntity
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FUKANENDO
     * @param association Association
     * @param 住所編集 RString
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     */
    public GenendoIdouKekkaIchiranInputEntity(KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity,
            KeisanjohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity,
            YMDHMS 調定日時, FlexibleYear 賦課年度, Association association, RString 住所編集,
            RString 並び順の１件目, RString 並び順の２件目,
            RString 並び順の３件目, RString 並び順の４件目, RString 並び順の５件目) {
        this.計算後情報_宛名_口座_更正前Entity = 計算後情報_宛名_口座_更正前Entity;
        this.計算後情報_宛名_口座_更正後Entity = 計算後情報_宛名_口座_更正後Entity;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.調定日時 = 調定日時;
        this.賦課年度 = 賦課年度;
        this.association = association;
        this.住所編集 = 住所編集;
    }
}
