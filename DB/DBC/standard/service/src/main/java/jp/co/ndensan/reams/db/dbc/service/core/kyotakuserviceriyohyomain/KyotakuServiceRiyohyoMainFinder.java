/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakuserviceriyohyomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain.KyotakuServiceRiyohyoMainResult;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain.TaishoshaIchiranResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakuserviceriyohyomain.KyotakuServiceRirekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakuserviceriyohyomain.TaishoshaichiranEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakuserviceriyohyomain.IKyotakuServiceRiyohyoMainMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住宅改修一覧の取得クラスです。
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class KyotakuServiceRiyohyoMainFinder {

    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KyotakuServiceRiyohyoMainFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KyotakuServiceRiyohyoMainFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyotakuServiceRiyohyoMainFinder}のインスタンスを返します。
     *
     * @return KyotakuServiceRiyohyoMainFinder
     */
    public static KyotakuServiceRiyohyoMainFinder createInstance() {

        return InstanceProvider.create(KyotakuServiceRiyohyoMainFinder.class);
    }

    /**
     * 居宅サービ一覧の取得です。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<KyotakuServiceRiyohyoMainResult> 居宅サービ一覧
     */
    public SearchResult<KyotakuServiceRiyohyoMainResult> selectJyutakukaisyuList(HihokenshaNo 被保険者番号) {
        List<KyotakuServiceRiyohyoMainResult> 居宅サービ一覧 = new ArrayList<>();
        IKyotakuServiceRiyohyoMainMapper mapper = mapperProvider.create(IKyotakuServiceRiyohyoMainMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(名称_被保険者番号.toString(), 被保険者番号);
        List<KyotakuServiceRirekiEntity> entityList = mapper.get居宅サービス履歴一覧(parameter);
        for (KyotakuServiceRirekiEntity entity : entityList) {
            居宅サービ一覧.add(new KyotakuServiceRiyohyoMainResult(entity));
        }
        return SearchResult.of(居宅サービ一覧, 0, false);
    }

    /**
     * 対象情報一覧取得です。
     *
     * @param parameter Map<String, Object>
     * @return SearchResult<TaishoshaIchiranResult> 対象情報一覧
     */
    public SearchResult<TaishoshaIchiranResult> selectTaishoshaIchiran(Map<String, Object> parameter) {
        List<TaishoshaIchiranResult> 対象情報一覧 = new ArrayList<>();
        IKyotakuServiceRiyohyoMainMapper mapper = mapperProvider.create(IKyotakuServiceRiyohyoMainMapper.class);
        List<TaishoshaichiranEntity> entityList = mapper.get対象情報一覧(parameter);
        for (TaishoshaichiranEntity entity : entityList) {
            対象情報一覧.add(new TaishoshaIchiranResult(entity));
        }
        return SearchResult.of(対象情報一覧, 0, false);
    }
}
