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
 * 公費受給者別明細一時TBLEntity項目定義クラスです。
 *
 * @reamsid_L DBC-4710-030 chenjie
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT6411KohiJukyushabetsuMeisaiTempEntity extends
        DbTableEntityBase<DbWT6411KohiJukyushabetsuMeisaiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int mRenban;
    @TempTableColumnOrder(2)
    private int mRirekiNo;
    @TempTableColumnOrder(3)
    private RString kohiJukyushaNo;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(5)
    private RString jigyoshoNo;
    @TempTableColumnOrder(6)
    private RString jigyoshoName;
    @TempTableColumnOrder(7)
    private RString serviceCode;
    @TempTableColumnOrder(8)
    private RString serviceShuruiMei;
    @TempTableColumnOrder(9)
    private RString serviceKomokuMei;
    @TempTableColumnOrder(10)
    private RString nissuKaisu;
    @TempTableColumnOrder(11)
    private RString kohiTaishoTanisu;
    @TempTableColumnOrder(12)
    private RString kohiFutanKingaku;
    @TempTableColumnOrder(13)
    private RString kohibunHonninFutangaku;
}
