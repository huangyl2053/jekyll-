/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikenshoprint;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshoprint.IChosaIraishoAndChosahyoAndIkenshoPrintMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 依頼書・認定調査票(OCR)・主治医意見書印刷のサービスクラスです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
public class ChosaIraishoAndChosahyoAndIkenshoPrintFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ChosaIraishoAndChosahyoAndIkenshoPrintFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ChosaIraishoAndChosahyoAndIkenshoPrintFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaIraishoAndChosahyoAndIkenshoPrintFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaIraishoAndChosahyoAndIkenshoPrintFinder}のインスタンス
     */
    public static ChosaIraishoAndChosahyoAndIkenshoPrintFinder createInstance() {
        return InstanceProvider.create(ChosaIraishoAndChosahyoAndIkenshoPrintFinder.class);
    }

    /**
     * 認定調査依頼情報を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 認定調査依頼情報
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get認定調査依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> entityList = mapper.select認定調査依頼情報(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        for (ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity : entityList) {
            list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        }

        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 主治医意見書依頼情報を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 認定調査依頼情報
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get主治医意見書依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> entityList = mapper.select主治医意見書依頼情報(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        for (ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity : entityList) {
            list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        }

        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 認定調査依頼情報を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return NinteichosaIraiJoho 更新用認定調査依頼情報
     */
    @Transaction
    public SearchResult<NinteichosaIraiJoho> get更新用認定調査依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        List<DbT5201NinteichosaIraiJohoEntity> entityList = mapper.select更新用認定調査依頼情報(parameter);
        List<NinteichosaIraiJoho> list = new ArrayList<>();
        for (DbT5201NinteichosaIraiJohoEntity entity : entityList) {
            entity.initializeMd5();
            list.add(new NinteichosaIraiJoho(entity));
        }
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 主治医意見書依頼情報を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ShujiiIkenshoIraiJoho 更新用主治医意見書依頼情報
     */
    @Transaction
    public SearchResult<ShujiiIkenshoIraiJoho> get更新用主治医意見書依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        List<DbT5301ShujiiIkenshoIraiJohoEntity> entityList = mapper.select更新用主治医意見書依頼情報(parameter);
        List<ShujiiIkenshoIraiJoho> list = new ArrayList<>();
        for (DbT5301ShujiiIkenshoIraiJohoEntity entity : entityList) {
            entity.initializeMd5();
            list.add(new ShujiiIkenshoIraiJoho(entity));
        }
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 認定調査依頼書を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 認定調査依頼書
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get認定調査依頼書(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity = mapper.select認定調査依頼書(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();

        if (entity == null) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 認定調査依頼一覧表を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 認定調査依頼一覧表
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get認定調査依頼一覧表(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> entityList = mapper.select認定調査依頼一覧表(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        for (ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity : entityList) {
            list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        }

        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 認定調査票_概況調査を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 認定調査票_概況調査
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get認定調査票_概況調査(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity = mapper.select認定調査票_概況調査(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        if (entity == null) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 認定調査票差異チェック票を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 認定調査票差異チェック票
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get認定調査票差異チェック票(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> entityList = mapper.select認定調査票差異チェック票(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        if (entityList.isEmpty()) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        for (ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity : entityList) {
            list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        }

        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 意見書作成依頼書を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 意見書作成依頼書
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get意見書作成依頼書(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity = mapper.select意見書作成依頼書(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        if (entity == null) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 意見書作成依頼一覧表を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 意見書作成依頼一覧表
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get意見書作成依頼一覧表(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintEntity> entityList = mapper.select意見書作成依頼一覧表(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        for (ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity : entityList) {
            list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        }

        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 主治医意見書記入用紙を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 主治医意見書記入用紙
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get主治医意見書記入用紙(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity = mapper.select主治医意見書記入用紙(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        if (entity == null) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 主治医意見書作成料請求書を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 主治医意見書作成料請求書
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get主治医意見書作成料請求書(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity = mapper.select主治医意見書作成料請求書(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        if (entity == null) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        return SearchResult.of(list, list.size(), true);
    }

    /**
     * 介護保険診断命令書を返します。
     *
     * @param parameter ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintBusiness 介護保険診断命令書
     */
    @Transaction
    public SearchResult<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> get介護保険診断命令書(ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter) {
        IChosaIraishoAndChosahyoAndIkenshoPrintMapper mapper = mapperProvider.create(IChosaIraishoAndChosahyoAndIkenshoPrintMapper.class);
        ChosaIraishoAndChosahyoAndIkenshoPrintEntity entity = mapper.select介護保険診断命令書(parameter);
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> list = new ArrayList<>();
        if (entity == null) {
            return SearchResult.of(new ArrayList(), 0, true);
        }
        list.add(new ChosaIraishoAndChosahyoAndIkenshoPrintBusiness(entity));
        return SearchResult.of(list, list.size(), true);
    }
}
