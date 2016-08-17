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
 * 非課税年金対象者同定結果情報一時テーブルクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity extends DbTableEntityBase<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity>
        implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("HikazeNenkinTaishoshaDouteiResultJohoTempTable");

    @TempTableColumnOrder(1)
    private RString douteiResultKubun;
    @TempTableColumnOrder(2)
    private RString fuicchiJiyu;
    @TempTableColumnOrder(3)
    private RString gaitouJiyu;
    @TempTableColumnOrder(4)
    private RString fuicchiItem;
    @TempTableColumnOrder(5)
    private RString kisoNennkinnNoHennkou;
    @TempTableColumnOrder(6)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(7)
    private RString atenaKanaShimei;
    @TempTableColumnOrder(8)
    private RString atenaSeinenngappi;
    @TempTableColumnOrder(9)
    private RString atenaSeibetsu;
    @TempTableColumnOrder(10)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(11)
    private RString shotaiCode;
    @TempTableColumnOrder(12)
    private FlexibleYear nendo;
    @TempTableColumnOrder(13)
    private RString shoriKubunn;
    @TempTableColumnOrder(14)
    private RString taishoMonth;
    @TempTableColumnOrder(15)
    private RString kisoNennkinnNo;
    @TempTableColumnOrder(16)
    private RString genKisoNennkinnNo;
    @TempTableColumnOrder(17)
    private RString nennkinnCode;
    @TempTableColumnOrder(18)
    private RString tourokuKubunn;
    @TempTableColumnOrder(19)
    private RString dtRekoDoKubunn;
    @TempTableColumnOrder(20)
    private RString dtShichosonCode;
    @TempTableColumnOrder(21)
    private RString dtNennkinnHokenshaCode;
    @TempTableColumnOrder(22)
    private RString dtTsuuchiContentCode;
    @TempTableColumnOrder(23)
    private RString dtYobi1;
    @TempTableColumnOrder(24)
    private RString dtSeidoCode;
    @TempTableColumnOrder(25)
    private RString dtCreateYMD;
    @TempTableColumnOrder(26)
    private RString dtKisoNennkinnNo;
    @TempTableColumnOrder(27)
    private RString dtNennkinnCode;
    @TempTableColumnOrder(28)
    private RString dtYobi2;
    @TempTableColumnOrder(29)
    private RString dtSeinenngappi;
    @TempTableColumnOrder(30)
    private RString dtSeibetsu;
    @TempTableColumnOrder(31)
    private RString dtKanaShimei;
    @TempTableColumnOrder(32)
    private RString dtShifutoCode1;
    @TempTableColumnOrder(33)
    private RString dtKanjiShimei;
    @TempTableColumnOrder(34)
    private RString dtShifutoCode2;
    @TempTableColumnOrder(35)
    private RString dtYubinNo;
    @TempTableColumnOrder(36)
    private RString dtKanajusyo;
    @TempTableColumnOrder(37)
    private RString dtShifutoCode3;
    @TempTableColumnOrder(38)
    private RString dtKanjijusyo;
    @TempTableColumnOrder(39)
    private RString dtShifutoCode4;
    @TempTableColumnOrder(40)
    private RString dtTaisyoYear;
    @TempTableColumnOrder(41)
    private RString dtTeiseiHyouji;
    @TempTableColumnOrder(42)
    private RString dtKakushuKubun;
    @TempTableColumnOrder(43)
    private RString dtShoriResult;
    @TempTableColumnOrder(44)
    private RString dtYobi3;
    @TempTableColumnOrder(45)
    private RString dtYobi4;
    @TempTableColumnOrder(46)
    private RString dtkinngaku1;
    @TempTableColumnOrder(47)
    private RString dtKinngakuYobi1;
    @TempTableColumnOrder(48)
    private RString dtKinngakuYobi2;
    @TempTableColumnOrder(49)
    private RString dtYobi5;
    @TempTableColumnOrder(50)
    private RString dtKyousaiNennkinnShoushoKigouNo;
}
