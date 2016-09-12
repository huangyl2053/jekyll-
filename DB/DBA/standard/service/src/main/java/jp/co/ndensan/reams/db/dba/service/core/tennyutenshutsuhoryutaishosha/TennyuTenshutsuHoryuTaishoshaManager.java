/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tennyutenshutsuhoryutaishosha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryu.TennyuHoryuTaisho;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryu.TenshutsuHoryuTaisho;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryu.TennyushutsuHoryuTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryu.TenshutsuHoryuTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyutenshutsuhoryutaishosha.ITennyuTenshutsuHoryuTaishoshaMapper;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1010TennyushutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1011TenshutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.kojin._KojinManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
    private final DbT1001HihokenshaDaichoDac hihokenshaDaichoDac;
    private final DbT1011TenshutsuHoryuTaishoshaDac tenshutsuHoryuTaishoshaDac;
    private final DbT1010TennyushutsuHoryuTaishoshaDac tennyushutsuHoryuTaishoshaDac;

    /**
     * コンストラクタです。
     */
    TennyuTenshutsuHoryuTaishoshaManager(MapperProvider mapperProvider,
            DbT1001HihokenshaDaichoDac hihokenshaDaichoDac,
            DbT1011TenshutsuHoryuTaishoshaDac tenshutsuHoryuTaishoshaDac,
            DbT1010TennyushutsuHoryuTaishoshaDac tennyushutsuHoryuTaishoshaDac) {
        this.mapperProvider = mapperProvider;
        this.hihokenshaDaichoDac = hihokenshaDaichoDac;
        this.tenshutsuHoryuTaishoshaDac = tenshutsuHoryuTaishoshaDac;
        this.tennyushutsuHoryuTaishoshaDac = tennyushutsuHoryuTaishoshaDac;
    }

    /**
     * コンストラクタです。
     */
    public TennyuTenshutsuHoryuTaishoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.hihokenshaDaichoDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
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
     * @return SearchResult<TenshutsuHoryuTaisho>
     */
    @Transaction
    public SearchResult<TenshutsuHoryuTaisho> getTenshutsuHoryuTaishoshas() {
        ITennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(ITennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TenshutsuHoryuTaishoshaRelateEntity> entityList = mapper.get転出保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<TenshutsuHoryuTaisho>emptyList(), 0, false);
        }
        List<TenshutsuHoryuTaisho> businessList = new ArrayList<>();
        for (TenshutsuHoryuTaishoshaRelateEntity entity : entityList) {
            businessList.add(new TenshutsuHoryuTaisho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 転入保留対象者情報の取得処理します。
     *
     * @return SearchResult<TennyuHoryuTaisho>
     */
    @Transaction
    public SearchResult<TennyuHoryuTaisho> getTennyuHoryuTaishoshas() {
        ITennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(ITennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TennyushutsuHoryuTaishoshaRelateEntity> entityList = mapper.get転入保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<TennyuHoryuTaisho>emptyList(), 0, false);
        }
        List<TennyuHoryuTaisho> businessList = new ArrayList<>();
        for (TennyushutsuHoryuTaishoshaRelateEntity entity : entityList) {
            businessList.add(new TennyuHoryuTaisho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 広域保留対象者 情報の取得処理します。
     *
     * @return SearchResult<TennyuHoryuTaisho>
     */
    @Transaction
    public SearchResult<TennyuHoryuTaisho> getKoikiHoryuTaishoshas() {
        ITennyuTenshutsuHoryuTaishoshaMapper mapper = mapperProvider.create(ITennyuTenshutsuHoryuTaishoshaMapper.class);
        List<TennyushutsuHoryuTaishoshaRelateEntity> entityList = mapper.get広域保留対象者情報の取得処理();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<TennyuHoryuTaisho>emptyList(), 0, false);
        }
        List<TennyuHoryuTaisho> businessList = new ArrayList<>();
        for (TennyushutsuHoryuTaishoshaRelateEntity entity : entityList) {
            businessList.add(new TennyuHoryuTaisho(entity));
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
    public boolean delete転出保留対象者(TenshutsuHoryuTaishosha 転出保留対象者) {
        return 1 == tenshutsuHoryuTaishoshaDac.deletePhysical(転出保留対象者.toEntity());
    }

    /**
     * 転入保留対象者情報を物理削除します。
     *
     * @param 転入保留対象者 転入保留対象者
     * @return true:削除した false:削除しない
     */
    @Transaction
    public boolean delete転入保留対象者(TennyushutsuHoryuTaishosha 転入保留対象者) {
        return 1 == tennyushutsuHoryuTaishoshaDac.deletePhysical(転入保留対象者.toEntity());
    }

    /**
     * 宛名Mapを取得します。
     *
     * @param 識別コードList List<ShikibetsuCode>
     * @return 宛名Map
     */
    @Transaction
    public Map<ShikibetsuCode, IKojin> get宛名Map(List<ShikibetsuCode> 識別コードList) {
        IShikibetsuTaishoSearchKey 識別対象検索キー = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true)
                .set識別コードリスト(識別コードList).build();
        List<IKojin> 宛名 = new _KojinManager().get個人s(識別対象検索キー);
        Map<ShikibetsuCode, IKojin> 宛名Map = new HashMap<>();
        for (IKojin iKojin : 宛名) {
            宛名Map.put(iKojin.get識別コード(), iKojin);
        }
        return 宛名Map;
    }

    /**
     * 転出保留対象者情報を一括喪失します。
     *
     * @param 被保険者台帳 List<HihokenshaDaicho>
     * @param 転出保留対象者 List<TenshutsuHoryuTaishosha>
     */
    @Transaction
    public void do一括喪失(List<HihokenshaDaicho> 被保険者台帳, List<TenshutsuHoryuTaishosha> 転出保留対象者) {
        save被保険者台帳(被保険者台帳);
        for (TenshutsuHoryuTaishosha taishosha : 転出保留対象者) {
            delete転出保留対象者(taishosha);
        }
    }

    private void save被保険者台帳(List<HihokenshaDaicho> 被保険者台帳) {
        for (HihokenshaDaicho hihokenshaDaicho : 被保険者台帳) {
            hihokenshaDaichoDac.save(hihokenshaDaicho.toEntity());
        }
    }
}
