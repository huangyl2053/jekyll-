/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanshikyuketteitsuchishohakkou;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshikyuketteitsuchishohakkou.ShokanShikyuKetteiTsuchishoHakkouBusiness;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteitsuchishohakkou.ShokanShikyuKetteiTsuchishoHakkouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanshikyuketteitsuchishohakkou.IShokanShikyuKetteiTsuchishoHakkouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払支給不支給決定情報取込共通処理。
 *
 * @reamsid_L DBC-5310-010 liuyl
 */
public class ShokanShikyuKetteiTsuchishoHakkouFinder {

    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private final DbT3105SogoJigyoTaishoshaDac 総合事業対象者Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShokanShikyuKetteiTsuchishoHakkouFinder() {
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.総合事業対象者Dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShokanShikyuKetteiTsuchishoHakkouFinder}のインスタンスを返します。
     *
     * @return ShokanShikyuKetteiTsuchishoHakkouFinder
     */
    public static ShokanShikyuKetteiTsuchishoHakkouFinder createInstance() {
        return InstanceProvider.create(ShokanShikyuKetteiTsuchishoHakkouFinder.class);
    }

    /**
     * 受給者台帳を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public List<JukyushaDaicho> get受給者台帳(HihokenshaNo 被保険者番号) {
        List<JukyushaDaicho> 受給者台帳List = new ArrayList<>();
        List<DbT4001JukyushaDaichoEntity> 受給者台帳EntityList = 受給者台帳Dac.get受給者台帳(被保険者番号);
        if (受給者台帳EntityList != null && !受給者台帳EntityList.isEmpty()) {
            for (DbT4001JukyushaDaichoEntity entity : 受給者台帳EntityList) {
                entity.initializeMd5();
                受給者台帳List.add(new JukyushaDaicho(entity));
            }
        }
        return 受給者台帳List;
    }

    /**
     * 総合事業対象者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<SogoJigyoTaishosha>
     */
    @Transaction
    public List<SogoJigyoTaishosha> get総合事業対象者(HihokenshaNo 被保険者番号) {
        List<SogoJigyoTaishosha> 総合事業対象者List = new ArrayList<>();
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者EntityList = 総合事業対象者Dac.get総合事業対象者(被保険者番号);
        if (総合事業対象者EntityList != null && !総合事業対象者EntityList.isEmpty()) {
            for (DbT3105SogoJigyoTaishoshaEntity entity : 総合事業対象者EntityList) {
                entity.initializeMd5();
                総合事業対象者List.add(new SogoJigyoTaishosha(entity));
            }
        }
        return 総合事業対象者List;
    }

    /**
     * 償還払支給判定結果を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<ShokanHanteiKekka>
     */
    @Transaction
    public List<ShokanHanteiKekka> select償還払支給判定結果(HihokenshaNo 被保険者番号) {
        List<ShokanHanteiKekka> 償還払支給判定結果List = new ArrayList<>();
        List<DbT3036ShokanHanteiKekkaEntity> 総合事業対象者EntityList = 償還払支給判定結果Dac.select償還払支給判定結果(被保険者番号);
        if (総合事業対象者EntityList != null && !総合事業対象者EntityList.isEmpty()) {
            for (DbT3036ShokanHanteiKekkaEntity entity : 総合事業対象者EntityList) {
                entity.initializeMd5();
                償還払支給判定結果List.add(new ShokanHanteiKekka(entity));
            }
        }
        return 償還払支給判定結果List;
    }

    /**
     * 償還払支給判定結果を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<ShokanShikyuKetteiTsuchishoHakkouBusiness>
     */
    @Transaction
    public List<ShokanShikyuKetteiTsuchishoHakkouBusiness> get償還払支給判定結果(HihokenshaNo 被保険者番号) {
        IShokanShikyuKetteiTsuchishoHakkouMapper mapper = mapperProvider.create(IShokanShikyuKetteiTsuchishoHakkouMapper.class);
        List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List = new ArrayList<>();
        List<ShokanShikyuKetteiTsuchishoHakkouEntity> 償還払支給判定結果EntityList = mapper.get償還払支給判定結果(被保険者番号);
        if (償還払支給判定結果EntityList != null && !償還払支給判定結果EntityList.isEmpty()) {
            for (ShokanShikyuKetteiTsuchishoHakkouEntity entity : 償還払支給判定結果EntityList) {
                entity.initializeMd5ToEntities();
                償還払支給判定結果List.add(new ShokanShikyuKetteiTsuchishoHakkouBusiness(entity));
            }
        }
        return 償還払支給判定結果List;
    }
}
