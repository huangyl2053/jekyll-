/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.chosachikugroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.chosachikugroup.ChosaChikuGroupMaster;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroup;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikugroup.ChosaChikuGroupMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachikugroup.ChosaChikuGroupRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosachikugroup.IChosaChikuGroupRelateMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5225ChosaChikuGroupDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査スケジュール登録8クラスです。
 *
 */
public class ChosaChikuGroupFinder {

    private final MapperProvider mapperProvider;
    private final DbT5225ChosaChikuGroupDac dbT5225Dac;

    /**
     * コンストラクタです。
     */
    ChosaChikuGroupFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5225Dac = InstanceProvider.create(DbT5225ChosaChikuGroupDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ChosaChikuGroupFinder(MapperProvider mapperProvider, DbT5225ChosaChikuGroupDac dbT5225Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5225Dac = dbT5225Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaChikuGroupFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaChikuGroupFinder}のインスタンス
     */
    public static ChosaChikuGroupFinder createInstance() {
        return InstanceProvider.create(ChosaChikuGroupFinder.class);
    }

    /**
     * 検索条件に従い、調査地区グループ情報を検索します。
     *
     * @return ChosaChikuGroup 調査地区グループ情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ChosaChikuGroup> getChosaChikuGroupList() {
        List<DbT5225ChosaChikuGroupEntity> entityList = dbT5225Dac.select調査地区グループ情報();
        List<ChosaChikuGroup> 調査地区グループ情報List = new ArrayList<>();
        for (DbT5225ChosaChikuGroupEntity entity : entityList) {
            調査地区グループ情報List.add(new ChosaChikuGroup(entity));
        }
        return SearchResult.of(調査地区グループ情報List, 0, false);
    }

    /**
     * 検索条件に従い、調査地区グループ調査地区一覧情報を検索します。
     *
     * @param parameter 調査地区グループ調査地区一覧検索条件
     * @return NinteiChosainMaster 調査地区グループ調査地区一覧情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ChosaChikuGroupMaster> getChosaChikuGroupChosaChikuList(ChosaChikuGroupMapperParameter parameter) {
        List<ChosaChikuGroupMaster> businessList = new ArrayList<>();
        IChosaChikuGroupRelateMapper mapper = mapperProvider.create(IChosaChikuGroupRelateMapper.class);
        List<ChosaChikuGroupRelateEntity> entityList = mapper.selectChosaChikuGroupChosaChiku(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ChosaChikuGroupMaster>emptyList(), 0, false);
        }
        for (ChosaChikuGroupRelateEntity entity : entityList) {
            businessList.add(new ChosaChikuGroupMaster(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 検索条件に従い、調査地区グループ調査地区一覧情報を検索します。
     *
     * @param parameter 調査地区グループ調査地区一覧検索条件
     * @return NinteiChosainMaster 調査地区グループ調査地区一覧情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ChosaChikuGroup> getChosaChikuGroup(ChosaChikuGroupMapperParameter parameter) {
        List<ChosaChikuGroup> businessList = new ArrayList<>();
        IChosaChikuGroupRelateMapper mapper = mapperProvider.create(IChosaChikuGroupRelateMapper.class);
        List<DbT5225ChosaChikuGroupEntity> entityList = mapper.selectChosaChikuGroup(parameter);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiJoho>emptyList(), 0, false);
        }
        for (DbT5225ChosaChikuGroupEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new ChosaChikuGroup(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 検索条件に従い、調査地区グループ調査地区一覧情報の件数を検索します。
     *
     * @param parameter 調査地区グループ調査地区一覧検索条件
     * @return 調査地区グループ調査地区一覧の件数
     */
    @Transaction
    public int getChosaChikuGroupCount(ChosaChikuGroupMapperParameter parameter) {
        IChosaChikuGroupRelateMapper mapper = mapperProvider.create(IChosaChikuGroupRelateMapper.class);
        return mapper.selectChosaChikuGroupCount(parameter);
    }

    /**
     * 検索条件に従い、市町村名称検索します。
     *
     * @param parameter 調査地区グループ調査地区一覧検索条件
     * @return 市町村名称
     */
    @Transaction
    public RString getShichosonMeisho(ChosaChikuGroupMapperParameter parameter) {
        IChosaChikuGroupRelateMapper mapper = mapperProvider.create(IChosaChikuGroupRelateMapper.class);
        return mapper.selectShichosonMeisho(parameter);
    }

    /**
     * 検索条件に従い、調査地区グループ調査地区一覧情報の件数を検索します。
     *
     * @param parameter 調査地区グループ調査地区一覧検索条件
     * @return 調査地区コードと市町村コードがDBに登録済み件数の件数
     */
    @Transaction
    public int getChosaChikuGroupChosaChikuCount(ChosaChikuGroupMapperParameter parameter) {
        IChosaChikuGroupRelateMapper mapper = mapperProvider.create(IChosaChikuGroupRelateMapper.class);
        return mapper.selectChosaChikuGroupChosaChikuCount(parameter);
    }

    /**
     * 検索条件に従い、調査地区グループ調査地区一覧情報の件数を検索します。
     *
     * @param parameter 調査地区グループ調査地区一覧検索条件
     * @return 同一調査地区コードと市町村コードが複数の調査地区グループに登録の件数
     */
    @Transaction
    public int getChosaChikuGroupChosaChikuToroukuCount(ChosaChikuGroupMapperParameter parameter) {
        IChosaChikuGroupRelateMapper mapper = mapperProvider.create(IChosaChikuGroupRelateMapper.class);
        return mapper.selectChosaChikuGroupChosaChikuToroukuCount(parameter);
    }
}
