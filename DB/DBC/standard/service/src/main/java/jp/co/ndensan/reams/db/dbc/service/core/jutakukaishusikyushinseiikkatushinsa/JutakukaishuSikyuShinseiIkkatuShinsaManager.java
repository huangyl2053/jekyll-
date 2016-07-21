/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinseiikkatushinsa;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa.MiShinsaSikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa.SaveIkkatuShinsaDate;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishusikyushinseiikkatushinsa.MiShinasaShikyuShinseiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinsei.GeifuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinseiikkatushinsa.MiShinsaSikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3049ShokanJutakuKaishuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishusikyushinseiikkatushinsa.IJutakukaishuSikyuShinseiIkkatuShinsaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuketteikyufujissekihennsyu.JutakuKaishuKetteiKyufujissekiHennsyuManager;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修費支給申請一括審査・決定
 *
 * @reamsid_L DBC-0991-040 xicongwang
 */
public class JutakukaishuSikyuShinseiIkkatuShinsaManager {

    private static final RString 区分_コード = new RString("1");
    private final MapperProvider mapperProvider;
    private final DbT3049ShokanJutakuKaishuDac 償還払請求住宅改修Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;

    /**
     * コンストラクタです。
     */
    JutakukaishuSikyuShinseiIkkatuShinsaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.償還払請求住宅改修Dac = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JutakukaishuSikyuShinseiIkkatuShinsaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JutakukaishuSikyuShinseiIkkatuShinsaManager}のインスタンス
     */
    public static JutakukaishuSikyuShinseiIkkatuShinsaManager createInstance() {

        return InstanceProvider.create(JutakukaishuSikyuShinseiIkkatuShinsaManager.class);
    }

    /**
     * 未審査支給申請一覧取得
     *
     * @param 支給申請開始日 支給申請開始日
     * @param 支給申請終了日 支給申請終了日
     * @return List<MiShinsaSikyuShinsei>
     */
    public List<MiShinsaSikyuShinsei> getMiShinasaShikyuShinseiList(FlexibleDate 支給申請開始日,
            FlexibleDate 支給申請終了日) {

        ShikibetsuTaishoPSMSearchKeyBuilder builder
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey key = builder.build();
        MiShinasaShikyuShinseiParameter parameter
                = new MiShinasaShikyuShinseiParameter(key, 支給申請開始日, 支給申請終了日);
        IJutakukaishuSikyuShinseiIkkatuShinsaMapper mapper
                = mapperProvider.create(IJutakukaishuSikyuShinseiIkkatuShinsaMapper.class);
        List<MiShinsaSikyuShinseiEntity> entityList = mapper.get未審査支給申請情報(parameter);
        if (entityList == null) {
            return new ArrayList<>();
        }
        List<MiShinsaSikyuShinsei> tmpList = new ArrayList<>();
        for (MiShinsaSikyuShinseiEntity entity : entityList) {
            tmpList.add(new MiShinsaSikyuShinsei(new ShokanShinsei(entity.getDbt3034entity()),
                    entity.get識別コード(), entity.get氏名()));
        }
        return tmpList;
    }

    /**
     * 償還払請求住宅改修リスト取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return List<ShokanJutakuKaishu>
     */
    public List<ShokanJutakuKaishu> getShokanJutakuKaishuList(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {

        List<DbT3049ShokanJutakuKaishuEntity> entityList
                = 償還払請求住宅改修Dac.get住宅改修(被保険者番号, サービス提供年月, 整理番号);
        if (entityList == null) {
            return new ArrayList<>();
        }
        List<ShokanJutakuKaishu> 住宅改修List = new ArrayList<>();
        for (DbT3049ShokanJutakuKaishuEntity entity : entityList) {
            ShokanJutakuKaishu 住宅改修 = new ShokanJutakuKaishu(entity);
            住宅改修List.add(住宅改修);
        }
        return 住宅改修List;
    }

    /**
     * DB保存
     *
     * @param parameterList parameterList
     * @return 完了ステータス
     */
    @Transaction
    public boolean saveDBDate(List<SaveIkkatuShinsaDate> parameterList) {

        if (parameterList != null && !parameterList.isEmpty()) {
            for (SaveIkkatuShinsaDate parameter : parameterList) {
                DbT3034ShokanShinseiEntity dbt3034entity = parameter.getDbt3034entity().toEntity();
                dbt3034entity.setState(EntityDataState.Modified);
                償還払支給申請Dac.save(dbt3034entity);
                DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNo(parameter.get整理番号());
                entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(parameter.get証記載保険者番号().getColumnValue()));
                entity.setKetteiYMD(parameter.get決定年月日());
                entity.setShikyuHushikyuKetteiKubun(parameter.get支給区分コード());
                entity.setShiharaiKingaku(parameter.get支払金額());
                entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(entity);
                List<DbT3053ShokanShukeiEntity> dbt3053EntityList
                        = 償還払請求集計Dac.select住宅改修費(parameter.get被保険者番号(),
                                parameter.getサービス提供年月(), parameter.get整理番号());
                DbT3053ShokanShukeiEntity dbt3053Entity = dbt3053EntityList.get(0);
                dbt3053Entity.setShinsaYM(new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString().toString()));
                dbt3053Entity.setShikyuKubunCode(parameter.get支給区分コード());
                dbt3053Entity.setState(EntityDataState.Modified);
                償還払請求集計Dac.save(dbt3053Entity);
                GeifuEntity kyufuentity = new GeifuEntity();
                kyufuentity.setShikibetsuCode(parameter.get識別コード());
                kyufuentity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
                kyufuentity.setShinsaYM(parameter.get決定年月日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(区分_コード);

                List<ShokanJutakuKaishu> 住宅改修List
                        = getShokanJutakuKaishuList(parameter.get被保険者番号(),
                                parameter.getサービス提供年月(), parameter.get整理番号());
                List<DbT3049ShokanJutakuKaishuEntity> dbt3049List = new ArrayList<>();
                if (住宅改修List != null && !住宅改修List.isEmpty()) {
                    for (ShokanJutakuKaishu 住宅改修 : 住宅改修List) {
                        dbt3049List.add(住宅改修.toEntity());
                    }
                }
                JutakukaishuSikyuShinseiManager manage = JutakukaishuSikyuShinseiManager.createInstance();
                ShokanKihon kihon
                        = manage.getShokanKihon(parameter.get被保険者番号(), parameter.getサービス提供年月(), parameter.get整理番号());
                DbT3038ShokanKihonEntity dbt3038entity = null;
                if (kihon != null) {
                    dbt3038entity = kihon.toEntity();
                }
                JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                        = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
                manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049List, dbt3053Entity, dbt3038entity);
            }
        }
        return true;
    }
}
