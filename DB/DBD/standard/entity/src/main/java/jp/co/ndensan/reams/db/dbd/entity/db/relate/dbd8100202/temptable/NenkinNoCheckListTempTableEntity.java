/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 年金番号チェックリスト一時テーブルEntityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenkinNoCheckListTempTableEntity extends DbTableEntityBase<NenkinNoCheckListTempTableEntity> implements IDbAccessable {

    /**
     * 年金番号チェックリスト一時テーブルの名称.
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("NenkinNoCheckListTempTable");
    }

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private RString atenaKanaShimei;
    @TempTableColumnOrder(3)
    private RString atenaSeinenngappi;
    @TempTableColumnOrder(4)
    private RString atenaSeibetsu;
    @TempTableColumnOrder(5)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(6)
    private RString shotaiCode;
    @TempTableColumnOrder(7)
    private RString atenaKanjiShimei;
    @TempTableColumnOrder(8)
    private RString atenaYubinNo;
    @TempTableColumnOrder(9)
    private RString atenakanaJusyo;
    @TempTableColumnOrder(10)
    private FlexibleYear nendo;
    @TempTableColumnOrder(11)
    private RString shoriKubunn;
    @TempTableColumnOrder(12)
    private RString taishoMonth;
    @TempTableColumnOrder(13)
    private RString kisoNennkinnNo;
    @TempTableColumnOrder(14)
    private RString genKisoNennkinnNo;
    @TempTableColumnOrder(15)
    private RString nennkinnCode;
    @TempTableColumnOrder(16)
    private RString tourokuKubunn;
    @TempTableColumnOrder(17)
    private RString dtRekoDoKubunn;
    @TempTableColumnOrder(18)
    private RString dtShichosonCode;
    @TempTableColumnOrder(19)
    private RString dtNennkinnHokenshaCode;
    @TempTableColumnOrder(20)
    private RString dtTsuuchiContentCode;
    @TempTableColumnOrder(21)
    private RString dtYobi1;
    @TempTableColumnOrder(22)
    private RString dtSeidoCode;
    @TempTableColumnOrder(23)
    private RString dtCreateYMD;
    @TempTableColumnOrder(24)
    private RString dtKisoNennkinnNo;
    @TempTableColumnOrder(25)
    private RString dtNennkinnCode;
    @TempTableColumnOrder(26)
    private RString dtYobi2;
    @TempTableColumnOrder(27)
    private RString dtSeinenngappi;
    @TempTableColumnOrder(28)
    private RString dtSeibetsu;
    @TempTableColumnOrder(29)
    private RString dtKanaShimei;
    @TempTableColumnOrder(30)
    private RString dtShifutoCode1;
    @TempTableColumnOrder(31)
    private RString dtKanjiShimei;
    @TempTableColumnOrder(32)
    private RString dtShifutoCode2;
    @TempTableColumnOrder(33)
    private RString dtYubinNo;
    @TempTableColumnOrder(34)
    private RString dtKanajusyo;
    @TempTableColumnOrder(35)
    private RString dtShifutoCode3;
    @TempTableColumnOrder(36)
    private RString dtKanjijusyo;
    @TempTableColumnOrder(37)
    private RString dtShifutoCode4;
    @TempTableColumnOrder(38)
    private RString dtTaisyoYear;
    @TempTableColumnOrder(39)
    private RString dtTeiseiHyouji;
    @TempTableColumnOrder(40)
    private RString dtKakushuKubun;
    @TempTableColumnOrder(41)
    private RString dtShoriResult;
    @TempTableColumnOrder(42)
    private RString dtYobi3;
    @TempTableColumnOrder(43)
    private RString dtYobi4;
    @TempTableColumnOrder(44)
    private RString dtkinngaku1;
    @TempTableColumnOrder(45)
    private RString dtKinngakuYobi1;
    @TempTableColumnOrder(46)
    private RString dtKinngakuYobi2;
    @TempTableColumnOrder(47)
    private RString dtYobi5;
    @TempTableColumnOrder(48)
    private RString dtKyousaiNennkinnShoushoKigouNo;
}
