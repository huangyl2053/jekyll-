/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoShokan3Keta;
import jp.co.ndensan.reams.db.dbc.definition.core.shikibetsunokubon.ShikibetsuNoKubon;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ServiceShuruiCodeParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShibaraiKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShokanShikyuShinseiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.ShichosonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekka;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3048ShokanFukushiYoguHanbaihiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7112ShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyushisei.IFukushiyoguKonyuhiShikyuGendogakuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.shokanfukushiyoguhanbaihi.FukushiyoguKonyuhiShikyuGendogakuManager;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 福祉用具購入費支給申請のビジネスです。
 *
 * @author GC 張鋭
 */
public class FukushiyoguKonyuhiShikyuGendogaku {

    private final MapperProvider mapperProvider;
    private final DbT7115UwanoseShokanShuruiShikyuGendoGakuDac 上乗せ償還払い給付種類支給限度額Dac;
    private final DbT7112ShokanShuruiShikyuGendoGakuDac 償還払い給付種類支給限度額Dac;
    private final DbT3038ShokanKihonDac 償還払請求基本Dac;
    private final DbT3048ShokanFukushiYoguHanbaihiDac 償還払請求福祉用具販売費Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final ShichosonSecurityJohoFinder 基準月市町村情報Finder;
    private final FukushiyoguKonyuhiShikyuGendogakuManager 福祉用具購入費支給決定給付実績編集Mgr;

    private static final RString 状態_登録 = new RString("登録");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 支給区分_支給 = new RString("1");
    private static final RString 支給区分_不支給 = new RString("0");

