/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tennyuhoryutokuteijushotoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiBusiness;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyuhoryutokuteijushoichiran.ITennyuHoryuTokuteiMapper;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJusho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7023RendoHoryuTokuteiJushoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転入保留特定住所登録処理です。
 *
 * @reamsid_L DBA-0480-020 zhangzhiming
 */
public class TennyuHoryuTokuteiManager {

    private final MapperProvider mapperProvider;
    private final DbT7023RendoHoryuTokuteiJushoDac dac;

    /**
     * コンストラクタ。
     */
    TennyuHoryuTokuteiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7023RendoHoryuTokuteiJushoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param dac DbT7023RendoHoryuTokuteiJushoDac
     */
    TennyuHoryuTokuteiManager(MapperProvider mapperProvider, DbT7023RendoHoryuTokuteiJushoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TennyuHoryuTokuteiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TennyuHoryuTokuteiManager}のインスタンス
     */
    public static TennyuHoryuTokuteiManager createInstance() {
        return InstanceProvider.create(TennyuHoryuTokuteiManager.class);
    }

    /**
     * 転入保留特定住所一覧を取得です。
     *
     * @return SearchResult<TennyuHoryuTokuteiBusiness>
     */
    @Transaction
    public SearchResult<TennyuHoryuTokuteiBusiness> getTennyuHoryuTokuteiJushoIchiran() {
        ITennyuHoryuTokuteiMapper mapper = mapperProvider.create(ITennyuHoryuTokuteiMapper.class);
        List<TennyuHoryuTokuteiEntity> tennyuHoryuTokuteiList = mapper.getTennyuHoryuTokuteiJushoIchiran();
        if (tennyuHoryuTokuteiList == null || tennyuHoryuTokuteiList.isEmpty()) {
            return SearchResult.of(Collections.<TennyuHoryuTokuteiBusiness>emptyList(), 0, false);
        }
        List<TennyuHoryuTokuteiBusiness> businessList = new ArrayList<>();
        for (TennyuHoryuTokuteiEntity entity : tennyuHoryuTokuteiList) {
            businessList.add(new TennyuHoryuTokuteiBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 連動保留特定住所を取得です。
     *
     * @return SearchResult<TennyuHoryuTokuteiBusiness>
     */
    @Transaction
    public SearchResult<RendoHoryuTokuteiJusho> get連動保留特定住所() {
        ITennyuHoryuTokuteiMapper mapper = mapperProvider.create(ITennyuHoryuTokuteiMapper.class);
        List<DbT7023RendoHoryuTokuteiJushoEntity> tennyuHoryuTokuteiList = mapper.get連動保留特定住所();
        if (tennyuHoryuTokuteiList == null || tennyuHoryuTokuteiList.isEmpty()) {
            return SearchResult.of(Collections.<RendoHoryuTokuteiJusho>emptyList(), 0, false);
        }
        List<RendoHoryuTokuteiJusho> businessList = new ArrayList<>();
        for (DbT7023RendoHoryuTokuteiJushoEntity entity : tennyuHoryuTokuteiList) {
            entity.initializeMd5();
            businessList.add(new RendoHoryuTokuteiJusho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 管理番号を全件返します。
     *
     * @return 管理番号
     */
    @Transaction
    public RString getKanriNo() {
        ITennyuHoryuTokuteiMapper mapper = mapperProvider.create(ITennyuHoryuTokuteiMapper.class);
        RString entity = mapper.getKanriNo();
        if (!RString.isNullOrEmpty(entity)) {
            return entity;
        }
        return RString.EMPTY;
    }

    /**
     * 転入保留特定住所の登録、更新、削除処理します。
     *
     * @param rendoHoryu RendoHoryuTokuteiJusho
     * @param state EntityDataState
     * @return count 件数
     */
    @Transaction
    public int insertOrUpdateOrDel(RendoHoryuTokuteiJusho rendoHoryu, EntityDataState state) {
        DbT7023RendoHoryuTokuteiJushoEntity entity = rendoHoryu.toEntity();
        entity.setState(state);
        if (state == EntityDataState.Deleted) {
            entity.setIsDeleted(true);
        }
        return dac.save(entity);
    }
}
