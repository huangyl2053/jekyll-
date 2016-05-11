/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tennyutenshutsuhoryutaishosha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanri;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha.ITennyuTenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha.TennyushutsuHoryuTaishoshaBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha.TenshutsuHoryuTaishoshaBusiness;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryutaishosha.TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryutaishosha.TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyutenshutsuhoryutaishosha.ITennyuTenshutsuHoryuTaishoshaMapper;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1010TennyushutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1011TenshutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転入転出保留対象者管理のmanagerクラスです。
 *
 * @reamsid_L DBA-0470-010 wangxiaodong
 */
public class TennyuTenshutsuHoryuTaishoshaManager {

    private final MapperProvider mapperProvider;
    private final DbT1011TenshutsuHoryuTaishoshaDac tenshutsuHoryuTaishoshaDac;
    private final DbT1010TennyushutsuHoryuTaishoshaDac tennyushutsuHoryuTaishoshaDac;

    /**
     * コンストラクタです。
     */
    TennyuTenshutsuHoryuTaishoshaManager(MapperProvider mapperProvider, DbT1011TenshutsuHoryuTaishoshaDac tenshutsuHoryuTaishoshaDac,
            DbT1010TennyushutsuHoryuTaishoshaDac tennyushutsuHoryuTaishoshaDac) {
        this.mapperProvider = mapperProvider;
        this.tenshutsuHoryuTaishoshaDac = tenshutsuHoryuTaishoshaDac;
        this.tennyushutsuHoryuTaishoshaDac = tennyushutsuHoryuTaishoshaDac;
    }

    /**
     * コンストラクタです。
     */
    public TennyuTenshutsuHoryuTaishoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.tenshutsuHoryuTaishoshaDac = InstanceProvider.create(DbT1011TenshutsuHoryuTaishoshaDac.class);
        this.tennyushutsuHoryuTaishoshaDac = InstanceProvider.create(DbT1010TennyushutsuHoryuTaishoshaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TennyuTenshutsuHoryuTaishoshaManager}のインスタンスを返します。
     *
     * @return KijuntsukiShichosonjohoFinder
     */
    public static TennyuTenshutsuHoryuTaishoshaManager createInstance() {
        return InstanceProvider.create(TennyuTenshutsuHoryuTaishoshaManager.class);
    }

    /**
     * 転出保留対象者情報の取得処理します。
     *
     * @return SearchResult<ITennyuTenshutsuHoryuTaishosha>
     */
    @Transaction
    public SearchResult<ITennyuTenshutsuHoryuTaishosha> getTenshutsuHoryuTaishoshaList() {
        ITennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(ITennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TennyushutsuHoryuTaishoshaEntity> entityList = mapper.get転出保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuShutokuJogaishaKanri>emptyList(), 0, false);
        }
        List<ITennyuTenshutsuHoryuTaishosha> businessList = new ArrayList<>();
        for (TennyushutsuHoryuTaishoshaEntity entity : entityList) {
            businessList.add(new TennyushutsuHoryuTaishoshaBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 転入保留対象者情報の取得処理します。
     *
     * @return SearchResult<ITennyuTenshutsuHoryuTaishosha>
     */
    @Transaction
    public SearchResult<ITennyuTenshutsuHoryuTaishosha> getTennyuHoryuTaishoshaList() {
        ITennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(ITennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TenshutsuHoryuTaishoshaEntity> entityList = mapper.get転入保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuShutokuJogaishaKanri>emptyList(), 0, false);
        }
        List<ITennyuTenshutsuHoryuTaishosha> businessList = new ArrayList<>();
        for (TenshutsuHoryuTaishoshaEntity entity : entityList) {
            businessList.add(new TenshutsuHoryuTaishoshaBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 広域保留対象者 情報の取得処理します。
     *
     * @return SearchResult<ITennyuTenshutsuHoryuTaishosha>
     */
    @Transaction
    public SearchResult<ITennyuTenshutsuHoryuTaishosha> getKoikiHoryuTaishoshaList() {
        ITennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(ITennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TenshutsuHoryuTaishoshaEntity> entityList = mapper.get広域保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuShutokuJogaishaKanri>emptyList(), 0, false);
        }
        List<ITennyuTenshutsuHoryuTaishosha> businessList = new ArrayList<>();
        for (TenshutsuHoryuTaishoshaEntity entity : entityList) {
            businessList.add(new TenshutsuHoryuTaishoshaBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 転出保留対象者情報を物理削除します。
     *
     * @param 転出保留対象者 転出保留対象者
     * @return true:削除した false:削除しない
     */
    @Transaction
    public boolean delTenshutsuHoryuTaishosha(TenshutsuHoryuTaishosha 転出保留対象者) {
        return 1 == tenshutsuHoryuTaishoshaDac.deletePhysical(転出保留対象者.toEntity());
    }

    /**
     * 転入保留対象者情報を物理削除します。
     *
     * @param 転入保留対象者 転入保留対象者
     * @return true:削除した false:削除しない
     */
    @Transaction
    public boolean delTennyushutsuHoryuTaishosha(TennyushutsuHoryuTaishosha 転入保留対象者) {
        return 1 == tennyushutsuHoryuTaishoshaDac.deletePhysical(転入保留対象者.toEntity());
    }

    /**
     * 転入保留対象者情報を取得します。
     *
     * @return SearchResult<TennyushutsuHoryuTaishosha>
     */
    @Transaction
    public SearchResult<TennyushutsuHoryuTaishosha> getAllTennyuHoryuTaishosha() {
        List<TennyushutsuHoryuTaishosha> 対象者List = new ArrayList<>();
        List<DbT1010TennyushutsuHoryuTaishoshaEntity> list = tennyushutsuHoryuTaishoshaDac.selectAll();
        for (DbT1010TennyushutsuHoryuTaishoshaEntity entity : list) {
            対象者List.add(new TennyushutsuHoryuTaishosha(entity));
        }
        return SearchResult.of(対象者List, 0, false);
    }

    /**
     * 転出保留対象者情報を取得します。
     *
     * @return SearchResult<TennyushutsuHoryuTaishosha>
     */
    @Transaction
    public SearchResult<TenshutsuHoryuTaishosha> getAllTenshutsuHoryuTaishosha() {
        List<TenshutsuHoryuTaishosha> 対象者List = new ArrayList<>();
        List<DbT1011TenshutsuHoryuTaishoshaEntity> list = tenshutsuHoryuTaishoshaDac.selectAll();
        for (DbT1011TenshutsuHoryuTaishoshaEntity entity : list) {
            対象者List.add(new TenshutsuHoryuTaishosha(entity));
        }
        return SearchResult.of(対象者List, 0, false);
    }
}
