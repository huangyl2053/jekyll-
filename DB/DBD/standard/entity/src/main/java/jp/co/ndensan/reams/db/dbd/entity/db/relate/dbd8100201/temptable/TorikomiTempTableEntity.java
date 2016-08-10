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

    private int dtno;
    private RString dtshichosonCode;
    private RString dtDTnennkinnHokennshaCode;
    private RString dttsuuchiContentCode;
    private RString dtyobi1;
    private RString dtseidoCode;
    private FlexibleDate dtcreateYMD;
    private RString dtnennkinnNo;
    private RString dtnennkinnCode;
    private RString dtyobi2;
    private RString dtseinenngappi;
    private RString dtseibetsu;
    private RString dtkanaShimei;
    private RString dtshifutoCode1;
    private RString dtkanjiShimei;
    private RString dtshifutoCode2;
    private YubinNo dtYubinNo;
    private RString dtkanaJusyo;
    private RString dtshifutoCode3;
    private RString dtkanjiJusyo;
    private RString dtshifutoCode4;
    private FlexibleYear dtTaishoYear;
    private RString dtteiseiHyouji;
    private RString dtkakushuKubun;
    private RString dtshoriResult;
    private RString dtyobi3;
    private RString dtyobi4;
    private Decimal dtkinngaku1;
    private RString dtkinngakuYobi1;
    private RString dtkinngakuYobi2;
    private RString dtyobi5;
    private RString dtkyousaiNennkinnShoushoKigouNo;

}
