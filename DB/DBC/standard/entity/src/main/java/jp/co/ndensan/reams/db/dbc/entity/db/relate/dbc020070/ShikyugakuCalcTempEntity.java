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
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * 支給額計算一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShikyugakuCalcTempEntity extends DbTableEntityBase<ShikyugakuCalcTempEntity> implements IDbAccessable {

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
    @PrimaryKey
    private RString meisaiNo;
    @PrimaryKey
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

    private HihokenshaNo zenFutangaku_hihokenshaNo;
    private FlexibleYear zenFutangaku_taishoNendo;
    private HokenshaNo zenFutangaku_shokisaiHokenshaNo;
    private RString zenFutangaku_shikyuShinseishoSeiriNo;
    private HokenshaNo zenFutangaku_tennyumaeHokenshaNo;
    private int zenFutangaku_rirekiNo;
    private RString zenFutangaku_jikoFutanSeiriNo;
    private RString zenFutangaku_tennyumaeHokenshaMei;
    private FlexibleDate zenFutangaku_taishoKeisanKaishiYMD;
    private FlexibleDate zenFutangaku_taishoKeisanShuryoYMD;
    private FlexibleDate zenFutangaku_hihokenshaKaishiYMD;
    private FlexibleDate zenFutangaku_hihokenshaShuryoYMD;
    private FlexibleDate zenFutangaku_hakkoDate;
    private Decimal zenFutangaku_gokei_JikoFutanGaku;
    private Decimal zenFutangaku_gokei_70_74JikoFutanGaku;
    private Decimal zenFutangaku_gokei_Under70KogakuShikyuGaku;
    private Decimal zenFutangaku_gokei_70_74KogakuShikyuGaku;
    private YubinNo zenFutangaku_atesakiYubinNo;
    private RString zenFutangaku_atesakiShimei;
    private RString zenFutangaku_atesakiJusho;
    private RString zenFutangaku_madoguchi_TaishoshaHanteiCode;
    private RString zenFutangaku_biko;
    private FlexibleDate zenFutangaku_uketsukeDate;
    private FlexibleDate zenFutangaku_shikyugakuKeisanDate;

    private HihokenshaNo futangaku_hihokenshaNo;
    private FlexibleYear futangaku_taishoNendo;
    private HokenshaNo futangaku_hokenshaNo;
    private RString futangaku_shikyuShinseishoSeiriNo;
    private int futangaku_rirekiNo;
    private RString futangaku_hokenSeidoCode;
    private RString futangaku_hokenshaMei;
    private RString futangaku_kokuho_HihokenshaShoKigo;
    private AtenaKanaMeisho futangaku_hihokenshaShimeiKana;
    private AtenaMeisho futangaku_hihokenshaShimei;
    private FlexibleDate futangaku_umareYMD;
    private Code futangaku_seibetsuCode;
    private RString futangaku_shotokuKubun;
    private RString futangaku_over70_ShotokuKubun;
    private RString futangaku_jikoFutanSeiriNo;
    private RString futangaku_koki_HokenshaNo;
    private RString futangaku_koki_HihokenshaNo;
    private RString futangaku_kokuho_HokenshaNo;
    private RString futangaku_kokuho_HihokenshaShoNo;
    private RString futangaku_kokuho_KojinNo;
    private RString futangaku_idoKubun;
    private RString futangaku_hoseiZumiSofuKubun;
    private FlexibleDate futangaku_taishoKeisanKaishiYMD;
    private FlexibleDate futangaku_taishoKeisanShuryoYMD;
    private FlexibleDate futangaku_hihokenshaKaishiYMD;
    private FlexibleDate futangaku_hihokenshaShuryoYMD;
    private FlexibleDate futangaku_shinseiYMD;
    private Decimal futangaku_gokei_JikoFutanGaku;
    private Decimal futangaku_gokei_70_74JikoFutanGaku;
    private Decimal futangaku_gokei_Under70KogakuShikyuGaku;
    private Decimal futangaku_gokei_70_74KogakuShikyuGaku;
    private Decimal futangaku_sumi_Gokei_JikoFutanGaku;
    private Decimal futangaku_sumi_Gokei_70_74JikoFutanGaku;
    private Decimal futangaku_sumi_Gokei_Under70KogakuShikyuGaku;
    private Decimal futangaku_sumi_Gokei_70_74KogakuShikyuGaku;
    private AtenaMeisho futangaku_atesakiShimei;
    private YubinNo futangaku_atesakiYubinNo;
    private RString futangaku_atesakiJusho;
    private RString futangaku_madoguchi_TaishoshaHanteiCode;
    private RString futangaku_shiharaiBasho;
    private FlexibleDate futangaku_shikaraiKaishiYMD;
    private FlexibleDate futangaku_shiharaiShuryoYMD;
    private RString futangaku_heichoNaiyo;
    private RString futangaku_shiharaiKaishiTime;
    private RString futangaku_shiharaiShuryoTime;
    private RString futangaku_biko;
    private RString futangaku_dataSakuseiKubun;
    private FlexibleYearMonth futangaku_kakunin_UketoriYM;
    private FlexibleYearMonth futangaku_hoseiZumi_SofuYM;
    private FlexibleYearMonth futangaku_shomeisho_UketoriYM;
    private RString futangaku_saisoFlag;
    private RString futangaku_sofuTaishoGaiFlag;
    private FlexibleDate futangaku_jikoFutanKeisanYMD;
    private FlexibleDate futangaku_shomeiShoSakuseiYMD;
    private RString futangaku_koki_KokuhoShoriKubun;
    private RString futangaku_jikoFutangakuShomeishoRealHakkoFlag;
    private FlexibleDate futangaku_batchHoseiJissiYMD;
    private FlexibleDate futangaku_realHoseiJissiYMD;
    private RString futangaku_shoumeishoyouDataKubun;

    private HihokenshaNo shikyugakuMeisai_hihokenshaNo;
    private FlexibleYear shikyugakuMeisai_taishoNendo;
    private HokenshaNo shikyugakuMeisai_shoKisaiHokenshaNo;
    private RString shikyugakuMeisai_shikyuShinseishoSeiriNo;
    private RString shikyugakuMeisai_meisanNo;
    private Decimal shikyugakuMeisai_rirekiNo;
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

    private HihokenshaNo futangakuMeisai_hihokenshaNo;
    private FlexibleYear futangakuMeisai_taishoNendo;
    private HokenshaNo futangakuMeisai_hokenshaNo;
    private RString futangakuMeisai_shikyuShinseishoSeiriNo;
    private int futangakuMeisai_rirekiNo;
    @PrimaryKey
    private RString futangakuMeisai_taishoM;
    private Decimal futangakuMeisai_jikoFutanGaku;
    private Decimal futangakuMeisai_uchisu_70_74JikoFutanGaku;
    private Decimal futangakuMeisai_under_70KogakuShikyuGaku;
    private Decimal futangakuMeisai_over_70_74KogakuShikyuGaku;
    private RString futangakuMeisai_tekiyo;
    private Decimal futangakuMeisai_sumi_JikoFutanGaku;
    private Decimal futangakuMeisai_sumi_70_74JikoFutanGaku;
    private Decimal futangakuMeisai_sumi_under_70KogakuShikyuGaku;
    private Decimal futangakuMeisai_sumi_70_74KogakuShikyuGaku;
    private RString futangakuMeisai_sumi_Tekiyo;

    private HihokenshaNo zenFutangakuMeisai_hihokenshaNo;
    private FlexibleYear zenFutangakuMeisai_taishoNendo;
    private HokenshaNo zenFutangakuMeisai_hokenshaNo;
    private RString zenFutangakuMeisai_shikyuShinseishoSeiriNo;
    @PrimaryKey
    private HokenshaNo zenFutangakuMeisai_tennyumaeHokenshaNo;
    private int zenFutangakuMeisai_rirekiNo;
    @PrimaryKey
    private RString zenFutangakuMeisai_taishoM;
    private Decimal zenFutangakuMeisai_jikoFutanGaku;
    private Decimal zenFutangakuMeisai_uchisu_70_74JikoFutanGaku;
    private Decimal zenFutangakuMeisai_under_70KogakuShikyuGaku;
    private Decimal zenFutangakuMeisai_over_70_74KogakuShikyuGaku;
    private RString zenFutangakuMeisai_tekiyo;

}
