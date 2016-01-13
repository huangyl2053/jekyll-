/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.tekiyojogaisha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaRelate;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha.ITekiyoJogaishaMapper;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 適用除外者を管理するクラスです。
 */
public class TekiyoJogaishaFinder {

    private final MapperProvider mapperProvider;
    private static boolean 退所日ありフラグ;

    /**
     * コンストラクタです。
     */
    TekiyoJogaishaFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TekiyoJogaishaFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaFinder}のインスタンス
     */
    public static TekiyoJogaishaFinder createInstance() {
        return InstanceProvider.create(TekiyoJogaishaFinder.class);
    }

    /**
     * 適用除外者の取得処理します。
     *
     * @param shikibetsuCode 識別コード
     * @param ronrisakujyoFlg 論理削除フラグ
     * @return SearchResult<TekiyoJogaishaRelate> 適用除外者を管理
     */
    @Transaction
    public SearchResult<TekiyoJogaishaRelate> getTekiyoJogaishaLst(ShikibetsuCode shikibetsuCode, boolean ronrisakujyoFlg) {
        List<TekiyoJogaishaRelate> tekiyoJogaishaRelateList = new ArrayList<>();
        TekiyoJogaishaMapperParameter 適用除外者Parameter = TekiyoJogaishaMapperParameter.
                createParam_get適用除外者(shikibetsuCode, ronrisakujyoFlg);
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        List<TekiyoJogaishaRelateEntity> 適用除外者List = mapper.get適用除外者(適用除外者Parameter);
        if (適用除外者List == null || 適用除外者List.isEmpty()) {
            return SearchResult.of(Collections.<TekiyoJogaishaRelate>emptyList(), 0, false);
        }
        for (TekiyoJogaishaRelateEntity entity : 適用除外者List) {
            退所日ありフラグ = true;
            TekiyoJogaishaMapperParameter 施設情Parameter = TekiyoJogaishaMapperParameter.createParam_get施設情(
                    entity.getShikibetsuCode(),
                    entity.getKaijoYMD(),
                    entity.getTekiyoYMD());
            List<TekiyoJogaishaRelateEntity> 施設情List = mapper.get施設情(施設情Parameter);
            if (施設情List == null || 施設情List.isEmpty()) {
                tekiyoJogaishaRelateList.add(new TekiyoJogaishaRelate(entity));
            } else {
                for (TekiyoJogaishaRelateEntity entity1 : 施設情List) {
                    if (entity1.getTaishoYMD() == null || entity1.getTaishoYMD().isEmpty()) {
                        entity.setRirekiNo(entity1.getRirekiNo());
                        entity.setNyushoShisetsuCode(entity1.getNyushoShisetsuCode());
                        entity.setNyushoYMD(entity1.getNyushoYMD());
                        entity.setTaishoYMD(entity1.getTaishoYMD());
                        entity.setJigyoshaMeisho(entity1.getJigyoshaMeisho());
                        tekiyoJogaishaRelateList.add(new TekiyoJogaishaRelate(entity));
                        退所日ありフラグ = false;
                    }
                }
                if (退所日ありフラグ) {
                    entity.setRirekiNo(施設情List.get(0).getRirekiNo());
                    entity.setNyushoShisetsuCode(施設情List.get(0).getNyushoShisetsuCode());
                    entity.setNyushoYMD(施設情List.get(0).getNyushoYMD());
                    entity.setTaishoYMD(施設情List.get(0).getTaishoYMD());
                    entity.setJigyoshaMeisho(施設情List.get(0).getJigyoshaMeisho());
                    tekiyoJogaishaRelateList.add(new TekiyoJogaishaRelate(entity));
                }
            }

        }
        return SearchResult.of(tekiyoJogaishaRelateList, 0, false);
    }

    /**
     * 介護保険施設入退所の取得処理します。
     *
     * @param shikibetsuCode 識別コード
     * @param ronrisakujyoFlg 論理削除フラグ
     * @return SearchResult<ShisetsuNyutaisho> 介護保険施設入退所を管理
     */
    @Transaction
    public SearchResult<ShisetsuNyutaisho> getShisetsuNyutaisho(ShikibetsuCode shikibetsuCode, boolean ronrisakujyoFlg) {
        List<ShisetsuNyutaisho> tekiyoJogaishaList = new ArrayList<>();
        TekiyoJogaishaMapperParameter 適用除外者Parameter = TekiyoJogaishaMapperParameter.
                createParam_get適用除外者(shikibetsuCode, ronrisakujyoFlg);
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        List<DbT1002TekiyoJogaishaEntity> 適用除外者List = mapper.getTekiyoJogaisha(適用除外者Parameter);
        if (適用除外者List == null || 適用除外者List.isEmpty()) {
            return SearchResult.of(Collections.<ShisetsuNyutaisho>emptyList(), 0, false);
        }
        for (DbT1002TekiyoJogaishaEntity dbT1002entity : 適用除外者List) {
            TekiyoJogaishaMapperParameter 施設情Parameter = TekiyoJogaishaMapperParameter.createParam_get施設情(
                    dbT1002entity.getShikibetsuCode(),
                    dbT1002entity.getKaijoYMD(),
                    dbT1002entity.getTekiyoYMD());
            List<DbT1004ShisetsuNyutaishoEntity> 施設情List = mapper.getShisetsuNyutaisho(施設情Parameter);
            if (施設情List != null && !施設情List.isEmpty()) {
                for (DbT1004ShisetsuNyutaishoEntity dbT1004entity : 施設情List) {
                    dbT1004entity.initializeMd5();
                    tekiyoJogaishaList.add(new ShisetsuNyutaisho(dbT1004entity));
                }
            }
        }
        return SearchResult.of(tekiyoJogaishaList, 0, false);
    }

    /**
     * 適用除外者の取得処理します。
     *
     * @param shikibetsuCode 識別コード
     * @param ronrisakujyoFlg 論理削除フラグ
     * @return SearchResult<TekiyoJogaishaRelate> 適用除外者を管理
     */
    @Transaction
    public SearchResult<TekiyoJogaisha> getTekiyoJogaisha(ShikibetsuCode shikibetsuCode, boolean ronrisakujyoFlg) {
        List<TekiyoJogaisha> tekiyoJogaishaList = new ArrayList<>();
        TekiyoJogaishaMapperParameter 適用除外者Parameter = TekiyoJogaishaMapperParameter.
                createParam_get適用除外者(shikibetsuCode, ronrisakujyoFlg);
        ITekiyoJogaishaMapper mapper = mapperProvider.create(ITekiyoJogaishaMapper.class);
        List<DbT1002TekiyoJogaishaEntity> 適用除外者List = mapper.getTekiyoJogaisha(適用除外者Parameter);
        if (適用除外者List == null || 適用除外者List.isEmpty()) {
            return SearchResult.of(Collections.<ShisetsuNyutaisho>emptyList(), 0, false);
        }
        for (DbT1002TekiyoJogaishaEntity dbT1002entity : 適用除外者List) {
            dbT1002entity.initializeMd5();
            tekiyoJogaishaList.add(new TekiyoJogaisha(dbT1002entity));
        }
        return SearchResult.of(tekiyoJogaishaList, 0, false);
    }

}
