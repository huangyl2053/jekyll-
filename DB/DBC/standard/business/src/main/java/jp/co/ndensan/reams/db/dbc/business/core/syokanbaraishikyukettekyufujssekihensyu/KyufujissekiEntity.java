/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraishikyukettekyufujssekihensyu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuhi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績編集用entityクラスです。
 *
 * @reamsid_L DBC-1030-210 xicongwang
 */
public class KyufujissekiEntity {

    private final List<DbT3038ShokanKihonEntity> dbT3038ShokanKihonList;
    private final DbT3034ShokanShinseiEntity dbT3034ShokanShinsei;
    private final DbT3036ShokanHanteiKekkaEntity dbT3036ShokanHanteiKekka;
    private final List<DbT3039ShokanMeisaiEntity> dbT3039ShokanMeisai;
    private final List<DbT3107ShokanMeisaiJushochiTokureiEntity> dbT3107ShokanMeisaiJushochiTokurei;
    private final List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> dbT3040ShokanKinkyuShisetsuRyoyo;
    private final List<DbT3041ShokanTokuteiShinryohiEntity> dbT3041ShokanTokuteiShinryohi;
    private final List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> dbT3042ShokanTokuteiShinryoTokubetsuRyoyo;
    private final List<DbT3043ShokanShokujiHiyoEntity> dbT3043ShokanShokujiHiyo;
    private final List<ServiceKeikakuHiRealtEntity> serviceKeikakuHiRealt;
    private final List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> dbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo;
    private final List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> dbT3051ShokanShakaiFukushiHojinKeigengaku;
    private final List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> dbT3052ShokanShoteiShikkanShisetsuRyoyo;
    private final List<DbT3053ShokanShukeiEntity> dbT3053ShokanShukei;

    /**
     * コンストラクタです。
     *
     * @param dbT3038ShokanKihonList dbT3038ShokanKihonList
     * @param dbT3034ShokanShinsei dbT3034ShokanShinsei
     * @param dbT3036ShokanHanteiKekka dbT3036ShokanHanteiKekka
     * @param dbT3039ShokanMeisai dbT3039ShokanMeisai
     * @param dbT3107ShokanMeisaiJushochiTokurei dbT3107ShokanMeisaiJushochiTokurei
     * @param dbT3040ShokanKinkyuShisetsuRyoyo dbT3040ShokanKinkyuShisetsuRyoyo
     * @param dbT3041ShokanTokuteiShinryohi dbT3041ShokanTokuteiShinryohi
     * @param dbT3042ShokanTokuteiShinryoTokubetsuRyoyo dbT3042ShokanTokuteiShinryoTokubetsuRyoyo
     * @param dbT3043ShokanShokujiHiyo dbT3043ShokanShokujiHiyo
     * @param serviceKeikakuHiRealt serviceKeikakuHiRealt
     * @param dbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo dbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo
     * @param dbT3051ShokanShakaiFukushiHojinKeigengaku dbT3051ShokanShakaiFukushiHojinKeigengaku
     * @param dbT3052ShokanShoteiShikkanShisetsuRyoyo dbT3052ShokanShoteiShikkanShisetsuRyoyo
     * @param dbT3053ShokanShukei dbT3053ShokanShukei
     */
    public KyufujissekiEntity(
            List<DbT3038ShokanKihonEntity> dbT3038ShokanKihonList,
            DbT3034ShokanShinseiEntity dbT3034ShokanShinsei,
            DbT3036ShokanHanteiKekkaEntity dbT3036ShokanHanteiKekka,
            List<DbT3039ShokanMeisaiEntity> dbT3039ShokanMeisai,
            List<DbT3107ShokanMeisaiJushochiTokureiEntity> dbT3107ShokanMeisaiJushochiTokurei,
            List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> dbT3040ShokanKinkyuShisetsuRyoyo,
            List<DbT3041ShokanTokuteiShinryohiEntity> dbT3041ShokanTokuteiShinryohi,
            List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> dbT3042ShokanTokuteiShinryoTokubetsuRyoyo,
            List<DbT3043ShokanShokujiHiyoEntity> dbT3043ShokanShokujiHiyo,
            List<ServiceKeikakuHiRealtEntity> serviceKeikakuHiRealt,
            List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> dbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo,
            List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> dbT3051ShokanShakaiFukushiHojinKeigengaku,
            List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> dbT3052ShokanShoteiShikkanShisetsuRyoyo,
            List<DbT3053ShokanShukeiEntity> dbT3053ShokanShukei) {
        this.dbT3038ShokanKihonList = dbT3038ShokanKihonList;
        this.dbT3034ShokanShinsei = dbT3034ShokanShinsei;
        this.dbT3036ShokanHanteiKekka = dbT3036ShokanHanteiKekka;
        this.dbT3039ShokanMeisai = dbT3039ShokanMeisai;
        this.dbT3107ShokanMeisaiJushochiTokurei = dbT3107ShokanMeisaiJushochiTokurei;
        this.dbT3040ShokanKinkyuShisetsuRyoyo = dbT3040ShokanKinkyuShisetsuRyoyo;
        this.dbT3041ShokanTokuteiShinryohi = dbT3041ShokanTokuteiShinryohi;
        this.dbT3042ShokanTokuteiShinryoTokubetsuRyoyo = dbT3042ShokanTokuteiShinryoTokubetsuRyoyo;
        this.dbT3043ShokanShokujiHiyo = dbT3043ShokanShokujiHiyo;
        this.serviceKeikakuHiRealt = serviceKeikakuHiRealt;
        this.dbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo = dbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo;
        this.dbT3051ShokanShakaiFukushiHojinKeigengaku = dbT3051ShokanShakaiFukushiHojinKeigengaku;
        this.dbT3052ShokanShoteiShikkanShisetsuRyoyo = dbT3052ShokanShoteiShikkanShisetsuRyoyo;
        this.dbT3053ShokanShukei = dbT3053ShokanShukei;

    }

