/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraishikyukettekyufujssekihensyu.SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraishikyukettekyufujssekihensyu.DealKyufujissekiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3017KyufujissekiKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3026KyufujissekiFukushiYoguHanbaihiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3033KyufujissekiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraishikyukettekyufujssekihensyu.ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 福祉用具購入費支給決定給付実績編集
 *
 * @reamsid_L DBC-1020-050 chenaoqi
 */
public class FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private final DbT3017KyufujissekiKihonDac 給付実績基本Dac;
    private final DbT3026KyufujissekiFukushiYoguHanbaihiDac 給付実績福祉用具販売費Dac;
    private final DbT3033KyufujissekiShukeiDac 給付実績集計Dac;
    private static final RString モード_登録 = new RString("登録");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_差額登録 = new RString("差額登録");
    private static final RString モード_削除 = new RString("削除");
    private static final RString モード_審査 = new RString("審査");
    private static final RString INDEX_1 = new RString("1");
    private static final RString INDEX_2 = new RString("2");
    private static final RString INDEX_3 = new RString("3");

    /**
     * コンストラクタです。
     */
    public FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.給付実績基本Dac = InstanceProvider.create(DbT3017KyufujissekiKihonDac.class);
        this.給付実績福祉用具販売費Dac = InstanceProvider.create(DbT3026KyufujissekiFukushiYoguHanbaihiDac.class);
        this.給付実績集計Dac = InstanceProvider.create(DbT3033KyufujissekiShukeiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu}のインスタンスを返します。
     *
     * @return FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu
     */
    public static FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu createInstance() {

        return InstanceProvider.create(FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 受給者台帳Dac 受給者台帳Dac
     * @param 給付実績基本Dac 給付実績基本Dac
     * @param 給付実績福祉用具販売費Dac 給付実績福祉用具販売費Dac
     * @param 給付実績集計Dac 給付実績集計Dac
     */
    FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu(
            MapperProvider mapperProvider,
            DbT4001JukyushaDaichoDac 受給者台帳Dac,
            DbT3017KyufujissekiKihonDac 給付実績基本Dac,
            DbT3026KyufujissekiFukushiYoguHanbaihiDac 給付実績福祉用具販売費Dac,
            DbT3033KyufujissekiShukeiDac 給付実績集計Dac
    ) {
        this.mapperProvider = mapperProvider;
        this.受給者台帳Dac = 受給者台帳Dac;
        this.給付実績基本Dac = 給付実績基本Dac;
        this.給付実績福祉用具販売費Dac = 給付実績福祉用具販売費Dac;
        this.給付実績集計Dac = 給付実績集計Dac;
    }

    /**
     * 給付実績処理
     *
     * @param 画面モード 画面モード
     * @param 識別コード 識別コード
     * @param shokanKihonEntity shokanKihonEntity
     * @param businessList businessList
     * @param shokanShinseiEntity shokanShinseiEntity
     * @param shokanHanteiKekkaEntity shokanHanteiKekkaEntity
     * @param shokanShukeiEntity shokanShukeiEntity
     * @param 修正前支給区分 修正前支給区分
     */
    public void dealKyufujisseki(RString 画面モード, ShikibetsuCode 識別コード,
            DbT3038ShokanKihonEntity shokanKihonEntity,
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> businessList,
            DbT3034ShokanShinseiEntity shokanShinseiEntity,
            DbT3036ShokanHanteiKekkaEntity shokanHanteiKekkaEntity,
            DbT3053ShokanShukeiEntity shokanShukeiEntity,
            RString 修正前支給区分) {

        requireNonNull(画面モード, UrSystemErrorMessages.値がnull.getReplacedMessage("画面モード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(shokanKihonEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求基本"));
        requireNonNull(businessList, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求福祉用具販売費"));
        requireNonNull(shokanShinseiEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給申請"));
        requireNonNull(shokanHanteiKekkaEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給判定結果"));
        requireNonNull(shokanShukeiEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求集計"));

        RString 給付実績情報作成区分コード;

        if (モード_登録.equals(画面モード)
                && ShikyuFushikyuKubun.支給.getコード().equals(shokanHanteiKekkaEntity.getShikyuHushikyuKetteiKubun())) {
            給付実績情報作成区分コード = INDEX_1;
            給付実績追加(画面モード, 識別コード, shokanKihonEntity, businessList,
                    shokanShinseiEntity, shokanHanteiKekkaEntity,
                    shokanShukeiEntity, 給付実績情報作成区分コード);
            return;
        }
        if (モード_修正.equals(画面モード) || モード_差額登録.equals(画面モード)) {
            requireNonNull(修正前支給区分, UrSystemErrorMessages.値がnull.getReplacedMessage("修正前支給区分"));
            if (修正前支給区分.equals(ShikyuFushikyuKubun.不支給.getコード())
                    && ShikyuFushikyuKubun.不支給.getコード().equals(shokanHanteiKekkaEntity.getShikyuHushikyuKetteiKubun())) {
                return;
            }
            if (ShikyuFushikyuKubun.不支給.getコード().equals(修正前支給区分)
                    && ShikyuFushikyuKubun.支給.getコード().equals(shokanHanteiKekkaEntity.getShikyuHushikyuKetteiKubun())) {
                給付実績情報作成区分コード = INDEX_1;
                給付実績追加(画面モード, 識別コード, shokanKihonEntity, businessList,
                        shokanShinseiEntity, shokanHanteiKekkaEntity,
                        shokanShukeiEntity, 給付実績情報作成区分コード);
                return;
            }
            if (ShikyuFushikyuKubun.支給.getコード().equals(修正前支給区分)
                    && ShikyuFushikyuKubun.支給.getコード().equals(shokanHanteiKekkaEntity.getShikyuHushikyuKetteiKubun())) {
                給付実績情報作成区分コード = INDEX_2;
                給付実績追加(画面モード, 識別コード, shokanKihonEntity, businessList,
                        shokanShinseiEntity, shokanHanteiKekkaEntity,
                        shokanShukeiEntity, 給付実績情報作成区分コード);
                return;
            }
            if (ShikyuFushikyuKubun.支給.getコード().equals(修正前支給区分)
                    && ShikyuFushikyuKubun.不支給.getコード().equals(shokanHanteiKekkaEntity.getShikyuHushikyuKetteiKubun())) {
                給付実績情報作成区分コード = INDEX_3;
                給付実績追加(画面モード, 識別コード, shokanKihonEntity, businessList,
                        shokanShinseiEntity, shokanHanteiKekkaEntity,
                        shokanShukeiEntity, 給付実績情報作成区分コード);
                return;
            }
        }
        if (モード_削除.equals(画面モード)) {
            if (ShikyuFushikyuKubun.不支給.getコード().equals(shokanHanteiKekkaEntity.getShikyuHushikyuKetteiKubun())) {
                return;
            }
            if (ShikyuFushikyuKubun.支給.getコード().equals(shokanHanteiKekkaEntity.getShikyuHushikyuKetteiKubun())) {
                給付実績情報作成区分コード = INDEX_3;
                給付実績追加(画面モード, 識別コード, shokanKihonEntity, businessList,
                        shokanShinseiEntity, shokanHanteiKekkaEntity,
                        shokanShukeiEntity, 給付実績情報作成区分コード);
                return;
            }
        }
        if (モード_審査.equals(画面モード)) {
            給付実績情報作成区分コード = INDEX_1;
            給付実績追加(画面モード, 識別コード, shokanKihonEntity, businessList,
                    shokanShinseiEntity, shokanHanteiKekkaEntity,
                    shokanShukeiEntity, 給付実績情報作成区分コード);
        }

    }

    /**
     * 給付実績追加
     *
     * @param 識別コード 識別コード
     * @param shokanKihonEntity shokanKihonEntity
     * @param businessList businessList
     * @param shokanShinseiEntity shokanShinseiEntity
     * @param shokanHanteiKekkaEntity shokanHanteiKekkaEntity
     * @param shokanShukeiEntity shokanShukeiEntity
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     */
    private void 給付実績追加(RString 画面モード, ShikibetsuCode 識別コード,
            DbT3038ShokanKihonEntity shokanKihonEntity,
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> businessList,
            DbT3034ShokanShinseiEntity shokanShinseiEntity,
            DbT3036ShokanHanteiKekkaEntity shokanHanteiKekkaEntity,
            DbT3053ShokanShukeiEntity shokanShukeiEntity,
            RString 給付実績情報作成区分コード) {
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        RString 通し番号 = Saiban.get(SubGyomuCode.DBC介護給付,
                SaibanHanyokeyName.実績管理番号.getコード()).nextString();
        if (null == 通し番号) {
            throw new IllegalArgumentException(UrErrorMessages.存在しない
                    .getMessage().replace("最新番号").evaluate());
        }

        ShikibetsuTaishoPSMSearchKeyBuilder builder
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        builder.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey key = builder.build();
        SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter parameter
                = new SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter(key);
        ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper mapper
                = mapperProvider.create(ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper.class);
        DealKyufujissekiEntity 宛名 = mapper.get宛名(parameter);
        FlexibleDate 生年月日YMD = null;
        RString 性別コード = RString.EMPTY;
        if (宛名 != null) {
            生年月日YMD = 宛名.get生年月日();
            性別コード = 宛名.get性別コード();
        }

        DbT4001JukyushaDaichoEntity dbT4001entity = 受給者台帳Dac.select認定有効期間(shokanShinseiEntity.getHiHokenshaNo());
        if (dbT4001entity == null) {
            throw new IllegalArgumentException(UrErrorMessages.存在しない
                    .getMessage().replace("認定有効期間").evaluate());
        }

        save給付実績基本(給付実績情報作成区分コード, 通し番号, 生年月日YMD, 性別コード,
                dbT4001entity, shokanKihonEntity, shokanShinseiEntity, shokanHanteiKekkaEntity);

        save給付実績福祉用具販売費(画面モード, 通し番号, businessList, shokanShinseiEntity, shokanShukeiEntity, shokanHanteiKekkaEntity
        );
        save給付実績集計(通し番号, shokanKihonEntity, shokanShinseiEntity, shokanHanteiKekkaEntity, shokanShukeiEntity);

    }

    /**
     * save給付実績基本
     *
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     * @param 通し番号 通し番号
     * @param 生年月日YMD 生年月日YMD
     * @param 性別コード 性別コード
     * @param dbT4001entity dbT4001entity
     * @param shokanKihonEntity shokanKihonEntity
     * @param shokanShinseiEntity shokanShinseiEntity
     * @param shokanHanteiKekkaEntity shokanHanteiKekkaEntity
     */
    public void save給付実績基本(RString 給付実績情報作成区分コード, RString 通し番号,
            FlexibleDate 生年月日YMD, RString 性別コード,
            DbT4001JukyushaDaichoEntity dbT4001entity,
            DbT3038ShokanKihonEntity shokanKihonEntity,
            DbT3034ShokanShinseiEntity shokanShinseiEntity,
            DbT3036ShokanHanteiKekkaEntity shokanHanteiKekkaEntity) {
        DbT3017KyufujissekiKihonEntity dbT3017entity = new DbT3017KyufujissekiKihonEntity();

        dbT3017entity.setKokanShikibetsuNo(get交換情報識別番号(shokanKihonEntity.getServiceTeikyoYM()));
        dbT3017entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(shokanKihonEntity.getYoshikiNo()));
        dbT3017entity.setRecodeShubetsuCode(new RString("01"));
        dbT3017entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
        if (shokanShinseiEntity.getShoKisaiHokenshaNo() != null) {
            dbT3017entity.setShokisaiHokenshaNo(new HokenshaNo(shokanShinseiEntity.getShoKisaiHokenshaNo().value().toString()));
        }
        dbT3017entity.setHiHokenshaNo(shokanKihonEntity.getHiHokenshaNo());
        dbT3017entity.setServiceTeikyoYM(shokanKihonEntity.getServiceTeikyoYM());
        dbT3017entity.setKyufuJissekiKubunCode(INDEX_2);
        dbT3017entity.setJigyoshoNo(shokanKihonEntity.getJigyoshaNo());
        dbT3017entity.setToshiNo(通し番号);
        dbT3017entity.setUmareYMD(生年月日YMD);
        dbT3017entity.setSeibetsuCode(性別コード);
        dbT3017entity.setNinteiYukoKaishiYMD(dbT4001entity.getNinteiYukoKikanKaishiYMD());
        dbT3017entity.setNinteiYukoShuryoYMD(dbT4001entity.getNinteiYukoKikanShuryoYMD());
        dbT3017entity.setHokenKyufuritsu(shokanKihonEntity.getHokenKyufuritsu());
        dbT3017entity.setMaeHokenSeikyugaku(new Decimal(shokanShinseiEntity.getHokenKyufugaku()));
        dbT3017entity.setMaeHokenRiyoshaFutangaku(shokanShinseiEntity.getRiyoshaFutangaku());
        dbT3017entity.setAtoHokenSeikyugaku(new Decimal(shokanShinseiEntity.getHokenKyufugaku()));
        dbT3017entity.setAtoHokenRiyoshaFutangaku(shokanShinseiEntity.getRiyoshaFutangaku());
        FlexibleDate ketteiYMD = shokanHanteiKekkaEntity.getKetteiYMD();
        if (ketteiYMD != null) {
            dbT3017entity.setShinsaYM(ketteiYMD.getYearMonth());
            dbT3017entity.setSofuYM(ketteiYMD.getYearMonth());
        }
        dbT3017entity.setSeiriNo(shokanKihonEntity.getSeiriNo());
        dbT3017entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(false);
        dbT3017entity.setState(EntityDataState.Added);
        給付実績基本Dac.save(dbT3017entity);
    }

    /**
     * save給付実績福祉用具販売費
     *
     * @param 画面モード 画面モード
     * @param 通し番号 通し番号
     * @param businessList businessList
     * @param shokanShinseiEntity shokanShinseiEntity
     * @param shokanShukeiEntity shokanShukeiEntity
     * @param shokanHanteiKekkaEntity shokanHanteiKekkaEntity
     */
    private void save給付実績福祉用具販売費(RString 画面モード, RString 通し番号,
            List<DbT3048ShokanFukushiYoguHanbaihiEntity> businessList,
            DbT3034ShokanShinseiEntity shokanShinseiEntity,
            DbT3053ShokanShukeiEntity shokanShukeiEntity,
            DbT3036ShokanHanteiKekkaEntity shokanHanteiKekkaEntity) {

        DbT3026KyufujissekiFukushiYoguHanbaihiEntity dbT3026entity = new DbT3026KyufujissekiFukushiYoguHanbaihiEntity();
        int 連番 = 0;
        for (DbT3048ShokanFukushiYoguHanbaihiEntity dbT3048Entity : businessList) {
            連番 = 連番 + 1;
            dbT3026entity.setKokanJohoShikibetsuNo(get交換情報識別番号(dbT3048Entity.getServiceTeikyoYM()));
            dbT3026entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(dbT3048Entity.getYoshikiNo()));
            dbT3026entity.setRecodeShubetsuCode(new RString("06"));
            if (shokanShinseiEntity.getShoKisaiHokenshaNo() != null) {
                dbT3026entity.setShokisaiHokenshaNo(new HokenshaNo(shokanShinseiEntity.getShoKisaiHokenshaNo().value().toString()));
            }
            dbT3026entity.setHiHokenshaNo(dbT3048Entity.getHiHokenshaNo());
            dbT3026entity.setServiceTeikyoYM(dbT3048Entity.getServiceTeikyoYM());
            dbT3026entity.setJigyoshoNo(dbT3048Entity.getJigyoshaNo());
            dbT3026entity.setToshiNo(通し番号);
            if (モード_修正.equals(画面モード)) {
                dbT3026entity.setMeisaiNo(new RString(String.valueOf(連番)));
            }
            ServiceShuruiCode サービス種類コード = shokanShukeiEntity.getServiceShuruiCode();
            if (サービス種類コード != null) {
                dbT3026entity.setServiceCode(new ServiceCode(サービス種類コード.value().concat(new RString("0000"))));
            }
            dbT3026entity.setFukushiyoguHanbaiYMD(nullTOEmpty(dbT3048Entity.getFukushiYoguHanbaiYMD()));
            dbT3026entity.setFukushiyoguShohinName(dbT3048Entity.getFukushiYoguShohinName());
            dbT3026entity.setFukushiyoguSyumokuCode(dbT3048Entity.getFukushiYoguShumokuCode());
            dbT3026entity.setFukushiyoguSeizoJigyoshaName(dbT3048Entity.getFukushiYoguSeizoJigyoshaName());
            dbT3026entity.setFukushiyoguHanbaiJigyoshaName(dbT3048Entity.getFukushiYoguHanbaiJigyoshaName());
            dbT3026entity.setHanbaiKingaku(new Decimal(dbT3048Entity.getKounyuKingaku()));
            dbT3026entity.setTekiyo(dbT3048Entity.getHinmokuCode());
            FlexibleDate ketteiYMD = shokanHanteiKekkaEntity.getKetteiYMD();
            if (ketteiYMD != null) {
                dbT3026entity.setShinsaYM(ketteiYMD.getYearMonth());
                dbT3026entity.setTorikomiYM(ketteiYMD.getYearMonth());
            }
            dbT3026entity.setSeiriNo(dbT3048Entity.getSeiriNo());
            dbT3026entity.setMeisaiNo(dbT3048Entity.getMeisaiNo());
            dbT3026entity.setState(EntityDataState.Added);
            給付実績福祉用具販売費Dac.save(dbT3026entity);
        }

    }

    /**
     * save給付実績集計
     *
     * @param 通し番号 通し番号
     * @param shokanKihonEntity shokanKihonEntity
     * @param shokanShinseiEntity shokanShinseiEntity
     * @param shokanHanteiKekkaEntity shokanHanteiKekkaEntity
     * @param shokanShukeiEntity shokanShukeiEntity
     */
    private void save給付実績集計(RString 通し番号,
            DbT3038ShokanKihonEntity shokanKihonEntity,
            DbT3034ShokanShinseiEntity shokanShinseiEntity,
            DbT3036ShokanHanteiKekkaEntity shokanHanteiKekkaEntity,
            DbT3053ShokanShukeiEntity shokanShukeiEntity) {

        DbT3033KyufujissekiShukeiEntity dbT3033entity = new DbT3033KyufujissekiShukeiEntity();
        dbT3033entity.setKokanJohoShikibetsuNo(get交換情報識別番号(shokanKihonEntity.getServiceTeikyoYM()));
        dbT3033entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(shokanKihonEntity.getYoshikiNo()));
        dbT3033entity.setRecodeShubetsuCode(new RString("10"));
        if (shokanShinseiEntity.getShoKisaiHokenshaNo() != null) {
            dbT3033entity.setShokisaiHokenshaNo(new HokenshaNo(shokanShinseiEntity.getShoKisaiHokenshaNo().value().toString()));
        }
        dbT3033entity.setHiHokenshaNo(shokanKihonEntity.getHiHokenshaNo());
        dbT3033entity.setServiceTeikyoYM(shokanKihonEntity.getServiceTeikyoYM());
        dbT3033entity.setJigyoshoNo(nullTOEmpty(shokanKihonEntity.getJigyoshaNo()));
        dbT3033entity.setToshiNo(通し番号);
        dbT3033entity.setServiceSyuruiCode(nullTOEmpty(shokanShukeiEntity.getServiceShuruiCode()));
        FlexibleDate ketteiYMD = shokanHanteiKekkaEntity.getKetteiYMD();
        if (ketteiYMD != null) {
            dbT3033entity.setShinsaYM(ketteiYMD.getYearMonth());
            dbT3033entity.setTorikomiYM(ketteiYMD.getYearMonth());
        }
        dbT3033entity.setSeiriNo(shokanKihonEntity.getSeiriNo());
        dbT3033entity.setState(EntityDataState.Added);
        給付実績集計Dac.save(dbT3033entity);
    }

    /**
     * 交換情報識別番号の取得
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     * @return 交換情報識別番号
     */
    private KokanShikibetsuNo get交換情報識別番号(FlexibleYearMonth serviceTeikyoYM) {
        KokanShikibetsuNo 交換情報識別番号 = new KokanShikibetsuNo("1131");
        if (serviceTeikyoYM.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            return 交換情報識別番号;
        }
        if (new FlexibleYearMonth("201504").isBeforeOrEquals(serviceTeikyoYM)) {
            交換情報識別番号 = new KokanShikibetsuNo("1138");
            return 交換情報識別番号;
        }
        if (new FlexibleYearMonth("201204").isBeforeOrEquals(serviceTeikyoYM)) {
            交換情報識別番号 = new KokanShikibetsuNo("1137");
            return 交換情報識別番号;
        }
        if (new FlexibleYearMonth("200904").isBeforeOrEquals(serviceTeikyoYM)) {
            交換情報識別番号 = new KokanShikibetsuNo("1136");
            return 交換情報識別番号;
        }
        if (new FlexibleYearMonth("200804").isBeforeOrEquals(serviceTeikyoYM)) {
            交換情報識別番号 = new KokanShikibetsuNo("1135");
            return 交換情報識別番号;
        }
        if (new FlexibleYearMonth("200604").isBeforeOrEquals(serviceTeikyoYM)) {
            交換情報識別番号 = new KokanShikibetsuNo("1134");
            return 交換情報識別番号;
        }
        if (new FlexibleYearMonth("200504").isBeforeOrEquals(serviceTeikyoYM)) {
            交換情報識別番号 = new KokanShikibetsuNo("1133");
            return 交換情報識別番号;
        }
        if (new FlexibleYearMonth("200304").isBeforeOrEquals(serviceTeikyoYM)) {
            交換情報識別番号 = new KokanShikibetsuNo("1132");
            return 交換情報識別番号;
        }
        return 交換情報識別番号;
    }

    /**
     * NULLのCHECK
     *
     * @param 項目 JigyoshaNo
     * @return
     */
    private JigyoshaNo nullTOEmpty(JigyoshaNo 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return new JigyoshaNo("");
        }
        return 項目;
    }

    /**
     * NULLのCHECK
     *
     * @param 項目 FlexibleDate
     * @return
     */
    private FlexibleDate nullTOEmpty(FlexibleDate 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return new FlexibleDate("");
        }
        return 項目;
    }

    /**
     * NULLのCHECK
     *
     * @param 項目 ServiceShuruiCode
     * @return
     */
    private ServiceShuruiCode nullTOEmpty(ServiceShuruiCode 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return new ServiceShuruiCode("");
        }
        return 項目;
    }

}
