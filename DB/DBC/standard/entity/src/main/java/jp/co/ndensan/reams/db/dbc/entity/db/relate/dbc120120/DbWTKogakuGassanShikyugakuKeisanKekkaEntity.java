/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 高額合算支給額計算結果一時TBL項目定義クラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWTKogakuGassanShikyugakuKeisanKekkaEntity {

    @PrimaryKey
    private int renban;
    @PrimaryKey
    private HihokenshaNo hihokenshaNoIn;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private int rirekiNo;
    private RString hokenSeidoCode;
    private RString jikoFutanSeiriNo;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private Decimal setaiFutanSogaku;
    private Decimal setaiGassanGaku;
    private Decimal over70_SetaiGassanGaku;
    private RString shotokuKubun;
    private RString over70_ShotokuKubun;
    private Decimal santeiKijunGaku;
    private Decimal over70_SanteiKijyunGaku;
    private Decimal setaiShikyuSogaku;
    private Decimal over70_SetaiShikyuSogaku;
    private Decimal honninShikyugaku;
    private Decimal over70_honninShikyugaku;
    private RString teiShotoku_1_SaiKeisanUmu;
    private RString biko;
    private YubinNo kekkaRenrakusakiYubinNo;
    private RString kekkaRenrakusakiJusho;
    private RString ketteRenrakusakiMeisho1;
    private RString kekkaRenrakusakiMeisho2;
    private FlexibleDate tsuchiYMD;
    private AtenaMeisho renrakuhyoHakkoshaMei;
    private YubinNo renrakuhyoHakkoshaYubinNo;
    private RString renrakuhyoHakkoshaJusho;
    private YubinNo toiawasesakiYobinNo;
    private RString toiawasesakiJusho;
    private RString toiawasesakiMeisho1;
    private RString toiawasesakiMeisho2;
    private TelNo toiawasesakiTelNo;
    private Decimal over70_FutangakuGokei;
    private Decimal over70_ShikyugakuGokei;
    private Decimal under70_FutangakuGokei;
    private Decimal futangakuGokei;
    private Decimal under70_ShikyugakuGokei;
    private Decimal shikyugakuGokei;
    private RString dataKubun;
    private FlexibleYearMonth uketoriYM;
    private FlexibleYearMonth sofuYM;
    private RString saisoFG;
    private FlexibleDate sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;
    private boolean kakuninListFlag;
    private int rirekiNoMax;
    private RString dbt3072DataKubun;
    private RString dbt3072SaisoFG;
    private FlexibleYearMonth dbt3072SofuYM;

}