    /**
     * 償還払請求基本Listを取得します。
     *
     * @return 償還払請求基本List
     */
    public List<DbT3038ShokanKihonEntity> get償還払請求基本List() {
        return dbT3038ShokanKihonList;
    }

    /**
     * 償還払支給申請を取得します。
     *
     * @return 償還払支給申請
     */
    public DbT3034ShokanShinseiEntity get償還払支給申請() {
        return dbT3034ShokanShinsei;
    }

    /**
     * 償還払支給判定結果を取得します。
     *
     * @return 償還払支給判定結果
     */
    public DbT3036ShokanHanteiKekkaEntity get償還払支給判定結果() {
        return dbT3036ShokanHanteiKekka;
    }

    /**
     * 償還払請求サービス計画Listを取得します。
     *
     * @return 償還払請求サービス計画List
     */
    public List<ServiceKeikakuHiRealtEntity> get償還払請求サービス計画List() {
        return serviceKeikakuHiRealt;
    }

    /**
     * 償還払請求明細Listを取得します。
     *
     * @return 償還払請求明細List
     */
    public List<DbT3039ShokanMeisaiEntity> get償還払請求明細List() {
        return dbT3039ShokanMeisai;
    }

    /**
     * 償還払請求明細・住所地特例Listを取得します。
     *
     * @return 償還払請求明細・住所地特例List
     */
    public List<DbT3107ShokanMeisaiJushochiTokureiEntity> get住所地特例List() {
        return dbT3107ShokanMeisaiJushochiTokurei;
    }

    /**
     * 償還払請求緊急時施設療養Listを取得します。
     *
     * @return 償還払請求緊急時施設療養List
     */
    public List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> get償還払請求緊急時施設療養List() {
        return dbT3040ShokanKinkyuShisetsuRyoyo;
    }

    /**
     * 償還払請求特定診療費Listを取得します。
     *
     * @return 償還払請求特定診療費List
     */
    public List<DbT3041ShokanTokuteiShinryohiEntity> get償還払請求特定診療費List() {
        return dbT3041ShokanTokuteiShinryohi;
    }

    /**
     * 償還払請求特定診療費・特別療養費Listを取得します。
     *
     * @return 償還払請求特定診療費・特別療養費List
     */
    public List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> get特別療養費List() {
        return dbT3042ShokanTokuteiShinryoTokubetsuRyoyo;
    }

    /**
     * 償還払請求食事費用Listを取得します。
     *
     * @return 償還払請求食事費用List
     */
    public List<DbT3043ShokanShokujiHiyoEntity> get給付実績食事費用List() {
        return dbT3043ShokanShokujiHiyo;
    }

    /**
     * 償還払請求特定入所者介護サービス費用Listを取得します。
     *
     * @return 償還払請求特定入所者介護サービス費用List
     */
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> get償還払請求特定入所者介護サービス費用List() {
        return dbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo;
    }

    /**
     * 償還払請求社会福祉法人軽減額Listを取得します。
     *
     * @return 償還払請求社会福祉法人軽減額List
     */
    public List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> get償還払請求社会福祉法人軽減額List() {
        return dbT3051ShokanShakaiFukushiHojinKeigengaku;
    }

    /**
     * 償還払請求所定疾患施設療養費等Listを取得します。
     *
     * @return 償還払請求所定疾患施設療養費等List
     */
    public List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> get償還払請求所定疾患施設療養費等List() {
        return dbT3052ShokanShoteiShikkanShisetsuRyoyo;
    }

    /**
     * 償還払請求集計Listを取得します。
     *
     * @return 償還払請求集計List
     */
    public List<DbT3053ShokanShukeiEntity> get償還払請求集計List() {
        return dbT3053ShokanShukei;
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分() {
        return dbT3036ShokanHanteiKekka.getShikyuHushikyuKetteiKubun();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return dbT3034ShokanShinsei.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return dbT3034ShokanShinsei.getServiceTeikyoYM();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return dbT3034ShokanShinsei.getShoKisaiHokenshaNo();
    }

    /**
     * 前・保険・請求額を取得します。
     *
     * @return 前・保険・請求額
     */
    public int get前保険請求額() {
        return dbT3034ShokanShinsei.getHokenKyufugaku();
    }

    /**
     * 前・保険・利用者負担額を取得します。
     *
     * @return 前・保険・利用者負担額
     */
    public int get前保険負担額() {
        return dbT3034ShokanShinsei.getRiyoshaFutangaku();
    }

    /**
     * 後・保険・請求額を取得します。
     *
     * @return 後・保険・請求額
     */
    public int get後保険請求額() {
        return dbT3034ShokanShinsei.getHokenKyufugaku();
    }

    /**
     * 後・保険・利用者負担額を取得します。
     *
     * @return 後・保険・利用者負担額
     */
    public int get後保険負担額() {
        return dbT3034ShokanShinsei.getRiyoshaFutangaku();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleDate get審査年月() {
        return dbT3036ShokanHanteiKekka.getKetteiYMD();
    }

}
