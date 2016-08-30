/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kaigokyufuhikagomositatetouroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomositatetouroku.KaigoKyufuhiParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3059KagoMoshitateDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomositatetouroku.IKaigoKyufuhiKagoMositateTourokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のビジネスクラスです。
 *
 * @reamsid_L DBC-2220-030 dongyabin
 */
public class KaigoKyufuhiKagoMositateTourokuFinder {

    private final MapperProvider mapperProvider;
    private final DbT3059KagoMoshitateDac dac;

    /**
     * コンストラクタです。
     */
    KaigoKyufuhiKagoMositateTourokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT3059KagoMoshitateDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KaigoKyufuhiKagoMositateTourokuFinder(MapperProvider mapperProvide, DbT3059KagoMoshitateDac dac) {
        this.mapperProvider = mapperProvide;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoKyufuhiKagoMositateTourokuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoKyufuhiKagoMositateTourokuFinder}のインスタンス
     */
    public static KaigoKyufuhiKagoMositateTourokuFinder createInstance() {
        return InstanceProvider.create(KaigoKyufuhiKagoMositateTourokuFinder.class);
    }

    /**
     * 過誤申立情報の最大連番取得します。
     *
     * @param 事業所番号 事業所番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return 最大連番
     */
    public int selectKyufuKanrihyoList(JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        DbT3059KagoMoshitateEntity entity = dac.getMax履歴番号(事業所番号, 被保険者番号, サービス提供年月);
        if (entity != null) {
            return entity.getRirekiNo();
        }
        return 0;
    }

    /**
     * 給付実績一覧取得します。
     *
     * @param param パラメータ
     * @return SearchResult<KaigoKyufuhiKagoMositateTourokuResult>
     */
    public SearchResult<KaigoKyufuhiKagoMositateTourokuResult> selectKyufuJissekiList(KaigoKyufuhiParamter param) {
        List<KaigoKyufuhiKagoMositateTourokuResult> result = new ArrayList<>();
        IKaigoKyufuhiKagoMositateTourokuMapper mapper = mapperProvider.create(IKaigoKyufuhiKagoMositateTourokuMapper.class);
        List<KaigoKyufuhiKagoMositateTourokuEntity> entityList = mapper.get給付実績一覧(param);
        for (KaigoKyufuhiKagoMositateTourokuEntity entity : entityList) {
            result.add(new KaigoKyufuhiKagoMositateTourokuResult(entity));
        }
        return SearchResult.of(result, 0, false);
    }
}
