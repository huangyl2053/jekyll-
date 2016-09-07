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
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JutakukaishuJizenShinseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JyutakuGaisyunaiyoListParameter;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.UpdSyokanbaraiketeJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiKey;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.syokanbaraikettejoho.SyokanbaraiketteJohoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinsei.GeifuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei.JutakukaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3017KyufujissekiKihonDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3049ShokanJutakuKaishuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishusikyushinsei.IJutakukaishuSikyuShinseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuketteikyufujissekihennsyu.JutakuKaishuKetteiKyufujissekiHennsyuManager;
import jp.co.ndensan.reams.db.dbc.service.core.jyutakukaisyuyichiran.JyutakukaisyuyichiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
 *
 * @reamsid_L DBC-0992-150 xicongwang
 */
public class JutakukaishuSikyuShinseiManager {

    private static final RString キー = new RString("hiHokenshaNo");
    private static final RString モード_審査 = new RString("審査モード");
    private static final RString モード_取消 = new RString("取消モード");
    private static final RString 住宅改修_削除 = new RString("削除");
    private static final RString 区分_コード1 = new RString("1");
    private static final RString 区分_コード2 = new RString("2");
    private static final RString 区分_コード3 = new RString("3");
    private static final RString メッセージ_1 = new RString("住宅改修データがありません。");
    private static final RString メッセージ_2 = new RString("着工日が同一年月を設定してください。");
    private static final RString メッセージ_3 = new RString("対象住宅住所が同じ住所を設定してください。");
    private final MapperProvider mapperProvider;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3038ShokanKihonDac 償還払請求基本Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3049ShokanJutakuKaishuDac 償還払請求住宅改修Dac;
    private final DbT3017KyufujissekiKihonDac 給付実績基本Dac;

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
        this.給付実績基本Dac = InstanceProvider.create(DbT3017KyufujissekiKihonDac.class);

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
        parameter.put(キー.toString(), 被保険者番号);
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
        parameter.put(キー.toString(), 被保険者番号);
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
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
    public boolean updDBDate(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号,
            RString 画面モード, ShikibetsuCode 識別コード, HokenshaNo 証記載保険者番号,
            ShokanShinsei dbt3034, ShokanKihon dbt3038, List<ShokanJutakuKaishu> dbt3049List,
            ShokanShukei dbt3053, ShokanHanteiKekka dbt3036) {

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
                if (EntityDataState.Deleted.equals(dbt3049.toEntity().getState())) {
                    償還払請求住宅改修Dac.delete(dbt3049.toEntity());
                } else {
                    償還払請求住宅改修Dac.save(dbt3049.toEntity());
                }
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
            kyufuentity.setKyufuSakuseiKubunCode(区分_コード1);
            ShokanKihon kihon = getShokanKihon(被保険者番号, サービス提供年月, 整理番号);
            DbT3038ShokanKihonEntity entity = null;
            if (kihon != null) {
                entity = kihon.toEntity();
            }
            JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                    = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
            manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049tmpList, dbt3053entity, entity);
        }
        return true;
    }

    /**
     * DB削除
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
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
    public boolean delDBDate(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号,
            FlexibleDate 決定日, ShikibetsuCode 識別コード, HokenshaNo 証記載保険者番号,
            List<ShokanJutakuKaishu> dbt3049List, ShokanShukei dbt3053,
            ShokanShinsei dbt3034, ShokanKihon dbt3038, ShokanHanteiKekka dbt3036) {

        List<DbT3049ShokanJutakuKaishuEntity> dbt3049tmpList = new ArrayList<>();
        if (dbt3049List != null && !dbt3049List.isEmpty()) {
            for (ShokanJutakuKaishu dbt3049 : dbt3049List) {
                DbT3049ShokanJutakuKaishuEntity entity = dbt3049.toEntity();
                entity.setState(EntityDataState.Deleted);
                償還払請求住宅改修Dac.delete(entity);
                dbt3049tmpList.add(dbt3049.toEntity());
            }
        }
        DbT3053ShokanShukeiEntity dbt3053entity = new DbT3053ShokanShukeiEntity();
        if (dbt3053 != null) {
            DbT3053ShokanShukeiEntity entity = dbt3053.toEntity();
            entity.setState(EntityDataState.Deleted);
            償還払請求集計Dac.delete(entity);
            dbt3053entity = dbt3053.toEntity();
        }

        if (dbt3036 != null) {
            DbT3036ShokanHanteiKekkaEntity entity = dbt3036.toEntity();
            entity.setState(EntityDataState.Deleted);
            償還払支給判定結果Dac.delete(entity);
        }
        if (dbt3034 != null) {
            DbT3034ShokanShinseiEntity entity = dbt3034.toEntity();
            entity.setState(EntityDataState.Deleted);
            償還払支給申請Dac.delete(entity);
        }
        GeifuEntity kyufuentity = new GeifuEntity();
        kyufuentity.setShikibetsuCode(識別コード);
        kyufuentity.setShoKisaiHokenshaNo(証記載保険者番号);
        kyufuentity.setShinsaYM((決定日 == null || 決定日.isEmpty()) ? FlexibleYearMonth.EMPTY : 決定日.getYearMonth());
        kyufuentity.setKyufuSakuseiKubunCode(区分_コード3);
        ShokanKihon kihon = getShokanKihon(被保険者番号, サービス提供年月, 整理番号);
        DbT3038ShokanKihonEntity entity = null;
        if (kihon != null) {
            entity = kihon.toEntity();
        }
        if (dbt3038 != null) {
            DbT3038ShokanKihonEntity dbt3038entity = dbt3038.toEntity();
            dbt3038entity.setState(EntityDataState.Deleted);
            償還払請求基本Dac.delete(dbt3038entity);
        }
        if (dbt3036 != null
                && ShikyuFushikyuKubun.支給.getコード().equals(dbt3036.toEntity().getShikyuHushikyuKetteiKubun())) {
            JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                    = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
            manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049tmpList, dbt3053entity, entity);
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
        HokenshaNo 証記載保険者番号 = null;
        if (dbt3034 != null) {
            DbT3034ShokanShinseiEntity dbt3034Entity = 償還払支給申請Dac.selectByKey(
                    dbt3034.get被保険者番号(), dbt3034.getサービス提供年月(), dbt3034.get整理番号());
            dbt3034Entity.setShikyuShinseiShinsaKubun(dbt3034.get支給申請審査区分());
            dbt3034Entity.setShinsaHohoKubun(dbt3034.get審査方法区分());
            dbt3034Entity.setShinsaYMD(dbt3034.get審査年月日());
            dbt3034Entity.setShinsaKekka(dbt3034.get審査結果());
            dbt3034Entity.setState(EntityDataState.Modified);
            証記載保険者番号 = new HokenshaNo(dbt3034Entity.getShoKisaiHokenshaNo().value());
            償還払支給申請Dac.save(dbt3034Entity);
        }

        ShokanHanteiKekka kekka = getShokanHanteiKekka(parameter.get被保険者番号(),
                parameter.getサービス提供年月(), parameter.get整理番号());
        DbT3036ShokanHanteiKekkaEntity dbt3036entity = new DbT3036ShokanHanteiKekkaEntity();
        if (kekka == null) {
            dbt3036entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbt3036entity.setServiceTeikyoYM(parameter.getサービス提供年月());
            dbt3036entity.setSeiriNo(parameter.get整理番号());
            dbt3036entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(parameter.get証記載保険者番号().value()));
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

        DbT3053ShokanShukeiEntity dbT3053Entity = null;
        if (dbt3053 != null) {
            SyokanbaraiketteJohoParameter mybatisParameter = SyokanbaraiketteJohoParameter.createMybatisParam(parameter.get被保険者番号(),
                    parameter.getサービス提供年月(), parameter.get整理番号());
            DbT3053ShokanShukeiEntity entity = 償還払請求集計Dac.select償還払請求集計(mybatisParameter);
            entity.setShinsaHohoKubunCode(dbt3053.get審査方法区分コード());
            entity.setShinsaYM(dbt3053.get審査年月());
            entity.setShikyuKubunCode(dbt3053.get支給区分コード());
            entity.setShikyuKingaku(dbt3053.get支払金額());
            entity.setZougenten(dbt3053.get増減点());
            entity.setSeikyugakuSagakuKingaku(dbt3053.get請求額差額金額());
            entity.setZougenRiyu(dbt3053.get増減理由等());
            entity.setHushikyuRiyu(dbt3053.get不支給理由等());
            entity.setKounyuKaishuRireki(dbt3053.get購入_改修履歴等());
            entity.setState(EntityDataState.Modified);
            償還払請求集計Dac.save(entity);

            dbT3053Entity = 償還払請求集計Dac.selectByKey(entity.getHiHokenshaNo(),
                    entity.getServiceTeikyoYM(), entity.getSeiriNo(),
                    entity.getJigyoshaNo(), entity.getYoshikiNo(),
                    entity.getMeisaiNo(), entity.getRenban());
        }
        GeifuEntity kyufuentity = new GeifuEntity();
        kyufuentity.setShikibetsuCode(parameter.get識別コード());
        kyufuentity.setShoKisaiHokenshaNo(証記載保険者番号);
        RString 不支給 = ShikyuFushikyuKubun.不支給.getコード();
        RString 支給 = ShikyuFushikyuKubun.支給.getコード();
        if (kekka == null) {
            if (支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(区分_コード1);
            } else if (不支給.equals(parameter.get支給区分())) {
                return true;
            }
        } else {
            if (不支給.equals(kekka.toEntity().getShikyuHushikyuKetteiKubun()) && 不支給.equals(parameter.get支給区分())) {
                return true;
            } else if (不支給.equals(kekka.toEntity().getShikyuHushikyuKetteiKubun()) && 支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(区分_コード1);
            } else if (支給.equals(kekka.toEntity().getShikyuHushikyuKetteiKubun())
                    && 不支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(区分_コード3);
            } else if (支給.equals(kekka.toEntity().getShikyuHushikyuKetteiKubun())
                    && 支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(区分_コード2);
            }
        }

        List<DbT3049ShokanJutakuKaishuEntity> dbt3049List = new ArrayList<>();
        JyutakukaisyuyichiranFinder finder = JyutakukaisyuyichiranFinder.createInstance();
        SearchResult<ShokanJutakuKaishu> tmpList
                = finder.selectJyutakukaisyuList(parameter.get被保険者番号(), parameter.getサービス提供年月(),
                        parameter.get整理番号(), parameter.get証明書());
        if (!tmpList.records().isEmpty()) {
            for (ShokanJutakuKaishu tmp : tmpList.records()) {
                dbt3049List.add(tmp.toEntity());
            }
        }
        ShokanKihon kihon
                = getShokanKihon(parameter.get被保険者番号(), parameter.getサービス提供年月(), parameter.get整理番号());
        DbT3038ShokanKihonEntity entity = null;
        if (kihon != null) {
            entity = kihon.toEntity();
        }
        JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
        manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049List, dbT3053Entity, entity);
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
        List<KyufujissekiKihon> 給付実績基本情報List = new ArrayList<>();
        List<DbT3017KyufujissekiKihonEntity> entityList
                = 給付実績基本Dac.select給付実績基本情報(様式番号, 保険者番号, 被保険者番号, サービス提供年月, 給付実績区分コード, 整理番号);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        for (DbT3017KyufujissekiKihonEntity entity : entityList) {
            給付実績基本情報List.add(new KyufujissekiKihon(entity));
        }
        return 給付実績基本情報List;
    }

    /**
     * 住宅改修内容のチェックメソッドです。
     *
     * @param parameterList 住宅改修内容一覧
     * @param 提供着工年月 FlexibleYearMonth
     * @return 住宅改修内容チェックエラーメッセージ
     */
    public RString checkJyutakuGaisyunaiyoList(List<JyutakuGaisyunaiyoListParameter> parameterList,
            FlexibleYearMonth 提供着工年月) {

        if (parameterList == null || parameterList.isEmpty()) {
            return メッセージ_1;
        }
        List<JyutakuGaisyunaiyoListParameter> tmpList = new ArrayList<>();
        for (JyutakuGaisyunaiyoListParameter parameter : parameterList) {
            if (!住宅改修_削除.equals(parameter.get状態())) {
                tmpList.add(parameter);
            }
        }
        if (tmpList.isEmpty()) {
            return メッセージ_1;
        }
        RString wk対象住宅住所 = tmpList.get(0).get対象住宅住所();
        for (JyutakuGaisyunaiyoListParameter tmp : tmpList) {
            if (提供着工年月 != null && !提供着工年月.equals(tmp.get着工年月日().getYearMonth())) {
                return メッセージ_2;
            }
            if (wk対象住宅住所 != null && !wk対象住宅住所.equals(tmp.get対象住宅住所())) {
                return メッセージ_3;
            }
        }
        return RString.EMPTY;
    }
}
