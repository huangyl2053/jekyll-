/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraishikyukettekyufujssekihensyu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績編集用entityクラスです。
 */
public class KyufujissekiEntity {

    private final DbT3038ShokanKihonEntity DbT3038ShokanKihon;
    private final DbT3034ShokanShinseiEntity DbT3034ShokanShinsei;
    private final DbT3036ShokanHanteiKekkaEntity DbT3036ShokanHanteiKekka;
    private final List<DbT3039ShokanMeisaiEntity> DbT3039ShokanMeisai;
    private final List<DbT3107ShokanMeisaiJushochiTokureiEntity> DbT3107ShokanMeisaiJushochiTokurei;
    private final List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> DbT3040ShokanKinkyuShisetsuRyoyo;
    private final List<DbT3041ShokanTokuteiShinryohiEntity> DbT3041ShokanTokuteiShinryohi;
    private final List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> DbT3042ShokanTokuteiShinryoTokubetsuRyoyo;
    private final List<DbT3043ShokanShokujiHiyoEntity> DbT3043ShokanShokujiHiyo;
    private final List<ServiceKeikakuHiRealtEntity> ServiceKeikakuHiRealt;
    private final List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo;
    private final List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> DbT3051ShokanShakaiFukushiHojinKeigengaku;
    private final List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> DbT3052ShokanShoteiShikkanShisetsuRyoyo;
    private final List<DbT3053ShokanShukeiEntity> DbT3053ShokanShukei;

    /**
     * コンストラクタです。
     *
     * @param DbT3038ShokanKihon
     * @param DbT3034ShokanShinsei
     * @param DbT3036ShokanHanteiKekka
     * @param DbT3039ShokanMeisai
     * @param DbT3107ShokanMeisaiJushochiTokurei
     * @param DbT3040ShokanKinkyuShisetsuRyoyo
     * @param DbT3041ShokanTokuteiShinryohi
     * @param DbT3042ShokanTokuteiShinryoTokubetsuRyoyo
     * @param DbT3043ShokanShokujiHiyo
     * @param ServiceKeikakuHiRealt
     * @param DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo
     * @param DbT3051ShokanShakaiFukushiHojinKeigengaku
     * @param DbT3052ShokanShoteiShikkanShisetsuRyoyo
     * @param DbT3053ShokanShukei
     */
    public KyufujissekiEntity(
            DbT3038ShokanKihonEntity DbT3038ShokanKihon,
            DbT3034ShokanShinseiEntity DbT3034ShokanShinsei,
            DbT3036ShokanHanteiKekkaEntity DbT3036ShokanHanteiKekka,
            List<DbT3039ShokanMeisaiEntity> DbT3039ShokanMeisai,
            List<DbT3107ShokanMeisaiJushochiTokureiEntity> DbT3107ShokanMeisaiJushochiTokurei,
            List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> DbT3040ShokanKinkyuShisetsuRyoyo,
            List<DbT3041ShokanTokuteiShinryohiEntity> DbT3041ShokanTokuteiShinryohi,
            List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> DbT3042ShokanTokuteiShinryoTokubetsuRyoyo,
            List<DbT3043ShokanShokujiHiyoEntity> DbT3043ShokanShokujiHiyo,
            List<ServiceKeikakuHiRealtEntity> ServiceKeikakuHiRealt,
            List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo,
            List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> DbT3051ShokanShakaiFukushiHojinKeigengaku,
            List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> DbT3052ShokanShoteiShikkanShisetsuRyoyo,
            List<DbT3053ShokanShukeiEntity> DbT3053ShokanShukei) {
        this.DbT3038ShokanKihon = DbT3038ShokanKihon;
        this.DbT3034ShokanShinsei = DbT3034ShokanShinsei;
        this.DbT3036ShokanHanteiKekka = DbT3036ShokanHanteiKekka;
        this.DbT3039ShokanMeisai = DbT3039ShokanMeisai;
        this.DbT3107ShokanMeisaiJushochiTokurei = DbT3107ShokanMeisaiJushochiTokurei;
        this.DbT3040ShokanKinkyuShisetsuRyoyo = DbT3040ShokanKinkyuShisetsuRyoyo;
        this.DbT3041ShokanTokuteiShinryohi = DbT3041ShokanTokuteiShinryohi;
        this.DbT3042ShokanTokuteiShinryoTokubetsuRyoyo = DbT3042ShokanTokuteiShinryoTokubetsuRyoyo;
        this.DbT3043ShokanShokujiHiyo = DbT3043ShokanShokujiHiyo;
        this.ServiceKeikakuHiRealt = ServiceKeikakuHiRealt;
        this.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo;
        this.DbT3051ShokanShakaiFukushiHojinKeigengaku = DbT3051ShokanShakaiFukushiHojinKeigengaku;
        this.DbT3052ShokanShoteiShikkanShisetsuRyoyo = DbT3052ShokanShoteiShikkanShisetsuRyoyo;
        this.DbT3053ShokanShukei = DbT3053ShokanShukei;

    }

