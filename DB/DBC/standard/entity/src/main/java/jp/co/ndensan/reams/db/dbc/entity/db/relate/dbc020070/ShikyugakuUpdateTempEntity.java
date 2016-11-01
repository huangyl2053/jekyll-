/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * 更新用一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShikyugakuUpdateTempEntity extends DbTableEntityBase<ShikyugakuUpdateTempEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private RString kubun;
    private RString meisaiNo;
    private HihokenshaNo meisaiHihokenshaNo;

    private HihokenshaNo shikyugaku_hihokenshaNo;
    private FlexibleYear shikyugaku_taishoNendo;
    private HokenshaNo shikyugaku_shoKisaiHokenshaNo;
    private RString shikyugaku_shikyuShinseishoSeiriNo;
    private int shikyugaku_rirekiNo;
    private RString shikyugaku_hokenSeidoCode;
    private RString shikyugaku_jikoFutanSeiriNo;
    private FlexibleDate shikyugaku_taishoKeisanKaishiYMD;
    private FlexibleDate shikyugaku_taishoKeisanShuryoYMD;
    private Decimal shikyugaku_setaiFutanSogaku;
    private Decimal shikyugaku_setaiGassanGaku;
    private Decimal shikyugaku_over70_SetaiGassanGaku;
    private RString shikyugaku_shotokuKubun;
    private RString shikyugaku_over70_ShotokuKubun;
    private Decimal shikyugaku_santeiKijunGaku;
    private Decimal shikyugaku_over70_SanteiKijyunGaku;
    private Decimal shikyugaku_setaiShikyuSogaku;
    private Decimal shikyugaku_over70_SetaiShikyuSogaku;
    private Decimal shikyugaku_honninShikyugaku;
    private Decimal shikyugaku_over70_honninShikyugaku;
    private RString shikyugaku_teiShotoku_1_SaiKeisanUmu;
    private RString shikyugaku_biko;
    private YubinNo shikyugaku_kekkaRenrakusakiYubinNo;
    private RString shikyugaku_kekkaRenrakusakiJusho;
    private RString shikyugaku_kettaRenrakusakiMeisho1;
    private RString shikyugaku_kekkaRenrakusakiMeisho2;
    private FlexibleDate shikyugaku_tsuchiYMD;
    private AtenaMeisho shikyugaku_renrakuhyoHakkoshaMei;
    private YubinNo shikyugaku_renrakuhyoHakkoshaYubinNo;
    private RString shikyugaku_renrakuhyoHakkoshaJusho;
    private YubinNo shikyugaku_toiawasesakiYobinNo;
    private RString shikyugaku_toiawasesakiJusho;
    private RString shikyugaku_toiawasesakiMeisho1;
    private RString shikyugaku_toiawasesakiMeisho2;
    private TelNo shikyugaku_toiawasesakiTelNo;
    private Decimal shikyugaku_over70_FutangakuGokei;
    private Decimal shikyugaku_over70_ShikyugakuGokei;
    private Decimal shikyugaku_under70_FutangakuGokei;
    private Decimal shikyugaku_futangakuGokei;
    private Decimal shikyugaku_under70_ShikyugakuGokei;
    private Decimal shikyugaku_shikyugakuGokei;
    private RString shikyugaku_dataKubun;
    private FlexibleYearMonth shikyugaku_uketoriYM;
    private FlexibleYearMonth shikyugaku_sofuYM;
    private RString shikyugaku_saisoFG;
    private FlexibleDate shikyugaku_sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;

    private HihokenshaNo shikyugakuMeisai_hihokenshaNo;
    private FlexibleYear shikyugakuMeisai_taishoNendo;
    private HokenshaNo shikyugakuMeisai_shoKisaiHokenshaNo;
    private RString shikyugakuMeisai_shikyuShinseishoSeiriNo;
    private RString shikyugakuMeisai_meisanNo;
    private int shikyugakuMeisai_rirekiNo;
    private RString shikyugakuMeisai_hokenSeidoCode;
    private RString shikyugakuMeisai_uchiwakeHokenshaNo;
    private RString shikyugakuMeisai_kokuho_HihokenshaShoKigo;
    private RString shikyugakuMeisai_hiHokenshaShoNo;
    private RString shikyugakuMeisai_uchiwakeHokenshaMei;
    private RString shikyugakuMeisai_jikoFutanSeiriNo;
    private RString shikyugakuMeisai_taishoshaShimei;
    private RString shikyugakuMeisai_over70_Futangaku;
    private RString shikyugakuMeisai_over70_AmbunRitsu;
    private RString shikyugakuMeisai_over70_Shikyugaku;
    private RString shikyugakuMeisai_under70_Futangaku;
    private RString shikyugakuMeisai_futangaku;
    private RString shikyugakuMeisai_ambunRitsu;
    private RString shikyugakuMeisai_under70_Shikyugaku;
    private RString shikyugakuMeisai_shikyugaku;
    private RString shikyugakuMeisai_over70_Biko;
    private RString shikyugakuMeisai_under70_Biko;
    private RString shikyugakuMeisai_dataKubun;
    private FlexibleYearMonth shikyugakuMeisai_uketoriYM;
    private FlexibleYearMonth shikyugakuMeisai_sofuYM;

    private HihokenshaNo kettei_hihokenshaNo;
    private FlexibleYear kettei_taishoNendo;
    private HokenshaNo kettei_hokenshaNo;
    private RString kettei_shikyuShinseishoSeiriNo;
    private int kettei_rirekiNo;
    private RString kettei_jikoFutanSeiriNo;
    private RString kettei_hokenSeidoCode;
    private RString kettei_kokuho_HihokenshaShoKigo;
    private FlexibleDate kettei_taishoKeisanKaishiYMD;
    private FlexibleDate kettei_taishoKeisanShuryoYMD;
    private FlexibleDate kettei_shinseiYMD;
    private FlexibleDate kettei_ketteiYMD;
    private Decimal kettei_jikoFutanSogaku;
    private RString kettei_shikyuKubun;
    private Decimal kettei_shikyugaku;
    private RString kettei_kyufuShurui;
    private RString kettei_fushikyuRiyu;
    private RString kettei_biko;
    private RString kettei_shiharaiHohoKubun;
    private RString kettei_shiharaiBasho;
    private FlexibleDate kettei_shiharaikikanKaishiYMD;
    private FlexibleDate kettei_shiharaikikanShuryoYMD;
    private RString kettei_heichoNaiyo;
    private RString kettei_shiharaikikanKaishiTime;
    private RString kettei_shiharaikikanShuryoTime;
    private FlexibleDate kettei_ketteiTsuchishoSakuseiYMD;
    private FlexibleDate kettei_hurikomiTsuchishoSakuseiYMD;
    private FlexibleYearMonth kettei_uketoriYM;
    private long kettei_kozaID;
    private RString kettei_dataSakuseiKubun;
    private YubinNo yubinNo;
    private ShikibetsuCode shikibetsuCode;
    private RString jushoCode;
    private RString gyoseiCode;
    private AtenaKanaMeisho atenaKanaShimei;
    private AtenaMeisho atenaShimei;
    private FlexibleDate seinengappiYMD;
    private LasdecCode shichosonCode;
    private RString saiShikyuKubun;
    private RString madoguchiKubun;
    private KinyuKikanCode kinyukikanCode;
    private RString kinyukikanMei;
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    private RString kinyuKikanShitenMei;
    private RString kozaShumoku;
    private RString kozaShumokuMei;
    private RString kozaNo;
    private AtenaKanaMeisho kozaMeiginin;
}
