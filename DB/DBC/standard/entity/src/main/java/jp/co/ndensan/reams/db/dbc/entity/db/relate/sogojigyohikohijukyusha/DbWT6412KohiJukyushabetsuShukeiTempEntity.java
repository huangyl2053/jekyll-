/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikohijukyusha;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 公費受給者別集計一時TBLEntity項目定義クラスです。
 *
 * @reamsid_L DBC-4710-030 chenjie
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT6412KohiJukyushabetsuShukeiTempEntity extends
        DbTableEntityBase<DbWT6412KohiJukyushabetsuShukeiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int sRirekiNo;
    @TempTableColumnOrder(2)
    private RString kohiFutanshaNo;
    @TempTableColumnOrder(3)
    private RString kohiFutanshaName;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(5)
    private RString kokuhorenName;
    @TempTableColumnOrder(6)
    private RString kohiTaishoTanisuShukei;
    @TempTableColumnOrder(7)
    private RString kohiFutanKingakuShukei;
    @TempTableColumnOrder(8)
    private RString kohibunHonninFutangakuShukei;

}