    /**
     * 償還払請求基本を取得します。
     *
     * @return 償還払請求基本
     */
    public DbT3038ShokanKihonEntity get償還払請求基本() {
        return DbT3038ShokanKihon;
    }

    /**
     * 償還払支給申請を取得します。
     *
     * @return 償還払支給申請
     */
    public DbT3034ShokanShinseiEntity get償還払支給申請() {
        return DbT3034ShokanShinsei;
    }

    /**
     * 償還払支給判定結果を取得します。
     *
     * @return 償還払支給判定結果
     */
    public DbT3036ShokanHanteiKekkaEntity get償還払支給判定結果() {
        return DbT3036ShokanHanteiKekka;
    }

    /**
     * 償還払請求サービス計画Listを取得します。
     *
     * @return 償還払請求サービス計画List
     */
    public List<ServiceKeikakuHiRealtEntity> get償還払請求サービス計画List() {
        return ServiceKeikakuHiRealt;
    }

    /**
     * 償還払請求明細Listを取得します。
     *
     * @return 償還払請求明細List
     */
    public List<DbT3039ShokanMeisaiEntity> get償還払請求明細List() {
        return DbT3039ShokanMeisai;
    }

    /**
     * 償還払請求明細・住所地特例Listを取得します。
     *
     * @return 償還払請求明細・住所地特例List
     */
    public List<DbT3107ShokanMeisaiJushochiTokureiEntity> get住所地特例List() {
        return DbT3107ShokanMeisaiJushochiTokurei;
    }

    /**
     * 償還払請求緊急時施設療養Listを取得します。
     *
     * @return 償還払請求緊急時施設療養List
     */
    public List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> get償還払請求緊急時施設療養List() {
        return DbT3040ShokanKinkyuShisetsuRyoyo;
    }

    /**
     * 償還払請求特定診療費Listを取得します。
     *
     * @return 償還払請求特定診療費List
     */
    public List<DbT3041ShokanTokuteiShinryohiEntity> get償還払請求特定診療費List() {
        return DbT3041ShokanTokuteiShinryohi;
    }

    /**
     * 償還払請求特定診療費・特別療養費Listを取得します。
     *
     * @return 償還払請求特定診療費・特別療養費List
     */
    public List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> get特別療養費List() {
        return DbT3042ShokanTokuteiShinryoTokubetsuRyoyo;
    }

    /**
     * 償還払請求食事費用Listを取得します。
     *
     * @return 償還払請求食事費用List
     */
    public List<DbT3043ShokanShokujiHiyoEntity> get給付実績食事費用List() {
        return DbT3043ShokanShokujiHiyo;
    }

    /**
     * 償還払請求特定入所者介護サービス費用Listを取得します。
     *
     * @return 償還払請求特定入所者介護サービス費用List
     */
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> get償還払請求特定入所者介護サービス費用List() {
        return DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo;
    }

    /**
     * 償還払請求社会福祉法人軽減額Listを取得します。
     *
     * @return 償還払請求社会福祉法人軽減額List
     */
    public List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> get償還払請求社会福祉法人軽減額List() {
        return DbT3051ShokanShakaiFukushiHojinKeigengaku;
    }

    /**
     * 償還払請求所定疾患施設療養費等Listを取得します。
     *
     * @return 償還払請求所定疾患施設療養費等List
     */
    public List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> get償還払請求所定疾患施設療養費等List() {
        return DbT3052ShokanShoteiShikkanShisetsuRyoyo;
    }

