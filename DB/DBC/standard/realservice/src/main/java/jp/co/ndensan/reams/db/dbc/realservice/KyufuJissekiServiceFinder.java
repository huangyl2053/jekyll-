/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCollections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbc.business.mapper.KyufuJissekiServiceMapper;
import jp.co.ndensan.reams.db.dbc.persistence.basic.KyufuJissekiServiceDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付実績照会一覧を表示するためのFinderです。
 *
 * @author N3317 塚田 萌
 */
public class KyufuJissekiServiceFinder {

    private final KyufuJissekiServiceDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public KyufuJissekiServiceFinder() {
        dac = InstanceProvider.create(KyufuJissekiServiceDac.class);
    }

    /**
     * 外部からDacを取得する、テスト用パッケージプライベートコンストラクタです。
     *
     * @param dac テスト用Dac
     */
    KyufuJissekiServiceFinder(KyufuJissekiServiceDac dac) {
        this.dac = dac;
    }

    /**
     * 指定したサービス提供年月（１ヶ月分）の給付実績情報を取得します。
     *
     * @param 被保番号 被保番号
     * @param サービス提供年月 サービス提供年月
     * @param サービス提供年月期間 サービス提供年月期間
     * @return 給付実績情報（１ヶ月分）
     */
    public KyufuJissekiServiceCollection get給付実績月別(
            KaigoHihokenshaNo 被保番号, ServiceTeikyoYM サービス提供年月, Range<ServiceTeikyoYM> サービス提供年月期間) {

        List<DbV3016KyufujissekiShuruiDetailEntity> entities = dac.select(被保番号, サービス提供年月);

        if (entities == null || entities.isEmpty()) {
            return new KyufuJissekiServiceCollection(Collections.EMPTY_LIST);
        }
        return KyufuJissekiServiceMapper.toKyufuJissekiServiceCollection(entities, サービス提供年月期間);
    }

    /**
     * 指定したサービス提供年月期間の給付実績情報を取得します。
     *
     * @param 被保番号 被保番号
     * @param サービス提供年月期間 サービス提供年月期間
     * @return 給付実績情報（検索期間分）
     */
    public KyufuJissekiServiceCollections get給付実績一覧(
            KaigoHihokenshaNo 被保番号, Range<ServiceTeikyoYM> サービス提供年月期間) {

        List<KyufuJissekiServiceCollection> list = new ArrayList<>();
        List<ServiceTeikyoYM> サービス提供年月List = getサービス提供年月List(サービス提供年月期間);
        for (ServiceTeikyoYM サービス提供年月 : サービス提供年月List) {
            list.add(get給付実績月別(被保番号, サービス提供年月, サービス提供年月期間));
        }
        return new KyufuJissekiServiceCollections(list);
    }

    private static List<ServiceTeikyoYM> getサービス提供年月List(Range<ServiceTeikyoYM> サービス提供年月期間) {

        List<ServiceTeikyoYM> list = new ArrayList<>();
        ServiceTeikyoYM サービス提供年月ForaddToList = サービス提供年月期間.getFrom();
        ServiceTeikyoYM サービス提供年月To = サービス提供年月期間.getTo();

        //TODO わかりにくいため、本実装の時に再度考える
        while (サービス提供年月ForaddToList.value().isBeforeOrEquals(サービス提供年月To.value())) {
            list.add(サービス提供年月ForaddToList);
            サービス提供年月ForaddToList = new ServiceTeikyoYM(サービス提供年月ForaddToList.value().plusMonth(1));
        }
        return list;
    }
}