    /**
     * コンストラクタです。
     */
    FukushiyoguKonyuhiShikyuGendogaku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.上乗せ償還払い給付種類支給限度額Dac = InstanceProvider.create(
                DbT7115UwanoseShokanShuruiShikyuGendoGakuDac.class);
        this.償還払い給付種類支給限度額Dac = InstanceProvider.create(DbT7112ShokanShuruiShikyuGendoGakuDac.class);
        this.償還払請求基本Dac = InstanceProvider.create(DbT3038ShokanKihonDac.class);
        this.償還払請求福祉用具販売費Dac = InstanceProvider.create(DbT3048ShokanFukushiYoguHanbaihiDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.基準月市町村情報Finder = InstanceProvider.create(ShichosonSecurityJohoFinder.class);
        this.福祉用具購入費支給決定給付実績編集Mgr
                = InstanceProvider.create(FukushiyoguKonyuhiShikyuGendogakuManager.class);
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return {@link InstanceProvider#create}により生成された{@link FukushiyoguKonyuhiShikyuGendogaku}
     */
    public static FukushiyoguKonyuhiShikyuGendogaku createInstance() {
        return InstanceProvider.create(FukushiyoguKonyuhiShikyuGendogaku.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 上乗せ償還払い給付種類支給限度額Dac 上乗せ償還払い給付種類支給限度額Dac
     * @param 償還払い給付種類支給限度額Dac 償還払い給付種類支給限度額Dac
     * @param 償還払請求基本Dac 償還払請求基本Dac
     * @param 償還払請求福祉用具販売費Dac 償還払請求福祉用具販売費Dac
     * @param 償還払支給申請Dac 償還払支給申請Dac
     * @param 償還払支給判定結果Dac 償還払支給判定結果Dac
     * @param 受給者台帳Dac 受給者台帳Dac
     */
    FukushiyoguKonyuhiShikyuGendogaku(
            MapperProvider mapperProvider,
            DbT7115UwanoseShokanShuruiShikyuGendoGakuDac 上乗せ償還払い給付種類支給限度額Dac,
            DbT7112ShokanShuruiShikyuGendoGakuDac 償還払い給付種類支給限度額Dac,
            DbT3038ShokanKihonDac 償還払請求基本Dac,
            DbT3048ShokanFukushiYoguHanbaihiDac 償還払請求福祉用具販売費Dac,
            DbT3034ShokanShinseiDac 償還払支給申請Dac,
            DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac,
            DbT3118ShikibetsuNoKanriDac 識別番号管理Dac,
            DbT3053ShokanShukeiDac 償還払請求集計Dac,
            FukushiyoguKonyuhiShikyuGendogakuManager 福祉用具購入費支給決定給付実績編集Mgr,
            ShichosonSecurityJohoFinder 基準月市町村情報Finder
    ) {
        this.mapperProvider = mapperProvider;
        this.上乗せ償還払い給付種類支給限度額Dac = 上乗せ償還払い給付種類支給限度額Dac;
        this.償還払い給付種類支給限度額Dac = 償還払い給付種類支給限度額Dac;
        this.償還払請求基本Dac = 償還払請求基本Dac;
        this.償還払請求福祉用具販売費Dac = 償還払請求福祉用具販売費Dac;
        this.償還払支給申請Dac = 償還払支給申請Dac;
        this.償還払支給判定結果Dac = 償還払支給判定結果Dac;
        this.識別番号管理Dac = 識別番号管理Dac;
        this.福祉用具購入費支給決定給付実績編集Mgr = 福祉用具購入費支給決定給付実績編集Mgr;
        this.基準月市町村情報Finder = 基準月市町村情報Finder;
        this.償還払請求集計Dac = 償還払請求集計Dac;
    }

    /**
     * 被保険者より、福祉用具購入費支給申請一覧のデータを取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<FukushiyouguKonyuhiShikyuShinsei>
     */
    @Transaction
    public List<FukushiyouguKonyuhiShikyuShinsei> getShokanShikyuShinseiList(HihokenshaNo 被保険者番号) {
        IFukushiyoguKonyuhiShikyuGendogakuMapper mapper
                = mapperProvider.create(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
        ShokanShikyuShinseiParameter parameter
                = ShokanShikyuShinseiParameter.createParameter(被保険者番号,
                        NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.getコード());
        List<FukushiyouguKonyuhiShikyuShinsei> shokanShikyuShinseiList
                = mapper.select支給申請一覧(parameter);
        if (null == shokanShikyuShinseiList) {
            shokanShikyuShinseiList = new ArrayList<>();
        }
        return shokanShikyuShinseiList;
    }

    /**
     * 償還払請求基本のキーより、該当する償還払い請求基本情報を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return ShokanKihon 償還払請求基本Entity
     */
    @Transaction
    public ShokanKihon getShokanSeikyuKihon(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        DbT3038ShokanKihonEntity entity = this.償還払請求基本Dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号);
        if (null == entity) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanKihon(entity);
    }

    /**
     * 償還払請求基本のキーより、該当する償還払い請求福祉用具販売費情報を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<ShokanFukushiYoguHanbaihi>
     */
    @Transaction
    public List<ShokanFukushiYoguHanbaihi> getShokanFukushiYoguHanbaihi(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        List<DbT3048ShokanFukushiYoguHanbaihiEntity> entityList
                = this.償還払請求福祉用具販売費Dac.select償還払請求福祉用具販売費リスト(
                        被保険者番号,
                        サービス提供年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号);
        List<ShokanFukushiYoguHanbaihi> resultList = new ArrayList<>();
        if (null == entityList || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3048ShokanFukushiYoguHanbaihiEntity entity : entityList) {
            if (null != entity) {
                entity.initializeMd5();
            }
            resultList.add(new ShokanFukushiYoguHanbaihi(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求基本のキーより、該当する償還払い支給申請を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return ShokanShinsei 償還払支給申請Entity
     */
    @Transaction
    public ShokanShinsei getShokanShinsei(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        DbT3034ShokanShinseiEntity entity = this.償還払支給申請Dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号);
        if (null == entity) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanShinsei(entity);
    }

    /**
     * 償還払請求基本のキーより、該当する償還払判定結果を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return ShokanHanteiKekka 償還払支給判定結果Entity
     */
    @Transaction
    public ShokanHanteiKekka getShokanHanteiKekka(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        DbT3036ShokanHanteiKekkaEntity entity = this.償還払支給判定結果Dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号);
        if (null == entity) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanHanteiKekka(entity);
    }

// TODO 設計が問題あるかも、対応待ち
    /**
     * 償還払請求基本のキーより、該当する償還払請求集計を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return ShokanHanteiKekka 償還払支給判定結果Entity
     */
    @Transaction
    public ShokanShukei getShokanShukei(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        DbT3053ShokanShukeiEntity entity = 償還払請求集計Dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                null);

        if (entity == null) {
            return null;
        }

        entity.initializeMd5();
        return new ShokanShukei(entity);
    }

    /**
     * 償還払請求基本のキーより、同じ年度のすべて支払結果を合計して取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return SokanbaraiShiharaiKekka 償還払支払結果Entity
     */
    @Transaction
    public SokanbaraiShiharaiKekka getShokanShiharaiKekkaAll(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        requireNonNull(被保険者番号,
                UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月,
                UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        IFukushiyoguKonyuhiShikyuGendogakuMapper mapper
                = mapperProvider.create(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
        ShibaraiKekkaParameter parameter = ShibaraiKekkaParameter.createParameter(
                被保険者番号,
                サービス提供年月.getYear().toDateString(),
                NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.getコード());
        SokanbaraiShiharaiKekka result = mapper.select支払結果情報(parameter);
        if (null == result) {
            result = new SokanbaraiShiharaiKekka();
            result.set保険対象費用額(Decimal.ZERO);
            result.set保険給付額(0);
            result.set利用者負担額(0);
            result.set費用額合計(Decimal.ZERO);
        }
        return result;
    }

    /**
     * 償還払請求基本のキーより、支払結果情報を抽出される。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return SokanbaraiShiharaiKekka 償還払支払結果Entity
     */
    @Transaction
    public SokanbaraiShiharaiKekka getShokanShiharaiKekka(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        DbT3034ShokanShinseiEntity entity = 償還払支給申請Dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号);
        SokanbaraiShiharaiKekka result = new SokanbaraiShiharaiKekka();
        if (null == entity) {
            result.set保険対象費用額(Decimal.ZERO);
            result.set保険給付額(0);
            result.set利用者負担額(0);
            result.set費用額合計(Decimal.ZERO);
            return result;
        }
        entity.initializeMd5();
        ShokanShinsei 償還払支給申請 = new ShokanShinsei(entity);
        result.set保険対象費用額(償還払支給申請.get保険対象費用額());
        result.set保険給付額(償還払支給申請.get保険給付額());
        result.set利用者負担額(償還払支給申請.get利用者負担額());
        result.set費用額合計(償還払支給申請.get支払金額合計());
        return result;
    }

    /**
     * 画面のデータをＤＢに追加する。
     *
     * @param 償還払請求基本 償還払請求基本
     * @param 償還払請求福祉用具販売費リスト 償還払請求福祉用具販売費リスト
     * @param 償還払支給申請 償還払支給申請
     * @param 償還払集計 償還払集計
     */
    @Transaction
    public void insert(
            ShokanKihon 償還払請求基本,
            List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト,
            ShokanShinsei 償還払支給申請,
            ShokanShukei 償還払集計) {
        RString 整理番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).nextString();
        DbT3038ShokanKihonEntity DbT3038Entity
                = 償還払請求基本.createBuilderForEdit().set整理番号(整理番号).build().toEntity();
        DbT3038Entity.setState(EntityDataState.Added);
        償還払請求基本Dac.save(DbT3038Entity);
        for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
            DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity
                    = 償還払請求福祉用具販売費.createBuilderForEdit().set整理番号(整理番号).build().toEntity();
            DbT3048Entity.setState(EntityDataState.Added);
            償還払請求福祉用具販売費Dac.save(DbT3048Entity);
        }
        DbT3034ShokanShinseiEntity DbT3034Entity
                = 償還払支給申請.createBuilderForEdit().set整理番号(整理番号).build().toEntity();
        DbT3034Entity.setState(EntityDataState.Added);
        償還払支給申請Dac.save(DbT3034Entity);
        DbT3053ShokanShukeiEntity DbT3053Entity
                = 償還払集計.createBuilderForEdit().set整理番号(整理番号).build().toEntity();
        DbT3053Entity.setState(EntityDataState.Added);
        償還払請求集計Dac.save(DbT3053Entity);
    }

    /**
     * 画面のデータを更新する。
     *
     * @param 償還払請求基本 償還払請求基本
     * @param 償還払請求福祉用具販売費リスト 償還払請求福祉用具販売費リスト
     * @param 償還払支給申請 償還払支給申請
     * @param 償還払支給判定結果
     * @param 償還払集計 償還払集計
     * @param 状態 状態
     */
    @Transaction
    public void updae(
            ShokanKihon 償還払請求基本,
            List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト,
            ShokanShinsei 償還払支給申請,
            ShokanHanteiKekka 償還払支給判定結果,
            ShokanShukei 償還払集計,
            RString 状態) {
        int 登録数 = 0;
        int 最大枝番;
        DbT3038ShokanKihonEntity DbT3038Entity = 償還払請求基本.toEntity();
        DbT3038Entity.setState(EntityDataState.Modified);
        List<DbT3048ShokanFukushiYoguHanbaihiEntity> DbT3048EntityList = new ArrayList<>();
        償還払請求基本Dac.save(DbT3038Entity);
        if (状態_登録.equals(状態)) {
            RString MAX連番 = 償還払請求福祉用具販売費Dac.getMAX連番(償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(),
                    償還払請求基本.get整理番号(),
                    償還払請求基本.get事業者番号(),
                    償還払請求基本.get様式番号(),
                    償還払請求基本.get明細番号());
            if (null == MAX連番 || MAX連番.isEmpty()) {
                最大枝番 = 1;
            } else {
                最大枝番 = Integer.valueOf(MAX連番.toString()) + 1;
            }
            for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
                DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity
                        = 償還払請求福祉用具販売費.createBuilderForEdit().set順次番号(
                                new RString(String.valueOf(最大枝番 + 登録数))).build().toEntity();
                DbT3048Entity.setState(EntityDataState.Added);
                DbT3048EntityList.add(DbT3048Entity);
                償還払請求福祉用具販売費Dac.save(DbT3048Entity);
                登録数++;
            }
        } else if (状態_修正.equals(状態)) {
            for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
                DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity = 償還払請求福祉用具販売費.toEntity();
                DbT3048Entity.setState(EntityDataState.Modified);
                DbT3048EntityList.add(DbT3048Entity);
                償還払請求福祉用具販売費Dac.save(DbT3048Entity);
            }
        } else if (状態_削除.equals(状態)) {
            for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
                DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity = 償還払請求福祉用具販売費.toEntity();
                DbT3048Entity.setState(EntityDataState.Deleted);
                DbT3048EntityList.add(DbT3048Entity);
                償還払請求福祉用具販売費Dac.save(DbT3048Entity);
            }
        }

        DbT3034ShokanShinseiEntity DbT3034Entity = 償還払支給申請.toEntity();
        DbT3034Entity.setState(EntityDataState.Modified);
        償還払支給申請Dac.save(DbT3034Entity);
        if (null != 償還払支給判定結果) {
            DbT3036ShokanHanteiKekkaEntity DbT3036Entity = 償還払支給判定結果.toEntity();
            int データ数 = 償還払支給判定結果Dac.getCountByKey(
                    償還払支給判定結果.get被保険者番号(),
                    償還払支給判定結果.getサービス提供年月(),
                    償還払支給判定結果.get整理番号());
            if (0 == データ数) {
                DbT3036Entity.setState(EntityDataState.Added);
            } else {
                DbT3036Entity.setState(EntityDataState.Modified);
            }
            償還払支給判定結果Dac.save(DbT3036Entity);
        }

        DbT3053ShokanShukeiEntity DbT3053Entity = 償還払集計.toEntity();
        DbT3053Entity.setState(EntityDataState.Modified);
        償還払請求集計Dac.save(DbT3053Entity);
        if (null != 償還払支給判定結果) {
            // TODO
//            福祉用具購入費支給決定給付実績編集Mgr.dealKyufujisseki(
//                    画面モード,
//                    ShikibetsuCode.EMPTY,
//                    償還払請求基本Entity.toEntity(),
//                    DbT3048EntityList,
//                    償還払支給申請entity.toEntity(),
//                    償還払支給判定結果entity.toEntity(),
//                    償還払請求集計entity.toEntity(),
//                    修正前支給区分);
        }
    }

    /**
     * 画面のデータを削除する。
     *
     * @param 償還払請求基本 償還払請求基本
     * @param 償還払請求福祉用具販売費リスト 償還払請求福祉用具販売費リスト
     * @param 償還払支給申請 償還払支給申請
     * @param 償還払支給判定結果 償還払支給判定結果
     * @param 償還払集計 償還払集計
     */
    @Transaction
    public void delete(
            ShokanKihon 償還払請求基本,
            List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト,
            ShokanShinsei 償還払支給申請,
            ShokanHanteiKekka 償還払支給判定結果,
            ShokanShukei 償還払集計) {
        DbT3038ShokanKihonEntity DbT3038Entity = 償還払請求基本.toEntity();
        DbT3038Entity.setState(EntityDataState.Deleted);
        償還払請求基本Dac.save(DbT3038Entity);

        for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
            DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity = 償還払請求福祉用具販売費.toEntity();
            DbT3048Entity.setState(EntityDataState.Modified);
            償還払請求福祉用具販売費Dac.save(DbT3048Entity);
        }

        DbT3034ShokanShinseiEntity DbT3034Entity = 償還払支給申請.toEntity();
        DbT3034Entity.setState(EntityDataState.Modified);
        償還払支給申請Dac.save(DbT3034Entity);

        DbT3036ShokanHanteiKekkaEntity DbT3036Entity = 償還払支給判定結果.toEntity();
        DbT3036Entity.setState(EntityDataState.Modified);
        償還払支給判定結果Dac.save(DbT3036Entity);

        DbT3053ShokanShukeiEntity DbT3053Entity = 償還払集計.toEntity();
        DbT3053Entity.setState(EntityDataState.Modified);
        償還払請求集計Dac.save(DbT3053Entity);
    }

