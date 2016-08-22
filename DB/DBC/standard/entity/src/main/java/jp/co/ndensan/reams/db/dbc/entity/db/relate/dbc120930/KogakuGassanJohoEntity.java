/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120930;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算情報のエンティティクラスです。
 *
 * @reamsid_L DBC-4840-040 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KogakuGassanJohoEntity extends DbTableEntityBase<KogakuGassanJohoEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    private int rirekiNo;
    private RString hokenSeidoCode3072;
    private RString jikoFutanSeiriNo3072;
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
    private Decimal over70_FutangakuGokei;
    private Decimal over70_ShikyugakuGokei;
    private Decimal under70_FutangakuGokei;
    private Decimal futangakuGokei;
    private Decimal under70_ShikyugakuGokei;
    private Decimal shikyugakuGokei;
    private RString dataKubun;
    private FlexibleYearMonth uketoriYM;
    private FlexibleYearMonth sofuYM;
    private RString hokenSeidoCode3073;
    private RString uchiwakeHokenshaNo;
    private RString kokuho_HihokenshaShoKigo;
    private RString hiHokenshaShoNo;
    private RString uchiwakeHokenshaMei;
    private RString jikoFutanSeiriNo3073;
    private RString taishoshaShimei;
    private RString over70_Futangaku;
    private RString over70_AmbunRitsu;
    private RString over70_Shikyugaku;
    private RString under70_Futangaku;
    private RString futangaku;
    private RString ambunRitsu;
    private RString under70_Shikyugaku;
    private RString shikyugaku;

}
