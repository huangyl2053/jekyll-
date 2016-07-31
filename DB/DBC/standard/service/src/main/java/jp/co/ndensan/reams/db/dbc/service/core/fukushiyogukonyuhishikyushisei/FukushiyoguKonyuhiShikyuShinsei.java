/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiYoguKonyuhiShikyuShiseiKetteDivEntity;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.ShichosonResult;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoShokan3Keta;
import jp.co.ndensan.reams.db.dbc.definition.core.shikibetsunokubon.ShikibetsuNoKubon;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ServiceShuruiCodeParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShibaraiKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShokanShikyuShinseiParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.syokanbaraikettejoho.SyokanbaraiketteJohoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.ShichosonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekka;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3048ShokanFukushiYoguHanbaihiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7112ShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.konyuhishikyushisei.IFukushiyoguKonyuhiShikyuGendogakuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 福祉用具購入費支給申請のビジネスです。
 *
 * @reamsid_L DBC-1020-040 zhangrui
 */
public class FukushiyoguKonyuhiShikyuShinsei {

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
    private final FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu 福祉用具購入費支給決定給付実績編集Mgr;

    private static final RString 状態_登録 = new RString("登録");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 支給区分_支給 = new RString("1");
    private static final RString 支給区分_不支給 = new RString("0");
    private static final RString メッセージ_集計 = new RString("償還払請求集計");
    private static final RString メッセージ_販売費 = new RString("償還払請求福祉用具販売費");
    private static final RString MEISAINO_0001 = new RString("0001");
    private static final ServiceShuruiCode SERVICECODE_44 = new ServiceShuruiCode("44");
    private static final ServiceShuruiCode SERVICECODE_41 = new ServiceShuruiCode("41");
    private static final RString MSG_NAME_HIHOKENSHANO = new RString("被保険者番号");
    private static final RString MSG_NAME_SERVICETEIKYOYM = new RString("サービス提供年月");

