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
import lombok.Getter;
import lombok.Setter;

/**
 * 実績データ一時テーブルEntityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JissekiDataIchijiSakuseiTempTableEntity extends DbTableEntityBase<JissekiDataIchijiSakuseiTempTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("JissekiDataIchijiSakuseiTempTable");

    private HihokenshaNo hihokenshaNo;
    private RString atenaKanaShimei;
    private FlexibleDate atenaSeinenngappi;
    private RString atenaSeibetsu;
    private ShikibetsuCode shikibetsuCode;
    private RString shotaiCode;
    private RString atenaKanjiShimei;
    private RString atenaYubinNo;
    private RString atenakanaJusyo;
    private RString nendo;
    private RString shoriKubunn;
    private RString TaishoMonth;
    private RString kisoNennkinnNo;
    private RString genKisoNennkinnNo;
    private RString nennkinnCode;
    private RString tourokuKubunn;
    private RString dtRekoDoKubunn;
    private RString dtShichosonCode;
    private RString dtNennkinnHokenshaCode;
    private RString dtTsuuchiContentCode;
    private RString dtYobi1;
    private RString dtSeidoCode;
    private FlexibleYear dtCreateYMD;
    private RString dtKisoNennkinnNo;
    private RString dtNennkinnCode;
    private RString dtYobi2;
    private FlexibleDate dtSeinenngappi;
    private RString dtSeibetsu;
    private RString dtKanaShimei;
    private RString dtShifutoCode1;
    private RString dtKanjiShimei;
    private RString dtShifutoCode2;
    private YubinNo dtYubinNo;
    private RString dtKanajusyo;
    private RString dtShifutoCode3;
    private RString dtKanjijusyo;
    private RString dtShifutoCode4;
    private RString dtTaisyoYear;
    private RString dtTeiseiHyouji;
    private RString dtKakushuKubun;
    private RString dtShoriResult;
    private RString dtYobi3;
    private RString dtYobi4;
    private Decimal dtkinngaku1;
    private Decimal dtKinngakuYobi1;
    private Decimal dtKinngakuYobi2;
    private RString dtYobi5;
    private RString dtKyousaiNennkinnShoushoKigouNo;
}
