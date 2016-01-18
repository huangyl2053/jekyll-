/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.ninnteichousairai.NinnteiChousairaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.ninnteichousairai.WaritsukeEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ininnteichousairai.INinnteiChousairaiMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報を管理するクラスです。
 */
public class NinnteiChousairaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinnteiChousairaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    NinnteiChousairaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiFinder}のインスタンス
     */
    public static NinnteiChousairaiFinder createInstance() {
        return InstanceProvider.create(NinnteiChousairaiFinder.class);
    }

    /**
     * 認定調査委託先情報を取得する。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return NinnteiChousairaiBusiness 認定調査委託先情報
     */
    @Transaction
    public SearchResult<NinnteiChousairaiBusiness> getNinnteiChousaItaku(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<NinnteiChousairaiEntity> entityList = mapper.selectNinnteiChousaItaku(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinnteiChousairaiBusiness>emptyList(), 0, false);
        }
        List<NinnteiChousairaiBusiness> 認定調査委託先List = new ArrayList<>();
        for (NinnteiChousairaiEntity entity : entityList) {
            認定調査委託先List.add(new NinnteiChousairaiBusiness(entity));
        }
        return SearchResult.of(認定調査委託先List, 0, false);
    }

    /**
     * 調査員情報を取得する。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return NinnteiChousairaiBusiness 調査員情報
     */
    @Transaction
    public SearchResult<NinnteiChousairaiBusiness> getChousaIn(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<NinnteiChousairaiEntity> entityList = mapper.selectChousaIn(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinnteiChousairaiBusiness>emptyList(), 0, false);
        }
        List<NinnteiChousairaiBusiness> 調査員情報 = new ArrayList<>();
        for (NinnteiChousairaiEntity entity : entityList) {
            調査員情報.add(new NinnteiChousairaiBusiness(entity));
        }
        return SearchResult.of(調査員情報, 0, false);
    }

    /**
     * 割付済み申請者一覧を取得する。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return WaritsukeBusiness 割付済み申請者一覧
     */
    @Transaction
    public SearchResult<WaritsukeBusiness> getWaritsuke(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.getWaritsuke(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<WaritsukeBusiness>emptyList(), 0, false);
        }
        List<WaritsukeBusiness> 割付済み申請者一覧 = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            割付済み申請者一覧.add(new WaritsukeBusiness(entity));
        }
        return SearchResult.of(割付済み申請者一覧, 0, false);
    }

    /**
     * 未割付申請者一覧（新規依頼）を取得する。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return WaritsukeBusiness 未割付申請者一覧（新規依頼）
     */
    @Transaction
    public SearchResult<WaritsukeBusiness> getShiteWaritsuke(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.getShiteWaritsuke(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<WaritsukeBusiness>emptyList(), 0, false);
        }
        List<WaritsukeBusiness> 未割付申請者一覧 = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            未割付申請者一覧.add(new WaritsukeBusiness(entity));
        }
        return SearchResult.of(未割付申請者一覧, 0, false);
    }

    /**
     * 未割付申請者一覧（再依頼）を取得する。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return WaritsukeBusiness 未割付申請者一覧（再依頼）
     */
    @Transaction
    public SearchResult<WaritsukeBusiness> getShiteWaritsukeSai(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.getShiteWaritsukeSai(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<WaritsukeBusiness>emptyList(), 0, false);
        }
        List<WaritsukeBusiness> 未割付再依頼一覧 = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            未割付再依頼一覧.add(new WaritsukeBusiness(entity));
        }
        return SearchResult.of(未割付再依頼一覧, 0, false);
    }
}
