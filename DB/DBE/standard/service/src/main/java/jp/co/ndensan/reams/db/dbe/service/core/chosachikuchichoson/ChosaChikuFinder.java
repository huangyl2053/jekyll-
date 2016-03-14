/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.chosachikuchichoson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson.ChosaChikuChichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson.UzT0007CodeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikuchichoson.ChosaChikuChichosonParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachikuchichoson.ChosaChikuChichosonRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosachikuchichoson.IChosaChikuChichosonMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5224ChikuShichosonDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査地区市町村情報を管理クラスです。
 */
public class ChosaChikuFinder {

    private static final CodeShubetsu コード種別 = new CodeShubetsu("5002");
    private final MapperProvider mapperProvider;
    private final DbT5224ChikuShichosonDac dbt5224dac;
    private final DbT7051KoseiShichosonMasterDac dbt7051dac;
    private final DbT5221NinteichosaScheduleDac dbt5221dac;

    /**
     * コンストラクタです。
     */
    ChosaChikuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5224dac = InstanceProvider.create(DbT5224ChikuShichosonDac.class);
        this.dbt7051dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.dbt5221dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ChosaChikuFinder(
            MapperProvider mapperProvider,
            DbT5224ChikuShichosonDac dbt5224dac,
            DbT7051KoseiShichosonMasterDac dbt7051dac,
            DbT5221NinteichosaScheduleDac dbt5221dac) {
        this.mapperProvider = mapperProvider;
        this.dbt5224dac = dbt5224dac;
        this.dbt7051dac = dbt7051dac;
        this.dbt5221dac = dbt5221dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaChikuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaChikuFinder}のインスタンス
     */
    public static ChosaChikuFinder createInstance() {
        return InstanceProvider.create(ChosaChikuFinder.class);
    }

    /**
     * 調査地区情報を取得します。
     *
     * @return SearchResult<UzT0007CodeBusiness>
     */
    @Transaction
    public SearchResult<UzT0007CodeBusiness> getChosaChikuList() {
        List<UzT0007CodeBusiness> resultList = new ArrayList<>();
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBE認定支援, コード種別);
        if (codeList == null || codeList.isEmpty()) {
            return SearchResult.of(Collections.<UzT0007CodeBusiness>emptyList(), 0, false);
        }
        Collections.sort(codeList, new Comparator<UzT0007CodeEntity>() {
            @Override
            public int compare(UzT0007CodeEntity entity1, UzT0007CodeEntity entity2) {
                return entity1.getコード().compareTo(entity2.getコード());
            }
        });
        for (UzT0007CodeEntity entity : codeList) {
            resultList.add(new UzT0007CodeBusiness(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 調査地区市町村一覧情報を取得します。
     *
     * @param paramer ChosaChikuChichosonParameter
     * @return SearchResult<ChosaChikuChichosonBusiness>
     */
    @Transaction
    public SearchResult<ChosaChikuChichosonBusiness> getChosaChikuChichosonList(ChosaChikuChichosonParameter paramer) {
        List<ChosaChikuChichosonBusiness> resultList = new ArrayList<>();
        List<ChosaChikuChichosonRelateEntity> relateList
                = mapperProvider.create(IChosaChikuChichosonMapper.class).select調査地区市町村一覧(paramer);
        if (relateList == null || relateList.isEmpty()) {
            return SearchResult.of(Collections.<ChosaChikuChichosonBusiness>emptyList(), 0, false);
        }
        for (ChosaChikuChichosonRelateEntity entity : relateList) {
            resultList.add(new ChosaChikuChichosonBusiness(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 地区市町村情報を取得します。
     *
     * @param 調査地区コード 調査地区コード
     * @return SearchResult<ChikuShichoson>
     */
    @Transaction
    public SearchResult<ChikuShichoson> get地区市町村情報(Code 調査地区コード) {

        List<ChikuShichoson> resultList = new ArrayList<>();
        List<DbT5224ChikuShichosonEntity> chikuShichosonList = dbt5224dac.selec地区市町村(調査地区コード);
        if (chikuShichosonList == null || chikuShichosonList.isEmpty()) {
            return SearchResult.of(Collections.<ChikuShichoson>emptyList(), 0, false);
        }
        for (DbT5224ChikuShichosonEntity entity : chikuShichosonList) {
            entity.initializeMd5();
            resultList.add(new ChikuShichoson(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 市町村名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 市町村名称
     */
    @Transaction
    public RString getShichosonMeisho(LasdecCode 市町村コード) {
        DbT7051KoseiShichosonMasterEntity entity = dbt7051dac.selectByShichosonCode(市町村コード);
        if (entity != null) {
            return entity.getShichosonMeisho();
        }
        return RString.EMPTY;
    }

    /**
     * 市町村コードの存在チェックです。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return boolean 検索結果
     */
    @Transaction
    public boolean checkShichosonCode(Code 調査地区コード, LasdecCode 市町村コード) {
        DbT5224ChikuShichosonEntity entity = dbt5224dac.selectByKey(調査地区コード, 市町村コード);
        return entity != null;
    }

    /**
     * 地区市町村情報{@link ChikuShichoson}を登録/更新します。
     *
     * @param 地区市町村情報 {@link ChikuShichoson}
     * @return 登録/更新件数 登録/更新結果の件数を返します。
     */
    @Transaction
    public int insertOrUpdate(ChikuShichoson 地区市町村情報) {
        if (!地区市町村情報.hasChanged()) {
            return 0;
        }
        return dbt5224dac.save(地区市町村情報.toEntity());
    }

    /**
     * 削除を行うデータの整合性チェックします。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return boolean
     */
    @Transaction
    public boolean getCheckResult(Code 調査地区コード, LasdecCode 市町村コード) {
        List<DbT5221NinteichosaScheduleEntity> entity = dbt5221dac.selectKensu(調査地区コード, 市町村コード);
        return entity == null || entity.isEmpty();
    }

    /**
     * 地区市町村情報の削除処理する。
     *
     * @param paramer paramer
     * @return int
     */
    @Transaction
    public int delete(ChosaChikuChichosonParameter paramer) {
        return mapperProvider.create(IChosaChikuChichosonMapper.class).delete地区市町村情報(paramer);
    }
}
