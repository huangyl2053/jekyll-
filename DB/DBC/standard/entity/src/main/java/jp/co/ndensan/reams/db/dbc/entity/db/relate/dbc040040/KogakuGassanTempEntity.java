/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 出力対象データのエンティティクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanTempEntity extends DbTableEntityBase<KogakuGassanTempEntity>
        implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo hokenshaNo;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private RString shinseiJokyoKubun;
    private FlexibleDate shinseiYMD;
    private RString shikyuShinseishoSeiriNo;
    private RString kokuhoShikyuShinseishoSeiriNo;
    private RString shikyuShinseiKubun;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private RString shikyuShinseiKeitai;
    private RString jikoFutanKofuUmu;
    private AtenaMeisho shinseiDaihyoshaShimei;
    private YubinNo shinseiDaihyoshaYubinNo;
    private RString shinseiDaihyoshaJusho;
    private TelNo shinseiDaihyoshaTelNo;
    private RString shotokuKubun;
    private RString over70_ShotokuKubun;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString shikakuSoshitsuJiyu;
    private FlexibleDate kanyuKaishiYMD;
    private FlexibleDate kanyuShuryoYMD;
    private RString kokuho_HokenshaNo;
    private RString kokuho_HokenshaMeisho;
    private RString kokuho_HihokenshaShoKigo;
    private RString kokuho_HihokenshaShoNo;
    private RString kokuho_SetaiNo;
    private RString kokuho_Zokugara;
    private FlexibleDate kokuho_KanyuKaishiYMD;
    private FlexibleDate kokuho_KanyuShuryoYMD;
    private RString koki_HokenshaNo;
    private RString koki_KoikiRengoMeisho;
    private RString koki_HihokenshaNo;
    private FlexibleDate koki_KanyuKaishiYMD;
    private FlexibleDate koki_KanyuShuryoYMD;
    private RString shiharaiHohoKubun;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private long kozaID;
    private RString biko;
    private FlexibleYearMonth shikyuShinseisho_SofuYM;
    private RString saiSofuFlag;
    private FlexibleYearMonth jikoFutan_KeisanYM;
    private RString saiKeisanKubun;

    private int jikoFutanGaku_RirekiNo;
    private RString jikoFutanGaku_HokenSeidoCode;
    private RString jikoFutanGaku_HokenshaMei;
    private RString jikoFutanGaku_Kokuho_HihokenshaShoKigo;
    private AtenaKanaMeisho jikoFutanGaku_HihokenshaShimeiKana;
    private AtenaMeisho jikoFutanGaku_HihokenshaShimei;
    private FlexibleDate jikoFutanGaku_UmareYMD;
    private Code jikoFutanGaku_SeibetsuCode;
    private RString jikoFutanGaku_ShotokuKubun;
    private RString jikoFutanGaku_Over70_ShotokuKubun;
    private RString jikoFutanGaku_JikoFutanSeiriNo;
    private RString jikoFutanGaku_Koki_HokenshaNo;
    private RString jikoFutanGaku_Koki_HihokenshaNo;
    private RString jikoFutanGaku_Kokuho_HokenshaNo;
    private RString jikoFutanGaku_Kokuho_HihokenshaShoNo;
    private RString jikoFutanGaku_Kokuho_KojinNo;
    private RString jikoFutanGaku_IdoKubun;
    private RString jikoFutanGaku_HoseiZumiSofuKubun;
    private FlexibleDate jikoFutanGaku_TaishoKeisanKaishiYMD;
    private FlexibleDate jikoFutanGaku_TaishoKeisanShuryoYMD;
    private FlexibleDate jikoFutanGaku_HihokenshaKaishiYMD;
    private FlexibleDate jikoFutanGaku_HihokenshaShuryoYMD;
    private FlexibleDate jikoFutanGaku_ShinseiYMD;
    private Decimal jikoFutanGaku_Gokei_JikoFutanGaku;
    private Decimal jikoFutanGaku_Gokei_70_74JikoFutanGaku;
    private Decimal jikoFutanGaku_Gokei_Under70KogakuShikyuGaku;
    private Decimal jikoFutanGaku_Gokei_70_74KogakuShikyuGaku;
    private Decimal jikoFutanGaku_Sumi_Gokei_JikoFutanGaku;
    private Decimal jikoFutanGaku_Sumi_Gokei_70_74JikoFutanGaku;
    private Decimal jikoFutanGaku_Sumi_Gokei_Under70KogakuShikyuGaku;
    private Decimal jikoFutanGaku_Sumi_Gokei_70_74KogakuShikyuGaku;
    private AtenaMeisho jikoFutanGaku_AtesakiShimei;
    private YubinNo jikoFutanGaku_AtesakiYubinNo;
    private RString jikoFutanGaku_AtesakiJusho;
    private RString jikoFutanGaku_Madoguchi_TaishoshaHanteiCode;
    private RString jikoFutanGaku_ShiharaiBasho;
    private FlexibleDate jikoFutanGaku_ShikaraiKaishiYMD;
    private FlexibleDate jikoFutanGaku_ShiharaiShuryoYMD;
    private RString jikoFutanGaku_HeichoNaiyo;
    private RString jikoFutanGaku_ShiharaiKaishiTime;
    private RString jikoFutanGaku_ShiharaiShuryoTime;
    private RString jikoFutanGaku_Biko;
    private RString jikoFutanGaku_DataSakuseiKubun;
    private FlexibleYearMonth jikoFutanGaku_Kakunin_UketoriYM;
    private FlexibleYearMonth jikoFutanGaku_HoseiZumi_SofuYM;
    private FlexibleYearMonth jikoFutanGaku_Shomeisho_UketoriYM;
    private RString jikoFutanGaku_SaisoFlag;
    private RString jikoFutanGaku_SofuTaishoGaiFlag;
    private FlexibleDate jikoFutanGaku_JikoFutanKeisanYMD;
    private FlexibleDate jikoFutanGaku_ShomeiShoSakuseiYMD;
    private RString jikoFutanGaku_Koki_KokuhoShoriKubun;

    private AtenaKanaMeisho atena_HihokenshaKanaShimei;
    private AtenaMeisho atena_HihokenshaShimei;
    private FlexibleDate atena_SeinengappiYMD;
    private RString atena_Seibetsu;
    private ShikibetsuCode shikibetsuCode;
}
