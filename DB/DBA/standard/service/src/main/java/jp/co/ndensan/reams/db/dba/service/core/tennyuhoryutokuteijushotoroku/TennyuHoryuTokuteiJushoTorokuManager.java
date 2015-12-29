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
import jp.co.ndensan.reams.db.dba.persistence.mapper.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiJushoIchiranMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7023RendoHoryuTokuteiJushoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 転入保留特定住所登録処理です。
 */
public class TennyuHoryuTokuteiJushoTorokuManager {

    private final MapperProvider mapperProvider;
    private final DbT7023RendoHoryuTokuteiJushoDac dac;
    private static final RString SHICHOSONCODE_VALUE = new RString("11");

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
        TennyuHoryuTokuteiJushoIchiranMapper mapper = mapperProvider.create(TennyuHoryuTokuteiJushoIchiranMapper.class);
        List<TennyuHoryuTokuteiJushoIchiranEntity> tennyuHoryuTokuteiJushoList = mapper.getTennyuHoryuTokuteiJushoIchiran();
        if (tennyuHoryuTokuteiJushoList == null || tennyuHoryuTokuteiJushoList.isEmpty()) {
            return SearchResult.of(Collections.<TennyuHoryuTokuteiJushoIchiranModel>emptyList(), 0, false);
        }
        return get住所一覧リスト(tennyuHoryuTokuteiJushoList);
    }

    private SearchResult<TennyuHoryuTokuteiJushoIchiranModel> get住所一覧リスト(List<TennyuHoryuTokuteiJushoIchiranEntity> tennyuHoryuTokuteiJushoList) {
        List<TennyuHoryuTokuteiJushoIchiranModel> businessList = new ArrayList<>();
        for (TennyuHoryuTokuteiJushoIchiranEntity entity : tennyuHoryuTokuteiJushoList) {
            businessList.add(new TennyuHoryuTokuteiJushoIchiranModel(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 転入保留特定住所の登録処理します。
     *
     * @param tokuteiJushoEntity TennyuHoryuTokuteiJushoIchiranEntity
     * @return count 件数
     */
    @Transaction
    public int insertTennyuHoryuTokuteiJusho(TennyuHoryuTokuteiJushoIchiranEntity tokuteiJushoEntity) {
        return getInsertCount(tokuteiJushoEntity);
    }

    private int getInsertCount(TennyuHoryuTokuteiJushoIchiranEntity tokuteiJushoEntity) {
        DbT7023RendoHoryuTokuteiJushoEntity entity = new DbT7023RendoHoryuTokuteiJushoEntity();
        //        entity.setKanriNo(tokuteiJushoEntity.getKanriNo());
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        if (導入形態コード.getKey().substring(1, 2).equals(SHICHOSONCODE_VALUE)) {
            entity.setShichosonCode(市町村セキュリティ情報.get市町村情報().get市町村コード());
        } else {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            entity.setShichosonCode(association.get地方公共団体コード());
        }
        entity.setJushoCode(tokuteiJushoEntity.getJushoCode());
        entity.setJusho(tokuteiJushoEntity.getJusho());
        entity.setBanchiCode1(tokuteiJushoEntity.getBanchiCode1());
        entity.setBanchiCode2(tokuteiJushoEntity.getBanchiCode2());
        entity.setBanchiCode3(tokuteiJushoEntity.getBanchiCode3());
        entity.setBanchi(tokuteiJushoEntity.getBanchi());
        entity.setShisetsuShurui(tokuteiJushoEntity.getShisetsuShurui());
        entity.setShisetsuCode(tokuteiJushoEntity.getShisetsuCode());
        entity.setIsDeleted(false);
        entity.setState(EntityDataState.Added);
        return dac.save(entity);
    }

    /**
     * 転入保留特定住所の更新処理します。
     *
     * @param tokuteiJushoEntity TennyuHoryuTokuteiJushoIchiranEntity
     * @return count 件数
     */
    @Transaction
    public int updateTennyuHoryuTokuteiJusho(TennyuHoryuTokuteiJushoIchiranEntity tokuteiJushoEntity) {
        return getUpdateCount(tokuteiJushoEntity);
    }

    private int getUpdateCount(TennyuHoryuTokuteiJushoIchiranEntity tokuteiJushoEntity) {
        DbT7023RendoHoryuTokuteiJushoEntity entity = dac.selectByKey(tokuteiJushoEntity.getKanriNo(), tokuteiJushoEntity.getShichosonCode());
        entity.setKanriNo(tokuteiJushoEntity.getKanriNo());
        entity.setShichosonCode(tokuteiJushoEntity.getShichosonCode());
        entity.setJushoCode(tokuteiJushoEntity.getJushoCode());
        entity.setJusho(tokuteiJushoEntity.getJusho());
        entity.setBanchiCode1(tokuteiJushoEntity.getBanchiCode1());
        entity.setBanchiCode2(tokuteiJushoEntity.getBanchiCode2());
        entity.setBanchiCode3(tokuteiJushoEntity.getBanchiCode3());
        entity.setBanchi(tokuteiJushoEntity.getBanchi());
        entity.setShisetsuShurui(tokuteiJushoEntity.getShisetsuShurui());
        entity.setShisetsuCode(tokuteiJushoEntity.getShisetsuCode());
        entity.setIsDeleted(false);
        entity.setState(EntityDataState.Modified);
        return dac.save(entity);
    }

    /**
     * 転入保留特定住所の削除処理します。
     *
     * @param tokuteiJushoEntity TennyuHoryuTokuteiJushoIchiranEntity
     * @return count 件数
     */
    @Transaction
    public int delTennyuHoryuTokuteiJusho(TennyuHoryuTokuteiJushoIchiranEntity tokuteiJushoEntity) {
        DbT7023RendoHoryuTokuteiJushoEntity entity = dac.selectByKey(tokuteiJushoEntity.getKanriNo(), tokuteiJushoEntity.getShichosonCode());
        entity.setIsDeleted(true);
        entity.setState(EntityDataState.Modified);
        return dac.save(entity);
    }
}
