/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairaishudou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairaishudou.NinnteiChousairaiShudouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairaishudou.NinnteiChousairaiShudouParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairaishudou.NinnteiChousairaiShudouEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairaijoho.ninteishinseijoho.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninnteichousairaishudou.INinnteiChousairaiShudouMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼(手動)を管理するクラスです。
 *
 * @reamsid_L DBE-1590-010 sunhaidi
 */
public class NinnteiChousairaiShudouFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinnteiChousairaiShudouFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider
     */
    NinnteiChousairaiShudouFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiShudouFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiShudouFinder}のインスタンス
     */
    public static NinnteiChousairaiShudouFinder createInstance() {
        return InstanceProvider.create(NinnteiChousairaiShudouFinder.class);
    }

    /**
     * 認定調査依頼情報を取得します。
     *
     * @param parameter 認定調査依頼情報パラメータ
     * @return SearchResult<NinnteiChousairaiShudouBusiness> 認定調査依頼情報
     */
    @Transaction
    public SearchResult<NinnteiChousairaiShudouBusiness> get認定調査依頼情報(NinnteiChousairaiShudouParameter parameter) {
        INinnteiChousairaiShudouMapper mapper = mapperProvider.create(INinnteiChousairaiShudouMapper.class);
        NinnteiChousairaiShudouEntity entity = mapper.select認定調査依頼情報(parameter);
        if (entity == null) {
            return SearchResult.of(Collections.<NinnteiChousairaiShudouBusiness>emptyList(), 0, false);
        }
        List<NinnteiChousairaiShudouBusiness> 認定調査依頼List = new ArrayList<>();
        認定調査依頼List.add(new NinnteiChousairaiShudouBusiness(entity));
        return SearchResult.of(認定調査依頼List, 0, false);
    }

    /**
     * 更新用認定調査依頼情報を取得します。
     *
     * @param parameter 認定調査依頼情報パラメータ
     * @return SearchResult<NinteiShinseiJoho> 認定調査依頼情報
     */
    @Transaction
    public SearchResult<NinteiShinseiJoho> get更新用認定調査依頼情報(NinnteiChousairaiShudouParameter parameter) {
        INinnteiChousairaiShudouMapper mapper = mapperProvider.create(INinnteiChousairaiShudouMapper.class);
        NinteiShinseiJohoRelateEntity entity = mapper.select更新用認定調査依頼情報(parameter);
        if (entity == null) {
            return SearchResult.of(Collections.<NinnteiChousairaiShudouBusiness>emptyList(), 0, false);
        }
        List<NinteiShinseiJoho> 認定調査依頼List = new ArrayList<>();
        entity.initializeMd5ToEntities();
        認定調査依頼List.add(new NinteiShinseiJoho(entity));
        return SearchResult.of(認定調査依頼List, 0, false);
    }

    /**
     * 認定調査依頼書を返します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return NinnteiChousairaiShudouBusiness 認定調査依頼書
     */
    @Transaction
    public SearchResult<NinnteiChousairaiShudouBusiness> get認定調査依頼書(NinnteiChousairaiShudouParameter parameter) {
        INinnteiChousairaiShudouMapper mapper = mapperProvider.create(INinnteiChousairaiShudouMapper.class);
        NinnteiChousairaiShudouEntity entity = mapper.select認定調査依頼書(parameter);
        List<NinnteiChousairaiShudouBusiness> list = new ArrayList<>();

        if (entity == null) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        list.add(new NinnteiChousairaiShudouBusiness(entity));
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 認定調査票_概況調査を返します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return NinnteiChousairaiShudouBusiness 認定調査票_概況調査
     */
    @Transaction
    public SearchResult<NinnteiChousairaiShudouBusiness> get認定調査票_概況調査(NinnteiChousairaiShudouParameter parameter) {
        INinnteiChousairaiShudouMapper mapper = mapperProvider.create(INinnteiChousairaiShudouMapper.class);
        NinnteiChousairaiShudouEntity entity = mapper.select認定調査票_概況調査(parameter);
        List<NinnteiChousairaiShudouBusiness> list = new ArrayList<>();

        if (entity == null) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        list.add(new NinnteiChousairaiShudouBusiness(entity));
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 認定調査票差異チェック票を返します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return NinnteiChousairaiShudouBusiness 認定調査票差異チェック票
     */
    @Transaction
    public SearchResult<NinnteiChousairaiShudouBusiness> get認定調査票差異チェック票(NinnteiChousairaiShudouParameter parameter) {
        INinnteiChousairaiShudouMapper mapper = mapperProvider.create(INinnteiChousairaiShudouMapper.class);
        List<NinnteiChousairaiShudouEntity> entityList = mapper.select認定調査票差異チェック票(parameter);
        List<NinnteiChousairaiShudouBusiness> list = new ArrayList<>();
        if (entityList.isEmpty()) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        for (NinnteiChousairaiShudouEntity entity : entityList) {
            list.add(new NinnteiChousairaiShudouBusiness(entity));
        }
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 認定調査依頼該当者履歴一覧を返します。
     *
     * @param parameter NinnteiChousairaiShudouParameter
     * @return NinnteiChousairaiShudouBusiness 認定調査依頼該当者履歴一覧
     */
    @Transaction
    public SearchResult<NinnteiChousairaiShudouBusiness> get認定調査依頼該当者履歴一覧(NinnteiChousairaiShudouParameter parameter) {
        INinnteiChousairaiShudouMapper mapper = mapperProvider.create(INinnteiChousairaiShudouMapper.class);
        List<NinnteiChousairaiShudouEntity> entityList = mapper.select認定調査依頼該当者履歴一覧(parameter);
        List<NinnteiChousairaiShudouBusiness> list = new ArrayList<>();
        if (entityList.isEmpty()) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        for (NinnteiChousairaiShudouEntity entity : entityList) {
            list.add(new NinnteiChousairaiShudouBusiness(entity));
        }
        return SearchResult.of(list, list.size(), true);
    }
}
