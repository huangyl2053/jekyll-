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
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha.TennyuTenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dba.entity.db.tennyutenshutsuhoryutaishosha.TennyuTenshutsuHoryuEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.tennyutenshutsuhoryutaishosha.TennyuTenshutsuHoryuTaishoshaMapper;
import jp.co.ndensan.reams.db.dba.service.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriManager;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1010TennyushutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1011TenshutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 転入転出保留対象者管理のMapperクラスです
 */
public class TennyuTenshutsuHoryuTaishoshaManager {

    private final MapperProvider mapperProvider;
    private final DbT1011TenshutsuHoryuTaishoshaDac TenshutsuHoryuTaishoshaDac;
    private final DbT1010TennyushutsuHoryuTaishoshaDac TennyushutsuHoryuTaishoshaDac;
    private static final RString 転出保留者 = new RString("転出保留者");
    private static final RString 転入保留者 = new RString("転入保留者");
    private static final RString 広域保留者 = new RString("広域保留者");

    /**
     * コンストラクタです。
     */
    TennyuTenshutsuHoryuTaishoshaManager(MapperProvider mapperProvider, DbT1011TenshutsuHoryuTaishoshaDac TenshutsuHoryuTaishoshaDac,
            DbT1010TennyushutsuHoryuTaishoshaDac TennyushutsuHoryuTaishoshaDac) {
        this.mapperProvider = mapperProvider;
        this.TenshutsuHoryuTaishoshaDac = TenshutsuHoryuTaishoshaDac;
        this.TennyushutsuHoryuTaishoshaDac = TennyushutsuHoryuTaishoshaDac;
    }

    /**
     * コンストラクタです。
     */
    public TennyuTenshutsuHoryuTaishoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.TenshutsuHoryuTaishoshaDac = InstanceProvider.create(DbT1011TenshutsuHoryuTaishoshaDac.class);
        this.TennyushutsuHoryuTaishoshaDac = InstanceProvider.create(DbT1010TennyushutsuHoryuTaishoshaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuShutokuJogaishaKanriManager}のインスタンスを返します。
     *
     * @return KijuntsukiShichosonjohoFinder
     */
    public static TennyuTenshutsuHoryuTaishoshaManager createInstance() {
        return InstanceProvider.create(TennyuTenshutsuHoryuTaishoshaManager.class);
    }

    /**
     * 転出保留対象者情報の取得処理します
     *
     * @return SearchResult<TennyuTenshutsuHoryuTaishosha>
     */
    @Transaction
    public SearchResult<TennyuTenshutsuHoryuTaishosha> getTenshutsuHoryuTaishoshaList() {
        TennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(TennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TennyuTenshutsuHoryuEntity> entityList = mapper.get転出保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuShutokuJogaishaKanri>emptyList(), 0, false);
        }
        List<TennyuTenshutsuHoryuTaishosha> businessList = new ArrayList<>();
        for (TennyuTenshutsuHoryuEntity entity : entityList) {
            CodeMaster.getShubetsu(SubGyomuCode.DBA介護資格, new CodeShubetsu(entity.getJuminShubetsuCode())).getコード種別名称();
            CodeMaster.getShubetsu(SubGyomuCode.DBA介護資格, new CodeShubetsu(entity.getIdoJiyuCode())).getコード種別名称();
            if (entity.getTenshutsuKakuteiIdoYMD().isEmpty()) {
                entity.setTorokuIdoYMD(entity.getTenshutsuYoteiIdoYMD());
            }
            entity.setTorokuIdoYMD(entity.getTenshutsuKakuteiIdoYMD());
            businessList.add(new TennyuTenshutsuHoryuTaishosha(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 転入保留対象者情報の取得処理します
     *
     * @return SearchResult<TennyuTenshutsuHoryuTaishosha>
     */
    @Transaction
    public SearchResult<TennyuTenshutsuHoryuTaishosha> getTennyuHoryuTaishoshaList() {
        TennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(TennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TennyuTenshutsuHoryuEntity> entityList = mapper.get転入保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuShutokuJogaishaKanri>emptyList(), 0, false);
        }
        List<TennyuTenshutsuHoryuTaishosha> businessList = new ArrayList<>();
        for (TennyuTenshutsuHoryuEntity entity : entityList) {
            CodeMaster.getShubetsu(SubGyomuCode.DBA介護資格, new CodeShubetsu(entity.getJuminShubetsuCode())).getコード種別名称();
            CodeMaster.getShubetsu(SubGyomuCode.DBA介護資格, new CodeShubetsu(entity.getIdoJiyuCode())).getコード種別名称();
            businessList.add(new TennyuTenshutsuHoryuTaishosha(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 広域保留対象者情報の取得処理します
     *
     * @return SearchResult<TennyuTenshutsuHoryuTaishosha>
     */
    @Transaction
    public SearchResult<TennyuTenshutsuHoryuTaishosha> getKoikiHoryuTaishoshaList() {
        TennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(TennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TennyuTenshutsuHoryuEntity> entityList = mapper.get広域保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuShutokuJogaishaKanri>emptyList(), 0, false);
        }
        List<TennyuTenshutsuHoryuTaishosha> businessList = new ArrayList<>();
        for (TennyuTenshutsuHoryuEntity entity : entityList) {
            CodeMaster.getShubetsu(SubGyomuCode.DBA介護資格, new CodeShubetsu(entity.getJuminShubetsuCode())).getコード種別名称();
            CodeMaster.getShubetsu(SubGyomuCode.DBA介護資格, new CodeShubetsu(entity.getIdoJiyuCode())).getコード種別名称();
            businessList.add(new TennyuTenshutsuHoryuTaishosha(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 転入転出保留対象者情報を物理削除します
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 Decimal
     * @param 対象種類 RString
     * @return
     */
    @Transaction
    public boolean delHoryuTaishosha(ShikibetsuCode 識別コード,
            Decimal 履歴番号,
            RString 対象種類) {
        if (転出保留者.equals(対象種類)) {
            DbT1011TenshutsuHoryuTaishoshaEntity tenshutsuHoryuTaishoshaEntity = new DbT1011TenshutsuHoryuTaishoshaEntity();
            tenshutsuHoryuTaishoshaEntity.setShikibetsuCode(識別コード);
            tenshutsuHoryuTaishoshaEntity.setRirekiNo(履歴番号);
            tenshutsuHoryuTaishoshaEntity.setState(EntityDataState.Deleted);
            return 1 == TenshutsuHoryuTaishoshaDac.delete(tenshutsuHoryuTaishoshaEntity);
        }
        if (転入保留者.equals(対象種類) || 広域保留者.equals(対象種類)) {
            DbT1010TennyushutsuHoryuTaishoshaEntity tennyushutsuHoryuTaishoshaEntity = new DbT1010TennyushutsuHoryuTaishoshaEntity();
            tennyushutsuHoryuTaishoshaEntity.setShikibetsuCode(識別コード);
            tennyushutsuHoryuTaishoshaEntity.setRirekiNo(履歴番号);
            tennyushutsuHoryuTaishoshaEntity.setState(EntityDataState.Deleted);
            return 1 == TennyushutsuHoryuTaishoshaDac.save(tennyushutsuHoryuTaishoshaEntity);
        }
        return false;
    }
}