    /**
     * コンストラクタです。
     */
    public FukushiyoguKonyuhiShikyuShinsei() {
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
                = InstanceProvider.create(FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu.class);
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return
     * {@link InstanceProvider#create}により生成された{@link FukushiyoguKonyuhiShikyuShinsei}
     */
    public static FukushiyoguKonyuhiShikyuShinsei createInstance() {
        return InstanceProvider.create(FukushiyoguKonyuhiShikyuShinsei.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 福祉用具購入費支給決定給付実績編集Mgr 福祉用具購入費支給決定給付実績編集Mgr
     * @param 基準月市町村情報Finder 基準月市町村情報Finder
     */
    FukushiyoguKonyuhiShikyuShinsei(
            MapperProvider mapperProvider,
            FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu 福祉用具購入費支給決定給付実績編集Mgr,
            ShichosonSecurityJohoFinder 基準月市町村情報Finder
    ) {
        this.mapperProvider = mapperProvider;
        this.上乗せ償還払い給付種類支給限度額Dac = InstanceProvider.create(
                DbT7115UwanoseShokanShuruiShikyuGendoGakuDac.class);
        this.償還払い給付種類支給限度額Dac = InstanceProvider.create(DbT7112ShokanShuruiShikyuGendoGakuDac.class);
        this.償還払請求基本Dac = InstanceProvider.create(DbT3038ShokanKihonDac.class);
        this.償還払請求福祉用具販売費Dac = InstanceProvider.create(DbT3048ShokanFukushiYoguHanbaihiDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.福祉用具購入費支給決定給付実績編集Mgr = 福祉用具購入費支給決定給付実績編集Mgr;
        this.基準月市町村情報Finder = 基準月市町村情報Finder;
    }

    /**
     * 被保険者より、福祉用具購入費支給申請一覧のデータを取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<FukushiyouguKonyuhiShikyuShinseiResult>
     */
    @Transaction
    public List<FukushiyouguKonyuhiShikyuShinseiResult> getShokanShikyuShinseiList(HihokenshaNo 被保険者番号) {
        IFukushiyoguKonyuhiShikyuGendogakuMapper mapper
                = mapperProvider.create(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
        ShokanShikyuShinseiParameter parameter
                = ShokanShikyuShinseiParameter.createParameter(被保険者番号,
                        NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.getコード());
        List<FukushiyouguKonyuhiShikyuShinsei> shokanShikyuShinseiList
                = mapper.select支給申請一覧(parameter);
        List<FukushiyouguKonyuhiShikyuShinseiResult> resuktList = new ArrayList<>();
        if (null == shokanShikyuShinseiList) {
            return resuktList;
        }
        for (FukushiyouguKonyuhiShikyuShinsei entity : shokanShikyuShinseiList) {
            resuktList.add(new FukushiyouguKonyuhiShikyuShinseiResult(entity));
        }
        return resuktList;
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
     * @return ShokanShinsei 償還払支給申請Entity
     */
    @Transaction
    public ShokanShinsei getShokanShinsei(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
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

    /**
     * 償還払請求基本のキーより、該当する償還払請求集計を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return ShokanHanteiKekka 償還払支給判定結果Entity
     */
    @Transaction
    public ShokanShukei getShokanShukei(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        SyokanbaraiketteJohoParameter parameter = SyokanbaraiketteJohoParameter.createMybatisParam(
                被保険者番号, サービス提供年月, 整理番号);
        DbT3053ShokanShukeiEntity entity = 償還払請求集計Dac.select償還払請求集計(parameter);

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
     * @return SokanbaraiShiharaiKekkaResult 償還払支払結果Entity
     * @throws ApplicationException 引数のいずれかがnullの場合
     */
    @Transaction
    public SokanbaraiShiharaiKekkaResult getShokanShiharaiKekkaAll(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月)
            throws ApplicationException {
        if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
            throw new ApplicationException(
                    UrErrorMessages.未指定.getMessage().replace(MSG_NAME_HIHOKENSHANO.toString()));
        }
        if (null == サービス提供年月 || サービス提供年月.isEmpty()) {
            throw new ApplicationException(
                    UrErrorMessages.未指定.getMessage().replace(MSG_NAME_SERVICETEIKYOYM.toString()));
        }
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
        return new SokanbaraiShiharaiKekkaResult(result);
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
     * @throws ApplicationException 引数のいずれかがnullの場合
     * @return SokanbaraiShiharaiKekkaResult 償還払支払結果Entity
     */
    @Transaction
    public SokanbaraiShiharaiKekkaResult getShokanShiharaiKekka(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号)
            throws ApplicationException {
        if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
            throw new ApplicationException(
                    UrErrorMessages.未指定.getMessage().replace(MSG_NAME_HIHOKENSHANO.toString()));
        }
        if (null == サービス提供年月 || サービス提供年月.isEmpty()) {
            throw new ApplicationException(
                    UrErrorMessages.未指定.getMessage().replace(MSG_NAME_SERVICETEIKYOYM.toString()));
        }
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
            return new SokanbaraiShiharaiKekkaResult(result);
        }
        entity.initializeMd5();
        ShokanShinsei 償還払支給申請 = new ShokanShinsei(entity);
        result.set保険対象費用額(償還払支給申請.get保険対象費用額());
        result.set保険給付額(償還払支給申請.get保険給付額());
        result.set利用者負担額(償還払支給申請.get利用者負担額());
        result.set費用額合計(償還払支給申請.get支払金額合計());
        return new SokanbaraiShiharaiKekkaResult(result);
    }

    /**
     * 画面のデータをＤＢに追加する。
     *
     * @param 福祉用具購入費支給申請明細登録画面 福祉用具購入費支給申請明細登録画面
     */
    @Transaction
    public void insert(FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity 福祉用具購入費支給申請明細登録画面) {
        RString 整理番号 = 福祉用具購入費支給申請明細登録画面.get償還払請求基本().get整理番号();
        DbT3038ShokanKihonEntity dbT3038Entity
                = 福祉用具購入費支給申請明細登録画面.get償還払請求基本().createBuilderForEdit().
                set整理番号(整理番号).build().toEntity();
        dbT3038Entity.setState(EntityDataState.Added);
        償還払請求基本Dac.save(dbT3038Entity);
        for (ShokanFukushiYoguHanbaihi 登録福祉用具販売費
                : 福祉用具購入費支給申請明細登録画面.get登録福祉用具販売費リスト()) {
            DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity
                    = 登録福祉用具販売費.createBuilderForEdit().set整理番号(整理番号).build().toEntity();
            dbT3048Entity.setState(EntityDataState.Added);
            償還払請求福祉用具販売費Dac.save(dbT3048Entity);
        }
        DbT3034ShokanShinseiEntity dbT3034Entity
                = 福祉用具購入費支給申請明細登録画面.get償還払支給申請().createBuilderForEdit().
                set整理番号(整理番号).build().toEntity();
        dbT3034Entity.setState(EntityDataState.Added);
        償還払支給申請Dac.save(dbT3034Entity);
        DbT3053ShokanShukeiEntity dbT3053Entity
                = 福祉用具購入費支給申請明細登録画面.get償還払集計().createBuilderForEdit().
                set整理番号(整理番号).build().toEntity();
        dbT3053Entity.setState(EntityDataState.Added);
        償還払請求集計Dac.save(dbT3053Entity);
    }

    /**
     * 画面のデータを更新する。
     *
     * @param 福祉用具購入費支給申請明細登録画面 福祉用具購入費支給申請明細登録画面
     */
    @Transaction
    public void update(FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity 福祉用具購入費支給申請明細登録画面) {
        int 登録数 = 0;
        int 最大枝番;
        DbT3038ShokanKihonEntity dbT3038Entity
                = 福祉用具購入費支給申請明細登録画面.get償還払請求基本().toEntity();
        dbT3038Entity.setState(EntityDataState.Modified);
        償還払請求基本Dac.save(dbT3038Entity);
        List<DbT3048ShokanFukushiYoguHanbaihiEntity> dbT3048EntityList = new ArrayList<>();
        DbT3048ShokanFukushiYoguHanbaihiEntity max連番 = 償還払請求福祉用具販売費Dac.getMAX連番(
                福祉用具購入費支給申請明細登録画面.get被保険者番号(),
                福祉用具購入費支給申請明細登録画面.get提供_購入_年月(),
                福祉用具購入費支給申請明細登録画面.get整理番号(),
                福祉用具購入費支給申請明細登録画面.get事業者番号(),
                福祉用具購入費支給申請明細登録画面.get証明書コード(),
                福祉用具購入費支給申請明細登録画面.get明細番号());
        if (null == max連番) {
            最大枝番 = 1;
        } else {
            最大枝番 = Integer.valueOf(max連番.getRenban().toString()) + 1;
        }
        for (ShokanFukushiYoguHanbaihi 登録福祉用具販売費
                : 福祉用具購入費支給申請明細登録画面.get登録福祉用具販売費リスト()) {
            DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity
                    = 登録福祉用具販売費.createBuilderForEdit().set連番(
                            new RString(String.format("%02d", 最大枝番 + 登録数))).build().toEntity();
            dbT3048Entity.setState(EntityDataState.Added);
            dbT3048EntityList.add(dbT3048Entity);
            償還払請求福祉用具販売費Dac.save(dbT3048Entity);
        }
        for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費
                : 福祉用具購入費支給申請明細登録画面.get修正福祉用具販売費リスト()) {
            DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity = 償還払請求福祉用具販売費.toEntity();
            dbT3048Entity.setState(EntityDataState.Modified);
            dbT3048EntityList.add(dbT3048Entity);
            償還払請求福祉用具販売費Dac.save(dbT3048Entity);
        }
        for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費
                : 福祉用具購入費支給申請明細登録画面.get削除福祉用具販売費リスト()) {
            DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity = 償還払請求福祉用具販売費.toEntity();
            dbT3048Entity.setState(EntityDataState.Deleted);
            dbT3048EntityList.add(dbT3048Entity);
            償還払請求福祉用具販売費Dac.delete(dbT3048Entity);
        }

        DbT3034ShokanShinseiEntity dbT3034Entity = 福祉用具購入費支給申請明細登録画面.get償還払支給申請().toEntity();
        dbT3034Entity.setState(EntityDataState.Modified);
        償還払支給申請Dac.save(dbT3034Entity);
        ShokanHanteiKekka 償還払支給判定結果entity = 福祉用具購入費支給申請明細登録画面.get償還払支給判定結果();
        if (null != 償還払支給判定結果entity) {
            DbT3036ShokanHanteiKekkaEntity dbT3036Entity = 償還払支給判定結果entity.toEntity();
            int データ数 = 償還払支給判定結果Dac.getCountByKey(
                    償還払支給判定結果entity.get被保険者番号(),
                    償還払支給判定結果entity.getサービス提供年月(),
                    償還払支給判定結果entity.get整理番号());
            if (0 == データ数) {
                dbT3036Entity.setState(EntityDataState.Added);
            } else {
                dbT3036Entity.setState(EntityDataState.Modified);
            }
            償還払支給判定結果Dac.save(dbT3036Entity);
        }

        DbT3053ShokanShukeiEntity dbT3053Entity = 福祉用具購入費支給申請明細登録画面.get償還払集計().toEntity();
        dbT3053Entity.setState(EntityDataState.Modified);
        償還払請求集計Dac.save(dbT3053Entity);
        if (null != 償還払支給判定結果entity) {
            福祉用具購入費支給決定給付実績編集Mgr.dealKyufujisseki(
                    状態_登録,
                    福祉用具購入費支給申請明細登録画面.get識別コード(),
                    dbT3038Entity,
                    dbT3048EntityList,
                    dbT3034Entity,
                    償還払支給判定結果entity.toEntity(),
                    dbT3053Entity,
                    福祉用具購入費支給申請明細登録画面.get支給区分());
        }
    }

    /**
     * 画面のデータを削除する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 識別コード ShikibetsuCode
     */
    @Transaction
    public void delete(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            ShikibetsuCode 識別コード) {
        ShokanKihon 償還払請求基本Entity = getShokanSeikyuKihon(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, MEISAINO_0001);
        List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト = getShokanFukushiYoguHanbaihi(
                被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, MEISAINO_0001);
        ShokanShinsei 償還払支給申請entity = getShokanShinsei(
                被保険者番号, サービス提供年月, 整理番号);
        ShokanHanteiKekka 償還払支給判定結果entity = getShokanHanteiKekka(
                被保険者番号, サービス提供年月, 整理番号);
        ShokanShukei 償還払請求集計entity = getShokanShukei(
                被保険者番号, サービス提供年月, 整理番号);
        DbT3038ShokanKihonEntity dbT3038Entity = 償還払請求基本Entity.toEntity();
        dbT3038Entity.setState(EntityDataState.Deleted);
        償還払請求基本Dac.delete(dbT3038Entity);
        List<DbT3048ShokanFukushiYoguHanbaihiEntity> dbT3048EntityList = new ArrayList<>();
        for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費 : 償還払請求福祉用具販売費リスト) {
            dbT3048EntityList.add(償還払請求福祉用具販売費.toEntity());
            DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity = 償還払請求福祉用具販売費.toEntity();
            dbT3048Entity.setState(EntityDataState.Deleted);
            償還払請求福祉用具販売費Dac.delete(dbT3048Entity);
        }
        DbT3034ShokanShinseiEntity dbT3034Entity = 償還払支給申請entity.toEntity();
        dbT3034Entity.setState(EntityDataState.Deleted);
        償還払支給申請Dac.delete(dbT3034Entity);

        if (null != 償還払支給判定結果entity) {
            DbT3036ShokanHanteiKekkaEntity dbT3036Entity = 償還払支給判定結果entity.toEntity();
            dbT3036Entity.setState(EntityDataState.Deleted);
            償還払支給判定結果Dac.delete(dbT3036Entity);
        }

        DbT3053ShokanShukeiEntity dbT3053Entity = 償還払請求集計entity.toEntity();
        dbT3053Entity.setState(EntityDataState.Deleted);
        償還払請求集計Dac.delete(dbT3053Entity);

        if (null != 償還払支給判定結果entity) {
            福祉用具購入費支給決定給付実績編集Mgr.dealKyufujisseki(
                    状態_削除, 識別コード, 償還払請求基本Entity.toEntity(),
                    dbT3048EntityList, 償還払支給申請entity.toEntity(), 償還払支給判定結果entity.toEntity(),
                    償還払請求集計entity.toEntity(), null);
        }
    }

    /**
     * 審査モードの時、ＤＢ保存処理を行う。
     *
     * @param 福祉用具購入費支給申請明細登録画面 福祉用具購入費支給申請明細登録画面
     */
    @Transaction
    public void updShinsa(FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity 福祉用具購入費支給申請明細登録画面) {
        int 登録数 = 0;
        int 最大枝番;
        DbT3038ShokanKihonEntity dbT3038Entity = 福祉用具購入費支給申請明細登録画面.get償還払請求基本().toEntity();
        dbT3038Entity.setState(EntityDataState.Modified);
        償還払請求基本Dac.save(dbT3038Entity);
        List<DbT3048ShokanFukushiYoguHanbaihiEntity> dbT3048EntityList = new ArrayList<>();
        DbT3048ShokanFukushiYoguHanbaihiEntity max連番 = 償還払請求福祉用具販売費Dac.getMAX連番(
                福祉用具購入費支給申請明細登録画面.get被保険者番号(),
                福祉用具購入費支給申請明細登録画面.get提供_購入_年月(),
                福祉用具購入費支給申請明細登録画面.get整理番号(),
                福祉用具購入費支給申請明細登録画面.get事業者番号(),
                福祉用具購入費支給申請明細登録画面.get証明書コード(),
                福祉用具購入費支給申請明細登録画面.get明細番号());
        if (null == max連番) {
            最大枝番 = 1;
        } else {
            最大枝番 = Integer.valueOf(max連番.getRenban().toString()) + 1;
        }
        for (ShokanFukushiYoguHanbaihi 登録福祉用具販売費
                : 福祉用具購入費支給申請明細登録画面.get登録福祉用具販売費リスト()) {
            DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity
                    = 登録福祉用具販売費.createBuilderForEdit().set連番(
                            new RString(String.format("%02d", 最大枝番 + 登録数))).build().toEntity();
            dbT3048Entity.setState(EntityDataState.Added);
            dbT3048EntityList.add(dbT3048Entity);
            償還払請求福祉用具販売費Dac.save(dbT3048Entity);
        }
        for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費
                : 福祉用具購入費支給申請明細登録画面.get修正福祉用具販売費リスト()) {
            DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity = 償還払請求福祉用具販売費.toEntity();
            dbT3048Entity.setState(EntityDataState.Modified);
            dbT3048EntityList.add(dbT3048Entity);
            償還払請求福祉用具販売費Dac.save(dbT3048Entity);
        }
        for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費
                : 福祉用具購入費支給申請明細登録画面.get削除福祉用具販売費リスト()) {
            DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity = 償還払請求福祉用具販売費.toEntity();
            dbT3048Entity.setState(EntityDataState.Deleted);
            dbT3048EntityList.add(dbT3048Entity);
            償還払請求福祉用具販売費Dac.delete(dbT3048Entity);
        }

        DbT3034ShokanShinseiEntity dbT3034Entity = 福祉用具購入費支給申請明細登録画面.get償還払支給申請().toEntity();
        dbT3034Entity.setState(EntityDataState.Modified);
        償還払支給申請Dac.save(dbT3034Entity);
        ShokanHanteiKekka 償還払支給判定結果 = 福祉用具購入費支給申請明細登録画面.get償還払支給判定結果();
        if (null != 償還払支給判定結果) {
            DbT3036ShokanHanteiKekkaEntity dbT3036Entity = 償還払支給判定結果.toEntity();
            if (ShinsaNaiyoKubun.承認する.getコード().equals(福祉用具購入費支給申請明細登録画面.get審査結果())) {
                dbT3036Entity = 償還払支給判定結果.createBuilderForEdit().
                        set支給_不支給決定区分(支給区分_支給).
                        set決定年月日(FlexibleDate.getNowDate()).
                        build().toEntity();
            } else if (ShinsaNaiyoKubun.却下する.getコード().equals(福祉用具購入費支給申請明細登録画面.get審査結果())) {
                dbT3036Entity = 償還払支給判定結果.createBuilderForEdit().
                        set支給_不支給決定区分(支給区分_不支給).
                        set決定年月日(FlexibleDate.getNowDate()).
                        build().toEntity();
            }
            int データ数 = 償還払支給判定結果Dac.getCountByKey(
                    償還払支給判定結果.get被保険者番号(),
                    償還払支給判定結果.getサービス提供年月(),
                    償還払支給判定結果.get整理番号());
            if (0 == データ数) {
                dbT3036Entity.setState(EntityDataState.Added);
            } else {
                dbT3036Entity.setState(EntityDataState.Modified);
            }
            償還払支給判定結果Dac.save(dbT3036Entity);
        }

        DbT3053ShokanShukeiEntity dbT3053Entity = 福祉用具購入費支給申請明細登録画面.get償還払集計().toEntity();
        dbT3053Entity.setState(EntityDataState.Modified);
        償還払請求集計Dac.save(dbT3053Entity);
        if (null != 償還払支給判定結果) {
            福祉用具購入費支給決定給付実績編集Mgr.dealKyufujisseki(
                    状態_登録,
                    福祉用具購入費支給申請明細登録画面.get識別コード(),
                    dbT3038Entity,
                    dbT3048EntityList,
                    dbT3034Entity,
                    償還払支給判定結果.toEntity(),
                    dbT3053Entity,
                    null);
        }
    }

    /**
     * 決定情報の登録更新処理を行う。
     *
     * @param 福祉用具購入費支給申請決定情報画面 福祉用具購入費支給申請決定情報画面
     */
    @Transaction
    public void updKetteJoho(FukushiYoguKonyuhiShikyuShiseiKetteDivEntity 福祉用具購入費支給申請決定情報画面) {
        RString 修正前支給区分 = RString.EMPTY;
        if (null != 福祉用具購入費支給申請決定情報画面.get決定日()
                && !福祉用具購入費支給申請決定情報画面.get決定日().isEmpty()) {
            int データ件数 = 償還払支給判定結果Dac.getCountByKey(福祉用具購入費支給申請決定情報画面.get被保険者番号(),
                    福祉用具購入費支給申請決定情報画面.get提供_購入_年月(), 福祉用具購入費支給申請決定情報画面.get整理番号());
            if (データ件数 == 0) {
                DbT3034ShokanShinseiEntity dbT3034Entity = 償還払支給申請Dac.selectByKey(
                        福祉用具購入費支給申請決定情報画面.get被保険者番号(), 福祉用具購入費支給申請決定情報画面.get提供_購入_年月(),
                        福祉用具購入費支給申請決定情報画面.get整理番号());
                DbT3036ShokanHanteiKekkaEntity dbT3036Entity
                        = new DbT3036ShokanHanteiKekkaEntity();
                dbT3036Entity.setHiHokenshaNo(福祉用具購入費支給申請決定情報画面.get被保険者番号());
                dbT3036Entity.setServiceTeikyoYM(福祉用具購入費支給申請決定情報画面.get提供_購入_年月());
                dbT3036Entity.setSeiriNo(福祉用具購入費支給申請決定情報画面.get整理番号());
                dbT3036Entity.setKetteiYMD(福祉用具購入費支給申請決定情報画面.get償還払支給判定結果().get決定年月日());
                dbT3036Entity.setShikyuHushikyuKetteiKubun(福祉用具購入費支給申請決定情報画面.get償還払支給判定結果().get支給_不支給決定区分());
                dbT3036Entity.setShiharaiKingaku(福祉用具購入費支給申請決定情報画面.get償還払支給判定結果().get支払金額());
                dbT3036Entity.setShoKisaiHokenshaNo(dbT3034Entity.getShoKisaiHokenshaNo());
                dbT3036Entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(dbT3036Entity);
                修正前支給区分 = 支給区分_不支給;
            } else {
                DbT3036ShokanHanteiKekkaEntity データ = 償還払支給判定結果Dac.selectByKey(
                        福祉用具購入費支給申請決定情報画面.get被保険者番号(),
                        福祉用具購入費支給申請決定情報画面.get提供_購入_年月(),
                        福祉用具購入費支給申請決定情報画面.get整理番号());
                データ.setKetteiYMD(福祉用具購入費支給申請決定情報画面.get償還払支給判定結果().get決定年月日());
                データ.setShikyuHushikyuKetteiKubun(福祉用具購入費支給申請決定情報画面.get償還払支給判定結果().
                        get支給_不支給決定区分());
                データ.setShiharaiKingaku(福祉用具購入費支給申請決定情報画面.get償還払支給判定結果().get支払金額());
                データ.setState(EntityDataState.Modified);
                償還払支給判定結果Dac.save(データ);
                修正前支給区分 = データ.getShikyuHushikyuKetteiKubun();
            }
            SyokanbaraiketteJohoParameter parameter = SyokanbaraiketteJohoParameter.createMybatisParam(
                    福祉用具購入費支給申請決定情報画面.get償還払集計().get被保険者番号(),
                    福祉用具購入費支給申請決定情報画面.get償還払集計().getサービス提供年月(),
                    福祉用具購入費支給申請決定情報画面.get償還払集計().get整理番号()
            );
            DbT3053ShokanShukeiEntity dbT3053Entity = 償還払請求集計Dac.select償還払請求集計(parameter);
            if (null != dbT3053Entity) {
                dbT3053Entity.setShinsaYM(福祉用具購入費支給申請決定情報画面.get決定日().getYearMonth());
                dbT3053Entity.setShikyuKubunCode(福祉用具購入費支給申請決定情報画面.get償還払集計().get支給区分コード());
                dbT3053Entity.setShikyuKingaku(福祉用具購入費支給申請決定情報画面.get償還払集計().get支払金額());
                dbT3053Entity.setZougenten(福祉用具購入費支給申請決定情報画面.get償還払集計().get増減点());
                dbT3053Entity.setSeikyugakuSagakuKingaku(福祉用具購入費支給申請決定情報画面.get償還払集計().get請求額差額金額());
                dbT3053Entity.setZougenRiyu(福祉用具購入費支給申請決定情報画面.get償還払集計().get増減理由等());
                dbT3053Entity.setHushikyuRiyu(福祉用具購入費支給申請決定情報画面.get償還払集計().get不支給理由等());
                dbT3053Entity.setKounyuKaishuRireki(福祉用具購入費支給申請決定情報画面.get償還払集計().get購入_改修履歴等());
                dbT3053Entity.setState(EntityDataState.Modified);
                償還払請求集計Dac.save(dbT3053Entity);
            } else {
                throw new ApplicationException(UrErrorMessages.更新に失敗.getMessage().replace(メッセージ_集計.toString()));
            }
        }
        if (!福祉用具購入費支給申請決定情報画面.is差額金額登録フラグ()) {
            for (ShokanFukushiYoguHanbaihi 償還払請求福祉用具販売費
                    : 福祉用具購入費支給申請決定情報画面.get修正福祉用具販売費リスト()) {
                DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity
                        = 償還払請求福祉用具販売費Dac.selectByKey(
                                償還払請求福祉用具販売費.get被保険者番号(), 償還払請求福祉用具販売費.getサービス提供年月(),
                                償還払請求福祉用具販売費.get整理番号(), 償還払請求福祉用具販売費.get事業者番号(),
                                償還払請求福祉用具販売費.get様式番号(), 償還払請求福祉用具販売費.get明細番号(),
                                償還払請求福祉用具販売費.get連番());
                if (null != dbT3048Entity) {
                    dbT3048Entity.setSagakuKingaku(償還払請求福祉用具販売費.get差額金額());
                    dbT3048Entity.setState(EntityDataState.Modified);
                    償還払請求福祉用具販売費Dac.save(dbT3048Entity);
                } else {
                    throw new ApplicationException(UrErrorMessages.更新に失敗.getMessage().replace(メッセージ_販売費.toString()));
                }
            }
        }
        if (null != 福祉用具購入費支給申請決定情報画面.get決定日()
                && !福祉用具購入費支給申請決定情報画面.get決定日().isEmpty()) {
            ShokanKihon 償還払請求基本Entity = getShokanSeikyuKihon(
                    福祉用具購入費支給申請決定情報画面.get被保険者番号(),
                    福祉用具購入費支給申請決定情報画面.get提供_購入_年月(),
                    福祉用具購入費支給申請決定情報画面.get整理番号(),
                    福祉用具購入費支給申請決定情報画面.get事業者番号(),
                    福祉用具購入費支給申請決定情報画面.get証明書コード(),
                    MEISAINO_0001);
            List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト2 = getShokanFukushiYoguHanbaihi(
                    福祉用具購入費支給申請決定情報画面.get被保険者番号(),
                    福祉用具購入費支給申請決定情報画面.get提供_購入_年月(),
                    福祉用具購入費支給申請決定情報画面.get整理番号(),
                    福祉用具購入費支給申請決定情報画面.get事業者番号(),
                    福祉用具購入費支給申請決定情報画面.get証明書コード(),
                    MEISAINO_0001);
            ShokanShinsei 償還払支給申請entity = getShokanShinsei(
                    福祉用具購入費支給申請決定情報画面.get被保険者番号(),
                    福祉用具購入費支給申請決定情報画面.get提供_購入_年月(),
                    福祉用具購入費支給申請決定情報画面.get整理番号());
            ShokanHanteiKekka 償還払支給判定結果entity = getShokanHanteiKekka(
                    福祉用具購入費支給申請決定情報画面.get被保険者番号(),
                    福祉用具購入費支給申請決定情報画面.get提供_購入_年月(),
                    福祉用具購入費支給申請決定情報画面.get整理番号());
            ShokanShukei 償還払請求集計entity = getShokanShukei(
                    福祉用具購入費支給申請決定情報画面.get被保険者番号(),
                    福祉用具購入費支給申請決定情報画面.get提供_購入_年月(),
                    福祉用具購入費支給申請決定情報画面.get整理番号());
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> dbT3048EntityList = new ArrayList<>();
            for (ShokanFukushiYoguHanbaihi entity : 償還払請求福祉用具販売費リスト2) {
                dbT3048EntityList.add(entity.toEntity());
            }

            if (null != 償還払支給判定結果entity && null != 償還払支給判定結果entity.get支給_不支給決定区分()
                    && !償還払支給判定結果entity.get支給_不支給決定区分().isEmpty()) {
                福祉用具購入費支給決定給付実績編集Mgr.dealKyufujisseki(
                        福祉用具購入費支給申請決定情報画面.get画面モード(),
                        福祉用具購入費支給申請決定情報画面.get識別コード(),
                        償還払請求基本Entity.toEntity(), dbT3048EntityList, 償還払支給申請entity.toEntity(),
                        償還払支給判定結果entity.toEntity(), 償還払請求集計entity.toEntity(), 修正前支給区分);
            }
        }
    }

    /**
     * サービス提供年月により、限度額を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return Decimal 限度額
     * @throws ApplicationException サービス種類コードが取得できない場合
     */
    @Transaction
    public Decimal getShikyuGendogaku(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月)
            throws ApplicationException {
        ServiceShuruiCode サービス種類コード = getServiceShuruiCode(被保険者番号, サービス提供年月);
        DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity dbT7115Entity
                = 上乗せ償還払い給付種類支給限度額Dac.select支給限度単位数(サービス種類コード, サービス提供年月);
        if (null != dbT7115Entity && null != dbT7115Entity.getShikyuGendoTaniSu()) {
            return dbT7115Entity.getShikyuGendoTaniSu();
        }
        DbT7112ShokanShuruiShikyuGendoGakuEntity dbT7112Entity = 償還払い給付種類支給限度額Dac.select支給限度単位数(
                サービス種類コード, サービス提供年月);
        if (null != dbT7112Entity && null != dbT7112Entity.getShikyuGendoTaniSu()) {
            return dbT7112Entity.getShikyuGendoTaniSu();
        }
        return Decimal.ZERO;
    }

    /**
     * サービス提供年月により、サービス種類を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return ServiceShuruiCode
     * @throws ApplicationException 引数のいずれかがnullの場合
     */
    @Transaction
    public ServiceShuruiCode getServiceShuruiCode(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月)
            throws ApplicationException {
        if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
            throw new ApplicationException(
                    UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace(MSG_NAME_HIHOKENSHANO.toString()));
        }
        if (null == サービス提供年月 || サービス提供年月.isEmpty()) {
            throw new ApplicationException(
                    UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace(MSG_NAME_SERVICETEIKYOYM.toString()));
        }
        ServiceShuruiCode サービス種類 = new ServiceShuruiCode("");
        IFukushiyoguKonyuhiShikyuGendogakuMapper mapper
                = mapperProvider.create(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
        ServiceShuruiCodeParameter parameter = ServiceShuruiCodeParameter.createParameter(被保険者番号, サービス提供年月);
        Code 要介護認定状態区分コード = mapper.select要介護認定状態区分コード(parameter);

        if (null == 要介護認定状態区分コード) {
            throw new ApplicationException(
                    UrErrorMessages.未指定.getMessage().replace("要介護認定状態区分"));
        }
        if (YokaigoJotaiKubun09.非該当.getコード()
                .equals(要介護認定状態区分コード.value())) {
            throw new ApplicationException(
                    UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().replace("要介護認定状態区分コード"));
        }

        if (YokaigoJotaiKubun09.要支援1.getコード()
                .equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要支援2.getコード().equals(要介護認定状態区分コード.value())) {
            サービス種類 = SERVICECODE_44;
        } else if (YokaigoJotaiKubun09.要介護1.getコード()
                .equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要介護2.getコード().equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要介護3.getコード().equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要介護4.getコード().equals(要介護認定状態区分コード.value())
                || YokaigoJotaiKubun09.要介護5.getコード().equals(要介護認定状態区分コード.value())) {
            サービス種類 = SERVICECODE_41;
        }
        return サービス種類;
    }

    /**
     * サービス年月より、保険者リストのデータを取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return List<ShichosonResult>
     * @throws ApplicationException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<ShichosonResult> getHokensyaList(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月)
            throws ApplicationException {
        if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                    replace(MSG_NAME_HIHOKENSHANO.toString()));
        }
        if (null == サービス提供年月 || サービス提供年月.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage().
                    replace(MSG_NAME_SERVICETEIKYOYM.toString()));
        }
        ShichosonSecurityJoho 市町村セキュリティ情報
                = 基準月市町村情報Finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        List<ShichosonResult> resultList = new ArrayList<>();
        if (null != 市町村セキュリティ情報 && DonyuKeitaiCode.事務単一.equals(市町村セキュリティ情報.get導入形態コード())) {
            ShichosonEntity entity = new ShichosonEntity();
            entity.set証記載保険者番号(市町村セキュリティ情報.get市町村情報().get証記載保険者番号());
            entity.set市町村名称(市町村セキュリティ情報.get市町村情報().get市町村名());
            resultList.add(new ShichosonResult(entity));
        } else if (null != 市町村セキュリティ情報
                && (DonyuKeitaiCode.事務広域.equals(市町村セキュリティ情報.get導入形態コード())
                || DonyuKeitaiCode.事務構成市町村.equals(市町村セキュリティ情報.get導入形態コード()))) {
            IFukushiyoguKonyuhiShikyuGendogakuMapper mapper
                    = mapperProvider.create(IFukushiyoguKonyuhiShikyuGendogakuMapper.class);
            ServiceShuruiCodeParameter parameter
                    = ServiceShuruiCodeParameter.createParameter(被保険者番号, サービス提供年月);
            List<ShichosonEntity> entityList = mapper.select措置元市町村データ(parameter);
            if (null == entityList) {
                ShichosonEntity entity = new ShichosonEntity();
                entity.set証記載保険者番号(市町村セキュリティ情報.get市町村情報().get証記載保険者番号());
                entity.set市町村名称(市町村セキュリティ情報.get市町村情報().get市町村名());
                resultList.add(new ShichosonResult(entity));
            } else {
                for (ShichosonEntity entity : entityList) {
                    resultList.add(new ShichosonResult(entity));
                }
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
        DbT3118ShikibetsuNoKanriEntity dbT3118Entity = this.識別番号管理Dac.select略称(
                識別番号,
                サービス年月,
                ShikibetsuNoKubon.入力識別番号.getコード());
        if (null == dbT3118Entity) {
            return RString.EMPTY;
        }
        return dbT3118Entity.getRyakusho();
    }

    /**
     * 給付実績基本情報リスト取得
     *
     * @param 様式番号 様式番号
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 給付実績区分コード 給付実績区分コード
     * @return List<KyufujissekiKihon>
     */
    public List<KyufujissekiKihon> getKyufuJissekiKihonList(RString 様式番号, HokenshaNo 保険者番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号, RString 給付実績区分コード) {
        return JutakukaishuSikyuShinseiManager.createInstance().getKyufuJissekiKihonList(
                様式番号, 保険者番号, 被保険者番号, サービス提供年月, 整理番号, 給付実績区分コード);
    }
}