    /**
     * 償還払請求集計Listを取得します。
     *
     * @return 償還払請求集計List
     */
    public List<DbT3053ShokanShukeiEntity> get償還払請求集計List() {
        return DbT3053ShokanShukei;
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分() {
        return DbT3036ShokanHanteiKekka.getShikyuHushikyuKetteiKubun();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return DbT3034ShokanShinsei.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return DbT3034ShokanShinsei.getServiceTeikyoYM();
    }

    /**
     * 入力識別番号を取得します。
     *
     * @return 入力識別番号
     */
    public RString get入力識別番号() {
        return DbT3038ShokanKihon.getYoshikiNo();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return DbT3034ShokanShinsei.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get請求基本被保険者番号() {
        return DbT3038ShokanKihon.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth get請求基本サービス提供年月() {
        return DbT3038ShokanKihon.getServiceTeikyoYM();
    }

    /**
     * 事業所番号を取得します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return DbT3038ShokanKihon.getJigyoshaNo();
    }

    /**
     * 開始年月日を取得します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return DbT3038ShokanKihon.getKaishiYMD();
    }

    /**
     * 中止年月日を取得します。
     *
     * @return 中止年月日
     */
    public FlexibleDate get中止年月日() {
        return DbT3038ShokanKihon.getChushiYMD();
    }

    /**
     * 中止理由・入所（院）前の状況コードを取得します。
     *
     * @return 中止理由・入所（院）前の状況コード
     */
    public RString get中止理由() {
        return DbT3038ShokanKihon.getChushiRiyuNyushomaeJyokyoCode();
    }

    /**
     * 入所（院）年月日を取得します。
     *
     * @return 入所（院）年月日
     */
    public FlexibleDate get入所院年月日() {
        return DbT3038ShokanKihon.getNyushoYMD();
    }

    /**
     * 退所（院）年月日を取得します。
     *
     * @return 退所（院）年月日
     */
    public FlexibleDate get退所院年月日() {
        return DbT3038ShokanKihon.getTaishoYMD();
    }

    /**
     * 入所（院）実日数を取得します。
     *
     * @return 入所（院）実日数
     */
    public Decimal get入所院実日数() {
        return DbT3038ShokanKihon.getNyushoJitsuNissu();
    }

    /**
     * 外泊日数を取得します。
     *
     * @return 外泊日数
     */
    public Decimal get外泊日数() {
        return DbT3038ShokanKihon.getGaihakuNissu();
    }

    /**
     * 退所（院）後の状態コードを取得します。
     *
     * @return 退所（院）後の状態コード
     */
    public RString get退所院後の状態コード() {
        return DbT3038ShokanKihon.getTaishogoJotaiCode();
    }

    /**
     * 保険給付率を取得します。
     *
     * @return 保険給付率
     */
    public HokenKyufuRitsu get保険給付率() {
        return DbT3038ShokanKihon.getHokenKyufuritsu();
    }

    /**
     * 前・保険・サービス単位数を取得します。
     *
     * @return 前・保険・サービス単位数
     */
    public int get前保険サービス単位数() {
        return DbT3038ShokanKihon.getServiceTanisu();
    }

    /**
     * 前・保険・請求額を取得します。
     *
     * @return 前・保険・請求額
     */
    public int get前保険請求額() {
        return DbT3034ShokanShinsei.getHokenKyufugaku();
    }

    /**
     * 前・保険・利用者負担額を取得します。
     *
     * @return 前・保険・利用者負担額
     */
    public int get前保険負担額() {
        return DbT3034ShokanShinsei.getRiyoshaFutangaku();
    }

    /**
     * 後・保険・サービス単位数を取得します。
     *
     * @return 後・保険・サービス単位数
     */
    public int get後保険サービス単位数() {
        return DbT3038ShokanKihon.getServiceTanisu();
    }

    /**
     * 後・保険・請求額を取得します。
     *
     * @return 後・保険・請求額
     */
    public int get後保険請求額() {
        return DbT3034ShokanShinsei.getHokenKyufugaku();
    }

    /**
     * 後・保険・利用者負担額を取得します。
     *
     * @return 後・保険・利用者負担額
     */
    public int get後保険負担額() {
        return DbT3034ShokanShinsei.getRiyoshaFutangaku();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleDate get審査年月() {
        return DbT3036ShokanHanteiKekka.getKetteiYMD();
    }

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return DbT3038ShokanKihon.getSeiriNp();
    }
}
