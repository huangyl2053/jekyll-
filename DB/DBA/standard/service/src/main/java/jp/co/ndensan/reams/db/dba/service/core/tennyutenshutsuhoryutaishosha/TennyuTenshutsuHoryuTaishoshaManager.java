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
import jp.co.ndensan.reams.db.dba.entity.db.tennyutenshutsuhoryutaishosha.TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.tennyutenshutsuhoryutaishosha.TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.tennyutenshutsuhoryutaishosha.ITennyuTenshutsuHoryuTaishoshaMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1010TennyushutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1011TenshutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 転入転出保留対象者管理のmanagerクラスです。
 */
public class TennyuTenshutsuHoryuTaishoshaManager {

    private static final RString 転出保留者 = new RString("転出保留者");
    private static final RString 転入保留者 = new RString("転入保留者");
    private static final RString 広域保留者 = new RString("広域保留者");
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
     * 転入転出保留対象者情報を物理削除します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 Decimal
     * @param 対象種類 RString
     * @return true:削除した false:削除しない
     */
    @Transaction
    public boolean delHoryuTaishosha(ShikibetsuCode 識別コード,
            Decimal 履歴番号,
            RString 対象種類) {
        if (転出保留者.equals(対象種類)) {
            DbT1011TenshutsuHoryuTaishoshaEntity tenshutsuEntity
                    = tenshutsuHoryuTaishoshaDac.selectByKey(識別コード, 履歴番号.intValue());
            tenshutsuEntity.setState(EntityDataState.Deleted);
            return 1 == tenshutsuHoryuTaishoshaDac.delete(tenshutsuEntity);
        }
        if (転入保留者.equals(対象種類) || 広域保留者.equals(対象種類)) {
            DbT1010TennyushutsuHoryuTaishoshaEntity tennyushutsuEntity
                    = tennyushutsuHoryuTaishoshaDac.selectByKey(識別コード, 履歴番号.intValue());
            tennyushutsuEntity.setState(EntityDataState.Deleted);
            return 1 == tennyushutsuHoryuTaishoshaDac.delete(tennyushutsuEntity);
        }
        return false;
    }
}
