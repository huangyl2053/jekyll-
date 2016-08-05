/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jikofutangakuhosei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jikofutangakuhosei.IJikoFutangakuHoseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住宅改修一覧の取得クラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuHoseiFinder {

    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    JikoFutangakuHoseiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    JikoFutangakuHoseiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JikoFutangakuHoseiFinder}のインスタンスを返します。
     *
     * @return JikoFutangakuHoseiFinder
     */
    public static JikoFutangakuHoseiFinder createInstance() {

        return InstanceProvider.create(JikoFutangakuHoseiFinder.class);
    }

    /**
     * 高額合算自己負担額一覧の取得です。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<KogakuGassanJikoFutanGaku> 高額合算自己負担額一覧
     */
    public SearchResult<KogakuGassanJikoFutanGaku> selectJyutakukaisyuList(HihokenshaNo 被保険者番号) {
        List<KogakuGassanJikoFutanGaku> 高額合算自己負担額一覧 = new ArrayList<>();
        IJikoFutangakuHoseiMapper mapper = mapperProvider.create(IJikoFutangakuHoseiMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(名称_被保険者番号.toString(), 被保険者番号);
        List<DbT3070KogakuGassanJikoFutanGakuEntity> entityList = mapper.get履歴チェックオフ(parameter);
        for (DbT3070KogakuGassanJikoFutanGakuEntity entity : entityList) {
            entity.initializeMd5();
            高額合算自己負担額一覧.add(new KogakuGassanJikoFutanGaku(entity));
        }
        return SearchResult.of(高額合算自己負担額一覧, 0, false);
    }
}
