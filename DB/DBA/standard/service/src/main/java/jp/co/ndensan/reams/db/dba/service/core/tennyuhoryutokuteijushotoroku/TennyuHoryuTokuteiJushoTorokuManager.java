/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tennyuhoryutokuteijushotoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiJushoIchiranModel;
import jp.co.ndensan.reams.db.dba.entity.db.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiJushoIchiranEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyuhoryutokuteijushoichiran.ITennyuHoryuTokuteiJushoIchiranMapper;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJusho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7023RendoHoryuTokuteiJushoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転入保留特定住所登録処理です。
 *
 * @reamsid_L DBA-0480-020 zhangzhiming
 */
public class TennyuHoryuTokuteiJushoTorokuManager {

    private final MapperProvider mapperProvider;
    private final DbT7023RendoHoryuTokuteiJushoDac dac;

    /**
     * コンストラクタ。
     */
    TennyuHoryuTokuteiJushoTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7023RendoHoryuTokuteiJushoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param dac DbT7023RendoHoryuTokuteiJushoDac
     */
    TennyuHoryuTokuteiJushoTorokuManager(MapperProvider mapperProvider, DbT7023RendoHoryuTokuteiJushoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TennyuHoryuTokuteiJushoTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TennyuHoryuTokuteiJushoTorokuManager}のインスタンス
     */
    public static TennyuHoryuTokuteiJushoTorokuManager createInstance() {
        return InstanceProvider.create(TennyuHoryuTokuteiJushoTorokuManager.class);
    }

    /**
     * 転入保留特定住所一覧を取得です。
     *
     * @return SearchResult<TennyuHoryuTokuteiJushoIchiranModel>
     */
    @Transaction
    public SearchResult<TennyuHoryuTokuteiJushoIchiranModel> getTennyuHoryuTokuteiJushoIchiran() {
        ITennyuHoryuTokuteiJushoIchiranMapper mapper = mapperProvider.create(ITennyuHoryuTokuteiJushoIchiranMapper.class);
        List<TennyuHoryuTokuteiJushoIchiranEntity> tennyuHoryuTokuteiJushoList = mapper.getTennyuHoryuTokuteiJushoIchiran();
        if (tennyuHoryuTokuteiJushoList == null || tennyuHoryuTokuteiJushoList.isEmpty()) {
            return SearchResult.of(Collections.<TennyuHoryuTokuteiJushoIchiranModel>emptyList(), 0, false);
        }
        List<TennyuHoryuTokuteiJushoIchiranModel> businessList = new ArrayList<>();
        for (TennyuHoryuTokuteiJushoIchiranEntity entity : tennyuHoryuTokuteiJushoList) {
            businessList.add(new TennyuHoryuTokuteiJushoIchiranModel(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 連動保留特定住所を取得です。
     *
     * @return SearchResult<RendoHoryuTokuteiJusho>
     */
    @Transaction
    public SearchResult<RendoHoryuTokuteiJusho> get連動保留特定住所() {
        ITennyuHoryuTokuteiJushoIchiranMapper mapper = mapperProvider.create(ITennyuHoryuTokuteiJushoIchiranMapper.class);
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
     * 転入保留特定住所の登録、更新、削除処理します。
     *
     * @param rendoHoryu RendoHoryuTokuteiJusho
     * @return count 件数
     */
    @Transaction
    public int insertOrUpdateOrDel(RendoHoryuTokuteiJusho rendoHoryu) {
        if (!rendoHoryu.hasChanged()) {
            return 0;
        }
        return dac.save(rendoHoryu.toEntity());
    }
}