    /**
     * 審査モードの時、ＤＢ保存処理を行う。
     *
     * @param 償還払請求基本 償還払請求基本
     * @param 償還払請求福祉用具販売費リスト 償還払請求福祉用具販売費リスト
     * @param 償還払支給申請 償還払支給申請
     * @param 償還払支給判定結果
     * @param 償還払集計 償還払集計
     * @param 審査結果 審査結果
     * @param 状態 状態
     */
    @Transaction
    public void updShinsa(
            ShokanKihon 償還払請求基本,
            List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト,
            ShokanShinsei 償還払支給申請,
            ShokanHanteiKekka 償還払支給判定結果,
            ShokanShukei 償還払集計,
            RString 審査結果,
            RString 状態) {
        int 登録数 = 0;
        int 最大枝番;
        DbT3038ShokanKihonEntity DbT3038Entity = 償還払請求基本.toEntity();
        DbT3038Entity.setState(EntityDataState.Modified);
        償還払請求基本Dac.save(DbT3038Entity);
        if (状態_登録.equals(状態)) {
            RString MAX連番 = 償還払請求福祉用具販売費Dac.getMAX連番(償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(),
                    償還払請求基本.get整理番号(),
                    償還払請求基本.get事業者番号(),
                    償還払請求基本.get様式番号(),
                    償還払請求基本.get明細番号());
            if (null == MAX連番 || MAX連番.isEmpty()) {
                最大枝番 = 1;
            } else {
                最大枝番 = Integer.valueOf(MAX連番.toString()) + 1;
            }
            for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
                DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity
                        = 償還払請求福祉用具販売費.createBuilderForEdit().set順次番号(
                                new RString(String.valueOf(最大枝番 + 登録数))).build().toEntity();
                DbT3048Entity.setState(EntityDataState.Added);
                償還払請求福祉用具販売費Dac.save(DbT3048Entity);
                登録数++;
            }
        } else if (状態_修正.equals(状態)) {
            for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
                DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity = 償還払請求福祉用具販売費.toEntity();
                DbT3048Entity.setState(EntityDataState.Modified);
                償還払請求福祉用具販売費Dac.save(DbT3048Entity);
            }
        } else if (状態_削除.equals(状態)) {
            for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
                DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity = 償還払請求福祉用具販売費.toEntity();
                DbT3048Entity.setState(EntityDataState.Deleted);
                償還払請求福祉用具販売費Dac.save(DbT3048Entity);
            }
        }

        DbT3034ShokanShinseiEntity DbT3034Entity = 償還払支給申請.toEntity();
        DbT3034Entity.setState(EntityDataState.Modified);
        償還払支給申請Dac.save(DbT3034Entity);
        if (null != 償還払支給判定結果) {
            DbT3036ShokanHanteiKekkaEntity DbT3036Entity = 償還払支給判定結果.toEntity();
            if (ShinsaNaiyoKubun.承認する.getコード().equals(審査結果)) {
                DbT3036Entity = 償還払支給判定結果.createBuilderForEdit().
                        set支給_不支給決定区分(支給区分_支給).
                        set決定年月日(FlexibleDate.getNowDate()).
                        build().toEntity();
            } else if (ShinsaNaiyoKubun.却下する.getコード().equals(審査結果)) {
                DbT3036Entity = 償還払支給判定結果.createBuilderForEdit().
                        set支給_不支給決定区分(支給区分_不支給).
                        set決定年月日(FlexibleDate.getNowDate()).
                        build().toEntity();
            }
            int データ数 = 償還払支給判定結果Dac.getCountByKey(
                    償還払支給判定結果.get被保険者番号(),
                    償還払支給判定結果.getサービス提供年月(),
                    償還払支給判定結果.get整理番号());
            if (0 == データ数) {
                DbT3036Entity.setState(EntityDataState.Added);
            } else {
                DbT3036Entity.setState(EntityDataState.Modified);
            }
            償還払支給判定結果Dac.save(DbT3036Entity);
        }

        DbT3053ShokanShukeiEntity DbT3053Entity = 償還払集計.toEntity();
        DbT3053Entity.setState(EntityDataState.Modified);
        償還払請求集計Dac.save(DbT3053Entity);
        if (null != 償還払支給判定結果) {
            // TODO
//            福祉用具購入費支給決定給付実績編集Mgr.dealKyufujisseki(
//                    画面モード,
//                    ShikibetsuCode.EMPTY,
//                    償還払請求基本Entity.toEntity(),
//                    DbT3048EntityList,
//                    償還払支給申請entity.toEntity(),
//                    償還払支給判定結果entity.toEntity(),
//                    償還払請求集計entity.toEntity(),
//                    修正前支給区分);
        }
    }

    /**
     * 決定情報の登録更新処理を行う。
     *
     * @param 償還払請求基本 償還払請求基本
     * @param 償還払請求福祉用具販売費リスト 償還払請求福祉用具販売費リスト
     * @param 償還払支給申請 償還払支給申請
     * @param 償還払支給判定結果 償還払支給判定結果
     * @param 償還払集計 償還払集計
     * @param 決定日 決定日
     * @param 差額金額登録フラグ 差額金額登録フラグ
     * @param 識別コード 識別コード
     * @param 画面モード 画面モード
     */
    @Transaction
    public void updKetteJoho(
            ShokanKihon 償還払請求基本,
            List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト,
            ShokanShinsei 償還払支給申請,
            ShokanHanteiKekka 償還払支給判定結果,
            ShokanShukei 償還払集計,
            FlexibleDate 決定日,
            boolean 差額金額登録フラグ,
            ShikibetsuCode 識別コード,
            RString 画面モード) {
        RString 整理番号 = Saiban.get(SubGyomuCode.DBC介護給付,
                SaibanHanyokeyName.償還整理番号.getコード()).nextString();
        RString 修正前支給区分 = RString.EMPTY;
        if (null != 決定日 && !決定日.isEmpty()) {
            int データ件数 = 償還払支給判定結果Dac.getCountByKey(
                    償還払支給判定結果.get被保険者番号(),
                    償還払支給判定結果.getサービス提供年月(),
                    償還払支給判定結果.get整理番号());
            if (0 == データ件数) {
                ShoKisaiHokenshaNo 証記載保険者番号 = 償還払支給申請Dac.select証記載保険者番号(
                        償還払支給判定結果.get被保険者番号(),
                        償還払支給判定結果.getサービス提供年月(),
                        償還払支給判定結果.get整理番号());
                DbT3036ShokanHanteiKekkaEntity DbT3036Entity = 償還払支給判定結果.createBuilderForEdit().
                        set整理番号(整理番号).build().toEntity();
                DbT3036Entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(DbT3036Entity);
                修正前支給区分 = 支給区分_不支給;
            } else {
                DbT3036ShokanHanteiKekkaEntity DbT3036Entity = 償還払支給判定結果.toEntity();
                DbT3036Entity.setState(EntityDataState.Modified);
                償還払支給判定結果Dac.save(DbT3036Entity);
                修正前支給区分 = 支給区分_支給;
            }
            DbT3053ShokanShukeiEntity DbT3053Entity = 償還払集計.toEntity();
            DbT3053Entity.setState(EntityDataState.Modified);
            償還払請求集計Dac.save(DbT3053Entity);
        }
        if (差額金額登録フラグ) {
            for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
                DbT3048ShokanFukushiYoguHanbaihiEntity DbT3048Entity
                        = 償還払請求福祉用具販売費.createBuilderForEdit().set整理番号(整理番号).build().toEntity();
                DbT3048Entity.setState(EntityDataState.Added);
                償還払請求福祉用具販売費Dac.save(DbT3048Entity);
            }
        }
        if (null != 決定日 && !決定日.isEmpty()) {
            ShokanKihon 償還払請求基本Entity = getShokanSeikyuKihon(
                    償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(),
                    償還払請求基本.get整理番号(),
                    償還払請求基本.get事業者番号(),
                    償還払請求基本.get様式番号(),
                    new RString("0001"));
            List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト2 = getShokanFukushiYoguHanbaihi(
                    償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(),
                    償還払請求基本.get整理番号(),
                    償還払請求基本.get事業者番号(),
                    償還払請求基本.get様式番号(),
                    new RString("0001"));
            ShokanShinsei 償還払支給申請entity = getShokanShinsei(
                    償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(),
                    償還払請求基本.get整理番号(),
                    償還払請求基本.get事業者番号(),
                    償還払請求基本.get様式番号(),
                    new RString("0001"));
            ShokanHanteiKekka 償還払支給判定結果entity = getShokanHanteiKekka(
                    償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(),
                    償還払請求基本.get整理番号());
            ShokanShukei 償還払請求集計entity = getShokanShukei(
                    償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(),
                    償還払請求基本.get整理番号(),
                    償還払請求基本.get事業者番号(),
                    償還払請求基本.get様式番号(),
                    new RString("0001"));
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> DbT3048EntityList = new ArrayList<>();
            for (ShokanFukushiYoguHanbaihi entity : 償還払請求福祉用具販売費リスト2) {
                DbT3048EntityList.add(entity.toEntity());
            }
            if (null != 償還払支給判定結果entity
                    && null != 償還払支給判定結果entity.get支給_不支給決定区分()
                    && !償還払支給判定結果entity.get支給_不支給決定区分().isEmpty()) {
                福祉用具購入費支給決定給付実績編集Mgr.dealKyufujisseki(
                        画面モード,
                        識別コード,
                        償還払請求基本Entity.toEntity(),
                        DbT3048EntityList,
                        償還払支給申請entity.toEntity(),
                        償還払支給判定結果entity.toEntity(),
                        償還払請求集計entity.toEntity(),
                        修正前支給区分);
            }
        }
    }

    /**
     * サービス提供年月により、限度額を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return Decimal 限度額
     */
    @Transaction
    public Decimal getShikyuGendogaku(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        ServiceShuruiCode サービス種類コード = null;
        try {
            サービス種類コード = getServiceShuruiCode(被保険者番号, サービス提供年月);
        } catch (NullPointerException e) {
// TODO
        }
        Decimal 限度額 = 上乗せ償還払い給付種類支給限度額Dac.select支給限度単位数(
                サービス種類コード, サービス提供年月);
        if (null == 限度額) {
            限度額 = 償還払い給付種類支給限度額Dac.select支給限度単位数(
                    サービス種類コード, サービス提供年月);
        }
        if (null == 限度額) {
            return Decimal.ZERO;
        }
        return 限度額;
    }

