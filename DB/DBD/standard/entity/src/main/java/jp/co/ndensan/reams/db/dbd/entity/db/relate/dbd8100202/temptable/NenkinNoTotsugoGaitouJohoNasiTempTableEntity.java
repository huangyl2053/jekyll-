/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 該当年金情報なし一時テーブルEntityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenkinNoTotsugoGaitouJohoNasiTempTableEntity extends DbTableEntityBase<NenkinNoTotsugoGaitouJohoNasiTempTableEntity>
        implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("NenkinNoTotsugoGaitouJohoNasiTempTable");

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
    private RString dtCreateYMD;
    @TempTableColumnOrder(8)
    private RString dtKisoNennkinnNo;
    @TempTableColumnOrder(9)
    private RString dtNennkinnCode;
    @TempTableColumnOrder(10)
    private RString dtYobi2;
    @TempTableColumnOrder(11)
    private RString dtSeinenngappi;
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
    private RString dtYubinNo;
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
    private RString dtkinngaku1;
    @TempTableColumnOrder(29)
    private RString dtKinngakuYobi1;
    @TempTableColumnOrder(30)
    private RString dtKinngakuYobi2;
    @TempTableColumnOrder(31)
    private RString dtYobi5;
    @TempTableColumnOrder(32)
    private RString dtKyousaiNennkinnShoushoKigouNo;
}
