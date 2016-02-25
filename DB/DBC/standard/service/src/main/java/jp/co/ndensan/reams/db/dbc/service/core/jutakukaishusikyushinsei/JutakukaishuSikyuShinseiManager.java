/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JutakukaishuJizenShinseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.UpdSyokanbaraiketeJoho;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjutakukaishu.ShokanJutakuKaishuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiKey;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.GeifuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei.JutakukaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3049ShokanJutakuKaishuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishusikyushinsei.IJutakukaishuSikyuShinseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuketteikyufujissekihennsyu.JutakuKaishuKetteiKyufujissekiHennsyuManager;
import jp.co.ndensan.reams.db.dbc.service.core.jyutakukaisyuyichiran.JyutakukaisyuyichiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修費支給申請
 */
public class JutakukaishuSikyuShinseiManager {

    private final MapperProvider mapperProvider;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3038ShokanKihonDac 償還払請求基本Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3049ShokanJutakuKaishuDac 償還払請求住宅改修Dac;

    /**
     * コンストラクタです。
     */
    JutakukaishuSikyuShinseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.償還払請求基本Dac = InstanceProvider.create(DbT3038ShokanKihonDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.償還払請求住宅改修Dac = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JutakukaishuSikyuShinseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JutakukaishuSikyuShinseiManager}のインスタンス
     */
    public static JutakukaishuSikyuShinseiManager createInstance() {

        return InstanceProvider.create(JutakukaishuSikyuShinseiManager.class);
    }

    /**
     * 支給申請一覧取得
     *
     * @param 被保険者番号 被保険者番号
     * @return 住宅改修費支給申請情報リスト （List<JutakukaishuSikyuShinseiResult>）
     */
    public List<JutakukaishuSikyuShinseiResult> getShokanShikyuShinseiList(HihokenshaNo 被保険者番号) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("hiHokenshaNo", 被保険者番号);
        IJutakukaishuSikyuShinseiMapper mapper = mapperProvider.create(IJutakukaishuSikyuShinseiMapper.class);
        List<JutakukaishuSikyuShinseiEntity> 住宅改修費支給申請情報List = mapper.get住宅改修費支給申請情報(parameter);
        List<JutakukaishuSikyuShinseiEntity> 住宅改修費事前申請情報List = mapper.get住宅改修費事前申請情報(parameter);
        if ((住宅改修費支給申請情報List == null || 住宅改修費支給申請情報List.isEmpty())
                && (住宅改修費事前申請情報List == null || 住宅改修費事前申請情報List.isEmpty())) {
            return null;
        }
        List<JutakukaishuSikyuShinseiEntity> list = new ArrayList<>();
        if (住宅改修費支給申請情報List != null && !住宅改修費支給申請情報List.isEmpty()) {
            for (JutakukaishuSikyuShinseiEntity 住宅改修費支給申請情報 : 住宅改修費支給申請情報List) {
                list.add(住宅改修費支給申請情報);
            }
        }
        if (住宅改修費事前申請情報List != null && !住宅改修費事前申請情報List.isEmpty()) {
            for (JutakukaishuSikyuShinseiEntity 住宅改修費事前申請情報 : 住宅改修費事前申請情報List) {
                list.add(住宅改修費事前申請情報);
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<JutakukaishuSikyuShinseiEntity>() {
            @Override
            public int compare(JutakukaishuSikyuShinseiEntity o1, JutakukaishuSikyuShinseiEntity o2) {
                int flag = o2.getServiceTeikyoYM().compareTo(o1.getServiceTeikyoYM());
                if (0 == flag) {
                    flag = o2.getShinseiYMD().compareTo(o1.getShinseiYMD());
                    if (0 == flag) {
                        flag = o2.getSeiriNo().compareTo(o1.getSeiriNo());
                    }
                }
                return flag;
            }
        });
        List<JutakukaishuSikyuShinseiResult> resultList = new ArrayList<>();
        for (JutakukaishuSikyuShinseiEntity entity : list) {
            resultList.add(new JutakukaishuSikyuShinseiResult(entity));
        }
        return resultList;
    }

