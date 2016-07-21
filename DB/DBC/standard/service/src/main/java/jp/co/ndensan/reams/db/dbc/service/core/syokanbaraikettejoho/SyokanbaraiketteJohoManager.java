/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraikettejoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.SyokanbaraiketteJoho;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraikettejoho.SyokanbaraiketteJohoMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.syokanbaraikettejoho.SyokanbaraiketteJohoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraiketejoho.KetteJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraiketejoho.SyokanbaraiketeJohoDekidakaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraiketejoho.SyokanbaraiketeJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3045ShokanServicePlan200004Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3046ShokanServicePlan200604Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraikettejoho.ISyokanbaraiketteJohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4024ShiharaiHohoHenkoSashitomeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払決定一覧を管理するクラスです。
 *
 * @reamsid_L DBC-0950-020 zuotao
 */
public class SyokanbaraiketteJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3047ShokanServicePlan200904Dac 償還払請求サービス計画200904Dac;
    private final DbT3046ShokanServicePlan200604Dac 償還払請求サービス計画200604Dac;
    private final DbT3045ShokanServicePlan200004Dac 償還払請求サービス計画200004Dac;
    private final DbT4024ShiharaiHohoHenkoSashitomeDac 支払方法変更差止Dac;
    private static final RString モード_登録 = new RString("登録");
    private static final RString テーブル区分_償還払請求集計 = new RString("3");
    private static final RString 出来高区分_非出来高 = new RString("0");
    private static final RString 出来高区分_出来高 = new RString("1");
    private static final RString 出来高医療費 = new RString("出来高医療費");
    private static final RString サービス計画費 = new RString("サービス計画費");
    private static final RString 特定入所者 = new RString("特定入所者");
    private static final RString 食事費用 = new RString("食事費用");
    private static final RString GYOKUKBN_償還払い費 = new RString("03");

    /**
     * コンストラクタです。
     */
    SyokanbaraiketteJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        償還払請求サービス計画200904Dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
        償還払請求サービス計画200604Dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
        償還払請求サービス計画200004Dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
        支払方法変更差止Dac = InstanceProvider.create(DbT4024ShiharaiHohoHenkoSashitomeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 償還払支給判定結果Dac 償還払支給判定結果Dac
     * @param 償還払請求集計Dac 償還払請求集計Dac
     * @param 償還払請求サービス計画200904Dac 償還払請求サービス計画200904Dac
     * @param 償還払請求サービス計画200604Dac 償還払請求サービス計画200604Dac
     * @param 償還払請求サービス計画200004Dac 償還払請求サービス計画200004Dac
     * @param 支払方法変更差止Dac 支払方法変更差止Dac
     */
    public SyokanbaraiketteJohoManager(MapperProvider mapperProvider, DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac,
            DbT3053ShokanShukeiDac 償還払請求集計Dac, DbT3047ShokanServicePlan200904Dac 償還払請求サービス計画200904Dac,
            DbT3046ShokanServicePlan200604Dac 償還払請求サービス計画200604Dac, DbT3045ShokanServicePlan200004Dac 償還払請求サービス計画200004Dac,
            DbT4024ShiharaiHohoHenkoSashitomeDac 支払方法変更差止Dac) {
        this.mapperProvider = mapperProvider;
        this.償還払支給判定結果Dac = 償還払支給判定結果Dac;
        this.償還払請求集計Dac = 償還払請求集計Dac;
        this.償還払請求サービス計画200904Dac = 償還払請求サービス計画200904Dac;
        this.償還払請求サービス計画200604Dac = 償還払請求サービス計画200604Dac;
        this.償還払請求サービス計画200004Dac = 償還払請求サービス計画200004Dac;
        this.支払方法変更差止Dac = 支払方法変更差止Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SyokanbaraiketteJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SyokanbaraiketteJohoManager}のインスタンス
     */
    public static SyokanbaraiketteJohoManager createInstance() {
        return InstanceProvider.create(SyokanbaraiketteJohoManager.class);
    }

    /**
     * 償還払決定一覧（福祉）を取得します。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param serviceTeikyoYM サービス提供年月
     * @param seiriNo 整理番号
     * @return 償還払決定情報リスト
     */
    public SearchResult<SyokanbaraiketteJoho> getSyokanbaraiketteFukushiList(HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {

        List<SyokanbaraiketteJoho> 償還払決定情報List = new ArrayList<>();
        ISyokanbaraiketteJohoMapper mapper = mapperProvider.create(ISyokanbaraiketteJohoMapper.class);
        List<SyokanbaraiketeJohoEntity> entityList
                = mapper.getSyokanbaraiketteFukushiList(SyokanbaraiketteJohoParameter.createMybatisParam(hiHokenshaNo, serviceTeikyoYM, seiriNo));
        for (SyokanbaraiketeJohoEntity entity : entityList) {
            償還払決定情報List.add(new SyokanbaraiketteJoho(entity));
        }
        if (償還払決定情報List.isEmpty()) {
            return SearchResult.of(Collections.<SyokanbaraiketteJoho>emptyList(), 0, false);
        }
        return SearchResult.of(償還払決定情報List, 0, false);
    }

    /**
     * 償還払決定一覧（住宅改修費）を取得します。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param serviceTeikyoYM サービス提供年月
     * @param seiriNo 整理番号
     * @return 償還払決定情報リスト
     */
    public SearchResult<SyokanbaraiketteJoho> getSyokanbaraiketteJyutakuList(HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {
        requireNonNull(hiHokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(serviceTeikyoYM, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(seiriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));

        List<SyokanbaraiketteJoho> 償還払決定情報List = new ArrayList<>();
        ISyokanbaraiketteJohoMapper mapper = mapperProvider.create(ISyokanbaraiketteJohoMapper.class);
        List<SyokanbaraiketeJohoEntity> entityList = mapper.getSyokanbaraiketteJyutakuList(SyokanbaraiketteJohoParameter.
                createMybatisParam(hiHokenshaNo, serviceTeikyoYM, seiriNo));
        for (SyokanbaraiketeJohoEntity entity : entityList) {
            償還払決定情報List.add(new SyokanbaraiketteJoho(entity));
        }
        if (償還払決定情報List.isEmpty()) {
            return SearchResult.of(Collections.<SyokanbaraiketteJoho>emptyList(), 0, false);
        }
        return SearchResult.of(償還払決定情報List, 0, false);
    }

    /**
     * 償還払決定一覧（償還払い費）を取得します。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param serviceTeikyoYM サービス提供年月
     * @param seiriNo 整理番号
     * @return 償還払決定情報リスト
     */
    public SearchResult<SyokanbaraiketteJoho> getSyokanbaraiketteSyokanList(HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {
        requireNonNull(hiHokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(serviceTeikyoYM, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(seiriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));

        List<SyokanbaraiketteJoho> 償還払決定情報List = new ArrayList<>();
        償還払決定情報List.addAll(get集計情報決定データ(SyokanbaraiketteJohoParameter.
                createMybatisParam(hiHokenshaNo, serviceTeikyoYM, seiriNo)));
        償還払決定情報List.addAll(getサービス計画費(hiHokenshaNo, serviceTeikyoYM, seiriNo));
        償還払決定情報List.addAll(get特定入所者(hiHokenshaNo, serviceTeikyoYM, seiriNo));
        償還払決定情報List.addAll(get食事費用(hiHokenshaNo, serviceTeikyoYM, seiriNo));
        if (償還払決定情報List.isEmpty()) {
            return SearchResult.of(Collections.<SyokanbaraiketteJoho>emptyList(), 0, false);
        }
        return SearchResult.of(償還払決定情報List, 0, false);
    }

    /**
     * 決定情報を取得します。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param serviceTeikyoYM サービス提供年月
     * @param seiriNo 整理番号
     * @param gyomuKbn 業務区分
     * @return 償還払決定情報リスト
     */
    public KetteJoho getKetteJoho(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo, RString gyomuKbn) {
        requireNonNull(hiHokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(serviceTeikyoYM, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(seiriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(gyomuKbn, UrSystemErrorMessages.値がnull.getReplacedMessage("業務区分"));
        KetteJohoEntity entity = getKetteJohoEntity(hiHokenshaNo, serviceTeikyoYM, seiriNo, gyomuKbn);
        if (entity == null) {
            return null;
        }
        return new KetteJoho(entity);
    }

    /**
     * 差止控除区分を取得します。
     *
     * @param mode 画面モード
     * @param hiHokenshaNo 被保険者番号
     * @param serviceTeikyoYM サービス提供年月
     * @param seiriNo 整理番号
     * @return 差止控除区分
     */
    public RString getShashitomeKojyoKubun(RString mode, HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {

        RString shashitomeKojyoKubun;
        if (モード_登録.equals(mode)) {
            shashitomeKojyoKubun = new RString("00");
        } else {
            DbT4024ShiharaiHohoHenkoSashitomeEntity entity = 支払方法変更差止Dac.get支払方法変更差止(hiHokenshaNo, serviceTeikyoYM, seiriNo);
            if (entity == null) {
                shashitomeKojyoKubun = new RString("00");
            } else if (entity.getSashitomeKojoNo() == null) {
                shashitomeKojyoKubun = new RString("10");
            } else {
                shashitomeKojyoKubun = new RString("20");
            }
        }

        DbT3036ShokanHanteiKekkaEntity entity = 償還払支給判定結果Dac.selectByKey(hiHokenshaNo, serviceTeikyoYM, seiriNo);
        if (entity != null && entity.getSagakuKingakuGokei() != null) {
            RStringBuilder rsb = new RStringBuilder();
            rsb.append(shashitomeKojyoKubun.substring(0, 1));
            rsb.append(new RString("1"));
            shashitomeKojyoKubun = rsb.toRString();
        }
        return shashitomeKojyoKubun;
    }

    private KetteJohoEntity getKetteJohoEntity(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo, RString gyomuKbn) {

        DbT3036ShokanHanteiKekkaEntity 償還払支給判定結果Entity = 償還払支給判定結果Dac.selectByKey(hiHokenshaNo, serviceTeikyoYM, seiriNo);
        if (償還払支給判定結果Entity == null) {
            return null;
        }
        SyokanbaraiketteJohoParameter mybatisParameter = SyokanbaraiketteJohoParameter.
                createMybatisParam(hiHokenshaNo, serviceTeikyoYM, seiriNo);
        KetteJohoEntity entity = new KetteJohoEntity();
        entity.setHiHokenshaNo(償還払支給判定結果Entity.getHiHokenshaNo());
        entity.setServiceTeikyoYM(償還払支給判定結果Entity.getServiceTeikyoYM());
        entity.setSeiriNo(償還払支給判定結果Entity.getSeiriNo());
        entity.setKetteiYMD(償還払支給判定結果Entity.getKetteiYMD());
        entity.setShikyuHushikyuKetteiKubun(償還払支給判定結果Entity.getShikyuHushikyuKetteiKubun());
        Decimal shiharaiKingaku = 償還払支給判定結果Entity.getShiharaiKingaku();
        if (shiharaiKingaku != null) {
            entity.setShiharaiKingaku(shiharaiKingaku.intValue());
        } else {
            entity.setShiharaiKingaku(0);
        }
        DbT3053ShokanShukeiEntity 償還払請求集計Entity = 償還払請求集計Dac.select償還払請求集計(mybatisParameter);

        if (償還払請求集計Entity != null) {
            entity.setZougenRiyu(償還払請求集計Entity.getZougenRiyu());
            entity.setHushikyuRiyu(償還払請求集計Entity.getHushikyuRiyu());
            entity.setZougenten(償還払請求集計Entity.getZougenten());
            entity.setKounyuKaishuRireki(償還払請求集計Entity.getKounyuKaishuRireki());
            return entity;
        }
        if (!GYOKUKBN_償還払い費.equals(gyomuKbn)) {
            return entity;
        }
        if (new FlexibleYearMonth("200904").isBefore(serviceTeikyoYM)) {
            DbT3047ShokanServicePlan200904Entity 計画200904Entity = 償還払請求サービス計画200904Dac.select決定理由情報(mybatisParameter);
            if (計画200904Entity != null) {
                entity.setZougenRiyu(計画200904Entity.getZougenRiyu());
                entity.setHushikyuRiyu(計画200904Entity.getFushikyuRiyu());
                entity.setZougenten(計画200904Entity.getZougenTen());
                entity.setKounyuKaishuRireki(計画200904Entity.getKounyuKaishuRireki());
            }

        } else if (serviceTeikyoYM.isBefore(new FlexibleYearMonth("200904"))
                && new FlexibleYearMonth("200604").isBefore(serviceTeikyoYM)) {
            DbT3046ShokanServicePlan200604Entity 計画200604Entity = 償還払請求サービス計画200604Dac.select決定理由情報(mybatisParameter);
            if (計画200604Entity != null) {
                entity.setZougenRiyu(計画200604Entity.getZougenRiyu());
                entity.setHushikyuRiyu(計画200604Entity.getFushikyuRiyu());
                entity.setZougenten(計画200604Entity.getZougenTen());
                entity.setKounyuKaishuRireki(計画200604Entity.getKounyuKaishuRireki());
            }
        } else if (serviceTeikyoYM.isBefore(new FlexibleYearMonth("200604"))
                && new FlexibleYearMonth("200004").isBefore(serviceTeikyoYM)) {
            DbT3045ShokanServicePlan200004Entity 計画200004Entity = 償還払請求サービス計画200004Dac.select決定理由情報(mybatisParameter);
            if (計画200004Entity != null) {
                entity.setZougenRiyu(計画200004Entity.getZougenRiyu());
                entity.setHushikyuRiyu(計画200004Entity.getFushikyuRiyu());
                entity.setZougenten(計画200004Entity.getZougenTen());
                entity.setKounyuKaishuRireki(計画200004Entity.getKounyuKaishuRireki());
            }
        }
        return entity;
    }

    private List<SyokanbaraiketteJoho> get集計情報決定データ(SyokanbaraiketteJohoParameter param) {
        ISyokanbaraiketteJohoMapper mapper = mapperProvider.create(ISyokanbaraiketteJohoMapper.class);
        List<SyokanbaraiketeJohoDekidakaEntity> dekidakaEntityList = mapper.get集計情報決定データ(param);
        List<SyokanbaraiketteJoho> resultList = new ArrayList<>();
        for (SyokanbaraiketeJohoDekidakaEntity dekidakaEntity : dekidakaEntityList) {
            resultList.add(new SyokanbaraiketteJoho(setSyokanbaraiketeJohoEntity(dekidakaEntity, 出来高区分_非出来高)));
            resultList.add(new SyokanbaraiketteJoho(setSyokanbaraiketeJohoEntity(dekidakaEntity, 出来高区分_出来高)));
        }
        return resultList;
    }

    private SyokanbaraiketeJohoEntity setSyokanbaraiketeJohoEntity(SyokanbaraiketeJohoDekidakaEntity dekidakaEntity, RString tableKbn) {

        SyokanbaraiketeJohoEntity entity = new SyokanbaraiketeJohoEntity();
        entity.setJigyoshaNo(dekidakaEntity.getJigyoshaNo());
        entity.setYoshikiNo(dekidakaEntity.getYoshikiNo());
        entity.setMeisaiNo(dekidakaEntity.getMeisaiNo());
        entity.setRenban(dekidakaEntity.getRenban());
        entity.setFukushiYoguShohinName(dekidakaEntity.getFukushiYoguShohinName());
        entity.setUpdateCount(dekidakaEntity.getUpdateCount());
        entity.setTableKbn(テーブル区分_償還払請求集計);
        if (出来高区分_非出来高.equals(tableKbn)) {
            entity.setServiceCode(dekidakaEntity.getServiceCode());
            entity.setServiceName(dekidakaEntity.getServiceName());
            entity.setKounyuKingaku(dekidakaEntity.getTanisuTotal());
            entity.setShiharaiKingaku(dekidakaEntity.getSeikyuKaku());
            entity.setSagakuKingaku(dekidakaEntity.getSeikyugakuSagakuKingaku());
            entity.setDekidakaKbn(出来高区分_非出来高);
        } else {
            entity.setServiceCode(ServiceCode.EMPTY);
            entity.setServiceName(出来高医療費);
            entity.setKounyuKingaku(dekidakaEntity.getDekidakaIryohiTanisuTotal());
            entity.setShiharaiKingaku(dekidakaEntity.getDekidakaSeikyukaku());
            entity.setSagakuKingaku(dekidakaEntity.getDekidakaSeikyugakuSagaku());
            entity.setDekidakaKbn(出来高区分_出来高);
        }
        return entity;
    }

    private List<SyokanbaraiketteJoho> getサービス計画費(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {

        List<SyokanbaraiketteJoho> resultList = new ArrayList<>();
        ISyokanbaraiketteJohoMapper mapper = mapperProvider.create(ISyokanbaraiketteJohoMapper.class);
        List<SyokanbaraiketeJohoEntity> entityList = mapper.get償還払決定一覧(SyokanbaraiketteJohoMapperParameter
                .createSyokanbaraiketteJohoMapperParameter(hiHokenshaNo, serviceTeikyoYM, seiriNo, サービス計画費));

        for (SyokanbaraiketeJohoEntity entity : entityList) {
            resultList.add(new SyokanbaraiketteJoho(entity));
        }
        return resultList;
    }

    private List<SyokanbaraiketteJoho> get特定入所者(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {

        List<SyokanbaraiketteJoho> resultList = new ArrayList<>();
        ISyokanbaraiketteJohoMapper mapper = mapperProvider.create(ISyokanbaraiketteJohoMapper.class);
        List<SyokanbaraiketeJohoEntity> entityList = mapper.get償還払決定一覧(SyokanbaraiketteJohoMapperParameter
                .createSyokanbaraiketteJohoMapperParameter(hiHokenshaNo, serviceTeikyoYM, seiriNo, 特定入所者));

        for (SyokanbaraiketeJohoEntity entity : entityList) {
            resultList.add(new SyokanbaraiketteJoho(entity));
        }
        return resultList;
    }

    private List<SyokanbaraiketteJoho> get食事費用(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM, RString seiriNo) {

        List<SyokanbaraiketteJoho> resultList = new ArrayList<>();
        ISyokanbaraiketteJohoMapper mapper = mapperProvider.create(ISyokanbaraiketteJohoMapper.class);
        List<SyokanbaraiketeJohoEntity> entityList = mapper.get償還払決定一覧(SyokanbaraiketteJohoMapperParameter
                .createSyokanbaraiketteJohoMapperParameter(hiHokenshaNo, serviceTeikyoYM, seiriNo, 食事費用));

        for (SyokanbaraiketeJohoEntity entity : entityList) {
            resultList.add(new SyokanbaraiketteJoho(entity));
        }
        return resultList;
    }
}
