/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 平均利用額統計表作成 給付実績データ一時テーブルtempEntity。
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class KyufujissekiTempTblEntity extends DbTableEntityBase<KyufujissekiTempTblEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString hiHokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(3)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(4)
    private FlexibleDate umareYMD;
    @TempTableColumnOrder(5)
    private RString serviceSyuruiCode;
    @TempTableColumnOrder(6)
    private RString serviceKomokuCode;
    @TempTableColumnOrder(7)
    private RString hokenSeikyuKingaku;
    @TempTableColumnOrder(8)
    private RString hokenRiyoshaFutangaku;
    @TempTableColumnOrder(9)
    private RString hokenTanisu;
    @TempTableColumnOrder(10)
    private RString hokenTanisuTani;
    @TempTableColumnOrder(11)
    private RString hokenDekidakaTanisu;
    @TempTableColumnOrder(12)
    private RString hiyosogaku;
    @TempTableColumnOrder(13)
    private RString shotoku;
    @TempTableColumnOrder(14)
    private RString serviceBunrui;
    @TempTableColumnOrder(15)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(16)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(17)
    private RString taishofukaNendo;
}
