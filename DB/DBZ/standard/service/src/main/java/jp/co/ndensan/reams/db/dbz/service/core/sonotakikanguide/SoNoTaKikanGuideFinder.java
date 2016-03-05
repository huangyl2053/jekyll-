/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.sonotakikanguide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuide;
import jp.co.ndensan.reams.db.dbz.definition.param.sonotakikanguide.SoNoTaKikanGuideParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT5914SonotaKikanJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.koseishichosonselector.KoseiShiChosonSelectorFinder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * その他機関情報の検索処理クラスです。
 */
public class SoNoTaKikanGuideFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SoNoTaKikanGuideFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7131KaigoServiceNaiyouDac}
     */
    SoNoTaKikanGuideFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShiChosonSelectorFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KoseiShiChosonSelectorFinder}のインスタンス
     */
    public static SoNoTaKikanGuideFinder createInstance() {
        return InstanceProvider.create(SoNoTaKikanGuideFinder.class);
    }

    /**
     * その他機関情報を検索します。
     *
     * @param param 成市町村の検索のパラメータ
     * @return SearchResult<KoseiShichoson>
     */
    public SearchResult<SoNoTaKikanGuide> getKoseiShichoson(SoNoTaKikanGuideParameter param) {
        List<SoNoTaKikanGuide> soNoTaKikanGuideList = new ArrayList<>();
        IDbT5914SonotaKikanJohoMapper mapper = mapperProvider.create(IDbT5914SonotaKikanJohoMapper.class);
        List<DbT5914SonotaKikanJohoEntity> entityList = null;//mapper.getSoNoTaKiKanJohoList(param);
        for (DbT5914SonotaKikanJohoEntity entity : entityList) {
            soNoTaKikanGuideList.add(new SoNoTaKikanGuide(entity));
        }
        return SearchResult.of(soNoTaKikanGuideList, 0, false);
    }
}
