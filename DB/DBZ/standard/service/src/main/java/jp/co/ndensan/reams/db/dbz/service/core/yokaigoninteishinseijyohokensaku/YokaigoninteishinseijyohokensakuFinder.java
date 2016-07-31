/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteishinseijyohokensaku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei.YouKaiGoNinTeiShinJyuKyuParameter;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei.YouKaiGoNinTeiShinNiTeiParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.yokaigoninteishinseijyohokensaku.IYoKaiGoNinTeiShinSeiJyoHoKenSaKuMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 画面設計_DBZ5100001_要介護認定申請情報検索クラスです。
 *
 * @reamsid_L DBZ-1300-150 houtianpeng
 */
public class YokaigoninteishinseijyohokensakuFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ。
     *
     */
    public YokaigoninteishinseijyohokensakuFinder() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoninteishinseijyohokensakuFinder}のインスタンスを返します。
     *
     * @return JigyoshaInputGuideFinder
     */
    public static YokaigoninteishinseijyohokensakuFinder createInstance() {
        return InstanceProvider.create(YokaigoninteishinseijyohokensakuFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapper取得
     */
    YokaigoninteishinseijyohokensakuFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 介護認定申請情報認定を取得します。
     *
     * @param parameter YouKaiGoNinTeiShinNiTeiParameter
     * @return 介護認定申請情報認定リスト
     */
    @Transaction
    public SearchResult<NinteiShinseiJoho> get介護認定申請情報認定(YouKaiGoNinTeiShinNiTeiParameter parameter) {
        List<NinteiShinseiJoho> 介護認定申請情報認定List = new ArrayList<>();
        IYoKaiGoNinTeiShinSeiJyoHoKenSaKuMapper mapper = mapperProvider.create(IYoKaiGoNinTeiShinSeiJyoHoKenSaKuMapper.class);
        List<DbT5101NinteiShinseiJohoEntity> entityList = mapper.get介護認定申請情報認定(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteiShinseiJoho>emptyList(), 0, false);
        }
        for (DbT5101NinteiShinseiJohoEntity entity : entityList) {
            介護認定申請情報認定List.add(new NinteiShinseiJoho(entity));
        }
        return SearchResult.of(介護認定申請情報認定List, 介護認定申請情報認定List.size(),
                (parameter.getLimitCount() < 介護認定申請情報認定List.size()));
    }

    /**
     * 介護認定申請情報受給を取得します。
     *
     * @param parameter YouKaiGoNinTeiShinJyuKyuParameter
     * @return 介護認定申請情報受給リスト
     */
    @Transaction
    public SearchResult<HokenshaNinteiShinseiJoho> get介護認定申請情報受給(YouKaiGoNinTeiShinJyuKyuParameter parameter) {
        List<HokenshaNinteiShinseiJoho> 介護認定申請情報受給List = new ArrayList<>();
        IYoKaiGoNinTeiShinSeiJyoHoKenSaKuMapper mapper = mapperProvider.create(IYoKaiGoNinTeiShinSeiJyoHoKenSaKuMapper.class);
        List<DbT4101NinteiShinseiJohoEntity> entityList = mapper.get介護認定申請情報受給(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<HokenshaNinteiShinseiJoho>emptyList(), 0, false);
        }
        for (DbT4101NinteiShinseiJohoEntity entity : entityList) {
            介護認定申請情報受給List.add(new HokenshaNinteiShinseiJoho(entity));
        }
        return SearchResult.of(介護認定申請情報受給List, 介護認定申請情報受給List.size(),
                (parameter.getLimitCount() < 介護認定申請情報受給List.size()));
    }
}
