/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    private final RString 出力順ID;
    private final YMDHMS 調定日時;
    private final Association association;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;

    /**
     * コンストラクタです。
     *
     * @param 計算後情報_宛名_口座_更正前Entity KeisangojohoAtenaKozaEntity
     * @param 計算後情報_宛名_口座_更正後Entity KeisangojohoAtenaKozaEntity
     * @param 出力順ID RString
     * @param 調定日時 YMDHMS
     * @param association Association
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     */
    public KanendoIdouKekkaIchiranInputEntity(KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity,
            KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity,
            RString 出力順ID, YMDHMS 調定日時, Association association,
            RString 並び順の１件目, RString 並び順の２件目,
            RString 並び順の３件目, RString 並び順の４件目, RString 並び順の５件目, List<RString> 改頁項目List) {
        this.計算後情報_宛名_口座_更正前Entity = 計算後情報_宛名_口座_更正前Entity;
        this.計算後情報_宛名_口座_更正後Entity = 計算後情報_宛名_口座_更正後Entity;
        this.出力順ID = 出力順ID;
        this.調定日時 = 調定日時;
        this.association = association;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
    }

}
