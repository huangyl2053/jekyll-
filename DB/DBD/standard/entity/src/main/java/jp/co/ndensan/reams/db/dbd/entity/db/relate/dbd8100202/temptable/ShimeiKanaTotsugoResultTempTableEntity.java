/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * 氏名カナ突合結果一時テーブルEntityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShimeiKanaTotsugoResultTempTableEntity extends DbTableEntityBase<ShimeiKanaTotsugoResultTempTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("ShimeiKanaTotsugoResultTempTable");

    @TempTableColumnOrder(1)
    private RString dtRekoDoKubunn;
    @TempTableColumnOrder(2)
    private RString dtShichosonCode;
    @TempTableColumnOrder(3)
    private RString dtNennkinnHokenshaCode;
    @TempTableColumnOrder(4)
    private RString dtTsuuchiContentCode;
    @TempTableColumnOrder(5)
    private RString dtYobi1;
    @TempTableColumnOrder(6)
    private RString dtSeidoCode;
    @TempTableColumnOrder(7)
    private FlexibleYear dtCreateYMD;
    @TempTableColumnOrder(8)
    private RString dtKisoNennkinnNo;
    @TempTableColumnOrder(9)
    private RString dtNennkinnCode;
    @TempTableColumnOrder(10)
    private RString dtYobi2;
    @TempTableColumnOrder(11)
    private FlexibleDate dtSeinenngappi;
    @TempTableColumnOrder(12)
    private RString dtSeibetsu;
    @TempTableColumnOrder(13)
    private RString dtKanaShimei;
    @TempTableColumnOrder(14)
    private RString dtShifutoCode1;
    @TempTableColumnOrder(15)
    private RString dtKanjiShimei;
    @TempTableColumnOrder(16)
    private RString dtShifutoCode2;
    @TempTableColumnOrder(17)
    private YubinNo dtYubinNo;
    @TempTableColumnOrder(18)
    private RString dtKanajusyo;
    @TempTableColumnOrder(19)
    private RString dtShifutoCode3;
    @TempTableColumnOrder(20)
    private RString dtKanjijusyo;
    @TempTableColumnOrder(21)
    private RString dtShifutoCode4;
    @TempTableColumnOrder(22)
    private RString dtTaisyoYear;
    @TempTableColumnOrder(23)
    private RString dtTeiseiHyouji;
    @TempTableColumnOrder(24)
    private RString dtKakushuKubun;
    @TempTableColumnOrder(25)
    private RString dtShoriResult;
    @TempTableColumnOrder(26)
    private RString dtYobi3;
    @TempTableColumnOrder(27)
    private RString dtYobi4;
    @TempTableColumnOrder(28)
    private Decimal dtkinngaku1;
    @TempTableColumnOrder(29)
    private Decimal dtKinngakuYobi1;
    @TempTableColumnOrder(30)
    private Decimal dtKinngakuYobi2;
    @TempTableColumnOrder(31)
    private RString dtYobi5;
    @TempTableColumnOrder(32)
    private RString dtKyousaiNennkinnShoushoKigouNo;
    @TempTableColumnOrder(33)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(34)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(35)
    private RString shotaiCode;
    @TempTableColumnOrder(36)
    private RString atenaKanaShimei;
    @TempTableColumnOrder(37)
    private FlexibleDate atenaSeinenngappi;
    @TempTableColumnOrder(38)
    private RString atenaSeibetsu;
}