    /**
     * 事前申請一覧取得
     *
     * @param 被保険者番号 被保険者番号
     * @return 住宅改修費事前申請情報リスト　（List<JutakukaishuJizenShinseiResult>）
     */
    public List<JutakukaishuJizenShinseiResult> getShokanJizenShinseiList(HihokenshaNo 被保険者番号) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("hiHokenshaNo", 被保険者番号);
        IJutakukaishuSikyuShinseiMapper mapper = mapperProvider.create(IJutakukaishuSikyuShinseiMapper.class);
        List<JutakukaishuJizenShinseiEntity> 事前申請一覧List = mapper.get事前申請一覧(parameter);
        if (事前申請一覧List == null || 事前申請一覧List.isEmpty()) {
            return null;
        }
        Collections.sort(事前申請一覧List, new Comparator<JutakukaishuJizenShinseiEntity>() {
            @Override
            public int compare(JutakukaishuJizenShinseiEntity o1, JutakukaishuJizenShinseiEntity o2) {
                int flag = o2.getServiceTeikyoYM().compareTo(o1.getServiceTeikyoYM());
                if (0 == flag) {
                    flag = o2.getShinseiYMD().compareTo(o1.getShinseiYMD());
                    if (0 == flag) {
                        flag = o2.getSeiriNo().compareTo(o1.getSeiriNo());
                    }
                }
                return flag;
            }
        });
        List<JutakukaishuJizenShinseiResult> resultList = new ArrayList<>();
        for (JutakukaishuJizenShinseiEntity 事前申請一覧 : 事前申請一覧List) {
            resultList.add(new JutakukaishuJizenShinseiResult(事前申請一覧));
        }
        return resultList;
    }

    /**
     * 償還払支給申請情報取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return ShokanShinsei
     */
    public ShokanShinsei getShokanKihonShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        JutakukaishuSikyuShinseiKey key = JutakukaishuSikyuShinseiKey.createSelectByKeyParam(被保険者番号,
                サービス提供年月, 整理番号);
        IJutakukaishuSikyuShinseiMapper mapper = mapperProvider.create(IJutakukaishuSikyuShinseiMapper.class);
        DbT3034ShokanShinseiEntity entity = mapper.get償還払支給申請(key);
        if (entity == null) {
            return null;
        }
        return new ShokanShinsei(entity);
    }

    /**
     * 償還払支給判定結果取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return ShokanHanteiKekka
     */
    public ShokanHanteiKekka getShokanHanteiKekka(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<DbT3036ShokanHanteiKekkaEntity> entityList
                = 償還払支給判定結果Dac.select償還払支給判定結果(被保険者番号, サービス提供年月, 整理番号);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        return new ShokanHanteiKekka(entityList.get(0));
    }

    /**
     * 償還払請求基本取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return ShokanKihon
     */
    public ShokanKihon getShokanKihon(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<DbT3038ShokanKihonEntity> entityList
                = 償還払請求基本Dac.selectByKey(被保険者番号, サービス提供年月, 整理番号);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        return new ShokanKihon(entityList.get(0));
    }

    /**
     * 償還払請求集計取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return ShokanShukei
     */
    public ShokanShukei getShokanSyukei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号,
            JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        List<DbT3053ShokanShukeiEntity> entityList = 償還払請求集計Dac.selectByKey(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        return new ShokanShukei(entityList.get(0));
    }

    /**
     * DB登録
     *
     * @param dbt3034 dbt3034
     * @param dbt3038 dbt3038
     * @param dbt3053 dbt3053
     * @param dbt3049List dbt3049List
     * @return 完了ステータス
     */
    @Transaction
    public boolean saveDBDate(ShokanShinsei dbt3034, ShokanKihon dbt3038,
            ShokanShukei dbt3053, List<ShokanJutakuKaishu> dbt3049List) {
        if (dbt3034 != null) {
            償還払支給申請Dac.save(dbt3034.toEntity());
        }
        if (dbt3038 != null) {
            償還払請求基本Dac.save(dbt3038.toEntity());
        }
        if (dbt3049List != null && !dbt3049List.isEmpty()) {
            for (ShokanJutakuKaishu dbt3049 : dbt3049List) {
                償還払請求住宅改修Dac.save(dbt3049.toEntity());
            }
        }
        if (dbt3053 != null) {
            償還払請求集計Dac.save(dbt3053.toEntity());
        }
        return true;
    }

    /**
     * DB更新
     *
     * @param 識別コード 識別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param dbt3034 dbt3034
     * @param dbt3038 dbt3038
     * @param 画面モード 画面モード
     * @param dbt3049List dbt3049List
     * @param dbt3053 dbt3053
     * @param dbt3036 dbt3036
     * @return 完了ステータス
     */
    @Transaction
    public boolean updDBDate(RString 画面モード, ShikibetsuCode 識別コード, HokenshaNo 証記載保険者番号,
            ShokanShinsei dbt3034, ShokanKihon dbt3038, List<ShokanJutakuKaishu> dbt3049List,
            ShokanShukei dbt3053, ShokanHanteiKekka dbt3036) {
        RString モード_審査 = new RString("審査");
        RString モード_取消 = new RString("取消");
        償還払支給申請Dac.save(dbt3034.toEntity());

        if (モード_取消.equals(画面モード)) {
            return true;
        }
        if (モード_審査.equals(画面モード)) {
            償還払支給判定結果Dac.save(dbt3036.toEntity());
        }
        if (dbt3038 != null) {
            償還払請求基本Dac.save(dbt3038.toEntity());
        }
        List<DbT3049ShokanJutakuKaishuEntity> dbt3049tmpList = new ArrayList<>();
        if (dbt3049List != null && !dbt3049List.isEmpty()) {
            for (ShokanJutakuKaishu dbt3049 : dbt3049List) {
                if (!EntityDataState.Deleted.equals(dbt3049.toEntity().getState())) {
                    dbt3049tmpList.add(dbt3049.toEntity());
                }
                償還払請求住宅改修Dac.save(dbt3049.toEntity());
            }
        }
        DbT3053ShokanShukeiEntity dbt3053entity = new DbT3053ShokanShukeiEntity();
        if (dbt3053 != null) {
            償還払請求集計Dac.save(dbt3053.toEntity());
            dbt3053entity = 償還払請求集計Dac.selectByKey(dbt3053.toEntity().getHiHokenshaNo(),
                    dbt3053.toEntity().getServiceTeikyoYM(), dbt3053.toEntity().getSeiriNo(),
                    dbt3053.toEntity().getJigyoshaNo(), dbt3053.toEntity().getYoshikiNo(),
                    dbt3053.toEntity().getMeisaiNo(), dbt3053.toEntity().getRenban());
        }
        if (モード_審査.equals(画面モード)) {
            GeifuEntity kyufuentity = new GeifuEntity();
            kyufuentity.setShikibetsuCode(識別コード);
            kyufuentity.setShoKisaiHokenshaNo(証記載保険者番号);
            kyufuentity.setShinsaYM(new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString()));
            kyufuentity.setKyufuSakuseiKubunCode(new RString("1"));
            JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                    = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
            manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049tmpList, dbt3053entity);
        }
        return true;
    }

    /**
     * DB削除
     *
     * @param 決定日 決定日
     * @param 識別コード 識別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param dbt3049List dbt3049List
     * @param dbt3053 dbt3053
     * @param dbt3034 dbt3034
     * @param dbt3038 dbt3038
     * @param dbt3036 dbt3036
     * @return 完了ステータス
     */
    @Transaction
    public boolean delDBDate(FlexibleDate 決定日, ShikibetsuCode 識別コード, HokenshaNo 証記載保険者番号,
            List<ShokanJutakuKaishu> dbt3049List, ShokanShukei dbt3053,
            ShokanShinsei dbt3034, ShokanKihon dbt3038, ShokanHanteiKekka dbt3036) {

        List<DbT3049ShokanJutakuKaishuEntity> dbt3049tmpList = new ArrayList<>();
        DbT3049ShokanJutakuKaishuEntity dbt3049entity;
        if (dbt3049List != null && !dbt3049List.isEmpty()) {
            for (ShokanJutakuKaishu dbt3049 : dbt3049List) {
                償還払請求住宅改修Dac.save(dbt3049.toEntity());
                dbt3049entity = 償還払請求住宅改修Dac.selectByKey(dbt3049.toEntity().getHiHokenshaNo(),
                        dbt3049.toEntity().getServiceTeikyoYM(),
                        dbt3049.toEntity().getSeiriNo(),
                        dbt3049.toEntity().getJigyoshaNo(),
                        dbt3049.toEntity().getYoshikiNo(),
                        dbt3049.toEntity().getMeisaiNo(),
                        dbt3049.toEntity().getRenban());
                dbt3049tmpList.add(dbt3049entity);
            }
        }
        DbT3053ShokanShukeiEntity dbt3053entity = new DbT3053ShokanShukeiEntity();
        if (dbt3053 != null) {
            償還払請求集計Dac.save(dbt3053.toEntity());
            dbt3053entity = 償還払請求集計Dac.selectByKey(dbt3053.toEntity().getHiHokenshaNo(),
                    dbt3053.toEntity().getServiceTeikyoYM(), dbt3053.toEntity().getSeiriNo(),
                    dbt3053.toEntity().getJigyoshaNo(), dbt3053.toEntity().getYoshikiNo(),
                    dbt3053.toEntity().getMeisaiNo(), dbt3053.toEntity().getRenban());
        }
        if (dbt3038 != null) {
            償還払請求基本Dac.save(dbt3038.toEntity());
        }
        if (dbt3036 != null) {
            償還払支給判定結果Dac.save(dbt3036.toEntity());
        }
        if (dbt3034 != null) {
            償還払支給申請Dac.save(dbt3034.toEntity());
        }
        GeifuEntity kyufuentity = new GeifuEntity();
        kyufuentity.setShikibetsuCode(識別コード);
        kyufuentity.setShoKisaiHokenshaNo(証記載保険者番号);
        kyufuentity.setShinsaYM(決定日.getYearMonth());
        kyufuentity.setKyufuSakuseiKubunCode(new RString("3"));

        if (dbt3036 != null
                && ShikyuFushikyuKubun.支給.getコード().equals(dbt3036.toEntity().getShikyuHushikyuKetteiKubun())) {
            JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                    = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
            manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049tmpList, dbt3053entity);
        }
        return true;
    }

    /**
     * 償還払決定情報更新
     *
     * @param parameter parameter
     * @param dbt3034 dbt3034
     * @param dbt3053 dbt3053
     * @return 完了ステータス
     */
    @Transaction
    public boolean updSyokanbaraiketeJoho(UpdSyokanbaraiketeJoho parameter,
            ShokanShinsei dbt3034, ShokanShukei dbt3053) {
        if (dbt3034 != null) {
            償還払支給申請Dac.save(dbt3034.toEntity());
        }

        ShokanHanteiKekka kekka = getShokanHanteiKekka(parameter.get被保険者番号(),
                parameter.getサービス提供年月(), parameter.get整理番号());
        DbT3036ShokanHanteiKekkaEntity dbt3036entity = new DbT3036ShokanHanteiKekkaEntity();
        if (kekka == null) {
            dbt3036entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbt3036entity.setServiceTeikyoYM(parameter.getサービス提供年月());
            dbt3036entity.setSeiriNo(parameter.get整理番号());
            dbt3036entity.setKetteiYMD(parameter.get決定年月日());
            dbt3036entity.setShikyuHushikyuKetteiKubun(parameter.get支給決定区分());
            dbt3036entity.setShiharaiKingaku(parameter.get支払金額());
            dbt3036entity.setZenkaiShiharaiKingaku(parameter.get前回支払金額());
            dbt3036entity.setSagakuKingakuGokei(parameter.get差額金額合計());
            dbt3036entity.setState(EntityDataState.Added);
            償還払支給判定結果Dac.save(dbt3036entity);
        } else {
            dbt3036entity = kekka.toEntity();
            dbt3036entity.setKetteiYMD(parameter.get決定年月日());
            dbt3036entity.setShikyuHushikyuKetteiKubun(parameter.get支給決定区分());
            dbt3036entity.setShiharaiKingaku(parameter.get支払金額());
            dbt3036entity.setSagakuKingakuGokei(parameter.get差額金額合計());
            dbt3036entity.setState(EntityDataState.Modified);
            償還払支給判定結果Dac.save(dbt3036entity);
        }
        DbT3053ShokanShukeiEntity dbt3053entity = null;
        if (dbt3053 != null) {
            償還払請求集計Dac.save(dbt3053.toEntity());
            dbt3053entity = 償還払請求集計Dac.selectByKey(dbt3053.toEntity().getHiHokenshaNo(),
                    dbt3053.toEntity().getServiceTeikyoYM(), dbt3053.toEntity().getSeiriNo(),
                    dbt3053.toEntity().getJigyoshaNo(), dbt3053.toEntity().getYoshikiNo(),
                    dbt3053.toEntity().getMeisaiNo(), dbt3053.toEntity().getRenban());
        }
        GeifuEntity kyufuentity = new GeifuEntity();
        kyufuentity.setShikibetsuCode(parameter.get識別コード());
        kyufuentity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
        RString 不支給 = ShikyuFushikyuKubun.不支給.getコード();
        RString 支給 = ShikyuFushikyuKubun.支給.getコード();
        if (kekka == null) {
            if (支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(new RString("1"));
            }
        } else {
            if (不支給.equals(dbt3036entity.getShikyuHushikyuKetteiKubun()) && 支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(new RString("1"));
            } else if (支給.equals(dbt3036entity.getShikyuHushikyuKetteiKubun())
                    && 不支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(new RString("3"));
            } else if (支給.equals(dbt3036entity.getShikyuHushikyuKetteiKubun())
                    && 支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(new RString("2"));
            }
        }

        List<DbT3049ShokanJutakuKaishuEntity> dbt3049List = new ArrayList<>();
        JyutakukaisyuyichiranFinder finder = JyutakukaisyuyichiranFinder.createInstance();
        SearchResult<ShokanJutakuKaishuBusiness> tmpList
                = finder.selectJyutakukaisyuList(parameter.get被保険者番号(), parameter.getサービス提供年月(),
                        parameter.get整理番号(), parameter.get証明書());
        if (!tmpList.records().isEmpty()) {
            for (ShokanJutakuKaishuBusiness tmp : tmpList.records()) {
                dbt3049List.add(tmp.get住宅改修());
            }
        }
        JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
        manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049List, dbt3053entity);
        return true;
    }

    /**
     * 様式名称取得
     *
     * @param サービス提供年月 サービス提供年月
     * @return 識別番号管理Entityリスト　（List<ShikibetsuNoKanri>）
     */
    public List<ShikibetsuNoKanri> getYoshikiName(FlexibleYearMonth サービス提供年月) {
        List<DbT3118ShikibetsuNoKanriEntity> entityList
                = 識別番号管理Dac.select様式名称(サービス提供年月);
        List<ShikibetsuNoKanri> 様式名称List = new ArrayList<>();
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        for (DbT3118ShikibetsuNoKanriEntity entity : entityList) {
            様式名称List.add(new ShikibetsuNoKanri(entity));
        }
        return 様式名称List;
    }
}