// TODO DBZを依存するので、対応待ち
    /**
     * サービス提供年月により、サービス種類を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return ServiceShuruiCode
     */
    @Transaction
    public ServiceShuruiCode getServiceShuruiCode(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月)
            throws NullPointerException {
        ServiceShuruiCode サービス種類 = new ServiceShuruiCode("");
        requireNonNull(被保険者番号, DbzErrorMessages.入力値が不正.getMessage().toString());
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        IFukushiyoguKonyuhiShikyuGendogakuMapper mapper
                = mapperProvider.create(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
        ServiceShuruiCodeParameter parameter = ServiceShuruiCodeParameter.createParameter(被保険者番号, サービス提供年月);
        Code 要介護認定状態区分コード = mapper.select要介護認定状態区分コード(parameter);
        requireNonNull(要介護認定状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定状態区分コード"));
        if (YokaigoJotaiKubun09.非該当.getコード().equals(要介護認定状態区分コード.value())) {
            // TODO
            throw new NullPointerException();
        }
        if (YokaigoJotaiKubun09.要支援1.getコード().equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要支援2.getコード().equals(要介護認定状態区分コード.value())) {
            サービス種類 = new ServiceShuruiCode("44");
        } else if (YokaigoJotaiKubun09.要介護1.getコード().equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要介護2.getコード().equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要介護3.getコード().equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要介護4.getコード().equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要介護5.getコード().equals(要介護認定状態区分コード.value())) {
            サービス種類 = new ServiceShuruiCode("41");
        }
        return サービス種類;
    }

    /**
     * サービス年月より、保険者リストのデータを取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return GappeiShichoson
     */
    @Transaction
    public List<ShichosonEntity> getHokensyaList(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        ShichosonSecurityJoho 市町村セキュリティ情報
                = 基準月市町村情報Finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        List<ShichosonEntity> resultList = new ArrayList<>();
        if (DonyukeitaiCode.事務単一.getCode().equals(市町村セキュリティ情報.get導入形態コード())) {
            ShichosonEntity entity = new ShichosonEntity();
            entity.set証記載保険者番号(市町村セキュリティ情報.get市町村情報().getShoKisaiHokenshaNo());
            entity.set市町村名称(市町村セキュリティ情報.get市町村情報().getShichosonMeisho());
            resultList.add(entity);
        } else if (DonyukeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード())) {
            IFukushiyoguKonyuhiShikyuGendogakuMapper mapper
                    = mapperProvider.create(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
            ServiceShuruiCodeParameter parameter = ServiceShuruiCodeParameter.createParameter(被保険者番号, サービス提供年月);
            List<ShichosonEntity> entityList = mapper.select措置元市町村データ(parameter);
            if (null == entityList || entityList.isEmpty()) {
                ShichosonEntity entity = new ShichosonEntity();
                entity.set証記載保険者番号(市町村セキュリティ情報.get市町村情報().getShoKisaiHokenshaNo());
                entity.set市町村名称(市町村セキュリティ情報.get市町村情報().getShichosonMeisho());
                resultList.add(entity);
            } else {
                resultList.addAll(entityList);
            }
        }
        return resultList;
    }

    /**
     * 様式番号により、様式名称を取得する。
     *
     * @param 識別番号 識別番号
     * @param サービス年月 サービス年月
     * @return RString 略称
     */
    @Transaction
    public RString getYoshikiName(RString 識別番号, FlexibleYearMonth サービス年月) {
        RString 略称 = this.識別番号管理Dac.select略称(
                識別番号,
                サービス年月,
                ShikibetsuNoKubon.入力識別番号.getコード());
        if (null == 略称) {
            return RString.EMPTY;
        }
        return 略称;
    }

    /**
     * 福祉用具購入費支給限度額判定
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 今回の保険対象費用額
     * @return
     */
    public boolean chkKonyuhiShikyuGendogaku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号, Decimal 今回の保険対象費用額) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        boolean flag = false;
        Decimal 支給限度額 = getShikyuGendogaku(被保険者番号, サービス提供年月);
        SokanbaraiShiharaiKekka entity = getShokanShiharaiKekkaAll(被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号);
        Decimal 今までの保険者対象費用額 = entity.get保険対象費用額();
        Decimal 今回登録済みの保険対象費用額 = new Decimal("");
        if (null == 整理番号) {

        } else {
            今回登録済みの保険対象費用額 = entity.get保険対象費用額();
        }
        Decimal 前回までの保険対象費用額 = 今までの保険者対象費用額.subtract(今回登録済みの保険対象費用額);
        Decimal 保険対象費用額 = 前回までの保険対象費用額.multiply(2).add(今回の保険対象費用額);
        if (保険対象費用額.doubleValue() <= 支給限度額.doubleValue()) {
            flag = true;
        }
        return flag;

    }
}
