/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.sukejurutouroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chikushichoson.ChikuShichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaschedule.NinteichosaScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichousasukejuru.NinteiChousaSukejuruParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichousasukejuru.NinteiChousaSukejuruRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosasche.INinteichosaScheduleMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5224ChikuShichosonDac;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査スケジュール登録1を管理するクラスです。
 */
public class SukejuruTourokuFinder {

    private final MapperProvider mapperProvider;
    private final DbT5224ChikuShichosonDac dbt5224dac;

    /**
     * コンストラクタです。
     */
    SukejuruTourokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5224dac = InstanceProvider.create(DbT5224ChikuShichosonDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider
     * @param DbT5224ChikuShichosonDac
     */
    SukejuruTourokuFinder(MapperProvider mapperProvider, DbT5224ChikuShichosonDac dac) {
        this.mapperProvider = mapperProvider;
        this.dbt5224dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SukejuruTourokuFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link SukejuruTourokuFinder}のインスタンス
     */
    public static SukejuruTourokuFinder createInstance() {
        return InstanceProvider.create(SukejuruTourokuFinder.class);
    }

    /**
     * 認定調査スケジュール登録1を取得します。
     *
     * @return SearchResult<ChikuShichosonBusiness> 認定調査スケジュール登録1
     */
    @Transaction
    public SearchResult<ChikuShichosonBusiness> getChikuShichosonList() {
        List<ChikuShichosonBusiness> businessList = new ArrayList<>();
        List<DbT5224ChikuShichosonEntity> dbt5224ChikuShichosonEntity = dbt5224dac.selectByjiChikuFlag();
        if (dbt5224ChikuShichosonEntity.isEmpty()) {
            return SearchResult.of(Collections.<ChikuShichosonBusiness>emptyList(), 0, false);
        }
        for (DbT5224ChikuShichosonEntity chikushichosonEntity : dbt5224ChikuShichosonEntity) {
            businessList.add(new ChikuShichosonBusiness(chikushichosonEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 認定調査スケジュール登録リストを取得します。
     *
     * @param 認定調査スケジュール登録1情報検索条件 NinteiChousaSukejuruParameter
     * @return SearchResult<NinteichosaScheduleBusiness> 認定調査スケジュール登録1
     */
    @Transaction
    public SearchResult<NinteichosaScheduleBusiness> getcheMapper(NinteiChousaSukejuruParameter 認定調査スケジュール登録1情報検索条件) {
        List<NinteichosaScheduleBusiness> businessList = new ArrayList<>();
        INinteichosaScheduleMapper mapper = mapperProvider.create(INinteichosaScheduleMapper.class);
        List<NinteiChousaSukejuruRelateEntity> ninteiEntity = mapper.getNinteiChousaSukeList(認定調査スケジュール登録1情報検索条件);
        for (NinteiChousaSukejuruRelateEntity relateEntity : ninteiEntity) {
            businessList.add(new NinteichosaScheduleBusiness(relateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
