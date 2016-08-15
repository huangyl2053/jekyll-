/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.temptable;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 取込データ一時テーブルEntityクラスです．
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiTempTableEntity extends DbTableEntityBase<TorikomiTempTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("TorikomiTempTable");

    @TempTableColumnOrder(1)
    private int dtno;
    @TempTableColumnOrder(2)
    private RString dtrekodoKubun;
    @TempTableColumnOrder(3)
    private RString dtshichosonCode;
    @TempTableColumnOrder(4)
    private RString dtDTnennkinnHokennshaCode;
    @TempTableColumnOrder(5)
    private RString dttsuuchiContentCode;
    @TempTableColumnOrder(6)
    private RString dtyobi1;
    @TempTableColumnOrder(7)
    private RString dtseidoCode;
    @TempTableColumnOrder(8)
    private FlexibleDate dtcreateYMD;
    @TempTableColumnOrder(9)
    private RString dtnennkinnNo;
    @TempTableColumnOrder(10)
    private RString dtnennkinnCode;
    @TempTableColumnOrder(11)
    private RString dtyobi2;
    @TempTableColumnOrder(12)
    private RString dtseinenngappi;
    @TempTableColumnOrder(13)
    private RString dtseibetsu;
    @TempTableColumnOrder(14)
    private RString dtkanaShimei;
    @TempTableColumnOrder(15)
    private RString dtshifutoCode1;
    @TempTableColumnOrder(16)
    private RString dtkanjiShimei;
    @TempTableColumnOrder(17)
    private RString dtshifutoCode2;
    @TempTableColumnOrder(18)
    private YubinNo dtYubinNo;
    @TempTableColumnOrder(19)
    private RString dtkanaJusyo;
    @TempTableColumnOrder(20)
    private RString dtshifutoCode3;
    @TempTableColumnOrder(21)
    private RString dtkanjiJusyo;
    @TempTableColumnOrder(22)
    private RString dtshifutoCode4;
    @TempTableColumnOrder(23)
    private FlexibleYear dtTaishoYear;
    @TempTableColumnOrder(24)
    private RString dtteiseiHyouji;
    @TempTableColumnOrder(25)
    private RString dtkakushuKubun;
    @TempTableColumnOrder(26)
    private RString dtshoriResult;
    @TempTableColumnOrder(27)
    private RString dtyobi3;
    @TempTableColumnOrder(28)
    private RString dtyobi4;
    @TempTableColumnOrder(29)
    private Decimal dtkinngaku1;
    @TempTableColumnOrder(30)
    private Decimal dtkinngakuYobi1;
    @TempTableColumnOrder(31)
    private Decimal dtkinngakuYobi2;
    @TempTableColumnOrder(32)
    private RString dtyobi5;
    @TempTableColumnOrder(33)
    private RString dtkyousaiNennkinnShoushoKigouNo;
}
